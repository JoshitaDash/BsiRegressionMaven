package com.tcs.BsiShopRedesign.pages;

import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import com.relevantcodes.extentreports.LogStatus;
import com.tcs.BsiShopRedesign.utilities.Page;
import com.tcs.BsiShopRedesign.utilities.CommonHelper;

public class DeliveryAddressPage extends Page {

	public DeliveryAddressPage(WebDriver driver) throws Exception {
		super(driver);
		// BaseTest.driver = driver;
	}

	public void addNewDeliveryAddress() {
		WebDriverWait wait = new WebDriverWait(driver, 15);

		try {
			// Thread.sleep(3000);
			Log.info("Click on Add new Delivery Address");
			System.out.println("Click on Add new Delivery Address");
			test.log(LogStatus.INFO, "Click on Add new Delivery Address");
			// wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("> Add
			// New Delivery Address")));
			// driver.findElement(By.linkText("> Add New Delivery Address")).click();
			System.out.println("");
			CommonHelper.isElementPresent(By.linkText("> Add New Delivery Address"));
			click("addDeliveryAddress_css");

			Thread.sleep(2000);
			Log.info("Adding Delivery Address Details");
			System.out.println("Adding Delivery Address Details");

			Thread.sleep(1000);
			System.out.println("Enter Address Name");
			test.log(LogStatus.INFO, "Enter Address Name");
			String randomString = RandomStringUtils.randomAlphabetic(5);
			String uniqueAddressName = "Reg Unique Name" + randomString;
			driver.findElement(By.cssSelector("input[name='unique_name']")).sendKeys(uniqueAddressName);

			Thread.sleep(1000);
			System.out.println("Enter Title");
			test.log(LogStatus.INFO, "Enter Title");
			Select titleDpdwn = new Select(driver.findElement(By.id("prefix")));
			titleDpdwn.selectByIndex(1);

			Thread.sleep(1000);
			System.out.println("Enter First Name");
			test.log(LogStatus.INFO, "Enter First Name");
			driver.findElement(By.cssSelector("input[id='register-name'][name='firstname']"))
					.sendKeys("Reg First Name");

			Thread.sleep(1000);
			System.out.println("Enter Last Name");
			test.log(LogStatus.INFO, "Enter Last Name");
			driver.findElement(By.id("register-last-name")).sendKeys("Reg Last Name");

			/*
			 * Thread.sleep(1000); System.out.println("Enter Company Name");
			 * test.log(LogStatus.INFO, "Enter Company Name");
			 * driver.findElement(By.id("register-company-name")).sendKeys(
			 * "Reg Company Name");
			 */

			Thread.sleep(1000);
			System.out.println("Enter Telephone Number");
			test.log(LogStatus.INFO, "Enter Telephone Number");
			driver.findElement(By.id("register-phn-no")).sendKeys("123456790");

			/*
			 * Thread.sleep(1000); System.out.println("Enter Fax Number");
			 * test.log(LogStatus.INFO, "Enter Fax Number");
			 * driver.findElement(By.id("fax")).sendKeys("0123456789");
			 */

			/*
			 * Thread.sleep(1000); System.out.println("Enter Street Address");
			 * test.log(LogStatus.INFO, "Enter Street Address");
			 * driver.findElement(By.id("street-address")).sendKeys( "London Street");
			 * 
			 * Thread.sleep(1000); System.out.println("Enter City");
			 * test.log(LogStatus.INFO, "Enter City");
			 * driver.findElement(By.id("city")).sendKeys("London");
			 * 
			 * Thread.sleep(1000); System.out.println("Enter State");
			 * test.log(LogStatus.INFO, "Enter State");
			 * driver.findElement(By.id("region")).sendKeys("England");
			 */

			Thread.sleep(1000);
			System.out.println("Enter Postal Code");
			test.log(LogStatus.INFO, "Enter Postal Code");
			driver.findElement(By.id("zip")).sendKeys("AA11AA");

			Thread.sleep(1000);
			System.out.println("Click Find Address");
			test.log(LogStatus.INFO, "Click Find Address");
			driver.findElement(By.cssSelector("button[class='action primary']")).click();

			Thread.sleep(1000);
			System.out.println("Select Address");
			test.log(LogStatus.INFO, "Select Address");
			Select address = new Select(driver.findElement(By.xpath("//*[@id='m2_address']/div/div/div[2]/select")));
			address.selectByIndex(1);

			Thread.sleep(3000);
			System.out.println("Click Submit");
			test.log(LogStatus.INFO, "Enter Submit");
			driver.findElement(By.cssSelector("button[class='redbuttonsubmit']")).click();
			test.log(LogStatus.PASS, "Adding Delivery Address has been added successfully");

		} catch (Exception e) {
			e.printStackTrace();
			CommonHelper.reportFailure("Add New Delivery address was unsuccessful");
			Assert.fail(e.getMessage());
		}
	}

