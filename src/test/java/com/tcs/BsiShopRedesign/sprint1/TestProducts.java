package com.tcs.BsiShopRedesign.sprint1;

import java.io.FileInputStream;
import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.tcs.BsiShopRedesign.pages.BasketPage;
import com.tcs.BsiShopRedesign.pages.ProductPage;
import com.tcs.BsiShopRedesign.utilities.BaseTest;

import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;

//Add listener for pdf report generation

public class TestProducts extends BaseTest {

	public TestProducts() throws Exception {
		super();
		// TODO Auto-generated constructor stub
	}

	@Test(priority = 1, enabled = true)
	public void searchAndUpdateStandardProduct() throws BiffException, IOException {

		WebDriverWait wait = new WebDriverWait(driver, 15);

		try {
			test = extent.startTest("search and update Test Product");
			/*** To access to Workbook ***/
			// String projectPath = System.getProperty("user.dir");
			// String FilePath = projectPath +
			// "\\TestData\\List_of_products_users-Demo.xls";
			// String FilePath = "C:\\Users\\529373\\Desktop\\BSI Automation
			// Demo\\List_of_products_users-Demo.xls";
			String FilePath = "D:\\BSI_Workspace\\BsiShopRedesign\\TestData\\List_of_products_users-TCS.xls";
			FileInputStream fs = new FileInputStream(FilePath);
			Workbook wb = Workbook.getWorkbook(fs);

			// *** To get the sheet access by sheet name
			Sheet sh = wb.getSheet("Products");

			// *** To get the number of rows present in sheet
			int totalNoOfRows = sh.getRows();
			System.out.println("The total no. of rows are: " + totalNoOfRows);

			// *** To get the number of columns present in sheet
			int totalNoOfCols = sh.getColumns();
			System.out.println("The total no. of columns are: " + totalNoOfCols);

			// *** To get the content in particular location, which will return
			// *** contents as a string

			String CellGetContent = sh.getCell(0, 1).getContents();
			System.out.println("The content of the cell is: " + CellGetContent);

			/*
			 * for (int col = 0; col < totalNoOfCols;) {
			 * 
			 * for (int row = 1; row < totalNoOfRows; row++) { String
			 * CellGetContent = sh.getCell(col, row).getContents();
			 * System.out.println("The content of the cell is: " +
			 * CellGetContent);
			 */

			Log.info("Enter product name in Search textbox");
			System.out.println("Enter product name in Search textbox");
			WebElement search = wait.until(ExpectedConditions.elementToBeClickable(By.id("search")));
			search.clear();
			search.sendKeys(CellGetContent);

			Log.info("Click on Search");
			System.out.println("Click on Search");
			driver.findElement(By.id("search-button")).click();

			Log.info("Select the Product");
			System.out.println("Select the Product");
			WebElement product = driver.findElement(By.linkText(CellGetContent));
			Thread.sleep(1000);
			product.click();
			// Thread.sleep(5000);

			Log.info("Select the Format and Add to Basket");
			System.out.println("Select the Format");
			ProductPage prod = new ProductPage(driver);
			String stat = prod.selectFormatAndAddToBasket();

			if (!stat.contains("Withdrawn") || stat.contains("essentialsFormat")) {
				Log.info("Edit the Basket with Update Quantity");
				System.out.println("Edit the Basket with Update Quantity");
				BasketPage basket = new BasketPage(driver);
				basket.editBasketUpdateQuantity();

				Log.info("Edit the Basket with Change Format");
				System.out.println("Edit the Basket with Change Format");
				basket.editBasketChangeFormat();

				Log.info("Remove the Product");
				System.out.println("Remove the Product");
				basket.removeProduct();
			}

			else {
				System.out.println("The product cannot be added to basket as the status is: " + stat);
			}

		}

		catch (Exception e) {
			e.printStackTrace();
			Assert.fail(e.getMessage());
		}

	}
}
