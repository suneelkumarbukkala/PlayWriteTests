package playwright.tests;
import com.microsoft.playwright.*;
import com.microsoft.playwright.options.*;
import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;
import java.util.*;

import org.testng.annotations.Test;

public class TestGenCode {
	@Test
	public void sampleCodeGenTest()
	{
	    try (Playwright playwright = Playwright.create()) 
	    {
	      Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions()
	        .setHeadless(false));
	      BrowserContext context = browser.newContext();
	      Page page = context.newPage();
	      page.navigate("https://freelance-learn-automation.vercel.app/login");
	      page.getByRole(AriaRole.IMG, new Page.GetByRoleOptions().setName("Login")).click();
	      page.getByPlaceholder("Enter Email").click();
	      page.getByPlaceholder("Enter Email").fill("kumar679@gmail.com");
	      page.getByPlaceholder("Enter Email").press("Tab");
	      page.getByText("Sign InSign inNew user? Signup").click();
	      page.getByPlaceholder("Enter Password").click();
	      page.getByPlaceholder("Enter Password").fill("Kuamr726");
	      page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Sign in")).click();
	      page.getByText("Start: Mon Feb 17 2025").nth(1).click();
	      page.getByText("Mukesh Otwani").nth(1).click();
	      page.getByRole(AriaRole.HEADING, new Page.GetByRoleOptions().setName("Selenium For Web Automation")).click();
	      page.locator("div:nth-child(2) > .course-data > .thumbnail").click();
	      page.locator("div:nth-child(2) > .bottom-div > button").click();
	      page.getByRole(AriaRole.IMG, new Page.GetByRoleOptions().setName("menu")).click();
	      page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Sign out")).click();
	    }
	  }
}
