package com.nopcommer.testcase;

import com.aventstack.extentreports.Status;
import commons.BaseTest;
import commons.PageGeneratorManagerAdmin;
import dataUser.UserDataMapper;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import pageObject.NopcommerAdmin.*;
import reportConfig.ExtentTestManager;

import java.lang.reflect.Method;
import java.util.List;
import java.util.Random;

public class Admin extends BaseTest{
	private WebDriver driver;
	private LoginAdminPageObject loginAdminPage;
	private DashBoardAdminPageObject dashBoardAdminPage;
	private ProductsCatologAdminPageObject productsCatologAdminPage;
	private CustomersAdminPageObject customersAdminPage;
	private DetailsCustomersAdminPageObject detailsCustomersAdminPage;
	private String emailAdmin, passWordAdmin;
	private UserDataMapper userData;
	private String countryCustomers,cityCustomer,addresses1Customers,addresses2Customers,zipCusomers,phoneNumberCustomer,faxNumberCustomer
			,emailCustomers,passwordCustomers, firstNameCustomers,lastNameCustomers,dateOfBirthCustomers,
			dateOfBirthCustomers_month,dateOfBirthCustomers_years,dateOfBirthCustomers_day,companyNameCustomers,
			adminCommentCustomers;
	private String editEmail,editFirstName,editLastName,editDateOf_Day,editDateOf_Month,editDateOf_Year,
			editDateOf,editCompany,editAdminComment;
	@Parameters({ "evnName", "serverName", "browser" })
	@BeforeClass
	public void beforeClass( String evnName, String serverName, String browser) {
		driver = getBrowserDriver(evnName, serverName, browser);
		driver.manage().window().maximize();
		userData = UserDataMapper.getUserDataMapper();

		loginAdminPage = PageGeneratorManagerAdmin.getLoginAdminPageObject(driver);

		emailCustomers = random()+userData.getAddressEmail();
		passwordCustomers = random()+userData.getPassWord();
		firstNameCustomers = random()+userData.getAddressFirstName();
		lastNameCustomers =random()+ userData.getAddressLastName();
		dateOfBirthCustomers_day = userData.getDateOfBirth_day();
		dateOfBirthCustomers_month = userData.getDateOfBirth_month();
		dateOfBirthCustomers_years = userData.getDateOfBirth_year();
		dateOfBirthCustomers = dateOfBirthCustomers_day+"/"+dateOfBirthCustomers_month+"/"+dateOfBirthCustomers_years;
		companyNameCustomers =random()+ userData.getAddressCompanyName();
		adminCommentCustomers = random()+userData.getAdminComment();
		countryCustomers = userData.getAddressCountry();
		addresses1Customers = userData.getAddressAddress_1();
		addresses2Customers = userData.getAddressAddress_2();
		zipCusomers = userData.getAddressZip();
		phoneNumberCustomer = userData.getAddressPhone();
		faxNumberCustomer  = userData.getAddressFaxNumber();
		cityCustomer  = userData.getAddressCity();


		editEmail = "Edit"+emailCustomers;
		editFirstName = "Edit"+firstNameCustomers;
		editLastName = lastNameCustomers;
		editDateOf_Day = "2";
		editDateOf_Month = "2";
		editDateOf_Year = "2008";
		editDateOf = editDateOf_Day+"/"+editDateOf_Month+"/"+editDateOf_Year;
		editCompany = "Edit"+companyNameCustomers;
		editAdminComment = "Edit Customer (Guest)";

		emailAdmin = userData.getEmailAdmin();
		passWordAdmin = userData.getPassWordAdmin();

		loginAdminPage.sendkeyTextBox("Email", emailAdmin);
		loginAdminPage.sendkeyTextBox("Password", passWordAdmin);

		dashBoardAdminPage = loginAdminPage.clickToButtonLoginSuccess();
		Assert.assertEquals(dashBoardAdminPage.getTextLogout(), "Logout");
		Assert.assertEquals(dashBoardAdminPage.getTextTitle(), "Dashboard");

	}

