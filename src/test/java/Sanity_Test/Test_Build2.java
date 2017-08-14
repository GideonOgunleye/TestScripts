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

public class Test_Build2 extends Chrome {
	
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
	  
	  /*
		 try{ 
			 
			 
			 if (LoginPageElements.LoginLinkContains("Login")){

				 test.log(LogStatus.INFO, "Logout Button Not Visible");
				 System.out.println("Logout Button Not Visible");
				 String path2 = ScreenShot.Image(driver, "Logout");
				 String imagePath2 = test.addScreenCapture(path2);
				 test.log(LogStatus.INFO, imagePath2);
				 report.endTest(test);
				 report.flush();
				 
			 }else {
				 
				 System.out.println("Domain Is" + driver.getCurrentUrl());
				 LoginPageElements.LoginLinkTestPrint();
				 String path2 = ScreenShot.Image(driver, "Logout");
				 String imagePath2 = test.addScreenCapture(path2);
				 test.log(LogStatus.INFO, imagePath2);
				 report.endTest(test);
				 report.flush();
			 }
			 */	
		/*	 
			 try {
				 
				  LoginPageElements.ClickAdminLogoutButton();
				  test.log(LogStatus.INFO, "Admin User Logged Out");
				  String path2 = ScreenShot.Image(driver, "Logout");
				  String imagePath2 = test.addScreenCapture(path2);
				  test.log(LogStatus.INFO, imagePath2);
				  report.endTest(test);
				  report.flush();
				 
			 }catch (Exception c) {
				 
				test.log(LogStatus.FAIL, "Logout Button Not Displayed");
				String path2 = ScreenShot.Image(driver, "Logout");
				String imagePath2 = test.addScreenCapture(path2);
				test.log(LogStatus.INFO, imagePath2);
				report.endTest(test);
				report.flush();
				 
			 }
		 
		  
		 }catch (Exception e) {
				
				test.log(LogStatus.FAIL, "Logout Validation Failed");
				String path2 = ScreenShot.Image(driver, "Logout");
				String imagePath2 = test.addScreenCapture(path2);
				test.log(LogStatus.INFO, imagePath2);
				report.endTest(test);
				report.flush();
				System.out.println("Exception " + e);
				driver.quit();
				//Assert.fail("Exception " + e);
		}
		*/	
}

