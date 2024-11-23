package com.webelementsinterface;

public interface ElementInterface {
	String userNameXPath = "//input[@name='username']";
	String PasswordXPath = "//input[@id='password']";
	String departmentXpath = "//li[@id='Isolation Ward']";
	String loginButton = "//input[@id='loginButton']";
	
	String errorMsg = "//div[@id='error-message']";
	
	String locationMsg = "//span[@class = 'location-error']";

}
