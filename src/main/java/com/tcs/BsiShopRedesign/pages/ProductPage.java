package com.tcs.BsiShopRedesign.pages;

import java.io.File;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import com.relevantcodes.extentreports.LogStatus;
import com.tcs.BsiShopRedesign.utilities.Page;
import com.tcs.BsiShopRedesign.utilities.CommonHelper;

public class ProductPage extends Page {

	public ProductPage(WebDriver driver) throws Exception {
		super(driver);
	}

	static String status;

	public String selectFormatAndAddToBasket() throws InterruptedException {

		WebDriverWait wait = new WebDriverWait(driver, 120);
		try {

			// Thread.sleep(2000);
			// boolean defaultFormat =
			// CommonHelper.checkVisibility(By.xpath("//h4[contains(.,'Format')]"));
			Log.info("Check Visibility for Default Format product");
			System.out.println("Check Visibility for Default Format product");
			boolean defaultFormat = CommonHelper.checkVisibility(By.cssSelector("h3[class='simple-prod-head']"));

			Log.info("Check Visibility for Existing Format product");
			System.out.println("Check Visibility for Existing Format product");
			boolean existingFormat = CommonHelper.checkVisibility(By.xpath("//*[@id='r']"));
			// boolean existingFormat =
			// CommonHelper.checkVisibility(By.xpath("//h4[text()='Select
			// format:']//following-sibling::div[@id='r']//label[contains(.,'PDF')]"));

			/*
			 * Log.info("Check Visibility for Withdrawn product");
			 * System.out.println("Check Visibility for Withdrawn product"); boolean
			 * withdrawnText = CommonHelper
			 * .checkVisibility(By.xpath("//*[@id='prod-main-new']/div[1]/div[2]/p[1]"));
			 */
			// boolean essentialsFormat =
			// CommonHelper.checkVisibility(By.xpath("//h4[text()='Select number of
			// license:']//following-sibling::div[@id='r']//label[contains(.,'1
			// License')]"));

			if (defaultFormat) {
				Log.info("Click on Add to Basket for Default Format product");
				System.out.println("Click on Add to Basket for Default Format product");
				test.log(LogStatus.INFO, "Click on Add to Basket for Default Format product");
				wait.until(
						ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='product-addtocart-button']/span")))
						.click();
				status = wait
						.until(ExpectedConditions.elementToBeClickable(
								By.xpath("//*[@id='product-details-media']/div[2]/div[2]/div/div[7]/div[1]/span[2]")))
						.getText();
				System.out.println("The status of the product is: " + status);
				test.log(LogStatus.INFO, "The status of the product is: " + status);
				// Thread.sleep(3000);

				viewBasket();

			} else if (existingFormat /* && !withdrawnText */) {
				// Thread.sleep(3000);
				System.out.println("Select Hardcopy format");
				test.log(LogStatus.INFO, "Select Hardcopy format");
				Log.info("Select Hardcopy format");
				driver.findElement(By.xpath("//*[@id='r']/label[3]/span")).click();

				// Thread.sleep(3000);
				Log.info("Click on Add to Basket");
				System.out.println("Click on Add to Basket");
				test.log(LogStatus.INFO, "Click on Add to Basket");
				// driver.findElement(By.xpath("//*[@id='product-addtocart-button']/span")).click();
				wait.until(
						ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='product-addtocart-button']/span")))
						.click();

				status = wait
						.until(ExpectedConditions.visibilityOfElementLocated(
								By.xpath("//*[@id='product-details-media']/div[2]/div[2]/div/div[7]/div[1]/span[2]")))
						.getText();
				System.out.println("The status of the product is: " + status);
				test.log(LogStatus.INFO, "The status of the product is: " + status);

				viewBasket();

			} /*
				 * else if (essentialsFormat) {
				 * 
				 * // Thread.sleep(3000); System.out.println("Select Essentials format ");
				 * test.log(LogStatus.INFO, "Select Essentials format ");
				 * Log.info("Select Format Essentials format");
				 * driver.findElement(By.xpath("//*[@id='r']/label[2]/span")).click();
				 * 
				 * Thread.sleep(3000); Log.info("Click on Add to Basket");
				 * System.out.println("Click on Add to Basket"); test.log(LogStatus.INFO,
				 * "Click on Add to Basket"); //
				 * driver.findElement(By.xpath("//*[@id='product-addtocart-button']/span")).
				 * click(); wait.until( ExpectedConditions.elementToBeClickable(By.xpath(
				 * "//*[@id='product-addtocart-button']/span"))) .click(); status =
				 * "essentialsFormat"; System.out.println("The status of the product is: " +
				 * status); test.log(LogStatus.INFO, "The status of the product is: " + status);
				 * 
				 * viewBasket();
				 * 
				 * }
				 */ else {
				Log.info("This product cannot be added to Basket");
				System.out.println("This product cannot be added to Basket");
				test.log(LogStatus.INFO, "This product cannot be added to Basket");

				status = wait
						.until(ExpectedConditions.elementToBeClickable(
								By.xpath("//*[@id='product-details-media']/div[2]/div[2]/div/div[7]/div[1]/span[2]")))
						.getText();
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
		WebDriverWait wait = new WebDriverWait(driver, 120);
		try {
			Thread.sleep(12000);
			System.out.println("Click on View Basket");
			test.log(LogStatus.INFO, "Click on View Basket ");
			Log.info("Click on View Basket");
			wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='basket']/div/a/span[1]")));
			// driver.findElement(By.xpath("//*[@id='basket']/div/a/span[1]")).click();
			click("viewBasket_xpath");
		} catch (InterruptedException e) {
			e.printStackTrace();
			CommonHelper.reportFailure("Click on View Basket was unsuccessful");
			Assert.fail(e.getMessage());
		}

	}

	public String addPDFProductToBasket() {

		WebDriverWait wait = new WebDriverWait(driver, 30);
		try {
			for (int i = 0; i <= 1; i++) {
				Thread.sleep(1000);
				/*
				 * Log.info("Check Visibility for Default Format product");
				 * System.out.println("Check Visibility for Default Format product"); boolean
				 * defaultFormat =
				 * CommonHelper.checkVisibility(By.cssSelector("h3[class='simple-prod-head']"));
				 */

				Log.info("Check Visibility for Existing Format product");
				System.out.println("Check Visibility for Existing Format product");
				boolean existingFormat = CommonHelper.checkVisibility(By.xpath("//*[@id='r']"));
				// boolean defaultFormat =
				// CommonHelper.checkVisibility(By.xpath("//h4[contains(.,'Format')]"));
				// boolean existingFormat =
				// CommonHelper.checkVisibility(By.xpath("//h4[text()='Select
				// format:']//following-sibling::div[@id='r']//label[contains(.,'PDF')]"));
				// boolean withdrawnText =
				// CommonHelper.checkVisibility(By.xpath("//*[@id='prod-main-new']/div[1]/div[2]/p[1]"));
				// boolean essentialsFormat =
				// CommonHelper.checkVisibility(By.xpath("//h4[text()='Select number of
				// license:']//following-sibling::div[@id='r']//label[contains(.,'1
				// License')]"));

				/*
				 * if (defaultFormat) {
				 * Log.info("Click on Add to Basket for Default Format product");
				 * System.out.println("Click on Add to Basket for Default Format product");
				 * test.log(LogStatus.INFO,
				 * "Click on Add to Basket for Default Format product");
				 * wait.until(ExpectedConditions
				 * .elementToBeClickable(By.xpath("//*[@id='product-addtocart-button']/span"))).
				 * click(); status = wait .until(ExpectedConditions.elementToBeClickable(
				 * By.xpath(
				 * "//*[@id='product-details-media']/div[2]/div[2]/div/div[7]/div[1]/span[2]")))
				 * .getText();
				 * 
				 * System.out.println("The status of the product is: " + status);
				 * test.log(LogStatus.INFO, "The status of the product is: " + status);
				 * 
				 * } else
				 */if (existingFormat /* && !withdrawnText */) {
					Thread.sleep(1000);
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
							.until(ExpectedConditions.elementToBeClickable(By
									.xpath("//*[@id='product-details-media']/div[2]/div[2]/div/div[7]/div[1]/span[2]")))
							.getText();

					System.out.println("The status of the product is: " + status);
					test.log(LogStatus.INFO, "The status of the product is: " + status);

				} /*
					 * else if (essentialsFormat) {
					 * 
					 * Thread.sleep(3000); System.out.println("Select Essentials format ");
					 * test.log(LogStatus.INFO, "Select Essentials format ");
					 * Log.info("Select Format Essentials format");
					 * driver.findElement(By.xpath("//*[@id='r']/label[2]/span")).click();
					 * 
					 * Thread.sleep(3000); Log.info("Click on Add to Basket");
					 * System.out.println("Click on Add to Basket"); test.log(LogStatus.INFO,
					 * "Click on Add to Basket"); //
					 * driver.findElement(By.xpath("//*[@id='product-addtocart-button']/span")).
					 * click(); wait.until(ExpectedConditions
					 * .elementToBeClickable(By.xpath("//*[@id='product-addtocart-button']/span"))).
					 * click(); status = "essentialsFormat";
					 * System.out.println("The status of the product is: " + status);
					 * test.log(LogStatus.INFO, "The status of the product is: " + status);
					 * 
					 * }
					 */ else {
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
			// boolean defaultFormat =
			// CommonHelper.checkVisibility(By.xpath("//h4[contains(.,'Format')]"));

			if (defaultFormat) {
				Log.info("Click on Add to Basket for Default Format product");
				System.out.println("Click on Add to Basket for Default Format product");
				test.log(LogStatus.INFO, "Click on Add to Basket for Default Format product");
				wait.until(
						ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='product-addtocart-button']/span")))
						.click();
				status = wait
						.until(ExpectedConditions.elementToBeClickable(
								By.xpath("//*[@id='product-details-media']/div[2]/div[2]/div/div[7]/div[1]/span[2]")))
						.getText();
				System.out.println("The status of the product is: " + status);
				test.log(LogStatus.INFO, "The status of the product is: " + status);
				// Thread.sleep(5000);

				viewBasket();
			}
		} catch (Exception e) {
			e.printStackTrace();
			CommonHelper.reportFailure("Check warning message was unsuccessful");
			Assert.fail(e.getMessage());
		}
		return status;
	}

	public void applyMembership() {

		try {
			WebDriverWait wait = new WebDriverWait(driver, 10);
			wait.until(ExpectedConditions.elementToBeClickable(
					By.xpath("//*[@id='prod-main-new']/div[1]/div[1]/span[2]/span/span[2]/a/p/span")));

			test.log(LogStatus.INFO, ("Click on Become a Member"));
			Log.info("Click on Become a Member");
			System.out.println("Click on Become a Member");
			driver.findElement(By.xpath("//*[@id='prod-main-new']/div[1]/div[1]/span[2]/span/span[2]/a/p/span"))
					.click();

		} catch (Exception e) {
			CommonHelper.reportFailure("Apply Membership was unsuccessful");
			e.printStackTrace();
			Assert.fail(e.getMessage());
		}

	}

	public void verifyMemberLink() {

		boolean memberLink = false;

		try {

			test.log(LogStatus.INFO, ("Verify Member Link"));
			Log.info("Verify Member Link");
			System.out.println("Verify Member Link");

			try {
				memberLink = driver
						.findElement(By.xpath("//*[@id='prod-main-new']/div[1]/div[1]/span[2]/span/span[2]/a/p/span"))
						.isDisplayed();
			} catch (Exception e) {
				e.printStackTrace();
			}

			if (memberLink) {
				Log.info("Member link is visible in Member Account");
				System.out.println("Member link is visible in Member Account");
				test.log(LogStatus.FAIL, "Member link is visible in Member Account");
				CommonHelper.reportFailure("Member link is visible in Member Account");
			}

			else {
				Log.info("Member link is not visible in Member Account");
				System.out.println("Member link is not visible in Member Account");
				test.log(LogStatus.PASS, "Member link is not visible in Member Account");
			}
		} catch (Exception e) {
			CommonHelper.reportFailure("Member link is visible in Member Account");
			e.printStackTrace();
			Assert.fail(e.getMessage());
		}
	}

	public void verifyPDFPreview() {

		try {
			// boolean noPreview = driver.findElement(By.id("no_preview")).isDisplayed();
			boolean lookInside = false;
			try {
				lookInside = driver.findElement(By.cssSelector("a[class='prod-look-inside-btn']")).isDisplayed();
			} catch (Exception e) {
				e.printStackTrace();
			}

			if (lookInside) {
				// WebDriverWait wait = new WebDriverWait(driver, 10);
				// wait.until(ExpectedConditions.elementToBeClickable(By.id("prevSubmit")));
				test.log(LogStatus.INFO, ("Click on Look Inside"));
				Log.info("Click on Look Inside");
				System.out.println("Click on Look Inside");
				CommonHelper.elementToBeClickable("lookInside_id");
				click("lookInside_id");

				pdfPreview();

				pdfZoomIn();

				pdfZoomOut();

				pdfSave();

				pdfPrint();

				pdfCloseWindow();

			} else /* if (noPreview.isDisplayed()) */ {
				test.log(LogStatus.PASS, ("No PDF Preview available for this product"));
				Log.info("No PDF Preview available for this product");
				System.out.println("No PDF Preview available for this product");
				Thread.sleep(1000);
				CommonHelper.takeScreenShot();
			}
		} catch (InterruptedException e) {
			CommonHelper.reportFailure("PDF Previweing was unsuccessful");
			e.printStackTrace();
		}

	}

	public void pdfPreview() throws InterruptedException {

		try {
			test.log(LogStatus.INFO, ("Verify PDF Preview image"));
			Log.info("Verify PDF Preview image");
			System.out.println("Verify PDF Preview image");

			System.out.println("Switch iFrame");
			// Thread.sleep(2000);
			driver.switchTo().activeElement();
			WebElement pdf = driver.findElement(By.xpath("//*[@id='prevNo-1']/img"));
			String altValue = pdf.getAttribute("alt");
			Thread.sleep(2000);
			CommonHelper.takeScreenShot();
			// String pdfText = driver.findElement(By.id("prevNo-1")).getText();
			System.out.println("The pdf text is: " + altValue);
			test.log(LogStatus.INFO, "The pdf text is: " + altValue);
		} catch (Exception e) {
			CommonHelper.reportFailure("Verify PDF Preview image was unsuccessful");
			e.printStackTrace();
		}
	}

	public void pdfZoomIn() {

		try {
			test.log(LogStatus.INFO, ("Verify PDF Preview Zoom In"));
			Log.info("Verify PDF Preview Zoom In");
			System.out.println("Verify PDF Preview Zoom In");
			CommonHelper.elementToBeClickable("pdfZoomIn_css");
			click("pdfZoomIn_css");
			Thread.sleep(2000);
			CommonHelper.takeScreenShot();
			test.log(LogStatus.PASS, "Verify PDF Preview Zoom In was successful");

		} catch (Exception e) {
			CommonHelper.reportFailure("Verify PDF Preview Zoom In was unsuccessful");
			e.printStackTrace();
		}
	}

	public void pdfZoomOut() {

		try {
			test.log(LogStatus.INFO, ("Verify PDF Preview Zoom Out"));
			Log.info("Verify PDF Preview Zoom Out");
			System.out.println("Verify PDF Preview Zoom Out");
			CommonHelper.elementToBeClickable("pdfZoomOut_css");
			click("pdfZoomOut_css");
			Thread.sleep(2000);
			CommonHelper.takeScreenShot();
			test.log(LogStatus.PASS, "Verify PDF Preview Zoom Out was successful");

		} catch (Exception e) {
			CommonHelper.reportFailure("Verify PDF Preview Zoom Out was unsuccessful");
			e.printStackTrace();
		}
	}

	public void pdfSave() {

		try {
			test.log(LogStatus.INFO, ("Verify PDF Preview Save"));
			Log.info("Verify PDF Preview Save");
			System.out.println("Verify PDF Preview Save");
			CommonHelper.elementToBeClickable("pdfSave_css");
			click("pdfSave_css");
			Thread.sleep(2000);
			CommonHelper.handleAlert();
			test.log(LogStatus.PASS, "Verify PDF Preview Save was successful");
			Thread.sleep(3000);
			String productName = driver.findElement(By.cssSelector("span[itemprop='name']")).getText();
			productName = productName.replace(":", "_");
			Thread.sleep(5000);
			if (verifyExpectedFileName(productName) != null) {
				test.log(LogStatus.PASS, "Verification of PDF Preview file name is Successful");
				System.out.println("Verification of PDF Preview file name is Successful");

			} else {
				test.log(LogStatus.FAIL, "Verification of PDF Preview file name was unSuccessful");
				System.out.println("Verification of PDF Preview file name was unSuccessful");
			}

		} catch (Exception e) {
			CommonHelper.reportFailure("Verify PDF Preview Save and File Name was unsuccessful");
			e.printStackTrace();
		}
	}

	public void pdfPrint() {

		try {
			test.log(LogStatus.INFO, ("Verify PDF Preview Print"));
			Log.info("Verify PDF Preview Print");
			System.out.println("Verify PDF Preview Print");
			CommonHelper.elementToBeClickable("pdfPrint_css");
			click("pdfPrint_css");
			test.log(LogStatus.PASS, "Verify PDF Preview Print was successful");

		} catch (Exception e) {
			CommonHelper.reportFailure("Verify PDF Preview Print was unsuccessful");
			e.printStackTrace();
		}
	}

	public void pdfCloseWindow() {

		try {

			test.log(LogStatus.INFO, ("Verify PDF Preview Close Window"));
			Log.info("Verify PDF Preview Close Window");
			System.out.println("Verify PDF Preview Close Window");
			CommonHelper.elementToBeClickable("pdfClose_css");
			click("pdfClose_css");
			test.log(LogStatus.PASS, "Verify PDF Preview Close Window was successful");

		} catch (Exception e) {
			CommonHelper.reportFailure("Verify PDF Preview Close Window was unsuccessful");
			e.printStackTrace();
		}
	}

	public String verifyExpectedFileName(String downloadDoc) {
		try {

			File getLatestFile = getLatestFilefromDir("C:\\Users\\shopqa\\Downloads");
			String fileName = getLatestFile.getName();

			if (fileName.contains(downloadDoc)) {
				test.log(LogStatus.INFO, "The downloaded file name is: " + fileName);
				test.log(LogStatus.PASS, "Verification of File Name was successful");
			} else
				CommonHelper.reportFailure("File Not Found");

		} catch (Exception e) {
			CommonHelper.reportFailure("PDF Preview Name Verification was unsuccessful");
			e.printStackTrace();
		}
		return downloadDoc;
	}

	/* Get the latest file from a specific directory */
	private File getLatestFilefromDir(String dirPath) {
		File dir = new File(dirPath);
		File[] files = dir.listFiles();
		if (files == null || files.length == 0) {
			return null;
		}

		File lastModifiedFile = files[0];
		for (int i = 1; i < files.length; i++) {
			if (lastModifiedFile.lastModified() < files[i].lastModified()) {
				lastModifiedFile = files[i];
			}
		}
		return lastModifiedFile;
	}

	public void verifyAdvanceAccessProduct() {

		try {

			test.log(LogStatus.INFO, ("Verify Advance Access Product"));
			Log.info("Verify Advance Access Product");
			System.out.println("Verify Advance Access Product");

			String advanceAcessText = driver.findElement(By.cssSelector("span[data-th='Availability Check']"))
					.getText();
			if (advanceAcessText.contains("advance access")) {
				System.out.println(
						"The text of the product is: " + advanceAcessText + "Advance Access Product was successful");
				test.log(LogStatus.INFO, "The text of the product is: " + advanceAcessText);
				test.log(LogStatus.PASS, "Advance Access Product was successful");
			}

			else {
				System.out.println(
						"The text of the product is: " + advanceAcessText + "Advance Access Product was unsuccessful");
				test.log(LogStatus.INFO, "The text of the product is: " + advanceAcessText);
				test.log(LogStatus.FAIL, "Advance Access Product was unsuccessful");
			}

		} catch (Exception e) {
			CommonHelper.reportFailure("Verification of Advance Access Product was unsuccessful");
			e.printStackTrace();
		}
	}

	public void verifyPreOrderProduct() {

		try {

			test.log(LogStatus.INFO, ("Verify Pre Order Product"));
			Log.info("Verify Pre Order Product");
			System.out.println("Verify Pre Order Product");

			String advanceAcessText = driver.findElement(By.cssSelector("span[data-th='Availability Check']"))
					.getText();
			if (advanceAcessText.contains("pre-order")) {
				System.out.println(
						"The text of the product is: " + advanceAcessText + "Pre Order Product was successful");
				test.log(LogStatus.INFO, "The text of the product is: " + advanceAcessText);
				test.log(LogStatus.PASS, "Pre Order Product was successful");
			}

			else {
				System.out.println(
						"The text of the product is: " + advanceAcessText + "Pre Order Product was unsuccessful");
				test.log(LogStatus.INFO, "The text of the product is: " + advanceAcessText);
				test.log(LogStatus.FAIL, "Pre Order Product was unsuccessful");
			}

		} catch (Exception e) {
			CommonHelper.reportFailure("Verification of Pre Order Product was unsuccessful");
			e.printStackTrace();
		}
	}
}
