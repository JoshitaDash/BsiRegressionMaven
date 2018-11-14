package com.tcs.BsiShopRedesign.sprint9;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.LogStatus;
import com.tcs.BsiShopRedesign.pages.BasketPage;
import com.tcs.BsiShopRedesign.pages.CheckoutPage;
import com.tcs.BsiShopRedesign.pages.HomePage;
import com.tcs.BsiShopRedesign.pages.OrderConfirmationPage;
import com.tcs.BsiShopRedesign.pages.OrderHistoryPage;
import com.tcs.BsiShopRedesign.pages.SearchPage;
import com.tcs.BsiShopRedesign.pages.SignInPage;
import com.tcs.BsiShopRedesign.utilities.BaseTest;
import com.tcs.BsiShopRedesign.utilities.CommonHelper;

public class ViewPDFInvoice extends BaseTest {

	public ViewPDFInvoice() throws Exception {
		super();
	}

	@Test(priority = 1, enabled = true)
	public void signIn() {

		try {
			test = extent.startTest("Sprint 9 - Registered User Sign In");
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
	public void applyPromoCode() {
		try {
			test = extent.startTest("Sprint 9 - Ecom-34 AC#76 __ View PDF Invoice from Order History Page");

			System.out.println("Perform Blank Search");
			Log.info("Perform Blank Search");
			HomePage home = new HomePage(driver);
			home.blankSearch();

			System.out.println("Verfiy search result");
			Log.info("Verfiy search result");
			SearchPage search = new SearchPage(driver);
			search.verifySearchResultforBlankSearch();

			Thread.sleep(1000);
			System.out.println("Click on Add to Basket from Search List");
			Log.info("Click on Add to Basket from Search List");
			test.log(LogStatus.INFO, "Click on Add to Basket from Search List");
			search.clickAddToBasket();

			System.out.println("Select PDF Format and Click Ok");
			Log.info("Select PDF Format and Click Ok");
			search.selectFormatClickOK();

			System.out.println("View Basket");
			Log.info("View Basket");
			test.log(LogStatus.INFO, "View Basket");
			search.viewBasket();

			System.out.println("Click Checkout Now");
			Log.info("Click Checkout Now");
			BasketPage checkout = new BasketPage(driver);
			checkout.clickCheckout();

			System.out.println("Enter Card Payment Details");
			Log.info("Enter Card Payment Details");
			test.log(LogStatus.INFO, "Enter Card Payment Details");
			CheckoutPage order = new CheckoutPage(driver);
			order.enterCardPaymentDetails();

			System.out.println("Click Review Order");
			Log.info("Click Review Order");
			test.log(LogStatus.INFO, "Click Review Order");
			order.clickReviewOrder();

			System.out.println("Confirm Order Details");
			Log.info("Confirm Order Details");
			test.log(LogStatus.INFO, "Confirm Order Details");
			order.confirmOrderDetailsOnly();

			System.out.println("Verify Success Message on Order Confirmation Page");
			Log.info("Verify Success Message on Order Confirmation Page");
			test.log(LogStatus.INFO, "Verify Success Message on Order Confirmation Page");
			OrderConfirmationPage verifyMsg = new OrderConfirmationPage(driver);
			verifyMsg.verifyOrderSuccessMessage();

			System.out.println("Click on My Profile");
			Log.info("Click on My Profile");
			HomePage myProfile = new HomePage(driver);
			myProfile.clickMyProfile();

			System.out.println("Click on Order History Tab");
			Log.info("Click on Order History Tab");
			OrderHistoryPage orderHistory = new OrderHistoryPage(driver);
			orderHistory.clickOrderHistoryTab();

			System.out.println("Verify PDF Order Status");
			Log.info("Verify PDF Order Status");
			orderHistory.verifyPDFOrderStatus();

			System.out.println("Click on View Order");
			Log.info("Click on View Order");
			orderHistory.clickViewOrder();
			
			System.out.println("View PDF Invoice");
			Log.info("View PDF Invoice");
			orderHistory.viewPDFInvoice();

			System.out.println("Click Logout");
			Log.info("Click Logout");
			home.clickLogout();
			
		} catch (Exception e) {
			test.log(LogStatus.FATAL, "View PDF Invoice from Order History Page was unsuccessful");
			CommonHelper.reportFailure("View PDF Invoice from Order History Page was unsuccessful");
			e.printStackTrace();
			Assert.fail(e.getMessage());
		}
	}

}
