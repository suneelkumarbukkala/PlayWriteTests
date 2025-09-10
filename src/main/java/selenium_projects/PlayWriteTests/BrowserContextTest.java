package selenium_projects.PlayWriteTests;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserContext;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.BrowserType.LaunchOptions;
import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;
import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;

public class BrowserContextTest {
 public static void main(String args[])
 {
	 Playwright wright            = Playwright.create();
	 Browser browser              = wright.chromium().launch(new LaunchOptions().setHeadless(false));
	 BrowserContext context       = browser.newContext();
	 Page page                    = context.newPage();
	 page.navigate("https://www.flipkart.com/");
	 Locator loginBtn = page.locator("//a[@title='Login']//span");
	 loginBtn.click();
	 Locator otpBtn= page.locator("//button[text()='Request OTP']");
	 assertThat(otpBtn).isVisible();
	 
	 Page tab1 = context.newPage();
	 tab1.navigate("https://railway.com/");
	 tab1.waitForLoadState();
	 Locator productArrow = tab1.locator("//span[text()='Product']");
	 productArrow.click();
	 
	 Page tab2=context.newPage();
	 tab2.navigate("https://equery.irctc.co.in/irctc_equery/");
	 tab2.waitForLoadState();
	 Locator submitBtn = tab2.locator("//button[@type='submit']");
	 assertThat(submitBtn).isVisible();
	 page.close();
	 context.close();
	 browser.close();
	 wright.close();
 }
}
