package com.tcs.BsiShopRedesign.sprint4_5;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.LogStatus;
import com.tcs.BsiShopRedesign.pages.EventPage;
import com.tcs.BsiShopRedesign.pages.HomePage;
import com.tcs.BsiShopRedesign.pages.SearchPage;
import com.tcs.BsiShopRedesign.utilities.BaseTest;
import com.tcs.BsiShopRedesign.utilities.CommonHelper;

public class VerifyProductStatusWithColorCode extends BaseTest {

	public VerifyProductStatusWithColorCode() throws Exception {
		super();
	}

	@Test(priority = 1, enabled = true)
	public void withdrawnStatusColorCode() {

		test = extent.startTest(
				"Sprint 4_5 - Ecom-48 #Search ___ Verificaiton of Color Code for Product with Withdrawn Status");
		try {

			System.out.println("Perform Blank Search");
			Log.info("Perform Blank Search");
			HomePage home = new HomePage(driver);
			home.blankSearch();

			Thread.sleep(1000);
			System.out.println("Verfiy search result");
			Log.info("Verfiy search result");
			SearchPage search = new SearchPage(driver);
			search.verifySearchResultforBlankSearch();

			System.out.println("Filter Search with Withdrawn Status");
			Log.info("Filter Search with Withdrawn Status");
			search.withdrwanFilterSearch();

			System.out.println("Verify Withdrawn Color Code");
			Log.info("Verify Withdrawn Color Code");
			search.verifyWithdrawnColorCode();

		} catch (Exception e) {
			test.log(LogStatus.FATAL, "Verificaiton of Color Code for Product with Withdrawn Status was unsuccessful");
			CommonHelper.reportFailure("Verificaiton of Color Code for Product with Withdrawn Status was unsuccessful");
			e.printStackTrace();
			Assert.fail(e.getMessage());
		}
	}

	@Test(priority = 2, enabled = true)
	public void currentStatusColorCode() {

		test = extent.startTest(
				"Sprint 4_5 - Ecom-48 #Search ___ Verificaiton of Color Code for Product with Current Status ");
		try {

			System.out.println("Perform Blank Search");
			Log.info("Perform Blank Search");
			HomePage home = new HomePage(driver);
			home.blankSearch();

			Thread.sleep(1000);
			System.out.println("Verfiy search result");
			Log.info("Verfiy search result");
			SearchPage search = new SearchPage(driver);
			search.verifySearchResultforBlankSearch();

			System.out.println("Filter Search with Current Status");
			Log.info("Filter Search with Current Status");
			search.currentFilterSearch();

			System.out.println("Select maximum items");
			Log.info("Select maximum items");
			search.selectMaxItems();

			System.out.println("Verify Current Color Code");
			Log.info("Verify Current Color Code");
			search.verifyCurrentColorCode();

		} catch (Exception e) {
			test.log(LogStatus.FATAL, "Verificaiton of Color Code for Product with Current Status was unsuccessful");
			CommonHelper.reportFailure("Verificaiton of Color Code for Product with Current Status was unsuccessful");
			e.printStackTrace();
			Assert.fail(e.getMessage());
		}
	}

	@Test(priority = 3, enabled = true)
	public void currentDraftStatusColorCode() {

		test = extent.startTest(
				"Sprint 4_5 - Ecom-48 #Search ___ Verificaiton of Color Code for Product with Current Draft for Public Comment Status ");
		try {

			System.out.println("Perform Blank Search");
			Log.info("Perform Blank Search");
			HomePage home = new HomePage(driver);
			home.blankSearch();

			Thread.sleep(1000);
			System.out.println("Verfiy search result");
			Log.info("Verfiy search result");
			SearchPage search = new SearchPage(driver);
			search.verifySearchResultforBlankSearch();

			System.out.println("Filter Search with Current Draft for Public Comment Status");
			Log.info("Filter Search with Current Draft for Public Comment Status");
			search.currentDraftFilterSearch();

			System.out.println("Select maximum items");
			Log.info("Select maximum items");
			search.selectMaxItems();

			System.out.println("Verify Current Draft for Public Comment Color Code");
			Log.info("Verify Current Draft for Public Comment Color Code");
			search.verifyAmberColorCode();

		} catch (Exception e) {
			test.log(LogStatus.FATAL,
					"Verificaiton of Color Code for Product with Current Draft for Public Comment Status was unsuccessful");
			CommonHelper.reportFailure(
					"Verificaiton of Color Code for Product with Current Draft for Public Comment Status was unsuccessful");
			e.printStackTrace();
			Assert.fail(e.getMessage());
		}
	}

	@Test(priority = 4, enabled = true)
	public void currentRevisionUnderwayStatusColorCode() {

		test = extent.startTest(
				"Sprint 4_5 - Ecom-48 #Search ___ Verificaiton of Color Code for Product with Current Revision Underway Status ");
		try {

			System.out.println("Perform Blank Search");
			Log.info("Perform Blank Search");
			HomePage home = new HomePage(driver);
			home.blankSearch();

			Thread.sleep(1000);
			System.out.println("Verfiy search result");
			Log.info("Verfiy search result");
			SearchPage search = new SearchPage(driver);
			search.verifySearchResultforBlankSearch();

			System.out.println("Filter Search with Current Revision Underway Status");
			Log.info("Filter Search with Current Revision Underway Status");
			search.currentRevisionUnderwayFilterSearch();

			System.out.println("Select maximum items");
			Log.info("Select maximum items");
			search.selectMaxItems();

			System.out.println("Verify Current Revision Underway Color Code");
			Log.info("Verify Current Revision Underway Color Code");
			search.verifyAmberColorCode();

		} catch (Exception e) {
			test.log(LogStatus.FATAL,
					"Verificaiton of Color Code for Product with Current Revision Underway Status was unsuccessful");
			CommonHelper.reportFailure(
					"Verificaiton of Color Code for Product with Current Revision Underway Status was unsuccessful");
			e.printStackTrace();
			Assert.fail(e.getMessage());
		}
	}

	@Test(priority = 5, enabled = true)
	public void currentUnderReviewStatusColorCode() {

		test = extent.startTest(
				"Sprint 4_5 - Ecom-48 #Search ___ Verificaiton of Color Code for Product with Current Under Review Status ");
		try {

			System.out.println("Perform Blank Search");
			Log.info("Perform Blank Search");
			HomePage home = new HomePage(driver);
			home.blankSearch();

			Thread.sleep(1000);
			System.out.println("Verfiy search result");
			Log.info("Verfiy search result");
			SearchPage search = new SearchPage(driver);
			search.verifySearchResultforBlankSearch();

			System.out.println("Filter Search with Current Under Review Status");
			Log.info("Filter Search with Current Under Review Status");
			search.currentReviewFilterSearch();

			System.out.println("Select maximum items");
			Log.info("Select maximum items");
			search.selectMaxItems();

			System.out.println("Verify Current Under Review Color Code");
			Log.info("Verify Current Under Review Color Code");
			search.verifyAmberColorCode();

		} catch (Exception e) {
			test.log(LogStatus.FATAL,
					"Verificaiton of Color Code for Product with Current Under Review Status was unsuccessful");
			CommonHelper.reportFailure(
					"Verificaiton of Color Code for Product with Current Under Review Status was unsuccessful");
			e.printStackTrace();
			Assert.fail(e.getMessage());
		}
	}

}
