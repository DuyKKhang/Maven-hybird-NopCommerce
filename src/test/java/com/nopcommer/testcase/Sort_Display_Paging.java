package com.nopcommer.testcase;

import com.aventstack.extentreports.Status;
import commons.BaseTest;
import commons.PageGeneratorManagerUser;
import dataUser.UserData;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import pageObject.NopCommerUser.ComputerPageObject;
import pageObject.NopCommerUser.HomePageObject;
import pageObject.NopCommerUser.LoginPageObject;
import pageObject.NopCommerUser.NotebooksPageObject;
import reportConfig.ExtentTestManager;

import java.lang.reflect.Method;
import java.util.Random;

public class Sort_Display_Paging extends BaseTest{
	private WebDriver driver;
	private LoginPageObject loginPage;
	private HomePageObject homePage;
	private ComputerPageObject computerPage;
	private NotebooksPageObject notebooksPage;
	private String email, passWord;

	@Parameters({ "evnName", "serverName", "browser" })
	@BeforeClass
	public void beforeClass( String evnName, String serverName, String browser) {
		driver = getBrowserDriver(evnName, serverName, browser);

		homePage = PageGeneratorManagerUser.getHomePageObject(driver);

		email = UserData.Register.EMAIL;
		passWord = UserData.Register.PASSWORD;
		loginPage = homePage.clickToLinkLogin();

		loginPage.sendkeyTextBox("Email", email);
		loginPage.sendkeyTextBox("Password", passWord);
		homePage = loginPage.clickToButtonLoginSuccess();
		Assert.assertEquals(homePage.getTextLogout(), "Log out");
		computerPage = homePage.clickComputerLinkProduct("Computers");
		notebooksPage = computerPage.clickLinkProductNotebooks("Notebooks");
	}

	@Test
	public void TC_01_Sort_Name_A_To_Z(Method method){
		ExtentTestManager.startTest(method.getName(),"Sort_Name_A_To_Z");
		ExtentTestManager.getTest().log(Status.INFO,"Step 01: Click sort by name A to Z");
		notebooksPage.selectSortByName("Name: A to Z");
		ExtentTestManager.getTest().log(Status.INFO,"Step 02: Verify product have been sort");
		verifyTrue(notebooksPage.isProductSortNameByAscending("A to Z"));

	}
	@Test
	public void TC_02_Sort_Name_Z_To_A(Method method){
		ExtentTestManager.startTest(method.getName(),"Sort_Name_Z_To_A");
		ExtentTestManager.getTest().log(Status.INFO,"Step 01: Click sort by name Z to A");
		notebooksPage.selectSortByName("Name: Z to A");
		ExtentTestManager.getTest().log(Status.INFO,"Step 02: Verify product have been sort");
		verifyTrue(notebooksPage.isProductSortNameByAscending("Z to A"));
	}
	@Test
	public void TC_03_Sort_Price_Low_To_High(Method method){
		ExtentTestManager.startTest(method.getName(),"Sort_Price_Low_To_High");
		ExtentTestManager.getTest().log(Status.INFO,"Step 01: Click sort by price low to high");
		notebooksPage.selectSortByName("Price: Low to High");
		ExtentTestManager.getTest().log(Status.INFO,"Step 02: Verify product have been sort");
		verifyTrue(notebooksPage.isProductSortPriceByAscending("Low to High"));
	}
	@Test
	public void TC_04_Sort_Price_High_To_Low(Method method){
		ExtentTestManager.startTest(method.getName(),"Sort_Price_High_To_Low");
		ExtentTestManager.getTest().log(Status.INFO,"Step 01: Click sort by price high to low");
		notebooksPage.selectSortByName("Price: High to Low");
		ExtentTestManager.getTest().log(Status.INFO,"Step 02: Verify product have been sort");
		verifyTrue(notebooksPage.isProductSortPriceByAscending("High to Low"));
	}
	@Test
	public void TC_05_Display_With_3_Product_On_1_Page(Method method){
		ExtentTestManager.startTest(method.getName(),"Display_With_3_Product_On_1_Page");
		ExtentTestManager.getTest().log(Status.INFO,"Step 01: Click display 3 product");
		notebooksPage.selectDisplayPage("3");

		ExtentTestManager.getTest().log(Status.INFO,"Step 02: Verify display 3 product");
		verifyTrue(notebooksPage.displayProduct()<=3);
		verifyTrue(notebooksPage.displaySwitchPage("1","next-page"));

		ExtentTestManager.getTest().log(Status.INFO,"Step 03: Click next page");
		notebooksPage.clickNextPage("next-page");

		ExtentTestManager.getTest().log(Status.INFO,"Step 04: Verify display icon previous page");
		verifyTrue(notebooksPage.displaySwitchPage("2","previous-page"));
	}
	@Test
	public void TC_06_Display_With_6_Product_On_1_Page(Method method){
		ExtentTestManager.startTest(method.getName(),"Display_With_6_Product_On_1_Page");
		ExtentTestManager.getTest().log(Status.INFO,"Step 01: Click display 6 product");
		notebooksPage.selectDisplayPage("6");
		ExtentTestManager.getTest().log(Status.INFO,"Step 02: Verify display 6 product");
		verifyTrue(notebooksPage.displayProduct()<=6);
		verifyTrue(notebooksPage.unDisplaySwitchPage("next-page"));
	}
	@Test
	public void TC_07_Display_With_9_Product_On_1_Page(Method method){
		ExtentTestManager.startTest(method.getName(),"Display_With_9_Product_On_1_Page");
		ExtentTestManager.getTest().log(Status.INFO,"Step 01: Click display 9 product");
		notebooksPage.selectDisplayPage("9");
		ExtentTestManager.getTest().log(Status.INFO,"Step 02: Verify display 9 product");
		verifyTrue(notebooksPage.displayProduct()<=9);
		verifyTrue(notebooksPage.unDisplaySwitchPage("next-page"));
	}


	@AfterClass(alwaysRun = true)
	public void afterClass() {
		closeBrowserDriver();
	}
	public int random(){
		Random random = new Random();
		return random.nextInt(99999);
	}
}
