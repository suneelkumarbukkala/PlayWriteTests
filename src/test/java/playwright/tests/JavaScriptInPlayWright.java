package playwright.tests;

import org.testng.annotations.Test;
import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Page.NavigateOptions;
import com.microsoft.playwright.Playwright;

public class JavaScriptInPlayWright {
	@Test
	public void javaScriptPalyWright()
	{
		Browser browser  = Playwright.create().chromium().launch(new BrowserType.LaunchOptions().setHeadless(false).setSlowMo(500));
		
		Page page  = browser.newPage();
		
		page.navigate("https://login.yahoo.com/?.lang=en-US&src=homepage&.done=https%3A%2F%2Fwww.yahoo.com%2F%3Fguccounter%3D1%26guce_referrer%3DaHR0cHM6Ly93d3cuZ29vZ2xlLmNvbS8%26guce_referrer_sig%3DAQAAACoMqNHfRGs-ZZEwHw1vyA-qjv21bcYyQlYb7sNhH0yATLI8XJW1z65rbSaL3-a5ss_vMr0pFzZGXwt3gjfxH3J7OTtqpaajgiaZYUwoqx6tLlnJ0W119N-H6j3pXe5fuWAnu76paKWN4hGlAVONsgnGh_CUOJv4n-pakF1Toq6k&pspid=2023538075&activity=ybar-signin",
				  new Page.NavigateOptions().setTimeout(60000));
		//Using java script evalutaor
		
		page.evaluate("document.getElementById('persistent').click()");
		
		page.close();
		browser.close();		
	}

}
