package practisetests;

import org.testng.annotations.Test;
import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;

public class KeyBaordEvents {
	@Test
	public void handleKeyBoardEvents() throws InterruptedException
	{
		Browser browser = Playwright.create().chromium().launch(new BrowserType.LaunchOptions().setHeadless(false).setSlowMo(1000));
	    Page page  = browser.newPage();
	    page.navigate("https://freelance-learn-automation.vercel.app/login");
	    page.getByPlaceholder("Enter Email").fill("abc725@gmail.com");
	    /*//1.Apporach
	    page.keyboard().down("Control");
	    page.keyboard().press("a");
	    
	    page.keyboard().down("Control");
	    page.keyboard().press("c");
	    
	    page.keyboard().down("Tab");
	    
	    page.keyboard().down("Control");
	    page.keyboard().press("c");*/
	    
	    //2.Apporach
	    
	    page.keyboard().press("Control+A");
	    
	    page.keyboard().press("Control+C");
	    
	    page.keyboard().press("Tab");
	    
	    page.keyboard().press("Control+V");
	    
	    page.close();
	    browser.close();
	}

}
