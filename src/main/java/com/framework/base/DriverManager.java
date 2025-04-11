package com.framework.base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DriverManager {
	private static WebDriver driver;

	public static WebDriver getDriver(String browser) {

		if(driver==null) {
			if(browser.equalsIgnoreCase("chrome")) {
				WebDriverManager.chromiumdriver().setup();
				driver = new ChromeDriver();
			} else if(browser.equalsIgnoreCase("firefox")){
				WebDriverManager.firefoxdriver().setup();
				driver = new FirefoxDriver();
			} else if(browser.equalsIgnoreCase("edge")){
				WebDriverManager.edgedriver().setup();
				driver = new EdgeDriver();
			} else {
				WebDriverManager.chromiumdriver().setup();
				driver = new ChromeDriver();
			}
		}
		
		return driver;
	}

}
