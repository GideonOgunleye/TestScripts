package Regression_Test;

import org.testng.annotations.Test;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import BaseUtilities.AlertBox;
import BaseUtilities.BrowserStack;
import BaseUtilities.Chrome;
import BaseUtilities.CsR;
import BaseUtilities.ExtentFactory;
import BaseUtilities.TakeScreenShot;
import PageFactory.AdminNavigationLinks;
import PageFactory.AdminSslDashBoard;
import PageFactory.BillingPage;
import PageFactory.ClientAccountsPage;
import PageFactory.LoginPage;
import PageFactory.NavigationLinks;
import PageFactory.sslDashBoard;

import org.testng.annotations.BeforeMethod;

import java.io.File;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;


public class MasterRelease_18 extends Chrome{
	ExtentReports report;
	ExtentTest test;
	LoginPage 	LoginPageElements;
	BillingPage BillingPageElements;
	sslDashBoard sslDashBoardElements;
	AdminSslDashBoard AdminSslDashBoardElements;
	CsR CsrElements;
	NavigationLinks NavigationElements;
	AdminNavigationLinks AdminNavigationLinksElements;
	ClientAccountsPage ClientAccountsPageElements;
	TakeScreenShot ScreenShot;
	
	AlertBox AlertBoxElements;

  @BeforeMethod (groups = {"Regression","Regression_Chrome"})
  public void beforeMethod() throws Exception {
	  
	  report = ExtentFactory.getInstance(); 
	  LoginPageElements = new LoginPage(driver);
	  BillingPageElements = new BillingPage(driver);
	  sslDashBoardElements = new sslDashBoard(driver);
	  AdminSslDashBoardElements = new AdminSslDashBoard(driver);
	  ClientAccountsPageElements = new ClientAccountsPage(driver);
	  AdminNavigationLinksElements = new AdminNavigationLinks(driver);
	  CsrElements = new CsR(driver);
	  NavigationElements = new NavigationLinks(driver);
	  AlertBoxElements = new AlertBox(driver);
	  ScreenShot = new TakeScreenShot();
		
		
	  Thread.sleep(5000);	
	  
  }

  @AfterMethod (groups = {"Regression","Regression_Chrome"}, alwaysRun = true)
  public String afterMethod (ITestResult result) throws Exception {
	  
	    //Take Screen Shots
	  	String filename =  result.getMethod().getMethodName() + result.getEndMillis() + ".png";
	    String Directory = "C:\\Users\\Gideon Okunleye\\Documents\\Testing Documents\\ScreenShots\\Regression ScreenShots\\";
		  
	    File sourceFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(sourceFile, new File(Directory + filename));
		  
		String destination = Directory + filename;
		String path = destination;
		String imagePath = test.addScreenCapture(path);
		test.log(LogStatus.INFO, "Test Complete", imagePath);
		
		driver.navigate().refresh();
		Thread.sleep(5000);
		
		test.log(LogStatus.INFO, "User Logged Out");
		
		report.endTest(test);
		report.flush();
		
		return destination;
	  
	  
  }
  
