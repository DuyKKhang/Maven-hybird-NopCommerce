package pageObject.NopCommer;

import org.openqa.selenium.WebDriver;

import commons.BasePage;
import pageUIs.NopCommer.LoginPageUIs;

public class LoginPageObject extends BasePage{

	public LoginPageObject(WebDriver driver) {
		super(driver);
	}

	public void clickToButtonLogin() {
		waitForElementClickable(LoginPageUIs.LOGIN_BUTTON);
		clickToElement(LoginPageUIs.LOGIN_BUTTON);
	}

	public String getTitlePageLogin() {

		return getTitle();
	}

	public String getMessageErrorEmail() {
		waitForElementVisible(LoginPageUIs.MESSAGE_ERROR_EMAIL);
		return getTextelement(LoginPageUIs.MESSAGE_ERROR_EMAIL);
	}

}
