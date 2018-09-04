package com.tcs.BsiShopRedesign.pages;

import java.util.ArrayList;
import java.util.List;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import com.relevantcodes.extentreports.LogStatus;
import com.tcs.BsiShopRedesign.utilities.Page;
import com.tcs.BsiShopRedesign.utilities.CommonHelper;

public class EventPage extends Page {

	public EventPage(WebDriver driver) throws Exception {
		super(driver);
		// BaseTest.driver = driver;
	}

	public void searchPaidEvent() {

		try {

			test.log(LogStatus.INFO, "Enter Event name in Search Box");
			Log.info("Enter event name in Search Box");
			System.out.println("Enter event name in Search Box");
			CommonHelper.elementToBeClickable("searchBox_id");
			enterText("searchBox_id", "Crisis Management Conference");

			test.log(LogStatus.INFO, "Click on Search");
			Log.info("Click on Search");
			System.out.println("Click on Search");
			click("searchButton_css");

			test.log(LogStatus.INFO, "Select the Event");
			Log.info("Select the Event");
			System.out.println("Select the Event");
			click("paidEvent_linkText");

		} catch (Exception e) {

			CommonHelper.reportFailure("Search Event was unsuccessful");
			e.printStackTrace();
			Assert.fail(e.getMessage());
		}

	}

	public void searchSecondPaidEvent() {

		try {

			test.log(LogStatus.INFO, "Enter second Event name in Search Box");
			Log.info("Enter second  event name in Search Box");
			System.out.println("Enter second  event name in Search Box");
			CommonHelper.elementToBeClickable("searchBox_id");
			enterText("searchBox_id", "Fire Safety Conference");

			test.log(LogStatus.INFO, "Click on Search");
			Log.info("Click on Search");
			System.out.println("Click on Search");
			click("searchButton_css");

			test.log(LogStatus.INFO, "Select the second  Event");
			Log.info("Select the second Event");
			System.out.println("Select the second Event");
			click("secondPaidEvent_linkText");

		} catch (Exception e) {

			CommonHelper.reportFailure("Search second Event was unsuccessful");
			e.printStackTrace();
			Assert.fail(e.getMessage());
		}

	}

	public void bookPaidEvent() {

		try {

			test.log(LogStatus.INFO, "Click Book Now");
			Log.info("Click Book Now");
			System.out.println("Click Book Now");
			CommonHelper.scrolltoview("addEventCart_id");
			click("addEventCart_id");
			Thread.sleep(2000);

		} catch (Exception e) {
			CommonHelper.reportFailure("Click Book Now was unsuccessful");
			e.printStackTrace();
			Assert.fail(e.getMessage());
		}

	}

	public void clickAddDelegate() {

		try {
			test.log(LogStatus.INFO, "Click Add Delegate");
			Log.info("Click Add Delegate");
			System.out.println("Click Add Delegate");
			Thread.sleep(1000);
			// driver.findElements(By.cssSelector("input[class='addDelegate']")).get(0).click();
			click("addDelegate_css");
			Thread.sleep(1000);
			// driver.findElement(By.cssSelector("input[class='addDelegate']")).click();
			// click("addFirstDelegate_xpath");

		} catch (Exception e) {
			CommonHelper.reportFailure("Click Add Delegate was unsuccessful");
			e.printStackTrace();
			Assert.fail(e.getMessage());
		}

	}

	public void clickSecondAddDelegate() {

		List<WebElement> addDelegate = CommonHelper.getElements("addDelegate_id");
		List<WebElement> addFirstDelegate = CommonHelper.getElements("divCollapsed_xpath");

		try {
			test.log(LogStatus.INFO, "Click Second Add Delegate");
			Log.info("Click Second Add Delegate");
			System.out.println("Click Second Add Delegate");
			Thread.sleep(1000);
			addDelegate.get(1).click();
			Thread.sleep(1000);
			addFirstDelegate.get(1).click();

			/*
			 * List<WebElement> elements = CommonHelper.getElements("addDelegate_id"); //int
			 * size=CommonHelper.getElementsSize("addDelegate_id"); int length =
			 * elements.size(); List<WebElement> collapsedAccordion =
			 * CommonHelper.getElements("divCollapsed_xpath"); List<WebElement>
			 * activeAccordion = CommonHelper.getElements("divActive_xpath");
			 * 
			 * for(int i=0;i<length;i++){ Thread.sleep(5000); elements.get(i).click();
			 * Thread.sleep(1000); collapsedAccordion.get(i).click(); addDelegateDetails();
			 * 
			 * }
			 */

		} catch (Exception e) {
			CommonHelper.reportFailure("Click Second Add Delegate was unsuccessful");
			e.printStackTrace();
			Assert.fail(e.getMessage());
		}

	}

