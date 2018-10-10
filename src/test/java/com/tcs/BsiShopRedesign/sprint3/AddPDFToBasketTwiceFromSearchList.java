package com.tcs.BsiShopRedesign.sprint3;

import org.testng.Assert;
import org.testng.annotations.Test;
import com.relevantcodes.extentreports.LogStatus;
import com.tcs.BsiShopRedesign.pages.BasketPage;
import com.tcs.BsiShopRedesign.pages.HomePage;
import com.tcs.BsiShopRedesign.pages.SearchPage;
import com.tcs.BsiShopRedesign.utilities.BaseTest;
import com.tcs.BsiShopRedesign.utilities.CommonHelper;

public class AddPDFToBasketTwiceFromSearchList extends BaseTest {

	public AddPDFToBasketTwiceFromSearchList() throws Exception {
		super();
	}

	@Test(priority = 1, enabled = true)
	public void addToBasketSearchList() {

		test = extent.startTest("Sprint 3 - Ecom-47 AC#38 ___ Add PDF product twice to Basket from Search List");
		try {

			System.out.println("Search Quality Product");
			Log.info("Search Quality Product");
			test.log(LogStatus.INFO, "Search Quality Product");
			HomePage home = new HomePage(driver);
			home.searchFireProduct();

			Thread.sleep(1000);
			System.out.println("Click on Add to Basket from Search List");
			Log.info("Click on Add to Basket from Search List");
			test.log(LogStatus.INFO, "Click on Add to Basket from Search List");
			SearchPage search = new SearchPage(driver);
			search.clickAddToBasket();

			System.out.println("Select Format and Click Ok");
			Log.info("Select Format and Click Ok");
			search.selectFormatClickOK();
			/*
			 * System.out.println("Select Format"); Log.info("Select Format");
			 * search.selectFormat();
			 */

			Thread.sleep(7000);
			System.out.println("Click on Add to Basket twice from Search List");
			Log.info("Click on Add to Basket twice from Search List");
			test.log(LogStatus.INFO, "Click on Add to Basket twice from Search List");
			search.clickAddToBasket();

			System.out.println("Select Format and Click Ok");
			Log.info("Select Format and Click Ok");
			search.selectFormatClickOK();

			/*
			 * System.out.println("Select Format"); Log.info("Select Format");
			 * search.selectFormat();
			 */

			System.out.println("Verify Alert message for adding PDF product twice");
			Log.info("Verify Alert message for adding PDF product twice");
			test.log(LogStatus.INFO, "Verify Alert message for adding PDF product twice");
			search.checkWarningMsg();

			System.out.println("View Basket");
			Log.info("View Basket");
			test.log(LogStatus.INFO, "View Basket");
			search.viewBasket();

			Log.info("Remove the Product");
			System.out.println("Remove the Product");
			test.log(LogStatus.INFO, "Remove the Product");
			BasketPage basket = new BasketPage(driver);
			basket.removeMultipleProduct();

		} catch (Exception e) {
			test.log(LogStatus.FATAL, "Add to Basket from Search List was unsuccessful");
			CommonHelper.reportFailure("Add to Basket from Search List was unsuccessful");
			e.printStackTrace();
			Assert.fail(e.getMessage());
		}
	}
}
