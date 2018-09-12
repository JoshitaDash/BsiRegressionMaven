package com.tcs.BsiShopRedesign.pages;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import com.relevantcodes.extentreports.LogStatus;
import com.tcs.BsiShopRedesign.utilities.CommonHelper;
import com.tcs.BsiShopRedesign.utilities.FileDownloader;
import com.tcs.BsiShopRedesign.utilities.Page;

public class OrderConfirmationPage extends Page {

	public OrderConfirmationPage(WebDriver driver) throws Exception {
		super(driver);

	}

	public void downloadVerifySoftCopyDocuments() {

		String allDocs = null;
		String firstSoftCopy = null;
		String secondSoftCopy = null;
		// List<String> docName = new ArrayList<String>();

		try {

			List<WebElement> downloadSoftCopy = driver
					.findElements(By.cssSelector("a[class*='downloadyourpdfbutton']"));
			List<WebElement> softCopyName = driver
					.findElements(By.cssSelector("a[href*='https://staging-standards.bsigroup.com/pid']"));

			Thread.sleep(2000);
			test.log(LogStatus.INFO, ("Download First SoftCopy Document"));
			Log.info("Download First SoftCopy Document");
			System.out.println("Download First SoftCopy Document");
			downloadSoftCopy.get(0).click();
			Thread.sleep(2000);
			CommonHelper.handleAlert();
			test.log(LogStatus.PASS, "First Document Download is Successful");
			Thread.sleep(2000);
			CommonHelper.handleAlert();
			firstSoftCopy = softCopyName.get(0).getText();
			firstSoftCopy = firstSoftCopy.replace(":", "_");
			// docName.add(firstSoftCopy);
			// verifyExpectedFileName(firstSoftCopy);
			// try {
			if (verifyExpectedFileName(firstSoftCopy) != null) {
				test.log(LogStatus.PASS, "Verificatiion of First Document Download is Successful");
				System.out.println("Verificatiion of First Document Download is Successful");

			} else {
				test.log(LogStatus.FAIL, "Verificatiion of First Document Download was unSuccessful");
				System.out.println("Verificatiion of First Document Download was unSuccessful");
			}
			// } catch (Exception e) {
			// e.printStackTrace();
			// }

			Thread.sleep(5000);
			test.log(LogStatus.INFO, ("Download Second SoftCopy Document"));
			Log.info("Download Second SoftCopy Document");
			System.out.println("Download Second SoftCopy Document");
			downloadSoftCopy.get(1).click();
			Thread.sleep(2000);
			CommonHelper.handleAlert();
			test.log(LogStatus.PASS, "Second Document Download is Successful");
			secondSoftCopy = softCopyName.get(1).getText();
			CommonHelper.handleAlert();
			secondSoftCopy = secondSoftCopy.replace(":", "_");
			 //docName.add(secondSoftCopy);
			 //verifyExpectedFileName(secondSoftCopy);
			// try {
			if (verifyExpectedFileName(secondSoftCopy) != null) {
				test.log(LogStatus.PASS, "Verificatiion of Second Document Download is Successful");
				System.out.println("Verificatiion of Second Document Download is Successful");

			} else {
				test.log(LogStatus.FAIL, "Verificatiion of Second Document Download was unSuccessful");
				System.out.println("Verificatiion of Second Document Download was unSuccessful");
			}
			// } catch (Exception e) {
			// e.printStackTrace();
			// }

			Thread.sleep(5000);
			test.log(LogStatus.INFO, ("Download All SoftCopy Documents"));
			Log.info("Download All SoftCopy Documents");
			System.out.println("Download All SoftCopy Documents");
			CommonHelper.scrolltoview("downloadAllDocuments_xpath");
			Thread.sleep(2000);
			click("downloadAllDocuments_xpath");
			CommonHelper.handleAlert();
			Thread.sleep(5000);
			test.log(LogStatus.PASS, "All Documents Download is Successful");
			allDocs = firstSoftCopy + "," + secondSoftCopy;
			// verifyExpectedFileName(allDocs);
			Thread.sleep(2000);
			// try {
			if (verifyExpectedFileName(allDocs) != null) {
				test.log(LogStatus.PASS, "Verificatiion of All Documents Download is Successful");
				System.out.println("Verificatiion of All Documents Download is Successful");

			} else {
				test.log(LogStatus.FAIL, "Verificatiion of All Documents Download was unSuccessful");
				System.out.println("Verificatiion of All Documents Download was unSuccessful");
			}
			// } catch (Exception e) {
			// e.printStackTrace();
			// }

		} catch (Exception e) {
			CommonHelper.reportFailure("SoftCopy Download was unsuccessful");
			e.printStackTrace();
		}

	}

	public String downloadSecondSoftCopyDocument() {

		String secondSoftCopy = null;

		try {

			List<WebElement> downloadSoftCopy = driver
					.findElements(By.cssSelector("a[class*='downloadyourpdfbutton']"));
			List<WebElement> softCopyName = driver
					.findElements(By.cssSelector("a[href*='https://staging-standards.bsigroup.com/pid']"));

			Thread.sleep(2000);
			test.log(LogStatus.INFO, ("Download Second SoftCopy Document"));
			Log.info("Download Second SoftCopy Document");
			System.out.println("Download Second SoftCopy Document");
			downloadSoftCopy.get(1).click();
			secondSoftCopy = softCopyName.get(1).getText();

		} catch (Exception e) {
			CommonHelper.reportFailure("First SoftCopy Download was unsuccessful");
			e.printStackTrace();
		}

		return secondSoftCopy;

	}

	public String downloadFirstSoftCopyDocument() {

		String firstSoftCopy = null;

		try {

			List<WebElement> downloadSoftCopy = driver
					.findElements(By.cssSelector("a[class*='downloadyourpdfbutton']"));
			List<WebElement> softCopyName = driver
					.findElements(By.cssSelector("a[href*='https://staging-standards.bsigroup.com/pid']"));

			Thread.sleep(2000);
			test.log(LogStatus.INFO, ("Download First SoftCopy Document"));
			Log.info("Download First SoftCopy Document");
			System.out.println("Download First SoftCopy Document");
			downloadSoftCopy.get(0).click();
			firstSoftCopy = softCopyName.get(0).getText();

		} catch (Exception e) {
			CommonHelper.reportFailure("First SoftCopy Download was unsuccessful");
			e.printStackTrace();
		}

		return firstSoftCopy;

	}

	public String verifyExpectedFileName(String downloadDoc) {
		try {

			File getLatestFile = getLatestFilefromDir("C:\\Users\\shopqa\\Downloads");
			String fileName = getLatestFile.getName();
			
			if(fileName.contains(downloadDoc)) {
				test.log(LogStatus.INFO, "The downloaded file name is: " + fileName);
				test.log(LogStatus.PASS, "Verification of File Name was successful");
			}else
				CommonHelper.reportFailure("File Not Found");
			
			

		} catch (Exception e) {
			CommonHelper.reportFailure("Soft Copy Document Name Verification was unsuccessful");
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

	public void verifySoftCopy() throws NullPointerException, IOException {
		try {
			FileDownloader file=new FileDownloader(driver, System.getProperty("user.dir")+"//Files");
			
			List<WebElement> documents = driver.findElements(By.xpath("//a[contains(.,'Document')]"));
			for(WebElement document:documents) {			
				file.downloader(document.getAttribute("url"));
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
