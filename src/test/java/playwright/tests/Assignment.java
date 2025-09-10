package playwright.tests;

import java.util.List;
import org.testng.annotations.Test;
import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;
import com.microsoft.playwright.assertions.PlaywrightAssertions;

public class Assignment {
	@Test
	public void assignment() 
	{
		Browser browser = Playwright.create().chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));
		Page page       = browser.newPage();
		page.navigate("https://freelance-learn-automation.vercel.app/");
		//1.Number of courses greater>0
		 Locator lst= page.locator("//div[@class='course-card row']//h2");
		 List<String> text=lst.allInnerTexts();
		 System.out.println("Size"+text.size());
		 System.out.println("Number of Courses is verified");
		
		 //2.Navigate to login page and verify login page
		 page.locator("//div[@class='navbar-menu-links']").click();
		 page.getByText("Log in").click();
		 PlaywrightAssertions.assertThat(page).hasTitle("Learn Automation Courses");
		 System.out.println("Login Page Title Vetified");
		 
		 //3.Logged into application and verify welcome page
		 page.getByPlaceholder("Enter Email").fill("kumar679@gmail.com");
		 page.getByPlaceholder("Enter Password").fill("Kuamr726");
		 page.locator("//button[@type='submit']").click();
		 Locator lt = page.locator("//div[@class='navbar-menu-logo']//h1");
		 PlaywrightAssertions.assertThat(lt).hasText("Learn Automation Courses");
		 System.out.println("After loggin in text verified");
		 
		 //4.Logout and verify Text
		 page.locator("//div[@class='navbar-menu-links']").click();
		 page.getByText("Sign out").click();
		 Locator sign=page.locator("//div[@class='content']//h2");
		 PlaywrightAssertions.assertThat(sign).hasText("Sign In");
		 System.out.println("After logout Sign Text verified");	 
	}
}
