package com.tcs.BsiShopRedesign.pages;

import org.apache.commons.lang3.RandomStringUtils;
import org.apache.http.impl.client.EntityEnclosingRequestWrapper;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

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
			Thread.sleep(2000);
			System.out.println("Click Enter Payment Details");
			test.log(LogStatus.INFO, "Click Enter Payment Details");
			Log.info("Click Enter Payment Details");
			CommonHelper.scrolltoview("paymentDetails_id");
			//click("paymentDetails_id");
			driver.findElement(By.id("opc-shipping-btn")).click();

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

			Thread.sleep(2000);
			System.out.println("Click Submit");
			test.log(LogStatus.INFO, "Click Submit");
			Log.info("Click Submit");
			// CommonHelper.clickByJS("paySubmit_id");
			click("paySubmit_id");
			driver.switchTo().defaultContent();

		} catch (Exception e) {
			CommonHelper.reportFailure("Enter Card Details was unsuccessful");
			e.printStackTrace();
		}

	}

	public void enterOrderDetails() {

		try {
			// driver.switchTo().defaultContent();
			System.out.println("Select Country");
			test.log(LogStatus.INFO, "Select Country");
			Log.info("Select Country");
			selectDpdwnText("country_xpath", "United Kingdom");

			System.out.println("Click Review Order");
			test.log(LogStatus.INFO, "Click Review Order");
			Log.info("Click Review Order");
			click("reviewOrder_xpath");

			 Thread.sleep(3000);
			System.out.println("Check Terms and Conditions");
			test.log(LogStatus.INFO, "Check Terms and Conditions");
			Log.info("Check Terms and Conditions");
			CommonHelper.scrolltoview("termsCond_css");
			CommonHelper.elementToBeVisible("termsCond_css");
			click("termsCond_css");

			System.out.println("Click Complete Your Order");
			test.log(LogStatus.INFO, "Click Complete Your Order");
			Log.info("Click Place Order");
			//CommonHelper.scrolltoview("completeOrder_id");
			click("completeOrder_id");
			//driver.findElement(By.id("place-order-trigger")).click();

		} catch (Exception e) {
			CommonHelper.reportFailure("Enter Order Details was unsuccesful");
			e.printStackTrace();
		}
	}

	public void confirmOrderDetails() {

		try {
			String confirmOrder = CommonHelper.element("confirmOrder_xpath").getText();
			if (confirmOrder.contains("Thank you for your order")) {
				test.log(LogStatus.PASS, confirmOrder);
				System.out.println(confirmOrder);
			} else {
				test.log(LogStatus.FAIL, "Placing of order was unsuccesful");
				System.out.println("Placing of order was unsuccesful");
			}
		} catch (Exception e) {
			CommonHelper.reportFailure("Placing of order was unsuccesful");
			e.printStackTrace();
		}

	}

	public void enterNonUKOrderDetails() {

		try {
			// driver.switchTo().defaultContent();
			System.out.println("Select Country");
			test.log(LogStatus.INFO, "Select Country");
			Log.info("Select Country");
			selectDpdwnText("country_xpath", "Singapore");

			System.out.println("Click Review Order");
			test.log(LogStatus.INFO, "Click Review Order");
			Log.info("Click Review Order");
			click("reviewOrder_xpath");
			Thread.sleep(2000);

		} catch (Exception e) {
			CommonHelper.reportFailure("Enter Non-UK Order Details was unsuccesful");
			e.printStackTrace();
		}
	}

	public void enterUKOrderDetails() {

		try {
			// driver.switchTo().defaultContent();
			System.out.println("Select Country");
			test.log(LogStatus.INFO, "Select Country");
			Log.info("Select Country");
			selectDpdwnText("country_xpath", "United Kingdom");

			System.out.println("Click Review Order");
			test.log(LogStatus.INFO, "Click Review Order");
			Log.info("Click Review Order");
			click("reviewOrder_xpath");

		} catch (Exception e) {
			CommonHelper.reportFailure("Enter UK Order Details was unsuccesful");
			e.printStackTrace();
		}
	}

	public void validateEvidenceErrorMessage() {

		String addressErrorMsg = driver.findElement(By.cssSelector("span[class='error-message']")).getText();
		if (addressErrorMsg.contains("Evidence does not match.")) {
			test.log(LogStatus.PASS, addressErrorMsg);
			System.out.println(addressErrorMsg);
		} else {
			test.log(LogStatus.FAIL, "Validation of Checkout Address was unsuccessful");
			System.out.println("Validation of Checkout Address was unsuccessful");
		}

	}

	public void validateBlockedCountryErrorMessage() {

		String addressErrorMsg = driver.findElement(By.cssSelector("div[class='error-message']")).getText();
		if (addressErrorMsg.contains("The electronic sale is restricted to the selected country")) {
			test.log(LogStatus.PASS, addressErrorMsg);
			System.out.println(addressErrorMsg);
		} else {
			test.log(LogStatus.FAIL, "Validation of Checkout Address was unsuccessful");
			System.out.println("Validation of Checkout Address was unsuccessful");
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

	public void createBillingAddress() {

		try {
			System.out.println("Add New Billing Address");
			test.log(LogStatus.INFO, "Add New Billing Address");
			Log.info("Add New Billing Address");
			selectDpdwnText("selectBillingAddress_id", "New Address");

			Thread.sleep(1000);
			System.out.println("Enter Address Name");
			test.log(LogStatus.INFO, "Enter Address Name");
			String randomString = RandomStringUtils.randomAlphabetic(5);
			String uniqueAddressName = "Reg Unique Name" + randomString;
			driver.findElement(By.cssSelector("input[name='custom_attributes[address_name]']"))
					.sendKeys(uniqueAddressName);
			// driver.findElement(By.cssSelector("input[name='unique_name']")).sendKeys(uniqueAddressName);

			Thread.sleep(1000);
			System.out.println("Enter Title");
			test.log(LogStatus.INFO, "Enter Title");
			Select titleDpdwn = new Select(driver.findElement(By.cssSelector("select[name='prefix']")));
			titleDpdwn.selectByIndex(1);

			Thread.sleep(1000);
			System.out.println("Enter Postal Code");
			test.log(LogStatus.INFO, "Enter Postal Code");
			driver.findElement(By.cssSelector("input[name='postcode']")).sendKeys("AA11AA");

			Thread.sleep(1000);
			System.out.println("Click Find Address");
			test.log(LogStatus.INFO, "Click Find Address");
			driver.findElement(By.cssSelector("button[class='action primary']")).click();

			Thread.sleep(1000);
			System.out.println("Select Address");
			test.log(LogStatus.INFO, "Select Address");
			Select address = new Select(driver.findElement(By.xpath("//*[@id='m2_0']/div/div[2]/select")));
			address.selectByIndex(1);

			Thread.sleep(1000);
			System.out.println("Enter Telephone Number");
			test.log(LogStatus.INFO, "Enter Telephone Number");
			driver.findElement(By.cssSelector("input[name='telephone']")).sendKeys("123456790");

			Thread.sleep(3000);
			System.out.println("Click Save");
			test.log(LogStatus.INFO, "Click Save");
			click("saveNewBillingAddress_css");
			test.log(LogStatus.PASS, "Add New Billing Address was successful");

		} catch (InterruptedException e) {
			CommonHelper.reportFailure("Add Address in Checkout Page was unsuccessful");
			e.printStackTrace();
			Assert.fail(e.getMessage());
		}

	}

	public void createSouthAfricanBillingAddress() {

		try {
			System.out.println("Add New Billing Address");
			test.log(LogStatus.INFO, "Add New Billing Address");
			Log.info("Add New Billing Address");
			selectDpdwnText("selectBillingAddress_id", "New Address");

			Thread.sleep(1000);
			System.out.println("Enter Address Name");
			test.log(LogStatus.INFO, "Enter Address Name");
			String randomString = RandomStringUtils.randomAlphabetic(5);
			String uniqueAddressName = "South Africa" + randomString;
			driver.findElement(By.cssSelector("input[name='custom_attributes[address_name]']")).clear();
			driver.findElement(By.cssSelector("input[name='custom_attributes[address_name]']"))
					.sendKeys(uniqueAddressName);
			// driver.findElement(By.cssSelector("input[name='unique_name']")).sendKeys(uniqueAddressName);

			Thread.sleep(1000);
			System.out.println("Select Title");
			test.log(LogStatus.INFO, "Select Title");
			Select titleDpdwn = new Select(driver.findElement(By.cssSelector("select[name='prefix']")));
			titleDpdwn.selectByIndex(1);

			Thread.sleep(1000);
			System.out.println("Enter Street Address Line One");
			test.log(LogStatus.INFO, "Enter Street Address Line One");
			clearText("streetAddressLineOne_css");
			enterText("streetAddressLineOne_css", "300 Kempston Road");

			Thread.sleep(1000);
			System.out.println("Enter Street Address Line Two");
			test.log(LogStatus.INFO, "Enter Street Address Line Two");
			clearText("streetAddressLineTwo_css");
			enterText("streetAddressLineTwo_css", "Ferguson");

			Thread.sleep(1000);
			System.out.println("Enter Town/City");
			test.log(LogStatus.INFO, "Enter Town/City");
			clearText("checkoutAddressCity_css");
			enterText("checkoutAddressCity_css", "Port Elizabeth");

			Thread.sleep(1000);
			System.out.println("Select Country");
			test.log(LogStatus.INFO, "Select Country");
			selectDpdwnText("checkoutAddressCountry_css", "South Africa");

			Thread.sleep(1000);
			System.out.println("Enter Post Code");
			test.log(LogStatus.INFO, "Enter Post Code");
			clearText("checkoutAddressPostcode_css");
			enterText("checkoutAddressPostcode_css", "6020");

			Thread.sleep(1000);
			System.out.println("Enter Telephone Number");
			test.log(LogStatus.INFO, "Enter Telephone Number");
			driver.findElement(By.cssSelector("input[name='telephone']")).clear();
			driver.findElement(By.cssSelector("input[name='telephone']")).sendKeys("123456790");

			Thread.sleep(3000);
			System.out.println("Click Save");
			test.log(LogStatus.INFO, "Click Save");
			click("saveNewBillingAddress_css");
			test.log(LogStatus.PASS, "South African Billing Address was saved successfully");

		} catch (InterruptedException e) {
			CommonHelper.reportFailure("Add South African Address in Checkout Page was unsuccessful");
			e.printStackTrace();
			Assert.fail(e.getMessage());
		}

	}

	public void verifyBillingAddress(String bllingAddress) {

	}

	public void verifyMemberDetails() {

		try {
			Thread.sleep(2000);
			System.out.println("Verify Member Details on Checkout Page");
			test.log(LogStatus.INFO, "Verify Member Details on Checkout Page");

			String orderSummary = CommonHelper.element("memberDetails_xpath").getText();
			if (orderSummary.contains("Membership")) {
				System.out.println("Membership Application below Band 9 was successful");
				test.log(LogStatus.INFO, "The Order Summary is: " + orderSummary);
				test.log(LogStatus.PASS, "Membership Application below Band 9 was successful");
			} else {
				System.out.println("Membership Application below Band 9was unsuccessful");
				test.log(LogStatus.FAIL, "Membership Application below Band 9 was unsuccessful");
			}
		} catch (InterruptedException e) {
			CommonHelper.reportFailure("Membership Application below Band 9 was unsuccessful");
			e.printStackTrace();
			Assert.fail(e.getMessage());
			e.printStackTrace();
		}
	}

	public void clickContinueShopping() {

		try {
			Thread.sleep(2000);
			System.out.println("Click Continue Shopping");
			test.log(LogStatus.INFO, "Click Continue Shopping");
			CommonHelper.scrolltoview("continueShopping_xpath");
			CommonHelper.clickByJS("continueShopping_xpath");
			// click("continueShopping_xpath");
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			CommonHelper.reportFailure("Click Continue Shopping was unsuccessful");
			e.printStackTrace();
		}
	}

	public void clickEditOrder() {

		try {

			Thread.sleep(5000);
			System.out.println("Click Edit Order on Checkout Page");
			test.log(LogStatus.INFO, "Click Edit Order on Checkout Page");
			driver.findElement(By.id("edit-button")).click();
			// CommonHelper.scrolltoview("editOrder_id");
			// click("editOrder_id");
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			CommonHelper.reportFailure("Click Edit Order on Checkout Page was unsuccessful");
			e.printStackTrace();
		}
	}

	public boolean verifyMemPriceCheckout(String memDisc) {

		try {
			WebElement cartPrice = driver.findElement(By.cssSelector("span[class='cart-price']"));
			String price = cartPrice.getText();
			price = price.substring(1);
			double finalUnitPrice = Double.parseDouble(price);
			String finalPrice = Double.toString(finalUnitPrice);

			if (finalPrice.equals(memDisc)) {
				System.out.println("The member price of the product in the Checkout Page is: " + memDisc);
				test.log(LogStatus.PASS, "The member price of the product in the Checkout Page is: " + memDisc);
				return true;
			} else {
				System.out.println("The member price of the product in the Checkout Page is: " + memDisc);
				test.log(LogStatus.FAIL, "The member price of the product in the Checkout Page is: " + memDisc);
			}
			return false;

		} catch (NumberFormatException e) {
			CommonHelper.reportFailure("The member price in the Checkout Page list is incorrect");
			e.printStackTrace();
		}
		return false;

	}
}
