package pageObject.NopCommerUser;

import commons.BasePage;
import commons.PageGeneratorManagerUser;
import org.openqa.selenium.WebDriver;
import pageUIs.NopCommerUser.ShoppingCartPageUIs;

public class ShoppingCartPageObject extends BasePage {
    private WebDriver driver;
    public ShoppingCartPageObject(WebDriver driver) {
        super(driver);
        this.driver = driver;
    }

    public int verifyProductShoppingCartPage() {
        waitForElementVisible(ShoppingCartPageUIs.TABLE_PRODUCT_CART);
        return getElementsSize(ShoppingCartPageUIs.TABLE_PRODUCT_CART);
    }

    public DetailProductPageObject clickEditProduct() {
        waitForElementClickable(ShoppingCartPageUIs.EDIT_LINK);
        clickToElementByJS(ShoppingCartPageUIs.EDIT_LINK);
        return PageGeneratorManagerUser.getDetailProductPageObject(driver);
    }

    public void removeProduct() {
        waitForElementVisible(ShoppingCartPageUIs.REMOVE_PRODUCT);
        clickToElement(ShoppingCartPageUIs.REMOVE_PRODUCT);
    }

    public String getMessageRemoveProduct() {
        waitForElementVisible(ShoppingCartPageUIs.MESSAGE_NO_DATA);
        return getTextElement(ShoppingCartPageUIs.MESSAGE_NO_DATA);
    }

    public boolean isUnDisplayed() {
        return isUnDisplayed(ShoppingCartPageUIs.TABLE_PRODUCT_CART);
    }

    public void changeQuantity(String number) {
        waitForElementVisible(ShoppingCartPageUIs.QUANTITY);
        sendkeyToElementByJS(ShoppingCartPageUIs.QUANTITY, number);
    }

    public void clickUpdate() {
        waitForElementVisible(ShoppingCartPageUIs.UPDATE_SHOPPING_CART);
        clickToElement(ShoppingCartPageUIs.UPDATE_SHOPPING_CART);
    }

    public String getTotal() {
        waitForElementVisible(ShoppingCartPageUIs.TOTAL_PRODUCT_SHOPPING_CART);
        return getTextElement(ShoppingCartPageUIs.TOTAL_PRODUCT_SHOPPING_CART);
    }

    public void clickTermsOfService() {
        waitForElementClickable(ShoppingCartPageUIs.CHECK_BOX_TERMS_OF_SERVICE);
        checkTheCheckboxOrRadio(ShoppingCartPageUIs.CHECK_BOX_TERMS_OF_SERVICE);
    }

    public CheckOutPageObject clickCheckOut() {
        waitForElementClickable(ShoppingCartPageUIs.CHECK_OUT_BUTTON);
        clickToElement(ShoppingCartPageUIs.CHECK_OUT_BUTTON);
        return PageGeneratorManagerUser.getCheckOutPageObject(driver);
    }

    public String getGiftWrappingProduct() {
        waitForElementVisible(ShoppingCartPageUIs.GIFT_WRAPPING_SELECT);
        return getTextElement(ShoppingCartPageUIs.GIFT_WRAPPING_SELECT);
    }

}
