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

	public String getTitlePage() {
		waitForElementVisible(LoginPageUIs.LINK_LOGOUT);
		return getTitle();
	}

	public String getTextLogout() {
		waitForElementVisible(LoginPageUIs.LINK_LOGOUT);
		return getTextelement(LoginPageUIs.LINK_LOGOUT);
	}


	public DetailProductPageObject clickAddToCard() {
		scrollToElement(HomePageUIs.LOCATOR_CONTIENT_PRODUCT);
		waitForElementClickable(HomePageUIs.ADD_TO_CARD_BUTTON);
		clickToElement(HomePageUIs.ADD_TO_CARD_BUTTON);
		return PageGeneratorManager.getDetailProductPageObject(driver);
	}
}
