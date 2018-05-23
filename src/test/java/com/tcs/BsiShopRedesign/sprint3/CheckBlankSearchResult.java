package com.tcs.BsiShopRedesign.sprint3;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.LogStatus;
import com.tcs.BsiShopRedesign.pages.HomePage;
import com.tcs.BsiShopRedesign.pages.SearchPage;
import com.tcs.BsiShopRedesign.utilities.BaseTest;

public class CheckBlankSearchResult extends BaseTest {

	public CheckBlankSearchResult() throws Exception {
		super();
		// TODO Auto-generated constructor stub
	}

	@Test(priority = 1, enabled = true)
	public void blankSearch() {

		test = extent.startTest("Sprint 3 - Check Product details for Blank Search");
		try {

			System.out.println("Perform Blank Search");
			Log.info("Perform Blank Search");
			HomePage home = new HomePage(driver);
			home.blankSearch();

			System.out.println("Verfiy search result");
			Log.info("Verfiy search result");
			SearchPage search = new SearchPage(driver);
			search.verifySearchResultforBlankSearch();

		} catch (Exception e) {
			test.log(LogStatus.FATAL, "Verification of Blank search was unsuccessful");
			e.printStackTrace();
			Assert.fail(e.getMessage());
		}
	}
}