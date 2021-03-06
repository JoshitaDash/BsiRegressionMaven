package com.tcs.BsiShopRedesign.pages;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import com.relevantcodes.extentreports.LogStatus;
import com.tcs.BsiShopRedesign.utilities.CommonHelper;
import com.tcs.BsiShopRedesign.utilities.Page;

import freemarker.template.utility.NumberUtil;

public class SearchPage extends Page {

	public SearchPage(WebDriver driver) throws Exception {
		super(driver);
	}

	public boolean countPAS() {

		boolean isNextButtonDisplayed = false;
		int counter = 1;
		int productLink = 0;
		String productLinkText;
		int numOfProducts = 0;

		try {

			do {

				isNextButtonDisplayed = !CommonHelper.isElementHiddenNow("(//span[text()='Next'])[2]");

				selectMaxItems();
				test.log(LogStatus.INFO, "Count product on the Search List");
				Log.info("Count product on the Search List");
				System.out.println("Count product on the Search List");
				CommonHelper.elementToBeVisible("productLinkCount_css");
				CommonHelper.elementToBeClickable("productLinkCount_css");
				productLink = driver.findElements(By.cssSelector("a[class='product-item-link']")).size();
				productLinkText = Integer.toString(productLink);

				if (isNextButtonDisplayed) {
					CommonHelper.elementToBeVisible("next_xpath");
					CommonHelper.scrolltoview("next_xpath");
					test.log(LogStatus.INFO, "Click on Next" + "The current page is: " + counter++);
					System.out.println("Click on Next");
					Log.info("Click on Next");
					/*
					 * JavascriptExecutor executor = (JavascriptExecutor) driver;
					 * executor.executeScript("arguments[0].click();",
					 * By.xpath("(//span[text()='Next'])[2]"));
					 */
					// driver.findElement(By.xpath("(//span[text()='Next'])[2]")).click();
					click("next_xpath");
					Thread.sleep(30000);
					isNextButtonDisplayed = !CommonHelper.isElementHiddenNow("(//span[text()='Next'])[2]");
				}
				Thread.sleep(2000);
				numOfProducts += productLink;

			} while (isNextButtonDisplayed);

			if (counter != 0) {
				test.log(LogStatus.INFO, "Count product");
				Log.info("Count product");
				System.out.println("Count product");
				CommonHelper.elementToBeVisible("productLinkCount_css");
				CommonHelper.elementToBeClickable("productLinkCount_css");
				productLink = driver.findElements(By.cssSelector("a[class='product-item-link']")).size();
				productLinkText = Integer.toString(productLink);
				numOfProducts += productLink;
				Thread.sleep(2000);
			}

			String searchCount = CommonHelper.element("productTextCount_xpath").getText();
			int count = Integer.parseInt(searchCount);
			if (count == numOfProducts) {
				System.out.println(
						"No. of Product Link is: " + numOfProducts + " \n " + ", Search Result is: " + searchCount);
				test.log(LogStatus.INFO,
						"No. of Product Link is: " + numOfProducts + " \n " + ", Search Result is: " + searchCount);
				test.log(LogStatus.PASS, "The search count was successful");

				return true;
			} else {
				System.out.println("The search count was unsuccessful");
				CommonHelper.reportFailure("The search count was unsuccessful");

			}
			return false;

		} catch (Exception e) {
			CommonHelper.reportFailure("The search count was unsuccessful");
			e.printStackTrace();
			Assert.fail(e.getMessage());
		}
		return false;

	}

	public void selectMaxItems() {

		try {

			test.log(LogStatus.INFO, "Select 100 items");
			Log.info("Select 100 items");
			System.out.println("Select 100 items");
			Thread.sleep(1000);
			CommonHelper.scrolltoview("showItem_xpath");
			selectDpdwnValue("showItem_xpath", "100");
			Thread.sleep(10000);

		} catch (Exception e) {
			CommonHelper.reportFailure("Select max items was unsuccessful");
			e.printStackTrace();
			Assert.fail(e.getMessage());
		}

	}

	public void checkWithdrawnStatus() {

		try {

			List<WebElement> prodStatus = driver
					.findElements(By.xpath("//img[@alt='live logo View']/following-sibling::span"));

			for (int j = 0; j < prodStatus.size(); j++) {
				String prodStatusText = prodStatus.get(j).getText();

				if (prodStatusText.contains("Withdrawn")) {
					System.out.println("The search list contains Withdrawn status");
					test.log(LogStatus.FAIL, "The search list contains Withdrawn status");
					break;

				} else {
					System.out.println("The status of the product is: " + prodStatusText);
					test.log(LogStatus.INFO, "The status of the product is: " + prodStatusText);
					test.log(LogStatus.PASS, "The search list does not contain Withdrawn status");
				}
			}

		} catch (Exception e) {
			CommonHelper.reportFailure("Select max items was unsuccessful");
			e.printStackTrace();
			Assert.fail(e.getMessage());
		}

	}

	public boolean productTypeSorting() {

		try {

			/*
			 * WebDriverWait wait = new WebDriverWait(driver, 60);
			 * wait.until(ExpectedConditions
			 * .visibilityOfAllElements(driver.findElements(By.xpath(
			 * "//div[@class='category_div']/img"))));
			 */
			List<WebElement> imgLabels = driver.findElements(By.xpath("//div[@class='category_div']/img"));

			// CommonHelper.scrolltoview("imgLabelsProductType_xpath");

			ArrayList<String> obtainedList = new ArrayList<String>();
			for (int i = 0; i < imgLabels.size(); i++) {
				String altValue = imgLabels.get(i).getAttribute("alt");
				obtainedList.add(altValue);
			}
			ArrayList<String> sortedList = new ArrayList<String>();
			for (String s : obtainedList) {
				sortedList.add(s);
			}
			Collections.sort(sortedList, Collections.reverseOrder());
			if (sortedList.equals(obtainedList)) {
				System.out.println("Sorting of Product Type in descending order is successful");
				test.log(LogStatus.PASS, "Sorting of Product Type in descending order is successful");
				return true;

			} else {
				System.out.println("Sorting of Product Type in descending order is unsuccessful");
				test.log(LogStatus.FAIL, "Sorting of Product Type in descending order is unsuccessful");
				CommonHelper.reportFailure("Sorting of Product Type in descending order is unsuccessful");
				return false;
			}
		} catch (Exception e) {
			CommonHelper.reportFailure("Sorting of Product Type in descending order is unsuccessful");
			e.printStackTrace();
			return false;
		}

	}

	public void publishedDateSorting() throws Exception {
		Date d1 = null;

		try {
			WebDriverWait wait = new WebDriverWait(driver, 60);
			wait.until(ExpectedConditions.visibilityOfAllElements(
					driver.findElements(By.xpath("//div[contains(@class,'search_price_layout')]//div[1]/div[2]"))));
			List<WebElement> statusDate = driver
					.findElements(By.xpath("//div[contains(@class,'search_price_layout')]//div[1]/div[2]"));
			// System.out.println("The status and date is: " + statusDate);

			ArrayList<Date> obtainedList = new ArrayList<Date>();
			ArrayList<Date> sortedList = new ArrayList<Date>();

			for (int i = 0; i < statusDate.size(); i++) {
				String dateText = statusDate.get(i).getText();
				// System.out.println("The status and date is: " + dateText );
				int paraStartIndex = dateText.indexOf("(");
				int start = paraStartIndex + 1;
				int paraEndIndex = dateText.indexOf(")");
				String date = dateText.substring(start, paraEndIndex);
				// String replacedText = dateText.replace("(", "").replace(")", "");
				// String[] splitStrng = replacedText.split(" ", 2);
				// String justDate = splitStrng[splitStrng.length - 1];
				System.out.println("The date is: " + date);
				d1 = new Date(date);
				obtainedList.add(d1);
				System.out.println("The obtained list is: " + obtainedList);

			}
			for (Date d : obtainedList) {
				sortedList.add(d);
			}

			Collections.sort(sortedList, Collections.reverseOrder());
			System.out.println("The sorted list is: " + sortedList);
			test.log(LogStatus.INFO, "The sorted list is: " + sortedList);

			if (sortedList.equals(obtainedList)) {
				test.log(LogStatus.PASS, "Sorting of Published Date in descending order is successful");
				System.out.println("Sorting of Published Date in descending order is successful");
			} else
				test.log(LogStatus.FAIL, "Sorting list of products with Published Date was unsuccessful");
			System.out.println("Sorting list of products with Published Date was unsuccessful");

		} catch (Exception e) {
			CommonHelper.reportFailure("Sorting list of products with Published Date was unsuccessful");
			e.printStackTrace();
			Assert.fail(e.getMessage());
		}

	}

