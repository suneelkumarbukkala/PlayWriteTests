package playwright.tests;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;

public class CrossbrowserTest {
	
	Playwright wright=wright = Playwright.create();
	Browser browser=null;
	Page page=null;
	
	@Parameters("BrowserName")
	@BeforeMethod()
	public void setUp(@Optional("Chrome") String Name)
	{
		if(Name.equalsIgnoreCase("Chrome"))
		{
			browser = wright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false).setSlowMo(500));
		}
		else if(Name.equalsIgnoreCase("firefox"))
		{
			browser = wright.firefox().launch(new BrowserType.LaunchOptions().setHeadless(false).setSlowMo(500));		
		}
		else if(Name.equalsIgnoreCase("webkit"))
		{
			wright.webkit().launch(new BrowserType.LaunchOptions().setHeadless(false).setSlowMo(500));
		}
		page    = browser.newPage();
	}
	
	
	@Test
	public void loginTest()
	{
	  page.navigate("https://freelance-learn-automation.vercel.app/login");
	  System.out.println("title:\t"+page.title());
	}
	
	@AfterMethod
	public void tearDown()
	{
		page.close();
		browser.close();
		wright.close();
	}

}
