package com.actitime.test;



import org.testng.annotations.Test;

import com.BaseClass.BaseTest;
import com.actitime.page.LoginPage;






public class LoginPageTest extends BaseTest {
	
	
	@Test(groups = {"Regression"})
	public void loginTest() throws Throwable {
		new LoginPage().login();
		
		
	}
	

}
