package com.tcs.BsiShopRedesign.sprint8;

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

public class EditOrderDetailsFromCheckout extends BaseTest {

	public EditOrderDetailsFromCheckout() throws Exception {
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
	public void verifyHardCopyDeliveryDetails() {

		try {
			test = extent
					.startTest("Sprint 8 - Ecom-52 AC#37,39 __ Edit Order for Hardcopy product from Checkout Page");
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
			search.selectHardCopyFormat();

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

			System.out.println("Click Edit on Checkout Page");
			Log.info("Click Edit on Checkout Page");
			CheckoutPage editOrder = new CheckoutPage(driver);
			editOrder.clickEditOrder();

			Log.info("Edit the Basket with Update Quantity");
			System.out.println("Edit the Basket with Update Quantity");
			test.log(LogStatus.INFO, "Edit the Basket with Update Quantity");
			checkout.editBasketUpdateQuantity();

			System.out.println("Click Checkout Now");
			Log.info("Click Checkout Now");
			checkout.clickCheckout();

			System.out.println("Enter Payment Details");
			Log.info("Enter Payment Details");
			test.log(LogStatus.INFO, "Enter Payment Details");
			CheckoutPage checkoutOrder = new CheckoutPage(driver);
			checkoutOrder.enterCardPaymentDetails();

			System.out.println("Enter Order Details");
			Log.info("Enter Order Details");
			test.log(LogStatus.INFO, "Enter Order Details");
			checkoutOrder.enterOrderDetails();

			System.out.println("Verify Success Message on Order Confirmation Page");
			Log.info("Verify Success Message on Order Confirmation Page");
			test.log(LogStatus.INFO, "Verify Success Message on Order Confirmation Page");
			OrderConfirmationPage verifyMsg = new OrderConfirmationPage(driver);
			verifyMsg.verifyOrderSuccessMessage();

		} catch (Exception e) {
			test.log(LogStatus.FATAL, "Edit Order for Hardcopy product from Checkout Page was unsuccessful");
			CommonHelper.reportFailure("Edit Order for Hardcopy product from Checkout Page was unsuccessful");
			e.printStackTrace();
			Assert.fail(e.getMessage());
		}
	}

}
