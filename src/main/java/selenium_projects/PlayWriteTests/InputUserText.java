package selenium_projects.PlayWriteTests;

import com.microsoft.playwright.*;
import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;

public class InputUserText {
	public static void main(String args[]) throws InterruptedException
	{
		try(Playwright wright=Playwright.create())
		{
			Browser browser = wright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));
			Page page = browser.newPage();
			page.navigate("https://www.flipkart.com/");
			//Verifing TextBox Attribute Value
			String titleValue =  page.locator("//input[@type='text']").getAttribute("title");
			Locator textbox = page.locator("//input[@type='text']");
			System.out.println("TitleValue:\t"+titleValue);
			assertThat(textbox).hasAttribute("title","Search for Products, Brands and More");
			
			//getting entered text from input textbox
			page.locator("//input[@type='text']").type("Mobiles");
			String InputValue = page.locator("//input[@type='text']").inputValue();
			System.out.println("InputValue:\t"+InputValue);
			
			//pressing enter key
			page.keyboard().press("Enter");
			Thread.sleep(4000);
			//Getting text content
			String Text = page.locator("(//div[@class='KzDlHZ'])[1]").textContent();
			System.out.println("Text:\t"+Text);
			Thread.sleep(2000);
			//Selecting checkbox
			Locator checkbox = page.locator("//div[text()='Apple']//preceding-sibling::div");
			checkbox.click();
			Thread.sleep(2000);
			wright.close();
		}
	}
}
