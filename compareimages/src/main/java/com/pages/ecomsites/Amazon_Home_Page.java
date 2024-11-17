package com.pages.ecomsites;

import java.time.Duration;
import java.util.HashSet;
import java.util.List;

import org.openqa.selenium.By;
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
		setDriver("Edge");
	}
	
	
	public void launchAmazonHomepage() {
		
		// Navigation to Amazon
		
		getDriver().get("http://www.amazon.in/");
		
		// Maximizing Browser window
		
		getDriver().manage().window().maximize();
	}
	
	public int findDropdownWithSelectTag() {
		// Waiter for select tag
		
		WebDriverWait dropdownwait = new WebDriverWait(getDriver(),Duration.ofMinutes(1));
		dropdownwait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.id(select_dropdown_id)));
						
		List<WebElement> select_dropdown = getDriver().findElements(By.id(select_dropdown_id));
		getDriver().findElement(By.id(select_dropdown_id)).click();
		
		return select_dropdown.size();
		
	}
	
	public int findSearchboxDropdrown() {
		// Fetching the count for Search dropdown
		
		WebDriverWait search_waiter = new WebDriverWait(getDriver(),Duration.ofMinutes(1));
		search_waiter.until(ExpectedConditions.elementToBeClickable(By.id(searchbox_dropdown_id)));
					
		getDriver().findElement(By.id(searchbox_dropdown_id)).sendKeys("Mobiles");
		List<WebElement> searchbox_dropdown = getDriver().findElements(By.id(searchbox_dropdown_id));
		getDriver().findElement(By.xpath("//div[@class='left-pane-results-container']"));
		
		return searchbox_dropdown.size();
	}
	
	public int findENDropDown() {
		
		// Waiter for EN division
		
		WebDriverWait enwaiter = new WebDriverWait(getDriver(),Duration.ofMinutes(1));
		enwaiter.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath(EN_dropdown_xpath)));
				
		Actions hover_en = new Actions(getDriver());
				
		hover_en.moveToElement(getDriver().findElement(By.xpath(EN_dropdown_xpath))).perform();
		
		// Finding the elements having EN text
		
		List<WebElement> endropdown = getDriver().findElements(By.xpath(EN_dropdown_xpath));
		
		return endropdown.size();
	}
	
	public int findHelloSignINDropDown() {
		
	// Waiter for Hello signin division
		
	WebDriverWait signinwaiter = new WebDriverWait(getDriver(),Duration.ofMinutes(1));
	signinwaiter.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath(HelloSignIn_dropdown_xpath)));
				
	Actions hover_signin = new Actions(getDriver());
				
	hover_signin.moveToElement(getDriver().findElement(By.xpath(HelloSignIn_dropdown_xpath))).perform();
								
	// Finding the elements having Hello Signin text
						
	List<WebElement> signindropdown = getDriver().findElements(By.xpath(HelloSignIn_dropdown_xpath));
		
	return signindropdown.size();
	}
	
	public void printAmazonDropdownCount() {
	
	// Printing the dropdown count in Amazon Homepage
	
		int totaldropdowncount = findDropdownWithSelectTag()+findSearchboxDropdrown()+findENDropDown()+findHelloSignINDropDown();
		System.out.println("Number of Dropdowns present in Amazon homepage:"+totaldropdowncount);
		
		
	}
	
	public void printnoofImages() {
		List<WebElement> images = getDriver().findElements(By.tagName("img"));
		
		 
		 for (WebElement image : images) {
		 
			if(image.getAttribute("src")!=null ) {
				
			
			 this.amazonimagesrc.add(image.getAttribute("src"));
			}
			
		}
		
		 System.out.println("Number of Images present in Amazon homepage:"+amazonimagesrc.size());
	}
	public void closeBrowser() {
		getDriver().close();
	}
	

}
