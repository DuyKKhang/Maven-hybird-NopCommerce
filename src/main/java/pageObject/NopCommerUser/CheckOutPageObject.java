package pageObject.NopCommerUser;

import commons.BasePage;
import commons.PageGeneratorManagerUser;
import org.openqa.selenium.WebDriver;
import pageUIs.NopCommerUser.CheckOutPageUIs;

public class CheckOutPageObject extends BasePage {
    private WebDriver driver;
    public CheckOutPageObject(WebDriver driver) {
        super(driver);
        this.driver = driver;
    }

    public void sendKeyInformationBilingAddress(String value, String dynamic) {
        waitForElementVisible(CheckOutPageUIs.INFORMATION_BILING_ADDRESS,dynamic);
        sendkeyToElement(CheckOutPageUIs.INFORMATION_BILING_ADDRESS,value,dynamic);
    }


    public void selectCountryBilingAddress(String vietNam) {
        waitForElementVisible(CheckOutPageUIs.SELECT_COUNTRY_INFORMATION_BILING_ADDRESS);
        selectItemInDropDownBy_Text(CheckOutPageUIs.SELECT_COUNTRY_INFORMATION_BILING_ADDRESS, vietNam);
    }

    public void clickContinueBillingAddres() {
        waitForElementClickable(CheckOutPageUIs.CONTINUE_BUTTON_BILLING_ADDRESS);
        clickToElementByJS(CheckOutPageUIs.CONTINUE_BUTTON_BILLING_ADDRESS);
    }

    public void chooseShippingMethod(String indexItem) {
        waitForElementClickable(CheckOutPageUIs.SHIPPING_MENTHOD,indexItem);
        checkTheCheckboxOrRadio(CheckOutPageUIs.SHIPPING_MENTHOD,indexItem);
    }

    public void clickContinueShippingAddress() {
        waitForElementClickable(CheckOutPageUIs.CONTINUE_BUTTON_SHIPPING_METHED);
        clickToElement(CheckOutPageUIs.CONTINUE_BUTTON_SHIPPING_METHED);
    }

    public void choosePaymentgMethod(String indexItem) {
        waitForElementClickable(CheckOutPageUIs.PAYMENT_METHOD,indexItem);
        checkTheCheckboxOrRadio(CheckOutPageUIs.PAYMENT_METHOD,indexItem);
    }

    public void clickContinuePaymentMethod() {
        waitForElementClickable(CheckOutPageUIs.CONTINUE_BUTTON_PAYMENT_METHOD);
        clickToElement(CheckOutPageUIs.CONTINUE_BUTTON_PAYMENT_METHOD);
    }

    public String getMessagePaymendInformation() {
        waitForElementVisible(CheckOutPageUIs.MEESSAGE_PAYMEND);
        return getTextElement(CheckOutPageUIs.MEESSAGE_PAYMEND);
    }

    public void clickContinuePaymendInformation() {
        waitForElementClickable(CheckOutPageUIs.CONTINUE_BUTTON_PAYMENT_INFORMATION);
        clickToElement(CheckOutPageUIs.CONTINUE_BUTTON_PAYMENT_INFORMATION);
    }

    public void checkShipToSameAddress() {
        waitForElementClickable(CheckOutPageUIs.SHIP_TO_SAME_CHECKBOX);
        checkTheCheckboxOrRadio(CheckOutPageUIs.SHIP_TO_SAME_CHECKBOX);
    }

    public String getInformationBillingAddress(String dynamicValue) {
        waitForElementVisible(CheckOutPageUIs.BILLING_ADDRESS_TEXT, dynamicValue);
        return getTextElement(CheckOutPageUIs.BILLING_ADDRESS_TEXT, dynamicValue);
    }

    public String getInformationShippingAddress(String dynamicValue) {
        waitForElementVisible(CheckOutPageUIs.SHIPPING_ADDRESS_TEXT, dynamicValue);
        return getTextElement(CheckOutPageUIs.SHIPPING_ADDRESS_TEXT, dynamicValue);
    }

