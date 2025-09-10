package selenium_projects.PlayWriteTests;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import com.google.gson.JsonObject;
import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;

public class ExecuteOnCloud {
   public static void main(String args[]) throws UnsupportedEncodingException
    {
	   JsonObject capabilities = new JsonObject();
	   JsonObject ltoptions = new JsonObject();
	   
	   String userName = "Suneel";
	   String accessKey =  "";
	   
	   capabilities.addProperty("browsername", "Chrome");
	   ltoptions.addProperty("browserVersion", "latest");
	   ltoptions.addProperty("platform", "Windows 10");
	   ltoptions.addProperty("name", "Play Wright Test");
	   ltoptions.addProperty("build", "Play wright Java Build 2");
	   ltoptions.addProperty("user", userName);
	   ltoptions.addProperty("accessKey", accessKey);
	   capabilities.add("LT:Options", ltoptions);
	   
	   Playwright wright     = Playwright.create();
	   BrowserType chromium  = wright.chromium();
	   String caps = URLEncoder.encode(capabilities.toString(),"utf-8");
	   String cdpUrl = "wss://cdp.lamdatest.com/playwright?capabilities="+caps;
	   Browser browser = chromium.connect(cdpUrl);
	   
	   Page page  = browser.newPage();
	   page.navigate(cdpUrl);
	   Locator duck = page.locator("(//a[@href=\"https://duck.ai\"])[2]");
	   duck.fill("LambdaTest");
	   page.keyboard().press("Enter");
	   String Title = page.title();
	   
	   if(Title.equals("DuckDuckGo AI Chat"))
	   {
		   System.out.println("Test Pass");
	   }
	   else
	   {
		   System.out.println("Test Fail");
	   }
	   browser.close();
	   wright.close();
    }
}
