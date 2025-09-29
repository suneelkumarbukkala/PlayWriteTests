package practisetests;

import java.nio.file.Path;
import org.testng.annotations.Test;
import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;

public class uploadFile {
	@Test
	public void uploadFile() throws InterruptedException
	{
	   Browser browser = Playwright.create().chromium().launch(new BrowserType.LaunchOptions().setHeadless(false).setSlowMo(500));
	   Page page  = browser.newPage();
	   page.navigate("https://the-internet.herokuapp.com/upload");
	   //1.uploading single file
	   //page.locator("#file-upload").setInputFiles(Path.of(System.getProperty("user.dir")+"/files/file_example_JPG.jpg"));
	   //2.uploading multiple files
	   Path files[]= {
			   Path.of(System.getProperty("user.dir")+"/files/jpg-example-file-download.jpg"),
			   //Path.of(System.getProperty("user.dir")+"/files/file_example_JPG.jpg")
			   };
	   page.locator("#file-upload").setInputFiles(files);
	   Thread.sleep(3000);
	   page.locator("#file-upload").setInputFiles(new Path[0]);
	   page.close();
	   browser.close();
	}

}
