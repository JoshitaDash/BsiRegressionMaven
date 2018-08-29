package com.tcs.BsiShopRedesign.sprint8;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.LogStatus;
import com.tcs.BsiShopRedesign.pages.BasketPage;
import com.tcs.BsiShopRedesign.pages.CheckoutPage;
import com.tcs.BsiShopRedesign.pages.HomePage;
import com.tcs.BsiShopRedesign.pages.SearchPage;
import com.tcs.BsiShopRedesign.pages.SignInPage;
import com.tcs.BsiShopRedesign.utilities.BaseTest;
import com.tcs.BsiShopRedesign.utilities.CommonHelper;

public class ValidateCheckoutDetails extends BaseTest {

	public ValidateCheckoutDetails() throws Exception {
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
	public void validateCheckoutNonUKDetails() {

		try {
			test = extent.startTest(
					"Sprint 8 - Ecom-10 AC#49 __ Validate Checkout Details with Billing and Card Billing Address as non UK Country for Hardcopy product on Checkout Page");
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

			System.out.println("Create South African Billing Address");
			Log.info("Create Checkout Billing South African Billing Address");
			test.log(LogStatus.INFO, "Create South African Billing Address ");
			CheckoutPage checkOut = new CheckoutPage(driver);
			checkOut.createSouthAfricanBillingAddress();

			System.out.println("Enter Payment Details");
			Log.info("Enter Payment Details");
			test.log(LogStatus.INFO, "Enter Payment Details");
			CheckoutPage checkoutOrder = new CheckoutPage(driver);
			checkoutOrder.enterPaymentDetails();

			System.out.println("Enter Order Details");
			Log.info("Enter Order Details");
			test.log(LogStatus.INFO, "Enter Order Details");
			checkoutOrder.enterNonUKOrderDetails();

			System.out.println("Validate Error Message for Evidence does not match");
			Log.info("Validate Error Message for Evidence does not match");
			test.log(LogStatus.INFO, "Validate Error Message for Evidence does not match");
			checkoutOrder.validateEvidenceErrorMessage();

			System.out.println("Click Edit on Checkout Page");
			Log.info("Click Edit on Checkout Page");
			CheckoutPage editOrder = new CheckoutPage(driver);
			editOrder.clickEditOrder();

			/*
			 * System.out.println("Click Continue Shopping");
			 * Log.info("Click Continue Shopping"); checkoutOrder.clickContinueShopping();
			 */

			Log.info("Remove the Product");
			System.out.println("Remove the Product");
			test.log(LogStatus.INFO, "Remove the Product");
			checkout.removeProduct();

		} catch (Exception e) {
			test.log(LogStatus.FATAL,
					"Validate Checkout Details with Billing and Card Billing Address as non UK Country for Hardcopy product on Checkout Page was unsuccessful");
			CommonHelper.reportFailure(
					"Validate Checkout Details with Billing and Card Billing Address as non UK Country for Hardcopy product on Checkout Page was unsuccessful");
			e.printStackTrace();
			Assert.fail(e.getMessage());
		}
	}

	@Test(priority = 3, enabled = true)
	public void validateCheckoutUKDetails() {

		try {
			test = extent.startTest(
					"Sprint 8 - Ecom-29 AC#52 __ Validate Checkout Details with Billing as Non - UK Country for PDF product on Checkout Page");
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

			System.out.println("Create South African Billing Address");
			Log.info("Create Checkout Billing South African Billing Address");
			test.log(LogStatus.INFO, "Create South African Billing Address ");
			CheckoutPage checkOut = new CheckoutPage(driver);
			checkOut.createSouthAfricanBillingAddress();

			System.out.println("Enter Payment Details");
			Log.info("Enter Payment Details");
			test.log(LogStatus.INFO, "Enter Payment Details");
			CheckoutPage checkoutOrder = new CheckoutPage(driver);
			checkoutOrder.enterPaymentDetails();

			/*
			 * System.out.println("Enter Order Details"); Log.info("Enter Order Details");
			 * test.log(LogStatus.INFO, "Enter Order Details");
			 * checkoutOrder.enterUKOrderDetails();
			 */

			System.out.println("Validate Error Message");
			Log.info("Validate Error Message");
			test.log(LogStatus.INFO, "Validate Error Message");
			checkoutOrder.validateBlockedCountryErrorMessage();

			System.out.println("Click Edit on Checkout Page");
			Log.info("Click Edit on Checkout Page");
			CheckoutPage editOrder = new CheckoutPage(driver);
			editOrder.clickEditOrder();

			Log.info("Remove the Product");
			System.out.println("Remove the Product");
			test.log(LogStatus.INFO, "Remove the Product");
			checkout.removeProduct();

			System.out.println("Click Logout");
			Log.info("Click Logout");
			home.clickLogout();

		} catch (Exception e) {
			test.log(LogStatus.FATAL,
					"Validate Checkout Details with Billing as Non - UK Country for PDF product on Checkout Page was unsuccessful");
			CommonHelper.reportFailure(
					"Validate Checkout Details with Billing as Non - UK Country for PDF product on Checkout Page was unsuccessful");
			e.printStackTrace();
			Assert.fail(e.getMessage());
		}
	}

}
