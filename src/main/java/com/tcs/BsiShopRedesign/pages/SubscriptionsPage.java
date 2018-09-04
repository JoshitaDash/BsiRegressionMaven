package com.tcs.BsiShopRedesign.pages;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import com.relevantcodes.extentreports.LogStatus;
import com.tcs.BsiShopRedesign.utilities.CommonHelper;
import com.tcs.BsiShopRedesign.utilities.Page;

public class SubscriptionsPage extends Page {

	public SubscriptionsPage(WebDriver driver) throws Exception {
		super(driver);
	}

	public void clickBSOL() {

		try {

			test.log(LogStatus.INFO, "Click on Subscriptions BSOL");
			System.out.println("Mousehover Subscriptions");
			Log.info("Click on Subscriptions BSOL");
			mouseHover("subscriptions_xpath");
			System.out.println("Click on BSOL");
			click("bsol_xpath");

		} catch (Exception e) {
			CommonHelper.reportFailure("Click on Subscriptions BSOL was unsuccessful");
			e.printStackTrace();
			Assert.fail(e.getMessage());
		}

	}

	public void clickRequestQuote() {
		try {

			test.log(LogStatus.INFO, "Click on Request a Quote");
			System.out.println("Click on Request a Quote");
			Log.info("Click on Request a Quote");
			click("requestQuote_css");
			Thread.sleep(2000);

		} catch (Exception e) {
			CommonHelper.reportFailure("Click on Request a Quote was unsuccessful");
			e.printStackTrace();
			Assert.fail(e.getMessage());
		}

	}

	public void enterBSOLPardotDetails() {

		try {
			test.log(LogStatus.INFO, "Enter BSOL Pardot form details");
			System.out.println("Enter BSOL Pardot form details");
			Log.info("Enter BSOL Pardot form details");

			/*
			 * System.out.println("Switch iFrame"); driver.switchTo().frame(0);
			 * Thread.sleep(3000); System.out.println("iframe switched");
			 * 
			 * boolean clickHere =
			 * driver.findElement(By.xpath("/html/body/form/p[1]/span/a")).isDisplayed();
			 * 
			 * if (clickHere) if (CommonHelper.element("clickHere_xpath") != null ||
			 * CommonHelper.element("clickHere_xpath").isDisplayed()) {
			 * test.log(LogStatus.INFO, "Click on the Click Here link");
			 * System.out.println("Click on the Click Here link");
			 * Log.info("Click on the Click Here link");
			 * driver.findElement(By.xpath("//*[@id='pardot-form']/p[1]/span/a")).click();
			 * CommonHelper.isElementVisible("title_css");
			 * CommonHelper.elementToBeClickable("title_css"); enterBSOLPardotFormDetails();
			 * } else
			 */ {
				Thread.sleep(3000);
				System.out.println("Switch iFrame");
				driver.switchTo().frame(0);
				Thread.sleep(5000);
				System.out.println("iframe switched");

				CommonHelper.isElementVisible("title_css");
				CommonHelper.elementToBeClickable("title_css");
				enterBSOLPardotFormDetails();

			}
		} catch (Exception e) {
			CommonHelper.reportFailure("Enter BSOL Pardot form details was unsuccessful");
			e.printStackTrace();
			Assert.fail(e.getMessage());
		}
	}

