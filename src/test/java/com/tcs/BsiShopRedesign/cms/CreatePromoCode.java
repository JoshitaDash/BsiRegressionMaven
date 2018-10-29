package com.tcs.BsiShopRedesign.cms;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.LogStatus;
import com.tcs.BsiShopRedesign.pages.CmsPage;
import com.tcs.BsiShopRedesign.pages.SignInPage;
import com.tcs.BsiShopRedesign.utilities.BaseTest;
import com.tcs.BsiShopRedesign.utilities.BsiConstants;
import com.tcs.BsiShopRedesign.utilities.CommonHelper;

public class CreatePromoCode extends BaseTest {

	public CreatePromoCode() throws Exception {
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
			test = extent.startTest("CMS - Ecom-15 AC#86  ___ Create Promocode with Special Character");

			System.out.println("Click on Marketing Menu");
			Log.info("Click on Marketing Menu");
			CmsPage customer = new CmsPage(driver);
			customer.clickMarketing();

			System.out.println("Click Add New Rule");
			Log.info("Click Add New Rule");
			customer.clickAddNewRule();

			System.out.println("Enter Promo Code Details");
			Log.info("Enter Promo Code Details");
			test.log(LogStatus.INFO, "Enter Promo Code Details");
			customer.enterPromoCodeDetails();

		} catch (Exception e) {
			test.log(LogStatus.FATAL, "Create Promocode with Special Character was unsuccessful");
			CommonHelper.reportFailure("Create Promocode with Special Character was unsuccessful");
			e.printStackTrace();
			Assert.fail(e.getMessage());
		}
	}
}
