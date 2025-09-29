package practisetests;

import org.testng.annotations.Test;
import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserContext;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;
import com.microsoft.playwright.options.AriaRole;

public class playwright {
	@Test
	public void playWriteTest()
	{
		try (Playwright playwright = Playwright.create()) 
		{
		      Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions()
		        .setHeadless(false));
		      BrowserContext context = browser.newContext();
		      Page page = context.newPage();
		      page.navigate("https://freelance-learn-automation.vercel.app/login");
		      page.getByPlaceholder("Enter Email").click();
		      page.getByPlaceholder("Enter Email").click();
		      page.getByPlaceholder("Enter Email").fill("kumar679@gmail.com");
		      page.getByPlaceholder("Enter Email").press("Tab");
		      page.getByPlaceholder("Enter Password").click();
		      page.getByPlaceholder("Enter Password").fill("Kuamr726");
		      page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Sign in")).click();
		      page.locator("div:nth-child(4) > .bottom-div > button").click();
		      page.getByRole(AriaRole.IMG, new Page.GetByRoleOptions().setName("menu")).click();
		      page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Sign out")).click();
		}	      
	}
}
