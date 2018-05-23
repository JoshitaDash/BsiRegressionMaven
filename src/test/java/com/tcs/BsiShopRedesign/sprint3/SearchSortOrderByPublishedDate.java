package com.tcs.BsiShopRedesign.sprint3;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.LogStatus;
import com.tcs.BsiShopRedesign.pages.HomePage;
import com.tcs.BsiShopRedesign.pages.SearchPage;
import com.tcs.BsiShopRedesign.utilities.BaseTest;

public class SearchSortOrderByPublishedDate extends BaseTest {

	public SearchSortOrderByPublishedDate() throws Exception {
		// TODO Auto-generated constructor stub
	}

	@Test(priority = 1, enabled = true)
	public void checkSortingOrderQuality() {

		test = extent.startTest("Sprint 3 - Verify Sorting order for Products by Published Date in Search List");
		try {

			System.out.println("Search PAS Product");
			Log.info("Search PAS Product");
			test.log(LogStatus.INFO, "Search PAS Product");
			HomePage home = new HomePage(driver);
			home.searchPASProduct();

			System.out.println("Select maximum items");
			Log.info("Select maximum items");
			SearchPage search = new SearchPage(driver);
			search.selectMaxItems();

			System.out.println("Select Published Date and Verify Sorting");
			Log.info("Select Published Date and Verify Sorting");
			test.log(LogStatus.INFO, "Select Published Date and Verify Sorting");
			search.checkSortingByPublishedDate();

		} catch (Exception e) {
			test.log(LogStatus.FATAL, "Select Published Date and Verify Sorting was unsuccessful");
			e.printStackTrace();
			Assert.fail(e.getMessage());
		}
	}
}
