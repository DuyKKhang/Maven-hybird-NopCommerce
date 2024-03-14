package com.nopcommer.testcase;

import com.aventstack.extentreports.Status;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.*;

import commons.BaseTest;
import commons.PageGeneratorManagerUser;
import dataUser.UserData;
import dataUser.UserDataMapper;
import pageObject.NopCommerUser.*;
import reportConfig.ExtentTestManager;

import java.lang.reflect.Method;
import java.util.Random;

public class MyAccount extends BaseTest {
    private WebDriver driver;
    private LoginPageObject loginPage;
    private HomePageObject homePage;
    private CustomerInfoPageObject myAccountPage;
    private AddressesPageObject addressesPage;
    private ChangePassPageObject changePassPage;
    private MyProductReviewsPageObject myProductReviewsPage;
    private DetailProductPageObject detailProductPage;
    private ProductReviewPageObject productReviewPage;
    private String email, passWord, newPassWord;
    UserDataMapper useDataMapper;
    private RegisterPageObject registerPage;
    private String firstName, lastName, confirmPasss;
    private String emailChange, company;

    @Parameters({"evnName", "serverName", "browser"})
    @BeforeClass
    public void beforeClass(String evnName, String serverName, String browser) {
        driver = getBrowserDriver(evnName, serverName, browser);

        homePage = PageGeneratorManagerUser.getHomePageObject(driver);

        firstName = UserData.Register.FIRSTNAME;
        lastName = UserData.Register.LASTNAME;
        email = random() + UserData.Register.EMAIL;
        passWord = UserData.Register.PASSWORD;
        confirmPasss = UserData.Register.PASSWORD;

        registerPage = homePage.clickToRegister();
        registerPage.inputTextbox(firstName, "FirstName");
        registerPage.inputTextbox(lastName, "LastName");
        registerPage.inputTextbox(email, "Email");
        registerPage.inputTextbox(passWord, "Password");
        registerPage.inputTextbox(confirmPasss, "ConfirmPassword");
        registerPage.clickButtonRegister();
        Assert.assertEquals(registerPage.getTextMessageSuccess(), "Your registration completed");
        Assert.assertTrue(registerPage.isDisplyedContinueButton());

        newPassWord = passWord + random();
        loginPage = registerPage.clickToLinkLogin();

        loginPage.sendkeyTextBox("Email", email);
        loginPage.sendkeyTextBox("Password", passWord);
        homePage = loginPage.clickToButtonLoginSuccess();

        Assert.assertEquals(homePage.getTextLogout(), "Log out");
        myAccountPage = homePage.clickToLinkMyAccount();

        useDataMapper = UserDataMapper.getUserDataMapper();

        firstName = useDataMapper.getCurtomerFirstName();
        lastName = useDataMapper.getCurtomerLastname();
        emailChange = random() + useDataMapper.getCurtomerEmail();
        company = useDataMapper.getCurtomerCompanyName();
    }

    @Test
    public void TC_01_Update_Customer_Info(Method method) {
        ExtentTestManager.startTest(method.getName(), "Update Customer Info");
        ExtentTestManager.getTest().log(Status.INFO, "Step 01: Click Radio Gender");
        myAccountPage.clickGenderRadioButton();

        ExtentTestManager.getTest().log(Status.INFO, "Step 02: Input First Name");
        myAccountPage.sendkyTextBox(firstName, "FirstName");

        ExtentTestManager.getTest().log(Status.INFO, "Step 03: Input Last Namer");
        myAccountPage.sendkyTextBox(lastName, "LastName");

        ExtentTestManager.getTest().log(Status.INFO, "Step 04: Chose date");
        myAccountPage.dropdownDateOfBirth("1", "DateOfBirthDay");

        ExtentTestManager.getTest().log(Status.INFO, "Step 05: Chose month");
        myAccountPage.dropdownDateOfBirth("January", "DateOfBirthMonth");

        ExtentTestManager.getTest().log(Status.INFO, "Step 06: Chose year");
        myAccountPage.dropdownDateOfBirth("1999", "DateOfBirthYear");

        ExtentTestManager.getTest().log(Status.INFO, "Step 07: Input email");
        myAccountPage.sendkyTextBox(emailChange, "Email");

        ExtentTestManager.getTest().log(Status.INFO, "Step 08: Input company");
        myAccountPage.sendkyTextBox(company, "Company");

        ExtentTestManager.getTest().log(Status.INFO, "Step 09: Click save");
        myAccountPage.clickSaveButton();

        ExtentTestManager.getTest().log(Status.INFO, "Step 10: Verify infomation");
        verifyEquals(myAccountPage.getMessageSuccessful(), "The customer info has been updated successfully.");
        verifyEquals(myAccountPage.getTextCustomer("FirstName", "value"), "Automation");
        verifyEquals(myAccountPage.getTextCustomer("LastName", "value"), "Fc");
        verifyEquals(myAccountPage.getTextDropDownTime("DateOfBirthDay", "value"), "1");
        verifyEquals(myAccountPage.getTextDropDownTime("DateOfBirthMonth", "value"), "1");
        verifyEquals(myAccountPage.getTextDropDownTime("DateOfBirthYear", "value"), "1999");
//		Assert.assertEquals(myAccountPage.getTextCustomer("Email", "value"), "automationfc.vn@gmail.com");
        verifyEquals(myAccountPage.getTextCustomer("Company", "value"), "Automation FC");
    }

