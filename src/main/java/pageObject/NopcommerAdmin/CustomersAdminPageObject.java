package pageObject.NopcommerAdmin;

import commons.BasePage;
import commons.PageGeneratorManagerAdmin;
import org.openqa.selenium.WebDriver;
import pageUIs.NopcommerAdmin.CustomersAdminPageUIs;
import pageUIs.NopcommerAdmin.ProductsCatologAdminPageUIs;

import java.util.ArrayList;
import java.util.List;

public class CustomersAdminPageObject extends BasePage {
    private WebDriver driver;
    public CustomersAdminPageObject(WebDriver driver) {
        super(driver);
        this.driver = driver;
    }

    public String getTitleCustomers() {
        waitForElementVisible(CustomersAdminPageUIs.TITLE_TEXT);
        return getTextElement(CustomersAdminPageUIs.TITLE_TEXT);
    }

    public void clickAddNew() {
        waitForElementVisible(CustomersAdminPageUIs.ADD_NEW_BUTTON);
        clickToElementByJS(CustomersAdminPageUIs.ADD_NEW_BUTTON);
    }

    public void inputInformation(String value, String dynamic) {
        waitForElementVisible(CustomersAdminPageUIs.INFORMATION_CUSTOMER_TEXTBOX, dynamic);
        sendkeyToElement(CustomersAdminPageUIs.INFORMATION_CUSTOMER_TEXTBOX, value, dynamic);
    }

    public void selectCustomerRoles(String value) {
        waitForElementVisible(CustomersAdminPageUIs.CUSTOMER_ROLES_SELECT);
        selectItemInDropDownBy_Text(CustomersAdminPageUIs.CUSTOMER_ROLES_SELECT, value);
    }

    public void clickSaveAndContinueEdit() {
        waitForElementClickable(CustomersAdminPageUIs.SAVE_CONTINUE_EDIT_BUTTON);
        clickToElement(CustomersAdminPageUIs.SAVE_CONTINUE_EDIT_BUTTON);
    }

    public String getTextMessageSaveSuccess() {
        waitForElementVisible(CustomersAdminPageUIs.MESSAGE_SAVE_SUCCESS);
        return getTextElement(CustomersAdminPageUIs.MESSAGE_SAVE_SUCCESS);
    }

    public void clickBackToCustomerList() {
        waitForElementVisible(CustomersAdminPageUIs.BACK_TO_CUSTOMER_LIST_LINK);
        clickToElementByJS(CustomersAdminPageUIs.BACK_TO_CUSTOMER_LIST_LINK);
    }

    public void clickSearch() {
        waitForElementVisible(CustomersAdminPageUIs.SEARCH_BUTTON);
        clickToElement(CustomersAdminPageUIs.SEARCH_BUTTON);
    }

    public void showItem(String value) {
        waitForElementInvisible(CustomersAdminPageUIs.LOADING_ICON);
        selectItemInDropDownBy_Text(CustomersAdminPageUIs.SHOW_ITEM_SELECT, value);
    }

    public void selectGender(String gender) {
        waitForElementVisible(CustomersAdminPageUIs.GENDER_RADIO,gender);
        checkTheCheckboxOrRadio(CustomersAdminPageUIs.GENDER_RADIO,gender);
    }

    public void checkBoxActive() {
        waitForElementVisible(CustomersAdminPageUIs.ACTIVE_CHECKBOX);
        checkTheCheckboxOrRadio(CustomersAdminPageUIs.ACTIVE_CHECKBOX);
    }

    public String getInformationCustomer(String dynamic) {
        waitForElementVisible(CustomersAdminPageUIs.INFORMATION_CUSTOMER_TEXTBOX, dynamic);
        return getTextElement(CustomersAdminPageUIs.INFORMATION_CUSTOMER_TEXTBOX, dynamic);
    }

    public String getGenderCustomerInfo(String dynamic) {
        waitForElementVisible(CustomersAdminPageUIs.GENDER_RADIO_TEXT, dynamic);
        return getTextElement(CustomersAdminPageUIs.GENDER_RADIO_TEXT, dynamic);
    }

