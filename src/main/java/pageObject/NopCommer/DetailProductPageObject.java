package pageObject.NopCommer;

import commons.BasePage;
import commons.PageGeneratorManager;
import org.openqa.selenium.WebDriver;
import pageUIs.NopCommer.DetailProductPageUIs;

public class DetailProductPageObject extends BasePage {
    private WebDriver driver;
    public DetailProductPageObject(WebDriver driver) {
        super(driver);
        this.driver = driver;
    }

    public ProductReviewPageObject clickAddYourReview() {
        waitForElementClickable(DetailProductPageUIs.ADD_YOUR_REVIEW_LINK);
        clickToElement(DetailProductPageUIs.ADD_YOUR_REVIEW_LINK);
        return PageGeneratorManager.getProductReviewPageObject(driver);
    }
}
