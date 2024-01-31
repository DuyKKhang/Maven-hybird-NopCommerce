package commons;

import org.openqa.selenium.WebDriver;

import pageObject.NopCommer.*;

public class PageGeneratorManager {
	
	public static HomePageObject getHomePageObject(WebDriver driver) {
		return new HomePageObject(driver);
	}
	
	public static LoginPageObject getLoginPageObject(WebDriver driver) {
		return new LoginPageObject(driver);
	}
	
	public static RegisterPageObject getRegisterPageObject(WebDriver driver) {
		return new RegisterPageObject(driver);
	}
	
	public static CustomerInfoPageObject getCustomerInfoPageObject(WebDriver driver) {
		return new CustomerInfoPageObject(driver);
	}
	public static AddressesPageObject getAddressesPageObject(WebDriver driver) {
		return new AddressesPageObject(driver);
	}
	public static ChangePassPageObject getChangePassPageObject(WebDriver driver) {
		return new ChangePassPageObject(driver);
	}
	public static MyProductReviewsPageObject getMyProductReviewsPageObject(WebDriver driver) {
		return new MyProductReviewsPageObject(driver);
	}
	public static DetailProductPageObject getDetailProductPageObject(WebDriver driver) {
		return new DetailProductPageObject(driver);
	}
	public static ProductReviewPageObject getProductReviewPageObject(WebDriver driver) {
		return new ProductReviewPageObject(driver);
	}
}
