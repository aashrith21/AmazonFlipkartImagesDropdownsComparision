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
	
	
	
	public void amazonLandingPage() {
		// TODO Auto-generated constructor stub
		
		// Navigation to Amazon
		
		getDriver().get("http://www.amazon.in/");
		
		// Maximizing Browser window
		
		getDriver().manage().window().maximize();
		
		// Waiter for select tag
		
		WebDriverWait dropdownwait = new WebDriverWait(getDriver(),Duration.ofMinutes(1));
		dropdownwait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.id(select_dropdown_id)));
				
		List<WebElement> dropdowns = getDriver().findElements(By.id(select_dropdown_id));
		getDriver().findElement(By.id(select_dropdown_id)).click();
		
		// Fetching the count for Search dropdown
		
		WebDriverWait search_waiter = new WebDriverWait(getDriver(),Duration.ofMinutes(1));
		search_waiter.until(ExpectedConditions.elementToBeClickable(By.id(searchbox_dropdown_id)));
		
		getDriver().findElement(By.id(searchbox_dropdown_id)).sendKeys("Mobiles");
		List<WebElement> searchbox = getDriver().findElements(By.id(searchbox_dropdown_id));
		getDriver().findElement(By.xpath("//div[@class='left-pane-results-container']"));
		
		
		
		// Waiter for EN division
		
		WebDriverWait enwaiter = new WebDriverWait(getDriver(),Duration.ofMinutes(1));
		enwaiter.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath(EN_dropdown_xpath)));
		
		Actions hover_en = new Actions(getDriver());
		
		hover_en.moveToElement(getDriver().findElement(By.xpath(EN_dropdown_xpath))).perform();
						
		// Finding the elements having EN text
				
		List<WebElement> endropdown = getDriver().findElements(By.xpath(EN_dropdown_xpath));
		
		// Waiter for Hello signin division
		
		WebDriverWait signinwaiter = new WebDriverWait(getDriver(),Duration.ofMinutes(1));
		signinwaiter.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath(HelloSignIn_dropdown_xpath)));
				
		Actions hover_signin = new Actions(getDriver());
				
		hover_signin.moveToElement(getDriver().findElement(By.xpath(HelloSignIn_dropdown_xpath))).perform();
								
		// Finding the elements having Hello Signin text
						
		List<WebElement> signindropdown = getDriver().findElements(By.xpath(HelloSignIn_dropdown_xpath));
				
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
		breadcrumb_waiter.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath(breadcrumb_dropdown_xpath)));
		
		Actions hover_breadcrumb = new Actions(getDriver());
		
		hover_breadcrumb.moveToElement(getDriver().findElement(By.xpath(breadcrumb_dropdown_xpath))).perform();
		
		List<WebElement> breadcrumb_count = getDriver().findElements(By.xpath(breadcrumb_dropdown_xpath));
		
		
		// Fetching the count for Login dropdown
		
		WebDriverWait login_waiter = new WebDriverWait(getDriver(),Duration.ofMinutes(1));
		login_waiter.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath(login_dropdown_xpath)));
		
		Actions hover_Login = new Actions(getDriver());
		
		hover_Login.moveToElement(getDriver().findElement(By.xpath(login_dropdown_xpath))).perform();
		
		List<WebElement> login_count = getDriver().findElements(By.xpath(login_dropdown_xpath));
		
		
		// Fetching the count for Two Wheelers dropdown
		
		WebDriverWait two_wheelers_waiter = new WebDriverWait(getDriver(),Duration.ofMinutes(1));
		two_wheelers_waiter.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath(two_wheelers_dropdown_xpath)));
				
		Actions hover_two_wheelers = new Actions(getDriver());
				
		hover_two_wheelers.moveToElement(getDriver().findElement(By.xpath(two_wheelers_dropdown_xpath))).perform();
				
		List<WebElement> two_wheelers_count = getDriver().findElements(By.xpath(two_wheelers_dropdown_xpath));
			
		// Fetching the count for Beauty, Toys, Category dropdown
		
		WebDriverWait beauty_waiter = new WebDriverWait(getDriver(),Duration.ofMinutes(1));
		beauty_waiter.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath(beauty_dropdown_xpath)));
						
		Actions hover_beauty = new Actions(getDriver());
						
		hover_beauty.moveToElement(getDriver().findElement(By.xpath(beauty_dropdown_xpath))).perform();
						
		List<WebElement> beauty_count = getDriver().findElements(By.xpath(beauty_dropdown_xpath));
		
		// Fetching the count for Home & Furniture dropdown
		
		WebDriverWait home_waiter = new WebDriverWait(getDriver(),Duration.ofMinutes(1));
		home_waiter.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath(home_furniture_xpath)));
						
		Actions hover_home = new Actions(getDriver());
						
		hover_home.moveToElement(getDriver().findElement(By.xpath(home_furniture_xpath))).perform();
						
		List<WebElement> home_count = getDriver().findElements(By.xpath(home_furniture_xpath));
		
		// Fetching the count for Electronics dropdown
		
		WebDriverWait electronics_waiter = new WebDriverWait(getDriver(),Duration.ofMinutes(1));
		electronics_waiter.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath(electronics_xpath)));
						
		Actions hover_electronics = new Actions(getDriver());
						
		hover_electronics.moveToElement(getDriver().findElement(By.xpath(electronics_xpath))).perform();
						
		List<WebElement> electronics_count = getDriver().findElements(By.xpath(electronics_xpath));
		
		// Fetching the count for Fashion dropdown
		
		WebDriverWait fashion_waiter = new WebDriverWait(getDriver(),Duration.ofMinutes(1));
		fashion_waiter.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath(fashion_xpath)));
								
		Actions hover_fashion = new Actions(getDriver());
								
		hover_fashion.moveToElement(getDriver().findElement(By.xpath(fashion_xpath))).perform();
								
		List<WebElement> fashion_count = getDriver().findElements(By.xpath(fashion_xpath));
		
		// Fetching the count for Search dropdown
		
		WebDriverWait search_waiter = new WebDriverWait(getDriver(),Duration.ofMinutes(1));
		search_waiter.until(ExpectedConditions.elementToBeClickable(By.xpath(search_box_xpath)));
		WebElement searchbox = getDriver().findElement(By.xpath(search_box_xpath));
		
		JavascriptExecutor jsexecutor = (JavascriptExecutor) getDriver();
		jsexecutor.executeScript("arguments[0].click()", searchbox);
		searchbox.sendKeys(" ",Keys.BACK_SPACE);
		
		
		
								
		Actions hover_search = new Actions(getDriver());
								
		hover_search.moveToElement(getDriver().findElement(By.xpath(search_dropdown_xpath))).perform();
								
		int search_count = getDriver().findElements(By.xpath(search_dropdown_xpath)).size();
				
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
		System.out.println("Common images between Amazon and Flipkart           :"+""+common);
	}
	
	public void closeBrowser() {
		getDriver().close();
	}
	
}

