package pageObject.NopCommerUser;

import commons.BasePage;
import org.openqa.selenium.WebDriver;
import pageUIs.NopCommerUser.CompareProductsPageUIs;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class CompareProductsPageObject extends BasePage {
    private WebDriver driver;
    public CompareProductsPageObject(WebDriver driver) {
        super(driver);
        this.driver = driver;
    }

    public boolean verifyNameProduct(List<String> nameProduct) {
        int indexName = getElementsSize(CompareProductsPageUIs.NAME_PRODUCT_TITLE_SIZE);
        List<String> listNameProduct = new ArrayList<>();
        for(int i=1; i<= indexName; i++){
            listNameProduct.add(getTextElement(CompareProductsPageUIs.NAME_PRODUCT_TITLE,Integer.toString(i)));
        }

        Collections.sort(nameProduct);
        return listNameProduct.equals(nameProduct);
    }

    public boolean verifyPriceProduct(List<String> priceProduct) {
        int indexPrice = getElementsSize(CompareProductsPageUIs.PRICE_PRODUCT_TITLE_SIZE);
        List<String> listPriceProduct = new ArrayList<>();
        for(int i=1; i<= indexPrice; i++){
            listPriceProduct.add(getTextElement(CompareProductsPageUIs.PRICE_PRODUCT_TITLE,Integer.toString(i+1)));
        }

        Collections.sort(listPriceProduct);
        return listPriceProduct.equals(priceProduct);
    }

    public void clickClearListCompare() {
        waitForElementClickable(CompareProductsPageUIs.CLEAR_BUTTON);
        clickToElement(CompareProductsPageUIs.CLEAR_BUTTON);
    }

    public String getMessageComparePageHadEmpty() {
        waitForElementVisible(CompareProductsPageUIs.MESSAGE_NO_ITEMS);
        return getTextElement(CompareProductsPageUIs.MESSAGE_NO_ITEMS);
    }

    public boolean isDisplayComparePage() {
        return isUnDisplayed(CompareProductsPageUIs.TABLE_DATA);
    }
}
