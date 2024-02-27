package pageObject.NopCommer;

import commons.BasePage;
import commons.PageGeneratorManager;
import org.openqa.selenium.WebDriver;
import pageUIs.NopCommer.DesktopsProductPageUIs;

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
        return PageGeneratorManager.getDetailProductPageObject(driver);
    }
}
