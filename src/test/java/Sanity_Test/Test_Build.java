package Sanity_Test;

import org.testng.annotations.Test;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import BaseUtilities.AlertBox;
import BaseUtilities.BrowserStack;
import BaseUtilities.Chrome;
import BaseUtilities.Cookies;
import BaseUtilities.CsR;
import BaseUtilities.DriverLoad;
import BaseUtilities.ExtentFactory;
import BaseUtilities.TakeScreenShot;
import PageFactory.BillingPage;
import PageFactory.CertificateDetailsPage;
import PageFactory.IssuedCertificatesPage;
import PageFactory.LoginPage;
import PageFactory.NavigationLinks;
import PageFactory.sslDashBoard;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
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
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;

public class Test_Build extends BrowserStack  {
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
	
	
	@BeforeMethod (groups = {"Sanity","Smoke","BS_Smoke","BS_Sanity","BS_Sanity","Smoke_Firefox","Smoke_Chrome","Sanity_Chrome"})
	public void User_Login () throws Exception {
		
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
		
		
		LoginPageElements.ClientLogin();
		
		Thread.sleep(5000);		
	}

	
	@AfterMethod (groups = {"Sanity","Smoke","BS_Smoke","BS_Sanity", "BS_Sanity","Smoke_Firefox","Smoke_Chrome","Sanity_Chrome"}, alwaysRun = true)
	public void User_Logout (ITestResult result) throws Exception {

	    //Take Screen Shots
				
	  	String path =  ScreenShot.Image(driver, "TestSecreenShot-" + result.getMethod().getMethodName());
		String imagePath = test.addScreenCapture(path);
		test.log(LogStatus.INFO, "Test Complete", imagePath);
		
		driver.navigate().refresh();
		
		Thread.sleep(5000);
		
		LoginPageElements.ClickLogoutButton();
		test.log(LogStatus.INFO, "User Logged Out");
		
		report.endTest(test);
		report.flush();
		
		//return destination;
		
	}                                                          
	                                                                                      
	@Test (priority = 3, groups = {"Sanity","BS_DailySanity"},dataProviderClass =Test_DataSanity.class, dataProvider="ReissueCertificate") 
	public void  Reissue_Certificate(String AdUsername, String Adpassword, String URL, String Account, String Product) throws Exception {
		
		System.out.println("Reissue Certificate Test Started!");
		
		test = report.startTest("Registered User Test --> Reissue Certificate: " + Product );
	    test.log(LogStatus.INFO, "User Logged in");
		
		//Navigate Domain Names Link on side bar
	    sslDashBoardElements.ClickMysslCertificatessLink();
		driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
	    test.log(LogStatus.INFO, "Clicked on My SSL Link");
	    
	    sslDashBoardElements.IssuedLinkClick();
		driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
	    test.log(LogStatus.INFO, "Clicked on Issued Link");
	    
	    try {
	    	
	    	if (IssuedCertificatesPageElements.Column1Contains(Product)) {
	    		
	    		driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
	    	    test.log(LogStatus.INFO, "Column 1 Contains Products");
	    		
	    	    String path = ScreenShot.Image(driver, "Product");
				String imagePath = test.addScreenCapture(path);
				test.log(LogStatus.INFO, imagePath);
	    	    
				IssuedCertificatesPageElements.Column1TextPrint();
				
	    		IssuedCertificatesPageElements.Product1View();
	    		driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
	    	    test.log(LogStatus.INFO, "Clicked to view product");
	    		
	    	    
	    		
	    		}else if (IssuedCertificatesPageElements.Column2Contains(Product)) {
	    			
	    			driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
		    	    test.log(LogStatus.INFO, "Column 2 Contains Products");
		    	    
		    	    String path = ScreenShot.Image(driver, "Product");
					String imagePath = test.addScreenCapture(path);
					test.log(LogStatus.INFO, imagePath);
					
					IssuedCertificatesPageElements.Column2TextPrint();
				
	    			IssuedCertificatesPageElements.Product2View();
	    			driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
		    	    test.log(LogStatus.INFO, "Clicked to view product");
	    			
		    	}else if (IssuedCertificatesPageElements.Column3Contains(Product)) {
	    			
	    			driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
		    	    test.log(LogStatus.INFO, "Column 3 Contains Products");
		    	    
		    	    String path = ScreenShot.Image(driver, "Product");
					String imagePath = test.addScreenCapture(path);
					test.log(LogStatus.INFO, imagePath);
					
					IssuedCertificatesPageElements.Column3TextPrint();
				
	    			IssuedCertificatesPageElements.Product3View();
	    			driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
		    	    test.log(LogStatus.INFO, "Clicked to view product");
    			
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
		
	    
	    //Certificates Page
	    try {
	    
	    	CertificateDetailsPageElements.ReIssueButtonClick();
	    	driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
    	    test.log(LogStatus.INFO, "Clicked on Re-Issued Tab");
    	    
    	    CertificateDetailsPageElements.CsrFieldClick();
    	    driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
    	    test.log(LogStatus.INFO, "Clicked Csr Field");
    	    
    	    CertificateDetailsPageElements.LoadSsl247_TestCsR();
    	    driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
    	    test.log(LogStatus.INFO, "Loaded Csr");
    	    
    	    CertificateDetailsPageElements.ValidateCsrButton();
    	    driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
    	    test.log(LogStatus.INFO, "Clicked Validate Csr Button");
    	    
    	    Thread.sleep(1000);
    	    
    	    CertificateDetailsPageElements.ReIssueCertificateButtonClick();
    	    driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
    	    test.log(LogStatus.INFO, "Clicked on Reissue Certificate Button");
	    
		}catch (Exception e) {
			
			String path = ScreenShot.Image(driver, "Product");
			String imagePath = test.addScreenCapture(path);
			test.log(LogStatus.INFO, imagePath);
			test.log(LogStatus.FAIL, "Validation Failed");
			Assert.fail("Exception " + e);
		}
	    
	    
	    try {
	    	
	    	String Alertnote = "Certificate has been submitted for reissue";  
	    	AlertBoxElements.AlertWait();
	    			    	
	      if (AlertBoxElements.VerifyAlert(Alertnote)) {
	    						
	    	test.log(LogStatus.PASS, "Validation Complete");
	    	Assert.assertTrue(AlertBoxElements.VerifyAlert(Alertnote));
	    	System.out.println("Validation Complete!");
	    	
	      }else{
	    	
	    	String path = ScreenShot.Image(driver, "SearchResult");
	    	String imagePath = test.addScreenCapture(path);
	    	test.log(LogStatus.INFO, imagePath);
  
	    	test.log(LogStatus.FAIL, "Alert Validation Failed");
	    	AlertBoxElements.AlertPrint();
	   	    	
	    	}
	    	
	    }catch (Exception e) {
	    						
	    	test.log(LogStatus.FAIL, "Alart Not Displayed");
	    	String path = ScreenShot.Image(driver, "SearchResult");
	    	String imagePath = test.addScreenCapture(path);
	    	test.log(LogStatus.INFO, imagePath);
	    	Assert.fail("Exception " + e);
	    }
	    
	}   

}
