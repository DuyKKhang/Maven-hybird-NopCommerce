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
import java.util.Random;

public class WishList_Compare_RecentView extends BaseTest{
	private WebDriver driver;
	private LoginPageObject loginPage;
	private HomePageObject homePage;
	private ComputerPageObject computerPage;
	private DesktopsPageObject desktopsPage;
	private WishlisPageObject wishlisPage;
	private ShoppingCartPageObject shoppingCartPage;
	private CustomerInfoPageObject customerInfoPage;
	private DetailProductPageObject detailProductPage;
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
		customerInfoPage = homePage.clickToLinkMyAccount();
		firstNameAccount =  customerInfoPage.getTextCustomer("FirstName", "value");
		lastNameAccount = customerInfoPage.getTextCustomer("LastName", "value");

		computerPage = customerInfoPage.clickComputerLinkProduct("Computers");
		desktopsPage = computerPage.clickLinkProductDesktops("Desktops");
	}

//	@Test
//	public void TC_01_Add_To_WishList(Method method){
//		ExtentTestManager.startTest(method.getName(),"Add_To_WishList");
//		ExtentTestManager.getTest().log(Status.INFO,"Step 01: Click one product");
//		detailProductPage = desktopsPage.clickProduct("1");
//		String nameProduct = detailProductPage.getNamePrduct();
//		String skuProduct = detailProductPage.getSkuProduct();
//		String priceProduct = detailProductPage.getPriceProduct();
//
//		ExtentTestManager.getTest().log(Status.INFO,"Step 02: Add to wishlist");
//		detailProductPage.selectRamDropdown("2 GB");
//		detailProductPage.clickHDDRadioButton();
//		detailProductPage.addToWishList();
//
//		ExtentTestManager.getTest().log(Status.INFO,"Step 03: Verify message add success");
//		verifyEquals(detailProductPage.getMessageAddWsihList(),"The product has been added to your wishlist");
//		detailProductPage.closeMessage();
//
//		ExtentTestManager.getTest().log(Status.INFO,"Step 04: Into wishlist page");
//		wishlisPage = detailProductPage.clickWishlistLink();
//
//		ExtentTestManager.getTest().log(Status.INFO,"Step 05: Verify product add success");
//		verifyTrue(wishlisPage.verifyProductWishlistPage()>=1);
//		verifyEquals(wishlisPage.getDetailProduct(),nameProduct);
//		verifyEquals(wishlisPage.getDetailProduct(),skuProduct);
//		verifyEquals(wishlisPage.getDetailProduct(),priceProduct);
//
//		ExtentTestManager.getTest().log(Status.INFO,"Step 06: Click link your wishlist URL for sharing");
//		wishlisPage.clickLinkWishlistSharing();
//		verifyEquals(wishlisPage.getTitleWishlistSharing(),"Wishlist of "+ firstNameAccount+" "+lastNameAccount);
//	}
//	@Test
//	public void TC_02_Add_Product_To_Cart_WishList_Page(Method method){
//		ExtentTestManager.startTest(method.getName(),"Add_Product_To_Cart_WishList_Page");
//		ExtentTestManager.getTest().log(Status.INFO,"Step 01: Checkbox product, Click Add to car");
//		wishlisPage.clickWishlistLink();
//		wishlisPage.checkBoxAddToCart();
//		wishlisPage.ClickAddToCart();
//
//		ExtentTestManager.getTest().log(Status.INFO,"Step 02: Verify product remove Wishlist page");
//		verifyTrue(wishlisPage.verifyProductWishlistPage()<= 0);
//
//		ExtentTestManager.getTest().log(Status.INFO,"Step 02: Verify product add to cart");
//		shoppingCartPage = wishlisPage.clickShoppingCart();
//		verifyTrue(shoppingCartPage.verifyProductShoppingCartPage()>= 1);
//	}
//	@Test
//	public void TC_03_Remove_Product_in_WishList_Page(Method method){
//		ExtentTestManager.startTest(method.getName(),"Remove_Product_in_WishList_Page");
//		ExtentTestManager.getTest().log(Status.INFO,"Step 01: Select a product");
//		computerPage = customerInfoPage.clickComputerLinkProduct("Computers");
//		desktopsPage = computerPage.clickLinkProductDesktops("Desktops");
//		detailProductPage = desktopsPage.clickProduct("1");
//		detailProductPage.selectRamDropdown("2 GB");
//		detailProductPage.clickHDDRadioButton();
//
//		ExtentTestManager.getTest().log(Status.INFO,"Step 01: Add to Wishlist");
//		detailProductPage.addToWishList();
//
//		ExtentTestManager.getTest().log(Status.INFO,"Step 02: Into wishlist");
//		wishlisPage = detailProductPage.clickWishlistLink();
//
//		ExtentTestManager.getTest().log(Status.INFO,"Step 02: Click checkbox remove");
//		wishlisPage.clickRemoveProduct();
//
//		ExtentTestManager.getTest().log(Status.INFO,"Step 03: Verify message");
//		verifyEquals(wishlisPage.getTextMessageWishlistNull(),"The wishlist is empty!");
//
//		ExtentTestManager.getTest().log(Status.INFO,"Step 03: Verify not display product");
//		verifyTrue(wishlisPage.verifyProductWishlistPage()>=0);
//	}
	@Test
	public void TC_04_Add_Product_To_Compare(Method method){
		ExtentTestManager.startTest(method.getName(),"Add_Product_To_Compare");
		ExtentTestManager.getTest().log(Status.INFO,"Step 01: Add two products to compare");
		driver.get("https://demo.nopcommerce.com/");

		ExtentTestManager.getTest().log(Status.INFO,"Step 02: Verify message");

		ExtentTestManager.getTest().log(Status.INFO,"Step 03: Into Compare products list");

		ExtentTestManager.getTest().log(Status.INFO,"Step 03: Verify display information product");

		ExtentTestManager.getTest().log(Status.INFO,"Step 03: Click Clear list button");

		ExtentTestManager.getTest().log(Status.INFO,"Step 03: Verify message display");

		ExtentTestManager.getTest().log(Status.INFO,"Step 03: Verify product undisplay in Compare page");
	}
	@Test
	public void TC_05_Recently_Viewed_Products(Method method){
		ExtentTestManager.startTest(method.getName(),"Recently_Viewed_Products");
		ExtentTestManager.getTest().log(Status.INFO,"Step 01: View detail 5 products any");

		ExtentTestManager.getTest().log(Status.INFO,"Step 02: Into page Recently viewed products");

		ExtentTestManager.getTest().log(Status.INFO,"Step 03: Verify only displays the last 3 products");
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
