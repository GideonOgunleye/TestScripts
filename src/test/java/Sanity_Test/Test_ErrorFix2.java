package Sanity_Test;

import org.testng.annotations.Test;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import BaseUtilities.AlertBox;
import BaseUtilities.BrowserStack;
import BaseUtilities.Chrome;
import BaseUtilities.CsR;
import BaseUtilities.DriverLoad;
import BaseUtilities.ExtentFactory;
import BaseUtilities.TakeScreenShot;
import PageFactory.BillingPage;
import PageFactory.LoginPage;
import PageFactory.sslDashBoard;
import Regression_Test.Test_Data;
import Sanity_Test.Test_DataSanity;

import org.testng.annotations.BeforeTest;
//import org.json.simple.parser.JSONParser;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

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
//import org.testng.annotations.BeforeMethod;

public class Test_ErrorFix2 extends Chrome {
	//WebDriver driver;
	ExtentReports report;
	ExtentTest test;
	LoginPage 	LoginPageElements;
	BillingPage BillingPageElements;
	sslDashBoard sslDashBoardElements;
	AlertBox AlertBoxElements;
	TakeScreenShot ScreenShot;
	CsR CsrElements;

	
	@BeforeMethod (groups = {"Regression","BS_Regression","Regression_Chrome"})
	public void User_Login () throws Exception {
		 
		LoginPageElements = new LoginPage(driver);
		BillingPageElements = new BillingPage(driver);
		sslDashBoardElements = new sslDashBoard(driver);
		AlertBoxElements = new AlertBox(driver);
		ScreenShot = new TakeScreenShot();
		CsrElements = new CsR(driver);

		
		LoginPageElements.ClientLogin();
		
		Thread.sleep(5000);
		
	}

	
	@AfterMethod (groups = {"Regression","BS_Regression","Regression_Chrome"}, alwaysRun = true)
	public void User_Logout (ITestResult result) throws Exception {
		  
	    //Take Screen Shots		
	  	String path =  ScreenShot.Image(driver, "TestSecreenShot-" + result.getMethod().getMethodName());
	  	String imagePath = test.addScreenCapture(path);
	  	test.log(LogStatus.INFO, "Test Complete", imagePath);	
	  	
	  	
		driver.navigate().refresh();
		
		Thread.sleep(1000);
		
		test.log(LogStatus.INFO, "Test Ended");
		
	  	try{ 
	  		
	  	//Try Client Logout	 
	  		
	  		   JavascriptExecutor jse = (JavascriptExecutor)driver;
	  		   jse.executeScript("window.scrollBy(0,-500)", "");
	  		   
	  		   Thread.sleep(1000);
	  		   
	  		   if(LoginPageElements.LogoutButtonIsVisible()) {
	  			   
	  			 LoginPageElements.ClickLogoutButton();
		  		 test.log(LogStatus.INFO, "After Method-Client User Logged Out");
		  		 String path2 = ScreenShot.Image(driver, "Logout");
		  		 String imagePath2 = test.addScreenCapture(path2);
		  		 test.log(LogStatus.INFO, imagePath2);
		  		 report.endTest(test);
		  		 report.flush();
	  			   
	  		   }else if(LoginPageElements.AdminLogoutButtonIsVisible()){
	  			   
	  			   	LoginPageElements.ClickAdminLogoutButton();
		  			test.log(LogStatus.INFO, "After Method-Admin User Logged Out");
		  			String path2 = ScreenShot.Image(driver, "Logout");
		  			String imagePath2 = test.addScreenCapture(path2);
		  			test.log(LogStatus.INFO, imagePath2);
		  			report.endTest(test);
		  			report.flush();
		  			
	  		   }else {
	  			   
	  			   	test.log(LogStatus.FAIL, "Logout Button Not Visible");
		  			String path2 = ScreenShot.Image(driver, "Logout");
		  			String imagePath2 = test.addScreenCapture(path2);
		  			test.log(LogStatus.INFO, imagePath2);
		  			report.endTest(test);
		  			report.flush();
	    
	  		   }
	  			 
	  			
	  	
	  	}catch (Exception e) {
	  				
	  			test.log(LogStatus.FAIL, "After Method-Logout Failed");
	  			String path2 = ScreenShot.Image(driver, "Logout");
	  			String imagePath2 = test.addScreenCapture(path2);
	  			test.log(LogStatus.INFO, imagePath2);
	  			report.endTest(test);
	  			report.flush();
	  			Assert.fail("Log Out Failed- "+"Exception: " + e);
	  			driver.quit();
	  				
	  	} 
	}
	
	
	@Test (priority = 0, groups = {"Smoke","BS_Smoke","BS_Sanity","Smoke_Firefox","Smoke_Chrome"},dataProviderClass =Test_DataSanity.class, dataProvider="LoginUser")
	  public void LogIn_Validation (String Username, String Password, String Credentials) throws Exception{
		 
		  report = ExtentFactory.getInstance3();
		
		 // test = report.startTest("<---------------------------Test Suite Start----------------------------------->");
		  test = report.startTest("Registered User Test --> User Login- " + Credentials);
		  
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
		  
		  LoginPageElements.LoadLoginPage();
		  Thread.sleep(1000);
		  test.log(LogStatus.INFO, "Browser Opened and Url Entered");
		  test.log(LogStatus.INFO, "Login Page Loaded");
		  
		  LoginPageElements.ClickLoginLink();
		  driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
		  test.log(LogStatus.INFO, "Clicked Login Link");
		  
		  LoginPageElements.EnterUserName(Username);
		  driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
		  test.log(LogStatus.INFO, "Entereed UserName");
		  
		  LoginPageElements.EnterPassword(Password);
		  driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
		  test.log(LogStatus.INFO, "Entered Password");
		  
		  
		  LoginPageElements.ClickLoginButton();
		  driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
		  test.log(LogStatus.INFO, "Clicked Login Link");
		  
		  
		  
		  try {
				
				 
			 if(driver.getTitle().contains("MySSL® » Dashboard ")){
				 
				 System.out.println("Admin User Logged In");
			 	 test.log(LogStatus.PASS, "Admin User Logged In");
			 
			 }else {
				 
				 System.out.println("Dashboard Page NOT Opened");
				 System.out.println("Title Page Displayed Is:- "+ driver.getTitle());
			 	 test.log(LogStatus.FAIL, "Dashboard Page NOT Opened");
			 	 
			 }
			  
			}catch(Exception e) {
				System.out.println("Exception:- "+ e);
				test.log(LogStatus.FAIL, "Validation Failed");
				//Assert.fail("Exception " + e);
			
			}	
			
		  
	  }
		
	
}