    public boolean getStatusActive() {
        waitForElementVisible(CustomersAdminPageUIs.ACTIVE_CHECKBOX);
        return isControlSelected(CustomersAdminPageUIs.ACTIVE_CHECKBOX);
    }

    public String getCustomerRolesText() {
        waitForElementVisible(CustomersAdminPageUIs.CUSTOMER_ROLES_TEXT);
        return getTextElement(CustomersAdminPageUIs.CUSTOMER_ROLES_TEXT);
    }

    public List<String> getListNameCustomer() {
        waitForElementInvisible(CustomersAdminPageUIs.LOADING_ICON);
        List<String> listName = new ArrayList<>();
        int cellSize = getElementsSize(CustomersAdminPageUIs.CELL_CUSTOMER_TABLE);
        for(int i=3; i<=cellSize; i=i+7){
            listName.add(getTextElement(CustomersAdminPageUIs.NAME_CELL_CUSTOMER_TABLE,Integer.toString(i)));
        }

        return listName;
    }

    public List<String> getListCompanyNameCustomer() {
        waitForElementInvisible(CustomersAdminPageUIs.LOADING_ICON);
        waitForElementInvisible(CustomersAdminPageUIs.LOADING_ICON);
        List<String> listCompanyName = new ArrayList<>();
        int cellSize = getElementsSize(CustomersAdminPageUIs.CELL_CUSTOMER_TABLE);
        for(int i=5; i<=cellSize; i=i+7){
            listCompanyName.add(getTextElement(CustomersAdminPageUIs.NAME_CELL_CUSTOMER_TABLE,Integer.toString(i)));
        }

        return listCompanyName;
    }

    public boolean isNameListCustomer(List<String> listNameCustomer, String value) {
        boolean isName = false;
        for(String name : listNameCustomer){
            if(name.equals(value)){
                isName = true;
            }
        }
        return isName;
    }

    public boolean isCoompanyNameListCustomer(List<String> listCompanyNameCustomer, String value) {
        boolean isCompanyName = false;
        for(String companyName : listCompanyNameCustomer){
            if(companyName.equals(value)){
                isCompanyName = true;
            }
        }
        return isCompanyName;
    }

    public void clickDeteleRoles() {
        waitForElementVisible(CustomersAdminPageUIs.DELETE_ROLES);
        clickToElementByJS(CustomersAdminPageUIs.DELETE_ROLES);
    }

    public void searchInformation(String emailCustomers, String dynamic) {
        waitForElementVisible(CustomersAdminPageUIs.SEARCH_INFORMATION_TEXTBOX, dynamic);
        sendkeyToElement(CustomersAdminPageUIs.SEARCH_INFORMATION_TEXTBOX, emailCustomers, dynamic);
    }

    public int getSizeElement() {
        return getElementsSize(CustomersAdminPageUIs.TABLE_CUSTOMER);
    }


    public void selectDateOfBirth(String value, String dynamic) {
        waitForElementVisible(CustomersAdminPageUIs.DATE_OF_BIRTH_SELECT, dynamic);
        selectItemInDropDownBy_Values(CustomersAdminPageUIs.DATE_OF_BIRTH_SELECT, value, dynamic);
    }

    public DetailsCustomersAdminPageObject clickEditCustomer() {
        waitForElementVisible(CustomersAdminPageUIs.EDIT_BUTTON);
        clickToElementByJS(CustomersAdminPageUIs.EDIT_BUTTON);
        return PageGeneratorManagerAdmin.getDetailsCustomersAdminPageObject(driver);
    }

    public String getMessageSaveEdit() {
        waitForElementVisible(CustomersAdminPageUIs.MESSAGE_SAVE_EDIT_TEXT);
        return getTextElement(CustomersAdminPageUIs.MESSAGE_SAVE_EDIT_TEXT);
    }
}
