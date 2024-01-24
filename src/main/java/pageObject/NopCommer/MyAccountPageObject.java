package pageObject.NopCommer;

import org.openqa.selenium.WebDriver;

import commons.BasePage;
import pageUIs.NopCommer.MyAccountUIs;

public class MyAccountPageObject extends BasePage{
	private WebDriver driver;
	public MyAccountPageObject(WebDriver driver) {
		super(driver);
		this.driver = driver;
	}
	public void clickSaveButton() {
		waitForElementClickable(MyAccountUIs.SAVE_BUTTON);
		clickToElement(MyAccountUIs.SAVE_BUTTON);
	}
	public void clickGenderRadioButton() {
		waitForElementClickable(MyAccountUIs.GENDER_RADIO);
		checkTheCheckboxOrRadio(MyAccountUIs.GENDER_RADIO);
	}
	public void sendkyTextBox(String valueText, String dynamic) {
		waitForElementVisible(MyAccountUIs.SENDKY_TEXTBOX,dynamic);
		sendkeyToElement(MyAccountUIs.SENDKY_TEXTBOX, valueText, dynamic);
	}
	public void dropdownDateOfBirth(String valueTime, String dynamic) {
		waitForElementVisible(MyAccountUIs.DATE_DROPDOWN, dynamic);
		selectItemInDropDownBy_Text(MyAccountUIs.DATE_DROPDOWN, valueTime, dynamic);
	}
	public String getMessageSuccessful() {
		waitForElementVisible(MyAccountUIs.MESSAGE_UPDATE_SUCCESSFULLY);
		return getTextelement(MyAccountUIs.MESSAGE_UPDATE_SUCCESSFULLY);
	}
	public String getTextCustomer(String dynamic) {
		waitForElementVisible(MyAccountUIs.SENDKY_TEXTBOX,dynamic);
		return getTextelement(MyAccountUIs.SENDKY_TEXTBOX,dynamic);
	}
	public String getTextDropDownTime(String dynamic) {
		waitForElementVisible(MyAccountUIs.DATE_DROPDOWN, dynamic);
		return getTextelement(MyAccountUIs.DATE_DROPDOWN, dynamic);
	}

}
