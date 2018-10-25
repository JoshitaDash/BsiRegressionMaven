package com.tcs.BsiShopRedesign.pages;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import com.relevantcodes.extentreports.LogStatus;
import com.tcs.BsiShopRedesign.utilities.Page;
import com.tcs.BsiShopRedesign.utilities.BaseTest;
import com.tcs.BsiShopRedesign.utilities.CommonHelper;

public class BasketPage extends Page {

	public BasketPage(WebDriver driver) throws Exception {
		super(driver);
		// Page.driver = driver;
		// TODO Auto-generated constructor stub
	}

	public void editBasketUpdateQuantity() {

		WebDriverWait wait = new WebDriverWait(driver, 60);

		try {

			Thread.sleep(2000);
			/*
			 * Log.info("Update Quantity in Basket"); System.out.println(
			 * "Update Quantity in Basket");
			 */

			boolean quantity = CommonHelper
					.checkVisibility(By.cssSelector("input[class='input-text qty'][title='Qty']"));
			boolean quantityLaminated = CommonHelper.checkVisibility(By.xpath("//*[@data-role='cart-item-qty']"));
			System.out.println("The quantity visibility of the product is: " + quantity + quantityLaminated);

			if (quantity) {
				Log.info("Update Quantity in Basket");
				System.out.println("Update Quantity in Basket");
				test.log(LogStatus.INFO, "Update Quantity in Basket");
				// Thread.sleep(3000);
				// WebElement quantityCount =
				// driver.findElement(By.cssSelector("input[class='input-text
				// qty'][title='Qty']"));
				// WebElement update = driver.findElement(By.id("qty_upd"));
				WebElement quantityCount = wait.until(ExpectedConditions
						.visibilityOfElementLocated(By.cssSelector("input[class='input-text qty'][title='Qty']")));
				WebElement update = wait.until(ExpectedConditions.elementToBeClickable(By.id("qty_upd")));
				quantityCount.clear();
				quantityCount.sendKeys("50");
				update.click();
				System.out.println("The Quantity of the product updated to 50");
				test.log(LogStatus.INFO, "The Quantity of the product updated to 50");

			} else if (quantityLaminated) {
				Log.info("Update Quantity in Basket");
				System.out.println("Update Quantity in Basket");
				test.log(LogStatus.INFO, "Update Quantity in Basket");
				Thread.sleep(2000);
				WebElement quantityLaminatedCount = driver
						.findElement(By.cssSelector("input[class='input-text qty'][title='Qty']"));

				WebElement update = driver.findElement(By.id("qty_upd"));
				quantityLaminatedCount.clear();
				quantityLaminatedCount.sendKeys("50");
				update.click();
				System.out.println("The Quantity of the product updated to 50 ");
				test.log(LogStatus.INFO, "The Quantity of the product updated to 50");

			} else {
				test.log(LogStatus.INFO, "This is a PDF product hence quantity textbox is disabled.");
				System.out.println("This is a PDF product hence quantity textbox is disabled.");
			}

		} catch (Exception e) {
			e.printStackTrace();
			CommonHelper.reportFailure("The Quantity of the product was not updated");
			Assert.fail(e.getMessage());
		}
	}

