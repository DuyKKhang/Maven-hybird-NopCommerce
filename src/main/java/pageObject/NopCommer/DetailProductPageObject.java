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

    public String getNameProduct() {
        waitForElementVisible(DetailProductPageUIs.NAME_PRODUCT_TITLE);
        return getTextElement(DetailProductPageUIs.NAME_PRODUCT_TITLE);
    }

    public String getSkuProduct() {
        waitForElementVisible(DetailProductPageUIs.SKU_PRODUCT);
        return getTextElement(DetailProductPageUIs.SKU_PRODUCT);
    }

    public String getPriceProduct() {
        waitForElementVisible(DetailProductPageUIs.PRICE_PRODUCT);
        return getTextElement(DetailProductPageUIs.PRICE_PRODUCT);
    }

    public void selectRamDropdown(String valueSelect) {
        waitForElementVisible(DetailProductPageUIs.RAW_SELECT);
        selectItemInDropDownBy_Text(DetailProductPageUIs.RAW_SELECT, valueSelect);
    }

    public void clickHDDRadioButton() {
        waitForElementClickable(DetailProductPageUIs.HDD_RADIO_BUTTON);
        checkTheCheckboxOrRadio(DetailProductPageUIs.HDD_RADIO_BUTTON);
    }
    public void addToWishList() {
        waitForElementClickable(DetailProductPageUIs.ADD_WISHLIST_BUTTON);
        clickToElement(DetailProductPageUIs.ADD_WISHLIST_BUTTON);
    }

    public Object getMessageAddWsihList() {
        waitForElementVisible(DetailProductPageUIs.MESSAGE_ADD_WISHLIST_SUCCESS);
        return getTextElement(DetailProductPageUIs.MESSAGE_ADD_WISHLIST_SUCCESS);

    }

    public void closeMessage() {
        waitForElementVisible(DetailProductPageUIs.CLOSE_MESSAGE_BUTTON);
        clickToElementByJS(DetailProductPageUIs.CLOSE_MESSAGE_BUTTON);
    }


    public HomePageObject backPreviousPage() {
        backToPage();
        return PageGeneratorManager.getHomePageObject(driver);
    }
}
