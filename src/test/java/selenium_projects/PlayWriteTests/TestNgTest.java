package selenium_projects.PlayWriteTests;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;
import com.microsoft.playwright.impl.driver.Driver;
public class TestNgTest  {
	Playwright wright ;
	Page page;
	
	@BeforeTest
	public void setUp()
	{
		wright = Playwright.create();
		Browser browser = wright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));
		page = browser.newPage();
		page.navigate("https://duckduckgo.com/");
	}
	
	@Test
	public void sampleTest() throws InterruptedException
	{
		
		page.waitForLoadState();
		page.locator("(//a[@href='https://duck.ai'])[2]").click();
		page.keyboard().press("Enter");
		page.waitForLoadState();
		page.wait(5000);
		String title = page.title();
		if(title.equals("Duck.ai"))
		{
			System.out.println("Test Pass");
		}
		else
		{
			System.out.println("Test Fail");
		}		
	}
	
	@AfterClass
	public void tearDown()
	{
		page.close();
		wright.close();
	}
}
