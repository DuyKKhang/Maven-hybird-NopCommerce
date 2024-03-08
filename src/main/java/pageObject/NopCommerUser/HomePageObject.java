package pageObject.NopCommerUser;

import org.openqa.selenium.WebDriver;

import commons.BasePage;
import commons.PageGeneratorManagerUser;
import pageUIs.NopCommerUser.HomePageUIs;
import pageUIs.NopCommerUser.LoginPageUIs;

import java.util.ArrayList;
import java.util.List;

public class HomePageObject extends BasePage{
	private WebDriver driver;
	public HomePageObject(WebDriver driver) {
		super(driver);
		this.driver = driver;
	}

	public RegisterPageObject clickToRegister() {
		waitForElementVisible(HomePageUIs.REGISTER_LINK);
		clickToElement(HomePageUIs.REGISTER_LINK);
		return new PageGeneratorManagerUser().getRegisterPageObject(driver);
	}

	public LoginPageObject clickToLinkLogin() {
		waitForElementClickable(HomePageUIs.LOGIN_LINK);
		clickToElement(HomePageUIs.LOGIN_LINK);
		return new PageGeneratorManagerUser().getLoginPageObject(driver);
	}

	public String getTitlePage() {
		waitForElementVisible(LoginPageUIs.LINK_LOGOUT);
		return getTitle();
	}

	public String getTextLogout() {
		waitForElementVisible(LoginPageUIs.LINK_LOGOUT);
		return getTextElement(LoginPageUIs.LINK_LOGOUT);
	}


	public DetailProductPageObject clickAddToCard() {
		scrollToElement(HomePageUIs.LOCATOR_CONTIENT_PRODUCT);
		waitForElementClickable(HomePageUIs.ADD_TO_CARD_BUTTON);
		clickToElement(HomePageUIs.ADD_TO_CARD_BUTTON);
		return PageGeneratorManagerUser.getDetailProductPageObject(driver);
	}

    public AdvencedSearchPageObject clickSearchFooter() {
		scrollToElement(HomePageUIs.SEARCH_LINK_FOOTER);
		waitForElementClickable(HomePageUIs.SEARCH_LINK_FOOTER);
		clickToElement(HomePageUIs.SEARCH_LINK_FOOTER);
		return PageGeneratorManagerUser.getAdvencedSearchPageObject(driver);
    }

    public void clickAddToCompare(String indexProduct) {
		waitForElementVisible(HomePageUIs.CONTAINT_PRODUCT_HOMEPAGE);
		scrollToElement(HomePageUIs.CONTAINT_PRODUCT_HOMEPAGE);
		for(int i=1; i<= Integer.parseInt(indexProduct); i++){
			waitForElementVisible(HomePageUIs.COMPARE_BUTTON, Integer.toString(i));
			clickToElement(HomePageUIs.COMPARE_BUTTON, Integer.toString(i));
		}
    }

	public List<String> getNameProduct(String indexProduct) {
		List<String> tempararyList = new ArrayList<>();
		for (int i = 1; i <= Integer.parseInt(indexProduct); i++) {
			tempararyList.add(getTextElement(HomePageUIs.NAME_TITLE_PRODUCT_LINK, Integer.toString(i)));
		}
		return tempararyList;
	}

	public List<String> getPriceProduct(String indexProduct) {
		List<String> tempararyList = new ArrayList<>();
		for (int i = 1; i <= Integer.parseInt(indexProduct); i++) {
			tempararyList.add(getTextElement(HomePageUIs.PRICE_TITLE_PRODUCT, Integer.toString(i)));
		}
		return tempararyList;
	}

	public String getMessageAddCompareSuccess() {
		waitForElementVisible(HomePageUIs.MEASSAGE_ADD_COMPARE_SUSSUCCE);
		return getTextElement(HomePageUIs.MEASSAGE_ADD_COMPARE_SUSSUCCE);
	}

	public CompareProductsPageObject clickCompareProduct() {
		scrollToElement(HomePageUIs.COMPARE_FOOTER_LINK);
		waitForElementClickable(HomePageUIs.COMPARE_FOOTER_LINK);
		clickToElement(HomePageUIs.COMPARE_FOOTER_LINK);
		return PageGeneratorManagerUser.getCompareProductsPageObject(driver);
	}

	public DetailProductPageObject clickViewDetailProduct(int i) {
		waitForElementClickable(HomePageUIs.TITLE_PRODUCT_LINK,Integer.toString(i));
		clickToElement(HomePageUIs.TITLE_PRODUCT_LINK,Integer.toString(i));
		return PageGeneratorManagerUser.getDetailProductPageObject(driver);
	}

    public RecentlyViewedProductsPageObject clickRecentlyViewProducts() {
		scrollToElement(HomePageUIs.RECENTLY_FOOTER_LINK);
		waitForElementClickable(HomePageUIs.RECENTLY_FOOTER_LINK);
		clickToElement(HomePageUIs.RECENTLY_FOOTER_LINK);

		return PageGeneratorManagerUser.getRecentlyViewedProductsPageObject(driver);
	}
}
