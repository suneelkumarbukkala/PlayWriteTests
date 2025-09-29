package pageobjectmodelPageClasses;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;

public class LoginPage {
   
	private Locator userName;
	private Locator password;
	private Locator signButton;
	
	public LoginPage(Page page)
	{
		userName = page.getByPlaceholder("Enter Email");
		password = page.getByPlaceholder("Enter Password");
		signButton = page.locator(".submit-btn");
	}
	
	public void loginPage(String un,String pwd)
	{
		userName.fill(un);
		password.fill(pwd);
		signButton.click();
	}
	
	
}
