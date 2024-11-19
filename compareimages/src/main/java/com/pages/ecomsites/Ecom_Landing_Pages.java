package com.pages.ecomsites;


import java.time.Duration;
import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.utilities.drivers.Drivers;

public class Ecom_Landing_Pages extends Drivers{
	
	public Ecom_Landing_Pages() {
		//setDriver("Edge");
	}
	
	//Amazon locators
	
	public String select_dropdown_id    = "searchDropdownBox";
	public String searchbox_dropdown_id = "twotabsearchtextbox";
	public String EN_dropdown_xpath = "//div[contains(text(),'EN')]";
	public String HelloSignIn_dropdown_xpath = "//span[contains(text(),'Hello, sign in')]";
	
	//Flipkart locators
	
	public String breadcrumb_dropdown_xpath = "//div[@class='H6-NpN']";
	public String login_dropdown_xpath      = "//img[@alt='Login']";
	public String beauty_dropdown_xpath     = "//img[@alt='Beauty, Toys & More']";
	public String two_wheelers_dropdown_xpath ="//img[@alt='Two Wheelers']";
	public String home_furniture_xpath      ="//img[@alt='Home & Furniture']";
	public String electronics_xpath         = "//img[@alt='Electronics']";
	public String fashion_xpath             = "//img[@alt='Fashion']";
	public String search_box_xpath          = "//input[@title='Search for Products, Brands and More']";
	public String search_dropdown_xpath     = "//div[@class='_2SmNnR']";
	public HashSet<String> flipkartimagesrc = new HashSet<>();
	
	public HashSet<String> amazonimagesrc = new HashSet<>();
	
	
	
