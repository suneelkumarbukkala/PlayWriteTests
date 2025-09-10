package playwright.tests;

import org.testng.annotations.Test;
import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;
import com.microsoft.playwright.FileChooser;
import java.nio.file.Path;


public class FileChooser {
	@Test
	public void uploadFileUsingChooser()
	{
		Browser browser  = Playwright.create().chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));
	    Page page  = browser.newPage();
	    page.navigate("https://the-internet.herokuapp.com/upload");
	    
	    FileChooser fileChooser = page.waitForFileChooser(()--> page.locator("#drag-drop-upload"));
	    
	    		
	} 

}
