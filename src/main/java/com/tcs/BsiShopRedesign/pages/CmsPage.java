package com.tcs.BsiShopRedesign.pages;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import com.relevantcodes.extentreports.LogStatus;
import com.tcs.BsiShopRedesign.utilities.CommonHelper;
import com.tcs.BsiShopRedesign.utilities.Page;

public class CmsPage extends Page {

	public CmsPage(WebDriver driver) throws Exception {
		super(driver);
	}

	public void searchCustomerDetails() {
		boolean remove = false;

		try {
			System.out.println("Click Customer Menu");
			Log.info("Click Customer Menu");
			test.log(LogStatus.INFO, "Click Customer Menu");
			click("magentoCustomer_xpath");

			System.out.println("Click All Customer Submenu");
			Log.info("Click All Customer Submenu");
			test.log(LogStatus.INFO, "Click All Customer Submenu");
			click("magentoAllCustomer_xpath");

			try {
				remove = CommonHelper.isElementVisible("removeKeyword_xpath");
			} catch (Exception e) {
				e.printStackTrace();
			}
			if (remove) {
				System.out.println("Click Remove Keyword");
				Log.info("Click Remove Keyword");
				test.log(LogStatus.INFO, "Click Remove Keyword");
				click("removeKeyword_xpath");
			}

			Thread.sleep(2000);
			System.out.println("Enter keyword for search");
			Log.info("Enter keyword for search");
			test.log(LogStatus.INFO, "Enter keyword for search");
			clearText("searchKeywordText_id");
			Thread.sleep(2000);
			enterText("searchKeywordText_id", "joshita");

			System.out.println("Click on Search");
			Log.info("Click on Search");
			test.log(LogStatus.INFO, "Click on Search");
			click("searchDetails_xpath");
			Thread.sleep(5000);

		} catch (Exception e) {
			CommonHelper.reportFailure("Search Customer Details was Unsuccessful");
			e.printStackTrace();
			Assert.fail(e.getMessage());
		}
	}

	public void editCustomerDetails() {

		try {
			System.out.println("Click on Edit link");
			Log.info("Click on Edit link");
			test.log(LogStatus.INFO, "Click on Edit link");
			CommonHelper.elementToBeVisible("editCustomerDetials_xpath");
			CommonHelper.elementToBeClickable("editCustomerDetials_xpath");
			click("editCustomerDetials_xpath");
			Thread.sleep(5000);
			CommonHelper.takeScreenShot();

		} catch (Exception e) {
			CommonHelper.reportFailure("Edit Customer Details was Unsuccessful");
			e.printStackTrace();
			Assert.fail(e.getMessage());
		}
	}

	public void verifyCustomerViewDetails() {
		try {
			System.out.println("Verify Customer Personal Information");
			Log.info("Verify Customer Personal Information");
			test.log(LogStatus.INFO, "Verify Customer Personal Information");
			String personalInfo = driver.findElement(By.cssSelector("table[class='admin__table-secondary']")).getText();
			System.out.println("Customer Personal Inforamtion is: " + personalInfo);
			test.log(LogStatus.INFO, "Customer Personal Inforamtion is: " + personalInfo);
			test.log(LogStatus.PASS, "Verify Customer Personal Information was successful");

			System.out.println("Verify Customer Billing Address");
			Log.info("Verify Customer Billing Address");
			test.log(LogStatus.INFO, "Verify Customer Billing Address");
			String billingAddress = driver
					.findElement(By.xpath("//*[@id='container']/div/div/div[2]/div[2]/div/div[2]/address")).getText();
			System.out.println("Customer Billing Address is: " + billingAddress);
			test.log(LogStatus.INFO, "Customer Billing Address is: " + billingAddress);
			test.log(LogStatus.PASS, "Verify Customer Billing Address was successful");

		} catch (Exception e) {
			e.printStackTrace();
			CommonHelper.reportFailure("Verification of Customer View Details was Unsuccessful");
		}

	}

	public void verifyAccountInfo() {

		try {
			System.out.println("Verify Customer Account Information");
			Log.info("Verify Customer Account Information");
			test.log(LogStatus.INFO, "Verify Customer Account Information");
			click("accountInfo_xpath");

			String group = driver.findElement(By.cssSelector("select[name='customer[group_id]']")).getText();
			System.out.println("The Group is: " + group);
			test.log(LogStatus.INFO, "The Group is: " + group);

			String firstName = driver.findElement(By.cssSelector("input[name='customer[firstname]']"))
					.getAttribute("value");
			System.out.println("The First Name is: " + firstName);
			test.log(LogStatus.INFO, "The First Name is: " + firstName);

			String lastName = driver.findElement(By.cssSelector("input[name='customer[lastname]']"))
					.getAttribute("value");
			System.out.println("The Last Name is: " + lastName);
			test.log(LogStatus.INFO, "The Last Name is: " + lastName);

			String email = driver.findElement(By.cssSelector("input[name='customer[email]']")).getAttribute("value");
			System.out.println("The Email id is: " + email);
			test.log(LogStatus.INFO, "The Email id is: " + email);

			String memberID = driver.findElement(By.cssSelector("input[name='customer[membership_number]']"))
					.getAttribute("value");
			System.out.println("The Membership Number is: " + memberID);
			test.log(LogStatus.INFO, "The Membership Number is: " + memberID);

			String expiryDate = driver.findElement(By.cssSelector("input[name='customer[membership_expiry]']"))
					.getAttribute("value");
			System.out.println("The Membership Expiry Date is: " + expiryDate);
			test.log(LogStatus.INFO, "The Membership Expiry Date is: " + expiryDate);

			String memberStatus = driver.findElement(By.cssSelector("input[name='customer[membership_status]']"))
					.getAttribute("value");
			System.out.println("The Membership Status is: " + memberStatus);
			test.log(LogStatus.INFO, "The Membership Status is: " + memberStatus);

			String storeView = driver.findElement(By.cssSelector("select[name='customer[sendemail_store_id]']"))
					.getText();
			System.out.println("The Store View is: " + storeView);
			test.log(LogStatus.INFO, "The Store View is: " + storeView);

			String membershipStartDate = driver.findElement(By.cssSelector("input[name='customer[membership_start]']"))
					.getAttribute("value");
			System.out.println("The Membership Start Date is: " + membershipStartDate);
			test.log(LogStatus.INFO, "The Membership Start Date is: " + membershipStartDate);
			test.log(LogStatus.PASS, "Verification of Account Information was successful");

		} catch (Exception e) {
			CommonHelper.reportFailure("Verification of Account Information was unsuccessful");
			e.printStackTrace();
		}

	}

