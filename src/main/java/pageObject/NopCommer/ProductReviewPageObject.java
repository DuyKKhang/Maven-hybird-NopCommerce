package pageObject.NopCommer;

import commons.BasePage;
import org.openqa.selenium.WebDriver;
import pageUIs.NopCommer.ProductReviewPageUIs;

public class ProductReviewPageObject extends BasePage {
    private WebDriver driver;
    public ProductReviewPageObject(WebDriver driver) {
        super(driver);
        this.driver = driver;
    }

    public String getTitleProduct() {
        waitForElementVisible(ProductReviewPageUIs.TITLE_PRODUCT_LINK);
        return getTextElement(ProductReviewPageUIs.TITLE_PRODUCT_LINK);
    }

    public void addReviewTitle(String content) {
        waitForElementVisible(ProductReviewPageUIs.TITLE_REVIEW_TEXTBOX);
        sendkeyToElement(ProductReviewPageUIs.TITLE_REVIEW_TEXTBOX, content);
    }

    public void addReviewText(String content) {
        waitForElementVisible(ProductReviewPageUIs.CONTENT_REVIEW_TEXTBOX);
        sendkeyToElement(ProductReviewPageUIs.CONTENT_REVIEW_TEXTBOX, content);
    }

    public void clickRating(String numberRating) {
        waitForElementClickable(ProductReviewPageUIs.RATING_REVIEW_TEXTBOX, numberRating);
        checkTheCheckboxOrRadio(ProductReviewPageUIs.RATING_REVIEW_TEXTBOX, numberRating);
    }

    public void clickSubmitReview() {
        waitForElementClickable(ProductReviewPageUIs.SUBMIT_REVIEW_BUTTON);
        clickToElement(ProductReviewPageUIs.SUBMIT_REVIEW_BUTTON);
    }
}
