package practisetests;

import java.nio.file.Paths;
import org.testng.annotations.Test;
import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserContext;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;

public class VideoRecording {
	@Test
	public void videoRecordingCapture()
	{
		 Browser browser  = Playwright.create().chromium().launch(new BrowserType.LaunchOptions().setHeadless(false).setSlowMo(1000));
	     BrowserContext context = browser.newContext(new Browser.NewContextOptions().setRecordVideoSize(1000,1000).setRecordVideoDir(Paths.get("videos/")));
	     Page page = context.newPage();
	     page.navigate("https://freelance-learn-automation.vercel.app/login");
	     page.locator("#email1").fill("abc275@gmail.com");
	     
	     String Path = page.video().path().toString();
	     
	     System.out.println("Vidoes of path\t"+Path);
	     
	     page.close();
	     context.close();
	     browser.close();
	}

}
