package com.live.magento.test_area;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Collection;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;


import com.live.magento.helper.WorldHelper;
import com.live.magento.spreadsheet.util.SpreadsheetTestData;


@RunWith(Parameterized.class)
public class MagentoLoginWithParameterizationTest {
	
	
	@Parameters
	public static Collection spreadsheetData() throws IOException {
		String path = System.getProperty("user.dir");
		InputStream spreadsheet = new FileInputStream(path+"/src/test/resources/SprintOne/SprintOneLoginTestData.xls");
		return new SpreadsheetTestData(spreadsheet).getData();
	}


	private String username;
	private String password;
	private WorldHelper helper;
	
	public MagentoLoginWithParameterizationTest(String username, String password) {
		super();
		this.username = username;
		this.password = password;
	}


	@Before
	public void setUp() throws Exception {
		helper = new WorldHelper();
		helper.getAbstractPage().openAndMaximizePage();
	}

	
	

	@Test 
	public void loginTest()  {
		helper.getHomePage().openMyAccount();
		helper.getMyAccountPage().loginWith(username, password);
		helper.getWelcomePage().verifyLogin();
		
	}


		
	@After
	public void executePostCondition() {
		helper.getAbstractPage().tearDown();
	}
	
	
	
	
}