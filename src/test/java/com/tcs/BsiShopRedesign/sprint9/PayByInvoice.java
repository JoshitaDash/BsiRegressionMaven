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
import com.tcs.BsiShopRedesign.utilities.BsiConstants;
import com.tcs.BsiShopRedesign.utilities.CommonHelper;

public class PayByInvoice extends BaseTest {

	public PayByInvoice() throws Exception {
		super();
	}

	String url = BsiConstants.getEnvDetails().get("url");

	@Test(priority = 1, enabled = true)
	public void signInMember() {

		try {
			test = extent.startTest("Sprint 9 - Member User Sign In");
			System.out.println("Member Signing In");
			Log.info("Member Signing In");
			SignInPage signIn = new SignInPage(driver);
			signIn.memberNewLogin();
		} catch (Exception e) {
			test.log(LogStatus.FATAL, "Member Signing in was unsuccessful");
			CommonHelper.takeScreenShot();
			e.printStackTrace();
			Assert.fail(e.getMessage());
		}
	}

	@Test(priority = 2, enabled = true)
	public void payByInvoiceOrder() {

		try {
			test = extent
					.startTest("Sprint 9 - Ecom-27 AC#63,64,65,67 __ Place order with Pay By Invoice payment method");
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

			System.out.println("Enter Invoice Payment Details");
			Log.info("Enter Invoice Payment Details");
			test.log(LogStatus.INFO, "Enter Invoice Payment Details");
			CheckoutPage checkoutOrder = new CheckoutPage(driver);
			checkoutOrder.enterInvoicePaymentDetails();

			System.out.println("Enter Invoice Order Details");
			Log.info("Enter Invoice Order Details");
			test.log(LogStatus.INFO, "Enter Invoice Order Details");
			checkoutOrder.enterInvoiceOrderDetails();

			System.out.println("Verify Success Message on Order Confirmation Page");
			Log.info("Verify Success Message on Order Confirmation Page");
			test.log(LogStatus.INFO, "Verify Success Message on Order Confirmation Page");
			OrderConfirmationPage verifyMsg = new OrderConfirmationPage(driver);
			verifyMsg.verifyOrderSuccessMessage();

			/*
			 * System.out.println("Click Logout"); Log.info("Click Logout");
			 * home.clickLogout();
			 */

		} catch (Exception e) {
			test.log(LogStatus.FATAL, "Place order with Pay By Invoice payment method was unsuccessful");
			CommonHelper.reportFailure("Place order with Pay By Invoice payment method Page was unsuccessful");
			e.printStackTrace();
			Assert.fail(e.getMessage());
		}
	}

	@Test(priority = 3, enabled = true)
	public void verifyPayByInvoiceErrorMsg() {

		try {
			test = extent.startTest(
					"Sprint 9 - Ecom-27 AC#66 __ Verify Pay By Invoice payment error message for Insufficient Balance");

			System.out.println("Fetching the URL");
			driver.get(url);

			System.out.println("Perform Blank Search");
			Log.info("Perform Blank Search");
			HomePage home = new HomePage(driver);
			home.blankSearch();

			System.out.println("Verfiy search result");
			Log.info("Verfiy search result");
			SearchPage search = new SearchPage(driver);
			search.verifySearchResultforBlankSearch();

			Thread.sleep(2000);
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

			Log.info("Edit the Basket with Update Quantity");
			System.out.println("Edit the Basket with Update Quantity");
			BasketPage basket = new BasketPage(driver);
			basket.editBasketUpdateQuantity();

			System.out.println("Click Checkout Now");
			Log.info("Click Checkout Now");
			BasketPage checkout = new BasketPage(driver);
			checkout.clickCheckout();

			System.out.println("Verify Error Message for Insufficient Balance");
			Log.info("Verify Error Message for Insufficient Balance");
			test.log(LogStatus.INFO, "Verify Error Message for Insufficient Balance");
			CheckoutPage checkoutOrder = new CheckoutPage(driver);
			checkoutOrder.insufficientBalInvoice();

			System.out.println("Click Edit on Checkout Page");
			Log.info("Click Edit on Checkout Page");
			CheckoutPage editOrder = new CheckoutPage(driver);
			editOrder.clickEditOrder();

			System.out.println("Remove Membership from Basket");
			Log.info("Remove Membership from Basket");
			checkout.removeMultipleProduct();

			System.out.println("Click Logout");
			Log.info("Click Logout");
			home.clickLogout();

		} catch (Exception e) {
			test.log(LogStatus.FATAL,
					"Verification Pay By Invoice payment error message for Insufficient Balance was unsuccesful");
			CommonHelper.reportFailure(
					"Verification Pay By Invoice payment error message for Insufficient Balance was unsuccesful");
			e.printStackTrace();
			Assert.fail(e.getMessage());
		}

	}
}
