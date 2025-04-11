package com.framework.test;

import org.testng.annotations.Test;

import com.framework.base.basetest;
import com.framework.base.genericKeywords;
import com.framework.pages.LoginPage;
import com.framework.pages.ProductPage;

public class productTest extends basetest{
	
	@Test
	public void addtocartTest() {
		LoginPage login = new LoginPage(driver);
		login.gotoLogin();

		boolean isTitleMatch = driver.getTitle().equals(prop.getProperty("expectedTitle"));
		if(isTitleMatch) {
			genericKeywords.logInfo("Title is correct");
		}else {
			genericKeywords.reportFailure("Title is incorrect." + " Actual title: " + driver.getTitle() + "<---->"  + " Expected Title: " + prop.getProperty("expectedTitle"), true);
		}
		
		ProductPage addtoCart = new ProductPage(driver);
		addtoCart.addtoCart(prop.getProperty("item1"));
		addtoCart.addtoCart(prop.getProperty("item2"));
		
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