	public void pagination() throws Exception {

		WebElement next = driver.findElement(By.xpath("(//span[text()='Next'])[2]"));
		if (next.isDisplayed() || next.isEnabled()) {
			System.out.println("pagination exists");
			next.click();
		} else {
			System.out.println("pagination not exists");
		}

	}

	public void checkSortingByProductType() {

		boolean isNextButtonDisplayed = false;
		int counter = 0;

		try {
			// isNextButtonDisplayed = CommonHelper.isVisisble("next_xpath");
			driver.findElement(By.xpath("(//span[text()='Next'])[2]")).isDisplayed();
			isNextButtonDisplayed = true;
		} catch (Exception e) {
			isNextButtonDisplayed = false;
			e.printStackTrace();
		}
		try {

			do {
				test.log(LogStatus.INFO, "Select Sort By Product Type");
				System.out.println("Select Sort By Product Type");
				Log.info("Select Sort By Product Type");
				selectSortByProductType();
				test.log(LogStatus.INFO, "Sort List of Products in Descending Order");
				System.out.println("Sort List of Products in Descending Order");
				Log.info("Sort List of Products in Descending Order");
				productTypeSorting();

				if (isNextButtonDisplayed) {
					counter = 1;
					CommonHelper.elementToBeVisible("next_xpath");
					CommonHelper.scrolltoview("next_xpath");
					test.log(LogStatus.INFO, "Click on Next");
					System.out.println("Click on Next");
					Log.info("Click on Next");
					driver.findElement(By.xpath("(//span[text()='Next'])[2]")).click();
					try {
						// isNextButtonDisplayed =
						// CommonHelper.isVisisble("next_xpath");
						driver.findElement(By.xpath("(//span[text()='Next'])[2]")).isDisplayed();
						isNextButtonDisplayed = true;
					} catch (Exception e) {
						isNextButtonDisplayed = false;
						e.printStackTrace();
					}

				}
			} while (isNextButtonDisplayed);

			Thread.sleep(1000);
			if (counter != 0) {
				Thread.sleep(2000);
				test.log(LogStatus.INFO, "Select Sort By Product Type");
				System.out.println("Select Sort By Product Type");
				Log.info("Select Sort By Product Type");
				selectSortByProductType();
				test.log(LogStatus.INFO, "Sort List of Products in Descending Order");
				System.out.println("Sort List of Products in Descending Order");
				Log.info("Sort List of Products in Descending Order");
				productTypeSorting();
				CommonHelper.scrolltoview("paginationLastPageProductType_xpath");
			}

		} catch (Exception e) {
			CommonHelper.reportFailure("Sorting list of products with Label Type was unsuccessful");
			e.printStackTrace();
			Assert.fail(e.getMessage());
		}

	}

	public void checkSortingByPublishedDate() {

		boolean isNextButtonDisplayed = false;
		int counter = 1;

		try {
			// isNextButtonDisplayed = CommonHelper.isElementHiddenNow("next_xpath");
			driver.findElement(By.xpath("(//span[text()='Next'])[2]")).isDisplayed();
			isNextButtonDisplayed = true;
		} catch (Exception e) {
			isNextButtonDisplayed = false;
			e.printStackTrace();
		}
		try {

			do {
				selectMaxItems();
				Thread.sleep(5000);
				test.log(LogStatus.INFO, "Select Sort By Published Date");
				System.out.println("Select Sort By Published Date");
				Log.info("Select Sort By Published Date");
				selectSortByPublishedDate();
				Thread.sleep(5000);
				test.log(LogStatus.INFO, "Sort List of Products in Descending Order");
				System.out.println("Sort List of Products in Descending Order");
				Log.info("Sort List of Products in Descending Order");
				publishedDateSorting();

				if (isNextButtonDisplayed) {
					CommonHelper.elementToBeVisible("next_xpath");
					CommonHelper.scrolltoview("next_xpath");
					test.log(LogStatus.INFO, "Click on Next" + "The current page is: " + counter++);
					System.out.println("Click on Next");
					Log.info("Click on Next");
					driver.findElement(By.xpath("(//span[text()='Next'])[2]")).click();
					Thread.sleep(20000);
					try {
						// isNextButtonDisplayed = CommonHelper.isElementHiddenNow("next_xpath");
						driver.findElement(By.xpath("(//span[text()='Next'])[2]")).isDisplayed();
						isNextButtonDisplayed = true;
					} catch (Exception e) {
						isNextButtonDisplayed = false;
						e.printStackTrace();
					}

				} else {
					System.out.println("The date field is missing");
					test.log(LogStatus.FAIL, "The date field is missing");
				}
				Thread.sleep(2000);
			} while (isNextButtonDisplayed);

			if (counter != 0) {
				test.log(LogStatus.INFO, "Select Sort By Published Date");
				System.out.println("Select Sort By Published Date");
				Log.info("Select Sort By Published Date");
				selectSortByPublishedDate();
				test.log(LogStatus.INFO, "The current page is: " + counter++);
				test.log(LogStatus.INFO, "Sort List of Products in Descending Order");
				System.out.println("Sort List of Products in Descending Order");
				Log.info("Sort List of Products in Descending Order");
				publishedDateSorting();
			} else {
				System.out.println("The date field is missing");
				test.log(LogStatus.FAIL, "The date field is missing");
			}

		} catch (Exception e) {
			CommonHelper.reportFailure("Sorting list of products with Published Date was unsuccessful");
			e.printStackTrace();
			Assert.fail(e.getMessage());
		}

	}

	public void selectSortByProductType() throws Exception {

		Select dropdown = new Select(driver.findElement(By.xpath("(//select[@id='sorter'])[1]")));
		dropdown.selectByVisibleText("Product Type");

	}

	public void selectSortByPublishedDate() throws Exception {

		Select dropdown = new Select(driver.findElement(By.xpath("(//select[@id='sorter'])[1]")));
		dropdown.selectByVisibleText("Published Date");

	}

	public void checkFreeEventName() {
		boolean freeEvent = false;
		String prodName = "Sustainability Performance and Reporting Event";

		try {
			System.out.println("Check Free Event Name");
			test.log(LogStatus.INFO, "Check Free Event Name");
			freeEvent = CommonHelper.element("productLinkCount_css").isDisplayed();
			if (freeEvent) {
				String freeEventText = CommonHelper.element("productLinkCount_css").getText();
				if (freeEventText.equals(prodName)) {
					System.out.println("Free Event Name is: " + freeEventText);
					test.log(LogStatus.INFO, "Free Event Name is: " + freeEventText);
					test.log(LogStatus.PASS, "Free Event Name match is successful");
				} else {
					System.out.println("Free Event Name match is unsuccessful");
					test.log(LogStatus.FAIL, "Free Event Name match is unsuccessful");
				}
			} else {
				CommonHelper.reportFailure("Free Event Name match is unsuccessful");
			}

		} catch (Exception e) {
			CommonHelper.reportFailure("Free Event Name match is unsuccessful");
			e.printStackTrace();
			Assert.fail(e.getMessage());
		}
	}

