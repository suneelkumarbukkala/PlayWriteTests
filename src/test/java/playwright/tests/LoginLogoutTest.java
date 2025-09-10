package playwright.tests;

import org.testng.annotations.Test;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;
import com.microsoft.playwright.assertions.PlaywrightAssertions;

public class LoginLogoutTest {
	@Test
	public void loginLogoutTest()
	{
		Playwright play=null;
		Browser browser=null;
		Page page=null; 
		try
		{
		  play = Playwright.create();
		  browser = play.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));
		  page       = browser.newPage();
		  page.navigate("https://freelance-learn-automation.vercel.app/login");
		  PlaywrightAssertions.assertThat(page).hasTitle("Learn Automation Courses");
		  page.locator("//input[@type='email']").fill("kumar679@gmail.com");
		  page.getByPlaceholder("Enter Password").fill("Kuamr726");
		  page.locator("//button[@class='submit-btn']").click();
		  PlaywrightAssertions.assertThat(page.locator("//div[@class='navbar-menu-logo']//h1")).containsText("Learn Automation Courses");
		  page.locator("//div[@class='navbar-menu-links']//img[@alt='menu']").click();
		  page.getByText("Sign out").click();
		  PlaywrightAssertions.assertThat(page.locator("//div[@class='content']//h2")).containsText("Sign In");
		  System.out.println("Test Compeleted");
		
		}finally
		{
			page.close();
			browser.close();
			play.close();
		}
	}
}
