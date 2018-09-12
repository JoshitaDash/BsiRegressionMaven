package com.tcs.BsiShopRedesign.pages;

import java.io.File;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import com.relevantcodes.extentreports.LogStatus;
import com.tcs.BsiShopRedesign.utilities.CommonHelper;
import com.tcs.BsiShopRedesign.utilities.Page;

public class OrderHistoryPage extends Page {

	public OrderHistoryPage(WebDriver driver) throws Exception {
		super(driver);

	}

	public void clickOrderHistoryTab() {

		try {
			Thread.sleep(1000);
			Log.info("Click on Order History Tab");
			System.out.println("Click on Order History Tab");
			test.log(LogStatus.INFO, "Click on Order History Tab");
			click("orderHistoryTab_id");

		} catch (InterruptedException e) {
			CommonHelper.reportFailure("Click on Order History Tab was unsuccessful");
			Assert.fail(e.getMessage());
			e.printStackTrace();
		}
	}

	public void clickViewOrder() {

		try {
			Thread.sleep(1000);
			Log.info("Click on View Order Link");
			System.out.println("Click on View Order Link");
			test.log(LogStatus.INFO, "Click on View Order Link");
			click("viewOrder_xpath");

		} catch (InterruptedException e) {
			CommonHelper.reportFailure("Click on Order History Tab was unsuccessful");
			Assert.fail(e.getMessage());
			e.printStackTrace();
		}
	}

	public void downloadAndVerifySoftCopy() {

		String allDocs = null;
		String firstSoftCopy = null;
		String secondSoftCopy = null;

		try {
			List<WebElement> downloadSoftCopy = driver
					.findElements(By.cssSelector("a[class*='downloadyourpdfbutton']"));
			List<WebElement> softCopyName = driver
					.findElements(By.cssSelector("a[href*='https://staging-standards.bsigroup.com/pid']"));

			Thread.sleep(2000);
			test.log(LogStatus.INFO, ("Download First SoftCopy Document"));
			Log.info("Download First SoftCopy Document");
			System.out.println("Download First SoftCopy Document");
			WebElement download = downloadSoftCopy.get(0);
			CommonHelper.explicitWaitClickable(download);
			download.click();
			firstSoftCopy = softCopyName.get(0).getText();
			firstSoftCopy = firstSoftCopy.replace(":", "_");
			// docName.add(firstSoftCopy);
			Thread.sleep(2000);
			verifyExpectedFileName(firstSoftCopy);

			Thread.sleep(4000);
			test.log(LogStatus.INFO, ("Download Second SoftCopy Document"));
			Log.info("Download Second SoftCopy Document");
			System.out.println("Download Second SoftCopy Document");
			downloadSoftCopy.get(1).click();
			secondSoftCopy = softCopyName.get(1).getText();
			secondSoftCopy = secondSoftCopy.replace(":", "_");
			// docName.add(secondSoftCopy);
			Thread.sleep(2000);
			verifyExpectedFileName(secondSoftCopy);

			Thread.sleep(4000);
			test.log(LogStatus.INFO, ("Download All SoftCopy Documents"));
			Log.info("Download All SoftCopy Documents");
			System.out.println("Download All SoftCopy Documents");
			CommonHelper.scrolltoview("downloadAllDocs_xpath");
			click("downloadAllDocs_xpath");
			Thread.sleep(2000);
			test.log(LogStatus.PASS, "All Documents Download is Successful");
			String orderNum = driver.findElement(By.xpath("//*[@id='order-date-css']/p/span")).getText();
			String arr[] = orderNum.split("#", 2);
			String ordernumber = arr[1];
			allDocs = "BSI_order number_" + ordernumber;
			Thread.sleep(2000);
			verifyExpectedFileName(allDocs);
			Thread.sleep(2000);
		} catch (Exception e) {
			CommonHelper.reportFailure("SoftCopy Download was unsuccessful");
			e.printStackTrace();
		}

	}

