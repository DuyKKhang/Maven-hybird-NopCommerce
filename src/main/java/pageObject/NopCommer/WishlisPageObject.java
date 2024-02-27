package pageObject.NopCommer;

import commons.BasePage;
import commons.PageGeneratorManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import pageUIs.NopCommer.WishlisPageUIs;

import java.util.List;

public class WishlisPageObject extends BasePage {
    private WebDriver driver;
    public WishlisPageObject(WebDriver driver) {
        super(driver);
        this.driver = driver;
    }

    public boolean verifyProductWishlistPage() {
        return isUnDisplayed(WishlisPageUIs.TABLE_PRODUCT);
    }
    private String indexProductInWishlist(){
        waitForElementVisible(WishlisPageUIs.INDEX_PRODUCT);
        return Integer.toString(getElementsSize(WishlisPageUIs.INDEX_PRODUCT));
    }
    public String getDetailNameProduct() {
        waitForElementVisible(WishlisPageUIs.NAME_PRODUCT_LINK_WISHLIST, indexProductInWishlist());
        return getTextElement(WishlisPageUIs.NAME_PRODUCT_LINK_WISHLIST, indexProductInWishlist());
    }

    public String getDetailSkuProduct() {
        waitForElementVisible(WishlisPageUIs.SKU_PRODUCT_LINK_WISHLIST, indexProductInWishlist());
        return getTextElement(WishlisPageUIs.SKU_PRODUCT_LINK_WISHLIST, indexProductInWishlist());
    }

    public String getDetailPriceProduct() {
        waitForElementVisible(WishlisPageUIs.PRICE_PRODUCT_LINK_WISHLIST, indexProductInWishlist());
        return getTextElement(WishlisPageUIs.PRICE_PRODUCT_LINK_WISHLIST, indexProductInWishlist());
    }

    public void clickLinkWishlistSharing() {
        waitForElementVisible(WishlisPageUIs.LINK_PRODUCT_WISHLIST);
        clickToElement(WishlisPageUIs.LINK_PRODUCT_WISHLIST);
    }

    public String getTitleWishlistSharing() {
        waitForElementVisible(WishlisPageUIs.TITLE_WISHLIST);
        return getTextElement(WishlisPageUIs.TITLE_WISHLIST);
    }

    public void checkBoxAddToCart() {
        waitForElementClickable(WishlisPageUIs.CHECKBOX_ADD_TO_CART);
        checkTheCheckboxOrRadio(WishlisPageUIs.CHECKBOX_ADD_TO_CART);
    }

    public ShoppingCartPageObject clickAddToCart() {
        waitForElementClickable(WishlisPageUIs.ADD_TO_CART_BUTTON);
        clickToElement(WishlisPageUIs.ADD_TO_CART_BUTTON);
        return PageGeneratorManager.getShoppingCartPageObject(driver);
    }

    public void clickRemoveProduct() {
        waitForElementClickable(WishlisPageUIs.REMOVE_PRODUCT_CART);
        clickToElement(WishlisPageUIs.REMOVE_PRODUCT_CART);
    }

    public String getTextMessageWishlistNull() {
        waitForElementVisible(WishlisPageUIs.MESSAGE_EMPTY_PRODUCT_CART);
        return getTextElement(WishlisPageUIs.MESSAGE_EMPTY_PRODUCT_CART);
    }
}
