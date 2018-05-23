package com.tcs.BsiShopRedesign.sprint2;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.LogStatus;
import com.tcs.BsiShopRedesign.pages.EventPage;
import com.tcs.BsiShopRedesign.pages.HomePage;
import com.tcs.BsiShopRedesign.pages.SignInPage;
import com.tcs.BsiShopRedesign.utilities.BaseTest;


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
			e.printStackTrace();
			Assert.fail(e.getMessage());
		}
	}

	@Test(priority = 2, enabled = true)
	public void BookPaidEvent() {

		test = extent.startTest("Sprint 2 - Book Paid Event");
		try {
			// test = extent.startTest("Search Paid Event");
			System.out.println("Search Paid Event");
			Log.info("Search Paid Event");
			EventPage event = new EventPage(driver);
			event.searchPaidEvent();

			// test = extent.startTest("Click Book Now for Paid Event");
			System.out.println("Click Book Now for Paid Event");
			Log.info("Click Book Now for Paid Event");
			event.bookPaidEvent();

			// test = extent.startTest("Add Delegate to Event");
			System.out.println("Add Delegate to Event");
			Log.info("Add Delegate to Event");
			event.clickAddDelegate();

			// test = extent.startTest("Add Delegate details to Event");
			System.out.println("Add Delegate details to Event");
			Log.info("Add Delegate details to Event");
			event.addDelegateDetails();

			// test = extent.startTest("Add Event to Basket");
			System.out.println("Add Event to Basket and View Basket");
			Log.info("Add Event to Basket and View Basket");
			event.addEventToBasket();

			// test = extent.startTest("View Basket");
			System.out.println("View Basket");
			Log.info("View Basket");
			event.viewBasket();

			// test = extent.startTest("Remove Event from Basket");
			System.out.println("Remove Event from Basket");
			Log.info("Remove Event from Basket");
			event.removeEvent();

			/*System.out.println("Click Logout");
			Log.info("Click Logout");
			HomePage paidEvent = new HomePage(driver);
			paidEvent.clickLogout();*/

		}

		catch (Exception e) {
			test.log(LogStatus.FATAL, "Booking Paid Event was unsuccessful");
			e.printStackTrace();
			Assert.fail(e.getMessage());
		}
	}

	@Test(priority = 3, enabled = true)
	public void BookFreeEvent() {

		test = extent.startTest("Sprint 2 - Book Free Event");
		try {
			// test = extent.startTest("Search Free Event");
			Thread.sleep(2000);
			System.out.println("Search Free Event");
			Log.info("Search Free Event");
			EventPage event = new EventPage(driver);
			event.searchFreeEvent();

			// test = extent.startTest("Click Book Now for Free Event");
			System.out.println("Click Book Now for Free Event");
			Log.info("Click Book Now for Free Event");
			event.bookFreeEvent();

			// test = extent.startTest("Enter Pardot Details");
			System.out.println("Enter Pardot Details");
			Log.info("Enter Pardot Details");
			event.enterPardotDetails();

			// test = extent.startTest("Verify Pardot Details");
			System.out.println("Verify Pardot Details");
			Log.info("Verify Pardot Details");
			event.verifyPardotForm();

			// test = extent.startTest("Click Logout");
			System.out.println("Click Logout");
			Log.info("Click Logout");
			HomePage freeEvent = new HomePage(driver);
			freeEvent.clickLogout();

		} catch (Exception e) {
			test.log(LogStatus.FATAL, "Booking Free Event was unsuccessful");
			e.printStackTrace();
			Assert.fail(e.getMessage());
		}
	}
}