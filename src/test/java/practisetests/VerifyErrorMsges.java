package practisetests;

import java.util.regex.Pattern;

import org.testng.Assert;
import org.testng.annotations.Test;
import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;
import com.microsoft.playwright.assertions.PlaywrightAssertions;

public class VerifyErrorMsges {
	@Test
	public void validateErroMsg()
	{
		Browser browser  = Playwright.create().chromium().launch(new BrowserType.LaunchOptions().setHeadless(false).setSlowMo(500));
		Page page  =browser.newPage();
		page.navigate("https://freelance-learn-automation.vercel.app/login");
		page.locator(".submit-btn").click();
		
		/*//Valdiate error messages using TestNG Assertons
		String ErrorTxt =page.locator(".errorMessage").textContent();
		Assert.assertEquals(ErrorTxt,"Email and Password is required");
		
		String ErrorMsg = page.locator(".errorMessage").innerText();
		Assert.assertEquals(ErrorMsg, "Email and Password is required");
		
		Assert.assertTrue(ErrorMsg.contains("required"));*/
		
		//2.Validate error messages using Playwright Assertions
		
		PlaywrightAssertions.assertThat(page.locator(".errorMessage")).containsText("Email and Password is required");
		PlaywrightAssertions.assertThat(page.locator(".errorMessage")).containsText(Pattern.compile("required"));
		
		page.close();
		browser.close();	
	}

}
