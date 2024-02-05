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
	public static AdvencedSearchPageObject getAdvencedSearchPageObject(WebDriver driver) {
		return new AdvencedSearchPageObject(driver);
	}
	public static ComputerPageObject getComputerPageObject(WebDriver driver) {
		return new ComputerPageObject(driver);
	}
	public static NotebooksPageObject getNotebooksPageObject(WebDriver driver) {
		return new NotebooksPageObject(driver);
	}
	public static DesktopsPageObject getDesktopsPageObject(WebDriver driver) {
		return new DesktopsPageObject(driver);
	}
	public static WishlisPageObject getWishlisPageObject(WebDriver driver) {
		return new WishlisPageObject(driver);
	}
	public static ShoppingCartPageObject getShoppingCartPageObject(WebDriver driver) {
		return new ShoppingCartPageObject(driver);
	}
}
