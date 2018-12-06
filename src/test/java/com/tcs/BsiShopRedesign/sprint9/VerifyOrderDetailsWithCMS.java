package com.tcs.BsiShopRedesign.sprint9;

import org.testng.Assert;
import org.testng.annotations.Test;
import com.relevantcodes.extentreports.LogStatus;
import com.tcs.BsiShopRedesign.pages.CmsPage;
import com.tcs.BsiShopRedesign.pages.HomePage;
import com.tcs.BsiShopRedesign.pages.OrderHistoryPage;
import com.tcs.BsiShopRedesign.pages.SignInPage;
import com.tcs.BsiShopRedesign.utilities.BaseTest;
import com.tcs.BsiShopRedesign.utilities.BsiConstants;
import com.tcs.BsiShopRedesign.utilities.CommonHelper;

public class VerifyOrderDetailsWithCMS extends BaseTest {

	public VerifyOrderDetailsWithCMS() throws Exception {
		super();
	}

	String adminURL = BsiConstants.getEnvDetails().get("adminURL");

	@Test(priority = 1, enabled = true)
	public void signIn() {

		try {
			test = extent.startTest("Sprint 9 - Registered User Sign In");
			System.out.println("Registered User Sign In");
			Log.info("Registered User Sign In");
			SignInPage signIn = new SignInPage(driver);
			signIn.login();
		}

		catch (Exception e) {
			test.log(LogStatus.FATAL, "Registered User signing in was unsuccessful");
			CommonHelper.reportFailure("Registered User signing in was unsuccessful");
			e.printStackTrace();
			Assert.fail(e.getMessage());
		}
	}

	@Test(priority = 2, enabled = true)
	public void applyPromoCode() {
		try {

			test = extent.startTest("Sprint 9 - Ecom-34 AC#76 __ Verify Order Details with CMS Page");

			System.out.println("Click on Order History Tab");
			Log.info("Click on Order History Tab");
			OrderHistoryPage orderHistory = new OrderHistoryPage(driver);
			orderHistory.clickOrderHistoryTab();

			System.out.println("View Order Number in Order History");
			Log.info("View Order Number in Order History");
			String orderNum = orderHistory.viewOrderNum();

			System.out.println("Click Logout");
			Log.info("Click Logout");
			HomePage home = new HomePage(driver);
			home.clickLogout();

			Thread.sleep(1000);
			driver.get(adminURL);
			// test = extent.startTest("CMS - Admin User Sign In");
			test.log(LogStatus.INFO, "URL: " + adminURL);
			System.out.println("Admin Signing In");
			Log.info("Admin Signing In");
			SignInPage signIn = new SignInPage(driver);
			signIn.adminLogin();

			System.out.println("Click on Sales Menu");
			Log.info("Click on Sales Menu");
			CmsPage customer = new CmsPage(driver);
			customer.clickSalesMenu();

			System.out.println("Click Orders Submenu");
			Log.info("Click Orders Submenu");
			customer.clickOrdersSubmenu();

			System.out.println("Search Order Number");
			Log.info("Search Order Number");
			customer.searchOrderNum(orderNum);

			System.out.println("Click View Order");
			Log.info("Click View Order");
			customer.clickViewOrder();

			System.out.println("Verify Evidence Information Order Details");
			Log.info("Verify Evidence Information Order Details");
			customer.verifyEvidenceInfo();

			System.out.println("Click Admin Logout");
			Log.info("Click Admin Logout");
			customer.clickAdminLogout();

		} catch (Exception e) {
			test.log(LogStatus.FATAL, "Verify Order Details with CMS Page was unsuccessful");
			CommonHelper.reportFailure("Verify Order Details with CMS Page was unsuccessful");
			e.printStackTrace();
			Assert.fail(e.getMessage());
		}
	}
}
