package com.runnermaterials;


import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.baseclass.BaseClass;
import com.pageobjectmanager.PageObjectManager;

public class LoginPageRunner extends BaseClass {

	PageObjectManager pageobjectmanager = new PageObjectManager();

	@BeforeTest
	public void browser() {
		launchBrowser(pageobjectmanager.getFileReader().getDataProperty("Browser"));
	}

	@Test(dependsOnMethods = "departmentOnlyTest")
	public void validLoginTest() {
		pageobjectmanager.getLoginpage().vaildLogin();
	}
	
	@Test(invocationCount = 3)
	public void invaildPasswordTest() {
		pageobjectmanager.getLoginpage().invaildPassword();
	}
	
	@Test(dependsOnMethods = "invaildPasswordTest")
	public void invaildDepartmentTest() {
		pageobjectmanager.getLoginpage().invaildDepartment();
	}
	
	@Test(dependsOnMethods = "invaildDepartmentTest")
	public void withoutAnyDataTest() {
		pageobjectmanager.getLoginpage().withoutAnyData();
	}
	
	@Test(dependsOnMethods = "withoutAnyDataTest")
	public void departmentOnlyTest() {
		pageobjectmanager.getLoginpage().departmentOnly();
	}
	

	@AfterTest
	public void closeBrowser() {
		terminateBrowser();
	}
}