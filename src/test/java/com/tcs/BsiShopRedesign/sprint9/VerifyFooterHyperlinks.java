package com.tcs.BsiShopRedesign.sprint9;

import org.testng.annotations.Test;

import com.relevantcodes.extentreports.LogStatus;
import com.tcs.BsiShopRedesign.pages.HomePage;
import com.tcs.BsiShopRedesign.utilities.BaseTest;
import com.tcs.BsiShopRedesign.utilities.CommonHelper;

public class VerifyFooterHyperlinks extends BaseTest {

	public VerifyFooterHyperlinks() throws Exception {
		super();
	}

	@Test(priority = 1, enabled = true)
	public void otherServices() {
		try {

			test = extent.startTest("Sprint 9 - CM-16 AC#35,36 __Verify Other Services Hyperlinks");

			System.out.println("Verify Affiliate Programme");
			Log.info("Verify Affiliate Programme");
			test.log(LogStatus.INFO, "Verify Affiliate Programme");
			HomePage home = new HomePage(driver);
			home.verifyAffiliateProgramme();

			// Thread.sleep(2000);
			System.out.println("Verify Distributor Programme");
			Log.info("Verify Distributor Programme");
			test.log(LogStatus.INFO, "Verify Distributor Programme");
			home.verifyDistributorProgramme();

			// Thread.sleep(2000);
			System.out.println("Verify Licensing");
			Log.info("Verify Licensing");
			test.log(LogStatus.INFO, "Verify Licensing");
			home.verifyLicensing();

			System.out.println("Verify Newsletter");
			Log.info("Verify Newsletter");
			test.log(LogStatus.INFO, "Verify Newsletter");
			home.verifyNewsletter();

			System.out.println("Verify PAS");
			Log.info("Verify PAS");
			test.log(LogStatus.INFO, "Verify PAS");
			home.verifyPAS();

			System.out.println("Verify Worldwide Standards");
			Log.info("Verify Worldwide Standards");
			test.log(LogStatus.INFO, "Verify Worldwide Standards");
			home.verifyWorldwideStandards();

		} catch (Exception e) {
			test.log(LogStatus.FATAL, " Verify Other Services Hyperlinks was unsuccessful");
			CommonHelper.reportFailure(" Verify Other Services Hyperlinks was unsuccessful");
			e.printStackTrace();
		}
	}

	@Test(priority = 2, enabled = true)
	public void otherBSIWebsites() {
		try {

			test = extent.startTest("Sprint 9 - CM-16 AC#35,36 __Verify Other BSI Websites Hyperlinks");

			System.out.println("Verify BIM Level 2");
			Log.info("Verify BIM Level 2");
			test.log(LogStatus.INFO, "Verify BIM Level 2");
			HomePage home = new HomePage(driver);
			home.verifyBimLevel2();

			System.out.println("Verify BSI Group website");
			Log.info("Verify BSI Group website");
			test.log(LogStatus.INFO, "Verify BSI Group website");
			home.verifyBSIGroupWebsite();

			System.out.println("Verify BSOL: British Standards Online");
			Log.info("Verify BSOL: British Standards Online");
			test.log(LogStatus.INFO, "Verify BSOL: British Standards Online");
			home.verifyBritishStandardsOnline();

			System.out.println("Verify Compliance Navigator for Medical Devices");
			Log.info("Verify Compliance Navigator for Medical Devicese");
			test.log(LogStatus.INFO, "Verify Compliance Navigator for Medical Devices");
			home.verifyComplianceNavigatorMedicalDevices();

			System.out.println("Verify E-committees");
			Log.info("Verify E-committees");
			test.log(LogStatus.INFO, "Verify E-committees");
			home.verifyECommittees();

			System.out.println("Verify Eurocodes Plus");
			Log.info("Verify Eurocodes Plus");
			test.log(LogStatus.INFO, "Verify Eurocodes Plus");
			home.verifyEurocodesPlus();

			System.out.println("Verify Member Portal");
			Log.info("Verify Member Portal");
			test.log(LogStatus.INFO, "Verify Member Portal");
			home.verifyMemberPortal();
			
			System.out.println("Verify Perinorm");
			Log.info("Verify Perinorm");
			test.log(LogStatus.INFO, "Verify Perinorm");
			home.verifyPerinorm();
			
			System.out.println("Verify Standards Development");
			Log.info("Verify Standards Development");
			test.log(LogStatus.INFO, "Verify Standards Development");
			home.verifyStandardsDevelopment();

		} catch (Exception e) {
			test.log(LogStatus.FATAL, " Verify Other BSI Websites Hyperlinks was unsuccessful");
			CommonHelper.reportFailure(" Verify Other BSI Websites Hyperlinks was unsuccessful");
			e.printStackTrace();
		}
	}
}
