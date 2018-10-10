package com.tcs.BsiShopRedesign.sprint8;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import com.relevantcodes.extentreports.LogStatus;
import com.tcs.BsiShopRedesign.pages.HomePage;
import com.tcs.BsiShopRedesign.pages.ProductPage;
import com.tcs.BsiShopRedesign.pages.SearchPage;
import com.tcs.BsiShopRedesign.utilities.BaseTest;
import com.tcs.BsiShopRedesign.utilities.CommonHelper;

public class VerifyPDFPreviewing extends BaseTest {

	public VerifyPDFPreviewing() throws Exception {
		super();
	}

	@Test(priority = 1, enabled = true)
	public void verifyMemberLink() {

		try {
			test = extent.startTest("Sprint 8 - Ecom-55 AC#66, 68__ PDF Previewing");

			System.out.println("Perform Blank Search");
			Log.info("Perform Blank Search");
			HomePage home = new HomePage(driver);
			home.blankSearch();

			System.out.println("Verfiy search result");
			Log.info("Verfiy search result");
			SearchPage search = new SearchPage(driver);
			search.verifySearchResultforBlankSearch();

			System.out.println("Click on Product");
			Log.info("Click on Product");
			search.clickProductOnSearchList();

			/*
			 * Log.info("Enter product name in Search textbox");
			 * System.out.println("Enter product name in Search textbox");
			 * driver.findElement(By.id("search")).clear();
			 * driver.findElement(By.id("search")).sendKeys("BS EN 3682-007:2013");
			 * 
			 * Log.info("Click on Search"); System.out.println("Click on Search");
			 * click("searchButton_css");
			 * 
			 * Log.info("Select the Product"); System.out.println("Select the Product");
			 * WebElement product = driver.findElement(By.linkText("BS EN 3682-007:2013"));
			 * product.click();
			 */

			System.out.println("Verify PDF Previewing");
			Log.info("Verify PDF Previewing");
			ProductPage prod = new ProductPage(driver);
			prod.verifyPDFPreview();

		} catch (Exception e) {
			test.log(LogStatus.FATAL, "Verify PDF Previewing Image was unsuccessful");
			CommonHelper.reportFailure("Verify PDF Previewing Image was unsuccessful");
			e.printStackTrace();
			Assert.fail(e.getMessage());
		}
	}
}
