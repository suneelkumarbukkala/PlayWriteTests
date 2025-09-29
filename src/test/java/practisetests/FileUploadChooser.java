package practisetests;

import java.nio.file.Path;
import org.testng.annotations.Test;
import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.FileChooser;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;

public class FileUploadChooser {
	@Test
	public void fileUplaod()
	{
		Browser browser =  Playwright.create().chromium().launch(new BrowserType.LaunchOptions().setHeadless(false).setSlowMo(500));
	    Page page  = browser.newPage();
	    page.navigate("https://the-internet.herokuapp.com/upload");
	    FileChooser fileChooser = page.waitForFileChooser(
	    		   ()->page.locator("#drag-drop-upload").click()
	    		   );
	    
	    //1.Single file Upload	
	    //fileChooser.setFiles(Path.of(System.getProperty("user.dir")+"/files/file_example_JPG.jpg"));
	    
	    //2.Multiple Files Upload
	    Path files[] = {
	    		Path.of(System.getProperty("user.dir")+"/files/file_example_JPG.jpg"),
	    		Path.of(System.getProperty("user.dir")+"/files/jpg-example-file-download.jpg")
	          };
	    fileChooser.setFiles(files);
	    
	    page.close();
	    browser.close();
	}
}