	@Test
	public void TC_01_Search_with_Product_Name(Method method){
		ExtentTestManager.startTest(method.getName(),"TC_01_Search_with_Product_Name");
		ExtentTestManager.getTest().log(Status.INFO,"Step 01: Open Catalog > Products");
		dashBoardAdminPage.clickCatalog("Catalog");
		productsCatologAdminPage = dashBoardAdminPage.clickProductMenuAdmin("Product");
		productsCatologAdminPage.clickSearchPorduct("style","display: block;");

		ExtentTestManager.getTest().log(Status.INFO,"Step 02: Search 'Lenovo IdeaCentre 600 All-in-One PC'");
		productsCatologAdminPage.searchProduct("Lenovo IdeaCentre 600 All-in-One PC","SearchProductName");
		productsCatologAdminPage.clickSearch();

		ExtentTestManager.getTest().log(Status.INFO,"Step 03: Verify only a product displayed in table");
		verifyEquals(productsCatologAdminPage.getInformationProducts("3"),"Lenovo IdeaCentre 600 All-in-One PC");
		verifyEquals(productsCatologAdminPage.getInformationProducts("4"),"LE_IC_600");
		verifyTrue(productsCatologAdminPage.getSizeElement()==1);

	}
	@Test
	public void TC_02_Search_With_Product_Name_Plus_Parent_Catefory_Plus_Unchecked(Method method){
		ExtentTestManager.startTest(method.getName(),"TC_02_Search_With_Product_Name_Plus_Parent_Catefory_Plus_Unchecked");
		ExtentTestManager.getTest().log(Status.INFO,"Step 01: Open Catalog > Products");
		ExtentTestManager.getTest().log(Status.INFO,"Step 02: Search 'Lenovo IdeaCentre 600 All-in_One PC'");
		productsCatologAdminPage.searchProduct("Lenovo IdeaCentre 600 All-in-One PC","SearchProductName");

		ExtentTestManager.getTest().log(Status.INFO,"Step 03: Category 'Computers'");
		productsCatologAdminPage.selectCategory("Computers","SearchCategoryId");

		ExtentTestManager.getTest().log(Status.INFO,"Step 04: Search subcategories Unchecked");
		productsCatologAdminPage.clickUnCheckBoxSearchSubcategories();
		productsCatologAdminPage.clickSearch();

		ExtentTestManager.getTest().log(Status.INFO,"Step 05: Verify 'No data available in table'");
		verifyEquals(productsCatologAdminPage.getMessageNodata(),"No data available in table");

	}
	@Test
	public void TC_03_Search_With_Product_Name_Plus_Parent_Catefory_Plus_Checked(Method method){
		ExtentTestManager.startTest(method.getName(),"TC_03_Search_With_Product_Name_Plus_Parent_Catefory_Plus_Checked");
		ExtentTestManager.getTest().log(Status.INFO,"Step 01: Open Catalog > Products");
		ExtentTestManager.getTest().log(Status.INFO,"Step 02: Search 'Lenovo IdeaCentre 600 All-in_One PC'");
		productsCatologAdminPage.searchProduct("Lenovo IdeaCentre 600 All-in-One PC","SearchProductName");

		ExtentTestManager.getTest().log(Status.INFO,"Step 03: Category 'Computers'");
		productsCatologAdminPage.selectCategory("Computers","SearchCategoryId");

		ExtentTestManager.getTest().log(Status.INFO,"Step 04: Search subcategories Checked");
		productsCatologAdminPage.clickCheckBoxSearchSubcategories();
		productsCatologAdminPage.clickSearch();

		ExtentTestManager.getTest().log(Status.INFO,"Step 05: Verify only a product displayed in table");
		verifyEquals(productsCatologAdminPage.getInformationProducts("3"),"Lenovo IdeaCentre 600 All-in-One PC");
		verifyEquals(productsCatologAdminPage.getInformationProducts("4"),"LE_IC_600");
		verifyTrue(productsCatologAdminPage.getSizeElement()==1);

	}
	@Test
	public void TC_04_Search_With_Product_Name_Plus_Chill_Catefory(Method method){
		ExtentTestManager.startTest(method.getName(),"TC_04_Search_With_Product_Name_Plus_Chill_Catefory");
		ExtentTestManager.getTest().log(Status.INFO,"Step 01: Open Catalog > Products");
		ExtentTestManager.getTest().log(Status.INFO,"Step 02: Search 'Lenovo IdeaCentre 600 All-in_One PC'");
		productsCatologAdminPage.searchProduct("Lenovo IdeaCentre 600 All-in-One PC","SearchProductName");

		ExtentTestManager.getTest().log(Status.INFO,"Step 03: Category 'Computers >> Desktops'");
		productsCatologAdminPage.selectCategory("Computers >> Desktops","SearchCategoryId");

		ExtentTestManager.getTest().log(Status.INFO,"Step 04: Search subcategories Unchecked");
		productsCatologAdminPage.clickUnCheckBoxSearchSubcategories();
		productsCatologAdminPage.clickSearch();

		ExtentTestManager.getTest().log(Status.INFO,"Step 05: Verify only a product displayed in table");
		verifyEquals(productsCatologAdminPage.getInformationProducts("3"),"Lenovo IdeaCentre 600 All-in-One PC");
		verifyEquals(productsCatologAdminPage.getInformationProducts("4"),"LE_IC_600");
		verifyTrue(productsCatologAdminPage.getSizeElement()==1);

	}
	@Test
	public void TC_05_Search_With_Product_Name_Plus_Manufacturer(Method method){
		ExtentTestManager.startTest(method.getName(),"TC_05_Search_With_Product_Name_Plus_Manufacturer");
		ExtentTestManager.getTest().log(Status.INFO,"Step 01: Open Catalog > Products");
		ExtentTestManager.getTest().log(Status.INFO,"Step 02: Search 'Lenovo IdeaCentre 600 All-in-One PC'");
		productsCatologAdminPage.searchProduct("Lenovo IdeaCentre 600 All-in-One PC", "SearchProductName");

		ExtentTestManager.getTest().log(Status.INFO,"Step 03: Category 'All'");
		productsCatologAdminPage.selectCategory("All","SearchCategoryId");

		ExtentTestManager.getTest().log(Status.INFO,"Step 04: Search subcategories Unchecked");
		productsCatologAdminPage.clickCheckBoxSearchSubcategories();

		ExtentTestManager.getTest().log(Status.INFO,"Step 05: Manufacturer 'Apple'");
		productsCatologAdminPage.selectCategory("Apple","SearchManufacturerId");
		productsCatologAdminPage.clickSearch();

		ExtentTestManager.getTest().log(Status.INFO,"Step 06: Verify 'No data available in table'");
		verifyEquals(productsCatologAdminPage.getMessageNodata(),"No data available in table");

	}
	@Test
	public void TC_06_Go_Directly_to_Product_SKU(Method method){
		ExtentTestManager.startTest(method.getName(),"TC_06_Go_Directly_to_Product_SKU");
		ExtentTestManager.getTest().log(Status.INFO,"Step 01: Open Catalog > Products");
		ExtentTestManager.getTest().log(Status.INFO,"Step 02: Go directly to product SKU 'LE_IC_600'");
		productsCatologAdminPage.searchProduct("LE_IC_600","GoDirectlyToSku");

		ExtentTestManager.getTest().log(Status.INFO,"Step 03: Click 'Go' button");
		productsCatologAdminPage.clickGoDirectly();

		ExtentTestManager.getTest().log(Status.INFO,"Step 04: Verify into product detail success");
		verifyTrue(productsCatologAdminPage.getTitleDirectly().contains("Edit product details"));

		ExtentTestManager.getTest().log(Status.INFO,"Step 05: verify displayed 'Lenovo IdeaCentre 600 All-in_One PC'");
		productsCatologAdminPage.clockOpenProductInfo();

		verifyEquals(productsCatologAdminPage.getInfoProductDetails("Name", "value"),"Lenovo IdeaCentre 600 All-in-One PC");
		verifyEquals(productsCatologAdminPage.getInfoProductDetails("Sku","value"),"LE_IC_600");

		dashBoardAdminPage = productsCatologAdminPage.clickDashBoard();
	}
	@Test
	public void TC_07_Create_new_Customer(Method method){
		ExtentTestManager.startTest(method.getName(),"TC_07_Create_new_Customer");
		ExtentTestManager.getTest().log(Status.INFO,"Step 01: Open Customer > Customers");
		dashBoardAdminPage.refreshPage();
		dashBoardAdminPage.clickCatalog("Customers");
		customersAdminPage = dashBoardAdminPage.clickCustomerstMenuAdmin("Customer");
		verifyEquals(customersAdminPage.getTitleCustomers(),"Customers");

		ExtentTestManager.getTest().log(Status.INFO,"Step 02: Click 'Add new'");
		customersAdminPage.clickAddNew();

		ExtentTestManager.getTest().log(Status.INFO,"Step 03: Input Data");

		customersAdminPage.inputInformation(emailCustomers,"Email");
		customersAdminPage.inputInformation(passwordCustomers,"Password");
		customersAdminPage.inputInformation(firstNameCustomers,"FirstName");
		customersAdminPage.inputInformation(lastNameCustomers,"LastName");
		String gender ="1";
		customersAdminPage.selectGender(gender);
		customersAdminPage.inputInformation(dateOfBirthCustomers,"DateOfBirth");
		customersAdminPage.inputInformation(companyNameCustomers,"Company");
		customersAdminPage.clickDeteleRoles();
		customersAdminPage.sendkeyCustomerRoles("Guests");
		customersAdminPage.checkBoxActive();
		customersAdminPage.inputTextAreaInformation(adminCommentCustomers,"AdminComment");

		ExtentTestManager.getTest().log(Status.INFO,"Step 04: Click button 'Save and Continue Edit'");
		customersAdminPage.clickSaveAndContinueEdit();

		ExtentTestManager.getTest().log(Status.INFO,"Step 05: Verify information");
		verifyTrue(customersAdminPage.getTextMessageSaveSuccess().contains("The new customer has been added successfully."));
		String saveEmailCustomerInfo = customersAdminPage.getInformationCustomer("value","Email");
		String saveFirstNameCustomerInfo = customersAdminPage.getInformationCustomer("value","FirstName");
		String saveLastNameCustomerInfo = customersAdminPage.getInformationCustomer("value","LastName");
		String saveGenderCustomerInfo = customersAdminPage.getGenderCustomerInfo(gender);
		String saveDateOfBirthCustomerInfo = customersAdminPage.getInformationCustomer("value","DateOfBirth");
		String saveCompanyNameCustomerInfo = customersAdminPage.getInformationCustomer("value","Company");
		String saveCustomerRolesCustomerInfo = customersAdminPage.getCustomerRolesText();
		boolean saveActiveCustomerInfo = customersAdminPage.getStatusActive();
		String saveAdminCommentCustomerInfo = customersAdminPage.getTextAreaInformationCustomer("AdminComment");

		verifyEquals(emailCustomers, saveEmailCustomerInfo);
		verifyEquals(firstNameCustomers, saveFirstNameCustomerInfo);
		verifyEquals(lastNameCustomers, saveLastNameCustomerInfo);
		verifyEquals(dateOfBirthCustomers, saveDateOfBirthCustomerInfo);
		verifyEquals(companyNameCustomers, saveCompanyNameCustomerInfo);
		verifyEquals(adminCommentCustomers, saveAdminCommentCustomerInfo);
		verifyEquals(saveGenderCustomerInfo, "Male");
		verifyEquals(saveCustomerRolesCustomerInfo, "Guests");
		verifyEquals(saveActiveCustomerInfo, true);


		ExtentTestManager.getTest().log(Status.INFO,"Step 06: Click button 'back to customer list'");
		customersAdminPage.clickBackToCustomerList();

		ExtentTestManager.getTest().log(Status.INFO,"Step 07: Search vs 'Customer roles' = Guest => Click search button");
		customersAdminPage.clickDeteleRolesCustomer();
		customersAdminPage.sendkeyCustomerRoles("Guests");
		customersAdminPage.clickSearch();

		ExtentTestManager.getTest().log(Status.INFO,"Step 08: Verify Customer displayed");
		customersAdminPage.showItem("100");
		List<String> listNameCustomer = customersAdminPage.getListNameCustomer();
		List<String> listCompanyNameCustomer = customersAdminPage.getListCompanyNameCustomer();

		verifyTrue(customersAdminPage.isNameListCustomer(listNameCustomer,firstNameCustomers +" "+ lastNameCustomers));
		verifyTrue(customersAdminPage.isCoompanyNameListCustomer(listCompanyNameCustomer,companyNameCustomers));

	}
	@Test
	public void TC_08_Search_Customer_With_Email(Method method){
		ExtentTestManager.startTest(method.getName(),"TC_08_Search_Customer_With_Email");
		ExtentTestManager.getTest().log(Status.INFO,"Step 01: Open Customer > Customers");
		ExtentTestManager.getTest().log(Status.INFO,"Step 02: Input Data 'automationfc@gmail.com");
		customersAdminPage.searchInformation(emailCustomers,"SearchEmail");

		ExtentTestManager.getTest().log(Status.INFO,"Step 03: Customer roles 'Guest'");
		customersAdminPage.clickDeteleRoles();
		customersAdminPage.sendkeyCustomerRoles("Guests");
		customersAdminPage.clickSearch();

		ExtentTestManager.getTest().log(Status.INFO,"Step 04: Verify only item in table displayed");
		List<String> listNameCustomer = customersAdminPage.getListNameCustomer();
		List<String> listCompanyNameCustomer = customersAdminPage.getListCompanyNameCustomer();

		verifyTrue(customersAdminPage.isNameListCustomer(listNameCustomer,firstNameCustomers +" "+ lastNameCustomers));
		verifyTrue(customersAdminPage.isCoompanyNameListCustomer(listCompanyNameCustomer,companyNameCustomers));
		verifyTrue(customersAdminPage.getSizeElement()==1);

	}
	@Test
	public void TC_09_Search_Customer_With_FirstName_and_LastName(Method method){
		ExtentTestManager.startTest(method.getName(),"TC_09_Search_Customer_With_FirstName_and_LastName");
		ExtentTestManager.getTest().log(Status.INFO,"Step 01: Open Customer > Customers");
		ExtentTestManager.getTest().log(Status.INFO,"Step 02: First name = Automation");
		customersAdminPage.searchInformation("","SearchEmail");
		customersAdminPage.searchInformation(firstNameCustomers,"SearchFirstName");

		ExtentTestManager.getTest().log(Status.INFO,"Step 03: Last name = FC ");
		customersAdminPage.searchInformation(lastNameCustomers,"SearchLastName");

		ExtentTestManager.getTest().log(Status.INFO,"Step 04: Customer roles = Guests");
		customersAdminPage.clickDeteleRoles();
		customersAdminPage.sendkeyCustomerRoles("Guests");
		customersAdminPage.clickSearch();

		ExtentTestManager.getTest().log(Status.INFO,"Step 05: Verify only item in table displayed");
		List<String> listNameCustomer = customersAdminPage.getListNameCustomer();
		List<String> listCompanyNameCustomer = customersAdminPage.getListCompanyNameCustomer();

		verifyTrue(customersAdminPage.isNameListCustomer(listNameCustomer,firstNameCustomers +" "+ lastNameCustomers));
		verifyTrue(customersAdminPage.isCoompanyNameListCustomer(listCompanyNameCustomer,companyNameCustomers));
		verifyTrue(customersAdminPage.getSizeElement()==1);

	}
	@Test
	public void TC_10_Search_Customer_vs_Company(Method method){
		ExtentTestManager.startTest(method.getName(),"TC_10_Search_Customer_vs_Company");
		ExtentTestManager.getTest().log(Status.INFO,"Step 01: Open Customer > Customers");
		ExtentTestManager.getTest().log(Status.INFO,"Step 02: Company = Automation FC");
		customersAdminPage.searchInformation("","SearchEmail");
		customersAdminPage.searchInformation("","SearchFirstName");
		customersAdminPage.searchInformation("","SearchLastName");
		customersAdminPage.searchInformation(companyNameCustomers,"SearchCompany");

		ExtentTestManager.getTest().log(Status.INFO,"Step 03: Customer roles = Guests");
		customersAdminPage.clickDeteleRoles();
		customersAdminPage.sendkeyCustomerRoles("Guests");
		customersAdminPage.clickSearch();

		ExtentTestManager.getTest().log(Status.INFO,"Step 04: Verify only item in table displayed");
		List<String> listNameCustomer = customersAdminPage.getListNameCustomer();
		List<String> listCompanyNameCustomer = customersAdminPage.getListCompanyNameCustomer();

		verifyTrue(customersAdminPage.isNameListCustomer(listNameCustomer,firstNameCustomers +" "+ lastNameCustomers));
		verifyTrue(customersAdminPage.isCoompanyNameListCustomer(listCompanyNameCustomer,companyNameCustomers));
		verifyTrue(customersAdminPage.getSizeElement()==1);

	}
	@Test
	public void TC_11_Search_Customer_vs_Full_Data(Method method){
		ExtentTestManager.startTest(method.getName(),"TC_11_Search_Customer_vs_Full_Data");
		ExtentTestManager.getTest().log(Status.INFO,"Step 01: Open Customer > Customers");
		ExtentTestManager.getTest().log(Status.INFO,"Step 02: Input data");
		customersAdminPage.searchInformation(emailCustomers,"SearchEmail");
		customersAdminPage.searchInformation(firstNameCustomers,"SearchFirstName");
		customersAdminPage.searchInformation(lastNameCustomers,"SearchLastName");
		customersAdminPage.selectDateOfBirth(dateOfBirthCustomers_day,"SearchDayOfBirth");
		customersAdminPage.selectDateOfBirth(dateOfBirthCustomers_month,"SearchMonthOfBirth");
		customersAdminPage.searchInformation(companyNameCustomers,"SearchCompany");

		ExtentTestManager.getTest().log(Status.INFO,"Step 03: Customer roles = Guests");
		customersAdminPage.clickDeteleRoles();
		customersAdminPage.sendkeyCustomerRoles("Guests");
		customersAdminPage.clickSearch();

		ExtentTestManager.getTest().log(Status.INFO,"Step 04: Verify only item in table displayed");
		List<String> listNameCustomer = customersAdminPage.getListNameCustomer();
		List<String> listCompanyNameCustomer = customersAdminPage.getListCompanyNameCustomer();

		verifyTrue(customersAdminPage.isNameListCustomer(listNameCustomer,firstNameCustomers +" "+ lastNameCustomers));
		verifyTrue(customersAdminPage.isCoompanyNameListCustomer(listCompanyNameCustomer,companyNameCustomers));
		verifyTrue(customersAdminPage.getSizeElement()==1);

	}
	@Test
	public void TC_12_Edit_Customer(Method method){
		ExtentTestManager.startTest(method.getName(),"TC_12_Edit_Customer");
		ExtentTestManager.getTest().log(Status.INFO,"Step 01: Open Customer > Customers");
		ExtentTestManager.getTest().log(Status.INFO,"Step 02: Input Search Customer with data");
		customersAdminPage.refreshPage();
		customersAdminPage.searchInformation(emailCustomers,"SearchEmail");
		customersAdminPage.searchInformation(firstNameCustomers,"SearchFirstName");
		customersAdminPage.searchInformation(lastNameCustomers,"SearchLastName");
		customersAdminPage.selectDateOfBirth(dateOfBirthCustomers_day,"SearchDayOfBirth");
		customersAdminPage.selectDateOfBirth(dateOfBirthCustomers_month,"SearchMonthOfBirth");
		customersAdminPage.searchInformation(companyNameCustomers,"SearchCompany");

		customersAdminPage.clickDeteleRoles();
		customersAdminPage.sendkeyCustomerRoles("Guests");
		customersAdminPage.clickSearch();

		ExtentTestManager.getTest().log(Status.INFO,"Step 03: Click 'Edit; button");
		detailsCustomersAdminPage = customersAdminPage.clickEditCustomer();

		ExtentTestManager.getTest().log(Status.INFO,"Step 04: Edit Customer with data");
		detailsCustomersAdminPage.editInformation(editEmail,"Email");
		detailsCustomersAdminPage.editInformation(editFirstName,"FirstName");
		detailsCustomersAdminPage.editInformation(editLastName,"LastName");
		detailsCustomersAdminPage.editInformation(editDateOf,"DateOfBirth");
		detailsCustomersAdminPage.editInformation(editCompany,"Company");
		detailsCustomersAdminPage.inputTextAreaInformationCustomer(editAdminComment,"AdminComment");

		ExtentTestManager.getTest().log(Status.INFO,"Step 05: Click Save");
		customersAdminPage = detailsCustomersAdminPage.clickSaveEdit();

		ExtentTestManager.getTest().log(Status.INFO,"Step 06: Verify message displayed: 'The customer has been updated successfully'");
		verifyTrue(customersAdminPage.getMessageSaveEdit().contains("The customer has been updated successfully."));

		ExtentTestManager.getTest().log(Status.INFO,"Step 07: Search");
		customersAdminPage.searchInformation(editEmail,"SearchEmail");
		customersAdminPage.searchInformation(editFirstName,"SearchFirstName");
		customersAdminPage.searchInformation(editLastName,"SearchLastName");
		customersAdminPage.selectDateOfBirth(editDateOf_Day,"SearchDayOfBirth");
		customersAdminPage.selectDateOfBirth(editDateOf_Month,"SearchMonthOfBirth");
		customersAdminPage.searchInformation(editCompany,"SearchCompany");

		customersAdminPage.clickDeteleRoles();
		customersAdminPage.sendkeyCustomerRoles("Guests");
		customersAdminPage.clickSearch();

		ExtentTestManager.getTest().log(Status.INFO,"Step 08: Verify true information after search");
		List<String> listNameCustomer = customersAdminPage.getListNameCustomer();
		List<String> listCompanyNameCustomer = customersAdminPage.getListCompanyNameCustomer();
		verifyTrue(customersAdminPage.isNameListCustomer(listNameCustomer,editFirstName +" "+ editLastName));
		verifyTrue(customersAdminPage.isCoompanyNameListCustomer(listCompanyNameCustomer,editCompany));

		verifyTrue(customersAdminPage.getSizeElement()==1);

	}
	@Test
	public void TC_13_Add_New_Address_In_Customer_Detail(Method method){
		ExtentTestManager.startTest(method.getName(),"TC_13_Add_New_Address_In_Customer_Detail");
		ExtentTestManager.getTest().log(Status.INFO,"Step 01: Open Customer > Customers");
		ExtentTestManager.getTest().log(Status.INFO,"Step 02: Search Customer with data");
		ExtentTestManager.getTest().log(Status.INFO,"Step 03: Click 'Edit' button > Click 'Addresses' > Click 'Add new address'");
		customersAdminPage.refreshPage();
		detailsCustomersAdminPage = customersAdminPage.clickEditCustomer();
		detailsCustomersAdminPage.clickAddressesDetail();
		detailsCustomersAdminPage.clickAddNewAdresses();

		ExtentTestManager.getTest().log(Status.INFO,"Step 04: Input all values and click 'Save' button");
		detailsCustomersAdminPage.fillOutInformationAddress(firstNameCustomers,"Address_FirstName");
		detailsCustomersAdminPage.fillOutInformationAddress(lastNameCustomers,"Address_LastName");
		detailsCustomersAdminPage.fillOutInformationAddress(emailCustomers,"Address_Email");
		detailsCustomersAdminPage.fillOutInformationAddress(cityCustomer,"Address_City");
		detailsCustomersAdminPage.fillOutInformationAddress(companyNameCustomers,"Address_Company");
		detailsCustomersAdminPage.selectCountryAddresses(countryCustomers);
		detailsCustomersAdminPage.fillOutInformationAddress(addresses1Customers,"Address_Address1");
		detailsCustomersAdminPage.fillOutInformationAddress(addresses2Customers,"Address_Address2");
		detailsCustomersAdminPage.fillOutInformationAddress(zipCusomers,"Address_ZipPostalCode");
		detailsCustomersAdminPage.fillOutInformationAddress(phoneNumberCustomer,"Address_PhoneNumber");
		detailsCustomersAdminPage.fillOutInformationAddress(faxNumberCustomer,"Address_FaxNumber");

		detailsCustomersAdminPage.clickSaveAddresses();

		ExtentTestManager.getTest().log(Status.INFO,"Step 05: Verify message displayed: 'The new address has been added successfully'");
		verifyTrue(detailsCustomersAdminPage.getMassegeSaveAddress().contains("The new address has been added successfully."));

		ExtentTestManager.getTest().log(Status.INFO,"Step 06: Click 'back to customer details' link");
		detailsCustomersAdminPage.clickBackToCustomerDetail();

		ExtentTestManager.getTest().log(Status.INFO,"Step 07: Verify information address displayed");
		detailsCustomersAdminPage.clickAddressesDetail();
		String addressesFirstName = detailsCustomersAdminPage.getInformationAddress("1");
		String addressesLastName = detailsCustomersAdminPage.getInformationAddress("2");
		String addressesEmail = detailsCustomersAdminPage.getInformationAddress("3");
		String addressesPhoneNumber = detailsCustomersAdminPage.getInformationAddress("4");
		String addressesFaxNumber = detailsCustomersAdminPage.getInformationAddress("5");
		String addressesAddress = detailsCustomersAdminPage.getInformationAddress("6");
		String verifyAddress = companyNameCustomers+"\n"+addresses1Customers+"\n"+addresses2Customers+"\n"+cityCustomer+","+zipCusomers+"\n"+countryCustomers;

		verifyEquals(firstNameCustomers,addressesFirstName);
		verifyEquals(lastNameCustomers,addressesLastName);
		verifyEquals(emailCustomers,addressesEmail);
		verifyEquals(phoneNumberCustomer,addressesPhoneNumber);
		verifyEquals(faxNumberCustomer,addressesFaxNumber);
		verifyEquals(verifyAddress,addressesAddress);
	}
	@Test
	public void TC_14_Edit_Address_in_Customer_Detail(Method method){
		ExtentTestManager.startTest(method.getName(),"TC_14_Edit_Address_in_Customer_Detail");
		ExtentTestManager.getTest().log(Status.INFO,"Step 01: Open Customer > Customers");
		ExtentTestManager.getTest().log(Status.INFO,"Step 02: Search Customer with data");
		ExtentTestManager.getTest().log(Status.INFO,"Step 03: Click 'Edit' button > Click 'Addresses' > Click 'Edit' button");
		detailsCustomersAdminPage.clickEditAddress("Edit");

		ExtentTestManager.getTest().log(Status.INFO,"Step 04: Update new information address");
		String updateFirstName = random()+firstNameCustomers;
		String updateLastName = random()+lastNameCustomers;
		String updateEmail = random()+emailCustomers;
		String updateCity = cityCustomer;
		String updateCompany = companyNameCustomers;
		String updateCountry = countryCustomers;
		String updateAddresses1 = random()+addresses1Customers;
		String updateAddresses2 = random()+addresses2Customers;
		String updateZip = zipCusomers;
		String updatePhoneNumber = phoneNumberCustomer;
		String updateFaxNumber = faxNumberCustomer;

		detailsCustomersAdminPage.fillOutInformationAddress(updateFirstName,"Address_FirstName");
		detailsCustomersAdminPage.fillOutInformationAddress(updateLastName,"Address_LastName");
		detailsCustomersAdminPage.fillOutInformationAddress(updateEmail,"Address_Email");
		detailsCustomersAdminPage.fillOutInformationAddress(updateCity,"Address_City");
		detailsCustomersAdminPage.fillOutInformationAddress(updateCompany,"Address_Company");
		detailsCustomersAdminPage.selectCountryAddresses(updateCountry);
		detailsCustomersAdminPage.fillOutInformationAddress(updateAddresses1,"Address_Address1");
		detailsCustomersAdminPage.fillOutInformationAddress(updateAddresses2,"Address_Address2");
		detailsCustomersAdminPage.fillOutInformationAddress(updateZip,"Address_ZipPostalCode");
		detailsCustomersAdminPage.fillOutInformationAddress(updatePhoneNumber,"Address_PhoneNumber");
		detailsCustomersAdminPage.fillOutInformationAddress(updateFaxNumber,"Address_FaxNumber");

		ExtentTestManager.getTest().log(Status.INFO,"Step 05: Click 'Save' and verify message 'The address has updated successfully'");
		detailsCustomersAdminPage.clickSaveAddresses();

		ExtentTestManager.getTest().log(Status.INFO,"Step 05: Verify message displayed: 'The new address has been added successfully'");
		verifyTrue(detailsCustomersAdminPage.getMassegeSaveAddress().contains("The address has been updated successfully."));

		ExtentTestManager.getTest().log(Status.INFO,"Step 06: Click 'back to customer details' link");
		detailsCustomersAdminPage.clickBackToCustomerDetail();

		ExtentTestManager.getTest().log(Status.INFO,"Step 07: Verify information address displayed");
		detailsCustomersAdminPage.clickAddressesDetail();
		String addressesFirstName = detailsCustomersAdminPage.getInformationAddress("1");
		String addressesLastName = detailsCustomersAdminPage.getInformationAddress("2");
		String addressesEmail = detailsCustomersAdminPage.getInformationAddress("3");
		String addressesPhoneNumber = detailsCustomersAdminPage.getInformationAddress("4");
		String addressesFaxNumber = detailsCustomersAdminPage.getInformationAddress("5");
		String addressesAddress = detailsCustomersAdminPage.getInformationAddress("6");
		String verifyAddress = updateCompany+"\n"+updateAddresses1+"\n"+updateAddresses2+"\n"+updateCity+","+updateZip+"\n"+updateCountry;

		verifyEquals(updateFirstName,addressesFirstName);
		verifyEquals(updateLastName,addressesLastName);
		verifyEquals(updateEmail,addressesEmail);
		verifyEquals(updatePhoneNumber,addressesPhoneNumber);
		verifyEquals(updateFaxNumber,addressesFaxNumber);
		verifyEquals(verifyAddress,addressesAddress);
	}
	@Test
	public void TC_15_Delete_Address_in_Customer_Detail(Method method){
		ExtentTestManager.startTest(method.getName(),"TC_15_Delete_Address_in_Customer_Detail");
		ExtentTestManager.getTest().log(Status.INFO,"Step 01: Open Customer > Customers");
		ExtentTestManager.getTest().log(Status.INFO,"Step 02: Search Customer with data");
		ExtentTestManager.getTest().log(Status.INFO,"Step 03: Click 'Edit' button > Click 'Addresses' > Click 'Delete' button");
		detailsCustomersAdminPage.clickDeleteAddress();

		ExtentTestManager.getTest().log(Status.INFO,"Step 04: Accept alert and verify address delete success");
		verifyEquals(detailsCustomersAdminPage.getMessageTableNoData(),"No data available in table");
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
