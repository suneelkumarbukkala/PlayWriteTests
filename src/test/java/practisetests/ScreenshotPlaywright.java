package practisetests;

import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Base64;
import org.testng.annotations.Test;
import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;

public class ScreenshotPlaywright {
	@Test
	public void takeScreenshot() {
		Browser browser  = Playwright.create().chromium().launch(new BrowserType.LaunchOptions().setHeadless(false).setSlowMo(500));
		Page page  = browser.newPage();
		page.navigate("https://www.naukri.com/");
		
		//1.Just taking screenshot
		byte[]  arr=page.screenshot();
		System.out.println(arr.length);
		
		//2.Screenshot of full page
		byte arr1[] = page.screenshot(new Page.ScreenshotOptions().setFullPage(true).setPath(Paths.get("screenshotpage1.png")));
		System.out.println(Base64.getEncoder().encodeToString(arr1));
		
		//3.Screenshot based on locator
		byte arr2[]= page.locator("//a[@title='Jobseeker Register']").screenshot(new Locator.ScreenshotOptions().setPath(Paths.get("screenshot2.png")));
		System.out.println(Base64.getEncoder().encodeToString(arr2));
		
		page.close();
		browser.close();
	}
}
