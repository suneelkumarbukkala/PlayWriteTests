package playwright.tests;

import org.testng.annotations.Test;
import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;
import com.microsoft.playwright.assertions.PlaywrightAssertions;

public class HandleAutoSuggestion {
	@Test
	public void autoSuggestionText() throws InterruptedException
	{
		Browser browser  = Playwright.create().chromium().launch(new BrowserType.LaunchOptions().setHeadless(false).setSlowMo(500));
        Page page  = browser.newPage();
        page.navigate("https://www.google.com/");
        page.locator("xpath=//textarea[@title='Search']").fill("mukesh otwani");
        Locator locator = page.locator("//ul[@role='listbox']//li");
        System.out.println("Count"+locator.count());
        for(int i=0;i<locator.count();i++)
        {
        	String Text = locator.nth(i).innerText().trim();
        	System.out.println("Text"+Text);
        	if(Text.contains("playwright"))
        	{
        		locator.nth(i).click();
        		break;
        	}
        }
        
        //Clicking on mukesh otwani playwright test
        page.close();
        browser.close();
	}

}
