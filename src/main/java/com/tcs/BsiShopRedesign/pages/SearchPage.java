package com.tcs.BsiShopRedesign.pages;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;

import org.openqa.selenium.By;
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
		int counter = 0;
		int productLink = 0;
		String productLinkText;
		int numOfProducts = 0;

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

				test.log(LogStatus.INFO, "Count product on the Search List");
				Log.info("Count product on the Search List");
				System.out.println("Count product on the Search List");
				CommonHelper.elementToBeVisible("productLinkCount_css");
				CommonHelper.elementToBeClickable("productLinkCount_css");
				productLink = driver.findElements(By.cssSelector("a[class='product-item-link']")).size();
				productLinkText = Integer.toString(productLink);

				if (isNextButtonDisplayed) {
					counter = 1;
					CommonHelper.elementToBeVisible("next_xpath");
					CommonHelper.scrolltoview("next_xpath");
					test.log(LogStatus.INFO, "Click on Next" + "The current page is: " + counter);
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
				test.log(LogStatus.FAIL, "The search count was unsuccessful");

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
					driver.findElements(By.xpath("//*[@id='search_price_layout']/div[1]/div[2]"))));
			List<WebElement> statusDate = driver.findElements(By.xpath("//*[@id='search_price_layout']/div[1]/div[2]"));
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
			}

		} catch (Exception e) {
			CommonHelper.reportFailure("Sorting list of products with Label Type was unsuccessful");
			e.printStackTrace();
			Assert.fail(e.getMessage());
		}

	}

	public void checkSortingByPublishedDate() {

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
				test.log(LogStatus.INFO, "Select Sort By Published Date");
				System.out.println("Select Sort By Published Date");
				Log.info("Select Sort By Published Date");
				selectSortByPublishedDate();
				test.log(LogStatus.INFO, "Sort List of Products in Descending Order");
				System.out.println("Sort List of Products in Descending Order");
				Log.info("Sort List of Products in Descending Order");
				publishedDateSorting();

				if (isNextButtonDisplayed) {
					counter = 1;
					CommonHelper.elementToBeVisible("next_xpath");
					CommonHelper.scrolltoview("next_xpath");
					test.log(LogStatus.INFO, "Click on Next" + "The current page is: " + counter + 1);
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

			if (counter != 0) {
				test.log(LogStatus.INFO, "Select Sort By Published Date");
				System.out.println("Select Sort By Published Date");
				Log.info("Select Sort By Published Date");
				selectSortByPublishedDate();
				test.log(LogStatus.INFO, "Sort List of Products in Descending Order");
				System.out.println("Sort List of Products in Descending Order");
				Log.info("Sort List of Products in Descending Order");
				publishedDateSorting();
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
		String prodName = "Sustainability Performance and Reporting Event – 2016";

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
			System.out.println("Check Event Label");
			test.log(LogStatus.INFO, "Check Event Label");
			freeEvent = CommonHelper.element("eventLabel_xpath").isDisplayed();

			if (freeEvent) {
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
			PAS = CommonHelper.element("productLinkCount_css").isDisplayed();
			if (PAS) {
				String eventName = CommonHelper.element("productLinkCount_css").getText();
				if (eventName.contains("PAS")) {
					System.out.println("PAS Product Name is: " + eventName);
					test.log(LogStatus.INFO, "PAS Product Name is: " + eventName);
					test.log(LogStatus.PASS, "PAS Product Name match is successful");
				} else {
					System.out.println("PAS Product Name match is unsuccessful");
					test.log(LogStatus.FAIL, "PAS Product Name match is unsuccessful");
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
			System.out.println("Check PAS Product Label");
			test.log(LogStatus.INFO, "Check PAS Product Label");
			PAS = CommonHelper.element("eventLabel_xpath").isDisplayed();

			if (PAS) {
				WebElement imgLabel = CommonHelper.element("eventLabel_xpath");
				String altValue = imgLabel.getAttribute("alt").replace("PAS Category", "PAS");

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
			System.out.println("Check Paid Event Name");
			test.log(LogStatus.INFO, "Check Paid Event Name");
			paidEvent = CommonHelper.element("productLinkCount_css").isDisplayed();
			if (paidEvent) {
				String paidEventText = CommonHelper.element("productLinkCount_css").getText();
				if (paidEventText.equals(prodName)) {
					System.out.println("Paid Event Name is: " + paidEventText);
					test.log(LogStatus.INFO, "Paid Event Name is: " + paidEventText);
					test.log(LogStatus.PASS, "Paid Event Name match is successful");
				} else {
					System.out.println("Paid Event Name match is unsuccessful");
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
			System.out.println("Check Paid Event Price");
			test.log(LogStatus.INFO, "Check Paid Event Price");
			paidEvent = CommonHelper.element("eventPrice_css").isDisplayed();
			if (paidEvent) {
				String paidEventText = CommonHelper.element("eventPrice_css").getText();
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
			WebElement addToBasket = driver.findElements(By.cssSelector("button[title='Add to Basket']")).get(0);
			CommonHelper.elementToBeClickable("addToBasket_css");
			addToBasket.click();
			Thread.sleep(2000);

		} catch (Exception e) {
			CommonHelper.reportFailure("Click on Add to Basket was unsuccessful");
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

	public void defaultFormatClickOK() {
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
				// CommonHelper.elementToBeClickable("pdfAlert_xpath");
				// CommonHelper.element("pdfAlert_xpath");
				// CommonHelper.clickByJS("twiceAddPdfAlert_css");
				// click("twiceAddPdfAlert_css");
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

	public boolean verifyMemPriceSearchList() {

		try {
			WebElement priceList = driver.findElements(By.cssSelector("span[id*='product-price']")).get(0);
			WebElement memPriceList = driver.findElements(By.cssSelector("span[class='price']")).get(1);
			String price = priceList.getText();
			String memPrice = memPriceList.getText();

			price = price.substring(1);
			memPrice = memPrice.substring(1);

			double finalPrice = Double.parseDouble(price);
			double finalMemPrice = Double.parseDouble(memPrice);
			double memberPrice = finalPrice / 2;

			if (finalMemPrice == memberPrice) {
				System.out.println("The price of the first product in the search list is: " + finalPrice
						+ " & The member price of the first product in the search list is: " + memberPrice);
				test.log(LogStatus.PASS, "The price of the first product in the search list is: " + finalPrice
						+ " & The member price of the first product in the search list is: " + memberPrice);
				return true;
			} else {
				System.out.println("The member price in the search list is incorrect");
				test.log(LogStatus.FAIL, "The member price in the search list is incorrect");
			}
			return false;

		} catch (NumberFormatException e) {
			CommonHelper.reportFailure("The member price in the search list is incorrect");
			e.printStackTrace();
		}
		return false;

	}
}
