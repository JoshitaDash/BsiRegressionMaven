package com.tcs.BsiShopRedesign.pages;
import org.apache.commons.lang3.RandomStringUtils;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import com.relevantcodes.extentreports.LogStatus;
import com.tcs.BsiShopRedesign.utilities.CommonHelper;
import com.tcs.BsiShopRedesign.utilities.Page;


public class BillingAddressPage extends Page {

	public BillingAddressPage(WebDriver driver) throws Exception {
		super(driver);
		// BaseTest.driver = driver;
		// TODO Auto-generated constructor stub
	}

	public void addNewBillingAddress() {
		WebDriverWait wait = new WebDriverWait(driver, 15);
		try {
			Thread.sleep(3000);
			Log.info("Click on Add new Billing Address");
			System.out.println("Click on Add new Billing Address");
			test.log(LogStatus.INFO, "Click on Add new Billing Address");
			// driver.findElement(By.cssSelector(".primary")).click();
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("> Add new billing address")));
			driver.findElement(By.linkText("> Add new billing address")).click();

			Thread.sleep(2000);
			Log.info("Adding Billing Address Details");
			System.out.println("Adding Billing Address Details");

			Thread.sleep(1000);
			System.out.println("Enter Address Name");
			test.log(LogStatus.INFO, "Enter Address Name");
			String randomString = RandomStringUtils.randomAlphabetic(5);
			String uniqueAddressName = "Reg Unique Name" + randomString;
			driver.findElement(By.id("register-unique-name")).sendKeys(uniqueAddressName);
			// driver.findElement(By.cssSelector("input[name='unique_name']")).sendKeys(uniqueAddressName);

			Thread.sleep(1000);
			System.out.println("Enter Title");
			test.log(LogStatus.INFO, "Enter Title");
			Select titleDpdwn = new Select(driver.findElement(By.id("prefix")));
			titleDpdwn.selectByIndex(1);

			Thread.sleep(1000);
			System.out.println("Enter First Name");
			test.log(LogStatus.INFO, "Enter First Name");
			driver.findElement(By.id("register-name")).sendKeys("Reg First Name");

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

			/*Thread.sleep(1000);
			System.out.println("Enter Fax Number");
			test.log(LogStatus.INFO, "Enter Fax Number");
			driver.findElement(By.id("fax")).sendKeys("0123456789");*/

			/*
			 * Thread.sleep(1000); System.out.println("Enter Street Address");
			 * test.log(LogStatus.INFO, "Enter Street Address");
			 * driver.findElement(By.id("street-address")).sendKeys(
			 * "London Street");
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
			// selectFirstOption("selectAddressDpdwn_xpath");

			Thread.sleep(3000);
			System.out.println("Click Submit");
			test.log(LogStatus.INFO, "Click Submit");
			driver.findElement(By.cssSelector("button[class='redbuttonsubmit']")).click();
			test.log(LogStatus.PASS, "Adding Billing Address was successful");

		} catch (Exception e) {

			e.printStackTrace();
			test.log(LogStatus.FAIL, "Adding Billing Address was unsuccessful");
			Assert.fail(e.getMessage());
		}
	}

	public void editBillingAddress() {

		try {
			boolean editAddress = CommonHelper
					.checkVisibility(By.xpath("//*[@id='dash-address']/div/div[1]/div/div[2]/div/div/p[2]/a/span[2]"));
			boolean editDefaultAddress = CommonHelper
					.checkVisibility(By.xpath("//*[@id='dash-address']/div/div[1]/div/div[1]/div/a/span"));

			if (editAddress) {
				Thread.sleep(3000);
				Log.info("Click on Edit Billing Address");
				test.log(LogStatus.INFO, "Click on Edit Billing Address");
				System.out.println("Click on Edit Billing Address");
				driver.findElement(By.xpath("//*[@id='dash-address']/div/div[1]/div/div[2]/div/div/p[2]/a/span[2]"))
						.click();

				Thread.sleep(2000);
				Log.info("Editing Billing Address Details");
				System.out.println("Editing Billing Address Details");

				Thread.sleep(1000);
				System.out.println("Edit Address Name");
				test.log(LogStatus.INFO, "Edit Address Name");
				driver.findElement(By.cssSelector("input[name='unique_name']")).sendKeys(" EDITED");

				Thread.sleep(1000);
				System.out.println("Edit Title");
				test.log(LogStatus.INFO, "Edit Title");
				Select titleDpdwn = new Select(driver.findElement(By.cssSelector("select[class*='selectgender']")));
				titleDpdwn.selectByIndex(1);

				/*
				 * Select titleDpdwn = new
				 * Select(driver.findElement(By.id("register-select-gender")));
				 * titleDpdwn.selectByIndex(1);
				 */

