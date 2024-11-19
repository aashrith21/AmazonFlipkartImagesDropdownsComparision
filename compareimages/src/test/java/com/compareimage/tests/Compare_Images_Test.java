package com.compareimage.tests;


import org.testng.annotations.Test;

import java.io.IOException;
import java.util.HashSet;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.compareimage.TestComponents.Retry;
import com.pages.ecomsites.Amazon_Home_Page;
import com.pages.ecomsites.Ecom_Landing_Pages;
import com.pages.ecomsites.Flipkart_Home_Page;
import com.utilities.drivers.Drivers;



public class Compare_Images_Test extends Drivers {
		
	Ecom_Landing_Pages ecom = new Ecom_Landing_Pages();
	
  @Test(retryAnalyzer=Retry.class)
	public void compareImagesDropdownsMethod1() throws IOException  {
	  
	  driver = getDriver();
	  ecom.amazonLandingPage(driver);
	  ecom.flipkartLandingPage(driver);
	  ecom.imageComparision(driver);
	  ecom.closeBrowser(driver);
		
	}

  

  @Test(retryAnalyzer=Retry.class)
  public void compareImagesDropdownsMethod2()  {
	  
	  
	driver = getDriver();

	//Amazon object initialization 
	
	Amazon_Home_Page amazon = new Amazon_Home_Page();
	
	
	// Fetching count by respective websites

	amazon.launchAmazonHomepage(driver);
	amazon.printAmazonDropdownCount(driver);
	amazon.printnoofImages(driver);
	amazon.closeBrowser(driver);
	
	
	//Flipkart object initialization 
	
	Flipkart_Home_Page flipkart = new Flipkart_Home_Page();
	
	flipkart.launchFlipkartHomepage(driver);
	flipkart.printFlipkartDropdownscount(driver);
	flipkart.printNoofImages(driver);
	flipkart.closeBrowser(driver);
	
		
	HashSet<String> common= new HashSet<>();
		 
		//if(amazonimagesrc.equals(flipkartimagesrc)) {
		for (String amazonimage : amazon.amazonimagesrc  ) {
						
							for(String flipkartimage : flipkart.flipkartimagesrc) {
								
								if(amazonimage == flipkartimage) {
									common.add(amazonimage);
									
								}
									
							}
					
				}
			
	   
	
		
		System.out.println("Number of common images between Amazon and Flipkart :"+""+common.size());
		System.out.println("Common images between Amazon and Flipkart           :"+""+common);
		
	}
  
  
  

   
 
}
