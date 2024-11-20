package com.compareimage.TestComponents;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.Writable;
import com.compareimage.tests.Compare_Images_Test;
import com.utilities.drivers.ExtentReporterNG;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.*;
import com.utilities.drivers.Drivers;

public class Listeners extends Compare_Images_Test implements ITestListener{
	
	ExtentReports extent = ExtentReporterNG.getReportObject();
	ExtentTest test;
	ThreadLocal extentTest = new ThreadLocal();

	@Override
	public void onTestStart(ITestResult result) {
		test = extent.createTest(result.getMethod().getMethodName());
		extentTest.set(test);
		
	}
	
	@Override
	public void onTestSuccess(ITestResult result) {
		
		
		try {
			        int countofamazondropdowns =  result.getTestClass().getRealClass().getField("countofamazondropdowns").getInt(result.getInstance());
					
			        int countofamazonimages = (int) result.getTestClass().getRealClass().getField("countofamazonimages")
											.get(result.getInstance());
			        int countofflipkartdropdowns =(int) result.getTestClass().getRealClass().getField("countofflipkartdropdowns")
					 						.get(result.getInstance());
			        int countofflipkartimages = (int) result.getTestClass().getRealClass().getField("countofflipkartimages")
					 						.get(result.getInstance());
			        driver = (WebDriver) result.getTestClass().getRealClass().getField("driver")
					 						.get(result.getInstance());
					
			if(result.getMethod().getMethodName() == "compareImagesDropdownsMethod1") {
				    test.assignAuthor("Aashrith");
				    test.addScreenCaptureFromPath(getScreenshot(result.getMethod().getMethodName(),driver));
				    test.log(Status.PASS, "Test passed successfully");
				    test.log(Status.INFO,"Number of DropDowns present in Amazon homepage:"+countofamazondropdowns);
				    test.log(Status.INFO,"Number of Images present in Amazon homepage:"+countofamazonimages);
				    test.log(Status.INFO,"Number of DropDowns present in Flipkart homepage:"+countofflipkartdropdowns);
				    test.log(Status.INFO,"Number of Images present in Flipkart homepage:"+countofflipkartimages);
				    test.log(Status.INFO,"Number of common images between Amazon and Flipkart :"+""+common.size());
				    test.log(Status.INFO,"Common images between Amazon and Flipkart :"+common);
			}
			else if (result.getMethod().getMethodName() == "compareImagesDropdownsMethod2") {
				    int countofamazondropdowns2 =  (int) result.getTestClass().getRealClass().getField("countofamazondropdowns")
						.get(result.getInstance());
				    int countofamazonimages2 = (int) result.getTestClass().getRealClass().getField("countofamazonimages")
						.get(result.getInstance());
				    int countofflipkartdropdowns2 =(int) result.getTestClass().getRealClass().getField("countofflipkartdropdowns")
						.get(result.getInstance());
				    int countofflipkartimages2 = (int) result.getTestClass().getRealClass().getField("countofflipkartimages")
						.get(result.getInstance());
				    driver = (WebDriver) result.getTestClass().getRealClass().getField("driver")
						.get(result.getInstance());
				
					test.assignAuthor("Aashrith");
					test.addScreenCaptureFromPath(getScreenshot(result.getMethod().getMethodName(),driver));
					test.log(Status.PASS, "Test passed successfully");
					test.log(Status.INFO,"Number of DropDowns present in Amazon homepage:"+countofamazondropdowns2);
					test.log(Status.INFO,"Number of Images present in Amazon homepage:"+countofamazonimages2);
					test.log(Status.INFO,"Number of DropDowns present in Flipkart homepage:"+countofflipkartdropdowns2);
					test.log(Status.INFO,"Number of Images present in Flipkart homepage:"+countofflipkartimages2);
					test.log(Status.INFO,"Number of common images between Amazon and Flipkart :"+""+common.size());
					test.log(Status.INFO,"Common images between Amazon and Flipkart :"+common);
				}
			
			
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@Override
	public void onTestFailure(ITestResult result) {
		
		
		
		
		
		try {
			driver = (WebDriver) result.getTestClass().getRealClass().getField("driver")
					.get(result.getInstance());
			test.assignAuthor("Aashrith");
			test.addScreenCaptureFromPath(getScreenshot(result.getMethod().getMethodName(),driver));
			test.fail(result.getThrowable());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		
		} 
			
			
		
	}
	
	
	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		// TODO Auto-generated method stub
		ITestListener.super.onTestFailedButWithinSuccessPercentage(result);
	}

	@Override
	public void onTestFailedWithTimeout(ITestResult result) {
		// TODO Auto-generated method stub
		ITestListener.super.onTestFailedWithTimeout(result);
	}


	@Override
	public void onTestSkipped(ITestResult result) {
		
	}
	
	@Override
	public void onFinish(ITestContext result) {
		extent.flush();
		
	}
	

}
