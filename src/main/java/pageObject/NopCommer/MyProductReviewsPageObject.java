package pageObject.NopCommer;

import commons.BasePage;
import org.openqa.selenium.WebDriver;
import pageUIs.NopCommer.MyProductReviewsPageUIs;

public class MyProductReviewsPageObject extends BasePage {
    private WebDriver driver;
    public MyProductReviewsPageObject(WebDriver driver) {
        super(driver);
        this.driver = driver;
    }

    public String getTextTitleReview() {
        waitForElementVisible(MyProductReviewsPageUIs.TITLE_REVIEW_MY_PRODUCT_REVIEW);
        return getTextElement(MyProductReviewsPageUIs.TITLE_REVIEW_MY_PRODUCT_REVIEW);
    }

    public String getTextContentReview() {
        waitForElementVisible(MyProductReviewsPageUIs.CONTENT_REVIEW_MY_PRODUCT_REVIEW);
        return getTextElement(MyProductReviewsPageUIs.CONTENT_REVIEW_MY_PRODUCT_REVIEW);
    }

    public String getRatingValue(String valueAttrabute) {
        waitForElementVisible(MyProductReviewsPageUIs.RATING_REVIEW_MY_PRODUCT_REVIEW);
        return getAttrabuteValue(MyProductReviewsPageUIs.RATING_REVIEW_MY_PRODUCT_REVIEW,valueAttrabute);
    }
}
