package playwright.tests;

import java.util.regex.Pattern;

import org.testng.annotations.Test;
import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Frame;
import com.microsoft.playwright.FrameLocator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;

public class HandleFrames {
	@Test
	public void handleFrame()
	{
		Browser browser = Playwright.create().chromium().launch(new BrowserType.LaunchOptions().setHeadless(false).setSlowMo(1000));
		Page page       = browser.newPage();
		page.navigate("https://www.redbus.in/");
		page.locator("//div[text()='Account']").click();
		page.locator("//button[text()='Log in']").click();
		
		//1.Using FrameLocator
		FrameLocator frame = page.frameLocator("//iframe[@title='reCAPTCHA']");
		frame.locator("//div[@class='recaptcha-checkbox-border']").click();
		
		//2.Using FrameUrlPattern
		Frame fram = page.frameByUrl(Pattern.compile(".*accounts.google.com.*"));
		fram.locator("//span[text()='Sign in with Google']").click();
		
	    page.close();
	    browser.close();
	}

}
