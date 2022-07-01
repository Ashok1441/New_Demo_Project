package com.actitime.page;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.BaseActionClass.Action;
import com.BaseClass.BaseTest;
import com.BaseClass.FileLib;



public class LoginPage extends BaseTest {
   	
	
	
	@FindBy(name="username") public WebElement untb;
	
	@FindBy(name="pwd") public WebElement passWord;
	
	@FindBy(id="loginButton") public WebElement lgnbutton;
	
	public LoginPage() {
		PageFactory.initElements(driver, this);
	}
	
public  void Verifyloginpage() throws Throwable {
		
		Action.getUrl(new FileLib().readProprertyData(Prop_Path, "url"));
		Action.assertEqualChar("loginPageTitle");
		
		
		
	}
	public  void login() throws Throwable {
		Action.getUrl(new FileLib().readProprertyData(Prop_Path, "url"));
		Action.type(untb, new FileLib().readProprertyData(Prop_Path, "username"));
		Action.type(passWord, new FileLib().readProprertyData(Prop_Path, "password"));
		Action.click(lgnbutton, "loginButton");
		
	}
}
