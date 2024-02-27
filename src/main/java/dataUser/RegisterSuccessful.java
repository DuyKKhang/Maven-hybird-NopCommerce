package dataUser;

import java.lang.reflect.Method;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;

import commons.BaseTest;
import commons.PageGeneratorManager;
import pageObject.NopCommer.HomePageObject;
import pageObject.NopCommer.RegisterPageObject;
import reportConfig.ExtentTestManager;

public class RegisterSuccessful extends BaseTest{
	private WebDriver driver;
	private HomePageObject homePage;
	private RegisterPageObject registerPage;
	private String firstName, lastName, email, passWord, confirmPasss;
	@Parameters({"evnName", "serverName", "browser"})
	@BeforeClass
	public void beforeClass(String evnName,String serverName, String browser) {
		driver = getBrowserDriver(evnName, serverName, browser);
		homePage = PageGeneratorManager.getHomePageObject(driver);

		firstName 	 = UserData.Register.FIRSTNAME;
		lastName 	 = UserData.Register.LASTNAME;
		email 		 = UserData.Register.EMAIL;
		passWord 	 = UserData.Register.PASSWORD;
		confirmPasss = UserData.Register.PASSWORD;
	}
	@Test
	public void Register_Success(Method method) {
		ExtentTestManager.startTest(method.getName(), "Register account run test case");
		registerPage = homePage.clickToRegister();
		registerPage.inputTextbox(firstName,"FirstName");
		registerPage.inputTextbox(lastName,"LastName");
		registerPage.inputTextbox(email,"Email");
		registerPage.inputTextbox(passWord,"Password");
		registerPage.inputTextbox(confirmPasss,"ConfirmPassword");
		ExtentTestManager.getTest().log(Status.INFO, "Email: "+email);
		ExtentTestManager.getTest().log(Status.INFO, "Pass word: "+passWord);
		registerPage.clickButtonRegister();
		Assert.assertEquals(registerPage.getTextMessageSuccess(), "Your registration completed");
		Assert.assertTrue(registerPage.isDisplyedContinueButton());
	}
	
	@AfterClass(alwaysRun = true)
	public void afterClass() {
		closeBrowserDriver();
	}
}
