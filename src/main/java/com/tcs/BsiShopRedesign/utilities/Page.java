package com.tcs.BsiShopRedesign.utilities;

import java.io.FileInputStream;
import java.util.Properties;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;


public class Page {

	public static WebDriver driver;
	public static Logger Log = Logger.getLogger(BaseTest.class.getName());
	public static ExtentReports extent = ExtentManager.getInstance();
	public static ExtentTest test;
	public static Properties prop;

	public Page(WebDriver driver) throws Exception {
		Page.driver = driver;

		if (prop == null) {
			String userdir = System.getProperty("user.dir");
			prop = new Properties();
			System.out.println("Checking Properties Object");
			String filepath = userdir + "\\File.properties";
			//String filepath = "D:\\BSI_Workspace\\BsiShopRedesign\\File.properties";
			System.out.println("Properties path: " + filepath);
			// File file = new File(filepath);
			System.out.println("Before File Input stream");
			FileInputStream fileInput = new FileInputStream(filepath);
			System.out.println("After File Input stream");
			prop.load(fileInput);
			System.out.println("Properties Input");
		}
	}

	public void click(String locator) {
		try {
			if (!locator.isEmpty() && CommonHelper.isElementVisible(locator))
				CommonHelper.elementToBeVisible(locator);
			CommonHelper.elementToBeClickable(locator);
			CommonHelper.element(locator).click();
		} catch (Exception e) {
			test.log(LogStatus.FAIL, locator + " Click Element Not Found");
			e.printStackTrace();
		}
	}

	public void enterText(String locator, String text) {
		try {
			CommonHelper.elementToBeVisible(locator);
			CommonHelper.element(locator).sendKeys(text);

		} catch (Exception e) {
			test.log(LogStatus.FAIL, locator + " Unable to enter text");
			e.printStackTrace();
		}
	}

	public void clearText(String locator) {
		try {
			if (!locator.isEmpty())
				CommonHelper.elementToBeVisible(locator);
			CommonHelper.element(locator).clear();
		} catch (Exception e) {
			test.log(LogStatus.FAIL, locator + " Clear text Element Not Found");
			e.printStackTrace();
		}
	}

	public void selectFirstOption(String locator) {
		try {
			CommonHelper.elementToBeVisible(locator);
			Select dpdwn = new Select(CommonHelper.element(locator));
			dpdwn.selectByIndex(1);
			// dpdwn.getFirstSelectedOption();
		} catch (Exception e) {
			test.log(LogStatus.FAIL, " Cannot select first option from dropdown");
			e.printStackTrace();
		}
	}

	public void mouseHover(String locator) {
		Actions action = new Actions(driver);
		action.moveToElement(CommonHelper.element(locator)).build().perform();
	}

	public void selectDpdwnValue(String locator, String value) {
		try {
			CommonHelper.elementToBeVisible(locator);
			Select dpdwn = new Select(CommonHelper.element(locator));
			dpdwn.selectByValue(value);
		} catch (Exception e) {
			test.log(LogStatus.FAIL, " Cannot select the value from dropdown");
			e.printStackTrace();
		}
	}

	public void selectDpdwnText(String locator, String text) {
		try {
			CommonHelper.elementToBeVisible(locator);
			Select dpdwn = new Select(CommonHelper.element(locator));
			dpdwn.selectByVisibleText(text);
		} catch (Exception e) {
			test.log(LogStatus.FAIL, " Cannot select the value from dropdown");
			e.printStackTrace();
		}
	}
}
