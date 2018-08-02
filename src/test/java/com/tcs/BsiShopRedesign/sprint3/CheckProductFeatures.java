package com.tcs.BsiShopRedesign.sprint3;

import org.testng.Assert;
import org.testng.annotations.Test;
import com.relevantcodes.extentreports.LogStatus;
import com.tcs.BsiShopRedesign.pages.HomePage;
import com.tcs.BsiShopRedesign.pages.SearchPage;
import com.tcs.BsiShopRedesign.utilities.BaseTest;
import com.tcs.BsiShopRedesign.utilities.CommonHelper;

public class CheckProductFeatures extends BaseTest {

	public CheckProductFeatures() throws Exception {
		super();

	}

	@Test(priority = 1, enabled = true)
	public void checkFreeEvent() {

		try {
			test = extent.startTest("Sprint 3 - Ecom-47 AC#36,42 ___ Checking Free Event Features in Search List");

			System.out.println("Search Free Event");
			Log.info("Search Free Event");
			HomePage home = new HomePage(driver);
			home.searchFreeEvent();

			System.out.println("Checking Free Event Name in Search List");
			Log.info("Checking Free Event Name in Search List");
			SearchPage search = new SearchPage(driver);
			search.checkFreeEventName();

			System.out.println("Checking Free Event Price in Search List");
			Log.info("Checking Free Event Price in Search List");
			search.checkFreeEventPrice();

			System.out.println("Checking Free Event Action Button in Search List");
			Log.info("Checking Free Event Action Button in Search List");
			search.checkEventButton();

			System.out.println("Checking Free Event Label in Search List");
			Log.info("Checking Free Event Label in Search List");
			search.checkEventLabel();
		}

		catch (Exception e) {
			test.log(LogStatus.FATAL, "Free Event Features check in search list was unsuccessful");
			CommonHelper.reportFailure("Free Event Features check in search list was unsuccessful");
			e.printStackTrace();
			Assert.fail(e.getMessage());
		}
	}

	@Test(priority = 2, enabled = true)
	public void checkPASProduct() {

		try {
			test = extent.startTest("Sprint 3 - Ecom-47 AC#36,42 ___Checking PAS Product Features in Search List");

			System.out.println("Search PAS Product");
			Log.info("Search PAS Product");
			HomePage home = new HomePage(driver);
			home.searchPASProduct();

			System.out.println("Checking PAS Product Name in Search List");
			Log.info("Checking PAS Product Name in Search List");
			SearchPage search = new SearchPage(driver);
			search.checkPASProductName();

			System.out.println("Checking PAS Product Price in Search List");
			Log.info("Checking PAS Product Price in Search List");
			search.checkPASProductPrice();

			System.out.println("Checking PAS Product Action Button in Search List");
			Log.info("Checking PAS Product Action Button in Search List");
			search.checkPASProductButton();

			System.out.println("Checking PAS Product Label in Search List");
			Log.info("Checking PAS Product Label in Search List");
			search.checkPASProductLabel();
		}

		catch (Exception e) {
			test.log(LogStatus.FATAL, "PAS Product Features check in search list was unsuccessful");
			CommonHelper.reportFailure("PAS Product Features check in search list was unsuccessful");
			e.printStackTrace();
			Assert.fail(e.getMessage());
		}
	}

	@Test(priority = 3, enabled = true)
	public void checkPaidEvent() {

		try {
			test = extent.startTest("Sprint 3 - Ecom-47 AC#36,42 ___Checking Paid Event Features in Search List");

			System.out.println("Search Paid Event");
			Log.info("Search Paid Event");
			HomePage home = new HomePage(driver);
			home.searchPaidEvent();

			System.out.println("Checking Paid Event Name in Search List");
			Log.info("Checking Paid Event Name in Search List");
			SearchPage search = new SearchPage(driver);
			search.checkPaidEventName();

			System.out.println("Checking Paid Event Price in Search List");
			Log.info("Checking Paid Event Price in Search List");
			search.checkPaidEventPrice();

			System.out.println("Checking Paid Event Member Price in Search List");
			Log.info("Checking Paid Event Member Price in Search List");
			search.checkPaidEventMemberPrice();

			System.out.println("Checking Paid Event Action Button in Search List");
			Log.info("Checking Paid Event Action Button in Search List");
			search.checkEventButton();

			System.out.println("Checking Paid Event Label in Search List");
			Log.info("Checking Paid Event Label in Search List");
			search.checkEventLabel();
		}

		catch (Exception e) {
			test.log(LogStatus.FATAL, "Paid Event Features check in search list was unsuccessful");
			CommonHelper.reportFailure("Paid Event Features check in search list was unsuccessful");
			e.printStackTrace();
			Assert.fail(e.getMessage());
		}
	}

}