	public void verifyAddresses() {

		try {
			System.out.println("Click Addresses");
			test.log(LogStatus.INFO, "Click Addresses");
			click("addresses_xpath");

			Thread.sleep(2000);
			String billlingAddress = driver
					.findElement(
							By.xpath("//*[@id='container']/div/div/div[2]/div[2]/div/div[2]/fieldset/div/ul/li[1]"))
					.getText();
			System.out.println("The Billing Address is: " + billlingAddress);
			test.log(LogStatus.INFO, "The Billing Address is: " + billlingAddress);

			String shippingAddress = driver
					.findElement(
							By.xpath("//*[@id='container']/div/div/div[2]/div[2]/div/div[2]/fieldset/div/ul/li[2]"))
					.getText();
			System.out.println("The Shipping Address is: " + shippingAddress);
			test.log(LogStatus.INFO, "The Shipping Address is: " + shippingAddress);
			test.log(LogStatus.PASS, "Verification of Addresses was successful");

		} catch (Exception e) {
			CommonHelper.reportFailure("Verification of Customer Addresses was unsuccessful");
			e.printStackTrace();
		}
	}

	public void verifyOrders() {

		try {
			System.out.println("Click Orders");
			test.log(LogStatus.INFO, "Click Orders");
			click("orders_xpath");

			String orderID = driver.findElement(By.xpath("//*[@id='customer_orders_grid_table']/tbody/tr[1]/td[1]"))
					.getText();
			System.out.println("The Order ID is: " + orderID);
			test.log(LogStatus.INFO, "The Order ID is: " + orderID);

			String purchaseDate = driver
					.findElement(By.xpath("//*[@id='customer_orders_grid_table']/tbody/tr[1]/td[2]")).getText();
			System.out.println("The Purchase Date is: " + purchaseDate);
			test.log(LogStatus.INFO, "The Purchase Date is: " + purchaseDate);

			String orderTotal = driver.findElement(By.xpath("//*[@id='customer_orders_grid_table']/tbody/tr[1]/td[5]"))
					.getText();
			System.out.println("The Order Total is: " + orderTotal);
			test.log(LogStatus.INFO, "The Order Total is: " + orderTotal);
			test.log(LogStatus.PASS, "Verification of Order Details was successful");

		} catch (Exception e) {
			CommonHelper.reportFailure("Verification of Order Details was unsuccessful");
			e.printStackTrace();
		}
	}

	public void verifyResetPwd() {

		try {
			System.out.println("Click Reset Password");
			test.log(LogStatus.INFO, "Click Reset Password");
			click("cmsResetPassword_id");

			System.out.println("Verify Success Message");
			test.log(LogStatus.INFO, "Verify Success Message");
			String successMsg = driver.findElement(By.cssSelector("div[class='message message-success success']"))
					.getText();
			if (successMsg.contains("The customer will receive an email with a link to reset password.")) {
				System.out.println("Verification of Success Message was successful");
				test.log(LogStatus.INFO, "Verification of Success Message was successful");
				test.log(LogStatus.PASS, "The message is: " + successMsg);
				CommonHelper.takeScreenShot();
			} else {
				System.out.println("Verification of Success Message was unsuccessful");
				test.log(LogStatus.INFO, "Verification of Success Message was unsuccessful");
				test.log(LogStatus.FAIL, "The message is: " + successMsg);
				CommonHelper.takeScreenShot();
			}
		} catch (Exception e) {
			CommonHelper.reportFailure("Verification of Success Message was unsuccessful");
			e.printStackTrace();
		}

	}

	public void blankSearchCustomerDetails() {
		boolean remove = false;

		try {
			System.out.println("Click Customer Menu");
			Log.info("Click Customer Menu");
			test.log(LogStatus.INFO, "Click Customer Menu");
			click("magentoCustomer_xpath");

			System.out.println("Click All Customer Submenu");
			Log.info("Click All Customer Submenu");
			test.log(LogStatus.INFO, "Click All Customer Submenu");
			click("magentoAllCustomer_xpath");

			try {
				remove = CommonHelper.isElementVisible("removeKeyword_xpath");
			} catch (Exception e) {
				e.printStackTrace();
			}
			if (remove) {
				System.out.println("Click Remove Keyword");
				Log.info("Click Remove Keyword");
				test.log(LogStatus.INFO, "Click Remove Keyword");
				click("removeKeyword_xpath");
			}
			/*
			 * Thread.sleep(2000); System.out.println("Enter keyword for search");
			 * Log.info("Enter keyword for search"); test.log(LogStatus.INFO,
			 * "Enter keyword for search"); clearText("searchKeywordText_id");
			 * Thread.sleep(2000); enterText("searchKeywordText_id", "joshita");
			 */

			System.out.println("Click on Search");
			Log.info("Click on Search");
			test.log(LogStatus.INFO, "Click on Search");
			click("searchDetails_xpath");
			Thread.sleep(5000);

		} catch (Exception e) {
			CommonHelper.reportFailure("Search Customer Details was Unsuccessful");
			e.printStackTrace();
			Assert.fail(e.getMessage());
		}
	}

	public void clickMarketing() {

		try {
			System.out.println("Click Marketing Menu");
			Log.info("Click on Marketing Menu");
			test.log(LogStatus.INFO, "Click on Marketing Menu");
			click("marketingMenu_xpath");

			System.out.println("Click Cart Price Rules submenu");
			Log.info("Click Cart Price Rules Submenu");
			test.log(LogStatus.INFO, "Click Cart Price Rules submenu");
			click("cartPriceRule_linkText");

		} catch (Exception e) {
			CommonHelper.reportFailure("Click Add New Rule was unsucessful");
			e.printStackTrace();
		}
	}