	public void checkFreeEventPrice() {
		boolean freeEvent = false;
		String productPrice = "Free";

		try {
			System.out.println("Check Free Event Price");
			test.log(LogStatus.INFO, "Check Free Event Price");
			freeEvent = CommonHelper.element("freeProductLabel_css").isDisplayed();
			if (freeEvent) {
				String freeEventText = CommonHelper.element("freeProductLabel_css").getText();
				if (freeEventText.equals(productPrice)) {
					System.out.println("Free Event Price is: " + freeEventText);
					test.log(LogStatus.INFO, "Free Event Price is: " + freeEventText);
					test.log(LogStatus.PASS, "Free Event Price match is successful");
				} else {
					System.out.println("Free Event Price match is unsuccessful");
					test.log(LogStatus.FAIL, "Free Event Price match is unsuccessful");
				}
			} else {
				CommonHelper.reportFailure("Free Event Price match is unsuccessful");
			}

		} catch (Exception e) {
			CommonHelper.reportFailure("Free Event Price match is unsuccessful");
			e.printStackTrace();
			Assert.fail(e.getMessage());
		}
	}

	public void checkEventButton() {
		boolean freeEvent = false;
		String productPrice = "Find Out More";

		try {
			System.out.println("Check Event Action Button");
			test.log(LogStatus.INFO, "Check Event Action Button");
			freeEvent = CommonHelper.element("eventActionButton_css").isDisplayed();
			if (freeEvent) {
				String freeEventText = CommonHelper.element("eventActionButton_css").getText();
				if (freeEventText.equals(productPrice)) {
					System.out.println("Event Action Button is: " + freeEventText);
					test.log(LogStatus.INFO, "Event Action Button is: " + freeEventText);
					test.log(LogStatus.PASS, "Event Action Button match is successful");
				} else {
					System.out.println("Event Action Button match is unsuccessful");
					test.log(LogStatus.FAIL, "Event Action Button match is unsuccessful");
				}

			} else {
				CommonHelper.reportFailure("Event Action Button match is unsuccessful");
			}
		} catch (Exception e) {
			CommonHelper.reportFailure("Event Action Button match is unsuccessful");
			e.printStackTrace();
			Assert.fail(e.getMessage());
		}
	}

	public void checkEventLabel() {
		boolean freeEvent = false;
		String productPrice = "Event";

		try {
			Thread.sleep(2000);
			System.out.println("Check Event Label");
			test.log(LogStatus.INFO, "Check Event Label");
			freeEvent = CommonHelper.element("eventLabel_xpath").isDisplayed();

			if (freeEvent) {
				Thread.sleep(2000);
				WebElement imgLabel = CommonHelper.element("eventLabel_xpath");
				String altValue = imgLabel.getAttribute("alt").replace("Events Category", "Event");

				if (altValue.equals(productPrice)) {
					System.out.println("Event Label is: " + altValue);
					test.log(LogStatus.INFO, "Event Label is: " + altValue);
					test.log(LogStatus.PASS, "Event Label match is successful");
				} else {
					System.out.println("Event Label match is unsuccessful " + altValue);
					test.log(LogStatus.FAIL, "Event Label match is unsuccessful " + altValue);
				}
			} else {
				CommonHelper.reportFailure("Event Label match is unsuccessful");
			}

		} catch (Exception e) {
			CommonHelper.reportFailure("Event Label match is unsuccessful");
			e.printStackTrace();
			Assert.fail(e.getMessage());
		}
	}

	public void checkPASProductName() {
		boolean PAS = false;
		// String prodName = "PAS 1192-3:2014";

		try {
			System.out.println("Check PAS Product Name");
			test.log(LogStatus.INFO, "Check PAS Product Name");
			Thread.sleep(2000);
			PAS = driver.findElement(By.cssSelector("a[class='product-item-link']")).isDisplayed();
			// PAS = CommonHelper.element("productLinkCount_css").isDisplayed();
			if (PAS) {
				Thread.sleep(3000);
				String prodName = CommonHelper.element("productLinkCount_css").getText();
				if (prodName.contains("PAS") || prodName.contains("Pas")) {
					System.out.println("PAS Product Name is: " + prodName);
					test.log(LogStatus.INFO, "PAS Product Name is: " + prodName);
					test.log(LogStatus.PASS, "PAS Product Name match is successful");
				} else {
					System.out.println("PAS Product Name match is unsuccessful" + prodName);
					test.log(LogStatus.FAIL, "PAS Product Name match is unsuccessful" + prodName);
				}
			} else {
				CommonHelper.reportFailure("PAS Product Name match is unsuccessful");
			}

		} catch (Exception e) {
			CommonHelper.reportFailure("PAS Product Name match is unsuccessful");
			e.printStackTrace();
			Assert.fail(e.getMessage());
		}
	}

	public void checkPASProductPrice() {
		boolean PAS = false;
		// String productPrice = "£53.00";

		try {
			System.out.println("Check PAS Product Price");
			test.log(LogStatus.INFO, "Check PAS Product Price");
			PAS = CommonHelper.element("stdProductPrice_css").isDisplayed();
			if (PAS) {
				String eventPrice = CommonHelper.element("stdProductPrice_css").getText();
				if (eventPrice != null) {
					System.out.println("PAS Product Price is: " + eventPrice);
					test.log(LogStatus.INFO, "PAS Product Price is: " + eventPrice);
					test.log(LogStatus.PASS, "PAS Product Price match is successful");
				} else {
					System.out.println("PAS Product Price match is unsuccessful");
					test.log(LogStatus.FAIL, "PAS Product Price match is unsuccessful");
				}
			} else {
				CommonHelper.reportFailure("PAS Product Price match is unsuccessful");
			}

		} catch (Exception e) {
			CommonHelper.reportFailure("PAS Product Price match is unsuccessful");
			e.printStackTrace();
			Assert.fail(e.getMessage());
		}
	}

	public void checkPASProductButton() {
		boolean PAS = false;
		String PASButtonText = "Add to Basket";

		try {
			System.out.println("Check PAS Product Action Button");
			test.log(LogStatus.INFO, "Check PAS Product Action Button");
			PAS = CommonHelper.element("stdActionButton_css").isDisplayed();
			if (PAS) {
				String PASText = CommonHelper.element("stdActionButton_css").getText();
				if (PASText.contains(PASButtonText)) {
					System.out.println("PAS Product Action Button is: " + PASText);
					test.log(LogStatus.INFO, "PAS Product Action Button is: " + PASText);
					test.log(LogStatus.PASS, "PAS Product Action Button match is successful");
				} else {
					System.out.println("PAS Product Action Button match is unsuccessful");
					test.log(LogStatus.FAIL, "PAS Product Action Button match is unsuccessful");
				}

			} else {
				CommonHelper.reportFailure("PAS Product Action Button match is unsuccessful");
			}
		} catch (Exception e) {
			CommonHelper.reportFailure("PAS Product Action Button match is unsuccessful");
			e.printStackTrace();
			Assert.fail(e.getMessage());
		}
	}

