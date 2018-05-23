package com.tcs.BsiShopRedesign.sprint2;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.LogStatus;
import com.tcs.BsiShopRedesign.pages.SubscriptionsPage;
import com.tcs.BsiShopRedesign.utilities.BaseTest;


public class RegisterSubscriptions extends BaseTest {

	public RegisterSubscriptions() throws Exception {
		super();
	}

	String url = "https://qa4-5rxefly-7redg7uykvdko.eu.magentosite.cloud/";

	@Test(priority = 1, enabled = true)
	public void regBSOLQuote() {

		test = extent.startTest("Sprint 2 - Register BSOL");
		try {
			// test = extent.startTest("Click on Subscriptions BSOL");
			System.out.println("Click on Subscriptions BSOL");
			Log.info("Click on Subscriptions BSOL");
			SubscriptionsPage bsol = new SubscriptionsPage(driver);
			bsol.clickBSOL();

			// test = extent.startTest("Click on Request a Quote");
			System.out.println("Click on Request a Quote");
			Log.info("Click on Request a Quote");
			bsol.clickRequestQuote();

			// test = extent.startTest("Enter Pardot Form details");
			System.out.println("Enter Pardot Form details");
			Log.info("Enter Pardot Form details");
			bsol.enterBSOLPardotDetails();

			// test = extent.startTest("Verify BSOL Pardot Form");
			System.out.println("Verify BSOL Pardot Form");
			Log.info("Verify BSOL Pardot Form");
			bsol.verifyPardotForm();
			Thread.sleep(2000);

		} catch (Exception e) {
			test.log(LogStatus.FATAL, "Register BSOL Quote was unsuccessful");
			e.printStackTrace();
			Assert.fail(e.getMessage());
		}
	}

	@Test(priority = 2, enabled = true)
	public void regCNQuote() {

		test = extent.startTest("Sprint 2 - Register Compliance Navigator");
		try {
			// test = extent.startTest("Goto Home Page");
			/*
			 * HomePage home = new HomePage(driver); home.clickHomePage();
			 */
			
			System.out.println("Fetching the URL");
			driver.get(url);

			// test = extent.startTest("Click on Subscriptions Compliance
			// Navigator");
			System.out.println("Click on Subscriptions Compliance Navigator");
			Log.info("Click on Subscriptions Compliance Navigator");
			SubscriptionsPage euro = new SubscriptionsPage(driver);
			euro.clickCN();

			// test = extent.startTest("Click on Request a Quote");
			System.out.println("Click on Request a Quote");
			euro.clickRequestQuote();

			// test = extent.startTest("Enter Pardot Form details");
			System.out.println("Enter Pardot Form details");
			Log.info("Enter Pardot Form details");
			euro.enterCNPardotDetails();

			// test = extent.startTest("Verify Complaince Navigator Pardot
			// Form");
			System.out.println("Verify Complaince Navigator Pardot Form");
			Log.info("Verify Complaince Navigator Pardot Form");
			euro.verifyPardotForm();
			Thread.sleep(2000);

		} catch (Exception e) {
			test.log(LogStatus.FATAL, "Register Complaince Navigator Quote was unsuccessful");
			e.printStackTrace();
			Assert.fail(e.getMessage());
		}
	}

	@Test(priority = 3, enabled = true)
	public void regEurocodes() {
		test = extent.startTest("Sprint 2 - Register Eurocodes");

		try {

			System.out.println("Fetching the URL");
			driver.get(url);
			// test = extent.startTest("Click on Subscriptions Eurocodes");
			System.out.println("Click on Eurocodes");
			Log.info("Click on Eurocodes");
			SubscriptionsPage compNav = new SubscriptionsPage(driver);
			compNav.clickEurocodes();

			// test = extent.startTest("Click on Request a Quote");
			System.out.println("Click on Request a Quote");
			Log.info("Click on Request a Quote");
			compNav.clickRequestQuote();

			// test = extent.startTest("Enter Pardot Form details");
			System.out.println("Enter Pardot Form details");
			Log.info("Enter Pardot Form details");
			compNav.enterEurocodePardotDetails();

			// test = extent.startTest("Verify Complaince Navigator Pardot
			// Form");
			System.out.println("Verify Complaince Navigator Pardot Form");
			Log.info("Verify Complaince Navigator Pardot Form");
			compNav.verifyPardotForm();
			Thread.sleep(2000);

		} catch (Exception e) {
			test.log(LogStatus.FATAL, "Register Complaince Navigator Quote was unsuccessful");
			e.printStackTrace();
			Assert.fail(e.getMessage());
		}
	}
}
