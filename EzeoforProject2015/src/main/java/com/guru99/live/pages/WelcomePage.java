package com.guru99.live.pages;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;

public class WelcomePage extends AbstractPage {

	public WelcomePage(WebDriver driver) {
		super(driver);
		
	}

	public void verifyLogin(String message){
		boolean result = driver.getPageSource().contains(message);
		Assert.assertTrue("Test failed because the page does not contain"+ message, result);		
	}
	
}
