package Sanity_Test;

import static org.testng.Assert.assertEquals;

import java.io.FileInputStream;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
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
import BaseUtilities.ExcelUtility;
import BaseUtilities.ExtentFactory;
import BaseUtilities.TakeScreenShot;
import PageFactory.AddAccountPage;
import PageFactory.AdminCertificateDetailsPage;
import PageFactory.AdminCertificatesPage;
import PageFactory.AdminIssuedCertificatesPage;
import PageFactory.AdminNavigationLinks;
import PageFactory.AdminOrdersPage;
import PageFactory.AdminSslDashBoard;
import PageFactory.BillingPage;
import PageFactory.CertificateDetailsPage;
import PageFactory.CertificateValidationPage;
import PageFactory.ClientAccountsPage;
import PageFactory.IncompleteCertificatesPage;
import PageFactory.IncompleteSmimePage;
import PageFactory.IssuedCertificatesPage;
import PageFactory.LoginPage;
import PageFactory.NavigationLinks;
import PageFactory.ProposalsPage;
import PageFactory.SmimeValidationPage;
import PageFactory.sslDashBoard;
import Regression_Test.Test_Data;

public class Test_Build3 extends Chrome {
	
	  ExtentReports report;
	  ExtentTest test;
	  LoginPage 	LoginPageElements;
	  AdminNavigationLinks AdminNavigationLinksElements;
	  AdminCertificatesPage AdminCertificatesPageElements;
	  NavigationLinks NavigationLinksElements;
	  BillingPage BillingPageElements;
	  sslDashBoard sslDashBoardElements;
	  AdminSslDashBoard AdminSslDashBoardElements;
	  AlertBox AlertBoxElements;
	  ProposalsPage ProposalsPageElements;
	  ClientAccountsPage ClientAccountsPageElements;
	  AdminIssuedCertificatesPage AdminIssuedCertificatesPage;
	  AdminCertificateDetailsPage AdminCertificateDetailsPage;
	  AddAccountPage AddAccountPageElements;
	  TakeScreenShot ScreenShot;
	  static ExcelUtility ExcelUtility;
	
