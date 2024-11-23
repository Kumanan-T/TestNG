package com.runnermaterials;

import java.io.IOException;

import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import com.aventstack.extentreports.ExtentTest;
import com.baseclass.BaseClass;

public class ExtentReportTest extends BaseClass {
	public static ExtentTest extenttest;
	@BeforeSuite
	
	public void extentTestReportsStartup()throws IOException {
		BaseClass base = new BaseClass() {

		};
		base.extentReportsStart(null);
	}
	
	@AfterSuite
	
	public void extendReportEnd() throws IOException {
		BaseClass base = new BaseClass() {

		};
		base.extentReportTearDown(null);
	}
}
