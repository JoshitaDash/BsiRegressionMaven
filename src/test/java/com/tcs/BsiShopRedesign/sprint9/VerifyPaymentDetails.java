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

public class VerifyPaymentDetails extends BaseTest {

	public VerifyPaymentDetails() throws Exception {
		super();
	}

	@Test(priority = 1, enabled = true)
	public void signInMember() {

		try {
			test = extent.startTest("Sprint 9 - Member User Sign In");
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
	public void verifyIncorrectCardPayment() {

		test = extent.startTest("Sprint 9 - Ecom----- AC#---- __ Verify Card Payment Details with incorrect entries");
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
			String searchMemDisc = memPrice.verifyMemPriceSearchList();

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
			basketMemPrice.verifyMemPriceBasket(searchMemDisc);

			System.out.println("Click Checkout Now");
			Log.info("Click Checkout Now");
			BasketPage checkout = new BasketPage(driver);
			checkout.clickCheckout();

			test.log(LogStatus.INFO, "Verify Member Price in Checkout Page");
			System.out.println("Verify Member Price in Checkout Page");
			Log.info("Verify Member Price in Checkout Page");
			CheckoutPage checkoutMemPrice = new CheckoutPage(driver);
			checkoutMemPrice.verifyMemPriceCheckout(searchMemDisc);

			System.out.println("Enter Incorrect Payment Details");
			Log.info("Enter Incorrect Payment Details");
			test.log(LogStatus.INFO, "Enter Incorrect Payment Details");
			CheckoutPage order = new CheckoutPage(driver);
			order.verifyIncorrectCardPaymentDetails();

			System.out.println("Enter Payment Details");
			Log.info("Enter Payment Details");
			test.log(LogStatus.INFO, "Enter Payment Details");
			order.enterValidCardPaymentDetails();

			System.out.println("Click Review Order");
			Log.info("Click Review Order");
			test.log(LogStatus.INFO, "Click Review Order");
			order.clickReviewOrder();

			Thread.sleep(5000);
			System.out.println("Verify Member Price in Review Order Page");
			Log.info("Verify Member Price in Review Order Page");
			test.log(LogStatus.INFO, "Verify Member Price in Review Order Page");
			order.verifyReviewOrderMemberPrice(searchMemDisc);

			System.out.println("Confirm Order Details");
			Log.info("Confirm Order Details");
			test.log(LogStatus.INFO, "Confirm Order Details");
			order.confirmOrderDetailsOnly();

			System.out.println("Verify Success Message on Order Confirmation Page");
			Log.info("Verify Success Message on Order Confirmation Page");
			test.log(LogStatus.INFO, "Verify Success Message on Order Confirmation Page");
			OrderConfirmationPage softcopy = new OrderConfirmationPage(driver);
			softcopy.verifyOrderSuccessMessage();

		} catch (Exception e) {
			test.log(LogStatus.FATAL, "Verification of Card Payment Details with incorrect entries was unsuccessful");
			CommonHelper.reportFailure("Verification of Card Payment Details with incorrect entries was unsuccessful");
			e.printStackTrace();
			Assert.fail(e.getMessage());
		}
	}
}
