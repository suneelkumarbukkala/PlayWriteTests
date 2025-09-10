package selenium_projects.PlayWriteTests;
import com.microsoft.playwright.*;
import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;
public class LaunchChrome
{
	public static void main(String args[]) throws InterruptedException
	{
		try(Playwright playwright = Playwright.create()){
			Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));
			Page page = browser.newPage();
			page.navigate("https://www.flipkart.com/");
			System.out.println("Page Title:\t"+page.title());
		    assertThat(page).hasTitle("Online Shopping Site for Mobiles, Electronics, Furniture, Grocery, Lifestyle, Books & More. Best Offers!");
			Locator login = page.locator("//div[@class='H6-NpN _3N4_BX']");
		    login.hover();
		    Thread.sleep(5000);
		    page.locator("//li[text()='My Profile']").click();
		    System.out.println("Test Completed");
		    page.close();
			browser.close();
			playwright.close();
		}	
	}
}