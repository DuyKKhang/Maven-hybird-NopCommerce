package com.nopcommer.testcase;

import com.aventstack.extentreports.Status;
import commons.BaseTest;
import commons.PageGeneratorManagerUser;
import dataUser.RegisterSuccessful;
import dataUser.UserData;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.*;
import pageObject.NopCommerUser.*;
import reportConfig.ExtentTestManager;

import java.lang.reflect.Method;
import java.util.Random;

public class AdvencedSearch extends BaseTest{
	private WebDriver driver;
	private LoginPageObject loginPage;
	private HomePageObject homePage;
	private AdvencedSearchPageObject advencedSearchPage;
	private RegisterPageObject registerPage;
	private String firstName,email, lastName, passWord, confirmPasss;
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

		loginPage = registerPage.clickToLinkLogin();

		loginPage.sendkeyTextBox("Email", email);
		loginPage.sendkeyTextBox("Password", passWord);
		homePage = loginPage.clickToButtonLoginSuccess();
		Assert.assertEquals(homePage.getTextLogout(), "Log out");
		advencedSearchPage = homePage.clickSearchFooter();
	}

	@Test
	public void TC_01_Search_Empty_Data(Method method){
		ExtentTestManager.startTest(method.getName(),"Search Empty Data");
		ExtentTestManager.getTest().log(Status.INFO,"Step 01: click Search");
		ExtentTestManager.getTest().log(Status.INFO, "Email: "+email);
		ExtentTestManager.getTest().log(Status.INFO, "Pass word: "+passWord);
		advencedSearchPage.clickSearchButton();
		ExtentTestManager.getTest().log(Status.INFO,"Step 02: Verify message error");
		verifyEquals(advencedSearchPage.getMessageError("warning"),"Search term minimum length is 3 characters");
	}
	@Test
	public void TC_02_Search_Data_Not_Exist(Method method){
		ExtentTestManager.startTest(method.getName(),"Search Data Not Exist");
		ExtentTestManager.getTest().log(Status.INFO,"Step 01: Search Macbook pro 20000");
		advencedSearchPage.inputKeyword("Macbook pro 20000");
		ExtentTestManager.getTest().log(Status.INFO,"Step 02: Click search");
		advencedSearchPage.clickSearchButton();
		ExtentTestManager.getTest().log(Status.INFO,"Step 03: Verify message error");
		verifyEquals(advencedSearchPage.getMessageError("no-result"),"No products were found that matched your criteria.");
	}
	@Test
	public void TC_03_Search_Product_Name_Relative(Method method){
		ExtentTestManager.startTest(method.getName(),"Search Product Name Relative");
		ExtentTestManager.getTest().log(Status.INFO,"Step 01: Search 'Lenovo'");
		advencedSearchPage.inputKeyword("Lenovo");
		ExtentTestManager.getTest().log(Status.INFO,"Step 02: Click search");
		advencedSearchPage.clickSearchButton();
		ExtentTestManager.getTest().log(Status.INFO,"Step 03: Verify product display");
		verifyTrue(advencedSearchPage.quantityProduct()>=1);
		for(WebElement nameProduct : advencedSearchPage.getNameManyProduct()){
			verifyTrue(nameProduct.getText().contains("Lenovo"));
		}
	}
	@Test
	public void TC_04_Search_Product_Name_Absolute(Method method){
		ExtentTestManager.startTest(method.getName(),"Search Product Name Absolute");
		ExtentTestManager.getTest().log(Status.INFO,"Step 01: Search 'ThinkPad X1 Carbon'");
		advencedSearchPage.inputKeyword("ThinkPad X1 Carbon");
		ExtentTestManager.getTest().log(Status.INFO,"Step 02: Click search");
		advencedSearchPage.clickSearchButton();
		ExtentTestManager.getTest().log(Status.INFO,"Step 03: Verify product display");
		verifyTrue(advencedSearchPage.displayJustOneProduct("ThinkPad X1 Carbon"));
	}
	@Test
	public void TC_05_Search_Parent_Categories(Method method){
		ExtentTestManager.startTest(method.getName(),"Search Parent Categories");
		ExtentTestManager.getTest().log(Status.INFO,"Step 01: Search 'Apple Macbook Pro'");
		advencedSearchPage.inputKeyword("Apple Macbook Pro");

		ExtentTestManager.getTest().log(Status.INFO,"Step 02: Check Advenced search");
		advencedSearchPage.clickAdvancedSearch();

		ExtentTestManager.getTest().log(Status.INFO,"Step 03: Choose Category: computer");
		advencedSearchPage.selectCategory("Computers", "cid");

		ExtentTestManager.getTest().log(Status.INFO,"Step 04: Automatically search sub categories: Uncheck");
		advencedSearchPage.unCheckSubCategories("isc");

		ExtentTestManager.getTest().log(Status.INFO,"Step 05: Click search");
		advencedSearchPage.clickSearchButton();

		ExtentTestManager.getTest().log(Status.INFO,"Step 06: Verify message error");
		verifyEquals(advencedSearchPage.getMessageError("no-result"),"No products were found that matched your criteria.");
	}
	@Test
	public void TC_06_Search_Sub_Categoris(Method method){
		ExtentTestManager.startTest(method.getName(),"Search Sub Categoris");
		ExtentTestManager.getTest().log(Status.INFO,"Step 01: Search 'Apple Macbook Pro'");
		advencedSearchPage.inputKeyword("Apple Macbook Pro");
		ExtentTestManager.getTest().log(Status.INFO,"Step 02: Check Advenced search");
		advencedSearchPage.clickAdvancedSearch();
		ExtentTestManager.getTest().log(Status.INFO,"Step 03: Choose Category: computer");
		advencedSearchPage.selectCategory("Computers", "cid");
		ExtentTestManager.getTest().log(Status.INFO,"Step 04: Automatically search sub categories: Check");
		advencedSearchPage.checkSubCategories("isc");
		ExtentTestManager.getTest().log(Status.INFO,"Step 05: Click search");
		advencedSearchPage.clickSearchButton();
		ExtentTestManager.getTest().log(Status.INFO,"Step 06: Verify product display");
		verifyTrue(advencedSearchPage.displayJustOneProduct("Apple Macbook Pro"));
	}
	@Test
	public void TC_07_Search_Incorrect_Manufacturer(Method method){
		ExtentTestManager.startTest(method.getName(),"Search Incorrect Manufacturer");
		ExtentTestManager.getTest().log(Status.INFO,"Step 01: Search 'Apple Macbook Pro'");
		advencedSearchPage.inputKeyword("Apple Macbook Pro");
		ExtentTestManager.getTest().log(Status.INFO,"Step 02: Check Advenced search");
		advencedSearchPage.clickAdvancedSearch();
		ExtentTestManager.getTest().log(Status.INFO,"Step 03: Choose Category: computer");
		advencedSearchPage.selectCategory("Computers","cid" );
		ExtentTestManager.getTest().log(Status.INFO,"Step 04: Automatically search sub categories: Check");
		advencedSearchPage.checkSubCategories("isc");
		ExtentTestManager.getTest().log(Status.INFO,"Step 05: Manufacture: HP");
		advencedSearchPage.selectCategory("HP","mid");
		ExtentTestManager.getTest().log(Status.INFO,"Step 06: Click search");
		advencedSearchPage.clickSearchButton();
		ExtentTestManager.getTest().log(Status.INFO,"Step 07: Verify message error");
		verifyEquals(advencedSearchPage.getMessageError("no-result"),"No products were found that matched your criteria.");
	}
	@Test
	public void TC_08_Search_Correct_Manufacturer(Method method){
		ExtentTestManager.startTest(method.getName(),"Search Correct Manufacturer");
		ExtentTestManager.getTest().log(Status.INFO,"Step 01: Search 'Apple Macbook Pro'");
		advencedSearchPage.inputKeyword("Apple Macbook Pro");
		ExtentTestManager.getTest().log(Status.INFO,"Step 02: Check Advenced search");
		advencedSearchPage.clickAdvancedSearch();
		ExtentTestManager.getTest().log(Status.INFO,"Step 03: Choose Category: computer");
		advencedSearchPage.selectCategory("Computers", "cid");
		ExtentTestManager.getTest().log(Status.INFO,"Step 04: Automatically search sub categories: Check");
		advencedSearchPage.checkSubCategories("isc");
		ExtentTestManager.getTest().log(Status.INFO,"Step 05: Manufacture: Apple");
		advencedSearchPage.selectCategory("Apple", "mid");
		ExtentTestManager.getTest().log(Status.INFO,"Step 06: Click search");
		advencedSearchPage.clickSearchButton();
		ExtentTestManager.getTest().log(Status.INFO,"Step 07: Verify message error");
		verifyTrue(advencedSearchPage.displayJustOneProduct("Apple MacBook Pro 13-inch"));
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
