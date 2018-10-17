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

	@Test(priority = 1, enabled = false)
	public void createRegUserUKProfile() {

		test = extent.startTest("Sprint 4&5 - Ecom-35 AC#1,2,6,7 ___ Create registered user with UK profile using Postcode");
		try {

			System.out.println("Click on Register");
			Log.info("Click on Register");
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

		} catch (Exception e) {
			test.log(LogStatus.FATAL, "Create registered user with UK profile using Postcode was unsuccessful");
			e.printStackTrace();
			Assert.fail(e.getMessage());

		}
	}

	@Test(priority = 2, enabled = true)
	public void createRegUserNonUKProfile() {

		test = extent.startTest("Sprint 4&5 - Ecom-35 AC#1,6,7 ___Create registered user with Non-UK profile without using Postcode");
		try {

			System.out.println("Click on Register");
			Log.info("Click on Register");
			HomePage home = new HomePage(driver);
			home.clickReg();

			System.out.println("Enter Registration Details");
			Log.info("Enter Registration Details");
			test.log(LogStatus.INFO, "Enter Registration Details");
			home.enterRegDetailsNonUK();

			System.out.println("Verify Registration");
			Log.info("Verify Registration");
			test.log(LogStatus.INFO, "Verify Registration");
			home.verifyReg();

		} catch (Exception e) {
			test.log(LogStatus.FATAL,
					"Create registered user with Non-UK profile without using Postcode was unsuccessful");
			e.printStackTrace();
			Assert.fail(e.getMessage());

		}
	}

	@Test(priority = 3, enabled = false)
	public void verifyTooltip() {

		test = extent.startTest("Sprint 4&5 - Ecom-35 AC#9 __ Verify Tooltip on Registration Page");
		try {

			System.out.println("Click on Register");
			Log.info("Click on Register");
			HomePage home = new HomePage(driver);
			home.clickReg();

			System.out.println("Verify Tooltip for Member Number");
			Log.info("Verify Tooltip for Member Number");
			test.log(LogStatus.INFO, "Verify Tooltip for Member Number");
			home.verifyTooltipMemberNum();

			System.out.println("Verify Tooltip for VAT Number");
			Log.info("Verify Tooltip for VAT Number");
			test.log(LogStatus.INFO, "Verify Tooltip for VAT Number");
			home.verifyTooltipVATNum();

		} catch (Exception e) {
			test.log(LogStatus.FATAL, "Verify Tooltip on Registration Page was unsuccessful");
			e.printStackTrace();
			Assert.fail(e.getMessage());

		}

	}

	@Test(priority = 4, enabled = false)
	public void verifyContactInformation() {

		test = extent.startTest("Sprint 4&5 - Ecom-35 AC#3 __ Verify Contact Information on Registration Page");
		try {

			System.out.println("Click on Register");
			Log.info("Click on Register");
			HomePage home = new HomePage(driver);
			home.clickReg();

			System.out.println("Verify Contact Information");
			Log.info("Verify Contact Information");
			test.log(LogStatus.INFO, "Verify Contact Information");
			home.verifyContactInfo();

		} catch (Exception e) {
			test.log(LogStatus.FATAL, "Verify Tooltip on Registration Page was unsuccessful");
			e.printStackTrace();
			Assert.fail(e.getMessage());

		}

	}

	@Test(priority = 5, enabled = false)
	public void loginThroughAlreadyRegistered() {

		test = extent.startTest("Sprint 4&5 - Ecom-35 AC#3 __Login through Already Registered User on Registration Page");
		try {

			System.out.println("Click on Register");
			Log.info("Click on Register");
			HomePage home = new HomePage(driver);
			home.clickReg();

			System.out.println("Verify Contact Information");
			Log.info("Verify Contact Information");
			test.log(LogStatus.INFO, "Verify Contact Information");
			home.loginThroughAlreadyRegistered();

			System.out.println("Click Logout");
			Log.info("Click Logout");
			HomePage logout = new HomePage(driver);
			logout.clickLogout();

		} catch (Exception e) {
			test.log(LogStatus.FATAL, "Login through Already Registered User on Registration Page was unsuccessful");
			e.printStackTrace();
			Assert.fail(e.getMessage());

		}
	}

	@Test(priority = 6, enabled = false)
	public void verifyLoginForRegisteredUser() {

		test = extent.startTest("Sprint 4&5 - Ecom-35 AC#11 ___ Verify Login Error Message for Registered User on Registration Page");
		try {

			System.out.println("Click on Register");
			Log.info("Click on Register");
			HomePage home = new HomePage(driver);
			home.clickReg();

			System.out.println("Enter Registration Details");
			Log.info("Enter Registration Details");
			test.log(LogStatus.INFO, "Enter Registration Details");
			home.enterRegDetailsForAlreadyRegisteredUser();

			System.out.println("Enter Registration Details");
			Log.info("Enter Registration Details");
			test.log(LogStatus.INFO, "Enter Registration Details");
			home.verifyErrorMsgForAlreadyRegisteredUser();

		} catch (Exception e) {
			test.log(LogStatus.FATAL,
					"Verify Login Error Message for Registered User on Registration Page was unsuccessful");
			e.printStackTrace();
			Assert.fail(e.getMessage());

		}
	}
}
