package com.live.magento.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class MyAccountPage extends AbstractPage{

	public MyAccountPage(WebDriver driver) {
		super(driver);
	}
	
	public void loginWith() {
		try {
			driver.findElement(By.id("email")).sendKeys(config.getProperty("username"));
			logger.info("Username has been entered successfully");
			driver.findElement(By.id("pass")).sendKeys(config.getProperty("password"));
			logger.info("Password has been entered successfully");
			driver.findElement(By.id("send2")).click();
			logger.info("Login button has been clicked successfully");
			camera.takeShot("openMyAccount");
		}catch(Exception e) {
			logger.error("The loginWith method has encountered an error", e);
			camera.takeShot("loginWith");
		}
	}
	
	
	public void loginWith(String username, String password) {
		try {
			driver.findElement(By.id("email")).sendKeys(username);
			logger.info("Username has been entered successfully");
			driver.findElement(By.id("pass")).sendKeys(password);
			logger.info("Password has been entered successfully");
			driver.findElement(By.id("send2")).click();
			logger.info("Login button has been clicked successfully");
			camera.takeShot("openMyAccount");
		}catch(Exception e) {
			logger.error("The loginWith method has encountered an error", e);
			camera.takeShot("loginWith");
		}
	}

}