	public void makeDefaultDeliveryAddress() {
		WebDriverWait wait = new WebDriverWait(driver, 15);

		try {
			boolean makeDefault = CommonHelper
					.checkVisibility(By.xpath("//*[@id='dash-address']/div/div[2]/div/ol/li/div/div[1]/a/span"));

			if (makeDefault) {
				Log.info("Click on Make Default Delivery Address");
				System.out.println("Click on Make Default Delivery Address");
				test.log(LogStatus.INFO, "Click on Make Default Delivery Address");
				driver.findElement(By.xpath("//*[@id='dash-address']/div/div[2]/div/ol/li/div/div[1]/a/span")).click();
				Thread.sleep(2000);
				test.log(LogStatus.PASS, "Make Default Delivery Address was successful");

			} else {

				Log.info("Add New Delivery Address");
				System.out.println("Add New Delivery Address");
				test.log(LogStatus.INFO, "Add New Delivery Address");
				addNewDeliveryAddress();

				Log.info("Click on Make Default Delivery Address");
				System.out.println("Click on Make Default Delivery Address");
				test.log(LogStatus.INFO, "Click on Make Default Delivery Address");
				driver.findElement(By.xpath("//*[@id='dash-address']/div/div[2]/div/ol/li/div/div[1]/a/span")).click();
				Thread.sleep(2000);
				test.log(LogStatus.PASS, "Make Default Delivery Address was successful");

			}

		} catch (Exception e) {
			e.printStackTrace();
			CommonHelper.reportFailure("Make Default Delivery Address was unsuccessful");
			Assert.fail(e.getMessage());
		}
	}

