package pageObject.NopCommerUser;

import commons.BasePage;
import org.openqa.selenium.WebDriver;
import pageUIs.NopCommerUser.ChangePassPageUIs;

public class ChangePassPageObject extends BasePage {
    private WebDriver driver;
    public ChangePassPageObject(WebDriver driver) {
        super(driver);
        this.driver = driver;
    }

    public void inputPassWordTextbox(String valueLocator, String dynamic) {
        waitForElementVisible(ChangePassPageUIs.PASSWORK_TEXTBOX,dynamic);
        sendkeyToElement(ChangePassPageUIs.PASSWORK_TEXTBOX,valueLocator,dynamic);
    }

    public void clickChangePassWordButton() {
        waitForElementClickable(ChangePassPageUIs.CHANGE_PASSWORD_BUTTON);
        clickToElement(ChangePassPageUIs.CHANGE_PASSWORD_BUTTON);
        sleep(1);
    }

    public String messageChangePassSuccess() {
        waitForElementVisible(ChangePassPageUIs.MESSAGE_CHANGE_PASSWORD_SUCCESS);
        return getTextElement(ChangePassPageUIs.MESSAGE_CHANGE_PASSWORD_SUCCESS);
    }

    public void clickDisableMessage() {
        waitForElementVisible(ChangePassPageUIs.CLOSE_MESSAGE);
        clickToElementByJS(ChangePassPageUIs.CLOSE_MESSAGE);
        waitForElementUndisplay(ChangePassPageUIs.CLOSE_MESSAGE);
    }
}
