package pageObject.NopCommerUser;

import org.openqa.selenium.WebDriver;

import commons.BasePage;
import commons.PageGeneratorManagerUser;
import pageUIs.NopCommerUser.RegisterPageUIs;

public class RegisterPageObject extends BasePage{
	private WebDriver driver;
	public RegisterPageObject(WebDriver driver) {
		super(driver);
		this.driver = driver;
	}

	public void clickButtonRegister() {
		waitForElementClickable(RegisterPageUIs.REGISTER_BUTTON);
		sleep(1);
		clickToElement(RegisterPageUIs.REGISTER_BUTTON);
	}

	public String getTextMessageError(String dynamic) {
		waitForElementVisible(RegisterPageUIs.MESSAGE_ERROR_TEXT,dynamic);
		return getTextElement(RegisterPageUIs.MESSAGE_ERROR_TEXT, dynamic);
	}

	public void inputTextbox(String textValue, String dynamic) {
		waitForElementVisible(RegisterPageUIs.INPUT_TEXTBOX, dynamic);
		sendkeyToElement(RegisterPageUIs.INPUT_TEXTBOX, textValue, dynamic);		
	}

	public String getTextMessageSuccess() {
		sleep(1);
		waitForElementVisible(RegisterPageUIs.MESSAGE_REGISTER_SUCCESS);
		return getTextElement(RegisterPageUIs.MESSAGE_REGISTER_SUCCESS);
	}

	public boolean isDisplyedContinueButton() {
		waitForElementVisible(RegisterPageUIs.CONTINUE_BUTTON);
		return isControlDisplayed(RegisterPageUIs.CONTINUE_BUTTON);
	}

	public HomePageObject clickToContinueButton() {
		waitForElementClickable(RegisterPageUIs.CONTINUE_BUTTON);
		clickToElement(RegisterPageUIs.CONTINUE_BUTTON);
		return PageGeneratorManagerUser.getHomePageObject(driver);
	}

	public String getTextMessageExists() {
		waitForElementVisible(RegisterPageUIs.MESSAGE_EMAIL_EXISTS);
		return getTextElement(RegisterPageUIs.MESSAGE_EMAIL_EXISTS);
	}

}
