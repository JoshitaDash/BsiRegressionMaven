package com.tcs.BsiShopRedesign.sprint8;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.LogStatus;
import com.tcs.BsiShopRedesign.pages.BasketPage;
import com.tcs.BsiShopRedesign.pages.CheckoutPage;
import com.tcs.BsiShopRedesign.pages.HomePage;
import com.tcs.BsiShopRedesign.pages.MyProfileMemberPage;
import com.tcs.BsiShopRedesign.pages.SignInPage;
import com.tcs.BsiShopRedesign.utilities.BaseTest;

public class RenewMembership extends BaseTest {

	public RenewMembership() throws Exception {
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
	public void addRenewMembershipToBasket() {

		test = extent.startTest("Sprint 8 - Ecom-44 AC#24,25 __ Renew Membership");
		try {
			// test = extent.startTest("Click on Member Tab");
			System.out.println("Click on Member Tab");
			Log.info("Click on Member Tab");
			MyProfileMemberPage mem = new MyProfileMemberPage(driver);
			mem.clickMemberTab();
			
			System.out.println("Click on Renew Membership");
			Log.info("Click on Renew Membership");
			mem.clickRenewMembership();

			System.out.println("Add Renew Membership to Basket");
			Log.info("Add Renew Membership to Basket");
			mem.renewMembershipToBasket();
			
			System.out.println("Click Checkout Now");
			Log.info("Click Checkout Now");
			BasketPage checkout = new BasketPage(driver);	
			checkout.clickCheckout();
			
			System.out.println("Enter Payment Details");
			Log.info("Enter Payment Details");
			test.log(LogStatus.INFO, "Enter Payment Details");
			CheckoutPage order = new CheckoutPage(driver);
			order.enterPaymentDetails();

			System.out.println("Enter Order Details");
			Log.info("Enter Order Details");
			test.log(LogStatus.INFO, "Enter Order Details");
			order.enterOrderDetails();

			System.out.println("Confirm Order Details");
			Log.info("Confirm Order Details");
			test.log(LogStatus.INFO, "Confirm Order Details");
			order.confirmOrderDetails();
			
			/*Log.info("Remove Renew Membership from Basket");
			System.out.println("Remove Renew Membership  from Basket");
			test.log(LogStatus.INFO, "Remove Renew Membership  from Basket");
			BasketPage basket = new BasketPage(driver);
			basket.removeProduct();*/

			System.out.println("Click Logout");
			Log.info("Click Logout");
			HomePage logout = new HomePage(driver);
			logout.clickLogout();

		} catch (Exception e) {
			test.log(LogStatus.FATAL, "Renew Membership was unsuccessful");
			e.printStackTrace();
			Assert.fail(e.getMessage());
		}
	}
}
