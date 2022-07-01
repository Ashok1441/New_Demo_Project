package com.UtilityClass;

import java.io.IOException;

import org.testng.ITestResult;

import com.BaseActionClass.Action;
import com.BaseClass.BaseTest;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentManager{
	
	public static ExtentSparkReporter sparkReporter;
	public static ExtentReports extentReports;
	public static ExtentTest extentTest;
	
	public static void setUpExtentReport() {
		
		sparkReporter=new ExtentSparkReporter("ExtentReport\\ExtentReport.html");
		extentReports = new ExtentReports();
		extentReports.attachReporter(sparkReporter);
		
		
		extentReports.setSystemInfo("Tester Name", "Ashok");
		extentReports.setSystemInfo("OS", System.getProperty("os.name"));
		extentReports.setSystemInfo("Java version", System.getProperty("java.version"));
	}
	
	public static void extent_Create(ITestResult result) {
		extentTest = extentReports.createTest(result.getName());
	}
	
	public static void extent_Info(ITestResult result) {
		extentTest.info(result.getName()+"test method is Started");
	}
	
	public static void extent_Pass(ITestResult result) {
		extentTest.pass(result.getName()+" test method is Passed");
	}
	
	public static void extent_Fail(ITestResult result) {
		extentTest.fail(result.getName()+" test method is Failed");
	}
	
	public static void extent_AttachScreenShot(ITestResult result, String text)  {
		String path;
		try {
			path = Action.screenShot(BaseTest.driver,result.getName());
			extentTest.fail(text+" test Screenshot is attached",MediaEntityBuilder.createScreenCaptureFromPath(path,result.getName()).build());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public static void extent_FailThrowable(ITestResult result) {
		extentTest.fail(result.getThrowable());
	}
	
	public static void extent_Skip(ITestResult result) {
		extentTest.skip(result.getName()+" test method is Skipped");
	}
	
	public static void extent_SkipThrowable(ITestResult result) {
		extentTest.skip(result.getThrowable());
	}
	
	public static void extent_AssignAuthor(String enterAuthorName) {
		extentTest.assignAuthor(enterAuthorName);
	}
	
	public static void extent_AssignCategory(String enterCategoryName) {
		extentTest.assignCategory(enterCategoryName);
	}
	
	public static void extent_Info(String enterMessage) {
		extentTest.info(enterMessage);
	}

	public static void endExtentReport() throws IOException {
		extentReports.flush();
		//Desktop.getDesktop().browse(new File("ExtentReport.html").toURI());
	}
	
	
}