	public void enterBSOLPardotFormDetails() {

		try {
			test.log(LogStatus.INFO, "Select title");
			System.out.println("Select title");
			Log.info("Select title");
			selectFirstOption("title_css");

			test.log(LogStatus.INFO, "Enter First Name");
			System.out.println("Enter First Name");
			Log.info("Enter First Name");
			enterText("firstName_xpath", "BSOL First Name");

			test.log(LogStatus.INFO, "Enter Last Name");
			System.out.println("Enter Last Name");
			Log.info("Enter Last Name");
			enterText("lastName_xpath", "BSOL Last Name");

			test.log(LogStatus.INFO, "Enter Email");
			System.out.println("Enter Email");
			Log.info("Enter Email");
			clearText("email_xpath");
			enterText("email_xpath", "bsol@tcs.com");

			test.log(LogStatus.INFO, "Enter Job Title");
			System.out.println("Enter Job Title");
			Log.info("Enter Job Title");
			enterText("jobTitle_xpath", "BSOL Job");

			test.log(LogStatus.INFO, "Enter Company");
			System.out.println("Enter Company");
			Log.info("Enter Company");
			enterText("company_xpath", "BSOL Company");

			test.log(LogStatus.INFO, "Enter PostCode");
			System.out.println("Enter PostCode");
			Log.info("Enter PostCode");
			enterText("postcode_xpath", "1234568");

			test.log(LogStatus.INFO, "Select Country");
			System.out.println("Select Country");
			Log.info("Select Country");
			selectFirstOption("countryBSOL_xpath");
			// selectDpdwnText("countryBSOL_xpath", "United Kingdom");
			// selectDpdwnValue("countryBSOL_xpath", "United Kingdom");

			test.log(LogStatus.INFO, "Select Industry");
			System.out.println("Select Industry");
			Log.info("Select Industry");
			selectFirstOption("industry_xpath");

			test.log(LogStatus.INFO, "Enter number of employees");
			System.out.println("Enter number of employees");
			Log.info("Enter number of employees");
			enterText("numEmployees_xpath", "100");

			test.log(LogStatus.INFO, "Enter How did you hear about us?");
			System.out.println("Enter How did you hear about us?");
			Log.info("Enter How did you hear about us?");
			enterText("howHearThis_xpath", "Social Media");

			test.log(LogStatus.INFO, "Select How would you like to be contacted?");
			System.out.println("Enter How would you like to be contacted?");
			Log.info("Enter How would you like to be contacted?");
			List<WebElement> checkBox = driver.findElements(By.cssSelector("input[type='checkbox']"));
			checkBox.get(0).click();

			test.log(LogStatus.INFO, "Select Terms and Conditions");
			System.out.println("Select Terms and Conditions");
			Log.info("Select Terms and Conditions");
			checkBox.get(4).click();

			test.log(LogStatus.INFO, "Click on Send your Enquiry");
			System.out.println("Click on Send your Enquiry");
			Log.info("Click on Send your Enquiry");
			CommonHelper.scrolltoview("sendEnquiry_xpath");
			click("sendEnquiry_xpath");
			Thread.sleep(2000);

		} catch (Exception e) {
			CommonHelper.reportFailure("Enter BSOL Form Details was unsuccessful");
			e.printStackTrace();
		}

	}

