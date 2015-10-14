package com.guru99.live.pages;

import org.openqa.selenium.WebDriver;

public class AbstractPage {
	
	public WebDriver driver;
	protected String BaseUrl= "http://live.guru99.com/";


	public AbstractPage (WebDriver driver){
		this.driver = driver;
	}

	public void Openandmaximizebrowser(){
		driver.manage().window().maximize();
		driver.navigate().to(BaseUrl);
	}
	
	public void teardownbrowser(){
		driver.quit();
	}
	
}
