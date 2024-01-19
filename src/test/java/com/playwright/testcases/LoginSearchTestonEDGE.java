package com.playwright.testcases;

import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserContext;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;
import com.microsoft.playwright.BrowserType.LaunchOptions;
import com.microsoft.playwright.options.AriaRole;

public class LoginSearchTestonEDGE {

	public Playwright playwright;
	public Page p1;
	
	@BeforeTest
	public void setup()
	{
	 playwright = Playwright.create();
	 LaunchOptions lp = new LaunchOptions();
		lp.setChannel("msedge"); //msedge
		lp.setHeadless(true);	
		Browser browser= playwright.chromium().launch(lp);
		BrowserContext brcx1 = browser.newContext();		 
		p1 = brcx1.newPage();
		p1.navigate("https://www.amazon.in");
		p1.getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName("Hello, sign in Account & Lists")).click();
		System.out.println("EDGE - INSIDE BEFORE TEST SETUP");
	}
	
	@Test (priority=1)
	public void login()
	{
		
		p1.getByLabel("Email or mobile phone number").click();
		p1.getByLabel("Email or mobile phone number").fill("aamirisprofessional@gmail.com");
		p1.getByLabel("Continue").click();
		p1.getByLabel("Password").fill("Onegod@111");
		p1.getByLabel("Sign in").click();
		System.out.println("EDGE - INSIDE LOGIN TEST");
	}
	
	@Test (priority=2)
	public void Search()
	{
		System.out.println("EDGE - INSIDE SEARCH TEST");

	    p1.getByPlaceholder("Search Amazon.in").fill("nike shoes");
	    p1.getByPlaceholder("Search Amazon.in").press("Enter");
	    assertThat(p1.locator("#search")).containsText("Nike");  // Assertion after search
	   
	}
	
	@AfterTest
	public void teardown()
	{
		System.out.println("EDGE - INSIDE AFTER TEST TEARDOWN");
		p1.context().browser().close();
		
	}
	
	
}
