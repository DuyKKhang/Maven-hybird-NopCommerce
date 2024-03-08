package com.nopcommer.testcase;

import com.aventstack.extentreports.Status;
import commons.BaseTest;
import commons.PageGeneratorManagerUser;
import dataUser.UserData;
import dataUser.UserDataMapper;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import pageObject.NopCommerUser.*;
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
	private ShoppingCartPageObject shoppingCartPage;
	private CustomerInfoPageObject customerInfoPage;
	private DetailProductPageObject detailProductPage;
	private CheckOutPageObject checkOutPage;
	private OrdersProductPageObject ordersProductPage;
	private String email, passWord;
	private UserDataMapper userData;
	private String firstName, lastName, emailAccount, city, address1, postalCode, phoneNumber, country, cardNumber, cardCode, expDay, expYear;

	@Parameters({ "evnName", "serverName", "browser" })
	@BeforeClass
	public void beforeClass( String evnName, String serverName, String browser) {
		driver = getBrowserDriver(evnName, serverName, browser);

		homePage = PageGeneratorManagerUser.getHomePageObject(driver);

		email = UserData.Register.EMAIL;
		passWord = UserData.Register.PASSWORD;
		loginPage = homePage.clickToLinkLogin();

		userData = UserDataMapper.getUserDataMapper();
		firstName = userData.getAddressFirstName();
		lastName = userData.getAddressLastName();
		emailAccount = userData.getAddressEmail();
		city = userData.getAddressCity();
		address1 = userData.getAddressAddress_1();
		postalCode = userData.getAddressZip();
		country = "Viet Nam";
		cardNumber = userData.getCardNumber();
		cardCode = userData.getCarCode();
		expDay = userData.getExpDate_day();
		expYear = userData.getExpDate_year();
		phoneNumber = userData.getAddressFaxNumber();

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
		detailProductPage.selectProcessor("2");
		detailProductPage.selectRamDropdown("8GB [+$60.00]");
		detailProductPage.clickHDDRadioButton("2");
		detailProductPage.clickOS("2");
		detailProductPage.clickSoftWare();

		String nameProduct = detailProductPage.getNameProduct();
		String processor = detailProductPage.getProcessor("2");
		String ram = detailProductPage.getRam("5");
		String hdd = detailProductPage.getHDD("2");
		String os = detailProductPage.getOS("2");
		List<String> softWare = new ArrayList<>();
		softWare = detailProductPage.getSoftWare("3");
		String softWareText = String.join("", softWare);
		String quantity = detailProductPage.getQuantity("value");
		String priceProduct = detailProductPage.getPriceProduct();

		detailProductPage.clickAddToCart();

		ExtentTestManager.getTest().log(Status.INFO,"Step 03: Verify message success");
		verifyEquals(detailProductPage.getMessageAddProduct(),"The product has been added to your shopping cart");

		detailProductPage.closeMessage();

		detailProductPage.displayShoppingCart();
		String nameProductShoppingCart = detailProductPage.getNameProductShoppingCart();
		String informationProduct = detailProductPage.getInformationShoppingCart();
		String unitPrice = detailProductPage.getUnitPriceShoppingCart();
		String quantityShoppingCart = detailProductPage.getQuantityShoppingCart();
		String subTotal = detailProductPage.getSubTotalShoppingCart();

		ExtentTestManager.getTest().log(Status.INFO,"Step 03: Verify product added sopping cart");

		verifyEquals(nameProduct, nameProductShoppingCart);
		String information = processor.trim() + "\n" + ram.trim() + "\n" + hdd.trim() + "\n" + os.trim() + "\n" + softWareText;
		verifyTrue(information.contains(informationProduct));
		verifyEquals(quantity,quantityShoppingCart);
		verifyEquals(priceProduct, unitPrice);
		verifyEquals(priceProduct, subTotal);

		System.out.println("priceProduct: "+priceProduct);
		System.out.println("unitPrice: "+unitPrice);
		System.out.println("subTotal: "+subTotal);

	}
	@Test
	public void TC_02_Edit_Product_In_Shopping_Cart(Method method) {
		ExtentTestManager.startTest(method.getName(), "Edit_Product_In_Shopping_Cart");
		ExtentTestManager.getTest().log(Status.INFO, "Step 01: Open shopping cart");
		shoppingCartPage = detailProductPage.clickShoppingCart();

		ExtentTestManager.getTest().log(Status.INFO, "Step 01: Edit product");
		detailProductPage = shoppingCartPage.clickEditProduct();

		detailProductPage.selectProcessor("1");
		detailProductPage.selectRamDropdown("4GB [+$20.00]");
		detailProductPage.clickHDDRadioButton("1");
		detailProductPage.clickOS("1");
		detailProductPage.clickSoftWare("1");
		int quantity = 3;
		detailProductPage.increaseQuantity(Integer.toString(quantity));

		String processor = detailProductPage.getProcessor("1");
		String ram = detailProductPage.getRam("4");
		String hdd = detailProductPage.getHDD("1");
		String os = detailProductPage.getOS("1");
		List<String> softWare = new ArrayList<>();
		softWare = detailProductPage.getSoftWare("1");
		String softWareText = String.join("", softWare);
//		String quantity = detailProductPage.getQuantity("value");
		String priceProduct = detailProductPage.getPriceProduct();
		String totalPriceProduct = detailProductPage.getTotalPriceProduct(priceProduct,quantity);

		ExtentTestManager.getTest().log(Status.INFO, "Step 01: Verify price");
		verifyEquals(priceProduct,"$1,320.00");

		detailProductPage.clickAddToCart();

		ExtentTestManager.getTest().log(Status.INFO, "Step 01: Verify message");
		verifyEquals(detailProductPage.getMessageAddProduct(),"The product has been added to your shopping cart");

		detailProductPage.closeMessage();

		ExtentTestManager.getTest().log(Status.INFO, "Step 01: Verify product information has been update successfully");
		detailProductPage.displayShoppingCart();
		String informationProduct = detailProductPage.getInformationShoppingCart();
		String unitPrice = detailProductPage.getUnitPriceShoppingCart();
		String quantityShoppingCart = detailProductPage.getQuantityShoppingCart();
		String subTotal = detailProductPage.getSubTotalShoppingCart();
		String information = processor.trim() + "\n" + ram.trim() + "\n" + hdd.trim() + "\n" + os.trim() + "\n" + softWareText;
		verifyTrue(information.contains(informationProduct));
		verifyEquals(Integer.toString(quantity),quantityShoppingCart);
		verifyEquals(priceProduct, unitPrice);


		ExtentTestManager.getTest().log(Status.INFO, "Step 01: Verify total pay shopping cart");
		verifyEquals(totalPriceProduct, subTotal);
	}
	@Test
	public void TC_03_Remove_Frome_Cart(Method method) {
		ExtentTestManager.startTest(method.getName(), "Remove_Frome_Cart");
		ExtentTestManager.getTest().log(Status.INFO, "Step 01: Open the shopping cart with product");
		shoppingCartPage = detailProductPage.clickShoppingCart();

		ExtentTestManager.getTest().log(Status.INFO, "Step 02: Choose remove and click update");
		shoppingCartPage.removeProduct();

		ExtentTestManager.getTest().log(Status.INFO, "Step 03: Verify message");
		verifyEquals(shoppingCartPage.getMessageRemoveProduct(),"Your Shopping Cart is empty!");

		ExtentTestManager.getTest().log(Status.INFO, "Step 04: Verify product undisplayed in shopping cart");
		verifyTrue(shoppingCartPage.isUnDisplayed());
		homePage = shoppingCartPage.clickHomePage();
	}
	@Test
	public void TC_04_Update_Shopping_Cart(Method method) {
		ExtentTestManager.startTest(method.getName(), "Update_Shopping_Cart");
		ExtentTestManager.getTest().log(Status.INFO, "Step 01: Add a product into shopping cart");

		computerPage = homePage.clickComputerLinkProduct("Computers");

		desktopsProductPage = computerPage.clickLinkProductDesktops("Desktops");

		detailProductPage = desktopsProductPage.clickProduct("3");

		detailProductPage.clickAddToCart();

		verifyEquals(detailProductPage.getMessageAddProduct(),"The product has been added to your shopping cart");

		detailProductPage.closeMessage();

		shoppingCartPage = detailProductPage.clickShoppingCart();
		ExtentTestManager.getTest().log(Status.INFO, "Step 01: Increase QTY 5 and Click update shopping cart");
		shoppingCartPage.changeQuantity("5");
		shoppingCartPage.clickUpdate();

		ExtentTestManager.getTest().log(Status.INFO, "Step 01: Verify total increase");
		String totalAfterUpdateQuantity = shoppingCartPage.getTotal();
		verifyEquals(totalAfterUpdateQuantity,"$2,500.00");

		shoppingCartPage.removeProduct();

		homePage = shoppingCartPage.clickHomePage();
	}
	@Test
	public void TC_05_Checkout_Payment_Method_By_Cheque(Method method) {
		ExtentTestManager.startTest(method.getName(), "Checkout_Payment_Method_By_Cheque");
		ExtentTestManager.getTest().log(Status.INFO, "Step 01: Added product into shopping cart");
//		driver.get("https://demo.nopcommerce.com/");
		computerPage = homePage.clickComputerLinkProduct("Computers");

		desktopsProductPage = computerPage.clickLinkProductDesktops("Notebooks ");
		detailProductPage = desktopsProductPage.clickProduct("1");

		String nameProduct = detailProductPage.getNameProduct();
		String skuProduct = detailProductPage.getSkuProduct();
		String quantityProduct = detailProductPage.getQuantity("value");
		String priceProduct = detailProductPage.getPriceProduct();

		detailProductPage.clickAddToCart();

		verifyEquals(detailProductPage.getMessageAddProduct(),"The product has been added to your shopping cart");

		detailProductPage.closeMessage();

		shoppingCartPage = detailProductPage.clickShoppingCart();
		String totalPriceProduct = shoppingCartPage.getTotal();

        ExtentTestManager.getTest().log(Status.INFO, "Step 02: Input information and click Checkout");
		String giftWrappingProduct = shoppingCartPage.getGiftWrappingProduct();
        shoppingCartPage.clickTermsOfService();
        checkOutPage = shoppingCartPage.clickCheckOut();

		ExtentTestManager.getTest().log(Status.INFO, "Step 03: Input information Bulling Address");
		checkOutPage.checkShipToSameAddress();
        checkOutPage.sendKeyInformationBilingAddress(firstName,"FirstName");
        checkOutPage.sendKeyInformationBilingAddress(lastName,"LastName");
        checkOutPage.sendKeyInformationBilingAddress(emailAccount,"Email");
		checkOutPage.selectCountryBilingAddress(country);
        checkOutPage.sendKeyInformationBilingAddress(city,"City");
        checkOutPage.sendKeyInformationBilingAddress(address1,"Address1");
        checkOutPage.sendKeyInformationBilingAddress(postalCode,"ZipPostalCode");
        checkOutPage.sendKeyInformationBilingAddress(phoneNumber,"PhoneNumber");

		checkOutPage.clickContinueBillingAddres();

		ExtentTestManager.getTest().log(Status.INFO, "Step 04: Choose shopping method");
		checkOutPage.chooseShippingMethod("1");
		String shippingMethodTextBefore = checkOutPage.getTextShippingMethod();
		String shippingMethodTextAfter = checkOutPage.getTextAfter(shippingMethodTextBefore);
		checkOutPage.clickContinueShippingAddress();

		ExtentTestManager.getTest().log(Status.INFO, "Step 05: Choose Payment method (Cheque)");
		String indexItemPaymentMethod = "1";
		checkOutPage.choosePaymentgMethod(indexItemPaymentMethod);
		String paymentMethodText = checkOutPage.getTextPaymentMethod(indexItemPaymentMethod);
		checkOutPage.clickContinuePaymentMethod();

		ExtentTestManager.getTest().log(Status.INFO, "Step 06: Verify information Payment");
		verifyEquals(checkOutPage.getMessagePaymendInformation(),"P.S. You can edit this text from admin panel.");
		checkOutPage.clickContinuePaymendInformation();

		ExtentTestManager.getTest().log(Status.INFO, "Step 07: Verify order and click confirm");
		String nameBillingAddress = checkOutPage.getInformationBillingAddress("name");
		String emailBillingAddress = checkOutPage.getInformationBillingAddress("email");
		String phoneBillingAddress = checkOutPage.getInformationBillingAddress("phone");
		String addressBillingAddress = checkOutPage.getInformationBillingAddress("address1");
		String zipBillingAddress = checkOutPage.getInformationBillingAddress("city-state-zip");
		String countryBillingAddress = checkOutPage.getInformationBillingAddress("country");
		String paymentBillingAddress = checkOutPage.getInformationBillingAddress("payment-method");

		String nameShippingAddress = checkOutPage.getInformationShippingAddress("name");
		String emailShippingAddress = checkOutPage.getInformationShippingAddress("email");
		String phoneShippingAddress = checkOutPage.getInformationShippingAddress("phone");
		String addressShippingAddress = checkOutPage.getInformationShippingAddress("address1");
		String zipShippingAddress = checkOutPage.getInformationShippingAddress("city-state-zip");
		String countryShippingAddress = checkOutPage.getInformationShippingAddress("country");
		String shippingShippingAddress = checkOutPage.getInformationShippingAddress("shipping-method");

		String skuConfirn = checkOutPage.getInformationProductConfirm("sku-number");
		String nameProductConfirn =checkOutPage.getNameProductConfirm();
		String priceConfirn =checkOutPage.getInformationProductConfirm("product-unit-price");
		String qtyConfirn =checkOutPage.getInformationProductConfirm("product-quantity");
		String totalConfirn =checkOutPage.getInformationProductConfirm("product-subtotal");

		String giftWrappingConfirn =checkOutPage.getStatusGiftWrapping();
		String subTotalConfirn =checkOutPage.getTotalProductConfirm();

		verifyEquals(firstName+" "+lastName,nameBillingAddress);
		verifyEquals("Email: "+emailAccount,emailBillingAddress);
		verifyEquals("Phone: "+phoneNumber,phoneBillingAddress);
		verifyEquals(address1,addressBillingAddress);
		verifyEquals(city+","+ postalCode,zipBillingAddress);
		verifyEquals(country,countryBillingAddress);
		verifyEquals("Payment Method: "+paymentMethodText,paymentBillingAddress);

		verifyEquals(firstName+" "+lastName,nameShippingAddress);
		verifyEquals("Email: "+emailAccount,emailShippingAddress);
		verifyEquals("Phone: "+phoneNumber,phoneShippingAddress);
		verifyEquals(address1,addressShippingAddress);
		verifyEquals(city+","+postalCode,zipShippingAddress);
		verifyEquals(country,countryShippingAddress);
		verifyEquals("Shipping Method: "+shippingMethodTextAfter,shippingShippingAddress);

		verifyEquals(skuProduct,skuConfirn);
		verifyEquals(nameProduct,nameProductConfirn);
		verifyEquals(priceProduct,priceConfirn);
		verifyEquals(quantityProduct,qtyConfirn);
		verifyEquals(totalPriceProduct,totalConfirn);
		verifyEquals("Gift wrapping: "+giftWrappingProduct,giftWrappingConfirn);
		verifyEquals(totalPriceProduct,subTotalConfirn);
		checkOutPage.clickContinueConfirm();

		ExtentTestManager.getTest().log(Status.INFO, "Step 08: Verify success message and order number");
		verifyEquals(checkOutPage.getMessageOrderSuccess(),"Your order has been successfully processed!");
		String orderNumber = checkOutPage.getOrderNumber();
		homePage = checkOutPage.clickContinueOrder();

		ExtentTestManager.getTest().log(Status.INFO, "Step 09: Into my account > other > verify information display");
		customerInfoPage = homePage.clickToLinkMyAccount();
		ordersProductPage= customerInfoPage.clickOrder();
		String orderNumberMyAccount = ordersProductPage.getOrderNumberMyAccount();
		verifyEquals(orderNumber,orderNumberMyAccount);
		ordersProductPage.clickDetails();

		String orderStatus = ordersProductPage.getOrderStatus();
		String orderTotal = ordersProductPage.getOrderTotal();

		String orderNameBillingAddress = ordersProductPage.getInformationBillingAddress("name");
		String orderEmailBillingAddress = ordersProductPage.getInformationBillingAddress("email");
		String orderPhoneBillingAddress = ordersProductPage.getInformationBillingAddress("phone");
		String orderAddressBillingAddress = ordersProductPage.getInformationBillingAddress("address1");
		String orderZipBillingAddress = ordersProductPage.getInformationBillingAddress("city-state-zip");
		String orderCountryBillingAddress = ordersProductPage.getInformationBillingAddress("country");
		String orderPaymentBillingAddress = ordersProductPage.getPayMentOrder();
		String orderPaymentStatusBillingAddress = ordersProductPage.getPayMentStatusOrder();

		String orderNameShippingAddress = ordersProductPage.getInformationShippingAddress("name");
		String orderEmailShippingAddress = ordersProductPage.getInformationShippingAddress("email");
		String orderPhoneShippingAddress = ordersProductPage.getInformationShippingAddress("phone");
		String orderAddressShippingAddress = ordersProductPage.getInformationShippingAddress("address1");
		String orderZipShippingAddress = ordersProductPage.getInformationShippingAddress("city-state-zip");
		String orderCountryShippingAddress = ordersProductPage.getInformationShippingAddress("country");
		String orderShippingShippingAddress = ordersProductPage.getShippingOrder();;
		String orderShippingStatusShippingAddress = ordersProductPage.getShippingStatusOrder();

		String orderSku =ordersProductPage.getInformationOrderDetails("sku");
		String orderProduct =ordersProductPage.getNameInformationOrderDetails();
		String orderPrice =ordersProductPage.getInformationOrderDetails("unit-price");
		String orderQty =ordersProductPage.getInformationOrderDetails("quantity");
		String orderTotalFinals =ordersProductPage.getInformationOrderDetails("total");
		String orderGiftWrapping =ordersProductPage.getGiftWrappingOrderDetails();
		String orderSubTotal =ordersProductPage.getOrderTotalDetails();

		ExtentTestManager.getTest().log(Status.INFO, "Step 10: verify information display  correct");
		verifyTrue(orderStatus.contains("Pending"));
		verifyEquals(orderTotal,orderSubTotal);
		verifyEquals(firstName+" "+lastName,orderNameBillingAddress);
		verifyEquals("Email: "+emailAccount,orderEmailBillingAddress);
		verifyEquals("Phone: "+phoneNumber,orderPhoneBillingAddress);
		verifyEquals(address1,orderAddressBillingAddress);
		verifyEquals(city+","+postalCode,orderZipBillingAddress);
		verifyEquals(country,orderCountryBillingAddress);
		verifyEquals("Shipping Method: "+shippingMethodTextAfter,shippingShippingAddress);
		verifyTrue(orderPaymentStatusBillingAddress.contains("Pending"));

		verifyEquals(firstName+" "+lastName,orderNameShippingAddress);
		verifyEquals("Email: "+emailAccount,orderEmailShippingAddress);
		verifyEquals("Phone: "+phoneNumber,orderPhoneShippingAddress);
		verifyEquals(address1,orderAddressShippingAddress);
		verifyEquals(city+","+postalCode,orderZipShippingAddress);
		verifyEquals(country,orderCountryShippingAddress);
		verifyEquals("Shipping Method: "+shippingMethodTextAfter,shippingShippingAddress);
		verifyTrue(orderShippingStatusShippingAddress.contains("Not yet shipped"));

		verifyEquals(skuProduct,orderSku);
		verifyEquals(nameProduct,orderProduct);
		verifyEquals(priceProduct,orderPrice);
		verifyEquals(quantityProduct,orderQty);
		verifyEquals(totalPriceProduct,orderTotalFinals);
		verifyEquals("Gift wrapping: "+giftWrappingProduct,orderGiftWrapping);
		verifyEquals(totalPriceProduct,orderSubTotal);
		homePage = ordersProductPage.clickHomePage();
	}
	@Test
	public void TC_06_Checkout_Payment_Method_By_Card(Method method) {
		ExtentTestManager.startTest(method.getName(), "Checkout_Payment_Method_By_Card");
		ExtentTestManager.getTest().log(Status.INFO, "Step 01: Added product into shopping cart");
//		homePage = shoppingCartPage.clickHomePage();
		computerPage = homePage.clickComputerLinkProduct("Computers");

		desktopsProductPage = computerPage.clickLinkProductDesktops("Notebooks ");
		detailProductPage = desktopsProductPage.clickProduct("1");

		String nameProduct = detailProductPage.getNameProduct();
		String skuProduct = detailProductPage.getSkuProduct();
		String quantityProduct = detailProductPage.getQuantity("value");
		String priceProduct = detailProductPage.getPriceProduct();

		detailProductPage.clickAddToCart();

		verifyEquals(detailProductPage.getMessageAddProduct(), "The product has been added to your shopping cart");

		detailProductPage.closeMessage();

		shoppingCartPage = detailProductPage.clickShoppingCart();
		String totalPriceProduct = shoppingCartPage.getTotal();

		ExtentTestManager.getTest().log(Status.INFO, "Step 02: Input information and click Checkout");
		String giftWrappingProduct = shoppingCartPage.getGiftWrappingProduct();
		shoppingCartPage.clickTermsOfService();
		checkOutPage = shoppingCartPage.clickCheckOut();

		ExtentTestManager.getTest().log(Status.INFO, "Step 03: Input information Bulling Address");
		checkOutPage.checkShipToSameAddress();
		checkOutPage.clickEditButton();
		checkOutPage.sendKeyInformationBilingAddress(firstName,"FirstName");
		checkOutPage.sendKeyInformationBilingAddress(lastName,"LastName");
		checkOutPage.sendKeyInformationBilingAddress(email,"Email");
		checkOutPage.selectCountryBilingAddress(country);
		checkOutPage.sendKeyInformationBilingAddress(city,"City");
		checkOutPage.sendKeyInformationBilingAddress(address1,"Address1");
		checkOutPage.sendKeyInformationBilingAddress(postalCode,"ZipPostalCode");
		checkOutPage.sendKeyInformationBilingAddress(phoneNumber,"PhoneNumber");

		checkOutPage.clickContinueBillingAddres();

		ExtentTestManager.getTest().log(Status.INFO, "Step 04: Choose shopping method");
		checkOutPage.chooseShippingMethod("1");
		String shippingMethodTextBefore = checkOutPage.getTextShippingMethod();
		String shippingMethodTextAfter = checkOutPage.getTextAfter(shippingMethodTextBefore);
		checkOutPage.clickContinueShippingAddress();


		ExtentTestManager.getTest().log(Status.INFO, "Step 05: Choose Payment method (Credit Card)");
		String indexItemPaymentMethod = "2";
		checkOutPage.choosePaymentgMethod(indexItemPaymentMethod);
		String paymentMethodText = checkOutPage.getTextPaymentMethod(indexItemPaymentMethod);
		checkOutPage.clickContinuePaymentMethod();

		ExtentTestManager.getTest().log(Status.INFO, "Step 06: Verify information Payment");

		checkOutPage.selectCreditCart("visa","CreditCardType");
		checkOutPage.inputInformationCreditCart(lastName+firstName,"CardholderName");
		checkOutPage.inputInformationCreditCart(cardNumber,"CardNumber");
		checkOutPage.selectCreditCart(expDay,"ExpireMonth");
		checkOutPage.selectCreditCart(expYear,"ExpireYear");
		checkOutPage.inputInformationCreditCart(cardCode,"CardCode");

		checkOutPage.clickContinuePaymendInformation();

		ExtentTestManager.getTest().log(Status.INFO, "Step 07: Verify order and click confirm");
		String nameBillingAddress = checkOutPage.getInformationBillingAddress("name");
		String emailBillingAddress = checkOutPage.getInformationBillingAddress("email");
		String phoneBillingAddress = checkOutPage.getInformationBillingAddress("phone");
		String addressBillingAddress = checkOutPage.getInformationBillingAddress("address1");
		String zipBillingAddress = checkOutPage.getInformationBillingAddress("city-state-zip");
		String countryBillingAddress = checkOutPage.getInformationBillingAddress("country");
		String paymentBillingAddress = checkOutPage.getInformationBillingAddress("payment-method");

		String nameShippingAddress = checkOutPage.getInformationShippingAddress("name");
		String emailShippingAddress = checkOutPage.getInformationShippingAddress("email");
		String phoneShippingAddress = checkOutPage.getInformationShippingAddress("phone");
		String addressShippingAddress = checkOutPage.getInformationShippingAddress("address1");
		String zipShippingAddress = checkOutPage.getInformationShippingAddress("city-state-zip");
		String countryShippingAddress = checkOutPage.getInformationShippingAddress("country");
		String shippingShippingAddress = checkOutPage.getInformationShippingAddress("shipping-method");

		String skuConfirn = checkOutPage.getInformationProductConfirm("sku-number");
		String nameProductConfirn =checkOutPage.getNameProductConfirm();
		String priceConfirn =checkOutPage.getInformationProductConfirm("product-unit-price");
		String qtyConfirn =checkOutPage.getInformationProductConfirm("product-quantity");
		String totalConfirn =checkOutPage.getInformationProductConfirm("product-subtotal");

		String giftWrappingConfirn =checkOutPage.getStatusGiftWrapping();
		String subTotalConfirn =checkOutPage.getTotalProductConfirm();

		verifyEquals(firstName+" "+lastName,nameBillingAddress);
		verifyEquals("Email: "+emailAccount,emailBillingAddress);
		verifyEquals("Phone: "+phoneNumber,phoneBillingAddress);
		verifyEquals(address1,addressBillingAddress);
		verifyEquals(city+","+ postalCode,zipBillingAddress);
		verifyEquals(country,countryBillingAddress);
		verifyEquals("Payment Method: "+paymentMethodText,paymentBillingAddress);

		verifyEquals(firstName+" "+lastName,nameShippingAddress);
		verifyEquals("Email: "+emailAccount,emailShippingAddress);
		verifyEquals("Phone: "+phoneNumber,phoneShippingAddress);
		verifyEquals(address1,addressShippingAddress);
		verifyEquals(city+","+postalCode,zipShippingAddress);
		verifyEquals(country,countryShippingAddress);
		verifyEquals("Shipping Method: "+shippingMethodTextAfter,shippingShippingAddress);

		verifyEquals(skuProduct,skuConfirn);
		verifyEquals(nameProduct,nameProductConfirn);
		verifyEquals(priceProduct,priceConfirn);
		verifyEquals(quantityProduct,qtyConfirn);
		verifyEquals(totalPriceProduct,totalConfirn);
		verifyEquals("Gift wrapping: "+giftWrappingProduct,giftWrappingConfirn);
		verifyEquals(totalPriceProduct,subTotalConfirn);
		checkOutPage.clickContinueConfirm();


		ExtentTestManager.getTest().log(Status.INFO, "Step 08: Verify success message and order number");
		verifyEquals(checkOutPage.getMessageOrderSuccess(),"Your order has been successfully processed!");
		String orderNumber = checkOutPage.getOrderNumber();
		homePage = checkOutPage.clickContinueOrder();

		ExtentTestManager.getTest().log(Status.INFO, "Step 09: Into my account > other > verify information display");

		customerInfoPage = homePage.clickToLinkMyAccount();
		ordersProductPage= customerInfoPage.clickOrder();
		String orderNumberMyAccount = ordersProductPage.getOrderNumberMyAccount();
		verifyEquals(orderNumber,orderNumberMyAccount);
		ordersProductPage.clickDetails();

		String orderStatus = ordersProductPage.getOrderStatus();
		String orderTotal = ordersProductPage.getOrderTotal();

		String orderNameBillingAddress = ordersProductPage.getInformationBillingAddress("name");
		String orderEmailBillingAddress = ordersProductPage.getInformationBillingAddress("email");
		String orderPhoneBillingAddress = ordersProductPage.getInformationBillingAddress("phone");
		String orderAddressBillingAddress = ordersProductPage.getInformationBillingAddress("address1");
		String orderZipBillingAddress = ordersProductPage.getInformationBillingAddress("city-state-zip");
		String orderCountryBillingAddress = ordersProductPage.getInformationBillingAddress("country");
		String orderPaymentBillingAddress = ordersProductPage.getPayMentOrder();
		String orderPaymentStatusBillingAddress = ordersProductPage.getPayMentStatusOrder();

		String orderNameShippingAddress = ordersProductPage.getInformationShippingAddress("name");
		String orderEmailShippingAddress = ordersProductPage.getInformationShippingAddress("email");
		String orderPhoneShippingAddress = ordersProductPage.getInformationShippingAddress("phone");
		String orderAddressShippingAddress = ordersProductPage.getInformationShippingAddress("address1");
		String orderZipShippingAddress = ordersProductPage.getInformationShippingAddress("city-state-zip");
		String orderCountryShippingAddress = ordersProductPage.getInformationShippingAddress("country");
		String orderShippingShippingAddress = ordersProductPage.getShippingOrder();;
		String orderShippingStatusShippingAddress = ordersProductPage.getShippingStatusOrder();

		String orderSku =ordersProductPage.getInformationOrderDetails("sku");
		String orderProduct =ordersProductPage.getNameInformationOrderDetails();
		String orderPrice =ordersProductPage.getInformationOrderDetails("unit-price");
		String orderQty =ordersProductPage.getInformationOrderDetails("quantity");
		String orderTotalFinals =ordersProductPage.getInformationOrderDetails("total");
		String orderGiftWrapping =ordersProductPage.getGiftWrappingOrderDetails();
		String orderSubTotal =ordersProductPage.getOrderTotalDetails();

		ExtentTestManager.getTest().log(Status.INFO, "Step 10: verify information display  correct");
		verifyTrue(orderStatus.contains("Pending"));
		verifyEquals(orderTotal,orderSubTotal);
		verifyEquals(firstName+" "+lastName,orderNameBillingAddress);
		verifyEquals("Email: "+emailAccount,orderEmailBillingAddress);
		verifyEquals("Phone: "+phoneNumber,orderPhoneBillingAddress);
		verifyEquals(address1,orderAddressBillingAddress);
		verifyEquals(city+","+postalCode,orderZipBillingAddress);
		verifyEquals(country,orderCountryBillingAddress);
		verifyEquals("Payment Method: "+paymentMethodText,paymentBillingAddress);
		verifyTrue(orderPaymentStatusBillingAddress.contains("Pending"));

		verifyEquals(firstName+" "+lastName,orderNameShippingAddress);
		verifyEquals("Email: "+emailAccount,orderEmailShippingAddress);
		verifyEquals("Phone: "+phoneNumber,orderPhoneShippingAddress);
		verifyEquals(address1,orderAddressShippingAddress);
		verifyEquals(city+","+postalCode,orderZipShippingAddress);
		verifyEquals(country,orderCountryShippingAddress);
		verifyEquals("Shipping Method: "+shippingMethodTextAfter,shippingShippingAddress);
		verifyTrue(orderShippingStatusShippingAddress.contains("Not yet shipped"));


		verifyEquals(skuProduct,orderSku);
		verifyEquals(nameProduct,orderProduct);
		verifyEquals(priceProduct,orderPrice);
		verifyEquals(quantityProduct,orderQty);
		verifyEquals(totalPriceProduct,orderTotalFinals);
		verifyEquals("Gift wrapping: "+giftWrappingProduct,orderGiftWrapping);
		verifyEquals(totalPriceProduct,orderSubTotal);
		homePage = ordersProductPage.clickHomePage();
	}
	@Test
	public void TC_07_Re_Order(Method method) {
		ExtentTestManager.startTest(method.getName(), "Re_Order");
		ExtentTestManager.getTest().log(Status.INFO, "Step 01: Have oder product is success");
		customerInfoPage = homePage.clickToLinkMyAccount();
		ordersProductPage= customerInfoPage.clickOrder();

		ExtentTestManager.getTest().log(Status.INFO, "Step 02: Click details");
		ordersProductPage.clickDetails();

		ExtentTestManager.getTest().log(Status.INFO, "Step 03: Click re-order");
		shoppingCartPage = ordersProductPage.clickreOrder();

		ExtentTestManager.getTest().log(Status.INFO, "Step 04: Update information");
		shoppingCartPage.changeQuantity("5");
		shoppingCartPage.clickUpdate();

//		String nameProduct = checkOutPage.getInformationProductConfirm("sku-number");
//		String skuProduct = checkOutPage.getNameProductConfirm();
//		String quantityProduct = checkOutPage.getInformationProductConfirm("product-quantity");
//		String priceProduct = shoppingCartPage.getPriceProduct();
//
//
//		String skuConfirn = checkOutPage.getInformationProductConfirm("sku-number");
//		String nameProductConfirn =checkOutPage.getNameProductConfirm();
//		String priceConfirn =checkOutPage.getInformationProductConfirm("product-unit-price");
//		String qtyConfirn =checkOutPage.getInformationProductConfirm("product-quantity");
//		String totalConfirn =checkOutPage.getInformationProductConfirm("product-subtotal");
//
//		String giftWrappingConfirn =checkOutPage.getStatusGiftWrapping();
//		String subTotalConfirn =checkOutPage.getTotalProductConfirm();

		shoppingCartPage.clickTermsOfService();
		checkOutPage = shoppingCartPage.clickCheckOut();

		checkOutPage.selectNewAddress("New Address");
		String firstNameRandom = firstName+random();
		String lastNameRandom = lastName+random();
		String emailRandom = random()+emailAccount;
		String cityRandom = city+random();
		String address1Random = address1+random();
		String postalCodeRandom = postalCode+random();
		String phoneNumberRandom = phoneNumber+random();

		checkOutPage.checkShipToSameAddress();
		checkOutPage.sendKeyInformationBilingAddress(firstNameRandom,"FirstName");
		checkOutPage.sendKeyInformationBilingAddress(lastNameRandom,"LastName");
		checkOutPage.sendKeyInformationBilingAddress(emailRandom,"Email");
		checkOutPage.selectCountryBilingAddress(country);
		checkOutPage.sendKeyInformationBilingAddress(cityRandom,"City");
		checkOutPage.sendKeyInformationBilingAddress(address1Random,"Address1");
		checkOutPage.sendKeyInformationBilingAddress(postalCodeRandom,"ZipPostalCode");
		checkOutPage.sendKeyInformationBilingAddress(phoneNumberRandom,"PhoneNumber");

		checkOutPage.clickContinueBillingAddres();

		ExtentTestManager.getTest().log(Status.INFO, "Step 04: Choose shopping method");
		checkOutPage.chooseShippingMethod("1");
		String shippingMethodTextBefore = checkOutPage.getTextShippingMethod();
		String shippingMethodTextAfter = checkOutPage.getTextAfter(shippingMethodTextBefore);
		checkOutPage.clickContinueShippingAddress();

		ExtentTestManager.getTest().log(Status.INFO, "Step 05: Choose Payment method (Cheque)");
		String indexItemPaymentMethod = "1";
		checkOutPage.choosePaymentgMethod(indexItemPaymentMethod);
		String paymentMethodText = checkOutPage.getTextPaymentMethod(indexItemPaymentMethod);
		checkOutPage.clickContinuePaymentMethod();

		ExtentTestManager.getTest().log(Status.INFO, "Step 06: Verify information Payment");
		verifyEquals(checkOutPage.getMessagePaymendInformation(),"P.S. You can edit this text from admin panel.");
		checkOutPage.clickContinuePaymendInformation();

		ExtentTestManager.getTest().log(Status.INFO, "Step 07: Verify order and click confirm");
		String nameBillingAddress = checkOutPage.getInformationBillingAddress("name");
		String emailBillingAddress = checkOutPage.getInformationBillingAddress("email");
		String phoneBillingAddress = checkOutPage.getInformationBillingAddress("phone");
		String addressBillingAddress = checkOutPage.getInformationBillingAddress("address1");
		String zipBillingAddress = checkOutPage.getInformationBillingAddress("city-state-zip");
		String countryBillingAddress = checkOutPage.getInformationBillingAddress("country");
		String paymentBillingAddress = checkOutPage.getInformationBillingAddress("payment-method");

		String nameShippingAddress = checkOutPage.getInformationShippingAddress("name");
		String emailShippingAddress = checkOutPage.getInformationShippingAddress("email");
		String phoneShippingAddress = checkOutPage.getInformationShippingAddress("phone");
		String addressShippingAddress = checkOutPage.getInformationShippingAddress("address1");
		String zipShippingAddress = checkOutPage.getInformationShippingAddress("city-state-zip");
		String countryShippingAddress = checkOutPage.getInformationShippingAddress("country");
		String shippingShippingAddress = checkOutPage.getInformationShippingAddress("shipping-method");

//		String skuConfirn = checkOutPage.getInformationProductConfirm("sku-number");
//		String nameProductConfirn =checkOutPage.getNameProductConfirm();
//		String priceConfirn =checkOutPage.getInformationProductConfirm("product-unit-price");
//		String qtyConfirn =checkOutPage.getInformationProductConfirm("product-quantity");
		String totalConfirn =checkOutPage.getInformationProductConfirm("product-subtotal");
//
//		String giftWrappingConfirn =checkOutPage.getStatusGiftWrapping();
//		String subTotalConfirn =checkOutPage.getTotalProductConfirm();

		verifyEquals(firstNameRandom+" "+lastNameRandom,nameBillingAddress);
		verifyEquals("Email: "+emailRandom,emailBillingAddress);
		verifyEquals("Phone: "+phoneNumberRandom,phoneBillingAddress);
		verifyEquals(address1Random,addressBillingAddress);
		verifyEquals(cityRandom+","+ postalCodeRandom,zipBillingAddress);
		verifyEquals(country,countryBillingAddress);
		verifyEquals("Payment Method: "+paymentMethodText,paymentBillingAddress);

		verifyEquals(firstNameRandom+" "+lastNameRandom,nameShippingAddress);
		verifyEquals("Email: "+emailRandom,emailShippingAddress);
		verifyEquals("Phone: "+phoneNumberRandom,phoneShippingAddress);
		verifyEquals(address1Random,addressShippingAddress);
		verifyEquals(cityRandom+","+postalCodeRandom,zipShippingAddress);
		verifyEquals(country,countryShippingAddress);
		verifyEquals("Shipping Method: "+shippingMethodTextAfter,shippingShippingAddress);

//		verifyEquals(skuProduct,skuConfirn);
//		verifyEquals(nameProduct,nameProductConfirn);
//		verifyEquals(priceProduct,priceConfirn);
//		verifyEquals(quantityProduct,qtyConfirn);
//		verifyEquals(totalPriceProduct,totalConfirn);
//		verifyEquals("Gift wrapping: "+giftWrappingProduct,giftWrappingConfirn);
//		verifyEquals(totalPriceProduct,subTotalConfirn);
		checkOutPage.clickContinueConfirm();

		ExtentTestManager.getTest().log(Status.INFO, "Step 08: Verify success message and order number");
		verifyEquals(checkOutPage.getMessageOrderSuccess(),"Your order has been successfully processed!");
		String orderNumber = checkOutPage.getOrderNumber();
		homePage = checkOutPage.clickContinueOrder();

		ExtentTestManager.getTest().log(Status.INFO, "Step 09: Into my account > other > verify information display");
		customerInfoPage = homePage.clickToLinkMyAccount();
		ordersProductPage= customerInfoPage.clickOrder();
		String orderNumberMyAccount = ordersProductPage.getOrderNumberMyAccount();
		verifyEquals(orderNumber,orderNumberMyAccount);
		ordersProductPage.clickDetails();

		String orderStatus = ordersProductPage.getOrderStatus();
		String orderTotal = ordersProductPage.getOrderTotal();

		String orderNameBillingAddress = ordersProductPage.getInformationBillingAddress("name");
		String orderEmailBillingAddress = ordersProductPage.getInformationBillingAddress("email");
		String orderPhoneBillingAddress = ordersProductPage.getInformationBillingAddress("phone");
		String orderAddressBillingAddress = ordersProductPage.getInformationBillingAddress("address1");
		String orderZipBillingAddress = ordersProductPage.getInformationBillingAddress("city-state-zip");
		String orderCountryBillingAddress = ordersProductPage.getInformationBillingAddress("country");
		String orderPaymentBillingAddress = ordersProductPage.getPayMentOrder();
		String orderPaymentStatusBillingAddress = ordersProductPage.getPayMentStatusOrder();

		String orderNameShippingAddress = ordersProductPage.getInformationShippingAddress("name");
		String orderEmailShippingAddress = ordersProductPage.getInformationShippingAddress("email");
		String orderPhoneShippingAddress = ordersProductPage.getInformationShippingAddress("phone");
		String orderAddressShippingAddress = ordersProductPage.getInformationShippingAddress("address1");
		String orderZipShippingAddress = ordersProductPage.getInformationShippingAddress("city-state-zip");
		String orderCountryShippingAddress = ordersProductPage.getInformationShippingAddress("country");
		String orderShippingShippingAddress = ordersProductPage.getShippingOrder();;
		String orderShippingStatusShippingAddress = ordersProductPage.getShippingStatusOrder();

		String orderSku =ordersProductPage.getInformationOrderDetails("sku");
		String orderProduct =ordersProductPage.getNameInformationOrderDetails();
		String orderPrice =ordersProductPage.getInformationOrderDetails("unit-price");
		String orderQty =ordersProductPage.getInformationOrderDetails("quantity");
		String orderTotalFinals =ordersProductPage.getInformationOrderDetails("total");
		String orderGiftWrapping =ordersProductPage.getGiftWrappingOrderDetails();
		String orderSubTotal =ordersProductPage.getOrderTotalDetails();

		ExtentTestManager.getTest().log(Status.INFO, "Step 10: verify information display  correct");
		verifyTrue(orderStatus.contains("Pending"));
		verifyEquals(orderTotal,orderSubTotal);
		verifyEquals(firstNameRandom+" "+lastNameRandom,orderNameBillingAddress);
		verifyEquals("Email: "+emailRandom,orderEmailBillingAddress);
		verifyEquals("Phone: "+phoneNumberRandom,orderPhoneBillingAddress);
		verifyEquals(address1Random,orderAddressBillingAddress);
		verifyEquals(cityRandom+","+postalCodeRandom,orderZipBillingAddress);
		verifyEquals(country,orderCountryBillingAddress);
		verifyEquals("Shipping Method: "+shippingMethodTextAfter,shippingShippingAddress);
		verifyTrue(orderPaymentStatusBillingAddress.contains("Pending"));

		verifyEquals(firstNameRandom+" "+lastNameRandom,orderNameShippingAddress);
		verifyEquals("Email: "+emailRandom,orderEmailShippingAddress);
		verifyEquals("Phone: "+phoneNumberRandom,orderPhoneShippingAddress);
		verifyEquals(address1Random,orderAddressShippingAddress);
		verifyEquals(cityRandom+","+postalCodeRandom,orderZipShippingAddress);
		verifyEquals(country,orderCountryShippingAddress);
		verifyEquals("Shipping Method: "+shippingMethodTextAfter,shippingShippingAddress);
		verifyTrue(orderShippingStatusShippingAddress.contains("Not yet shipped"));

		verifyEquals(orderSku,orderSku);
		verifyEquals(orderProduct,orderProduct);
		verifyEquals(orderPrice,orderPrice);
		verifyEquals(orderQty,orderQty);
		verifyEquals(totalConfirn,orderTotalFinals);
		verifyEquals(orderGiftWrapping,orderGiftWrapping);
		verifyEquals(orderTotalFinals,orderSubTotal);

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
