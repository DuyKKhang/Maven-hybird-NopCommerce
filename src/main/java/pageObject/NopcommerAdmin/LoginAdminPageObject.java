package pageObject.NopcommerAdmin;

import commons.BasePage;
import commons.PageGeneratorManagerAdmin;
import commons.PageGeneratorManagerUser;
import org.openqa.selenium.WebDriver;
import pageUIs.NopcommerAdmin.LoginAdminPageUIs;

public class LoginAdminPageObject extends BasePage {
    private WebDriver driver;
    public LoginAdminPageObject(WebDriver driver) {
        super(driver);
        this.driver = driver;
    }

    public void sendkeyTextBox(String dynamic, String value) {
        waitForElementVisible(LoginAdminPageUIs.LOGIN_TEXTBOX, dynamic);
        sendkeyToElement(LoginAdminPageUIs.LOGIN_TEXTBOX,value, dynamic);
    }

    public DashBoardAdminPageObject clickToButtonLoginSuccess() {
        waitForElementClickable(LoginAdminPageUIs.LOGIN_BUTTON);
        clickToElement(LoginAdminPageUIs.LOGIN_BUTTON);
        return PageGeneratorManagerAdmin.getDashBoardAdminPageObject(driver);
    }
}
