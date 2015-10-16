package com.liveguru.www;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class MyAccountPage extends AbstractPage{

	public MyAccountPage(WebDriver driver) {
		super(driver);
		
	}
	
	public void loginWith(){
		try{
		driver.findElement(By.id("email")).sendKeys(config.getProperty("username"));
		logger.info("Username entered successfully");
		driver.findElement(By.id("pass")).sendKeys(config.getProperty("password"));
		logger.info("Password entered successfully");
		driver.findElement(By.id("send2")).click();
		logger.info("Login button clicked");
		}
		catch(Throwable t){
			logger.error("Login details not entered correctly");
	
			
		}
		
	} 	
}
