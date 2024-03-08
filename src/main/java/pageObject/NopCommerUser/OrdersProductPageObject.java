package pageObject.NopCommerUser;

import commons.BasePage;
import commons.PageGeneratorManagerUser;
import org.openqa.selenium.WebDriver;
import pageUIs.NopCommerUser.OrdersProductPageUIs;

public class OrdersProductPageObject extends BasePage {
    private WebDriver driver;
    public OrdersProductPageObject(WebDriver driver) {
        super(driver);
        this.driver = driver;
    }

    public String getOrderNumberMyAccount() {
        waitForElementVisible(OrdersProductPageUIs.ORDER_BUTTON_MY_ACCOUNT);
        return getTextElement(OrdersProductPageUIs.ORDER_BUTTON_MY_ACCOUNT).toLowerCase();
    }

    public void clickDetails() {
        waitForElementClickable(OrdersProductPageUIs.DETAILS_BUTTON);
        clickToElementByJS(OrdersProductPageUIs.DETAILS_BUTTON);
    }

    public String getOrderStatus() {
        waitForElementVisible(OrdersProductPageUIs.ORDER_STATUS_TEXT);
        return getTextElement(OrdersProductPageUIs.ORDER_STATUS_TEXT);
    }

    public String getOrderTotal() {
        waitForElementVisible(OrdersProductPageUIs.ORDER_TOTAL_TEXT);
        return getTextElement(OrdersProductPageUIs.ORDER_TOTAL_TEXT);
    }

    public String getInformationBillingAddress(String dynamicValue) {
        waitForElementVisible(OrdersProductPageUIs.BILLING_ADDRESS_TEXT, dynamicValue);
        return getTextElement(OrdersProductPageUIs.BILLING_ADDRESS_TEXT, dynamicValue);
    }

    public String getPayMentOrder() {
        waitForElementVisible(OrdersProductPageUIs.PAYMENT_METHOD_TEXT);
        return getTextElement(OrdersProductPageUIs.PAYMENT_METHOD_TEXT);
    }

    public String getPayMentStatusOrder() {
        waitForElementVisible(OrdersProductPageUIs.PAYMENT_METHOD_STATUS_TEXT);
        return getTextElement(OrdersProductPageUIs.PAYMENT_METHOD_STATUS_TEXT);
    }

    public String getInformationShippingAddress(String dynamicValue) {
        waitForElementVisible(OrdersProductPageUIs.SHIPPING_ADDRESS_TEXT, dynamicValue);
        return getTextElement(OrdersProductPageUIs.SHIPPING_ADDRESS_TEXT, dynamicValue);
    }

    public String getShippingOrder() {
        waitForElementVisible(OrdersProductPageUIs.SHIPPING_METHOD_TEXT);
        return getTextElement(OrdersProductPageUIs.SHIPPING_METHOD_TEXT);
    }

    public String getShippingStatusOrder() {
        waitForElementVisible(OrdersProductPageUIs.SHIPPING_METHOD_STATUS_TEXT);
        return getTextElement(OrdersProductPageUIs.SHIPPING_METHOD_STATUS_TEXT);
    }

    public String getInformationOrderDetails(String dynamic) {
        waitForElementVisible(OrdersProductPageUIs.INFROMATION_PRODUCT_ORDER_DETAILS,dynamic);
        return getTextElement(OrdersProductPageUIs.INFROMATION_PRODUCT_ORDER_DETAILS,dynamic);
    }

    public String getNameInformationOrderDetails() {
        waitForElementVisible(OrdersProductPageUIs.NAME_INFROMATION_PRODUCT_ORDER_DETAILS);
        return getTextElement(OrdersProductPageUIs.NAME_INFROMATION_PRODUCT_ORDER_DETAILS);
    }

    public String getGiftWrappingOrderDetails() {
        waitForElementVisible(OrdersProductPageUIs.GIFT_WRAPPING_TEXT);
        return getTextElement(OrdersProductPageUIs.GIFT_WRAPPING_TEXT);
    }

    public String getOrderTotalDetails() {
        waitForElementVisible(OrdersProductPageUIs.ORDER_TOTAL);
        return getTextElement(OrdersProductPageUIs.ORDER_TOTAL);
    }

    public ShoppingCartPageObject clickreOrder() {
        waitForElementClickable(OrdersProductPageUIs.REORDER_BUTTON);
        clickToElementByJS(OrdersProductPageUIs.REORDER_BUTTON);
        return PageGeneratorManagerUser.getShoppingCartPageObject(driver);
    }
}
