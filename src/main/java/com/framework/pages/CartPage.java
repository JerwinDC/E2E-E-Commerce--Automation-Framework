package com.framework.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.framework.base.basetest;
import com.framework.base.genericKeywords;

public class CartPage extends basetest{
	
	WebDriver driver;
	
	//constructor
	public CartPage(WebDriver driver) {
		this.driver = driver;
	}
	
	//locators
	By cart_btn = By.xpath(prop.getProperty("cart_btn"));
	By CartItem_names = By.className(prop.getProperty("CartItem_names"));
	
	//Actions
	private void clickButton(By locator) {
		genericKeywords.logInfo("Clicked the cart button located in the specified locator: " + locator);
		driver.findElement(locator).click();
	}
	
	private List<WebElement> getCartItems(By locator) {
		List<WebElement> elements = driver.findElements(locator);
		
		return elements;
	}
	
	
	public void validateCart(String itemName) {
		itemName = itemName.toUpperCase();
		List<WebElement> elements = getCartItems(CartItem_names);
		Boolean isElementPresent = false;
		for(WebElement element : elements) {
			String cartitemName = element.getText().toUpperCase();

			if(cartitemName.equals(itemName)) {
				isElementPresent = true;
			}
		}
		
		if(isElementPresent) {
			genericKeywords.logInfo("Item " + itemName + " is added in the cart correctly" );
		} else {
			genericKeywords.reportFailure("Item " + itemName + " does not exist in the cart" , isElementPresent);
		}
		
	}
	
	public void gotoCart() {
		clickButton(cart_btn);
	}
	


}
