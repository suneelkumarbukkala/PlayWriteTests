package practisetests;

import org.testng.annotations.Test;
import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.FrameLocator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;

public class DragAndDrop {
	@Test
	public void dragAndDrop()
	{
		Browser browser  = Playwright.create().chromium().launch(new BrowserType.LaunchOptions().setHeadless(false).setSlowMo(1000));
	    Page page  = browser.newPage();
	    page.navigate("https://jqueryui.com/droppable/");
	    
	    FrameLocator frame  = page.frameLocator(".demo-frame");
	    frame.locator("#draggable").dragTo(frame.locator("#droppable"));
	    
	    page.close();
	    browser.close();
	}

}
