package com.tcs.BsiShopRedesign.sprint1;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.LogStatus;
import com.tcs.BsiShopRedesign.pages.BillingAddressPage;
import com.tcs.BsiShopRedesign.pages.DeliveryAddressPage;
import com.tcs.BsiShopRedesign.pages.SignInPage;
import com.tcs.BsiShopRedesign.utilities.BaseTest;
import com.tcs.BsiShopRedesign.utilities.CommonHelper;

public class MyProfileAddTenAddresses extends BaseTest {

	public MyProfileAddTenAddresses() throws Exception {
		super();
	}

	@Test(priority = 1, enabled = true)
	public void signIn() {

		try {
			test = extent.startTest("Sprint 1 - Registered User Sign In");
			System.out.println("User Signing In");
			Log.info("User Signing In");
			SignInPage signIn = new SignInPage(driver);
			signIn.loginTenAddress();
		}

		catch (Exception e) {
			test.log(LogStatus.FATAL, "Login unsuccessful");
			CommonHelper.reportFailure("Login unsuccessful");
			e.printStackTrace();
			Assert.fail(e.getMessage());
		}
	}

	@Test(priority = 2, enabled = true)
	public void addTenBillingAddress() {

		try {
			test = extent.startTest("Sprint 1 - Ecom-45_46A AC#30 ___ Add Ten Billing Address");
			System.out.println("Add Ten Billing Address");
			Log.info("Add Ten Billing Address");
			BillingAddressPage billTen = new BillingAddressPage(driver);
			billTen.addTenNewBillingAddress();

		}

		catch (Exception e) {
			e.printStackTrace();
			test.log(LogStatus.FATAL, "Adding Ten Billing Address was unsuccessful");
			CommonHelper.reportFailure("Adding Ten Billing Address was unsuccessful");
			Assert.fail(e.getMessage());
		}
	}

	@Test(priority = 3, enabled = true)
	public void deleteTenBillingAddress() {

		try {
			test = extent.startTest("Sprint 1 - Ecom-45_46A AC#30 ___ Delete Ten Billing Address");
			System.out.println("Delete Ten Billing Address");
			Log.info("Delete Ten Billing Address");
			BillingAddressPage billTen = new BillingAddressPage(driver);
			billTen.deleteTenBillingAddress();

		} catch (Exception e) {
			e.printStackTrace();
			test.log(LogStatus.FATAL, "Delete Ten Billing Address was unsuccessful");
			CommonHelper.reportFailure("Delete Ten Billing Address was unsuccessful");
			Assert.fail(e.getMessage());
		}

	}

	@Test(priority = 4, enabled = true)
	public void addTenDeliveryAddress() {

		try {
			test = extent.startTest("Sprint 1 - Ecom-45_46A AC#29 ___ Add Ten Delivery Address");
			System.out.println("Add Ten Delivery Address");
			Log.info("Add Ten Delivery Address");
			DeliveryAddressPage deliveryTen = new DeliveryAddressPage(driver);
			deliveryTen.addTenNewDeliveryAddress();

		}

		catch (Exception e) {
			test.log(LogStatus.FATAL, "Delviery Address addition was unsuccessful");
			CommonHelper.reportFailure("Delviery Address addition was unsuccessful");
			e.printStackTrace();
			Assert.fail(e.getMessage());
		}
	}

	@Test(priority = 5, enabled = true)
	public void deleteTenDeliveryAddress() {

		try {
			test = extent.startTest("Sprint 1 - Ecom-45_46A AC#29 ___ Delete Ten Delivery Address");
			System.out.println("Delete Ten Delivery Address");
			Log.info("Delete Ten Delivery Address");
			DeliveryAddressPage deliveryTen = new DeliveryAddressPage(driver);
			deliveryTen.deleteTenDeliveryAddress();

		} catch (Exception e) {
			test.log(LogStatus.FATAL, "Delviery Address deletion was unsuccessful");
			CommonHelper.reportFailure("Delviery Address deletion was unsuccessful");
			e.printStackTrace();
			Assert.fail(e.getMessage());
		}
	}

}
