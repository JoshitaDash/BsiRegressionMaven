package com.tcs.BsiShopRedesign.sprint2;

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

public class CheckWarningMsgAddtoBasket extends BaseTest {

	public CheckWarningMsgAddtoBasket() throws Exception {
		super();
	}

	@Test(priority = 1, enabled = true)
	public void checkWarningMsgPDF() {

		WebDriverWait wait = new WebDriverWait(driver, 30);

		try {

			test = extent.startTest("Sprint 2 - Add PDF Product twice to check warning message");
			Log.info("Enter product name in Search textbox");
			System.out.println("Enter product name in Search textbox");
			test.log(LogStatus.INFO, "Enter product name in Search textbox");
			WebElement search = wait.until(ExpectedConditions.elementToBeClickable(By.id("search")));
			search.clear();
			search.sendKeys("BS 6070-1:1981");

			Log.info("Click on Search");
			System.out.println("Click on Search");
			test.log(LogStatus.INFO, "Click on Search");
			CommonHelper.elementToBeClickable("searchButton_css");
			click("searchButton_css");

			Log.info("Select the Product");
			System.out.println("Select the Product");
			test.log(LogStatus.INFO, "Select the Product");
			WebElement product = driver.findElement(By.linkText("BS 6070-1:1981"));
			String name = product.toString();
			CommonHelper.elementToBeClickable(name);
			product.click();

			// test = extent.startTest("Select PDF Format and Add to Basket
			// twice");
			test.log(LogStatus.INFO, "Select PDF Format and Add to Basket twice");
			Log.info("Select PDF Format and Add to Basket twice ");
			System.out.println("Select PDF Format and Add to Basket twice");
			ProductPage prod = new ProductPage(driver);
			prod.addPDFProductToBasket();

			// test = extent.startTest("Check warning message");
			test.log(LogStatus.INFO, "Check warning message");
			Log.info("Check warning message");
			System.out.println("Check warning message");
			prod.checkWarningMsg();

		} catch (Exception e) {
			test.log(LogStatus.FATAL, "Adding same Product twice to Basket and checking warning message was unsuccessful");
			CommonHelper.reportFailure("Adding same Product twice to Basket and checking warning message was unsuccessful");
			e.printStackTrace();
			Assert.fail(e.getMessage());
		}
	}
}