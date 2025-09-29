package practisetests;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;

public class HandleAlertsPopups {
	Browser browser;
	Page page;
	
	@BeforeClass
	public void launch()
	{
        browser = Playwright.create().chromium().launch(new BrowserType.LaunchOptions().setHeadless(false).setSlowMo(500));
	    page       = browser.newPage();
	    page.navigate("https://the-internet.herokuapp.com/javascript_alerts");	
	}
	
	@Test(enabled=false)
	public void handleAlertPopup()
	{
		//1.Handling of Alert Popup
	    page.onDialog(dialog->
	    {
	       String msg = dialog.message();
	       System.out.println("message"+msg);
	       Assert.assertEquals(msg,"I am a JS Alert");
	       dialog.accept();
	    });
	    
	    page.locator("//button[text()='Click for JS Alert']").click();   
	}
	
	@Test(enabled=false)
	public void handleConfirmationPopup()
	{
		page.onceDialog(dialog->{
			String msg = dialog.message();
			System.out.println("Message"+msg);
			Assert.assertEquals(msg, "I am a JS Confirm");
			dialog.accept();		
		});
		
		page.locator("//button[text()='Click for JS Confirm']").click();
	}
    
	@Test(priority=2)
	public void handlePromptPopup()
	{
		page.onDialog(dialog->{
			String msg = dialog.message();
			System.out.println("Prompt msg\t"+msg);
			Assert.assertEquals(msg, "I am a JS prompt");
			dialog.accept("Suneel Kumar");	
			
		});
		
		page.locator("//button[text()='Click for JS Prompt']").click();
		
	}
	
	@AfterClass
	public void quit()
	{
		page.close();
		browser.close();
	}
}
