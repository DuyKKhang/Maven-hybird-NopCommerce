package pageObject.NopCommerUser;

import commons.BasePage;
import commons.PageGeneratorManagerUser;
import org.openqa.selenium.WebDriver;
import pageUIs.NopCommerUser.DesktopsProductPageUIs;

public class DesktopsProductPageObject extends BasePage {
    private WebDriver driver;
    public DesktopsProductPageObject(WebDriver driver) {
        super(driver);
        this.driver = driver;
    }

    public DetailProductPageObject clickProduct(String indexOrder) {
        waitForElementVisible(DesktopsProductPageUIs.LINK_TITLE_PRODUCT, indexOrder);
        clickToElementByJS(DesktopsProductPageUIs.LINK_TITLE_PRODUCT, indexOrder);
        sleep(2);
        return PageGeneratorManagerUser.getDetailProductPageObject(driver);
    }
}
