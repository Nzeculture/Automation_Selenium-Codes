package com.liveguru.www;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;


public class WelcomePage extends AbstractPage {

	public WelcomePage(WebDriver driver) {
		super(driver);
		
	}

	public void verifyLogin(){
		boolean result = driver.getPageSource().contains(config.getProperty("message"));
		Assert.assertTrue("Test failed because the page does not contain"+ config.getProperty("message"), result);
		logger.info("Page verification is successful");
	}
}
	