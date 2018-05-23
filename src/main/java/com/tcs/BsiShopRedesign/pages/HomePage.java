package com.tcs.BsiShopRedesign.pages;

import java.io.FileInputStream;

import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import com.relevantcodes.extentreports.LogStatus;

import com.tcs.BsiShopRedesign.utilities.BaseTest;
import jxl.Sheet;
import jxl.Workbook;
import net.bytebuddy.utility.RandomString;
import com.tcs.BsiShopRedesign.utilities.CommonHelper;

public class HomePage extends BaseTest {

	public HomePage(WebDriver driver) throws Exception {
		super();
		// TODO Auto-generated constructor stub
	}

	public void clickHomePage() {

		try {

			test.log(LogStatus.INFO, "Click on Home Page");
			Log.info("Click on Home Page");
			System.out.println("Click on Home Page");
			CommonHelper.scrolltoview("bsiShopLogo_xpath");
			CommonHelper.elementToBeVisible("bsiShopLogo_xpath");
			CommonHelper.elementToBeClickable("bsiShopLogo_xpath");
			click("bsiShopLogo_xpath");

		} catch (Exception e) {
			CommonHelper.reportFailure("Click on Home Page was unsuccessful");
			e.printStackTrace();
			Assert.fail(e.getMessage());
		}

	}

	public void searchProduct() {

		WebDriverWait wait = new WebDriverWait(driver, 15);

		try {
			test = extent.startTest("Search PAS product");
			/*** To access to Workbook ***/
			String projectPath = System.getProperty("user.dir");
			String FilePath = projectPath + "\\TestData\\List_of_products_users-TCS.xls";
			// String FilePath = "C:\\Users\\529373\\Desktop\\BSI Automation
			// Demo\\List_of_products_users-Demo.xls";
			// String FilePath =
			// "D:\\BSI_FW\\BSI\\BSI.Automation.Regression\\TestData\\List_of_products_users-TCS.xls";
			FileInputStream fs = new FileInputStream(FilePath);
			Workbook wb = Workbook.getWorkbook(fs);

			// *** To get the sheet access by sheet name
			Sheet sh = wb.getSheet("Products");

			// *** To get the number of rows present in sheet
			int totalNoOfRows = sh.getRows();
			System.out.println("The total no. of rows are: " + totalNoOfRows);

			// *** To get the number of columns present in sheet
			int totalNoOfCols = sh.getColumns();
			System.out.println("The total no. of columns are: " + totalNoOfCols);

			// *** To get the content in particular location, which will return
			// *** contents as a string

			String CellGetContent = sh.getCell(0, 1).getContents();
			System.out.println("The content of the cell is: " + CellGetContent);

			Log.info("Enter product name in Search textbox");
			System.out.println("Enter product name in Search textbox");
			test.log(LogStatus.INFO, "Enter product name in Search textbox");
			WebElement search = wait.until(ExpectedConditions.elementToBeClickable(By.id("search-box")));
			search.clear();
			search.sendKeys(CellGetContent);

			Log.info("Click on Search");
			System.out.println("Click on Search");
			test.log(LogStatus.INFO, "Click on Search");
			click("searchButton_id");

			Log.info("Select the Product");
			System.out.println("Select the Product");
			test.log(LogStatus.INFO, "Select the Product");
			WebElement product = driver.findElement(By.linkText(CellGetContent));
			Thread.sleep(500);
			product.click();

		} catch (Exception e) {
			test.log(LogStatus.FATAL, "Download Materials for PAS product was unsuccessful");
			CommonHelper.reportFailure("");
			e.printStackTrace();
			Assert.fail(e.getMessage());
		}
	}

	public void searchPASProduct() throws Exception {

		Log.info("Enter product name in Search textbox");
		System.out.println("Enter product name in Search textbox");
		test.log(LogStatus.INFO, "Enter product name in Search textbox");
		CommonHelper.elementToBeClickable("searchBox_id");
		clearText("searchBox_id");
		enterText("searchBox_id", "PAS");

		Log.info("Click on Search");
		System.out.println("Click on Search");
		test.log(LogStatus.INFO, "Click on Search");
		click("searchButton_css");
	}

	public void searchEvents() throws Exception {

		Log.info("Enter product name in Search textbox");
		System.out.println("Enter product name in Search textbox");
		test.log(LogStatus.INFO, "Enter product name in Search textbox");
		CommonHelper.elementToBeClickable("searchBox_id");
		clearText("searchBox_id");
		enterText("searchBox_id", "Events");

		Log.info("Click on Search");
		System.out.println("Click on Search");
		test.log(LogStatus.INFO, "Click on Search");
		click("searchButton_css");
	}

