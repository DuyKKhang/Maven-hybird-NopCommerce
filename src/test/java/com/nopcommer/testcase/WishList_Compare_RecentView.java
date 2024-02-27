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
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class WishList_Compare_RecentView extends BaseTest{
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
		customerInfoPage = homePage.clickToLinkMyAccount();
		firstNameAccount =  customerInfoPage.getTextCustomer("FirstName", "value");
		lastNameAccount = customerInfoPage.getTextCustomer("LastName", "value");

		computerPage = customerInfoPage.clickComputerLinkProduct("Computers");
		desktopsProductPage = computerPage.clickLinkProductDesktops("Desktops");
	}

	@Test
	public void TC_01_Add_To_WishList(Method method){
		ExtentTestManager.startTest(method.getName(),"Add_To_WishList");
		ExtentTestManager.getTest().log(Status.INFO,"Step 01: Click one product");

		detailProductPage = desktopsProductPage.clickProduct("1");

		ExtentTestManager.getTest().log(Status.INFO,"Step 02: Add to wishlist");
		detailProductPage.selectRamDropdown("2 GB");
		detailProductPage.clickHDDRadioButton();

		String nameProduct = detailProductPage.getNameProduct();
		String skuProduct = detailProductPage.getSkuProduct();
		String priceProduct = detailProductPage.getPriceProduct();

		detailProductPage.addToWishList();

		ExtentTestManager.getTest().log(Status.INFO,"Step 03: Verify message add success");
		verifyEquals(detailProductPage.getMessageAddWsihList(),"The product has been added to your wishlist");
		detailProductPage.closeMessage();

		ExtentTestManager.getTest().log(Status.INFO,"Step 04: Into wishlist page");
		wishlisPage = detailProductPage.clickWishlistLink();

		ExtentTestManager.getTest().log(Status.INFO,"Step 05: Verify product add success");
		verifyFalse(wishlisPage.verifyProductWishlistPage());
		verifyEquals(wishlisPage.getDetailNameProduct(),nameProduct);
		verifyEquals(wishlisPage.getDetailSkuProduct(),skuProduct);
		verifyEquals(wishlisPage.getDetailPriceProduct(),priceProduct);

		ExtentTestManager.getTest().log(Status.INFO,"Step 06: Click link your wishlist URL for sharing");
		wishlisPage.clickLinkWishlistSharing();
		verifyEquals(wishlisPage.getTitleWishlistSharing(),"Wishlist of "+ firstNameAccount+" "+lastNameAccount);
	}
	@Test
	public void TC_02_Add_Product_To_Cart_WishList_Page(Method method){
		ExtentTestManager.startTest(method.getName(),"Add_Product_To_Cart_WishList_Page");
		ExtentTestManager.getTest().log(Status.INFO,"Step 01: Checkbox product, Click Add to car");
		wishlisPage.clickWishlistLink();
		wishlisPage.checkBoxAddToCart();
		shoppingCartPage = wishlisPage.clickAddToCart();
		wishlisPage = shoppingCartPage.clickWishlistLink();

		ExtentTestManager.getTest().log(Status.INFO,"Step 02: Verify product remove Wishlist page");
		verifyFalse(wishlisPage.verifyProductWishlistPage());

		ExtentTestManager.getTest().log(Status.INFO,"Step 03: Verify product add to cart");
		shoppingCartPage = wishlisPage.clickShoppingCart();
		verifyTrue(shoppingCartPage.verifyProductShoppingCartPage()>= 1);
	}
	@Test
	public void TC_03_Remove_Product_in_WishList_Page(Method method){
		ExtentTestManager.startTest(method.getName(),"Remove_Product_in_WishList_Page");
		ExtentTestManager.getTest().log(Status.INFO,"Step 01: Select a product");
		driver.get("https://demo.nopcommerce.com");
		computerPage = homePage.clickComputerLinkProduct("Computers");
		desktopsProductPage = computerPage.clickLinkProductDesktops("Desktops");
		detailProductPage = desktopsProductPage.clickProduct("1");
		detailProductPage.selectRamDropdown("2 GB");
		detailProductPage.clickHDDRadioButton();

		ExtentTestManager.getTest().log(Status.INFO,"Step 02: Add to Wishlist");
		detailProductPage.addToWishList();

		ExtentTestManager.getTest().log(Status.INFO,"Step 03: Into wishlist");
		wishlisPage = detailProductPage.clickWishlistLink();

		ExtentTestManager.getTest().log(Status.INFO,"Step 04: Click checkbox remove");
		wishlisPage.clickRemoveProduct();

		ExtentTestManager.getTest().log(Status.INFO,"Step 05: Verify message");
		verifyEquals(wishlisPage.getTextMessageWishlistNull(),"The wishlist is empty!");

		ExtentTestManager.getTest().log(Status.INFO,"Step 06: Verify not display product");
		verifyTrue(wishlisPage.verifyProductWishlistPage());
		homePage = wishlisPage.clickHomePage();
	}
	@Test
	public void TC_04_Add_Product_To_Compare(Method method){
		ExtentTestManager.startTest(method.getName(),"Add_Product_To_Compare");
		ExtentTestManager.getTest().log(Status.INFO,"Step 01: Add two products to compare");
		String indexLocator = "2";
		homePage.clickAddToCompare(indexLocator);
		List<String> nameProduct = homePage.getNameProduct(indexLocator);
		List<String> priceProduct = homePage.getPriceProduct(indexLocator);

		ExtentTestManager.getTest().log(Status.INFO,"Step 02: Verify message");
		verifyEquals(homePage.getMessageAddCompareSuccess(),"The product has been added to your product comparison");

		ExtentTestManager.getTest().log(Status.INFO,"Step 03: Into Compare products list");
		compareProductsPage = homePage.clickCompareProduct();

		ExtentTestManager.getTest().log(Status.INFO,"Step 04: Verify display information product");
		verifyTrue(compareProductsPage.verifyNameProduct(nameProduct));
		verifyTrue(compareProductsPage.verifyPriceProduct(priceProduct));

		ExtentTestManager.getTest().log(Status.INFO,"Step 05: Click Clear list button");
		compareProductsPage.clickClearListCompare();

		ExtentTestManager.getTest().log(Status.INFO,"Step 05: Verify message display");
		verifyEquals(compareProductsPage.getMessageComparePageHadEmpty(),"You have no items to compare.");

		ExtentTestManager.getTest().log(Status.INFO,"Step 07: Verify product undisplay in Compare page");
		verifyTrue(compareProductsPage.isDisplayComparePage());
		homePage = compareProductsPage.clickHomePage();
	}
	@Test
	public void TC_05_Recently_Viewed_Products(Method method){
		ExtentTestManager.startTest(method.getName(),"Recently_Viewed_Products");
		ExtentTestManager.getTest().log(Status.INFO,"Step 01: View detail 5 products any");
		driver.get("https://demo.nopcommerce.com");
		List<String> allNameProduct = new ArrayList<>();
		List<String> allPriceProduct = new ArrayList<>();
		int productNumber = 4;
		for (int i = 1; i <= productNumber; i++) {
			detailProductPage = homePage.clickViewDetailProduct(i);
			allNameProduct.add(detailProductPage.getNameProduct());
			allPriceProduct.add(detailProductPage.getPriceProduct());
			homePage = detailProductPage.backPreviousPage();
		}
		List<String> nameProduct = new ArrayList<>();
		List<String> priceProduct = new ArrayList<>();

		int sizeListAllName = allNameProduct.size();
		if(sizeListAllName>3){
			for (int i = 1; i <= 3; i++) {
				nameProduct.add(allNameProduct.get(i));
				priceProduct.add(allPriceProduct.get(i));
			}
		}else {
			for(int i=1; i<=sizeListAllName;i++){
				nameProduct.add(allNameProduct.get(i));
				priceProduct.add(allPriceProduct.get(i));
			}
		}

		ExtentTestManager.getTest().log(Status.INFO,"Step 02: Into page Recently viewed products");
		recentlyViewedProductsPage = homePage.clickRecentlyViewProducts();

		ExtentTestManager.getTest().log(Status.INFO,"Step 03: Verify only displays the last 3 products");
		verifyTrue(recentlyViewedProductsPage.verifyNameProduct(nameProduct));
		verifyTrue(recentlyViewedProductsPage.verifyPriceProduct(priceProduct));
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
