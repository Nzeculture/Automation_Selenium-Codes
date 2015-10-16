package com.live.magento.browsers;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.live.magento.pages.AbstractPage;



public class Browsers {
	

	protected static WebDriver driver;
	protected static Properties config = new Properties();
	protected static FileInputStream fis;
	protected static Logger logger = LogManager.getLogger("TestLogger");


	

	public void instatiateDriver(){
		
		
		if(driver == null){
			String path = System.getProperty("user.dir");
			try {
				logger.info("Loaded properties 1");
				fis = new FileInputStream(path +"/src/main/resources/testDataRepo.properties");
				logger.info("Loaded properties 2");
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			}
			try {
				config.load(fis);
				logger.info("Loaded properties 3");
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
		if(config.getProperty("browser").equalsIgnoreCase("firefox")){
			logger.info("Loaded driver ff");
			driver = new FirefoxDriver();
		}else if(config.getProperty("browser").equalsIgnoreCase("chrome")){
			logger.info("about to ch");
			System.setProperty("webdriver.chrome.driver", "/home/dotcom/projects/java_projects/team_redbulls_repo/first_basic_framework_24092015/drivers/chromedriver");
			driver = new ChromeDriver();
			logger.info("Loaded driver ch");
		}else{
			System.out.println("Hello");
		}

	
		

		
		
	}
	
	
	

	
	
	

	

}
