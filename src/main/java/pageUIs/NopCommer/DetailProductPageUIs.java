package pageUIs.NopCommer;

import commons.BasePage;
import org.openqa.selenium.WebDriver;

public class DetailProductPageUIs {
    public final static String ADD_YOUR_REVIEW_LINK = "xpath=//a[text()='Add your review']";
    public final static String NAME_PRODUCT_TITLE = "xpath=//div[@class='product-name']";
    public final static String SKU_PRODUCT = "xpath=//div[@class='sku']/span[@id='sku-1']";
    public final static String PRICE_PRODUCT = "xpath=//div[@class='product-price']/span";
    public final static String RAW_SELECT = "xpath=//select[@id='product_attribute_2']";
    public final static String HDD_RADIO_BUTTON = "xpath=//input[@id='product_attribute_3_6']";
    public final static String ADD_WISHLIST_BUTTON = "xpath=//div[@class='add-to-wishlist']";
    public final static String MESSAGE_ADD_WISHLIST_SUCCESS = "xpath=//p[@class='content']";
    public final static String CLOSE_MESSAGE_BUTTON = "xpath=//span[@class='close']";
}
