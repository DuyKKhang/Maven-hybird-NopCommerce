package pageObject.NopCommer;

import commons.BasePage;
import org.openqa.selenium.WebDriver;

public class WishlisPageObject extends BasePage {
    private WebDriver driver;
    public WishlisPageObject(WebDriver driver) {
        super(driver);
        this.driver = driver;
    }
}
