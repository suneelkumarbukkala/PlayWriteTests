package practisetests;

import org.testng.annotations.Test;
import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.FrameLocator;
import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;

public class Sliders {
	@Test
	public void handleSlider()
	{
		Browser browser = Playwright.create().chromium().launch(new BrowserType.LaunchOptions().setHeadless(false).setSlowMo(1000));
	    Page page  = browser.newPage();
	    page.navigate("https://jqueryui.com/slider/");
	    
	    FrameLocator frame = page.frameLocator(".demo-frame");
	    Locator slider = frame.locator("//span[@class='ui-slider-handle ui-corner-all ui-state-default']");
	    slider.focus();
	    
	    for(int i=1;i<=10;i++)
	    {
	    	page.keyboard().press("ArrowRight");
	    }
	    
	    page.close();
	    browser.close();
	}

}
