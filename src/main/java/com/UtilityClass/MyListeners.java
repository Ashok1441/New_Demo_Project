package com.UtilityClass;

import org.testng.ITestListener;
import org.testng.ITestResult;

public class MyListeners implements ITestListener  {
	
	public void onTestStart(ITestResult result) {
		ExtentManager.extent_Create(result);
		ExtentManager.extent_AssignAuthor("Ashok");
		ExtentManager.extent_AssignCategory("RegressionTest");
		Log.startTestCase(result.getName());
		ExtentManager.extent_Info(result);
		
	}

	public void onTestSuccess(ITestResult result) {
		ExtentManager.extent_Pass(result);
		Log.endTestCase(result.getName());
	}

	public void onTestFailure(ITestResult result) {
		ExtentManager.extent_Fail(result);
		ExtentManager.extent_FailThrowable(result);
		ExtentManager.extent_AttachScreenShot(result, "Failed");
		Log.info("-------------------"+result.getName()+ " Is Failed---------------------------");
		
	}

	public void onTestSkipped(ITestResult result) {
		
		ExtentManager.extent_Skip(result);
		ExtentManager.extent_SkipThrowable(result);
		ExtentManager.extent_AttachScreenShot(result, "Skipped");
		
	}

	
	
}
