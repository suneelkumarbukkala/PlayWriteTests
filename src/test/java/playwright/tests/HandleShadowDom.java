package playwright.tests;

import org.testng.annotations.Test;
import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;

public class HandleShadowDom {
	@Test
	public void handleShadowDom() 
	{
		Browser browser = Playwright.create().chromium().launch(new BrowserType.LaunchOptions().setHeadless(false).setSlowMo(1000));
		Page page       = browser.newPage();
		page.navigate("https://selectorshub.com/xpath-practice-page/");
		//page.locator("#kils").fill("abc736@gmail.com");
		
		Locator shadow = page.locator("#userName");
		shadow.locator("#kils").fill("Test Munal");
		//page.wait(2000);
		String Text = shadow.locator("#kils").textContent();
		System.out.println("Text"+Text);
		page.close();
		browser.close();	
	}

}
