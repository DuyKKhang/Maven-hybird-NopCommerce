package pageUIs.NopCommer;

import commons.BasePage;
import org.openqa.selenium.WebDriver;

public class CheckOutPageUIs {
    public final static String INFORMATION_BILING_ADDRESS = "xpath=//input[@name='BillingNewAddress.%s']";
    public final static String SELECT_COUNTRY_INFORMATION_BILING_ADDRESS = "xpath=//select[@name='BillingNewAddress.CountryId']";
    public final static String CONTINUE_BUTTON_BILLING_ADDRESS = "xpath=//div[@id='billing-buttons-container']//button[@name='save']";
    public final static String CONTINUE_BUTTON_SHIPPING_METHED = "xpath=//div[@id='shipping-method-buttons-container']//button";
    public final static String CONTINUE_BUTTON_PAYMENT_METHOD = "xpath=//div[@id='payment-method-buttons-container']//button";
    public final static String CONTINUE_BUTTON_PAYMENT_INFORMATION = "xpath=//div[@id='payment-info-buttons-container']//button";
    public final static String CONTINUE_BUTTON_CONFIRM = "xpath=//div[@id='confirm-order-buttons-container']//button";
    public final static String CONTINUE_ORDER_BUTTON = "xpath=//div[@class='buttons']//button[@type='button']";
    public final static String SHIP_TO_SAME_CHECKBOX = "xpath=//input[@id='ShipToSameAddress']";
    public final static String ORDER_NUMBER_CHECKBOX = "xpath=//div[@class='section order-completed']//div[@class='order-number']/strong";
    public final static String SHIPPING_MENTHOD = "xpath=(//div[@class='method-name']//input[@name='shippingoption'])[%s]";
    public final static String PAYMENT_METHOD = "xpath=(//div[@class='payment-details']//input[@name='paymentmethod'])[%s]";
    public final static String MEESSAGE_PAYMEND = "xpath=(//div[@class='info']//p)[4]";
    public final static String BILLING_ADDRESS_TEXT = "xpath=//div[@class='billing-info-wrap']//ul[@class='info-list']//li[@class='%s']";
    public final static String SHIPPING_ADDRESS_TEXT = "xpath=//div[@class='shipping-info-wrap']//ul[@class='info-list']//li[@class='%s']";
    public final static String SHIPPING_METHOD_TEXT = "xpath=//div[@class='method-name']//label[@for='shippingoption_0']";
    public final static String PAYMENT_METHOD_TEXT = "xpath=(//div[@class='payment-details']//label)[%s]";
    public final static String PRODUCT_INFORMATION_TEXT = "xpath=//div[@class='table-wrapper']//span[@class='%s']";
    public final static String NAME_PRODUCT_INFORMATION_TEXT = "xpath=//div[@class='table-wrapper']//a[@class='product-name']";
    public final static String GIFT_WRAPPING_TEXT = "xpath=//div[@class='cart-options']//div[@class='selected-checkout-attributes']";
    public final static String TOTAL_CONFIRM = "xpath=//div[@class='cart-footer']//strong";
    public final static String CREDIT_CARD_SELECT_DROPDOWN = "xpath=//select[@id='%s']";
    public final static String CREDIT_CARD_INPUT_TEXTBOX = "xpath=//input[@id='%s']";
    public final static String BILLING_ADDRESS_SELECT = "xpath=//select[@id='billing-address-select']";
    public final static String MESSAGE_CONFIRM = "css=div[class='section order-completed'] div[class='title'] strong";
    public final static String EDIT_BUTTON = "css=div#billing-buttons-container button#edit-billing-address-button";

}
