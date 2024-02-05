package pageObject.NopCommer;

import org.openqa.selenium.WebDriver;

import commons.BasePage;
import pageUIs.NopCommer.CustomerInfoPageUIs;

public class CustomerInfoPageObject extends BasePage{
	private WebDriver driver;
	public CustomerInfoPageObject(WebDriver driver) {
		super(driver);
		this.driver = driver;
	}
	public void clickSaveButton() {
		waitForElementClickable(CustomerInfoPageUIs.SAVE_BUTTON);
		clickToElement(CustomerInfoPageUIs.SAVE_BUTTON);
	}
	public void clickGenderRadioButton() {
		waitForElementClickable(CustomerInfoPageUIs.GENDER_RADIO);
		checkTheCheckboxOrRadio(CustomerInfoPageUIs.GENDER_RADIO);
	}
	public void sendkyTextBox(String valueText, String dynamic) {
		waitForElementVisible(CustomerInfoPageUIs.SENDKY_TEXTBOX,dynamic);
		sendkeyToElement(CustomerInfoPageUIs.SENDKY_TEXTBOX, valueText, dynamic);
	}
	public void dropdownDateOfBirth(String valueTime, String dynamic) {
		waitForElementVisible(CustomerInfoPageUIs.DATE_DROPDOWN, dynamic);
		selectItemInDropDownBy_Text(CustomerInfoPageUIs.DATE_DROPDOWN, valueTime, dynamic);
	}
	public String getMessageSuccessful() {
		waitForElementVisible(CustomerInfoPageUIs.MESSAGE_UPDATE_SUCCESSFULLY);
		return getTextElement(CustomerInfoPageUIs.MESSAGE_UPDATE_SUCCESSFULLY);
	}
	public String getTextCustomer(String dynamic, String value) {
		waitForElementVisible(CustomerInfoPageUIs.SENDKY_TEXTBOX,dynamic);
		return getAttrabuteValue(CustomerInfoPageUIs.SENDKY_TEXTBOX,value, dynamic);
	}
	public String getTextDropDownTime(String dynamic, String value) {
		waitForElementVisible(CustomerInfoPageUIs.DATE_DROPDOWN, dynamic);
		return getAttrabuteValue(CustomerInfoPageUIs.DATE_DROPDOWN, value, dynamic);
	}
}
