package com.runnermaterials;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import com.baseclass.BaseClass;
import com.runnermaterials.ExtentReportTest;
import com.pageobjectmanager.PageObjectManager;

@Listeners(ITestListnerClass.class)
public class LoginPage extends BaseClass {

	PageObjectManager pageobject = new PageObjectManager();

	@BeforeTest
	public void browser() {
		launchBrowser(pageobject.getFileReader().getDataProperty("Browser"));
	}
	@Test
	public void validLoginTest() {

		ExtentReportTest.extenttest = extentReports
				.createTest("Login Test" + " " + Thread.currentThread().getStackTrace()[1].getMethodName().toString())
				.info("ValidLogin");
		Assert.assertTrue(pageobject.getLoginpage().vaildLogin(ExtentReportTest.extenttest));
	}
	@AfterTest
	public void closeBrowser() {
		terminateBrowser();
	}
	@BeforeTest
	private void extendReportStartup() {
		extentReportsStart("D:\\Greens Java Selenium\\Test NG\\TestNG\\Reports");
	}
	@AfterTest
	private void extendReportEnd() throws IOException {
		extentReportTearDown("D:\\Greens Java Selenium\\Test NG\\TestNG\\Reports\\index.html");
	}
}