	 @BeforeMethod (groups = {"Sanity","Smoke","BS_Smoke","Smoke_Firefox","Smoke_Chrome","BS_Sanity","Sanity_Chrome"})
	  public void Login() throws Exception {

		  LoginPageElements = new LoginPage(driver);
		  BillingPageElements = new BillingPage(driver);
		  sslDashBoardElements = new sslDashBoard(driver);
		  AdminSslDashBoardElements = new AdminSslDashBoard(driver);
		  AlertBoxElements = new AlertBox(driver);
		  ProposalsPageElements = new ProposalsPage(driver);
		  NavigationLinksElements = new NavigationLinks(driver);
		  AdminNavigationLinksElements = new AdminNavigationLinks(driver);
		  ClientAccountsPageElements = new ClientAccountsPage(driver);
		  AdminCertificatesPageElements = new AdminCertificatesPage(driver);
		  AdminIssuedCertificatesPage = new AdminIssuedCertificatesPage(driver);
		  AdminCertificateDetailsPage = new AdminCertificateDetailsPage(driver);
		  AddAccountPageElements = new AddAccountPage(driver);
		  ScreenShot = new TakeScreenShot();
		  ExcelUtility = new ExcelUtility();
	  
		  //LoginPageElements.AdminLogin();
		  
		  report = ExtentFactory.getInstance(); 

			 
	  }

@AfterMethod (alwaysRun = true, groups = {"Sanity","Smoke","BS_Smoke","Smoke_Firefox","Smoke_Chrome","BS_Sanity","Sanity_Chrome"})
public void Log_Out (ITestResult result) throws Exception {
	    
	  
	  String path =  ScreenShot.Image(driver, "TestSecreenShot-" + result.getMethod().getMethodName());
	  String imagePath = test.addScreenCapture(path);
	  test.log(LogStatus.INFO, "Test Complete", imagePath);
	  
	  
	  /*User Log Out*/
	  driver.navigate().refresh();
	  
	  JavascriptExecutor jse = (JavascriptExecutor)driver;
	  jse.executeScript("window.scrollBy(0,-500)", "");
	  
	  Thread.sleep(1000);
	  
	  String path2 = ScreenShot.Image(driver, "Logout");
	  String imagePath2 = test.addScreenCapture(path2);
	  test.log(LogStatus.INFO, imagePath2);
	  report.endTest(test);
	  report.flush();
	  

}
/*
@DataProvider(name = "loginData")
public static Object[][] dataProvider(){
	
	//Object[][] testData = ExcelUtility.getTestData("Invalid_Login");
	
	//Object[][] testData = ExcelUtility.getTestData("Invalid_Login");
	
	Object[][] testData = ExcelUtility.getTestData("Invalid_Login");
	
	for(Object o:testData){
		
		System.out.println(o.toString());
	}
	
	return testData;
}*/

@Test (priority = 2,groups = {"Smoke","BS_Smoke","BS_Sanity","Smoke_Firefox","Smoke_Chrome"},dataProviderClass =Test_DataSanity.class,dataProvider="loginData")
public void Create_Proposal (String Username, String Password) throws Exception {
	  
	//Navigate to User Account, Search for User and Click View
	  
	  		report = ExtentFactory.getInstance3();
	  		test = report.startTest("Admin Test -->  Create a Proposal");
	  		
			ExcelUtility.setExcelFile(Constants.ExcelFile_Path + Constants.ExcelFile_Name, "LoginTests");
	  		
	  		
	  		
	  	  //Properties prop = new Properties();
		  //FileInputStream fis = new FileInputStream("C://Users//Gideon Okunleye//workspace//AutomationTestScripts//DataDriving.properties");
					 
		  //prop.load(fis);

		  Thread.sleep(1000);	  		
	  		
	  		
			  //Admin Login User
			  try {
				  
				  //driver.get(prop.getProperty(Domain)); 
				  driver.get(Constants.URL);
				  driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
				  driver.manage().window().maximize();
				  //LoginPageElements.LoadLoginPage();
				  Thread.sleep(1000);
				  test.log(LogStatus.INFO, "Browser Opened and Url Entered");
				  test.log(LogStatus.INFO, "Login Page Loaded");
				  
				  LoginPageElements.ClickLoginLink();
				  driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
				  test.log(LogStatus.INFO, "Clicked Login Link");
				  
				 //LoginPageElements.EnterUserName(prop.getProperty(Username));
				  LoginPageElements.EnterUserName(Username);
				  driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
				  test.log(LogStatus.INFO, "Entereed UserName");
				  
				  //LoginPageElements.EnterPassword(prop.getProperty(Password));
				  LoginPageElements.EnterPassword(Password);
				  driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
				  test.log(LogStatus.INFO, "Entered Password");
				  
				  LoginPageElements.ClickLoginButton();
				  driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
				  test.log(LogStatus.INFO, "Clicked Login Link");
				  
				  Thread.sleep(1000);
			  
			  }catch (Exception e) {
					
					test.log(LogStatus.FAIL, "Element Not Found");
					System.out.println("Element Not Found");
					String path2 = ScreenShot.Image(driver, "Element");
					String imagePath2 = test.addScreenCapture(path2);
					test.log(LogStatus.INFO, imagePath2);
					report.endTest(test);
					report.flush();
					Assert.fail("Exception " + e);
				}	  		
	  		
	  		
	  		
	  		
	  		test.log(LogStatus.INFO, "Admin User Logged in");
	 	
			AdminNavigationLinksElements.ClientsAccountsLinkClick();
			test.log(LogStatus.INFO, "Click on clients Accounts Link");
			 
			//ClientAccountsPageElements.ValidatePage();
			//ClientAccountsPageElements.SearchQueryFieldFill("UK Test");
			//test.log(LogStatus.INFO, "Click on Search Query and Enter UK Test");
			 
			ClientAccountsPageElements.UpdateButtonClink();
			test.log(LogStatus.INFO, "Click on Update Button");
			 
			Thread.sleep(5000);
			
			ClientAccountsPageElements.ValidateResults("UKTE001");
			driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
			test.log(LogStatus.INFO, "Search Resusult is Displayed");
			
			JavascriptExecutor jse = (JavascriptExecutor)driver;
		    jse.executeScript("window.scrollBy(0,500)", "");
		    
		    Thread.sleep(1000);
			
			ClientAccountsPageElements.ViewAccount();	
			driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
		    test.log(LogStatus.INFO, "Click on UK Test Account in search Result");
		    
		    Thread.sleep(1000);
		    //sslDashBoardElements.AdminDashboardValidation();
		  	test.log(LogStatus.INFO, "DashBord Page Opened");
			
			//Navigate to Proposals Section 
		  	AdminSslDashBoardElements.ProposalsLinkClick();
			Thread.sleep(10000);
			test.log(LogStatus.INFO, "Proposal Link Clicked");
		
		try {	
			//Click on New Proposal
			//ProposalsPageElements.ValidatePage();
			ProposalsPageElements.NewProposalButtonClink();
			Thread.sleep(10000);
			test.log(LogStatus.INFO, "New Proposal Buttton Clicked");
			
			//Fill in required information
			ProposalsPageElements.ProductTypeFieldSelect("SSL Certificate");
			driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
			test.log(LogStatus.INFO, "Select Product Type");
			
			driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
		
			ProposalsPageElements.ProductFieldSelect("RapidSSL Pro");
			driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
			test.log(LogStatus.INFO, "Select Product Name");
			Thread.sleep(10000);
				
			ProposalsPageElements.QuantityFieldClear();
			driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
			test.log(LogStatus.INFO, "Cleared Quantity Field");
			
			ProposalsPageElements.QuantityFieldSenkeys("3");
			driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
			test.log(LogStatus.INFO, "Enter Quantity in Field ");
			
			ProposalsPageElements.DurationFieldSelect("3 years");
			driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
			test.log(LogStatus.INFO, "Select Number of Years");
			Thread.sleep(10000);		
			
			ProposalsPageElements.CommonNameFieldClear();
			driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
			test.log(LogStatus.INFO, "Cleared Common Name Field");
			
			ProposalsPageElements.CommonNameFieldSendKeys("ssl247-testing.co.uk");
			driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
			test.log(LogStatus.INFO, "Fill in Common Name");
			
			driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
			
			ProposalsPageElements.CalculatePricesButtonClink();
			driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
			test.log(LogStatus.INFO, "Click on Calculate Prices Button");
			Thread.sleep(10000);
			
			//Click Save
			ProposalsPageElements.SaveProposalButtonClink();
			driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
			test.log(LogStatus.INFO, "Click on Save Proposal Button");
			
		}catch (Exception e) {
				
				test.log(LogStatus.FAIL, "Validation Failed");
				Assert.fail("Exception " + e);
		
		}
	
			
			//Validate Test
			try {
				String Alertnote = "Proposal saved";  
				AlertBoxElements.AlertWait();
						    	
			  if (AlertBoxElements.VerifyAlert(Alertnote)) {
									
				test.log(LogStatus.PASS, "Validation Complete");
				Assert.assertTrue(AlertBoxElements.VerifyAlert(Alertnote));
				System.out.println("Validation Complete!");
			  }else{
						    	
			test.log(LogStatus.FAIL, "Validation Failed");
				AlertBoxElements.AlertPrint();
				Assert.fail("Validation Failed ");
						    	
				}
				
			}catch (Exception e) {
									
				String path = ScreenShot.Image(driver, "SearchResult");
				String imagePath = test.addScreenCapture(path);
				test.log(LogStatus.INFO, imagePath);
				test.log(LogStatus.FAIL, "Alert not Displayed");

			}

} 

}
