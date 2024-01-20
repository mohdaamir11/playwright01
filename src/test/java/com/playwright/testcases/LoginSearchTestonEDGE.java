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
import com.microsoft.playwright.Locator;
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
		p1.navigate("https://automationexercise.com/login");
		System.out.println("EDGE - INSIDE BEFORE TEST SETUP");
	}
	
	@Test (priority=1)
	public void login()
	{
		System.out.println("EDGE - INSIDE LOGIN TEST");
		 p1.navigate("https://automationexercise.com/login");
		 p1.locator("form").filter(new Locator.FilterOptions().setHasText("Login")).getByPlaceholder("Email Address").click();
		 p1.locator("form").filter(new Locator.FilterOptions().setHasText("Login")).getByPlaceholder("Email Address").fill("Onegod@111");
		 p1.getByPlaceholder("Password").click();
		 p1.getByPlaceholder("Password").fill("Onegod@111");
		 p1.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Login")).click();
		 assertThat(p1.locator("b")).containsText("Mohd Aamir"); 
	}
	
	@Test (priority=2)
	public void Search()
	{
		System.out.println("EDGE - INSIDE SEARCH TEST");

		p1.getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName("Products")).click();
		p1.getByPlaceholder("Search Product").click();
		p1.getByPlaceholder("Search Product").fill("GRAPHIC DESIGN MEN T SHIRT");
		p1.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("")).click();
		 assertThat(p1.locator("body")).containsText("GRAPHIC DESIGN MEN T SHIRT - BLUE");  // Assertion after search
	     
		
	   
	}
	
	@AfterTest
	public void teardown()
	{
		System.out.println("EDGE - INSIDE AFTER TEST TEARDOWN");
		p1.context().browser().close();
		
	}
	
	
	
	
	
}
