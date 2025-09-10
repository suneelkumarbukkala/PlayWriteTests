package selenium_projects.PlayWriteTests;

import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;
import java.util.List;
import com.microsoft.playwright.*;
import com.microsoft.playwright.options.SelectOption;

public class HandleDropDown {
public static void main(String args[])
{
	try(Playwright wright=Playwright.create())
	{
		Browser browser = wright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));
		Page page = browser.newPage();
		page.navigate("https://www.flipkart.com/");
		Locator textbox = page.locator("//input[@type='text']");
		textbox.type("Mobiles");
		page.keyboard().press("Enter");
		Locator dropdown = page.locator("(//select[@class='Gn+jFg'])[1]");
		dropdown.selectOption("₹15000");
		dropdown.selectOption(new SelectOption().setLabel("₹20000"));
		dropdown.selectOption(new SelectOption().setIndex(1));
		
		Locator options = dropdown.locator("option");
		System.out.println("Size:\t"+options.count());
		List<String> text=options.allInnerTexts();
		for(int i=0;i<text.size();i++)
		{
			System.out.println("Options\t"+text.get(i));
		}
	}
}
	
}