    public String getTextShippingMethod() {
        waitForElementVisible(CheckOutPageUIs.SHIPPING_METHOD_TEXT);
        return getTextElement(CheckOutPageUIs.SHIPPING_METHOD_TEXT);
    }

    public String getTextPaymentMethod(String indexItem) {
        waitForElementVisible(CheckOutPageUIs.PAYMENT_METHOD_TEXT,indexItem);
        return getTextElement(CheckOutPageUIs.PAYMENT_METHOD_TEXT,indexItem);
    }

    public String getInformationProductConfirm(String dynamicValue) {
        waitForElementVisible(CheckOutPageUIs.PRODUCT_INFORMATION_TEXT, dynamicValue);
        return getTextElement(CheckOutPageUIs.PRODUCT_INFORMATION_TEXT, dynamicValue);
    }

    public String getNameProductConfirm() {
        waitForElementVisible(CheckOutPageUIs.NAME_PRODUCT_INFORMATION_TEXT);
        return getTextElement(CheckOutPageUIs.NAME_PRODUCT_INFORMATION_TEXT);
    }

    public String getStatusGiftWrapping() {
        waitForElementVisible(CheckOutPageUIs.GIFT_WRAPPING_TEXT);
        return getTextElement(CheckOutPageUIs.GIFT_WRAPPING_TEXT);
    }

    public String getTotalProductConfirm() {
        waitForElementVisible(CheckOutPageUIs.TOTAL_CONFIRM);
        return getTextElement(CheckOutPageUIs.TOTAL_CONFIRM);
    }

    public void clickContinueConfirm() {
        sleep(5);
        waitForElementClickable(CheckOutPageUIs.CONTINUE_BUTTON_CONFIRM);
        clickToElementByJS(CheckOutPageUIs.CONTINUE_BUTTON_CONFIRM);
    }

    public String getMessageOrderSuccess() {
        waitForElementVisible(CheckOutPageUIs.MESSAGE_CONFIRM);
        return getTextElement(CheckOutPageUIs.MESSAGE_CONFIRM);
    }

    public String getOrderNumber() {
        waitForElementVisible(CheckOutPageUIs.ORDER_NUMBER_CHECKBOX);
        return getTextElement(CheckOutPageUIs.ORDER_NUMBER_CHECKBOX).toLowerCase();
    }

    public HomePageObject clickContinueOrder() {
        waitForElementClickable(CheckOutPageUIs.CONTINUE_ORDER_BUTTON);
        clickToElement(CheckOutPageUIs.CONTINUE_ORDER_BUTTON);

        return PageGeneratorManagerUser.getHomePageObject(driver);
    }

    public void selectCreditCart(String valueSelect, String dynamicLocator) {
        waitForElementVisible(CheckOutPageUIs.CREDIT_CARD_SELECT_DROPDOWN, dynamicLocator);
        selectItemInDropDownBy_Values(CheckOutPageUIs.CREDIT_CARD_SELECT_DROPDOWN,valueSelect, dynamicLocator);
    }

    public void inputInformationCreditCart(String valueKeys, String dynamicLocator) {
        waitForElementVisible(CheckOutPageUIs.CREDIT_CARD_INPUT_TEXTBOX,dynamicLocator);
        sendkeyToElement(CheckOutPageUIs.CREDIT_CARD_INPUT_TEXTBOX, valueKeys, dynamicLocator);
    }

    public void selectNewAddress(String valueSelect) {
        waitForElementVisible(CheckOutPageUIs.BILLING_ADDRESS_SELECT);
        selectItemInDropDownBy_Text(CheckOutPageUIs.BILLING_ADDRESS_SELECT, valueSelect);
    }

    public String getTextAfter(String shippingMethodTextBefore) {
        int indexText = shippingMethodTextBefore.indexOf("(");
        String textAfter = shippingMethodTextBefore.substring(0,indexText);
        System.out.println("textAfter"+textAfter);
        return textAfter.trim();
    }

    public void clickEditButton() {
        waitForElementClickable(CheckOutPageUIs.EDIT_BUTTON);
        clickToElement(CheckOutPageUIs.EDIT_BUTTON);
    }

}
