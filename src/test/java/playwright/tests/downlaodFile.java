package playwright.tests;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import org.testng.annotations.Test;
import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Download;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;

public class downlaodFile {
	@Test
	public void handleDownloadFile() throws IOException
	{
		Browser browser = Playwright.create().chromium().launch(new BrowserType.LaunchOptions().setHeadless(false).setSlowMo(500));
		Page page  = browser.newPage();
		page.navigate("https://demo.automationtesting.in/FileDownload.html");
		Download download = page.waitForDownload(()->{
			page.locator("//a[@class='btn btn-primary']").click();
		});
		download.path();
		String Name = download.suggestedFilename();
		String url= download.url();
		System.out.println("Url"+url);
		System.out.println("FileName"+Name);
		String downloadedPath= System.getProperty("user.dir")+"/downloads/"+Name;
		
		download.saveAs((Paths.get(downloadedPath)));
		
		if(downloadedPath.endsWith(".pdf"))
		{
			System.out.println("File Extension ended");
		}
		else
		{
			System.out.println("File Extension Not ended");
			page.close();
			browser.close();
		}
		
		if(Files.size(Path.of(downloadedPath))>0)
		{
			System.out.println("File size exists");
		}
		else
		{
			System.out.println("File size dosen't exists");
			page.close();
			browser.close();
		}
		
		//String dataFromFile =  Files.readString(Path.of(downloadedPath));
		String dataFromFile =  Files.readString(Path.of(downloadedPath));
		
		if(dataFromFile.contains("The Selenium Browser Automation Project"))
		{
			System.out.println("File Content Verified");
		}
		else
		{
			System.out.println("file Content not verified");
			page.close();
			browser.close();
		}
		page.close();
		browser.close();
	}

}
