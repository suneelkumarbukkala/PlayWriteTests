package playwright.tests;
import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.BrowserType.LaunchOptions;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;

public class FirstPlaywrightTest {
	public static void main(String args[]) {
	Playwright play  = Playwright.create();
	Browser browser  =  play.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));
	//Browser browser  =  play.firefox().launch(new BrowserType.LaunchOptions().setHeadless(false));
	//Browser browser  =  play.webkit().launch(new BrowserType.LaunchOptions().setHeadless(false));
	Page page        = browser.newPage();
	page.navigate("https://playwright.dev/java/docs/intro");
	String Title = page.title();
	System.out.println("Title"+Title);
	page.close();
	browser.close();
	play.close();
	}	
}
