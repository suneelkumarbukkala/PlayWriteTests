package playwright.tests;

import java.util.List;

import org.testng.annotations.Test;
import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;
import com.microsoft.playwright.BrowserContext;
public class HandleMultipleWindows {
	@Test
	public void handleMultipleWindows() {
		Browser browser        =  Playwright.create().chromium().launch(new BrowserType.LaunchOptions().setHeadless(false).setSlowMo(3000));
	    BrowserContext context = browser.newContext();
	    Page page              = context.newPage();
	    page.navigate("https://freelance-learn-automation.vercel.app/login");
	    
	    Locator pages= page.locator("//div[@class='social']//a");
	    for(int i=0;i<pages.count();i++)
	    {
	    	pages.nth(i).click();
	    }
	    
	    List<Page> newPages = context.pages();
	    for(Page newPage:newPages)
	    {
	    	String Title = newPage.title();
	    	if(Title.contains("Facebook"))
	    	{
	    		newPage.bringToFront();
	    		newPage.locator("//input[@type='text']").fill("xyz826@gmail.com");
	    		System.out.println("Facebook Page is found");
	    		break;
	    	}
	    }
	    
	    page.bringToFront();
	    page.close();
	    context.close();
	    browser.close();
	}

}
