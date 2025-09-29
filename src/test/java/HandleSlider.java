import org.testng.annotations.Test;
import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.FrameLocator;
import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;

public class HandleSlider {
	@Test
	public void handleSlider()
	{
      Browser browser = Playwright.create().chromium().launch(new BrowserType.LaunchOptions().setHeadless(false).setSlowMo(500));
      Page page  = browser.newPage();
      page.navigate("https://jqueryui.com/slider/");
      FrameLocator frameLocator = page.frameLocator("//iframe[@class='demo-frame']");
      Locator slider  = frameLocator.locator("//span[contains(@class,'ui-slider-handle ui')]");
      slider.focus();
      for(int i=1;i<=10;i++)
      {
    	  page.keyboard().press("ArrowRight");
      }
      
      page.close();
      browser.close(); 
    }
}