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
		waitForElementClickable(HomePageUIs.LOGIN_LINK);
		clickToElement(HomePageUIs.LOGIN_LINK);
		return new PageGeneratorManager().getLoginPageObject(driver);
	}

	public MyAccountPageObject clickToLinkMyAccount() {
		waitForElementVisible(HomePageUIs.MY_ACCOUNT_LINK);
		clickToElement(HomePageUIs.MY_ACCOUNT_LINK);
		sleep(2);
		return new PageGeneratorManager().getMyAccountPageObject(driver);
	}

	public String getTitlePage() {
		return getTitle();
	}

	public String getTextLogout() {
		waitForElementVisible(LoginPageUIs.LINK_LOGOUT);
		return getTextelement(LoginPageUIs.LINK_LOGOUT);
	}

	
	
}
