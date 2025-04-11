package com.framework.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.framework.base.basetest;
import com.framework.base.genericKeywords;

public class CheckoutTwo extends basetest {
	WebDriver driver;

	public CheckoutTwo(WebDriver driver) {
		this.driver = driver;
	}

	By finish_btn = By.id(prop.getProperty("finish_btn"));
	By checkOutStatus = By.xpath(prop.getProperty("checkoutStatus"));

	private void clickButton(By locator) {
		genericKeywords.logInfo("Clicked the button located in the specified locator: " + locator);
		driver.findElement(locator).click();
	}

	public void validateCheckOutResult(String expectedResult) {
		WebElement element = driver.findElement(checkOutStatus);
		Boolean isStatusSuccess = element.getText().equals(expectedResult);
		if (isStatusSuccess) {
             genericKeywords.logInfo("Checkout is successful.");
		} else {
			genericKeywords.reportFailure("Checkout is unsuccessful.", isStatusSuccess);
		}
	}

	public void finishCheckOut() {
		genericKeywords.logInfo("Finished check out");
		clickButton(finish_btn);
	}

}
