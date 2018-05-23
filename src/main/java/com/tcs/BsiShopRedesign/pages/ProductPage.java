package com.tcs.BsiShopRedesign.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import com.relevantcodes.extentreports.LogStatus;
import com.tcs.BsiShopRedesign.utilities.Page;
import com.tcs.BsiShopRedesign.utilities.CommonHelper;

public class ProductPage extends Page {

	public ProductPage(WebDriver driver) throws Exception {
		super(driver);
		// Page.driver = driver;
	}

	static String status;

	public String selectFormatAndAddToBasket() throws InterruptedException {

		WebDriverWait wait = new WebDriverWait(driver, 120);
		try {

			//Thread.sleep(2000);
			//boolean defaultFormat = CommonHelper.checkVisibility(By.xpath("//h4[contains(.,'Format')]"));
			Log.info("Check Visibility for Default Format product");
			System.out.println("Check Visibility for Default Format product");
			boolean defaultFormat = CommonHelper.checkVisibility(By.cssSelector("h3[class='simple-prod-head']"));
			
			Log.info("Check Visibility for Existing Format product");
			System.out.println("Check Visibility for Existing Format product");
			boolean existingFormat = CommonHelper.checkVisibility(By.xpath("//*[@id='r']"));
			//boolean existingFormat = CommonHelper.checkVisibility(By.xpath("//h4[text()='Select format:']//following-sibling::div[@id='r']//label[contains(.,'PDF')]"));
			
			/*Log.info("Check Visibility for Withdrawn product");
			System.out.println("Check Visibility for Withdrawn product");
			boolean withdrawnText = CommonHelper
					.checkVisibility(By.xpath("//*[@id='prod-main-new']/div[1]/div[2]/p[1]"));*/
			//boolean essentialsFormat = CommonHelper.checkVisibility(By.xpath("//h4[text()='Select number of license:']//following-sibling::div[@id='r']//label[contains(.,'1 License')]"));

			if (defaultFormat) {
				Log.info("Click on Add to Basket for Default Format product");
				System.out.println("Click on Add to Basket for Default Format product");
				test.log(LogStatus.INFO, "Click on Add to Basket for Default Format product");
				wait.until(
						ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='product-addtocart-button']/span")))
						.click();
				status = wait.until(ExpectedConditions.elementToBeClickable(
						By.xpath("//*[@id='product-attribute-specs-table']/div[8]/div[1]/span[2]"))).getText();
				System.out.println("The status of the product is: " + status);
				test.log(LogStatus.INFO, "The status of the product is: " + status);
				Thread.sleep(3000);

				viewBasket();

			} else if (existingFormat /*&& !withdrawnText*/) {
				Thread.sleep(3000);
				System.out.println("Select Hardcopy format");
				test.log(LogStatus.INFO, "Select Hardcopy format");
				Log.info("Select Hardcopy format");
				driver.findElement(By.xpath("//*[@id='r']/label[3]/span")).click();

				Thread.sleep(3000);
				Log.info("Click on Add to Basket");
				System.out.println("Click on Add to Basket");
				test.log(LogStatus.INFO, "Click on Add to Basket");
				// driver.findElement(By.xpath("//*[@id='product-addtocart-button']/span")).click();
				wait.until(
						ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='product-addtocart-button']/span")))
						.click();

				status = wait.until(ExpectedConditions.elementToBeClickable(
						By.xpath("//*[@id='product-attribute-specs-table']/div[8]/div[1]/span[2]"))).getText();
				System.out.println("The status of the product is: " + status);
				test.log(LogStatus.INFO, "The status of the product is: " + status);

				viewBasket();

			} /*else if (essentialsFormat) {

				// Thread.sleep(3000);
				System.out.println("Select Essentials format ");
				test.log(LogStatus.INFO, "Select Essentials format ");
				Log.info("Select Format Essentials format");
				driver.findElement(By.xpath("//*[@id='r']/label[2]/span")).click();

				Thread.sleep(3000);
				Log.info("Click on Add to Basket");
				System.out.println("Click on Add to Basket");
				test.log(LogStatus.INFO, "Click on Add to Basket");
				// driver.findElement(By.xpath("//*[@id='product-addtocart-button']/span")).click();
				wait.until(
						ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='product-addtocart-button']/span")))
						.click();
				status = "essentialsFormat";
				System.out.println("The status of the product is: " + status);
				test.log(LogStatus.INFO, "The status of the product is: " + status);

				viewBasket();

			}*/ else {
				Log.info("This product cannot be added to Basket");
				System.out.println("This product cannot be added to Basket");
				test.log(LogStatus.INFO, "This product cannot be added to Basket");

				status = wait.until(ExpectedConditions.elementToBeClickable(
						By.xpath("//*[@id='product-attribute-specs-table']/div[8]/div[1]/span[2]"))).getText();
				System.out.println("The Status of the product is: " + status);
				test.log(LogStatus.INFO, "The Status of the product is: " + status);
			}

		} catch (Exception e) {
			e.printStackTrace();
			CommonHelper.reportFailure("Select Format and Add to Basket was unsuccessful");
			Assert.fail(e.getMessage());
		}
		return status;

	}