	public void checkPASProductLabel() {
		boolean PAS = false;
		// String productLabel = "PAS";

		try {
			Thread.sleep(2000);
			System.out.println("Check PAS Product Label");
			test.log(LogStatus.INFO, "Check PAS Product Label");
			PAS = CommonHelper.element("eventLabel_xpath").isDisplayed();

			if (PAS) {
				WebElement imgLabel = CommonHelper.element("eventLabel_xpath");
				String altValue = imgLabel.getAttribute("alt").replace("PAS Category", "PAS");
				Thread.sleep(2000);
				if (altValue.contains("Standard")) {
					System.out.println("PAS Product Label is: " + altValue);
					test.log(LogStatus.INFO, "PAS Product Label is: " + altValue);
					test.log(LogStatus.PASS, "PAS Product Label match is successful");
				} else {
					System.out.println("PAS Product Label match is unsuccessful " + altValue);
					test.log(LogStatus.FAIL, "PAS Product Label match is unsuccessful " + altValue);
				}
			} else {
				CommonHelper.reportFailure("PAS Product Label match is unsuccessful");
			}

		} catch (Exception e) {
			CommonHelper.reportFailure("PAS Product Label match is unsuccessful");
			e.printStackTrace();
			Assert.fail(e.getMessage());
		}
	}

	public void checkPaidEventName() {
		boolean paidEvent = false;
		String prodName = "Fire Safety Conference";

		try {
			Thread.sleep(2000);
			System.out.println("Check Paid Event Name");
			test.log(LogStatus.INFO, "Check Paid Event Name");
			paidEvent = CommonHelper.element("productLinkCount_css").isDisplayed();
			if (paidEvent) {
				Thread.sleep(5000);
				String paidEventText = CommonHelper.element("productLinkCount_css").getText();
				if (paidEventText.equals(prodName)) {
					System.out.println("Paid Event Name is: " + paidEventText);
					test.log(LogStatus.INFO, "Paid Event Name is: " + paidEventText);
					test.log(LogStatus.PASS, "Paid Event Name match is successful");
				} else {
					System.out.println("Paid Event Name match is unsuccessful");
					test.log(LogStatus.INFO, "Paid Event Name is: " + paidEventText);
					test.log(LogStatus.FAIL, "Paid Event Name match is unsuccessful");
				}
			} else {
				CommonHelper.reportFailure("Paid Event Name match is unsuccessful");
			}

		} catch (Exception e) {
			CommonHelper.reportFailure("Paid Event Name match is unsuccessful");
			e.printStackTrace();
			Assert.fail(e.getMessage());
		}
	}

	public void checkPaidEventPrice() {
		boolean paidEvent = false;
		String eventPrice = "£800.00";

		try {
			Thread.sleep(2000);
			System.out.println("Check Paid Event Price");
			test.log(LogStatus.INFO, "Check Paid Event Price");
			paidEvent = CommonHelper.element("eventPrice_css").isDisplayed();
			if (paidEvent) {
				Thread.sleep(2000);
				String paidEventText = CommonHelper.element("eventPrice_css").getText();
				Thread.sleep(2000);
				if (paidEventText.equals(eventPrice)) {
					System.out.println("Paid Event Price is: " + paidEventText);
					test.log(LogStatus.INFO, "Paid Event Price is: " + paidEventText);
					test.log(LogStatus.PASS, "Paid Event Price match is successful");
				} else {
					System.out.println("Paid Event Price match is unsuccessful");
					test.log(LogStatus.FAIL, "Paid Event Price match is unsuccessful");
				}
			} else {
				CommonHelper.reportFailure("Paid Event Price match is unsuccessful");
			}

		} catch (Exception e) {
			CommonHelper.reportFailure("Paid Event Price match is unsuccessful");
			e.printStackTrace();
			Assert.fail(e.getMessage());
		}
	}

	public void checkPaidEventMemberPrice() {
		boolean paidEvent = false;
		String eventMemberPrice = "Members' Price £400.00";

		try {
			System.out.println("Check Paid Event Member Price");
			test.log(LogStatus.INFO, "Check Paid Event Member Price");
			paidEvent = CommonHelper.element("eventMemberPrice_css").isDisplayed();
			if (paidEvent) {
				String paidEventText = CommonHelper.element("eventMemberPrice_css").getText();
				if (paidEventText.equals(eventMemberPrice)) {
					System.out.println("Paid Event Member Price is: " + paidEventText);
					test.log(LogStatus.INFO, "Paid Event Member Price is: " + paidEventText);
					test.log(LogStatus.PASS, "Paid Event Member Price match is successful");
				} else {
					System.out.println("Paid Event Member Price match is unsuccessful");
					test.log(LogStatus.FAIL, "Paid Event Member Price match is unsuccessful");
				}
			} else {
				CommonHelper.reportFailure("Paid Event Member Price match is unsuccessful");
			}

		} catch (Exception e) {
			CommonHelper.reportFailure("Paid Event Member Price match is unsuccessful");
			e.printStackTrace();
			Assert.fail(e.getMessage());
		}
	}

	public void verifySearchResultforBlankSearch() {

		try {

			test.log(LogStatus.INFO, "Verify blank search result");
			Log.info("Verify blank search result");
			System.out.println("Verify blank search result");
			Thread.sleep(1000);
			// CommonHelper.elementToBeClickable("blankSearchResult_xpath");
			boolean res = CommonHelper.isElementVisible("blankSearchResult_xpath");

			if (res) {
				String result = CommonHelper.element("blankSearchResult_xpath").getText();
				if (result.contains("Results")) {

					System.out.println("The List of Products on first page");
					test.log(LogStatus.INFO, "The List of Products on first page");

					List<WebElement> productName = driver.findElements(By.cssSelector("a[class='product-item-link']"));

					for (int i = 0; i < productName.size(); i++) {
						String prodNameText = productName.get(i).getText();
						System.out.println("The Product Name is: " + prodNameText);
						test.log(LogStatus.INFO, "The Product Name is: " + prodNameText);
					}
					System.out.println("The result of Blank Search is: " + result);
					test.log(LogStatus.INFO, "The result of Blank Search is: " + result);
					test.log(LogStatus.PASS, "Blank search was successful");
				}
			} else {
				System.out.println("Blank search was unsuccessful");
				test.log(LogStatus.FAIL, "Blank search was unsuccessful");
			}

		} catch (Exception e) {
			CommonHelper.reportFailure("Blank search was unsuccessful");
			e.printStackTrace();
			Assert.fail(e.getMessage());
		}

	}

	public void clickAddToBasket() {

		try {
			Thread.sleep(3000);
			test.log(LogStatus.INFO, "Click on Add to Basket");
			Log.info("Click on Add to Basket");
			System.out.println("Click on Add to Basket");
			CommonHelper.elementToBeClickable("addToBasket_css");
			WebElement addToBasket = driver.findElements(By.cssSelector("button[title='Add to Basket']")).get(1);
			addToBasket.click();
			Thread.sleep(2000);

		} catch (Exception e) {
			CommonHelper.reportFailure("Click on Add to Basket was unsuccessful");
			e.printStackTrace();
			Assert.fail(e.getMessage());
		}

	}

	public void addSamePDFTwiceToBasket() {

		try {
			Thread.sleep(3000);
			test.log(LogStatus.INFO, "Click on Add to Basket");
			Log.info("Click on Add to Basket");
			System.out.println("Click on Add to Basket");
			CommonHelper.elementToBeClickable("addToBasket_css");
			WebElement addToBasket = driver.findElements(By.cssSelector("button[title='Add to Basket']")).get(1);
			addToBasket.click();
			Thread.sleep(2000);

			System.out.println("");
			List<WebElement> okButtons = driver.findElements(By.xpath("//button[text()='Ok']"));
			for (WebElement okButton : okButtons) {
				try {
					if (okButton.isDisplayed()) {
						okButton.click();
					}
				} catch (Exception e) {
					CommonHelper.reportFailure("Click OK was unsuccessful");
					e.printStackTrace();
					Assert.fail(e.getMessage());
				}
			}

		} catch (Exception e) {
			CommonHelper.reportFailure("Add Second PDF product to Basket was unsuccessful");
			e.printStackTrace();
			Assert.fail(e.getMessage());
		}

	}

