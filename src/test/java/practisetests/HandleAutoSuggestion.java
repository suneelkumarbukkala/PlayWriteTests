package practisetests;

import org.testng.annotations.Test;
import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;

public class HandleAutoSuggestion {
	@Test
	public void autoSuggestionsPlaywright()
	{
		Browser browser  = Playwright.create().chromium().launch(new BrowserType.LaunchOptions().setHeadless(false).setSlowMo(500));
	    Page page  = browser.newPage();
	    page.navigate("https://www.google.com/");
	    
	    page.locator("//textarea[@title='Search']").fill("Mukesh otwani");
	    
	    Locator options = page.locator("//ul[@role='listbox']//li");
	    System.out.println("Count\t"+options.count());
	    for(int i=0;i<options.count();i++)
	    {
	    	String optionText = options.nth(i).innerText();
	    	System.out.println("Text\t"+optionText);
	    	if(optionText.contains("playwright"))
	    	{
	    	   options.nth(i).click();
	    	   break;
	    	}
	    }
	    page.close();
	    browser.close();    
	}

}