	public void viewBasket() {

		try {
			Thread.sleep(12000);
			System.out.println("Click on View Basket");
			test.log(LogStatus.INFO, "Click on View Basket ");
			Log.info("Click on View Basket");
			driver.findElement(By.xpath("//*[@id='basket']/div/a")).click();
		} catch (InterruptedException e) {
			e.printStackTrace();
			CommonHelper.reportFailure("Click on View Basket was unsuccessful");
			Assert.fail(e.getMessage());
		}

	}

	public String addPDFProductToBasket() {

		WebDriverWait wait = new WebDriverWait(driver, 120);
		try {
			for (int i = 0; i <= 1; i++) {
				Thread.sleep(5000);
				Log.info("Check Visibility for Default Format product");
				System.out.println("Check Visibility for Default Format product");
				boolean defaultFormat = CommonHelper.checkVisibility(By.cssSelector("h3[class='simple-prod-head']"));
				
				Log.info("Check Visibility for Existing Format product");
				System.out.println("Check Visibility for Existing Format product");
				boolean existingFormat = CommonHelper.checkVisibility(By.xpath("//*[@id='r']"));
				//boolean defaultFormat = CommonHelper.checkVisibility(By.xpath("//h4[contains(.,'Format')]"));
				//boolean existingFormat = CommonHelper.checkVisibility(By.xpath("//h4[text()='Select format:']//following-sibling::div[@id='r']//label[contains(.,'PDF')]"));
				//boolean withdrawnText = CommonHelper.checkVisibility(By.xpath("//*[@id='prod-main-new']/div[1]/div[2]/p[1]"));
				//boolean essentialsFormat = CommonHelper.checkVisibility(By.xpath("//h4[text()='Select number of license:']//following-sibling::div[@id='r']//label[contains(.,'1 License')]"));

				if (defaultFormat) {
					Log.info("Click on Add to Basket for Default Format product");
					System.out.println("Click on Add to Basket for Default Format product");
					test.log(LogStatus.INFO, "Click on Add to Basket for Default Format product");
					wait.until(ExpectedConditions
							.elementToBeClickable(By.xpath("//*[@id='product-addtocart-button']/span"))).click();		
					status = wait
							.until(ExpectedConditions.elementToBeClickable(
									By.xpath("//*[@id='product-attribute-specs-table']/div[8]/div[1]/span[2]")))
							.getText();
				
					System.out.println("The status of the product is: " + status);
					test.log(LogStatus.INFO, "The status of the product is: " + status);

				} else if (existingFormat /*&& !withdrawnText*/) {
					Thread.sleep(3000);
					System.out.println("Select PDF format");
					test.log(LogStatus.INFO, "Select PDF format");
					Log.info("Select PDF format");
					CommonHelper.elementToBeClickable("selectPDFformat_xpath");
					click("selectPDFformat_xpath");

					Thread.sleep(3000);
					Log.info("Click on Add to Basket");
					System.out.println("Click on Add to Basket");
					test.log(LogStatus.INFO, "Click on Add to Basket");
					// driver.findElement(By.xpath("//*[@id='product-addtocart-button']/span")).click();
					wait.until(ExpectedConditions
							.elementToBeClickable(By.xpath("//*[@id='product-addtocart-button']/span"))).click();
					
					status = wait
							.until(ExpectedConditions.elementToBeClickable(
									By.xpath("//*[@id='product-attribute-specs-table']/div[8]/div[1]/span[2]")))
							.getText();

					System.out.println("The status of the product is: " + status);
					test.log(LogStatus.INFO, "The status of the product is: " + status);

				} /*else if (essentialsFormat) {

					Thread.sleep(3000);
					System.out.println("Select Essentials format ");
					test.log(LogStatus.INFO, "Select Essentials format ");
					Log.info("Select Format Essentials format");
					driver.findElement(By.xpath("//*[@id='r']/label[2]/span")).click();

					Thread.sleep(3000);
					Log.info("Click on Add to Basket");
					System.out.println("Click on Add to Basket");
					test.log(LogStatus.INFO, "Click on Add to Basket");
					// driver.findElement(By.xpath("//*[@id='product-addtocart-button']/span")).click();
					wait.until(ExpectedConditions
							.elementToBeClickable(By.xpath("//*[@id='product-addtocart-button']/span"))).click();
					status = "essentialsFormat";
					System.out.println("The status of the product is: " + status);
					test.log(LogStatus.INFO, "The status of the product is: " + status);

				}*/ else {
					Log.info("This product cannot be added to Basket");
					System.out.println("This product cannot be added to Basket");
					test.log(LogStatus.INFO, "This product cannot be added to Basket");
	
					status = wait
							.until(ExpectedConditions.elementToBeClickable(
									By.xpath("//*[@id='product-attribute-specs-table']/div[8]/div[1]/span[2]")))
							.getText();

					System.out.println("The Status of the product is: " + status);
					test.log(LogStatus.INFO, "The Status of the product is: " + status);
				}

			}
		} catch (Exception e) {
			e.printStackTrace();
			CommonHelper.reportFailure(" Select Format and Adding the same product twice to Basket was unsuccessful");
			Assert.fail(e.getMessage());
		}
		return status;

	}

