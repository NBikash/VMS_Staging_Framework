package com.VMS.Generic;
import java.io.IOException;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;


import com.VMS.POM.HomePage;
import com.VMS.POM.LoginPage;
import com.aventstack.extentreports.ExtentReports;



import com.aventstack.extentreports.reporter.ExtentSparkReporter;


public class Baseclass {
	public static WebDriver driver;
	public static ExtentReports extent = new ExtentReports();
	ExtentSparkReporter spark = new ExtentSparkReporter("ExtentReport.html");
	FileLibrary f=new FileLibrary();
	
	@BeforeTest
	public void BeforeTest() {
		extent.attachReporter(spark);
		
	}
	@BeforeClass
	public void openBrowser() throws IOException
	{		
		driver=new ChromeDriver();
		Generic g=new Generic();
		g.implicitWait(10);
		driver.manage().window().maximize();
		String url=f.readproperty("url");
		driver.get(url);
		Reporter.log("Browser Opened",true);
	}
	@BeforeMethod
	public void login() throws IOException, InterruptedException
	{		
		FileLibrary f=new FileLibrary();
		String un = f.readproperty("un");
		String pw=f.readproperty("pwd");
		LoginPage l=new LoginPage(driver);
		l.setlogin(un, pw);
		Reporter.log("Sucessfully logged",true);
		
	}
	@AfterMethod
	public void logout() throws InterruptedException
	{		
		HomePage h=new HomePage(driver);
		h.getlogout();
		Reporter.log("logout",true);		
	}
	@AfterClass
	public void closeBrowser()
	{		
		driver.close();
		Reporter.log("closeBrowser",true);
	}
	@AfterTest
	public void AfterTest() {
		extent.flush();
		
	}

}
