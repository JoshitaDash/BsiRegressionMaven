package com.tcs.BsiShopRedesign.cms;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.LogStatus;
import com.tcs.BsiShopRedesign.pages.CmsPage;
import com.tcs.BsiShopRedesign.pages.SignInPage;
import com.tcs.BsiShopRedesign.utilities.BaseTest;
import com.tcs.BsiShopRedesign.utilities.BsiConstants;
import com.tcs.BsiShopRedesign.utilities.CommonHelper;

public class VerifyCmsDetails extends BaseTest {

	public VerifyCmsDetails() throws Exception {
		super();
	}

	String adminURL = BsiConstants.getEnvDetails().get("adminURL");

	@Test(priority = 1, enabled = true)
	public void signInCms() {

		try {
			test = extent.startTest("CMS - Admin User Sign In");
			test.log(LogStatus.INFO, "URL: " + adminURL);
			System.out.println("Admin Signing In");
			Log.info("Admin Signing In");
			SignInPage signIn = new SignInPage(driver);
			signIn.adminLogin();
		} catch (Exception e) {
			test.log(LogStatus.FATAL, "Admin Signing in was unsuccessful");
			CommonHelper.takeScreenShot();
			e.printStackTrace();
			Assert.fail(e.getMessage());
		}
	}

	@Test(priority = 2, enabled = true)
	public void verifyCmsDetails() {

		try {
			test = extent.startTest("CMS - Ecom 1,2,4 AC#1,2,3,4 ___ Verify Customer Details");

			System.out.println("Search Customer Details");
			Log.info("Search Customer Details");
			CmsPage customer = new CmsPage(driver);
			customer.searchCustomerDetails();

			System.out.println("Edit Customer Details");
			Log.info("Edit Customer Details");
			customer.editCustomerDetails();

			System.out.println("Verify Customer View Details");
			Log.info("Verify Customer View Details");
			customer.verifyCustomerViewDetails();

			System.out.println("Verify Customer Account Information");
			Log.info("Verify Customer Account Information");
			customer.verifyAccountInfo();

			System.out.println("Verify Customer Addresses");
			Log.info("Verify Customer Addresses");
			customer.verifyAddresses();
			
			System.out.println("Verify Customer Orders");
			Log.info("Verify Customer Orders");
			customer.verifyOrders();

		} catch (Exception e) {
			test.log(LogStatus.FATAL, "Verify Customer Details was unsuccessful");
			CommonHelper.takeScreenShot();
			e.printStackTrace();
			Assert.fail(e.getMessage());
		}
	}
}
