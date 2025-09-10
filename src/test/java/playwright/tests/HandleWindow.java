package playwright.tests;

import org.testng.annotations.Test;
import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserContext;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;

public class HandleWindow {
	@Test
	public void multipleWidnows()
	{
		Browser browser  =  Playwright.create().chromium().launch(new BrowserType.LaunchOptions().setHeadless(false).setSlowMo(1000));
	    BrowserContext context = browser.newContext();
	    Page ParentPage = context.newPage();
	    ParentPage.navigate("https://freelance-learn-automation.vercel.app/login");
	    
	    Page ChildPage = context.waitForPage(()->
	    {
	    	ParentPage.locator("//a[contains(@href,'facebook')]").first().click();	
	    });
	    
	    ChildPage.locator("//input[@type='text']").fill("abx625@gmail.com");
	    ParentPage.bringToFront();
	    ChildPage.bringToFront();
	    ParentPage.bringToFront();
	    ChildPage.bringToFront();
	    
	    ChildPage.close();
	    ParentPage.close();
	    browser.close();
	}

}
