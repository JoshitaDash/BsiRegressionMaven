package com.tcs.BsiShopRedesign.sprint8;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.LogStatus;
import com.tcs.BsiShopRedesign.pages.HomePage;
import com.tcs.BsiShopRedesign.pages.MyProfileMemberPage;
import com.tcs.BsiShopRedesign.pages.ProductPage;
import com.tcs.BsiShopRedesign.pages.SearchPage;
import com.tcs.BsiShopRedesign.pages.SignInPage;
import com.tcs.BsiShopRedesign.utilities.BaseTest;
import com.tcs.BsiShopRedesign.utilities.CommonHelper;

public class VerifyMemberDetails extends BaseTest {

	public VerifyMemberDetails() throws Exception {
		super();
	}

	@Test(priority = 1, enabled = true)
	public void signInMember() {

		try {
			test = extent.startTest("Sprint 8 - Member User Sign In");
			System.out.println("Member Signing In");
			Log.info("Member Signing In");
			SignInPage signIn = new SignInPage(driver);
			signIn.memberNewLogin();
		}

		catch (Exception e) {
			test.log(LogStatus.FATAL, "Member Signing in was unsuccessful");
			CommonHelper.reportFailure("Member Signing in was unsuccessful");
			e.printStackTrace();
			Assert.fail(e.getMessage());
		}

	}

	@Test(priority = 2, enabled = true)
	public void verifyMemberLink() {

		try {
			test = extent.startTest("Sprint 8 - Ecom-05 AC#17 __ Verify Member Link");
			System.out.println("Perform Blank Search");
			Log.info("Perform Blank Search");
			HomePage home = new HomePage(driver);
			home.blankSearch();

			System.out.println("Verfiy search result");
			Log.info("Verfiy search result");
			SearchPage search = new SearchPage(driver);
			search.verifySearchResultforBlankSearch();

			System.out.println("Click on Product");
			Log.info("Click on Product");
			search.clickProductOnSearchList();

			System.out.println("Verify Member Link");
			Log.info("Verify Member Link");
			ProductPage prod = new ProductPage(driver);
			prod.verifyMemberLink();

		} catch (Exception e) {
			test.log(LogStatus.FATAL, "Verify Member Link was unsuccessful");
			CommonHelper.reportFailure("Verify Member Link was unsuccessful");
			e.printStackTrace();
			Assert.fail(e.getMessage());
		}

	}

	@Test(priority = 3, enabled = true)
	public void enterEmailID() {

		test = extent.startTest("Sprint 8 - Ecom-05 AC#21 __ Enter Email ID in Member Benefits Tab");
		try {

			System.out.println("Click on My Profile");
			Log.info("Click on My Profile");
			HomePage myProfile = new HomePage(driver);
			myProfile.clickMyProfile();

			System.out.println("Click on Member Tab");
			Log.info("Click on Member Tab");
			MyProfileMemberPage mem = new MyProfileMemberPage(driver);
			mem.clickMemberTab();

			System.out.println("Enter Email ID");
			Log.info("Enter Email ID");
			mem.enterEmailID();

			System.out.println("Click on Send");
			Log.info("Click on Send");
			mem.clickSend();

			System.out.println("Verify Success Message");
			Log.info("Verify Success Message");
			mem.verifySuccessMsg();

			System.out.println("Click Logout");
			Log.info("Click Logout");
			HomePage home = new HomePage(driver);
			home.clickLogout();

		} catch (Exception e) {
			test.log(LogStatus.FATAL, "Enter Email ID was unsuccessful");
			CommonHelper.reportFailure("Enter Email ID was unsuccessful");
			e.printStackTrace();
			Assert.fail(e.getMessage());
		}

	}
}
