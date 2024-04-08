package com.nopcommer.testcase;

import com.aventstack.extentreports.Status;
import dataUser.RegisterSuccessful;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.*;

import commons.BaseTest;
import commons.PageGeneratorManagerUser;
import dataUser.UserData;
import pageObject.NopCommerUser.HomePageObject;
import pageObject.NopCommerUser.LoginPageObject;
import pageObject.NopCommerUser.RegisterPageObject;
import reportConfig.ExtentTestManager;

import java.lang.reflect.Method;
import java.util.Random;

public class Login extends BaseTest {
	private WebDriver driver;
	private LoginPageObject loginPage;
	private HomePageObject homePage;
	private RegisterPageObject registerPage;
	private String firstName, lastName, email, passWord, confirmPasss;

	@Parameters({ "evnName", "serverName", "browser" })
	@BeforeClass
	public void beforeClass(@Optional("local") String evnName,@Optional("dev") String serverName, String browser, String os, String os_version) {
		driver = getBrowserDriver(evnName, serverName, browser, os, os_version);

		homePage = PageGeneratorManagerUser.getHomePageObject(driver);
		firstName 	 = UserData.Register.FIRSTNAME;
		lastName 	 = UserData.Register.LASTNAME;
		email 		 = random() + UserData.Register.EMAIL;
		passWord 	 = UserData.Register.PASSWORD;
		confirmPasss = UserData.Register.PASSWORD;

		registerPage = homePage.clickToRegister();
		registerPage.inputTextbox(firstName,"FirstName");
		registerPage.inputTextbox(lastName,"LastName");
		registerPage.inputTextbox(email,"Email");
		registerPage.inputTextbox(passWord,"Password");
		registerPage.inputTextbox(confirmPasss,"ConfirmPassword");
		registerPage.clickButtonRegister();
		Assert.assertEquals(registerPage.getTextMessageSuccess(), "Your registration completed");
		Assert.assertTrue(registerPage.isDisplyedContinueButton());

	}

	@Test
	public void TC_01_Login_With_Empty_Data(Method method) {
		ExtentTestManager.startTest(method.getName(),"Login_With_Empty_Data");
		loginPage = registerPage.clickToLinkLogin();
		loginPage.clickToButtonLogin();

		Assert.assertEquals(loginPage.getTitlePageLogin(), "nopCommerce demo store. Login");
		Assert.assertEquals(loginPage.getMessageErrorEmail(), "Please enter your email");
	}

	@Test
	public void TC_02_Login_With_Invalid_Email() {
		
		loginPage.sendkeyTextBox("Email", "asdf");
		loginPage.sendkeyTextBox("Password", passWord);
		
		loginPage.clickToButtonLogin();

		Assert.assertEquals(loginPage.getMessageErrorEmail(), "Wrong email");
	}

	@Test
	public void TC_03_Login_With_Email_Unregistered() {
		loginPage.sendkeyTextBox("Email", "asdfas@gmail.com");
		loginPage.sendkeyTextBox("Password", passWord);
		
		loginPage.clickToButtonLogin();
		
		Assert.assertEquals(loginPage.getMessageErrorEmailUnsuccessful(), "Login was unsuccessful. Please correct the errors and try again.\nNo customer account found");

	}

	@Test
	public void TC_04_Login_With_Email_Register_Password_Empty() {
		loginPage.sendkeyTextBox("Email", email);
		loginPage.sendkeyTextBox("Password", "");
		loginPage.clickToButtonLogin();
		Assert.assertEquals(loginPage.getMessageErrorEmailUnsuccessful(), "Login was unsuccessful. Please correct the errors and try again.\nThe credentials provided are incorrect");
	}

	@Test
	public void TC_05_Login_With_Email_Register_Password_False() {
		loginPage.sendkeyTextBox("Email", email);
		loginPage.sendkeyTextBox("Password", email);
		
		loginPage.clickToButtonLogin();
		Assert.assertEquals(loginPage.getMessageErrorEmailUnsuccessful(), "Login was unsuccessful. Please correct the errors and try again.\nThe credentials provided are incorrect");

	}

	@Test
	public void TC_06_Login_With_Email_Register_Password_True() {
		loginPage.sendkeyTextBox("Email", email);
		loginPage.sendkeyTextBox("Password", passWord);
		
		homePage = loginPage.clickToButtonLoginSuccess();
		Assert.assertEquals(homePage.getTitlePage(), "nopCommerce demo store");
		Assert.assertEquals(homePage.getTextLogout(), "Log out");
	}

	@AfterClass
	public void afterClass() {
		closeBrowserDriver();
	}
	public int random(){
		Random random = new Random();
		return random.nextInt(99999);
	}
}
