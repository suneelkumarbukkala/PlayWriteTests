package utils;

import java.nio.file.Paths;
import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Page.ScreenshotOptions;

public class Screenshots {

	public static byte[] takeScreenshotByPage(Page page)
	{
		byte[] arr = page.screenshot(new Page.ScreenshotOptions().setFullPage(true).setPath(Paths.get("Screenshot1.png")));
	    return arr;
	}	
	
	public static byte[] takeScreenshotByLocator(Page page,String locator)
	{
		byte arr[] = page.locator(locator).screenshot(new Locator.ScreenshotOptions().setPath(Paths.get("Screenshot2.png")));
		return arr;
	}
	
}
