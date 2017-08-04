package Sanity_Test;

import static org.testng.Assert.assertEquals;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
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
import PageFactory.AdminCertificatesPage;
import PageFactory.AdminNavigationLinks;
import PageFactory.AdminSslDashBoard;
import PageFactory.BillingPage;
import PageFactory.CertificateDetailsPage;
import PageFactory.ClientAccountsPage;
import PageFactory.IssuedCertificatesPage;
import PageFactory.LoginPage;
import PageFactory.NavigationLinks;
import PageFactory.ProposalsPage;
import PageFactory.sslDashBoard;
import Regression_Test.Test_Data;

public class Test_Build extends Chrome {
	
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
		
		Thread.sleep(5000);		
	}

	
	@AfterMethod (groups = {"Sanity","Smoke","BS_Smoke","BS_Sanity","BS_DailySanity", "BS_Sanity","Smoke_Firefox","Smoke_Chrome","Sanity_Chrome"}, alwaysRun = true)
	public void Logout (ITestResult result) throws Exception {

	    //Take Screen Shots
				
	  	String path =  ScreenShot.Image(driver, "TestSecreenShot-" + result.getMethod().getMethodName());
		String imagePath = test.addScreenCapture(path);
		test.log(LogStatus.INFO, "Test Complete", imagePath);
		
		driver.navigate().refresh();
		
		Thread.sleep(5000);
		
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
		
		//return destination;
		
	}
	
	@Test (priority = 0, groups = {"Smoke","BS_Smoke","BS_Sanity","Smoke_Firefox","Smoke_Chrome"},dataProviderClass =Test_DataSanity.class, dataProvider="LoginUser")
	  public void LogIn_Validation (String Username, String Password, String Credentials) throws Exception{
		 
		  report = ExtentFactory.getInstance3();
			
		  test = report.startTest("Registered User Test --> User Login- " + Credentials);
		  test.log(LogStatus.INFO, "Browser Opened and Url Entered");
		  
		  
		  LoginPageElements.LoadLoginPage();
		  
		  Thread.sleep(1000);
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
		  
		  //driver.findElement(By.xpath(".//*[@id='top-panel']/div[1]/span[1]/a[2]")).click();
		  
		  //Thread.sleep(1000);
		  
		  try {
				
				/*if (sslDashBoardElements.PageIsVisible()) {
					
					System.out.println("Dashboard Page Opened");
				
					sslDashBoardElements.ClientDashboardValidation();
					driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
					test.log(LogStatus.PASS, "User Successfully Logged In");
					
				}*/
			  
			  /*String actualTitle = driver.getTitle();
			  String expectedTitle = "MySSL® » Dashboard ";
			  assertEquals(expectedTitle,actualTitle);*/
			 
			 if(driver.getTitle().contains("MySSL® » Dashboard ")){
				 
				 System.out.println("Dashboard Page Opened");
			 	 test.log(LogStatus.PASS, "Dashboard Page Opened");
			 
			 }else {
				 
				 System.out.println("Dashboard Page NOT Opened");
			 	 test.log(LogStatus.FAIL, "Dashboard Page NOT Opened");
			 	 
			 }
			  
			}catch(Exception e) {
				System.out.println("Exception:- "+ e);
				test.log(LogStatus.FAIL, "Validation Failed");
				//Assert.fail("Exception " + e);
			
				}	
			
		  
	  }
  
}
