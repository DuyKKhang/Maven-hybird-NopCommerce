package com.nopcommer.testcase;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import commons.BaseTest;
import commons.PageGeneratorManager;
import dataUser.UserData;
import pageObject.NopCommer.HomePageObject;
import pageObject.NopCommer.RegisterPageObject;
import utilities.DataHelper;


public class Register extends BaseTest{
	
	private WebDriver driver;
	private HomePageObject homePage;
	private RegisterPageObject registerPage;
	private String firstName, lastName, email, passWord, confirmPasss;
	
	@Parameters({"evnName", "serverName", "browser"})
	@BeforeClass
	public void beforeClass(String evnName,String serverName, String browser) {
		driver = getBrowserDriver(evnName, serverName, browser);
		
		homePage = PageGeneratorManager.getHomePageObject(driver);
		
		firstName 	= UserData.Register.FIRSTNAME;
		lastName 	= UserData.Register.LASTNAME;
		email 		= UserData.Register.EMAIL;
		passWord 	= UserData.Register.PASSWORD;
		confirmPasss = UserData.Register.PASSWORD;
	}
	
	@Test
	public void TC_01_Register_With_Empty_Data(){
		registerPage = homePage.clickToRegister();
		registerPage.clickButtonRegister();
		Assert.assertEquals(registerPage.getTextMessageError("FirstName-error"), "First name is required.");
		Assert.assertEquals(registerPage.getTextMessageError("LastName-error"), "Last name is required.");
		Assert.assertEquals(registerPage.getTextMessageError("Email-error"), "Email is required.");
		Assert.assertEquals(registerPage.getTextMessageError("Password-error"), "Password is required.");
		Assert.assertEquals(registerPage.getTextMessageError("ConfirmPassword-error"), "Password is required.");
		
	}
	@Test
	public void TC_02_Register_With_Invailid_Email(){
		
		registerPage.inputTextbox(firstName,"FirstName");
		registerPage.inputTextbox(lastName,"LastName");
		registerPage.inputTextbox("haha","Email");
		registerPage.inputTextbox(passWord,"Password");
		registerPage.inputTextbox(confirmPasss,"ConfirmPassword");
		registerPage.clickButtonRegister();
		
		Assert.assertEquals(registerPage.getTextMessageError("Email-error"), "Wrong email");
	}
	@Test
	public void TC_03_Register_Success(){
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
	public void TC_04_Register_With_Email_Exist(){
		homePage = registerPage.clickToContinueButton();
		registerPage = homePage.clickToRegister();
		registerPage.inputTextbox(firstName,"FirstName");
		registerPage.inputTextbox(lastName,"LastName");
		registerPage.inputTextbox(email,"Email");
		registerPage.inputTextbox(passWord,"Password");
		registerPage.inputTextbox(confirmPasss,"ConfirmPassword");
		registerPage.clickButtonRegister();
		Assert.assertEquals(registerPage.getTextMessageExists(), "The specified email already exists");
		
	}
	@Test
	public void TC_05_Register_With_Password_Less_6(){
		registerPage.inputTextbox(firstName,"FirstName");
		registerPage.inputTextbox(lastName,"LastName");
		registerPage.inputTextbox(email,"Email");
		registerPage.inputTextbox("123","Password");
		registerPage.inputTextbox("123","ConfirmPassword");
		registerPage.clickButtonRegister();
		Assert.assertEquals(registerPage.getTextMessageError("Password-error"), "Password must meet the following rules:\nmust have at least 6 characters");
		
	}
	@Test
	public void TC_06_Register_With_ConfirmPass_Other_Than_PassWord(){
		registerPage.inputTextbox(firstName,"FirstName");
		registerPage.inputTextbox(lastName,"LastName");
		registerPage.inputTextbox(email,"Email");
		registerPage.inputTextbox(passWord,"Password");
		registerPage.inputTextbox("123","ConfirmPassword");
		registerPage.clickButtonRegister();
		
		Assert.assertEquals(registerPage.getTextMessageError("ConfirmPassword-error"), "The password and confirmation password do not match.");
	}
	
	@AfterClass(alwaysRun = true)
	public void afterClass() {
		closeBrowserDriver();
	}
}
