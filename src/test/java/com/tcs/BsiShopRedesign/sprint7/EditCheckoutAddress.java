package com.tcs.BsiShopRedesign.sprint7;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.LogStatus;
import com.tcs.BsiShopRedesign.pages.CheckoutPage;
import com.tcs.BsiShopRedesign.pages.HomePage;
import com.tcs.BsiShopRedesign.pages.SearchPage;
import com.tcs.BsiShopRedesign.pages.SignInPage;
import com.tcs.BsiShopRedesign.utilities.BaseTest;
import com.tcs.BsiShopRedesign.utilities.CommonHelper;

public class EditCheckoutAddress extends BaseTest {

	public EditCheckoutAddress() throws Exception {
		super();
	}

	@Test(priority = 1, enabled = true)
	public void signIn() {

		try {
			test = extent.startTest("Sprint 7 - Registered User Sign In");
			System.out.println("User Signing In");
			Log.info("User Signing In");
			SignInPage signIn = new SignInPage(driver);
			signIn.regUserLogin();
		}

		catch (Exception e) {
			test.log(LogStatus.FATAL, "Registered User Sign In was unsuccessful");
			CommonHelper.reportFailure("Registered User Sign In was unsuccessful");
			e.printStackTrace();
			Assert.fail(e.getMessage());
		}
	}

	@Test(priority = 2, enabled = true)
	public void editAddress() {

		try {
			System.out.println("Perform Blank Search");
			Log.info("Perform Blank Search");
			HomePage home = new HomePage(driver);
			home.blankSearch();

			System.out.println("Verfiy search result");
			Log.info("Verfiy search result");
			SearchPage search = new SearchPage(driver);
			search.verifySearchResultforBlankSearch();

			System.out.println("Click on Add to Basket from Search List");
			Log.info("Click on Add to Basket from Search List");
			test.log(LogStatus.INFO, "Click on Add to Basket from Search List");
			search.clickAddToBasket();

			System.out.println("Select Format and Click Ok");
			Log.info("Select Format and Click Ok");
			search.defaultFormatClickOK();

			System.out.println("Click Checkout from Mini Basket");
			Log.info("Click Checkout from Mini Basket");
			test.log(LogStatus.INFO, "Click Checkout from Mini Basket");
			CheckoutPage checkOut = new CheckoutPage(driver);
			checkOut.clickMiniCartCheckout();

		} catch (Exception e) {
			test.log(LogStatus.FATAL, "Edit Address in Checkout Page was unsuccessful");
			CommonHelper.reportFailure("Edit Address in Checkout Page was unsuccessful");
			e.printStackTrace();
			Assert.fail(e.getMessage());
		}
	}
}
