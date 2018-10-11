package com.tcs.BsiShopRedesign.sprint9;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.LogStatus;
import com.tcs.BsiShopRedesign.pages.BasketPage;
import com.tcs.BsiShopRedesign.pages.CheckoutPage;
import com.tcs.BsiShopRedesign.pages.OrderConfirmationPage;
import com.tcs.BsiShopRedesign.pages.ProductPage;
import com.tcs.BsiShopRedesign.pages.SignInPage;
import com.tcs.BsiShopRedesign.utilities.BaseTest;
import com.tcs.BsiShopRedesign.utilities.CommonHelper;

public class PreBookProducts extends BaseTest {

	public PreBookProducts() throws Exception {
		super();
	}

	@Test(priority = 1, enabled = true)
	public void signInMember() {

		try {
			test = extent.startTest("Sprint 9 - Member User Sign In");
			System.out.println("Member Signing In");
			Log.info("Member Signing In");
			SignInPage signIn = new SignInPage(driver);
			signIn.memberNewLogin();
		} catch (Exception e) {
			test.log(LogStatus.FATAL, "Member Signing in was unsuccessful");
			e.printStackTrace();
			Assert.fail(e.getMessage());
		}
	}

	@Test(priority = 2, enabled = false)
	public void verifyAdavanceAccessProduct() {

		test = extent.startTest(
				"Sprint 9 - ECom-04 & ECom-19 AC#9,10,11,12,13 ___ Verification and Placing order for Advance Access Product");

		WebDriverWait wait = new WebDriverWait(driver, 30);
		try {

			Log.info("Enter product name in Search textbox");
			System.out.println("Enter product name in Search textbox");
			test.log(LogStatus.INFO, "Enter product name in Search textbox");
			WebElement search = wait.until(ExpectedConditions.elementToBeClickable(By.id("search")));
			search.clear();
			search.sendKeys("WD/ISO9000 : 2015 Advanced Access");

			Log.info("Click on Search");
			System.out.println("Click on Search");
			test.log(LogStatus.INFO, "Click on Search");
			CommonHelper.elementToBeClickable("searchButton_css");
			// driver.findElement(By.cssSelector("button[title='Search']")).click();
			click("searchButton_css");

			Log.info("Select the Product");
			System.out.println("Select the Product");
			test.log(LogStatus.INFO, "Select the Product");
			WebElement product = driver.findElement(By.linkText("WD/ISO9000 : 2015 Advanced Access"));
			Thread.sleep(1000);
			wait.until(ExpectedConditions.elementToBeClickable(By.linkText("WD/ISO9000 : 2015 Advanced Access")));
			product.click();

			Log.info("Verify Advance Access Product");
			System.out.println("Verify Advance Access Product");
			ProductPage advanceAccess = new ProductPage(driver);
			advanceAccess.verifyAdvanceAccessProduct();

			Log.info("Add Advance Access Product to Basket");
			System.out.println("Add Advance Access Product to Basket");
			advanceAccess.selectDefaultFormatAndAddToBasket();

			System.out.println("Click Checkout Now");
			Log.info("Click Checkout Now");
			BasketPage checkout = new BasketPage(driver);
			checkout.clickCheckout();

			System.out.println("Enter Payment Details");
			Log.info("Enter Payment Details");
			test.log(LogStatus.INFO, "Enter Payment Details");
			CheckoutPage checkoutOrder = new CheckoutPage(driver);
			checkoutOrder.enterCardPaymentDetails();

			System.out.println("Enter Order Details");
			Log.info("Enter Order Details");
			test.log(LogStatus.INFO, "Enter Order Details");
			checkoutOrder.enterOrderDetails();

			System.out.println("Verify Success Message on Order Confirmation Page");
			Log.info("Verify Success Message on Order Confirmation Page");
			test.log(LogStatus.INFO, "Verify Success Message on Order Confirmation Page");
			OrderConfirmationPage verifyMsg = new OrderConfirmationPage(driver);
			verifyMsg.verifyOrderSuccessMessage();

		} catch (Exception e) {
			test.log(LogStatus.FATAL, "Verification and Placing order for Advance Access Product was unsuccessful");
			e.printStackTrace();
			Assert.fail(e.getMessage());

		}
	}

	@Test(priority = 2, enabled = true)
	public void verifyPreOrderProduct() {

		test = extent.startTest(
				"Sprint 9 - ECom-04 & ECom-19 AC#9,10,11,12,13 ___ Verification and Placing order for Advance Access Product");

		WebDriverWait wait = new WebDriverWait(driver, 30);
		try {

			Log.info("Enter product name in Search textbox");
			System.out.println("Enter product name in Search textbox");
			test.log(LogStatus.INFO, "Enter product name in Search textbox");
			WebElement search = wait.until(ExpectedConditions.elementToBeClickable(By.id("search")));
			search.clear();
			search.sendKeys("BIP 2223:2018");

			Log.info("Click on Search");
			System.out.println("Click on Search");
			test.log(LogStatus.INFO, "Click on Search");
			CommonHelper.elementToBeClickable("searchButton_css");
			// driver.findElement(By.cssSelector("button[title='Search']")).click();
			click("searchButton_css");

			Log.info("Select the Product");
			System.out.println("Select the Product");
			test.log(LogStatus.INFO, "Select the Product");
			WebElement product = driver.findElement(By.linkText("BIP 2223:2018"));
			Thread.sleep(1000);
			wait.until(ExpectedConditions.elementToBeClickable(By.linkText("BIP 2223:2018")));
			product.click();

			Log.info("Verify Pre Order Product");
			System.out.println("Verify Pre Order Product");
			ProductPage preOrder = new ProductPage(driver);
			preOrder.verifyPreOrderProduct();

			Log.info("Add Pre Order Product to Basket");
			System.out.println("Add Pre Order Product to Basket");
			preOrder.selectDefaultFormatAndAddToBasket();

			System.out.println("Click Checkout Now");
			Log.info("Click Checkout Now");
			BasketPage checkout = new BasketPage(driver);
			checkout.clickCheckout();

			System.out.println("Enter Payment Details");
			Log.info("Enter Payment Details");
			test.log(LogStatus.INFO, "Enter Payment Details");
			CheckoutPage checkoutOrder = new CheckoutPage(driver);
			checkoutOrder.enterCardPaymentDetails();

			System.out.println("Enter Order Details");
			Log.info("Enter Order Details");
			test.log(LogStatus.INFO, "Enter Order Details");
			checkoutOrder.enterOrderDetails();

			System.out.println("Verify Success Message on Order Confirmation Page");
			Log.info("Verify Success Message on Order Confirmation Page");
			test.log(LogStatus.INFO, "Verify Success Message on Order Confirmation Page");
			OrderConfirmationPage verifyMsg = new OrderConfirmationPage(driver);
			verifyMsg.verifyOrderSuccessMessage();

		} catch (Exception e) {
			test.log(LogStatus.FATAL, "Verification and Placing order for Pre Order Product was unsuccessful");
			e.printStackTrace();
			Assert.fail(e.getMessage());

		}
	}
}
