package com.framework.base;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.SkipException;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.framework.utils.initProperties;
import com.framework.utils.reportManager;

public class basetest extends initProperties {
	protected WebDriver driver;
	public ExtentReports extentReport;
	public ExtentTest ExtentTest;
	public genericKeywords app;

	@BeforeTest(alwaysRun = true)
	public void init(ITestContext context) {
		app = new genericKeywords();
		initProperty();
		extentReport = reportManager.getReport();
		ExtentTest = extentReport.createTest(context.getCurrentXmlTest().getName());
		app.setTest(ExtentTest);
		context.setAttribute("extentReport", extentReport);
		context.setAttribute("ExtentTest", ExtentTest);
		context.setAttribute("app", app);
	}

	@BeforeMethod(alwaysRun = true)
	public void setUp(ITestContext context) {
		app = (genericKeywords) context.getAttribute("app");
		extentReport = (ExtentReports) context.getAttribute("extentReport");
		ExtentTest = (ExtentTest) context.getAttribute("ExtentTest");
		String isCriticalFailute = (String) context.getAttribute("isCriticalFailure");
		if (isCriticalFailute != null && isCriticalFailute.equals("true")) {
			app.logSkip("Skip due to error from previous test");
			throw new SkipException("Skip due to error from previous test");
		}
		driver = DriverManager.getDriver(prop.getProperty("browser"));
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));
		driver.get(initProperties.prop.getProperty("url"));
	}

	@AfterTest
	public void tearDown() {
		if (extentReport != null) {
			extentReport.flush();
		}
		driver.quit();
	}

	public void validateTitle(String expectedTitle) {

		boolean isTitleMatch = driver.getTitle().equals(expectedTitle);
		if (isTitleMatch) {
			genericKeywords.logInfo("Title is correct");
		} else {
			genericKeywords.reportFailure("Title is incorrect." + " Actual title: " + driver.getTitle() + "<---->"
					+ " Expected Title: " + expectedTitle, true);
		}

	}

}
