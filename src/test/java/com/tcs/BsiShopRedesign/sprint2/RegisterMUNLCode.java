package com.tcs.BsiShopRedesign.sprint2;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.LogStatus;
import com.tcs.BsiShopRedesign.pages.BasketPage;
import com.tcs.BsiShopRedesign.pages.ProductPage;
import com.tcs.BsiShopRedesign.utilities.BaseTest;
import com.tcs.BsiShopRedesign.utilities.CommonHelper;

public class RegisterMUNLCode extends BaseTest {

	public RegisterMUNLCode() throws Exception {
		super();
	}

	@Test(priority = 1, enabled = true)
	public void registerMUNL() {

		test = extent.startTest("Sprint 2 - Ecom-02 AC#07 ___Register MUNL code");
		try {

			WebDriverWait wait = new WebDriverWait(driver, 120);
			Log.info("Enter product name in Search textbox");
			System.out.println("Enter product name in Search textbox");
			test.log(LogStatus.INFO, "Enter product name in Search textbox");
			WebElement search = wait.until(ExpectedConditions.elementToBeClickable(By.id("search")));
			search.clear();
			search.sendKeys("PAS 1192-5:2015");

			Log.info("Click on Search");
			System.out.println("Click on Search");
			test.log(LogStatus.INFO, "Click on Search");
			CommonHelper.elementToBeClickable("searchButton_css");
			click("searchButton_css");

			Log.info("Select the Product");
			System.out.println("Select the Product");
			test.log(LogStatus.INFO, "Select the Product");
			WebElement product = driver.findElement(By.linkText("PAS 1192-5:2015"));
			String name = product.toString();
			CommonHelper.elementToBeClickable(name);
			Thread.sleep(1000);
			product.click();

			Log.info("Select Format and Add to Basket");
			System.out.println("Select Format and Add to Basket");
			test.log(LogStatus.INFO, "Select Format and Add to Basket");
			ProductPage prod = new ProductPage(driver);
			prod.selectFormatAndAddToBasket();

			Log.info("Request MUNL Code");
			System.out.println("Request MUNL Code");
			test.log(LogStatus.INFO, "Request MUNL Code");
			BasketPage munl = new BasketPage(driver);
			munl.clickRegMUNL();

			Log.info("Enter Request MUNL Code details");
			System.out.println("Enter Request MUNL Code details");
			munl.enterRegMUNLDetails();

			Log.info("Verify Request MUNL Code details");
			System.out.println("Verify Request MUNL Code details");
			munl.verifyMUNL();

			Log.info("Remove the Product from Basket");
			System.out.println("Remove the Product from Basket");
			test.log(LogStatus.INFO, "Remove the Product from Basket");
			BasketPage basket = new BasketPage(driver);
			basket.removeProduct();

		}

		catch (Exception e) {
			test.log(LogStatus.FATAL, "Register MUNL code was unsuccessful");
			CommonHelper.reportFailure("Register MUNL code was unsuccessful");
			e.printStackTrace();
			Assert.fail(e.getMessage());
		}
	}
}