	public void clickAddNewRule() throws InterruptedException {

		System.out.println("Click Add New Rule");
		Log.info("Click  Add New Rule");
		test.log(LogStatus.INFO, "Click  Add New Rule");
		click("addNewRule_css");
		Thread.sleep(2000);
	}

	public String createPromoCodeDetails() {
		String ruleName = null;

		try {

			System.out.println("Enter Rule Name");
			Log.info("Enter Rule Name");
			test.log(LogStatus.INFO, "Enter Rule Name");
			CommonHelper.elementToBeVisible("ruleName_css");
			ruleName = RandomStringUtils.randomAlphanumeric(5) + RandomStringUtils.random(5, "@!#$%")
					+ RandomStringUtils.randomAlphabetic(3);
			System.out.println("The rule Name is: " + ruleName);
			test.log(LogStatus.INFO, "The rule Name is: " + ruleName);
			clearText("ruleName_css");
			enterText("ruleName_css", ruleName);
			Thread.sleep(2000);

			// Thread.sleep(2000);
			System.out.println("Select Website");
			Log.info("Select Website");
			test.log(LogStatus.INFO, "Select Website");
			// Thread.sleep(2000);
			click("mainWebsite_css");
			String website = CommonHelper.element("mainWebsite_css").getAttribute("data-title");
			System.out.println("The Website is: " + website);
			test.log(LogStatus.INFO, "The Website is: " + website);
			// Thread.sleep(2000);

			// Thread.sleep(2000);
			System.out.println("Select Customer Group");
			Log.info("Select Customer Group");
			test.log(LogStatus.INFO, "Select Customer Group");
			// selectDpdwnText("mainWebsite_css", "General");
			click("groupGeneral_css");
			String group = CommonHelper.element("groupGeneral_css").getText();
			System.out.println("The Customer Group is: " + group);
			test.log(LogStatus.INFO, "The Customer Group is: " + group);
			// Thread.sleep(2000);

			// Thread.sleep(2000);
			System.out.println("Select Coupon Type");
			Log.info("Select Coupon Type");
			test.log(LogStatus.INFO, "Select Coupon Type");
			selectDpdwnText("couponType_css", "Specific Coupon");
			String couponType = CommonHelper.element("couponType_css").getCssValue("value");
			System.out.println("The Coupon Type is: " + "Specific Coupon");
			test.log(LogStatus.INFO, "The Coupon Type is: " + "Specific Coupon");
			// Thread.sleep(2000);

			// Thread.sleep(2000);
			System.out.println("Enter Coupon Code");
			Log.info("Enter Coupon Code");
			test.log(LogStatus.INFO, "Enter Coupon Code");
			CommonHelper.scrolltoview("couponCode_css");
			clearText("couponCode_css");
			enterText("couponCode_css", ruleName);
			String couponCode = CommonHelper.element("couponCode_css").getAttribute("data-title");
			System.out.println("The Coupon Code is: " + ruleName);
			test.log(LogStatus.INFO, "The Coupon Code is: " + ruleName);
			// Thread.sleep(2000);

			// Thread.sleep(2000);
			System.out.println("Enter Uses Per Coupon");
			Log.info("Enter Uses Per Coupon");
			test.log(LogStatus.INFO, "Enter Uses Per Coupon");
			clearText("usesPerCoupon_css");
			enterText("usesPerCoupon_css", "100");
			String usesPerCoupon = CommonHelper.element("usesPerCoupon_css").getAttribute("data-title");
			System.out.println("The Uses Per Coupon is: " + "100");
			test.log(LogStatus.INFO, "The Uses Per Coupon is: " + "100");
			// Thread.sleep(2000);

			// Thread.sleep(2000);
			System.out.println("Enter Uses Per Customer");
			Log.info("Enter Uses Per Customer");
			test.log(LogStatus.INFO, "Enter Uses Per Customer");
			clearText("usesPerCustomer_css");
			enterText("usesPerCustomer_css", "100");
			String usesPerCustomer = CommonHelper.element("usesPerCustomer_css").getAttribute("data-title");
			System.out.println("The Uses Per Customer is: " + "100");
			test.log(LogStatus.INFO, "The Uses Per Customer is: " + "100");
			// Thread.sleep(2000);

			// Thread.sleep(2000);
			System.out.println("Click on Action");
			Log.info("Click on Action");
			test.log(LogStatus.INFO, "Click on Action");
			click("actions_xpath");
			Thread.sleep(1000);

			System.out.println("Enter Discount Percentage");
			Log.info("Enter Discount Percentage");
			test.log(LogStatus.INFO, "Enter Discount Percentage");
			CommonHelper.scrolltoview("discountAmount_css");
			clearText("discountAmount_css");
			enterText("discountAmount_css", "10");
			String discountAmount = CommonHelper.element("discountAmount_css").getAttribute("data-title");
			System.out.println("The Discount Percentage is: " + "10");
			test.log(LogStatus.INFO, "The Discount Percentage is: " + "10");

			System.out.println("Click on Save");
			Log.info("Click on Save");
			test.log(LogStatus.INFO, "Click on Save");
			click("saveCouponCodeDetails_id");
			Thread.sleep(1000);

			String successMsg = driver.findElement(By.xpath("//*[@id='messages']/div/div/div")).getText();
			if (successMsg.contains("You saved the rule.")) {
				test.log(LogStatus.PASS, "The success message is: " + successMsg);
				System.out.println("The success message is: " + successMsg);
				test.log(LogStatus.PASS, "Create Promocode with Special Character was successful");
				System.out.println("Create Promocode with Special Character was successful");
			} else {
				test.log(LogStatus.FAIL, "Create Promocode with Special Character was unsuccessful");
				System.out.println("Create Promocode with Special Character was unsuccessful");
			}

		} catch (Exception e) {
			CommonHelper.reportFailure("Create Promocode with Special Character was unsuccessful");
			e.printStackTrace();
		}

		return ruleName;

	}

	public void clickReports() {

		try {
			System.out.println("Click Reports Menu");
			Log.info("Click on Reports Menu");
			test.log(LogStatus.INFO, "Click Reports Menu");
			click("reportsMenu_xpath");

			System.out.println("Click Coupons submenu");
			Log.info("Click Coupons Submenu");
			test.log(LogStatus.INFO, "Click Coupons submenu");
			click("coupons_xpath");
			// click("coupons_css");
			// driver.findElement(By.cssSelector("coupons_xpath")).click();

		} catch (Exception e) {
			CommonHelper.reportFailure("Click Add New Rule was unsucessful");
			e.printStackTrace();
		}
	}

