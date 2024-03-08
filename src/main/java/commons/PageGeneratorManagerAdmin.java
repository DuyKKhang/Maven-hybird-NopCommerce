package commons;

import org.openqa.selenium.WebDriver;
import pageObject.NopcommerAdmin.*;

public class PageGeneratorManagerAdmin {
    public static LoginAdminPageObject getLoginAdminPageObject(WebDriver driver) {
        return new LoginAdminPageObject(driver);
    }
    public static DashBoardAdminPageObject getDashBoardAdminPageObject(WebDriver driver) {
        return new DashBoardAdminPageObject(driver);
    }
    public static ProductsCatologAdminPageObject getProductsCatologAdminPageObject(WebDriver driver) {
        return new ProductsCatologAdminPageObject(driver);
    }
    public static CustomersAdminPageObject getCustomersAdminPageObject(WebDriver driver) {
        return new CustomersAdminPageObject(driver);
    }
    public static DetailsCustomersAdminPageObject getDetailsCustomersAdminPageObject(WebDriver driver) {
        return new DetailsCustomersAdminPageObject(driver);
    }
}
