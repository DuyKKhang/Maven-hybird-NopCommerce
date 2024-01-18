package pageObject.NopCommer;

import org.openqa.selenium.WebDriver;

import commons.BasePage;

public class PageObjectRegister extends BasePage{

	public PageObjectRegister(WebDriver driver) {
		super(driver);
	}
	
	public void openPageTest(String url) {
		openPageUrl(url);
	}

}
