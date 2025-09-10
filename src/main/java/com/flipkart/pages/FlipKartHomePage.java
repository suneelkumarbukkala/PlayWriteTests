package com.flipkart.pages;
import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;

public class FlipKartHomePage {
	
	private Page page = null;
	
	public FlipKartHomePage(Page page)
	{
		this.page = page;
	}
	
	public Locator getFashionsArrow()
	{
		return this.page.locator("//div[@aria-label='Fashion']//span[@class='_27h2j1']");
	}
	
	public Locator getMensFashionLink()
	{
		return this.page.locator("(//a[contains(@href,'mens-tshirts')])[2]");
	}
	
	public void navigateToMensThsirts() throws InterruptedException
	{
		this.getFashionsArrow().hover();
		Thread.sleep(4000);
		this.getMensFashionLink().click();
	}

}
