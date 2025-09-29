package practisetests;

import org.testng.annotations.Test;
import com.github.javafaker.Faker;
import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;
import com.microsoft.playwright.assertions.PlaywrightAssertions;

public class UserRegistration {
	@Test
	public void userRegistration()
	{
		Faker faker = new Faker();
		
		Browser browser = Playwright.create().chromium().launch(new BrowserType.LaunchOptions().setHeadless(false).setSlowMo(500));
	    Page page  = browser.newPage();
	    
	    page.navigate("https://freelance-learn-automation.vercel.app/signup");
	    page.getByPlaceholder("Name").fill(faker.name().fullName());
	    page.pause();
	    String Email = faker.internet().emailAddress();
	    System.out.println("Email:\t"+Email);
	    page.getByPlaceholder("Email").fill(Email);
	    String Pwd = faker.internet().password();
	    System.out.println("Pwd"+Pwd);
	    page.locator("#password").fill(Pwd);
	    
	    page.locator("//label[text()='Selenium']//preceding::input[1]").click();
	    PlaywrightAssertions.assertThat(page.locator("//label[text()='Selenium']//preceding::input[1]")).isChecked();
	    page.locator("//input[@value='Male']").click();
	    
	    page.locator("#state").selectOption("Kerala");
	    
	    String values[] = {"Playing","Singing"};
	    page.locator("#hobbies").selectOption(values);
	    
	    PlaywrightAssertions.assertThat(page.locator(".submit-btn")).isEnabled();
	    
	    page.locator(".submit-btn").click();
	}
}
