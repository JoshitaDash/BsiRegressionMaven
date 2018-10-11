package com.tcs.BsiShopRedesign.sprint8;

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
import com.tcs.BsiShopRedesign.utilities.BsiConstants;
import com.tcs.BsiShopRedesign.utilities.CommonHelper;

public class VerifyHardCopyDetails extends BaseTest {

	public VerifyHardCopyDetails() throws Exception {
		super();
	}

	String url = BsiConstants.getEnvDetails().get("url");

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
			test = extent.startTest(
					"Sprint 8 - ECom-20,ECom- 21,Ecom-24 -AC# 84; Ecom-52 AC#33,41 __ Verify HardCopy Delivery Details from Order History Page and Order Confirmation Page");
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

			System.out.println("Verify Hard Copy Details in Order Confirmation Page");
			Log.info("Verify Hard Copy Details in Order Confirmation Page");
			OrderConfirmationPage hardCopy = new OrderConfirmationPage(driver);
			hardCopy.verifyHardCopyDetails();

			/*
			 * System.out.println("Fetching the URL"); driver.get(url);
			 */

			System.out.println("Click on My Profile");
			Log.info("Click on My Profile");
			HomePage myProfile = new HomePage(driver);
			myProfile.clickMyProfile();

			System.out.println("Click on Order History Tab");
			Log.info("Click on Order History Tab");
			OrderHistoryPage order = new OrderHistoryPage(driver);
			order.clickOrderHistoryTab();

			System.out.println("Verify Order Status");
			Log.info("Verify Order Status");
			order.verifyOrderStatus();

			System.out.println("Click on View Order");
			Log.info("Click on View Order");
			order.clickViewOrder();

			System.out.println("Verify Hard Copy Details in Order History Page");
			Log.info("Verify Hard Copy Details in Order History Page");
			order.verifyHardCopyDetails();

		} catch (Exception e) {
			test.log(LogStatus.FATAL, "Verify HardCopy Delivery details from Order History Page was unsuccessful");
			CommonHelper.reportFailure("Verify HardCopy Delivery details from Order History Page was unsuccessful");
			e.printStackTrace();
			Assert.fail(e.getMessage());
		}
	}
}
