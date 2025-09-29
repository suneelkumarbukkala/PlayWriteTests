package practisetests;

import org.testng.annotations.Test;
import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;

public class HandleShadowElement {
	@Test
	public void handleShadowElement()
	{
		Browser browser  = Playwright.create().chromium().launch(new BrowserType.LaunchOptions().setHeadless(false).setSlowMo(500));
		Page page  = browser.newPage();
		page.navigate("https://selectorshub.com/xpath-practice-page");
		//Identify Shadow Root
		Locator shadow  = page.locator("div#userName");
		//Identify element under shadow
		shadow.locator("#kils").fill("SuneelKumar");
		
		page.close();
		browser.close();
	}

}