    @Test
    public void TC_02_Add_Addresses(Method method) {
        ExtentTestManager.startTest(method.getName(), "Add Addresses");
        ExtentTestManager.getTest().log(Status.INFO, "Step 01: Click Radio Gender");
        addressesPage = myAccountPage.clickAddressesPage();

        ExtentTestManager.getTest().log(Status.INFO, "Step 02: Click add new");
        addressesPage.clickAddNew();

        ExtentTestManager.getTest().log(Status.INFO, "Step 03: Input first name");
        addressesPage.inputTextBox(useDataMapper.getAddressFirstName(), "Address_FirstName");

        ExtentTestManager.getTest().log(Status.INFO, "Step 04: Input last name");
        addressesPage.inputTextBox(useDataMapper.getAddressLastName(), "Address_LastName");

        ExtentTestManager.getTest().log(Status.INFO, "Step 05:Input email");
        addressesPage.inputTextBox(useDataMapper.getAddressEmail(), "Address_Email");

        ExtentTestManager.getTest().log(Status.INFO, "Step 06: Input company name");
        addressesPage.inputTextBox(useDataMapper.getAddressCompanyName(), "Address_Company");

        ExtentTestManager.getTest().log(Status.INFO, "Step 07: Select country Viet name");
        addressesPage.selectCountry("Viet Nam");

        ExtentTestManager.getTest().log(Status.INFO, "Step 08: Input city");
        addressesPage.inputTextBox(useDataMapper.getAddressCity(), "Address_City");

        ExtentTestManager.getTest().log(Status.INFO, "Step 09: Input address 1");
        addressesPage.inputTextBox(useDataMapper.getAddressAddress_1(), "Address_Address1");

        ExtentTestManager.getTest().log(Status.INFO, "Step 10: Input address 2");
        addressesPage.inputTextBox(useDataMapper.getAddressAddress_2(), "Address_Address2");

        ExtentTestManager.getTest().log(Status.INFO, "Step 11: Input Zip code");
        addressesPage.inputTextBox(useDataMapper.getAddressZip(), "Address_ZipPostalCode");

        ExtentTestManager.getTest().log(Status.INFO, "Step 12: Input phone");
        addressesPage.inputTextBox(useDataMapper.getAddressPhone(), "Address_PhoneNumber");

        ExtentTestManager.getTest().log(Status.INFO, "Step 13: Input Fax number");
        addressesPage.inputTextBox(useDataMapper.getAddressFaxNumber(), "Address_FaxNumber");

        ExtentTestManager.getTest().log(Status.INFO, "Step 14: Click Save");
        addressesPage.clickToSave();

        ExtentTestManager.getTest().log(Status.INFO, "Step 15: Verify Information");
        Assert.assertEquals(addressesPage.getTextVerifyNotLabel("name"), useDataMapper.getAddressFirstName() + " " + useDataMapper.getAddressLastName());
        Assert.assertEquals(addressesPage.getTextVerifyNotLabel("email"), "Email: " + useDataMapper.getAddressEmail());
        Assert.assertEquals(addressesPage.getTextVerifyNotLabel("phone"), "Phone number: " + useDataMapper.getAddressPhone());
        Assert.assertEquals(addressesPage.getTextVerifyNotLabel("fax"), "Fax number: " + useDataMapper.getAddressFaxNumber());
        Assert.assertEquals(addressesPage.getTextVerifyNotLabel("company"), useDataMapper.getAddressCompanyName());
        Assert.assertEquals(addressesPage.getTextVerifyNotLabel("address1"), useDataMapper.getAddressAddress_1());
        Assert.assertEquals(addressesPage.getTextVerifyNotLabel("address2"), useDataMapper.getAddressAddress_2());
        Assert.assertEquals(addressesPage.getTextVerifyNotLabel("city-state-zip"), useDataMapper.getAddressCity() + ", " + useDataMapper.getAddressZip());
        Assert.assertEquals(addressesPage.getTextVerifyNotLabel("country"), useDataMapper.getAddressCountry());

    }

