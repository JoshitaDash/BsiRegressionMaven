package com.tcs.BsiShopRedesign.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

import com.relevantcodes.extentreports.LogStatus;
import com.tcs.BsiShopRedesign.utilities.BsiConstants;
import com.tcs.BsiShopRedesign.utilities.CommonHelper;
import com.tcs.BsiShopRedesign.utilities.Page;

public class CheckoutPage extends Page {

	public CheckoutPage(WebDriver driver) throws Exception {
		super(driver);
	}

	public void clickMiniCartCheckout() {

		System.out.println("Hover on Basket");
		test.log(LogStatus.INFO, "Hover on Basket");
		Log.info("Hover on Basket");
		mouseHover("mouseHoverBasket_xpath");

		System.out.println("Click Checkout");
		test.log(LogStatus.INFO, "Click Checkout");
		Log.info("Click Checkout");
		click("miniCartCheckout_xpath");
	}

	public void signIn() {

		System.out.println("Enter Email");
		test.log(LogStatus.INFO, "Enter Email");
		Log.info("Enter Email");
		enterText("email_id", BsiConstants.getEnvDetails().get("username"));

		System.out.println("Enter Password");
		test.log(LogStatus.INFO, "Enter Password");
		Log.info("Enter Password");
		enterText("password_id", BsiConstants.getEnvDetails().get("password"));

		System.out.println("Click SignIn");
		test.log(LogStatus.INFO, "Click SignIn");
		Log.info("Click SignIn");
		click("signIn_css");
	}

	public void enterPaymentDetails() throws InterruptedException {

		try {
			System.out.println("Click on Payment Details");
			test.log(LogStatus.INFO, "Click on Payment Details");
			Log.info("Click on Payment Details");
			click("paymentDetails_id");

			System.out.println("Click Pay by Credit Card");
			test.log(LogStatus.INFO, "Click Pay by Credit Card");
			Log.info("Click Pay by Credit Card");
			click("payCard_id");
			// driver.switchTo().frame(0);

			Thread.sleep(2000);
			System.out.println("Select VISA Credit Card");
			test.log(LogStatus.INFO, "Select VISA Credit Card");
			Log.info("Select VISA Credit Card");

			boolean selectCard = driver.findElement(By
					.xpath("//*[@id='checkout-payment-method-load']/div[2]/div[2]/fieldset/div[2]/div/label/span/span"))
					.isDisplayed();
			if (selectCard) {
				click("selectCard_xpath");
			}
			selectDpdwnText("creditCard_id", "VISA");

			driver.switchTo().frame(0);
			System.out.println("Enter Card Number");
			test.log(LogStatus.INFO, "Enter Card Number");
			Log.info("Enter Card Number");
			enterText("cardNum_id", "4111111111111111");

			System.out.println("Enter Cardholder's Name");
			test.log(LogStatus.INFO, "Enter Cardholder's Name");
			Log.info("Enter Cardholder's Name");
			enterText("cardholderName_id", "Tom Cruise");

			System.out.println("Enter Card Expiry Month");
			test.log(LogStatus.INFO, "Enter Card Expiry Month");
			Log.info("Enter Card Expiry Month");
			selectDpdwnValue("payExpMonth_id", "12");

			System.out.println("Enter Card Expiry Year");
			test.log(LogStatus.INFO, "Enter Card Expiry Year");
			Log.info("Enter Card Expiry Year");
			selectDpdwnValue("payExpYear_id", "2058");

			System.out.println("Enter CVC Number");
			test.log(LogStatus.INFO, "Enter CVC Number");
			Log.info("Enter CVC Number");
			enterText("payCvc_id", "000");

			System.out.println("Click Submit");
			test.log(LogStatus.INFO, "Click Submit");
			Log.info("Click Submit");
			click("paySubmit_id");

		} catch (Exception e) {
			CommonHelper.reportFailure("Enter Card Details was unsuccessful");
			e.printStackTrace();
		}

	}

	public void enterOrderDetails() {

		try {
			driver.switchTo().defaultContent();
			System.out.println("Select Country");
			test.log(LogStatus.INFO, "Select Country");
			Log.info("Select Country");
			selectDpdwnText("country_xpath", "United Kingdom");

			System.out.println("Click Review Order");
			test.log(LogStatus.INFO, "Click Review Order");
			Log.info("Click Review Order");
			click("reviewOrder_xpath");

			// Thread.sleep(10000);
			System.out.println("Check Terms and Conditions");
			test.log(LogStatus.INFO, "Check Terms and Conditions");
			Log.info("Check Terms and Conditions");
			CommonHelper.elementToBeVisible("termsCond_xpath");
			click("termsCond_xpath");

			System.out.println("Click Place Order");
			test.log(LogStatus.INFO, "Click Place Order");
			Log.info("Click Place Order");
			click("placeOrder_id");

		} catch (Exception e) {
			CommonHelper.reportFailure("Enter Order Details was unsuccesful");
			e.printStackTrace();
		}
	}

	public void confirmOrderDetails() {

		String confirmOrder = CommonHelper.element("confirmOrder_xpath").getText();
		if (confirmOrder.contains("Thank you for your order")) {
			test.log(LogStatus.PASS, confirmOrder);
			System.out.println(confirmOrder);
		} else {
			test.log(LogStatus.FAIL, "Placing of order was unsuccesful");
			System.out.println("Placing of order was unsuccesful");
		}

	}

	public String editBillingAddress() {

		String billingAddress = null;

		try {
			System.out.println("Click on Edit Billing Address");
			test.log(LogStatus.INFO, "Click on Edit Billing Address");
			Log.info("Click on Edit Billing Address");
			CommonHelper.elementToBeClickable("editBillingAddress_xpath");
			click("editBillingAddress_xpath");

			Thread.sleep(1000);
			System.out.println("Click Find Address");
			test.log(LogStatus.INFO, "Click Find Address");
			driver.findElement(By.cssSelector("button[class='action primary']")).click();

			Thread.sleep(1000);
			System.out.println("Select Address");
			test.log(LogStatus.INFO, "Select Address");
			Select address = new Select(driver.findElement(By.xpath("//*[@id='m2_address']/div/div/div[2]/select")));
			address.selectByIndex(4);

			Thread.sleep(1000);
			System.out.println("Click Submit");
			test.log(LogStatus.INFO, "Edit Submit");
			driver.findElement(By.cssSelector("button[class='redbuttonsubmit']")).click();
			test.log(LogStatus.PASS, "Edit Billing Address was successful");

			billingAddress = driver.findElement(By.cssSelector("span[data-bind='html: addressText']")).getText();
			billingAddress = billingAddress.replace("[Edit]", "");
			System.out.println("The updated Billing Address is: " + billingAddress);

		} catch (InterruptedException e) {
			CommonHelper.reportFailure("Edit Billing Address was unsuccessful");
			e.printStackTrace();
		}
		return billingAddress;
	}

	public void verifyBillingAddress(String bllingAddress) {
		

	}
}