	public void checkWarningMsg() {
		try {
			Thread.sleep(2000);
			test.log(LogStatus.INFO, "Checking warning message");
			CommonHelper.elementToBeVisible("pdfAlertText_id");
			String msg = CommonHelper.element("pdfAlertText_id").getText();
			if (msg != null
					|| msg.contains("Because of copyright, you can't add this product a second time in PDF format.")) {
				test.log(LogStatus.INFO, "Warning message is: " + msg);
				CommonHelper.elementToBeClickable("pdfAlert_xpath");
				CommonHelper.element("pdfAlert_xpath");
				click("pdfAlert_xpath");
				Log.info("Check warning message on adding PDF product twice was successful ");
				System.out.println("Check warning message on adding PDF product twice was successful ");
				test.log(LogStatus.PASS, "Check warning message on adding PDF product twice was successful ");
			} else {
				Log.info("Check warning message on adding PDF product twice was unsuccessful ");
				System.out.println("Check warning message on adding PDF product twice was unsuccessful ");
				test.log(LogStatus.PASS, "Check warning message on adding PDF product twice was unsuccessful ");
			}

		} catch (Exception e) {
			e.printStackTrace();
			CommonHelper.reportFailure("Check warning message was unsuccessful");
			Assert.fail(e.getMessage());
		}
	}

	public String selectDefaultFormatAndAddToBasket() throws InterruptedException {

		WebDriverWait wait = new WebDriverWait(driver, 120);
		try {

			Thread.sleep(2000);
			Log.info("Check Visibility for Default Format product");
			System.out.println("Check Visibility for Default Format product");
			boolean defaultFormat = CommonHelper.checkVisibility(By.cssSelector("h3[class='simple-prod-head']"));
			//boolean defaultFormat = CommonHelper.checkVisibility(By.xpath("//h4[contains(.,'Format')]"));

			if (defaultFormat) {
				Log.info("Click on Add to Basket for Default Format product");
				System.out.println("Click on Add to Basket for Default Format product");
				test.log(LogStatus.INFO, "Click on Add to Basket for Default Format product");
				wait.until(
						ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='product-addtocart-button']/span")))
						.click();
				status = wait.until(ExpectedConditions.elementToBeClickable(
						By.xpath("//*[@id='product-attribute-specs-table']/div[8]/div[1]/span[2]"))).getText();
				System.out.println("The status of the product is: " + status);
				test.log(LogStatus.INFO, "The status of the product is: " + status);
				Thread.sleep(5000);

				viewBasket();
			}
		} catch (Exception e) {
			e.printStackTrace();
			CommonHelper.reportFailure("Check warning message was unsuccessful");
			Assert.fail(e.getMessage());
		}
		return status;
	}
}
