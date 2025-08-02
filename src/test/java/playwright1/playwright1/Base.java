package playwright1.playwright1;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserContext;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;

public class Base extends Util implements IntialClass {
	
	Playwright playwright ;
	Page page;
	Browser browser ;


	@BeforeTest
	public void launchURL() {
		playwright = Playwright.create() ;
			 browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false)
					.setArgs(java.util.Arrays.asList("--start-maximized")));
			BrowserContext context = browser.newContext(new Browser.NewContextOptions().setViewportSize(null));
			// browser.
			
			page = context.newPage();
	}
	
	@BeforeClass
	public void URL() {
		page.navigate("https://facebook.com/");
		
	}
	
	@BeforeMethod
	public void login() throws InterruptedException {
		Thread.sleep(2000);
		dataFill(page, ObjectRepository.userName, dataRead("First"));
		Thread.sleep(2000);
	}


}
