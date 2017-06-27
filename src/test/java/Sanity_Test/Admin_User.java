package Sanity_Test;

import org.testng.annotations.Test;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import BaseUtilities.AlertBox;
import BaseUtilities.BrowserStack;
import BaseUtilities.DriverLoad;
import BaseUtilities.ExtentFactory;
import BaseUtilities.TakeScreenShot;
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

public class Admin_User extends DriverLoad {
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
  TakeScreenShot ScreenShot;
  
	
  @BeforeMethod (groups = {"Sanity","Smoke","Smoke_Firefox","Smoke_Chrome","Sanity_Chrome"})
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
	  ScreenShot = new TakeScreenShot();
  
	  LoginPageElements.AdminLogin();
 
	  report = ExtentFactory.getInstance(); 	 
		 
  }
  
  @AfterMethod (alwaysRun = true, groups = {"Sanity","Smoke","Smoke_Firefox","Smoke_Chrome","Sanity_Chrome"})
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
  
  @Test (priority = 0, groups = {"Smoke","Smoke_Firefox"})
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

  
  @Test (priority = 1, groups = {"Sanity","BS_Sanity","Sanity_Chrome"})
  public void Edit_Account_User() throws Exception{
	  
	//Search For UK Test User
	     test = report.startTest("Admin Test --> Edit User");
	     test.log(LogStatus.INFO, "Admin User Logged in");
	  
	     AdminNavigationLinksElements.ClientsAccountsLinkClick();
		 test.log(LogStatus.INFO, "Click on clients Accounts Link");
		 
		 ClientAccountsPageElements.ValidatePage();
		 ClientAccountsPageElements.SearchQueryFieldFill("UK Test");
		 test.log(LogStatus.INFO, "Click on Search Query and Enter UK Test");
		 
		 ClientAccountsPageElements.UpdateButtonClink();
		 test.log(LogStatus.INFO, "Click on Update Button");
		 
		 Thread.sleep(5000);
		 ClientAccountsPageElements.ValidateResults("UK Test");
		 test.log(LogStatus.INFO, "Search Resusult is Displayed");
		 ClientAccountsPageElements.ViewAccount();
	     test.log(LogStatus.INFO, "Click on UK Test Account in search Result");
	     Thread.sleep(1000);
	     sslDashBoardElements.AdminDashboardValidation();
	  	 test.log(LogStatus.INFO, "DashBord Page Opened");
	     
		 
	     /*
	      * Click on My Users Link
	      */
	     sslDashBoardElements.ClickAccountEndUsersLink();
	     driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
	     JavascriptExecutor jse = (JavascriptExecutor)driver;
	     jse.executeScript("window.scrollBy(0,500)", "");
	     Thread.sleep(1000);
		 test.log(LogStatus.INFO, "Click on Account End Users link on the side bar Menu");
		 
try {		 
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
		     test.log(LogStatus.INFO, "Navigate to Quality Assurance Tester User and Click Edit");
		     
		     //Edit User
		     WebElement AccessLevel = driver.findElement(By.xpath(".//*[@id='UserAccessLevel']"));
			 Select Level = new Select(AccessLevel);
			 Level.selectByVisibleText("Super User");
			 test.log(LogStatus.INFO, "Change Access Level to Super User");
			 Thread.sleep(1000);
			 
			//Edit Optional Details
			 driver.findElement(By.xpath(".//*[@id='UserAdminEditForm']/div[3]/ul/li[2]/a")).click();
			 driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
			 driver.findElement(By.xpath(".//*[@id='UserState']")).clear();
			 driver.findElement(By.xpath(".//*[@id='UserState']")).sendKeys("London");
			 driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
			 
			//Click Save User
			 driver.findElement(By.xpath(".//*[@id='UserAdminEditForm']/div[2]/button")).click();
			 test.log(LogStatus.INFO, "Click Submit Chnages Button");
			 
			 test.log(LogStatus.PASS, "Test User Account Edited and Saved");
			 
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
			     test.log(LogStatus.INFO, "Navigate to Quality Assurance Tester User and Click Edit");
			     
			     //Edit User
			     WebElement AccessLevel = driver.findElement(By.xpath(".//*[@id='UserAccessLevel']"));
				 Select Level = new Select(AccessLevel);
				 Level.selectByVisibleText("Super User");
				 test.log(LogStatus.INFO, "Change Access Level to Super User");
				 Thread.sleep(1000);
				 
				 //Edit Optional Details
				 driver.findElement(By.xpath(".//*[@id='UserAdminEditForm']/div[3]/ul/li[2]/a")).click();
				 driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
				 driver.findElement(By.xpath(".//*[@id='UserState']")).clear();
				 driver.findElement(By.xpath(".//*[@id='UserState']")).sendKeys("London");
				 driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
				 
				//Click Save User
				 driver.findElement(By.xpath(".//*[@id='UserAdminEditForm']/div[2]/button")).click();
				 test.log(LogStatus.INFO, "Click Submit Chnages Button");
				 
				 test.log(LogStatus.PASS, "Test User Account Edited and Saved");
				 
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
				 test.log(LogStatus.INFO, "Navigate to Quality Assurance Tester User and Click Edit");
				 
				 //Edit User
			     WebElement AccessLevel = driver.findElement(By.xpath(".//*[@id='UserAccessLevel']"));
				 Select Level = new Select(AccessLevel);
				 Level.selectByVisibleText("Super User");
				 test.log(LogStatus.INFO, "Change Access Level to Super User");
				 Thread.sleep(1000);
				 
				//Edit Optional Details
				 driver.findElement(By.xpath(".//*[@id='UserAdminEditForm']/div[3]/ul/li[2]/a")).click();
				 driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
				 driver.findElement(By.xpath(".//*[@id='UserState']")).clear();
				 driver.findElement(By.xpath(".//*[@id='UserState']")).sendKeys("London");
				 driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
				 
				//Click Save User
				 driver.findElement(By.xpath(".//*[@id='UserAdminEditForm']/div[2]/button")).click();
				 test.log(LogStatus.INFO, "Click Submit Chnages Button");
				 
				 test.log(LogStatus.PASS, "Test User Account Edited and Saved");
		
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
				 test.log(LogStatus.INFO, "Navigate to Quality Assurance Tester User and Click Edit");
				 
				 //Edit User
			     WebElement AccessLevel = driver.findElement(By.xpath(".//*[@id='UserAccessLevel']"));
				 Select Level = new Select(AccessLevel);
				 Level.selectByVisibleText("Super User");
				 test.log(LogStatus.INFO, "Change Access Level to Super User");
				 Thread.sleep(1000);
				 
				//Edit Optional Details
				 driver.findElement(By.xpath(".//*[@id='UserAdminEditForm']/div[3]/ul/li[2]/a")).click();
				 driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
				 driver.findElement(By.xpath(".//*[@id='UserState']")).clear();
				 driver.findElement(By.xpath(".//*[@id='UserState']")).sendKeys("London");
				 driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
				 
				//Click Save User
				 driver.findElement(By.xpath(".//*[@id='UserAdminEditForm']/div[2]/button")).click();
				 test.log(LogStatus.INFO, "Click Submit Chnages Button");
				 
				 test.log(LogStatus.PASS, "Test User Account Edited and Saved");
				 
			 }else  {
				 
				test.log(LogStatus.FAIL, "Test User Account not Found"); 
				System.out.println("Quality Tester User Not Found");
				
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
				Assert.fail("Validation Failed ");
						    	
				}
				
			}catch (Exception e) {
									
				test.log(LogStatus.FAIL, "Validation Failed");
				Assert.fail("Exception " + e);

			}

		 	 		
		 
  }
  
  @Test (priority = 2,groups = {"Smoke","Smoke_Firefox"})
  public void Create_Proposal () throws Exception {
	  
	//Navigate to User Account, Search for User and Click View
	  
	  		report = ExtentFactory.getInstance3();
	  		test = report.startTest("Admin Test -->  Create a Proposal");
	  		test.log(LogStatus.INFO, "Admin User Logged in");
	 	
			AdminNavigationLinksElements.ClientsAccountsLinkClick();
			test.log(LogStatus.INFO, "Click on clients Accounts Link");
			 
			ClientAccountsPageElements.ValidatePage();
			ClientAccountsPageElements.SearchQueryFieldFill("UK Test");
			test.log(LogStatus.INFO, "Click on Search Query and Enter UK Test");
			 
			ClientAccountsPageElements.UpdateButtonClink();
			test.log(LogStatus.INFO, "Click on Update Button");
			 
			Thread.sleep(5000);
			ClientAccountsPageElements.ValidateResults("UK Test");
			test.log(LogStatus.INFO, "Search Resusult is Displayed");
			ClientAccountsPageElements.ViewAccount();
		    test.log(LogStatus.INFO, "Click on UK Test Account in search Result");
		    Thread.sleep(1000);
		    sslDashBoardElements.AdminDashboardValidation();
		  	test.log(LogStatus.INFO, "DashBord Page Opened");
			
			//Navigate to Proposals Section 
			sslDashBoardElements.ClickMyProposalsLink();
			Thread.sleep(10000);
			test.log(LogStatus.INFO, "Proposal Page Opened");
			
			//Click on New Proposal
			ProposalsPageElements.ValidatePage();
			ProposalsPageElements.NewProposalButtonClink();
			Thread.sleep(10000);
			
			//Fill in required information
			ProposalsPageElements.ProductTypeFieldSelect("SSL Certificate");
			test.log(LogStatus.INFO, "Select Product Type");
			driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
		
			ProposalsPageElements.ProductFieldSelect("RapidSSL Pro");
			test.log(LogStatus.INFO, "Select Product Name");
			Thread.sleep(10000);
				
			ProposalsPageElements.QuantityFieldClear();
			ProposalsPageElements.QuantityFieldSenkeys("3");
			test.log(LogStatus.INFO, "Enter Quantity ");
			
			ProposalsPageElements.DurationFieldSelect("3 years");
			test.log(LogStatus.INFO, "Select Number of Years");
			Thread.sleep(10000);		
			
			ProposalsPageElements.CommonNameFieldClear();
			ProposalsPageElements.CommonNameFieldSendKeys("ssl247-testing.co.uk");
			test.log(LogStatus.INFO, "Fill in Common Name");
			driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
			
			ProposalsPageElements.CalculatePricesButtonClink();
			test.log(LogStatus.INFO, "Click on Calculate Prices Button");
			Thread.sleep(10000);
			
			//Click Save
			ProposalsPageElements.SaveProposalButtonButtonClink();
			
			
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
									
				test.log(LogStatus.FAIL, "Validation Failed");
				Assert.fail("Exception " + e);

			}

			
			
			//test.log(LogStatus.INFO, "Click on Save Proposal Button");
			//test.log(LogStatus.PASS, "Proposal Created and Saved Successfully");
  } 
  
  @Test (priority = 3,groups = {"Sanity","Sanity_Chrome"})
  public void IssueProposal () throws Exception {
	  
	  test = report.startTest("Admin Test --> Issue a Proposal");
	  test.log(LogStatus.INFO, "Admin User Logged in");
	  
	  AdminNavigationLinksElements.ClientsAccountsLinkClick();
	  test.log(LogStatus.INFO, "Click on clients Accounts Link");
		 
	  ClientAccountsPageElements.ValidatePage();
	  ClientAccountsPageElements.SearchQueryFieldFill("UK Test");
	  test.log(LogStatus.INFO, "Click on Search Query and Enter UK Test");
		 
	  ClientAccountsPageElements.UpdateButtonClink();
	  test.log(LogStatus.INFO, "Click on Update Button");
		 
	  Thread.sleep(1000);
	  ClientAccountsPageElements.ValidateResults("UK Test");
	  test.log(LogStatus.INFO, "Search Resusult is Displayed");
	  ClientAccountsPageElements.ViewAccount();
	  test.log(LogStatus.INFO, "Clicked on UK Test Account in search Result");
	  Thread.sleep(1000);
	  
	try {
	 
	  		sslDashBoardElements.AdminDashboardValidation();
	  		test.log(LogStatus.INFO, "DashBord Page Opened");
	  		sslDashBoardElements.ClickMyProposalsLink();
	  		ProposalsPageElements.ValidatePage();
		  	ProposalsPageElements.UnIssuedTabClink();
		  	ProposalsPageElements.ViewTopResult();
		  	ProposalsPageElements.IssueProposalTabClink();
		  	Thread.sleep(1000);
		  	ProposalsPageElements.ConfirmCheckBoxOneClink();
		  	Thread.sleep(1000);
		  	ProposalsPageElements.ConfirmCheckBoxTwoClink();
		  	Thread.sleep(1000);
		  	ProposalsPageElements.IssueProposalButtonClink();
	  
	  
			String Alertnote = "issued";  
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
  
  
  @Test (priority = 4,groups = {"Sanity","BS_Sanity","Sanity_Chrome"})
  public void Send_Fulfillment_Email() throws Exception {
	  
	  test = report.startTest("Admin Test -->  Send Fullfillement Email");
	    test.log(LogStatus.INFO, "Admin User Logged in");
	  
	  //Navigate to products link
	  	driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
	  	Actions  actions=new Actions(driver);
	  	WebElement ProductsLink=driver.findElement(By.xpath(".//*[@id='mainNavigation']/li[3]/a"));
	  	actions.moveToElement(ProductsLink);
	  	driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
	  	
	  	Thread.sleep(1000);
	  	WebElement CertificatesLink=driver.findElement(By.xpath(".//*[@id='mainNavigation']/li[3]/ul/li[1]/a"));
	    actions.moveToElement(CertificatesLink);
	  	actions.click();
	  	actions.perform();
	  	test.log(LogStatus.INFO, "Opened Search Products Page");
		
	  	//Select Account Name from for field
	  	AdminCertificatesPageElements.ForFieldFieldSelect("Account name");
	  	
		//Select Issued from Status Field
		AdminCertificatesPageElements.StatusFieldSelect("Issued");
		
	    //Enter Account Name into form field and Click Search
		AdminCertificatesPageElements.SearchFieldSendKeys("UK Test");
		driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
		AdminCertificatesPageElements.SearchButtonClick();		
		
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
		
		String AccountName = "UK Test01";
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
		//test.log(LogStatus.INFO, "Selected Test User from drop down list");
		
		driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
		driver.findElement(By.xpath(".//*[@id='CertificateOneOffEmail']")).sendKeys("qa@ssl247.co.uk");
		//test.log(LogStatus.INFO, "Entered Email in email field");
		
		driver.findElement(By.xpath(".//*[@id='sendFulfillmentEmail']/form/div[4]/button")).click();
		test.log(LogStatus.INFO, "Filled In Required information in form and Clicked");
		//test.log(LogStatus.INFO, "Clicked on Send Button");
		
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
		 Thread.sleep(15000);
		 
		 Actions  Mouse=new Actions(driver);
	     WebElement Dropdown=driver.findElement(By.xpath(".//*[@id='DataTables_Table_0']/tbody/tr[1]/td[9]/div/button"));
	     Mouse.click(Dropdown);
	     driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
	     WebElement EyeIcon=driver.findElement(By.xpath(".//*[@id='DataTables_Table_0']/tbody/tr[1]/td[9]/div/ul/li[1]/a"));
	     Mouse.moveToElement(EyeIcon);
	     Mouse.click();
	     Mouse.perform();
	     test.log(LogStatus.INFO, "UK Test Account Found and Opened");
		 
	     /*Click Account End Users Link*/
		 sslDashBoardElements.ClickAccountEndUsersLink();
		 JavascriptExecutor jse = (JavascriptExecutor)driver;
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

		 
		 
		 /*--------Force Email Out to User from test environment------------*/
/*		 
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
		 test.log(LogStatus.INFO, "Navigateed to Outgoing Emails Page");
			
		 String EmailCol = driver.findElement(By.xpath(".//*[@id='mainContainer']/div[6]/div/div/table/tbody/tr[1]/td[2]")).getText();		
		 Assert.assertTrue(EmailCol.contains("qa@ssl247.co.uk"));
		 test.log(LogStatus.PASS, "Email Found in Outgoing Emails");
	*/
		 
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
