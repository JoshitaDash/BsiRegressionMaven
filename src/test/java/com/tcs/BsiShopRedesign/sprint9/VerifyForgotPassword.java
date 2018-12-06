package com.tcs.BsiShopRedesign.sprint9;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.LogStatus;
import com.tcs.BsiShopRedesign.pages.HomePage;
import com.tcs.BsiShopRedesign.utilities.BaseTest;
import com.tcs.BsiShopRedesign.utilities.CommonHelper;

public class VerifyForgotPassword extends BaseTest {

	public VerifyForgotPassword() throws Exception {
		super();
	}

	@Test(priority = 2, enabled = true)
	public void validateCheckoutNonUKDetailsHardCopy() {

		try {
			
			test = extent.startTest("Sprint 9 - Ecom-36 AC#13 __ Verify Forgot Password Success Message");

			System.out.println("Verify Forgot Password");
			Log.info("Verify Forgot Password");
			HomePage home = new HomePage(driver);
			home.verifyForgotPassword();

		} catch (Exception e) {
			test.log(LogStatus.FATAL, "Verify Forgot Password Success Message was unsuccessful");
			CommonHelper.reportFailure("Verify Forgot Password Success Message was unsuccessful");
			e.printStackTrace();
			Assert.fail(e.getMessage());
		}
	}
}
