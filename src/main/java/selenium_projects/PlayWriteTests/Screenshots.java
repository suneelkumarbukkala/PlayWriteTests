package selenium_projects.PlayWriteTests;
import java.nio.file.Paths;
import java.util.Arrays;
import com.microsoft.playwright.*;
import com.microsoft.playwright.Page.ScreenshotOptions;


public class Screenshots {
	public static void main(String args[])
	{
		try(Playwright wright=Playwright.create())
		{
		  Browser browser = wright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));	
		  Page page = browser.newPage();
		  page.navigate("https://www.flipkart.com/");
		  
		  //Screenshots
		  ScreenshotOptions options = new ScreenshotOptions();
		  page.screenshot(options.setPath(Paths.get("./screenshots/screen.png")));
		 
		  //Full Page Screenshots
		  page.screenshot(options.setFullPage(true).setPath(Paths.get("./screenshots/fullscreen.png")));
		  
		  //Locator Screenshot
		  Locator loginBtn = page.locator("//a[@title='Login'][@class='_1TOQfO']");
		  loginBtn.screenshot(new Locator.ScreenshotOptions().setPath(Paths.get("./screenshots/locatorscreen.png")));
		  
		  //locator Masking Screenshot
		  Locator input = page.locator("//input[@title='Search for Products, Brands and More']");
		  input.scrollIntoViewIfNeeded();
		  page.screenshot(options.setPath(Paths.get("./screenshots/locatormask.png")).setFullPage(false).setMask(Arrays.asList(input)));
		  
		  page.close();
		  browser.close();
		  wright.close();
		}
	}

}
