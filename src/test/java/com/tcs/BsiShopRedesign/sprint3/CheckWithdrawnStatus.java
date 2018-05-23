package com.tcs.BsiShopRedesign.sprint3;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.LogStatus;
import com.tcs.BsiShopRedesign.pages.HomePage;
import com.tcs.BsiShopRedesign.pages.SearchPage;
import com.tcs.BsiShopRedesign.utilities.BaseTest;


public class CheckWithdrawnStatus extends BaseTest {

	public CheckWithdrawnStatus() throws Exception {
		super();
	}

	@Test(priority = 1, enabled = true)
	public void checkProductStatus() {

		test = extent.startTest("Sprint 3 - Check Withdrawn Status for Products");
		try {

			System.out.println("Search PAS Product");
			Log.info("Search PAS Product");
			test.log(LogStatus.INFO, "Search PAS Product");
			HomePage home = new HomePage(driver);
			home.searchPASProduct();

			System.out.println("Select maximum items");
			Log.info("Select maximum items");
			test.log(LogStatus.INFO, "Select maximum items");
			SearchPage search = new SearchPage(driver);
			search.selectMaxItems();

			System.out.println("Check Withdrawn status");
			Log.info("Check Withdrawn status");
			test.log(LogStatus.INFO, "Check Withdrawn status");
			search.checkWithdrawnStatus();

		} catch (Exception e) {
			test.log(LogStatus.FATAL, "Checking Withdrawn status of Product was unsuccessful");
			e.printStackTrace();
			Assert.fail(e.getMessage());
		}
	}

	@Test(priority = 2, enabled = true)
	public void checkEventStatus() {

		test = extent.startTest("Sprint 3 - Check Withdrawn Status for Events");
		try {

			System.out.println("Search Events");
			Log.info("Search Events");
			test.log(LogStatus.INFO, "Search Events");
			HomePage home = new HomePage(driver);
			home.searchEvents();

			System.out.println("Select maximum items");
			Log.info("Select maximum items");
			test.log(LogStatus.INFO, "Select maximum items");
			SearchPage search = new SearchPage(driver);
			search.selectMaxItems();

			System.out.println("Check Withdrawn status");
			Log.info("Check Withdrawn status");
			test.log(LogStatus.INFO, "Check Withdrawn status");
			search.checkWithdrawnStatus();

		} catch (Exception e) {
			test.log(LogStatus.FATAL, "Checking Withdrawn status of Product was unsuccessful");
			e.printStackTrace();
			Assert.fail(e.getMessage());
		}
	}

	@Test(priority = 3, enabled = true)
	public void checkBookStatus() {

		test = extent.startTest("Sprint 3 - Check Withdrawn Status for Books");
		try {

			System.out.println("Search Books");
			Log.info("Search Books");
			test.log(LogStatus.INFO, "Search Books");
			HomePage home = new HomePage(driver);
			home.searchBooks();

			System.out.println("Select maximum items");
			Log.info("Select maximum items");
			test.log(LogStatus.INFO, "Select maximum items");
			SearchPage search = new SearchPage(driver);
			search.selectMaxItems();

			System.out.println("Check Withdrawn status");
			Log.info("Check Withdrawn status");
			test.log(LogStatus.INFO, "Check Withdrawn status");
			search.checkWithdrawnStatus();

		} catch (Exception e) {
			test.log(LogStatus.FATAL, "Checking Withdrawn status of Product was unsuccessful");
			e.printStackTrace();
			Assert.fail(e.getMessage());
		}
	}
}
