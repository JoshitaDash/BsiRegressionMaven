package com.tcs.BsiShopRedesign.sprint9;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.LogStatus;
import com.tcs.BsiShopRedesign.pages.HomePage;
import com.tcs.BsiShopRedesign.utilities.BaseTest;
import com.tcs.BsiShopRedesign.utilities.CommonHelper;

public class VerifyContactUs extends BaseTest {

	public VerifyContactUs() throws Exception {
		super();
	}

	@Test(priority = 1, enabled = true)
	public void contactUs() {
		// WebDriverWait wait = new WebDriverWait(driver, 120);

		try {
			test = extent.startTest("Sprint 9 - Ecom-66 AC#78 __Verify Contact Us Details");

			System.out.println("Click Contact Us on HomePage");
			Log.info("Click Contact Us on HomePage");
			HomePage home = new HomePage(driver);
			home.clickContactUs();

			System.out.println("Enter Contact Us Details");
			Log.info("Enter Contact Us Details");
			home.enterContactUsDetails();

			System.out.println("Verify Contact Us Message");
			Log.info("Verify Contact Us Message");
			home.verifyContactUsMessage();

		} catch (Exception e) {
			test.log(LogStatus.FATAL, "Verification of Contact Us Message was unsuccessful");
			CommonHelper.reportFailure("Verification of Contact Us Message was unsuccessful");
			e.printStackTrace();
			Assert.fail(e.getMessage());
		}
	}

}
