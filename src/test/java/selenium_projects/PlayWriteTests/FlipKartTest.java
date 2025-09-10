package selenium_projects.PlayWriteTests;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import com.flipkart.pages.FlipKartHomePage;
import com.flipkart.pages.FlipKartMensTShirtPage;
import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserContext;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;
import com.microsoft.playwright.impl.driver.Driver;

public class FlipKartTest {
	Page page;
	Playwright wright;
	Browser browser;
	public BrowserContext context;
	Driver driver;
	
	@BeforeClass
	public void launch()
	{
		wright   = Playwright.create();
		browser  = wright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));
		context     = browser.newContext();
		page = context.newPage();
		page.navigate("https://www.flipkart.com/");
		page.waitForLoadState();
	}
	
	@Test
	public void verifyTShirtDetails() throws InterruptedException
	{
		try {
		FlipKartHomePage homePage = new FlipKartHomePage(page);
		FlipKartMensTShirtPage tshirtPage = new FlipKartMensTShirtPage(page);
		
		
		homePage.navigateToMensThsirts();
		tshirtPage.navigateToTShirtLinkDetailsPage();
		tshirtPage.verifyTshirtDetails();
		}catch(Exception e)
		{
		  e.printStackTrace();	
		}
	}
	
	@AfterClass
	public void quit()
	{
		page.close();
		browser.close();
		wright.close();
	}

}
