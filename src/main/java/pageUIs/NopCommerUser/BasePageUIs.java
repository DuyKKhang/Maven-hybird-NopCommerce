package pageUIs.NopCommerUser;

public class BasePageUIs {
    public final static String CUSTOMER_INFO_LINK ="xpath=//li[@class='customer-info inactive']/a";
    public final static String ADDRESSES_LINK ="xpath=//li[@class='customer-addresses inactive']/a";
    public final static String CHANGE_PASSWORD_LINK ="xpath=//li[@class='change-password inactive']/a";
    public final static String MY_PRODUCT_REVIEWS_LINK ="xpath=//li[@class='customer-reviews inactive']/a";
    public final static String ORDERS_LINK ="xpath=//li[@class='customer-orders inactive']/a";
    public final static String LOG_OUT_LINK ="xpath=//a[@class='ico-logout']";
    public final static String MY_ACCOUNT_LINK = "xpath=//a[@class='ico-account']";
    public final static String WISHLIST_LINK = "xpath=//a[@class='ico-wishlist']";
    public final static String SHOPPING_CART_LINK = "xpath=//a[@class='ico-cart']";
    public final static String HOME_PAGE_LINK = "xpath=//div[@class='header-logo']//img[contains(@src,'https://demo.nopcommerce.com')]";
    public final static String DYNAMIC_LINK_MENU_PRODUCT = "xpath=//ul[@class='top-menu notmobile']//a[contains(text(),'%s')]";
    public final static String MENU_CATALOG_ADMIN = "xpath=//li[@class='nav-item has-treeview']/a//p[contains(text(),'%s')]";
    public final static String PRODUCTS_MENU_CATALOG_ADMIN_LINK = "xpath=//a[contains(@href,'/Admin/%s/List') and @class='nav-link']";
    public final static String DASH_BOARD_LINK = "xpath=//img[@class='brand-image-xl logo-xl']";
}
