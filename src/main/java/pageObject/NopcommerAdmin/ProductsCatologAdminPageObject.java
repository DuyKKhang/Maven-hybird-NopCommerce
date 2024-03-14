package pageObject.NopcommerAdmin;

import commons.BasePage;
import org.openqa.selenium.WebDriver;
import pageUIs.NopcommerAdmin.ProductsCatologAdminPageUIs;

public class ProductsCatologAdminPageObject extends BasePage {
    private WebDriver driver;
    public ProductsCatologAdminPageObject(WebDriver driver) {
        super(driver);
        this.driver = driver;
    }


    public void searchProduct(String value, String dynamic) {
        waitForElementVisible(ProductsCatologAdminPageUIs.SEARCH_TEXTBOX, dynamic);
        sendkeyToElement(ProductsCatologAdminPageUIs.SEARCH_TEXTBOX,value, dynamic);
    }

    public void clickSearch() {
        waitForElementClickable(ProductsCatologAdminPageUIs.SEARCH_BUTTON);
        clickToElement(ProductsCatologAdminPageUIs.SEARCH_BUTTON);
        sleep(2);
    }

    public String getInformationProducts(String dynamic) {
        sleep(1);
        scrollToElement(ProductsCatologAdminPageUIs.INFORMATION_PRODUCT_TEXTBOX, dynamic);
        waitForElementVisible(ProductsCatologAdminPageUIs.INFORMATION_PRODUCT_TEXTBOX, dynamic);
        return getTextElement(ProductsCatologAdminPageUIs.INFORMATION_PRODUCT_TEXTBOX, dynamic);
    }

    public int getSizeElement() {
        waitForElementVisible(ProductsCatologAdminPageUIs.ITEM_PRODUCT_TABLE);
        return getElementsSize(ProductsCatologAdminPageUIs.ITEM_PRODUCT_TABLE);
    }

    public void selectCategory(String value, String dynamic) {
        waitForElementVisible(ProductsCatologAdminPageUIs.CATEGORY_SELECT,dynamic);
        selectItemInDropDownBy_Text(ProductsCatologAdminPageUIs.CATEGORY_SELECT, value, dynamic);
    }

    public void clickCheckBoxSearchSubcategories() {
        waitForElementVisible(ProductsCatologAdminPageUIs.SEARCH_SUBCATEGORIES_CHECKBOX);
        checkTheCheckboxOrRadio(ProductsCatologAdminPageUIs.SEARCH_SUBCATEGORIES_CHECKBOX);
    }

    public String getMessageNodata() {
        waitForElementVisible(ProductsCatologAdminPageUIs.MESSAGE_NO_DATA);
        return getTextElement(ProductsCatologAdminPageUIs.MESSAGE_NO_DATA);
    }

    public void clickUnCheckBoxSearchSubcategories() {
        waitForElementVisible(ProductsCatologAdminPageUIs.SEARCH_SUBCATEGORIES_CHECKBOX);
        uncheckTheCheckboxOrRadio(ProductsCatologAdminPageUIs.SEARCH_SUBCATEGORIES_CHECKBOX);
    }

    public void clickGoDirectly() {
        waitForElementClickable(ProductsCatologAdminPageUIs.GO_BUTTON);
        clickToElement(ProductsCatologAdminPageUIs.GO_BUTTON);
    }

    public String getTitleDirectly() {
        waitForElementVisible(ProductsCatologAdminPageUIs.DETAILS_TITLE);
        return getTextElement(ProductsCatologAdminPageUIs.DETAILS_TITLE);
    }

    public String getInfoProductDetails(String dynamic, String valueAttribute) {
        waitForElementVisible(ProductsCatologAdminPageUIs.INFORMATION_PRODUCT_INPUT, dynamic);
        return getAttrabuteValue(ProductsCatologAdminPageUIs.INFORMATION_PRODUCT_INPUT,valueAttribute,dynamic);
    }

    public void clickSearchPorduct(String properties, String value) {
        waitForElementVisible(ProductsCatologAdminPageUIs.SEARCH_TITLE);
        setPropertiesToElementByJS(ProductsCatologAdminPageUIs.SEARCH_TITLE,properties, value);
    }

    public void openProductInfo(String properties, String value) {
        waitForElementVisible(ProductsCatologAdminPageUIs.PRODUCT_INFO_PROPERTIES);
        setPropertiesToElementByJS(ProductsCatologAdminPageUIs.PRODUCT_INFO_PROPERTIES, properties, value);
    }

    public void clockOpenProductInfo() {
        waitForElementVisible(ProductsCatologAdminPageUIs.OPEN_PRODUCT_INFO_PROPERTIES);
        sleep(2);
        boolean statusInfo = isUnDisplayed(ProductsCatologAdminPageUIs.PRODUCT_INFO_PROPERTIES);
        if(statusInfo){
            clickToElement(ProductsCatologAdminPageUIs.OPEN_PRODUCT_INFO_PROPERTIES);
        }
    }
}