    @Test
    public void TC_03_Change_Password(Method method) {
        ExtentTestManager.startTest(method.getName(), "Change Password");
        ExtentTestManager.getTest().log(Status.INFO, "Step 01: Click Change Password");
        changePassPage = addressesPage.clickChangePassPage();

        ExtentTestManager.getTest().log(Status.INFO, "Step 02: Input old password");
        changePassPage.inputPassWordTextbox(passWord, "OldPassword");

        ExtentTestManager.getTest().log(Status.INFO, "Step 03: Input new password");
        changePassPage.inputPassWordTextbox(newPassWord, "NewPassword");

        ExtentTestManager.getTest().log(Status.INFO, "Step 04: Input  new password");
        changePassPage.inputPassWordTextbox(newPassWord, "ConfirmNewPassword");

        ExtentTestManager.getTest().log(Status.INFO, "Step 05: Click Change password");
        changePassPage.clickChangePassWordButton();

        ExtentTestManager.getTest().log(Status.INFO, "Step 06: Verify change password success");
        verifyEquals(changePassPage.messageChangePassSuccess(), "Password was changed");

        ExtentTestManager.getTest().log(Status.INFO, "Step 07: Disable message");
        changePassPage.clickDisableMessage();

        ExtentTestManager.getTest().log(Status.INFO, "Step 08: Click logout");
        homePage = changePassPage.clickLogOut();

        ExtentTestManager.getTest().log(Status.INFO, "Step 09: Click login");
        loginPage = homePage.clickToLinkLogin();

        ExtentTestManager.getTest().log(Status.INFO, "Step 10: input email");
        loginPage.sendkeyTextBox("Email", emailChange);

        ExtentTestManager.getTest().log(Status.INFO, "Step 11: Input old password");
        loginPage.sendkeyTextBox("Password", passWord);

        ExtentTestManager.getTest().log(Status.INFO, "Step 12: Click button login");
        loginPage.clickToButtonLoginSuccessNotCreateDriver();

        ExtentTestManager.getTest().log(Status.INFO, "Step 13: Verify message error");
        verifyEquals(loginPage.getMessageErrorEmailUnsuccessful(), "Login was unsuccessful. Please correct the errors and try again.\nThe credentials provided are incorrect");

        ExtentTestManager.getTest().log(Status.INFO, "Step 14: Input new password");
        loginPage.sendkeyTextBox("Password", newPassWord);

        ExtentTestManager.getTest().log(Status.INFO, "Step 15: Click button login");
        homePage = loginPage.clickToButtonLoginSuccess();

        ExtentTestManager.getTest().log(Status.INFO, "Step 16: Verify login success");
        verifyEquals(homePage.getTitlePage(), "nopCommerce demo store");
        verifyEquals(homePage.getTextLogout(), "Log out");

    }

    @Test
    public void TC_04_My_Product_Reviews(Method method) {
        ExtentTestManager.startTest(method.getName(), "My Product eviews");
        ExtentTestManager.getTest().log(Status.INFO, "Step 01: Run page");
        driver.get("https://demo.nopcommerce.com");

        ExtentTestManager.getTest().log(Status.INFO, "Step 02: Choose rating");
        // 1 | 2 | 3 | 4 | 5
        String numberRating = "2";
        String verifyNumberRating = null;

        ExtentTestManager.getTest().log(Status.INFO, "Step 03: Click add to card");
        detailProductPage = homePage.clickAddToCard();

        ExtentTestManager.getTest().log(Status.INFO, "Step 04: Click add your review");
        productReviewPage = detailProductPage.clickAddYourReview();

        ExtentTestManager.getTest().log(Status.INFO, "Step 05: Get title product");
        String titleProduct = productReviewPage.getTitleProduct();

        ExtentTestManager.getTest().log(Status.INFO, "Step 06: Write title content");
        productReviewPage.addReviewTitle("reviews " + titleProduct);

        ExtentTestManager.getTest().log(Status.INFO, "Step 07: Write content");
        productReviewPage.addReviewText("good \nverify");

        ExtentTestManager.getTest().log(Status.INFO, "Step 08: Click rating");
        productReviewPage.clickRating(numberRating);

        ExtentTestManager.getTest().log(Status.INFO, "Step 09: Click submit review");
        productReviewPage.clickSubmitReview();

        ExtentTestManager.getTest().log(Status.INFO, "Step 10: Click to link my account");
        myAccountPage = productReviewPage.clickToLinkMyAccount();

        ExtentTestManager.getTest().log(Status.INFO, "Step 11: Click my product review page");
        myProductReviewsPage = myAccountPage.clickMyProductReviewsPage();

        ExtentTestManager.getTest().log(Status.INFO, "Step 12: Verify");
        Assert.assertEquals(myProductReviewsPage.getTextTitleReview(), "reviews " + titleProduct);
        Assert.assertEquals(myProductReviewsPage.getTextContentReview(), "good\nverify");
        switch (numberRating) {
            case "1":
                verifyNumberRating = "width: 20%;";
                break;
            case "2":
                verifyNumberRating = "width: 40%;";
                break;
            case "3":
                verifyNumberRating = "width: 60%;";
                break;
            case "4":
                verifyNumberRating = "width: 80%;";
                break;
            case "5":
                verifyNumberRating = "width: 100%;";
                break;
        }
        Assert.assertEquals(myProductReviewsPage.getRatingValue("style"), verifyNumberRating);
    }

    @AfterClass(alwaysRun = true)
    public void afterClass() {
        closeBrowserDriver();
    }

    public int random() {
        Random random = new Random();
        return random.nextInt(99999);
    }
}
