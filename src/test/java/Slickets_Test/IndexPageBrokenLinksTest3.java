package Slickets_Test;

import org.testng.annotations.Test;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import BaseUtilities.AlertBox;
import BaseUtilities.BrowserStack;
import BaseUtilities.Chrome;
import BaseUtilities.Constants;
import BaseUtilities.DriverLoad;
import BaseUtilities.ExtentFactory;
import BaseUtilities.FindLinks;
import BaseUtilities.TakeScreenShot;
import PageFactory.LoginPage;
//import PageFactory.Navigation;
import PageFactory.NavigationLinks;
//import Slickets_Test.FindAllLinks5B;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;

public class IndexPageBrokenLinksTest3 extends Chrome {
	
	ExtentReports report;
	ExtentTest test;
	NavigationLinks NavigationElements;
	LoginPage 	LoginPageElements;
	AlertBox AlertBoxElements;
	TakeScreenShot ScreenShot;
	FindLinks Links;
	
	   	 
	 
  @BeforeMethod (groups = {"Smoke","BS_Smoke","BS_Sanity","Smoke_Firefox","Smoke_Chrome"})
  public void beforeMethod() throws Exception {
	  
	  NavigationElements = new NavigationLinks(driver);
	  LoginPageElements = new LoginPage(driver);
	  AlertBoxElements = new AlertBox(driver);
	  ScreenShot = new TakeScreenShot();
	  //NewTest = new IndexPageBrokenLinksTest3();
	  Links = new  FindLinks(driver);
	  report = ExtentFactory.getInstance4();

	  
  }

  @AfterMethod (groups = {"Smoke","BS_Smoke","BS_Sanity","Smoke_Firefox","Smoke_Chrome"})
  public void afterMethod(ITestResult result) throws IOException, Exception {
	  

		//report.endTest(test);
		//report.flush();
	  
  }
  
  
  @Test (priority = 0, groups = {"Smoke","BS_Smoke","BS_Sanity","Smoke_Firefox","Smoke_Chrome"})
  public void HomePage_Test() throws Exception {
	  
	  
	  //test = report.startTest("Nav Links Test --> HomePage Test-  ");
	  
	  String Path = "C:\\ExtentReport\\UkWebsite.csv";
	  driver.get("https://www.ssl247.co.uk");
	  driver.manage().window().maximize();
	  driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
	  
	  //NewTest.linkTest();
	  Links.DemoTestlinks("Uk Website", Path, "https://www.ssl247.co.uk");
	  
	  
	  //test.log(LogStatus.INFO, "Page Opened");

  }
  
}