	public void editDeliveryAddress() {
		WebDriverWait wait = new WebDriverWait(driver, 30);
		try {
			boolean editDelivery = CommonHelper
					.checkVisibility(By.xpath(".//*[@id='dash-address']/div/div[2]/div/ol/li/div/div[2]/a/span[2]"));
			boolean editDefaultDelivery = CommonHelper.checkVisibility(By.cssSelector(".action.edit>span"));

			if (editDelivery) {

				Log.info("Click on Edit Delivery Address");
				System.out.println("Click on Edit Delivery Address");
				test.log(LogStatus.INFO, "Click on Edit Delivery Address");
				// driver.findElement(By.cssSelector(".pr5p.item.actions>a>span")).click();
				wait.until(ExpectedConditions.visibilityOfElementLocated(
						By.xpath(".//*[@id='dash-address']/div/div[2]/div/ol/li/div/div[2]/a/span[2]"))).click();

				Thread.sleep(2000);
				Log.info("Editing Delivery Address Details");
				System.out.println("Editing Delivery Address Details");

				Thread.sleep(1000);
				System.out.println("Edit Address Name");
				test.log(LogStatus.INFO, "Edit Address Name");
				wait.until(ExpectedConditions
						.visibilityOf(driver.findElement(By.cssSelector("input[name='unique_name']"))));
				driver.findElement(By.cssSelector("input[name='unique_name']")).sendKeys(" EDITED");

				Thread.sleep(1000);
				System.out.println("Edit Title");
				test.log(LogStatus.INFO, "Edit Title");
				Select titleDpdwn = new Select(driver.findElement(By.id("prefix")));
				titleDpdwn.selectByIndex(1);

				Thread.sleep(1000);
				System.out.println("Edit First Name");
				test.log(LogStatus.INFO, "Edit First Name");
				driver.findElement(By.id("first-name")).sendKeys(" EDITED");

				Thread.sleep(1000);
				System.out.println("Edit Last Name");
				test.log(LogStatus.INFO, "Edit Last Name");
				driver.findElement(By.id("register-last-name")).sendKeys(" EDITED");

				/*
				 * Thread.sleep(1000); System.out.println("Edit Company Name");
				 * test.log(LogStatus.INFO, "Edit Company Name");
				 * driver.findElement(By.id("register-company-name")).sendKeys( " EDITED");
				 */

				Thread.sleep(1000);
				System.out.println("Edit Telephone Number");
				test.log(LogStatus.INFO, "Edit Telephone Number");
				driver.findElement(By.id("register-phn-no")).sendKeys("0123456789");

				/*
				 * Thread.sleep(1000); System.out.println("Edit Fax Number");
				 * test.log(LogStatus.INFO, "Edit Fax Number");
				 * driver.findElement(By.id("fax")).sendKeys("9874563210");
				 */

				/*
				 * Thread.sleep(1000); System.out.println("Edit Street Address" );
				 * test.log(LogStatus.INFO, "Edit Street Address");
				 * driver.findElement(By.id("street-address")).sendKeys( " EDITED");
				 * 
				 * Thread.sleep(1000); System.out.println("Edit City"); test.log(LogStatus.INFO,
				 * "Edit City"); driver.findElement(By.id("city")).sendKeys(" EDITED");
				 * 
				 * Thread.sleep(1000); System.out.println("Edit State");
				 * test.log(LogStatus.INFO, "Edit State");
				 * driver.findElement(By.id("region")).sendKeys(" EDITED");
				 */

				Thread.sleep(1000);
				System.out.println("Edit Postal Code");
				test.log(LogStatus.INFO, "Edit Postal Code");
				driver.findElement(By.id("zip")).clear();
				driver.findElement(By.id("zip")).sendKeys("AA11AA");

				Thread.sleep(1000);
				System.out.println("Click Find Address");
				test.log(LogStatus.INFO, "Click Find Address");
				driver.findElement(By.cssSelector("button[class='action primary']")).click();

				Thread.sleep(1000);
				System.out.println("Select Address");
				test.log(LogStatus.INFO, "Select Address");
				Select address = new Select(
						driver.findElement(By.xpath("//*[@id='m2_address']/div/div/div[2]/select")));
				address.selectByIndex(2);

				Thread.sleep(3000);
				System.out.println("Click Submit");
				test.log(LogStatus.INFO, "Edit Submit");
				driver.findElement(By.cssSelector("button[class='redbuttonsubmit']")).click();
				test.log(LogStatus.PASS, "Delivery Addresses has been edited successfully");

			}

			else if (editDefaultDelivery) {

				Log.info("Click on Edit Delivery Address");
				System.out.println("Click on Edit Delivery Address");
				test.log(LogStatus.INFO, "Click on Edit Delivery Address");
				wait.until(ExpectedConditions.elementToBeClickable(
						By.xpath(".//*[@id='dash-address']/div/div[1]/div/div[4]/div[2]/div/div[1]/a/span"))).click();

				Thread.sleep(2000);
				Log.info("Editing Default Delivery Address Details");
				test.log(LogStatus.INFO, "Editing Default Delivery Address Details");
				System.out.println("Editing Default Delivery Address Details");

				Thread.sleep(1000);
				System.out.println("Edit Address Name");
				test.log(LogStatus.INFO, "Edit Address Name");
				driver.findElement(By.cssSelector("input[name='unique_name']")).sendKeys(" EDITED");

				Thread.sleep(1000);
				System.out.println("Edit Title");
				test.log(LogStatus.INFO, "Edit Title");
				Select titleDpdwn = new Select(driver.findElement(By.id("prefix")));
				titleDpdwn.selectByIndex(1);

				Thread.sleep(1000);
				System.out.println("Edit First Name");
				test.log(LogStatus.INFO, "Edit First Name");
				driver.findElement(By.id("first-name")).sendKeys(" EDITED");

				Thread.sleep(1000);
				System.out.println("Edit Last Name");
				test.log(LogStatus.INFO, "Edit Last Name");
				driver.findElement(By.id("register-last-name")).sendKeys(" EDITED");

				/*
				 * Thread.sleep(1000); System.out.println("Edit Company Name");
				 * test.log(LogStatus.INFO, "Edit Company Name");
				 * driver.findElement(By.id("register-company-name")).sendKeys( " EDITED");
				 */

				Thread.sleep(1000);
				System.out.println("Edit Telephone Number");
				test.log(LogStatus.INFO, "Edit Telephone Number");
				driver.findElement(By.id("register-phn-no")).sendKeys("0123456789");

				/*
				 * Thread.sleep(1000); System.out.println("Edit Fax Number");
				 * test.log(LogStatus.INFO, "Edit Fax Number");
				 * driver.findElement(By.id("fax")).sendKeys("9874563210");
				 */
				/*
				 * Thread.sleep(1000); System.out.println("Edit Street Address" );
				 * test.log(LogStatus.INFO, "Edit Street Address");
				 * driver.findElement(By.id("street-address")).sendKeys( " EDITED");
				 * 
				 * Thread.sleep(1000); System.out.println("Edit City"); test.log(LogStatus.INFO,
				 * "Edit City"); driver.findElement(By.id("city")).sendKeys(" EDITED");
				 * 
				 * Thread.sleep(1000); System.out.println("Edit State");
				 * test.log(LogStatus.INFO, "Edit State");
				 * driver.findElement(By.id("region")).sendKeys(" EDITED");
				 */

				Thread.sleep(1000);
				System.out.println("Edit Postal Code");
				test.log(LogStatus.INFO, "Edit Postal Code");
				driver.findElement(By.id("zip")).clear();
				driver.findElement(By.id("zip")).sendKeys("AA11AA");

				Thread.sleep(1000);
				System.out.println("Click Find Address");
				test.log(LogStatus.INFO, "Click Find Address");
				driver.findElement(By.cssSelector("button[class='action primary']")).click();

				Thread.sleep(1000);
				System.out.println("Select Address");
				test.log(LogStatus.INFO, "Select Address");
				Select address = new Select(
						driver.findElement(By.xpath("//*[@id='m2_address']/div/div/div[2]/select")));
				address.selectByIndex(2);

				Thread.sleep(3000);
				System.out.println("Click Submit");
				test.log(LogStatus.INFO, "Click Submit");
				driver.findElement(By.cssSelector("button[class='redbuttonsubmit']")).click();
				test.log(LogStatus.PASS, "Delivery Addresses has been edited successfully");
			}

			else {
				test.log(LogStatus.INFO, "No Edit option present for Delivery Address");
				System.out.println("No Edit option present for Delivery Address");
			}
		} catch (Exception e) {
			e.printStackTrace();
			CommonHelper.reportFailure("Edit Delivery Address was unsuccessful");
			Assert.fail(e.getMessage());
		}

	}

