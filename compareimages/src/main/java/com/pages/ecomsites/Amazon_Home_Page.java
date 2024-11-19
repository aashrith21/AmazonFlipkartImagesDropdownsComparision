package com.pages.ecomsites;

import java.time.Duration;
import java.util.HashSet;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.utilities.drivers.Drivers;

public class Amazon_Home_Page extends Drivers {
	
	public String select_dropdown_id    = "searchDropdownBox";
	public String searchbox_dropdown_id = "twotabsearchtextbox";
	public String EN_dropdown_xpath = "//div[contains(text(),'EN')]";
	public String HelloSignIn_dropdown_xpath = "//span[contains(text(),'Hello, sign in')]";
	public HashSet<String> amazonimagesrc = new HashSet<>();

	public Amazon_Home_Page() {
		// TODO Auto-generated constructor stub
		//setDriver("Edge");
	}
	
	
	public void launchAmazonHomepage(WebDriver driver) {
		
		// Navigation to Amazon
		
		driver.get("http://www.amazon.in/");
		
		// Maximizing Browser window
		
		driver.manage().window().maximize();
	}
	
	public int findDropdownWithSelectTag(WebDriver driver) {
		// Waiter for select tag
		
		WebDriverWait dropdownwait = new WebDriverWait(driver,Duration.ofMinutes(1));
		dropdownwait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.id(select_dropdown_id)));
						
		List<WebElement> select_dropdown = driver.findElements(By.id(select_dropdown_id));
		driver.findElement(By.id(select_dropdown_id)).click();
		
		return select_dropdown.size();
		
	}
	
	public int findSearchboxDropdrown(WebDriver driver) {
		// Fetching the count for Search dropdown
		
		WebDriverWait search_waiter = new WebDriverWait(driver,Duration.ofMinutes(1));
		search_waiter.until(ExpectedConditions.elementToBeClickable(By.id(searchbox_dropdown_id)));
					
		driver.findElement(By.id(searchbox_dropdown_id)).sendKeys("Mobiles");
		List<WebElement> searchbox_dropdown = driver.findElements(By.id(searchbox_dropdown_id));
		driver.findElement(By.xpath("//div[@class='left-pane-results-container']"));
		
		return searchbox_dropdown.size();
	}
	
	public int findENDropDown(WebDriver driver) {
		
		// Waiter for EN division
		
		WebDriverWait enwaiter = new WebDriverWait(driver,Duration.ofMinutes(1));
		enwaiter.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath(EN_dropdown_xpath)));
				
		Actions hover_en = new Actions(driver);
				
		hover_en.moveToElement(driver.findElement(By.xpath(EN_dropdown_xpath))).perform();
		
		// Finding the elements having EN text
		
		List<WebElement> endropdown = driver.findElements(By.xpath(EN_dropdown_xpath));
		
		return endropdown.size();
	}
	
	public int findHelloSignINDropDown(WebDriver driver) {
		
	// Waiter for Hello signin division
		
	WebDriverWait signinwaiter = new WebDriverWait(driver,Duration.ofMinutes(1));
	signinwaiter.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath(HelloSignIn_dropdown_xpath)));
				
	Actions hover_signin = new Actions(driver);
				
	hover_signin.moveToElement(driver.findElement(By.xpath(HelloSignIn_dropdown_xpath))).perform();
								
	// Finding the elements having Hello Signin text
						
	List<WebElement> signindropdown = driver.findElements(By.xpath(HelloSignIn_dropdown_xpath));
		
	return signindropdown.size();
	}
	
	public void printAmazonDropdownCount(WebDriver driver) {
	
	// Printing the dropdown count in Amazon Homepage
	
		int totaldropdowncount = findDropdownWithSelectTag(driver)+findSearchboxDropdrown(driver)+findENDropDown(driver)+findHelloSignINDropDown(driver);
		System.out.println("Number of Dropdowns present in Amazon homepage:"+totaldropdowncount);
		
		
	}
	
	public void printnoofImages(WebDriver driver) {
		List<WebElement> images = driver.findElements(By.tagName("img"));
		
		 
		 for (WebElement image : images) {
		 
			if(image.getAttribute("src")!=null ) {
				
			
			 this.amazonimagesrc.add(image.getAttribute("src"));
			}
			
		}
		
		 System.out.println("Number of Images present in Amazon homepage:"+amazonimagesrc.size());
	}
	public void closeBrowser(WebDriver driver) {
		//getDriver().close();
	}
	

}
