package com.runnermaterials;

import java.io.IOException;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.MediaEntityBuilder;
import com.baseclass.BaseClass;

public class ITestListnerClass extends BaseClass implements ITestListener{
	@Override
	public void onTestStart(ITestResult result) {
		ITestListener.super.onTestStart(result);
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		try {
			ExtentReportTest.extenttest.pass(result.getMethod().getMethodName() + " : " + "Test Pass",
					MediaEntityBuilder.createScreenCaptureFromPath(takeScreenShot()).build());
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	@Override
	public void onTestFailure(ITestResult result) {
		try {
			ExtentReportTest.extenttest.fail(result.getMethod().getMethodName() + " : " + "Test Fail",
					MediaEntityBuilder.createScreenCaptureFromPath(takeScreenShot()).build());
		} catch (IOException e) {
			e.printStackTrace();
		}
		ITestListener.super.onTestFailure(result);
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		ITestListener.super.onTestSkipped(result);
	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		ITestListener.super.onTestFailedButWithinSuccessPercentage(result);
	}

	@Override
	public void onTestFailedWithTimeout(ITestResult result) {
		ITestListener.super.onTestFailedWithTimeout(result);
	}

	@Override
	public void onStart(ITestContext context) {
		ITestListener.super.onStart(context);
	}

	@Override
	public void onFinish(ITestContext context) {
		ITestListener.super.onFinish(context);
	}

}