	public void editBasketChangeFormat() {

		try {

			Log.info("Change Format in Basket");
			System.out.println("Change Format in Basket");
			test.log(LogStatus.INFO, "Change Format in Basket");

			boolean formatType = CommonHelper.checkVisibility(By.xpath("//div[@class='option1' and contains(.,'')]"));

			if (formatType) {

				WebElement format = driver.findElement(By.xpath("//div[@class='option1' and contains(.,'')]"));
				String formatText = format.getText();
				System.out.println("The Format of the product is: " + formatText);
				test.log(LogStatus.INFO, "The Format of the product is: " + formatText);

				Thread.sleep(10000);
				if (formatText.contains("Hard copy")) {
					Thread.sleep(2000);
					System.out.println("Change Format to PDF");
					test.log(LogStatus.INFO, "Change Format to PDF");
					driver.findElement(By.xpath(
							"//div[@class='option1' and contains(.,'Hard copy')]/ancestor::dd/following-sibling::div/button[contains(.,'Change Format')]"))
							.click();
					Thread.sleep(2000);

					Thread.sleep(2000);
					System.out.println("Click on the dropdown");
					test.log(LogStatus.INFO, "Click on the dropdown");
					WebElement ele = driver.findElement(By.xpath("//*[@id='attribute189']"));
					if (ele.isDisplayed()) {
						// JavascriptExecutor executor = (JavascriptExecutor)
						// driver;
						// executor.executeScript("arguments[0].click();", ele);
						ele.click();
						Thread.sleep(2000);
						Select dpdwn = new Select(ele);
						dpdwn.selectByIndex(0);
						Thread.sleep(3000);

					} else {
						System.out.println("Dropwn not visible: " + ele);
						test.log(LogStatus.FAIL, "Dropwn not visible: " + ele);
					}

				} else if (formatText.contains("PDF")) {
					Thread.sleep(2000);
					System.out.println("Change Format to HardCopy");
					test.log(LogStatus.INFO, "Change Format to HardCopy");
					driver.findElement(By.xpath(
							"//div[@class='option1' and contains(.,'PDF')]/ancestor::dd/following-sibling::div/button[contains(.,'Change Format')]"))
							.click();
					Thread.sleep(2000);

					Thread.sleep(2000);
					System.out.println("Click on the dropdown");
					test.log(LogStatus.INFO, "Click on the dropdown");
					WebElement ele = driver.findElement(By.xpath("//*[@id='attribute189']"));
					if (ele.isDisplayed()) {
						// JavascriptExecutor exe = (JavascriptExecutor)driver;
						// exe.executeScript("arguments[0].click();", ele);
						ele.click();
						Thread.sleep(2000);
						Select dpdwn = new Select(ele);
						dpdwn.selectByIndex(1);
						Thread.sleep(3000);

					} else {
						System.out.println("Dropwn not visible: " + ele);
						test.log(LogStatus.FAIL, "Dropwn not visible: " + ele);
					}
				} else {
					Log.info("There is no product with PDF or HardCopy format");
					System.out.println("There is no product with PDF or HardCopy format");
					test.log(LogStatus.INFO, "There is no product with PDF or HardCopy format");

				}
			} else {
				Log.info("There is no product in the Basket with Change Format Option");
				System.out.println("There is no product in the Basket with Change Format Option");
				test.log(LogStatus.INFO, "There is no product in the Basket with Change Format Option");

			}
		}

		catch (Exception e) {
			e.printStackTrace();
			CommonHelper.reportFailure("Change format in Basket was unsuccessful");
			Assert.fail(e.getMessage());

		}
	}

