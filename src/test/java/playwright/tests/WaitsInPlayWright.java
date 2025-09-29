package playwright.tests;

import org.testng.annotations.Test;
import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;
import com.microsoft.playwright.options.LoadState;
import com.microsoft.playwright.options.WaitForSelectorState;

public class WaitsInPlayWright {
	@Test
	public void differentWaitsPalyWright()
	{
		Browser browser = Playwright.create().chromium().launch(new BrowserType.LaunchOptions().setHeadless(false).setSlowMo(500));
		Page page  = browser.newPage();
		page.navigate("https://seleniumpractise.blogspot.com/2016/",new Page.NavigateOptions().setTimeout(60000));
		page.setDefaultTimeout(6000);
		
		page.locator("//input[@value='CLick me']").waitFor(new Locator.WaitForOptions().setState(WaitForSelectorState.VISIBLE).setTimeout(5000));
		
		System.out.println("IS visible:\t"+page.locator("//input[@value='CLick me']").isVisible());
		
		page.waitForLoadState(LoadState.NETWORKIDLE);
		
		page.close();
		browser.close();
	}

}
