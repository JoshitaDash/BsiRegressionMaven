package com.tcs.BsiShopRedesign.sprint9;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.LogStatus;
import com.tcs.BsiShopRedesign.pages.HomePage;
import com.tcs.BsiShopRedesign.pages.SearchPage;
import com.tcs.BsiShopRedesign.utilities.BaseTest;
import com.tcs.BsiShopRedesign.utilities.CommonHelper;

public class VerifyRecentlyViewedProducts extends BaseTest {

	public VerifyRecentlyViewedProducts() throws Exception {
		super();
	}

	@Test(priority = 1, enabled = true)
	public void blankSearch() {

		test = extent.startTest("Sprint 9 - CM-14 AC#29 ___ Verify Recently Viewed Products");
		try {

			System.out.println("Perform Blank Search");
			Log.info("Perform Blank Search");
			HomePage home = new HomePage(driver);
			home.blankSearch();

			Thread.sleep(3000);
			System.out.println("Verfiy search result");
			Log.info("Verfiy search result");
			SearchPage search = new SearchPage(driver);
			search.verifySearchResultforBlankSearch();

			Thread.sleep(2000);
			System.out.println("View First Product");
			Log.info("View First Product");
			String firstProd = search.viewFirstProduct();

			System.out.println("Perform Blank Search");
			Log.info("Perform Blank Search");
			home.blankSearch();

			Thread.sleep(3000);
			System.out.println("Verfiy search result");
			Log.info("Verfiy search result");
			search.verifySearchResultforBlankSearch();

			Thread.sleep(2000);
			System.out.println("View Second Product");
			Log.info("View Second Product");
			String secondProd = search.viewSecondProduct();

			System.out.println("Perform Blank Search");
			Log.info("Perform Blank Search");
			home.blankSearch();

			Thread.sleep(3000);
			System.out.println("Verfiy search result");
			Log.info("Verfiy search result");
			search.verifySearchResultforBlankSearch();

			Thread.sleep(2000);
			System.out.println("View Third Product");
			Log.info("View Third Product");
			String thirdProd = search.viewThirdProduct();

			System.out.println("Perform Blank Search");
			Log.info("Perform Blank Search");
			home.blankSearch();

			Thread.sleep(3000);
			System.out.println("Verfiy search result");
			Log.info("Verfiy search result");
			search.verifySearchResultforBlankSearch();

			Thread.sleep(2000);
			System.out.println("Verify Recently viewed Products");
			Log.info("Verify Recently viewed Products");
			search.verifyRecentlyViewedProducts(firstProd, secondProd, thirdProd);

		} catch (Exception e) {
			test.log(LogStatus.FATAL, "Verification of Blank search was unsuccessful");
			CommonHelper.reportFailure("Verification of Blank search was unsuccessful");
			e.printStackTrace();
			Assert.fail(e.getMessage());
		}
	}
}
