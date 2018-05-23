package com.tcs.BsiShopRedesign.sprint3;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.LogStatus;
import com.tcs.BsiShopRedesign.pages.HomePage;
import com.tcs.BsiShopRedesign.pages.SearchPage;
import com.tcs.BsiShopRedesign.utilities.BaseTest;



public class SearchSortOrderByProductType extends BaseTest {

	public SearchSortOrderByProductType() throws Exception {
		
		super();
	}

	@Test(priority = 1, enabled = true)
	public void checkSortingOrderQuality() {

		test = extent.startTest("Sprint 3 - Check Sorting order for Products by Product Type in Search List");
		try {

			System.out.println("Search Quality Product");
			Log.info("Search Quality Product");
			test.log(LogStatus.INFO, "Search Quality Product");
			HomePage home = new HomePage(driver);
			home.searchQualityProduct();

			System.out.println("Select maximum items");
			Log.info("Select maximum items");
			SearchPage search = new SearchPage(driver);
			search.selectMaxItems();

			System.out.println("Select Product Type and Verify Sorting");
			Log.info("Select Product Type and Verify Sorting");
			test.log(LogStatus.INFO, "Select Product Type and Verify Sorting");
			search.checkSortingByProductType();

		} catch (Exception e) {
			test.log(LogStatus.FATAL, "Select Product Type and Verify Sorting was unsuccessful");
			e.printStackTrace();
			Assert.fail(e.getMessage());
		}
	}
}