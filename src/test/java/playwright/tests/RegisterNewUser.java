package playwright.tests;

import org.testng.annotations.Test;
import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;
import com.microsoft.playwright.assertions.PlaywrightAssertions;

public class RegisterNewUser {
	@Test
	public void registerUser()
	{
		 Playwright wright = Playwright.create();
		 Browser browser   = wright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false).setSlowMo(500));
		 Page page         = browser.newPage();
		 page.navigate("https://freelance-learn-automation.vercel.app/login");
		 page.pause();
		 page.getByText("New user? Signup").click();
		 page.getByPlaceholder("Name").fill("Kumar");
		 page.getByPlaceholder("Email").fill("kumar679@gmail.com");
		 page.pause();
		 page.getByPlaceholder("Password").fill("Kuamr726");
		 //PlaywrightAssertions.assertThat(page.locator("//label[text()='Selenium']//preceding::input[1]")).isChecked();
		 page.locator("//label[text()='Selenium']//preceding::input[1]").click();
		 page.locator("//label[text()='Male']//preceding::input[1]").click();
		 page.locator("#state").selectOption("Andhra Pradesh");
		 String lst[]= {"Swimming","Dancing"};
		 page.locator("#hobbies").selectOption(lst);
		 page.locator("//button[@type='submit']").click();
		 page.waitForTimeout(5000);
	}

}
