package com.live.magento.pages;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;

public class WelcomePage extends AbstractPage{

	public WelcomePage(WebDriver driver) {
		super(driver);
	}
	
	
	public void verifyLogin() {
		try {
			boolean test1 = driver.getPageSource().contains(config.getProperty("name"));
			Assert.assertTrue("The test could not find name: "+config.getProperty("name"), test1);
			logger.info("name has been verified");
			boolean test2 = driver.getPageSource().contains(config.getProperty("username"));
			Assert.assertTrue("The test could not find username: "+config.getProperty("username"), test2);
			logger.info("Ussername has been verified");
		}catch(Throwable t) {
			logger.error("The verify method has encountered error ", t);
			camera.takeShot("verifyLogin");
		}
		
	}

}
