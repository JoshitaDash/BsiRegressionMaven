package com.tcs.BsiShopRedesign.sprint8;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.LogStatus;
import com.tcs.BsiShopRedesign.pages.BasketPage;
import com.tcs.BsiShopRedesign.pages.CheckoutPage;
import com.tcs.BsiShopRedesign.pages.HomePage;
import com.tcs.BsiShopRedesign.pages.OrderConfirmationPage;
import com.tcs.BsiShopRedesign.pages.OrderHistoryPage;
import com.tcs.BsiShopRedesign.pages.SearchPage;
import com.tcs.BsiShopRedesign.pages.SignInPage;
import com.tcs.BsiShopRedesign.utilities.BaseTest;
import com.tcs.BsiShopRedesign.utilities.BsiConstants;
import com.tcs.BsiShopRedesign.utilities.CommonHelper;

public class SoftCopyDownloads extends BaseTest {

	public SoftCopyDownloads() throws Exception {
		super();
	}

	String url = BsiConstants.getEnvDetails().get("url");

	@Test(priority = 1, enabled = true)
	public void signIn() {

		try {
			test = extent.startTest("Sprint 8 - Registered User Sign In");
			System.out.println("User Signing In");
			Log.info("User Signing In");
			SignInPage signIn = new SignInPage(driver);
			signIn.login();
		}

		catch (Exception e) {
			test.log(LogStatus.FATAL, "Registered User Sign In was unsuccessful");
			CommonHelper.reportFailure("Registered User Sign In was unsuccessful");
			e.printStackTrace();
			Assert.fail(e.getMessage());
		}
	}

	@Test(priority = 2, enabled = true)
	public void downloadSoftCopyfromOrderCofirmationPage() {
		//WebDriverWait wait = new WebDriverWait(driver, 120);

		try {
			test = extent.startTest(
					"Sprint 8 - Ecom-16 AC#78,80; Ecom-18 AC#82 __ Download and Verify SoftCopy from Order Confirmation Page");

			System.out.println("Perform Blank Search");
			Log.info("Perform Blank Search");
			HomePage home = new HomePage(driver);
			home.blankSearch();

			System.out.println("Verfiy search result");
			Log.info("Verfiy search result");
			SearchPage search = new SearchPage(driver);
			search.verifySearchResultforBlankSearch();

			
			Thread.sleep(1000);
			System.out.println("Click on Add to Basket from Search List");
			Log.info("Click on Add to Basket from Search List");
			test.log(LogStatus.INFO, "Click on Add to Basket from Search List");
			//SearchPage search = new SearchPage(driver);
			search.clickAddToBasket();

			System.out.println("Select PDF Format and Click Ok");
			Log.info("Select PDF Format and Click Ok");
			search.selectFormatClickOK();

			Thread.sleep(5000);
			System.out.println("Click on Add to Basket from Search List");
			Log.info("Click on Add to Basket from Search List");
			test.log(LogStatus.INFO, "Click on Add to Basket from Search List");
			search.clickAddToBasketAgain();

			System.out.println("Select second PDF Format and Click Ok");
			Log.info("Select second PDF Format and Click Ok");
			search.selectFormatClickOK();

			System.out.println("View Basket");
			Log.info("View Basket");
			test.log(LogStatus.INFO, "View Basket");
			search.viewBasket();

			System.out.println("Click Checkout Now");
			Log.info("Click Checkout Now");
			BasketPage checkout = new BasketPage(driver);
			checkout.clickCheckout();

			System.out.println("Enter Payment Details");
			Log.info("Enter Payment Details");
			test.log(LogStatus.INFO, "Enter Payment Details");
			CheckoutPage order = new CheckoutPage(driver);
			order.enterCardPaymentDetails();

			System.out.println("Enter Order Details");
			Log.info("Enter Order Details");
			test.log(LogStatus.INFO, "Enter Order Details");
			order.enterOrderDetails();

			System.out.println("Verify Success Message on Order Confirmation Page");
			Log.info("Verify Success Message on Order Confirmation Page");
			test.log(LogStatus.INFO, "Verify Success Message on Order Confirmation Page");
			OrderConfirmationPage softcopy = new OrderConfirmationPage(driver);
			softcopy.verifyOrderSuccessMessage();

			System.out.println("Download SoftCopy from Order Confirmation Page");
			Log.info("Download SoftCopy from Order Confirmation Page");
			test.log(LogStatus.INFO, "Download SoftCopy from Order Confirmation Page");	
			softcopy.downloadVerifySoftCopyDocuments();
			
			/*
			 * System.out.println("Verify SoftCopy Download Document Name");
			 * Log.info("Verify SoftCopy Download Document Name"); test.log(LogStatus.INFO,
			 * "Verify SoftCopy Download Document Name");
			 * softcopy.verifyExpectedFileName(softCopy);
			 */
		} catch (Exception e) {
			test.log(LogStatus.FATAL, "Download and Verify SoftCopy from Order Confirmation Page was unsuccessful");
			CommonHelper.reportFailure("Download and Verify SoftCopy from Order Confirmation Page was unsuccessful");
			e.printStackTrace();
			Assert.fail(e.getMessage());
		}
	}

	@Test(priority = 3, enabled = true)
	public void downloadSoftCopyfromOrderHistoryPage() {

		try {
			test = extent.startTest(
					"Sprint 8 - Ecom-16 AC#78,80; Ecom-18 AC#82 __ Download and Verify SoftCopy from Order History Page");

			System.out.println("Fetching the URL");
			driver.get(url);

			System.out.println("Click on My Profile");
			Log.info("Click on My Profile");
			HomePage myProfile = new HomePage(driver);
			myProfile.clickMyProfile();

			System.out.println("Click on Order History Tab");
			Log.info("Click on Order History Tab");
			OrderHistoryPage order = new OrderHistoryPage(driver);
			order.clickOrderHistoryTab();

			System.out.println("Click on View Order");
			Log.info("Click on View Order");
			order.clickViewOrder();

			System.out.println("Download SoftCopy from Order History Page");
			Log.info("Download SoftCopy from Order History Page");
			test.log(LogStatus.INFO, "Download SoftCopy from Order History Page");
			order.downloadAndVerifySoftCopy();

			System.out.println("Click Logout");
			Log.info("Click Logout");
			myProfile.clickLogout();

		} catch (Exception e) {
			test.log(LogStatus.FATAL, "Download and Verify SoftCopy from Order History Page was unsuccessful");
			CommonHelper.reportFailure("Download and Verify SoftCopy from Order History Page was unsuccessful");
			e.printStackTrace();
			Assert.fail(e.getMessage());
		}
	}
}