	public void clickAddToBasketAgain() {

		try {
			Thread.sleep(3000);
			test.log(LogStatus.INFO, "Add Second PDF product to Basket");
			Log.info("Add Second PDF product to Basket");
			System.out.println("Add Second PDF product to Basket");
			WebElement addToBasket = driver.findElements(By.cssSelector("button[title='Add to Basket']")).get(2);
			CommonHelper.elementToBeClickable("addToBasket_css");
			addToBasket.click();
			Thread.sleep(2000);

		} catch (Exception e) {
			CommonHelper.reportFailure("Add Second PDF product to Basket was unsuccessful");
			e.printStackTrace();
			Assert.fail(e.getMessage());
		}

	}

	public void selectFormat() {

		try {
			Thread.sleep(2000);
			test.log(LogStatus.INFO, "Select PDF Format");
			Log.info("Select PDF Format");
			System.out.println("Select PDF Format");
			click("selectFormat_xpath");
			Thread.sleep(5000);

		} catch (Exception e) {
			CommonHelper.reportFailure("Select Format was unsuccessful");
			e.printStackTrace();
			Assert.fail(e.getMessage());
		}

	}

	public void selectFormatClickOK() throws InterruptedException {

		// boolean productAddedTwiceAlert = false;

		System.out.println("");
		List<WebElement> okButtons = driver.findElements(By.xpath("//button[text()='Ok']"));
		for (WebElement okButton : okButtons) {
			try {
				if (okButton.isDisplayed()) {
					okButton.click();
				}
			} catch (Exception e) {
				CommonHelper.reportFailure("Click OK for Selecting Format was unsuccessful");
				e.printStackTrace();
				Assert.fail(e.getMessage());
			}
		}

		Thread.sleep(3000);
		List<WebElement> productAddedTwiceAlerts = driver.findElements(By.xpath("//button[text()='Ok']"));
		for (WebElement productAddedTwiceAlertbutton : productAddedTwiceAlerts) {
			try {
				if (productAddedTwiceAlertbutton.isDisplayed()) {
					productAddedTwiceAlertbutton.click();
				}
			} catch (Exception e) {
				CommonHelper.reportFailure("Adding of the same product in same format was unsuccessful");
				e.printStackTrace();
				Assert.fail(e.getMessage());
			}
		}

		Thread.sleep(2000);
		List<WebElement> productAddedDiffFormatAlerts = driver
				.findElements(By.xpath("//button[text()='Yes, proceed']"));
		for (WebElement productAddedDiffFormatAlertsbutton : productAddedDiffFormatAlerts) {
			try {
				if (productAddedDiffFormatAlertsbutton.isDisplayed()
						&& productAddedDiffFormatAlertsbutton.isEnabled()) {
					productAddedDiffFormatAlertsbutton.click();
				}
			} catch (Exception e) {
				CommonHelper.reportFailure("Adding of product in diffrent format was unsuccessful");
				e.printStackTrace();
				Assert.fail(e.getMessage());
			}
		}

	}

	public void selectFormatPDFTwiceByClickOK() throws InterruptedException {

		System.out.println("Select the PDF Format twice by clicking OK");
		test.log(LogStatus.INFO, "Select the PDF Format twice by clicking OK");
		Log.info("Select the PDF Format twice by clicking OK");
		List<WebElement> okButtons = driver.findElements(By.xpath("//button[text()='Ok']"));
		for (WebElement okButton : okButtons) {
			try {
				if (okButton.isDisplayed()) {
					okButton.click();
				}
			} catch (Exception e) {
				CommonHelper.reportFailure("Select the same Format twice by clicking OK was unsuccessful");
				e.printStackTrace();
				Assert.fail(e.getMessage());
			}
		}

	}

	public void selectHardCopyFormat() {

		test.log(LogStatus.INFO, "Select HardCopy Format");
		Log.info("Select HardCopy Format");
		System.out.println("Select HardCopy Format");
		List<WebElement> hardcopys = driver.findElements(By.cssSelector("select[id*='sel']"));
		for (WebElement hardcopy : hardcopys) {
			try {
				if (hardcopy.isDisplayed()) {
					Select dpdwn = new Select(hardcopy);
					dpdwn.selectByVisibleText("Hard copy");

				}
			} catch (Exception e) {
				CommonHelper.reportFailure("Select Hardcopy Format was unsuccessful");
				e.printStackTrace();
				Assert.fail(e.getMessage());

			}
		}
	}

	public void viewBasket() {

		try {
			Thread.sleep(12000);
			System.out.println("Click on View Basket");
			test.log(LogStatus.INFO, "Click on View Basket ");
			Log.info("Click on View Basket");
			CommonHelper.elementToBeClickable("viewBasket_xpath");
			click("viewBasket_xpath");
			// driver.findElement(By.xpath("//*[@id='basket']/div/a/span[1]")).click();

			Thread.sleep(3000);
			List<WebElement> okButtons = driver.findElements(By.xpath("//button[text()='Okay']"));
			for (WebElement okButton : okButtons) {
				try {
					if (okButton.isDisplayed()) {
						okButton.click();
						System.out.println("Click OK for List of Conflict Error");
						test.log(LogStatus.INFO, "Click OK for List of Conflict Error");
					}
				} catch (Exception e) {
					CommonHelper.reportFailure("Click Okay was unsuccessful");
					e.printStackTrace();
					Assert.fail(e.getMessage());
				}
			}

			Thread.sleep(2000);
			List<WebElement> okButtonsAgain = driver.findElements(By.xpath("//button[text()='Okay']"));
			for (WebElement okButton : okButtonsAgain) {
				try {
					if (okButton.isDisplayed()) {
						okButton.click();
						System.out.println("Click OK for List of Conflict Error");
						test.log(LogStatus.INFO, "Click OK for List of Conflict Error");
					}
				} catch (Exception e) {
					CommonHelper.reportFailure("Click Okay was unsuccessful");
					e.printStackTrace();
					Assert.fail(e.getMessage());
				}
			}

		} catch (InterruptedException e) {
			e.printStackTrace();
			CommonHelper.reportFailure("Click on View Basket was unsuccessful");
			Assert.fail(e.getMessage());
		}

	}

