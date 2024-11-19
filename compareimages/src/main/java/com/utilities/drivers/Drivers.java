package com.utilities.drivers;
import java.io.File;
import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.ITestResult;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;

import com.beust.jcommander.Parameter;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;


public class Drivers {
	
	
	// WebDriver initialization
	
	public WebDriver driver;
	
	// Getter for Browser
	
	@BeforeMethod
	public void  initializeDriver() {
		setDriver("Edge");
		
	}
	
	
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
	
	public  String getScreenshot(String testcasename, WebDriver driver) throws IOException{
		TakesScreenshot ts = (TakesScreenshot) driver;
		File source =  ts.getScreenshotAs(OutputType.FILE);
		File file   = new File(System.getProperty("user.dir")+"//screenshots//"+testcasename+".png");
		FileUtils.copyFile(source, file);
		return System.getProperty("user.dir")+"//screenshots//"+testcasename+".png";
		
		
	}
}
