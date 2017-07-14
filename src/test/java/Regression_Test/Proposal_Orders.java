package Regression_Test;

import java.util.concurrent.TimeUnit;

import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import BaseUtilities.AlertBox;
import BaseUtilities.BrowserStack;
import BaseUtilities.CsR;
import BaseUtilities.DriverLoad;
import BaseUtilities.ExtentFactory;
import BaseUtilities.TakeScreenShot;
import PageFactory.AdminCertificatesPage;
import PageFactory.AdminNavigationLinks;
import PageFactory.AdminSslDashBoard;
import PageFactory.BillingPage;
import PageFactory.ClientAccountsPage;
import PageFactory.LoginPage;
import PageFactory.NavigationLinks;
import PageFactory.ProposalsPage;
import PageFactory.sslDashBoard;

public class Proposal_Orders extends BrowserStack {
	
	ExtentReports report;
	ExtentTest test;
	LoginPage 	LoginPageElements;
	BillingPage BillingPageElements;
	sslDashBoard sslDashBoardElements;
	AlertBox AlertBoxElements;
	TakeScreenShot ScreenShot;
	CsR CsrElements;
	AdminNavigationLinks AdminNavigationLinksElements;
	AdminCertificatesPage AdminCertificatesPageElements;
	NavigationLinks NavigationLinksElements;
	AdminSslDashBoard AdminSslDashBoardElements;
	ProposalsPage ProposalsPageElements;
	ClientAccountsPage ClientAccountsPageElements;

	
	@BeforeMethod (groups = {"Regression","BS_Regression","Regression_Chrome"})
	public void User_Login () throws Exception {
		 
		LoginPageElements = new LoginPage(driver);
		BillingPageElements = new BillingPage(driver);
		sslDashBoardElements = new sslDashBoard(driver);
		AlertBoxElements = new AlertBox(driver);
		ScreenShot = new TakeScreenShot();
		CsrElements = new CsR(driver);
		AdminSslDashBoardElements = new AdminSslDashBoard(driver);
		ProposalsPageElements = new ProposalsPage(driver);
		NavigationLinksElements = new NavigationLinks(driver);
		AdminNavigationLinksElements = new AdminNavigationLinks(driver);
		ClientAccountsPageElements = new ClientAccountsPage(driver);
		AdminCertificatesPageElements = new AdminCertificatesPage(driver);
	
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
		
		report.endTest(test);
		report.flush();
		
	}
	
	
  @Test (priority = 1)
  public void Proposals_Order() throws Exception {
	  
	  report = ExtentFactory.getInstance2();
	  
	  test = report.startTest("Admin Test --> Proposals Order Test");
	     
	  test.log(LogStatus.INFO, "Admin User Logged in");
	  
	  //Log in as administrator
	  LoginPageElements.AdminLogin();
	  driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
	  test.log(LogStatus.INFO, "Logged in as Admin");
	  
	  AdminNavigationLinksElements.ClientsAccountsLinkClick();
	  driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
	  test.log(LogStatus.INFO, "Click on clients Accounts Link");
	  
	  ClientAccountsPageElements.ValidatePage();
	  driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
	  test.log(LogStatus.INFO, "Click Account Page Validated");
		 
		 
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
		 
	  ClientAccountsPageElements.ViewAccount();
	  driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
	  test.log(LogStatus.INFO, "Click on UK Test Account in search Result");
	     
	  Thread.sleep(1000);
	  
	  LoginPageElements.ClickAdminLogoutButton();
	  
	  
  }
  
  
  
  
  
}
