package com.live.magento.test_area;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Collection;

import org.junit.After;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.live.magento.helper.WorldHelper;
import com.live.magento.pages.AbstractPage;
import com.live.magento.pages.HomePage;
import com.live.magento.pages.MyAccountPage;
import com.live.magento.pages.SearchResultPage;
import com.live.magento.pages.WelcomePage;
import com.live.magento.spreadsheet.util.SpreadsheetTestData;
import com.live.magento.utilities.Screenshot;
import com.tngtech.java.junit.dataprovider.DataProvider;
import com.tngtech.java.junit.dataprovider.DataProviderRunner;
import com.tngtech.java.junit.dataprovider.UseDataProvider;




@RunWith(Parameterized.class)
public class MagentoSearchFeatureTest {
	@Parameters
	public static Collection spreadsheetData() throws IOException {
		String excelPAth = System.getProperty("user.dir");
		InputStream spreadsheet = new FileInputStream(excelPAth+"/src/test/resources/SprintOne/SprintOneSearchTestData.xls");
		return new SpreadsheetTestData(spreadsheet).getData();
	}
	
	
	
	private String productName;
	private WorldHelper helper;


	public MagentoSearchFeatureTest(String productName) {
		this.productName = productName;
	}
	

	

	@Before
	public void setUp() {
		this.helper = new WorldHelper();
		helper.getAbstractPage().openAndMaximizePage();
		System.out.println(helper);
	}
	
	
	@Test 
	public void searchingForProducts() {
		helper.getAbstractPage().searchForProduct(productName);
		helper.getSearchResultPage().verifyTheProduct(productName);
	}
	
	
	



	
	@After
	public void executePostCondition() {
		helper.getAbstractPage().tearDown();
	}
	
//	
//	@DataProvider
//	public static Object[][] testDataForSearchProduct() {
//		 return new Object[][] {
//             { "LG LCD"},
//             { "Samsung Galaxy"},             
//     };
//	}
//	
	

}
