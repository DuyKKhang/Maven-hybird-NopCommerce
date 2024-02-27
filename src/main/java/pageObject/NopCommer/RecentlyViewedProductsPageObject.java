package pageObject.NopCommer;

import commons.BasePage;
import org.openqa.selenium.WebDriver;
import pageUIs.NopCommer.RecentlyViewedProductsPageUIs;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class RecentlyViewedProductsPageObject extends BasePage {
    private WebDriver driver;
    public RecentlyViewedProductsPageObject(WebDriver driver) {
        super(driver);
        this.driver = driver;
    }

    public boolean verifyNameProduct(List<String> nameProduct) {
        int sizeListItems= getElementsSize(RecentlyViewedProductsPageUIs.NAME_PRODUCT_RECENTLY_SIZE);
        List<String> nameProductList = new ArrayList<>();
        for (int i=1; i<=sizeListItems;i++){
             nameProductList.add(getTextElement(RecentlyViewedProductsPageUIs.NAME_PRODUCT_RECENTLY, Integer.toString(i)));
        }

        Collections.reverse(nameProductList);
        return nameProductList.equals(nameProduct);
    }

    public boolean verifyPriceProduct(List<String> priceProduct) {
        int sizeListItems= getElementsSize(RecentlyViewedProductsPageUIs.PRICE_PRODUCT_RECENTLY_SIZE);
        List<String> nameProductList = new ArrayList<>();
        for (int i=1; i<=sizeListItems;i++){
            nameProductList.add(getTextElement(RecentlyViewedProductsPageUIs.PRICE_PRODUCT_RECENTLY, Integer.toString(i)));
        }

        Collections.reverse(nameProductList);
        return nameProductList.equals(priceProduct);
    }
}
