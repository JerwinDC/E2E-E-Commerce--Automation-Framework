package com.framework.test;

import org.testng.annotations.Test;

import com.framework.base.basetest;
import com.framework.pages.CartPage;
import com.framework.pages.LoginPage;
import com.framework.pages.ProductPage;

public class cartTest extends basetest {
	
	
	@Test
	public void checkoutTest() {
		LoginPage login = new LoginPage(driver);
		login.gotoLogin();
		validateTitle(prop.getProperty("expectedTitle"));
		
		ProductPage addtoCart = new ProductPage(driver);
		addtoCart.addtoCart(prop.getProperty("item1"));
		addtoCart.addtoCart(prop.getProperty("item2"));
		
		CartPage cart = new CartPage(driver);
		cart.gotoCart();
		validateTitle(prop.getProperty("expectedTitle"));
		
		cart.validateCart(prop.getProperty("item1"));
		cart.validateCart(prop.getProperty("item2"));
		
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