	public void addDelegateDetails() {

		try {
			Thread.sleep(2000);
			test.log(LogStatus.INFO, "Enter Title");
			Log.info("Enter Title");
			System.out.println("Enter Title");
			selectFirstOption("selectTitle_css");

			test.log(LogStatus.INFO, "Enter First Name");
			Log.info("Enter First Name");
			System.out.println("Enter First Name");
			enterText("firstName_css", "EventFirstName");

			test.log(LogStatus.INFO, "Enter Last Name");
			Log.info("Enter Last Name");
			System.out.println("Enter Last Name");
			enterText("lastName_css", "EventLastName");

			test.log(LogStatus.INFO, "Enter Email ID");
			Log.info("Enter Email ID");
			System.out.println("Enter Email ID");
			enterText("email_css", "event@tcs.com");

			test.log(LogStatus.INFO, "Enter Telephone Number");
			Log.info("Enter Telephone Number");
			System.out.println("Enter Telephone Number ");
			enterText("phoneNum_css", "123456789");

			test.log(LogStatus.INFO, "Enter Street Address");
			Log.info("Enter Street Address");
			System.out.println("Enter Street Address");
			enterText("streetAddress_css", "Event Street Address");

			test.log(LogStatus.INFO, "Enter City");
			Log.info("Enter City");
			System.out.println("Enter City");
			enterText("city_css", "London");

			test.log(LogStatus.INFO, "Enter State/Province");
			Log.info("Enter State/Province");
			System.out.println("Enter State/Province");
			enterText("state_css", "England");

			test.log(LogStatus.INFO, "Enter Zip Postal Code");
			Log.info("Enter Zip Postal Code");
			System.out.println("Enter Zip Postal Code");
			enterText("postalCode_css", "987456");

			test.log(LogStatus.INFO, "Enter Country");
			Log.info("Enter Country");
			System.out.println("Enter Country");
			// selectFirstOption("country_css");
			WebElement country = driver.findElement(By.cssSelector("select[title='Country']"));
			Select dpdwn = new Select(country);
			dpdwn.selectByVisibleText("United Kingdom");

		} catch (Exception e) {
			CommonHelper.reportFailure("Adding Delegate details was unsuccessful");
			e.printStackTrace();
			Assert.fail(e.getMessage());
		}

	}

	public void editDelegateDetails() {

		try {
			test.log(LogStatus.INFO, "Edit Title");
			Log.info("Edit Title");
			System.out.println("Edit Title");
			selectFirstOption("selectTitle_css");

			test.log(LogStatus.INFO, "Edit First Name");
			Log.info("Edit First Name");
			System.out.println("Edit First Name");
			clearText("firstName_css");
			enterText("firstName_css", "EventFirstNameEDIT");

			test.log(LogStatus.INFO, "Edit Last Name");
			Log.info("Edit Last Name");
			System.out.println("Edit Last Name");
			clearText("lastName_css");
			enterText("lastName_css", "EventLastNameEDIT");

			test.log(LogStatus.INFO, "Edit Email ID");
			Log.info("Edit Email ID");
			System.out.println("Edit Email ID");
			clearText("email_css");
			enterText("email_css", "eventEDIT1st@tcs.com");

			test.log(LogStatus.INFO, "Edit Telephone Number");
			Log.info("Edit Telephone Number");
			System.out.println("Edit Telephone Number");
			clearText("phoneNum_css");
			enterText("phoneNum_css", "3545648976");

			test.log(LogStatus.INFO, "Edit Street Address");
			Log.info("Edit Street Address");
			System.out.println("Edit Street Address");
			// CommonHelper.elementToBeClickable("streetAddress_css");
			clearText("editStreetAddress_css");
			enterText("editStreetAddress_css", "Event Street Address EDIT");

			test.log(LogStatus.INFO, "Edit City");
			Log.info("Edit City");
			System.out.println("Edit City");
			clearText("city_css");
			enterText("city_css", "London EDIT");

			test.log(LogStatus.INFO, "Edit State/Province");
			Log.info("Edit State/Province");
			System.out.println("Edit State/Province");
			// CommonHelper.elementToBeClickable("state_css");
			clearText("editState_css");
			enterText("editState_css", "England EDIT");

			/*
			 * test.log(LogStatus.INFO, "Edit Zip Postal Code");
			 * Log.info("Edit Zip Postal Code"); System.out.println("Edit Zip Postal Code");
			 * clearText("postalCode_css"); enterText("postalCode_css", "132465");
			 * 
			 * test.log(LogStatus.INFO, "Edit Country"); Log.info("Edit Country");
			 * System.out.println("Edit Country"); selectFirstOption("country_css");
			 */

		} catch (Exception e) {
			CommonHelper.reportFailure("Editing Delegate details was unsuccessful");
			e.printStackTrace();
			Assert.fail(e.getMessage());
		}

	}

