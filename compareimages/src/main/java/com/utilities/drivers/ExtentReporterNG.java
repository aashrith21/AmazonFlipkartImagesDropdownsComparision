package com.utilities.drivers;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentReporterNG {
	 

	public static ExtentReports getReportObject() {
		String path = System.getProperty("user.dir")+"\\reports\\index.html";
		ExtentSparkReporter reporter = new ExtentSparkReporter(path);
		reporter.config().setReportName("Comparing Amazon Flipkart DropDowns and Images");
		
		
		ExtentReports extent = new ExtentReports();
		extent.attachReporter(reporter);
		//extent.createTest(path);
		return extent;
	}
}
