package selenium_projects.PlayWriteTests;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;
import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;

import java.util.List;

public class WindowHandle {
	public static void main(String args[])
	{
		try(Playwright wright=Playwright.create())
		{
			Browser browser = wright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));
			Page page= browser.newPage();
			page.navigate("https://www.selenium.dev/selenium/web/window_switching_tests/page_with_frame.html");
			System.out.println("Parent Page Title"+page.title());
			
			/*Page child= page.waitForPopup(()->{
			page.locator("//a[@id='a-link-that-opens-a-new-window']").click();
			});
			child.waitForLoadState();
			assertThat(child).hasTitle("Simple Page");
			System.out.println("Child Page Title"+child.title());*/
			
			Page tabs= page.waitForPopup(new Page.WaitForPopupOptions().
					setPredicate(p->p.context().pages().size()==2),()->
			{
				page.locator("//a[@id='a-link-that-opens-a-new-window']").click();
			});
		    List<Page> pages = tabs.context().pages();
		    System.out.println("Number of Page:\t"+pages.size());
		    pages.forEach(pat->{
		    		pat.waitForLoadState();
		    		System.out.println("Title\t"+pat.title());
		    });
		    	
		    
			//child.close();
			page.close();
			browser.close();
			wright.close();
		}
	}

}
