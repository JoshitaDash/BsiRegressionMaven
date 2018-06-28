package com.tcs.BsiShopRedesign.sprint1;

import java.io.IOException;
import java.util.Hashtable;

import org.apache.poi.xssf.usermodel.extensions.XSSFCellBorder.BorderSide;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.LogStatus;
import com.tcs.BsiShopRedesign.pages.BasketPage;
import com.tcs.BsiShopRedesign.pages.ProductPage;
import com.tcs.BsiShopRedesign.utilities.BaseTest;
import com.tcs.BsiShopRedesign.utilities.BsiConstants;
import com.tcs.BsiShopRedesign.utilities.CommonHelper;
import com.tcs.BsiShopRedesign.utilities.DataUtil;
import com.tcs.BsiShopRedesign.utilities.Xls_Reader;

import jxl.read.biff.BiffException;

public class SCRProductsUpdateBasket extends BaseTest {

	public SCRProductsUpdateBasket() throws Exception {
		super();
	}
	
	public Xls_Reader xls = new Xls_Reader(
			"D:\\BSI_Workspace\\BsiShopRedesign\\TestData\\List_of_products_users-TCS.xls");
	
	String testCaseName = "Standard_Product_Update";
	
	// String url = "https://staging-standards.bsigroup.com/";
	String url = BsiConstants.getEnvDetails().get("url");
	
	@DataProvider
	public Object[][] getData() {
		return DataUtil.getData(xls, testCaseName);
	}

	@Test(dataProvider = "getData")
	public void productUpdateBasket(Hashtable<String, String> data) throws BiffException, IOException {

		WebDriverWait wait = new WebDriverWait(driver, 120);

		try {
			String prodName = data.get("Product_name");
			test = extent.startTest("Sprint 1 - Search and Update Basket of SCR imported Product: " + prodName);
			System.out.println("Test");
			driver.get(url);
			Log.info("Enter product name in Search textbox");
			System.out.println("Enter product name in Search textbox");
			test.log(LogStatus.INFO, "Enter product name in Search textbox");
			WebElement search = wait.until(ExpectedConditions.elementToBeClickable(By.id("search")));
			search.clear();
			search.sendKeys(prodName);

			Log.info("Click on Search");
			System.out.println("Click on Search");
			test.log(LogStatus.INFO, "Click on Search");
			CommonHelper.elementToBeClickable("searchButton_css");
			// driver.findElement(By.cssSelector("button[title='Search']")).click();
			click("searchButton_css");

			Log.info("Select the Product");
			System.out.println("Select the Product");
			test.log(LogStatus.INFO, "Select the Product");
			WebElement product = driver.findElement(By.linkText(prodName));
			Thread.sleep(1000);
			wait.until(ExpectedConditions.elementToBeClickable(By.linkText(prodName)));
			product.click();
			// Thread.sleep(5000);
			Log.info("Select the Format");
			System.out.println("Select the Format");
			test.log(LogStatus.INFO, "Select the Format");
			ProductPage prod = new ProductPage(driver);
			String stat = prod.selectFormatAndAddToBasket();

			if (!stat.contains("Withdrawn") || stat.contains("essentialsFormat")) {
				Log.info("Edit the Basket with Update Quantity");
				System.out.println("Edit the Basket with Update Quantity");
				test.log(LogStatus.INFO, "Edit the Basket with Update Quantity");
				BasketPage basket = new BasketPage(driver);
				basket.editBasketUpdateQuantity();

				Log.info("Edit the Basket with Change Format");
				System.out.println("Edit the Basket with Change Format");
				test.log(LogStatus.INFO, "Edit the Basket with Change Format");
				basket.editBasketChangeFormat();

				Log.info("Remove the Product");
				System.out.println("Remove the Product");
				test.log(LogStatus.INFO, "Remove the Product");
				basket.removeProduct();
			}

			else {
				test.log(LogStatus.INFO, "The product cannot be added to basket as the status is: " + stat);
				System.out.println("The product cannot be added to basket as the status is: " + stat);
			}

		} catch (Exception e) {
			e.printStackTrace();
			test.log(LogStatus.FATAL, "Search and Update SCR Products was unsuccessful");
			CommonHelper.reportFailure("Search and Update SCR Products was unsuccessful");
			Assert.fail(e.getMessage());
		}

	}
}
