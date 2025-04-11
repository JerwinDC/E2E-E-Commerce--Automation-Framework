package com.framework.utils;

import java.util.Date;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class reportManager {
	public static ExtentReports report = null;
	public static ExtentSparkReporter spark = null;
	
	
	public static String generateReportFolder() {
		String reportPath, reportFolderName = null;
		Date date = new Date();
		reportFolderName = date.toString().replaceAll(":", "_").replaceAll(" ", "-" );
		reportPath = System.getProperty("user.dir") + "\\Reports\\" + reportFolderName;		
		return reportPath;
		
	}
	
	public static ExtentReports getReport() {
		
		if(report == null) {
			report = new ExtentReports();
		    try {
				spark = new ExtentSparkReporter(generateReportFolder());
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		    spark.config().setDocumentTitle("Test Report");
		    spark.config().setReportName("E-Commerce Test Report");
		    spark.config().setEncoding("utf-8");
		    
		    report.attachReporter(spark);
		}
		
		
		return report;
		
	}

}
