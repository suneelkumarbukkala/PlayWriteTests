package practisetests;

import java.util.List;

import org.testng.annotations.Test;
import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Frame;
import com.microsoft.playwright.FrameLocator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;

public class HandleFrames {
	@Test
	public void handleFrames()
	{
		Browser  browser  = Playwright.create().chromium().launch(new BrowserType.LaunchOptions().setHeadless(false).setSlowMo(1000));
	    Page page         = browser.newPage();
	    page.navigate("https://www.redbus.in/");
	    page.locator("//div[contains(text(),'Account')]").click();
	    page.locator("//button[contains(text(),'Log in')]").click();
	    
	    List<Frame> frames=page.frames();
	    System.out.println("Number of frames:\t"+frames.size());
	    
	    FrameLocator frameLocator = page.frameLocator("//iframe[@title='reCAPTCHA']");
	    frameLocator.locator("//span[@role='checkbox']").click();
	    
	    page.close();
	    browser.close();
	}

}