	public void selectCalendarDate() {

		System.out.println("Click From Date Calendar");
		Log.info("Click From Date Calendar");
		test.log(LogStatus.INFO, "Click From Date Calendar");
		click("calendarFromDatePicker_xpath");

		System.out.println("Select From Month");
		Log.info("Select From Month");
		test.log(LogStatus.INFO, "Select From Month");
		selectDpdwnText("calendarMonthPicker_css", "Apr");

		System.out.println("Select From Date");
		Log.info("Select From Date");
		test.log(LogStatus.INFO, "Select From Date");
		click("calendarFromDate_xpath");

		System.out.println("Click To Date Calendar");
		Log.info("Click To Date Calendar");
		test.log(LogStatus.INFO, "Click To Date Calendar");
		click("calendarToDatePicker_xpath");

		System.out.println("Select Today's Date");
		Log.info("Select Today's Date");
		test.log(LogStatus.INFO, "Select Today's Date");
		click("calendarTodayDate_css");

		System.out.println("Click Close Calendar");
		Log.info("Click Close Calendar");
		test.log(LogStatus.INFO, "Click Close Calendar");
		click("calendarClose_xpath");

	}

	public void clickShowReports() {

		try {
			System.out.println("Click Show Report");
			Log.info("Click Show Report");
			test.log(LogStatus.INFO, "Click Show Report");
			click("showReport_id");
			test.log(LogStatus.PASS, "Reports shown successfully");

		} catch (Exception e) {
			CommonHelper.reportFailure("Reports shown was unsuccessful");
			e.printStackTrace();
		}
	}

	public void verifyPromoCodeList() {

		try {
			Thread.sleep(2000);
			System.out.println("View Number of Records");
			Log.info("View Number of Records");
			test.log(LogStatus.INFO, "View Number of Records");
			String numRecords = CommonHelper.element("numOfRecords_css").getText();
			System.out.println("The number of Records is:" + numRecords);
			test.log(LogStatus.INFO, "The number of Records is:" + numRecords);

			Thread.sleep(3000);
			CommonHelper.scrolltoview("tableOfRecords_css");
			String table = driver.findElement(By.cssSelector("table[class='data-grid']")).getText();
			System.out.println("The table data is:" + table);
			test.log(LogStatus.INFO, "The table data is:" + table);
			CommonHelper.takeScreenShot();

		} catch (Exception e) {
			CommonHelper.reportFailure("Verification of Promo Code records was unsuccessful");
			e.printStackTrace();
		}

	}

	public void verifyPromoCode(String promocode) {

		try {

			System.out.println("Reset Filter");
			Log.info("Reset Filter");
			test.log(LogStatus.INFO, "Reset Filter");
			click("resetFilter_css");

			Thread.sleep(2000);
			System.out.println("Enter Promocode");
			Log.info("Enter Promocode");
			test.log(LogStatus.INFO, "Enter Promocode");
			enterText("couponCode_id", promocode);

			System.out.println("Click Search Promocode");
			Log.info("Click Search Promocode");
			test.log(LogStatus.INFO, "Click Search Promocode");
			click("searchCouponCode_css");

			String couponCode = CommonHelper.element("couponCodeSearchColumnData_css").getText();
			if (couponCode.equals(promocode)) {
				System.out.println("The created Coupon Code is: " + couponCode);
				test.log(LogStatus.PASS, "The created Coupon Code is: " + couponCode);
			} else {
				System.out.println("The created Coupon Code is: " + couponCode);
				test.log(LogStatus.FAIL, "The created Coupon Code is: " + couponCode);
			}

			String couponCodeStatus = CommonHelper.element("statusPromoCode_css").getText();
			if (couponCodeStatus.equalsIgnoreCase("Active")) {
				System.out.println("The status of Coupon Code is: " + couponCode);
				test.log(LogStatus.PASS, "The status of Coupon Code is: " + couponCode);
				test.log(LogStatus.PASS, "Verification of Promo Code was successful");

			} else {
				System.out.println("Verification of Promo Code was unsuccessful");
				test.log(LogStatus.FAIL, "Verification of Promo Code was unsuccessful");
			}
		} catch (Exception e) {
			CommonHelper.reportFailure("Verification of Promo Code was unsuccessful");
			e.printStackTrace();
		}

	}

	public void clickSalesMenu() throws Exception {

		System.out.println("Click Sales Menu");
		Log.info("Click Sales Menu");
		test.log(LogStatus.INFO, "Click Sales Menu");
		click("magentoSales_xpath");

	}

	public void clickOrdersSubmenu() throws Exception {

		System.out.println("Click Orders Submenu");
		Log.info("Click Orders Submenu");
		test.log(LogStatus.INFO, "Click Orders Submenu");
		click("orderSubmenu_xpath");
	}

	public void searchOrderNum(String orderNumber) {
		try {
			boolean remove = false;

			try {
				remove = CommonHelper.isElementVisible("removeKeyword_xpath");
			} catch (Exception e) {
				e.printStackTrace();
			}
			if (remove) {
				System.out.println("Click Remove Keyword");
				Log.info("Click Remove Keyword");
				test.log(LogStatus.INFO, "Click Remove Keyword");
				click("removeKeyword_xpath");
			}

			Thread.sleep(2000);
			System.out.println("Enter keyword for search");
			Log.info("Enter keyword for search");
			test.log(LogStatus.INFO, "Enter keyword for search");
			clearText("searchKeywordText_id");
			Thread.sleep(2000);
			enterText("searchKeywordText_id", orderNumber);

			System.out.println("Click on Search");
			Log.info("Click on Search");
			test.log(LogStatus.INFO, "Click on Search");
			click("searchDetails_xpath");
			Thread.sleep(5000);

		} catch (Exception e) {
			CommonHelper.reportFailure("Search Order Number was unsuccessful");
			e.printStackTrace();
		}
	}

