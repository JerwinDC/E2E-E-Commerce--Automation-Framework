package com.framework.base;

import org.testng.Reporter;
import org.testng.asserts.SoftAssert;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

public class genericKeywords {
	public static SoftAssert softAssert;
	public static ExtentTest test;
	
	public genericKeywords() {
		softAssert = new SoftAssert();
	}
	
	public void setTest(ExtentTest test) {
		this.test = test;
	}
	
	public static void logError(String msg) {
		test.log(Status.FAIL, msg);
	}
	
	public void logSkip(String msg) {
		test.log(Status.SKIP, msg);
	}
	
	public static void logInfo(String msg) {
		test.log(Status.INFO, msg);
	}
	
	public void reportFailure(String msg) {
		reportFailure(msg, false);
	}
	
	public static void reportFailure(String msg, Boolean isCriticalFailure) {
		logError(msg);
		softAssert.fail();
		
		if(isCriticalFailure) {
			Reporter.getCurrentTestResult().getTestContext().setAttribute("isCriticalFailure", "true");
			reportAll();
		}
	}
	
	public static void reportAll() {
		softAssert.assertAll();
	}
	

}
