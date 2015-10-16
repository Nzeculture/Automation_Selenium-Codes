package com.live.magento.pages;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class HomePage extends AbstractPage{
	
	
	
	public HomePage(WebDriver driver) {
		super(driver);
	}

	
	
	public void openMyAccount() {
		try {
		driver.findElement(By.xpath("//*[@id='top']/body/div[1]/div/div[3]/div/div[4]/ul/li/a")).click();
		logger.info("Account has been opened successfully");
		}catch(Throwable t) {
			logger.error("The method openMyAccount has encountered error ", t);
			camera.takeShot("openMyAccount");
			
		}
	}
}