	public void addEventToBasket() {

		try {
			test.log(LogStatus.INFO, "Click Add Event to Basket");
			Log.info("Click Add Event to Basket");
			System.out.println("Click Add Event to Basket");
			click("addToBasket_id");
			CommonHelper.scrolltoview("viewBasket_xpath");
			Thread.sleep(2000);

		} catch (Exception e) {
			CommonHelper.reportFailure("Add Event to Basket was unsuccessful");
			e.printStackTrace();
			Assert.fail(e.getMessage());
		}

	}

	public void viewBasket() {

		try {
			// Thread.sleep(9000);
			test.log(LogStatus.INFO, "View Basket");
			Log.info("View Basket");
			System.out.println("View Basket");
			CommonHelper.elementToBeClickable("viewBasket_xpath");
			click("viewBasket_xpath");

		} catch (Exception e) {
			CommonHelper.reportFailure("View Basket was unsuccessful");
			e.printStackTrace();
			Assert.fail(e.getMessage());
		}
	}

	public void removeEvent() {
		WebDriverWait wait = new WebDriverWait(driver, 120);

		try {
			WebElement remove = driver.findElement(By.xpath("//img[@alt='delete']"));
			test.log(LogStatus.INFO, "Remove Event from Basket");
			Thread.sleep(5000);
			wait.until(ExpectedConditions.visibilityOf(remove));
			wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//img[@alt='delete']")));
			// CommonHelper.elementToBeVisible("removeEvent_xpath");
			// CommonHelper.elementToBeClickable("removeEvent_xpath");
			// click("removeEvent_xpath");
			// CommonHelper.clickByJS("removeEvent_xpath");
			click("removeEvent_xpath");
			//remove.click();
			Thread.sleep(3000);
			test.log(LogStatus.INFO, "Verify Remove Basket");
			CommonHelper.elementToBeClickable("verifyBasket_css");
			String verifyBasket = CommonHelper.element("verifyBasket_css").getText();
			System.out.println("The Verification message is: " + verifyBasket);
			Log.info("The Verification message is: " + verifyBasket);
			test.log(LogStatus.PASS, "The Verification message is: " + verifyBasket);

		} catch (Exception e) {
			CommonHelper.reportFailure("Remove Event from Basket was unsuccessful");
			e.printStackTrace();
			Assert.fail(e.getMessage());
		}

	}

	public void removeMultipleEvent() {

		WebDriverWait wait = new WebDriverWait(driver, 120);
		test.log(LogStatus.INFO, "Remove Multiple Event from Basket");

		try {

			for (int i = 1; i <= 2; i++) {
				WebElement remove = driver.findElement(By.xpath("//img[@alt='delete']"));
				Thread.sleep(5000);
				wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//img[@alt='delete']")));
				wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//img[@alt='delete']")));
				remove.click();
				// click("removeEvent_xpath");
			}

			Thread.sleep(5000);
			test.log(LogStatus.INFO, "Verify Remove Basket");
			CommonHelper.elementToBeClickable("verifyBasket_css");
			String verifyBasket = CommonHelper.element("verifyBasket_css").getText();
			System.out.println("The Verfication message is: " + verifyBasket);
			Log.info("The Verfication message is: " + verifyBasket);
			test.log(LogStatus.PASS, "Multiple Events has been removed from Basket successfully");

		} catch (Exception e) {
			CommonHelper.reportFailure("Remove Event from Basket was unsuccessful");
			e.printStackTrace();
			Assert.fail(e.getMessage());
		}

	}

	public void searchFreeEvent() {

		try {

			test.log(LogStatus.INFO, "Enter Event name in Search Box");
			Log.info("Enter event name in Search Box");
			System.out.println("Enter event name in Search Box");
			CommonHelper.elementToBeClickable("searchBox_id");
			enterText("searchBox_id", "Sustainability Performance and Reporting Event – 2016");
			Thread.sleep(2000);
			// driver.findElement(By.id("search")).sendKeys("BSI�s BIM
			// Conference");

			test.log(LogStatus.INFO, "Click on Search");
			Log.info("Click on Search");
			System.out.println("Click on Search");
			click("searchButton_css");

			test.log(LogStatus.INFO, "Select the Event");
			Log.info("Select the Event");
			System.out.println("Select the Event");
			click("freeEvent_linkText");

		} catch (Exception e) {
			CommonHelper.reportFailure("Search Free Event was unsuccessful");
			e.printStackTrace();
			Assert.fail(e.getMessage());
		}

	}