@Test (priority = 0, groups = {"Smoke","BS_Smoke","BS_Sanity","Smoke_Firefox","Smoke_Chrome"},dataProviderClass =Test_DataSanity.class, dataProvider="AdminLoginAllSites")
public void Admin_LogInValidation(String Websitename, String Domain, String Username, String Password,String Credentials) throws Exception{

	  report = ExtentFactory.getInstance3();
	 // LoginPageElements.AdminLogin();
	  
	  test = report.startTest("Registered User Test --> Admin Login- "+ Websitename + " - " + Credentials);
	  
	  Properties prop = new Properties();
	  FileInputStream fis = new FileInputStream("C://Users//Gideon Okunleye//workspace//AutomationTestScripts//DataDriving.properties");
				 
	  prop.load(fis);

	  Thread.sleep(1000);

	  try {
		  
		  driver.get(prop.getProperty(Domain)); 
		  driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
		  driver.manage().window().maximize();
		  //LoginPageElements.LoadLoginPage();
		  Thread.sleep(1000);
		  test.log(LogStatus.INFO, "Browser Opened and Url Entered");
		  test.log(LogStatus.INFO, "Login Page Loaded");
		  
		  LoginPageElements.ClickLoginLink();
		  driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
		  test.log(LogStatus.INFO, "Clicked Login Link");
		  
		  LoginPageElements.EnterUserName(prop.getProperty(Username));
		  driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
		  test.log(LogStatus.INFO, "Entereed UserName");
		  
		  LoginPageElements.EnterPassword(prop.getProperty(Password));
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
	  
	  try {
			
			 
		 if(driver.getTitle().contains("Slicket Backlog")){
			 
			 System.out.println("Admin User Logged In");
		 	 test.log(LogStatus.PASS, "Admin User Logged In");
		 	 
			 LoginPageElements.ClickAdminLogoutButton();
			 test.log(LogStatus.INFO, "Admin User Logged Out");
			 String path2 = ScreenShot.Image(driver, "Logout");
			 String imagePath2 = test.addScreenCapture(path2);
			 test.log(LogStatus.INFO, imagePath2);
			 report.endTest(test);
			 report.flush();
		 	 
		 
		 }else {
			 
			 System.out.println("Admin User Not Logged In");
		 	 test.log(LogStatus.FAIL, "Admin User Not Logged In");
		 	 //String path2 = ScreenShot.Image(driver, "Element");
		 	 //String imagePath2 = test.addScreenCapture(path2);
		 	 //test.log(LogStatus.INFO, imagePath2);
		 	// driver.close();
		 	 
		 }
		  
	  }catch(Exception e) {
			System.out.println("Exception:- "+ e);
			test.log(LogStatus.FAIL, "Validation Failed");
			String path2 = ScreenShot.Image(driver, "Logout");
			String imagePath2 = test.addScreenCapture(path2);
			test.log(LogStatus.INFO, imagePath2);
			report.endTest(test);
			report.flush();
			Assert.fail("Exception " + e);
		
	  }
	  
}


@Test (priority = 1, groups = {"Sanity","BS_Sanity","Sanity_Chrome"},dataProviderClass =Test_DataSanity.class, dataProvider="EditUserAllSites")
public void Edit_Account_User(String Websitename, String Domain, String Username, String Password,String Credentials) throws Exception{
	  
		//Search For UK Test User
		  test = report.startTest("Admin User Test --> Edit User Account- "+ Websitename);
		  
		  Properties prop = new Properties();
		  FileInputStream fis = new FileInputStream("C://Users//Gideon Okunleye//workspace//AutomationTestScripts//DataDriving.properties");
					 
		  prop.load(fis);

		  Thread.sleep(1000);
		  
		  //Admin Login User
		  try {
			  
			  driver.get(prop.getProperty(Domain)); 
			  driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
			  driver.manage().window().maximize();
			  //LoginPageElements.LoadLoginPage();
			  Thread.sleep(1000);
			  test.log(LogStatus.INFO, "Browser Opened and Url Entered");
			  test.log(LogStatus.INFO, "Login Page Loaded");
			  
			  LoginPageElements.ClickLoginLink();
			  driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
			  test.log(LogStatus.INFO, "Clicked Login Link");
			  
			  LoginPageElements.EnterUserName(prop.getProperty(Username));
			  driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
			  test.log(LogStatus.INFO, "Entereed UserName");
			  
			  LoginPageElements.EnterPassword(prop.getProperty(Password));
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
	     driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
		 test.log(LogStatus.INFO, "Click on clients Accounts Link");
		 
		 ClientAccountsPageElements.SearchQueryFieldFill("UK Test");
		 driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
		 test.log(LogStatus.INFO, "Click on Search Query and Enter UK Test");
		 
		 ClientAccountsPageElements.UpdateButtonClink();
		 driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
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
	     
	     //JavascriptExecutor jse = (JavascriptExecutor)driver;
	     jse.executeScript("window.scrollBy(0,500)", "");
	     
	     Thread.sleep(1000);
	     
	     //sslDashBoardElements.AdminDashboardValidation();
	     //driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
	  	// test.log(LogStatus.INFO, "DashBord Page Opened");
	     
		 
	     
	     //Click on My Users Link
	     AdminSslDashBoardElements.ClickAccountEndUsersLink();
	     driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
	     test.log(LogStatus.INFO, "Click on Account End Users link on the side bar Menu");
	     
	     //JavascriptExecutor jse = (JavascriptExecutor)driver;
	     jse.executeScript("window.scrollBy(0,500)", "");
	     Thread.sleep(1000);
	     test.log(LogStatus.INFO, "Scrolled Page Down");
		 
		 
	     try {		 
		 String UserVal = "Gideon Ogunleye";

		 if(AdminSslDashBoardElements.User1_LinkContains(UserVal)){
				
			 driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
			 AdminSslDashBoardElements.User1_EditButton();
			 driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
		     test.log(LogStatus.INFO, "Navigate to Quality Assurance Tester User and Click Edit");
		     
		     //Edit User
		     AdminSslDashBoardElements.AccessLevelSelect();
			 Thread.sleep(1000);
			 
			//Edit Optional Details
			 AdminSslDashBoardElements.OptionalDetailsTabClick();
			 driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
			 AdminSslDashBoardElements.StateFieldFill("London");
			 driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
			 
			 jse.executeScript("window.scrollBy(0,-500)", "");
		     Thread.sleep(1000);
		     test.log(LogStatus.INFO, "Scrolled Page up");
			 
			//Click Save User
			 AdminSslDashBoardElements.SubmitChangesButtonClick();
			 driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
			 test.log(LogStatus.INFO, "Click Submit Chnages Button");
			 driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
			 test.log(LogStatus.PASS, "Test User Account Edited and Saved");
			 
			}else if (AdminSslDashBoardElements.User2_LinkContains(UserVal)) {
				
				driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
				AdminSslDashBoardElements.User2_EditButton();
			    test.log(LogStatus.INFO, "Navigate to Quality Assurance Tester User and Click Edit");
			    
			    Thread.sleep(1000);
				 
				 //Edit User
				 AdminSslDashBoardElements.RequiredDetailsTabClick();
				 driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
				 test.log(LogStatus.INFO, "Clicked Required Details Tab");
				 
			     AdminSslDashBoardElements.AccessLevelSelect();
			     driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
				 test.log(LogStatus.INFO, "Selected Super User Option");
			     
				 Thread.sleep(1000);
				 
				 //Edit Optional Details
				 AdminSslDashBoardElements.OptionalDetailsTabClick();
				 driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
				 AdminSslDashBoardElements.StateFieldFill("London");
				 driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
				 
				 jse.executeScript("window.scrollBy(0,-500)", "");
			     Thread.sleep(1000);
			     test.log(LogStatus.INFO, "Scrolled Page up");
				 
				//Click Save User
				 AdminSslDashBoardElements.SubmitChangesButtonClick();
				 driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
				 test.log(LogStatus.INFO, "Click Submit Chnages Button");
				 driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
				 test.log(LogStatus.PASS, "Test User Account Edited and Saved");
				 
			 }else if (AdminSslDashBoardElements.User3_LinkContains(UserVal)) {
		
				 driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
				 AdminSslDashBoardElements.User3_EditButton();
				 test.log(LogStatus.INFO, "Navigate to Quality Assurance Tester User and Click Edit");
				 
				 Thread.sleep(1000);
				 
				 //Edit User
				 AdminSslDashBoardElements.RequiredDetailsTabClick();
				 driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
				 test.log(LogStatus.INFO, "Clicked Required Details Tab");
				 
			     AdminSslDashBoardElements.AccessLevelSelect();
			     driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
				 test.log(LogStatus.INFO, "Selected Super User Option");
			     
				 Thread.sleep(1000);
				 
				//Edit Optional Details
				 AdminSslDashBoardElements.OptionalDetailsTabClick();
				 driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
				 AdminSslDashBoardElements.StateFieldFill("London");
				 driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
				 
				 jse.executeScript("window.scrollBy(0,-500)", "");
			     Thread.sleep(1000);
			     test.log(LogStatus.INFO, "Scrolled Page up");
				 
				//Click Save User
				 AdminSslDashBoardElements.SubmitChangesButtonClick();
				 driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
				 test.log(LogStatus.INFO, "Click Submit Chnages Button");
				 driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
				 test.log(LogStatus.PASS, "Test User Account Edited and Saved");
				 
				 
			 }else if (AdminSslDashBoardElements.User4_LinkContains(UserVal)) {
				 
				 driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
				 AdminSslDashBoardElements.User4_EditButton();
				 test.log(LogStatus.INFO, "Navigate to Quality Assurance Tester User and Click Edit");
				 
				 Thread.sleep(1000);
				 
				 //Edit User
				 AdminSslDashBoardElements.RequiredDetailsTabClick();
				 driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
				 test.log(LogStatus.INFO, "Clicked Required Details Tab");
				 
			     AdminSslDashBoardElements.AccessLevelSelect();
			     driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
				 test.log(LogStatus.INFO, "Selected Super User Option");
			     
				 Thread.sleep(1000);
				 
				//Edit Optional Details
				 AdminSslDashBoardElements.OptionalDetailsTabClick();
				 driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
				 test.log(LogStatus.INFO, "Clicked Optional Details Tab");
				 
				 AdminSslDashBoardElements.StateFieldFill("London");
				 driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
				 driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
				 test.log(LogStatus.INFO, "Filled In State");
				 
				 jse.executeScript("window.scrollBy(0,-500)", "");
			     Thread.sleep(1000);
			     test.log(LogStatus.INFO, "Scrolled Page up");
				 
				//Click Save User
				 AdminSslDashBoardElements.SubmitChangesButtonClick();
				 driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
				 test.log(LogStatus.INFO, "Click Submit Chnages Button");
				 driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
				 test.log(LogStatus.PASS, "Test User Account Edited and Saved");
				 
			 }else  {
				 
				test.log(LogStatus.FAIL, "Test User Account not Found"); 
				System.out.println("Quality Tester User Not Found");
				Assert.fail("Quality Tester User Not Found");
			 }
		 
	}catch (Exception e) {
		
		test.log(LogStatus.FAIL, "Validation Failed");
		Assert.fail("Exception " + e);

	}

		
		 /*Test Validation*/
		 
		 try {
				String Alertnote = "User details have been updated";  
				AlertBoxElements.AlertWait();
						    	
			  if (AlertBoxElements.VerifyAlert(Alertnote)) {
									
				test.log(LogStatus.PASS, "Validation Complete");
				Assert.assertTrue(AlertBoxElements.VerifyAlert(Alertnote));
				System.out.println("Validation Complete!");
				
			  }else{
						    	
				test.log(LogStatus.FAIL, "Validation Failed");
				AlertBoxElements.AlertPrint();
				String path = ScreenShot.Image(driver, "SearchResult");
				String imagePath = test.addScreenCapture(path);
				test.log(LogStatus.INFO, imagePath);
						    	
				}
				
			}catch (Exception e) {
									
				String path = ScreenShot.Image(driver, "SearchResult");
				String imagePath = test.addScreenCapture(path);
				test.log(LogStatus.INFO, "Alert Not Displayed");
				test.log(LogStatus.INFO, imagePath);


			}
		 
		 
		 //Admin Log Out
		 try {
			 
			  LoginPageElements.ClickAdminLogoutButton();
			  test.log(LogStatus.INFO, "Admin User Logged Out");
			  String path2 = ScreenShot.Image(driver, "Logout");
			  String imagePath2 = test.addScreenCapture(path2);
			  test.log(LogStatus.INFO, imagePath2);
			  report.endTest(test);
			  report.flush();
			 
		 }catch (Exception c) {
			 
			test.log(LogStatus.FAIL, "Logout Button Not Displayed");
			String path2 = ScreenShot.Image(driver, "Logout");
			String imagePath2 = test.addScreenCapture(path2);
			test.log(LogStatus.INFO, imagePath2);
			report.endTest(test);
			report.flush();
			Assert.fail("Exception " + c); 
		 }
	
		 
}

@DataProvider(name = "loginData")
public Object[][] dataProvider() {
	Object[][] testData = ExcelUtility.getTestData("Invalid_Login");
	
	return testData;
}

@Test (priority = 2,groups = {"Smoke","BS_Smoke","BS_Sanity","Smoke_Firefox","Smoke_Chrome"},dataProvider="loginData")
public void Create_Proposal (String Username, String Password) throws Exception {
	  
	//Navigate to User Account, Search for User and Click View
	  
	  		report = ExtentFactory.getInstance3();
	  		test = report.startTest("Admin Test -->  Create a Proposal");
	  		
			ExcelUtility.setExcelFile(Constants.File_Path + Constants.File_Name, "LoginTests");
	  		
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

			//test.log(LogStatus.INFO, "Click on Save Proposal Button");
			//test.log(LogStatus.PASS, "Proposal Created and Saved Successfully");
} 

@Test (priority = 3,groups = {"Sanity","BS_Sanity","Sanity_Chrome"})
public void IssueProposal () throws Exception {
	  
	  test = report.startTest("Admin Test --> Issue a Proposal");
	  test.log(LogStatus.INFO, "Admin User Logged in");
	  
	  AdminNavigationLinksElements.ClientsAccountsLinkClick();
	  driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
	  test.log(LogStatus.INFO, "Click on clients Accounts Link");
		 
	  //ClientAccountsPageElements.ValidatePage();
	  ClientAccountsPageElements.SearchQueryFieldFill("UK Test");
	  driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
	  test.log(LogStatus.INFO, "Click on Search Query and Enter UK Test");
		 
	  ClientAccountsPageElements.UpdateButtonClink();
	  driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
	  test.log(LogStatus.INFO, "Click on Update Button");
	  
	  JavascriptExecutor jse = (JavascriptExecutor)driver;
	  jse.executeScript("window.scrollBy(0,500)", "");
		 
	  Thread.sleep(1000);
	  
	  ClientAccountsPageElements.ValidateResults("UKTE001");
	  driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
	  test.log(LogStatus.INFO, "Search Resusult is Displayed");
	  
	  ClientAccountsPageElements.ViewAccount();
	  driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
	  test.log(LogStatus.INFO, "Clicked on UK Test Account in search Result");
	  Thread.sleep(1000);
	  
	try {
	 
	  		test.log(LogStatus.INFO, "DashBord Page Opened");
	  		
	  		AdminSslDashBoardElements.ProposalsLinkClick();
	  		driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
	  		test.log(LogStatus.INFO, "Clicked on Proposal Link");
	  		
		  	ProposalsPageElements.UnIssuedTabClink();
	  		driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
	  		test.log(LogStatus.INFO, "Clicked on Unissused Tab");
		  	
		  	ProposalsPageElements.ViewTopResult();
	  		driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
	  		test.log(LogStatus.INFO, "Clicked to view Top Result");		  	
		  	
		  	ProposalsPageElements.IssueProposalTabClink();
	  		driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
	  		test.log(LogStatus.INFO, "Clicked on Issue Proposal Tab");
		  	
		  	Thread.sleep(1000);
		  	
		  	ProposalsPageElements.ConfirmCheckBoxOneClink();
	  		driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
	  		test.log(LogStatus.INFO, "Clicked on Chec Box One");
		  	
		  	Thread.sleep(1000);
		  	ProposalsPageElements.ConfirmCheckBoxTwoClink();
		  	driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
	  		test.log(LogStatus.INFO, "Clicked on Chec Box two");
		  	
		  	Thread.sleep(1000);
		  	
		  	ProposalsPageElements.IssueProposalButtonClink();
		  	driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
	  		test.log(LogStatus.INFO, "Clicked on Issue Proposal Button");
	  
		}catch (Exception e) {
		
			test.log(LogStatus.FAIL, "Validation Failed");
			Assert.fail("Exception " + e);

	}
	

	  		
		//Validate Alert	
		try { 
			
			String Alertnote = "issued";  
			AlertBoxElements.AlertWait();
			
			if (AlertBoxElements.VerifyAlert(Alertnote)) {
				
				Assert.assertTrue(AlertBoxElements.VerifyAlert(Alertnote));
				test.log(LogStatus.PASS, "Validation Complete");
				driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
				System.out.println("Validation Complete!");
				
			}else {
					    	
				test.log(LogStatus.FAIL, "Validation Failed");
				AlertBoxElements.AlertPrint();
				Assert.fail("Validation Failed ");		    	
			}
			
		}catch (Exception e) {
			
			String path = ScreenShot.Image(driver, "SearchResult");
			String imagePath = test.addScreenCapture(path);
			test.log(LogStatus.FAIL, "Alert not Displayed");
			test.log(LogStatus.INFO, imagePath);

		}
	  
}


@Test (priority = 4, groups = {"Sanity", "BS_Sanity","Sanity_Chrome"})
public void Send_Fulfillment_Email() throws Exception {
		  
    test = report.startTest("Admin Test -->  Send Fullfillement Email");
    test.log(LogStatus.INFO, "Admin User Logged in");
  
    //Navigate to products link
    
    Thread.sleep(1000);

  
    try {   	
		  	WebDriverWait wait = new WebDriverWait(driver, 50);
		  	Actions  actions=new Actions(driver);
		  	
		  	WebElement ProductsLink = wait.until(ExpectedConditions.visibilityOfElementLocated (By.xpath(".//*[@id='mainNavigation']/li[3]/a")));
		  	actions.moveToElement(ProductsLink);
		  	actions.perform();
		  	
		  	WebElement CertificatesLink = wait.until(ExpectedConditions.visibilityOfElementLocated (By.xpath(".//*[@id='mainNavigation']/li[3]/ul/li[1]/a")));
		    actions.moveToElement(CertificatesLink);
		  	actions.click();
		  	actions.perform();
		  	driver.manage().timeouts().implicitlyWait(50,TimeUnit.SECONDS);
		  	test.log(LogStatus.INFO, "Opened Search Products Page");
		
		}catch (Exception e){
			
			System.out.println("Search Product Link Not Clicked");
			test.log(LogStatus.FAIL, "Search Products Page Not Opened");
			Assert.fail("Exception " + e);
		}
			  	
	  	
	  	
	  	Thread.sleep(5000);
	  	
try { 		
	  	//Select Account Name from for field
	  	AdminCertificatesPageElements.ForFieldSelect("Account name");
		driver.manage().timeouts().implicitlyWait(50,TimeUnit.SECONDS);
		test.log(LogStatus.INFO, "Selected Account Name From Field");
	  	
		//Select Issued from Status Field
		AdminCertificatesPageElements.StatusFieldSelect("Issued");
		driver.manage().timeouts().implicitlyWait(50,TimeUnit.SECONDS);
		test.log(LogStatus.INFO, "Selected Issued From Status Field");
		
	    //Enter Account Name into form field and Click Search
		AdminCertificatesPageElements.SearchFieldSendKeys("UK Test");
		driver.manage().timeouts().implicitlyWait(50,TimeUnit.SECONDS);
		test.log(LogStatus.INFO, "Entered account name in field");
		
		AdminCertificatesPageElements.SearchButtonClick();	
		driver.manage().timeouts().implicitlyWait(50,TimeUnit.SECONDS);
		test.log(LogStatus.INFO, "Clicked Search Button");
	
	}catch (Exception e){
		
		System.out.println("Search Fields Not Present");
		test.log(LogStatus.FAIL, "Search Fields Not Present");
	}
	
	
	//Wait for Result to appear 
	try {
		
		String Message = "records per page";
		
		if (AdminCertificatesPageElements.SearchResultValidate().contains(Message)) {
			
			test.log(LogStatus.INFO, "Result Is Displayed");
			
		}else {
			
			System.out.println("Search Result Not Present");
			//ScreenShot.Image(null);
			String path = ScreenShot.Image(driver, "SearchResult");
			String imagePath = test.addScreenCapture(path);
			test.log(LogStatus.FAIL, "Search Result Not Present", imagePath);
				
		}

	}catch (Exception e){
		
		System.out.println("Search Result Element Not Present");
		test.log(LogStatus.FAIL, "Result Not Displayed");
	}
	
	String AccountName = "UK TEST where can you see me";
	String Status = "Issued";
	WebElement Col1 = driver.findElement(By.xpath(".//*[@id='DataTables_Table_0']/tbody/tr[1]/td[2]"));
	WebElement Col2 = driver.findElement(By.xpath(".//*[@id='DataTables_Table_0']/tbody/tr[2]/td[2]"));
	WebElement StatusCol = driver.findElement(By.xpath(".//*[@id='DataTables_Table_0']/tbody/tr[1]/td[5]"));
	WebElement StatusCo2 = driver.findElement(By.xpath(".//*[@id='DataTables_Table_0']/tbody/tr[2]/td[5]"));
	
	if (Col1.getText().contains(AccountName)){
		
		System.out.println("Account Found in col 1");
		
		if (StatusCol.getText().equals(Status)) {
			
			System.out.println("issued Cert found in col 1");
			driver.findElement(By.xpath(".//*[@id='DataTables_Table_0']/tbody/tr[1]/td[8]/a/i")).click();
			test.log(LogStatus.INFO, "Clicked on Issued Certificate in first column of result");
			
		}else{
			
			System.out.println("No issued cert present in col 1");
			//driver.close();
		}
		
	}else if(Col2.getText().contains(AccountName)){
		
			System.out.println("Account Found in col 2");
		
		if (StatusCo2.getText().equals(Status)) {
			
			System.out.println("issued Cert found in col 2");
			driver.findElement(By.xpath(".//*[@id='DataTables_Table_0']/tbody/tr[2]/td[8]/a/i")).click();
			test.log(LogStatus.INFO, "Clicked on Issued Certificate in Second column of result");
			
		}else {
			
			System.out.println("No issued cert present in col 2");
			//driver.close();
			}
		
	}else  {
		 
		System.out.println("Quality Tester User With Issued Cert Not Found");
		test.log(LogStatus.FAIL, "Test User with Issued Cert Not Found");
		
	 }


	//Click on Send Fulfillment Email Link
	Thread.sleep(10000);
	driver.findElement(By.cssSelector("a[href*='#sendFulfillmentEmail']")).click();
	test.log(LogStatus.INFO, "Clicked on Send Fulfillment");
	
	//Fill In required information
	Thread.sleep(10000);
	driver.findElement(By.xpath(".//*[@id='CertificateNotes']")).clear();
	driver.findElement(By.xpath(".//*[@id='CertificateNotes']")).sendKeys("Test Note");
	
	
	WebElement EmailField = driver.findElement(By.xpath(".//*[@id='CertificateEmail']"));
	Select EmailAdd = new Select(EmailField);
	EmailAdd.selectByVisibleText("gogunleye@ssl247.co.uk");
	driver.manage().timeouts().implicitlyWait(50,TimeUnit.SECONDS);
	test.log(LogStatus.INFO, "Selected Test User from drop down list");
	
	driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
	driver.findElement(By.xpath(".//*[@id='CertificateOneOffEmail']")).sendKeys("qa@ssl247.co.uk");
	driver.manage().timeouts().implicitlyWait(50,TimeUnit.SECONDS);
	test.log(LogStatus.INFO, "Entered Email in email field");
	
	driver.findElement(By.xpath(".//*[@id='sendFulfillmentEmail']/form/div[4]/button")).click();
	driver.manage().timeouts().implicitlyWait(50,TimeUnit.SECONDS);
	test.log(LogStatus.INFO, "Clicked on Send Button");
	
	driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
  	String SendStatus = driver.findElement(By.xpath("html/body/div[4]/p[1]")).getText();	
  	Assert.assertTrue(SendStatus.contains("Certificate has been emailed to qa@ssl247.co.uk"));
  	test.log(LogStatus.PASS, "Message Sent");
	
	
	/*----Verify Sent Email is in Outgoing emails--------*/
	
	//Navigate to Outgoing Emails Link
	driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
  	Actions  action2=new Actions(driver);
  	WebElement CMSLink=driver.findElement(By.cssSelector("a[href*='/admin/websites/index']"));
  	action2.moveToElement(CMSLink);
  	driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
  	WebElement OutgoingEmailsLink=driver.findElement(By.cssSelector("a[href*='/admin/outgoing_emails/index']"));
    action2.moveToElement(OutgoingEmailsLink);
  	action2.click();
  	action2.perform();
  	test.log(LogStatus.INFO, "Navigated to Outgoing emails Page");
	
  	String SubjectCol = driver.findElement(By.xpath(".//*[@id='mainContainer']/div[6]/div/div/table/tbody/tr[1]/td[1]")).getText();
  	
  	Assert.assertTrue(SubjectCol.contains("Your 1 year(s) GlobalSign DomainSSL SSL certificate for *.ssl247.co.uk has been issued"));
  	test.log(LogStatus.PASS, "Varified email is present");
  	
    //Delete Outgoing Emails Afterwards
  	driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
  	driver.findElement(By.xpath(".//*[@id='mainContainer']/div[6]/div/div/table/tbody/tr[1]/td[5]/a")).click();
  	
  	driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
  	driver.switchTo().alert().accept();
  	
  	 try {
			String Alertnote = "Email deleted";  
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
								
			test.log(LogStatus.FAIL, "Validation Failed");
			Assert.fail("Exception " + e);

		}


}




@Test (priority = 5,groups = {"Sanity","BS_Sanity","Sanity_Chrome"})
public void Send_Change_Password_Request_Email() throws Exception {
	  
	    test = report.startTest("Admin Test --> Change Password Request Email");
	    test.log(LogStatus.INFO, "Admin User Logged in");
	  		
		//Navigate to User Profiles
		//Search For UK Test User
		 driver.findElement(By.xpath(".//*[@id='mainNavigation']/li[2]/a")).click();
		 test.log(LogStatus.INFO, "Account Search Page Opened");
		 
		 driver.findElement(By.name("data[Account][query]")).sendKeys("Uk Test");
		 //test.log(LogStatus.INFO, "Type 'UK Test' in Search Query Field");
		 
		 driver.findElement(By.xpath(".//*[@id='AccountAdminIndexForm']/div[2]/div[1]/button")).click();
		 //test.log(LogStatus.INFO, "Type 'UK Test' in Search Query Field");
		 
		 JavascriptExecutor jse = (JavascriptExecutor)driver;
	     jse.executeScript("window.scrollBy(0,500)", "");
		 
		 Thread.sleep(15000);
		 
		 Actions  Mouse=new Actions(driver);
	     WebElement Dropdown=driver.findElement(By.xpath(".//*[@id='DataTables_Table_0']/tbody/tr[1]/td[9]/div/button"));
	     Mouse.click(Dropdown);
	     driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
	     WebElement EyeIcon=driver.findElement(By.xpath(".//*[@id='DataTables_Table_0']/tbody/tr[1]/td[9]/div/ul/li[1]/a"));
	     Mouse.moveToElement(EyeIcon);
	     Mouse.click();
	     Mouse.perform();
	     
	     driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
	     test.log(LogStatus.INFO, "UK Test Account Found and Opened");
		 
	     /*Click Account End Users Link*/
	     AdminSslDashBoardElements.ClickAccountEndUsersLink();
		 
		 //JavascriptExecutor jse = (JavascriptExecutor)driver;
	     jse.executeScript("window.scrollBy(0,500)", "");
	     
	     Thread.sleep(1000);
	     
		 test.log(LogStatus.INFO, "Opened Account End Users Page");
		  
		 String UserVal = "Gideon Ogunleye";
		 WebElement User = driver.findElement(By.xpath(".//*[@id='mainContainer']/div[7]/div[2]/div[2]/div[1]/div/address/strong[1]"));
		 WebElement User2 = driver.findElement(By.xpath(".//*[@id='mainContainer']/div[7]/div[2]/div[2]/div[2]/div/address/strong[1]"));
		 WebElement User3 = driver.findElement(By.xpath(".//*[@id='mainContainer']/div[7]/div[2]/div[2]/div[3]/div/address/strong[1]"));
		 WebElement User4 = driver.findElement(By.xpath(".//*[@id='mainContainer']/div[7]/div[2]/div[2]/div[4]/div/address/strong[1]"));
		 
		 if(User.getText().equals(UserVal)){
				
			 driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
			 Actions  actions=new Actions(driver);
		     WebElement menuHoverLink=driver.findElement(By.xpath(".//*[@id='mainContainer']/div[7]/div[2]/div[2]/div[1]/div/address/div[2]/div/button"));
		     actions.click(menuHoverLink);
		     driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
		     WebElement subLink=driver.findElement(By.xpath(".//*[@id='mainContainer']/div[7]/div[2]/div[2]/div[1]/div/address/div[2]/div/ul/li[1]/a"));
		     actions.moveToElement(subLink);
		     actions.click();
		     actions.perform();
		     test.log(LogStatus.INFO, "Clicked on Edit Button of UK Test User");
		     
				 
			}else if (User2.getText().equals(UserVal)) {
				
				driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
				 Actions  actions=new Actions(driver);
			     WebElement menuHoverLink=driver.findElement(By.xpath(".//*[@id='mainContainer']/div[7]/div[2]/div[2]/div[2]/div/address/div[2]/div/button"));
			     actions.click(menuHoverLink);
			     driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
			     WebElement subLink=driver.findElement(By.xpath(".//*[@id='mainContainer']/div[7]/div[2]/div[2]/div[2]/div/address/div[2]/div/ul/li[1]/a"));
			     actions.moveToElement(subLink);
			     actions.click();
			     actions.perform();
			     test.log(LogStatus.INFO, "Clicked on Edit Button of UK Test User");
			     
				
			 }else if (User3.getText().equals(UserVal)) {
		
				 driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
				 Actions  actions=new Actions(driver);
				 WebElement menuHoverLink=driver.findElement(By.xpath(".//*[@id='mainContainer']/div[7]/div[2]/div[2]/div[3]/div/address/div[2]/div/button"));
				 actions.click(menuHoverLink);
				 driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
				 WebElement subLink=driver.findElement(By.xpath(".//*[@id='mainContainer']/div[7]/div[2]/div[2]/div[3]/div/address/div[2]/div/ul/li[1]/a"));
				 actions.moveToElement(subLink);
				 actions.click();
				 actions.perform();
				 test.log(LogStatus.INFO, "Clicked on Edit Button of UK Test User");
				 
		
			 }else if (User4.getText().equals(UserVal)) {
				 
				 driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
				 Actions  actions=new Actions(driver);
				 WebElement menuHoverLink=driver.findElement(By.xpath(".//*[@id='mainContainer']/div[7]/div[2]/div[2]/div[]/div/address/div[2]/div/button"));
				 actions.click(menuHoverLink);
				 driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
				 WebElement subLink=driver.findElement(By.xpath(".//*[@id='mainContainer']/div[7]/div[2]/div[2]/div[1]/div/address/div[2]/div/ul/li[1]/a"));
				 actions.moveToElement(subLink);
				 actions.click();
				 actions.perform();
				 test.log(LogStatus.INFO, "Clicked on Edit Button of UK Test User");
				 
				 
			 }else  {
				 
				System.out.println("Quality Tester User Not Found");
				test.log(LogStatus.FAIL, "Test User Not Found");
			 }
		 
		 driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
		 driver.findElement(By.xpath(".//*[@id='UserAdminEditForm']/div[2]/a")).click();
		 //test.log(LogStatus.INFO, "Clicked on Send Change Password Email Button");
		 
		 driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
		 driver.switchTo().alert().accept();
/*		 
		 driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
		 String Confirmation = driver.findElement(By.xpath("html/body/div[4]/p[1]")).getText();	
		 Assert.assertTrue(Confirmation.contains("A reset password has been sent to qa@ssl247.co.uk"));
		 test.log(LogStatus.PASS, "Send Change Password Email Request Successfully Sent");
*/		 
		 try {
				String Alertnote = "A reset password has been sent to qa@ssl247.co.uk";  
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
									
				test.log(LogStatus.FAIL, "Validation Failed");
				Assert.fail("Exception " + e);

			}

		 
}

@Test (priority = 6,groups = {"Sanity","BS_DailySanity"},dataProviderClass =Test_DataSanity.class, dataProvider="ReissueCertificate")
public void Sync_Cert_WithCA(String AdUsername, String Adpassword, String URL, String Account, String Product) throws Exception {
	  
	  test = report.startTest("Admin Test --> Sync Cert With CA");
	  test.log(LogStatus.INFO, "Admin User Logged in");
	  
	  AdminNavigationLinksElements.ClientsAccountsLinkClick();
	  driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
	  test.log(LogStatus.INFO, "Click on clients Accounts Link");
		 
	  //ClientAccountsPageElements.ValidatePage();
	  ClientAccountsPageElements.SearchQueryFieldFill("UK Test");
	  driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
	  test.log(LogStatus.INFO, "Click on Search Query and Enter UK Test");
		 
	  ClientAccountsPageElements.UpdateButtonClink();
	  driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
	  test.log(LogStatus.INFO, "Click on Update Button");
	  
	  JavascriptExecutor jse = (JavascriptExecutor)driver;
	  jse.executeScript("window.scrollBy(0,500)", "");
		 
	  Thread.sleep(1000);
	  
	  ClientAccountsPageElements.ValidateResults("UKTE001");
	  driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
	  test.log(LogStatus.INFO, "Search Resusult is Displayed");
	  
	  ClientAccountsPageElements.ViewAccount();
	  driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
	  test.log(LogStatus.INFO, "Clicked on UK Test Account in search Result");
	  
	  Thread.sleep(2000);
	  
	try {
	 
	  		test.log(LogStatus.INFO, "DashBord Page Opened");
	  		
	  		AdminSslDashBoardElements.ClickMysslCertificatessLink();
	  		driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
			test.log(LogStatus.INFO, "Clicked on Myssl Certificates Link");
	  		
	  		AdminSslDashBoardElements.IssuedLinkClick();
	  		driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
			test.log(LogStatus.INFO, "Clicked on Issued Link");
			
	  	  	jse.executeScript("window.scrollBy(0,450)", "");
	  	  	
	  	  	Thread.sleep(2000);
			
			if (AdminIssuedCertificatesPage.Column10Contains(Product)) {
	    		
	    		driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
	    	    test.log(LogStatus.INFO, "Column 1 Contains Products");
	    		
	    	    String path = ScreenShot.Image(driver, "Product");
				String imagePath = test.addScreenCapture(path);
				test.log(LogStatus.INFO, imagePath);
	    	    
				AdminIssuedCertificatesPage.Column10TextPrint();
				
				AdminIssuedCertificatesPage.Product10View();
	    		driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
	    	    test.log(LogStatus.INFO, "Clicked to view product");
	    	    
	    	    AdminCertificateDetailsPage.SyncWithCaButtonClick();
	    		driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
	    	    test.log(LogStatus.INFO, "Clicked on Sync Button");
	    		
	    	    
	    		}else if (AdminIssuedCertificatesPage.Column2Contains(Product)) {
	    			
	    			driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
		    	    test.log(LogStatus.INFO, "Column 2 Contains Products");
		    	    
		    	    String path = ScreenShot.Image(driver, "Product");
					String imagePath = test.addScreenCapture(path);
					test.log(LogStatus.INFO, imagePath);
					
					AdminIssuedCertificatesPage.Column2TextPrint();
				
					AdminIssuedCertificatesPage.Product2View();
	    			driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
		    	    test.log(LogStatus.INFO, "Clicked to view product");
		    	    
		    	    AdminCertificateDetailsPage.SyncWithCaButtonClick();
		    		driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
		    	    test.log(LogStatus.INFO, "Clicked on Sync Button");
	    			
		    	}else if (AdminIssuedCertificatesPage.Column3Contains(Product)) {
	    			
	    			driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
		    	    test.log(LogStatus.INFO, "Column 3 Contains Products");
		    	    
		    	    String path = ScreenShot.Image(driver, "Product");
					String imagePath = test.addScreenCapture(path);
					test.log(LogStatus.INFO, imagePath);
					
					AdminIssuedCertificatesPage.Column3TextPrint();
				
					AdminIssuedCertificatesPage.Product3View();
	    			driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
		    	    test.log(LogStatus.INFO, "Clicked to view product");
		    	    
		    	    AdminCertificateDetailsPage.SyncWithCaButtonClick();
		    		driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
		    	    test.log(LogStatus.INFO, "Clicked on Sync Button");
		    	    
		    	}else if (AdminIssuedCertificatesPage.Column15Contains(Product)) {
	    			
	    			driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
		    	    test.log(LogStatus.INFO, "Column 10 Contains Products");
		    	    
		    	    String path = ScreenShot.Image(driver, "Product");
					String imagePath = test.addScreenCapture(path);
					test.log(LogStatus.INFO, imagePath);
					
					AdminIssuedCertificatesPage.Column15TextPrint();
				
					AdminIssuedCertificatesPage.Product15View();
	    			driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
		    	    test.log(LogStatus.INFO, "Clicked to view product");
		    	    
		    	    AdminCertificateDetailsPage.SyncWithCaButtonClick();
		    		driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
		    	    test.log(LogStatus.INFO, "Clicked on Sync Button");
  			
	    	}else {
				
				System.out.println("Product Not Found");
				
				//AdminIssuedCertificatesPage.Column15TextPrint();
				
				test.log(LogStatus.FAIL, "Product Not Found");
				String path = ScreenShot.Image(driver, "Product");
				String imagePath = test.addScreenCapture(path);
				test.log(LogStatus.INFO, imagePath);
				
		    	}	
	  
		}catch (Exception e) {
		
			String path = ScreenShot.Image(driver, "Product");
			String imagePath = test.addScreenCapture(path);
			test.log(LogStatus.INFO, imagePath);
			test.log(LogStatus.FAIL, "Validation Failed");
			Assert.fail("Exception " + e);

	}
	
	Thread.sleep(1000);
	
	  		
		//Validate Alert	
		try { 
			
			String Alertnote = "Certificate synced with the CA";  
			AlertBoxElements.AlertWait();
			
			if (AlertBoxElements.VerifyAlert(Alertnote)) {
				
				Assert.assertTrue(AlertBoxElements.VerifyAlert(Alertnote));
				test.log(LogStatus.PASS, "Validation Complete");
				driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
				System.out.println("Validation Complete!");
				
			}else {
					    	
				test.log(LogStatus.FAIL, "Alert Validation Failed");
				AlertBoxElements.AlertPrint();
				//Assert.fail("Validation Failed ");		    	
			}
			
		}catch (Exception e) {
			
			String path = ScreenShot.Image(driver, "SearchResult");
			String imagePath = test.addScreenCapture(path);
			test.log(LogStatus.FAIL, "Alert not Displayed");
			test.log(LogStatus.INFO, imagePath);

		}
	  
}

@Test (priority = 7, groups = {"Sanity","BS_Sanity","Sanity_Chrome"})
public void Create_user_Account() throws Exception{
	  
		//Search For UK Test User
	     test = report.startTest("Admin Test --> Create Account");
	     
	     test.log(LogStatus.INFO, "Admin User Logged in");
	  
		 AdminNavigationLinksElements.ClientsAccountsLinkMouse();
		 driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
		 test.log(LogStatus.INFO, "Moved Mouse to Clients Accounts Link");
		 
		 AdminNavigationLinksElements.NewAccountLinkClick();
		 driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
		 test.log(LogStatus.INFO, "Clicked on New Account Link");
		 
		 Thread.sleep(1000);
		 
		 
		 try { 
			 
		 
			 AddAccountPageElements.CompanyNameFieldFill("SSL 247-Test");
			 driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
			 test.log(LogStatus.INFO, "Filled Company Name");
			 
			 AddAccountPageElements.AccountManagerFieldSelect("Daniel Genadiev");
			 driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
			 test.log(LogStatus.INFO, "Selected Account Manager");
			 
			 AddAccountPageElements.SalesAssistantFieldSelect("Anna Cardinale");
			 driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
			 test.log(LogStatus.INFO, "Selected Sales Assistant");
			 
			 AddAccountPageElements.TerritoryFieldSelect("United Kingdom");
			 driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
			 test.log(LogStatus.INFO, "Selected Territory");
			 
			 AddAccountPageElements.VatPrefixFieldSelect("IT");
			 driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
			 test.log(LogStatus.INFO, "Selected Prefix");
			 
			 AddAccountPageElements.VatNumberFieldFill("01479900217");
			 driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
			 test.log(LogStatus.INFO, "Filled VaT Number");
			 
			 AddAccountPageElements.CompanyRegNumberFieldFill("1234567");
			 driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
			 test.log(LogStatus.INFO, "Filled Reg Number");
			 
			 AddAccountPageElements.AccountActivitySectorFieldSelect("Other");
			 driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
			 test.log(LogStatus.INFO, "Selected Account Activity Sector");
			 
			 AddAccountPageElements.AccountCompanySizeFieldSelect("51-250");
			 driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
			 test.log(LogStatus.INFO, "Selected Company Range");
			 
			 AddAccountPageElements.RequestPaymentTermsCheckBoxClick();
			 driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
			 test.log(LogStatus.INFO, "Ticked Payment Terms Checkbox");
			 
			 AddAccountPageElements.DaysToPayFieldSelect("7");
			 driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
			 test.log(LogStatus.INFO, "Selected Number Of Days To Pay");
			 
			 AddAccountPageElements.DaysToEomCheckBoxClick();
			 driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
			 test.log(LogStatus.INFO, "Ticked Days to Pay EOM Checkbox");
			 
			 AddAccountPageElements.MinimumPaymentLimitFieldSelect("50");
			 driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
			 test.log(LogStatus.INFO, "Selected Minimum Payment Limit");
			 
			 AddAccountPageElements.ActiveButtonClick();
			 driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
			 test.log(LogStatus.INFO, "Clicked Active Button");
			 
			 String path = ScreenShot.Image(driver, "Account");
			 String imagePath = test.addScreenCapture(path);
			 test.log(LogStatus.INFO, imagePath);
			 
			 AddAccountPageElements.CreateAccountButtonClick();
			 driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
			 test.log(LogStatus.INFO, "Clicked Create Account Button");
			 
			 
		 }catch (Exception e) {
				
			  String path = ScreenShot.Image(driver, "Account");
			  String imagePath = test.addScreenCapture(path);
			  test.log(LogStatus.INFO, imagePath);
			  test.log(LogStatus.FAIL, "Form Submittion Failed");
			  driver.navigate().refresh();
			  Assert.fail("Exception " + e);
				
		}	 
	
}

}
