package com.tcs.BsiShopRedesign.cms;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.LogStatus;
import com.tcs.BsiShopRedesign.pages.CmsPage;
import com.tcs.BsiShopRedesign.pages.SignInPage;
import com.tcs.BsiShopRedesign.utilities.BaseTest;
import com.tcs.BsiShopRedesign.utilities.BsiConstants;
import com.tcs.BsiShopRedesign.utilities.CommonHelper;

public class CreateCMSPageWithBlocks extends BaseTest {

	public CreateCMSPageWithBlocks() throws Exception {
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
	public void createBlocks() {

		try {
			test = extent.startTest("CMS - CM-04,09 AC# 24___ Create and Delete Blocks in CMS Page");

			System.out.println("Click on Content Menu");
			Log.info("Click on Content Menu");
			CmsPage customer = new CmsPage(driver);
			customer.clickContent();

			System.out.println("Click Pages Submenu");
			Log.info("Click Pages Submenu");
			customer.clickPages();

			System.out.println("Create Folder on CMS Page");
			Log.info("Create Folder on CMS Page");
			String CMSPage = customer.createPage();
			
			/*System.out.println("Search CMS Page");
			Log.info("Search CMS Page");
			customer.searchCMSPage(CMSPage);

			System.out.println("Edit CMS Page");
			Log.info("Edit CMS Page");
			customer.previewCMSPage(CMSPage);

			System.out.println("Search CMS Page");
			Log.info("Search CMS Page");
			customer.searchCMSPage(CMSPage);

			System.out.println("Delete CMS Page");
			Log.info("Delete CMS Page");
			customer.deleteCMSPage();*/

		} catch (Exception e) {
			test.log(LogStatus.FATAL, "Create and Delete Blocks in CMS Page was unsuccessful");
			CommonHelper.takeScreenShot();
			e.printStackTrace();
			Assert.fail(e.getMessage());
		}
	}
}
