package com.framework.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.framework.base.basetest;
import com.framework.base.genericKeywords;

public class CheckoutOne extends basetest {
	WebDriver driver;
	
	public CheckoutOne(WebDriver driver) {
		this.driver = driver;
	}
	
	By checkout_btn = By.id(prop.getProperty("checkout_btn"));
	By firstName_txtbox = By.id(prop.getProperty("firstName_id"));
	By lastName_txtbox = By.id(prop.getProperty("lastName_id"));
	By zipCode_txtbox = By.id(prop.getProperty("postalcode_id"));
	By continue_btn = By.id(prop.getProperty("continue_btn"));
	
	
	private void clickButton(By locator) {
		genericKeywords.logInfo("Clicked the button located in the specified locator: " + locator);
		driver.findElement(locator).click();
	}
	
	private void enterKey(String text, By locator) {
		genericKeywords.logInfo("Entered " + text + " in the specified locator " + locator);
		WebElement element = driver.findElement(locator);
		element.clear();
		element.sendKeys(text);
	}
	
	public void proceedtoCheckOut() {
		genericKeywords.logInfo("Proceeded to check out");
		clickButton(checkout_btn);
	}
	
	public void fillUpformandProceed() {
		enterKey(prop.getProperty("firstName"),firstName_txtbox);
		enterKey(prop.getProperty("lastName"),lastName_txtbox);
		enterKey(prop.getProperty("zipCode"),zipCode_txtbox);
		clickButton(continue_btn);
	}
	
}
