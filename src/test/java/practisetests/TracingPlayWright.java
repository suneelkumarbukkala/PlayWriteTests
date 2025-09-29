package practisetests;

import java.nio.file.Paths;

import org.testng.annotations.Test;
import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserContext;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;
import com.microsoft.playwright.Tracing;
import com.microsoft.playwright.assertions.PlaywrightAssertions;

public class TracingPlayWright {
	@Test
	public void CaptureTracing()
	{
		Browser browser=null;
		BrowserContext context=null;
		Page page=null;
		
		
		try {
			browser  = Playwright.create().chromium().launch(new BrowserType.LaunchOptions().setHeadless(false).setSlowMo(1000));
	        context = browser.newContext();
	        context.tracing().start(new Tracing.StartOptions().setScreenshots(true).setSnapshots(true).setSources(true));
	        page  = context.newPage();
	        page.navigate("https://freelance-learn-automation.vercel.app/login");
	        page.navigate("https://freelance-learn-automation.vercel.app/login");
		    PlaywrightAssertions.assertThat(page).hasTitle("Learn Automation Courses");
		    page.locator("//input[@type='email']").fill("kumar679@gmail.com");
		    page.getByPlaceholder("Enter Password").fill("Kuamr726");
		    page.locator("//button[@class='submit-btn']").click();
		    PlaywrightAssertions.assertThat(page.locator("//div[@class='navbar-menu-logo']//h1")).containsText("Learn Automation Courses");
		    page.locator("//div[@class='navbar-menu-links']//img[@alt='menu']").click();
		    page.getByText("Sign out").click();
	     }finally {
	    	 context.tracing().stop(new Tracing.StopOptions().setPath(Paths.get("Tracing.zip")));
	    	 page.close();
	    	 context.close();
	    	 browser.close();
	     }	  
	}

}