	public void deleteDeliveryAddress() {

		WebDriverWait wait = new WebDriverWait(driver, 15);
		try {
			Thread.sleep(3000);
			boolean deleteAddress = CommonHelper.checkVisibility(By.cssSelector(".action.delete>span"));

			if (deleteAddress) {
				Log.info("Click on Delete Delivery Address");
				System.out.println("Click on Delete Delivery Address");
				test.log(LogStatus.INFO, "Click on Delete Delivery Address");
				driver.findElement(By.cssSelector(".action.delete>span")).click();

				Thread.sleep(2000);
				Log.info("Click on Confirm Delete Delivery Address");
				System.out.println("Click on Confirm Delete Delivery Address");
				test.log(LogStatus.INFO, "Click on Confirm Delete Delivery Address");
				driver.findElement(By.cssSelector(".action-primary.action-accept")).click();
				Thread.sleep(2000);
				test.log(LogStatus.PASS, "Delivery Address has been deleted successfully");

			} else {
				Log.info("Add New Delivery Address");
				System.out.println("Add New Delivery Address");
				test.log(LogStatus.INFO, "Add New Delivery Address");
				addNewDeliveryAddress();

				Thread.sleep(3000);
				Log.info("Click on Delete Delivery Address");
				System.out.println("Click on Delete Delivery Address");
				test.log(LogStatus.INFO, "Click on Delete Delivery Address");
				driver.findElement(By.cssSelector(".action.delete>span")).click();

				Thread.sleep(2000);
				Log.info("Click on Confirm Delete Delivery Address");
				System.out.println("Click on Confirm Delete Delivery Address");
				test.log(LogStatus.INFO, "Click on Confirm Delete Delivery Address");
				driver.findElement(By.cssSelector(".action-primary.action-accept")).click();
				Thread.sleep(2000);
				test.log(LogStatus.PASS, "Delivery Address has been deleted successfully");
			}

		} catch (Exception e) {
			e.printStackTrace();
			CommonHelper.reportFailure("Delete Delivery Address was unsuccessful");
			Assert.fail(e.getMessage());
		}
	}

