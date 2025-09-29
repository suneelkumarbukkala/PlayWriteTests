package practisetests;

import org.testng.annotations.Test;
import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;

public class FirestNewTest {
   @Test
   public void firstTest()
   {
	    Browser browser = Playwright.create().chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));

	    //Browser browser = Playwright.create().firefox().launch(new BrowserType.LaunchOptions().setHeadless(false).setSlowMo(500));
 
	    //Browser browser = Playwright.create().webkit().launch(new BrowserType.LaunchOptions().setHeadless(false).setSlowMo(500));
	   
	    Page    page    =  browser.newPage();
	    page.navigate("https://playwright.dev/java/docs/intro");
	    String Title = page.title();
	    System.out.println("Title:"+Title);
	    page.close();
	    browser.close();
   }
}
