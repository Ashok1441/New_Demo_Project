package com.actitime.test;

import org.testng.annotations.Test;

import com.BaseClass.BaseTest;
import com.actitime.page.LoginPage;

public class VerifyPageTitles extends BaseTest{
	
	
	@Test(groups = "Sanity")
	public void verifyloginPageTitles() throws Throwable {
		new LoginPage().Verifyloginpage();

		
		
	}
}
