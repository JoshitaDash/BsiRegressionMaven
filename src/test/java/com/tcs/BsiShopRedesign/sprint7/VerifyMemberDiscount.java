package com.tcs.BsiShopRedesign.sprint7;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.LogStatus;
import com.tcs.BsiShopRedesign.pages.BasketPage;
import com.tcs.BsiShopRedesign.pages.HomePage;
import com.tcs.BsiShopRedesign.pages.SearchPage;
import com.tcs.BsiShopRedesign.pages.SignInPage;
import com.tcs.BsiShopRedesign.utilities.BaseTest;
import com.tcs.BsiShopRedesign.utilities.CommonHelper;

public class VerifyMemberDiscount extends BaseTest {

	public VerifyMemberDiscount() throws Exception {
		super();
	}

	@Test(priority = 1, enabled = true)
	public void signInMember() {

		try {
			test = extent.startTest("Sprint 7 - Member User Sign In");
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
	public void verifyMemberPrice() {

		test = extent.startTest(
				"Sprint 7 - Ecom-52 AC#31 __ Verify Member Price/Discount in Search List, Basket Page and Checkout Page");
		try {

			test.log(LogStatus.INFO, "Perform Blank Search");
			System.out.println("Perform Blank Search");
			Log.info("Perform Blank Search");
			HomePage home = new HomePage(driver);
			home.blankSearch();

			System.out.println("Verfiy search result");
			Log.info("Verfiy search result");
			SearchPage search = new SearchPage(driver);
			search.verifySearchResultforBlankSearch();

			test.log(LogStatus.INFO, "Verify Member Price in Search List");
			System.out.println("Verify Member Price in Search List");
			Log.info("Verify Member Price in Search List");
			SearchPage memPrice = new SearchPage(driver);
			memPrice.verifyMemPriceSearchList();

			Thread.sleep(1000);
			System.out.println("Click on Add to Basket from Search List");
			Log.info("Click on Add to Basket from Search List");
			test.log(LogStatus.INFO, "Click on Add to Basket from Search List");
			search.clickAddToBasket();

			System.out.println("Select Format and Click Ok");
			Log.info("Select Format and Click Ok");
			search.selectFormatClickOK();

			System.out.println("View Basket");
			Log.info("View Basket");
			test.log(LogStatus.INFO, "View Basket");
			search.viewBasket();

			test.log(LogStatus.INFO, "Verify Member Price in Basket Page");
			System.out.println("Verify Member Price in Basket Page");
			Log.info("Verify Member Price in Basket Page");
			BasketPage basketMemPrice = new BasketPage(driver);
			basketMemPrice.verifyMemPriceBasket();

			/*
			 * Log.info("Remove the Product"); System.out.println("Remove the Product");
			 * test.log(LogStatus.INFO, "Remove the Product");
			 * basketMemPrice.removeProduct();
			 */

			System.out.println("Click Logout");
			Log.info("Click Logout");
			home.clickLogout();

		} catch (Exception e) {
			test.log(LogStatus.FATAL, "Verification of Member Price was unsuccessful");
			CommonHelper.reportFailure("Verification of Member Price was unsuccessful");
			e.printStackTrace();
		}

	}
}
