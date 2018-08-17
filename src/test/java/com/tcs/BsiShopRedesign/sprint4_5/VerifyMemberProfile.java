package com.tcs.BsiShopRedesign.sprint4_5;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.LogStatus;
import com.tcs.BsiShopRedesign.pages.HomePage;
import com.tcs.BsiShopRedesign.pages.MyProfileMemberPage;
import com.tcs.BsiShopRedesign.pages.SignInPage;
import com.tcs.BsiShopRedesign.utilities.BaseTest;

public class VerifyMemberProfile extends BaseTest{

	public VerifyMemberProfile() throws Exception{
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
	public void verifyMemberTab() {

		test = extent.startTest("Sprint 4&5 - Ecom-44 AC#26; Ecom-39 AC#19; Ecom-36 AC#14 ___ Verify Member Member Tab");
		try {
			//test = extent.startTest("Click on Member Tab");
			System.out.println("Click on Member Tab");
			Log.info("Click on Member Tab");
			MyProfileMemberPage mem = new MyProfileMemberPage(driver);
			mem.clickMemberTab();
			
			System.out.println("Verify Member Number");
			Log.info("Verify Member Number");
			mem.verifyMemberNumber();
			
			System.out.println("Verify Member Expiry Date");
			Log.info("Verify Member Expiry Date");
			mem.verifyMemberExpDate();

			//test = extent.startTest("Verify Member Account");
			System.out.println("Verify Member Status");
			Log.info("Verify Member Status");
			mem.verifyMemberStatus();
			
			System.out.println("Verify Member Credit Amount");
			Log.info("Verify Member Credit Amount");
			mem.verifyMemberCreditAmnt();

			//test = extent.startTest("Click Logout");
			System.out.println("Click Logout");
			Log.info("Click Logout");
			HomePage logout = new HomePage(driver);
			logout.clickLogout();
		}

		catch (Exception e) {
			test.log(LogStatus.FATAL, "Verify Member tab was unsuccessful");
			e.printStackTrace();
			Assert.fail(e.getMessage());
		}
	}
}