	public void bookFreeEvent() {

		try {

			test.log(LogStatus.INFO, "Click Book Now");
			Log.info("Click Book Now");
			System.out.println("Click Book Now");
			CommonHelper.scrolltoview("bookFreeEvent_css");
			CommonHelper.elementToBeClickable("bookFreeEvent_css");
			click("bookFreeEvent_css");

			/*
			 * Thread.sleep(5000); ArrayList<String> tabs2 = new
			 * ArrayList<String>(driver.getWindowHandles());
			 * driver.switchTo().window(tabs2.get(1)); System.out.println("tab switched");
			 */
			Thread.sleep(5000);
			driver.switchTo().frame(0);
			Thread.sleep(5000);
			System.out.println("iframe switched");

		} catch (Exception e) {
			CommonHelper.reportFailure("Click Book Now was unsuccessful");
			e.printStackTrace();
			Assert.fail(e.getMessage());
		}

	}

	public void enterFreeEventPardotDetails() {

		try {
			/*
			 * test.log(LogStatus.INFO, "Select Pardot Title");
			 * Log.info("Select Pardot Title"); System.out.println("Select Pardot Title");
			 * selectFirstOption("pardotTitle_id");
			 */

			test.log(LogStatus.INFO, "Enter Pardot First Name");
			Log.info("Enter Pardot First Name");
			System.out.println("Enter Pardot First Name");
			enterText("pardotFreeEventFirstName_xpath", "Pardot First Name");

			test.log(LogStatus.INFO, "Enter Pardot Last Name");
			Log.info("Enter Pardot Last Name");
			System.out.println("Enter Pardot Last Name");
			enterText("pardotFreeEventLastName_xpath", "Pardot Last Name");

			/*
			 * test.log(LogStatus.INFO, "Enter Pardot Job Title");
			 * Log.info("Enter Pardot Job Title");
			 * System.out.println("Enter Pardot Job Title"); enterText("pardotJobTitle_id",
			 * "Pardot Job Title");
			 */

			test.log(LogStatus.INFO, "Enter Pardot Company");
			Log.info("Enter Pardot Company");
			System.out.println("Enter Pardot Company");
			enterText("pardotFreeEventCompany_xpath", "Pardot Company");

			test.log(LogStatus.INFO, "Enter Pardot Email");
			Log.info("Enter Pardot Email");
			System.out.println("Enter Pardot Email");
			enterText("pardotFreeEventEmail_xpath", "pardot.company@tcs.com");

			/*
			 * test.log(LogStatus.INFO, "Enter Pardot Phone");
			 * Log.info("Enter Pardot Phone"); System.out.println("Enter Pardot Phone");
			 * enterText("pardotPhone_id", "123456789");
			 */

			test.log(LogStatus.INFO, "Select How would you like to be contacted?");
			System.out.println("Enter How would you like to be contacted?");
			Log.info("Enter How would you like to be contacted?");
			List<WebElement> checkBox = driver.findElements(By.cssSelector("input[type='checkbox']"));
			checkBox.get(0).click();

			test.log(LogStatus.INFO, "Select Terms and Conditions");
			System.out.println("Select Terms and Conditions");
			Log.info("Select Terms and Conditions");
			checkBox.get(4).click();

			test.log(LogStatus.INFO, "Click Submit");
			Log.info("Click Submit");
			System.out.println("Click Submit");
			click("pardotSubmit_css");

			ArrayList<String> tabs2 = new ArrayList<String>(driver.getWindowHandles());
			driver.switchTo().window(tabs2.get(1));
			System.out.println("tab switched");
			driver.manage().window().maximize();

		} catch (Exception e) {
			CommonHelper.reportFailure("Adding Pardot Details was unsucessful");
			e.printStackTrace();
			Assert.fail(e.getMessage());
		}

	}

