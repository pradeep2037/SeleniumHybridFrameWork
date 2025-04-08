package utils;

import org.openqa.selenium.JavascriptExecutor;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.Status;

import base.BaseTest;

public class MyTestNGListener extends BaseTest implements ITestListener{

	@Override
	public void onTestStart(ITestResult result) {
		test.log(Status.INFO, result.getMethod().getMethodName() + " is started...");
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		test.addScreenCaptureFromPath(UtilKit.getScreenShot());
		test.log(Status.PASS, result.getMethod().getMethodName()+" is passes...");
	}

	@Override
	public void onTestFailure(ITestResult result) {
		test.addScreenCaptureFromPath(UtilKit.getScreenShot());
		test.log(Status.FAIL, result.getMethod().getMethodName()+" is failed...");
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		// TODO Auto-generated method stub
		ITestListener.super.onTestSkipped(result);
	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		// TODO Auto-generated method stub
		ITestListener.super.onTestFailedButWithinSuccessPercentage(result);
	}

	@Override
	public void onTestFailedWithTimeout(ITestResult result) {
		// TODO Auto-generated method stub
		ITestListener.super.onTestFailedWithTimeout(result);
	}

	@Override
	public void onStart(ITestContext context) {
		// TODO Auto-generated method stub
		ITestListener.super.onStart(context);
	}

	@Override
	public void onFinish(ITestContext context) {
		
	}
}
