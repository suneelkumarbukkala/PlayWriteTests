package playwright.tests;

import java.nio.file.Paths;
import org.testng.annotations.Test;
import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;

import utils.Screenshots;

public class TakeScreenshots {
	@Test
	public void takeScreenshot()
	{
		Browser browser = Playwright.create().chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));
		Page page       = browser.newPage();
		page.navigate("https://www.naukri.com/");
		
		byte arr[]=page.screenshot();
		System.out.println(arr);
		
		Screenshots.takeScreenshotByPage(page);
		System.out.println("First Screenshot taken");
		Screenshots.takeScreenshotByLocator(page,"//a[@title='Jobseeker Login']");
		System.out.println("Second Screenshot taken");
		
	    page.close();
	    browser.close();
	}

}
