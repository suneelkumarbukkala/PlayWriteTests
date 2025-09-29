package practisetests;

import java.util.List;
import org.testng.annotations.Test;
import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserContext;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;

public class HandleMultiplePages {
	@Test
	public void handleMultipleWidnows()
	{
		Browser browser = Playwright.create().chromium().launch(new BrowserType.LaunchOptions().setHeadless(false).setSlowMo(500));
	    BrowserContext context = browser.newContext();
	    Page page  = context.newPage();
	    page.navigate("https://freelance-learn-automation.vercel.app/login");
	    
	    Locator locator = page.locator("//div[@class='social']//a");
	    
	    for(int i=0;i<locator.count();i++)
	    {
	    	locator.nth(i).click();
	    }
	    
	    List<Page> pages = context.pages();
	    for(Page p:pages)
	    {
	    	String Title = p.title();
	    	p.bringToFront();
	    	if(Title.contains("Selenium Webdriver questions and answers | Facebook"))
	    	{
	    		p.locator("//input[@type='email']").fill("abc7625@gmail.com");
	    		break;
	    	}	
	    }
	    
	    page.bringToFront();
	    
	    page.getByPlaceholder("Enter Email").fill("atdg275@gmail.com");
	    
	    context.close();
	    page.close();
	    browser.close();
	}

}
