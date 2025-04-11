package com.framework.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.framework.base.genericKeywords;
import com.framework.utils.initProperties;

public class LoginPage{
	
	WebDriver driver;
	//constructor
	public LoginPage(WebDriver driver) {
		this.driver = driver;
	}
	
	//Locators
	By username = By.name("user-name");
	By password = By.name("password");
	By loginBtn = By.id("login-button");
	String usernameInput = initProperties.prop.getProperty("username");
	String passwordInput = initProperties.prop.getProperty("password");
	
	//Actions
	public void enterKey(String text, By locator) {
		genericKeywords.logInfo("Entered " + text + " in the specified locator " + locator);
		WebElement element = driver.findElement(locator);
		element.clear();
		element.sendKeys(text);

	}
	
	public void clickButton(By locator) {
		genericKeywords.logInfo("Clicked the button located in the specified locator: " + locator);
		driver.findElement(locator).click();
	
	}
	
	public void gotoLogin() {
		enterKey(usernameInput, username);
		enterKey(passwordInput, password);
		clickButton(loginBtn);
		genericKeywords.logInfo("Entered log-in page");
	}
	

}
