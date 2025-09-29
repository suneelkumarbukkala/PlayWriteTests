package practisetests;

import org.testng.annotations.Test;
import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;
import com.microsoft.playwright.assertions.PlaywrightAssertions;

public class FirstTest {
   @Test
   public void firstTest() throws InterruptedException 
   {
	   Browser browser  = Playwright.create().chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));
	   Page page  = browser.newPage();
	   page.navigate("https://freelance-learn-automation.vercel.app/login");
	   page.getByPlaceholder("Enter Email").fill("kumar679@gmail.com");
	   page.getByPlaceholder("Enter Password").fill("Kuamr726");
	   page.locator(".submit-btn").click();
	   
	   PlaywrightAssertions.assertThat(page.locator("//div[@class='navbar-menu-logo']//h1")).containsText("Learn Automation Courses");
	   
	   Thread.sleep(3000);
	   
	   page.locator("//div[@class='navbar-menu-links']//img[@alt='menu']").click();
	   page.locator("//button[text()='Sign out']").click();
	   
	   page.close();
	   browser.close();	   
   }
}
