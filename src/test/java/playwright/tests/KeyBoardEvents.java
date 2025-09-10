package playwright.tests;

import org.testng.annotations.Test;
import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;

public class KeyBoardEvents {
	@Test
	public void KeyboardTest()
	{
		Browser browser = Playwright.create().chromium().launch(new BrowserType.LaunchOptions().setHeadless(false).setSlowMo(500));
		Page page       = browser.newPage();
		page.navigate("https://freelance-learn-automation.vercel.app/login");
		page.getByPlaceholder("Enter Email").fill("abc625@gmail.com");
		//1.Approach 
		//Selcting
		/*page.keyboard().down("Control");
		page.keyboard().press("A");
		page.keyboard().up("Control");
		//Copy
		page.keyboard().down("Control");
		page.keyboard().press("C");
		page.keyboard().up("Control");
		page.keyboard().press("Enter");
		page.keyboard().press("Tab");
		//Paste
		page.keyboard().down("Control");
		page.keyboard().press("V");
		page.keyboard().up("Control");*/
		
		//2.Approach
		
		page.keyboard().press("Control+A");
		page.keyboard().press("Control+C");
		page.keyboard().press("Tab");
		page.keyboard().press("Control+V");
		
		page.close();
		browser.close();
	}

}
