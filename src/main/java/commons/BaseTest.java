package commons;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import factoryEnvironment.BrowserStackFactory;
import org.openqa.selenium.WebDriver;

import factoryEnvironment.EnvironmentList;
import factoryEnvironment.LocalFactory;
import org.testng.Assert;
import org.testng.Reporter;

public class BaseTest{

	private ThreadLocal<WebDriver> driver = new ThreadLocal<WebDriver>();
	public WebDriver getDriverIntance() {
		return driver.get();
	}
	protected WebDriver getBrowserDriver(String evnName,String serverName, String browser, String os, String os_version) {
		switch (evnName) {
		case "local":
			driver.set(new LocalFactory(browser).createDriver());
			break;

		case "browserStack":
			driver.set(new BrowserStackFactory(browser, os, os_version).createDriver());
			break;

		}

		driver.get().manage().timeouts().implicitlyWait(GlobalConstants.getGlobalConstants().getLongTimeOut(), TimeUnit.SECONDS);
		driver.get().get(getEnvironmentUrl(serverName));
		return driver.get();
	}
	
	private String getEnvironmentUrl(String serverName) {
		String server = null;
		EnvironmentList environment = EnvironmentList.valueOf(serverName.toUpperCase());
		switch (environment) {
		case DEV:
			server ="https://demo.nopcommerce.com/";
			break;
		case TEST:
			server ="https://demo.nopcommerce.com/";
			break;
		case ADMIN:
			server ="https://admin-demo.nopcommerce.com/login?ReturnUrl=/admin/";
			break;
		case STAGING:
			server ="https://demo.nopcommerce.com/";
			break;
		case PRODUCT:
			server ="https://demo.nopcommerce.com/";
			break;

		}
		return server;
	}
	
	protected void closeBrowserDriver() {
		String cmd = null;
		try {
			String osName = System.getProperty("os.name").toLowerCase();
//			System.out.println("OS name = " + osName);
			
			String driverInstanceName = driver.toString().toLowerCase();
//			System.out.println("Driver instance name = " + driverInstanceName);
			
			String browserDriverName = null;

			if (driverInstanceName.contains("chrome")) {
				browserDriverName = "chromedriver";
			} else if (driverInstanceName.contains("internetexplorer")) {
				browserDriverName = "IEDriverServer";
			} else if (driverInstanceName.contains("firefox")) {
				browserDriverName = "geckodriver";
			} else if (driverInstanceName.contains("edge")) {
				browserDriverName = "msedgedriver";
			} else if (driverInstanceName.contains("opera")) {
				browserDriverName = "operadriver";
			} else {
				browserDriverName = "safaridriver";
			}

			if (osName.contains("window")) {
				cmd = "taskkill /F /FI \"IMAGENAME eq " + browserDriverName + "*\"";
			} else {
				cmd = "pkill " + browserDriverName;
			}

			if (driver != null) {
				driver.get().manage().deleteAllCookies();
				driver.get().quit();
				driver.remove();
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				Process process = Runtime.getRuntime().exec(cmd);
				process.waitFor();
			} catch (IOException e) {
				e.printStackTrace();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
	protected boolean verifyTrue(boolean condition) {
		boolean pass = true;
		try {
			Assert.assertTrue(condition);
		} catch (Throwable e) {
			pass = false;

			VerificationFailures.getFailures().addFailureForTest(Reporter.getCurrentTestResult(), e);
			Reporter.getCurrentTestResult().setThrowable(e);
		}
		return pass;
	}

	protected boolean verifyFalse(boolean condition) {
		boolean pass = true;
		try {
			Assert.assertFalse(condition);
		} catch (Throwable e) {
			pass = false;
			VerificationFailures.getFailures().addFailureForTest(Reporter.getCurrentTestResult(), e);
			Reporter.getCurrentTestResult().setThrowable(e);
		}
		return pass;
	}

	protected boolean verifyEquals(Object actual, Object expected) {
		boolean pass = true;
		try {
			Assert.assertEquals(actual, expected);
		} catch (Throwable e) {
			pass = false;
			VerificationFailures.getFailures().addFailureForTest(Reporter.getCurrentTestResult(), e);
			Reporter.getCurrentTestResult().setThrowable(e);
		}
		return pass;
	}
}