	public void verifyPardotForm() {

		try {
			Thread.sleep(2000);
			ArrayList<String> tabs2 = new ArrayList<String>(driver.getWindowHandles());
			driver.switchTo().window(tabs2.get(1));
			driver.manage().window().maximize();
			// String text = driver.findElement(By.id("HeadSection")).toString();
			/*
			 * driver.switchTo().window(
			 * "https://www.bsigroup.com/en-GB/standards/british-standards-online-database/find-out-more/thank-you-for-your-enquiry/"
			 * );
			 */
			System.out.println("switched to 2nd tab");

			test.log(LogStatus.INFO, "Verify Pardot Form");
			Log.info("Verify Pardot Form");
			System.out.println("Verify Pardot Form");
			Thread.sleep(5000);

			CommonHelper.elementToBeVisible("verifyBSOLPardotSubmit_css");
			String verifyBSOLPardotSubmit = driver.findElement(By.cssSelector("h1[class='page-title']")).getText();
			// String verifyBSOLPardotSubmit =
			// CommonHelper.element("verifyBSOLPardotSubmit_css").getText();
			Log.info("The Verfication message is: " + verifyBSOLPardotSubmit);
			System.out.println("The Verfication message is: " + verifyBSOLPardotSubmit);

			if (verifyBSOLPardotSubmit.contains("Thank you for your enquiry")) {
				System.out.println("Verification of Pardot Form successful");
				test.log(LogStatus.PASS, "Verification of Pardot Form successful");
			} else {
				System.out.println("The verification message is: " + verifyBSOLPardotSubmit);
				CommonHelper.reportFailure("The verification message is: " + verifyBSOLPardotSubmit);
			}

			/*
			 * List<WebElement> verificationText =
			 * driver.findElements(By.xpath("//div[@id='CenterContent']/h1") );
			 * Thread.sleep(5000); test.log(LogStatus.INFO, "Verify BSOL Pardot Form");
			 * Log.info( "Verify BSOL Pardot Form"); System.out.println(
			 * "Verify BSOL Pardot Form");
			 * CommonHelper.elementToBeVisible("verifyPardotSubmit_xpath"); //String
			 * verifyPardotSubmit =
			 * CommonHelper.element("verifyPardotSubmit_xpath").getText(); String
			 * verifyPardotSubmit = verificationText.get(3).getText() +
			 * verificationText.get(4).getText(); Log.info( "The Verfication message is: " +
			 * verifyPardotSubmit); System.out.println("The Verfication message is: " +
			 * verifyPardotSubmit); test.log(LogStatus.PASS,
			 * "Verification of BSOL Pardot Form successful");
			 */

			driver.close();
			driver.switchTo().window(tabs2.get(0));
			System.out.println("switched back to to 1st tab");
			Thread.sleep(2000);

		} catch (Exception e) {
			CommonHelper.reportFailure("Verification of Pardot Form was unsuccessful");
			e.printStackTrace();
			Assert.fail(e.getMessage());
		}
	}

	public void clickCN() {

		try {

			test.log(LogStatus.INFO, "Click on Subscriptions Compliance Navigator");
			System.out.println("Mousehover Subscriptions");
			CommonHelper.elementToBeVisible("subscriptions_xpath");
			mouseHover("subscriptions_xpath");
			Log.info("Click on Subscriptions Compliance Navigator");
			System.out.println("Click on Compliance Navigator");
			CommonHelper.elementToBeClickable("compNavMenu_xpath");
			click("compNavMenu_xpath");

		} catch (Exception e) {
			CommonHelper.reportFailure("Click on Subscriptions Compliance Navigator was unsuccessful");
			e.printStackTrace();
			Assert.fail(e.getMessage());
		}

	}

	public void enterCNPardotDetails() {
		try {
			System.out.println("Switch iFrame");
			driver.switchTo().frame(0);
			Thread.sleep(3000);
			System.out.println("iframe switched");

			boolean clickHere = driver.findElement(By.xpath("/html/body/form/p[1]/span/a")).isDisplayed();
			Thread.sleep(2000);

			if (clickHere)
				if (CommonHelper.element("clickHere_xpath") != null
						|| CommonHelper.element("clickHere_xpath").isDisplayed()) {
					test.log(LogStatus.INFO, "Click on the Click Here link");
					System.out.println("Click on the Click Here link");
					Log.info("Click on the Click Here link");
					driver.findElement(By.xpath("//*[@id='pardot-form']/p[1]/span/a")).click();
					// click("clickHere_xpath");
					CommonHelper.elementToBeClickable("firstNameCN_xpath");
					CommonHelper.isElementVisible("firstNameCN_xpath");

					test.log(LogStatus.INFO, "Enter Compliance Navigator Pardot Form Details");
					System.out.println("Enter Compliance Navigator Pardot Form Details");
					Log.info("Enter Compliance Navigator Pardot Form Details");
					enterCNPardotFormDetails();

				} else {

					test.log(LogStatus.INFO, "Enter Compliance Navigator Pardot Form Details");
					System.out.println("Enter Compliance Navigator Pardot Form Details");
					Log.info("Enter Compliance Navigator Pardot Form Details");
					// CommonHelper.isVisisble("title_css");
					// CommonHelper.elementToBeClickable("title_css");
					enterCNPardotFormDetails();
				}
		} catch (Exception e) {
			CommonHelper.reportFailure("Enter Pardot Form details was unsuccessful");
			Assert.fail(e.getMessage());
			e.printStackTrace();
		}

	}

