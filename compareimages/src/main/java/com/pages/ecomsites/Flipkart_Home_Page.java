package com.pages.ecomsites;

import java.time.Duration;
import java.util.HashSet;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.utilities.drivers.Drivers;

public class Flipkart_Home_Page extends Drivers {
	
	public String breadcrumb_dropdown_xpath = "//div[@class='H6-NpN']";
	public String login_dropdown_xpath      = "//img[@alt='Login']";
	public String beauty_dropdown_xpath     = "//img[@alt='Beauty, Toys & More']";
	public String two_wheelers_dropdown_xpath ="//img[@alt='Two Wheelers']";
	public String home_furniture_xpath      ="//img[@alt='Home & Furniture']";
	public String electronics_xpath         = "//img[@alt='Electronics']";
	public String fashion_xpath             = "//img[@alt='Fashion']";
	public String search_dropdown_xpath     = "//input[@title='Search for Products, Brands and More']";
	
	public HashSet<String> flipkartimagesrc = new HashSet<>();
	

	public Flipkart_Home_Page() {
		// TODO Auto-generated constructor stub
		//setDriver("Edge");
	}
	
	public void launchFlipkartHomepage(WebDriver driver) {
		
		// Navigation to Amazon
		
		driver.get("https://www.flipkart.com/");
		
		// Maximizing Browser window
		
		driver.manage().window().maximize();
	}
	
