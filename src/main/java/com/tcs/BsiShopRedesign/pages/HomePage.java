package com.tcs.BsiShopRedesign.pages;

import java.io.FileInputStream;
import java.util.ArrayList;

import org.apache.commons.lang3.RandomStringUtils;
import org.jsoup.Connection.Base;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import com.relevantcodes.extentreports.LogStatus;

import com.tcs.BsiShopRedesign.utilities.BaseTest;
import com.tcs.BsiShopRedesign.utilities.BsiConstants;

import jxl.Sheet;
import jxl.Workbook;
import net.bytebuddy.utility.RandomString;
import com.tcs.BsiShopRedesign.utilities.CommonHelper;

public class HomePage extends BaseTest {

	public HomePage(WebDriver driver) throws Exception {
		super();
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
		Thread.sleep(2000);
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
		CommonHelper.clickByJS("register_xpath");
		// click("register_xpath");

	}

	public void enterRegDetails() {

		try {
			Thread.sleep(1000);
			Log.info("Enter Email");
			System.out.println("Enter Email");
			test.log(LogStatus.INFO, "Enter Email");
			// CommonHelper.elementToBeClickable("emaidID_id");
			String email = RandomStringUtils.randomAlphabetic(5).toLowerCase();
			email = email + ".unique@tcs.com";
			enterText("emaidIDReg_id", email);

			Log.info("Enter Password");
			System.out.println("Enter Password");
			test.log(LogStatus.INFO, "Enter Password");
			enterText("passwordReg_id", "Test@1234");

			Log.info("Enter Confirm Password");
			System.out.println("Enter Confirm Password");
			test.log(LogStatus.INFO, "Enter Confirm Password");
			enterText("confirmPwdReg_id", "Test@1234");

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

			/*
			 * Log.info("Enter Address Name"); System.out.println("Enter Address Name");
			 * test.log(LogStatus.INFO, "Enter Address Name"); String addressName =
			 * RandomStringUtils.randomAlphanumeric(7); enterText("addressName_id",
			 * addressName);
			 */

			/*
			 * Log.info("Select Country"); System.out.println("Select Country");
			 * test.log(LogStatus.INFO, "Select Country");
			 * CommonHelper.scrolltoview("country_id"); selectDpdwnText("country_id",
			 * "India");
			 */

			Log.info("Enter Postcode");
			System.out.println("Enter Postcode");
			test.log(LogStatus.INFO, "Enter Postcode");
			enterText("postcode_id", "AA11AA");

			Thread.sleep(2000);
			Log.info("Click Find Address");
			System.out.println("Click Find Address");
			test.log(LogStatus.INFO, "Click Find Address");
			CommonHelper.clickByJS("findAddressReg_css");

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

	public void enterRegDetailsNonUK() {
		try {
			Thread.sleep(1000);
			Log.info("Enter Email");
			System.out.println("Enter Email");
			test.log(LogStatus.INFO, "Enter Email");
			// CommonHelper.elementToBeClickable("emaidID_id");
			String email = RandomStringUtils.randomAlphabetic(5).toLowerCase();
			email = email + ".unique@tcs.com";
			enterText("emaidIDReg_id", email);

			Log.info("Enter Password");
			System.out.println("Enter Password");
			test.log(LogStatus.INFO, "Enter Password");
			enterText("passwordReg_id", "Test@1234");

			Log.info("Enter Confirm Password");
			System.out.println("Enter Confirm Password");
			test.log(LogStatus.INFO, "Enter Confirm Password");
			enterText("confirmPwdReg_id", "Test@1234");

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

			Log.info("Enter Postcode");
			System.out.println("Enter Postcode");
			test.log(LogStatus.INFO, "Enter Postcode");
			enterText("postcode_id", "6001");

			// Thread.sleep(2000);
			Log.info("Click Find Address");
			System.out.println("Click Find Address");
			test.log(LogStatus.INFO, "Click Find Address");
			click("findAddressReg_css");

			Thread.sleep(2000);
			String manualAddressText = CommonHelper.element("manualAddressMsg_xpath").getText();
			System.out.println("The message is: " + manualAddressText);
			test.log(LogStatus.PASS, "The message is: " + manualAddressText);

			/*System.out.println("");
			Log.info("Click Find Address");
			System.out.println("Click Find Address");
			test.log(LogStatus.INFO, "Click Find Address");
			driver.findElement(By.xpath("//*[@id='m2_address']/div/div/div[1]/button/span")).click();*/
			

			Log.info("Enter Address Name");
			System.out.println("Enter Address Name");
			test.log(LogStatus.INFO, "Enter Address Name");
			CommonHelper.scrolltoview("addressName_id");
			String addressName = RandomStringUtils.randomAlphanumeric(7);
			enterText("addressName_id", addressName);

			Log.info("Enter Address Line 1");
			System.out.println("Enter Address Line 1");
			test.log(LogStatus.INFO, "Enter Address Line 1");
			enterText("addressLine1_id", "300 Kempston Road");

			Log.info("Enter Town/City");
			System.out.println("Enter Town/City");
			test.log(LogStatus.INFO, "Enter Town/City");
			enterText("city_id", "Port Elizabeth");

			Log.info("Select Country");
			System.out.println("Select Country");
			test.log(LogStatus.INFO, "Select Country");
			CommonHelper.scrolltoview("country_id");
			selectDpdwnText("country_id", "United States");

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
			CommonHelper.reportFailure("Enter registration details for Non-UK profile was unsuccessful");
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
			// String verificationText =
			// driver.findElement(By.cssSelector("div[data-bind*='html']")).getText();

			Thread.sleep(2000);
			if (verificationText.contains("You must confirm your account.")) {
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

	public void clickMyProfile() {
		try {
			Thread.sleep(1000);
			Log.info("Click on My Profile");
			System.out.println("Click on My Profile");
			test.log(LogStatus.INFO, "Click on My Profile");
			click("myProfile_id");
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			CommonHelper.reportFailure("Click on My Profile was unsuccessful");
			Assert.fail(e.getMessage());
			e.printStackTrace();
		}
	}

	/*
	 * public void clickLogout() { try { Thread.sleep(1000);
	 * Log.info("Click Logout"); System.out.println("Click Logout");
	 * driver.findElement(By.linkText("Logout")).click(); test.log(LogStatus.PASS,
	 * "Logged out Successfully");
	 * 
	 * 
	 * Thread.sleep(2000); CommonHelper.elementToBeVisible("verifyLogout_xpath");
	 * String verifyLogout = CommonHelper.element("verifyLogout_xpath").getText();
	 * System.out.println("The verification message is: " + verifyLogout);
	 * test.log(LogStatus.PASS, "Logged out Successfully" );
	 * 
	 * } catch (InterruptedException e) {
	 * CommonHelper.reportFailure("Logout was unsuccessful"); e.printStackTrace();
	 * Assert.fail(e.getMessage()); }
	 * 
	 * }
	 */

	public void clickLogout() {

		try {
			Thread.sleep(1000);
			Log.info("Click Logout");
			System.out.println("Click Logout");
			test.log(LogStatus.INFO, "Click Logout");
			click("logoutButton_id");
			Thread.sleep(2000);
			test.log(LogStatus.PASS, "Logged Out Successfully");

		} catch (Exception e) {
			CommonHelper.reportFailure("Click Logout was unsuccessful");
			Assert.fail(e.getMessage());
			e.printStackTrace();
		}
	}

	public void verifyTooltipMemberNum() {

		try {
			Thread.sleep(1000);
			CommonHelper.scrolltoview("memberTooltip_id");
			Thread.sleep(1000);
			CommonHelper.mHover("memberTooltip_id");
			Thread.sleep(1000);
			String memTooltip = driver.findElement(By.id("memberTooltip")).getAttribute("data-content");
			if (memTooltip.contains("Your 8-digit customer number")) {
				System.out.println("The tooltip message is: " + memTooltip);
				test.log(LogStatus.PASS, "The tooltip message is: " + memTooltip);
			} else {
				System.out.println("Verification of Tooltip for Member Number was unsuccessful");
				test.log(LogStatus.FAIL, "Verification of Tooltip for Member Number was unsuccessful");
			}
		} catch (InterruptedException e) {
			CommonHelper.reportFailure("Verification of Tooltip for Member Number was unsuccessful");
			Assert.fail(e.getMessage());
			e.printStackTrace();
		}
	}

	public void verifyTooltipVATNum() {

		try {
			Thread.sleep(1000);
			CommonHelper.scrolltoview("vatTooltip_id");
			Thread.sleep(1000);
			CommonHelper.mHover("vatTooltip_id");
			Thread.sleep(1000);
			String vatTooltip = driver.findElement(By.id("vatTooltip")).getAttribute("data-content");
			if (vatTooltip.contains("The first two characters of this number")) {
				System.out.println("The tooltip message is: " + vatTooltip);
				test.log(LogStatus.PASS, "The tooltip message is: " + vatTooltip);
			} else {
				System.out.println("Verification of Tooltip for VAT Number was unsuccessful");
				test.log(LogStatus.FAIL, "Verification of Tooltip for VAT Number was unsuccessful");
			}
		} catch (InterruptedException e) {
			CommonHelper.reportFailure("Verification of Tooltip for VAT Number was unsuccessful");
			Assert.fail(e.getMessage());
			e.printStackTrace();
		}
	}

	public void verifyContactInfo() {

		try {
			Thread.sleep(1000);
			CommonHelper.scrolltoview("contactInfo_xpath");

			Thread.sleep(1000);
			String conInfo = driver.findElement(By.xpath("//*[@id='one']/div/div[3]")).getText();
			if (conInfo.contains("BSI Member")) {
				System.out.println("The text in contact info is: " + conInfo);
				test.log(LogStatus.PASS, "The text in contact info is: " + conInfo);
			} else {
				System.out.println("Verification of Contact Info was unsuccessful");
				test.log(LogStatus.FAIL, "Verification of Contact Info was unsuccessful");
			}
		} catch (InterruptedException e) {
			CommonHelper.reportFailure("Verification of Contact Info was unsuccessful");
			Assert.fail(e.getMessage());
			e.printStackTrace();
		}
	}

	public void loginThroughAlreadyRegistered() {

		try {
			Thread.sleep(5000);
			Log.info("Click Login Here");
			System.out.println("Click Login Here");
			test.log(LogStatus.INFO, "Click Login Here");
			// CommonHelper.clickByJS("loginHere_linktext");
			driver.findElement(By.linkText("Log in here")).click();
			// click("loginHere_linktext");

			System.out.println("Enter Email ID");
			Log.info("Enter Email ID");
			test.log(LogStatus.INFO, "Enter Email ID");
			Thread.sleep(5000);
			driver.findElement(By.id("bsi_email")).sendKeys(BsiConstants.getEnvDetails().get("username"));

			Thread.sleep(5000);
			System.out.println("Enter Password");
			Log.info("Enter Password");
			test.log(LogStatus.INFO, "Enter Password");
			driver.findElement(By.id("bsi_pass")).sendKeys(BsiConstants.getEnvDetails().get("password"));

			Thread.sleep(3000);
			System.out.println("Click on SignIn button");
			Log.info("Click on SignIn button");
			test.log(LogStatus.INFO, "Click on SignIn button");
			click("loginButton_xpath");

			boolean isEMyprofileVisible = CommonHelper.isElementVisible("myProfile_xpath");
			if (isEMyprofileVisible)
				test.log(LogStatus.PASS, "Login Successful");
			else
				CommonHelper.reportFailure("Login UnSuccessful");

		} catch (Exception e) {
			CommonHelper.reportFailure("Verify Login Error Message for Registered User was unsuccessful");
			Assert.fail(e.getMessage());
			e.printStackTrace();
		}
	}

	public void enterRegDetailsForAlreadyRegisteredUser() {

		try {
			Thread.sleep(1000);
			Log.info("Enter Email");
			System.out.println("Enter Email");
			test.log(LogStatus.INFO, "Enter Email");
			enterText("emaidIDReg_id", BsiConstants.getEnvDetails().get("mem_sec_username"));

			Log.info("Enter Password");
			System.out.println("Enter Password");
			test.log(LogStatus.INFO, "Enter Password");
			enterText("passwordReg_id", BsiConstants.getEnvDetails().get("mem_sec_password"));

			Log.info("Enter Confirm Password");
			System.out.println("Enter Confirm Password");
			test.log(LogStatus.INFO, "Enter Confirm Password");
			enterText("confirmPwdReg_id", BsiConstants.getEnvDetails().get("mem_sec_password"));

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

			Log.info("Enter Postcode");
			System.out.println("Enter Postcode");
			test.log(LogStatus.INFO, "Enter Postcode");
			enterText("postcode_id", "AA11AA");

			Thread.sleep(2000);
			Log.info("Click Find Address");
			System.out.println("Click Find Address");
			test.log(LogStatus.INFO, "Click Find Address");
			CommonHelper.clickByJS("findAddressReg_css");

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

	public void verifyErrorMsgForAlreadyRegisteredUser() {

		try {
			CommonHelper.scrolltoview("errorMsg_css");
			String errorMessage = driver.findElement(By.cssSelector("div[data-ui-id='message-error']")).getText();

			if (errorMessage.contains("There is already an account with this email address.")) {
				System.out.println("The error message is: " + errorMessage);
				test.log(LogStatus.INFO, "The error message is: " + errorMessage);
				test.log(LogStatus.PASS, "Registration Verification successful");
				System.out.println("Registration Verification successful");

			} else {
				System.out.println("Verification of Registration was unsuccessful");
				test.log(LogStatus.FAIL, "Verification of Registration was unsuccessful");
			}
		} catch (Exception e) {
			CommonHelper.reportFailure("Verify registration details for already registered user was unsuccessful");
			e.printStackTrace();
			Assert.fail(e.getMessage());
		}
	}

	public void clickContactUs() {

		try {

			test.log(LogStatus.INFO, "Click Contact Us on Home Page");
			Log.info("Click Contact Us on Home Page");
			System.out.println("Click Contact Us on Home Page");
			// CommonHelper.scrolltoview("contactUs_linkText");
			CommonHelper.elementToBeVisible("contactUs_linkText");
			CommonHelper.elementToBeClickable("contactUs_linkText");
			click("contactUs_linkText");
			Thread.sleep(2000);

		} catch (Exception e) {
			CommonHelper.reportFailure("Click on Home Page was unsuccessful");
			e.printStackTrace();
			Assert.fail(e.getMessage());
		}

	}

	public void enterContactUsDetails() {

		try {

			Thread.sleep(2000);
			ArrayList<String> tabs2 = new ArrayList<String>(driver.getWindowHandles());
			driver.switchTo().window(tabs2.get(1));
			driver.manage().window().maximize();
			System.out.println("switched to 2nd window");

			test.log(LogStatus.INFO, "Select What is your enquiry about");
			Log.info("Select What is your enquiry about");
			System.out.println("Select What is your enquiry about");
			selectDpdwnIndex("enquiryAbout_id", 3);

			test.log(LogStatus.INFO, "Select What can we help you with");
			Log.info("Select What can we help you with");
			System.out.println("Select What can we help you with");
			selectDpdwnIndex("helpWith_id", 5);

			test.log(LogStatus.INFO, "Enter First Name");
			Log.info("Enter First Name");
			System.out.println("Enter First Name");
			enterText("contactUsFirstName_id", "Harry");

			test.log(LogStatus.INFO, "Enter Last Name");
			Log.info("Enter Last Name");
			System.out.println("Enter Last Name");
			enterText("contactUsLastName_id", "Potter");

			test.log(LogStatus.INFO, "Enter Email Address");
			Log.info("Enter Email Address");
			System.out.println("Enter Email Address");
			enterText("contactUsEmail_id", "harry.potter@gmail.com");

			test.log(LogStatus.INFO, "Enter Company Name");
			Log.info("Enter Company Name");
			System.out.println("Enter Company Name");
			enterText("contactUsOrganisation_id", "Harry Potter and The World of Wizardry");

			test.log(LogStatus.INFO, "Enter Company Postcode");
			Log.info("Enter Company Postcode");
			System.out.println("Enter Company Postcode");
			enterText("contactUsPostCode_id", "65486456");

			test.log(LogStatus.INFO, "Click Submit");
			Log.info("Click Submit");
			System.out.println("Click Submit");
			click("conatctUsSubmit_css");
			Thread.sleep(2000);

		} catch (InterruptedException e) {
			CommonHelper.reportFailure("Enter Contact Us Details was unsuccessful");
			e.printStackTrace();
		}

	}

	public void verifyContactUsMessage() {

		try {
			test.log(LogStatus.INFO, "Verify Contact Us Message");
			Log.info("Verify Contact Us Message");
			System.out.println("Verify Contact Us Message");
			String contactSubmitTitle = driver.getTitle();
			String submissionMsg = driver.findElement(By.xpath("//*[@id='maincontent']/div[4]/div/div[2]/div/div/p[1]"))
					.getText();
			if (contactSubmitTitle.contains("Contact us") && submissionMsg.contains("Thank you for contacting us")) {
				test.log(LogStatus.INFO, "The Contact Us Message is: " + submissionMsg);
				System.out.println("The Contact Us Message is: " + submissionMsg);
				CommonHelper.takeScreenShot();
				test.log(LogStatus.PASS, "Verification of Contact Us Message was successful");

			} else {
				test.log(LogStatus.INFO, "The Contact Us Message is: " + submissionMsg);
				System.out.println("The Contact Us Message is: " + submissionMsg);
				CommonHelper.takeScreenShot();
				test.log(LogStatus.FAIL, "Verification of Contact Us Message was unsuccessful");
			}
			// ArrayList<String> tabs2 = new ArrayList<String>(driver.getWindowHandles());
			// driver.close();
		} catch (Exception e) {
			CommonHelper.reportFailure("Verification of Contact Us Message was unsuccessful");
			e.printStackTrace();
		}
	}

	public void verifyAffiliateProgramme() {

		try {
			test.log(LogStatus.INFO, "Click Affiliate Programme");
			Log.info("Click Affiliate Programme");
			System.out.println("Click Affiliate Programme");
			CommonHelper.scrolltoview("affiliateProgramme_linkText");
			click("affiliateProgramme_linkText");

			Thread.sleep(1000);
			System.out.println("Switch to 2nd tab");
			ArrayList<String> tabs2 = new ArrayList<String>(driver.getWindowHandles());
			Thread.sleep(1000);
			driver.switchTo().window(tabs2.get(1));
			driver.manage().window().maximize();
			Thread.sleep(1000);
			System.out.println("Switched to 2nd tab");

			String text = driver.findElement(By.cssSelector("span[data-ui-id='page-title-wrapper']")).getText();
			if (text.contains("Affiliate program")) {
				System.out.println("The text contains: " + text);
				test.log(LogStatus.PASS, "The text contains: " + text);
				System.out.println("Verification of Affiliate Programme was successful");
				test.log(LogStatus.PASS, "Verification of Affiliate Programme was successful");
			} else {
				System.out.println("Verification of Affiliate Programme was unsuccessful");
				test.log(LogStatus.FAIL, "Verification of Affiliate Programme was unsuccessful");
			}

			driver.close();
			driver.switchTo().window(tabs2.get(0));

		} catch (InterruptedException e) {
			CommonHelper.reportFailure("Verify Affiliate Programme was unsuccessful");
			e.printStackTrace();
		}
	}

	public void verifyDistributorProgramme() {

		try {
			test.log(LogStatus.INFO, "Click Distributor Programme");
			Log.info("Click Distributor Programme");
			System.out.println("Click Distributor Programme");
			CommonHelper.scrolltoview("distributorProgramme_linkText");
			click("distributorProgramme_linkText");

			Thread.sleep(1000);
			System.out.println("Switch to 2nd tab");
			ArrayList<String> tabs2 = new ArrayList<String>(driver.getWindowHandles());
			Thread.sleep(1000);
			driver.switchTo().window(tabs2.get(1));
			driver.manage().window().maximize();
			Thread.sleep(1000);
			System.out.println("Switched to 2nd tab");

			String text = driver.findElement(By.cssSelector("span[data-ui-id='page-title-wrapper']")).getText();
			if (text.contains("Distributor Network")) {
				System.out.println("The text contains: " + text);
				test.log(LogStatus.PASS, "The text contains: " + text);
				System.out.println("Verification of Distributor Programme was successful");
				test.log(LogStatus.PASS, "Verification of Distributor Programme was successful");
			} else {
				System.out.println("Verification of Distributor Programme was unsuccessful");
				test.log(LogStatus.FAIL, "Verification of Distributor Programme was unsuccessful");
			}

			driver.close();
			driver.switchTo().window(tabs2.get(0));

		} catch (InterruptedException e) {
			CommonHelper.reportFailure("Verify Distributor Programme was unsuccessful");
			e.printStackTrace();
		}
	}

	public void verifyLicensing() {

		try {
			test.log(LogStatus.INFO, "Click Licensing");
			Log.info("Click Licensing");
			System.out.println("Click Licensing");
			CommonHelper.scrolltoview("licensing_linkText");
			click("licensing_linkText");

			Thread.sleep(1000);
			System.out.println("Switch to 2nd tab");
			ArrayList<String> tabs2 = new ArrayList<String>(driver.getWindowHandles());
			Thread.sleep(1000);
			driver.switchTo().window(tabs2.get(1));
			Thread.sleep(1000);
			driver.manage().window().maximize();
			Thread.sleep(1000);
			System.out.println("Switched to 2nd tab");

			String text = driver.findElement(By.cssSelector("span[data-ui-id='page-title-wrapper']")).getText();
			if (text.contains("Licensing")) {
				System.out.println("The text contains: " + text);
				test.log(LogStatus.PASS, "The text contains: " + text);
				System.out.println("Verification of Licensing was successful");
				test.log(LogStatus.PASS, "Verification of Licensing was successful");
			} else {
				System.out.println("Verification of Licensing was unsuccessful");
				test.log(LogStatus.FAIL, "Verification of Licensing was unsuccessful");
			}

			driver.close();
			driver.switchTo().window(tabs2.get(0));

		} catch (InterruptedException e) {
			CommonHelper.reportFailure("Verify Licensing was unsuccessful");
			e.printStackTrace();
		}
	}

	public void verifyNewsletter() {

		try {
			test.log(LogStatus.INFO, "Click Newsletter");
			Log.info("Click Newsletter");
			System.out.println("Click Newsletter");
			CommonHelper.scrolltoview("newsletter_linkText");
			click("newsletter_linkText");

			Thread.sleep(1000);
			System.out.println("Switch to 2nd tab");
			ArrayList<String> tabs2 = new ArrayList<String>(driver.getWindowHandles());
			Thread.sleep(1000);
			driver.switchTo().window(tabs2.get(1));
			Thread.sleep(1000);
			driver.manage().window().maximize();
			Thread.sleep(1000);
			System.out.println("Switched to 2nd tab");

			String text = driver.findElement(By.cssSelector("span[data-ui-id='page-title-wrapper']")).getText();
			if (text.contains("Newsletter")) {
				System.out.println("The text contains: " + text);
				test.log(LogStatus.PASS, "The text contains: " + text);
				System.out.println("Verification of Newsletter was successful");
				test.log(LogStatus.PASS, "Verification of Newsletter was successful");
			} else {
				System.out.println("Verification of Newsletter was unsuccessful");
				test.log(LogStatus.FAIL, "Verification of Newsletter was unsuccessful");
			}

			driver.close();
			driver.switchTo().window(tabs2.get(0));

		} catch (InterruptedException e) {
			CommonHelper.reportFailure("Verify Newsletter was unsuccessful");
			e.printStackTrace();
		}
	}

	public void verifyPAS() {

		try {
			test.log(LogStatus.INFO, "Click PAS");
			Log.info("Click PAS");
			System.out.println("Click PAS");
			CommonHelper.scrolltoview("PAS_linkText");
			click("PAS_linkText");

			/*
			 * Thread.sleep(1000); System.out.println("Switch to 2nd tab");
			 * ArrayList<String> tabs2 = new ArrayList<String>(driver.getWindowHandles());
			 * Thread.sleep(1000); driver.switchTo().window(tabs2.get(1));
			 * Thread.sleep(1000); driver.manage().window().maximize(); Thread.sleep(1000);
			 * System.out.println("Switched to 2nd tab");
			 */

			String text = driver.findElement(By.cssSelector("span[data-ui-id='page-title-wrapper']")).getText();
			if (text.contains("PAS")) {
				System.out.println("The text contains: " + text);
				test.log(LogStatus.PASS, "The text contains: " + text);
				System.out.println("Verification of PAS was successful");
				test.log(LogStatus.PASS, "Verification of PAS was successful");
			} else {
				System.out.println("Verification of PAS was unsuccessful");
				test.log(LogStatus.FAIL, "Verification of PAS was unsuccessful");
			}

			/*
			 * driver.close(); driver.switchTo().window(tabs2.get(0));
			 */

		} catch (Exception e) {
			CommonHelper.reportFailure("Verify PAS was unsuccessful");
			e.printStackTrace();
		}
	}

	public void verifyWorldwideStandards() {

		try {
			test.log(LogStatus.INFO, "Click Worldwide Standards");
			Log.info("Click Worldwide Standards");
			System.out.println("Click Worldwide Standards");
			CommonHelper.scrolltoview("worldwideStandards_linkText");
			click("worldwideStandards_linkText");

			/*
			 * Thread.sleep(1000); System.out.println("Switch to 2nd tab");
			 * ArrayList<String> tabs2 = new ArrayList<String>(driver.getWindowHandles());
			 * Thread.sleep(1000); driver.switchTo().window(tabs2.get(1));
			 * Thread.sleep(1000); driver.manage().window().maximize(); Thread.sleep(1000);
			 * System.out.println("Switched to 2nd tab");
			 */

			String text = driver.findElement(By.cssSelector("span[data-ui-id='page-title-wrapper']")).getText();
			if (text.contains("Worldwide Standards")) {
				System.out.println("The text contains: " + text);
				test.log(LogStatus.PASS, "The text contains: " + text);
				System.out.println("Verification of Worldwide Standards was successful");
				test.log(LogStatus.PASS, "Verification of Worldwide Standards was successful");
			} else {
				System.out.println("Verification of Worldwide Standards was unsuccessful");
				test.log(LogStatus.FAIL, "Verification of Worldwide Standards was unsuccessful");
			}

			/*
			 * driver.close(); driver.switchTo().window(tabs2.get(0));
			 */

		} catch (Exception e) {
			CommonHelper.reportFailure("Verify Worldwide Standards was unsuccessful");
			e.printStackTrace();
		}
	}

	public void verifyBimLevel2() {

		try {

			test.log(LogStatus.INFO, "Click BIM Level 2");
			Log.info("Click BIM Level 2");
			System.out.println("Click BIM Level 2");
			CommonHelper.scrolltoview("bimLevel2_linkText");
			click("bimLevel2_linkText");

			Thread.sleep(1000);
			System.out.println("Switch to 2nd tab");
			ArrayList<String> tabs2 = new ArrayList<String>(driver.getWindowHandles());
			Thread.sleep(1000);
			driver.switchTo().window(tabs2.get(1));
			Thread.sleep(1000);
			driver.manage().window().maximize();
			Thread.sleep(1000);
			System.out.println("Switched to 2nd tab");

			String text = driver.findElement(By.cssSelector("span[data-ui-id='page-title-wrapper']")).getText();
			if (text.contains("BIM Level 2")) {
				System.out.println("The text contains: " + text);
				test.log(LogStatus.PASS, "The text contains: " + text);
				System.out.println("Verification of BIM Level 2 was successful");
				test.log(LogStatus.PASS, "Verification of BIM Level 2 was successful");
			} else {
				System.out.println("Verification of BIM Level 2 was unsuccessful");
				test.log(LogStatus.FAIL, "Verification of BIM Level 2 was unsuccessful");
			}

			driver.close();
			driver.switchTo().window(tabs2.get(0));

		} catch (InterruptedException e) {
			CommonHelper.reportFailure("Verify BIM Level 2 was unsuccessful");
			e.printStackTrace();
		}

	}

	public void verifyBSIGroupWebsite() {

		try {

			test.log(LogStatus.INFO, "Click BSI Group website");
			Log.info("Click BSI Group website");
			System.out.println("Click BSI Group website");
			CommonHelper.scrolltoview("bsiGroupWebsite_linkText");
			click("bsiGroupWebsite_linkText");

			Thread.sleep(1000);
			System.out.println("Switch to 2nd tab");
			ArrayList<String> tabs2 = new ArrayList<String>(driver.getWindowHandles());
			Thread.sleep(1000);
			driver.switchTo().window(tabs2.get(1));
			Thread.sleep(1000);
			driver.manage().window().maximize();
			Thread.sleep(1000);
			System.out.println("Switched to 2nd tab");

			String text = driver.findElement(By.cssSelector("span[data-ui-id='page-title-wrapper']")).getText();
			if (text.contains("BSI Group website")) {
				System.out.println("The text contains: " + text);
				test.log(LogStatus.PASS, "The text contains: " + text);
				System.out.println("Verification of BSI Group website was successful");
				test.log(LogStatus.PASS, "Verification of BSI Group website was successful");
			} else {
				System.out.println("Verification of BSI Group website was unsuccessful");
				test.log(LogStatus.FAIL, "Verification of BSI Group website was unsuccessful");
			}

			driver.close();
			driver.switchTo().window(tabs2.get(0));

		} catch (InterruptedException e) {
			CommonHelper.reportFailure("Verify BSI Group website was unsuccessful");
			e.printStackTrace();
		}
	}

	public void verifyBritishStandardsOnline() {

		try {

			test.log(LogStatus.INFO, "Click BSOL: British Standards Online");
			Log.info("Click BSOL: British Standards Online");
			System.out.println("Click BSOL: British Standards Online");
			CommonHelper.scrolltoview("britishStandardsOnline_linkText");
			click("britishStandardsOnline_linkText");

			Thread.sleep(1000);
			System.out.println("Switch to 2nd tab");
			ArrayList<String> tabs2 = new ArrayList<String>(driver.getWindowHandles());
			Thread.sleep(1000);
			driver.switchTo().window(tabs2.get(1));
			Thread.sleep(1000);
			driver.manage().window().maximize();
			Thread.sleep(1000);
			System.out.println("Switched to 2nd tab");

			String text = driver.findElement(By.cssSelector("span[data-ui-id='page-title-wrapper']")).getText();
			if (text.contains("BSOL: British Standards Online")) {
				System.out.println("The text contains: " + text);
				test.log(LogStatus.PASS, "The text contains: " + text);
				System.out.println("Verification of BSOL: British Standards Online was successful");
				test.log(LogStatus.PASS, "Verification of BSOL: British Standards Online was successful");
			} else {
				System.out.println("Verification of BSOL: British Standards Online was unsuccessful");
				test.log(LogStatus.FAIL, "Verification of BSOL: British Standards Online was unsuccessful");
			}

			driver.close();
			driver.switchTo().window(tabs2.get(0));

		} catch (InterruptedException e) {
			CommonHelper.reportFailure("Verify BSOL: British Standards Online was unsuccessful");
			e.printStackTrace();
		}
	}

	public void verifyComplianceNavigatorMedicalDevices() {

		try {

			test.log(LogStatus.INFO, "Click Compliance Navigator for Medical Devices");
			Log.info("Click Compliance Navigator for Medical Devices");
			System.out.println("Click Compliance Navigator for Medical Devices");
			CommonHelper.scrolltoview("complianceNavigatorForMedicalDevices_linkText");
			click("complianceNavigatorForMedicalDevices_linkText");

			Thread.sleep(1000);
			System.out.println("Switch to 2nd tab");
			ArrayList<String> tabs2 = new ArrayList<String>(driver.getWindowHandles());
			Thread.sleep(1000);
			driver.switchTo().window(tabs2.get(1));
			Thread.sleep(1000);
			driver.manage().window().maximize();
			Thread.sleep(1000);
			System.out.println("Switched to 2nd tab successfully");

			String text = driver.findElement(By.cssSelector("span[data-ui-id='page-title-wrapper']")).getText();
			if (text.contains("Compliance Navigator for Medical Devices")) {
				System.out.println("The text contains: " + text);
				test.log(LogStatus.PASS, "The text contains: " + text);
				System.out.println("Verification of Compliance Navigator for Medical Devices was successful");
				test.log(LogStatus.PASS, "Verification of Compliance Navigator for Medical Devices was successful");
			} else {
				System.out.println("Verification of Compliance Navigator for Medical Devices was unsuccessful");
				test.log(LogStatus.FAIL, "Verification of Compliance Navigator for Medical Devices was unsuccessful");
			}

			driver.close();
			driver.switchTo().window(tabs2.get(0));

		} catch (InterruptedException e) {
			CommonHelper.reportFailure("Verify Compliance Navigator for Medical Devices was unsuccessful");
			e.printStackTrace();
		}

	}

	public void verifyECommittees() {

		try {

			test.log(LogStatus.INFO, "Click E-committees");
			Log.info("Click E-committees");
			System.out.println("Click E-committees");
			CommonHelper.scrolltoview("eCommittees_linkText");
			click("eCommittees_linkText");

			Thread.sleep(1000);
			System.out.println("Switch to 2nd tab");
			ArrayList<String> tabs2 = new ArrayList<String>(driver.getWindowHandles());
			Thread.sleep(1000);
			driver.switchTo().window(tabs2.get(1));
			Thread.sleep(1000);
			driver.manage().window().maximize();
			Thread.sleep(1000);
			System.out.println("Switched to 2nd tab successfully");

			String text = driver.findElement(By.cssSelector("span[data-ui-id='page-title-wrapper']")).getText();
			if (text.contains("E-committees")) {
				System.out.println("The text contains: " + text);
				test.log(LogStatus.PASS, "The text contains: " + text);
				System.out.println("Verification of E-committees was successful");
				test.log(LogStatus.PASS, "Verification of E-committees was successful");
			} else {
				System.out.println("Verification of E-committees was unsuccessful");
				test.log(LogStatus.FAIL, "Verification of E-committees was unsuccessful");
			}

			driver.close();
			driver.switchTo().window(tabs2.get(0));

		} catch (InterruptedException e) {
			CommonHelper.reportFailure("Verify E-committees was unsuccessful");
			e.printStackTrace();
		}

	}

	public void verifyEurocodesPlus() {

		try {

			test.log(LogStatus.INFO, "Click Eurocodes Plus");
			Log.info("Click Eurocodes Plus");
			System.out.println("Click Eurocodes Plus");
			CommonHelper.scrolltoview("eurocodesPlus_linkText");
			click("eurocodesPlus_linkText");

			Thread.sleep(1000);
			System.out.println("Switch to 2nd tab");
			ArrayList<String> tabs2 = new ArrayList<String>(driver.getWindowHandles());
			Thread.sleep(1000);
			driver.switchTo().window(tabs2.get(1));
			Thread.sleep(1000);
			driver.manage().window().maximize();
			Thread.sleep(1000);
			System.out.println("Switched to 2nd tab successfully");

			String text = driver.findElement(By.cssSelector("span[data-ui-id='page-title-wrapper']")).getText();
			if (text.contains("Eurocodes Plus")) {
				System.out.println("The text contains: " + text);
				test.log(LogStatus.PASS, "The text contains: " + text);
				System.out.println("Verification of Eurocodes Plus was successful");
				test.log(LogStatus.PASS, "Verification of Eurocodes Plus was successful");
			} else {
				System.out.println("Verification of Eurocodes Plus was unsuccessful");
				test.log(LogStatus.FAIL, "Verification of Eurocodes Plus was unsuccessful");
			}

			driver.close();
			driver.switchTo().window(tabs2.get(0));

		} catch (InterruptedException e) {
			CommonHelper.reportFailure("Verify Eurocodes Plus was unsuccessful");
			e.printStackTrace();
		}

	}

	public void verifyMemberPortal() {

		try {

			test.log(LogStatus.INFO, "Click Member Portal");
			Log.info("Click Member Portal");
			System.out.println("Click Member Portal");
			CommonHelper.scrolltoview("memberPortal_linkText");
			click("memberPortal_linkText");

			Thread.sleep(1000);
			System.out.println("Switch to 2nd tab");
			ArrayList<String> tabs2 = new ArrayList<String>(driver.getWindowHandles());
			Thread.sleep(1000);
			driver.switchTo().window(tabs2.get(1));
			Thread.sleep(1000);
			driver.manage().window().maximize();
			Thread.sleep(1000);
			System.out.println("Switched to 2nd tab successfully");

			String text = driver.findElement(By.cssSelector("span[data-ui-id='page-title-wrapper']")).getText();
			if (text.contains("Member Portal")) {
				System.out.println("The text contains: " + text);
				test.log(LogStatus.PASS, "The text contains: " + text);
				System.out.println("Verification of Member Portalwas successful");
				test.log(LogStatus.PASS, "Verification of Member Portal was successful");
			} else {
				System.out.println("Verification of Member Portal was unsuccessful");
				test.log(LogStatus.FAIL, "Verification of Member Portal was unsuccessful");
			}

			driver.close();
			driver.switchTo().window(tabs2.get(0));

		} catch (InterruptedException e) {
			CommonHelper.reportFailure("Verify Member Portal was unsuccessful");
			e.printStackTrace();
		}
	}

	public void verifyPerinorm() {

		try {

			test.log(LogStatus.INFO, "Click Perinorm");
			Log.info("Click Perinorm");
			System.out.println("Click Perinorm");
			CommonHelper.scrolltoview("perinorm_linkText");
			click("perinorm_linkText");

			Thread.sleep(1000);
			System.out.println("Switch to 2nd tab");
			ArrayList<String> tabs2 = new ArrayList<String>(driver.getWindowHandles());
			Thread.sleep(1000);
			driver.switchTo().window(tabs2.get(1));
			Thread.sleep(1000);
			driver.manage().window().maximize();
			Thread.sleep(1000);
			System.out.println("Switched to 2nd tab successfully");

			String text = driver.findElement(By.cssSelector("span[data-ui-id='page-title-wrapper']")).getText();
			if (text.contains("Perinorm")) {
				System.out.println("The text contains: " + text);
				test.log(LogStatus.PASS, "The text contains: " + text);
				System.out.println("Verification of Perinorm was successful");
				test.log(LogStatus.PASS, "Verification of Perinorm was successful");
			} else {
				System.out.println("Verification of Perinorm was unsuccessful");
				test.log(LogStatus.FAIL, "Verification of Perinorm was unsuccessful");
			}

			driver.close();
			driver.switchTo().window(tabs2.get(0));

		} catch (InterruptedException e) {
			CommonHelper.reportFailure("Verify Perinorm was unsuccessful");
			e.printStackTrace();
		}
	}

	public void verifyStandardsDevelopment() {

		try {

			test.log(LogStatus.INFO, "Click Standards Development");
			Log.info("Click Standards Development");
			System.out.println("Click Standards Development");
			CommonHelper.scrolltoview("standardsDevelopment_linkText");
			click("standardsDevelopment_linkText");

			Thread.sleep(1000);
			System.out.println("Switch to 2nd tab");
			ArrayList<String> tabs2 = new ArrayList<String>(driver.getWindowHandles());
			Thread.sleep(1000);
			driver.switchTo().window(tabs2.get(1));
			Thread.sleep(1000);
			driver.manage().window().maximize();
			Thread.sleep(1000);
			System.out.println("Switched to 2nd tab successfully");

			String text = driver.findElement(By.cssSelector("span[data-ui-id='page-title-wrapper']")).getText();
			if (text.contains("Standards Development")) {
				System.out.println("The text contains: " + text);
				test.log(LogStatus.PASS, "The text contains: " + text);
				System.out.println("Verification of Standards Development was successful");
				test.log(LogStatus.PASS, "Verification of Standards Development was successful");
			} else {
				System.out.println("Verification of Standards Development was unsuccessful");
				test.log(LogStatus.FAIL, "Verification of Standards Development was unsuccessful");
			}

			driver.close();
			driver.switchTo().window(tabs2.get(0));

		} catch (InterruptedException e) {
			CommonHelper.reportFailure("Verify Standards Development was unsuccessful");
			e.printStackTrace();
		}

	}

	public void verifyForgotPassword() {

		try {
			
			Thread.sleep(3000);
			System.out.println("Click on login link");
			Log.info("Click on login link");
			test.log(LogStatus.INFO, "Click on login link");
			CommonHelper.elementToBeVisible("loginLink_xpath");
			CommonHelper.elementToBeClickable("loginLink_xpath");
			click("loginLink_xpath");
			Thread.sleep(2000);
			
			test.log(LogStatus.INFO, "Click Forgot Password");
			Log.info("Click Forgot Password");
			System.out.println("Click Forgot Password");
			click("forgotPwd_linkText");

			test.log(LogStatus.INFO, "Enter Email ID");
			Log.info("Enter Email ID");
			System.out.println("Enter Email ID");
			enterText("forgotPwdEmail_id", "subhrateja.satapathy@tcs.com");

			test.log(LogStatus.INFO, "Click Reset Password");
			Log.info("Click Reset Password");
			System.out.println("Click Reset Password");
			click("resetPwd_xpath");

			String successMsg = driver.findElement(By.cssSelector("div[data-ui-id='message-success']")).getText();
			if (successMsg.contains("you will receive an email with a link to reset your password")) {
				System.out.println("The success message is: " + successMsg);
				test.log(LogStatus.INFO, "The success message is: " + successMsg);
				System.out.println("Verification of Forgot Password was successful");
				test.log(LogStatus.PASS, "Verification of Forgot Password was successful");
			} else {
				System.out.println("Verification of Forgot Password was unsuccessful");
				test.log(LogStatus.FAIL, "Verification of Forgot Password was unsuccessful");
				CommonHelper.takeScreenShot();
			}
		} catch (Exception e) {
			CommonHelper.reportFailure("Verification of Forgot Password was unsuccessful");
			e.printStackTrace();
		}
	}

}
