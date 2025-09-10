package playwright.tests;

import java.nio.file.Path;
import org.testng.annotations.Test;
import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;

public class FileUploadTest {
	@Test
	public void uplaodFile() 
	{
		Browser browser = Playwright.create().chromium().launch(new BrowserType.LaunchOptions().setHeadless(false).setSlowMo(500));
		Page page = browser.newPage();
		page.navigate("https://the-internet.herokuapp.com/upload");
		//page.locator("#file-upload").setInputFiles(Path.of(System.getProperty("user.dir")+"/files/file_example_JPG.jpg"));
		
		Path files[] = { 
				 Path.of(System.getProperty("user.dir")+"/files/file_example_JPG.jpg")
				};
		
		page.locator("#file-upload").setInputFiles(files);
		
		page.locator("#file-upload").setInputFiles(new Path[0]);
		//page.wait(5000);
		page.close();
		browser.close();
		
	}

}
