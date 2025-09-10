package playwright.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import com.microsoft.playwright.*;
import com.microsoft.playwright.assertions.PlaywrightAssertions;
import com.microsoft.playwright.options.*;
import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;

import java.util.regex.Pattern;

public class VerifyErrorText {
	@Test
	public void verifyErrorMsg()
	{
		Browser browser  = Playwright.create().chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));
	    Page page = browser.newPage();
	    page.navigate("https://freelance-learn-automation.vercel.app/login");
	    page.locator(".submit-btn").click();
	    String expectedText = "Email and Password is required";
	    String actualText = page.locator(".errorMessage").textContent().trim();
	    String actualText1 = page.locator(".errorMessage").innerText().trim();
	    
	    Assert.assertEquals(actualText, expectedText);
	    Assert.assertTrue(actualText.contains(expectedText));
	    
	    PlaywrightAssertions.assertThat(page.locator(".errorMessage")).containsText("Email is required");
	    PlaywrightAssertions.assertThat(page.locator(".errorMessage")).containsText(Pattern.compile("required"));
	    
	    page.close();
	    browser.close();   
	}

}
