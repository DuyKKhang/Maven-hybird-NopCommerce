package commons;

import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.Color;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BasePage {
	private long longTimeout = GlobalConstants.getGlobalConstants().getLongTimeOut();
	private long shortTimeout = GlobalConstants.getGlobalConstants().getShortTimeOut();;
	private WebDriver driver;
	
	public BasePage(WebDriver driver) {
		this.driver = driver;
	}
	
//	public static BasePage getBasePageObject() {
//		return new BasePage();
//	}
	
	protected void openPageUrl(String pageUrl) {
		driver.get(pageUrl);
	}
	
	protected String getTitle() {
		return driver.getTitle();
	}
	
	protected String getCurrentURL() {
		return driver.getCurrentUrl();
	}
	
	protected String getPageSourve() {
		return driver.getPageSource();
	}
	
	protected void backToPage() {
		driver.navigate().back();
	}
	
	protected void forwardToPage() {
		driver.navigate().forward();
	}
	
	protected void refreshCurrentPage() {
		driver.navigate().refresh();
	}
	
	protected Alert waitAlertPresence () {
		WebDriverWait exliciWait = new WebDriverWait(driver, longTimeout);
		return exliciWait.until(ExpectedConditions.alertIsPresent());
	}
	
	protected void acceptAlert() {
		waitAlertPresence().accept();
	}
	
	protected void cancelAlert() {
		waitAlertPresence().dismiss();
	}
	
	protected String getTextAlert() {
		return waitAlertPresence().getText();
	}
	
	protected void sendkeyToAlert(String textAlert) {
		waitAlertPresence().sendKeys(textAlert);
		
	}
	
	protected String getWindownHanble() {
		return driver.getWindowHandle();
	}
	
	protected void switchWindowByID(String idWindownParent) {
		Set<String> allWindowIDs = driver.getWindowHandles();
		for (String idWindow : allWindowIDs) {
			if( !idWindow.equals(idWindownParent)) {
				driver.switchTo().window(idWindow);
			}
		}
	}
	
	protected void switchWindowByTitle(String titleValue) {
		Set<String> allWindowIDs = driver.getWindowHandles();
		for (String id : allWindowIDs) {
			driver.switchTo().window(id);
			String titleWindown = driver.getTitle();
			if(titleWindown.equals(titleValue)) {
				break;
			}
		}
	}
	
	protected void closeAllWindowsWithoutParent(String idParent) {
		Set<String> allWindowIDs = driver.getWindowHandles();
		for (String id : allWindowIDs) {
			if(!id.equals(idParent)) {
				driver.switchTo().window(id);
				driver.close();
			}
		}
		driver.switchTo().window(idParent);
	}
	
	protected void highlightElement( String locatorType) {
		JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
		WebElement element = getWebElement(locatorType);
		String originalStyle = element.getAttribute("style");
		jsExecutor.executeScript("arguments[0].setAttribute(arguments[1], arguments[2])", element, "style", "border: 4px solid red; border-style: dashed;");
		sleep(1);
		jsExecutor.executeScript("arguments[0].setAttribute(arguments[1], arguments[2])", element, "style", originalStyle);
	}
	
	public void highlightElement( String locatorType, String...dynamicValues) {
		JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
		WebElement element = getWebElement(dynamicLocator(locatorType, dynamicValues));
		String originalStyle = element.getAttribute("style");
		jsExecutor.executeScript("arguments[0].setAttribute(arguments[1], arguments[2])", element, "style", "border: 4px solid red; border-style: dashed;");
		sleep(1);
		jsExecutor.executeScript("arguments[0].setAttribute(arguments[1], arguments[2])", element, "style", originalStyle);
	}
	
	public void sleep(long timeSleep)  {
		try {
			Thread.sleep(timeSleep*1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	private By getByElement(String locatorType) {
		By by = null;
		if(locatorType.startsWith("ID=")|| locatorType.startsWith("id=") || locatorType.startsWith("Id=")) {
			by = By.id(locatorType.substring(3));
		}else if(locatorType.startsWith("CLASS=")|| locatorType.startsWith("class=") || locatorType.startsWith("Class=")) {
			by = By.className(locatorType.substring(6));
		}else if(locatorType.startsWith("CSS=")|| locatorType.startsWith("css=") || locatorType.startsWith("Css=")) {
			by = By.cssSelector(locatorType.substring(4));
		}else if(locatorType.startsWith("XPATH=")|| locatorType.startsWith("xpath=") || locatorType.startsWith("Xpath=")) {
			by = By.xpath(locatorType.substring(6));
		}else {
			throw new  RuntimeException("Locator type is not supporter!");
		}
		return by;
	}
	
	private String dynamicLocator(String locatorType, String... dynamicValues) {
		if(locatorType.startsWith("xpath=") || locatorType.startsWith("XPATH=") || locatorType.startsWith("XPath="))
		{
			locatorType = String.format(locatorType, ( Object [] ) dynamicValues);
		}
		return locatorType;
	}
	
	private WebElement getWebElement(String locatorType) {
		return driver.findElement(getByElement(locatorType));
	}
	
	private List<WebElement> getWebElements(String locatorType){
		return driver.findElements(getByElement(locatorType));
	}
	
	protected void clickToElement(String locator) {
		highlightElement(locator);
		getWebElement(locator).click();
	}
	
	protected void clickToElement(String locator, String...dynamicLocator) {
		highlightElement(dynamicLocator(locator, dynamicLocator));
		getWebElement(dynamicLocator(locator, dynamicLocator)).click();
	}
	
	protected void sendkeyToElement(String locator, String values) {
		highlightElement(locator);
		WebElement element = getWebElement(locator);
		element.clear();
		element.sendKeys(values);
	}
	
	protected void sendkeyToElement(String locator, String values, String...dynamicLocator) {
		highlightElement(dynamicLocator(locator, dynamicLocator));
		WebElement element = getWebElement(dynamicLocator(locator, dynamicLocator));
		element.clear();
		element.sendKeys(values);	
	}
	
	protected void clearValueInElementByPressKey(String locator) {
		WebElement element = getWebElement(locator);
		element.sendKeys(Keys.chord(Keys.CONTROL, "a", Keys.DELETE));
	}
	
	protected void selectItemInDropDownBy_Values(String locator, String values) {
		highlightElement(locator);
		Select select = new Select(getWebElement(locator));
		select.selectByValue(values);
	}

	protected void selectItemInDropDownBy_Values(String locator, String values, String...dynamicLocator) {
		highlightElement(dynamicLocator(locator, dynamicLocator));
		Select select = new Select(getWebElement(dynamicLocator(locator, dynamicLocator)));
		select.selectByValue(values);
	}
	
	protected void selectItemInDropDownBy_Text(String locator, String valuesText ) {
		highlightElement(locator);
		Select select = new Select(getWebElement(locator));
		select.selectByVisibleText(valuesText);
	}
	
	protected void selectItemInDropDownBy_Text(String locator, String valuesText, String...dynamicLocator ) {
		highlightElement(dynamicLocator(locator, dynamicLocator));
		Select select = new Select(getWebElement(dynamicLocator(locator, dynamicLocator)));
		select.selectByVisibleText(valuesText);
	}
	
	protected boolean isDropdownMultiple(String locator) {
		Select select = new Select(getWebElement(locator));
		return select.isMultiple();
	}
	
	protected String getSelectedItemInDropdown(String locator) {
		Select select = new Select(getWebElement(locator));
		return select.getFirstSelectedOption().getText();
	}
	
	protected void selectItemInCustomDropdown(String locatorParent, String loatorChill, String valueText) {
		getWebElement(locatorParent).click();
		
		WebDriverWait expliciWait = new WebDriverWait(driver, longTimeout);
		
		List<WebElement> allItem = expliciWait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(getByElement(loatorChill)));
		
		for (WebElement item : allItem) {
		
			if(item.getText().trim().equals(valueText)) {
			
				JavascriptExecutor jscript = (JavascriptExecutor) driver;
				
				jscript.executeScript("arguments[0].scrollIntoView(true);", item);
				
				item.click();
				
				break;
			}
		}
	}
	
	protected String getTextelement(String locator) {
		return getWebElement(locator).getText();
	}
	
	protected String getTextelement(String locator, String... dynamicValues) {
		return getWebElement(dynamicLocator(locator, dynamicValues)).getText();
	}
	
	protected String getAttributeElement(String locator, String nameAttribute) {
		return getWebElement(locator).getAttribute(nameAttribute);
	}
	
	protected String getCssValue(String locator, String propertyName) {
		return getWebElement(locator).getCssValue(propertyName);
	}
	
	protected String getHexaColorFromeRGBA(String rgbaValue) {
		return Color.fromString(rgbaValue).asHex().toUpperCase();
	}
	
	protected int getElementsSize(String locator) {
		return getWebElements(locator).size();
	}
	
	protected void checkTheCheckboxOrRadio(String locator) {
		WebElement elementCheck = getWebElement(locator);
		if(!elementCheck.isSelected()) {
			elementCheck.click();
		}
	}
	
	protected void uncheckTheCheckboxOrRadio(String locator) {
		WebElement elementCheck = getWebElement(locator);
		if(elementCheck.isSelected()) {
			elementCheck.click();
		}
	}
	
	protected void checkTheCheckbox_MultipleCheck(String locator) {
		List<WebElement> elementCheck = getWebElements(locator);
		for (WebElement itemCheck : elementCheck) {
			if (!itemCheck.isSelected()) {
				itemCheck.click();
			}
		}
	}
	
	protected void unCheckTheCheckbox_MultipleCheck(String locator) {
		List<WebElement> elementCheck = getWebElements(locator);
		for (WebElement itemCheck : elementCheck) {
			if (itemCheck.isSelected()) {
				itemCheck.click();
			}
		}
	}
	
	protected boolean isControlDisplayed(String locator) {
		return getWebElement(locator).isDisplayed();
	}

	protected boolean isControlSelected(String locator) {
		return getWebElement(locator).isSelected();
	}
	
	protected boolean isControlEnable(String locator) {
		return getWebElement(locator).isEnabled();
	}
	
	private void overrideImplicitTimeout(long timOut) {
		driver.manage().timeouts().implicitlyWait(timOut, TimeUnit.SECONDS);
	}
	
	protected boolean isUnDisplayed(String locator) {
		overrideImplicitTimeout(GlobalConstants.getGlobalConstants().getShortTimeOut());
		List<WebElement> element = getWebElements(locator);
		overrideImplicitTimeout(GlobalConstants.getGlobalConstants().getLongTimeOut());
		if(element.size()==0) {
			return true;
		}else if (element.size() > 0 && !element.get(0).isDisplayed()) {
			return true;
		}else {
		return false;
		}
	}
	
	protected void switchToFrame(String locator) {
		driver.switchTo().frame(getWebElement(locator));
	}

	protected void switchToDefaultContentFrame() {
		driver.switchTo().defaultContent();
	}
	
	protected void doubleClickToElement(String locator) {
		Actions action = new Actions(driver);
		action.moveToElement(getWebElement(locator)).doubleClick().perform();
	}
	
	protected void hoverMouseToElement(String locator) {
		Actions action = new Actions(driver);
		action.moveToElement(getWebElement(locator)).perform();
	}
	
	protected void sendKeyboardToElement(String lovator, Keys key) {
		Actions action = new Actions(driver);
		action.sendKeys(getWebElement(lovator),key).perform();
	}
	
	protected void upLoadFile(String locator, String file) {
		getWebElement(locator).sendKeys(file);
	}

	protected void scrollToBottomPage() {
		JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
		jsExecutor.executeScript("window.scrollBy(0,document.body.scrollHeight)");
	}
	
	protected String getElementValueByJSXpath( String xpathLocator) {
		JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
		xpathLocator = xpathLocator.replace("xpath=", "");
		return(String) jsExecutor.executeScript("return $(document.evaluate(\""+xpathLocator+"\", document, null, XPathResult.FIRST_ORDERED_NODE_TYPE, null).singleNodeValue).val()");
	}
	
	protected void sendkeyToElementByJS( String locatorType, String value) {
		JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
		jsExecutor.executeScript("arguments[0].setAttribute('value', '" + value + "')", getWebElement(locatorType));
	}

	protected void sendkeyToElementByJS( String locatorType, String value, String... dynamicValues) {
		JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
		jsExecutor.executeScript("arguments[0].setAttribute('value', '" + value + "')", getWebElement(dynamicLocator(locatorType, dynamicValues)));
	}
	
	protected void clickToElementByJS( String locatorType) {
		JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
		jsExecutor.executeScript("arguments[0].click();", getWebElement(locatorType));
	}
	protected void clickToElementByJS(String locatorType, String... dynamicValues) {
		JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
		jsExecutor.executeScript("arguments[0].click();", getWebElement(dynamicLocator(locatorType, dynamicValues)));
	}
	
	protected void scrollToElement(String locatorType) {
		JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
		jsExecutor.executeScript("arguments[0].scrollIntoView(true);", getWebElement(locatorType));
	}
	protected void scrollToElement( String locatorType, String... dynamicValues) {
		JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
		jsExecutor.executeScript("arguments[0].scrollIntoView(true);", getWebElement(dynamicLocator(locatorType, dynamicValues)));
	}
	
	protected void removeAttributeInDOM( String locatorType, String attributeRemove) {
		JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
		jsExecutor.executeScript("arguments[0].removeAttribute('" + attributeRemove + "');", getWebElement( locatorType));
	}

	public boolean areJQueryAndJSLoadedSuccess(WebDriver driver) {
		WebDriverWait explicitWait = new WebDriverWait(driver, longTimeout);
		final JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
		
		ExpectedCondition<Boolean> jQueryLoad = new ExpectedCondition<Boolean>() {
			@Override
			public Boolean apply(WebDriver driver) {
				try {
					return ((Long) jsExecutor.executeScript("return jQuery.active") == 0);
				} catch (Exception e) {
					return true;
				}
			}
		};

		ExpectedCondition<Boolean> jsLoad = new ExpectedCondition<Boolean>() {
			@Override
			public Boolean apply(WebDriver driver) {
				return jsExecutor.executeScript("return document.readyState").toString().equals("complete");
			}
		};

		return explicitWait.until(jQueryLoad) && explicitWait.until(jsLoad);
	}
	
	protected String getElementAttribute( String locatorType, String attributeName) {
		return getWebElement( locatorType).getAttribute(attributeName);
	}
	
	protected String getAttrabuteValue (String locatorType, String attrabuteValue) {
		return getWebElement(locatorType).getAttribute(attrabuteValue);
	}

	protected String getElementValidationMessage(String locator) {
		JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
		return (String) jsExecutor.executeScript("return arguments[0].validationMessage;", getWebElement(locator));
	}

	protected boolean isImageLoaded(String locator) {
		JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
		boolean status = (boolean) jsExecutor.executeScript("return arguments[0].complete && typeof arguments[0].naturalWidth != \"undefined\" && arguments[0].naturalWidth > 0", getWebElement(locator));
		return status;
	}
	
	protected boolean isImageLoaded( String locator, String... dynamicValues) {
		JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
		boolean status = (boolean) jsExecutor.executeScript("return arguments[0].complete && typeof arguments[0].naturalWidth != \"undefined\" && arguments[0].naturalWidth > 0", getWebElement(dynamicLocator(locator, dynamicValues)));
			return status;
	}
	
	protected void waitForElementVisible(String locator) {
		WebDriverWait explicitWait = new WebDriverWait(driver, longTimeout);
		explicitWait.until(ExpectedConditions.visibilityOfElementLocated(getByElement(locator)));
	}
	protected void waitForElementVisible(String locator, String... dynamicValues) {
		WebDriverWait explicitWait = new WebDriverWait(driver, longTimeout);
		explicitWait.until(ExpectedConditions.visibilityOfElementLocated(getByElement(dynamicLocator(locator, dynamicValues))));
	}

	protected void waitForElementAllVisible(String locator) {
		WebDriverWait explicitWait = new WebDriverWait(driver, longTimeout);
		explicitWait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(getByElement(locator)));
	}
	protected void waitForElementAllVisible(String locator, String... dynamicValues) {
		WebDriverWait explicitWait = new WebDriverWait(driver, longTimeout);
		explicitWait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(getByElement(dynamicLocator(locator, dynamicValues))));
	}

	protected void waitForElementInvisible(String locator) {
		WebDriverWait explicitWait = new WebDriverWait(driver, longTimeout);
		explicitWait.until(ExpectedConditions.invisibilityOfElementLocated(getByElement(locator)));
	}
	protected void waitForElementInvisible(String locator, String... dynamicValues) {
		WebDriverWait explicitWait = new WebDriverWait(driver, longTimeout);
		explicitWait.until(ExpectedConditions.invisibilityOfElementLocated(getByElement(dynamicLocator(locator, dynamicValues))));
	}

	protected void waitForAllElementInvisible(String locator) {
		WebDriverWait explicitWait = new WebDriverWait(driver, longTimeout);
		explicitWait.until(ExpectedConditions.invisibilityOfAllElements(getWebElements(locator)));
	}
	protected void waitForAllElementInvisible(String locator, String... dynamicValues) {
		WebDriverWait explicitWait = new WebDriverWait(driver, longTimeout);
		explicitWait.until(ExpectedConditions.invisibilityOfAllElements(getWebElements(dynamicLocator(locator, dynamicValues))));
	}
	
	protected void waitForElementClickable(String locator) {
		WebDriverWait explicitWait = new WebDriverWait(driver, longTimeout);
		explicitWait.until(ExpectedConditions.elementToBeClickable(getByElement(locator)));
	}
	protected void waitForElementClickable(String locator, String... dynamicValues) {
		WebDriverWait explicitWait = new WebDriverWait(driver, longTimeout);
		explicitWait.until(ExpectedConditions.elementToBeClickable(getByElement(dynamicLocator(locator, dynamicValues))));
	}

	
}
