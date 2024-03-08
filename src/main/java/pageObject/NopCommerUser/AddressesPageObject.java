package pageObject.NopCommerUser;

import commons.BasePage;
import org.openqa.selenium.WebDriver;
import pageUIs.NopCommerUser.AddressesPageUIs;

public class AddressesPageObject extends BasePage {
    private WebDriver driver;
    public AddressesPageObject(WebDriver driver) {
        super(driver);
        this.driver = driver;
    }

    public void clickAddNew() {
        waitForElementClickable(AddressesPageUIs.BUTTON_ADD_NEW);
        clickToElement(AddressesPageUIs.BUTTON_ADD_NEW);
    }

    public void inputTextBox(String value, String dynamic) {
        waitForElementVisible(AddressesPageUIs.INPUT_TEXTBOX, dynamic);
        sendkeyToElement(AddressesPageUIs.INPUT_TEXTBOX, value, dynamic);
    }

    public void selectCountry(String value) {
        waitForElementVisible(AddressesPageUIs.SELECT_COUNTRY);
        selectItemInDropDownBy_Text(AddressesPageUIs.SELECT_COUNTRY,value);
    }

    public void clickToSave() {
        waitForElementClickable(AddressesPageUIs.BUTTON_SAVE);
        clickToElement(AddressesPageUIs.BUTTON_SAVE);
    }

    public String getTextVerifyNotLabel(String dynamic) {
        waitForElementVisible(AddressesPageUIs.TEXT_VALUE_VERIFY_NOT_LABEL, dynamic);
        return getTextElement(AddressesPageUIs.TEXT_VALUE_VERIFY_NOT_LABEL, dynamic);
    }
}
