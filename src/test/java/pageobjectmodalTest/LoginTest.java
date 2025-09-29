package pageobjectmodalTest;

import org.testng.annotations.Test;
import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;

import pageobjectmodelPageClasses.LoginPage;

public class LoginTest {
  
	@Test
	public void login()
	{
		Browser browser = Playwright.create().chromium().launch(new BrowserType.LaunchOptions().setHeadless(false).setSlowMo(500));
		
		Page page = browser.newPage();
		
		page.navigate("https://freelance-learn-automation.vercel.app/login");
		
		LoginPage lp = new LoginPage(page);
		
		lp.loginPage("kumar679@gmail.com", "Kuamr726");
		
		
	}
	
}
