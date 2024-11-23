package com.baseclass;

import java.awt.Desktop;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class BaseClass {

	public static WebDriver driver;
	public static ExtentReports extentReports;
	public static File file;

	protected static WebDriver launchBrowser(String browsername) {
		try {
			if (browsername.equalsIgnoreCase("chrome")) {
				driver = new ChromeDriver();
			} else if (browsername.equalsIgnoreCase("edge")) {
				driver = new EdgeDriver();
			} else if (browsername.equalsIgnoreCase("firefox")) {
				driver = new FirefoxDriver();
			}

		} catch (Exception e) {
			Assert.fail("Error: Occur During Browser Opening!");
		}
		driver.manage().window().maximize();
		return driver;
	}

	protected static WebDriver launchUrl(String url) {
		try {
			driver.get(url);
		} catch (Exception e) {
			Assert.fail("Error: Occur During Opening The Url!");
		}
		return driver;
	}

	protected static void terminateBrowser() {
		try {
			driver.quit();
		} catch (Exception e) {
			Assert.fail("Error: Occur During Quit The Browser!");
		}
	}

	protected static void passValues(WebElement element, String value) {
		try {
			element.sendKeys(value);
		} catch (Exception e) {

		}
	}

	protected static void clickElement(WebElement element) {
		try {
			element.click();
		} catch (Exception e) {
			Assert.fail("Error: Occur During Clicking The Element!");
		}
	}

	protected static void validation(String actual, String excepted) {
		try {
			Assert.assertEquals(actual, excepted);
		} catch (Exception e) {
			Assert.fail("Error: Occur During Validation");
		}
	}

	public static void extentReportsStart(String location) {
		extentReports = new ExtentReports();
		file = new File(location);
		ExtentSparkReporter sparkRepoter = new ExtentSparkReporter(file);
		extentReports.attachReporter(sparkRepoter);
		extentReports.setSystemInfo("OS", System.getProperty("os.name"));
		extentReports.setSystemInfo("Java Version", System.getProperty("java.version"));
	}

	public static void extentReportTearDown(String location) throws IOException {
		extentReports.flush();
		file = new File(location); 
		Desktop.getDesktop().browse((file).toURI());
	}

	public String takeScreenShot() throws IOException {
		TakesScreenshot screenshot = (TakesScreenshot) driver;
		String timeStamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date());
		File scrfile = screenshot.getScreenshotAs(OutputType.FILE);
		File destfile = new File("D:\\TestNG\\TestNGTutorial\\Screenshot_" + timeStamp + ".png");
		FileUtils.copyFile(scrfile, destfile);
		return destfile.getAbsolutePath();
	}
}