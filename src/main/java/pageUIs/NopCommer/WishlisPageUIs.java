package pageUIs.NopCommer;

import commons.BasePage;
import org.openqa.selenium.WebDriver;

public class WishlisPageUIs {
    public final static String TABLE_PRODUCT = "xpath=//table[@class='cart']//tbody";
    public final static String INDEX_PRODUCT = "xpath=//tr";
    public final static String NAME_PRODUCT_LINK_WISHLIST = "xpath=(//tr)[%s]//td[@class='product']/a";
    public final static String SKU_PRODUCT_LINK_WISHLIST = "xpath=(//tr)[%s]//td[@class='sku']/span";
    public final static String PRICE_PRODUCT_LINK_WISHLIST = "xpath=(//tr)[%s]//td[@class='unit-price']/span";
    public final static String LINK_PRODUCT_WISHLIST = "xpath=//div[@class='share-info']/a[@class='share-link']";
    public final static String TITLE_WISHLIST = "xpath=//div[@class='page-title']";
    public final static String CHECKBOX_ADD_TO_CART = "xpath=//tbody//input[@name='addtocart']";
    public final static String ADD_TO_CART_BUTTON = "xpath=//button[@name='addtocartbutton']";
    public final static String REMOVE_PRODUCT_CART = "xpath=//button[@class='remove-btn']";
    public final static String MESSAGE_EMPTY_PRODUCT_CART = "xpath=//div[@class='no-data']";
}
