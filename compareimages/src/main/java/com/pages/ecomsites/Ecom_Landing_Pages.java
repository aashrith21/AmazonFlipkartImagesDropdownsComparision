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
	

	
	public HashSet<String> flipkartimagesrc = new HashSet<>();
	
	public HashSet<String> amazonimagesrc = new HashSet<>();
	
	
	
	public void amazonLandingPage() {
		// TODO Auto-generated constructor stub
		
		// Navigation to Amazon
		
		getDriver().get("http://www.amazon.in/");
		
		// Maximizing Browser window
		
		getDriver().manage().window().maximize();
		
		// Waiter for select tag
		
		WebDriverWait dropdownwait = new WebDriverWait(getDriver(),Duration.ofMinutes(1));
		dropdownwait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.id("searchDropdownBox")));
				
		List<WebElement> dropdowns = getDriver().findElements(By.id("searchDropdownBox"));
		getDriver().findElement(By.id("searchDropdownBox"));
		
		// Fetching the count for Search dropdown
		
		WebDriverWait search_waiter = new WebDriverWait(getDriver(),Duration.ofMinutes(1));
		search_waiter.until(ExpectedConditions.elementToBeClickable(By.id("twotabsearchtextbox")));
		
		getDriver().findElement(By.id("twotabsearchtextbox")).sendKeys("Mobiles");
		List<WebElement> searchbox = getDriver().findElements(By.id("twotabsearchtextbox"));
		getDriver().findElement(By.xpath("//div[@class='left-pane-results-container']"));
		
		
		
		// Waiter for EN division
		
		WebDriverWait enwaiter = new WebDriverWait(getDriver(),Duration.ofMinutes(1));
		enwaiter.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath("//div[contains(text(),'EN')]")));
		
		Actions hover_en = new Actions(getDriver());
		
		hover_en.moveToElement(getDriver().findElement(By.xpath("//div[contains(text(),'EN')]"))).perform();
						
		// Finding the elements having EN text
				
		List<WebElement> endropdown = getDriver().findElements(By.xpath("//div[contains(text(),'EN')]"));
		
		// Waiter for Hello signin division
		
		WebDriverWait signinwaiter = new WebDriverWait(getDriver(),Duration.ofMinutes(1));
		signinwaiter.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath("//span[contains(text(),'Hello, sign in')]")));
				
		Actions hover_signin = new Actions(getDriver());
				
		hover_signin.moveToElement(getDriver().findElement(By.xpath("//span[contains(text(),'Hello, sign in')]"))).perform();
								
		// Finding the elements having Hello Signin text
						
		List<WebElement> signindropdown = getDriver().findElements(By.xpath("//span[contains(text(),'Hello, sign in')]"));
		
		
		
		
		
		// Printing the dropdown and image counts	
		
		int totaldropdowncount = dropdowns.size()+endropdown.size()+signindropdown.size()+searchbox.size();
		System.out.println("Number of dropdowns present in Amazon homepage:"+totaldropdowncount);
		
		
		
		List<WebElement> images = getDriver().findElements(By.tagName("img"));
		
		 
		 for (WebElement image : images) {
		 
			if(image.getAttribute("src")!=null ) {
				
			
			 this.amazonimagesrc.add( image.getAttribute("src"));
			}
			
		}
		
		
		
		 System.out.println("Number of images in Amazon Home Page :"+""+amazonimagesrc.size());
		 
	}
		
		
	
	public void flipkartLandingPage() throws IOException {
		// TODO Auto-generated constructor stub
		
		// Navigation to Flipkart
		
		getDriver().get("https://www.flipkart.com/");
		
		// Maximizing Browser window
		
		getDriver().manage().window().maximize();
		
		
		// Fetching the count for breadcrumb
		
		WebDriverWait breadcrumb_waiter = new WebDriverWait(getDriver(),Duration.ofMinutes(1));
		breadcrumb_waiter.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath("//div[@class='H6-NpN']")));
		
		Actions hover_breadcrumb = new Actions(getDriver());
		
		hover_breadcrumb.moveToElement(getDriver().findElement(By.xpath("//div[@class='H6-NpN']"))).perform();
		
		List<WebElement> breadcrumb_count = getDriver().findElements(By.xpath("//div[@class='H6-NpN']"));
		
		
		// Fetching the count for Login dropdown
		
		WebDriverWait login_waiter = new WebDriverWait(getDriver(),Duration.ofMinutes(1));
		login_waiter.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath("//img[@alt='Login']")));
		
		Actions hover_Login = new Actions(getDriver());
		
		hover_Login.moveToElement(getDriver().findElement(By.xpath("//img[@alt='Login']"))).perform();
		
		List<WebElement> login_count = getDriver().findElements(By.xpath("//img[@alt='Login']"));
		
		
		// Fetching the count for Two Wheelers dropdown
		
		WebDriverWait two_wheelers_waiter = new WebDriverWait(getDriver(),Duration.ofMinutes(1));
		two_wheelers_waiter.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath("//img[@alt='Two Wheelers']")));
				
		Actions hover_two_wheelers = new Actions(getDriver());
				
		hover_two_wheelers.moveToElement(getDriver().findElement(By.xpath("//img[@alt='Two Wheelers']"))).perform();
				
		List<WebElement> two_wheelers_count = getDriver().findElements(By.xpath("//img[@alt='Two Wheelers']"));
			
		// Fetching the count for Beauty, Toys, Category dropdown
		
		WebDriverWait beauty_waiter = new WebDriverWait(getDriver(),Duration.ofMinutes(1));
		beauty_waiter.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath("//img[@alt='Beauty, Toys & More']")));
						
		Actions hover_beauty = new Actions(getDriver());
						
		hover_beauty.moveToElement(getDriver().findElement(By.xpath("//img[@alt='Beauty, Toys & More']"))).perform();
						
		List<WebElement> beauty_count = getDriver().findElements(By.xpath("//img[@alt='Beauty, Toys & More']"));
		
		// Fetching the count for Home & Furniture dropdown
		
		WebDriverWait home_waiter = new WebDriverWait(getDriver(),Duration.ofMinutes(1));
		home_waiter.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath("//img[@alt='Home & Furniture']")));
						
		Actions hover_home = new Actions(getDriver());
						
		hover_home.moveToElement(getDriver().findElement(By.xpath("//img[@alt='Home & Furniture']"))).perform();
						
		List<WebElement> home_count = getDriver().findElements(By.xpath("//img[@alt='Home & Furniture']"));
		
		// Fetching the count for Electronics dropdown
		
		WebDriverWait electronics_waiter = new WebDriverWait(getDriver(),Duration.ofMinutes(1));
		electronics_waiter.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath("//img[@alt='Electronics']")));
						
		Actions hover_electronics = new Actions(getDriver());
						
		hover_electronics.moveToElement(getDriver().findElement(By.xpath("//img[@alt='Electronics']"))).perform();
						
		List<WebElement> electronics_count = getDriver().findElements(By.xpath("//img[@alt='Electronics']"));
		
		// Fetching the count for Fashion dropdown
		
		WebDriverWait fashion_waiter = new WebDriverWait(getDriver(),Duration.ofMinutes(1));
		fashion_waiter.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath("//img[@alt='Fashion']")));
								
		Actions hover_fashion = new Actions(getDriver());
								
		hover_fashion.moveToElement(getDriver().findElement(By.xpath("//img[@alt='Fashion']"))).perform();
								
		List<WebElement> fashion_count = getDriver().findElements(By.xpath("//img[@alt='Fashion']"));
		
		// Fetching the count for Search dropdown
		
		WebDriverWait search_waiter = new WebDriverWait(getDriver(),Duration.ofMinutes(1));
		search_waiter.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@title='Search for Products, Brands and More']")));
		WebElement searchbox = getDriver().findElement(By.xpath("//input[@title='Search for Products, Brands and More']"));
		
		JavascriptExecutor jsexecutor = (JavascriptExecutor) getDriver();
		jsexecutor.executeScript("arguments[0].click()", searchbox);
		searchbox.sendKeys(" ",Keys.BACK_SPACE);
		
		
		
								
		Actions hover_search = new Actions(getDriver());
								
		hover_search.moveToElement(getDriver().findElement(By.xpath("//div[@class='_2SmNnR']"))).perform();
								
		int search_count = getDriver().findElements(By.xpath("//div[@class='_2SmNnR']")).size();
				
		// Printing the dropdown and image counts
		
		int totaldropdowncount = breadcrumb_count.size()+login_count.size()+two_wheelers_count.size()+beauty_count.size()+home_count.size()+electronics_count.size()+fashion_count.size()+search_count;		
		System.out.println("Number of dropdowns present in Flipkart homepage:"+totaldropdowncount);
		
		List<WebElement> images = getDriver().findElements(By.tagName("img"));
		
		for (WebElement image : images) {
			if(image.getAttribute("src")!=null) {
			
				
			 this.flipkartimagesrc.add(image.getAttribute("src"));
			}
			
		}
		
		
		System.out.println("Number of images in Flipkart Homepage :"+""+flipkartimagesrc.size());
		
	}
	
	
	
	public void imageComparision() {
		
		
		
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
		
	}
}

