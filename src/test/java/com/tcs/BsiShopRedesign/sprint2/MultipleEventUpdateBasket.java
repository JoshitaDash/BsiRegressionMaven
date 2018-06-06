package com.tcs.BsiShopRedesign.sprint2;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.LogStatus;
import com.tcs.BsiShopRedesign.pages.EventPage;
import com.tcs.BsiShopRedesign.pages.SignInPage;
import com.tcs.BsiShopRedesign.utilities.BaseTest;
import com.tcs.BsiShopRedesign.utilities.CommonHelper;

public class MultipleEventUpdateBasket extends BaseTest {

	public MultipleEventUpdateBasket() throws Exception {
		super();
	}

	@Test(priority = 1, enabled = false)
	public void signIn() {

		try {
			test = extent.startTest("Sprint 2 - Member User Sign In");
			System.out.println("Member Signing In");
			Log.info("Member Signing In");
			SignInPage signIn = new SignInPage(driver);
			signIn.memberLogin();
		}

		catch (Exception e) {
			test.log(LogStatus.FATAL, "Member Signing in was unsuccessful");
			CommonHelper.reportFailure("Member Signing in was unsuccessful");
			e.printStackTrace();
			Assert.fail(e.getMessage());
		}
	}

	@Test(priority = 2, enabled = true)
	public void addAndUpdateMultipleEvents() {
		test = extent.startTest("Sprint 2 - Add and Update Basket for Multiple Events");
		try {
			
			System.out.println("Search Paid Event");
			Log.info("Search Paid Event");
			EventPage event = new EventPage(driver);
			event.searchPaidEvent();
	
			System.out.println("Click Book Now for Paid Event");
			Log.info("Click Book Now for Paid Event");
			event.bookPaidEvent();

			System.out.println("Add Delegate to Event");
			Log.info("Add Delegate to Event");
			event.clickAddDelegate();
	
			System.out.println("Add Delegate details to Event");
			Log.info("Add Delegate details to Event");
			event.addDelegateDetails();
	
			System.out.println("Add Event to Basket ");
			Log.info("Add Event to Basket");
			event.addEventToBasket();
	
			System.out.println("Search Paid Event");
			Log.info("Search Paid Event");
			event.searchSecondPaidEvent();

			System.out.println("Click Book Now for Paid Event");
			Log.info("Click Book Now for Paid Event");
			event.bookPaidEvent();

			System.out.println("Add Delegate to Event");
			Log.info("Add Delegate to Event");
			event.clickAddDelegate();

			System.out.println("Add Delegate details to Event");
			Log.info("Add Delegate details to Event");
			event.addDelegateDetails();

			System.out.println("Add Event to Basket");
			Log.info("Add Event to Basket");
			event.addEventToBasket();

			System.out.println("View Basket");
			Log.info("View Basket");
			event.viewBasket();

			System.out.println("Edit Event");
			Log.info("Edit Event");
			event.editEvent();

			System.out.println("Remove Multiple Event from Basket");
			Log.info("Remove Multiple Event from Basket");
			event.removeMultipleEvent();

		}

		catch (Exception e) {
			test.log(LogStatus.FATAL, "Adding and Updating Multiple Paid Events was unsuccessful");
			CommonHelper.reportFailure("Adding and Updating Multiple Paid Events was unsuccessful");
			e.printStackTrace();
			Assert.fail(e.getMessage());
		}
	}

}
