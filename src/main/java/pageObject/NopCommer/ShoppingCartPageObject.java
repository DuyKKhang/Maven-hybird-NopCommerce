package pageObject.NopCommer;

import commons.BasePage;
import org.openqa.selenium.WebDriver;

public class ShoppingCartPageObject extends BasePage {
    private WebDriver driver;
    public ShoppingCartPageObject(WebDriver driver) {
        super(driver);
        this.driver = driver;
    }
}
