package com.tcs.BsiShopRedesign.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.openqa.selenium.WebElement;
import com.relevantcodes.extentreports.LogStatus;

import com.tcs.BsiShopRedesign.utilities.Page;
import com.tcs.BsiShopRedesign.utilities.CommonHelper;

public class MyProfileMemberPage extends Page {

	public MyProfileMemberPage(WebDriver driver) throws Exception {
		super(driver);
	}

	public void clickMemberTab() {

		try {
			test.log(LogStatus.INFO, "Click on Member Tab");
			System.out.println("Click on Member Tab");
			Log.info("Click on Member Tab");
			click("memberBenefitsTab_id");
		} catch (Exception e) {
			CommonHelper.reportFailure("Click on Member Tab was unsuccessful");
			Assert.fail(e.getMessage());
			e.printStackTrace();
		}
	}

	public void verifyMemberStatus() {

		try {

			test.log(LogStatus.INFO, "Check membership status");
			System.out.println("Check membership status");
			Log.info("Check membership status");
			WebElement stat = driver.findElement(By.xpath("//*[@id='status']"));
			String status = stat.getAttribute("value");

			if (status != null && status.contains("Active")) {
				test.log(LogStatus.PASS, "The Membership status is: " + status);
				System.out.println("The Membership status is: " + status);
				Log.info("The Membership status is: " + status);
			} else {
				test.log(LogStatus.FAIL, "The Membership status is: " + status);
				System.out.println("The Membership status is: " + status);
			}

		} catch (Exception e) {
			CommonHelper.reportFailure("Check membership status was unsuccessful");
			Assert.fail(e.getMessage());
			e.printStackTrace();
		}
	}

	public void verifyMemberNumber() {

		try {

			test.log(LogStatus.INFO, "Check membership number");
			System.out.println("Check membership number");
			Log.info("Check membership number");
			WebElement num = driver.findElement(By.id("membershipnumber"));
			// String number = num.getText();
			String number = num.getAttribute("value");

			System.out.println("The Membership number is: " + number);
			test.log(LogStatus.PASS, "The Membership number is: " + number);
			Log.info("The Membership number is: " + number);

		} catch (Exception e) {
			CommonHelper.reportFailure("Check membership number was unsuccessful");
			Assert.fail(e.getMessage());
			e.printStackTrace();
		}
	}

	public void verifyMemberExpDate() {

		try {

			test.log(LogStatus.INFO, "Check membership Expiry Date");
			System.out.println("Check membership Expiry Date");
			Log.info("Check membership Expiry Date");
			WebElement date = driver.findElement(By.id("membershipexpirydate"));
			String expDate = date.getAttribute("value");

			System.out.println("The Membership Expiry Date is: " + expDate);
			test.log(LogStatus.PASS, "The Membership Expiry Date is: " + expDate);
			Log.info("The Membership Expiry Date is: " + expDate);

		} catch (Exception e) {
			CommonHelper.reportFailure("Check membership Expiry Date was unsuccessful");
			Assert.fail(e.getMessage());
			e.printStackTrace();
		}
	}

	public void verifyMemberCreditAmnt() {

		try {

			test.log(LogStatus.INFO, "Check membership Credit Amount");
			System.out.println("Check membership Credit Amount");
			Log.info("Check membership Credit Amount");
			WebElement amnt = driver.findElement(By.id("creditamount"));
			String creditAmnt = amnt.getAttribute("value");

			System.out.println("The Membership Credit Amount is: " + creditAmnt);
			test.log(LogStatus.PASS, "The Membership Credit Amount is: " + creditAmnt);
			Log.info("The Membership Credit Amount is: " + creditAmnt);

		} catch (Exception e) {
			CommonHelper.reportFailure("Check membership Credit Amount was unsuccessful");
			Assert.fail(e.getMessage());
			e.printStackTrace();
		}
	}

	public void addToBasketFromMemTab() {

		try {
			test.log(LogStatus.INFO, "Add Invoice to Basket from Member Benefits Tab");
			System.out.println("Add Invoice to Basket from Member Benefits Tab");
			Log.info("Add Invoice to Basket from Member Benefits Tab");

			WebElement addToBasket = driver.findElements(By.cssSelector("input[value='Add to Basket']")).get(0);
			addToBasket.click();

			Thread.sleep(2000);
			System.out.println("Click on View Basket");
			test.log(LogStatus.INFO, "Click on View Basket ");
			Log.info("Click on View Basket");
			driver.findElement(By.xpath("//*[@id='basket']/div/a")).click();

		} catch (Exception e) {
			CommonHelper.reportFailure("Add to Basket from Member Benefits Tab was unsuccessful");
			Assert.fail(e.getMessage());
			e.printStackTrace();
		}
	}

