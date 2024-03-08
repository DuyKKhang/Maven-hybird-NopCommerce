package pageObject.NopCommerUser;

import commons.BasePage;
import commons.PageGeneratorManagerUser;
import org.openqa.selenium.WebDriver;
import pageUIs.NopCommerUser.ComputerPageUIs;

public class ComputerPageObject extends BasePage {
    private WebDriver driver;
    public ComputerPageObject(WebDriver driver) {
        super(driver);
        this.driver = driver;
    }

    public NotebooksPageObject clickLinkProductNotebooks(String valueProduct) {
        waitForElementClickable(ComputerPageUIs.DYNAMIC_COMPUTER_PRODUCT, valueProduct);
        clickToElement(ComputerPageUIs.DYNAMIC_COMPUTER_PRODUCT, valueProduct);

        return PageGeneratorManagerUser.getNotebooksPageObject(driver);
    }


}
