package com.nopcommer.testcase;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import commons.BasePage;
import commons.BaseTest;
import commons.PageGeneratorManager;
import dataUser.UserData;
import dataUser.UserDataMaper;
import pageObject.NopCommer.HomePageObject;
import pageObject.NopCommer.LoginPageObject;
import pageObject.NopCommer.MyAccountPageObject;

public class MyAccount extends BaseTest{
	private WebDriver driver;
	private LoginPageObject loginPage;
	private HomePageObject homePage;
	private MyAccountPageObject myAccountPage;
	private String email, passWord;
	UserDataMaper useDataMapper;
	private String firstName, lastName, emailChange, company;

	@Parameters({ "evnName", "serverName", "browser" })
	@BeforeClass
	public void beforeClass(String evnName, String serverName, String browser) {
		driver = getBrowserDriver(evnName, serverName, browser);

		homePage = PageGeneratorManager.getHomePageObject(driver);

		email = UserData.Register.EMAIL;
		passWord = UserData.Register.PASSWORD;
		loginPage = homePage.clickToLinkLogin();
		
		loginPage.sendkeyTextBox("Email", email);
		loginPage.sendkeyTextBox("Password", passWord);
		homePage = loginPage.clickToButtonLoginSuccess();
		Assert.assertEquals(homePage.getTitlePage(), "nopCommerce demo store");
		Assert.assertEquals(homePage.getTextLogout(), "Log out");
		myAccountPage = homePage.clickToLinkMyAccount();
		
		
		useDataMapper = UserDataMaper.getUserDataMaper();
		
		firstName = useDataMapper.getCurtomerFirstName();
		
		lastName = useDataMapper.getCurtomerLastName();
		emailChange = useDataMapper.getCurtomerEmail();
		company = useDataMapper.getCurtomerCompany();
	}
		
	@Test
	public void TC_01_Update_Customer_Info() {
		
		
		myAccountPage.clickGenderRadioButton();
		myAccountPage.sendkyTextBox(firstName,"FirstName");
		myAccountPage.sendkyTextBox(lastName,"LastName");
		myAccountPage.dropdownDateOfBirth("01","DateOfBirthDay");
		myAccountPage.dropdownDateOfBirth("01","DateOfBirthMonth");
		myAccountPage.dropdownDateOfBirth("1999","DateOfBirthYear");
		myAccountPage.sendkyTextBox(emailChange,"Email");
		myAccountPage.sendkyTextBox(company,"Company");
		myAccountPage.clickSaveButton();
		
		Assert.assertEquals(myAccountPage.getMessageSuccessful(), "The customer info has been updated successfully.");
		Assert.assertEquals(myAccountPage.getTextCustomer("FirstName"), "Automation");
		Assert.assertEquals(myAccountPage.getTextCustomer("LastName"), "Automation");
		Assert.assertEquals(myAccountPage.getTextDropDownTime("DateOfBirthDay"), "01");
		Assert.assertEquals(myAccountPage.getTextDropDownTime("DateOfBirthMonth"), "Month");
		Assert.assertEquals(myAccountPage.getTextDropDownTime("DateOfBirthYear"), "1999");
		Assert.assertEquals(myAccountPage.getTextCustomer("Email"), "automationfc.vn@gmail.com");
		Assert.assertEquals(myAccountPage.getTextCustomer("Company"), "Automation FC");
	}
	@Test
	public void TC_02_Add_Addresses() {
		
	}
	@Test
	public void TC_03_Change_Password() {
		
	}
	@Test
	public void TC_04_My_Product_Reviews() {

	}

	@AfterClass(alwaysRun = true)
	public void afterClass() {
		closeBrowserDriver();
	}
}
