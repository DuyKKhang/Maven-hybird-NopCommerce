package pageObject.NopCommer;

import org.openqa.selenium.WebDriver;

import commons.BasePage;
import commons.PageGeneratorManager;
import pageUIs.NopCommer.HomePageUIs;
import pageUIs.NopCommer.LoginPageUIs;

public class HomePageObject extends BasePage{
	private WebDriver driver;
	public HomePageObject(WebDriver driver) {
		super(driver);
		this.driver = driver;
	}

	public RegisterPageObject clickToRegister() {
		waitForElementVisible(HomePageUIs.REGISTER_LINK);
		clickToElement(HomePageUIs.REGISTER_LINK);
		return new PageGeneratorManager().getRegisterPageObject(driver);
	}

	public LoginPageObject clickToLinkLogin() {
		waitForElementClickable(LoginPageUIs.LOGIN_LINK);
		clickToElement(LoginPageUIs.LOGIN_LINK);
		return new PageGeneratorManager().getLoginPageObject(driver);
	}
	
	
}
