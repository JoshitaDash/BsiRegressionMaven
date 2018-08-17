package com.tcs.BsiShopRedesign.sprint2;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.LogStatus;
import com.tcs.BsiShopRedesign.pages.DownloadMMPage;
import com.tcs.BsiShopRedesign.pages.HomePage;
import com.tcs.BsiShopRedesign.pages.SignInPage;
import com.tcs.BsiShopRedesign.utilities.BaseTest;
import com.tcs.BsiShopRedesign.utilities.CommonHelper;

public class DownloadMarketingMaterial extends BaseTest {

	public DownloadMarketingMaterial() throws Exception {
		super();
	}

	@Test(priority = 1, enabled = true)
	public void signIn() {

		try {
			test = extent.startTest("Sprint 2 - Registered User Sign In");
			System.out.println("Registered User Sign In");
			Log.info("Registered User Sign In");
			SignInPage signIn = new SignInPage(driver);
			signIn.login();
		}

		catch (Exception e) {
			test.log(LogStatus.FATAL,"Registered User signing in was unsuccessful");
			CommonHelper.reportFailure("Registered User signing in was unsuccessful");
			e.printStackTrace();
			Assert.fail(e.getMessage());
		}
	}

	@Test(priority = 2, enabled = true)
	public void downloadPASMM() {

		WebDriverWait wait = new WebDriverWait(driver, 120);

		try {

			test = extent.startTest("Sprint 2 - Ecom-59 AC#77 ___Search product and Download Marketing Material");
			Log.info("Enter product name in Search textbox");
			System.out.println("Enter product name in Search textbox");
			test.log(LogStatus.INFO, "Enter product name in Search textbox");
			WebElement search = wait.until(ExpectedConditions.elementToBeClickable(By.id("search")));
			search.clear();
			search.sendKeys("Governance & Resilience");

			Log.info("Click on Search");
			System.out.println("Click on Search");
			test.log(LogStatus.INFO, "Click on Search");
			CommonHelper.elementToBeClickable("searchButton_css");
			click("searchButton_css");

			Log.info("Select the Product");
			System.out.println("Select the Product");
			test.log(LogStatus.INFO, "Select the Product");
			WebElement product = driver.findElement(By.linkText("Governance & Resilience"));
			String name = product.toString();
			CommonHelper.elementToBeClickable(name);
			product.click();

			Log.info("Click Download Now");
			System.out.println("Click Download Now");
			DownloadMMPage down = new DownloadMMPage(driver);
			down.clickDownloadNow();
			
			Log.info("Enter Pardot Details");
			System.out.println("Enter Pardot Details");
			down.enterGRPardotDetails();
			
			Log.info("Verify Governance Resilience pdf download");
			System.out.println("Verify Governance Resilience pdf download");
			down.verifyPdf();

			/*System.out.println("Click Logout");
			Log.info("Click Logout");
			HomePage event = new HomePage(driver);
			event.clickLogout();*/

		} catch (Exception e) {
			test.log(LogStatus.FATAL, "Download Materials for Governance Resilience product was unsuccessful");
			CommonHelper.reportFailure("Download Materials for Governance Resilience product was unsuccessful");
			e.printStackTrace();
			Assert.fail(e.getMessage());
		}

	}
}
