package pageObject.NopCommer;

import org.openqa.selenium.WebDriver;

import commons.BasePage;
import commons.PageGeneratorManager;
import pageUIs.NopCommer.LoginPageUIs;

public class LoginPageObject extends BasePage{
	private WebDriver driver;
	public LoginPageObject(WebDriver driver) {
		super(driver);
		this.driver = driver;
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
		return getTextElement(LoginPageUIs.MESSAGE_ERROR_EMAIL);
	}

	public void sendkeyTextBox(String dynamic, String textValue ) {
		waitForElementVisible(LoginPageUIs.INPUT_TEXTBOX, dynamic);
		sendkeyToElement(LoginPageUIs.INPUT_TEXTBOX, textValue, dynamic);
	}

	public String getMessageErrorEmailUnsuccessful() {
		waitForElementVisible(LoginPageUIs.MESSAGE_ERROR_UNSUCCESSFUL_EMAIL);
		return getTextElement(LoginPageUIs.MESSAGE_ERROR_UNSUCCESSFUL_EMAIL);
	}

	public HomePageObject clickToButtonLoginSuccess() {
		waitForElementClickable(LoginPageUIs.LOGIN_BUTTON);
		clickToElement(LoginPageUIs.LOGIN_BUTTON);
		return PageGeneratorManager.getHomePageObject(driver);
	}
	public void clickToButtonLoginSuccessNotCreateDriver() {
		waitForElementClickable(LoginPageUIs.LOGIN_BUTTON);
		clickToElement(LoginPageUIs.LOGIN_BUTTON);
	}
}
