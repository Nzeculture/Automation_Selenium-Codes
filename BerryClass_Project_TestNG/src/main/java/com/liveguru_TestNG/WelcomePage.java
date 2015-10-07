package com.liveguru_TestNG;


import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class WelcomePage extends AbstractPage {

	public WelcomePage(WebDriver driver) {
		super(driver);
		
	}

	public void verifyLogin(String message){
		boolean result = driver.getPageSource().contains(message);
		Assert.assertTrue(result, "Test failed because the page does not contain"+ message);		
	}
	
}
