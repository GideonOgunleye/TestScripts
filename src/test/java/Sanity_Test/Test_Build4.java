package Sanity_Test;

import org.testng.annotations.Test;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import BaseUtilities.AlertBox;
import BaseUtilities.BrowserStack;
import BaseUtilities.Chrome;
import BaseUtilities.Constants;
import BaseUtilities.CsR;
import BaseUtilities.DriverLoad;
import BaseUtilities.ExtentFactory;
import BaseUtilities.HtmlUnit;
import BaseUtilities.TakeScreenShot;
import PageFactory.BillingPage;
import PageFactory.CertificateDetailsPage;
import PageFactory.IssuedCertificatesPage;
import PageFactory.LoginPage;
import PageFactory.NavigationLinks;
import PageFactory.sslDashBoard;
import Regression_Test.Test_Data;

import org.testng.annotations.BeforeTest;
//import org.json.simple.parser.JSONParser;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
//import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import java.net.HttpURLConnection;


public class Test_Build4 extends HtmlUnit  {
	
	ExtentReports report;
	ExtentTest test;
	LoginPage 	LoginPageElements;
	BillingPage BillingPageElements;
	sslDashBoard sslDashBoardElements;
	CsR CsrElements;
	NavigationLinks NavigationElements;
	AlertBox AlertBoxElements;
	TakeScreenShot ScreenShot;
	IssuedCertificatesPage IssuedCertificatesPageElements;
	CertificateDetailsPage CertificateDetailsPageElements;
	
	@BeforeMethod (groups = {"Sanity","Smoke","BS_Smoke","BS_Sanity","BS_Sanity","BS_DailySanity","Smoke_Firefox","Smoke_Chrome","Sanity_Chrome"})
	public void Login () throws Exception {
		
		report = ExtentFactory.getInstance(); 
		LoginPageElements = new LoginPage(driver);
		BillingPageElements = new BillingPage(driver);
		sslDashBoardElements = new sslDashBoard(driver);
		CsrElements = new CsR(driver);
		NavigationElements = new NavigationLinks(driver);
		AlertBoxElements = new AlertBox(driver);
		IssuedCertificatesPageElements = new IssuedCertificatesPage(driver);
		CertificateDetailsPageElements = new CertificateDetailsPage(driver);
		ScreenShot = new TakeScreenShot();
		
		
		//LoginPageElements.ClientLogin();
		
		Thread.sleep(2000);		
	}

	
	@AfterMethod (groups = {"Sanity","Smoke","BS_Smoke","BS_Sanity","BS_DailySanity", "BS_Sanity","Smoke_Firefox","Smoke_Chrome","Sanity_Chrome"}, alwaysRun = true)
	public void Logout (ITestResult result) throws Exception {

	    //Take Screen Shots
	/*			
	  	String path =  ScreenShot.Image(driver, "TestSecreenShot-" + result.getMethod().getMethodName());
		String imagePath = test.addScreenCapture(path);
		test.log(LogStatus.INFO, "Test Complete", imagePath);
	*/	
		driver.navigate().refresh();
		
		Thread.sleep(1000);
	/*	
		String path2 = ScreenShot.Image(driver, "Logout");
		String imagePath2 = test.addScreenCapture(path2);
		test.log(LogStatus.INFO, imagePath2);
		report.endTest(test);
		report.flush();
	*/	
		
	/*	
		try{
			
			LoginPageElements.ClickLogoutButton();
			driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
			test.log(LogStatus.INFO, "User Logged Out");
			String path2 = ScreenShot.Image(driver, "Logout");
			String imagePath2 = test.addScreenCapture(path2);
			test.log(LogStatus.INFO, imagePath2);
			report.endTest(test);
			report.flush();
		
		}catch (Exception e) {
			
			test.log(LogStatus.FAIL, "Logout Failed");
			String path2 = ScreenShot.Image(driver, "Logout");
			String imagePath2 = test.addScreenCapture(path2);
			test.log(LogStatus.INFO, imagePath2);
			report.endTest(test);
			report.flush();
			//Assert.fail("Exception " + e);
		}
		*/
		//return destination;
		
	}
	

	
	@Test (priority = 0, groups = {"Smoke","BS_Smoke","BS_Sanity","Smoke_Firefox","Smoke_Chrome"})
	  public void Get_Attribute () throws Exception{
		 
		  //report = ExtentFactory.getInstance3();
		
		 // test = report.startTest("<---------------------------Test Suite Start----------------------------------->");
		 // test = report.startTest("Url Test --> Validate Links- ");
		  
		  driver.get("https://ssl247:wpmsBv9P@automation-live.ssl247.co.uk"); 
		  driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
		  driver.manage().window().maximize();
		 
		  Thread.sleep(1000);
		  //test.log(LogStatus.INFO, "Browser Opened and Url Entered");
		  //test.log(LogStatus.INFO, "Login Page Loaded");
		  
		  List<WebElement> inputs = driver.findElements(By.tagName("img"));
		  System.out.println("Total images are " + inputs.size());
		  

		  
		  for (Iterator<WebElement> iterator = inputs.iterator(); iterator.hasNext();) {
		      WebElement webElement = (WebElement) iterator.next();
		      //String ImageUrl=webElement.getAttribute("src");
		      //String ImageName=webElement.getLocation();
		      URLConnection urlConnection = new URL(webElement.getAttribute("src")).openConnection();
		      int size = urlConnection.getContentLength();
		      System.out.println( webElement);
		      //System.out.println("Image Text is: " + ImageName);
		      //System.out.println("Image SrC is: " + ImageUrl);
		      System.out.println("Image Size is: " + size+"Bytes");
		  }
		  
	
		  
	  }
	
}