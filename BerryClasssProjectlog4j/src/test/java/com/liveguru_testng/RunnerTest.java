package com.liveguru_testng;



import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;


//import com.liveguru.TestData.LoginTestData;




public class RunnerTest {	
		
		private WebDriver driver;
		private AbstractPage abstractPage;
		private HomePage homePage;
		private MyAccountPage myAccountPage;
		private WelcomePage welcomePage;


	@Before
	public void setUp(){
		driver = new FirefoxDriver();
		
		abstractPage = new AbstractPage(driver);
		
		homePage = new HomePage(driver);
		myAccountPage = new MyAccountPage(driver);
		welcomePage = new WelcomePage(driver);
		abstractPage.OpenAndMaximizeBrowser();

		
	}			

	@Test
	public void testLoginFunctionality(){
		homePage.openMyAccount();
		myAccountPage.loginWith();
		welcomePage.verifyLogin();
		}

	@After
	public void closeBrowser(){
		abstractPage.teardownbrowser();
	}

}
