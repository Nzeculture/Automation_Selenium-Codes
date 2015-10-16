package com.live.magento.pages;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.live.magento.utilities.Screenshot;

public class AbstractPage {
	
	protected static WebDriver driver;
	protected static Properties config = new Properties();
	protected static InputStream fis;
	protected static Screenshot camera;
	protected static Logger logger = LogManager.getLogger("TestLogger");
	
	
	private static String searchID = "search";
	private static String searchButton = ".button.search-button";
	
	public AbstractPage(WebDriver driver) {
		this.driver = driver;
		camera = new Screenshot(driver);
		String path = System.getProperty("user.dir");
		try {
			fis = new FileInputStream(path +"/src/main/resources/testDataRepo.properties");
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		try {
			config.load(fis);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	
	public void openAndMaximizePage() {
		try {
//			250usec
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.MILLISECONDS);
		driver.manage().window().maximize();
		logger.info("Browser has been maximized");
//		String formattedUrl = Anything.formatUrl(config.getProperty("base_url"));
		driver.navigate().to(config.getProperty("base_url"));
		logger.info("The web Address has been loaded successfully");
		}catch(Exception e) {
			logger.error("The openAndMaximizePage method has eencountered error "+e);
			camera.takeShot("openAndMaximizePage");
		}
	}
	
	
	public void tearDown() {
		try {
		
		driver.quit();
		logger.info("The browser has now quit");
		driver = null;
		logger.info("The browser has no value anymore");
		}catch(Throwable t) {
			logger.error("The tearDown has encountered error", t);
			camera.takeShot("tearDown");
		}
	}


	public void searchForProduct(String productName) {
		try {
			driver.findElement(By.id(searchID)).sendKeys(productName);
			logger.info("The product " +productName+ " has been populated successfully");
			driver.findElement(By.cssSelector(searchButton)).click();	
			logger.info("The search button has been clicked successfully");
			}catch(Throwable t) {
				logger.error("The searchForProduct has encountered error", t);
				camera.takeShot("searchForProduct");
			}
	}
	

}
