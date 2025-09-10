package playwright.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;

public class HandleAlertPopup {
	@Test
	public void HandlePopups() throws InterruptedException
	{
		Browser browser = Playwright.create().chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));
		Page page  = browser.newPage();
		page.navigate("https://the-internet.herokuapp.com/javascript_alerts");
		
		//1.Alert Popup
		/*page.onDialog(dialog->{
				String Messsage  = dialog.message();
				System.out.println("message"+Messsage);
				Assert.assertEquals(Messsage.trim(), "I am a JS Alert");
				dialog.accept();
		});
		page.locator("//button[text()='Click for JS Alert']").click();
		
		String Text = page.locator(".result").innerText().trim();
		Assert.assertEquals(Text, "You successfully clicked an alert");*/
		
		//2.Confirm popup
		/*page.onDialog(dialog->{
			String Message = dialog.message();
			System.out.println("Messsage on Confirm popup"+Message);
			Assert.assertEquals(Message, "I am a JS Confirm");
			dialog.accept();		
		});
		page.locator("//button[text()='Click for JS Confirm']").click();

		String ConfirmText = page.locator(".result").innerText().trim();
		Assert.assertEquals(ConfirmText, "You clicked: Ok");*/
		
		//3.Propmt Popup
		/*page.onDialog(dialog->{
			String promptMsg = dialog.message();
			System.out.println("Prompt Messsage"+promptMsg);
			Assert.assertEquals(promptMsg, "I am a JS prompt");
		    dialog.type();
			dialog.accept();	
		});
		
		page.locator("//button[text()='Click for JS Prompt']").click();*/
		
		page.close();
		browser.close();
		
	}
}
