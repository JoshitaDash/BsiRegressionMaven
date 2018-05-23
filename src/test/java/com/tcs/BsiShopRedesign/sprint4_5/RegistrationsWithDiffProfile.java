package com.tcs.BsiShopRedesign.sprint4_5;

import org.testng.Assert;
import org.testng.annotations.Test;
import com.relevantcodes.extentreports.LogStatus;
import com.tcs.BsiShopRedesign.pages.HomePage;
import com.tcs.BsiShopRedesign.utilities.BaseTest;


public class RegistrationsWithDiffProfile extends BaseTest {

	public RegistrationsWithDiffProfile() throws Exception {
		super();
	}

	@Test(priority = 1, enabled = true)
	public void createRegUserUKProfile() {

		test = extent.startTest("Sprint 4&5 - Create registered user with UK profile using Postcode");
		try {

			System.out.println("Click on Register");
			Log.info("Click on Register");
			test.log(LogStatus.INFO, "Click on Register");
			HomePage home = new HomePage(driver);
			home.clickReg();

			System.out.println("Enter Registration Details");
			Log.info("Enter Registration Details");
			test.log(LogStatus.INFO, "Enter Registration Details");
			home.enterRegDetails();

			System.out.println("Verify Registration");
			Log.info("Verify Registration");
			test.log(LogStatus.INFO, "Verify Registration");
			home.verifyReg();

			System.out.println("Click Logout");
			Log.info("Click Logout");
			HomePage reg = new HomePage(driver);
			reg.clickLogout();

		} catch (Exception e) {
			test.log(LogStatus.FATAL, "Create registered user with UK profile using Postcode was unsuccessful");
			e.printStackTrace();
			Assert.fail(e.getMessage());

		}
	}

	@Test(priority = 2, enabled = true)
	public void createRegUserNonUKProfile() {

		test = extent.startTest("Sprint 4&5 - Create registered user with Non-UK profile using Postcode");
		try {

			System.out.println("Click on Register");
			Log.info("Click on Register");
			test.log(LogStatus.INFO, "Click on Register");
			HomePage home = new HomePage(driver);
			home.clickReg();

			System.out.println("Enter Registration Details");
			Log.info("Enter Registration Details");
			test.log(LogStatus.INFO, "Enter Registration Details");
			home.enterRegDetails();

			System.out.println("Verify Registration");
			Log.info("Verify Registration");
			test.log(LogStatus.INFO, "Verify Registration");
			home.verifyReg();

			System.out.println("Click Logout");
			Log.info("Click Logout");
			HomePage reg = new HomePage(driver);
			reg.clickLogout();

		} catch (Exception e) {
			test.log(LogStatus.FATAL, "Create registered user with Non-UK profile using Postcode was unsuccessful");
			e.printStackTrace();
			Assert.fail(e.getMessage());

		}
	}
}
