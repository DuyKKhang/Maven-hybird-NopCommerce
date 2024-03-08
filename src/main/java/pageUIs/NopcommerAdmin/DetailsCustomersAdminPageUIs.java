package pageUIs.NopcommerAdmin;

import commons.BasePage;
import org.openqa.selenium.WebDriver;

public class DetailsCustomersAdminPageUIs  {
    public final static String INFORMATION_EDIT_TEXTBOX ="xpath=//input[@id='%s']";
    public final static String SAVE_BUTTON ="xpath=//button[@name='save']";
    public final static String DETAILS_ADDRESSES ="xpath=//div[@id='customer-address']";
    public final static String ADD_NEW_ADDRESSES_BUTTON ="xpath=//div[@id='customer-address']//button[@class='btn btn-primary']";
    public final static String INFORMATION_ADDRESSES ="xpath=//input[@id='%s']";
    public final static String SELECT_INFORMATION_ADDRESSES ="xpath=//select[@id='Address_CountryId']";
    public final static String SAVE_ADDRESSES_BUTTON ="xpath=//div[@class='float-right']/button[@class='btn btn-primary']";
    public final static String MESSAGE_SUCCESS_SAVE ="xpath=//div[@class='alert alert-success alert-dismissable']";
    public final static String BACK_TO_CUSTOMER_LINK ="xpath=//h1[@class='float-left']//a";
    public final static String INFO_ADDRESS_TABLE_TEXT ="xpath=(//div[@id='customer-address']//td)[%s]";
    public final static String EDIT_ADDRESSES ="xpath=//a[text()='%s']";
    public final static String MESSAGE_TABLE_NO_DATA ="xpath=//div[@id='customer-address']//td[@class='dataTables_empty']";
}
