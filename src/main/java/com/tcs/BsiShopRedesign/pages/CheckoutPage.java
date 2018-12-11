package com.tcs.BsiShopRedesign.pages;

import java.util.List;

import org.apache.commons.lang3.RandomStringUtils;
import org.apache.http.impl.client.EntityEnclosingRequestWrapper;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.DoubleClickAction;
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

		try {
			Thread.sleep(2000);
			System.out.println("Hover on Basket");
			test.log(LogStatus.INFO, "Hover on Basket");
			Log.info("Hover on Basket");
			mouseHover("mouseHoverBasket_xpath");
			Thread.sleep(2000);

			System.out.println("Click Checkout");
			test.log(LogStatus.INFO, "Click Checkout");
			Log.info("Click Checkout");
			click("miniCartCheckout_xpath");
			Thread.sleep(1000);
			
		} catch (InterruptedException e) {
			CommonHelper.reportFailure("Click Checkout from mini cart was unsuccessful");
			e.printStackTrace();
		}
	}

	public void signIn() {

		try {
			System.out.println("Enter Email");
			test.log(LogStatus.INFO, "Enter Email");
			Log.info("Enter Email");
			enterText("email_id", BsiConstants.getEnvDetails().get("username"));
			System.out.println(BsiConstants.getEnvDetails().get("username"));
			Thread.sleep(2000);

			System.out.println("Enter Password");
			test.log(LogStatus.INFO, "Enter Password");
			Log.info("Enter Password");
			enterText("password_id", BsiConstants.getEnvDetails().get("password"));
			System.out.println(BsiConstants.getEnvDetails().get("password"));
			Thread.sleep(2000);

			System.out.println("Click SignIn");
			test.log(LogStatus.INFO, "Click SignIn");
			Log.info("Click SignIn");
			click("signIn_css");
		} catch (InterruptedException e) {
			CommonHelper.reportFailure("Sign In was unsuccessful");
			e.printStackTrace();
		}
	}

	public void enterCardPaymentDetails() throws InterruptedException {

		try {
			Thread.sleep(5000);
			System.out.println("Enter Payment Details");
			test.log(LogStatus.INFO, "Enter Payment Details");
			Log.info("Enter Payment Details");
			CommonHelper.scrolltoview("paymentDetails_id");
			click("paymentDetails_id");
			Thread.sleep(1000);
			// click("paymentDetails_id");
			// driver.findElement(By.id("opc-shipping-btn")).click();

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
			clearText("cardNum_id");
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
			clearText("payCvc_id");
			enterText("payCvc_id", "000");

			Thread.sleep(5000);
			System.out.println("Click Submit");
			test.log(LogStatus.INFO, "Click Submit");
			Log.info("Click Submit");
			CommonHelper.clickByJS("paySubmit_id");
			// CommonHelper.scrolltoview("paySubmit_id");
			// click("paySubmit_id");
			driver.switchTo().defaultContent();

		} catch (Exception e) {
			CommonHelper.reportFailure("Enter Card Details was unsuccessful");
			e.printStackTrace();
		}

	}

	public void verifyIncorrectCardPaymentDetails() {
		
		try {
			
			Thread.sleep(5000);
			System.out.println("Enter Payment Details");
			test.log(LogStatus.INFO, "Enter Payment Details");
			Log.info("Enter Payment Details");
			CommonHelper.scrolltoview("paymentDetails_id");
			click("paymentDetails_id");
			Thread.sleep(1000);

			System.out.println("Click Pay by Credit Card");
			test.log(LogStatus.INFO, "Click Pay by Credit Card");
			Log.info("Click Pay by Credit Card");
			click("payCard_id");

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
			System.out.println("Enter Incorrect Card Number");
			test.log(LogStatus.INFO, "Enter Incorrect Card Number");
			Log.info("Enter Incorrect Card Number");
			enterText("cardNum_id", "4561538");

			Thread.sleep(2000);
			System.out.println("Click Outside Fields");
			test.log(LogStatus.INFO, "Click Outside Fields");
			Log.info("Click Outside Fields");
			driver.findElement(By.id("payment-cardholdername-container")).click();

			String cardNumValidation = driver.findElement(By.cssSelector("span[data-valmsg-for='Card.CardNumber']"))
					.getText();
			if (cardNumValidation.contains("enter a valid card number.")) {
				System.out.println("The validation message for Card Number is: " + cardNumValidation);
				test.log(LogStatus.INFO, "The validation message for Card Number is: " + cardNumValidation);
				System.out.println("Verification of invalid card number was successful");
				test.log(LogStatus.PASS, "Verification of invalid card number was successful");
			} else {
				test.log(LogStatus.FAIL, "The validation message for Card Number is: " + cardNumValidation);
				System.out.println("Verification of invalid card number was unsuccessful");
			}
			Thread.sleep(2000);
			System.out.println("Enter Card Expiry Month");
			test.log(LogStatus.INFO, "Enter Card Expiry Month");
			Log.info("Enter Card Expiry Month");
			selectDpdwnText("payExpMonth_id", "3");

			System.out.println("Enter Card Expiry Year");
			test.log(LogStatus.INFO, "Enter Card Expiry Year");
			Log.info("Enter Card Expiry Year");
			selectDpdwnText("payExpYear_id", "2018");

			Thread.sleep(2000);
			String cardExpiryDateValidation = driver
					.findElement(By.xpath("//*[@id='payment-expirymonth-error-container']/span/span/p")).getText();
			if (cardExpiryDateValidation.contains("Please provide a valid expiry date")) {
				System.out.println("The validation message for Card Expiry Date is: " + cardExpiryDateValidation);
				test.log(LogStatus.INFO, "The validation message for Card Expiry Date is: " + cardExpiryDateValidation);
				System.out.println("Verification of invalid Card Expiry Date was successful");
				test.log(LogStatus.PASS, "Verification of invalid Card Expiry Date was successful");
			} else {
				test.log(LogStatus.FAIL, "The validation message for Card Expiry Date is: " + cardExpiryDateValidation);
				System.out.println("Verification of invalid Card Expiry Date was unsuccessful");
			}

			Thread.sleep(2000);
			System.out.println("Enter Incorrect CVC Number");
			test.log(LogStatus.INFO, "Enter Incorrect CVC Number");
			Log.info("Enter Incorrect CVC Number");
			enterText("payCvc_id", "1245");

			Thread.sleep(2000);
			System.out.println("Click Submit");
			test.log(LogStatus.INFO, "Click Submit");
			Log.info("Click Submit");
			CommonHelper.clickByJS("paySubmit_id");

			Thread.sleep(2000);
			String cardCvvNumValidation = driver
					.findElement(By.xpath("//*[@id='payment-cvc-error-container']/span/span/p")).getText();
			if (cardCvvNumValidation.contains("The CVC you have entered is not correct")) {
				System.out.println("The validation message for Card CVC Number is: " + cardCvvNumValidation);
				test.log(LogStatus.INFO, "The validation message for Card CVC Number is: " + cardCvvNumValidation);
				System.out.println("Verification of invalid Card CVC Number was successful");
				test.log(LogStatus.PASS, "Verification of invalid Card CVC Number was successful");
			} else {
				test.log(LogStatus.FAIL, "The validation message for Card CVC Number is: " + cardCvvNumValidation);
				System.out.println("Verification of invalid Card CVC Number was unsuccessful");
			}

			Thread.sleep(2000);
			String cardHolderNameValidation = driver
					.findElement(By.xpath("//*[@id='payment-cardholdername-error-container']/span/span/p")).getText();
			if (cardHolderNameValidation.contains("Cardholder's name is required.")) {
				System.out.println("The validation message for Card Holder's name is: " + cardHolderNameValidation);
				test.log(LogStatus.INFO,
						"The validation message for Card Holder's name is: " + cardHolderNameValidation);
				System.out.println("Verification of invalid Card Holder's name was successful");
				test.log(LogStatus.PASS, "Verification of invalid Card Holder's name was successful");
			} else {
				test.log(LogStatus.FAIL,
						"The validation message for Card Holder's name is: " + cardHolderNameValidation);
				System.out.println("Verification of invalid Card Holder's name was unsuccessful");
			}

		} catch (Exception e) {
			CommonHelper.reportFailure("Enter Incorrect Card Details was unsuccessful");
			e.printStackTrace();
		}

	}

	public void enterValidCardPaymentDetails() {

		try {

			System.out.println("Enter Valid Card Number");
			test.log(LogStatus.INFO, "Enter Valid Card Number");
			Log.info("Enter Valid Card Number");
			CommonHelper.scrolltoview("cardNum_id");
			clearText("cardNum_id");
			enterText("cardNum_id", "4111111111111111");

			System.out.println("Enter Cardholder's Name");
			test.log(LogStatus.INFO, "Enter Cardholder's Name");
			Log.info("Enter Cardholder's Name");
			enterText("cardholderName_id", "Tom Cruise");

			System.out.println("Enter Card Expiry Month");
			test.log(LogStatus.INFO, "Enter Card Expiry Month");
			Log.info("Enter Card Expiry Month");
			selectDpdwnText("payExpMonth_id", "5");

			System.out.println("Enter Card Expiry Year");
			test.log(LogStatus.INFO, "Enter Card Expiry Year");
			Log.info("Enter Card Expiry Year");
			selectDpdwnText("payExpYear_id", "2058");

			System.out.println("Enter CVC Number");
			test.log(LogStatus.INFO, "Enter CVC Number");
			Log.info("Enter CVC Number");
			clearText("payCvc_id");
			enterText("payCvc_id", "000");

			Thread.sleep(5000);
			System.out.println("Click Submit");
			test.log(LogStatus.INFO, "Click Submit");
			Log.info("Click Submit");
			CommonHelper.clickByJS("paySubmit_id");
			// CommonHelper.scrolltoview("paySubmit_id");
			// click("paySubmit_id");
			driver.switchTo().defaultContent();

		} catch (InterruptedException e) {
			CommonHelper.reportFailure("Enter valid card details was unsuccessful");
			e.printStackTrace();
		}

	}

	public void clickReviewOrder() {

		try {
			// driver.switchTo().defaultContent();
			System.out.println("Select Card Billing Country");
			test.log(LogStatus.INFO, "Select Card Billing Country");
			Log.info("Select Country");
			selectDpdwnText("country_xpath", "United Kingdom");

			System.out.println("Click Review Order");
			test.log(LogStatus.INFO, "Click Review Order");
			Log.info("Click Review Order");
			click("reviewOrder_xpath");
			Thread.sleep(5000);
		} catch (Exception e) {
			CommonHelper.reportFailure("Click Review Order was unsuccesful");
			e.printStackTrace();
		}
	}

	public void confirmOrderDetailsOnly() {
		try {
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
			// CommonHelper.scrolltoview("completeOrder_id");
			click("completeOrder_id");
			// CommonHelper.scrolltoview("completeOrder_id");
		} catch (InterruptedException e) {
			CommonHelper.reportFailure("Confirm Order Details was unsuccessful");
			e.printStackTrace();
		}

	}

	public void enterOrderDetails() {
		try {
			// driver.switchTo().defaultContent();
			System.out.println("Select Card Billing Country");
			test.log(LogStatus.INFO, "Select Card Billing Country");
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
			// CommonHelper.scrolltoview("completeOrder_id");
			click("completeOrder_id");
			// driver.findElement(By.id("place-order-trigger")).click();

		} catch (Exception e) {
			CommonHelper.reportFailure("Enter Order Details was unsuccesful");
			e.printStackTrace();
		}
	}

	public void verifyReviewOrderMemberPrice(String searchMemPrice) {

		boolean priceMismatch = false;
		List<WebElement> price = driver.findElements(By.cssSelector("span[class='price']"));

		try {
			Thread.sleep(1000);
			try {
				priceMismatch = driver.findElement(By.cssSelector("div[class='price-mismatch']")).isDisplayed();
				Thread.sleep(3000);
			} catch (Exception e) {
				e.printStackTrace();
			}

			if (priceMismatch) {
				Thread.sleep(1000);
				String priceMismatchText = driver.findElement(By.cssSelector("div[class='price-mismatch']")).getText();
				System.out.println("The Price Mismatch message is: " + priceMismatchText);
				test.log(LogStatus.INFO, "The Price Mismatch message is: " + priceMismatchText);

				String orderSummaryPrice = price.get(0).getText();
				String orderSummarySubTotal = price.get(1).getText();
				String reviewOrderPrice = price.get(4).getText();
				String reviewOrderSubTotal = price.get(5).getText();

				System.out.println("The search Member Price is: " + searchMemPrice);
				test.log(LogStatus.INFO, "The search Member Price is: " + searchMemPrice);

				if (orderSummaryPrice.equals(orderSummarySubTotal) && reviewOrderPrice.equals(reviewOrderSubTotal)
						&& orderSummarySubTotal.equals(reviewOrderSubTotal)
						&& reviewOrderSubTotal.equals(searchMemPrice)) {
					System.out.println("The review order subtotal is: " + reviewOrderSubTotal);
					test.log(LogStatus.INFO, "The review order subtotal is: " + reviewOrderSubTotal);
					test.log(LogStatus.INFO, "The order summary subtotal is: " + orderSummarySubTotal);
					System.out.println("Member Price Verification on Review Order Page was successful");
					test.log(LogStatus.PASS, "Member Price Verification on Review Order Page was successful");

				} else {
					System.out.println("The review order subtotal is: " + reviewOrderSubTotal);
					test.log(LogStatus.INFO, "The review order subtotal is: " + reviewOrderSubTotal);
					test.log(LogStatus.INFO, "The order summary subtotal is: " + orderSummarySubTotal);
					System.out.println("Member Price Verification on Review Order Page was unsuccessful");
					test.log(LogStatus.FAIL, "Member Price Verification on Review Order Page was unsuccessful");
					CommonHelper.takeScreenShot();
				}

			} else {

				String orderSummaryPrice = price.get(0).getText();
				String orderSummarySubTotal = price.get(1).getText();
				String reviewOrderPrice = price.get(4).getText();
				String reviewOrderSubTotal = price.get(5).getText();

				System.out.println("The search Member Price is: " + searchMemPrice);
				test.log(LogStatus.INFO, "The search Member Price is: " + searchMemPrice);

				if (orderSummaryPrice.equals(orderSummarySubTotal) && reviewOrderPrice.equals(reviewOrderSubTotal)
						&& orderSummarySubTotal.equals(reviewOrderSubTotal)
						&& reviewOrderSubTotal.equals(searchMemPrice)) {
					System.out.println("The member price is: " + reviewOrderSubTotal);
					test.log(LogStatus.INFO, "The member price is: " + reviewOrderSubTotal);
					System.out.println("Member Price Verification was successful");
					test.log(LogStatus.PASS, "Member Price Verification was successful");
				} else {
					System.out.println("The member price is: " + reviewOrderSubTotal);
					test.log(LogStatus.INFO, "The member price is: " + reviewOrderSubTotal);
					System.out.println("Member Price Verification was unsuccessful");
					test.log(LogStatus.FAIL, "Member Price Verification was unsuccessful");
					CommonHelper.takeScreenShot();
				}

			}
		} catch (Exception e) {
			CommonHelper.reportFailure("Verification of Member Price in the Review Order Page was unsuccesful");
			e.printStackTrace();
		}
	}

	public void enterNonUKOrderDetails() {
		try {
			Thread.sleep(5000);
			System.out.println("Click Enter Payment Details");
			test.log(LogStatus.INFO, "Click Enter Payment Details");
			Log.info("Click Enter Payment Details");
			CommonHelper.scrolltoview("paymentDetails_id");
			click("paymentDetails_id");
			Thread.sleep(1000);

			/*
			 * System.out.println("Click Pay by Credit Card"); test.log(LogStatus.INFO,
			 * "Click Pay by Credit Card"); Log.info("Click Pay by Credit Card");
			 * click("payCard_id");
			 */
		} catch (Exception e) {
			CommonHelper.reportFailure("Enter Non-UK Order Details was unsuccesful");
			e.printStackTrace();
		}
	}

	public void enterNonUKOrderDetailsHardcopy() {

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

		} catch (Exception e) {
			CommonHelper.reportFailure("Enter UK Order Details was unsuccesful");
			e.printStackTrace();
		}
	}

	public void validateEvidenceErrorMessage() {

		String addressErrorMsg = driver.findElement(By.cssSelector("span[class='error-message']")).getText();
		if (addressErrorMsg.contains("Evidence does not match")) {
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
			Thread.sleep(2000);
			System.out.println("Add New Billing Address");
			test.log(LogStatus.INFO, "Add New Billing Address");
			Log.info("Add New Billing Address");
			click("selectBillingAddress_id");
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
			driver.findElement(By.cssSelector("input[name='telephone']")).sendKeys("+443450869001");

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
			driver.findElement(By.cssSelector("input[name='telephone']")).sendKeys("+443450869001");

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

			String orderSummary = CommonHelper.element("orderDetails_xpath").getText();
			if (orderSummary.contains("Membership")) {
				Thread.sleep(2000);
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

			Thread.sleep(3000);
			System.out.println("Click Edit Order on Checkout Page");
			test.log(LogStatus.INFO, "Click Edit Order on Checkout Page");
			CommonHelper.scrolltoview("editOrder_id");
			driver.findElement(By.id("edit-button")).click();
			// click("editOrder_id");

			Thread.sleep(2000);
		} catch (InterruptedException e) {
			CommonHelper.reportFailure("Click Edit Order on Checkout Page was unsuccessful");
			e.printStackTrace();
		}
	}

	public boolean verifyMemPriceCheckout(String memDisc) {

		try {
			List<WebElement> orderSummaryPrice = driver.findElements(By.cssSelector("span[class='price']"));
			WebElement cartPrice = driver.findElement(By.cssSelector("span[class='cart-price']"));
			String price = cartPrice.getText();
			/*
			 * price = price.substring(1); double finalUnitPrice =
			 * Double.parseDouble(price); String finalPrice =
			 * Double.toString(finalUnitPrice);
			 */
			String Subtotal = orderSummaryPrice.get(1).getText();
			String Total = orderSummaryPrice.get(2).getText();

			if (price.equals(memDisc) && memDisc == Subtotal && Total == memDisc) {
				System.out.println("The SubTotal of the product in the Checkout Page is: " + Subtotal);
				test.log(LogStatus.INFO, "The SubTotal of the product in the Checkout Page is: " + Subtotal);
				return true;
			} else {
				System.out.println("The SubTotal of the product in the Checkout Page is: " + Subtotal);
				test.log(LogStatus.INFO, "The SubTotal of the product in the Checkout Page is: " + Subtotal);
			}
			return false;

		} catch (NumberFormatException e) {
			CommonHelper.reportFailure("The member price in the Checkout Page list is incorrect");
			e.printStackTrace();
		}
		return false;

	}

	public void enterPromoCode() {
		try {

			boolean successMsg = false;

			Thread.sleep(3000);
			;
			System.out.println("Click Have a discount code on Checkout Page");
			test.log(LogStatus.INFO, "Click Have a discount code on Checkout Page");
			// driver.findElement(By.id("block-discount-heading")).click();
			click("clickDiscountCode_id");

			System.out.println("Enter Promo Code on Checkout Page");
			test.log(LogStatus.INFO, "Enter Promo Code on Checkout Page");
			// CommonHelper.scrolltoview("promoCode_id");
			clearText("promoCode_id");
			enterText("promoCode_id", "testpromoaut");

			System.out.println("Click Apply Coupon on Checkout Page");
			test.log(LogStatus.INFO, "Click Apply Coupon on Checkout Page");
			click("applyDiscount_css");

			try {
				successMsg = driver.findElement(By.cssSelector("div[class='message message-success success']"))
						.isDisplayed();
				return;
			} catch (Exception e) {
				e.printStackTrace();
			}

			if (successMsg) {
				System.out.println("Coupon code applied succesfully");
				test.log(LogStatus.INFO, " The message is: " + successMsg);
				test.log(LogStatus.PASS, "Coupon code applied succesfully");
			} else {

				System.out.println("Coupon code application failed");
				test.log(LogStatus.INFO, " The message is: " + successMsg);
				test.log(LogStatus.FAIL, "Coupon code application failed");
			}
		} catch (Exception e) {
			CommonHelper.reportFailure("Coupon code application failed");
			e.printStackTrace();
		}

	}

	public void verifyOrderSummaryDiscount() {

		try {
			Thread.sleep(2000);
			System.out.println("Verify Order Summary for Discount on Checkout Page");
			test.log(LogStatus.INFO, "Verify Order Summary for Discount on Checkout Page");

			String orderSummary = CommonHelper.element("orderDetails_xpath").getText();
			if (orderSummary.contains("Discount")) {
				Thread.sleep(2000);
				System.out.println("Discount applied successfully on Checkout Page");
				test.log(LogStatus.INFO, "The Order Summary is: " + orderSummary);
				test.log(LogStatus.PASS, "Discount applied successfully on Checkout Page");
				CommonHelper.takeScreenShot();
			} else {
				System.out.println("Discount applied was unsuccesful on Checkout Page");
				test.log(LogStatus.INFO, "The Order Summary is: " + orderSummary);
				test.log(LogStatus.FAIL, "Discount applied was unsuccesful on Checkout Page");
				CommonHelper.takeScreenShot();
			}
		} catch (InterruptedException e) {
			CommonHelper.reportFailure("Discount applied was unsuccesful");
			Assert.fail(e.getMessage());
			e.printStackTrace();
		}
	}

	public void verifyReviewOrderDetails() {

		try {
			Thread.sleep(3000);
			System.out.println("Verify Review Order Deatils for Discount");
			test.log(LogStatus.INFO, "Verify Review Order Deatils for Discount");

			CommonHelper.scrolltoview("reviewOrderDetails_css");
			String reviewOrder = CommonHelper.element("reviewOrderDetails_css").getText();
			if (reviewOrder.contains("Discount")) {
				Thread.sleep(2000);
				System.out.println("Discount applied successfully on Review Order Page");
				test.log(LogStatus.INFO, "The Review Order is: " + reviewOrder);
				test.log(LogStatus.PASS, "Discount applied successfully on Review Order Page");
				CommonHelper.takeScreenShot();
			} else {
				System.out.println("Discount applied was unsuccesful on Review Order Page");
				test.log(LogStatus.INFO, "The Review Order is: " + reviewOrder);
				test.log(LogStatus.FAIL, "Discount applied was unsuccesful on Review Order Page");
				CommonHelper.takeScreenShot();
			}
		} catch (InterruptedException e) {
			CommonHelper.reportFailure("Discount applied on Review Order Page was unsuccesful");
			Assert.fail(e.getMessage());
			e.printStackTrace();
		}

	}

	public void enterInvoicePaymentDetails() {

		boolean removePrice = false;

		try {
			Thread.sleep(2000);
			System.out.println("Click Enter Payment Details");
			test.log(LogStatus.INFO, "Click Enter Payment Details");
			Log.info("Click Enter Payment Details");
			// CommonHelper.scrolltoview("paymentDetails_id");
			click("paymentDetails_id");
			Thread.sleep(1000);
			// click("paymentDetails_id");
			// driver.findElement(By.id("opc-shipping-btn")).click();

			try {
				Thread.sleep(1000);
				removePrice = driver.findElement(By.xpath("//*[@id='iwd_opc_store_credit']/div[2]/button/span"))
						.isDisplayed();

			} catch (Exception e) {
				e.printStackTrace();
			}
			//Thread.sleep(2000);
			if (removePrice) {
				click("removeInovicePrice_xpath");
			}

			System.out.println("Click Pay by Invoice");
			test.log(LogStatus.INFO, "Click Pay by Invoice");
			Log.info("Click Pay by Invoice");
			click("payInvoice_id");
			// driver.switchTo().frame(0);

			Thread.sleep(1000);
			System.out.println("Enter PO Number");
			test.log(LogStatus.INFO, "Enter PO Number");
			Log.info("Enter PO Number");
			enterText("storeCreditPoNumber_id", "123456789");

			// driver.switchTo().frame(0);
			System.out.println("Enter Phone Number");
			test.log(LogStatus.INFO, "Enter Phone Number");
			Log.info("Enter Phone Number");
			enterText("storeCreditPhone_id", "+443450869001");
			Thread.sleep(1000);
			driver.findElement(By.id("form-storecredit")).click();

			Thread.sleep(1000);
			System.out.println("Click Apply");
			test.log(LogStatus.INFO, "Click Apply");
			Log.info("Click Apply");
			click("appyInvoice_xpath");

			Thread.sleep(2000);
			String additionalPaymentInfo = driver.findElement(By.cssSelector("div[class*='additional_payment_info']"))
					.getText();
			System.out.println("The additional payment information is: " + additionalPaymentInfo);
			Log.info("The additional payment information is: " + additionalPaymentInfo);
			test.log(LogStatus.INFO, "The additional payment information is: " + additionalPaymentInfo);

		} catch (InterruptedException e) {
			CommonHelper.reportFailure("Pay by Invoice was unsuccesful");
			Assert.fail(e.getMessage());
			e.printStackTrace();
		}
	}

	public void enterInvoiceOrderDetails() {

		try {

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
			// CommonHelper.scrolltoview("completeOrder_id");
			click("completeOrder_id");
			// driver.findElement(By.id("place-order-trigger")).click();

		} catch (Exception e) {
			CommonHelper.reportFailure("Enter Order Details was unsuccesful");
			e.printStackTrace();
		}
	}

	public void insufficientBalInvoice() {

		boolean removePrice = false;

		try {
			Thread.sleep(2000);
			System.out.println("Click Enter Payment Details");
			test.log(LogStatus.INFO, "Click Enter Payment Details");
			Log.info("Click Enter Payment Details");
			CommonHelper.scrolltoview("paymentDetails_id");
			click("paymentDetails_id");
			Thread.sleep(1000);
			click("paymentDetails_id");
			// driver.findElement(By.id("opc-shipping-btn")).click();

			try {
				Thread.sleep(1000);
				removePrice = driver.findElement(By.xpath("//*[@id='iwd_opc_store_credit']/div[2]/button/span"))
						.isDisplayed();

			} catch (Exception e) {
				e.printStackTrace();
			}
			Thread.sleep(2000);
			if (removePrice) {
				click("removeInovicePrice_xpath");
			}

			System.out.println("Click Pay by Invoice");
			test.log(LogStatus.INFO, "Click Pay by Invoice");
			Log.info("Click Pay by Invoice");
			click("payInvoice_id");
			// driver.switchTo().frame(0);

			String errorMessage = driver
					.findElement(By.xpath("//*[@id='checkout-payment-method-load']/div[3]/div[2]/div")).getText();
			if (errorMessage.contains("Insufficient funds")) {
				System.out.println("The error message is: " + errorMessage);
				test.log(LogStatus.PASS, "The error message is: " + errorMessage);
			} else {
				System.out.println("The error message is: " + errorMessage);
				test.log(LogStatus.FAIL, "The error message is: " + errorMessage);
			}
		} catch (Exception e) {
			CommonHelper
					.reportFailure("Pay By Invoice Insufficient balance error message verificiaiton was unsuccesful");
			e.printStackTrace();
		}
	}

	public void enterSecureCardPaymentDetails() throws InterruptedException {

		try {
			Thread.sleep(5000);
			System.out.println("Enter Payment Details");
			test.log(LogStatus.INFO, "Enter Payment Details");
			Log.info("Enter Payment Details");
			CommonHelper.scrolltoview("paymentDetails_id");
			click("paymentDetails_id");
			Thread.sleep(1000);
			// driver.findElement(By.id("opc-shipping-btn")).click();

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
			System.out.println("Enter Secure Card Number");
			test.log(LogStatus.INFO, "Enter Secure Card Number");
			Log.info("Enter Card Number");
			enterText("cardNum_id", "4000000000000002");

			System.out.println("Enter Cardholder's Name");
			test.log(LogStatus.INFO, "Enter Cardholder's Name");
			Log.info("Enter Cardholder's Name");
			enterText("cardholderName_id", "Hermoine Granger");

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

			Thread.sleep(5000);
			System.out.println("Click Submit");
			test.log(LogStatus.INFO, "Click Submit");
			Log.info("Click Submit");
			CommonHelper.clickByJS("paySubmit_id");
			// CommonHelper.scrolltoview("paySubmit_id");
			// click("paySubmit_id");
			driver.switchTo().defaultContent();

		} catch (Exception e) {
			CommonHelper.reportFailure("Enter Card Details was unsuccessful");
			e.printStackTrace();
		}

	}

	public void enterIngenicoAuthenticationDetails() {

		try {
			Thread.sleep(5000);
			System.out.println("Enter Authentication Password");
			test.log(LogStatus.INFO, "Enter  Authentication Password");
			Log.info("Enter  Authentication Password");
			enterText("ingenicoAuthPwd_css", "11111");
			Thread.sleep(1000);
			System.out.println("Click GO");
			test.log(LogStatus.INFO, "Click GO");
			Log.info("Click GO");
			click("ingenicoAuthGo_id");
			Thread.sleep(1000);
			System.out.println("Click Back to Payment");
			test.log(LogStatus.INFO, "Click Back to Payment");
			Log.info("Click Back to Payment");
			click("ingenicoAuthBackToPay_id");
			Thread.sleep(1000);
		} catch (Exception e) {
			CommonHelper.reportFailure("Enter Card Details was unsuccessful");
			e.printStackTrace();
		}

	}

	public void selectDeliveryAddress() {

		try {
			test.log(LogStatus.INFO, "Uncheck Billing Address as Delivery Address");
			System.out.println("Uncheck Billing Address as Delivery Address");
			Log.info("Uncheck Billing Address as Delivery Address");
			click("uncheckAddress_id");
			test.log(LogStatus.PASS, "Selected New Delivery Address successfully");
			System.out.println("Selected New Delivery Address successfully");

			String billingAddress = driver.findElement(By.cssSelector("span[data-bind='html: addressText']")).getText();
			String deliveryAdress = driver.findElement(By.cssSelector("span[data-bind='html: shippingAddressText']"))
					.getText();
			System.out.println("The Billing Address is: " + billingAddress);
			test.log(LogStatus.INFO, "The Billing Address is: " + billingAddress);
			System.out.println("The Delivery Address is: " + deliveryAdress);
			test.log(LogStatus.INFO, "The Delivery Address is: " + deliveryAdress);

		} catch (Exception e) {
			CommonHelper.reportFailure("Uncheck of Billing Address as Delivery Address was unsuccessful");
			e.printStackTrace();
		}

	}
}
