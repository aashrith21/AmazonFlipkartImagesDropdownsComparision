package com.compareimage.tests;


import org.testng.annotations.Test;

import java.io.IOException;
import java.util.HashSet;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.pages.ecomsites.Amazon_Home_Page;
import com.pages.ecomsites.Ecom_Landing_Pages;
import com.pages.ecomsites.Flipkart_Home_Page;
import com.utilities.drivers.Drivers;

public class Compare_Images_Test extends Ecom_Landing_Pages {
	
  @Test
	public void compareImagesDropdownsMethod1() throws IOException  {
		System.out.println("*******Method 1 Output************");
		setDriver("Edge");
		amazonLandingPage();
		flipkartLandingPage();
		imageComparision();
	}

  

  @Test
  public void compareImagesDropdownsMethod2()  {
	  
	  System.out.println("*******Method 2 Output************");
	
	//Amazon object initialization 
	
	Amazon_Home_Page amazon = new Amazon_Home_Page();
	
	
	// Fetching count by respective websites
	amazon.launchAmazonHomepage();
	amazon.printAmazonDropdownCount();
	amazon.printnoofImages();
	amazon.closeBrowser();
	
	
	//Flipkart object initialization 
	
	Flipkart_Home_Page flipkart = new Flipkart_Home_Page();
	flipkart.launchFlipkartHomepage();
	flipkart.printFlipkartDropdownscount();
	flipkart.printNoofImages();
	flipkart.closeBrowser();
	
		
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
