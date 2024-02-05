package pageObject.NopCommer;

import commons.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import pageUIs.NopCommer.NotebooksPageUIs;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class NotebooksPageObject extends BasePage {
    private WebDriver driver;
    public NotebooksPageObject(WebDriver driver) {
        super(driver);
        this.driver = driver;
    }

    public void selectSortByName(String sortBy) {
        waitForElementClickable(NotebooksPageUIs.SELECT_SORT_BY);
        selectItemInDropDownBy_Text(NotebooksPageUIs.SELECT_SORT_BY, sortBy);
    }

    public boolean isProductSortNameByAscending(String sortBy) {
        waitForElementAllVisible(NotebooksPageUIs.NAME_PRODUCT_TITLE);
        sleep(1);
        List<String> allTitleNameProduct = new ArrayList<>();
        List<String> sortAllTitleNameProduct = new ArrayList<>();
        List<WebElement> listElementsTitleNameProduct = getWebElements(NotebooksPageUIs.NAME_PRODUCT_TITLE);
        for(WebElement element : listElementsTitleNameProduct){
            allTitleNameProduct.add(element.getText());
        }

        for(String element : allTitleNameProduct){
            sortAllTitleNameProduct.add(element);
        }
        Collections.sort(sortAllTitleNameProduct);
        String checkSortDescending = "z to a";

        if(sortBy.toUpperCase().contains(checkSortDescending.toUpperCase())){
            Collections.reverse(sortAllTitleNameProduct);
        }
        return allTitleNameProduct.equals(sortAllTitleNameProduct);
    }

    public boolean isProductSortPriceByAscending(String sortBy) {
        waitForElementAllVisible(NotebooksPageUIs.PRICE_PRODUCT_TITLE);
        sleep(1);

        List<Integer> allTitlePriceProduct = new ArrayList<Integer>();
        List<Integer> sortAllTitlePriceProduct = new ArrayList<Integer>();
        List<WebElement> listElementsTitlePriceProduct = getWebElements(NotebooksPageUIs.PRICE_PRODUCT_TITLE);

        for(WebElement element : listElementsTitlePriceProduct){
            allTitlePriceProduct.add(Integer.parseInt(element.getText().replaceAll("[^0-9]", "")));
        }

        for(Integer element : allTitlePriceProduct){
            sortAllTitlePriceProduct.add(element);
        }

        Collections.sort(sortAllTitlePriceProduct);
        String checkSortDescending = "High to Low";

        if(sortBy.toUpperCase().contains(checkSortDescending.toUpperCase())){
            Collections.reverse(sortAllTitlePriceProduct);
        }

        return allTitlePriceProduct.equals(sortAllTitlePriceProduct);
    }

    public void selectDisplayPage(String displayPage) {
        waitForElementClickable(NotebooksPageUIs.SELECT_DISPLAY_PAGE);
        selectItemInDropDownBy_Text(NotebooksPageUIs.SELECT_DISPLAY_PAGE, displayPage);
    }

    public int displayProduct() {
        sleep(1);
        waitForElementVisible(NotebooksPageUIs.ITEM_PRODUCT);
        return getElementsSize(NotebooksPageUIs.ITEM_PRODUCT);
    }

    public boolean displaySwitchPage(String numberPage, String dynamic) {
        boolean statusIconNextPage = false;
        switch (numberPage){
            case "1":
                statusIconNextPage = isControlDisplayed(NotebooksPageUIs.ICON_SWICTH_PAGE, dynamic);
                break;
            case "2":
                statusIconNextPage = isControlDisplayed(NotebooksPageUIs.ICON_SWICTH_PAGE, dynamic);
                break;
        }

        return statusIconNextPage;
    }

    public void clickNextPage(String dynamic) {
        waitForElementVisible(NotebooksPageUIs.ICON_SWICTH_PAGE, dynamic);
        clickToElement(NotebooksPageUIs.ICON_SWICTH_PAGE, dynamic);
    }

    public boolean unDisplaySwitchPage(String dynamic) {
        return isUnDisplayed(NotebooksPageUIs.ICON_SWICTH_PAGE, dynamic);
    }
}
