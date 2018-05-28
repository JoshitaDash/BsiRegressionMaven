package com.tcs.BsiShopRedesign.sprint1;

import java.io.FileInputStream;
import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.tcs.BsiShopRedesign.pages.BasketPage;
import com.tcs.BsiShopRedesign.pages.ProductPage;
import com.tcs.BsiShopRedesign.utilities.BaseTest;
import com.tcs.BsiShopRedesign.utilities.BsiConstants;

import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;

public class MultipleProductUpdateBasket extends BaseTest {

	public MultipleProductUpdateBasket() throws Exception {
		super();
		// TODO Auto-generated constructor stub
	}

	String url = BsiConstants.getEnvDetails().get("url");

	@Test(priority = 1, enabled = true)
	public void searchAndUpdateProduct1() throws BiffException, IOException {

		try {
			test = extent.startTest("search and update Product 1");
			// To access to Workbook
			String projectPath = System.getProperty("user.dir");
			String FilePath = projectPath + "\\TestData\\List_of_products_users-TCS.xls";
			// String FilePath =
			// "D:\\BSI_FW\\BSI\\BSI.Automation.Regression\\TestData\\List_of_products_users-TCS.xls";
			FileInputStream fs = new FileInputStream(FilePath);
			Workbook wb = Workbook.getWorkbook(fs);

			// To get the sheet access by sheet name
			Sheet sh = wb.getSheet("Products");

			// To get the number of rows present in sheet
			int totalNoOfRows = sh.getRows();
			System.out.println("The total no. of rows are: " + totalNoOfRows);

			// To get the number of columns present in sheet
			int totalNoOfCols = sh.getColumns();
			System.out.println("The total no. of columns are: " + totalNoOfCols);

			// To get the content in particular location, which will return
			// contents as a string
			String CellGetContent = sh.getCell(0, 1).getContents();
			System.out.println("The content of the cell is: " + CellGetContent);

			/*
			 * for (int col = 0; col < totalNoOfCols;) {
			 * 
			 * for (int row = 1; row < totalNoOfRows; row++) { String CellGetContent =
			 * sh.getCell(col, row).getContents();
			 * System.out.println("The content of the cell is: " + CellGetContent);
			 */
			Log.info("Enter product name in Search textbox");
			System.out.println("Enter product name in Search textbox");
			driver.findElement(By.id("search")).clear();
			driver.findElement(By.id("search")).sendKeys(CellGetContent);

			Log.info("Click on Search");
			System.out.println("Click on Search");
			driver.findElement(By.id("search-button")).click();

			Log.info("Select the Product");
			System.out.println("Select the Product");
			WebElement product = driver.findElement(By.linkText(CellGetContent));
			product.click();
			// Thread.sleep(5000);

			Log.info("Select the Format");
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
			} else {
				System.out.println("The product cannot be added to basket as the status is: " + stat);
			}

		} catch (Exception e) {
			e.printStackTrace();
			Assert.fail(e.getMessage());
		}
	}

	@Test(priority = 2, enabled = true)
	public void searchAndUpdateProduct2() throws BiffException, IOException {

		try {
			test = extent.startTest("search and update Product 2");
			Thread.sleep(3000);
			System.out.println("Fetching the URL");
			driver.get(url);

			// To access to Workbook
			String projectPath = System.getProperty("user.dir");
			String FilePath = projectPath + "\\TestData\\List_of_products_users-TCS.xls";
			FileInputStream fs = new FileInputStream(FilePath);
			Workbook wb = Workbook.getWorkbook(fs);

			// To get the sheet access by sheet name
			Sheet sh = wb.getSheet("Products");

			// To get the number of rows present in sheet
			int totalNoOfRows = sh.getRows();
			System.out.println("The total no. of rows are: " + totalNoOfRows);

			// To get the number of columns present in sheet
			int totalNoOfCols = sh.getColumns();
			System.out.println("The total no. of columns are: " + totalNoOfCols);

			// To get the content in particular location, which will return
			// contents as a string
			String CellGetContent = sh.getCell(0, 2).getContents();
			System.out.println("The content of the cell is: " + CellGetContent);

			Log.info("Enter product name in Search textbox");
			System.out.println("Enter product name in Search textbox");
			driver.findElement(By.id("search")).clear();
			driver.findElement(By.id("search")).sendKeys(CellGetContent);

			Log.info("Click on Search");
			System.out.println("Click on Search");
			driver.findElement(By.id("search-button")).click();

			Log.info("Select the Product");
			System.out.println("Select the Product");
			WebElement product = driver.findElement(By.linkText(CellGetContent));
			product.click();
			Thread.sleep(5000);

			Log.info("Select the Format");
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
			} else {
				System.out.println("The product cannot be added to basket as the status is: " + stat);
			}

		} catch (Exception e) {
			e.printStackTrace();
			Assert.fail(e.getMessage());
		}
	}

	@Test(priority = 3, enabled = true)
	public void searchAndUpdateProduct3() throws BiffException, IOException {

		try {
			test = extent.startTest("search and update Product 3");
			Thread.sleep(3000);
			System.out.println("Fetching the URL");
			driver.get(url);

			// To access to Workbook
			String projectPath = System.getProperty("user.dir");
			String FilePath = projectPath + "\\TestData\\List_of_products_users-TCS.xls";
			// String FilePath =
			// "D:\\BSI_FW\\BSI\\BSI.Automation.Regression\\TestData\\List_of_products_users-TCS.xls";
			FileInputStream fs = new FileInputStream(FilePath);
			Workbook wb = Workbook.getWorkbook(fs);

			// To get the sheet access by sheet name
			Sheet sh = wb.getSheet("Products");

			// To get the number of rows present in sheet
			int totalNoOfRows = sh.getRows();
			System.out.println("The total no. of rows are: " + totalNoOfRows);

			// To get the number of columns present in sheet
			int totalNoOfCols = sh.getColumns();
			System.out.println("The total no. of columns are: " + totalNoOfCols);

			// To get the content in particular location, which will return
			// contents as a string
			String CellGetContent = sh.getCell(0, 3).getContents();
			System.out.println("The content of the cell is: " + CellGetContent);

			Log.info("Enter product name in Search textbox");
			System.out.println("Enter product name in Search textbox");
			driver.findElement(By.id("search-box")).clear();
			driver.findElement(By.id("search-box")).sendKeys(CellGetContent);

			Log.info("Click on Search");
			System.out.println("Click on Search");
			driver.findElement(By.id("search-button")).click();

			Log.info("Select the Product");
			System.out.println("Select the Product");
			WebElement product = driver.findElement(By.linkText(CellGetContent));
			product.click();
			Thread.sleep(5000);

			Log.info("Select the Format");
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
			} else {
				System.out.println("The product cannot be added to basket as the status is: " + stat);
			}

		} catch (Exception e) {
			e.printStackTrace();
			Assert.fail(e.getMessage());
		}
	}

	@Test(priority = 4, enabled = true)
	public void searchProduct4() throws BiffException, IOException {

		try {
			test = extent.startTest("search and update Product 4");
			Thread.sleep(3000);
			System.out.println("Fetching the URL");
			driver.get(url);

			// To access to Workbook
			String projectPath = System.getProperty("user.dir");
			String FilePath = projectPath + "\\TestData\\List_of_products_users-TCS.xls";
			// String FilePath =
			// "D:\\BSI_FW\\BSI\\BSI.Automation.Regression\\TestData\\List_of_products_users-TCS.xls";
			FileInputStream fs = new FileInputStream(FilePath);
			Workbook wb = Workbook.getWorkbook(fs);

			// To get the sheet access by sheet name
			Sheet sh = wb.getSheet("Products");

			// To get the number of rows present in sheet
			int totalNoOfRows = sh.getRows();
			System.out.println("The total no. of rows are: " + totalNoOfRows);

			// To get the number of columns present in sheet
			int totalNoOfCols = sh.getColumns();
			System.out.println("The total no. of columns are: " + totalNoOfCols);

			// To get the content in particular location, which will return
			// contents as a string
			String CellGetContent = sh.getCell(0, 4).getContents();
			System.out.println("The content of the cell is: " + CellGetContent);

			Log.info("Enter product name in Search textbox");
			System.out.println("Enter product name in Search textbox");
			driver.findElement(By.id("search-box")).clear();
			driver.findElement(By.id("search-box")).sendKeys(CellGetContent);

			Log.info("Click on Search");
			System.out.println("Click on Search");
			driver.findElement(By.id("search-button")).click();

			Log.info("Select the Product");
			System.out.println("Select the Product");
			WebElement product = driver.findElement(By.linkText(CellGetContent));
			product.click();
			Thread.sleep(5000);

			Log.info("Select the Format");
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
			} else {
				System.out.println("The product cannot be added to basket as the status is: " + stat);
			}

			/*
			 * Thread.sleep(2000); Log.info("Click on CheckOut");
			 * System.out.println("Click on CheckOut"); basket.clickCheckout();
			 */

		} catch (Exception e) {
			e.printStackTrace();
			Assert.fail(e.getMessage());
		}
	}

	@Test(priority = 5, enabled = true)
	public void searchProduct5() throws BiffException, IOException {

		try {
			test = extent.startTest("search and update Product 5");
			Thread.sleep(3000);
			System.out.println("Fetching the URL");
			driver.get(url);

			// To access to Workbook
			String projectPath = System.getProperty("user.dir");
			String FilePath = projectPath + "\\TestData\\List_of_products_users-TCS.xls";
			// String FilePath =
			// "D:\\BSI_FW\\BSI\\BSI.Automation.Regression\\TestData\\List_of_products_users-TCS.xls";
			FileInputStream fs = new FileInputStream(FilePath);
			Workbook wb = Workbook.getWorkbook(fs);

			// To get the sheet access by sheet name
			Sheet sh = wb.getSheet("Products");

			// To get the number of rows present in sheet
			int totalNoOfRows = sh.getRows();
			System.out.println("The total no. of rows are: " + totalNoOfRows);

			// To get the number of columns present in sheet
			int totalNoOfCols = sh.getColumns();
			System.out.println("The total no. of columns are: " + totalNoOfCols);

			// To get the content in particular location, which will return
			// contents as a string
			String CellGetContent = sh.getCell(0, 5).getContents();
			System.out.println("The content of the cell is: " + CellGetContent);

			Log.info("Enter product name in Search textbox");
			System.out.println("Enter product name in Search textbox");
			driver.findElement(By.id("search-box")).clear();
			driver.findElement(By.id("search-box")).sendKeys(CellGetContent);

			Log.info("Click on Search");
			System.out.println("Click on Search");
			driver.findElement(By.id("search-button")).click();

			Log.info("Select the Product");
			System.out.println("Select the Product");
			WebElement product = driver.findElement(By.linkText(CellGetContent));
			product.click();
			Thread.sleep(5000);

			Log.info("Select the Format");
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
			} else {
				System.out.println("The product cannot be added to basket as the status is: " + stat);
			}

			/*
			 * Thread.sleep(2000); Log.info("Click on CheckOut");
			 * System.out.println("Click on CheckOut"); basket.clickCheckout();
			 */

		} catch (Exception e) {
			e.printStackTrace();
			Assert.fail(e.getMessage());
		}
	}

	@Test(priority = 6, enabled = true)
	public void searchProduct6() throws BiffException, IOException {

		System.out.println("Fetching the URL");
		driver.get(url);

		try {
			test = extent.startTest("search and update Product 6");
			// To access to Workbook
			String FilePath = "D:\\BSI_FW\\BSI\\BSI.Automation.Regression\\TestData\\List_of_products_users-TCS.xls";
			FileInputStream fs = new FileInputStream(FilePath);
			Workbook wb = Workbook.getWorkbook(fs);

			// To get the sheet access by sheet name
			Sheet sh = wb.getSheet("Products");

			// To get the number of rows present in sheet
			int totalNoOfRows = sh.getRows();
			System.out.println("The total no. of rows are: " + totalNoOfRows);

			// To get the number of columns present in sheet
			int totalNoOfCols = sh.getColumns();
			System.out.println("The total no. of columns are: " + totalNoOfCols);

			// To get the content in particular location, which will return
			// contents as a string
			String CellGetContent = sh.getCell(0, 6).getContents();
			System.out.println("The content of the cell is: " + CellGetContent);

			Log.info("Enter product name in Search textbox");
			System.out.println("Enter product name in Search textbox");
			driver.findElement(By.id("search-box")).clear();
			driver.findElement(By.id("search-box")).sendKeys(CellGetContent);

			Log.info("Click on Search");
			System.out.println("Click on Search");
			driver.findElement(By.id("search-button")).click();

			Log.info("Select the Product");
			System.out.println("Select the Product");
			WebElement product = driver.findElement(By.linkText(CellGetContent));
			product.click();
			Thread.sleep(5000);

			Log.info("Select the Format");
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
			} else {
				System.out.println("The product cannot be added to basket as the status is: " + stat);
			}

			/*
			 * Thread.sleep(2000); Log.info("Click on CheckOut");
			 * System.out.println("Click on CheckOut"); basket.clickCheckout();
			 */
		} catch (Exception e) {
			e.printStackTrace();
			Assert.fail(e.getMessage());
		}
	}

	@Test(priority = 7, enabled = true)
	public void searchProduct7() throws BiffException, IOException {

		System.out.println("Fetching the URL");
		driver.get(url);

		try {
			test = extent.startTest("search and update Product 7");
			// To access to Workbook
			String FilePath = "D:\\BSI_FW\\BSI\\BSI.Automation.Regression\\TestData\\List_of_products_users-TCS.xls";
			FileInputStream fs = new FileInputStream(FilePath);
			Workbook wb = Workbook.getWorkbook(fs);

			// To get the sheet access by sheet name
			Sheet sh = wb.getSheet("Products");

			// To get the number of rows present in sheet
			int totalNoOfRows = sh.getRows();
			System.out.println("The total no. of rows are: " + totalNoOfRows);

			// To get the number of columns present in sheet
			int totalNoOfCols = sh.getColumns();
			System.out.println("The total no. of columns are: " + totalNoOfCols);

			// To get the content in particular location, which will return
			// contents as a string
			String CellGetContent = sh.getCell(0, 7).getContents();
			System.out.println("The content of the cell is: " + CellGetContent);

			Log.info("Enter product name in Search textbox");
			System.out.println("Enter product name in Search textbox");
			driver.findElement(By.id("search-box")).clear();
			driver.findElement(By.id("search-box")).sendKeys(CellGetContent);

			Log.info("Click on Search");
			System.out.println("Click on Search");
			driver.findElement(By.id("search-button")).click();

			Log.info("Select the Product");
			System.out.println("Select the Product");
			WebElement product = driver.findElement(By.linkText(CellGetContent));
			product.click();
			Thread.sleep(5000);

			Log.info("Select the Format");
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
			} else {
				System.out.println("The product cannot be added to basket as the status is: " + stat);
			}

			/*
			 * Thread.sleep(2000); Log.info("Click on CheckOut");
			 * System.out.println("Click on CheckOut"); basket.clickCheckout();
			 */
		} catch (Exception e) {
			e.printStackTrace();
			Assert.fail(e.getMessage());
		}
	}

	@Test(priority = 8, enabled = true)
	public void searchProduct8() throws BiffException, IOException {

		System.out.println("Fetching the URL");
		driver.get(url);

		try {
			test = extent.startTest("search and update Product 8");
			// To access to Workbook
			String FilePath = "D:\\BSI_FW\\BSI\\BSI.Automation.Regression\\TestData\\List_of_products_users-TCS.xls";
			FileInputStream fs = new FileInputStream(FilePath);
			Workbook wb = Workbook.getWorkbook(fs);

			// To get the sheet access by sheet name
			Sheet sh = wb.getSheet("Products");

			// To get the number of rows present in sheet
			int totalNoOfRows = sh.getRows();
			System.out.println("The total no. of rows are: " + totalNoOfRows);

			// To get the number of columns present in sheet
			int totalNoOfCols = sh.getColumns();
			System.out.println("The total no. of columns are: " + totalNoOfCols);

			// To get the content in particular location, which will return
			// contents as a string
			String CellGetContent = sh.getCell(0, 8).getContents();
			System.out.println("The content of the cell is: " + CellGetContent);

			Log.info("Enter product name in Search textbox");
			System.out.println("Enter product name in Search textbox");
			driver.findElement(By.id("search-box")).clear();
			driver.findElement(By.id("search-box")).sendKeys(CellGetContent);

			Log.info("Click on Search");
			System.out.println("Click on Search");
			driver.findElement(By.id("search-button")).click();

			Log.info("Select the Product");
			System.out.println("Select the Product");
			WebElement product = driver.findElement(By.linkText(CellGetContent));
			product.click();
			Thread.sleep(5000);

			Log.info("Select the Format");
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
			} else {
				System.out.println("The product cannot be added to basket as the status is: " + stat);
			}

			/*
			 * Thread.sleep(2000); Log.info("Click on CheckOut");
			 * System.out.println("Click on CheckOut"); basket.clickCheckout();
			 */
		} catch (Exception e) {
			e.printStackTrace();
			Assert.fail(e.getMessage());
		}
	}

	@Test(priority = 9, enabled = true)
	public void searchProduct9() throws BiffException, IOException {

		System.out.println("Fetching the URL");
		driver.get(url);

		try {
			test = extent.startTest("search and update Product 9");
			// To access to Workbook
			String FilePath = "D:\\BSI_FW\\BSI\\BSI.Automation.Regression\\TestData\\List_of_products_users-TCS.xls";
			FileInputStream fs = new FileInputStream(FilePath);
			Workbook wb = Workbook.getWorkbook(fs);

			// To get the sheet access by sheet name
			Sheet sh = wb.getSheet("Products");

			// To get the number of rows present in sheet
			int totalNoOfRows = sh.getRows();
			System.out.println("The total no. of rows are: " + totalNoOfRows);

			// To get the number of columns present in sheet
			int totalNoOfCols = sh.getColumns();
			System.out.println("The total no. of columns are: " + totalNoOfCols);

			// To get the content in particular location, which will return
			// contents as a string
			String CellGetContent = sh.getCell(0, 9).getContents();
			System.out.println("The content of the cell is: " + CellGetContent);

			Log.info("Enter product name in Search textbox");
			System.out.println("Enter product name in Search textbox");
			driver.findElement(By.id("search-box")).clear();
			driver.findElement(By.id("search-box")).sendKeys(CellGetContent);

			Log.info("Click on Search");
			System.out.println("Click on Search");
			driver.findElement(By.id("search-button")).click();

			Log.info("Select the Product");
			System.out.println("Select the Product");
			WebElement product = driver.findElement(By.linkText(CellGetContent));
			product.click();
			Thread.sleep(5000);

			Log.info("Select the Format");
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
			} else {
				System.out.println("The product cannot be added to basket as the status is: " + stat);
			}
			/*
			 * Thread.sleep(2000); Log.info("Click on CheckOut");
			 * System.out.println("Click on CheckOut"); basket.clickCheckout();
			 */
		} catch (Exception e) {
			e.printStackTrace();
			Assert.fail(e.getMessage());
		}
	}

	@Test(priority = 10, enabled = true)
	public void searchProduct10() throws BiffException, IOException {

		System.out.println("Fetching the URL");
		driver.get(url);

		try {
			test = extent.startTest("search and update Product 10");
			// To access to Workbook
			String FilePath = "D:\\BSI_FW\\BSI\\BSI.Automation.Regression\\TestData\\List_of_products_users-TCS.xls";
			FileInputStream fs = new FileInputStream(FilePath);
			Workbook wb = Workbook.getWorkbook(fs);

			// To get the sheet access by sheet name
			Sheet sh = wb.getSheet("Products");

			// To get the number of rows present in sheet
			int totalNoOfRows = sh.getRows();
			System.out.println("The total no. of rows are: " + totalNoOfRows);

			// To get the number of columns present in sheet
			int totalNoOfCols = sh.getColumns();
			System.out.println("The total no. of columns are: " + totalNoOfCols);

			// To get the content in particular location, which will return
			// contents as a string
			String CellGetContent = sh.getCell(0, 10).getContents();
			System.out.println("The content of the cell is: " + CellGetContent);

			Log.info("Enter product name in Search textbox");
			System.out.println("Enter product name in Search textbox");
			driver.findElement(By.id("search-box")).clear();
			driver.findElement(By.id("search-box")).sendKeys(CellGetContent);

			Log.info("Click on Search");
			System.out.println("Click on Search");
			driver.findElement(By.id("search-button")).click();

			Log.info("Select the Product");
			System.out.println("Select the Product");
			WebElement product = driver.findElement(By.linkText(CellGetContent));
			product.click();
			Thread.sleep(5000);

			Log.info("Select the Format");
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
			} else {
				System.out.println("The product cannot be added to basket as the status is: " + stat);
			}

			/*
			 * Thread.sleep(2000); Log.info("Click on CheckOut");
			 * System.out.println("Click on CheckOut"); basket.clickCheckout();
			 */
		} catch (Exception e) {
			e.printStackTrace();
			Assert.fail(e.getMessage());
		}
	}

	@Test(priority = 11, enabled = true)
	public void searchProduct11() throws BiffException, IOException {

		System.out.println("Fetching the URL");
		driver.get(url);

		try {
			test = extent.startTest("search and update Product 11");
			// To access to Workbook
			String FilePath = "D:\\BSI_FW\\BSI\\BSI.Automation.Regression\\TestData\\List_of_products_users-TCS.xls";
			FileInputStream fs = new FileInputStream(FilePath);
			Workbook wb = Workbook.getWorkbook(fs);

			// To get the sheet access by sheet name
			Sheet sh = wb.getSheet("Products");

			// To get the number of rows present in sheet
			int totalNoOfRows = sh.getRows();
			System.out.println("The total no. of rows are: " + totalNoOfRows);

			// To get the number of columns present in sheet
			int totalNoOfCols = sh.getColumns();
			System.out.println("The total no. of columns are: " + totalNoOfCols);

			// To get the content in particular location, which will return
			// contents as a string
			String CellGetContent = sh.getCell(0, 11).getContents();
			System.out.println("The content of the cell is: " + CellGetContent);

			Log.info("Enter product name in Search textbox");
			System.out.println("Enter product name in Search textbox");
			driver.findElement(By.id("search-box")).clear();
			driver.findElement(By.id("search-box")).sendKeys(CellGetContent);

			Log.info("Click on Search");
			System.out.println("Click on Search");
			driver.findElement(By.id("search-button")).click();

			Log.info("Select the Product");
			System.out.println("Select the Product");
			WebElement product = driver.findElement(By.linkText(CellGetContent));
			product.click();
			Thread.sleep(5000);

			Log.info("Select the Format");
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
			} else {
				System.out.println("The product cannot be added to basket as the status is: " + stat);
			}

			/*
			 * Thread.sleep(2000); Log.info("Click on CheckOut");
			 * System.out.println("Click on CheckOut"); basket.clickCheckout();
			 */

		} catch (Exception e) {
			e.printStackTrace();
			Assert.fail(e.getMessage());
		}
	}

	@Test(priority = 12, enabled = true)
	public void searchProduct12() throws BiffException, IOException {

		System.out.println("Fetching the URL");
		driver.get(url);

		try {
			test = extent.startTest("search and update Product 12");
			// To access to Workbook
			String FilePath = "D:\\BSI_FW\\BSI\\BSI.Automation.Regression\\TestData\\List_of_products_users-TCS.xls";
			FileInputStream fs = new FileInputStream(FilePath);
			Workbook wb = Workbook.getWorkbook(fs);

			// To get the sheet access by sheet name
			Sheet sh = wb.getSheet("Products");

			// To get the number of rows present in sheet
			int totalNoOfRows = sh.getRows();
			System.out.println("The total no. of rows are: " + totalNoOfRows);

			// To get the number of columns present in sheet
			int totalNoOfCols = sh.getColumns();
			System.out.println("The total no. of columns are: " + totalNoOfCols);

			// To get the content in particular location, which will return
			// contents as a string
			String CellGetContent = sh.getCell(0, 12).getContents();
			System.out.println("The content of the cell is: " + CellGetContent);

			Log.info("Enter product name in Search textbox");
			System.out.println("Enter product name in Search textbox");
			driver.findElement(By.id("search-box")).clear();
			driver.findElement(By.id("search-box")).sendKeys(CellGetContent);

			Log.info("Click on Search");
			System.out.println("Click on Search");
			driver.findElement(By.id("search-button")).click();

			Log.info("Select the Product");
			System.out.println("Select the Product");
			WebElement product = driver.findElement(By.linkText(CellGetContent));
			product.click();
			Thread.sleep(5000);

			Log.info("Select the Format");
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
			} else {
				System.out.println("The product cannot be added to basket as the status is: " + stat);
			}

			/*
			 * Thread.sleep(2000); Log.info("Click on CheckOut");
			 * System.out.println("Click on CheckOut"); basket.clickCheckout();
			 */
		} catch (Exception e) {
			e.printStackTrace();
			Assert.fail(e.getMessage());
		}
	}

	@Test(priority = 13, enabled = true)
	public void searchProduct13() throws BiffException, IOException {

		System.out.println("Fetching the URL");
		driver.get(url);

		try {
			test = extent.startTest("search and update Product 13");
			// To access to Workbook
			String FilePath = "D:\\BSI_FW\\BSI\\BSI.Automation.Regression\\TestData\\List_of_products_users-TCS.xls";
			FileInputStream fs = new FileInputStream(FilePath);
			Workbook wb = Workbook.getWorkbook(fs);

			// To get the sheet access by sheet name
			Sheet sh = wb.getSheet("Products");

			// To get the number of rows present in sheet
			int totalNoOfRows = sh.getRows();
			System.out.println("The total no. of rows are: " + totalNoOfRows);

			// To get the number of columns present in sheet
			int totalNoOfCols = sh.getColumns();
			System.out.println("The total no. of columns are: " + totalNoOfCols);

			// To get the content in particular location, which will return
			// contents as a string
			String CellGetContent = sh.getCell(0, 13).getContents();
			System.out.println("The content of the cell is: " + CellGetContent);

			Log.info("Enter product name in Search textbox");
			System.out.println("Enter product name in Search textbox");
			driver.findElement(By.id("search-box")).clear();
			driver.findElement(By.id("search-box")).sendKeys(CellGetContent);

			Log.info("Click on Search");
			System.out.println("Click on Search");
			driver.findElement(By.id("search-button")).click();

			Log.info("Select the Product");
			System.out.println("Select the Product");
			WebElement product = driver.findElement(By.linkText(CellGetContent));
			product.click();
			Thread.sleep(5000);

			Log.info("Select the Format");
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
			} else {
				System.out.println("The product cannot be added to basket as the status is: " + stat);
			}

			/*
			 * Thread.sleep(2000); Log.info("Click on CheckOut");
			 * System.out.println("Click on CheckOut"); basket.clickCheckout();
			 */

		} catch (Exception e) {
			e.printStackTrace();
			Assert.fail(e.getMessage());
		}
	}

	@Test(priority = 14, enabled = true)
	public void searchProduct14() throws BiffException, IOException {

		System.out.println("Fetching the URL");
		driver.get(url);

		try {
			test = extent.startTest("search and update Product 14");
			// To access to Workbook
			String FilePath = "D:\\BSI_FW\\BSI\\BSI.Automation.Regression\\TestData\\List_of_products_users-TCS.xls";
			FileInputStream fs = new FileInputStream(FilePath);
			Workbook wb = Workbook.getWorkbook(fs);

			// To get the sheet access by sheet name
			Sheet sh = wb.getSheet("Products");

			// To get the number of rows present in sheet
			int totalNoOfRows = sh.getRows();
			System.out.println("The total no. of rows are: " + totalNoOfRows);

			// To get the number of columns present in sheet
			int totalNoOfCols = sh.getColumns();
			System.out.println("The total no. of columns are: " + totalNoOfCols);

			// To get the content in particular location, which will return
			// contents as a string
			String CellGetContent = sh.getCell(0, 14).getContents();
			System.out.println("The content of the cell is: " + CellGetContent);

			Log.info("Enter product name in Search textbox");
			System.out.println("Enter product name in Search textbox");
			driver.findElement(By.id("search-box")).clear();
			driver.findElement(By.id("search-box")).sendKeys(CellGetContent);

			Log.info("Click on Search");
			System.out.println("Click on Search");
			driver.findElement(By.id("search-button")).click();

			Log.info("Select the Product");
			System.out.println("Select the Product");
			WebElement product = driver.findElement(By.linkText(CellGetContent));
			product.click();
			Thread.sleep(5000);

			Log.info("Select the Format");
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
			} else {
				System.out.println("The product cannot be added to basket as the status is: " + stat);
			}

			/*
			 * Thread.sleep(2000); Log.info("Click on CheckOut");
			 * System.out.println("Click on CheckOut"); basket.clickCheckout();
			 */

		} catch (Exception e) {
			e.printStackTrace();
			Assert.fail(e.getMessage());
		}
	}

	@Test(priority = 15, enabled = true)
	public void searchProduct15() throws BiffException, IOException {

		System.out.println("Fetching the URL");
		driver.get(url);

		try {
			test = extent.startTest("search and update Product 15");
			// To access to Workbook
			String FilePath = "D:\\BSI_FW\\BSI\\BSI.Automation.Regression\\TestData\\List_of_products_users-TCS.xls";
			FileInputStream fs = new FileInputStream(FilePath);
			Workbook wb = Workbook.getWorkbook(fs);

			// To get the sheet access by sheet name
			Sheet sh = wb.getSheet("Products");

			// To get the number of rows present in sheet
			int totalNoOfRows = sh.getRows();
			System.out.println("The total no. of rows are: " + totalNoOfRows);

			// To get the number of columns present in sheet
			int totalNoOfCols = sh.getColumns();
			System.out.println("The total no. of columns are: " + totalNoOfCols);

			// To get the content in particular location, which will return
			// contents as a string
			String CellGetContent = sh.getCell(0, 15).getContents();
			System.out.println("The content of the cell is: " + CellGetContent);

			Log.info("Enter product name in Search textbox");
			System.out.println("Enter product name in Search textbox");
			driver.findElement(By.id("search-box")).clear();
			driver.findElement(By.id("search-box")).sendKeys(CellGetContent);

			Log.info("Click on Search");
			System.out.println("Click on Search");
			driver.findElement(By.id("search-button")).click();

			Log.info("Select the Product");
			System.out.println("Select the Product");
			WebElement product = driver.findElement(By.linkText(CellGetContent));
			product.click();
			Thread.sleep(5000);

			Log.info("Select the Format");
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
			} else {
				System.out.println("The product cannot be added to basket as the status is: " + stat);
			}
			/*
			 * Thread.sleep(2000); Log.info("Click on CheckOut");
			 * System.out.println("Click on CheckOut"); basket.clickCheckout();
			 */

		} catch (Exception e) {
			e.printStackTrace();
			Assert.fail(e.getMessage());
		}
	}

	@Test(priority = 16, enabled = true)
	public void searchProduct16() throws BiffException, IOException {

		System.out.println("Fetching the URL");
		driver.get(url);

		try {
			test = extent.startTest("search and update Product 16");
			// To access to Workbook
			String FilePath = "D:\\BSI_FW\\BSI\\BSI.Automation.Regression\\TestData\\List_of_products_users-TCS.xls";
			FileInputStream fs = new FileInputStream(FilePath);
			Workbook wb = Workbook.getWorkbook(fs);

			// To get the sheet access by sheet name
			Sheet sh = wb.getSheet("Products");

			// To get the number of rows present in sheet
			int totalNoOfRows = sh.getRows();
			System.out.println("The total no. of rows are: " + totalNoOfRows);

			// To get the number of columns present in sheet
			int totalNoOfCols = sh.getColumns();
			System.out.println("The total no. of columns are: " + totalNoOfCols);

			// To get the content in particular location, which will return
			// contents as a string
			String CellGetContent = sh.getCell(0, 16).getContents();
			System.out.println("The content of the cell is: " + CellGetContent);

			Log.info("Enter product name in Search textbox");
			System.out.println("Enter product name in Search textbox");
			driver.findElement(By.id("search-box")).clear();
			driver.findElement(By.id("search-box")).sendKeys(CellGetContent);

			Log.info("Click on Search");
			System.out.println("Click on Search");
			driver.findElement(By.id("search-button")).click();

			Log.info("Select the Product");
			System.out.println("Select the Product");
			WebElement product = driver.findElement(By.linkText(CellGetContent));
			product.click();
			Thread.sleep(5000);

			Log.info("Select the Format");
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
			} else {
				System.out.println("The product cannot be added to basket as the status is: " + stat);
			}

			/*
			 * Thread.sleep(2000); Log.info("Click on CheckOut");
			 * System.out.println("Click on CheckOut"); basket.clickCheckout();
			 */

		} catch (Exception e) {
			e.printStackTrace();
			Assert.fail(e.getMessage());
		}
	}

	@Test(priority = 17, enabled = true)
	public void searchProduct17() throws BiffException, IOException {

		System.out.println("Fetching the URL");
		driver.get(url);

		try {
			test = extent.startTest("search and update Product 17");
			// To access to Workbook
			String FilePath = "D:\\BSI_FW\\BSI\\BSI.Automation.Regression\\TestData\\List_of_products_users-TCS.xls";
			FileInputStream fs = new FileInputStream(FilePath);
			Workbook wb = Workbook.getWorkbook(fs);

			// To get the sheet access by sheet name
			Sheet sh = wb.getSheet("Products");

			// To get the number of rows present in sheet
			int totalNoOfRows = sh.getRows();
			System.out.println("The total no. of rows are: " + totalNoOfRows);

			// To get the number of columns present in sheet
			int totalNoOfCols = sh.getColumns();
			System.out.println("The total no. of columns are: " + totalNoOfCols);

			// To get the content in particular location, which will return
			// contents as a string
			String CellGetContent = sh.getCell(0, 17).getContents();
			System.out.println("The content of the cell is: " + CellGetContent);

			Log.info("Enter product name in Search textbox");
			System.out.println("Enter product name in Search textbox");
			driver.findElement(By.id("search-box")).clear();
			driver.findElement(By.id("search-box")).sendKeys(CellGetContent);

			Log.info("Click on Search");
			System.out.println("Click on Search");
			driver.findElement(By.id("search-button")).click();

			Log.info("Select the Product");
			System.out.println("Select the Product");
			WebElement product = driver.findElement(By.linkText(CellGetContent));
			product.click();
			Thread.sleep(5000);

			Log.info("Select the Format");
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
			} else {
				System.out.println("The product cannot be added to basket as the status is: " + stat);
			}

			/*
			 * Thread.sleep(2000); Log.info("Click on CheckOut");
			 * System.out.println("Click on CheckOut"); basket.clickCheckout();
			 */
		} catch (Exception e) {
			e.printStackTrace();
			Assert.fail(e.getMessage());
		}
	}

	@Test(priority = 18, enabled = true)
	public void searchProduct18() throws BiffException, IOException {

		System.out.println("Fetching the URL");
		driver.get(url);

		try {
			test = extent.startTest("search and update Product 18");
			// To access to Workbook
			String FilePath = "D:\\BSI_FW\\BSI\\BSI.Automation.Regression\\TestData\\List_of_products_users-TCS.xls";
			FileInputStream fs = new FileInputStream(FilePath);
			Workbook wb = Workbook.getWorkbook(fs);

			// To get the sheet access by sheet name
			Sheet sh = wb.getSheet("Products");

			// To get the number of rows present in sheet
			int totalNoOfRows = sh.getRows();
			System.out.println("The total no. of rows are: " + totalNoOfRows);

			// To get the number of columns present in sheet
			int totalNoOfCols = sh.getColumns();
			System.out.println("The total no. of columns are: " + totalNoOfCols);

			// To get the content in particular location, which will return
			// contents as a string
			String CellGetContent = sh.getCell(0, 18).getContents();
			System.out.println("The content of the cell is: " + CellGetContent);

			Log.info("Enter product name in Search textbox");
			System.out.println("Enter product name in Search textbox");
			driver.findElement(By.id("search-box")).clear();
			driver.findElement(By.id("search-box")).sendKeys(CellGetContent);

			Log.info("Click on Search");
			System.out.println("Click on Search");
			driver.findElement(By.id("search-button")).click();

			Log.info("Select the Product");
			System.out.println("Select the Product");
			WebElement product = driver.findElement(By.linkText(CellGetContent));
			product.click();
			Thread.sleep(5000);

			Log.info("Select the Format");
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
			} else {
				System.out.println("The product cannot be added to basket as the status is: " + stat);
			}
			/*
			 * Thread.sleep(2000); Log.info("Click on CheckOut");
			 * System.out.println("Click on CheckOut"); basket.clickCheckout();
			 */

		} catch (Exception e) {
			e.printStackTrace();
			Assert.fail(e.getMessage());
		}
	}

	@Test(priority = 19, enabled = true)
	public void searchProduct19() throws BiffException, IOException {

		System.out.println("Fetching the URL");
		driver.get(url);

		try {
			test = extent.startTest("search and update Product 19");
			// To access to Workbook
			String FilePath = "D:\\BSI_FW\\BSI\\BSI.Automation.Regression\\TestData\\List_of_products_users-TCS.xls";
			FileInputStream fs = new FileInputStream(FilePath);
			Workbook wb = Workbook.getWorkbook(fs);

			// To get the sheet access by sheet name
			Sheet sh = wb.getSheet("Products");

			// To get the number of rows present in sheet
			int totalNoOfRows = sh.getRows();
			System.out.println("The total no. of rows are: " + totalNoOfRows);

			// To get the number of columns present in sheet
			int totalNoOfCols = sh.getColumns();
			System.out.println("The total no. of columns are: " + totalNoOfCols);

			// To get the content in particular location, which will return
			// contents as a string
			String CellGetContent = sh.getCell(0, 19).getContents();
			System.out.println("The content of the cell is: " + CellGetContent);

			Log.info("Enter product name in Search textbox");
			System.out.println("Enter product name in Search textbox");
			driver.findElement(By.id("search-box")).clear();
			driver.findElement(By.id("search-box")).sendKeys(CellGetContent);

			Log.info("Click on Search");
			System.out.println("Click on Search");
			driver.findElement(By.id("search-button")).click();

			Log.info("Select the Product");
			System.out.println("Select the Product");
			WebElement product = driver.findElement(By.linkText(CellGetContent));
			product.click();
			Thread.sleep(5000);

			Log.info("Select the Format");
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
			} else {
				System.out.println("The product cannot be added to basket as the status is: " + stat);
			}

			/*
			 * Thread.sleep(2000); Log.info("Click on CheckOut");
			 * System.out.println("Click on CheckOut"); basket.clickCheckout();
			 */

		} catch (Exception e) {
			e.printStackTrace();
			Assert.fail(e.getMessage());
		}
	}

	@Test(priority = 20, enabled = true)
	public void searchProduct20() throws BiffException, IOException {

		System.out.println("Fetching the URL");
		driver.get(url);

		try {
			test = extent.startTest("search and update Product 20");
			// To access to Workbook
			String FilePath = "D:\\BSI_FW\\BSI\\BSI.Automation.Regression\\TestData\\List_of_products_users-TCS.xls";
			FileInputStream fs = new FileInputStream(FilePath);
			Workbook wb = Workbook.getWorkbook(fs);

			// To get the sheet access by sheet name
			Sheet sh = wb.getSheet("Products");

			// To get the number of rows present in sheet
			int totalNoOfRows = sh.getRows();
			System.out.println("The total no. of rows are: " + totalNoOfRows);

			// To get the number of columns present in sheet
			int totalNoOfCols = sh.getColumns();
			System.out.println("The total no. of columns are: " + totalNoOfCols);

			// To get the content in particular location, which will return
			// contents as a string
			String CellGetContent = sh.getCell(0, 20).getContents();
			System.out.println("The content of the cell is: " + CellGetContent);

			Log.info("Enter product name in Search textbox");
			System.out.println("Enter product name in Search textbox");
			driver.findElement(By.id("search-box")).clear();
			driver.findElement(By.id("search-box")).sendKeys(CellGetContent);

			Log.info("Click on Search");
			System.out.println("Click on Search");
			driver.findElement(By.id("search-button")).click();

			Log.info("Select the Product");
			System.out.println("Select the Product");
			WebElement product = driver.findElement(By.linkText(CellGetContent));
			product.click();
			Thread.sleep(5000);

			Log.info("Select the Format");
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
			} else {
				System.out.println("The product cannot be added to basket as the status is: " + stat);
			}

			/*
			 * Thread.sleep(2000); Log.info("Click on CheckOut");
			 * System.out.println("Click on CheckOut"); basket.clickCheckout();
			 */
		} catch (Exception e) {
			e.printStackTrace();
			Assert.fail(e.getMessage());
		}
	}

	@Test(priority = 21, enabled = true)
	public void searchProduct21() throws BiffException, IOException {

		System.out.println("Fetching the URL");
		driver.get(url);

		try {
			test = extent.startTest("search and update Product 21");
			// To access to Workbook
			String FilePath = "D:\\BSI_FW\\BSI\\BSI.Automation.Regression\\TestData\\List_of_products_users-TCS.xls";
			FileInputStream fs = new FileInputStream(FilePath);
			Workbook wb = Workbook.getWorkbook(fs);

			// To get the sheet access by sheet name
			Sheet sh = wb.getSheet("Products");

			// To get the number of rows present in sheet
			int totalNoOfRows = sh.getRows();
			System.out.println("The total no. of rows are: " + totalNoOfRows);

			// To get the number of columns present in sheet
			int totalNoOfCols = sh.getColumns();
			System.out.println("The total no. of columns are: " + totalNoOfCols);

			// To get the content in particular location, which will return
			// contents as a string
			String CellGetContent = sh.getCell(0, 21).getContents();
			System.out.println("The content of the cell is: " + CellGetContent);

			Log.info("Enter product name in Search textbox");
			System.out.println("Enter product name in Search textbox");
			driver.findElement(By.id("search-box")).clear();
			driver.findElement(By.id("search-box")).sendKeys(CellGetContent);

			Log.info("Click on Search");
			System.out.println("Click on Search");
			driver.findElement(By.id("search-button")).click();

			Log.info("Select the Product");
			System.out.println("Select the Product");
			WebElement product = driver.findElement(By.linkText(CellGetContent));
			product.click();
			Thread.sleep(5000);

			Log.info("Select the Format");
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
			} else {
				System.out.println("The product cannot be added to basket as the status is: " + stat);
			}

		} catch (Exception e) {
			e.printStackTrace();
			Assert.fail(e.getMessage());
		}
	}

	@Test(priority = 22, enabled = true)
	public void searchProduct22() throws BiffException, IOException {

		System.out.println("Fetching the URL");
		driver.get(url);

		try {
			test = extent.startTest("search and update Product 22");
			// To access to Workbook
			String FilePath = "D:\\BSI_FW\\BSI\\BSI.Automation.Regression\\TestData\\List_of_products_users-TCS.xls";
			FileInputStream fs = new FileInputStream(FilePath);
			Workbook wb = Workbook.getWorkbook(fs);

			// To get the sheet access by sheet name
			Sheet sh = wb.getSheet("Products");

			// To get the number of rows present in sheet
			int totalNoOfRows = sh.getRows();
			System.out.println("The total no. of rows are: " + totalNoOfRows);

			// To get the number of columns present in sheet
			int totalNoOfCols = sh.getColumns();
			System.out.println("The total no. of columns are: " + totalNoOfCols);

			// To get the content in particular location, which will return
			// contents as a string
			String CellGetContent = sh.getCell(0, 22).getContents();
			System.out.println("The content of the cell is: " + CellGetContent);

			Log.info("Enter product name in Search textbox");
			System.out.println("Enter product name in Search textbox");
			driver.findElement(By.id("search-box")).clear();
			driver.findElement(By.id("search-box")).sendKeys(CellGetContent);

			Log.info("Click on Search");
			System.out.println("Click on Search");
			driver.findElement(By.id("search-button")).click();

			Log.info("Select the Product");
			System.out.println("Select the Product");
			WebElement product = driver.findElement(By.linkText(CellGetContent));
			product.click();
			Thread.sleep(5000);

			Log.info("Select the Format");
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
			} else {
				System.out.println("The product cannot be added to basket as the status is: " + stat);
			}
			/*
			 * Thread.sleep(2000); Log.info("Click on CheckOut");
			 * System.out.println("Click on CheckOut"); basket.clickCheckout();
			 */

		} catch (Exception e) {
			e.printStackTrace();
			Assert.fail(e.getMessage());
		}
	}

	@Test(priority = 23, enabled = true)
	public void searchProduct23() throws BiffException, IOException {

		System.out.println("Fetching the URL");
		driver.get(url);

		try {
			test = extent.startTest("search and update Product 23");
			// To access to Workbook
			String FilePath = "D:\\BSI_FW\\BSI\\BSI.Automation.Regression\\TestData\\List_of_products_users-TCS.xls";
			FileInputStream fs = new FileInputStream(FilePath);
			Workbook wb = Workbook.getWorkbook(fs);

			// To get the sheet access by sheet name
			Sheet sh = wb.getSheet("Products");

			// To get the number of rows present in sheet
			int totalNoOfRows = sh.getRows();
			System.out.println("The total no. of rows are: " + totalNoOfRows);

			// To get the number of columns present in sheet
			int totalNoOfCols = sh.getColumns();
			System.out.println("The total no. of columns are: " + totalNoOfCols);

			// To get the content in particular location, which will return
			// contents as a string
			String CellGetContent = sh.getCell(0, 23).getContents();
			System.out.println("The content of the cell is: " + CellGetContent);

			Log.info("Enter product name in Search textbox");
			System.out.println("Enter product name in Search textbox");
			driver.findElement(By.id("search-box")).clear();
			driver.findElement(By.id("search-box")).sendKeys(CellGetContent);

			Log.info("Click on Search");
			System.out.println("Click on Search");
			driver.findElement(By.id("search-button")).click();

			Log.info("Select the Product");
			System.out.println("Select the Product");
			WebElement product = driver.findElement(By.linkText(CellGetContent));
			product.click();
			Thread.sleep(5000);

			Log.info("Select the Format");
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
			} else {
				System.out.println("The product cannot be added to basket as the status is: " + stat);
			}
			/*
			 * Thread.sleep(2000); Log.info("Click on CheckOut");
			 * System.out.println("Click on CheckOut"); basket.clickCheckout();
			 */
		} catch (Exception e) {
			e.printStackTrace();
			Assert.fail(e.getMessage());
		}
	}

	@Test(priority = 24, enabled = true)
	public void searchProduct24() throws BiffException, IOException {

		System.out.println("Fetching the URL");
		driver.get(url);

		try {
			test = extent.startTest("search and update Product 24");
			// To access to Workbook
			String FilePath = "D:\\BSI_FW\\BSI\\BSI.Automation.Regression\\TestData\\List_of_products_users-TCS.xls";
			FileInputStream fs = new FileInputStream(FilePath);
			Workbook wb = Workbook.getWorkbook(fs);

			// To get the sheet access by sheet name
			Sheet sh = wb.getSheet("Products");

			// To get the number of rows present in sheet
			int totalNoOfRows = sh.getRows();
			System.out.println("The total no. of rows are: " + totalNoOfRows);

			// To get the number of columns present in sheet
			int totalNoOfCols = sh.getColumns();
			System.out.println("The total no. of columns are: " + totalNoOfCols);

			// To get the content in particular location, which will return
			// contents as a string
			String CellGetContent = sh.getCell(0, 24).getContents();
			System.out.println("The content of the cell is: " + CellGetContent);

			Log.info("Enter product name in Search textbox");
			System.out.println("Enter product name in Search textbox");
			driver.findElement(By.id("search-box")).clear();
			driver.findElement(By.id("search-box")).sendKeys(CellGetContent);

			Log.info("Click on Search");
			System.out.println("Click on Search");
			driver.findElement(By.id("search-button")).click();

			Log.info("Select the Product");
			System.out.println("Select the Product");
			WebElement product = driver.findElement(By.linkText(CellGetContent));
			product.click();
			Thread.sleep(5000);

			Log.info("Select the Format");
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
			} else {
				System.out.println("The product cannot be added to basket as the status is: " + stat);
			}

			/*
			 * Thread.sleep(2000); Log.info("Click on CheckOut");
			 * System.out.println("Click on CheckOut"); basket.clickCheckout();
			 */
		} catch (Exception e) {
			e.printStackTrace();
			Assert.fail(e.getMessage());
		}
	}

	@Test(priority = 25, enabled = true)
	public void searchProduct25() throws BiffException, IOException {

		System.out.println("Fetching the URL");
		driver.get(url);

		try {
			test = extent.startTest("search and update Product 25");
			// To access to Workbook
			String FilePath = "D:\\BSI_FW\\BSI\\BSI.Automation.Regression\\TestData\\List_of_products_users-TCS.xls";
			FileInputStream fs = new FileInputStream(FilePath);
			Workbook wb = Workbook.getWorkbook(fs);

			// To get the sheet access by sheet name
			Sheet sh = wb.getSheet("Products");

			// To get the number of rows present in sheet
			int totalNoOfRows = sh.getRows();
			System.out.println("The total no. of rows are: " + totalNoOfRows);

			// To get the number of columns present in sheet
			int totalNoOfCols = sh.getColumns();
			System.out.println("The total no. of columns are: " + totalNoOfCols);

			// To get the content in particular location, which will return
			// contents as a string
			String CellGetContent = sh.getCell(0, 25).getContents();
			System.out.println("The content of the cell is: " + CellGetContent);

			Log.info("Enter product name in Search textbox");
			System.out.println("Enter product name in Search textbox");
			driver.findElement(By.id("search-box")).clear();
			driver.findElement(By.id("search-box")).sendKeys(CellGetContent);

			Log.info("Click on Search");
			System.out.println("Click on Search");
			driver.findElement(By.id("search-button")).click();

			Log.info("Select the Product");
			System.out.println("Select the Product");
			WebElement product = driver.findElement(By.linkText(CellGetContent));
			product.click();
			Thread.sleep(5000);

			Log.info("Select the Format");
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
			} else {
				System.out.println("The product cannot be added to basket as the status is: " + stat);
			}

			/*
			 * Thread.sleep(2000); Log.info("Click on CheckOut");
			 * System.out.println("Click on CheckOut"); basket.clickCheckout();
			 */
		} catch (Exception e) {
			e.printStackTrace();
			Assert.fail(e.getMessage());
		}
	}

	@Test(priority = 26, enabled = true)
	public void searchProduct26() throws BiffException, IOException {

		System.out.println("Fetching the URL");
		driver.get(url);

		try {
			test = extent.startTest("search and update Product 26");
			// To access to Workbook
			String FilePath = "D:\\BSI_FW\\BSI\\BSI.Automation.Regression\\TestData\\List_of_products_users-TCS.xls";
			FileInputStream fs = new FileInputStream(FilePath);
			Workbook wb = Workbook.getWorkbook(fs);

			// To get the sheet access by sheet name
			Sheet sh = wb.getSheet("Products");

			// To get the number of rows present in sheet
			int totalNoOfRows = sh.getRows();
			System.out.println("The total no. of rows are: " + totalNoOfRows);

			// To get the number of columns present in sheet
			int totalNoOfCols = sh.getColumns();
			System.out.println("The total no. of columns are: " + totalNoOfCols);

			// To get the content in particular location, which will return
			// contents as a string
			String CellGetContent = sh.getCell(0, 26).getContents();
			System.out.println("The content of the cell is: " + CellGetContent);

			Log.info("Enter product name in Search textbox");
			System.out.println("Enter product name in Search textbox");
			driver.findElement(By.id("search-box")).clear();
			driver.findElement(By.id("search-box")).sendKeys(CellGetContent);

			Log.info("Click on Search");
			System.out.println("Click on Search");
			driver.findElement(By.id("search-button")).click();

			Log.info("Select the Product");
			System.out.println("Select the Product");
			WebElement product = driver.findElement(By.linkText(CellGetContent));
			product.click();
			Thread.sleep(5000);

			Log.info("Select the Format");
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
			} else {
				System.out.println("The product cannot be added to basket as the status is: " + stat);
			}
			/*
			 * Thread.sleep(2000); Log.info("Click on CheckOut");
			 * System.out.println("Click on CheckOut"); basket.clickCheckout();
			 */
		} catch (Exception e) {
			e.printStackTrace();
			Assert.fail(e.getMessage());
		}
	}

	@Test(priority = 27, enabled = true)
	public void searchProduct27() throws BiffException, IOException {

		System.out.println("Fetching the URL");
		driver.get(url);

		try {
			test = extent.startTest("search and update Product 27");
			// To access to Workbook
			String FilePath = "D:\\BSI_FW\\BSI\\BSI.Automation.Regression\\TestData\\List_of_products_users-TCS.xls";
			FileInputStream fs = new FileInputStream(FilePath);
			Workbook wb = Workbook.getWorkbook(fs);

			// To get the sheet access by sheet name
			Sheet sh = wb.getSheet("Products");

			// To get the number of rows present in sheet
			int totalNoOfRows = sh.getRows();
			System.out.println("The total no. of rows are: " + totalNoOfRows);

			// To get the number of columns present in sheet
			int totalNoOfCols = sh.getColumns();
			System.out.println("The total no. of columns are: " + totalNoOfCols);

			// To get the content in particular location, which will return
			// contents as a string
			String CellGetContent = sh.getCell(0, 27).getContents();
			System.out.println("The content of the cell is: " + CellGetContent);

			Log.info("Enter product name in Search textbox");
			System.out.println("Enter product name in Search textbox");
			driver.findElement(By.id("search-box")).clear();
			driver.findElement(By.id("search-box")).sendKeys(CellGetContent);

			Log.info("Click on Search");
			System.out.println("Click on Search");
			driver.findElement(By.id("search-button")).click();

			Log.info("Select the Product");
			System.out.println("Select the Product");
			WebElement product = driver.findElement(By.linkText(CellGetContent));
			product.click();
			Thread.sleep(5000);

			Log.info("Select the Format");
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
			} else {
				System.out.println("The product cannot be added to basket as the status is: " + stat);
			}
			/*
			 * Thread.sleep(2000); Log.info("Click on CheckOut");
			 * System.out.println("Click on CheckOut"); basket.clickCheckout();
			 */

		} catch (Exception e) {
			e.printStackTrace();
			Assert.fail(e.getMessage());
		}
	}

	@Test(priority = 28, enabled = true)
	public void searchProduct28() throws BiffException, IOException {

		System.out.println("Fetching the URL");
		driver.get(url);

		try {
			test = extent.startTest("search and update Product 28");
			// To access to Workbook
			String FilePath = "D:\\BSI_FW\\BSI\\BSI.Automation.Regression\\TestData\\List_of_products_users-TCS.xls";
			FileInputStream fs = new FileInputStream(FilePath);
			Workbook wb = Workbook.getWorkbook(fs);

			// To get the sheet access by sheet name
			Sheet sh = wb.getSheet("Products");

			// To get the number of rows present in sheet
			int totalNoOfRows = sh.getRows();
			System.out.println("The total no. of rows are: " + totalNoOfRows);

			// To get the number of columns present in sheet
			int totalNoOfCols = sh.getColumns();
			System.out.println("The total no. of columns are: " + totalNoOfCols);

			// To get the content in particular location, which will return
			// contents as a string
			String CellGetContent = sh.getCell(0, 28).getContents();
			System.out.println("The content of the cell is: " + CellGetContent);

			Log.info("Enter product name in Search textbox");
			System.out.println("Enter product name in Search textbox");
			driver.findElement(By.id("search-box")).clear();
			driver.findElement(By.id("search-box")).sendKeys(CellGetContent);

			Log.info("Click on Search");
			System.out.println("Click on Search");
			driver.findElement(By.id("search-button")).click();

			Log.info("Select the Product");
			System.out.println("Select the Product");
			WebElement product = driver.findElement(By.linkText(CellGetContent));
			product.click();
			Thread.sleep(5000);

			Log.info("Select the Format");
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
			} else {
				System.out.println("The product cannot be added to basket as the status is: " + stat);
			}

			/*
			 * Thread.sleep(2000); Log.info("Click on CheckOut");
			 * System.out.println("Click on CheckOut"); basket.clickCheckout();
			 */
		} catch (Exception e) {
			e.printStackTrace();
			Assert.fail(e.getMessage());
		}
	}

	@Test(priority = 29, enabled = true)
	public void searchProduct29() throws BiffException, IOException {

		System.out.println("Fetching the URL");
		driver.get(url);

		try {
			test = extent.startTest("search and update Product 29");
			// To access to Workbook
			String FilePath = "D:\\BSI_FW\\BSI\\BSI.Automation.Regression\\TestData\\List_of_products_users-TCS.xls";
			FileInputStream fs = new FileInputStream(FilePath);
			Workbook wb = Workbook.getWorkbook(fs);

			// To get the sheet access by sheet name
			Sheet sh = wb.getSheet("Products");

			// To get the number of rows present in sheet
			int totalNoOfRows = sh.getRows();
			System.out.println("The total no. of rows are: " + totalNoOfRows);

			// To get the number of columns present in sheet
			int totalNoOfCols = sh.getColumns();
			System.out.println("The total no. of columns are: " + totalNoOfCols);

			// To get the content in particular location, which will return
			// contents as a string
			String CellGetContent = sh.getCell(0, 29).getContents();
			System.out.println("The content of the cell is: " + CellGetContent);

			Log.info("Enter product name in Search textbox");
			System.out.println("Enter product name in Search textbox");
			driver.findElement(By.id("search-box")).clear();
			driver.findElement(By.id("search-box")).sendKeys(CellGetContent);

			Log.info("Click on Search");
			System.out.println("Click on Search");
			driver.findElement(By.id("search-button")).click();

			Log.info("Select the Product");
			System.out.println("Select the Product");
			WebElement product = driver.findElement(By.linkText(CellGetContent));
			product.click();
			Thread.sleep(5000);

			Log.info("Select the Format");
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
			} else {
				System.out.println("The product cannot be added to basket as the status is: " + stat);
			}
			/*
			 * Thread.sleep(2000); Log.info("Click on CheckOut");
			 * System.out.println("Click on CheckOut"); basket.clickCheckout();
			 */

		} catch (Exception e) {
			e.printStackTrace();
			Assert.fail(e.getMessage());
		}
	}

	@Test(priority = 30, enabled = true)
	public void searchProduct30() throws BiffException, IOException {

		System.out.println("Fetching the URL");
		driver.get(url);

		try {
			test = extent.startTest("search and update Product 30");
			// To access to Workbook
			String FilePath = "D:\\BSI_FW\\BSI\\BSI.Automation.Regression\\TestData\\List_of_products_users-TCS.xls";
			FileInputStream fs = new FileInputStream(FilePath);
			Workbook wb = Workbook.getWorkbook(fs);

			// To get the sheet access by sheet name
			Sheet sh = wb.getSheet("Products");

			// To get the number of rows present in sheet
			int totalNoOfRows = sh.getRows();
			System.out.println("The total no. of rows are: " + totalNoOfRows);

			// To get the number of columns present in sheet
			int totalNoOfCols = sh.getColumns();
			System.out.println("The total no. of columns are: " + totalNoOfCols);

			// To get the content in particular location, which will return
			// contents as a string
			String CellGetContent = sh.getCell(0, 30).getContents();
			System.out.println("The content of the cell is: " + CellGetContent);

			Log.info("Enter product name in Search textbox");
			System.out.println("Enter product name in Search textbox");
			driver.findElement(By.id("search-box")).clear();
			driver.findElement(By.id("search-box")).sendKeys(CellGetContent);

			Log.info("Click on Search");
			System.out.println("Click on Search");
			driver.findElement(By.id("search-button")).click();

			Log.info("Select the Product");
			System.out.println("Select the Product");
			WebElement product = driver.findElement(By.linkText(CellGetContent));
			product.click();
			Thread.sleep(5000);

			Log.info("Select the Format");
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
			} else {
				System.out.println("The product cannot be added to basket as the status is: " + stat);
			}

			/*
			 * Thread.sleep(2000); Log.info("Click on CheckOut");
			 * System.out.println("Click on CheckOut"); basket.clickCheckout();
			 */
		} catch (Exception e) {
			e.printStackTrace();
			Assert.fail(e.getMessage());
		}
	}

	@Test(priority = 31, enabled = true)
	public void searchProduct31() throws BiffException, IOException {

		System.out.println("Fetching the URL");
		driver.get(url);

		try {
			test = extent.startTest("search and update Product 31");
			// To access to Workbook
			String FilePath = "D:\\BSI_FW\\BSI\\BSI.Automation.Regression\\TestData\\List_of_products_users-TCS.xls";
			FileInputStream fs = new FileInputStream(FilePath);
			Workbook wb = Workbook.getWorkbook(fs);

			// To get the sheet access by sheet name
			Sheet sh = wb.getSheet("Products");

			// To get the number of rows present in sheet
			int totalNoOfRows = sh.getRows();
			System.out.println("The total no. of rows are: " + totalNoOfRows);

			// To get the number of columns present in sheet
			int totalNoOfCols = sh.getColumns();
			System.out.println("The total no. of columns are: " + totalNoOfCols);

			// To get the content in particular location, which will return
			// contents as a string
			String CellGetContent = sh.getCell(0, 31).getContents();
			System.out.println("The content of the cell is: " + CellGetContent);

			Log.info("Enter product name in Search textbox");
			System.out.println("Enter product name in Search textbox");
			driver.findElement(By.id("search-box")).clear();
			driver.findElement(By.id("search-box")).sendKeys(CellGetContent);

			Log.info("Click on Search");
			System.out.println("Click on Search");
			driver.findElement(By.id("search-button")).click();

			Log.info("Select the Product");
			System.out.println("Select the Product");
			WebElement product = driver.findElement(By.linkText(CellGetContent));
			product.click();
			Thread.sleep(5000);

			Log.info("Select the Format");
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
			} else {
				System.out.println("The product cannot be added to basket as the status is: " + stat);
			}

			/*
			 * Thread.sleep(2000); Log.info("Click on CheckOut");
			 * System.out.println("Click on CheckOut"); basket.clickCheckout();
			 */

		} catch (Exception e) {
			e.printStackTrace();
			Assert.fail(e.getMessage());
		}
	}

	@Test(priority = 32, enabled = true)
	public void searchProduct32() throws BiffException, IOException {

		System.out.println("Fetching the URL");
		driver.get(url);

		try {
			test = extent.startTest("search and update Product 32");
			// To access to Workbook
			String FilePath = "D:\\BSI_FW\\BSI\\BSI.Automation.Regression\\TestData\\List_of_products_users-TCS.xls";
			FileInputStream fs = new FileInputStream(FilePath);
			Workbook wb = Workbook.getWorkbook(fs);

			// To get the sheet access by sheet name
			Sheet sh = wb.getSheet("Products");

			// To get the number of rows present in sheet
			int totalNoOfRows = sh.getRows();
			System.out.println("The total no. of rows are: " + totalNoOfRows);

			// To get the number of columns present in sheet
			int totalNoOfCols = sh.getColumns();
			System.out.println("The total no. of columns are: " + totalNoOfCols);

			// To get the content in particular location, which will return
			// contents as a string
			String CellGetContent = sh.getCell(0, 32).getContents();
			System.out.println("The content of the cell is: " + CellGetContent);

			Log.info("Enter product name in Search textbox");
			System.out.println("Enter product name in Search textbox");
			driver.findElement(By.id("search-box")).clear();
			driver.findElement(By.id("search-box")).sendKeys(CellGetContent);

			Log.info("Click on Search");
			System.out.println("Click on Search");
			driver.findElement(By.id("search-button")).click();

			Log.info("Select the Product");
			System.out.println("Select the Product");
			WebElement product = driver.findElement(By.linkText(CellGetContent));
			product.click();
			Thread.sleep(5000);

			Log.info("Select the Format");
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
			} else {
				System.out.println("The product cannot be added to basket as the status is: " + stat);
			}

			/*
			 * Thread.sleep(2000); Log.info("Click on CheckOut");
			 * System.out.println("Click on CheckOut"); basket.clickCheckout();
			 */

		} catch (Exception e) {
			e.printStackTrace();
			Assert.fail(e.getMessage());
		}
	}

	@Test(priority = 33, enabled = true)
	public void searchProduct33() throws BiffException, IOException {

		System.out.println("Fetching the URL");
		driver.get(url);

		try {
			test = extent.startTest("search and update Product 33");
			// To access to Workbook
			String FilePath = "D:\\BSI_FW\\BSI\\BSI.Automation.Regression\\TestData\\List_of_products_users-TCS.xls";
			FileInputStream fs = new FileInputStream(FilePath);
			Workbook wb = Workbook.getWorkbook(fs);

			// To get the sheet access by sheet name
			Sheet sh = wb.getSheet("Products");

			// To get the number of rows present in sheet
			int totalNoOfRows = sh.getRows();
			System.out.println("The total no. of rows are: " + totalNoOfRows);

			// To get the number of columns present in sheet
			int totalNoOfCols = sh.getColumns();
			System.out.println("The total no. of columns are: " + totalNoOfCols);

			// To get the content in particular location, which will return
			// contents as a string
			String CellGetContent = sh.getCell(0, 33).getContents();
			System.out.println("The content of the cell is: " + CellGetContent);

			Log.info("Enter product name in Search textbox");
			System.out.println("Enter product name in Search textbox");
			driver.findElement(By.id("search-box")).clear();
			driver.findElement(By.id("search-box")).sendKeys(CellGetContent);

			Log.info("Click on Search");
			System.out.println("Click on Search");
			driver.findElement(By.id("search-button")).click();

			Log.info("Select the Product");
			System.out.println("Select the Product");
			WebElement product = driver.findElement(By.linkText(CellGetContent));
			product.click();
			Thread.sleep(5000);

			Log.info("Select the Format");
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
			} else {
				System.out.println("The product cannot be added to basket as the status is: " + stat);
			}

			/*
			 * Thread.sleep(2000); Log.info("Click on CheckOut");
			 * System.out.println("Click on CheckOut"); basket.clickCheckout();
			 */

		} catch (Exception e) {
			e.printStackTrace();
			Assert.fail(e.getMessage());
		}
	}

	@Test(priority = 34, enabled = true)
	public void searchProduct34() throws BiffException, IOException {

		System.out.println("Fetching the URL");
		driver.get(url);

		try {
			test = extent.startTest("search and update Product 34");
			// To access to Workbook
			String FilePath = "D:\\BSI_FW\\BSI\\BSI.Automation.Regression\\TestData\\List_of_products_users-TCS.xls";
			FileInputStream fs = new FileInputStream(FilePath);
			Workbook wb = Workbook.getWorkbook(fs);

			// To get the sheet access by sheet name
			Sheet sh = wb.getSheet("Products");

			// To get the number of rows present in sheet
			int totalNoOfRows = sh.getRows();
			System.out.println("The total no. of rows are: " + totalNoOfRows);

			// To get the number of columns present in sheet
			int totalNoOfCols = sh.getColumns();
			System.out.println("The total no. of columns are: " + totalNoOfCols);

			// To get the content in particular location, which will return
			// contents as a string
			String CellGetContent = sh.getCell(0, 34).getContents();
			System.out.println("The content of the cell is: " + CellGetContent);

			Log.info("Enter product name in Search textbox");
			System.out.println("Enter product name in Search textbox");
			driver.findElement(By.id("search-box")).clear();
			driver.findElement(By.id("search-box")).sendKeys(CellGetContent);

			Log.info("Click on Search");
			System.out.println("Click on Search");
			driver.findElement(By.id("search-button")).click();

			Log.info("Select the Product");
			System.out.println("Select the Product");
			WebElement product = driver.findElement(By.linkText(CellGetContent));
			product.click();
			Thread.sleep(5000);

			Log.info("Select the Format");
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
			} else {
				System.out.println("The product cannot be added to basket as the status is: " + stat);
			}

			/*
			 * Thread.sleep(2000); Log.info("Click on CheckOut");
			 * System.out.println("Click on CheckOut"); basket.clickCheckout();
			 */
		} catch (Exception e) {
			e.printStackTrace();
			Assert.fail(e.getMessage());
		}
	}

	@Test(priority = 35, enabled = true)
	public void searchProduct35() throws BiffException, IOException {

		System.out.println("Fetching the URL");
		driver.get(url);

		try {
			test = extent.startTest("search and update Product 35");
			// To access to Workbook
			String FilePath = "D:\\BSI_FW\\BSI\\BSI.Automation.Regression\\TestData\\List_of_products_users-TCS.xls";
			FileInputStream fs = new FileInputStream(FilePath);
			Workbook wb = Workbook.getWorkbook(fs);

			// To get the sheet access by sheet name
			Sheet sh = wb.getSheet("Products");

			// To get the number of rows present in sheet
			int totalNoOfRows = sh.getRows();
			System.out.println("The total no. of rows are: " + totalNoOfRows);

			// To get the number of columns present in sheet
			int totalNoOfCols = sh.getColumns();
			System.out.println("The total no. of columns are: " + totalNoOfCols);

			// To get the content in particular location, which will return
			// contents as a string
			String CellGetContent = sh.getCell(0, 35).getContents();
			System.out.println("The content of the cell is: " + CellGetContent);

			Log.info("Enter product name in Search textbox");
			System.out.println("Enter product name in Search textbox");
			driver.findElement(By.id("search-box")).clear();
			driver.findElement(By.id("search-box")).sendKeys(CellGetContent);

			Log.info("Click on Search");
			System.out.println("Click on Search");
			driver.findElement(By.id("search-button")).click();

			Log.info("Select the Product");
			System.out.println("Select the Product");
			WebElement product = driver.findElement(By.linkText(CellGetContent));
			product.click();
			Thread.sleep(5000);

			Log.info("Select the Format");
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
			} else {
				System.out.println("The product cannot be added to basket as the status is: " + stat);
			}

			/*
			 * Thread.sleep(2000); Log.info("Click on CheckOut");
			 * System.out.println("Click on CheckOut"); basket.clickCheckout();
			 */
		} catch (Exception e) {
			e.printStackTrace();
			Assert.fail(e.getMessage());
		}
	}

	@Test(priority = 36, enabled = true)
	public void searchProduct36() throws BiffException, IOException {

		System.out.println("Fetching the URL");
		driver.get(url);

		try {
			test = extent.startTest("search and update Product 36");
			// To access to Workbook
			String FilePath = "D:\\BSI_FW\\BSI\\BSI.Automation.Regression\\TestData\\List_of_products_users-TCS.xls";
			FileInputStream fs = new FileInputStream(FilePath);
			Workbook wb = Workbook.getWorkbook(fs);

			// To get the sheet access by sheet name
			Sheet sh = wb.getSheet("Products");

			// To get the number of rows present in sheet
			int totalNoOfRows = sh.getRows();
			System.out.println("The total no. of rows are: " + totalNoOfRows);

			// To get the number of columns present in sheet
			int totalNoOfCols = sh.getColumns();
			System.out.println("The total no. of columns are: " + totalNoOfCols);

			// To get the content in particular location, which will return
			// contents as a string
			String CellGetContent = sh.getCell(0, 36).getContents();
			System.out.println("The content of the cell is: " + CellGetContent);

			Log.info("Enter product name in Search textbox");
			System.out.println("Enter product name in Search textbox");
			driver.findElement(By.id("search-box")).clear();
			driver.findElement(By.id("search-box")).sendKeys(CellGetContent);

			Log.info("Click on Search");
			System.out.println("Click on Search");
			driver.findElement(By.id("search-button")).click();

			Log.info("Select the Product");
			System.out.println("Select the Product");
			WebElement product = driver.findElement(By.linkText(CellGetContent));
			product.click();
			Thread.sleep(5000);

			Log.info("Select the Format");
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
			} else {
				System.out.println("The product cannot be added to basket as the status is: " + stat);
			}
			/*
			 * Thread.sleep(2000); Log.info("Click on CheckOut");
			 * System.out.println("Click on CheckOut"); basket.clickCheckout();
			 */

		} catch (Exception e) {
			e.printStackTrace();
			Assert.fail(e.getMessage());
		}
	}

	@Test(priority = 37, enabled = true)
	public void searchProduct37() throws BiffException, IOException {

		System.out.println("Fetching the URL");
		driver.get(url);

		try {
			test = extent.startTest("search and update Product 37");
			// To access to Workbook
			String FilePath = "D:\\BSI_FW\\BSI\\BSI.Automation.Regression\\TestData\\List_of_products_users-TCS.xls";
			FileInputStream fs = new FileInputStream(FilePath);
			Workbook wb = Workbook.getWorkbook(fs);

			// To get the sheet access by sheet name
			Sheet sh = wb.getSheet("Products");

			// To get the number of rows present in sheet
			int totalNoOfRows = sh.getRows();
			System.out.println("The total no. of rows are: " + totalNoOfRows);

			// To get the number of columns present in sheet
			int totalNoOfCols = sh.getColumns();
			System.out.println("The total no. of columns are: " + totalNoOfCols);

			// To get the content in particular location, which will return
			// contents as a string
			String CellGetContent = sh.getCell(0, 37).getContents();
			System.out.println("The content of the cell is: " + CellGetContent);

			Log.info("Enter product name in Search textbox");
			System.out.println("Enter product name in Search textbox");
			driver.findElement(By.id("search-box")).clear();
			driver.findElement(By.id("search-box")).sendKeys(CellGetContent);

			Log.info("Click on Search");
			System.out.println("Click on Search");
			driver.findElement(By.id("search-button")).click();

			Log.info("Select the Product");
			System.out.println("Select the Product");
			WebElement product = driver.findElement(By.linkText(CellGetContent));
			product.click();
			Thread.sleep(5000);

			Log.info("Select the Format");
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
			} else {
				System.out.println("The product cannot be added to basket as the status is: " + stat);
			}

			/*
			 * Thread.sleep(2000); Log.info("Click on CheckOut");
			 * System.out.println("Click on CheckOut"); basket.clickCheckout();
			 */

		} catch (Exception e) {
			e.printStackTrace();
			Assert.fail(e.getMessage());
		}
	}

	@Test(priority = 38, enabled = true)
	public void searchProduct38() throws BiffException, IOException {

		System.out.println("Fetching the URL");
		driver.get(url);

		try {
			test = extent.startTest("search and update Product 38");
			// To access to Workbook
			String FilePath = "D:\\BSI_FW\\BSI\\BSI.Automation.Regression\\TestData\\List_of_products_users-TCS.xls";
			FileInputStream fs = new FileInputStream(FilePath);
			Workbook wb = Workbook.getWorkbook(fs);

			// To get the sheet access by sheet name
			Sheet sh = wb.getSheet("Products");

			// To get the number of rows present in sheet
			int totalNoOfRows = sh.getRows();
			System.out.println("The total no. of rows are: " + totalNoOfRows);

			// To get the number of columns present in sheet
			int totalNoOfCols = sh.getColumns();
			System.out.println("The total no. of columns are: " + totalNoOfCols);

			// To get the content in particular location, which will return
			// contents as a string
			String CellGetContent = sh.getCell(0, 38).getContents();
			System.out.println("The content of the cell is: " + CellGetContent);

			Log.info("Enter product name in Search textbox");
			System.out.println("Enter product name in Search textbox");
			driver.findElement(By.id("search-box")).clear();
			driver.findElement(By.id("search-box")).sendKeys(CellGetContent);

			Log.info("Click on Search");
			System.out.println("Click on Search");
			driver.findElement(By.id("search-button")).click();

			Log.info("Select the Product");
			System.out.println("Select the Product");
			WebElement product = driver.findElement(By.linkText(CellGetContent));
			product.click();
			Thread.sleep(5000);

			Log.info("Select the Format");
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
			} else {
				System.out.println("The product cannot be added to basket as the status is: " + stat);
			}

			/*
			 * Thread.sleep(2000); Log.info("Click on CheckOut");
			 * System.out.println("Click on CheckOut"); basket.clickCheckout();
			 */

		} catch (Exception e) {
			e.printStackTrace();
			Assert.fail(e.getMessage());
		}
	}

	@Test(priority = 39, enabled = true)
	public void searchProduct39() throws BiffException, IOException {

		System.out.println("Fetching the URL");
		driver.get(url);

		try {
			test = extent.startTest("search and update Product 39");
			// To access to Workbook
			String FilePath = "D:\\BSI_FW\\BSI\\BSI.Automation.Regression\\TestData\\List_of_products_users-TCS.xls";
			FileInputStream fs = new FileInputStream(FilePath);
			Workbook wb = Workbook.getWorkbook(fs);

			// To get the sheet access by sheet name
			Sheet sh = wb.getSheet("Products");

			// To get the number of rows present in sheet
			int totalNoOfRows = sh.getRows();
			System.out.println("The total no. of rows are: " + totalNoOfRows);

			// To get the number of columns present in sheet
			int totalNoOfCols = sh.getColumns();
			System.out.println("The total no. of columns are: " + totalNoOfCols);

			// To get the content in particular location, which will return
			// contents as a string
			String CellGetContent = sh.getCell(0, 39).getContents();
			System.out.println("The content of the cell is: " + CellGetContent);

			Log.info("Enter product name in Search textbox");
			System.out.println("Enter product name in Search textbox");
			driver.findElement(By.id("search-box")).clear();
			driver.findElement(By.id("search-box")).sendKeys(CellGetContent);

			Log.info("Click on Search");
			System.out.println("Click on Search");
			driver.findElement(By.id("search-button")).click();

			Log.info("Select the Product");
			System.out.println("Select the Product");
			WebElement product = driver.findElement(By.linkText(CellGetContent));
			product.click();
			Thread.sleep(5000);

			Log.info("Select the Format");
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
			} else {
				System.out.println("The product cannot be added to basket as the status is: " + stat);
			}

			/*
			 * Thread.sleep(2000); Log.info("Click on CheckOut");
			 * System.out.println("Click on CheckOut"); basket.clickCheckout();
			 */
		} catch (Exception e) {
			e.printStackTrace();
			Assert.fail(e.getMessage());
		}
	}

	@Test(priority = 40, enabled = true)
	public void searchProduct40() throws BiffException, IOException {

		System.out.println("Fetching the URL");
		driver.get(url);

		try {
			test = extent.startTest("search and update Product 40");
			// To access to Workbook
			String FilePath = "D:\\BSI_FW\\BSI\\BSI.Automation.Regression\\TestData\\List_of_products_users-TCS.xls";
			FileInputStream fs = new FileInputStream(FilePath);
			Workbook wb = Workbook.getWorkbook(fs);

			// To get the sheet access by sheet name
			Sheet sh = wb.getSheet("Products");

			// To get the number of rows present in sheet
			int totalNoOfRows = sh.getRows();
			System.out.println("The total no. of rows are: " + totalNoOfRows);

			// To get the number of columns present in sheet
			int totalNoOfCols = sh.getColumns();
			System.out.println("The total no. of columns are: " + totalNoOfCols);

			// To get the content in particular location, which will return
			// contents as a string
			String CellGetContent = sh.getCell(0, 40).getContents();
			System.out.println("The content of the cell is: " + CellGetContent);

			Log.info("Enter product name in Search textbox");
			System.out.println("Enter product name in Search textbox");
			driver.findElement(By.id("search-box")).clear();
			driver.findElement(By.id("search-box")).sendKeys(CellGetContent);

			Log.info("Click on Search");
			System.out.println("Click on Search");
			driver.findElement(By.id("search-button")).click();

			Log.info("Select the Product");
			System.out.println("Select the Product");
			WebElement product = driver.findElement(By.linkText(CellGetContent));
			product.click();
			Thread.sleep(5000);

			Log.info("Select the Format");
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
			} else {
				System.out.println("The product cannot be added to basket as the status is: " + stat);
			}
			/*
			 * Thread.sleep(2000); Log.info("Click on CheckOut");
			 * System.out.println("Click on CheckOut"); basket.clickCheckout();
			 */
		} catch (Exception e) {
			e.printStackTrace();
			Assert.fail(e.getMessage());
		}
	}

	@Test(priority = 41, enabled = true)
	public void searchProduct41() throws BiffException, IOException {

		System.out.println("Fetching the URL");
		driver.get(url);

		try {
			test = extent.startTest("search and update Product 41");
			// To access to Workbook
			String FilePath = "D:\\BSI_FW\\BSI\\BSI.Automation.Regression\\TestData\\List_of_products_users-TCS.xls";
			FileInputStream fs = new FileInputStream(FilePath);
			Workbook wb = Workbook.getWorkbook(fs);

			// To get the sheet access by sheet name
			Sheet sh = wb.getSheet("Products");

			// To get the number of rows present in sheet
			int totalNoOfRows = sh.getRows();
			System.out.println("The total no. of rows are: " + totalNoOfRows);

			// To get the number of columns present in sheet
			int totalNoOfCols = sh.getColumns();
			System.out.println("The total no. of columns are: " + totalNoOfCols);

			// To get the content in particular location, which will return
			// contents as a string
			String CellGetContent = sh.getCell(0, 41).getContents();
			System.out.println("The content of the cell is: " + CellGetContent);

			Log.info("Enter product name in Search textbox");
			System.out.println("Enter product name in Search textbox");
			driver.findElement(By.id("search-box")).clear();
			driver.findElement(By.id("search-box")).sendKeys(CellGetContent);

			Log.info("Click on Search");
			System.out.println("Click on Search");
			driver.findElement(By.id("search-button")).click();

			Log.info("Select the Product");
			System.out.println("Select the Product");
			WebElement product = driver.findElement(By.linkText(CellGetContent));
			product.click();
			Thread.sleep(5000);

			Log.info("Select the Format");
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
			} else {
				System.out.println("The product cannot be added to basket as the status is: " + stat);
			}
			/*
			 * Thread.sleep(2000); Log.info("Click on CheckOut");
			 * System.out.println("Click on CheckOut"); basket.clickCheckout();
			 */

		} catch (Exception e) {
			e.printStackTrace();
			Assert.fail(e.getMessage());
		}
	}

	@Test(priority = 42, enabled = true)
	public void searchProduct42() throws BiffException, IOException {

		System.out.println("Fetching the URL");
		driver.get(url);

		try {
			test = extent.startTest("search and update Product 42");
			// To access to Workbook
			String FilePath = "D:\\BSI_FW\\BSI\\BSI.Automation.Regression\\TestData\\List_of_products_users-TCS.xls";
			FileInputStream fs = new FileInputStream(FilePath);
			Workbook wb = Workbook.getWorkbook(fs);

			// To get the sheet access by sheet name
			Sheet sh = wb.getSheet("Products");

			// To get the number of rows present in sheet
			int totalNoOfRows = sh.getRows();
			System.out.println("The total no. of rows are: " + totalNoOfRows);

			// To get the number of columns present in sheet
			int totalNoOfCols = sh.getColumns();
			System.out.println("The total no. of columns are: " + totalNoOfCols);

			// To get the content in particular location, which will return
			// contents as a string
			String CellGetContent = sh.getCell(0, 42).getContents();
			System.out.println("The content of the cell is: " + CellGetContent);

			Log.info("Enter product name in Search textbox");
			System.out.println("Enter product name in Search textbox");
			driver.findElement(By.id("search-box")).clear();
			driver.findElement(By.id("search-box")).sendKeys(CellGetContent);

			Log.info("Click on Search");
			System.out.println("Click on Search");
			driver.findElement(By.id("search-button")).click();

			Log.info("Select the Product");
			System.out.println("Select the Product");
			WebElement product = driver.findElement(By.linkText(CellGetContent));
			product.click();
			Thread.sleep(5000);

			Log.info("Select the Format");
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
			} else {
				System.out.println("The product cannot be added to basket as the status is: " + stat);
			}

			/*
			 * Thread.sleep(2000); Log.info("Click on CheckOut");
			 * System.out.println("Click on CheckOut"); basket.clickCheckout();
			 */

		} catch (Exception e) {
			e.printStackTrace();
			Assert.fail(e.getMessage());
		}
	}

	@Test(priority = 43, enabled = true)
	public void searchProduct43() throws BiffException, IOException {

		System.out.println("Fetching the URL");
		driver.get(url);

		try {
			test = extent.startTest("search and update Product 43");
			// To access to Workbook
			String FilePath = "D:\\BSI_FW\\BSI\\BSI.Automation.Regression\\TestData\\List_of_products_users-TCS.xls";
			FileInputStream fs = new FileInputStream(FilePath);
			Workbook wb = Workbook.getWorkbook(fs);

			// To get the sheet access by sheet name
			Sheet sh = wb.getSheet("Products");

			// To get the number of rows present in sheet
			int totalNoOfRows = sh.getRows();
			System.out.println("The total no. of rows are: " + totalNoOfRows);

			// To get the number of columns present in sheet
			int totalNoOfCols = sh.getColumns();
			System.out.println("The total no. of columns are: " + totalNoOfCols);

			// To get the content in particular location, which will return
			// contents as a string
			String CellGetContent = sh.getCell(0, 43).getContents();
			System.out.println("The content of the cell is: " + CellGetContent);

			Log.info("Enter product name in Search textbox");
			System.out.println("Enter product name in Search textbox");
			driver.findElement(By.id("search-box")).clear();
			driver.findElement(By.id("search-box")).sendKeys(CellGetContent);

			Log.info("Click on Search");
			System.out.println("Click on Search");
			driver.findElement(By.id("search-button")).click();

			Log.info("Select the Product");
			System.out.println("Select the Product");
			WebElement product = driver.findElement(By.linkText(CellGetContent));
			product.click();
			Thread.sleep(5000);

			Log.info("Select the Format");
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
			} else {
				System.out.println("The product cannot be added to basket as the status is: " + stat);
			}

			/*
			 * Thread.sleep(2000); Log.info("Click on CheckOut");
			 * System.out.println("Click on CheckOut"); basket.clickCheckout();
			 */
		} catch (Exception e) {
			e.printStackTrace();
			Assert.fail(e.getMessage());
		}
	}

	@Test(priority = 44, enabled = true)
	public void searchProduct44() throws BiffException, IOException {

		System.out.println("Fetching the URL");
		driver.get(url);

		try {
			test = extent.startTest("search and update Product 44");
			// To access to Workbook
			String FilePath = "D:\\BSI_FW\\BSI\\BSI.Automation.Regression\\TestData\\List_of_products_users-TCS.xls";
			FileInputStream fs = new FileInputStream(FilePath);
			Workbook wb = Workbook.getWorkbook(fs);

			// To get the sheet access by sheet name
			Sheet sh = wb.getSheet("Products");

			// To get the number of rows present in sheet
			int totalNoOfRows = sh.getRows();
			System.out.println("The total no. of rows are: " + totalNoOfRows);

			// To get the number of columns present in sheet
			int totalNoOfCols = sh.getColumns();
			System.out.println("The total no. of columns are: " + totalNoOfCols);

			// To get the content in particular location, which will return
			// contents as a string
			String CellGetContent = sh.getCell(0, 44).getContents();
			System.out.println("The content of the cell is: " + CellGetContent);

			Log.info("Enter product name in Search textbox");
			System.out.println("Enter product name in Search textbox");
			driver.findElement(By.id("search-box")).clear();
			driver.findElement(By.id("search-box")).sendKeys(CellGetContent);

			Log.info("Click on Search");
			System.out.println("Click on Search");
			driver.findElement(By.id("search-button")).click();

			Log.info("Select the Product");
			System.out.println("Select the Product");
			WebElement product = driver.findElement(By.linkText(CellGetContent));
			product.click();
			Thread.sleep(5000);

			Log.info("Select the Format");
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
			} else {
				System.out.println("The product cannot be added to basket as the status is: " + stat);
			}

			/*
			 * Thread.sleep(2000); Log.info("Click on CheckOut");
			 * System.out.println("Click on CheckOut"); basket.clickCheckout();
			 */

		} catch (Exception e) {
			e.printStackTrace();
			Assert.fail(e.getMessage());
		}
	}

	@Test(priority = 45, enabled = true)
	public void searchProduct45() throws BiffException, IOException {

		System.out.println("Fetching the URL");
		driver.get(url);

		try {
			test = extent.startTest("search and update Product 45");
			// To access to Workbook
			String FilePath = "D:\\BSI_FW\\BSI\\BSI.Automation.Regression\\TestData\\List_of_products_users-TCS.xls";
			FileInputStream fs = new FileInputStream(FilePath);
			Workbook wb = Workbook.getWorkbook(fs);

			// To get the sheet access by sheet name
			Sheet sh = wb.getSheet("Products");

			// To get the number of rows present in sheet
			int totalNoOfRows = sh.getRows();
			System.out.println("The total no. of rows are: " + totalNoOfRows);

			// To get the number of columns present in sheet
			int totalNoOfCols = sh.getColumns();
			System.out.println("The total no. of columns are: " + totalNoOfCols);

			// To get the content in particular location, which will return
			// contents as a string
			String CellGetContent = sh.getCell(0, 45).getContents();
			System.out.println("The content of the cell is: " + CellGetContent);

			Log.info("Enter product name in Search textbox");
			System.out.println("Enter product name in Search textbox");
			driver.findElement(By.id("search-box")).clear();
			driver.findElement(By.id("search-box")).sendKeys(CellGetContent);

			Log.info("Click on Search");
			System.out.println("Click on Search");
			driver.findElement(By.id("search-button")).click();

			Log.info("Select the Product");
			System.out.println("Select the Product");
			WebElement product = driver.findElement(By.linkText(CellGetContent));
			product.click();
			Thread.sleep(5000);

			Log.info("Select the Format");
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
			} else {
				System.out.println("The product cannot be added to basket as the status is: " + stat);
			}

			/*
			 * Thread.sleep(2000); Log.info("Click on CheckOut");
			 * System.out.println("Click on CheckOut"); basket.clickCheckout();
			 */
		} catch (Exception e) {
			e.printStackTrace();
			Assert.fail(e.getMessage());
		}
	}

	@Test(priority = 46, enabled = true)
	public void searchProduct46() throws BiffException, IOException {

		System.out.println("Fetching the URL");
		driver.get(url);

		try {
			test = extent.startTest("search and update Product 46");
			// To access to Workbook
			String FilePath = "D:\\BSI_FW\\BSI\\BSI.Automation.Regression\\TestData\\List_of_products_users-TCS.xls";
			FileInputStream fs = new FileInputStream(FilePath);
			Workbook wb = Workbook.getWorkbook(fs);

			// To get the sheet access by sheet name
			Sheet sh = wb.getSheet("Products");

			// To get the number of rows present in sheet
			int totalNoOfRows = sh.getRows();
			System.out.println("The total no. of rows are: " + totalNoOfRows);

			// To get the number of columns present in sheet
			int totalNoOfCols = sh.getColumns();
			System.out.println("The total no. of columns are: " + totalNoOfCols);

			// To get the content in particular location, which will return
			// contents as a string
			String CellGetContent = sh.getCell(0, 46).getContents();
			System.out.println("The content of the cell is: " + CellGetContent);

			Log.info("Enter product name in Search textbox");
			System.out.println("Enter product name in Search textbox");
			driver.findElement(By.id("search-box")).clear();
			driver.findElement(By.id("search-box")).sendKeys(CellGetContent);

			Log.info("Click on Search");
			System.out.println("Click on Search");
			driver.findElement(By.id("search-button")).click();

			Log.info("Select the Product");
			System.out.println("Select the Product");
			WebElement product = driver.findElement(By.linkText(CellGetContent));
			product.click();
			Thread.sleep(5000);

			Log.info("Select the Format");
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
			} else {
				System.out.println("The product cannot be added to basket as the status is: " + stat);
			}
			/*
			 * Thread.sleep(2000); Log.info("Click on CheckOut");
			 * System.out.println("Click on CheckOut"); basket.clickCheckout();
			 */

		} catch (Exception e) {
			e.printStackTrace();
			Assert.fail(e.getMessage());
		}
	}

	@Test(priority = 47, enabled = true)
	public void searchProduct47() throws BiffException, IOException {

		System.out.println("Fetching the URL");
		driver.get(url);

		try {
			test = extent.startTest("search and update Product 47");
			// To access to Workbook
			String FilePath = "D:\\BSI_FW\\BSI\\BSI.Automation.Regression\\TestData\\List_of_products_users-TCS.xls";
			FileInputStream fs = new FileInputStream(FilePath);
			Workbook wb = Workbook.getWorkbook(fs);

			// To get the sheet access by sheet name
			Sheet sh = wb.getSheet("Products");

			// To get the number of rows present in sheet
			int totalNoOfRows = sh.getRows();
			System.out.println("The total no. of rows are: " + totalNoOfRows);

			// To get the number of columns present in sheet
			int totalNoOfCols = sh.getColumns();
			System.out.println("The total no. of columns are: " + totalNoOfCols);

			// To get the content in particular location, which will return
			// contents as a string
			String CellGetContent = sh.getCell(0, 47).getContents();
			System.out.println("The content of the cell is: " + CellGetContent);

			Log.info("Enter product name in Search textbox");
			System.out.println("Enter product name in Search textbox");
			driver.findElement(By.id("search-box")).clear();
			driver.findElement(By.id("search-box")).sendKeys(CellGetContent);

			Log.info("Click on Search");
			System.out.println("Click on Search");
			driver.findElement(By.id("search-button")).click();

			Log.info("Select the Product");
			System.out.println("Select the Product");
			WebElement product = driver.findElement(By.linkText(CellGetContent));
			product.click();
			Thread.sleep(5000);

			Log.info("Select the Format");
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
			} else {
				System.out.println("The product cannot be added to basket as the status is: " + stat);
			}

			/*
			 * Thread.sleep(2000); Log.info("Click on CheckOut");
			 * System.out.println("Click on CheckOut"); basket.clickCheckout();
			 */
		} catch (Exception e) {
			e.printStackTrace();
			Assert.fail(e.getMessage());
		}
	}

	@Test(priority = 48, enabled = true)
	public void searchProduct48() throws BiffException, IOException {

		System.out.println("Fetching the URL");
		driver.get(url);

		try {
			test = extent.startTest("search and update Product 48");
			// To access to Workbook
			String FilePath = "D:\\BSI_FW\\BSI\\BSI.Automation.Regression\\TestData\\List_of_products_users-TCS.xls";
			FileInputStream fs = new FileInputStream(FilePath);
			Workbook wb = Workbook.getWorkbook(fs);

			// To get the sheet access by sheet name
			Sheet sh = wb.getSheet("Products");

			// To get the number of rows present in sheet
			int totalNoOfRows = sh.getRows();
			System.out.println("The total no. of rows are: " + totalNoOfRows);

			// To get the number of columns present in sheet
			int totalNoOfCols = sh.getColumns();
			System.out.println("The total no. of columns are: " + totalNoOfCols);

			// To get the content in particular location, which will return
			// contents as a string
			String CellGetContent = sh.getCell(0, 48).getContents();
			System.out.println("The content of the cell is: " + CellGetContent);

			Log.info("Enter product name in Search textbox");
			System.out.println("Enter product name in Search textbox");
			driver.findElement(By.id("search-box")).clear();
			driver.findElement(By.id("search-box")).sendKeys(CellGetContent);

			Log.info("Click on Search");
			System.out.println("Click on Search");
			driver.findElement(By.id("search-button")).click();

			Log.info("Select the Product");
			System.out.println("Select the Product");
			WebElement product = driver.findElement(By.linkText(CellGetContent));
			product.click();
			Thread.sleep(5000);

			Log.info("Select the Format");
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
			} else {
				System.out.println("The product cannot be added to basket as the status is: " + stat);
			}

			/*
			 * Thread.sleep(2000); Log.info("Click on CheckOut");
			 * System.out.println("Click on CheckOut"); basket.clickCheckout();
			 */
		} catch (Exception e) {
			e.printStackTrace();
			Assert.fail(e.getMessage());
		}
	}

	@Test(priority = 49, enabled = true)
	public void searchProduct49() throws BiffException, IOException {

		System.out.println("Fetching the URL");
		driver.get(url);

		try {
			test = extent.startTest("search and update Product 49");
			// To access to Workbook
			String FilePath = "D:\\BSI_FW\\BSI\\BSI.Automation.Regression\\TestData\\List_of_products_users-TCS.xls";
			FileInputStream fs = new FileInputStream(FilePath);
			Workbook wb = Workbook.getWorkbook(fs);

			// To get the sheet access by sheet name
			Sheet sh = wb.getSheet("Products");

			// To get the number of rows present in sheet
			int totalNoOfRows = sh.getRows();
			System.out.println("The total no. of rows are: " + totalNoOfRows);

			// To get the number of columns present in sheet
			int totalNoOfCols = sh.getColumns();
			System.out.println("The total no. of columns are: " + totalNoOfCols);

			// To get the content in particular location, which will return
			// contents as a string
			String CellGetContent = sh.getCell(0, 49).getContents();
			System.out.println("The content of the cell is: " + CellGetContent);

			Log.info("Enter product name in Search textbox");
			System.out.println("Enter product name in Search textbox");
			driver.findElement(By.id("search-box")).clear();
			driver.findElement(By.id("search-box")).sendKeys(CellGetContent);

			Log.info("Click on Search");
			System.out.println("Click on Search");
			driver.findElement(By.id("search-button")).click();

			Log.info("Select the Product");
			System.out.println("Select the Product");
			WebElement product = driver.findElement(By.linkText(CellGetContent));
			product.click();
			Thread.sleep(5000);

			Log.info("Select the Format");
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
			} else {
				System.out.println("The product cannot be added to basket as the status is: " + stat);
			}
			/*
			 * Thread.sleep(2000); Log.info("Click on CheckOut");
			 * System.out.println("Click on CheckOut"); basket.clickCheckout();
			 */
		} catch (Exception e) {
			e.printStackTrace();
			Assert.fail(e.getMessage());
		}
	}

	@Test(priority = 50, enabled = true)
	public void searchProduct50() throws BiffException, IOException {

		System.out.println("Fetching the URL");
		driver.get(url);

		try {
			test = extent.startTest("search and update Product 50");
			// To access to Workbook
			String FilePath = "D:\\BSI_FW\\BSI\\BSI.Automation.Regression\\TestData\\List_of_products_users-TCS.xls";
			FileInputStream fs = new FileInputStream(FilePath);
			Workbook wb = Workbook.getWorkbook(fs);

			// To get the sheet access by sheet name
			Sheet sh = wb.getSheet("Products");

			// To get the number of rows present in sheet
			int totalNoOfRows = sh.getRows();
			System.out.println("The total no. of rows are: " + totalNoOfRows);

			// To get the number of columns present in sheet
			int totalNoOfCols = sh.getColumns();
			System.out.println("The total no. of columns are: " + totalNoOfCols);

			// To get the content in particular location, which will return
			// contents as a string
			String CellGetContent = sh.getCell(0, 50).getContents();
			System.out.println("The content of the cell is: " + CellGetContent);

			Log.info("Enter product name in Search textbox");
			System.out.println("Enter product name in Search textbox");
			driver.findElement(By.id("search-box")).clear();
			driver.findElement(By.id("search-box")).sendKeys(CellGetContent);

			Log.info("Click on Search");
			System.out.println("Click on Search");
			driver.findElement(By.id("search-button")).click();

			Log.info("Select the Product");
			System.out.println("Select the Product");
			WebElement product = driver.findElement(By.linkText(CellGetContent));
			product.click();
			Thread.sleep(5000);

			Log.info("Select the Format");
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
			} else {
				System.out.println("The product cannot be added to basket as the status is: " + stat);
			}

			/*
			 * Thread.sleep(2000); Log.info("Click on CheckOut");
			 * System.out.println("Click on CheckOut"); basket.clickCheckout();
			 */

		} catch (Exception e) {
			e.printStackTrace();
			Assert.fail(e.getMessage());
		}
	}

	@Test(priority = 51, enabled = true)
	public void searchProduct51() throws BiffException, IOException {

		System.out.println("Fetching the URL");
		driver.get(url);

		try {
			test = extent.startTest("search and update Product 51");
			// To access to Workbook
			String FilePath = "D:\\BSI_FW\\BSI\\BSI.Automation.Regression\\TestData\\List_of_products_users-TCS.xls";
			FileInputStream fs = new FileInputStream(FilePath);
			Workbook wb = Workbook.getWorkbook(fs);

			// To get the sheet access by sheet name
			Sheet sh = wb.getSheet("Products");

			// To get the number of rows present in sheet
			int totalNoOfRows = sh.getRows();
			System.out.println("The total no. of rows are: " + totalNoOfRows);

			// To get the number of columns present in sheet
			int totalNoOfCols = sh.getColumns();
			System.out.println("The total no. of columns are: " + totalNoOfCols);

			// To get the content in particular location, which will return
			// contents as a string
			String CellGetContent = sh.getCell(0, 51).getContents();
			System.out.println("The content of the cell is: " + CellGetContent);

			Log.info("Enter product name in Search textbox");
			System.out.println("Enter product name in Search textbox");
			driver.findElement(By.id("search-box")).clear();
			driver.findElement(By.id("search-box")).sendKeys(CellGetContent);

			Log.info("Click on Search");
			System.out.println("Click on Search");
			driver.findElement(By.id("search-button")).click();

			Log.info("Select the Product");
			System.out.println("Select the Product");
			WebElement product = driver.findElement(By.linkText(CellGetContent));
			product.click();
			Thread.sleep(5000);

			Log.info("Select the Format");
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
			} else {
				System.out.println("The product cannot be added to basket as the status is: " + stat);
			}

			/*
			 * Thread.sleep(2000); Log.info("Click on CheckOut");
			 * System.out.println("Click on CheckOut"); basket.clickCheckout();
			 */

		} catch (Exception e) {
			e.printStackTrace();
			Assert.fail(e.getMessage());
		}
	}

	@Test(priority = 52, enabled = true)
	public void searchProduct52() throws BiffException, IOException {

		System.out.println("Fetching the URL");
		driver.get(url);

		try {
			test = extent.startTest("search and update Product 52");
			// To access to Workbook
			String FilePath = "D:\\BSI_FW\\BSI\\BSI.Automation.Regression\\TestData\\List_of_products_users-TCS.xls";
			FileInputStream fs = new FileInputStream(FilePath);
			Workbook wb = Workbook.getWorkbook(fs);

			// To get the sheet access by sheet name
			Sheet sh = wb.getSheet("Products");

			// To get the number of rows present in sheet
			int totalNoOfRows = sh.getRows();
			System.out.println("The total no. of rows are: " + totalNoOfRows);

			// To get the number of columns present in sheet
			int totalNoOfCols = sh.getColumns();
			System.out.println("The total no. of columns are: " + totalNoOfCols);

			// To get the content in particular location, which will return
			// contents as a string
			String CellGetContent = sh.getCell(0, 52).getContents();
			System.out.println("The content of the cell is: " + CellGetContent);

			Log.info("Enter product name in Search textbox");
			System.out.println("Enter product name in Search textbox");
			driver.findElement(By.id("search-box")).clear();
			driver.findElement(By.id("search-box")).sendKeys(CellGetContent);

			Log.info("Click on Search");
			System.out.println("Click on Search");
			driver.findElement(By.id("search-button")).click();

			Log.info("Select the Product");
			System.out.println("Select the Product");
			WebElement product = driver.findElement(By.linkText(CellGetContent));
			product.click();
			Thread.sleep(5000);

			Log.info("Select the Format");
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
			} else {
				System.out.println("The product cannot be added to basket as the status is: " + stat);
			}

			/*
			 * Thread.sleep(2000); Log.info("Click on CheckOut");
			 * System.out.println("Click on CheckOut"); basket.clickCheckout();
			 */

		} catch (Exception e) {
			e.printStackTrace();
			Assert.fail(e.getMessage());
		}
	}

	@Test(priority = 53, enabled = true)
	public void searchProduct53() throws BiffException, IOException {

		System.out.println("Fetching the URL");
		driver.get(url);

		try {
			test = extent.startTest("search and update Product 53");
			// To access to Workbook
			String FilePath = "D:\\BSI_FW\\BSI\\BSI.Automation.Regression\\TestData\\List_of_products_users-TCS.xls";
			FileInputStream fs = new FileInputStream(FilePath);
			Workbook wb = Workbook.getWorkbook(fs);

			// To get the sheet access by sheet name
			Sheet sh = wb.getSheet("Products");

			// To get the number of rows present in sheet
			int totalNoOfRows = sh.getRows();
			System.out.println("The total no. of rows are: " + totalNoOfRows);

			// To get the number of columns present in sheet
			int totalNoOfCols = sh.getColumns();
			System.out.println("The total no. of columns are: " + totalNoOfCols);

			// To get the content in particular location, which will return
			// contents as a string
			String CellGetContent = sh.getCell(0, 53).getContents();
			System.out.println("The content of the cell is: " + CellGetContent);

			Log.info("Enter product name in Search textbox");
			System.out.println("Enter product name in Search textbox");
			driver.findElement(By.id("search-box")).clear();
			driver.findElement(By.id("search-box")).sendKeys(CellGetContent);

			Log.info("Click on Search");
			System.out.println("Click on Search");
			driver.findElement(By.id("search-button")).click();

			Log.info("Select the Product");
			System.out.println("Select the Product");
			WebElement product = driver.findElement(By.linkText(CellGetContent));
			product.click();
			Thread.sleep(5000);

			Log.info("Select the Format");
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
			} else {
				System.out.println("The product cannot be added to basket as the status is: " + stat);
			}

			/*
			 * Thread.sleep(2000); Log.info("Click on CheckOut");
			 * System.out.println("Click on CheckOut"); basket.clickCheckout();
			 */

		} catch (Exception e) {
			e.printStackTrace();
			Assert.fail(e.getMessage());
		}
	}

	@Test(priority = 54, enabled = true)
	public void searchProduct54() throws BiffException, IOException {

		System.out.println("Fetching the URL");
		driver.get(url);

		try {
			test = extent.startTest("search and update Product 54");
			// To access to Workbook
			String FilePath = "D:\\BSI_FW\\BSI\\BSI.Automation.Regression\\TestData\\List_of_products_users-TCS.xls";
			FileInputStream fs = new FileInputStream(FilePath);
			Workbook wb = Workbook.getWorkbook(fs);

			// To get the sheet access by sheet name
			Sheet sh = wb.getSheet("Products");

			// To get the number of rows present in sheet
			int totalNoOfRows = sh.getRows();
			System.out.println("The total no. of rows are: " + totalNoOfRows);

			// To get the number of columns present in sheet
			int totalNoOfCols = sh.getColumns();
			System.out.println("The total no. of columns are: " + totalNoOfCols);

			// To get the content in particular location, which will return
			// contents as a string
			String CellGetContent = sh.getCell(0, 54).getContents();
			System.out.println("The content of the cell is: " + CellGetContent);

			Log.info("Enter product name in Search textbox");
			System.out.println("Enter product name in Search textbox");
			driver.findElement(By.id("search-box")).clear();
			driver.findElement(By.id("search-box")).sendKeys(CellGetContent);

			Log.info("Click on Search");
			System.out.println("Click on Search");
			driver.findElement(By.id("search-button")).click();

			Log.info("Select the Product");
			System.out.println("Select the Product");
			WebElement product = driver.findElement(By.linkText(CellGetContent));
			product.click();
			Thread.sleep(5000);

			Log.info("Select the Format");
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
			} else {
				System.out.println("The product cannot be added to basket as the status is: " + stat);
			}

			/*
			 * Thread.sleep(2000); Log.info("Click on CheckOut");
			 * System.out.println("Click on CheckOut"); basket.clickCheckout();
			 */
		} catch (Exception e) {
			e.printStackTrace();
			Assert.fail(e.getMessage());
		}
	}

	@Test(priority = 55, enabled = true)
	public void searchProduct55() throws BiffException, IOException {

		System.out.println("Fetching the URL");
		driver.get(url);

		try {
			test = extent.startTest("search and update Product 55");
			// To access to Workbook
			String FilePath = "D:\\BSI_FW\\BSI\\BSI.Automation.Regression\\TestData\\List_of_products_users-TCS.xls";
			FileInputStream fs = new FileInputStream(FilePath);
			Workbook wb = Workbook.getWorkbook(fs);

			// To get the sheet access by sheet name
			Sheet sh = wb.getSheet("Products");

			// To get the number of rows present in sheet
			int totalNoOfRows = sh.getRows();
			System.out.println("The total no. of rows are: " + totalNoOfRows);

			// To get the number of columns present in sheet
			int totalNoOfCols = sh.getColumns();
			System.out.println("The total no. of columns are: " + totalNoOfCols);

			// To get the content in particular location, which will return
			// contents as a string
			String CellGetContent = sh.getCell(0, 55).getContents();
			System.out.println("The content of the cell is: " + CellGetContent);

			Log.info("Enter product name in Search textbox");
			System.out.println("Enter product name in Search textbox");
			driver.findElement(By.id("search-box")).clear();
			driver.findElement(By.id("search-box")).sendKeys(CellGetContent);

			Log.info("Click on Search");
			System.out.println("Click on Search");
			driver.findElement(By.id("search-button")).click();

			Log.info("Select the Product");
			System.out.println("Select the Product");
			WebElement product = driver.findElement(By.linkText(CellGetContent));
			product.click();
			Thread.sleep(5000);

			Log.info("Select the Format");
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
			} else {
				System.out.println("The product cannot be added to basket as the status is: " + stat);
			}

			/*
			 * Thread.sleep(2000); Log.info("Click on CheckOut");
			 * System.out.println("Click on CheckOut"); basket.clickCheckout();
			 */

		} catch (Exception e) {
			e.printStackTrace();
			Assert.fail(e.getMessage());
		}
	}

	@Test(priority = 56, enabled = true)
	public void searchProduct56() throws BiffException, IOException {

		System.out.println("Fetching the URL");
		driver.get(url);

		try {
			test = extent.startTest("search and update Product 56");
			Thread.sleep(5000);
			// To access to Workbook
			String FilePath = "D:\\BSI_FW\\BSI\\BSI.Automation.Regression\\TestData\\List_of_products_users-TCS.xls";
			FileInputStream fs = new FileInputStream(FilePath);
			Workbook wb = Workbook.getWorkbook(fs);

			// To get the sheet access by sheet name
			Sheet sh = wb.getSheet("Products");

			// To get the number of rows present in sheet
			int totalNoOfRows = sh.getRows();
			System.out.println("The total no. of rows are: " + totalNoOfRows);

			// To get the number of columns present in sheet
			int totalNoOfCols = sh.getColumns();
			System.out.println("The total no. of columns are: " + totalNoOfCols);

			// To get the content in particular location, which will return
			// contents as a string
			String CellGetContent = sh.getCell(0, 56).getContents();
			System.out.println("The content of the cell is: " + CellGetContent);

			Log.info("Enter product name in Search textbox");
			System.out.println("Enter product name in Search textbox");
			driver.findElement(By.id("search-box")).clear();
			driver.findElement(By.id("search-box")).sendKeys(CellGetContent);

			Log.info("Click on Search");
			System.out.println("Click on Search");
			driver.findElement(By.id("search-button")).click();

			Log.info("Select the Product");
			System.out.println("Select the Product");
			WebElement product = driver.findElement(By.linkText(CellGetContent));
			product.click();
			Thread.sleep(5000);

			Log.info("Select the Format");
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
			} else {
				System.out.println("The product cannot be added to basket as the status is: " + stat);
			}

			/*
			 * Thread.sleep(2000); Log.info("Click on CheckOut");
			 * System.out.println("Click on CheckOut"); basket.clickCheckout();
			 */
		} catch (Exception e) {
			e.printStackTrace();
			Assert.fail(e.getMessage());
		}
	}

	@Test(priority = 57, enabled = true)
	public void searchProduct57() throws BiffException, IOException {

		System.out.println("Fetching the URL");
		driver.get(url);

		try {
			test = extent.startTest("search and update Product 57");
			// To access to Workbook
			String FilePath = "D:\\BSI_FW\\BSI\\BSI.Automation.Regression\\TestData\\List_of_products_users-TCS.xls";
			FileInputStream fs = new FileInputStream(FilePath);
			Workbook wb = Workbook.getWorkbook(fs);

			// To get the sheet access by sheet name
			Sheet sh = wb.getSheet("Products");

			// To get the number of rows present in sheet
			int totalNoOfRows = sh.getRows();
			System.out.println("The total no. of rows are: " + totalNoOfRows);

			// To get the number of columns present in sheet
			int totalNoOfCols = sh.getColumns();
			System.out.println("The total no. of columns are: " + totalNoOfCols);

			// To get the content in particular location, which will return
			// contents as a string
			String CellGetContent = sh.getCell(0, 57).getContents();
			System.out.println("The content of the cell is: " + CellGetContent);

			Log.info("Enter product name in Search textbox");
			System.out.println("Enter product name in Search textbox");
			driver.findElement(By.id("search-box")).clear();
			driver.findElement(By.id("search-box")).sendKeys(CellGetContent);

			Log.info("Click on Search");
			System.out.println("Click on Search");
			driver.findElement(By.id("search-button")).click();

			Log.info("Select the Product");
			System.out.println("Select the Product");
			WebElement product = driver.findElement(By.linkText(CellGetContent));
			product.click();
			Thread.sleep(5000);

			Log.info("Select the Format");
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
			} else {
				System.out.println("The product cannot be added to basket as the status is: " + stat);
			}

			/*
			 * Thread.sleep(2000); Log.info("Click on CheckOut");
			 * System.out.println("Click on CheckOut"); basket.clickCheckout();
			 */
		} catch (Exception e) {
			e.printStackTrace();
			Assert.fail(e.getMessage());
		}
	}

	/*
	 * @Test(priority = 58, enabled = true) public void searchProduct58() throws
	 * BiffException, IOException {
	 * 
	 * System.out.println("Fetching the URL");
	 * driver.get("https://qa2-dh6pqni-7redg7uykvdko.eu.magentosite.cloud/");
	 * 
	 * try {
	 * 
	 * // To access to Workbook String FilePath =
	 * "D:\\BSI_FW\\BSI\\BSI.Automation.Regression\\TestData\\List_of_products_users-TCS.xls"
	 * ; FileInputStream fs = new FileInputStream(FilePath); Workbook wb =
	 * Workbook.getWorkbook(fs);
	 * 
	 * // To get the sheet access by sheet name Sheet sh = wb.getSheet("Products");
	 * 
	 * // To get the number of rows present in sheet int totalNoOfRows =
	 * sh.getRows(); System.out.println("The total no. of rows are: " +
	 * totalNoOfRows);
	 * 
	 * // To get the number of columns present in sheet int totalNoOfCols =
	 * sh.getColumns(); System.out.println("The total no. of columns are: " +
	 * totalNoOfCols);
	 * 
	 * // To get the content in particular location, which will return // contents
	 * as a string String CellGetContent = sh.getCell(0, 58).getContents();
	 * System.out.println("The content of the cell is: " + CellGetContent);
	 * 
	 * Log.info("Enter product name in Search textbox"); System.out.println(
	 * "Enter product name in Search textbox");
	 * driver.findElement(By.id("search-box")).clear();
	 * driver.findElement(By.id("search-box")).sendKeys(CellGetContent);
	 * 
	 * Log.info("Click on Search"); System.out.println("Click on Search");
	 * driver.findElement(By.id("search-button")).click();
	 * 
	 * Log.info("Select the Product"); System.out.println("Select the Product");
	 * WebElement product = driver.findElement(By.linkText(CellGetContent));
	 * product.click(); Thread.sleep(5000);
	 * 
	 * Log.info("Select the Format"); System.out.println("Select the Format");
	 * ProductPage prod = new ProductPage(driver); String stat =
	 * prod.selectFormat();
	 * 
	 * if (!stat.contains("Withdrawn")|| stat.contains("essentialsFormat")) {
	 * Log.info( "Edit the Basket with Update Quantity"); System.out.println(
	 * "Edit the Basket with Update Quantity"); BasketPage basket = new
	 * BasketPage(driver); basket.editBasketUpdateQuantity();
	 * 
	 * Log.info("Edit the Basket with Change Format"); System.out.println(
	 * "Edit the Basket with Change Format"); basket.editBasketChangeFormat();
	 * 
	 * Log.info("Remove the Product"); System.out.println("Remove the Product");
	 * basket.removeProduct(); } else { System.out.println(
	 * "The product cannot be added to basket as the status is: " + stat); }
	 * 
	 * 
	 * } catch (Exception e) { e.printStackTrace(); Assert.fail(e.getMessage()); }
	 */
}
