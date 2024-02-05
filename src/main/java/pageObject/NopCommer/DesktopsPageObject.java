package pageObject.NopCommer;

import commons.BasePage;
import commons.PageGeneratorManager;
import org.openqa.selenium.WebDriver;

public class DesktopsPageObject extends BasePage {
    private WebDriver driver;
    public DesktopsPageObject(WebDriver driver) {
        super(driver);
        this.driver = driver;
    }

    public DetailProductPageObject clickProduct(String indexOrder) {
        return PageGeneratorManager.getDetailProductPageObject(driver);
    }
}
