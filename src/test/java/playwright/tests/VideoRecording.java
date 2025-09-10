package playwright.tests;

import java.nio.file.Paths;
import org.testng.annotations.Test;
import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserContext;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;

public class VideoRecording {
	@Test
	public void recording()
	{
		Browser browser  =  Playwright.create().chromium().launch(new BrowserType.LaunchOptions().setHeadless(false).setSlowMo(500));
		BrowserContext context = browser.newContext(new Browser.NewContextOptions().setRecordVideoSize(1000,1000).setRecordVideoDir(Paths.get("videos/")));
		Page page       = context.newPage();
		page.navigate("https://freelance-learn-automation.vercel.app/login");
		page.waitForTimeout(3000);
		page.getByPlaceholder("Enter Email").fill("abc725@gmail.com");
		
		String path = page.video().path().toString();
		System.out.println("Path="+path);
		page.close();
		browser.close();
		
	}

}
