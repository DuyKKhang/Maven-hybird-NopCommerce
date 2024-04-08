package dataUser;

import java.lang.reflect.Method;
import java.util.Random;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.*;

import com.aventstack.extentreports.Status;

import commons.BaseTest;
import commons.PageGeneratorManagerUser;
import pageObject.NopCommerUser.HomePageObject;
import pageObject.NopCommerUser.RegisterPageObject;
import reportConfig.ExtentTestManager;

public class RegisterSuccessful extends BaseTest{
	private WebDriver driver;
	private HomePageObject homePage;
	private RegisterPageObject registerPage;
	private String firstName, lastName, email, passWord, confirmPasss;
	@Parameters({"evnName", "serverName", "browser", "os", "os_version","ipAddress","port"})
	@BeforeClass
	public void beforeClass(@Optional("local") String evnName,@Optional("dev") String serverName, String browser, String os, String os_version) {
		driver = getBrowserDriver(evnName, serverName, browser, os, os_version);
		homePage = PageGeneratorManagerUser.getHomePageObject(driver);

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
	public static int random(){
		Random random = new Random();
		return random.nextInt(99999);
	}
	@AfterClass(alwaysRun = true)
	public void afterClass() {
		closeBrowserDriver();
	}
}