	public void amazonLandingPage(WebDriver driver) {
		// TODO Auto-generated constructor stub
		
		// Navigation to Amazon
		
		driver.get("http://www.amazon.in/");
		
		// Maximizing Browser window
		
		driver.manage().window().maximize();
		
		// Waiter for select tag
		
		WebDriverWait dropdownwait = new WebDriverWait(driver,Duration.ofMinutes(1));
		dropdownwait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.id(select_dropdown_id)));
				
		List<WebElement> dropdowns = driver.findElements(By.id(select_dropdown_id));
		driver.findElement(By.id(select_dropdown_id)).click();
		
		// Fetching the count for Search dropdown
		
		WebDriverWait search_waiter = new WebDriverWait(driver,Duration.ofMinutes(1));
		search_waiter.until(ExpectedConditions.elementToBeClickable(By.id(searchbox_dropdown_id)));
		
		driver.findElement(By.id(searchbox_dropdown_id)).sendKeys("Mobiles");
		List<WebElement> searchbox = driver.findElements(By.id(searchbox_dropdown_id));
		driver.findElement(By.xpath("//div[@class='left-pane-results-container']"));
		
		
		
		// Waiter for EN division
		
		WebDriverWait enwaiter = new WebDriverWait(driver,Duration.ofMinutes(1));
		enwaiter.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath(EN_dropdown_xpath)));
		
		Actions hover_en = new Actions(driver);
		
		hover_en.moveToElement(driver.findElement(By.xpath(EN_dropdown_xpath))).perform();
						
		// Finding the elements having EN text
				
		List<WebElement> endropdown = driver.findElements(By.xpath(EN_dropdown_xpath));
		
		// Waiter for Hello signin division
		
		WebDriverWait signinwaiter = new WebDriverWait(driver,Duration.ofMinutes(1));
		signinwaiter.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath(HelloSignIn_dropdown_xpath)));
				
		Actions hover_signin = new Actions(driver);
				
		hover_signin.moveToElement(driver.findElement(By.xpath(HelloSignIn_dropdown_xpath))).perform();
								
		// Finding the elements having Hello Signin text
						
		List<WebElement> signindropdown = driver.findElements(By.xpath(HelloSignIn_dropdown_xpath));
				
		// Printing the dropdown and image counts	
		
		int totaldropdowncount = dropdowns.size()+endropdown.size()+signindropdown.size()+searchbox.size();
		System.out.println("Number of dropdowns present in Amazon homepage:"+totaldropdowncount);
		
		
		
		List<WebElement> images = driver.findElements(By.tagName("img"));
		
		 
		 for (WebElement image : images) {
		 
			if(image.getAttribute("src")!=null ) {
				
			
			 this.amazonimagesrc.add( image.getAttribute("src"));
			}
			
		}
		
		
		
		 System.out.println("Number of images in Amazon Home Page :"+""+amazonimagesrc.size());
		 
	}
		
		
	
	



	public void flipkartLandingPage(WebDriver driver) throws IOException {
		// TODO Auto-generated constructor stub
		
		// Navigation to Flipkart
		
		driver.get("https://www.flipkart.com/");
		
		// Maximizing Browser window
		
		driver.manage().window().maximize();
		
		
		// Fetching the count for breadcrumb
		
		WebDriverWait breadcrumb_waiter = new WebDriverWait(driver,Duration.ofMinutes(1));
		breadcrumb_waiter.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath(breadcrumb_dropdown_xpath)));
		
		Actions hover_breadcrumb = new Actions(driver);
		
		hover_breadcrumb.moveToElement(driver.findElement(By.xpath(breadcrumb_dropdown_xpath))).perform();
		
		List<WebElement> breadcrumb_count = driver.findElements(By.xpath(breadcrumb_dropdown_xpath));
		
		
		// Fetching the count for Login dropdown
		
		WebDriverWait login_waiter = new WebDriverWait(driver,Duration.ofMinutes(1));
		login_waiter.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath(login_dropdown_xpath)));
		
		Actions hover_Login = new Actions(driver);
		
		hover_Login.moveToElement(driver.findElement(By.xpath(login_dropdown_xpath))).perform();
		
		List<WebElement> login_count = driver.findElements(By.xpath(login_dropdown_xpath));
		
		
		// Fetching the count for Two Wheelers dropdown
		
		WebDriverWait two_wheelers_waiter = new WebDriverWait(driver,Duration.ofMinutes(1));
		two_wheelers_waiter.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath(two_wheelers_dropdown_xpath)));
				
		Actions hover_two_wheelers = new Actions(driver);
				
		hover_two_wheelers.moveToElement(driver.findElement(By.xpath(two_wheelers_dropdown_xpath))).perform();
				
		List<WebElement> two_wheelers_count = driver.findElements(By.xpath(two_wheelers_dropdown_xpath));
			
		// Fetching the count for Beauty, Toys, Category dropdown
		
		WebDriverWait beauty_waiter = new WebDriverWait(driver,Duration.ofMinutes(1));
		beauty_waiter.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath(beauty_dropdown_xpath)));
						
		Actions hover_beauty = new Actions(driver);
						
		hover_beauty.moveToElement(driver.findElement(By.xpath(beauty_dropdown_xpath))).perform();
						
		List<WebElement> beauty_count = driver.findElements(By.xpath(beauty_dropdown_xpath));
		
		// Fetching the count for Home & Furniture dropdown
		
		WebDriverWait home_waiter = new WebDriverWait(driver,Duration.ofMinutes(1));
		home_waiter.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath(home_furniture_xpath)));
						
		Actions hover_home = new Actions(driver);
						
		hover_home.moveToElement(driver.findElement(By.xpath(home_furniture_xpath))).perform();
						
		List<WebElement> home_count = driver.findElements(By.xpath(home_furniture_xpath));
		
		// Fetching the count for Electronics dropdown
		
		WebDriverWait electronics_waiter = new WebDriverWait(driver,Duration.ofMinutes(1));
		electronics_waiter.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath(electronics_xpath)));
						
		Actions hover_electronics = new Actions(driver);
						
		hover_electronics.moveToElement(driver.findElement(By.xpath(electronics_xpath))).perform();
						
		List<WebElement> electronics_count = driver.findElements(By.xpath(electronics_xpath));
		
		// Fetching the count for Fashion dropdown
		
		WebDriverWait fashion_waiter = new WebDriverWait(driver,Duration.ofMinutes(1));
		fashion_waiter.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath(fashion_xpath)));
								
		Actions hover_fashion = new Actions(driver);
								
		hover_fashion.moveToElement(driver.findElement(By.xpath(fashion_xpath))).perform();
								
		List<WebElement> fashion_count = driver.findElements(By.xpath(fashion_xpath));
		
		// Fetching the count for Search dropdown
		
		WebDriverWait search_waiter = new WebDriverWait(driver,Duration.ofMinutes(1));
		search_waiter.until(ExpectedConditions.elementToBeClickable(By.xpath(search_box_xpath)));
		WebElement searchbox = driver.findElement(By.xpath(search_box_xpath));
		
		JavascriptExecutor jsexecutor = (JavascriptExecutor) driver;
		jsexecutor.executeScript("arguments[0].click()", searchbox);
		searchbox.sendKeys(" ",Keys.BACK_SPACE);
		
		
		
								
		Actions hover_search = new Actions(driver);
								
		hover_search.moveToElement(driver.findElement(By.xpath(search_dropdown_xpath))).perform();
								
		int search_count = driver.findElements(By.xpath(search_dropdown_xpath)).size();
				
		// Printing the dropdown and image counts
		
		int totaldropdowncount = breadcrumb_count.size()+login_count.size()+two_wheelers_count.size()+beauty_count.size()+home_count.size()+electronics_count.size()+fashion_count.size()+search_count;		
		System.out.println("Number of dropdowns present in Flipkart homepage:"+totaldropdowncount);
		
		List<WebElement> images = driver.findElements(By.tagName("img"));
		
		for (WebElement image : images) {
			if(image.getAttribute("src")!=null) {
			
				
			 this.flipkartimagesrc.add(image.getAttribute("src"));
			}
			
		}
		
		
		System.out.println("Number of images in Flipkart Homepage :"+""+flipkartimagesrc.size());
		
	}
	
	
	
	public void imageComparision(WebDriver webDriver) {
		
		
		
		HashSet<String> common= new HashSet<>();
		 
		//if(amazonimagesrc.equals(flipkartimagesrc)) {
		for (String amazonimage : amazonimagesrc  ) {
						
							for(String flipkartimage : flipkartimagesrc) {
								
								if(amazonimage == flipkartimage) {
									common.add(amazonimage);
									
								}
									
							}
					
				}
			
	   
	
		
		System.out.println("Number of common images between Amazon and Flipkart :"+""+common.size());
		System.out.println("Common images between Amazon and Flipkart           :"+""+common);
	}







	public void closeBrowser(WebDriver driver) {
		// TODO Auto-generated method stub
		//driver.close();
	}
	
	



	
}

