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
import pageObject.NopCommer.LoginPageObject;

public class Login extends BaseTest{
	private WebDriver driver;
	private LoginPageObject loginPage;
	private HomePageObject homePage;
	private String  email, passWord;
	
	@Parameters({"evnName", "serverName", "browser"})
	@BeforeClass
	public void beforeClass(String evnName,String serverName, String browser) {
		driver = getBrowserDriver(evnName, serverName, browser);
		
		homePage = PageGeneratorManager.getHomePageObject(driver);
		
		email 		= UserData.Register.EMAIL;
		passWord 	= UserData.Register.PASSWORD;
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
		
	}
	@Test
	public void TC_03_Login_With_Email_Unregistered() {
		
	}
	@Test
	public void TC_04_Login_With_Email_Register_Password_Empty() {
		
	}
	@Test
	public void TC_05_Login_With_Email_Register_Password_False() {
		
	}
	@Test
	public void TC_06_Login_With_Email_Register_Password_True() {
		
	}
	
	@AfterClass
	public void afterClass() {
		closeBrowserDriver();
	}
}
