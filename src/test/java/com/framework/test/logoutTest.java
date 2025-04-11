package com.framework.test;

import org.testng.annotations.Test;

import com.framework.base.basetest;
import com.framework.pages.CartPage;
import com.framework.pages.CheckoutOne;
import com.framework.pages.CheckoutTwo;
import com.framework.pages.LoginPage;
import com.framework.pages.LogoutPage;
import com.framework.pages.ProductPage;

public class logoutTest extends basetest {
	
	@Test
	public void logoutTestCase() {
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
		
		CheckoutOne checkOne = new CheckoutOne(driver);
		checkOne.proceedtoCheckOut();
		validateTitle(prop.getProperty("expectedTitle"));
		checkOne.fillUpformandProceed();
		
		CheckoutTwo checkTwo = new CheckoutTwo(driver);
		checkTwo.finishCheckOut();
		checkTwo.validateCheckOutResult(prop.getProperty("CheckoutStatus"));
		
		LogoutPage logOut = new LogoutPage(driver);
		logOut.logOut();
		
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		
	}
	
}
