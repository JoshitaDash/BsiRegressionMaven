package com.tcs.BsiShopRedesign.sprint7;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.LogStatus;
import com.tcs.BsiShopRedesign.pages.SignInPage;
import com.tcs.BsiShopRedesign.utilities.BaseTest;

public class VerifyMemberDiscount extends BaseTest {

	public VerifyMemberDiscount() throws Exception {
		super();
	}

	@Test(priority = 1, enabled = true)
	public void signInMember() {

		try {
			test = extent.startTest("Sprint 7 - Member User Sign In");
			System.out.println("Member Signing In");
			Log.info("Member Signing In");
			SignInPage signIn = new SignInPage(driver);
			signIn.memberNewLogin();
			System.out.println("");
		}

		catch (Exception e) {
			test.log(LogStatus.FATAL, "Member Signing in was unsuccessful");
			e.printStackTrace();
			Assert.fail(e.getMessage());
		}

	}
}
