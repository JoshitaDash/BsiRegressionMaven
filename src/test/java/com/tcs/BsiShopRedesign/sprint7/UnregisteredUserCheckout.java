package com.tcs.BsiShopRedesign.sprint7;

import org.testng.Assert;
import org.testng.annotations.Test;
import com.relevantcodes.extentreports.LogStatus;
import com.tcs.BsiShopRedesign.pages.CheckoutPage;
import com.tcs.BsiShopRedesign.pages.HomePage;
import com.tcs.BsiShopRedesign.pages.OrderConfirmationPage;
import com.tcs.BsiShopRedesign.pages.SearchPage;
import com.tcs.BsiShopRedesign.utilities.BaseTest;
import com.tcs.BsiShopRedesign.utilities.CommonHelper;

public class UnregisteredUserCheckout extends BaseTest {

	public UnregisteredUserCheckout() throws Exception {
		super();
	}

	@Test(priority = 1, enabled = true)
	public void CheckLoginAlertOnChekout() {

		test = extent.startTest("Sprint 7 - Ecom-52 AC#32,38; Ecom-25 AC#56,58 __ Verify Login Alert for Unregistered User on Clicking Checkout");
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
			search.selectFormatClickOK();

			System.out.println("Click Checkout from Mini Basket");
			Log.info("Click Checkout from Mini Basket");
			test.log(LogStatus.INFO, "Click Checkout from Mini Basket");
			CheckoutPage checkOut = new CheckoutPage(driver);
			checkOut.clickMiniCartCheckout();

			System.out.println("Enter Credentials and Sign In");
			Log.info("Enter Credentials and Sign In");
			test.log(LogStatus.INFO, "Enter Credentials and Sign In");
			checkOut.signIn();

			System.out.println("Enter Payment Details");
			Log.info("Enter Payment Details");
			test.log(LogStatus.INFO, "Enter Payment Details");
			checkOut.enterCardPaymentDetails();

			System.out.println("Enter Order Details");
			Log.info("Enter Order Details");
			test.log(LogStatus.INFO, "Enter Order Details");
			checkOut.enterOrderDetails();

			/*System.out.println("Confirm Order Details");
			Log.info("Confirm Order Details");
			test.log(LogStatus.INFO, "Confirm Order Details");
			checkOut.confirmOrderDetails();*/
			
			System.out.println("Verify Success Message on Order Confirmation Page");
			Log.info("Verify Success Message on Order Confirmation Page");
			test.log(LogStatus.INFO, "Verify Success Message on Order Confirmation Page");
			OrderConfirmationPage verifyMsg = new OrderConfirmationPage(driver);
			verifyMsg.verifyOrderSuccessMessage();

			System.out.println("Click Logout");
			Log.info("Click Logout");
			test.log(LogStatus.INFO, "Click Logout");
			home.clickLogout();

		} catch (Exception e) {
			test.log(LogStatus.FATAL,
					"Verification of Credentials for Unregistered user on clicking checkout was unsuccessful");
			CommonHelper.reportFailure(
					"Verification of Credentials for Unregistered user on clicking checkout was unsuccessful");
			e.printStackTrace();
			Assert.fail(e.getMessage());
		}
	}
}