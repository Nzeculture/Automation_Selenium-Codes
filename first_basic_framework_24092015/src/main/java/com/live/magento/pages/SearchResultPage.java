package com.live.magento.pages;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class SearchResultPage extends AbstractPage{

	public SearchResultPage(WebDriver driver) {
		super(driver);
	}

	public void verifyTheProduct(String productName) {
		try {
			boolean conditionRes = driver.getPageSource().contains(productName);
			logger.info("The condition has been determined"+ conditionRes);
			Assert.assertFalse("The Product does not exist on the application", !conditionRes);
			logger.info("The product has been found on the page");
		}catch(Exception e) {
			logger.error("The verifyTheProduct method has encountered error", e);
			camera.takeShot("verifyTheProduct");
		}
		
	}
	
	
	

}