	public void addTenNewDeliveryAddress() {
		WebDriverWait wait = new WebDriverWait(driver, 120);

		try {

			for (int i = 1; i <= 9; i++) {
				Thread.sleep(5000);
				Log.info("Add New Delivery Address");
				System.out.println("Add New Delivery Address");
				test.log(LogStatus.INFO, "Add New Delivery Address");
				addNewDeliveryAddress();

			}
			Thread.sleep(1000);
			String tenDeliveryMsg = driver.findElement(By.xpath("//*[@id='dash-address']/div/div[3]/div")).getText();
			System.out.println("The Delivery Address message is: " + tenDeliveryMsg);
			Log.info("The Delivery Address message is: " + tenDeliveryMsg);

			if (tenDeliveryMsg
					.contains("You have reached the maximum of 10 delivery addresses attached to your profile.")) {
				test.log(LogStatus.PASS, tenDeliveryMsg);
				System.out.println(tenDeliveryMsg);
			}

			else {
				Log.info("Adding Ten Delivery Address was unsuccessful");
				System.out.println("Adding Ten Delivery Address was unsuccessful");
				test.log(LogStatus.FAIL, "Adding Ten Delivery Address was unsuccessful");
			}

		} catch (Exception e) {
			e.printStackTrace();
			CommonHelper.reportFailure("Adding Ten Delivery Address was unsuccessful");
			Assert.fail(e.getMessage());
		}
	}

	public void deleteTenDeliveryAddress() {

		// WebDriverWait wait = new WebDriverWait(driver, 15);

		try {
			Thread.sleep(10000);
			boolean deleteAddress = CommonHelper.checkVisibility(By.cssSelector(".action.delete>span"));

			if (deleteAddress) {

				for (int i = 1; i <= 9; i++) {
					Thread.sleep(2000);
					Log.info("Click on Delete Delivery Address");
					System.out.println("Click on Delete Delivery Address");
					test.log(LogStatus.INFO, "Click on Delete Delivery Address");
					CommonHelper.elementToBeVisible("deleteDeliveryAddress_css");
					CommonHelper.elementToBeClickable("deleteDeliveryAddress_css");
					click("deleteDeliveryAddress_css");

					Thread.sleep(3000);
					Log.info("Click on Confirm Delete Delivery Address");
					System.out.println("Click on Confirm Delete Delivery Address");
					test.log(LogStatus.INFO, "Click on Confirm Delete Delivery Address");
					driver.findElement(By.cssSelector(".action-primary.action-accept")).click();
					Thread.sleep(5000);

					test.log(LogStatus.PASS, "Delivery Address has been deleted successfully");
					System.out.println("Delivery Address has been deleted successfully");
				}
				
				test.log(LogStatus.PASS, "Ten Delivery Addresses has been deleted successfully");
				System.out.println("Ten Delivery Addresses has been deleted successfully");

			}
		} catch (Exception e) {
			e.printStackTrace();
			CommonHelper.reportFailure("Delete Ten Delivery Address was unsuccessful");
			Assert.fail(e.getMessage());
		}
	}

}
