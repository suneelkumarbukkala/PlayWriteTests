package com.flipkart.pages;
import org.testng.Assert;

import com.microsoft.playwright.BrowserContext;
import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;

public class FlipKartMensTShirtPage  {
	
	public Page page = null;
	public Page child = null;
	
	
	public FlipKartMensTShirtPage(Page page)
	{
		this.page = page;	
	}
	
	public Locator getTShirtLink()
	{
	  return this.page.locator("(//a[@class='rPDeLR']//div)[1]");	
	}
	
	public Locator getTShirtTitle()
	{
		return child.locator("(//div[@class='C7fEHH']//span)[1]");
	}
	
	
	public Locator getTshirtPrice()
	{
		return child.locator("(//div[@class='hl05eU']//div)[1]");
	}
	
	public Page navigateToTShirtLinkDetailsPage()
	{
		child = page.waitForPopup(()->{
			
			this.getTShirtLink().click();
		});
		return child;
		
	}
	
	public void verifyTshirtDetails() throws InterruptedException
	{
		child.waitForLoadState();
		Assert.assertTrue(this.getTshirtPrice().textContent().length()>0);
		Assert.assertTrue(this.getTShirtTitle().textContent().length()>0);
	    System.out.println("TShirt Details valdiated sucessfully");
	}
	
	

}