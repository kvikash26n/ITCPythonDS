package com.cctv.utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.lang.reflect.Method;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Properties;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;

import org.apache.log4j.Logger;
import org.apache.maven.shared.utils.io.FileUtils;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.UnexpectedAlertBehaviour;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.logging.LogType;
import org.openqa.selenium.logging.LoggingPreferences;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;

import com.cctv.pages.LoginPage;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class TestBase {

	public static WebDriver driver;
	public static String log4jPropertyFilePath = System.getProperty("user.dir")
			+ "\\src\\main\\resources\\log4j.properties";
	protected final static Logger log = Logger.getLogger(TestBase.class.getName());
	public static ExtentReports extentReport;
	public static ExtentTest extentTest;
	public static Properties prop;
	public FileInputStream fis = null;
	public GenericUtilities util;
	static String chromeDriverPath = System.getProperty("user.dir") + "\\drivers\\chromedriver.exe";
	static String gerkoDriverPath = System.getProperty("user.dir") + "\\drivers\\geckodriver.exe";
	static String extentReportPath = System.getProperty("user.dir") + "\\extentReports";
	static String extentConfigFilePath = System.getProperty("user.dir") + "\\src\\main\\resources\\extent-config.xml";
	LoginPage loginPage;

	static {

		extentReport = new ExtentReports(System.getProperty("user.dir") + "\\extentReports\\"
				+ new SimpleDateFormat("dd_mm_yyyy_hh_mm_ss").format(Calendar.getInstance().getTime()) + ".html",
				false);
		extentReport.loadConfig(new File(extentConfigFilePath));
		extentReport.addSystemInfo(" App env", "Dev2");
		extentReport.addSystemInfo("Tester", "Alok");

	}

	public TestBase() {

		prop = new Properties();
		try {
			fis = new FileInputStream(System.getProperty("user.dir") + "\\src\\main\\resources\\config.properties");
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		try {
			prop.load(fis);
		} catch (IOException e) {
			e.printStackTrace();
		}
		// This will initialize page factory web elements of the class who extends this class.
		PageFactory.initElements(driver, this);
	}

	public WebDriver getDriver() {
		return driver;
	}

	@BeforeMethod()
	public void driverAndExtentReportSetup(Method method) {
		System.out.println(" testbase before method");
		initialization();
		loginPage = new LoginPage();
		try {
			loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
		} catch (Exception e) {

			e.printStackTrace();
		}
		extentTest = extentReport.startTest(method.getName());
		extentTest.log(LogStatus.INFO, method.getName() + " test started");
	}

	@AfterMethod()
	public void afterMethod(ITestResult result) {

		getResult(result);

		if (result.getStatus() == ITestResult.SUCCESS) {

			util = new GenericUtilities();
			String screenshot = util.takeScreenShot(result.getName());

			String image = extentTest.addScreenCapture(screenshot);
			extentTest.log(LogStatus.PASS, "title verification", image);

		}

		else if (result.getStatus() == ITestResult.FAILURE) {
			util = new GenericUtilities();
			String screenshot = util.takeScreenShot(result.getName());

			String image = extentTest.addScreenCapture(screenshot);
			extentTest.log(LogStatus.FAIL, image);
		}

		driver.quit();
	}

	@BeforeClass

	public void thisClassTestStarted() {

		log.info("***** Test case execution of Class " + getClass().getName() + "started******");
	}

	@AfterClass(alwaysRun = true)
	public void endTest() {

		log.info("***************All test cases of Class " + getClass().getName() + " executed******");

	}

	@AfterSuite(alwaysRun = true)
	public void tearDown() throws Exception {
		// to delete directory
		FileUtils.deleteDirectory(extentReportPath);
		FileUtils.mkdir(extentReportPath);
		// extent report related code below
		extentReport.endTest(extentTest);
		extentReport.flush();
		Thread.sleep(3000);
		
		// to send extent report in email.
		try {
		SendMailSSLWithAttachment.sendReportByEmail(prop.getProperty("fromEmail"), prop.getProperty("fromEmailPassword"),  prop.getProperty("toEmail")); }
		
		catch(Exception e) {
			
			log.error(" Emailing of report failed :  "+e);
		}
		
		log.info("*********** All test classes run. Extent report generated and put in : " + extentReportPath
				+ " .Quitting browser**********");

	}

	// extent report related
	public void getResult(ITestResult result) {
		if (result.getStatus() == ITestResult.SUCCESS) {
			extentTest.log(LogStatus.PASS, result.getName() + " test is pass");
		} else if (result.getStatus() == ITestResult.SKIP) {

			extentTest.log(LogStatus.SKIP,
					result.getName() + " Test is skipped and reason is : " + result.getThrowable());
		} else if (result.getStatus() == ITestResult.FAILURE) {

			extentTest.log(LogStatus.ERROR,
					result.getName() + " Test is failed and reason is : " + result.getThrowable());
		}

		else if (result.getStatus() == ITestResult.STARTED) {

			extentTest.log(LogStatus.INFO, result.getName() + " - Test is started");
		}

	}

	public static void initialization() {

		String browserName = prop.getProperty("browser");

		String appURL = prop.getProperty("appURL");

		if (browserName.equalsIgnoreCase("chrome")) {
			// This chromedriver is enabled to catch browser f12 console JavaScript erros as
			// well. See method collectBrowserJSerrorMessages() in GenericUtilities as well.

			DesiredCapabilities cap = DesiredCapabilities.chrome();
			LoggingPreferences loggingPreferences = new LoggingPreferences();
			loggingPreferences.enable(LogType.BROWSER, Level.ALL);
			cap.setCapability(CapabilityType.LOGGING_PREFS, loggingPreferences);
			ChromeOptions options = new ChromeOptions();

			// Below code will start chrome in maximized mode
			// options.addArguments("--start-fullscreen");
			// Below code will remove message "Chrome is being controlled by... Software"
			options.addArguments("disable-infobars");
			options.addArguments("--no-sandbox");
			options.addArguments("--allow-insecure-localhost");

			// below code will run chrome in headless mode.
			// options.addArguments("--headless");
			options.addArguments("--disable-gpu");

			cap.setCapability(ChromeOptions.CAPABILITY, options);
			cap.setCapability(CapabilityType.UNEXPECTED_ALERT_BEHAVIOUR, UnexpectedAlertBehaviour.ACCEPT);

			System.setProperty("webdriver.chrome.driver", chromeDriverPath);
			driver = new ChromeDriver(cap);

			// log.info(" chromedriver is enabled to collect all console JavaScript errors
			// also .");

		} else if (browserName.equalsIgnoreCase("FF")) {
			System.setProperty("webdriver.gecko.driver", gerkoDriverPath);
			driver = new FirefoxDriver();
		}
		try {
			
			driver.manage().window().maximize();
			// Set good resolution for chrome to run smoothly in headless mode.
			// driver.manage().window().setSize(new Dimension(1600, 1200));
			driver.manage().deleteAllCookies();

			log.info("***********Window maximized and browser cookies deleted******");
		}

		catch (Exception e) {
			log.error(e);

		}
		// Eventfiring WebDriver setup. Comment below line if not required.
		// driver = new EventFiringWebDriver(driver).register(new WebEventListener());

		driver.manage().timeouts().pageLoadTimeout(Integer.parseInt((String) prop.get("PAGE_LOAD_TIMEOUT")),
				TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(Integer.parseInt((String) prop.get("IMPLICIT_WAIT")),
				TimeUnit.SECONDS);

		log.info("********* Launching " + browserName + " browser*****************");

		driver.get(appURL);
		log.info("********* Opening URL-- " + appURL + " *****************");
		// return driver;

	}
}