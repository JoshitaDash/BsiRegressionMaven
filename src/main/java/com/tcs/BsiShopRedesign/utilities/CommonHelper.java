package com.tcs.BsiShopRedesign.utilities;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Properties;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import com.relevantcodes.extentreports.LogStatus;

public class CommonHelper extends Page {

	public CommonHelper() throws Exception {
		super(driver);
	}

	public static boolean checkVisibility(By by) {
		try {
			driver.findElement((by)).isDisplayed();
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	public static boolean isElementPresent(By by) {
		try {
			if (driver.findElement((by)).isDisplayed() & driver.findElement((by)).isEnabled())
				return true;
			else
				return false;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	public static void takeScreenShot() {

		String userDir = System.getProperty("user.dir");
		Date d = new Date();
		String screenshotFile = d.toString().replace(":", "_").replace(" ", "_") + ".png";
		String filePath = userDir + "//reports//screenshots//" + screenshotFile;
		// store screenshot in that file
		File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);

		try {
			FileUtils.copyFile(scrFile, new File(filePath));
		} catch (IOException e) {
			e.printStackTrace();
		}
		test.log(LogStatus.INFO, test.addScreenCapture(filePath));
	}

	public static void reportFailure(String failureMessage) {
		test.log(LogStatus.FAIL, failureMessage);
		takeScreenShot();
		Assert.fail(failureMessage);
	}

	public static boolean isNull(String var) {

		try {
			if (var.equals(null)) {
				return true;
			} else {
				return false;
			}
		} catch (Exception e) {

			return true;
		}
	}

	public static String readPropertiesFile(String value) throws IOException {
		String result = null;
		try {
			FileReader reader;
			String userdir = System.getProperty("user.dir");
			reader = new FileReader(userdir + "\\TestData\\TestData.properties");
			// reader = new
			// FileReader("D:\\BSI_Workspace\\BsiShopRedesign\\TestData\\TestData.properties");
			Properties p = new Properties();
			p.load(reader);

			result = p.getProperty(value);

		} catch (FileNotFoundException e) {
			reportFailure("Test Data path not found");
			e.printStackTrace();

		}
		return result;
	}

	public static WebElement element(String locator) {
		WebElement e = null;
		try {
			if (locator.endsWith("_xpath"))
				e = driver.findElement(By.xpath(prop.getProperty(locator)));
			else if (locator.endsWith("_id"))
				e = driver.findElement(By.id(prop.getProperty(locator)));
			else if (locator.endsWith("_css"))
				e = driver.findElement(By.cssSelector(prop.getProperty(locator)));
			else if (locator.endsWith("_linkText"))
				e = driver.findElement(By.linkText(prop.getProperty(locator)));

		} catch (Exception e1) {
			test.log(LogStatus.FAIL, locator + " WebElement is not Visible");
			e1.printStackTrace();
		}
		return e;

	}

	public static String getTitle() {
		String title = driver.getTitle();
		return title;
	}

	public static List<WebElement> getElements(String locator) {

		List<WebElement> elementList = null;

		if (locator.endsWith("_xpath"))
			elementList = (driver.findElements(By.xpath(prop.getProperty(locator))));
		else if (locator.endsWith("_id"))
			elementList = driver.findElements(By.id(prop.getProperty(locator)));
		else if (locator.endsWith("_css"))
			elementList = driver.findElements(By.cssSelector(prop.getProperty(locator)));
		else if (locator.endsWith("_linkText"))
			elementList = driver.findElements(By.linkText(prop.getProperty(locator)));

		return elementList;
	}

	public static int getElementsSize(String locator) {

		List<WebElement> elementList = null;
		if (locator.endsWith("_xpath"))
			elementList = (driver.findElements(By.xpath(prop.getProperty(locator))));
		else if (locator.endsWith("_id"))
			elementList = driver.findElements(By.id(prop.getProperty(locator)));
		else if (locator.endsWith("_css"))
			elementList = driver.findElements(By.cssSelector(prop.getProperty(locator)));
		else if (locator.endsWith("_linkText"))
			elementList = driver.findElements(By.linkText(prop.getProperty(locator)));
		int noOfElements = elementList.size();

		return noOfElements;
	}

	public static void scrolltoview(String locator) {
		try {
			JavascriptExecutor jse = (JavascriptExecutor) driver;
			jse.executeScript("arguments[0].scrollIntoView(true);", element(locator));
			Thread.sleep(5000);
		} catch (Exception e) {
			e.printStackTrace();
			test.log(LogStatus.FAIL, locator + " Unable to perform scroll to view");
		}

	}

	public static void clickJS(WebElement webElement) {
		try {
			if (webElement.isDisplayed() && webElement.isEnabled()) {
				// WebElement element = driver.findElement((By) (webElement));
				JavascriptExecutor executor = (JavascriptExecutor) driver;
				executor.executeScript("arguments[0].click();", webElement);
			}
		} catch (Exception e) {
			e.printStackTrace();
			test.log(LogStatus.FAIL, webElement + " WebElement not found for ClickByJS");
		}
	}

	public static void clickByJS(String locator) {
		try {
			clickJS(element(locator));
		} catch (Exception e) {
			test.log(LogStatus.FAIL, locator + " Unable to perform ClickByJS");
			e.printStackTrace();
		}
	}

	public static void explicitWaitClickable(WebElement element) {
		try {
			WebDriverWait wait = new WebDriverWait(driver, 30);
			wait.until(ExpectedConditions.elementToBeClickable(element));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void elementToBeClickable(String locator) {
		try {
			explicitWaitClickable(element(locator));
		} catch (Exception e) {
			test.log(LogStatus.FAIL, locator + " Element not Clickable");
			e.printStackTrace();
		}
	}

	public static void explicitWaitVisible(WebElement element) {
		try {
			WebDriverWait wait = new WebDriverWait(driver, 30);
			// wait.until(ExpectedConditions.visibilityOf(element));
			wait.until(ExpectedConditions.visibilityOf(element));
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public static void elementToBeVisible(String locator) {
		try {
			explicitWaitVisible(element(locator));
		} catch (Exception e) {
			test.log(LogStatus.FAIL, locator + " Element not Visible after Wait");
			e.printStackTrace();
		}
	}

	public static void visibilityOfElement(WebElement element) throws Exception {
		try {
			element.isDisplayed();
			element.isEnabled();
		} catch (Exception e) {
			test.log(LogStatus.FAIL, element + " Element is not Displayed and Enabled");
			e.printStackTrace();
		}
	}

	public static boolean isElementVisible(String locator) {
		try {
			visibilityOfElement(element(locator));
			return true;
		} catch (Exception e) {
			test.log(LogStatus.FAIL, locator + " Element is not Visible");
			e.printStackTrace();
			return false;
		}

	}

	public static String windowHandle() {
		try {

			String parentWindowHandler = driver.getWindowHandle(); // Store your parent window
			String subWindowHandler = null;

			Set<String> handles = driver.getWindowHandles(); // get all window handles
			Iterator<String> iterator = handles.iterator();
			while (iterator.hasNext()) {
				subWindowHandler = iterator.next();
			}
			driver.switchTo().window(subWindowHandler); // switch to pop-up window
			driver.manage().window().maximize();

		} catch (Exception e) {

			return null;
		}
		return null;
	}

	public static void mHover(String locator) {
		try {
			Actions action = new Actions(driver);
			WebElement we = (element(locator));
			action.moveToElement(we).build().perform();

		} catch (Exception e) {
			e.printStackTrace();

		}
	}

	public static boolean isElementHiddenNow(String xpath) {
		turnOffImplicitWaits();
		boolean result = ExpectedConditions.invisibilityOfElementLocated(By.xpath(xpath)).apply(driver);
		turnOnImplicitWaits();
		return result;
	}

	public static void turnOffImplicitWaits() {
		driver.manage().timeouts().implicitlyWait(0, TimeUnit.SECONDS);
	}

	public static void turnOnImplicitWaits() {
		driver.manage().timeouts().implicitlyWait(45, TimeUnit.SECONDS);
	}

	public static void waitForLoad(WebDriver driver) {
		ExpectedCondition<Boolean> pageLoadCondition = new ExpectedCondition<Boolean>() {
			public Boolean apply(WebDriver driver) {
				return ((JavascriptExecutor) driver).executeScript("return document.readyState").equals("complete");
			}
		};
		WebDriverWait wait = new WebDriverWait(driver, 30);
		wait.until(pageLoadCondition);
	}

	public static void handleAlert() {
		if (isAlertPresent()) {
			Alert alert = driver.switchTo().alert();
			System.out.println(alert.getText());
			alert.accept();
		}
	}

	public static void dismissAlert() {
		if (isAlertPresent()) {
			Alert alert = driver.switchTo().alert();
			System.out.println(alert.getText());
			alert.dismiss();
		}
	}

	public static boolean isAlertPresent() {
		try {
			driver.switchTo().alert();
			return true;
		} catch (org.openqa.selenium.NoAlertPresentException ex) {
			return false;
		}
	}
}