	public void clickViewOrder() throws Exception {

		boolean closeAlert = false;

		try {
			Thread.sleep(2000);
			System.out.println("Click View Order");
			Log.info("Click View Order");
			test.log(LogStatus.INFO, "Click View Order");
			click("viewCMSOrder_xpath");
			Thread.sleep(5000);

			try {
				driver.switchTo().defaultContent();
				closeAlert = driver.findElement(By.cssSelector("button[data-role='closeBtn']")).isDisplayed();
				if (closeAlert) {
					test.log(LogStatus.INFO, "Close Alert");
					System.out.println("Close Alert");
					List<WebElement> alert = driver.findElements(By.cssSelector("button[data-role='closeBtn']"));
					for (int i = 0; i <= alert.size(); i++) {
						click("closeAlert_css");
					}
					Thread.sleep(1000);
				}
			} catch (Exception e) {
				e.printStackTrace();
			}

			/*
			 * try { alert = driver.findElement(By.xpath(
			 * "//*[@id='html-body']/div[8]/aside[3]/div[2]/header/button")) .isDisplayed();
			 * } catch (Exception e) { e.printStackTrace(); } if (alert) {
			 * System.out.println("Click Alert"); test.log(LogStatus.INFO, "Click Alert");
			 * List<WebElement> alerts = driver .findElements(By.xpath(
			 * "//*[@id='html-body']/div[8]/aside[4]/div[2]/footer/button/span")); for (int
			 * i = 0; i <= alerts.size(); i++) { driver.findElement(By.xpath(
			 * "//*[@id='html-body']/div[8]/aside[4]/div[2]/footer/button/span")) .click();
			 * }
			 * 
			 * }
			 */
		} catch (Exception e) {
			CommonHelper.reportFailure("Click View Order was unsuccessful");
			e.printStackTrace();
		}

	}

	public void verifyEvidenceInfo() {

		try {
			CommonHelper.scrolltoview("evidenceInfo_xpath");
			List<WebElement> evidenceCountry = driver.findElements(By.cssSelector("div[class='box-content']"));
			String ipCountry = evidenceCountry.get(0).getText();
			System.out.println("The IP Country is: " + ipCountry);
			test.log(LogStatus.INFO, "The IP Country is: " + ipCountry);
			String billingCountry = evidenceCountry.get(1).getText();
			System.out.println("The Billing Country is: " + billingCountry);
			test.log(LogStatus.INFO, "The Billing Country is: " + billingCountry);
			String cardIssueCountry = evidenceCountry.get(2).getText();
			System.out.println("The Card Issue Country is: " + cardIssueCountry);
			test.log(LogStatus.INFO, "The Card Issue Country is: " + cardIssueCountry);

			if (ipCountry.equals(billingCountry) && billingCountry.equals(cardIssueCountry)
					&& cardIssueCountry.equals(ipCountry)) {
				System.out.println("Verification of Evidence Information was successful");
				test.log(LogStatus.PASS, "Verification of Evidence Information was successful");
			} else {
				System.out.println("Verification of Evidence Information was unsuccessful");
				test.log(LogStatus.FAIL, "Verification of Evidence Information was unsuccessful");
			}
		} catch (Exception e) {
			CommonHelper.reportFailure("Verification of Evidence Information Order Details was unsuccessful");
			e.printStackTrace();
		}

	}

	public void clickAdminLogout() {

		try {

			Thread.sleep(2000);
			System.out.println("Click Admin Logout");
			Log.info("Click Admin Logout");
			test.log(LogStatus.INFO, "Click Admin Logout");
			CommonHelper.scrolltoview("adminLogoutDpdwn_xpath");
			click("adminLogoutDpdwn_xpath");
			click("adminSignOut_css");
			test.log(LogStatus.PASS, "Admin Logout was successful");
			System.out.println("Admin Logout was successful");

		} catch (InterruptedException e) {
			CommonHelper.reportFailure("Admin Logout was unsuccessful");
			e.printStackTrace();
		}
	}

	public void clickContent() {

		try {
			System.out.println("Click Content Menu");
			Log.info("Click on Content Menu");
			test.log(LogStatus.INFO, "Click on Content Menu");
			click("contentMenu_xpath");

		} catch (Exception e) {
			CommonHelper.reportFailure("Click Content Menu was unsucessful");
			e.printStackTrace();
		}
	}

	public void clickPages() {

		try {

			System.out.println("Click Pages submenu");
			Log.info("Click Pages Submenu");
			test.log(LogStatus.INFO, "Click Pages submenu");
			click("pagesSubmenu_xpath");

		} catch (Exception e) {
			CommonHelper.reportFailure("Click Pages submenu was unsucessful");
			e.printStackTrace();
		}
	}

	public void searchPage() {

		boolean remove = false;

		try {
			Thread.sleep(2000);
			try {
				remove = CommonHelper.isElementVisible("removeKeyword_xpath");
			} catch (Exception e) {
				e.printStackTrace();
			}
			if (remove) {
				System.out.println("Click Remove Keyword");
				Log.info("Click Remove Keyword");
				test.log(LogStatus.INFO, "Click Remove Keyword");
				click("removeKeyword_xpath");
			}

			Thread.sleep(1000);
			System.out.println("Enter keyword for search");
			Log.info("Enter keyword for search");
			test.log(LogStatus.INFO, "Enter keyword for search");
			clearText("searchKeywordText_id");
			Thread.sleep(1000);
			enterText("searchKeywordText_id", "503");

			System.out.println("Click on Search");
			Log.info("Click on Search");
			test.log(LogStatus.INFO, "Click on Search");
			click("searchDetails_xpath");
			Thread.sleep(2000);

		} catch (InterruptedException e) {
			CommonHelper.reportFailure("Search Page was unsuccessful");
			e.printStackTrace();
		}
	}

	public void viewCMSContentPage() {

		try {

			System.out.println("Verify CMS Page");
			Log.info("Verify CMS Page");
			test.log(LogStatus.INFO, "Verify CMS Page");
			String title = driver.findElement(By.xpath("//*[@id='container']/div/div[5]/table/tbody/tr[2]/td[3]/div"))
					.getText();
			if (title.contains("503")) {
				System.out.println("Verification of CMS Content Page was susccessful");
				test.log(LogStatus.PASS, "Verification of CMS Content Page was susccessful");
				CommonHelper.takeScreenShot();
			}

		} catch (Exception e) {
			CommonHelper.reportFailure("Verify CMS Content Page was unsuccessful");
			e.printStackTrace();
		}
	}

