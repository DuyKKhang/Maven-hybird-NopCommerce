package pageUIs.NopCommer;

public class ShoppingCartPageUIs {
    public final static String TABLE_PRODUCT_CART = "xpath=//div[@class='table-wrapper']//tbody/tr";
    public final static String EDIT_LINK = "xpath=//div[@class='edit-item']/a";
    public final static String REMOVE_PRODUCT = "css=form[id='shopping-cart-form'] table[class='cart'] tbody td[class='remove-from-cart'] button[class='remove-btn']";
    public final static String MESSAGE_NO_DATA = "xpath=//div[@class='order-summary-content']//div[@class='no-data']";
    public final static String QUANTITY = "xpath=//td[@class='quantity']//input[@class='qty-input']";
    public final static String UPDATE_SHOPPING_CART = "xpath=//div[@class='common-buttons']//button[@id='updatecart']";
    public final static String TOTAL_PRODUCT_SHOPPING_CART = "xpath=//td[@class='subtotal']//span[@class='product-subtotal']";
    public final static String CHECK_BOX_TERMS_OF_SERVICE = "xpath=//input[@id='termsofservice']";
    public final static String CHECK_OUT_BUTTON = "xpath=//div[@class='checkout-buttons']//button[@id='checkout']";
    public final static String GIFT_WRAPPING_SELECT = "xpath=//select[@name='checkout_attribute_1']/option[@value='1']";

}
