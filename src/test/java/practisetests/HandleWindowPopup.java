package practisetests;

import org.testng.annotations.Test;
import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserContext;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;

public class HandleWindowPopup {
	@Test
	public void handleWidnow()
	{
		Browser browser  = Playwright.create().chromium().launch(new BrowserType.LaunchOptions().setHeadless(false).setSlowMo(2000));
	    BrowserContext context = browser.newContext();
	    Page parentPage = context.newPage();
	    parentPage.navigate("https://freelance-learn-automation.vercel.app/login");
	    
	    Page childPage  = context.waitForPage(()->{
	    	parentPage.locator("//a[contains(@href,'https://www.facebook.com/')]").first().click();
	    });
	    
	    childPage.locator("//input[@name='email']").last().fill("abc726@gmail.com");
	    
	    parentPage.bringToFront();
	    childPage.bringToFront();
	    parentPage.bringToFront();
	    childPage.bringToFront();
	    
	    childPage.close();
	    parentPage.close();
	    
	    context.close();
	    browser.close();
	    
	}

}
