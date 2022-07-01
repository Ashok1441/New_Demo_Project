package com.BaseClass;

import java.io.IOException;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Reporter;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Parameters;

import com.BaseActionClass.Action;
import com.UtilityClass.ExtentManager;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseTest implements IAutoConsts {
	
	public static WebDriver driver;
	
	@BeforeSuite
	public void extentReport() {
		ExtentManager.setUpExtentReport();
		
	}
	
	@AfterSuite
	public void endExtentReport() throws IOException {
		ExtentManager.endExtentReport();
	}
	

	@Parameters("Browser")
	@BeforeMethod(groups = "Regression")
	public static void launchApp(String browserName) throws Throwable { //
		
		if(browserName.equals("chrome")) {
			WebDriverManager.chromedriver().setup();
			driver=new ChromeDriver();
		}
		else if(browserName.equals("edge")) {
			WebDriverManager.edgedriver().setup();
		    driver= new EdgeDriver();
		}
		else if(browserName.equals("firefox")) {
			WebDriverManager.firefoxdriver().setup();
			driver=new FirefoxDriver();	
		}
		else {
			Reporter.log("Given Browser name is Mismatched", true);
		}

	}
	
	@AfterMethod(groups = "Regression")
	public void teardown() {
		driver.quit();
	}

}
