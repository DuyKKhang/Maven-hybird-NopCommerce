package pageObject.NopCommerUser;

import commons.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import pageUIs.NopCommerUser.AdvencedSearchPageUIs;

import java.util.List;

public class AdvencedSearchPageObject extends BasePage {
    private WebDriver driver;
    public AdvencedSearchPageObject(WebDriver driver) {
        super(driver);
        this.driver = driver;
    }

    public void clickSearchButton() {
        waitForElementClickable(AdvencedSearchPageUIs.SEARCH_BUTTON);
        clickToElement(AdvencedSearchPageUIs.SEARCH_BUTTON);
    }

    public String getMessageError(String dynamic) {
        waitForElementVisible(AdvencedSearchPageUIs.MESSAGE_ERROR,dynamic);
        return getTextElement(AdvencedSearchPageUIs.MESSAGE_ERROR,dynamic);
    }

    public void inputKeyword(String keyWord) {
        waitForElementVisible(AdvencedSearchPageUIs.KEYWORD_TEXTBOX);
        sendkeyToElement(AdvencedSearchPageUIs.KEYWORD_TEXTBOX, keyWord);
    }

    public void clickAdvancedSearch() {
        waitForElementClickable(AdvencedSearchPageUIs.ADVENCED_CHECKBOX);
        checkTheCheckboxOrRadio(AdvencedSearchPageUIs.ADVENCED_CHECKBOX);
    }

    public void selectCategory(String value, String dynamic) {
        waitForElementVisible(AdvencedSearchPageUIs.CATEGORY_MANUFACTURER_SELECT, dynamic);
        selectItemInDropDownBy_Text(AdvencedSearchPageUIs.CATEGORY_MANUFACTURER_SELECT, value, dynamic);
    }

    public void unCheckSubCategories(String dynamic) {
        waitForElementClickable(AdvencedSearchPageUIs.AUTOMATICALLY_SEARCH_CHECKBOX, dynamic);
        uncheckTheCheckboxOrRadio(AdvencedSearchPageUIs.AUTOMATICALLY_SEARCH_CHECKBOX, dynamic);
    }

    public void checkSubCategories(String dynamic) {
        waitForElementClickable(AdvencedSearchPageUIs.AUTOMATICALLY_SEARCH_CHECKBOX, dynamic);
        checkTheCheckboxOrRadio(AdvencedSearchPageUIs.AUTOMATICALLY_SEARCH_CHECKBOX, dynamic);
    }

    public List<WebElement> getNameManyProduct() {
        List<WebElement> elements = getWebElements(AdvencedSearchPageUIs.NAME_PRODUCT);
        return elements;
    }

    public int quantityProduct() {
        waitForElementAllVisible(AdvencedSearchPageUIs.NAME_PRODUCT);
        return getElementsSize(AdvencedSearchPageUIs.NAME_PRODUCT);
    }

    public boolean displayJustOneProduct(String nameProduct) {
        if ( getElementsSize(AdvencedSearchPageUIs.NAME_PRODUCT)==1 && getTextElement(AdvencedSearchPageUIs.NAME_PRODUCT).toUpperCase().contains(nameProduct.toUpperCase())) {
            return true;
        }else {
            return false;
        }
    }
}
