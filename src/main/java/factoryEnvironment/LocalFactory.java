package factoryEnvironment;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import factoryBrowser.ChromeDriverManager;
import factoryBrowser.EdgeDriverManager;
import factoryBrowser.FirefoxDriverManager;
import factoryBrowser.HeadlessChromeDriverManager;
import factoryBrowser.HeadlessFirefoxDriverManager;

public class LocalFactory {
	
	private String browser;
	private WebDriver driver;
	
	public LocalFactory(String browser) {
		this.browser = browser;
	}

	public WebDriver createDriver() {
		BrowserList browserList = BrowserList.valueOf(browser.toUpperCase());
		switch (browserList) {
		case CHROME:
			driver = new ChromeDriverManager().getBrowserDriver();
			break;

		case H_CHROME:
			driver = new HeadlessChromeDriverManager().getBrowserDriver();
			break;
			
		case FIREFOX:
			driver = new FirefoxDriverManager().getBrowserDriver();
			break;
		
		case H_FIREFOX:
			driver = new HeadlessFirefoxDriverManager().getBrowserDriver();
			break;
		
		case EDGE:
			driver = new EdgeDriverManager().getBrowserDriver();
			break;
		}	
		return driver;
	}
	
	
	
}
