package selenium_projects.PlayWriteTests;

import com.microsoft.playwright.Browser;
import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;
import com.microsoft.playwright.BrowserType.LaunchOptions;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;

public class AlertHandle {
	public static void main(String args[])
	{
		Playwright wright=Playwright.create();
		Browser browser  = wright.chromium().launch(new LaunchOptions().setHeadless(false));
		Page page = browser.newPage();
		page.navigate("https://www.selenium.dev/selenium/web/alerts.html#");
		page.waitForLoadState();
		//1.Hanlding of Alert Popup
		page.onceDialog(alert ->{
			page.waitForTimeout(5000);
			String message = alert.message();
			System.out.println("message"+message);
			alert.accept();
		});
		page.locator("//a[@id='alert']").click();
		System.out.println("Alert Popup is handled");
		page.waitForTimeout(5000);
		page.waitForTimeout(5000);
		//2.Handling of prompt
		page.onDialog(alert -> {
		    String message = alert.message();
		    System.out.println("Prompt text: " + alert.message());
		    System.out.println("Value"+alert.defaultValue());
		    alert.accept("Kumar");  // Provide input and accept
		});
		page.locator("//a[text()='prompt happen'] ").click();
		System.out.println("Prompt is handled");
		wright.close();
	}
}