	public void searchBooks() throws Exception {

		Log.info("Enter product name in Search textbox");
		System.out.println("Enter product name in Search textbox");
		test.log(LogStatus.INFO, "Enter product name in Search textbox");
		CommonHelper.elementToBeClickable("searchBox_id");
		clearText("searchBox_id");
		enterText("searchBox_id", "Book");

		Log.info("Click on Search");
		System.out.println("Click on Search");
		test.log(LogStatus.INFO, "Click on Search");
		click("searchButton_css");
	}

	public void searchQualityProduct() throws Exception {

		Log.info("Enter product name in Search textbox");
		System.out.println("Enter product name in Search textbox");
		test.log(LogStatus.INFO, "Enter product name in Search textbox");
		CommonHelper.elementToBeClickable("searchBox_id");
		clearText("searchBox_id");
		enterText("searchBox_id", "Quality");

		Log.info("Click on Search");
		System.out.println("Click on Search");
		test.log(LogStatus.INFO, "Click on Search");
		click("searchButton_css");
	}

	public void searchASTMProduct() throws Exception {

		Log.info("Enter product name in Search textbox");
		System.out.println("Enter product name in Search textbox");
		test.log(LogStatus.INFO, "Enter product name in Search textbox");
		CommonHelper.elementToBeClickable("searchBox_id");
		clearText("searchBox_id");
		enterText("searchBox_id", "ASTM");

		Log.info("Click on Search");
		System.out.println("Click on Search");
		test.log(LogStatus.INFO, "Click on Search");
		click("searchButton_css");
	}
	
	public void searchHealthProduct() throws Exception {

		Log.info("Enter product name in Search textbox");
		System.out.println("Enter product name in Search textbox");
		test.log(LogStatus.INFO, "Enter product name in Search textbox");
		CommonHelper.elementToBeClickable("searchBox_id");
		clearText("searchBox_id");
		enterText("searchBox_id", "Health");

		Log.info("Click on Search");
		System.out.println("Click on Search");
		test.log(LogStatus.INFO, "Click on Search");
		click("searchButton_css");
	}


	public void searchFreeEvent() throws Exception {

		Log.info("Enter product name in Search textbox");
		System.out.println("Enter product name in Search textbox");
		test.log(LogStatus.INFO, "Enter product name in Search textbox");
		CommonHelper.elementToBeClickable("searchBox_id");
		clearText("searchBox_id");
		enterText("searchBox_id", "Sustainability Performance and Reporting Event – 2016");

		Log.info("Click on Search");
		System.out.println("Click on Search");
		test.log(LogStatus.INFO, "Click on Search");
		click("searchButton_css");
	}

	public void searchPaidEvent() throws Exception {

		Log.info("Enter product name in Search textbox");
		System.out.println("Enter product name in Search textbox");
		test.log(LogStatus.INFO, "Enter product name in Search textbox");
		CommonHelper.elementToBeClickable("searchBox_id");
		clearText("searchBox_id");
		enterText("searchBox_id", "Fire Safety Conference");

		Log.info("Click on Search");
		System.out.println("Click on Search");
		test.log(LogStatus.INFO, "Click on Search");
		click("searchButton_css");
	}

	public void blankSearch() throws Exception {

		Log.info("Clear Text in Search textbox");
		System.out.println("Clear Text in Search textbox");
		test.log(LogStatus.INFO, "Clear Text in Search textbox");
		CommonHelper.elementToBeClickable("searchBox_id");
		clearText("searchBox_id");

		Log.info("Click on Search");
		System.out.println("Click on Search");
		test.log(LogStatus.INFO, "Click on Search");
		click("searchButton_css");
	}

	public void searchFireProduct() throws InterruptedException {

		Log.info("Enter product name in Search textbox");
		System.out.println("Enter product name in Search textbox");
		test.log(LogStatus.INFO, "Enter product name in Search textbox");
		CommonHelper.elementToBeClickable("searchBox_id");
		clearText("searchBox_id");
		enterText("searchBox_id", "Fire");

		Log.info("Click on Search");
		System.out.println("Click on Search");
		test.log(LogStatus.INFO, "Click on Search");
		click("searchButton_css");
		Thread.sleep(3000);
	}

	public void clickReg() throws Exception {

		Log.info("Click on Register");
		System.out.println("Click on Register");
		test.log(LogStatus.INFO, "Click on Register");
		CommonHelper.elementToBeClickable("register_xpath");
		click("register_xpath");

	}

