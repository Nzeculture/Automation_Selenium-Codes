package com.liveguru.TestData;

import org.testng.annotations.DataProvider;

public class LoginTestData {
	
	@DataProvider(name = "LoginData")
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
}
