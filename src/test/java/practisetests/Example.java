package practisetests;

import com.microsoft.playwright.*;
import com.microsoft.playwright.options.*;
import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;
import java.util.*;

public class Example {
  public static void main(String[] args) {
    try (Playwright playwright = Playwright.create()) {
      Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions()
        .setHeadless(false));
      Page page = browser.newPage();
      page.navigate("https://freelance-learn-automation.vercel.app/login");
      page.locator(".col-lg-6").click();
      page.getByPlaceholder("Enter Email").fill("flossie.walter@hotmail.com");
      page.getByPlaceholder("Enter Email").click();
      page.getByPlaceholder("Enter Email").press("Tab");
      page.getByPlaceholder("Enter Password").fill("gg03pg3bjblxxg");
      page.getByPlaceholder("Enter Password").click();
      page.getByPlaceholder("Enter Password").press("Enter");
      page.locator(".bottom-div > button").first().click();
      page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Cart 1")).click();
      page.getByRole(AriaRole.IMG, new Page.GetByRoleOptions().setName("menu")).click();
      page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Sign out")).click();
      page.close();
      browser.close();
    }
  }
}
