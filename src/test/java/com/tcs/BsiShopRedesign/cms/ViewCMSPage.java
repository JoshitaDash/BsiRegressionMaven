package com.tcs.BsiShopRedesign.cms;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.LogStatus;
import com.tcs.BsiShopRedesign.pages.CmsPage;
import com.tcs.BsiShopRedesign.pages.SignInPage;
import com.tcs.BsiShopRedesign.utilities.BaseTest;
import com.tcs.BsiShopRedesign.utilities.BsiConstants;
import com.tcs.BsiShopRedesign.utilities.CommonHelper;

public class ViewCMSPage extends BaseTest {

	public ViewCMSPage() throws Exception {
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
			test = extent.startTest("CMS - Ecom-24  ___ View CMS Content Page");

			System.out.println("Click on Content Menu");
			Log.info("Click on Content Menu");
			CmsPage customer = new CmsPage(driver);
			customer.clickContent();

			System.out.println("Click Pages Submenu");
			Log.info("Click Pages Submenu");
			customer.clickPages();
			
			System.out.println("Search Page");
			Log.info("Search Page");
			customer.searchPage();
			
			System.out.println("View CMS Content Page");
			Log.info("View CMS Content Page");
			customer.viewCMSContentPage();

		} catch (Exception e) {
			test.log(LogStatus.FATAL, "View CMS Content Page was unsuccessful");
			CommonHelper.reportFailure("View CMS Content Page was unsuccessful");
			e.printStackTrace();
			Assert.fail(e.getMessage());
		}
	}
}
