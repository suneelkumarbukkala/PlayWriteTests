package playwright.tests;

import org.testng.annotations.Test;
import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.FrameLocator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;

public class DragAndDrop {
	@Test
	public void handleDragAndDrop()
	{
		Browser browser = Playwright.create().chromium().launch(new BrowserType.LaunchOptions().setHeadless(false).setSlowMo(500));
		Page page  = browser.newPage();
		page.navigate("https://jqueryui.com/droppable/");
		FrameLocator framelocator = page.frameLocator(".demo-frame");
		framelocator.locator("#draggable").dragTo(framelocator.locator("#droppable"));
		page.close();
		browser.close();
	}

}
