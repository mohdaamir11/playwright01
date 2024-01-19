package com.playwright;

import java.nio.file.Paths;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserContext;
import com.microsoft.playwright.Playwright;
import com.microsoft.playwright.BrowserType.LaunchOptions;
import com.microsoft.playwright.options.AriaRole;
import com.microsoft.playwright.Page;

public class NewAuth {

	public static void main(String[] args) {
		Playwright playwright = Playwright.create();
		LaunchOptions lp = new LaunchOptions();
		lp.setChannel("chrome"); //msedge //firefox
		lp.setHeadless(false);
		Browser browser= playwright.chromium().launch(lp);
		
	BrowserContext brcontext = browser.newContext(new Browser.NewContextOptions().setStorageStatePath(Paths.get("amazonLogin.json")));  
    Page page=brcontext.newPage();
    page.navigate("https://www.amazon.in");
    page.getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName("Hello, sign in Account & Lists")).click();
	}

}