				Thread.sleep(1000);
				System.out.println("Edit First Name");
				test.log(LogStatus.INFO, "Edit First Name");
				driver.findElement(By.id("first-name")).sendKeys(" EDITED");

				Thread.sleep(1000);
				System.out.println("Edit Last Name");
				test.log(LogStatus.INFO, "Edit Last Name");
				driver.findElement(By.id("register-last-name")).sendKeys(" EDITED");

				Thread.sleep(1000);
				System.out.println("Edit Company Name");
				test.log(LogStatus.INFO, "Edit Company Name");
				driver.findElement(By.id("register-company-name")).sendKeys(" EDITED");

				Thread.sleep(1000);
				System.out.println("Edit Telephone Number");
				test.log(LogStatus.INFO, "Edit Telephone Number");
				driver.findElement(By.id("register-phn-no")).sendKeys("0123456789");

				/*Thread.sleep(1000);
				System.out.println("Edit Fax Number");
				test.log(LogStatus.INFO, "Edit Fax Number");
				driver.findElement(By.id("fax")).sendKeys("9874563210");*/

				/*
				 * Thread.sleep(1000); System.out.println("Edit Street Address"
				 * ); test.log(LogStatus.INFO, "Edit Street Address");
				 * driver.findElement(By.id("street-address")).sendKeys(
				 * " EDITED");
				 * 
				 * Thread.sleep(1000); System.out.println("Edit City");
				 * test.log(LogStatus.INFO, "Edit City");
				 * driver.findElement(By.id("city")).sendKeys(" EDITED");
				 * 
				 * Thread.sleep(1000); System.out.println("Edit State");
				 * test.log(LogStatus.INFO, "Edit State");
				 * driver.findElement(By.id("region")).sendKeys(" EDITED");
				 */

				/*
				 * Thread.sleep(1000); System.out.println("Enter Postal Code");
				 * test.log(LogStatus.INFO, "Enter Postal Code");
				 * driver.findElement(By.id("zip")).sendKeys("AA11AA");
				 */

				Thread.sleep(1000);
				System.out.println("Click Find Address");
				test.log(LogStatus.INFO, "Click Find Address");
				driver.findElement(By.cssSelector("button[class='action primary']")).click();

				Thread.sleep(1000);
				System.out.println("Select Address");
				test.log(LogStatus.INFO, "Select Address");
				Select address = new Select(
						driver.findElement(By.xpath("//*[@id='m2_address']/div/div/div[2]/select")));
				address.selectByIndex(3);

