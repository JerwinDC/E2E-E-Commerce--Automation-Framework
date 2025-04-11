package com.framework.test;

import org.testng.annotations.Test;

import com.framework.base.basetest;
import com.framework.base.genericKeywords;
import com.framework.pages.LoginPage;

public class loginTest extends basetest{
	
	@Test
	public void gotoLoginPage() {
		LoginPage login = new LoginPage(driver);
		login.gotoLogin();

		boolean isTitleMatch = driver.getTitle().equals(prop.getProperty("expectedTitle"));
		if(isTitleMatch) {
			genericKeywords.logInfo("Title is correct");
		}else {
			genericKeywords.reportFailure("Title is incorrect." + " Actual title: " + driver.getTitle() + "<---->"  + " Expected Title: " + prop.getProperty("expectedTitle"), true);
		}
		
		
	}

}
