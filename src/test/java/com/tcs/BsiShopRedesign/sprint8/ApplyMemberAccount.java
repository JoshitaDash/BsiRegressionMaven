package com.tcs.BsiShopRedesign.sprint8;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.LogStatus;
import com.tcs.BsiShopRedesign.pages.BasketPage;
import com.tcs.BsiShopRedesign.pages.CheckoutPage;
import com.tcs.BsiShopRedesign.pages.HomePage;
import com.tcs.BsiShopRedesign.pages.MembershipPage;
import com.tcs.BsiShopRedesign.pages.MyProfileMemberPage;
import com.tcs.BsiShopRedesign.pages.ProductPage;
import com.tcs.BsiShopRedesign.pages.SearchPage;
import com.tcs.BsiShopRedesign.pages.SignInPage;
import com.tcs.BsiShopRedesign.utilities.BaseTest;
import com.tcs.BsiShopRedesign.utilities.CommonHelper;

public class ApplyMemberAccount extends BaseTest {

	public ApplyMemberAccount() throws Exception {
		super();
	}

	@Test(priority = 1, enabled = true)
	public void signIn() {

		try {
			test = extent.startTest("Sprint 8 - Registered User Sign In");
			System.out.println("User Signing In");
			Log.info("User Signing In");
			SignInPage signIn = new SignInPage(driver);
			signIn.login();
		}

		catch (Exception e) {
			test.log(LogStatus.FATAL, "Registered User Sign In was unsuccessful");
			CommonHelper.reportFailure("Registered User Sign In was unsuccessful");
			e.printStackTrace();
			Assert.fail(e.getMessage());
		}
	}

	@Test(priority = 2, enabled = true)
	public void applyMemberAccountBelowBandNine() {

		try {
			test = extent.startTest("Sprint 8 - Ecom-05 AC#14,15,18,19 __ Apply for Membership account below Band 9");
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

			System.out.println("Apply for Membership");
			Log.info("Apply for Membership");
			ProductPage prod = new ProductPage(driver);
			prod.applyMembership();

			System.out.println("Enter Membership Details");
			Log.info("Enter Membership Details");
			MembershipPage member = new MembershipPage(driver);
			member.enterMembershipDetails();

			System.out.println("Add Product to Basket");
			Log.info("Add Product to Basket");
			member.addToBasket();

			System.out.println("Click Checkout Now");
			Log.info("Click Checkout Now");
			BasketPage checkout = new BasketPage(driver);
			checkout.clickCheckout();

			System.out.println("Verify Membership Details in Checkout Page");
			Log.info("Verify Membership Details in Checkout Page");
			CheckoutPage memDetails = new CheckoutPage(driver);
			memDetails.verifyMemberDetails();

			System.out.println("Click Continue Shopping");
			Log.info("Click Continue Shopping");
			memDetails.clickContinueShopping();

			System.out.println("Remove Membership from Basket");
			Log.info("Remove Membership from Basket");
			checkout.removeProduct();

		} catch (Exception e) {
			CommonHelper.reportFailure("Membership Application for below Band 9 was unsuccessful");
			e.printStackTrace();
		}

	}

	@Test(priority = 3, enabled = true)
	public void applyMemberAccountBandNineAbove() {

		try {
			test = extent.startTest("Sprint 8 - Ecom-05 AC#16 __ Apply for Membership account above Band 9");
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

			System.out.println("Verfiy Member Price");
			Log.info("Verfiy Member Price");
			ProductPage prod = new ProductPage(driver);
			prod.applyMembership();

			System.out.println("Enter Membership Details");
			Log.info("Enter Membership Details");
			MembershipPage member = new MembershipPage(driver);
			member.enterMembershipDetailsAboveBandNine();

			System.out.println("Verify Membership Message for Band 9 and above");
			Log.info("Verify Membership Message for Band 9 and above");
			member.verifyMemberMessage();

		} catch (Exception e) {
			CommonHelper.reportFailure("Membership Application for above Band 9 was unsuccessful");
			e.printStackTrace();
		}
	}

	@Test(priority = 4, enabled = false)
	public void validateErrorMsgMemberNumber() {

		try {
			test = extent.startTest("Sprint 8 - Ecom-39 AC#20 __ Validate Error Message for Membership Number");
			System.out.println("Click on My Profile");
			Log.info("Click on My Profile");
			HomePage myProfile = new HomePage(driver);
			myProfile.clickMyProfile();

			System.out.println("Enter Membership Number");
			Log.info("Enter Membership Number");
			MyProfileMemberPage mem = new MyProfileMemberPage(driver);
			mem.enterMemNum();

			System.out.println("Verify Member Number Error Message");
			Log.info("Verify Member Number Error Message");
			mem.verifyErrorMsg();

			System.out.println("Click Logout");
			Log.info("Click Logout");
			myProfile.clickLogout();

		} catch (Exception e) {
			e.printStackTrace();
		}

	}
}
