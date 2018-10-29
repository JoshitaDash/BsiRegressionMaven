package com.tcs.BsiShopRedesign.pages;

import org.apache.commons.lang3.RandomStringUtils;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
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
				remove = CommonHelper.isElementVisible("removeKeyword_css");
			} catch (Exception e) {
				e.printStackTrace();
			}
			if (remove) {
				System.out.println("Click Remove Keyword");
				Log.info("Click Remove Keyword");
				test.log(LogStatus.INFO, "Click Remove Keyword");
				click("removeKeyword_css");
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
				remove = CommonHelper.isElementVisible("removeKeyword_css");
			} catch (Exception e) {
				e.printStackTrace();
			}
			if (remove) {
				System.out.println("Click Remove Keyword");
				Log.info("Click Remove Keyword");
				test.log(LogStatus.INFO, "Click Remove Keyword");
				click("removeKeyword_css");
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

	public void enterPromoCodeDetails() {

		try {

			System.out.println("Enter Rule Name");
			Log.info("Enter Rule Name");
			test.log(LogStatus.INFO, "Enter Rule Name");
			CommonHelper.elementToBeVisible("ruleName_css");
			String ruleName = RandomStringUtils.randomAlphanumeric(5) + RandomStringUtils.random(5, "@!#$%")
					+ RandomStringUtils.randomAlphabetic(3);
			System.out.println("The rule Name is: " + ruleName);
			test.log(LogStatus.INFO, "The rule Name is: " + ruleName);
			clearText("ruleName_css");
			enterText("ruleName_css", ruleName);
			Thread.sleep(2000);

			System.out.println("Select Website");
			Log.info("Select Website");
			test.log(LogStatus.INFO, "Select Website");
			click("mainWebsite_css");
			String website = CommonHelper.element("mainWebsite_css").getAttribute("data-title");
			System.out.println("The Website is: " + website);
			test.log(LogStatus.INFO, "The Website is: " + website);

			System.out.println("Select Customer Group");
			Log.info("Select Customer Group");
			test.log(LogStatus.INFO, "Select Customer Group");
			click("groupGeneral_css");
			String group = CommonHelper.element("groupGeneral_css").getText();
			System.out.println("The Customer Group is: " + group);
			test.log(LogStatus.INFO, "The Customer Group is: " + group);

			System.out.println("Select Coupon Type");
			Log.info("Select Coupon Type");
			test.log(LogStatus.INFO, "Select Coupon Type");
			selectDpdwnText("couponType_css", "Specific Coupon");
			String couponType = CommonHelper.element("couponType_css").getCssValue("value");
			System.out.println("The Coupon Type is: " + "Specific Coupon");
			test.log(LogStatus.INFO, "The Coupon Type is: " + "Specific Coupon");

			System.out.println("Enter Coupon Code");
			Log.info("Enter Coupon Code");
			test.log(LogStatus.INFO, "Enter Coupon Code");
			clearText("couponCode_css");
			enterText("couponCode_css", ruleName);
			String couponCode = CommonHelper.element("couponCode_css").getAttribute("data-title");
			System.out.println("The Coupon Code is: " + ruleName);
			test.log(LogStatus.INFO, "The Coupon Code is: " + ruleName);

			System.out.println("Enter Uses Per Coupon");
			Log.info("Enter Uses Per Coupon");
			test.log(LogStatus.INFO, "Enter Uses Per Coupon");
			clearText("usesPerCoupon_css");
			enterText("usesPerCoupon_css", "100");
			String usesPerCoupon = CommonHelper.element("usesPerCoupon_css").getAttribute("data-title");
			System.out.println("The Uses Per Coupon is: " + "100");
			test.log(LogStatus.INFO, "The Uses Per Coupon is: " + "100");

			System.out.println("Enter Uses Per Customer");
			Log.info("Enter Uses Per Customer");
			test.log(LogStatus.INFO, "Enter Uses Per Customer");
			clearText("usesPerCustomer_css");
			enterText("usesPerCustomer_css", "100");
			String usesPerCustomer = CommonHelper.element("usesPerCustomer_css").getAttribute("data-title");
			System.out.println("The Uses Per Customer is: " + "100");
			test.log(LogStatus.INFO, "The Uses Per Customer is: " + "100");

			System.out.println("Click on Action");
			Log.info("Click on Action");
			test.log(LogStatus.INFO, "Click on Action");
			click("actions_xpath");
			Thread.sleep(1000);

			System.out.println("Enter Discount Percentage");
			Log.info("Enter Discount Percentage");
			test.log(LogStatus.INFO, "Enter Discount Percentage");
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
			test.log(LogStatus.PASS, "Enter Promo Code Details was successful");
			System.out.println("Enter Promo Code Details was successful");

		} catch (InterruptedException e) {
			CommonHelper.reportFailure("Enter Promo Code Details was unsuccessful");
			e.printStackTrace();
		}

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
			//click("coupons_css");
			//driver.findElement(By.cssSelector("coupons_xpath")).click();

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
		
		System.out.println("Click Show Report");
		Log.info("Click Show Report");
		test.log(LogStatus.INFO, "Click Show Report");
		click("showReport_id");
		test.log(LogStatus.PASS, "Reports shown successfully");

	}

}
