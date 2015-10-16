package com.live.magento.test_area;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.live.magento.helper.WorldHelper;
import com.live.magento.pages.AbstractPage;
import com.live.magento.pages.HomePage;
import com.live.magento.pages.MyAccountPage;
import com.live.magento.pages.SearchResultPage;
import com.live.magento.pages.WelcomePage;
import com.live.magento.spreadsheet.util.Constant;
import com.live.magento.spreadsheet.util.ExcelReader;
import com.live.magento.utilities.Screenshot;


public class MagentoLoginFeatureTest {
	

	private WorldHelper helper;

	@Before
	public void setUp() throws Exception {
		helper = new WorldHelper();
		helper.getAbstractPage().openAndMaximizePage();
		ExcelReader.setExcelFile(Constant.Path_TestData+Constant.file_TestData, "login_data");
	}

	
	

	@Test 
	public void loginTest()  {
		try {
		String username = ExcelReader.getCellData(1, 1);
		String password = ExcelReader.getCellData(1, 2);
		helper.getHomePage().openMyAccount();
		helper.getMyAccountPage().loginWith(username, password);
		helper.getWelcomePage().verifyLogin();
		ExcelReader.setCellData("Passed", 1, 3);
		}catch(Exception e) {
			try {
				ExcelReader.setCellData("Failed", 1, 3);
			} catch (Exception e1) {
				e1.printStackTrace();
			}
		}
	}


	@Test 
	public void loginTestwithValidUsernameAndInvalidPassword()  {
		try {
		String username = ExcelReader.getCellData(2, 1);
		String password = ExcelReader.getCellData(2, 2);
		helper.getHomePage().openMyAccount();
		helper.getMyAccountPage().loginWith(username, password);
		helper.getWelcomePage().verifyLogin();
		ExcelReader.setCellData("Passed", 2, 3);
		}catch(Exception e) {
			try {
				ExcelReader.setCellData("Failed", 2, 3);
			} catch (Exception e1) {
				e1.printStackTrace();
			}
		}
	}
	
	

	@Test 
	public void loginTestwithInValidUsernameAndvalidPassword()  {
		try {
		String username = ExcelReader.getCellData(3, 1);
		String password = ExcelReader.getCellData(3, 2);
		helper.getHomePage().openMyAccount();
		helper.getMyAccountPage().loginWith(username, password);
		helper.getWelcomePage().verifyLogin();
		ExcelReader.setCellData("Passed", 3, 3);
		}catch(Exception e) {
			try {
				ExcelReader.setCellData("Failed", 3, 3);
			} catch (Exception e1) {
				e1.printStackTrace();
			}
		}
	}
	
	@After
	public void executePostCondition() {
		helper.getAbstractPage().tearDown();
	}
}
