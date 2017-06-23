package Sanity_Test;

import org.testng.annotations.Test;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import BaseUtilities.AlertBox;
import BaseUtilities.BrowserStack;
import BaseUtilities.DriverLoad;
import BaseUtilities.ExtentFactory;
import PageFactory.AdminCertificatesPage;
import PageFactory.AdminNavigationLinks;
import PageFactory.BillingPage;
import PageFactory.ClientAccountsPage;
import PageFactory.LoginPage;
import PageFactory.NavigationLinks;
import PageFactory.ProposalsPage;
import PageFactory.sslDashBoard;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.Reporter;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;

public class Admin_User2 extends DriverLoad {
  //WebDriver driver;
	
	
  ExtentReports report;
  ExtentTest test;
  LoginPage 	LoginPageElements;
  AdminNavigationLinks AdminNavigationLinksElements;
  AdminCertificatesPage AdminCertificatesPageElements;
  NavigationLinks NavigationLinksElements;
  BillingPage BillingPageElements;
  sslDashBoard sslDashBoardElements;
  AlertBox AlertBoxElements;
  ProposalsPage ProposalsPageElements;
  ClientAccountsPage ClientAccountsPageElements;
  
	
  @BeforeMethod (groups = {"Sanity","Smoke"})
  public void Login() throws Exception {

  
	  LoginPageElements = new LoginPage(driver);
	  BillingPageElements = new BillingPage(driver);
	  sslDashBoardElements = new sslDashBoard(driver);
	  AlertBoxElements = new AlertBox(driver);
	  ProposalsPageElements = new ProposalsPage(driver);
	  NavigationLinksElements = new NavigationLinks(driver);
	  AdminNavigationLinksElements = new AdminNavigationLinks(driver);
	  ClientAccountsPageElements = new ClientAccountsPage(driver);
	  AdminCertificatesPageElements = new AdminCertificatesPage(driver);
  
	  LoginPageElements.AdminLogin();

/*	  
	  Properties prop = new Properties();
	  FileInputStream fis = new FileInputStream("C://Users//Gideon Okunleye//workspace//AutomationTestScripts//DataDrivingAdmin.properties");
				 
		prop.load(fis);

		driver.get(prop.getProperty("Url")); 
		driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		//String title = driver.getTitle();				 
		//Assert.assertTrue(title.contains("SSL Certificates: Buy Symantec, Thawte, Apache SSL Cert, GlobalSign, GeoTrust, RapidSSL- SSL247.co.uk")); 
		//Thread.sleep(5000);
		
		LoginPageElements.ClickLoginLink();
		driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
		LoginPageElements.EnterUserName(prop.getProperty("Username"));
		LoginPageElements.EnterPassword(prop.getProperty("Password"));
		driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
		LoginPageElements.ClickLoginButton();
	*/  
	  report = ExtentFactory.getInstance(); 	 
		 
  }
  
  @AfterMethod (alwaysRun = true, groups = {"Sanity","Smoke"})
  public String Log_Out (ITestResult result) throws Exception {
	  
	  //Take Screen Shots
	  String filename = result.getMethod().getMethodName() +".png";
	  String Directory = "C:\\Users\\Gideon Okunleye\\Documents\\Testing Documents\\ScreenShots\\Sanity ScreenShots\\";
	  
	  File sourceFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
	  FileUtils.copyFile(sourceFile, new File(Directory + filename));
	  
	  String destination = Directory + filename;
	  String path = destination;
	  String imagePath = test.addScreenCapture(path);
	  test.log(LogStatus.INFO, "Test Complete", imagePath);
	  
	  
	  /*User Log Out*/
	  driver.navigate().refresh();
	  Thread.sleep(5000);
	  
	  LoginPageElements.ClickAdminLogoutButton();
	  test.log(LogStatus.INFO, "Admin User Logged Out");
	  
	  report.endTest(test);
	  report.flush();
	  return destination;
  }
  
  @Test (priority = 0, groups = {"Smoke"})
  public void Admin_LogIn() throws Exception{

	  report = ExtentFactory.getInstance3();
	 // LoginPageElements.AdminLogin();
		
	  test = report.startTest("New User Test --> Admin Login/LogOut");
	  test.log(LogStatus.INFO, "Browser Opened and Url Entered");
	  
	  Thread.sleep(5000);
	  
	 // String StatusMsg = "MySSL® » Dashboard";	
	  if (LoginPageElements.AdminPageValidation()) {
			
			test.log(LogStatus.PASS, "Admin Successfully Signed");
			
		}else {
			
			test.log(LogStatus.FAIL, "Admin not Successfully Signed");
		}
	  
	  //LoginPageElements.ClickAdminLogoutButton();
	  
  }

 /*
  @BeforeTest (groups = {"Sanity"})
  public void beforeTest() {
	  
	     System.setProperty("webdriver.chrome.driver", "C:\\chromedriver.exe");
		 driver = new ChromeDriver();  
		
		 

		//report = new ExtentReports("C:\\Users\\Gideon Okunleye\\workspace\\SSL247_Test\\test-output\\Extent Report\\Admin_User.html"); 
		 //test = report.startTest("Verify Test");
		 //test.log(LogStatus.INFO, "Browser Started...");
		 //test = report.startTest("Admin Module");
		 System.out.println("Admin Module Test is Running.....");
  }

  @AfterTest (groups = {"Sanity"})
  public void afterTest() throws Exception {
	  
	  Thread.sleep(1000);
	  //report.endTest(test);
	  
	  driver.quit();
	  System.out.println("Admin Module Test is Complete!");
		
  }
 */
}
