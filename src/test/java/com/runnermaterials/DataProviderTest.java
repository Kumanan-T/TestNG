package com.runnermaterials;

import java.time.Duration;

import org.openqa.selenium.By;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.baseclass.BaseClass;

public class DataProviderTest extends BaseClass{
	
	@Test(dataProvider = "login")
	public void login(String username, String password) {
		launchBrowser("chrome");
		launchUrl("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.findElement(By.name("username")).sendKeys(username);
		driver.findElement(By.name("password")).sendKeys(password);
		driver.findElement(By.xpath("//button[text()=' Login ']")).click();
	}
	
	@DataProvider(name = "login")
	public Object [][] dataset(){
		
		return new Object[][]
				{{"Admin","admin123"},{"ADM!N","!@#"},{"admin","admin"},{"   ","   "}};
	}
}