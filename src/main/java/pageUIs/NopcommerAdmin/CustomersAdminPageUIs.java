package pageUIs.NopcommerAdmin;

import commons.BasePage;
import org.openqa.selenium.WebDriver;

public class CustomersAdminPageUIs{
    public final static String TITLE_TEXT = "xpath=//h1[@class='float-left']";
    public final static String ADD_NEW_BUTTON = "xpath=//a[@class='btn btn-primary']";
    public final static String INFORMATION_CUSTOMER_TEXTBOX = "xpath=//input[@id='%s']";
    public final static String TEXTAREA_INFORMATION_CUSTOMER_TEXT_BOX = "xpath=//textarea[@id='%s']";
    public final static String SAVE_CONTINUE_EDIT_BUTTON = "xpath=//div[@class='content-header clearfix']//button[@name='save-continue']";
    public final static String MESSAGE_SAVE_SUCCESS = "xpath=//div[@class='content-wrapper']//div[@class='alert alert-success alert-dismissable']";
    public final static String BACK_TO_CUSTOMER_LIST_LINK = "xpath=//h1[@class='float-left']//a[contains(@href,'/Admin/Customer/List')]";
    public final static String SEARCH_BUTTON = "css=button#search-customers";
    public final static String LOADING_ICON = "xpath=//div[@id='ajaxBusy']";
    public final static String SHOW_ITEM_SELECT = "xpath=//select[@name='customers-grid_length']";
    public final static String GENDER_RADIO = "xpath=(//div[@class='raw']//input[@type='radio'])[%s]";
    public final static String GENDER_RADIO_TEXT = "xpath=(//div[@class='raw']//label[@class='form-check-label'])[%s]";
    public final static String ACTIVE_CHECKBOX = "xpath=//input[@id='Active']";
    public final static String CUSTOMER_ROLES_TEXT = "xpath=//li[@class='k-button']/span[text()='Guests']";
    public final static String CELL_CUSTOMER_TABLE = "xpath=//tbody//td";
    public final static String NAME_CELL_CUSTOMER_TABLE = "xpath=(//tbody//td)[%s]";
    public final static String DELETE_ROLES = "xpath=//li[@class='k-button']//span[@class='k-icon k-i-close']";
    public final static String SEARCH_INFORMATION_TEXTBOX = "xpath=//input[@id='%s']";
    public final static String TABLE_CUSTOMER = "xpath=//tr[@class='odd']";
    public final static String DATE_OF_BIRTH_SELECT = "xpath=//select[@id='%s']";
    public final static String EDIT_BUTTON = "xpath=//a[@class='btn btn-default']";
    public final static String MESSAGE_SAVE_EDIT_TEXT = "xpath=//div[@class='alert alert-success alert-dismissable']";
    public final static String CUSTOMER_ROLES_INPUT_TEXT_BOX = "xpath=//label[@id='SelectedCustomerRoleIds_label']//ancestor::div[@class='form-group row']//input";

}
