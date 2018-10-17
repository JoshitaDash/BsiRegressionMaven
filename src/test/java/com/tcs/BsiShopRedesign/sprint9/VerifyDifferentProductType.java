package com.tcs.BsiShopRedesign.sprint9;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.LogStatus;
import com.tcs.BsiShopRedesign.pages.ProductPage;
import com.tcs.BsiShopRedesign.utilities.BaseTest;
import com.tcs.BsiShopRedesign.utilities.CommonHelper;

public class VerifyDifferentProductType extends BaseTest {

	public VerifyDifferentProductType() throws Exception {
		super();
	}

	@Test(priority = 1, enabled = true)
	public void verifyDCProduct() {

		test = extent.startTest("Sprint 9 - ECom-51 & ECom-60 AC#56 ___ Verification Status of DC Product");

		WebDriverWait wait = new WebDriverWait(driver, 30);
		try {

			Log.info("Enter product name in Search textbox");
			System.out.println("Enter product name in Search textbox");
			test.log(LogStatus.INFO, "Enter product name in Search textbox");
			WebElement search = wait.until(ExpectedConditions.elementToBeClickable(By.id("search")));
			search.clear();
			search.sendKeys("18/30363361 DC");

			Log.info("Click on Search");
			System.out.println("Click on Search");
			test.log(LogStatus.INFO, "Click on Search");
			CommonHelper.elementToBeClickable("searchButton_css");
			// driver.findElement(By.cssSelector("button[title='Search']")).click();
			click("searchButton_css");

			Log.info("Select the Product");
			System.out.println("Select the Product");
			test.log(LogStatus.INFO, "Select the Product");
			WebElement product = driver.findElement(By.linkText("18/30363361 DC"));
			Thread.sleep(1000);
			wait.until(ExpectedConditions.elementToBeClickable(By.linkText("18/30363361 DC")));
			product.click();
			Thread.sleep(2000);

			Log.info("Click Status");
			System.out.println("Click Status");
			test.log(LogStatus.INFO, "Click Status");
			ProductPage status = new ProductPage(driver);
			status.clickStatus();

			Log.info("Verify URL");
			System.out.println("Verify URL");
			test.log(LogStatus.INFO, "Verify URL");
			status.verifyURL();

		} catch (Exception e) {
			test.log(LogStatus.FATAL, "Verification Status of DC Product was unsuccessful");
			e.printStackTrace();
			Assert.fail(e.getMessage());

		}
	}

	@Test(priority = 2, enabled = true)
	public void verifyNewsFeed() {

		test = extent.startTest("Sprint 9 - #CM06 ___ Verification of News Feed");

		WebDriverWait wait = new WebDriverWait(driver, 30);
		try {

			Log.info("Enter product name in Search textbox");
			System.out.println("Enter product name in Search textbox");
			test.log(LogStatus.INFO, "Enter product name in Search textbox");
			WebElement search = wait.until(ExpectedConditions.elementToBeClickable(By.id("search")));
			search.clear();
			search.sendKeys("Building and Construction");

			Log.info("Click on Search");
			System.out.println("Click on Search");
			test.log(LogStatus.INFO, "Click on Search");
			CommonHelper.elementToBeClickable("searchButton_css");
			// driver.findElement(By.cssSelector("button[title='Search']")).click();
			click("searchButton_css");

			Log.info("Select the Product");
			System.out.println("Select the Product");
			test.log(LogStatus.INFO, "Select the Product");
			WebElement product = driver.findElement(By.linkText("Building and Construction"));
			Thread.sleep(1000);
			wait.until(ExpectedConditions.elementToBeClickable(By.linkText("Building and Construction")));
			product.click();
			Thread.sleep(2000);
			
			Log.info("Verify News Feed");
			System.out.println("Verify News Feed");
			test.log(LogStatus.INFO, "Verify News Feed");
			ProductPage newsFeed = new ProductPage(driver);
			newsFeed.verifyNewsFeed();

		} catch (Exception e) {
			test.log(LogStatus.FATAL, "Verification of News Feed was unsuccessful");
			e.printStackTrace();
			Assert.fail(e.getMessage());

		}

	}
}
