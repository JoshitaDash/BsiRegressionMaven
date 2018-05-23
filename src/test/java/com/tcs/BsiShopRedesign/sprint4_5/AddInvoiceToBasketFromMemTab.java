package com.tcs.BsiShopRedesign.sprint4_5;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.LogStatus;
import com.tcs.BsiShopRedesign.pages.BasketPage;
import com.tcs.BsiShopRedesign.pages.MyProfileMemberPage;
import com.tcs.BsiShopRedesign.pages.SignInPage;
import com.tcs.BsiShopRedesign.utilities.BaseTest;


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
			e.printStackTrace();
			Assert.fail(e.getMessage());
		}
	}

	@Test(priority = 2, enabled = true)
	public void AddInvoiceToBasket() {

		test = extent.startTest("Sprint 4&5 - Add invoice to Basket from Member Tab");
		try {
			// test = extent.startTest("Click on Member Tab");
			System.out.println("Click on Member Tab");
			Log.info("Click on Member Tab");
			MyProfileMemberPage mem = new MyProfileMemberPage(driver);
			mem.clickMemberTab();

			System.out.println("Click on Member Tab");
			Log.info("Click on Member Tab");
			mem.addToBasketFromMemTab();

			Log.info("Remove the Product");
			System.out.println("Remove the Product");
			test.log(LogStatus.INFO, "Remove the Product");
			BasketPage basket = new BasketPage(driver);
			basket.removeProduct();

			System.out.println("Click Logout");
			Log.info("Click Logout");
			mem.clickLogout();
			
			
		} catch (Exception e) {
			test.log(LogStatus.FATAL, "Verify Member tab was unsuccessful");
			e.printStackTrace();
			Assert.fail(e.getMessage());
		}
	}
}