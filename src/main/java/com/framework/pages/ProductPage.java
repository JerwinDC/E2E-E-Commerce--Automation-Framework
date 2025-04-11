package com.framework.pages;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.framework.base.basetest;
import com.framework.base.genericKeywords;

public class ProductPage extends basetest{
	WebDriver driver;
	
	public ProductPage(WebDriver driver) {
		this.driver = driver;
	}
	
	By backpack_btn = By.id(prop.getProperty("backpack_btn"));
	By bikelight_btn = By.id(prop.getProperty("bikelight_btn"));
	By bolttshirt_btn =  By.id(prop.getProperty("bolttshirt_btn"));
	By fleecejacket_btn =  By.id(prop.getProperty("fleecejacket_btn"));
	By onesie_btn =  By.id(prop.getProperty("onesie_btn"));
	By allthethings_btn =  By.id(prop.getProperty("allthethings_btn"));
	
	List<By> list = new ArrayList<By>();

	
	private void clickAddtocart(By locators) {
		genericKeywords.logInfo("Clicked the add to cart button located in the specified locator: " + locators);
		driver.findElement(locators).click();
	}
	
	private void addLocatorstoList() {
		list.add(backpack_btn);
		list.add(bikelight_btn);
		list.add(bolttshirt_btn);
		list.add(fleecejacket_btn);
		list.add(onesie_btn);
		list.add(allthethings_btn);
	}
	
	public static String trimBeforeWord(String text, String word) {
        int index = text.indexOf(word);
        if (index != -1) {
            return text.substring(index);
        }
        return "";
    }

	
	public void addtoCart(String name) {
		String newName = name.replaceAll(" ", "-");
		addLocatorstoList();
		Iterator<By> iterator = list.iterator();
		boolean isMatch = false;
		while(iterator.hasNext()) {
			By by = (By) iterator.next();
			String StringBy = by.toString();
			trimBeforeWord(StringBy,newName);
			if(StringBy.endsWith(newName)) {
				isMatch = true;
				clickAddtocart(by);
				break;
			}
			iterator.next();
		}
		if(isMatch) {
			genericKeywords.logInfo("Successfully added " + name.toUpperCase() + " to the cart.");
		} else {
			genericKeywords.logInfo("Item does not exist");
		}
	};

}
