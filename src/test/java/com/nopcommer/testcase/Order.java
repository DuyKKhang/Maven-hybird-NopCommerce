package com.nopcommer.testcase;

import com.aventstack.extentreports.Status;
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
import reportConfig.ExtentTestManager;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Order extends BaseTest{
	private WebDriver driver;
	private LoginPageObject loginPage;
	private HomePageObject homePage;
	private ComputerPageObject computerPage;
	private DesktopsProductPageObject desktopsProductPage;
	private WishlisPageObject wishlisPage;
	private ShoppingCartPageObject shoppingCartPage;
	private CustomerInfoPageObject customerInfoPage;
	private DetailProductPageObject detailProductPage;
	private CompareProductsPageObject compareProductsPage;
	private RecentlyViewedProductsPageObject recentlyViewedProductsPage;
	private String email, passWord;
	private String firstNameAccount, lastNameAccount;

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

		computerPage = homePage.clickComputerLinkProduct("Computers");
		desktopsProductPage = computerPage.clickLinkProductDesktops("Desktops");
	}

	@Test
	public void TC_01_Add_Product_To_Cart(Method method){
		ExtentTestManager.startTest(method.getName(),"Add_Product_To_Cart");
		ExtentTestManager.getTest().log(Status.INFO,"Step 01: Click one product");

		detailProductPage = desktopsProductPage.clickProduct("1");

		ExtentTestManager.getTest().log(Status.INFO,"Step 02: Add to shopping cart");
		detailProductPage.selectRamDropdown("2 GB");
		detailProductPage.clickHDDRadioButton();

		String nameProduct = detailProductPage.getNameProduct();
		String skuProduct = detailProductPage.getSkuProduct();
		String priceProduct = detailProductPage.getPriceProduct();

		ExtentTestManager.getTest().log(Status.INFO,"Step 03: Verify message success");

		ExtentTestManager.getTest().log(Status.INFO,"Step 03: Verify product added sopping cart");
	}
	@Test
	public void TC_02_Edit_Product_In_Shopping_Cart(Method method) {
		ExtentTestManager.startTest(method.getName(), "Edit_Product_In_Shopping_Cart");
		ExtentTestManager.getTest().log(Status.INFO, "Step 01: Open shopping cart");
		ExtentTestManager.getTest().log(Status.INFO, "Step 01: Edit product");
		ExtentTestManager.getTest().log(Status.INFO, "Step 01: Verify price");
		ExtentTestManager.getTest().log(Status.INFO, "Step 01: Verify message");
		ExtentTestManager.getTest().log(Status.INFO, "Step 01: Verify product information has been update successfully");
		ExtentTestManager.getTest().log(Status.INFO, "Step 01: Verify total pay shopping cart");
	}
	@Test
	public void TC_03_Remove_Frome_Cart(Method method) {
		ExtentTestManager.startTest(method.getName(), "Remove_Frome_Cart");
		ExtentTestManager.getTest().log(Status.INFO, "Step 01: Open the shopping cart with product");
		ExtentTestManager.getTest().log(Status.INFO, "Step 01: Choose remove and click update");
		ExtentTestManager.getTest().log(Status.INFO, "Step 01: Verify message");
		ExtentTestManager.getTest().log(Status.INFO, "Step 01: Verify product undisplayed in shopping cart");
	}
	@Test
	public void TC_04_Update_Shopping_Cart(Method method) {
		ExtentTestManager.startTest(method.getName(), "Update_Shopping_Cart");
		ExtentTestManager.getTest().log(Status.INFO, "Step 01: Add a product into shopping cart");
		ExtentTestManager.getTest().log(Status.INFO, "Step 01: Increase QTY 5 and Click update shopping cart");
		ExtentTestManager.getTest().log(Status.INFO, "Step 01: Verify total increase");
	}
	@Test
	public void TC_05_Checkout_Payment_Method_By_Cheque(Method method) {
		ExtentTestManager.startTest(method.getName(), "Checkout_Payment_Method_By_Cheque");
		ExtentTestManager.getTest().log(Status.INFO, "Step 01: Added product into shopping cart");
		ExtentTestManager.getTest().log(Status.INFO, "Step 01: Input information and click Checkout");
		ExtentTestManager.getTest().log(Status.INFO, "Step 01: Input information Bulling Address");
		ExtentTestManager.getTest().log(Status.INFO, "Step 01: Input information Shipping address");
		ExtentTestManager.getTest().log(Status.INFO, "Step 01: Choose shopping method");
		ExtentTestManager.getTest().log(Status.INFO, "Step 01: Choose Payment method (Cheque)");
		ExtentTestManager.getTest().log(Status.INFO, "Step 01: Verify information Payment");
		ExtentTestManager.getTest().log(Status.INFO, "Step 01: Verify order and click confirm");
		ExtentTestManager.getTest().log(Status.INFO, "Step 01: Verify success message and order number");
		ExtentTestManager.getTest().log(Status.INFO, "Step 01: Into my account > other > verify information display");
		ExtentTestManager.getTest().log(Status.INFO, "Step 01: verify information display  correct");
	}
	@Test
	public void TC_06_Checkout_Payment_Method_By_Card(Method method) {
		ExtentTestManager.startTest(method.getName(), "Checkout_Payment_Method_By_Card");
		ExtentTestManager.getTest().log(Status.INFO, "Step 01: Added product into shopping cart");
		ExtentTestManager.getTest().log(Status.INFO, "Step 01: Input information and click Checkout");
		ExtentTestManager.getTest().log(Status.INFO, "Step 01: Input information Bulling Address");
		ExtentTestManager.getTest().log(Status.INFO, "Step 01: Input information Shipping address");
		ExtentTestManager.getTest().log(Status.INFO, "Step 01: Choose shopping method");
		ExtentTestManager.getTest().log(Status.INFO, "Step 01: Choose Payment method (Cart)");
		ExtentTestManager.getTest().log(Status.INFO, "Step 01: Verify information Payment");
		ExtentTestManager.getTest().log(Status.INFO, "Step 01: Verify order and click confirm");
		ExtentTestManager.getTest().log(Status.INFO, "Step 01: Verify success message and order number");
		ExtentTestManager.getTest().log(Status.INFO, "Step 01: Into my account > other > verify information display");
		ExtentTestManager.getTest().log(Status.INFO, "Step 01: verify information display  correct");
	}
	@Test
	public void TC_07_Re_Order(Method method) {
		ExtentTestManager.startTest(method.getName(), "Re_Order");
		ExtentTestManager.getTest().log(Status.INFO, "Step 01: Have oder product is success");
		ExtentTestManager.getTest().log(Status.INFO, "Step 01: Input My account");
		ExtentTestManager.getTest().log(Status.INFO, "Step 01: Order");
		ExtentTestManager.getTest().log(Status.INFO, "Step 01: Choose a order number");
		ExtentTestManager.getTest().log(Status.INFO, "Step 01: Click details");
		ExtentTestManager.getTest().log(Status.INFO, "Step 01: Click re-order");
		ExtentTestManager.getTest().log(Status.INFO, "Step 01: Update information");
		ExtentTestManager.getTest().log(Status.INFO, "Step 01: Verify success information update");
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
