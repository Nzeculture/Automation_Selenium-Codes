package com.liveguru_TestNG;


import com.liveguru_TestNG.AbstractPage;
import com.liveguru_TestNG.HomePage;
import com.liveguru_TestNG.MyAccountPage;
import com.liveguru_TestNG.WelcomePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.liveguru.TestData.LoginTestData;


public class RunnerTest {
	
		private WebDriver driver;
		protected AbstractPage abstractPage;
		private HomePage homePage;
		private MyAccountPage myAccountPage;
		private WelcomePage welcomePage;


	@BeforeMethod
	public void setUp(){
		driver = new FirefoxDriver();
		abstractPage = new AbstractPage(driver);
		homePage = new HomePage(driver);
		myAccountPage = new MyAccountPage(driver);
		welcomePage = new WelcomePage(driver);	
		abstractPage.Openandmaximizebrowser();
	}	


	

	@Test (dataProvider = "LoginData", dataProviderClass = LoginTestData.class)
	public void testLoginFunctionality(String username, String password, String message){
		homePage.openMyAccount();
		myAccountPage.loginWith(username, password);
		welcomePage.verifyLogin(message);
		}

	@AfterMethod
	public void closeBrowser(){
		abstractPage.teardownbrowser();
	}

}
