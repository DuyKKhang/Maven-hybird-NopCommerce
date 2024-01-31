package com.nopcommer.testcase;

import commons.BaseTest;
import commons.PageGeneratorManager;
import dataUser.UserData;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import pageObject.NopCommer.*;

import java.util.Random;

public class AdvencedSearch extends BaseTest{
	private WebDriver driver;
	private LoginPageObject loginPage;
	private HomePageObject homePage;
	private CustomerInfoPageObject myAccountPage;
	private AddressesPageObject addressesPage;
	private ChangePassPageObject changePassPage;
	private MyProductReviewsPageObject myProductReviewsPage;
	private DetailProductPageObject detailProductPage;
	private ProductReviewPageObject productReviewPage;
	private String email, passWord;

	@Parameters({ "evnName", "serverName", "browser" })
	@BeforeClass
	public void beforeClass( String evnName, String serverName, String browser) {
		driver = getBrowserDriver(evnName, serverName, browser);

		homePage = PageGeneratorManager.getHomePageObject(driver);

		email = UserData.Register.EMAIL;
		passWord = UserData.Register.PASSWORD;
		loginPage = homePage.clickToLinkLogin();

		loginPage.sendkeyTextBox("Email", email);
		loginPage.sendkeyTextBox("Password", passWord);
		homePage = loginPage.clickToButtonLoginSuccess();
		Assert.assertEquals(homePage.getTextLogout(), "Log out");
		myAccountPage = homePage.clickToLinkMyAccount();
	}

	@Test
	public void TC_01_Search_Empty_Data(){}
	public void TC_02_Search_Data_Not_Exist(){}
	public void TC_03_Search_Product_Name_Relative(){}
	public void TC_04_Search_Product_Name_Absolute(){}
	public void TC_05_Search_Parent_Categories(){}
	public void TC_06_Search_Sub_Categoris(){}
	public void TC_07_Search_Incorrect_Manufacturer(){}
	public void TC_08_Search_Correct_Manufacturer(){}


	@AfterClass(alwaysRun = true)
	public void afterClass() {
		closeBrowserDriver();
	}
	public int random(){
		Random random = new Random();
		return random.nextInt(99999);
	}
}