				Thread.sleep(3000);
				System.out.println("Click Submit");
				test.log(LogStatus.INFO, "Edit Submit");
				driver.findElement(By.cssSelector("button[class='redbuttonsubmit']")).click();
				test.log(LogStatus.PASS, "Edit Billing Address was successful");

			}

			else if (editDefaultAddress) {

				Thread.sleep(3000);
				Log.info("Click on Edit Billing Address");
				test.log(LogStatus.INFO, "Click on Edit Billing Address");
				System.out.println("Click on Edit Billing Address");
				driver.findElement(By.xpath("//*[@id='dash-address']/div/div[1]/div/div[1]/div/a/span")).click();

				Thread.sleep(2000);
				Log.info("Editing Default Billing Address Details");
				System.out.println("Editing Default Billing Address Details");

				Thread.sleep(1000);
				System.out.println("Edit Address Name");
				test.log(LogStatus.INFO, "Edit Address Name");
				driver.findElement(By.cssSelector("input[name='unique_name']")).sendKeys(" EDITED");

				Thread.sleep(1000);
				System.out.println("Edit Title");
				test.log(LogStatus.INFO, "Edit Title");
				Select titleDpdwn = new Select(driver.findElement(By.cssSelector("select[class*='selectgender']")));
				titleDpdwn.selectByIndex(1);
				/*
				 * Select titleDpdwn1 = new
				 * Select(driver.findElement(By.id("register-select-gender")));
				 * titleDpdwn1.selectByIndex(1);
				 */

				Thread.sleep(1000);
				System.out.println("Edit First Name");
				test.log(LogStatus.INFO, "Edit First Name");
				driver.findElement(By.id("first-name")).sendKeys(" EDITED");

				Thread.sleep(1000);
				System.out.println("Edit Last Name");
				test.log(LogStatus.INFO, "Edit Last Name");
				driver.findElement(By.id("register-last-name")).sendKeys(" EDITED");

				Thread.sleep(1000);
				System.out.println("Edit Company Name");
				test.log(LogStatus.INFO, "Edit Company Name");
				driver.findElement(By.id("register-company-name")).sendKeys(" EDITED");

				Thread.sleep(1000);
				System.out.println("Edit Telephone Number");
				test.log(LogStatus.INFO, "Edit Telephone Number");
				driver.findElement(By.id("register-phn-no")).sendKeys("0123456789");

				/*Thread.sleep(1000);
				System.out.println("Edit Fax Number");
				test.log(LogStatus.INFO, "Edit Fax Number");
				driver.findElement(By.id("fax")).sendKeys("9874563210");*/

				/*
				 * Thread.sleep(1000); System.out.println("Edit Street Address"
				 * ); test.log(LogStatus.INFO, "Edit Street Address");
				 * driver.findElement(By.id("street-address")).sendKeys(
				 * " EDITED");
				 * 
				 * Thread.sleep(1000); System.out.println("Edit City");
				 * test.log(LogStatus.INFO, "Edit City");
				 * driver.findElement(By.id("city")).sendKeys(" EDITED");
				 * 
				 * Thread.sleep(1000); System.out.println("Edit State");
				 * test.log(LogStatus.INFO, "Edit State");
				 * driver.findElement(By.id("region")).sendKeys(" EDITED");
				 */

				Thread.sleep(1000);
				System.out.println("Enter Postal Code");
				test.log(LogStatus.INFO, "Enter Postal Code");
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
				address.selectByIndex(1);

				Thread.sleep(3000);
				System.out.println("Click Submit");
				test.log(LogStatus.INFO, "Click Submit");
				driver.findElement(By.cssSelector("button[class='redbuttonsubmit']")).click();
				test.log(LogStatus.PASS, "Edit Billing Address was successful");

			} else {
				test.log(LogStatus.INFO, "Edit Billing Address does not exist");
				System.out.println("Edit Billing Address does not exist");
			}

		} catch (Exception e) {
			e.printStackTrace();
			CommonHelper.reportFailure("Edit Billing Address was unsuccessful");
			Assert.fail(e.getMessage());
		}
	}

	public void deleteBillingAddress() {

		try {
			Thread.sleep(3000);
			boolean deleteAddress = CommonHelper.checkVisibility(By.cssSelector(".action.edit.deletebtn>span"));

			if (deleteAddress) {
				Log.info("Click on Delete Billing Address");
				System.out.println("Click on Delete Billing Address");
				test.log(LogStatus.INFO, "Click on Delete Billing Address");
				driver.findElement(By.cssSelector(".action.edit.deletebtn>span")).click();

				Thread.sleep(2000);
				Log.info("Click on Confirm Delete Billing Address");
				System.out.println("Click on Confirm Delete Billing Address");
				test.log(LogStatus.INFO, "Click on Confirm Delete Billing Address");
				driver.findElement(By.cssSelector(".myprofile-okbutton")).click();
				Thread.sleep(2000);
				test.log(LogStatus.PASS, "Delete Billing Address was successful");

			} else {
				Log.info("Add New Billing Address");
				System.out.println("Add New Billing Address");
				test.log(LogStatus.INFO, "Add New Billing Address");
				addNewBillingAddress();

				Thread.sleep(3000);
				Log.info("Click on Delete Billing Address");
				System.out.println("Click on Delete Billing Address");
				test.log(LogStatus.INFO, "Click on Delete Billing Address");
				driver.findElement(By.cssSelector(".action.edit.deletebtn>span")).click();

				Thread.sleep(2000);
				Log.info("Click on Confirm Delete Billing Address");
				System.out.println("Click on Confirm Delete Billing Address");
				test.log(LogStatus.INFO, "Click on Confirm Delete Billing Address");
				driver.findElement(By.cssSelector(".myprofile-okbutton")).click();
				Thread.sleep(2000);
				test.log(LogStatus.PASS, "Delete Billing Address was successful");

			}

		} catch (Exception e) {
			e.printStackTrace();
			test.log(LogStatus.FAIL, "Delete Billing Address was unsuccessful");
			Assert.fail(e.getMessage());
		}
	}

	public void makeDefaultBillingAddress() {

		try {
			boolean makeDefault = CommonHelper
					.checkVisibility(By.xpath("//*[@id='dash-address']/div/div[1]/div/div[2]/div/div/p[1]/a/span"));

			if (makeDefault) {
				Log.info("Click on Make Default Billing Address");
				System.out.println("Click on Make Default Billing Address");
				test.log(LogStatus.INFO, "Click on Make Default Billing Address");
				driver.findElement(By.xpath("//*[@id='dash-address']/div/div[1]/div/div[2]/div/div/p[1]/a/span"))
						.click();
				Thread.sleep(2000);
				test.log(LogStatus.PASS, "Make Default of Billing Address was successful");
			}

			else {

				Log.info("Add New Billing Address");
				System.out.println("Add New Billing Address");
				test.log(LogStatus.INFO, "Add New Billing Address");
				addNewBillingAddress();

				Thread.sleep(2000);
				Log.info("Click on Make Default Billing Address");
				System.out.println("Click on Make Default Billing Address");
				test.log(LogStatus.INFO, "Click on Make Default Billing Address");
				driver.findElement(By.xpath("//*[@id='dash-address']/div/div[1]/div/div[2]/div/div/p[1]/a/span"))
						.click();
				Thread.sleep(2000);
				test.log(LogStatus.PASS, "Make Default of Billing Address was successful");
			}

		} catch (Exception e) {
			e.printStackTrace();
			CommonHelper.reportFailure("Make Default of Billing Address was unsuccessful");
			Assert.fail(e.getMessage());
		}
	}

	public void addTenNewBillingAddress() {
		// WebDriverWait wait = new WebDriverWait(driver, 15);
		// boolean tenBillMsg =
		// checkVisibility(By.xpath("//*[@id='dash-address']/div/div[1]/div/div[3]/div"));

		try {

			for (int i = 1; i <= 9; i++) {

				Thread.sleep(2000);
				Log.info("Adding Billing Address Details");
				System.out.println("Adding Billing Address Details");

				Log.info("Add New Billing Address");
				System.out.println("Add New Billing Address");
				test.log(LogStatus.INFO, "Add New Billing Address");
				addNewBillingAddress();
			}

			String billingMsg = driver.findElement(By.xpath("//*[@id='dash-address']/div/div[1]/div/div[3]/div"))
					.getText();
			System.out.println("The Billing Message is: " + billingMsg);
			Log.info("The Billing Message is: " + billingMsg);
			test.log(LogStatus.PASS, "Ten Billing Addresses has been added successfully");

			if (billingMsg.contains("You have reached the maximum of 10 billing addresses attached to your profile.")) {
				test.log(LogStatus.PASS, billingMsg);
			}

			else {
				Log.info("Adding Ten Billing Address was unsuccessful");
				System.out.println("Adding Ten Billing Address was unsuccessful");
				test.log(LogStatus.FAIL, "Adding Ten Billing Address was unsuccessful");
			}

		} catch (Exception e) {
			e.printStackTrace();
			CommonHelper.reportFailure("Adding Ten Billing Address was unsuccessful");
			Assert.fail(e.getMessage());
		}
	}

	public void deleteTenBillingAddress() {

		try {
			Thread.sleep(3000);
			boolean deleteAddress = CommonHelper.checkVisibility(By.cssSelector(".action.edit.deletebtn>span"));

			if (deleteAddress) {

				for (int i = 1; i <= 9; i++) {
					Log.info("Click on Delete Billing Address");
					System.out.println("Click on Delete Billing Address");
					test.log(LogStatus.INFO, "Click on Delete Billing Address");
					CommonHelper.elementToBeVisible("deleteBillingAddress_css");
					CommonHelper.elementToBeClickable("deleteBillingAddress_css");
					click("deleteBillingAddress_css");

					Thread.sleep(2000);
					Log.info("Click on Confirm Delete Billing Address");
					System.out.println("Click on Confirm Delete Billing Address");
					test.log(LogStatus.INFO, "Click on Confirm Delete Billing Address");
					driver.findElement(By.cssSelector(".myprofile-okbutton")).click();
					Thread.sleep(2000);
				}

				test.log(LogStatus.PASS, "Billing Address has been deleted successfully");
				System.out.println("Billing Address has been deleted successfully");

			} else {
				test.log(LogStatus.FAIL, "There is no Delete Address link available");
				System.out.println("There is no Delete Address link available");
			}
		} catch (Exception e) {
			e.printStackTrace();
			Log.error("Billing Address has not been deleted");
			test.log(LogStatus.FAIL, "Billing Address has not been deleted");
			Assert.fail(e.getMessage());
		}

	}
}
