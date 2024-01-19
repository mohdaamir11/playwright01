package com.playwright;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserContext;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.BrowserType.LaunchOptions;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;
import com.microsoft.playwright.options.AriaRole;
import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;

import java.nio.file.Path;
import java.nio.file.Paths;

public class MySession {

	public static void main(String[] args) {

	

			Playwright playwright = Playwright.create();
			
			// first browser context - EDGE
			
			LaunchOptions lp = new LaunchOptions();
			lp.setChannel("msedge"); //msedge
			lp.setHeadless(true);	
			
			Browser browser= playwright.chromium().launch(lp);
			BrowserContext brcx1 = browser.newContext();		 
			Page p1 = brcx1.newPage();
			p1.navigate("https://www.amazon.in");
			
			System.out.println("page title is " + p1.title()); // printing title and URL
			System.out.println("URL is " + p1.url());
			
			p1.getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName("Hello, sign in Account & Lists")).click();
			p1.getByLabel("Email or mobile phone number").click();
			p1.getByLabel("Email or mobile phone number").fill("aamirisprofessional@gmail.com");
			p1.getByLabel("Continue").click();
			p1.getByLabel("Password").fill("Onegod@111");
			p1.getByLabel("Sign in").click();
			
//			brcx1.storageState(new BrowserContext.StorageStateOptions().setPath(Paths.get("amazonLogin.json")));
			
		     p1.getByPlaceholder("Search Amazon.in").fill("nike shoes");
		     p1.getByPlaceholder("Search Amazon.in").press("Enter");
		     assertThat(p1.locator("#search")).containsText("Nike");  // Assertion after search

		     
		     // Second browser context FIREFOX
//		     Playwright playwright2 = Playwright.create();
//				Browser browser2= playwright2.firefox().launch();
//		        BrowserContext brcx2 = browser2.newContext();	
//		        Page p2 = brcx2.newPage();
//				p2.navigate("https://www.amazon.in");
//				
//				System.out.println("page title is " + p2.title());    // printing title and URL
//				System.out.println("URL is " + p2.url());
//				
//				p2.getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName("Hello, sign in Account & Lists")).click();
//				p2.getByLabel("Email or mobile phone number").click();
//				p2.getByLabel("Email or mobile phone number").fill("aamirisprofessional@gmail.com");
//				p2.getByLabel("Continue").click();
//				p2.getByLabel("Password").fill("Onegod@111");
//				p2.getByLabel("Sign in").click();
//				
//				p2.getByPlaceholder("Search Amazon.in").fill("nike shoes");
//				p2.getByPlaceholder("Search Amazon.in").press("Enter");
//				
//			     assertThat(p2.locator("#search")).containsText("Nike");
			     
			     
			     // third browser context CHROME 
//			     Playwright playwright3 = Playwright.create();
//			     LaunchOptions lp3 = new LaunchOptions();
//					lp3.setChannel("chrome"); //msedge
//					lp3.setHeadless(true);
//					Browser browser3= playwright3.chromium().launch(lp3);
//			        BrowserContext brcx3 = browser3.newContext();	
//			        Page p3 = brcx3.newPage();
//					p3.navigate("https://www.amazon.in");
//					
//					System.out.println("page title is " + p3.title()); 	// printing title and URL
//					System.out.println("URL is " + p3.url());
//					
//					p3.getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName("Hello, sign in Account & Lists")).click();
//					p3.getByLabel("Email or mobile phone number").click();
//					p3.getByLabel("Email or mobile phone number").fill("aamirisprofessional@gmail.com");
//					p3.getByLabel("Continue").click();
//					p3.getByLabel("Password").fill("Onegod@111");
//					p3.getByLabel("Sign in").click();
//					
//					p3.getByPlaceholder("Search Amazon.in").fill("nike shoes");
//					p3.getByPlaceholder("Search Amazon.in").press("Enter");
//					
//				     assertThat(p3.locator("#search")).containsText("Nike");
			     
		     
			brcx1.close();
//			brcx2.close();
//			brcx3.close();
			playwright.close();
		
	}

}