	public void verifyExpectedFileName(String downloadDoc) {
		try {
			File getLatestFile = getLatestFilefromDir("C:\\Users\\shopqa\\Downloads");
			String fileName = getLatestFile.getName();
			if (fileName.contains(downloadDoc)) {
				// Assert.assertTrue(fileName.contains(downloadDoc),"Downloaded file name is not
				// matching with expected file name");
				test.log(LogStatus.INFO, "The downloaded file name is: " + fileName);
				test.log(LogStatus.PASS, "Verification of File Name was successful");
			} else {
				CommonHelper.reportFailure("File Not Found");
			}
		} catch (Exception e) {
			CommonHelper.reportFailure("Soft Copy Document Name Verification was unsuccessful");
			e.printStackTrace();
		}
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

	public void verifyOrderStatus() {

		try {
			String status = driver.findElements(By.cssSelector("td[data-th='Status']")).get(0).getText();
			if (status.equals("In Progress")) {
				test.log(LogStatus.PASS, "The Status is: " + status);
				System.out.println("The Status is: " + status);
			} else {
				test.log(LogStatus.FAIL, "The Status is: " + status);
				System.out.println("The Status is: " + status);
			}
		} catch (Exception e) {
			CommonHelper.reportFailure("Verification of Status in Order History Page was unsuccessful");
			e.printStackTrace();
		}
	}

	public void verifyHardCopyDetails() {

		try {
			Thread.sleep(1000);
			Log.info("Verify HardCopy Details in Order History Page");
			System.out.println("Verify HardCopy Details in Order History Page");
			test.log(LogStatus.INFO, "Verify HardCopy Details in Order History Page");
			String orderDate = driver.findElement(By.id("order-date-css")).getText();
			if (orderDate.contains("Order")) {
				test.log(LogStatus.PASS, "The Order ID and Date is: " + orderDate);
				System.out.println("The Order ID and Date is: " + orderDate);
			} else {
				test.log(LogStatus.FAIL, "The Order ID and Date is: " + orderDate);
				System.out.println("The Order ID and Date is: " + orderDate);
			}

			String orderDetails = driver
					.findElement(By.cssSelector("div[class='table-wrapper order-items order-margin-allignment']"))
					.getText();
			if (orderDetails.contains("Hard")) {
				test.log(LogStatus.PASS, "The Order detials for Hardcopy Product is: " + orderDetails);
				System.out.println("The Order detials for Hardcopy Product is: " + orderDetails);

			} else {
				test.log(LogStatus.FAIL, "The Order detials for Hardcopy Product is: " + orderDetails);
				System.out.println("The Order detials for Hardcopy Product is: " + orderDetails);

			}

			String paymentMethod = driver.findElement(By.cssSelector("div[class='box box-order-billing-method']"))
					.getText();
			if (paymentMethod.contains("Payment")) {
				test.log(LogStatus.PASS, "The Payment Details for Harcopy Product is: " + paymentMethod);
				System.out.println("The Payment detials for Hardcopy Product is: " + paymentMethod);

			} else {
				test.log(LogStatus.FAIL, "The Payment Details for Harcopy Product is: " + paymentMethod);
				System.out.println("The Payment detials for Hardcopy Product is: " + paymentMethod);
			}

			String address = driver.findElement(By.xpath("//*[@id='maincontent']/div[5]/div[1]/div[2]/div[2]"))
					.getText();
			if (address.contains("address")) {
				test.log(LogStatus.PASS, "The Address Details for Harcopy Product is: " + address);
				System.out.println("The Address detials for Hardcopy Product is: " + address);
			}

		} catch (InterruptedException e) {
			CommonHelper.reportFailure("Verification of Hardcopy Details on Order History Page was unsuccessful");
			Assert.fail(e.getMessage());
			e.printStackTrace();
		}
	}

}
