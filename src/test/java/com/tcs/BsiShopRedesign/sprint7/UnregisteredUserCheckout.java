package com.tcs.BsiShopRedesign.sprint7;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.LogStatus;
import com.tcs.BsiShopRedesign.pages.CheckoutPage;
import com.tcs.BsiShopRedesign.pages.HomePage;
import com.tcs.BsiShopRedesign.pages.SearchPage;
import com.tcs.BsiShopRedesign.utilities.BaseTest;

public class UnregisteredUserCheckout extends BaseTest {

	public UnregisteredUserCheckout() throws Exception {
		super();
	}

	@Test(priority = 1, enabled = true)
	public void CheckLoginAlertOnChekout() {

		test = extent.startTest("Sprint 7 - Verify Login Alert for Unregistered User on Clicking Checkout");
		try {

			System.out.println("Perform Blank Search");
			Log.info("Perform Blank Search");
			HomePage home = new HomePage(driver);
			home.blankSearch();

			System.out.println("Click on Add to Basket from Search List");
			Log.info("Click on Add to Basket from Search List");
			test.log(LogStatus.INFO, "Click on Add to Basket from Search List");
			SearchPage search = new SearchPage(driver);
			search.clickAddToBasket();

			System.out.println("Select Format and Click Ok");
			Log.info("Select Format and Click Ok");
			search.defaultFormatClickOK();

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
			checkOut.enterPaymentDetails();

			System.out.println("Enter Order Details");
			Log.info("Enter Order Details");
			test.log(LogStatus.INFO, "Enter Order Details");
			checkOut.enterOrderDetails();
			
			System.out.println("Confirm Order Details");
			Log.info("Confirm Order Details");
			test.log(LogStatus.INFO, "Confirm Order Details");
			checkOut.confirmOrderDetails();

			System.out.println("Click Logout");
			Log.info("Click Logout");
			test.log(LogStatus.INFO, "Click Logout");
			home.clickLogout();

		} catch (Exception e) {
			test.log(LogStatus.FATAL, "Verify Credentials for Unregistered user on clicking checkout was unsuccessful");
			e.printStackTrace();
			Assert.fail(e.getMessage());
		}
	}

	/*
	 * private CheckoutPage CheckoutPage(WebDriver driver) { // TODO Auto-generated
	 * method stub return null; }
	 */
}