  @Test (groups = {"Regression","Regression_Chrome"})
  public void HackAdvertOption_Not_Available() throws Exception {
	  
	  //Log in as Administrator
	  LoginPageElements.AdminLogin();
	  
	  report = ExtentFactory.getInstance2();
	  
	  //Search For UK Test User
	  test = report.startTest("Regression Test --> HackAdvert Option Not Available");
	  test.log(LogStatus.INFO, "Admin User Logged in");
	  
	  AdminNavigationLinksElements.ClientsAccountsLinkClick();
	  driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
	  test.log(LogStatus.INFO, "Click on clients Accounts Link");
		 
	  ClientAccountsPageElements.ValidatePage();
	  driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
	  ClientAccountsPageElements.SearchQueryFieldFill("UK Test");
	  driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
	  test.log(LogStatus.INFO, "Click on Search Query and Enter UK Test");
		 
	  ClientAccountsPageElements.UpdateButtonClink();
	  driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
	  test.log(LogStatus.INFO, "Click on Update Button");
		 
	  Thread.sleep(5000);
	  ClientAccountsPageElements.ValidateResults("UK Test");
	  driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
	  test.log(LogStatus.INFO, "Search Resusult is Displayed");
	  ClientAccountsPageElements.ViewAccount();
	  driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
	  test.log(LogStatus.INFO, "Click on UK Test Account in search Result");
	  Thread.sleep(1000);
	  sslDashBoardElements.AdminDashboardValidation();
	  driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
	  test.log(LogStatus.INFO, "DashBord Page Opened");
	  
	  //Click on SSL Certificates Link
	  AdminSslDashBoardElements.ClickMysslCertificatessLink();
	  driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
	  test.log(LogStatus.INFO, "Clicked on Certificates Link");
	  
	  Thread.sleep(2000);

	  //Click on External Link
	  AdminSslDashBoardElements.ExternalLinkClick();
	  driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
	  test.log(LogStatus.INFO, "Clicked on External Link");
	  
	  //Scroll Page Up
	  driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
	  JavascriptExecutor jse = (JavascriptExecutor)driver;
	  jse.executeScript("window.scrollBy(0,-500)", "");
	  Thread.sleep(1000);
	  
	  //Verify Free Vulnerability Scan Option
	 
	  try{	  
		  
		  AdminSslDashBoardElements.FirstCertDropDown();
		  driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
		  String path = ScreenShot.Image(driver, "SearchResult");
		  String imagePath = test.addScreenCapture(path);
		  test.log(LogStatus.FAIL, "Hackadvert Available");
		  test.log(LogStatus.INFO, imagePath);
		  Assert.fail("Hackadvert Option is Available");
		  
	  }catch (Exception e) {
			
		  	test.log(LogStatus.PASS, "Hackadvert Not Available");
		  	
	 }

	  //Log Out 
	  LoginPageElements.ClickAdminLogoutButton();
	  test.log(LogStatus.INFO, "Admin User Logged Out");
	   
  }
  
  
  @Test 
  public void Bulk_Edit_AdminContact () throws Exception {
	  
	  //Log in as Administrator
	  LoginPageElements.AdminLogin();
	  
	  report = ExtentFactory.getInstance2();
	  
	  //Search For UK Test User
	  test = report.startTest("Regression Test --> HackAdvert Option Not Available");
	  test.log(LogStatus.INFO, "Admin User Logged in");
	  
	  AdminNavigationLinksElements.ClientsAccountsLinkClick();
	  driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
	  test.log(LogStatus.INFO, "Click on clients Accounts Link");
		 
	  ClientAccountsPageElements.ValidatePage();
	  driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
	  ClientAccountsPageElements.SearchQueryFieldFill("UK Test");
	  driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
	  test.log(LogStatus.INFO, "Click on Search Query and Enter UK Test");
		 
	  ClientAccountsPageElements.UpdateButtonClink();
	  driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
	  test.log(LogStatus.INFO, "Click on Update Button");
		 
	  Thread.sleep(5000);
	  ClientAccountsPageElements.ValidateResults("UK Test");
	  driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
	  test.log(LogStatus.INFO, "Search Resusult is Displayed");
	  ClientAccountsPageElements.ViewAccount();
	  driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
	  test.log(LogStatus.INFO, "Click on UK Test Account in search Result");
	  Thread.sleep(1000);
	  sslDashBoardElements.AdminDashboardValidation();
	  driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
	  test.log(LogStatus.INFO, "DashBord Page Opened");
	  
	  
	  //Click on SSL Certificates Link
	  AdminSslDashBoardElements.ClickMysslCertificatessLink();
	  driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
	  test.log(LogStatus.INFO, "Clicked on Certificates Link");
	  
	  Thread.sleep(2000);
	  
	  //Click on Search Link
	  AdminSslDashBoardElements.SearchLinkClick();
	  driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
	  test.log(LogStatus.INFO, "Clicked on Search Link");
	  
	  
	  //Click on Bulk Edit Contacts Button 
	  AdminSslDashBoardElements.BulkEditContactsButtonClick();
	  driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
	  test.log(LogStatus.INFO, "Clicked on Bulk Edit Contacts Button");
	  
	  Thread.sleep(1000);
	
	try {  
		
	  //Click on Admin Contact Checkbox
	  AdminSslDashBoardElements.AdminContactCheckboxClick();
	  driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
	  test.log(LogStatus.INFO, "Clicked on Admin Contact Checkbox");	  
	  
	  AdminSslDashBoardElements.ContactFieldSelect("Gideon Ogunleye");
	  driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
	  test.log(LogStatus.INFO, "Selected Name From Contact Field");	 
	  
	  AdminSslDashBoardElements.UpdateCertificateButtonClick();
	  //driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
	  test.log(LogStatus.INFO, "Clicked The Update Button");	
	  
	} catch (Exception e) {
		
		test.log(LogStatus.FAIL, "Validation Failed");
		Assert.fail("Exception " + e);

	}
	
	try {
		
		String Alertnote = "Certificates Updated Successfully";  
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
		System.out.println("Alert NOT Validated");

	}

	
	
	  
	  
	  
	  
	  
	  
	  
	  
  }


}
