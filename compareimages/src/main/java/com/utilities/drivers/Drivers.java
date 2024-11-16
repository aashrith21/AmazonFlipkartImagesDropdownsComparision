package com.utilities.drivers;
import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Drivers {
	
	
	// WebDriver initialization
	
	private WebDriver driver;
	
	// Getter for Browser
	public WebDriver getDriver() {
		return driver;
	}

	// Setter for Browser
	
	public void setDriver(String browser) {
		switch(browser) {
			case "Edge":
			this.driver = new EdgeDriver();
			break;
			case "Firefox":
			this.driver = new FirefoxDriver();
			break;
			case "Chrome":
			this.driver = new ChromeDriver();
			break;
		}
		
	}
	
}
