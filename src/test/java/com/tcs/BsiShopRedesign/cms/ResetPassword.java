package com.tcs.BsiShopRedesign.cms;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.LogStatus;
import com.tcs.BsiShopRedesign.pages.CmsPage;
import com.tcs.BsiShopRedesign.pages.SignInPage;
import com.tcs.BsiShopRedesign.utilities.BaseTest;
import com.tcs.BsiShopRedesign.utilities.BsiConstants;
import com.tcs.BsiShopRedesign.utilities.CommonHelper;

public class ResetPassword extends BaseTest {

	public ResetPassword() throws Exception {
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
			CommonHelper.reportFailure("Admin Signing in was unsuccessful");
			e.printStackTrace();
			Assert.fail(e.getMessage());
		}
	}

	@Test(priority = 2, enabled = true)
	public void verifyCmsDetails() {

		try {
			test = extent.startTest("CMS - Req ID-5 AC#1  ___ Verify Reset Password");

			System.out.println("Search Customer Details");
			Log.info("Search Customer Details");
			CmsPage customer = new CmsPage(driver);
			customer.blankSearchCustomerDetails();

			System.out.println("Edit Customer Details");
			Log.info("Edit Customer Details");
			customer.editCustomerDetails();

			System.out.println("Verify Reset Password");
			Log.info("Verify Reset Password");
			customer.verifyResetPwd();

		} catch (Exception e) {
			test.log(LogStatus.FATAL, "Verify Customer Details was unsuccessful");
			CommonHelper.reportFailure("Verify Customer Details was unsuccessful");
			e.printStackTrace();
			Assert.fail(e.getMessage());
		}
	}

}
