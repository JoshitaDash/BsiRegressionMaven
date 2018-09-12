package com.tcs.BsiShopRedesign.sprint8;

import org.testng.Assert;
import org.testng.annotations.Test;
import com.relevantcodes.extentreports.LogStatus;
import com.tcs.BsiShopRedesign.pages.HomePage;
import com.tcs.BsiShopRedesign.pages.ProductPage;
import com.tcs.BsiShopRedesign.pages.SearchPage;
import com.tcs.BsiShopRedesign.utilities.BaseTest;
import com.tcs.BsiShopRedesign.utilities.CommonHelper;

public class VerifyPDFPreviewing extends BaseTest {

	public VerifyPDFPreviewing() throws Exception {
		super();
	}

	@Test(priority = 1, enabled = true)
	public void verifyMemberLink() {

		try {
			test = extent.startTest("Sprint 8 - Ecom-55 AC#66, 68__ PDF Reviewing");
			System.out.println("Perform Blank Search");
			Log.info("Perform Blank Search");
			HomePage home = new HomePage(driver);
			home.blankSearch();

			System.out.println("Verfiy search result");
			Log.info("Verfiy search result");
			SearchPage search = new SearchPage(driver);
			search.verifySearchResultforBlankSearch();

			System.out.println("Click on Product");
			Log.info("Click on Product");
			search.clickProductOnSearchList();

			System.out.println("Click on Product");
			Log.info("Click on Product");
			ProductPage prod = new ProductPage(driver);
			prod.clickLookInside();

			System.out.println("Verify PDF Previewing Image");
			Log.info("Verify PDF Previewing Image");
			prod.verifyPDFPreview();

		} catch (Exception e) {
			test.log(LogStatus.FATAL, "Verify PDF Previewing Image was unsuccessful");
			CommonHelper.reportFailure("Verify PDF Previewing Image was unsuccessful");
			e.printStackTrace();
			Assert.fail(e.getMessage());
		}
	}

	@Test(priority = 2, enabled = true)
	public void verifyPDFPreviewFeatures() {

		try {
			System.out.println("Verify PDF Previewing Zoom In");
			Log.info("Verify PDF Previewing Zoom In");
			ProductPage prod = new ProductPage(driver);
			prod.verifyPDFZoomIn();

			System.out.println("Verify PDF Previewing Zoom Out");
			Log.info("Verify PDF Previewing Zoom Out");
			prod.verifyPDFZoomOut();

			System.out.println("Verify PDF Previewing Save");
			Log.info("Verify PDF Previewing Save");
			prod.verifyPDFSave();

			System.out.println("Verify PDF Previewing Print");
			Log.info("Verify PDF Previewing Print");
			prod.verifyPDFPrint();

			System.out.println("Verify PDF Previewing Close Window");
			Log.info("Verify PDF Previewing Close Window");
			prod.verifyPDFCloseWindow();

		} catch (Exception e) {
			test.log(LogStatus.FATAL, "Verify PDF Previewing was unsuccessful");
			CommonHelper.reportFailure("Verify PDF Previewing was unsuccessful");
			e.printStackTrace();
		}

	}
}
