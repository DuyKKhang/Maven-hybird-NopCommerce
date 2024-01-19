package pageObject.NopCommer;

import org.openqa.selenium.WebDriver;

import commons.BasePage;
import commons.PageGeneratorManager;
import pageUIs.NopCommer.RegisterPageUIs;

public class RegisterPageObject extends BasePage{
	private WebDriver driver;
	public RegisterPageObject(WebDriver driver) {
		super(driver);
		this.driver = driver;
	}

	public void clickButtonRegister() {
		waitForElementClickable(RegisterPageUIs.REGISTER_BUTTON);
		clickToElement(RegisterPageUIs.REGISTER_BUTTON);
	}

	public String getTextMessageError(String dynamic) {
		waitForElementVisible(RegisterPageUIs.MESSAGE_ERROR_TEXT,dynamic);
		return getTextelement(RegisterPageUIs.MESSAGE_ERROR_TEXT, dynamic);
	}

	public void inputTextbox(String textValue, String dynamic) {
		waitForElementVisible(RegisterPageUIs.INPUT_TEXTBOX, dynamic);
		sendkeyToElement(RegisterPageUIs.INPUT_TEXTBOX, textValue, dynamic);		
	}

	public String getTextMessageSuccess() {
		waitForElementVisible(RegisterPageUIs.MESSAGE_REGISTER_SUCCESS);
		return getTextelement(RegisterPageUIs.MESSAGE_REGISTER_SUCCESS);
	}

	public boolean isDisplyedContinueButton() {
		waitForElementVisible(RegisterPageUIs.CONTINUE_BUTTON);
		return isControlDisplayed(RegisterPageUIs.CONTINUE_BUTTON);
	}

	public HomePageObject clickToContinueButton() {
		waitForElementClickable(RegisterPageUIs.CONTINUE_BUTTON);
		clickToElement(RegisterPageUIs.CONTINUE_BUTTON);
		return PageGeneratorManager.getHomePageObject(driver);
	}

	public String getTextMessageExists() {
		waitForElementVisible(RegisterPageUIs.MESSAGE_EMAIL_EXISTS);
		return getTextelement(RegisterPageUIs.MESSAGE_EMAIL_EXISTS);
	}

}
