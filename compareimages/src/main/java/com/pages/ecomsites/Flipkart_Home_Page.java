package com.pages.ecomsites;

import java.time.Duration;
import java.util.HashSet;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
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
		setDriver("Edge");
	}
	
	public void launchFlipkartHomepage() {
		
		// Navigation to Amazon
		
		getDriver().get("https://www.flipkart.com/");
		
		// Maximizing Browser window
		
		getDriver().manage().window().maximize();
	}
	
	public int findBreadCrumbDropdown() {
		
		// Fetching the count for breadcrumb
		
		WebDriverWait breadcrumb_waiter = new WebDriverWait(getDriver(),Duration.ofMinutes(1));
		breadcrumb_waiter.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath(breadcrumb_dropdown_xpath)));
				
		Actions hover_breadcrumb = new Actions(getDriver());
				
		hover_breadcrumb.moveToElement(getDriver().findElement(By.xpath(breadcrumb_dropdown_xpath))).perform();
				
		List<WebElement> breadcrumb_dropdown = getDriver().findElements(By.xpath(breadcrumb_dropdown_xpath));
		
		return breadcrumb_dropdown.size();
	}
	
	public int findLoginDropdown(){ 
	
	// Fetching the count for Login dropdown
	
	WebDriverWait login_waiter = new WebDriverWait(getDriver(),Duration.ofMinutes(1));
	login_waiter.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath(login_dropdown_xpath)));
	
	Actions hover_Login = new Actions(getDriver());
	
	hover_Login.moveToElement(getDriver().findElement(By.xpath(login_dropdown_xpath))).perform();
	
	List<WebElement> login_dropdown = getDriver().findElements(By.xpath(login_dropdown_xpath));
	
	return login_dropdown.size();
	
	}
	
	public int findTwoWheelersDropdown(){
		
		// Fetching the count for Two Wheelers dropdown
		
		WebDriverWait two_wheelers_waiter = new WebDriverWait(getDriver(),Duration.ofMinutes(1));
		two_wheelers_waiter.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath(two_wheelers_dropdown_xpath)));
						
		Actions hover_two_wheelers = new Actions(getDriver());
						
		hover_two_wheelers.moveToElement(getDriver().findElement(By.xpath(two_wheelers_dropdown_xpath))).perform();
						
		List<WebElement> two_wheelers_dropdown = getDriver().findElements(By.xpath(two_wheelers_dropdown_xpath));
		
		return two_wheelers_dropdown.size();
	}
	
	
	public int findBeautyDropdown(){ 
		
		// Fetching the count for Beauty, Toys, Category dropdown
		
		WebDriverWait beauty_waiter = new WebDriverWait(getDriver(),Duration.ofMinutes(1));
		beauty_waiter.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath(beauty_dropdown_xpath)));
								
		Actions hover_beauty = new Actions(getDriver());
								
		hover_beauty.moveToElement(getDriver().findElement(By.xpath(beauty_dropdown_xpath))).perform();
								
		List<WebElement> beauty_dropdown = getDriver().findElements(By.xpath(beauty_dropdown_xpath));
		
		return beauty_dropdown.size();
	}
	public int findHomeFurnitureDropdown(){
		
	
	// Fetching the count for Home & Furniture dropdown
	
	WebDriverWait home_waiter = new WebDriverWait(getDriver(),Duration.ofMinutes(1));
	home_waiter.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath(home_furniture_xpath)));
							
	Actions hover_home = new Actions(getDriver());
							
	hover_home.moveToElement(getDriver().findElement(By.xpath(home_furniture_xpath))).perform();
							
	List<WebElement> home_count = getDriver().findElements(By.xpath(home_furniture_xpath));
	
	return home_count.size();
			
	}
	
	public int findElectronicsDropdown(){
	
	// Fetching the count for Electronics dropdown
			
	WebDriverWait electronics_waiter = new WebDriverWait(getDriver(),Duration.ofMinutes(1));
	electronics_waiter.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath(electronics_xpath)));
							
	Actions hover_electronics = new Actions(getDriver());
							
	hover_electronics.moveToElement(getDriver().findElement(By.xpath(electronics_xpath))).perform();
							
	List<WebElement> electronics_count = getDriver().findElements(By.xpath(electronics_xpath));
	
	return electronics_count.size();
	}
	public int findFashionDropdown(){
		
	// Fetching the count for Fashion dropdown
			
	WebDriverWait fashion_waiter = new WebDriverWait(getDriver(),Duration.ofMinutes(1));
	fashion_waiter.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath(fashion_xpath)));
									
	Actions hover_fashion = new Actions(getDriver());
									
	hover_fashion.moveToElement(getDriver().findElement(By.xpath(fashion_xpath))).perform();
									
	List<WebElement> fashion_count = getDriver().findElements(By.xpath(fashion_xpath));
	return fashion_count.size();
	
	}
	
	public int findSearchDropdown(){
			
	// Fetching the count for Search dropdown
			
	WebDriverWait search_waiter = new WebDriverWait(getDriver(),Duration.ofMinutes(1));
	search_waiter.until(ExpectedConditions.elementToBeClickable(By.xpath(search_dropdown_xpath)));
	WebElement searchbox = getDriver().findElement(By.xpath(search_dropdown_xpath));
			
	JavascriptExecutor jsexecutor = (JavascriptExecutor) getDriver();
	jsexecutor.executeScript("arguments[0].click()", searchbox);
	searchbox.sendKeys(" ",Keys.BACK_SPACE);
			
	Actions hover_search = new Actions(getDriver());
									
	hover_search.moveToElement(getDriver().findElement(By.xpath("//div[@class='_2SmNnR']"))).perform();
									
	List<WebElement> search_count = getDriver().findElements(By.xpath("//div[@class='_2SmNnR']"));
	return search_count.size();
	}
	
	public void printFlipkartDropdownscount() {
		int totaldropdowncount = findBreadCrumbDropdown()+findLoginDropdown()+findTwoWheelersDropdown()+findBeautyDropdown()+findHomeFurnitureDropdown()+findElectronicsDropdown()+findFashionDropdown()+findSearchDropdown();		
		System.out.println("Number of dropdowns present in Flipkart homepage:"+totaldropdowncount);
	}
	
	public void printNoofImages() {
		List<WebElement> images = getDriver().findElements(By.tagName("img"));
		
		for (WebElement image : images) {
			if(image.getAttribute("src")!=null) {
			
				
			 this.flipkartimagesrc.add(image.getAttribute("src"));
			}
			
		}
		
		
		System.out.println("Number of images in Flipkart Homepage :"+""+flipkartimagesrc.size());
	}
	
	public void closeBrowser() {
		getDriver().close();
	}
	
	
}
