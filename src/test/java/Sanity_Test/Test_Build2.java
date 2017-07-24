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
import PageFactory.AdminCertificateDetailsPage;
import PageFactory.AdminCertificatesPage;
import PageFactory.AdminIssuedCertificatesPage;
import PageFactory.AdminNavigationLinks;
import PageFactory.AdminSslDashBoard;
import PageFactory.BillingPage;
import PageFactory.ClientAccountsPage;
import PageFactory.LoginPage;
import PageFactory.NavigationLinks;
import PageFactory.ProposalsPage;
import PageFactory.sslDashBoard;
import Regression_Test.Test_Data;

public class Test_Build2 extends BrowserStack {
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
		  report.endTest(test);
		  report.flush();
	  
	 }catch (Exception e) {
			
			test.log(LogStatus.FAIL, "Logout Failed");
			report.endTest(test);
			report.flush();
			//Assert.fail("Exception " + e);
		}
	 
	 // return destination;
}
	
@Test (priority = 3,groups = {"Sanity","BS_DailySanity"},dataProviderClass =Test_DataSanity.class, dataProvider="ReissueCertificate")
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
	  
	  Thread.sleep(1000);
	  
	try {
	 
	  		test.log(LogStatus.INFO, "DashBord Page Opened");
	  		
	  		AdminSslDashBoardElements.ClickMysslCertificatessLink();
	  		driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
			test.log(LogStatus.INFO, "Clicked on Myssl Certificates Link");
	  		
	  		AdminSslDashBoardElements.IssuedLinkClick();
	  		driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
			test.log(LogStatus.INFO, "Clicked on Issued Link");
			
			if (AdminIssuedCertificatesPage.Column1Contains(Product)) {
	    		
	    		driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
	    	    test.log(LogStatus.INFO, "Column 1 Contains Products");
	    		
	    	    String path = ScreenShot.Image(driver, "Product");
				String imagePath = test.addScreenCapture(path);
				test.log(LogStatus.INFO, imagePath);
	    	    
				AdminIssuedCertificatesPage.Column1TextPrint();
				
				AdminIssuedCertificatesPage.Product1View();
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
  			
	    	}else {
				
				System.out.println("Product Not Found");
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

  
}
