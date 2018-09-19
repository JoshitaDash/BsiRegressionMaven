package com.tcs.BsiShopRedesign.sprint9;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.LogStatus;
import com.tcs.BsiShopRedesign.pages.BasketPage;
import com.tcs.BsiShopRedesign.pages.CheckoutPage;
import com.tcs.BsiShopRedesign.pages.HomePage;
import com.tcs.BsiShopRedesign.pages.OrderConfirmationPage;
import com.tcs.BsiShopRedesign.pages.SearchPage;
import com.tcs.BsiShopRedesign.pages.SignInPage;
import com.tcs.BsiShopRedesign.utilities.BaseTest;
import com.tcs.BsiShopRedesign.utilities.CommonHelper;

public class PromoCodeOrder extends BaseTest {

	public PromoCodeOrder() throws Exception {
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
		// WebDriverWait wait = new WebDriverWait(driver, 120);

		try {
			test = extent.startTest("Sprint 9 - Ecom-15 AC#53,54,55 __ Apply Promo Code and Verify Discount");

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
			
			Thread.sleep(5000);
			System.out.println("Click on Add to Basket from Search List");
			Log.info("Click on Add to Basket from Search List");
			test.log(LogStatus.INFO, "Click on Add to Basket from Search List");
			search.clickAddToBasketAgain();
			
			System.out.println("Select Hardcopy Format and Click Ok");
			Log.info("Select Hardcopy Format and Click Ok");
			search.selectHardCopyFormat();
			
			System.out.println("Click Ok");
			Log.info("Click Ok");
			search.selectFormatClickOK();

			System.out.println("View Basket");
			Log.info("View Basket");
			test.log(LogStatus.INFO, "View Basket");
			search.viewBasket();

			System.out.println("Click Checkout Now");
			Log.info("Click Checkout Now");
			BasketPage checkout = new BasketPage(driver);
			checkout.clickCheckout();

			System.out.println("Enter Promo Code");
			Log.info("Enter Promo Code");
			CheckoutPage order = new CheckoutPage(driver);
			order.enterPromoCode();

			System.out.println("Verify Order Summary for Discount on Checkout Page");
			Log.info("Verify Order Summary for Discount on Checkout Page");
			order.verifyOrderSummaryDiscount();

			System.out.println("Enter Card Payment Details");
			Log.info("Enter Card Payment Details");
			test.log(LogStatus.INFO, "Enter Card Payment Details");
			order.enterCardPaymentDetails();

			System.out.println("Click Review Order");
			Log.info("Click Review Order");
			test.log(LogStatus.INFO, "Click Review Order");
			order.clickReviewOrder();

			System.out.println("Verify Review Order Details for Discount");
			Log.info("Verify Review Order Details for Discount");
			test.log(LogStatus.INFO, "Verify Review Order Details for Discount");
			order.verifyReviewOrderDetails();

			System.out.println("Confirm Order Details");
			Log.info("Confirm Order Details");
			test.log(LogStatus.INFO, "Confirm Order Details");
			order.confirmOrderDetailsOnly();

			System.out.println("Verify Success Message on Order Confirmation Page");
			Log.info("Verify Success Message on Order Confirmation Page");
			test.log(LogStatus.INFO, "Verify Success Message on Order Confirmation Page");
			OrderConfirmationPage verifyMsg = new OrderConfirmationPage(driver);
			verifyMsg.verifyOrderSuccessMessage();

			System.out.println("Verify Discount on Order Confirmation Page");
			Log.info("Verify Discount on Order Confirmation Page");
			test.log(LogStatus.INFO, "Verify Discount on Order Confirmation Page");
			verifyMsg.verifyOrderDetailsDiscount();

		} catch (Exception e) {
			test.log(LogStatus.FATAL, "Apply Promo Code and verify discount was unsuccessful");
			CommonHelper.reportFailure("Apply Promo Code and verify discount was unsuccessful");
			e.printStackTrace();
			Assert.fail(e.getMessage());
		}
	}
}