	public void removeProduct() {
		boolean removeProd = false;
		WebDriverWait wait = new WebDriverWait(driver, 120);

		try {
			Thread.sleep(5000);
			// removeProd =
			// driver.findElement(By.xpath("//img[@alt='delete']")).isDisplayed();
			// if (removeProd) {
			WebElement remove = driver.findElement(By.xpath("//img[@alt='delete']"));
			System.out.println("Click on Remove Item");
			test.log(LogStatus.INFO, "Click on Remove Item");
			Thread.sleep(5000);
			wait.until(ExpectedConditions.visibilityOf(remove));
			// wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//img[@alt='delete']")));
			wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//img[@alt='delete']")));

			// CommonHelper.clickByJS("remoeItem_id");
			System.out.println("removing product");
			click("removeProduct_xpath");
			// driver.findElement(By.xpath("///*[@id='shopping-cart-table']/tbody/tr/td[1]/div/div/a/span/img")).click();

			Thread.sleep(2000);
			System.out.println("Get the text of the remove basket message");
			test.log(LogStatus.INFO, "Get the text of the remove basket message");
			Thread.sleep(5000);
			wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("div[class='cart-empty']")));
			String basketVerify = wait
					.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("div[class='cart-empty']")))
					.getText();
			System.out.println("The Verfication message is: " + basketVerify);
			Log.info("The Verfication message is: " + basketVerify);
			test.log(LogStatus.PASS, "The Verfication message is: " + basketVerify);

			// }
		}

		catch (Exception e) {
			e.printStackTrace();
			CommonHelper.reportFailure("Remove product from Basket was unsuccessful");
			Assert.fail(e.getMessage());
		}

	}

	public void removeProductAndEvent() {

		WebDriverWait wait = new WebDriverWait(driver, 120);
		try {
			test.log(LogStatus.INFO, "Remove Product and Event from Basket");
			for (int i = 1; i <= 2; i++) {
				WebElement remove = driver.findElement(By.xpath("//img[@alt='delete']"));
				Thread.sleep(5000);
				wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//img[@alt='delete']")));
				wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//img[@alt='delete']")));
				remove.click();
				// Thread.sleep(5000);
				// click("removeEvent_xpath");
				// CommonHelper.clickByJS("removeEvent_xpath");
			}

			Thread.sleep(2000);
			test.log(LogStatus.INFO, "Verify Remove Basket");
			CommonHelper.elementToBeVisible("verifyBasket_css");
			CommonHelper.elementToBeClickable("verifyBasket_css");
			String verifyBasket = CommonHelper.element("verifyBasket_css").getText();
			System.out.println("The Verfication message is: " + verifyBasket);
			Log.info("The Verfication message is: " + verifyBasket);
			if (verifyBasket.contains("You have no items in your shopping basket.")) {
				test.log(LogStatus.PASS, "The Verfication message is: " + verifyBasket);
				test.log(LogStatus.PASS, "Product and Event has been removed from Basket successfully");
			}

		} catch (Exception e) {
			CommonHelper.reportFailure("Remove Event and Product from Basket was unsuccessful");
			e.printStackTrace();
			Assert.fail(e.getMessage());
		}

	}

	public void clickRegMUNL() {
		WebElement munlFrame_xpath = driver.findElement(By.xpath("//*[@id='MUNL-Modal']/div/div[2]/iframe"));

		try {
			Log.info("Click on Request MUNL link");
			System.out.println("Click on Request MUNL link");
			test.log(LogStatus.INFO, "Click on Request MUNL link");
			CommonHelper.elementToBeClickable("reqMUNL_linkText");
			Thread.sleep(1000);
			click("reqMUNL_linkText");

			System.out.println("Switch iFrame");
			Thread.sleep(2000);
			driver.switchTo().frame(munlFrame_xpath);
			// driver.switchTo().frame(0);
			Thread.sleep(2000);
			System.out.println("iframe switched");

		} catch (Exception e) {
			CommonHelper.reportFailure("Click on Request MUNL link was unsuccessful");
			e.printStackTrace();
			Assert.fail(e.getMessage());
		}
	}

	public void enterRegMUNLDetails() {
		try {
			test.log(LogStatus.INFO, "Select title");
			System.out.println("Select title");
			Log.info("Select title");
			// selectFirstOption("titleMUNL_css");
			enterText("titleMUNL_xpath", "Mr.");

			test.log(LogStatus.INFO, "Enter First Name");
			System.out.println("Enter First Name");
			Log.info("Enter First Name");
			enterText("firstNameMUNL_xpath", "MUNL First Name");

			test.log(LogStatus.INFO, "Enter Last Name");
			System.out.println("Enter Last Name");
			Log.info("Enter Last Name");
			enterText("lastNameMUNL_xpath", "MUNL Last Name");

			test.log(LogStatus.INFO, "Enter Email");
			System.out.println("Enter Email");
			Log.info("Enter Email");
			enterText("emailMUNL_xpath", "munl@tcs.com");

			test.log(LogStatus.INFO, "Enter Telephone Number");
			System.out.println("Enter Telephone Number");
			Log.info("Enter Telephone Number");
			enterText("telphoneMUNL_xpath", "132456789");

			test.log(LogStatus.INFO, "Enter Company");
			System.out.println("Enter Company");
			Log.info("Enter Company");
			enterText("companyMUNL_xpath", "MUNL Company");

			test.log(LogStatus.INFO, "Enter Address Line 1");
			System.out.println("Enter Address Line 1");
			Log.info("Enter Address Line 1");
			enterText("addressMUNL_xpath", "MUNL Address");

			test.log(LogStatus.INFO, "Enter Town");
			System.out.println("Enter Town");
			Log.info("Enter Town");
			enterText("townMUNL_xpath", "MUNL Town");

			test.log(LogStatus.INFO, "Enter PostCode");
			System.out.println("Enter PostCode");
			Log.info("Enter PostCode");
			enterText("postcodeMUNL_xpath", "MUNL PostCode");

			test.log(LogStatus.INFO, "Select Country");
			System.out.println("Select Country");
			Log.info("Select Country");
			selectFirstOption("countryMUNL_xpath");

			test.log(LogStatus.INFO, "Enter STD number");
			System.out.println("Enter STD number");
			Log.info("Enter STD number");
			enterText("stdnumMUNL_xpath", "135465768");

			test.log(LogStatus.INFO, "Enter STD title");
			System.out.println("Enter STD title");
			Log.info("Enter STD title");
			enterText("stdTitleMUNL_xpath", "135465768");

			test.log(LogStatus.INFO, "Select MUNL Question");
			System.out.println("Select MUNL Question");
			Log.info("Select MUNL Question");
			CommonHelper.scrolltoview("quesMUNL_xpath");
			selectFirstOption("quesMUNL_xpath");

			test.log(LogStatus.INFO, "Select How would you like to be contacted?");
			System.out.println("Enter How would you like to be contacted?");
			Log.info("Enter How would you like to be contacted?");
			List<WebElement> checkBox = driver.findElements(By.cssSelector("input[type='checkbox']"));
			checkBox.get(0).click();

			test.log(LogStatus.INFO, "Select Terms and Conditions");
			System.out.println("Select Terms and Conditions");
			Log.info("Select Terms and Conditions");
			checkBox.get(4).click();

			test.log(LogStatus.INFO, " Click on Submit");
			System.out.println("Click on Submit");
			Log.info("Click on Submit");
			CommonHelper.scrolltoview("submitMUNL_css");
			// CommonHelper.clickByJS("submitMUNL_css");
			click("submitMUNL_css");
			Thread.sleep(3000);

		} catch (Exception e) {
			CommonHelper.reportFailure("Enter Request MUNL Details was unsuccessful");
			e.printStackTrace();
			Assert.fail(e.getMessage());
		}

	}

	public void verifyMUNL() {
		try {
			// if (BaseTest.browser.equals("IE")) {
			ArrayList<String> tabs2 = new ArrayList<String>(driver.getWindowHandles());
			driver.switchTo().window(tabs2.get(1));
			driver.switchTo().activeElement();
			driver.manage().window().maximize();

			Thread.sleep(1000);
			test.log(LogStatus.INFO, "Verify MUNL Request");
			System.out.println("Verify MUNL Request");
			Log.info("Verify MUNL Request");
			CommonHelper.scrolltoview("verifyMUNL_xpath");
			String verifyText = CommonHelper.element("verifyMUNL_xpath").getText();
			// String verifyText = driver.findElement(By.id("pardot-form")).getText();
			System.out.println("The verification message is: " + verifyText);
			test.log(LogStatus.PASS, "The verification message is: " + verifyText);

			driver.close();
			driver.switchTo().window(tabs2.get(0));

			Thread.sleep(1000);
			test.log(LogStatus.INFO, "Click on Close MUNL Form");
			System.out.println("Click on Close MUNL Form");
			Log.info("Click on Close MUNL Form");
			driver.switchTo().defaultContent();
			click("closeMUNLform_xpath");

			// } else {
			/*
			 * Thread.sleep(1000); test.log(LogStatus.INFO, "Verify MUNL Request");
			 * System.out.println("Verify MUNL Request"); Log.info("Verify MUNL Request");
			 * CommonHelper.scrolltoview("verifyMUNL_xpath"); String verifyText =
			 * CommonHelper.element("verifyMUNL_xpath").getText(); // String verifyText =
			 * driver.findElement(By.id("pardot-form")).getText();
			 * System.out.println("The verification message is: " + verifyText);
			 * test.log(LogStatus.PASS, "The verification message is: " + verifyText);
			 * 
			 * Thread.sleep(1000); test.log(LogStatus.INFO, "Click on Close MUNL Form");
			 * System.out.println("Click on Close MUNL Form");
			 * Log.info("Click on Close MUNL Form"); driver.switchTo().defaultContent();
			 * click("closeMUNLform_xpath");
			 */
			// }

		} catch (Exception e) {
			CommonHelper.reportFailure("VerifyRequest MUNL Details was unsuccessful");
			e.printStackTrace();
			Assert.fail(e.getMessage());
		}
	}

	public void clickCheckout() {

		try {
			Thread.sleep(2000);
			test.log(LogStatus.INFO, "Click Checkout");
			System.out.println("Click Checkout");
			Log.info("Click Checkout");
			Thread.sleep(2000);
			// CommonHelper.scrolltoview("checkoutNow_css");
			WebElement checkout = driver.findElement(By.cssSelector("button[title='Checkout Now']"));
			if (checkout.isDisplayed() || checkout.isEnabled()) {
				Thread.sleep(5000);
				// CommonHelper.clickJS(checkout);
				checkout.click();
				// click("checkoutNow_css");

				Thread.sleep(3000);
			} else {
				test.log(LogStatus.FAIL, "Click Checkout was unsuccessful");
			}
		}

		catch (Exception e) {
			CommonHelper.reportFailure("Click Checkout was unsuccessful");
			e.printStackTrace();
			Assert.fail(e.getMessage());
		}

	}

	

	public void clickOtherFormatOKAlert() {

		try {
			boolean otherFormat = driver.findElement(By.id("OtherFormatFlag")).isDisplayed();
			// driver.switchTo().activeElement();
			driver.switchTo().frame(0);
			// CommonHelper.handleAlert();
			System.out.println(" ");
			if (otherFormat) {
				// WebElement otherForm = driver.findElement(By.id("otherFormat"));
				/*
				 * JavascriptExecutor executor = (JavascriptExecutor) driver;
				 * executor.executeScript("arguments[0].click();",
				 * driver.findElement(By.id("otherFormat")));
				 */
				driver.findElement(By.id("otherFormat")).click();
				System.out.println("Other Foramt Flag exists");
			} else {
				System.out.println("Other Format Flag does not exists");
			}

		} catch (Exception e) {
			CommonHelper.reportFailure("Other Format Flag does not exists");
			e.printStackTrace();
		}
	}

	public String verifyMemPriceBasket() {

		String memDiscount = null;
		try {
			WebElement unitPrice = driver.findElements(By.cssSelector("td[data-th='Price']>div")).get(0);
			WebElement finalPrice = driver.findElement(By.cssSelector("span[class='cart-price']"));
			WebElement memPrice = driver.findElements(By.cssSelector("span[class='textcolour']")).get(1);
			WebElement totalPrice = driver.findElement(By.cssSelector("span[class='floatr']"));

			String priceText = unitPrice.getText();
			String finalPriceText = finalPrice.getText();
			String totalPriceText = totalPrice.getText();

			String memPrice1 = memPrice.getText();
			String[] splitMemPrice = memPrice1.split(" ", 3);
			String memPriceText = splitMemPrice[2];

			priceText = priceText.substring(1);
			finalPriceText = finalPriceText.substring(1);
			memPriceText = memPriceText.substring(1);
			totalPriceText = totalPriceText.substring(1);

			double finalUnitPrice = Double.parseDouble(priceText);
			double finalFinalPrice = Double.parseDouble(finalPriceText);
			double finalMemPrice = Double.parseDouble(memPriceText);
			double finalTotalPrice = Double.parseDouble(totalPriceText);
			double memberPrice = finalUnitPrice / 2;
			memDiscount = Double.toString(memberPrice);

			if (finalFinalPrice == memberPrice && finalMemPrice == memberPrice && finalTotalPrice == memberPrice) {
				System.out.println("The unit price of the product in the Basket Page is: " + finalUnitPrice
						+ " & The member price of the product in the Basket Page is: " + finalMemPrice
						+ " & The total price of the product in the Basket Page is: " + finalTotalPrice);
				test.log(LogStatus.PASS,
						"The unit price of the product in the Basket Page is: " + finalUnitPrice
								+ " & The member price of the product in the Basket Page is: " + finalMemPrice
								+ " & The total price of the product in the Basket Page is: " + finalTotalPrice);
				// return true;
			} else {
				System.out.println("The unit price of the product in the Basket Page is: " + finalUnitPrice
						+ " & The member price of the product in the Basket Page is: " + finalMemPrice
						+ " & The total price of the product in the Basket Page is: " + finalTotalPrice);
				test.log(LogStatus.FAIL,
						"The unit price of the product in the Basket Page is: " + finalUnitPrice
								+ " & The member price of the product in the Basket Page is: " + finalMemPrice
								+ " & The total price of the product in the Basket Page is: " + finalTotalPrice);
				CommonHelper.reportFailure("The member price in the Basket Page is incorrect");
			}
			// return false;

		} catch (NumberFormatException e) {
			CommonHelper.reportFailure("The member price in the Basket Page is incorrect");
			e.printStackTrace();
		}
		return memDiscount;

	}

	public void removeMultipleProduct() {

		WebDriverWait wait = new WebDriverWait(driver, 120);
		test.log(LogStatus.INFO, "Remove Multiple Products from Basket");
		List<WebElement> removeItem = driver.findElements(By.xpath("//img[@alt='delete']"));
		System.out.println("Remove");
		try {

			for (int i = 1; i <= removeItem.size(); i++) {
				// WebElement remove = driver.findElement(By.xpath("//img[@alt='delete']"));
				Thread.sleep(5000);
				wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//img[@alt='delete']")));
				wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//img[@alt='delete']")));
				// remove.click();
				click("removeEvent_xpath");
			}

			Thread.sleep(3000);
			test.log(LogStatus.INFO, "Verify Remove Basket");
			// CommonHelper.elementToBeVisible("verifyBasket_css");
			CommonHelper.elementToBeClickable("verifyBasket_css");
			String verifyBasket = CommonHelper.element("verifyBasket_css").getText();
			System.out.println("The Verfication message is: " + verifyBasket);
			Log.info("The Verfication message is: " + verifyBasket);
			test.log(LogStatus.PASS, "Multiple Products has been removed from Basket successfully");

		} catch (Exception e) {
			CommonHelper.reportFailure("Remove Product from Basket was unsuccessful");
			e.printStackTrace();
			Assert.fail(e.getMessage());
		}

	}

}