	public void clickRenewMembership() {

		try {
			test.log(LogStatus.INFO, "Click Renew Membership");
			System.out.println("Click Renew Membership");
			Log.info("Click Renew Membership");
			WebElement renewMembership = driver.findElements(By.cssSelector("a[title*='Renew Membership']")).get(0);
			String renewMemText = renewMembership.getText();
			test.log(LogStatus.INFO, "The Membership number is: " + renewMemText);
			System.out.println("The Membership number is: " + renewMemText);
			renewMembership.click();
		} catch (Exception e) {

			CommonHelper.reportFailure("Click Renew Membership was unsuccessful");
			Assert.fail(e.getMessage());
			e.printStackTrace();
		}

	}

	public void renewMembershipToBasket() {

		try {
			test.log(LogStatus.INFO, "Add Renew Membership to Basket");
			System.out.println("Add Renew Membership to Basket");
			Log.info("Add Renew Membership to Basket");
			click("addToBasketMembership_id");

			Thread.sleep(2000);
			System.out.println("Click on View Basket");
			test.log(LogStatus.INFO, "Click on View Basket ");
			Log.info("Click on View Basket");
			driver.findElement(By.xpath("//*[@id='basket']/div/a")).click();

		} catch (Exception e) {
			CommonHelper.reportFailure("Add Renew Membership to Basket was unsuccessful");
			Assert.fail(e.getMessage());
			e.printStackTrace();
		}
	}

	public void enterEmailID() {
		try {
			Thread.sleep(1000);
			Log.info("Enter Email ID");
			System.out.println("Enter Email ID");
			test.log(LogStatus.INFO, "Enter Email ID");
			enterText("memEmail_id", "abc@tcs.com");

		} catch (InterruptedException e) {
			CommonHelper.reportFailure("Enter Email ID was unsuccessful");
			Assert.fail(e.getMessage());
			e.printStackTrace();
		}
	}

	public void clickSend() {
		try {
			Thread.sleep(1000);
			Log.info("Click on Send Email");
			System.out.println("Click on Send Email");
			test.log(LogStatus.INFO, "Click on Send Email");
			click("emailSend_id");

		} catch (InterruptedException e) {
			CommonHelper.reportFailure("Click on Send Email was unsuccessful");
			Assert.fail(e.getMessage());
			e.printStackTrace();
		}
	}

	public void verifySuccessMsg() {
		try {
			Thread.sleep(1000);
			Log.info("Verify Success Message");
			System.out.println("Verify Success Message");
			test.log(LogStatus.INFO, "Verify Success Message");
			String successMsg = driver.findElement(By.id("successmessage")).getText();
			if (successMsg.contains("Thank you")) {
				System.out.println("The Success Message is: " + successMsg);
				test.log(LogStatus.PASS, "The Success Message is: " + successMsg);
			} else {
				System.out.println("The Verification of Success Message failed");
				test.log(LogStatus.FAIL, "The Verification of Success Message failed");
			}

		} catch (InterruptedException e) {
			CommonHelper.reportFailure("Verify Success Message was unsuccessful");
			Assert.fail(e.getMessage());
			e.printStackTrace();
		}
	}

	public void enterMemNum() {

		String memNumText = "65478915";
		try {
			Log.info("Enter Membership Number");
			System.out.println("Enter Membership Number");
			test.log(LogStatus.INFO, "Enter Membership Number");
			enterText("memNumber_id", memNumText);
			test.log(LogStatus.INFO, "The Membership number entered is: " + memNumText);

			System.out.println("Click Update");
			Log.info("Click Update");
			test.log(LogStatus.INFO, "Click Update");
			click("profileUpdate_id");
			Thread.sleep(2000);

		} catch (Exception e) {
			CommonHelper.reportFailure("Enter Membership Number was unsuccessful");
			e.printStackTrace();
		}
	}

	public void verifyErrorMsg() {

		try {
			Log.info("Verify Error Message for Member Number");
			System.out.println("Verify Error Message for Member Number ");
			test.log(LogStatus.INFO, "Verify Error Message for Member Number");
			String memNumErrorMsg = driver.findElements(By.id("member-error-message")).get(0).getText();
			if (memNumErrorMsg.contains("Membership Number and Billing Address don't match")) {
				System.out.println("The Error Message is: " + memNumErrorMsg);
				test.log(LogStatus.PASS, "The Error Message is: " + memNumErrorMsg);
			} else {
				System.out.println("The Error Message is: " + memNumErrorMsg);
				test.log(LogStatus.FAIL, "The Error Message is: " + memNumErrorMsg);
			}
		} catch (Exception e) {
			CommonHelper.reportFailure("Verification of Member Number Error Message was unsuccessful");
			e.printStackTrace();
		}
	}
}
