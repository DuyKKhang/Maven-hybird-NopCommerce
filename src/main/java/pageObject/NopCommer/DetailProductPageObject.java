package pageObject.NopCommer;

import commons.BasePage;
import commons.PageGeneratorManager;
import org.openqa.selenium.WebDriver;
import pageUIs.NopCommer.DetailProductPageUIs;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

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

    public void clickHDDRadioButton(String indexItems) {
        waitForElementClickable(DetailProductPageUIs.HDD_RADIO_BUTTON, indexItems);
        checkTheCheckboxOrRadio(DetailProductPageUIs.HDD_RADIO_BUTTON, indexItems);
    }
    public void addToWishList() {
        waitForElementClickable(DetailProductPageUIs.ADD_WISHLIST_BUTTON);
        clickToElement(DetailProductPageUIs.ADD_WISHLIST_BUTTON);
    }

    public String getMessageAddProduct() {
        waitForElementVisible(DetailProductPageUIs.MESSAGE_ADD_PRODUCT_SUCCESS);
        return getTextElement(DetailProductPageUIs.MESSAGE_ADD_PRODUCT_SUCCESS);

    }

    public void closeMessage() {
        waitForElementVisible(DetailProductPageUIs.CLOSE_MESSAGE_BUTTON);
        clickToElementByJS(DetailProductPageUIs.CLOSE_MESSAGE_BUTTON);
    }

    public void selectProcessor(String indexItems) {
        waitForElementVisible(DetailProductPageUIs.PROCESSOR_SELECT);
        selectItemInDropDownBy_Values(DetailProductPageUIs.PROCESSOR_SELECT, indexItems);
    }

    public HomePageObject backPreviousPage() {
        backToPage();
        return PageGeneratorManager.getHomePageObject(driver);
    }

    public void clickOS(String indexItems) {
        waitForElementClickable(DetailProductPageUIs.OS_RADIO_BUTTON, indexItems);
        checkTheCheckboxOrRadio(DetailProductPageUIs.OS_RADIO_BUTTON, indexItems);
    }

    public void clickSoftWare() {
        waitForElementClickable(DetailProductPageUIs.SOFTWARE_CHECKBOX_BUTTON);
        checkTheCheckboxOrRadio(DetailProductPageUIs.SOFTWARE_CHECKBOX_BUTTON);
    }
    public void clickSoftWare(String indexItems) {
        waitForElementClickable(DetailProductPageUIs.SOFTWARE_CHECKBOX_BUTTON_DYNAMIC, indexItems);
        checkTheCheckboxOrRadio(DetailProductPageUIs.SOFTWARE_CHECKBOX_BUTTON_DYNAMIC, indexItems);
    }

    public void clickAddToCart() {
        waitForElementClickable(DetailProductPageUIs.ADD_SHOPPING_CART_BUTTON);
        clickToElementByJS(DetailProductPageUIs.ADD_SHOPPING_CART_BUTTON);
    }

    public String getProcessor(String indexItems) {
        waitForElementVisible(DetailProductPageUIs.PROCESSOR_SELECT, indexItems);
        return "Processor: "+ getTextElement(DetailProductPageUIs.PROCESSOR_TEXT, indexItems);

    }

    public String getRam(String indexItems) {
        waitForElementVisible(DetailProductPageUIs.RAM_SELECT, indexItems);
        return "RAM: "+getTextElement(DetailProductPageUIs.RAM_SELECT, indexItems);
    }

    public String getHDD(String indexItems) {
        waitForElementVisible(DetailProductPageUIs.HDD_TEXT, indexItems);
        return "HDD: "+getTextElement(DetailProductPageUIs.HDD_TEXT, indexItems);
    }

    public String getOS(String indexItems) {
        waitForElementVisible(DetailProductPageUIs.OS_TEXT, indexItems);
        return "OS: "+getTextElement(DetailProductPageUIs.OS_TEXT, indexItems);
    }

    public List<String> getSoftWare(String indexItems) {
        List<String> softWareTest = new ArrayList<>();
        for (int i = 1; i <= Integer.parseInt(indexItems); i++) {
            softWareTest.add("Software: "+getTextElement(DetailProductPageUIs.SOFT_WARE_TEXT,Integer.toString(i)).trim()+"\n");
        }
        return softWareTest;
    }

    public String getQuantity(String value) {
        scrollToElement(DetailProductPageUIs.ADD_SHOPPING_CART_BUTTON);
        return getElementAttribute(DetailProductPageUIs.QUATITY_PRODUCT, value);
    }

    public String getNameProductShoppingCart() {
        waitForElementVisible(DetailProductPageUIs.NAME_PRODUCT_SHOPPING_CART );
        return getTextElement(DetailProductPageUIs.NAME_PRODUCT_SHOPPING_CART );
    }

    public String getInformationShoppingCart() {
        waitForElementVisible(DetailProductPageUIs.INFORMATION_PRODUCT_SHOPPING_CART );
        return getTextElement(DetailProductPageUIs.INFORMATION_PRODUCT_SHOPPING_CART );
    }

    public String getUnitPriceShoppingCart() {
        waitForElementVisible(DetailProductPageUIs.UNIT_PRICE_PRODUCT_SHOPPING_CART );
        return getTextElement(DetailProductPageUIs.UNIT_PRICE_PRODUCT_SHOPPING_CART );
    }

    public String getQuantityShoppingCart() {
        waitForElementVisible(DetailProductPageUIs.QUANTITY_PRODUCT_SHOPPING_CART );
        return getTextElement(DetailProductPageUIs.QUANTITY_PRODUCT_SHOPPING_CART );
    }

    public String getSubTotalShoppingCart() {
        waitForElementVisible(DetailProductPageUIs.SUB_TOTAL_PRODUCT_SHOPPING_CART );
        return getTextElement(DetailProductPageUIs.SUB_TOTAL_PRODUCT_SHOPPING_CART );
    }

    public void displayShoppingCart() {
        waitForElementVisible(DetailProductPageUIs.ICON_SHOPPING_CART);
        scrollToElement(DetailProductPageUIs.ICON_SHOPPING_CART);
        hoverMouseToElement(DetailProductPageUIs.ICON_SHOPPING_CART);
    }

    public void increaseQuantity(String value) {
        waitForElementVisible(DetailProductPageUIs.QUATITY_PRODUCT);
        scrollToElement(DetailProductPageUIs.ADD_SHOPPING_CART_BUTTON);
        sendkeyToElementByJS(DetailProductPageUIs.QUATITY_PRODUCT, value);
    }

    public String getTotalPriceProduct(String priceProduct, int quantity) {
        String price = priceProduct.substring(1).replace(",", "");
        double numberPrice = Double.parseDouble(price);
        double totalPrice = numberPrice * quantity;

        DecimalFormat decimalFormat = new DecimalFormat("#,###.00");
        return "$" + decimalFormat.format(totalPrice);
    }
}