	public int findBreadCrumbDropdown(WebDriver driver) {
		
		// Fetching the count for breadcrumb
		
		WebDriverWait breadcrumb_waiter = new WebDriverWait(driver,Duration.ofMinutes(1));
		breadcrumb_waiter.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath(breadcrumb_dropdown_xpath)));
				
		Actions hover_breadcrumb = new Actions(driver);
				
		hover_breadcrumb.moveToElement(driver.findElement(By.xpath(breadcrumb_dropdown_xpath))).perform();
				
		List<WebElement> breadcrumb_dropdown = driver.findElements(By.xpath(breadcrumb_dropdown_xpath));
		
		return breadcrumb_dropdown.size();
	}
	
	public int findLoginDropdown(WebDriver driver){ 
	
	// Fetching the count for Login dropdown
	
	WebDriverWait login_waiter = new WebDriverWait(driver,Duration.ofMinutes(1));
	login_waiter.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath(login_dropdown_xpath)));
	
	Actions hover_Login = new Actions(driver);
	
	hover_Login.moveToElement(driver.findElement(By.xpath(login_dropdown_xpath))).perform();
	
	List<WebElement> login_dropdown = driver.findElements(By.xpath(login_dropdown_xpath));
	
	return login_dropdown.size();
	
	}
	
	public int findTwoWheelersDropdown(WebDriver driver){
		
		// Fetching the count for Two Wheelers dropdown
		
		WebDriverWait two_wheelers_waiter = new WebDriverWait(driver,Duration.ofMinutes(1));
		two_wheelers_waiter.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath(two_wheelers_dropdown_xpath)));
						
		Actions hover_two_wheelers = new Actions(driver);
						
		hover_two_wheelers.moveToElement(driver.findElement(By.xpath(two_wheelers_dropdown_xpath))).perform();
						
		List<WebElement> two_wheelers_dropdown = driver.findElements(By.xpath(two_wheelers_dropdown_xpath));
		
		return two_wheelers_dropdown.size();
	}
	
	
	public int findBeautyDropdown(WebDriver driver){ 
		
		// Fetching the count for Beauty, Toys, Category dropdown
		
		WebDriverWait beauty_waiter = new WebDriverWait(driver,Duration.ofMinutes(1));
		beauty_waiter.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath(beauty_dropdown_xpath)));
								
		Actions hover_beauty = new Actions(driver);
								
		hover_beauty.moveToElement(driver.findElement(By.xpath(beauty_dropdown_xpath))).perform();
								
		List<WebElement> beauty_dropdown = driver.findElements(By.xpath(beauty_dropdown_xpath));
		
		return beauty_dropdown.size();
	}
	public int findHomeFurnitureDropdown(WebDriver driver){
		
	
	// Fetching the count for Home & Furniture dropdown
	
	WebDriverWait home_waiter = new WebDriverWait(driver,Duration.ofMinutes(1));
	home_waiter.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath(home_furniture_xpath)));
							
	Actions hover_home = new Actions(driver);
							
	hover_home.moveToElement(driver.findElement(By.xpath(home_furniture_xpath))).perform();
							
	List<WebElement> home_count = driver.findElements(By.xpath(home_furniture_xpath));
	
	return home_count.size();
			
	}
	
	public int findElectronicsDropdown(WebDriver driver){
	
	// Fetching the count for Electronics dropdown
			
	WebDriverWait electronics_waiter = new WebDriverWait(driver,Duration.ofMinutes(1));
	electronics_waiter.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath(electronics_xpath)));
							
	Actions hover_electronics = new Actions(driver);
							
	hover_electronics.moveToElement(driver.findElement(By.xpath(electronics_xpath))).perform();
							
	List<WebElement> electronics_count = driver.findElements(By.xpath(electronics_xpath));
	
	return electronics_count.size();
	}
	public int findFashionDropdown(WebDriver driver){
		
	// Fetching the count for Fashion dropdown
			
	WebDriverWait fashion_waiter = new WebDriverWait(driver,Duration.ofMinutes(1));
	fashion_waiter.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath(fashion_xpath)));
									
	Actions hover_fashion = new Actions(driver);
									
	hover_fashion.moveToElement(driver.findElement(By.xpath(fashion_xpath))).perform();
									
	List<WebElement> fashion_count = driver.findElements(By.xpath(fashion_xpath));
	return fashion_count.size();
	
	}
	
	public int findSearchDropdown(WebDriver driver){
			
	// Fetching the count for Search dropdown
			
	WebDriverWait search_waiter = new WebDriverWait(driver,Duration.ofMinutes(1));
	search_waiter.until(ExpectedConditions.elementToBeClickable(By.xpath(search_dropdown_xpath)));
	WebElement searchbox = driver.findElement(By.xpath(search_dropdown_xpath));
			
	JavascriptExecutor jsexecutor = (JavascriptExecutor) driver;
	jsexecutor.executeScript("arguments[0].click()", searchbox);
	searchbox.sendKeys(" ",Keys.BACK_SPACE);
			
	Actions hover_search = new Actions(driver);
									
	hover_search.moveToElement(driver.findElement(By.xpath("//div[@class='_2SmNnR']"))).perform();
									
	List<WebElement> search_count = driver.findElements(By.xpath("//div[@class='_2SmNnR']"));
	return search_count.size();
	}
	
	public int printFlipkartDropdownscount(WebDriver driver) {
		int totaldropdowncount = findBreadCrumbDropdown(driver)+findLoginDropdown(driver)+findTwoWheelersDropdown(driver)+findBeautyDropdown(driver)+findHomeFurnitureDropdown(driver)+findElectronicsDropdown(driver)+findFashionDropdown(driver)+findSearchDropdown(driver);		
		System.out.println("Number of dropdowns present in Flipkart homepage:"+totaldropdowncount);
		return totaldropdowncount;
	}
	
	public int printNoofImages(WebDriver driver) {
		List<WebElement> images = driver.findElements(By.tagName("img"));
		
		for (WebElement image : images) {
			if(image.getAttribute("src")!=null) {
			
				
			 this.flipkartimagesrc.add(image.getAttribute("src"));
			}
			
		}
		
		
		System.out.println("Number of images in Flipkart Homepage :"+""+flipkartimagesrc.size());
		return flipkartimagesrc.size();
	}
	
	public void closeBrowser(WebDriver driver) {
		//getDriver().close();
	}
	
	
}
