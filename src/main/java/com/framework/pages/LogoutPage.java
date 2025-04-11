package com.framework.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.framework.base.basetest;
import com.framework.base.genericKeywords;

public class LogoutPage extends  basetest{
	
	WebDriver driver;
	
	public LogoutPage(WebDriver driver) {
		this.driver = driver;
	}
	
	By backtoHome = By.id(prop.getProperty("backtoHome_btn"));
	By clickMenu = By.id(prop.getProperty("menu_btn"));
	By logoutBtn = By.id(prop.getProperty("logout_btn"));
	
	private void clickButton(By locator) {
		genericKeywords.logInfo("Clicked the button located in the specified locator: " + locator);
		driver.findElement(locator).click();
	}
	
	public void logOut() {
		clickButton(backtoHome);
		clickButton(clickMenu);
		clickButton(logoutBtn);
		genericKeywords.logInfo("Log out successful!");
	}
}
