package pageObject.NopCommer;

import commons.BasePage;
import org.openqa.selenium.WebDriver;
import pageUIs.NopCommer.ShoppingCartPageUIs;

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
}
