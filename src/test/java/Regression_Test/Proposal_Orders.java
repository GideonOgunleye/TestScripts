package Regression_Test;

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
	
	
  @Test (priority = 1, groups = {"Regression","BS_Regression","Regression_Chrome"},dataProviderClass = Test_Data.class, dataProvider="ProposalsOrder_Data")
  public void Proposals_Order(String ProductType, String Product, String Quantity, String Duration, String License, String CommonName) throws Exception {
	  
	  report = ExtentFactory.getInstance2();
	  
	  test = report.startTest("Admin Test --> Proposals Order Test");
	     
	  test.log(LogStatus.INFO, "Browser Opened and Url Enterl");
	  
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
	  
	  AdminSslDashBoardElements.ProposalsLinkClick();
	  driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
	  test.log(LogStatus.INFO, "Clicked on proposal link");
	  
	  JavascriptExecutor jse = (JavascriptExecutor)driver;
	  jse.executeScript("window.scrollBy(0,500)", "");
	  
	  Thread.sleep(1000);
	 
	  try {
		  
			  ProposalsPageElements.NewProposalButtonClink();
			  driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
			  test.log(LogStatus.INFO, "Clicked on New Proposal Button");
			  
			  jse.executeScript("window.scrollBy(0,500)", "");
			  
			  Thread.sleep(2000);
			  
			  //Select Product Type
			  ProposalsPageElements.ProductTypeFieldSelect(ProductType);
			  driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
			  test.log(LogStatus.INFO, "Selected Product Type");
			  
			  Thread.sleep(1000);
			  
			  //Select Product 
			  ProposalsPageElements.ProductFieldSelect(Product);
			  driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
			  test.log(LogStatus.INFO, "Selected Product");
			  
			  Thread.sleep(1000);
			  
			  //Select Quantity
			  ProposalsPageElements.QuantityFieldClear();
			  ProposalsPageElements.QuantityFieldSenkeys(Quantity);
			  driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
			  test.log(LogStatus.INFO, "Selected Quantity");
			  
			  Thread.sleep(1000);
			  
			  //Select Duration
			  ProposalsPageElements.DurationFieldSelect(Duration);
			  driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
			  test.log(LogStatus.INFO, "Selected Duration");
			  
			  Thread.sleep(1000);
			  
			  //Select Number of Licenses
			  try {  
				  
				  ProposalsPageElements.LicenseFieldSelect(License);
				  driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
				  test.log(LogStatus.INFO, "Selected Duration");
			  
			  }catch (Exception p) {
					
				  String path = ScreenShot.Image(driver, "Proposal");
				  String imagePath = test.addScreenCapture(path);
				  test.log(LogStatus.INFO, imagePath);
				  test.log(LogStatus.INFO, "Licence Field Not Clickable");
				  //Assert.fail("Exception " + e);

				}
			  

			  Thread.sleep(1000);
			  
			  //Fill Common Name Field
			  try { 
				 
				  ProposalsPageElements.CommonNameFieldClear();
				  ProposalsPageElements.CommonNameFieldSendKeys(CommonName);
				  driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
				  test.log(LogStatus.INFO, "Entered Common Name");
			  
			  }catch (Exception e) {
			
				  String path = ScreenShot.Image(driver, "Proposal");
				  String imagePath = test.addScreenCapture(path);
				  test.log(LogStatus.INFO, imagePath);
				  test.log(LogStatus.INFO, "Common Name Field Not Clickable");
				  //Assert.fail("Exception " + e);
		
			  }
			  
			  Thread.sleep(1000);
			  
			  //Click Calculate Prices Button
			  
			  ProposalsPageElements.CalculatePricesButtonClink();
			  driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
			  test.log(LogStatus.INFO, "Click on Calculate Prices Button");
			  
			  jse.executeScript("window.scrollBy(0,500)", "");
			  
			  Thread.sleep(1000);
				
			  //Click Save 
			
			  ProposalsPageElements.SaveProposalButtonClink();
			  driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
			  test.log(LogStatus.INFO, "Click on Save Proposal Button");
			  
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
		  	  
		  	  Thread.sleep(1000);
		  	  
		  	  ProposalsPageElements.ConvertToInvoiceButtonClink();
		  	  driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
		  	  test.log(LogStatus.INFO, "Clicked Covert to Invoice Button");
		  	
		  	try {
		  		
		  		 WebDriverWait wait = new WebDriverWait(driver, 2);
		         wait.until(ExpectedConditions.alertIsPresent());
		         Alert alert = driver.switchTo().alert();
		         alert.accept();
		         driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
			  	 test.log(LogStatus.INFO, "Clicked on Alert");
		        
		    } catch (Exception e) {
		    	
		    	System.out.println("Alert Not Handled");
		    }
		  	  
			  
			 
	   }catch (Exception e) {
			
		   	String path = ScreenShot.Image(driver, "Proposal");
			String imagePath = test.addScreenCapture(path);
			test.log(LogStatus.INFO, imagePath);
			test.log(LogStatus.FAIL, "Test Failed");
			LoginPageElements.ClickAdminLogoutButton();
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
			//Assert.fail("Validation Failed ");
					    	
		  }
			
		}catch (Exception e) {
								
			String path = ScreenShot.Image(driver, "SearchResult");
			String imagePath = test.addScreenCapture(path);
			test.log(LogStatus.INFO, imagePath);
			test.log(LogStatus.FAIL, "Alert not Displayed");

		}

	  
	  LoginPageElements.ClickAdminLogoutButton();
	  
	  
  }
  
  
  
  
  
}
