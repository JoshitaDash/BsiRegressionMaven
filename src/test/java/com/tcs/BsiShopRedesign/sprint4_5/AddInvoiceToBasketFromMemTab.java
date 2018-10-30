package com.tcs.BsiShopRedesign.sprint4_5;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.LogStatus;
import com.tcs.BsiShopRedesign.pages.BasketPage;
import com.tcs.BsiShopRedesign.pages.HomePage;
import com.tcs.BsiShopRedesign.pages.MyProfileMemberPage;
import com.tcs.BsiShopRedesign.pages.SignInPage;
import com.tcs.BsiShopRedesign.utilities.BaseTest;
import com.tcs.BsiShopRedesign.utilities.CommonHelper;

public class AddInvoiceToBasketFromMemTab extends BaseTest {

	public AddInvoiceToBasketFromMemTab() throws Exception {
		super();
	}

	@Test(priority = 1, enabled = true)
	public void signInMember() {

		try {
			test = extent.startTest("Sprint 4&5 - Member User Sign In");
			System.out.println("Member Signing In");
			Log.info("Member Signing In");
			SignInPage signIn = new SignInPage(driver);
			signIn.memberNewLogin();
		}

		catch (Exception e) {
			test.log(LogStatus.FATAL, "Member Signing in was unsuccessful");
			CommonHelper.takeScreenShot();
			e.printStackTrace();
			Assert.fail(e.getMessage());
		}
	}

	@Test(priority = 2, enabled = true)
	public void AddInvoiceToBasket() {

		test = extent.startTest("Sprint 4&5 - Ecom-27 AC#24 ___ Add invoice to Basket from Member Tab");
		try {
			// test = extent.startTest("Click on Member Tab");
			System.out.println("Click on Member Tab");
			Log.info("Click on Member Tab");
			MyProfileMemberPage mem = new MyProfileMemberPage(driver);
			mem.clickMemberTab();

			System.out.println("Add Invoice to Basket");
			Log.info("Add Invoice to Basket");
			mem.addToBasketFromMemTab();

			Log.info("Remove Invoice from Basket");
			System.out.println("Remove Invoice from Basket");
			test.log(LogStatus.INFO, "Remove Invoice from Basket");
			BasketPage basket = new BasketPage(driver);
			basket.removeMultipleProduct();

			System.out.println("Click Logout");
			Log.info("Click Logout");
			HomePage logout = new HomePage(driver);
			logout.clickLogout();

		} catch (Exception e) {
			test.log(LogStatus.FATAL, "Add invoice to Basket from Member Tab was unsuccessful");
			CommonHelper.takeScreenShot();
			e.printStackTrace();
			Assert.fail(e.getMessage());
		}
	}
}