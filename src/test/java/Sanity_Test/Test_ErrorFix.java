package Sanity_Test;

import java.io.IOException;
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
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import BaseUtilities.AlertBox;
import BaseUtilities.BrowserStack;
import BaseUtilities.Cookies;
import BaseUtilities.CsR;
import BaseUtilities.DriverLoad;
import BaseUtilities.ExtentFactory;
import BaseUtilities.TakeScreenShot;
import PageFactory.AddAccountPage;
import PageFactory.AdminCertificateDetailsPage;
import PageFactory.AdminCertificatesPage;
import PageFactory.AdminIssuedCertificatesPage;
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

public class Test_ErrorFix extends BrowserStack {
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
	  
		  LoginPageElements.AdminLogin();
	 
		  report = ExtentFactory.getInstance(); 	 
			 
	  }

@AfterMethod (alwaysRun = true, groups = {"Sanity","Smoke","BS_Smoke","Smoke_Firefox","Smoke_Chrome","BS_Sanity","Sanity_Chrome"})
public void Log_Out (ITestResult result) throws Exception {
	    
	  
	  String path =  ScreenShot.Image(driver, "TestSecreenShot-" + result.getMethod().getMethodName());
	  String imagePath = test.addScreenCapture(path);
	  test.log(LogStatus.INFO, "Test Complete", imagePath);
	  
	  
	  /*User Log Out*/
	  driver.navigate().refresh();
	  Thread.sleep(5000);
	  
	 try{ 
		 
		  LoginPageElements.ClickAdminLogoutButton();
		  test.log(LogStatus.INFO, "Admin User Logged Out");
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
	 
	 // return destination;
}
	
@Test (priority = 1, groups = {"Sanity","BS_Sanity","Sanity_Chrome"})
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
			 
			 AddAccountPageElements.DaysToPayFieldSelect("5");
			 driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
			 test.log(LogStatus.INFO, "Selected Number Of Days To Pay");
			 
			 AddAccountPageElements.DaysToEomCheckBoxClick();
			 driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
			 test.log(LogStatus.INFO, "Tcked Days to Pay EOM Checkbox");
			 
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
