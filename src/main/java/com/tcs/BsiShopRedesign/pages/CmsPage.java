package com.tcs.BsiShopRedesign.pages;

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

		try {
			System.out.println("Click Customer Menu");
			Log.info("Click Customer Menu");
			test.log(LogStatus.INFO, "Click Customer Menu");
			click("magentoCustomer_xpath");

			System.out.println("Click All Customer Submenu");
			Log.info("Click All Customer Submenu");
			test.log(LogStatus.INFO, "Click All Customer Submenu");
			click("magentoAllCustomer_xpath");
			
			System.out.println("Click Remove Keyword");
			Log.info("Click Remove Keyword");
			test.log(LogStatus.INFO, "Click Remove Keyword");
			click("removeKeyword_css");

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

			String firstName = driver.findElement(By.cssSelector("input[name='customer[firstname]']")).getAttribute("value");
			System.out.println("The First Name is: " + firstName);
			test.log(LogStatus.INFO, "The First Name is: " + firstName);

			String lastName = driver.findElement(By.cssSelector("input[name='customer[lastname]']")).getAttribute("value");
			System.out.println("The Last Name is: " + lastName);
			test.log(LogStatus.INFO, "The Last Name is: " + lastName);

			String email = driver.findElement(By.cssSelector("input[name='customer[email]']")).getAttribute("value");
			System.out.println("The Email id is: " + email);
			test.log(LogStatus.INFO, "The Email id is: " + email);

			String memberID = driver.findElement(By.cssSelector("input[name='customer[membership_number]']")).getAttribute("value");
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
}
