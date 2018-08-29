package com.tcs.BsiShopRedesign.sprint2;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.LogStatus;
import com.tcs.BsiShopRedesign.pages.EventPage;
import com.tcs.BsiShopRedesign.pages.HomePage;
import com.tcs.BsiShopRedesign.pages.SignInPage;
import com.tcs.BsiShopRedesign.utilities.BaseTest;
import com.tcs.BsiShopRedesign.utilities.CommonHelper;

public class BookEvent extends BaseTest {

	public BookEvent() throws Exception {
		super();

	}

	@Test(priority = 1, enabled = true)
	public void signIn() {

		try {
			
			test = extent.startTest("Sprint 2 - Registered User Sign In");
			System.out.println("User Signing In");
			Log.info("User Signing In");
			SignInPage signIn = new SignInPage(driver);
			signIn.login();
		}

		catch (Exception e) {
			test.log(LogStatus.FATAL, "Signing in was unsuccessful");
			CommonHelper.reportFailure("Signing in was unsuccessful");
			e.printStackTrace();
			Assert.fail(e.getMessage());
		}
	}

	@Test(priority = 2, enabled = true)
	public void BookPaidEvent() {

		test = extent.startTest("Sprint 2 - Ecom-06 AC#26 ___ Book Paid Event");
		try {

			System.out.println("Search Paid Event");
			Log.info("Search Paid Event");
			EventPage event = new EventPage(driver);
			event.searchPaidEvent();

			System.out.println("Click Book Now for Paid Event");
			Log.info("Click Book Now for Paid Event");
			event.bookPaidEvent();

			Thread.sleep(5000);
			System.out.println("Add Delegate to Event");
			Log.info("Add Delegate to Event");
			event.clickAddDelegate();

			//Thread.sleep(5000);
			System.out.println("Add Delegate details to Event");
			Log.info("Add Delegate details to Event");
			event.addDelegateDetails();

			System.out.println("Add Event to Basket and View Basket");
			Log.info("Add Event to Basket and View Basket");
			event.addEventToBasket();

			System.out.println("View Basket");
			Log.info("View Basket");
			event.viewBasket();

			System.out.println("Remove Event from Basket");
			Log.info("Remove Event from Basket");
			event.removeEvent();

			System.out.println("Click Logout");
			Log.info("Click Logout");
			HomePage paidEvent = new HomePage(driver);
			paidEvent.clickLogout();

		}

		catch (Exception e) {
			test.log(LogStatus.FATAL, "Booking Paid Event was unsuccessful");
			CommonHelper.reportFailure("Booking Paid Event was unsuccessful");
			e.printStackTrace();
			Assert.fail(e.getMessage());
		}
	}

	@Test(priority = 3, enabled = false)
	public void BookFreeEvent() {

		test = extent.startTest("Sprint 2 - Ecom-06 AC#27 ___Book Free Event");
		try {

			Thread.sleep(2000);
			System.out.println("Search Free Event");
			Log.info("Search Free Event");
			EventPage event = new EventPage(driver);
			event.searchFreeEvent();

			System.out.println("Click Book Now for Free Event");
			Log.info("Click Book Now for Free Event");
			event.bookFreeEvent();

			System.out.println("Enter Pardot Details");
			Log.info("Enter Pardot Details");
			event.enterPardotDetails();

			System.out.println("Verify Pardot Details");
			Log.info("Verify Pardot Details");
			event.verifyPardotForm();

			System.out.println("Click Logout");
			Log.info("Click Logout");
			HomePage freeEvent = new HomePage(driver);
			freeEvent.clickLogout();

		} catch (Exception e) {
			test.log(LogStatus.FATAL, "Booking Free Event was unsuccessful");
			CommonHelper.reportFailure("Booking Free Event was unsuccessful");
			e.printStackTrace();
			Assert.fail(e.getMessage());
		}
	}
}