	@SuppressWarnings("null")
	public void checkWarningMsg() {
		try {
			Thread.sleep(2000);
			test.log(LogStatus.INFO, "Checking warning message");
			CommonHelper.elementToBeVisible("pdfAlertText_id");
			String msg = CommonHelper.element("pdfAlertText_id").getText();
			if (msg != null || msg.contains(
					"The item you are trying to add is already in your basket. Because of copyright, you can't add this product a second time in PDF format.")) {
				test.log(LogStatus.INFO, "Warning message is: " + msg);

				Thread.sleep(1000);
				driver.findElement(By.cssSelector("button[class='btn btn-default warning_submit']")).click();
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

	public String verifyMemPriceSearchList() throws InterruptedException {

		// double finalMemPrice = 0;
		// double finalPrice = 0;

		String memPrice = null;

		try {
			Thread.sleep(2000);
			WebElement priceList = driver.findElements(By.cssSelector("span[id*='product-price']")).get(1);
			// WebElement memPriceList =
			// driver.findElements(By.cssSelector("span[class='price']")).get(1);
			WebElement memPriceList = driver.findElement(
					By.xpath("//*[@id='search_results_display']/li[2]/div[1]/div/div[2]/div[1]/span[2]/span/span[1]"));
			String price = priceList.getText();
			memPrice = memPriceList.getText();

			// price = price.substring(1);
			// memPrice = memPrice.substring(1);
			System.out.println("The price of the second product in the search list is: " + price
					+ " & The member price of the second product in the search list is: " + memPrice);
			test.log(LogStatus.PASS, "The price of the second product in the search list is: " + price
					+ " & The member price of the second product in the search list is: " + memPrice);

			/*
			 * finalPrice = Double.parseDouble(price); finalMemPrice
			 * =Double.parseDouble(memPrice); double memberPrice = finalPrice / 2;
			 */

			/*
			 * Thread.sleep(2000); if (finalMemPrice == memberPrice ) {
			 * System.out.println("The price of the first product in the search list is: " +
			 * finalPrice +
			 * " & The member price of the first product in the search list is: " +
			 * finalMemPrice); test.log(LogStatus.PASS,
			 * "The price of the first product in the search list is: " + finalPrice +
			 * " & The member price of the first product in the search list is: " +
			 * finalMemPrice); return true; } else {
			 * System.out.println("The member price in the search list is incorrect");
			 * test.log(LogStatus.FAIL,
			 * "The price of the first product in the search list is: " + finalPrice +
			 * " & The member price of the first product in the search list is: " +
			 * finalMemPrice); } return false;
			 */

		} catch (NumberFormatException e) {
			CommonHelper.reportFailure("The member price in the search list is incorrect");
			e.printStackTrace();
		}

		return memPrice;
		// return finalPrice;
	}

	public void clickProductOnSearchList() {

		// Log.info("Check Visibility for Member Price");
		// System.out.println("Check Visibility for Member Price");
		boolean memLink = CommonHelper
				.checkVisibility(By.xpath("//*[@id='search_results_display']/li[1]/div[1]/div/div[2]/div[1]/span[2]"));

		if (memLink) {
			try {

				test.log(LogStatus.INFO, ("Click product on the Search List"));
				Log.info("Click product on the Search List");
				System.out.println("Click product on the Search List");
				CommonHelper.elementToBeVisible("productLinkCount_css");
				CommonHelper.elementToBeClickable("productLinkCount_css");
				driver.findElement(By.cssSelector("a[class='product-item-link']")).click();

			} catch (Exception e) {
				CommonHelper.reportFailure("Product search was unsuccessful");
				e.printStackTrace();
				Assert.fail(e.getMessage());
			}

		}

	}

	public String viewFirstProduct() {

		String prodName = null;
		try {
			System.out.println("");
			test.log(LogStatus.INFO, ("Click product on the Search List"));
			Log.info("Click product on the Search List");
			System.out.println("Click product on the Search List");
			WebElement prod = driver.findElements(By.cssSelector("a[class='product-item-link']")).get(2);
			Thread.sleep(1000);
			String product = prod.getText();
			System.out.println("The product is: " + product);
			prod.click();

			prodName = driver.findElement(By.cssSelector("span[data-ui-id='page-title-wrapper']")).getText();
			System.out.println("The First Product is: " + prodName);
			test.log(LogStatus.PASS, "The First Product is: " + prodName);

		} catch (Exception e) {
			CommonHelper.reportFailure("The first product view was unsuccessful");
			e.printStackTrace();
		}
		return prodName;
	}

	public String viewSecondProduct() {
		String prodName = null;

		try {
			
			test.log(LogStatus.INFO, ("Click product on the Search List"));
			Log.info("Click product on the Search List");
			System.out.println("Click product on the Search List");
			WebElement prod = driver.findElements(By.cssSelector("a[class='product-item-link']")).get(4);
			Thread.sleep(1000);
			String product = prod.getText();
			System.out.println("The product is: " + product);
			prod.click();
			prodName = driver.findElement(By.cssSelector("span[data-ui-id='page-title-wrapper']")).getText();
			System.out.println("The Second Product is: " + prodName);
			test.log(LogStatus.PASS, "The Second Product is: " + prodName);

		} catch (Exception e) {
			CommonHelper.reportFailure("The Second product view was unsuccessful");
			e.printStackTrace();
		}
		return prodName;
	}

	public String viewThirdProduct() {
		String prodName = null;
		try {
			test.log(LogStatus.INFO, ("Click product on the Search List"));
			Log.info("Click product on the Search List");
			System.out.println("Click product on the Search List");
			driver.findElements(By.cssSelector("a[class='product-item-link']")).get(6).click();

			prodName = driver.findElement(By.cssSelector("span[data-ui-id='page-title-wrapper']")).getText();
			System.out.println("The Third Product is: " + prodName);
			test.log(LogStatus.PASS, "The Third Product is: " + prodName);

		} catch (Exception e) {
			CommonHelper.reportFailure("The Third product view was unsuccessful");
			e.printStackTrace();
		}
		return prodName;
	}

	public void viewFourthProduct() {

		try {
			test.log(LogStatus.INFO, ("Click product on the Search List"));
			Log.info("Click product on the Search List");
			System.out.println("Click product on the Search List");
			driver.findElements(By.cssSelector("a[class='product-item-link']")).get(8).click();

			String prodName = driver.findElement(By.cssSelector("span[data-ui-id='page-title-wrapper']")).getText();
			System.out.println("The Fourth Product is: " + prodName);
			test.log(LogStatus.PASS, "The Fourth Product is: " + prodName);

		} catch (Exception e) {
			CommonHelper.reportFailure("The Fourth product view was unsuccessful");
			e.printStackTrace();
		}

	}

	public void verifyRecentlyViewedProducts(String firstProd, String secProd, String ThirdProd) {

		try {
			Thread.sleep(2000);
			CommonHelper.scrolltoview("recentlyViewWidget_id");

			List<WebElement> recentlyViewedProducts = driver
					.findElements(By.xpath("//a[@class='product-item-link active']"));

			String firstRVProd = recentlyViewedProducts.get(0).getText();
			String secRVProd = recentlyViewedProducts.get(1).getText();
			String thirdRVProd = recentlyViewedProducts.get(2).getText();

			if (firstRVProd.equals(ThirdProd)) {
				System.out.println("Verification of Recently viewed for First product is successful");
				test.log(LogStatus.INFO, "The First Recently viewed product is: " + firstRVProd);
				test.log(LogStatus.PASS, "Verification of Recently viewed for First product is successful");
			} else {
				System.out.println("Verification of Recently viewed for First product is unsuccessful");
				test.log(LogStatus.INFO, "The First Recently viewed product is: " + firstRVProd);
				test.log(LogStatus.FAIL, "Verification of Recently viewed for First product is unsuccessful");
			}

			if (secRVProd.equals(secProd)) {
				System.out.println("Verification of Recently viewed for Second product is successful");
				test.log(LogStatus.INFO, "The Second Recently viewed product is: " + secRVProd);
				test.log(LogStatus.PASS, "Verification of Recently viewed for Second product is successful");
			} else {
				System.out.println("Verification of Recently viewed for Second product is unsuccessful");
				test.log(LogStatus.INFO, "The Second Recently viewed product is: " + secRVProd);
				test.log(LogStatus.FAIL, "Verification of Recently viewed for Second product is unsuccessful");
			}

			if (thirdRVProd.equals(firstProd)) {
				System.out.println("Verification of Recently viewed for Third product is successful");
				test.log(LogStatus.INFO, "The Third Recently viewed product is: " + thirdRVProd);
				test.log(LogStatus.PASS, "Verification of Recently viewed for Third product is successful");
				CommonHelper.takeScreenShot();
			} else {
				System.out.println("Verification of Recently viewed for Third product is unsuccessful");
				test.log(LogStatus.INFO, "The Third Recently viewed product is: " + thirdRVProd);
				test.log(LogStatus.FAIL, "Verification of Recently viewed for Third product is unsuccessful");
			}
		} catch (Exception e) {
			CommonHelper.reportFailure("Verification of Recently Viewed Products was unsuccessful");
			e.printStackTrace();
		}
	}

	public void withdrwanFilterSearch() {

		try {
			Thread.sleep(2000);
			CommonHelper.scrolltoview("resetFilter_linkText");
			test.log(LogStatus.INFO, ("Click Reset Filters"));
			Log.info("Click Reset Filters");
			System.out.println("Click Reset Filters");
			CommonHelper.elementToBeClickable("resetFilter_linkText");
			click("resetFilter_linkText");

			Thread.sleep(5000);
			CommonHelper.scrolltoview("filterStatus_id");
			test.log(LogStatus.INFO, ("Select Status"));
			Log.info("Select Status");
			System.out.println("Select Status");
			CommonHelper.elementToBeClickable("filterStatus_id");
			click("filterStatus_id");
			Thread.sleep(1000);

			test.log(LogStatus.INFO, ("Select Withdrawn"));
			Log.info("Select Withdrawn");
			System.out.println("Select Withdrawn");
			click("searchStatusWithdrawn_id");

			Thread.sleep(1000);
			// CommonHelper.scrolltoview("applySearchFilter_id");
			test.log(LogStatus.INFO, ("Click Apply Filter"));
			Log.info("Click Apply Filter");
			System.out.println("Click Apply Filter");
			click("applySearchFilter_id");

		} catch (Exception e) {
			CommonHelper.reportFailure("Select Filter with Withdrawn Status was unsuccessful");
			e.printStackTrace();
		}
	}

	public void verifyWithdrawnColorCode() {

		boolean isNextButtonDisplayed = false;
		int counter = 0;

		try { // isNextButtonDisplayed = CommonHelper.isVisisble("next_xpath");
			driver.findElement(By.xpath("(//span[text()='Next'])[2]")).isDisplayed();
			isNextButtonDisplayed = true;
		} catch (Exception e) {
			isNextButtonDisplayed = false;
			e.printStackTrace();
		}

		try {

			do {
				Thread.sleep(2000);
				test.log(LogStatus.INFO, ("Verify Withdrawn Status Color Code"));
				Log.info("Verify Withdrawn Status Color Code");
				System.out.println("Verify Withdrawn Status Color Code");
				List<WebElement> withdrawn = driver.findElements(By.cssSelector("span[class*='font14']"));

				for (int i = 0; i < withdrawn.size(); i++) {
					String withdrawnText = withdrawn.get(i).getText();
					System.out.println("The Status of the product is: " + withdrawnText);
					test.log(LogStatus.INFO, "The Status of the product is: " + withdrawnText);
					String withdrawnValue = withdrawn.get(i).getAttribute("class");
					System.out.println("The Withdrawn Value is: " + withdrawnValue);

					if (withdrawnText.equals("Withdrawn") && withdrawnValue.startsWith("status-green-colour")) {
						System.out
								.println("Verification of Color code for " + withdrawnText + " status was unsucessful");
						test.log(LogStatus.FAIL,
								"Verification of Color code for " + withdrawnText + " status was unsucessful");
						System.out.println("The Color Code is not Red ");
						test.log(LogStatus.INFO, "The Color Code is not Red ");
						// CommonHelper.takeScreenShot();
					} else {
						System.out.println("The Color Code is Red ");
						test.log(LogStatus.INFO, "The Color Code is Red ");
						System.out.println("Verification of Color code for " + withdrawnText + " status was sucessful");
						test.log(LogStatus.PASS,
								"Verification of Color code for " + withdrawnText + " status was sucessful");
						// CommonHelper.takeScreenShot();
					}
				}

				if (isNextButtonDisplayed) {
					counter = 1;
					CommonHelper.elementToBeVisible("next_xpath");
					CommonHelper.scrolltoview("next_xpath");
					test.log(LogStatus.INFO, "Click on Next");
					System.out.println("Click on Next");
					Log.info("Click on Next");
					driver.findElement(By.xpath("(//span[text()='Next'])[2]")).click();
					try { //
						isNextButtonDisplayed = // CommonHelper.isVisisble("next_xpath");
								driver.findElement(By.xpath("(//span[text()='Next'])[2]")).isDisplayed();
						isNextButtonDisplayed = true;
					} catch (Exception e) {
						isNextButtonDisplayed = false;
						e.printStackTrace();
					}

				}
			} while (isNextButtonDisplayed);

			Thread.sleep(1000);
			if (counter != 0) {
				Thread.sleep(2000);
				test.log(LogStatus.INFO, ("Verify Withdrawn Status Color Code"));
				Log.info("Verify Withdrawn Status Color Code");
				System.out.println("Verify Withdrawn Status Color Code");
				// CommonHelper.scrolltoview("productStatus_css");
				List<WebElement> withdrawn = driver.findElements(By.cssSelector("span[class*='font14']"));

				for (int i = 0; i < withdrawn.size(); i++) {
					CommonHelper.scrolltoview("productStatus_css");
					String withdrawnText = withdrawn.get(i).getText();
					System.out.println("The Status of the product is: " + withdrawnText);
					test.log(LogStatus.INFO, "The Status of the product is: " + withdrawnText);
					String withdrawnValue = withdrawn.get(i).getAttribute("class");
					System.out.println("The Withdrawn Value is: " + withdrawnValue);

					if (withdrawnText.equals("Withdrawn") && withdrawnValue.startsWith("status-green-colour")) {
						System.out.println("The Color Code for " + withdrawnText + " Status is not Red ");
						test.log(LogStatus.INFO, "The Color Code for " + withdrawnText + " Status is not Red ");
						System.out
								.println("Verification of Color code for " + withdrawnText + " status was unsucessful");
						test.log(LogStatus.FAIL,
								"Verification of Color code for " + withdrawnText + " status was unsucessful");
						// CommonHelper.takeScreenShot();
					} else {
						System.out.println("The Color Code for " + withdrawnText + " Status is Red ");
						test.log(LogStatus.INFO, "The Color Code for " + withdrawnText + " Status is Red ");
						System.out.println("Verification of Color code for " + withdrawnText + " status was sucessful");
						test.log(LogStatus.PASS,
								"Verification of Color code for " + withdrawnText + " status was sucessful");
						// CommonHelper.takeScreenShot();
					}
				}

			}
		} catch (Exception e) {
			CommonHelper.reportFailure("Verification of Color Code for Withdrawn status was unsuccessful");
			e.printStackTrace();
		}
	}

	public void currentFilterSearch() {

		try {
			Thread.sleep(2000);
			CommonHelper.scrolltoview("resetFilter_linkText");
			test.log(LogStatus.INFO, ("Click Reset Filters"));
			Log.info("Click Reset Filters");
			System.out.println("Click Reset Filters");
			click("resetFilter_linkText");

			Thread.sleep(5000);
			CommonHelper.scrolltoview("filterStatus_css");
			test.log(LogStatus.INFO, ("Select Status"));
			Log.info("Select Status");
			System.out.println("Select Status");
			click("filterStatus_id");
			Thread.sleep(1000);
			test.log(LogStatus.INFO, ("Select Current"));
			Log.info("Select Current");
			System.out.println("Select Current");
			click("filterCurrentStatus_id");

			Thread.sleep(1000);
			// CommonHelper.scrolltoview("applySearchFilter_id");
			test.log(LogStatus.INFO, ("Click Apply Filter"));
			Log.info("Click Apply Filter");
			System.out.println("Click Apply Filter");
			click("applySearchFilter_id");

		} catch (Exception e) {
			CommonHelper.reportFailure("Select Filter with Current Status was unsuccessful");
			e.printStackTrace();
		}
	}

	public void verifyCurrentColorCode() {

		try {
			Thread.sleep(2000);
			test.log(LogStatus.INFO, ("Verify Current Status Color Code"));
			Log.info("Verify Current Status Color Code");
			System.out.println("Verify Current Status Color Code");
			CommonHelper.elementToBeClickable("productStatus_css");
			List<WebElement> status = driver.findElements(By.cssSelector("span[class*='font14']"));

			for (int i = 0; i < status.size(); i++) {
				// CommonHelper.scrolltoview("productStatus_css");
				String statusText = status.get(i).getText();
				System.out.println("The Status of the product is: " + statusText);
				test.log(LogStatus.INFO, "The Status of the product is: " + statusText);
				String statusValue = status.get(i).getAttribute("class");
				System.out.println("The Status Value is: " + statusValue);

				if (statusText.equals("Current") && statusValue.startsWith("status-green-colour")) {
					System.out.println("The Color Code for " + statusText + " Status is Green ");
					test.log(LogStatus.INFO, "The Color Code for " + statusText + " Status is Green ");
					System.out.println("Verification of Color code for " + statusText + " status was sucessful");
					test.log(LogStatus.PASS, "Verification of Color code for " + statusText + " status was sucessful");
					// CommonHelper.takeScreenShot();
				} else {
					System.out.println("The Color Code for " + statusText + " Status is not Green ");
					test.log(LogStatus.INFO, "The Color Code for " + statusText + " Status is not Green ");
					System.out.println("Verification of Color code for " + statusText + " status was unsucessful");
					test.log(LogStatus.FAIL,
							"Verification of Color code for " + statusText + " status was unsucessful");
					// CommonHelper.takeScreenShot();
				}
			}

		} catch (Exception e) {
			CommonHelper.reportFailure("Verification of Color Code for Current status was unsuccessful");
			e.printStackTrace();
		}
	}

	public void currentDraftFilterSearch() {

		try {
			Thread.sleep(2000);
			CommonHelper.scrolltoview("resetFilter_linkText");
			test.log(LogStatus.INFO, ("Click Reset Filters"));
			Log.info("Click Reset Filters");
			System.out.println("Click Reset Filters");
			click("resetFilter_linkText");

			Thread.sleep(5000);
			CommonHelper.scrolltoview("filterStatus_css");
			test.log(LogStatus.INFO, ("Select Status"));
			Log.info("Select Status");
			System.out.println("Select Status");
			click("filterStatus_id");
			Thread.sleep(1000);
			test.log(LogStatus.INFO, ("Select Current Draft for Public Comment Status"));
			Log.info("Select Current Draft for Public Comment Status");
			System.out.println("Select Current Draft for Public Comment Status");
			click("filterDraftStatus_id");

			Thread.sleep(1000);
			// CommonHelper.scrolltoview("applySearchFilter_id");
			test.log(LogStatus.INFO, ("Click Apply Filter"));
			Log.info("Click Apply Filter");
			System.out.println("Click Apply Filter");
			click("applySearchFilter_id");

		} catch (Exception e) {
			CommonHelper.reportFailure(
					"Select Multiple Filter with Current Draft for Public Comment Status was unsuccessful");
			e.printStackTrace();
		}
	}

	public void currentRevisionUnderwayFilterSearch() {

		try {
			Thread.sleep(2000);
			CommonHelper.scrolltoview("resetFilter_linkText");
			test.log(LogStatus.INFO, ("Click Reset Filters"));
			Log.info("Click Reset Filters");
			System.out.println("Click Reset Filters");
			click("resetFilter_linkText");

			Thread.sleep(5000);
			CommonHelper.scrolltoview("filterStatus_css");
			test.log(LogStatus.INFO, ("Select Status"));
			Log.info("Select Status");
			System.out.println("Select Status");
			click("filterStatus_id");

			Thread.sleep(1000);
			test.log(LogStatus.INFO, ("Select Current Revision Underway Status"));
			Log.info("Select Current Revision Underway Status");
			System.out.println("Select Current Revision Underway Status");
			click("filterRevisionUnderwayStatus_id");

			Thread.sleep(1000);
			// CommonHelper.scrolltoview("applySearchFilter_id");
			test.log(LogStatus.INFO, ("Click Apply Filter"));
			Log.info("Click Apply Filter");
			System.out.println("Click Apply Filter");
			click("applySearchFilter_id");

		} catch (Exception e) {
			CommonHelper.reportFailure("Select Filter with Current Revision Underway Status was unsuccessful");
			e.printStackTrace();
		}
	}

	public void currentUnderReviewFilterSearch() {

		try {
			Thread.sleep(2000);
			CommonHelper.scrolltoview("resetFilter_linkText");
			test.log(LogStatus.INFO, ("Click Reset Filters"));
			Log.info("Click Reset Filters");
			System.out.println("Click Reset Filters");
			click("resetFilter_linkText");

			Thread.sleep(5000);
			CommonHelper.scrolltoview("filterStatus_css");
			test.log(LogStatus.INFO, ("Select Status"));
			Log.info("Select Status");
			System.out.println("Select Status");
			click("filterStatus_id");

			Thread.sleep(1000);
			test.log(LogStatus.INFO, ("Select Current Under Review Status"));
			Log.info("Select Current Under Review Status");
			System.out.println("Select Current Under Review Status");
			click("filterUnderReviewStatus_id");

			Thread.sleep(1000);
			// CommonHelper.scrolltoview("applySearchFilter_id");
			test.log(LogStatus.INFO, ("Click Apply Filter"));
			Log.info("Click Apply Filter");
			System.out.println("Click Apply Filter");
			click("applySearchFilter_id");

		} catch (Exception e) {
			CommonHelper.reportFailure("Select Multiple Filter with Current Under Review Status was unsuccessful");
			e.printStackTrace();
		}
	}

	public void verifyAmberColorCode() {

		try {
			// Thread.sleep(2000);
			test.log(LogStatus.INFO, ("Verify Current Draft Status Color Code"));
			Log.info("Verify Current Draft Status Color Code");
			System.out.println("Verify Current Draft Status Color Code");
			CommonHelper.elementToBeClickable("productStatus_css");
			List<WebElement> status = driver.findElements(By.cssSelector("span[class*='font14']"));
			List<WebElement> product = driver.findElements(By.cssSelector("a[class='product-item-link']"));
			// Thread.sleep(2000);
			// for (int j = 0; j < product.size(); j++) {
			for (int i = 0; i < status.size(); i++) {
				Thread.sleep(1000);
				String statusText = status.get(i).getText();
				System.out.println("The Status of the product is: " + statusText);
				test.log(LogStatus.INFO, "The Status of the product is: " + statusText);
				String statusValue = status.get(i).getAttribute("class");
				System.out.println("The Status Value is: " + statusValue);
				// String productName = product.get(j).getText();
				// System.out.println("The Name of the product is: " + productName);
				// test.log(LogStatus.INFO, "The Name of the product is: " + productName);
				// Thread.sleep(2000);

				if (statusText.contains("Current") && statusValue.startsWith("status-draft-color")) {
					System.out.println("The Color Code for " + statusText + " status is Amber ");
					test.log(LogStatus.INFO, "The Color Code for " + statusText + " status is Amber ");
					System.out.println("Verification of Color code for " + statusText + " status was sucessful");
					test.log(LogStatus.PASS, "Verification of Color code for " + statusText + " status was sucessful");
				} else {
					System.out.println("The Color Code for " + statusText + " status is not Amber ");
					test.log(LogStatus.INFO, "The Color Code for " + statusText + " status is not Amber ");
					System.out.println("Verification of Color code for " + statusText + " status was not sucessful");
					test.log(LogStatus.FAIL,
							"Verification of Color code for " + statusText + " status was not sucessful");
				}
			}
			// }

		} catch (Exception e) {
			CommonHelper.reportFailure("Verification of Color Code for Current Draft statuses was unsuccessful");
			e.printStackTrace();
		}
	}
}
