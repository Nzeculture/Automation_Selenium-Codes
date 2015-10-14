package com.guru99.live.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class MyAccountPage extends AbstractPage{

	public MyAccountPage(WebDriver driver) {
		super(driver);
		
	}
	
	public void loginWith(String username, String password){
		driver.findElement(By.id("email")).sendKeys(username);
		driver.findElement(By.id("pass")).sendKeys(password);
		driver.findElement(By.id("send2")).click();
		
	} 	
}
