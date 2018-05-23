package com.tcs.BsiShopRedesign.utilities;

//http://relevantcodes.com/Tools/ExtentReports2/javadoc/index.html?com/relevantcodes/extentreports/ExtentReports.html

import java.io.File;
import java.util.Date;

import com.relevantcodes.extentreports.DisplayOrder;
import com.relevantcodes.extentreports.ExtentReports;

public class ExtentManager {
	private static ExtentReports extent;

	public static ExtentReports getInstance() {
		if (extent == null) {
			Date d = new Date();
			String fileName = d.toString().replace(":", "_").replace(" ", "_") + ".html";
			//String projectPath = System.getProperty("user.dir");
			//String reportPath = projectPath + "\\reports\\" + fileName;
			// String demoReportPath = "C:\\Users\\529373\\Desktop\\BSI
			// Automation Demo\\reports" + fileName;
			String reportPath ="D:\\BSI_Workspace\\BsiShopRedesign\\reports\\" + fileName;
		
			
			extent = new ExtentReports(reportPath, true, DisplayOrder.OLDEST_FIRST);
			extent.loadConfig(new File(System.getProperty("user.dir") + "//ReportsConfig.xml"));
			// optional
			// extent.addSystemInfo("User Name", "TCS").addSystemInfo("Host
			// Name", "--").addSystemInfo("Selenium Version",
			// "3.8.0").addSystemInfo(
			// "Environment",
			// "https://qa2-dh6pqni-7redg7uykvdko.eu.magentosite.cloud/").addSystemInfo("Browser",
			// "Chrome v63");
		}
		return extent;
	}
}
