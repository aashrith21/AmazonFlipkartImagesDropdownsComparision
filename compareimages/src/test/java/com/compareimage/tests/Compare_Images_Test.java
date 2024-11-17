package com.compareimage.tests;


import org.testng.annotations.Test;

import java.io.IOException;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;


import com.pages.ecomsites.Ecom_Landing_Pages;

public class Compare_Images_Test extends Ecom_Landing_Pages {
	
	

  

  @Test(testName = "Dropdowns and Images Test")
  public void compareImagesDropdownsTest() throws IOException {
	  
	 
	
	// Browser selection
	  
	setDriver("Edge");
	
	// Fetching count by calling respective methods
	
    amazonLandingPage();
    flipkartLandingPage();
    imageComparision();
    
    
    
    
  }
  
  @AfterTest
  public void closeBrowser() {
	  
	    getDriver().close();
	    
	   
	  
  }
   
 
}
