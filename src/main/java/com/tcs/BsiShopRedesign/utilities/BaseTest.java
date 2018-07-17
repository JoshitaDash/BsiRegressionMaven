package com.tcs.BsiShopRedesign.utilities;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.xml.DOMConfigurator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Parameters;

import com.relevantcodes.extentreports.LogStatus;

public class BaseTest extends Page {

	public BaseTest() throws Exception {
		super(driver);
	}

	public static String browser;
	String url = BsiConstants.getEnvDetails().get("url");
	

	@SuppressWarnings("deprecation")
	@Parameters("browser")
	@BeforeClass
	// *** Passing Browser parameter from TestNG xml
	public void launchBrowser(String browser) throws InterruptedException, IOException {

		try {
			DOMConfigurator.configure("log4j.xml");

			if (browser.equalsIgnoreCase("Chrome")) {

				Log.info("Launching Chrome browser");
				System.out.println("Launching Chrome browser");

				// **** setting up the path for my ChromeDriver
				String projectPath = System.getProperty("user.dir");
				System.setProperty("webdriver.chrome.driver", projectPath + "\\lib\\chromedriver.exe");
				driver = new ChromeDriver();
				// driver.manage().deleteAllCookies();
				Thread.sleep(1000);
				driver.manage().window().maximize();

				extent.addSystemInfo("User Name", "TCS").addSystemInfo("Host Name", "TCS")
						.addSystemInfo("Selenium Version", "3.8.0").addSystemInfo("Environment", url)
						.addSystemInfo("Browser", "Chrome 67.0");

			}

			else if (browser.equalsIgnoreCase("IE")) {
				String projectPath = System.getProperty("user.dir");
				DesiredCapabilities cap = null;
				System.setProperty("webdriver.ie.driver", projectPath + "\\\\lib\\\\IEDriverServer_Win32_3.9.0\\\\IEDriverServer.exe");
				/*System.setProperty("webdriver.ie.driver",
						"D:\\BSI_Workspace\\BsiShopRedesign\\lib\\IEDriverServer_Win32_3.9.0\\IEDriverServer.exe");*/
				cap = DesiredCapabilities.internetExplorer();
				cap.setCapability(CapabilityType.BROWSER_NAME, "internet explorer");
				cap.setCapability(InternetExplorerDriver.NATIVE_EVENTS, true);
				cap.setCapability(InternetExplorerDriver.IGNORE_ZOOM_SETTING, true);
				cap.setCapability(InternetExplorerDriver.INTRODUCE_FLAKINESS_BY_IGNORING_SECURITY_DOMAINS, true);
				cap.setPlatform(org.openqa.selenium.Platform.WINDOWS);
				cap.setCapability(InternetExplorerDriver.IE_ENSURE_CLEAN_SESSION, true);
				cap.setCapability(InternetExplorerDriver.ENABLE_PERSISTENT_HOVERING, false);
				cap.setCapability(CapabilityType.ACCEPT_SSL_CERTS, true);
				cap.setCapability("allow-blocked-content", true);
				cap.setCapability("allowBlockedContent", true);
				driver = new InternetExplorerDriver(cap);
				driver.manage().window().maximize();

				extent.addSystemInfo("User Name", "TCS").addSystemInfo("Host Name", "TCS")
						.addSystemInfo("Selenium Version", "3.8.0").addSystemInfo("Environment", url)
						.addSystemInfo("Browser", "Internet Explorer 11");

			} else if (browser.equalsIgnoreCase("Firefox")) {

				Log.info("Launching Firefox browser");
				System.out.println("Launching Firefox browser");

				// ****** setting up the path for my FirefoxDriver
				String projectPath = System.getProperty("user.dir");
				System.setProperty("webdriver.gecko.driver", projectPath + "\\lib\\geckodriver.exe");
				driver = new FirefoxDriver();
				Thread.sleep(2000);
				driver.manage().window().maximize();

				extent.addSystemInfo("User Name", "TCS").addSystemInfo("Host Name", "TCS")
						.addSystemInfo("Selenium Version", "3.8.0").addSystemInfo("Environment", url)
						.addSystemInfo("Browser", "Mozilla Firefox 61.0");

			} else if (driver == null) {
				System.out.println("The tescase is skipped");
				test.log(LogStatus.SKIP, "The tescase is skipped");
			}

			// ****** Doesn't the browser type, launch the Website
			System.out.println("Fetching the URL");
			driver.get(url);
			driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		}

		catch (WebDriverException e) {
			e.printStackTrace();
			System.out.println(e.getMessage());
		}

	}

	@AfterClass
	public void tearDown() throws InterruptedException {
		if (extent != null) {
			extent.endTest(test);
			System.out.println("Extent Report test ended");
			extent.flush();
		}
		if (driver != null) {
			Log.info("Close Browser");
			System.out.println("Close Browser");
			// driver.close();
			driver.quit();
		}

	}

	@BeforeSuite
	public WebDriver getDriverInstance() {
		return driver;
	}

}