	public String createPage() {
		String page = "BSI_Shop Automation";

		try {
			System.out.println("Click Add New Page");
			Log.info("Click Add New Page");
			test.log(LogStatus.INFO, "Click Add New Page");
			click("addPage_id");

			System.out.println("Enter Page Title");
			Log.info("Enter Page Title");
			test.log(LogStatus.INFO, "Enter Page Title");
			enterText("cmsTitle_css", "BSI_Shop Automation");

			System.out.println("Enter Page Keyword");
			Log.info("Enter Page Keyword");
			test.log(LogStatus.INFO, "Enter Page Keyword");
			enterText("cmskeyword_css", "BSI_Shop Automation");

			System.out.println("Click on Content");
			Log.info("Click on Content");
			test.log(LogStatus.INFO, "Click on Content");
			click("showContent_xpath");

			System.out.println("Enter Page Text");
			Log.info("Enter Page Text");
			test.log(LogStatus.INFO, "Enter Page Text");
			click("showHideEditor_xpath");
			enterText("pageContent_id", "BSI_Shop Automation");
			click("showHideEditor_xpath");

			System.out.println("Show Hierarchy");
			Log.info("Show Hierarchy");
			test.log(LogStatus.INFO, "Show Hierarchy");
			click("showHierarchy_xpath");

			System.out.println("Select Hierarchy Folder");
			Log.info("Select Hierarchy Folder");
			test.log(LogStatus.INFO, "Select Hierarchy Folder");
			click("selectHierarchy_id");

			System.out.println("Click on Save Page");
			Log.info("Click on Save Page");
			test.log(LogStatus.INFO, "Click on Save Page");
			click("savePage_xpath");
			Thread.sleep(2000);

			String verifySuccessMsg = driver.findElement(By.xpath("//*[@id='messages']/div/div/div")).getText();
			if (verifySuccessMsg.contains("You saved the page.")) {
				System.out.println("CMS Page creation was successful");
				test.log(LogStatus.PASS, "CMS Page creation was successful");
			}
			// Thread.sleep(5000);

		} catch (InterruptedException e) {
			CommonHelper.reportFailure("CMS Page creation was unsuccessful");
			e.printStackTrace();
		}
		return page;
	}

	public void searchCMSPage(String cmsPage) {

		boolean removeKeyword = false;

		try {
			Thread.sleep(2000);
			try {
				removeKeyword = driver
						.findElement(By.xpath("//*[@id='container']/div/div[2]/div[1]/div[4]/div[2]/ul/li/button"))
						.isDisplayed();
			} catch (Exception e) {
				e.printStackTrace();
			}
			if (removeKeyword) {
				System.out.println("Click Clear All Keywords");
				Log.info("Click Clear All Keywords");
				test.log(LogStatus.INFO, "Click Clear All Keywords");
				click("clearAllKeywords_xpath");

				Thread.sleep(2000);
				System.out.println("Enter keyword for search");
				Log.info("Enter keyword for search");
				test.log(LogStatus.INFO, "Enter keyword for search");
				// CommonHelper.scrolltoview("searchKeywordText_xpath");
				clearText("searchKeywordText_xpath");
				Thread.sleep(2000);
				enterText("searchKeywordText_xpath", cmsPage);

				System.out.println("Click on Search");
				Log.info("Click on Search");
				test.log(LogStatus.INFO, "Click on Search");
				click("searchDetails_xpath");
				Thread.sleep(2000);

			} else {

				Thread.sleep(2000);
				System.out.println("Enter keyword for search");
				Log.info("Enter keyword for search");
				test.log(LogStatus.INFO, "Enter keyword for search");
				// CommonHelper.scrolltoview("searchKeywordText_xpath");
				clearText("searchKeywordText_xpath");
				Thread.sleep(2000);
				enterText("searchKeywordText_xpath", cmsPage);

				System.out.println("Click on Search");
				Log.info("Click on Search");
				test.log(LogStatus.INFO, "Click on Search");
				click("searchDetails_xpath");
				Thread.sleep(2000);
			}
		} catch (Exception e) {
			CommonHelper.reportFailure("Search CMS Page was unsuccessful");
			e.printStackTrace();
		}
	}

	public void deleteCMSPage() {

		try {
			Thread.sleep(1000);
			System.out.println("Delete CMS Page");
			Log.info("Delete CMS Page");
			test.log(LogStatus.INFO, "Delete CMS Page");
			click("selectAction_xpath");
			// selectDpdwnValue("selectAction_xpath", "delete");
			click("selectDeletePage_xpath");
			Thread.sleep(1000);
			System.out.println("Confirm Delete CMS Page");
			Log.info("Confirm Delete CMS Page");
			test.log(LogStatus.INFO, "Confirm Delete CMS Page");
			click("confirmDelete_xpath");
			Thread.sleep(5000);

			String verifySuccessMsg = driver.findElement(By.xpath("//*[@id='messages']/div/div/div")).getText();
			if (verifySuccessMsg.contains("The page has been deleted.")) {
				System.out.println("CMS Page was deleted successfully");
				test.log(LogStatus.PASS, "CMS Page was deleted successfully");
			}
			Thread.sleep(2000);

		} catch (InterruptedException e) {
			CommonHelper.reportFailure("Delete CMS Page was unsuccessful");
			e.printStackTrace();
		}
	}

	public void clickEdit() {
		try {
			Thread.sleep(1000);
			System.out.println("Click on Edit CMS Page");
			Log.info("Click on Edit CMS Page");
			test.log(LogStatus.INFO, "Click on Edit CMS Page");
			click("selectAction_xpath");
			click("selectEdit_xpath");
		} catch (InterruptedException e) {
			CommonHelper.reportFailure("Click Edit was unsuccessful");
			e.printStackTrace();
		}

	}

