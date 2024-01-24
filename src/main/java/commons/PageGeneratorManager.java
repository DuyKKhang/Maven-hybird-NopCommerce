package commons;

import org.openqa.selenium.WebDriver;

import pageObject.NopCommer.HomePageObject;
import pageObject.NopCommer.LoginPageObject;
import pageObject.NopCommer.MyAccountPageObject;
import pageObject.NopCommer.RegisterPageObject;

public class PageGeneratorManager {
	
	public static HomePageObject getHomePageObject(WebDriver driver) {
		return new HomePageObject(driver);
	}
	
	public static LoginPageObject getLoginPageObject(WebDriver driver) {
		return new LoginPageObject(driver);
	}
	
	public static RegisterPageObject getRegisterPageObject(WebDriver driver) {
		return new RegisterPageObject(driver);
	}
	
	public static MyAccountPageObject getMyAccountPageObject(WebDriver driver) {
		return new MyAccountPageObject(driver);
	}
}