	public void enterRegDetails() {

		try {

			Log.info("Enter Email");
			System.out.println("Enter Email");
			test.log(LogStatus.INFO, "Enter Email");
			CommonHelper.elementToBeClickable("emaidID_id");
			String email = RandomStringUtils.randomAlphabetic(5).toLowerCase();
			email = email + ".unique@tcs.com";
			enterText("emaidID_id", email);

			Log.info("Enter Password");
			System.out.println("Enter Password");
			test.log(LogStatus.INFO, "Enter Password");
			enterText("password_id", "Test@1234");

			Log.info("Enter Confirm Password");
			System.out.println("Enter Confirm Password");
			test.log(LogStatus.INFO, "Enter Confirm Password");
			enterText("confirmPwd_id", "Test@1234");

			Log.info("Select Title");
			System.out.println("Select Title");
			test.log(LogStatus.INFO, "Select Title");
			selectFirstOption("title_id");

			Log.info("Enter First Name");
			System.out.println("Enter First Name");
			test.log(LogStatus.INFO, "Enter First Name");
			String firstName = RandomStringUtils.randomAlphabetic(5).toLowerCase();
			enterText("firstName_id", firstName);

			Log.info("Enter Last Name");
			System.out.println("Enter Last Name");
			test.log(LogStatus.INFO, "Enter Last Name");
			String lastName = RandomStringUtils.randomAlphabetic(5).toLowerCase();
			enterText("lastName_id", lastName);

			/*Log.info("Enter Address Name");
			System.out.println("Enter Address Name");
			test.log(LogStatus.INFO, "Enter Address Name");
			String addressName = RandomStringUtils.randomAlphanumeric(7);
			enterText("addressName_id", addressName);*/

			/*Log.info("Select Country");
			System.out.println("Select Country");
			test.log(LogStatus.INFO, "Select Country");
			CommonHelper.scrolltoview("country_id");
			selectDpdwnText("country_id", "India");*/

			Log.info("Enter Postcode");
			System.out.println("Enter Postcode");
			test.log(LogStatus.INFO, "Enter Postcode");
			enterText("postcode_id", "AA11AA");

			Log.info("Click Find Address");
			System.out.println("Click Find Address");
			test.log(LogStatus.INFO, "Click Find Address");
			click("findAddress_css");

			Log.info("Select Your Address");
			System.out.println("Select Your Address");
			test.log(LogStatus.INFO, "Select Your Address");
			selectFirstOption("selectAddress_xpath");

			Log.info("Enter Telephone Number");
			System.out.println("Enter Telephone Number");
			test.log(LogStatus.INFO, "Enter Telephone Number");
			enterText("telephoneNum_id", "3154564685");

			Log.info("Check Privacy Statement and Terms & Conditons");
			System.out.println("Check Privacy Statement and Terms & Conditons");
			test.log(LogStatus.INFO, "Check Privacy Statement and Terms & Conditons");
			click("checkPolicy_id");

			Log.info("Click Create an Account");
			System.out.println("Click Create an Account");
			test.log(LogStatus.INFO, "Click Create an Account");
			click("createAccount_css");
			Thread.sleep(2000);

		} catch (Exception e) {
			CommonHelper.reportFailure("Enter registration details was unsuccessful");
			e.printStackTrace();
			Assert.fail(e.getMessage());
		}
	}

	public boolean verifyReg() {

		try {
			Thread.sleep(2000);
			Log.info("Verify Success Message");
			System.out.println("Verify Success Message");
			test.log(LogStatus.INFO, "Verify Success Message");
			CommonHelper.elementToBeVisible("successMsg_css");
			String verificationText = CommonHelper.element("successMsg_css").getText();
			//String verificationText = driver.findElement(By.cssSelector("div[data-bind*='html']")).getText();

			Thread.sleep(2000);
			if (verificationText.contains("Thank you for registering with BSI.")) {
				System.out.println("The Verification message is: " + verificationText);
				test.log(LogStatus.INFO, "The Verification message is: " + verificationText);
				test.log(LogStatus.PASS, "Registration was successful");
				return true;

			} else {
				test.log(LogStatus.INFO, "The Verification message is: " + verificationText);
				test.log(LogStatus.FAIL, "Registration was unsuccessful");
			}

		} catch (Exception e) {
			CommonHelper.reportFailure("Verification of registration details was unsuccessful");
			e.printStackTrace();
			Assert.fail(e.getMessage());
		}
		return false;
	}
	
	
	public void clickLogout() {
		try {
			Thread.sleep(1000);
			test.log(LogStatus.INFO, "Click Logout");
			Log.info("Click Logout");
			System.out.println("Click Logout");
			driver.findElement(By.linkText("Logout")).click();
			test.log(LogStatus.PASS, "Logged out Successfully");

			/*
			 * Thread.sleep(2000);
			 * CommonHelper.elementToBeVisible("verifyLogout_xpath"); String
			 * verifyLogout =
			 * CommonHelper.element("verifyLogout_xpath").getText();
			 * System.out.println("The verification message is: " +
			 * verifyLogout); test.log(LogStatus.PASS, "Logged out Successfully"
			 * );
			 */
		} catch (InterruptedException e) {
			CommonHelper.reportFailure("Logout was unsuccessful");
			e.printStackTrace();
			Assert.fail(e.getMessage());
		}

	}
	
	
}
