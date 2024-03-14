package pageObject.NopcommerAdmin;

import commons.BasePage;
import org.openqa.selenium.WebDriver;
import pageUIs.NopcommerAdmin.DashBoardAdminPageUIs;
import pageUIs.NopcommerAdmin.LoginAdminPageUIs;

public class DashBoardAdminPageObject extends BasePage {
    private WebDriver driver;
    public DashBoardAdminPageObject(WebDriver driver) {
        super(driver);
        this.driver = driver;
    }

    public String getTextLogout() {
        waitForElementVisible(DashBoardAdminPageUIs.LOGOUT_LINK);
        return getTextElement(DashBoardAdminPageUIs.LOGOUT_LINK);
    }

    public String getTextTitle() {
        waitForElementVisible(DashBoardAdminPageUIs.DASHBOARD_TITLE);
        return getTextElement(DashBoardAdminPageUIs.DASHBOARD_TITLE);
    }


    public void refreshPage() {
        refreshCurrentPage();
    }
}
