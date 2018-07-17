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
			test.log(LogStatus.INFO, "Add to Basket from Member Benefits Tab");
			System.out.println("Add to Basket from Member Benefits Tab");
			Log.info("Add to Basket from Member Benefits Tab");

			WebElement addToBasket = driver.findElements(By.cssSelector("input[value='Add to Basket']")).get(1);
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

	public void clickLogout() {

		try {
			Thread.sleep(1000);
			Log.info("Click Logout");
			System.out.println("Click Logout");
			test.log(LogStatus.INFO, "Click Logout");
			click("logoutButton_xpath");
			Thread.sleep(2000);
			test.log(LogStatus.PASS, "Logged Out Successfully");

		} catch (Exception e) {
			CommonHelper.reportFailure("Click Logout was unsuccessful");
			Assert.fail(e.getMessage());
			e.printStackTrace();
		}
	}
}
