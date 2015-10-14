package com.guru99.live_Test;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.guru99.live.pages.AbstractPage;
import com.guru99.live.pages.HomePage;
import com.guru99.live.pages.MyAccountPage;
import com.guru99.live.pages.WelcomePage;
import com.tngtech.java.junit.dataprovider.DataProvider;
import com.tngtech.java.junit.dataprovider.DataProviderRunner;
import com.tngtech.java.junit.dataprovider.UseDataProvider;

@RunWith(DataProviderRunner.class)
public class RunnerTest {

	
		
		private WebDriver driver;
		protected AbstractPage abstractPage;
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
		abstractPage.Openandmaximizebrowser();
	}	


		
	@DataProvider
	public static Object[][]dataForLoginTest(){
		return new Object[][]{
			{"234dotus@gmail.com", "password123", "Donald"},
			{"234dotus@gmail.com", "password123jghg", "Invalid login or password."},
			{"234hfjahsfdotus@gmail.com", "password123", "Invalid login or password."},
			{"234hfjahsfdotus@gmail.com", "password123jghg", "Invalid login or password."},
			{"         ", "password123", "Login"},
			{"         ", "password123jghg", "Login"},
			{"234dotus@gmail.com", "     ", "Login"},
			{"234hfjahsfdotus@gmail.com", "     ", "Login"},
			{"    ", "     ", "Login"}
		};

	}

	@Test @UseDataProvider("dataForLoginTest")
	public void testLoginFunctionality(String username, String password, String message){
		homePage.openMyAccount();
		myAccountPage.loginWith(username, password);
		welcomePage.verifyLogin(message);
		}

	@After
	public void closeBrowser(){
		abstractPage.teardownbrowser();
	}

}
