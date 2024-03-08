package com.nopcommer.testcase;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import commons.BaseTest;
import commons.PageGeneratorManagerUser;
import dataUser.UserData;
import pageObject.NopCommerUser.HomePageObject;
import pageObject.NopCommerUser.LoginPageObject;

public class Login extends BaseTest {
	private WebDriver driver;
	private LoginPageObject loginPage;
	private HomePageObject homePage;
	private String email, passWord;

	@Parameters({ "evnName", "serverName", "browser" })
	@BeforeClass
	public void beforeClass(String evnName, String serverName, String browser) {
		driver = getBrowserDriver(evnName, serverName, browser);

		homePage = PageGeneratorManagerUser.getHomePageObject(driver);

		email = UserData.Register.EMAIL;
		passWord = UserData.Register.PASSWORD;
		System.out.println(email);
		System.out.println(passWord);
	}

	@Test
	public void TC_01_Login_With_Empty_Data() {
		loginPage = homePage.clickToLinkLogin();
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
}
