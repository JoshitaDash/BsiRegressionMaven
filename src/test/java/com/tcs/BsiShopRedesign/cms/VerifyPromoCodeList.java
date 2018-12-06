package com.tcs.BsiShopRedesign.cms;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.LogStatus;
import com.tcs.BsiShopRedesign.pages.CmsPage;
import com.tcs.BsiShopRedesign.pages.SignInPage;
import com.tcs.BsiShopRedesign.utilities.BaseTest;
import com.tcs.BsiShopRedesign.utilities.BsiConstants;
import com.tcs.BsiShopRedesign.utilities.CommonHelper;

public class VerifyPromoCodeList extends BaseTest {

	public VerifyPromoCodeList() throws Exception {
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
			test = extent.startTest("CMS - Ecom-15,16,17 AC#87,88  ___ Verify List of Promo Codes");

			System.out.println("Click on Reports Menu");
			Log.info("Click on Reports Menu");
			CmsPage customer = new CmsPage(driver);
			customer.clickReports();

			System.out.println("Select Date from Calendar");
			Log.info("Select Date from Calendar");
			customer.selectCalendarDate();

			System.out.println("Click Show Reports");
			Log.info("Click Show Reports");
			customer.clickShowReports();
			
			System.out.println("Verify List of Promo Codes");
			Log.info("Verify List of Promo Codes");
			customer.verifyPromoCodeList();
			
			System.out.println("Click Admin Logout");
			Log.info("Click Admin Logout");
			customer.clickAdminLogout();

		} catch (Exception e) {
			test.log(LogStatus.FATAL, "Verification of List of Promo Codes was unsuccessful");
			CommonHelper.reportFailure("Verification of List of Promo Codes was unsuccessful");
			e.printStackTrace();
			Assert.fail(e.getMessage());
		}
	}

}
