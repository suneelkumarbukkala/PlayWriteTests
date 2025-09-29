package playwright.tests;

import org.testng.annotations.Test;
import com.microsoft.playwright.Browser;
import com.microsoft.playwright.Browser.NewContextOptions;
import com.microsoft.playwright.BrowserContext;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;

public class HandleSSLCert {
	@Test
	public void handleSSLCert()
	{
		Browser browser  =  Playwright.create().chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));
		NewContextOptions contextOptions = new Browser.NewContextOptions();
		contextOptions.setIgnoreHTTPSErrors(true);
		BrowserContext context = browser.newContext(contextOptions);
		Page page  = context.newPage();
		page.navigate("https://expired.badssl.com/");
		
		page.close();
		browser.close();
	}

}
