package com.tcs.BsiShopRedesign.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import com.relevantcodes.extentreports.LogStatus;
import com.tcs.BsiShopRedesign.utilities.CommonHelper;
import com.tcs.BsiShopRedesign.utilities.Page;

public class MembershipPage extends Page {

	public MembershipPage(WebDriver driver) throws Exception {
		super(driver);

	}

	public void enterMembershipDetails() {

		WebDriverWait wait = new WebDriverWait(driver, 120);
		try {
			CommonHelper.waitForLoad(driver);
			System.out.println("Select Organisation");
			test.log(LogStatus.INFO, "Select Organisation");
			Log.info("Select Organisation");
			CommonHelper.elementToBeVisible("selectOrganisation_id");
			CommonHelper.elementToBeClickable("selectOrganisation_id");
			selectDpdwnText("selectOrganisation_id",
					"D - Educational, Housing Associations and Healthcare establishments");

			System.out.println("Click Get Quote");
			test.log(LogStatus.INFO, "Click Get Quoten");
			Log.info("Click Get Quote");
			CommonHelper.elementToBeClickable("getQuote_id");
			click("getQuote_id");

			System.out.println("Click Cost Membership Continue ");
			test.log(LogStatus.INFO, "Click Cost Membership Continue");
			Log.info("Click Cost Membership Continue");
			click("continue_id");

			System.out.println("Select Membership Address ");
			test.log(LogStatus.INFO, "Select Membership Address ");
			Log.info("Select Membership Address ");
			selectFirstOption("memberAddress_id");

			/*
			 * System.out.println("Enter Company Billing Email"); test.log(LogStatus.INFO,
			 * "Enter Company Billing Email"); Log.info("Enter Company Billing Email");
			 * clearText("compBillEmail_id"); enterText("compBillEmail_id",
			 * "compBill@tcs.com");
			 */

			System.out.println("Enter Company Billing Email");
			test.log(LogStatus.INFO, "Enter Company Billing Email");
			Log.info("Enter Company Billing Email");
			enterText("compBillEmail_id", "compBill@tcs.com");

			System.out.println("Enter Firtst Name");
			test.log(LogStatus.INFO, "Enter Firtst Name");
			Log.info("Enter Firtst Name");
			enterText("deliveryFirstName_id", "Brad");

			System.out.println("Enter Firtst Name");
			test.log(LogStatus.INFO, "Enter Firtst Name");
			Log.info("Enter Firtst Name");
			enterText("deliveryLastName_id", "Pitt");

			System.out.println("Enter Job Title");
			test.log(LogStatus.INFO, "Enter Job Title");
			Log.info("Enter Job Title");
			enterText("deliveryJob_id", "Delivery Job");

			System.out.println("Enter Telephone Number");
			test.log(LogStatus.INFO, "Enter Telephone Number");
			Log.info("Enter Telephone Number");
			enterText("deliveryPhone_id", "465978132");

			System.out.println("Enter Email ID");
			test.log(LogStatus.INFO, "Enter Email ID");
			Log.info("Enter Email ID");
			enterText("deliveryEmail_id", "delivery@tcs.com");

			System.out.println("Check Self Declaration");
			test.log(LogStatus.INFO, "Check Self Declaration");
			Log.info("Check Self Declaration");
			click("selfDeclaration_id");

		} catch (Exception e) {
			e.printStackTrace();
			CommonHelper.reportFailure("Enter Membership Details was unsuccessful");
			Assert.fail(e.getMessage());
		}
	}

	public void addToBasket() {

		try {
			System.out.println("Click Add to Basket");
			test.log(LogStatus.INFO, "Click Add to Basket");
			Log.info("Click Add to Basket");
			click("memberAddToBasket_id");

		} catch (Exception e) {
			e.printStackTrace();
			CommonHelper.reportFailure("Add to Basket was unsuccessful");
			Assert.fail(e.getMessage());
		}

	}

	public void enterMembershipDetailsAboveBandNine() {

		WebDriverWait wait = new WebDriverWait(driver, 120);
		try {
			CommonHelper.waitForLoad(driver);
			System.out.println("Select Organisation");
			test.log(LogStatus.INFO, "Select Organisation");
			Log.info("Select Organisation");
			CommonHelper.elementToBeVisible("selectOrganisation_id");
			CommonHelper.elementToBeClickable("selectOrganisation_id");
			selectDpdwnText("selectOrganisation_id", "A - Partnerships and Consultancy services");

			System.out.println("Select Number of Employees");
			test.log(LogStatus.INFO, "Select Number of Employees");
			Log.info("Select Number of Employees");
			CommonHelper.elementToBeVisible("numOfEmployees_id");
			CommonHelper.elementToBeClickable("numOfEmployees_id");
			selectDpdwnText("numOfEmployees_id", "1401+");

			System.out.println("Click Get Quote");
			test.log(LogStatus.INFO, "Click Get Quote");
			Log.info("Click Get Quote");
			CommonHelper.elementToBeClickable("getQuote_id");
			click("getQuote_id");

		} catch (Exception e) {
			e.printStackTrace();
			CommonHelper.reportFailure("Add to Basket was unsuccessful");
			Assert.fail(e.getMessage());
		}
	}

	public void verifyMemberMessage() {

		try {
			String bandNineMsg = driver.findElement(By.id("message")).getText();
			if (bandNineMsg.contains("higher membership bandings and may qualify for additional benefits.")) {
				test.log(LogStatus.INFO, "The verification message is: " + bandNineMsg);
				test.log(LogStatus.PASS, "Membership Application for above Band 9 was successful");
			} else {
				test.log(LogStatus.FAIL, "Membership Application for above Band 9 was unsuccessful");
				CommonHelper.reportFailure("Membership Application for above Band 9 was unsuccessful");
			}
		} catch (Exception e) {
			CommonHelper.reportFailure("Membership Application for above Band 9 was unsuccessful");
			e.printStackTrace();
		}

	}

}
