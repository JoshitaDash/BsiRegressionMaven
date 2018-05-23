package com.tcs.BsiShopRedesign.sprint1;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.LogStatus;
import com.tcs.BsiShopRedesign.pages.BillingAddressPage;
import com.tcs.BsiShopRedesign.pages.DeliveryAddressPage;
import com.tcs.BsiShopRedesign.pages.SignInPage;
import com.tcs.BsiShopRedesign.utilities.BaseTest;
import com.tcs.BsiShopRedesign.utilities.CommonHelper;


public class MyProfile extends BaseTest {

	public MyProfile() throws Exception {
		super();
	}

	@Test(priority = 1, enabled = true)
	public void signIn() {

		try {
			test = extent.startTest("Sprint 1 - Registered User Sign In");
			System.out.println("User Signing In");
			Log.info("User Signing In");
			SignInPage signIn = new SignInPage(driver);
			signIn.login();
		}

		catch (Exception e) {
			test.log(LogStatus.FATAL, "Registered User Sign In was unsuccessful");
			e.printStackTrace();
			Assert.fail(e.getMessage());
		}
	}

	@Test(priority = 2, enabled = true)
	public void addNewBillingAddress() {

		try {
			test = extent.startTest("Sprint 1 - Add Billing Address");
			System.out.println("Add Billing Address");
			Log.info("Add Billing Address");
			BillingAddressPage bill = new BillingAddressPage(driver);
			bill.addNewBillingAddress();

		}

		catch (Exception e) {
			test.log(LogStatus.FATAL, "Adding Billing address was unsuccessful");
			e.printStackTrace();
			Assert.fail(e.getMessage());
		}
	}

	@Test(priority = 3, enabled = true)
	public void makeDefaultBillingAddress() {

		try {
			test = extent.startTest("Sprint 1 - Make Default Billing Address");
			System.out.println("Make Default Billing Address");
			Log.info("Make Default  Billing Address");
			BillingAddressPage bill = new BillingAddressPage(driver);
			bill.makeDefaultBillingAddress();
		}

		catch (Exception e) {
			test.log(LogStatus.FATAL, "Make Default Billing Address was unsuccessful");
			e.printStackTrace();
			Assert.fail(e.getMessage());
		}
	}

	@Test(priority = 4, enabled = true)
	public void editBillingAddress() {

		try {
			test = extent.startTest("Sprint 1 - Edit Billing Address");
			System.out.println("Edit Billing Address");
			Log.info("Edit Billing Address");
			BillingAddressPage bill = new BillingAddressPage(driver);
			bill.editBillingAddress();

		}

		catch (Exception e) {
			test.log(LogStatus.FATAL, "Edit Billing Address was unsuccessful");
			e.printStackTrace();
			Assert.fail(e.getMessage());
		}
	}

	@Test(priority = 5, enabled = true)
	public void deleteBillingAddress() {

		try {
			test = extent.startTest("Sprint 1 - Delete Billing Address");
			System.out.println("Delete Billing Address");
			Log.info("Delete Billing Address");
			BillingAddressPage bill = new BillingAddressPage(driver);
			bill.deleteBillingAddress();

		}

		catch (Exception e) {
			test.log(LogStatus.FATAL, "Delete Billing Address was unsuccessful");
			e.printStackTrace();
			Assert.fail(e.getMessage());
		}
	}

	@Test(priority = 6, enabled = true)
	public void addDeliveryAddress() {

		try {
			test = extent.startTest("Sprint 1 - Add Delivery Address");
			System.out.println("Add Delivery Address");
			Log.info("Add Delivery Address");
			DeliveryAddressPage delivery = new DeliveryAddressPage(driver);
			delivery.addNewDeliveryAddress();

		} catch (Exception e) {
			test.log(LogStatus.FATAL, "Add Delivery Address was unsuccessful");
			e.printStackTrace();
			Assert.fail(e.getMessage());
		}
	}

	@Test(priority = 7, enabled = true)
	public void makeDefaultDeliveryAddress() {

		try {
			test = extent.startTest("Sprint 1 - Make Default Delivery Address");
			System.out.println("Make Default Delivery Address");
			Log.info("Make Default Delivery Address");
			DeliveryAddressPage delivery = new DeliveryAddressPage(driver);
			delivery.makeDefaultDeliveryAddress();

		} catch (Exception e) {
			test.log(LogStatus.FATAL, "Make Default Delivery Address was unsuccessful");
			e.printStackTrace();
			Assert.fail(e.getMessage());
		}
	}

	@Test(priority = 8, enabled = true)
	public void editDeliveryAddress() {

		try {
			test = extent.startTest("Sprint 1 - Edit Delivery Address");
			System.out.println("Edit Delivery Address");
			Log.info("Edit Delivery Address");
			DeliveryAddressPage delivery = new DeliveryAddressPage(driver);
			delivery.editDeliveryAddress();

		} catch (Exception e) {
			test.log(LogStatus.FATAL, "Edit Delivery Address was unsuccessful");
			e.printStackTrace();
			Assert.fail(e.getMessage());
		}
	}

	@Test(priority = 9, enabled = true)
	public void deleteDeliveryAddress() {

		try {
			test = extent.startTest("Sprint 1 - Delete Delivery Address");
			System.out.println("Delete Delivery Address");
			Log.info("Delete Delivery Address");
			DeliveryAddressPage delivery = new DeliveryAddressPage(driver);
			delivery.deleteDeliveryAddress();

		} catch (Exception e) {
			test.log(LogStatus.FATAL, "Delete Delivery Address was unsuccessful");
			e.printStackTrace();
			Assert.fail(e.getMessage());
		}
	}

	@Test(priority = 10, enabled = true)
	public void resetPassword() {

		try {
			test = extent.startTest("Sprint 1 - Reset Password");
			System.out.println("Reset Password");
			Log.info("Reset Password");
			SignInPage signIn = new SignInPage(driver);
			signIn.resetPwd();

		} catch (Exception e) {
			CommonHelper.reportFailure("Reset Password was unsuccessful");
			e.printStackTrace();
			Assert.fail(e.getMessage());
		}
	}
}