	public void selectMetaRobot() {
		try {
			Thread.sleep(2000);
			System.out.println("Click Search Engine Optimisation");
			Log.info("Click Search Engine Optimisation");
			test.log(LogStatus.INFO, "Click Search Engine Optimisation");
			click("searchEngineOpti_xpath");

			Thread.sleep(2000);
			System.out.println("Select Meta Robot");
			Log.info("Select Meta Robot");
			test.log(LogStatus.INFO, "Select Meta Robot");
			CommonHelper.scrolltoview("metaRobot_css");
			selectDpdwnText("metaRobot_css", "NOINDEX, NOFOLLOW");
		} catch (InterruptedException e) {
			CommonHelper.reportFailure("Select Meta Robot was unsuccessful");
			e.printStackTrace();
		}
	}

	public void scheduleNewUpdate() {

		try {
			Thread.sleep(1000);
			System.out.println("Click on Schedule New Update");
			Log.info("Click on Schedule New Update");
			test.log(LogStatus.INFO, "Click on Schedule New Update");
			click("scheduleUpdate_xpath");

			Thread.sleep(2000);
			System.out.println("Enter Update Name");
			Log.info("Enter Update Name");
			test.log(LogStatus.INFO, "Enter Update Name");
			enterText("updateName_css", "BSI_Automation_Updated");

			Thread.sleep(3000);
			System.out.println("Click on Date Picker for Start Date");
			Log.info("Click on Date Picker for Start Date");
			test.log(LogStatus.INFO, "Click on Date Picker for Start Date");
			List<WebElement> datePicker = driver
					.findElements(By.cssSelector("button[class='ui-datepicker-trigger v-middle']"));
			datePicker.get(0).click();

			Thread.sleep(1000);
			System.out.println("Select Start Month");
			Log.info("Select Start Month");
			test.log(LogStatus.INFO, "Select Start Month");
			selectDpdwnText("calendarSelectMonth_xpath", "Apr");

			System.out.println("Select Start Date");
			Log.info("Select Start Date");
			test.log(LogStatus.INFO, "Select Start Date");
			click("calendarSelectStartDate_xpath");

			System.out.println("Click Close Calendar");
			Log.info("Click Close Calendar");
			test.log(LogStatus.INFO, "Click Close Calendar");
			click("calendarClose_css");

			Thread.sleep(3000);
			System.out.println("Click on Date Picker for End Date");
			Log.info("Click on Date Picker for End Date");
			test.log(LogStatus.INFO, "Click on Date Picker for End Date");
			datePicker.get(1).click();

			Thread.sleep(1000);
			System.out.println("Select End Month");
			Log.info("Select End Month");
			test.log(LogStatus.INFO, "Select End Month");
			selectDpdwnText("calendarSelectMonth_xpath", "Dec");

			System.out.println("Select End Date");
			Log.info("Select End Date");
			test.log(LogStatus.INFO, "Select End Date");
			click("calendarSelectStartDate_xpath");

			System.out.println("Click Close Calendar");
			Log.info("Click Close Calendar");
			test.log(LogStatus.INFO, "Click Close Calendar");
			click("calendarClose_css");

		} catch (InterruptedException e) {
			CommonHelper.reportFailure("Schedule New Update was unsuccessful");
			e.printStackTrace();
		}
	}

	public void editCMSPage() {

		try {

			System.out.println("Click on Edit CMS Page");
			Log.info("Click on Edit CMS Page");
			clickEdit();

			System.out.println("Select Meta Robot");
			Log.info("Select Meta Robot");
			selectMetaRobot();

			System.out.println("Schedule New Update");
			Log.info("Schedule New Update");
			test.log(LogStatus.INFO, "Schedule New Update");
			scheduleNewUpdate();

			System.out.println("Click on Save");
			Log.info("Click on Save");
			test.log(LogStatus.INFO, "Click on Save");
			CommonHelper.scrolltoview("editSave_css");
			click("editSave_css");

			System.out.println("Click on Save Page");
			Log.info("Click on Save Page");
			test.log(LogStatus.INFO, "Click on Save Page");
			click("saveEditPage_css");
			Thread.sleep(2000);

			String verifySuccessMsg = driver.findElement(By.xpath("//*[@id='messages']/div/div/div")).getText();
			if (verifySuccessMsg.contains("You saved the page.")) {
				System.out.println("CMS Page edit and update was successful");
				test.log(LogStatus.PASS, "CMS Page edit and update was successful");
			}

		} catch (InterruptedException e) {
			CommonHelper.reportFailure("Edit and Update of CMS Page was unsuccessful");
			e.printStackTrace();
		}
	}

	public void previewCMSPage(String preivewContent) {

		try {
			System.out.println("Click on Edit CMS Page");
			Log.info("Click on Edit CMS Page");
			clickEdit();

			System.out.println("Click on Page Revision");
			Log.info("Click on Page Revision");
			test.log(LogStatus.INFO, "Click on Page Revision");
			CommonHelper.scrolltoview("pageRevision_xpath");
			click("pageRevision_xpath");

			Thread.sleep(1000);
			System.out.println("Select Preview CMS Page");
			Log.info("Select Preview CMS Page");
			test.log(LogStatus.INFO, "Select Preview CMS Page");
			CommonHelper.scrolltoview("selectActionPreview_xpath");
			click("selectActionPreview_xpath");
			click("selectPreview_xpath");
			Thread.sleep(1000);

			Thread.sleep(1000);
			System.out.println("Click Show Preview");
			Log.info("Click Show Preview");
			test.log(LogStatus.INFO, "Click Show Preview");
			click("showPreview_xpath");
			Thread.sleep(5000);

			System.out.println("Switch to 2nd tab");
			ArrayList<String> tabs2 = new ArrayList<String>(driver.getWindowHandles());
			driver.switchTo().window(tabs2.get(1));
			driver.manage().window().maximize();
			System.out.println("Switched to 2nd tab");
			Thread.sleep(5000);

			String previewText = driver.findElement(By.cssSelector("div[id='authenticationPopup']+p")).getText();
			if (previewText.contains(preivewContent)) {
				System.out.println("The Preview Content is: " + previewText);
				test.log(LogStatus.INFO, "The Preview Content is: " + previewText);
				CommonHelper.takeScreenShot();
				test.log(LogStatus.PASS, "Verification of Preview was succeccsful");
			}

			driver.close();
			driver.switchTo().window(tabs2.get(0));
			Thread.sleep(2000);
			driver.findElement(By.id("back")).click();

		} catch (InterruptedException e) {
			CommonHelper.reportFailure("Preview of CMS Page was unsuccessful");
			e.printStackTrace();
		}

	}

