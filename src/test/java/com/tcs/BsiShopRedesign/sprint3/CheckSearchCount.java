package com.tcs.BsiShopRedesign.sprint3;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.LogStatus;
import com.tcs.BsiShopRedesign.pages.HomePage;
import com.tcs.BsiShopRedesign.pages.SearchPage;
import com.tcs.BsiShopRedesign.utilities.BaseTest;
import com.tcs.BsiShopRedesign.utilities.CommonHelper;



public class CheckSearchCount extends BaseTest {

	public CheckSearchCount() throws Exception {
		super();
	}

	@Test(priority = 1, enabled = true)
	public void searchPASCount() {

		test = extent.startTest("Sprint 3 - Ecom-47 AC#33 ___ Check Product Count in Search List");
		try {

			System.out.println("Search PAS Product");
			Log.info("Search PAS Product");
			HomePage home = new HomePage(driver);
			home.searchPASProduct();

			System.out.println("Select maximum items");
			Log.info("Select maximum items");
			SearchPage search = new SearchPage(driver);
			search.selectMaxItems();

			System.out.println("Check the search count");
			Log.info("Check the search count");
			search.countPAS();

		} catch (Exception e) {
			test.log(LogStatus.FATAL, "Searching PAS Product was unsuccessful");
			CommonHelper.reportFailure("Searching PAS Product was unsuccessful");
			e.printStackTrace();
			Assert.fail(e.getMessage());
		}
	}
}
