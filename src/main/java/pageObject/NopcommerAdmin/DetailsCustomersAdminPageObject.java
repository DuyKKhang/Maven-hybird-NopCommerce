package pageObject.NopcommerAdmin;

import commons.BasePage;
import commons.PageGeneratorManagerAdmin;
import org.openqa.selenium.WebDriver;
import pageUIs.NopcommerAdmin.CustomersAdminPageUIs;
import pageUIs.NopcommerAdmin.DetailsCustomersAdminPageUIs;

import java.util.ArrayList;
import java.util.List;

public class DetailsCustomersAdminPageObject extends BasePage {
    private WebDriver driver;
    public DetailsCustomersAdminPageObject(WebDriver driver) {
        super(driver);
        this.driver = driver;
    }


    public void editInformation(String value, String dynamic) {
        waitForElementVisible(DetailsCustomersAdminPageUIs.INFORMATION_EDIT_TEXTBOX,dynamic);
        scrollToElement(DetailsCustomersAdminPageUIs.INFORMATION_EDIT_TEXTBOX,dynamic);
        sendkeyToElement(DetailsCustomersAdminPageUIs.INFORMATION_EDIT_TEXTBOX, value, dynamic);
    }

    public CustomersAdminPageObject clickSaveEdit() {
        waitForElementVisible(DetailsCustomersAdminPageUIs.SAVE_BUTTON);
        clickToElement(DetailsCustomersAdminPageUIs.SAVE_BUTTON);
        return PageGeneratorManagerAdmin.getCustomersAdminPageObject(driver);
    }

    public void clickAddressesDetail() {
        waitForElementVisible(DetailsCustomersAdminPageUIs.DETAILS_ADDRESSES);
        scrollToElement(DetailsCustomersAdminPageUIs.DETAILS_ADDRESSES);
        clickToElement(DetailsCustomersAdminPageUIs.DETAILS_ADDRESSES);
    }

    public void clickAddNewAdresses() {
        waitForElementVisible(DetailsCustomersAdminPageUIs.ADD_NEW_ADDRESSES_BUTTON);
        clickToElement(DetailsCustomersAdminPageUIs.ADD_NEW_ADDRESSES_BUTTON);
    }


    public void fillOutInformationAddress(String value, String dynamic) {
        waitForElementVisible(DetailsCustomersAdminPageUIs.INFORMATION_ADDRESSES, dynamic);
        sendkeyToElement(DetailsCustomersAdminPageUIs.INFORMATION_ADDRESSES,value,dynamic);
    }

    public void selectCountryAddresses(String value) {
        waitForElementVisible(DetailsCustomersAdminPageUIs.SELECT_INFORMATION_ADDRESSES);
        selectItemInDropDownBy_Text(DetailsCustomersAdminPageUIs.SELECT_INFORMATION_ADDRESSES,value);
    }

    public void clickSaveAddresses() {
        waitForElementVisible(DetailsCustomersAdminPageUIs.SAVE_ADDRESSES_BUTTON);
        clickToElement(DetailsCustomersAdminPageUIs.SAVE_ADDRESSES_BUTTON);
    }

    public String getMassegeSaveAddress() {
        waitForElementVisible(DetailsCustomersAdminPageUIs.MESSAGE_SUCCESS_SAVE);
        return getTextElement(DetailsCustomersAdminPageUIs.MESSAGE_SUCCESS_SAVE);
    }

    public void clickBackToCustomerDetail() {
        waitForElementVisible(DetailsCustomersAdminPageUIs.BACK_TO_CUSTOMER_LINK);
        clickToElementByJS(DetailsCustomersAdminPageUIs.BACK_TO_CUSTOMER_LINK);
    }

    public String getInformationAddress(String dynamic) {
        waitForElementVisible(DetailsCustomersAdminPageUIs.INFO_ADDRESS_TABLE_TEXT,dynamic);
        return getTextElement(DetailsCustomersAdminPageUIs.INFO_ADDRESS_TABLE_TEXT, dynamic);
    }

    public void clickEditAddress(String dynamic) {
        waitForElementVisible(DetailsCustomersAdminPageUIs.EDIT_ADDRESSES,dynamic);
        clickToElementByJS(DetailsCustomersAdminPageUIs.EDIT_ADDRESSES,dynamic);

    }

    public String getMessageTableNoData() {
        waitForElementVisible(DetailsCustomersAdminPageUIs.MESSAGE_TABLE_NO_DATA);
        return getTextElement(DetailsCustomersAdminPageUIs.MESSAGE_TABLE_NO_DATA);
    }

    public void inputTextAreaInformationCustomer(String value, String dynamic) {
        waitForElementVisible(CustomersAdminPageUIs.TEXTAREA_INFORMATION_CUSTOMER_TEXT_BOX, dynamic);
        sendkeyToElement(CustomersAdminPageUIs.TEXTAREA_INFORMATION_CUSTOMER_TEXT_BOX, value, dynamic);
    }

    public void clickDeleteAddress() {
        waitForElementVisible(DetailsCustomersAdminPageUIs.DELETE_ADDRESSES);
        clickToElement(DetailsCustomersAdminPageUIs.DELETE_ADDRESSES);
        acceptAlert();
    }
}