	public void verifyFreeEventPardotForm() {

		try {
			Thread.sleep(3000);
			test.log(LogStatus.INFO, "Verify Pardot Form");
			Log.info("Verify Pardot Form");
			System.out.println("Verify Pardot Form");
			// CommonHelper.elementToBeVisible("verifyPardotSubmit_xpath");
			// String verifyPardotSubmit =
			// CommonHelper.element("verifyPardotSubmit_xpath").getText();

			List<WebElement> verificationMsg = driver.findElements(By.xpath("//div[@id='CenterContent']/h1"));
			Thread.sleep(5000);
			test.log(LogStatus.INFO, "Verify Pardot Form");
			Log.info("Verify Pardot Form");
			System.out.println("Verify Pardot Form");
			CommonHelper.elementToBeVisible("verifyPardotSubmit_xpath");

			CommonHelper.element("verifyPardotSubmit_xpath").getText();
			String verifyPardotSubmit = verificationMsg.get(3).getText() + verificationMsg.get(4).getText();
			Log.info("The Verfication message is: " + verifyPardotSubmit);
			System.out.println("The Verfication message is: " + verifyPardotSubmit);
			test.log(LogStatus.PASS, "The Verfication message is: " + verifyPardotSubmit);

			if (verifyPardotSubmit.contains("Thank you for contacting us")) {
				Log.info("The Verfication message is: " + verifyPardotSubmit);
				System.out.println("The Verfication message is: " + verifyPardotSubmit);
				test.log(LogStatus.PASS, "Verification of Pardot Form successful");
			}
			ArrayList<String> tabs2 = new ArrayList<String>(driver.getWindowHandles());
			driver.close();
			driver.switchTo().window(tabs2.get(0));

		} catch (Exception e) {
			CommonHelper.reportFailure("Verification of Pardot Form unsuccessful");
			e.printStackTrace();
			Assert.fail(e.getMessage());
		}
	}

	public void editEvent() {

		try {
			// List<WebElement> ele =
			// driver.findElements(By.id("eventaddtocart1"));
			Thread.sleep(1000);
			test.log(LogStatus.INFO, "Click on Edit First Event");
			Log.info("Click on Edit First Event");
			System.out.println("Click on Edit First Event");
			// ele.get(1).click();
			// click("editFirstEvent_xpath");
			CommonHelper.elementToBeVisible("editFirstEvent_xpath");
			CommonHelper.elementToBeClickable("editFirstEvent_xpath");
			click("editFirstEvent_xpath");
			// CommonHelper.clickByJS("editFirstEvent_xpath");
			Thread.sleep(3000);
			CommonHelper.elementToBeClickable("divCollapsed_xpath");
			click("divCollapsed_xpath");

			Thread.sleep(1000);
			test.log(LogStatus.INFO, "Edit First Event Delegate Details");
			Log.info("Edit First Event Delegate Details");
			System.out.println("Edit First Event Delegate Details");
			editDelegateDetails();

			Thread.sleep(2000);
			test.log(LogStatus.INFO, "Click on Update First Event");
			Log.info("Click on Update First Event");
			System.out.println("Click on Update First Event");
			Thread.sleep(1000);
			CommonHelper.scrolltoview("updateEvent_css");
			CommonHelper.elementToBeClickable("updateEvent_css");
			CommonHelper.clickByJS("updateEvent_css");
			// click("updateEvent_css");

			Thread.sleep(2000);
			test.log(LogStatus.INFO, "Click Edit for Second  Event");
			Log.info("Click Edit for Second Event");
			System.out.println("Click Edit for Second Event");
			// ele.get(2).click();
			CommonHelper.elementToBeVisible("editSecondEvent_xpath");
			CommonHelper.elementToBeClickable("editSecondEvent_xpath");
			// CommonHelper.clickByJS("editSecondEvent_xpath");
			click("editSecondEvent_xpath");

			Thread.sleep(3000);
			CommonHelper.elementToBeClickable("divCollapsed_css");
			click("divCollapsed_css");
			test.log(LogStatus.INFO, "Edit Second Event Delegate Details");
			Log.info("Edit Second Event Delegate Details");
			System.out.println("Edit Second Event Delegate Details");
			Thread.sleep(1000);
			editDelegateDetails();

			test.log(LogStatus.INFO, "Click on Update Second Event");
			Log.info("Click on Update Second Event");
			System.out.println("Click on Update Second Event");
			Thread.sleep(1000);

			CommonHelper.scrolltoview("updateEvent_css");
			CommonHelper.elementToBeClickable("updateEvent_css");
			CommonHelper.clickByJS("updateEvent_css");
			// click("updateEvent_css");
			Thread.sleep(1000);
			test.log(LogStatus.PASS, "Event Updated Successfully");

		} catch (InterruptedException e) {
			e.printStackTrace();
			CommonHelper.reportFailure("Edit Event was unsuccessful");
			Assert.fail(e.getMessage());
		}
	}

	public void test() {
		List<WebElement> addToDelegateLinks = driver.findElements(By.id("addButton"));
		for (WebElement element : addToDelegateLinks) {
			element.click();
			addDelegateDetails();
			driver.findElement(By.xpath(""));
		}
	}
}