	public String createPageWithMedia() throws AWTException, IOException {

		String page = "BSI_Shop Automation";

		try {
			System.out.println("Click Add New Page");
			Log.info("Click Add New Page");
			test.log(LogStatus.INFO, "Click Add New Page");
			click("addPage_id");

			System.out.println("Enter Page Title");
			Log.info("Enter Page Title");
			test.log(LogStatus.INFO, "Enter Page Title");
			enterText("cmsTitle_css", "BSI_Shop Automation");

			System.out.println("Enter Page Keyword");
			Log.info("Enter Page Keyword");
			test.log(LogStatus.INFO, "Enter Page Keyword");
			enterText("cmskeyword_css", "BSI_Shop Automation");

			System.out.println("Click on Content");
			Log.info("Click on Content");
			test.log(LogStatus.INFO, "Click on Content");
			click("showContent_xpath");

			System.out.println("Enter Page Text");
			Log.info("Enter Page Text");
			test.log(LogStatus.INFO, "Enter Page Text");
			click("showHideEditor_xpath");
			enterText("pageContent_id", "BSI_Shop Automation");
			click("showHideEditor_xpath");

			Thread.sleep(2000);
			System.out.println("Click Insert Image File");
			Log.info("Click Insert Image File");
			test.log(LogStatus.INFO, "Click Insert Image File");
			// CommonHelper.scrolltoview("insertImage_css");
			click("insertImage_css");
			Thread.sleep(2000);

			// AutoIt Command to call the script
			// Runtime.getRuntime().exec("C:\\AutoIT\\FileUpload.exe");
			// Thread.sleep(10000);

			StringSelection ss = new StringSelection(
					"https://staging-standards.bsigroup.com/admin/cms/wysiwyg/directive/___directive/e3ttZWRpYSB1cmw9Ind5c2l3eWcvVENTX0F1dG9tYXRpb24vQlNJLUltYWdlLnBuZyJ9fQ,,/key/5e8b6a49c6fa17325dbcbc9fe2b211a8b907b4a81e3a2782d54f91b4bef16a33/");
			Toolkit.getDefaultToolkit().getSystemClipboard().setContents(ss, null);

			// native key strokes for CTRL, V and ENTER keys
			Robot robot = new Robot();
			robot.keyPress(KeyEvent.VK_CONTROL);
			robot.keyPress(KeyEvent.VK_V);
			robot.keyRelease(KeyEvent.VK_V);
			robot.keyRelease(KeyEvent.VK_CONTROL);
			robot.keyPress(KeyEvent.VK_ENTER);
			robot.keyRelease(KeyEvent.VK_ENTER);
			robot.keyPress(KeyEvent.VK_ENTER);
			robot.keyRelease(KeyEvent.VK_ENTER);

			Thread.sleep(10000);
			System.out.println("Show Hierarchy");
			Log.info("Show Hierarchy");
			test.log(LogStatus.INFO, "Show Hierarchy");
			click("showHierarchy_xpath");

			System.out.println("Select Hierarchy Folder");
			Log.info("Select Hierarchy Folder");
			test.log(LogStatus.INFO, "Select Hierarchy Folder");
			click("selectHierarchy_id");

			System.out.println("Click on Save Page");
			Log.info("Click on Save Page");
			test.log(LogStatus.INFO, "Click on Save Page");
			click("savePage_xpath");
			Thread.sleep(2000);

			String verifySuccessMsg = driver.findElement(By.xpath("//*[@id='messages']/div/div/div")).getText();
			if (verifySuccessMsg.contains("You saved the page.")) {
				System.out.println("CMS Page creation was successful");
				test.log(LogStatus.PASS, "CMS Page creation was successful");
			}
			// Thread.sleep(5000);

		} catch (InterruptedException e) {
			CommonHelper.reportFailure("CMS Page creation was unsuccessful");
			e.printStackTrace();
		}
		return page;
	}

	public String createFolderCMSPage() throws AWTException, IOException {

		String page = "BSI_Shop Automation";

		try {
			System.out.println("Click Add New Page");
			Log.info("Click Add New Page");
			test.log(LogStatus.INFO, "Click Add New Page");
			click("addPage_id");

			System.out.println("Enter Page Title");
			Log.info("Enter Page Title");
			test.log(LogStatus.INFO, "Enter Page Title");
			enterText("cmsTitle_css", "BSI_Shop Automation");

			System.out.println("Enter Page Keyword");
			Log.info("Enter Page Keyword");
			test.log(LogStatus.INFO, "Enter Page Keyword");
			enterText("cmskeyword_css", "BSI_Shop Automation");

			System.out.println("Click on Content");
			Log.info("Click on Content");
			test.log(LogStatus.INFO, "Click on Content");
			click("showContent_xpath");

			System.out.println("Enter Page Text");
			Log.info("Enter Page Text");
			test.log(LogStatus.INFO, "Enter Page Text");
			click("showHideEditor_xpath");
			enterText("pageContent_id", "BSI_Shop Automation");
			click("showHideEditor_xpath");

			Thread.sleep(2000);
			System.out.println("Click Insert Image File");
			Log.info("Click Insert Image File");
			test.log(LogStatus.INFO, "Click Insert Image File");
			// CommonHelper.scrolltoview("insertImage_css");
			click("insertImage_css");
			Thread.sleep(2000);
			
			System.out.println("Click on Browse");
			Log.info("Click on Browse");
			test.log(LogStatus.INFO, "Click on Browse");
			//Switching to Iframe
			driver.switchTo().frame(driver.findElement(By.id("mce_26_ifr")));
			click("browseImage_id");
			Thread.sleep(2000);
			click("subFolder_css");
			Thread.sleep(2000);
			click("createFolder_id");
			Thread.sleep(2000);
			enterText("folderName_id", "Automation Test Folder");
			Thread.sleep(2000);
			click("createFolderNameOk_xpath");
			Thread.sleep(2000);


			
			
		} catch (InterruptedException e) {
			CommonHelper.reportFailure("CMS Page creation was unsuccessful");
			e.printStackTrace();
		}
		return page;
	}
}
