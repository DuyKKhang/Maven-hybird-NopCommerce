package dataUser;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import commons.BaseTest;
import commons.PageGeneratorManager;
import pageObject.NopCommer.HomePageObject;
import pageObject.NopCommer.RegisterPageObject;

public class RegisterSuccessful extends BaseTest{
	private WebDriver driver;
	private HomePageObject homePage;
	private RegisterPageObject registerPage;
	private String firstName, lastName, email, passWord, confirmPasss;
	UserDataMapper_1 useDataMapper_1;
	UserDataMapper_2 useDataMapper_2;
	@Parameters({"evnName", "serverName", "browser"})
	@BeforeClass
	public void beforeClass(String evnName,String serverName, String browser) {
		driver = getBrowserDriver(evnName, serverName, browser);
		
		homePage = PageGeneratorManager.getHomePageObject(driver);
		useDataMapper_1 = UserDataMapper_1.getUserData();
		useDataMapper_2 = UserDataMapper_2.getUserData();
	
		
		firstName 	= UserData.Register.FIRSTNAME;
		lastName 	= UserData.Register.LASTNAME;
		email 		= UserData.Register.EMAIL;
		passWord 	= UserData.Register.PASSWORD;
		confirmPasss = UserData.Register.PASSWORD;
		
		registerPage = homePage.clickToRegister();
		registerPage.inputTextbox(firstName,"FirstName");
		registerPage.inputTextbox(lastName,"LastName");
		registerPage.inputTextbox(email,"Email");
		registerPage.inputTextbox(passWord,"Password");
		registerPage.inputTextbox(confirmPasss,"ConfirmPassword");
		registerPage.clickButtonRegister();
		System.out.println("________________" + useDataMapper_1.getCurtomerFirstName()+"____________________");
		System.out.println("________________" + useDataMapper_2.getLoginUsername()+"____________________");
		Assert.assertEquals(registerPage.getTextMessageSuccess(), "Your registration completed");
		Assert.assertTrue(registerPage.isDisplyedContinueButton());
		
		System.out.println(email);
		System.out.println(passWord);
	}
	@Test
	public void TC_01() {
		
	}
	
	@AfterClass(alwaysRun = true)
	public void afterClass() {
		closeBrowserDriver();
	}
}
