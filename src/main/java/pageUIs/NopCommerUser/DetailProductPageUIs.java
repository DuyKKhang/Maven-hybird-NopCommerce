package pageUIs.NopCommerUser;

public class DetailProductPageUIs {
    public final static String ADD_YOUR_REVIEW_LINK = "xpath=//a[text()='Add your review']";
    public final static String NAME_PRODUCT_TITLE = "xpath=//div[@class='product-name']";
    public final static String SKU_PRODUCT = "xpath=//div[@class='sku']/span[@class='value']";
    public final static String PRICE_PRODUCT = "xpath=//div[@class='product-price']/span";
    public final static String RAW_SELECT = "xpath=//select[@id='product_attribute_2']";
    public final static String PROCESSOR_SELECT = "xpath=//select[@id='product_attribute_1']";
    public final static String PROCESSOR_TEXT = "xpath=//select[@id='product_attribute_1']/option[@value='%s']";
    public final static String RAM_SELECT = "xpath=//select[@id='product_attribute_2']/option[@value='%s']";
    public final static String HDD_TEXT = "xpath=(//dd[@id='product_attribute_input_3']//label)[%s]";
    public final static String OS_TEXT = "xpath=(//dd[@id='product_attribute_input_4']//label)[%s]";
    public final static String SOFT_WARE_TEXT = "xpath=(//dd[@id='product_attribute_input_5']//label)[%s]";
    public final static String QUATITY_PRODUCT = "xpath=//div[@class='add-to-cart']//input[@class='qty-input']";
    public final static String HDD_RADIO_BUTTON = "xpath=(//dd[@id='product_attribute_input_3']//input)[%s]";
    public final static String OS_RADIO_BUTTON = "xpath=(//dd[@id='product_attribute_input_4']//input)[%s]";
    public final static String SOFTWARE_CHECKBOX_BUTTON_DYNAMIC = "xpath=(//dd[@id='product_attribute_input_5']//input)[%s]";
    public final static String SOFTWARE_CHECKBOX_BUTTON = "xpath=//dd[@id='product_attribute_input_5']//input";
    public final static String ADD_WISHLIST_BUTTON = "xpath=//div[@class='add-to-wishlist']";
    public final static String ADD_SHOPPING_CART_BUTTON = "css=div[class='add-to-cart'] button[type='button']";
    public final static String MESSAGE_ADD_PRODUCT_SUCCESS = "css=div#bar-notification p.content";
    public final static String CLOSE_MESSAGE_BUTTON = "xpath=//span[@class='close']";
    public final static String NAME_PRODUCT_SHOPPING_CART = "xpath=//div[@class='name']/a";
    public final static String INFORMATION_PRODUCT_SHOPPING_CART = "xpath=//div[@class='item first']//div[@class='attributes']";
    public final static String UNIT_PRICE_PRODUCT_SHOPPING_CART = "xpath=//div[@class='item first']//div[@class='price']/span";
    public final static String QUANTITY_PRODUCT_SHOPPING_CART = "xpath=//div[@class='item first']//div[@class='quantity']/span";
    public final static String SUB_TOTAL_PRODUCT_SHOPPING_CART = "xpath=//div[@class='totals']/strong";
    public final static String ICON_SHOPPING_CART = "xpath=//li[@id='topcartlink']//span[@class='cart-label']";

}