	public void enterCNPardotFormDetails() {

		try {

			/*
			 * test.log(LogStatus.INFO, "Select title"); System.out.println(
			 * "Select title"); Log.info("Select title"); selectFirstOption("title_css");
			 */
			Thread.sleep(2000);
			test.log(LogStatus.INFO, "Enter First Name");
			System.out.println("Enter First Name");
			Log.info("Enter First Name");
			enterText("firstNameCN_xpath", "Comp Nav First Name");

			test.log(LogStatus.INFO, "Enter Last Name");
			System.out.println("Enter Last Name");
			Log.info("Enter Last Name");
			enterText("lastNameCN_xpath", "Comp Nav Last Name");

			test.log(LogStatus.INFO, "Enter Email");
			System.out.println("Enter Email");
			Log.info("Enter Email");
			enterText("emailCN_xpath", "compNav@tcs.com");

			test.log(LogStatus.INFO, "Enter Phone");
			System.out.println("Enter Phone");
			Log.info("Enter Phone");
			enterText("phoneCN_xpath", "1324648589");

			test.log(LogStatus.INFO, "Enter Job Title");
			System.out.println("Enter Job Title");
			Log.info("Enter Job Title");
			enterText("jobTitleCN_xpath", "Comp Nav Job");

			test.log(LogStatus.INFO, "Enter Company");
			System.out.println("Enter Company");
			Log.info("Enter Company");
			enterText("companyCN_xpath", "Comp Nav Company");

			test.log(LogStatus.INFO, "Select Country");
			System.out.println("Select Country");
			Log.info("Select Country");
			selectFirstOption("countryCN_xpath");

			test.log(LogStatus.INFO, "Select How would you like to be contacted?");
			System.out.println("Enter How would you like to be contacted?");
			Log.info("Enter How would you like to be contacted?");
			List<WebElement> checkBox = driver.findElements(By.cssSelector("input[type='checkbox']"));
			checkBox.get(0).click();

			test.log(LogStatus.INFO, "Select Terms and Conditions");
			System.out.println("Select Terms and Conditions");
			Log.info("Select Terms and Conditions");
			checkBox.get(4).click();

			test.log(LogStatus.INFO, "Click on Send your Enquiry");
			System.out.println("Click on Send your Enquiry");
			Log.info("Click on Send your Enquiry");
			CommonHelper.scrolltoview("sendEnquiry_xpath");
			click("sendEnquiry_xpath");

		} catch (Exception e) {
			CommonHelper.reportFailure("Enter Compliance Navigator Form Details was unsuccessful");
			e.printStackTrace();
			Assert.fail(e.getMessage());
		}

	}

	public void clickEurocodes() {

		try {

			test.log(LogStatus.INFO, "Click on Subscriptions Eurocodes");
			System.out.println("Mousehover Subscriptions");
			CommonHelper.elementToBeVisible("subscriptions_xpath");
			mouseHover("subscriptions_xpath");
			Log.info("Click on Subscriptions Eurocodes");
			System.out.println("Click on Eurocodes");
			CommonHelper.elementToBeClickable("eurocodeMenu_xpath");
			click("eurocodeMenu_xpath");

		} catch (Exception e) {
			CommonHelper.reportFailure("Click on Subscriptions Eurocodes was unsuccessful");
			e.printStackTrace();
			Assert.fail(e.getMessage());
		}

	}

