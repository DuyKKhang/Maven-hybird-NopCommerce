package factoryEnvironment;

import commons.GlobalConstants;
import factoryBrowser.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URL;

public class BrowserStackFactory {

	private String browser, os, os_version;
	private WebDriver driver;

	public BrowserStackFactory(String browser, String os, String os_version) {
		this.browser = browser;
		this.os = os;
		this.os_version = os_version;
	}

	public WebDriver createDriver() {
		DesiredCapabilities caps = new DesiredCapabilities();
		caps.setCapability("browser", browser);
		caps.setCapability("os", os);
		caps.setCapability("os_version", os_version);
		caps.setCapability("browser_version", "latest");
		caps.setCapability("browserstack.console", "info");

		try {
			driver = new RemoteWebDriver(new URL(GlobalConstants.getGlobalConstants().getbrowserStackUrl()),caps);
		}catch (MalformedURLException e){
			e.printStackTrace();
		}
		return driver;
	}
}
