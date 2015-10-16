package com.live.magento.utilities;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class Screenshot {
	
	
	private WebDriver driver;
	
	public Screenshot(WebDriver driver) {
		this.driver = driver;
	}
	
	public void takeShot(String methodName) {
		File scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		String path = System.getProperty("user.dir");
		String path2 = "/src/main/resources/com/live/magento/screenshots";
		try {
			FileUtils.copyFile(scrFile, new File(path + path2  +methodName + ".jpeg"));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
