package com.guru99.live.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage extends AbstractPage {

	public HomePage(WebDriver driver) {
		super(driver);
		
	}

	public void openMyAccount(){
		driver.findElement(By.xpath("//*[@id='top']/body/div[1]/div/div[3]/div/div[4]/ul/li[1]/a")).click();
	}
}