	public void enterEurocodePardotDetails() {

		try {

			System.out.println("Switch iFrame");
			driver.switchTo().frame(0);
			Thread.sleep(3000);
			System.out.println("iframe switched");

			boolean clickHere = driver.findElement(By.xpath("/html/body/form/p[1]/span/a")).isDisplayed();

			if (clickHere)
				if (CommonHelper.element("clickHere_xpath") != null
						|| CommonHelper.element("clickHere_xpath").isDisplayed()) {
					test.log(LogStatus.INFO, "Click on the Click Here link");
					System.out.println("Click on the Click Here link");
					Log.info("Click on the Click Here link");
					click("clickHere_xpath");
					CommonHelper.isElementVisible("firstNameEC_xpath");
					CommonHelper.elementToBeClickable("firstNameEC_xpath");

					test.log(LogStatus.INFO, "Enter Eurocode Pardot Form Details");
					System.out.println("Enter Eurocode Pardot Form Details");
					Log.info("Enter Eurocode Pardot Form Details");
					enterEurocodePardotFormDetails();

				} else {

					test.log(LogStatus.INFO, "Enter Eurocode Pardot Form Details");
					System.out.println("Enter Eurocode Pardot Form Details");
					Log.info("Enter Eurocode Pardot Form Details");
					CommonHelper.isElementVisible("firstNameEC_xpath");
					CommonHelper.elementToBeClickable("firstNameEC_xpath");
					enterEurocodePardotFormDetails();
				}
		} catch (Exception e) {
			CommonHelper.reportFailure("Enter Eurocode Pardot Form details was unsuccessful");
			Assert.fail(e.getMessage());
			e.printStackTrace();
		}

	}

	public void enterEurocodePardotFormDetails() {

		try {

			/*
			 * test.log(LogStatus.INFO, "Select title"); System.out.println(
			 * "Select title"); Log.info("Select title"); selectFirstOption("title_css");
			 */

			test.log(LogStatus.INFO, "Enter First Name");
			System.out.println("Enter First Name");
			Log.info("Enter First Name");
			enterText("firstNameEC_xpath", "Eurocodes First Name");

			test.log(LogStatus.INFO, "Enter Last Name");
			System.out.println("Enter Last Name");
			Log.info("Enter Last Name");
			enterText("lastNameEC_xpath", "Eurocodes Last Name");

			test.log(LogStatus.INFO, "Enter Company");
			System.out.println("Enter Company");
			Log.info("Enter Company");
			enterText("companyEC_xpath", "Eurocodes Company");

			test.log(LogStatus.INFO, "Enter Job Title");
			System.out.println("Enter Job Title");
			Log.info("Enter Job Title");
			enterText("jobTtileEC_xpath", "Eurocodes Job Title");

			test.log(LogStatus.INFO, "Enter Email");
			System.out.println("Enter Email");
			Log.info("Enter Email");
			enterText("emailEC_xpath", "euro@tcs.com");

			test.log(LogStatus.INFO, "Enter Phone");
			System.out.println("Enter Phone");
			Log.info("Enter Phone");
			enterText("phoneEC_xpath", "1324648589");

			test.log(LogStatus.INFO, "Select Country");
			System.out.println("Select Country");
			Log.info("Select Country");
			selectFirstOption("countryEC_xpath");

			test.log(LogStatus.INFO, "Select How would you like to be contacted?");
			System.out.println("Enter How would you like to be contacted?");
			Log.info("Enter How would you like to be contacted?");
			List<WebElement> checkBox = driver.findElements(By.cssSelector("input[type='checkbox']"));
			checkBox.get(0).click();

			test.log(LogStatus.INFO, "Select Terms and Conditions");
			System.out.println("Select Terms and Conditions");
			Log.info("Select Terms and Conditions");
			checkBox.get(4).click();

			test.log(LogStatus.INFO, "Click on Send your Enquiry");
			System.out.println("Click on Send your Enquiry");
			Log.info("Click on Send your Enquiry");
			CommonHelper.scrolltoview("sendEnquiry_xpath");
			click("sendEnquiry_xpath");

		} catch (Exception e) {
			CommonHelper.reportFailure("Enter Compliance Navigator Form Details was unsuccessful");
			e.printStackTrace();
			Assert.fail(e.getMessage());
		}

	}

}
