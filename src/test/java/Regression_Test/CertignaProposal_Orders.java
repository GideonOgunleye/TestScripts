package Regression_Test;

import java.io.FileInputStream;
import java.util.Properties;
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
import PageFactory.AdminOrdersPage;
import PageFactory.AdminSslDashBoard;
import PageFactory.BillingPage;
import PageFactory.CertificateValidationPage;
import PageFactory.ClientAccountsPage;
import PageFactory.IncompleteCertificatesPage;
import PageFactory.LoginPage;
import PageFactory.NavigationLinks;
import PageFactory.ProposalsPage;
import PageFactory.sslDashBoard;

public class CertignaProposal_Orders extends BrowserStack {
	
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
	AdminOrdersPage AdminOrdersPageElements;
	IncompleteCertificatesPage IncompleteCertificaesPageElements;
	CertificateValidationPage CertificateValidationPageElements;
	
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
		AdminOrdersPageElements = new AdminOrdersPage(driver);
		IncompleteCertificaesPageElements = new IncompleteCertificatesPage(driver);
		CertificateValidationPageElements = new CertificateValidationPage(driver);
	
	
		Thread.sleep(5000);
		
		  report = ExtentFactory.getInstance2();
		  

		
		//Log in as administrator
		LoginPageElements.AdminLogin();
		driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);

		
	}	
	
	@AfterMethod (groups = {"Regression","BS_Regression","Regression_Chrome"}, alwaysRun = true)
	public void User_Logout (ITestResult result) throws Exception {
		
	
	    //Take Screen Shots

		String path =  ScreenShot.Image(driver, "TestSecreenShot-" + result.getMethod().getMethodName());
		String imagePath = test.addScreenCapture(path);
		test.log(LogStatus.INFO, "Test Complete", imagePath);
		
		Thread.sleep(1000);
		
		JavascriptExecutor jse = (JavascriptExecutor)driver;
		jse.executeScript("window.scrollBy(0,-500)", "");
		
		Thread.sleep(1000);
		
		//Logout------------------------------------------------------------------------------------------
	  	try{ 
	  		   Thread.sleep(1000);
	  		   
	  		   if(LoginPageElements.LogoutButtonIsVisible()) {
	  			   
	  			 LoginPageElements.ClickLogoutButton();
		  		 test.log(LogStatus.INFO, "After Method-Client User Logged Out");
		  		 String path2 = ScreenShot.Image(driver, "Logout");
		  		 String imagePath2 = test.addScreenCapture(path2);
		  		 test.log(LogStatus.INFO, imagePath2);
		  		 report.endTest(test);
		  		 report.flush();
	  			   
	  		   }else if(LoginPageElements.AdminLogoutButtonIsVisible()){
	  			   
	  			   	LoginPageElements.ClickAdminLogoutButton();
		  			test.log(LogStatus.INFO, "After Method-Admin User Logged Out");
		  			String path2 = ScreenShot.Image(driver, "Logout");
		  			String imagePath2 = test.addScreenCapture(path2);
		  			test.log(LogStatus.INFO, imagePath2);
		  			report.endTest(test);
		  			report.flush();
	  		   }

	  	}catch (Exception e) {
	  				
	  			test.log(LogStatus.FAIL, "After Method-Logout Failed");
	  			String path2 = ScreenShot.Image(driver, "Logout");
	  			String imagePath2 = test.addScreenCapture(path2);
	  			test.log(LogStatus.INFO, imagePath2);
	  			report.endTest(test);
	  			report.flush();
	  			Assert.fail("Log Out Failed- "+"Exception: " + e);
	  			driver.quit();
	  				
	  	} 
		
	}
	
	
	  @Test (priority = 1, groups = {"Regression","BS_Regression","Regression_Chrome"},dataProviderClass = Test_Data.class, dataProvider="CertignaCertificate_ProposalsOrder_Data")
	  public void CertignaCertificates_Proposals (String ProductType, String Product1, String Quantity, String Duration, String License, String CommonName, String StaffName, String Line1, String Line2, String Line3, String Line4, String Line5, String Line6, String Line7, String Line8, String Line9, String Line10, String Line11, String Line12, String Line13, String Line14, String Line15, String Line16, String Line17) throws Exception {
		  
		  Properties prop = new Properties();
		  FileInputStream fis = new FileInputStream("C://Users//Gideon Okunleye//workspace//AutomationTestScripts//DataDriving.properties");
		  
		  prop.load(fis);
		  
		  test = report.startTest("Admin Test --> Proposals Order Test - " + Product1);
		     
		  test.log(LogStatus.INFO, "Browser Opened and Url Enterl");
		  test.log(LogStatus.INFO, "Logged in as Admin");
		  
		  System.out.println("Started Proposal For:------------------ " + Product1 );
		  
		  AdminNavigationLinksElements.ClientsAccountsLinkClick();
		  driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
		  test.log(LogStatus.INFO, "Click on clients Accounts Link");
		  
		  //ClientAccountsPageElements.ValidatePage();
		  //driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
		  //test.log(LogStatus.INFO, "Click Account Page Validated");
			 
			 
		  ClientAccountsPageElements.SearchQueryFieldFill("FRT");
		  driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
		  test.log(LogStatus.INFO, "Click on Search Query and Enter UK Test");
			 
		  ClientAccountsPageElements.UpdateButtonClink();
		  driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
		  test.log(LogStatus.INFO, "Click on Update Button");
		  
		  JavascriptExecutor jse = (JavascriptExecutor)driver;
		  jse.executeScript("window.scrollBy(0,500)", "");
			 
		  Thread.sleep(5000);
		  
		  ClientAccountsPageElements.ValidateResults("FRTE001");
		  driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
		  test.log(LogStatus.INFO, "Search Resusult is Displayed");
			 
		  ClientAccountsPageElements.ViewAccount();
		  driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
		  test.log(LogStatus.INFO, "Click on UK Test Account in search Result");
		     
		  Thread.sleep(1000);
		  
		  
		  AdminSslDashBoardElements.ProposalsLinkClick();
		  driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
		  test.log(LogStatus.INFO, "Clicked on proposal link");
		  
		  Thread.sleep(2000);
		 
		  try {
			  
				  ProposalsPageElements.NewProposalButton2Clink();
				  driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
				  test.log(LogStatus.INFO, "Clicked on New Proposal Button");
				  
				  jse.executeScript("window.scrollBy(0,500)", "");
				  
				  Thread.sleep(2000);
				  
				//Add First Product-----------------------------------------------------------------------  
				  
				  //Select Product Type
				  ProposalsPageElements.ProductTypeFieldSelect(ProductType);
				  driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
				  test.log(LogStatus.INFO, "Selected Product Type");
				  
				  Thread.sleep(1000);
				  
				  //Select Product 
				  ProposalsPageElements.ProductFieldSelect(Product1);
				  driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
				  test.log(LogStatus.INFO, "Selected Product");
				  
				  Thread.sleep(1000);
				
				try {  
					
				  //Select Quantity
				  ProposalsPageElements.QuantityFieldClear();
				  ProposalsPageElements.QuantityFieldSenkeys(Quantity);
				  driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
				  test.log(LogStatus.INFO, "Selected Quantity");
				  
		  		}catch (Exception p) {
				
		  			String path = ScreenShot.Image(driver, "Proposal");
		  			String imagePath = test.addScreenCapture(path);
		  			test.log(LogStatus.INFO, imagePath);
		  			test.log(LogStatus.INFO, "Duration not Selected");
		  			//Assert.fail("Exception " + e);
		  		}
				  
				  
				  Thread.sleep(1000);
				  
				//Select Duration----------------------------------------
				  try {
					
					  ProposalsPageElements.DurationFieldSelect(Duration);
					  driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
					  test.log(LogStatus.INFO, "Selected Duration");
				  
				  }catch (Exception p) {
						
					  String path = ScreenShot.Image(driver, "Proposal");
					  String imagePath = test.addScreenCapture(path);
					  test.log(LogStatus.INFO, imagePath);
					  test.log(LogStatus.INFO, "Duration not Selected");
					  //Assert.fail("Exception " + e);

					} 

				  Thread.sleep(1000);
				  
				  //Fill Common Name Field----------------------------------
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
				  
				  Thread.sleep(1000);
				  jse.executeScript("window.scrollBy(0,500)", "");
				  
				  test.log(LogStatus.PASS, "Proposal Created");
				  String path = ScreenShot.Image(driver, "Proposal");
				  String imagePath = test.addScreenCapture(path);
				  test.log(LogStatus.INFO, imagePath);
				  
				  Thread.sleep(1000);
					
				  //Click Save 
				
				  ProposalsPageElements.SaveProposalButtonClink();
				  driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
				  test.log(LogStatus.INFO, "Click on Save Proposal Button");
				  
			   	  jse.executeScript("window.scrollBy(0,250)", "");
			  	  Thread.sleep(1000);
				 
			  	  
			  	  //Issue Proposal------------------------------------------------------------------
				  ProposalsPageElements.IssueProposalTabFRClink();
			  	  driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
			  	  test.log(LogStatus.INFO, "Clicked on Issue Proposal Tab");
			  	  
			   	  jse.executeScript("window.scrollBy(0,250)", "");
				  	
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
			  	  
			  	  jse.executeScript("window.scrollBy(0,500)", "");
			  	  Thread.sleep(1000);
			  	  
			  	  //Convert Proposal To Invoice------------------------------------------------------------------
			  	  
			  	  ProposalsPageElements.ConvertToInvoiceButtonClink();
			  	  driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
			  	  test.log(LogStatus.INFO, "Clicked Covert to Invoice Button");
			  	  

			    
		   }catch (Exception e) {
				
			   	String path = ScreenShot.Image(driver, "Proposal");
				String imagePath = test.addScreenCapture(path);
				test.log(LogStatus.INFO, imagePath);
				test.log(LogStatus.FAIL, "Test Failed");
				driver.navigate().refresh();
				//Assert.fail( Product1 +" - Exception: "+ e);
				
			}
			  	  

			//Handle Alart-------------------------------------------------------------------------------------  	
			  	try {
			  		
				  	  Alert alert = driver.switchTo().alert();
				  	  alert.accept();
				  	  test.log(LogStatus.INFO, "Clicked on Alert");
				  	  
				  	  jse.executeScript("window.scrollBy(0,500)", "");
			        
			    } catch (Exception e) {
			    	
			    	System.out.println("Alert Not Handled");
			    }		
			
			//View Ordered Certificate--------------------------------------------------------
			
			
			try {
				
				Thread.sleep(1000);
				
				AdminSslDashBoardElements.OrdersLinkFRClick();
				driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
			  	test.log(LogStatus.INFO, "Clicked on Orders Link");
			  	
			  	AdminOrdersPageElements.SavedTabFRClick();
			  	driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
			  	test.log(LogStatus.INFO, "Clicked on Saved Tab");
			  	
				String path = ScreenShot.Image(driver, "Proposal");
				String imagePath = test.addScreenCapture(path);
				test.log(LogStatus.INFO, imagePath);
  	
			  	
			}catch (Exception e) {
				
				String path = ScreenShot.Image(driver, "Proposal");
				String imagePath = test.addScreenCapture(path);
				test.log(LogStatus.INFO, imagePath);
				test.log(LogStatus.INFO, "Invoice Not Issued");
				System.out.println("View Ordered Cert Exception:-  " + e);
			}
			
			
			
		     //Admin User Log Out------------------------------------------------------------------
			
			 try{ 
				 
				 if(LoginPageElements.AdminLogoutButtonIsVisible()) {
		  			   
		  			 LoginPageElements.ClickAdminLogoutButton();
			  		 test.log(LogStatus.PASS, "Admin-Logout Logged Out");
			  		 String path2 = ScreenShot.Image(driver, "Logout");
			  		 String imagePath2 = test.addScreenCapture(path2);
			  		 test.log(LogStatus.INFO, imagePath2);
					 
				 }else {
					 
					 test.log(LogStatus.FAIL, "Admin-Logout not visible");
					 String path2 = ScreenShot.Image(driver, "Logout");
					 String imagePath2 = test.addScreenCapture(path2);
					 test.log(LogStatus.INFO, imagePath2);
					 report.endTest(test);
					 report.flush();
					 Assert.fail("Log Out not visible");
					 driver.quit();
				 }
		
			 }catch (Exception e) {
					
					test.log(LogStatus.FAIL, "Admin-Logout Failed");
					String path2 = ScreenShot.Image(driver, "Logout");
					String imagePath2 = test.addScreenCapture(path2);
					test.log(LogStatus.INFO, imagePath2);
					report.endTest(test);
					report.flush();
					Assert.fail("Log Out Failed- "+"Exception: " + e);
					driver.quit();
					
				} 
			
			
			
			 
			//Client Login---------------------------------------------------------------------
			 
			try {
				  
			/*	  LoginPageElements.LoadLoginPage();
				  Thread.sleep(1000);
				  test.log(LogStatus.INFO, "Browser Opened and Url Entered");
				  test.log(LogStatus.INFO, "Login Page Loaded");
				  
				  LoginPageElements.ClickLoginLink();
				  driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
				  test.log(LogStatus.INFO, "Clicked Login Link");
				*/  
				
				  LoginPageElements.EnterUserName("qa@ssl247.fr");
				  driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
				  test.log(LogStatus.INFO, "Entereed UserName");
				  
				  LoginPageElements.EnterPassword("Test1234");
				  driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
				  test.log(LogStatus.INFO, "Entered Password");
				  
				  LoginPageElements.ClickLoginButton();
				  driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
				  test.log(LogStatus.INFO, "Clicked Login Button");
				  
				  test.log(LogStatus.PASS, "Client Logged In Successfully");
				  String path2 = ScreenShot.Image(driver, "Proposal");
				  String imagePath2 = test.addScreenCapture(path2);
				  test.log(LogStatus.INFO, imagePath2);
			  
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
			 
			 
			 Thread.sleep(2000);
			 
		//Validate Certificate-------------------------------------------------------------------------	 
			
			sslDashBoardElements.MysslCertificatessLinkFRClick();
			driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
			test.log(LogStatus.INFO, "Clicked on My SSL Link");
			    
			sslDashBoardElements.IncompleteLinkFRClick();
		    driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
			test.log(LogStatus.INFO, "Clicked on Issued Link");	
			
			IncompleteCertificaesPageElements.Column1EditButtonClick();
		    driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
			test.log(LogStatus.INFO, "Clicked to view certificate on First Row");
			
			test.log(LogStatus.PASS, "Saved Order Found");
			String path = ScreenShot.Image(driver, "Proposal");
			String imagePath = test.addScreenCapture(path);
			test.log(LogStatus.INFO, imagePath);
				
		//Certificate Details Tab-------------------------------------------------------------------------		
	try {	
			CertificateValidationPageElements.CertificatesDetailsTabFRClick();
		    driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
			test.log(LogStatus.INFO, "Clicked on Certificate Details Tab");	
			
			Thread.sleep(2000);
		  	jse.executeScript("window.scrollBy(0,500)", "");
			
			CertificateValidationPageElements.CsrFieldClick();;
		    driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
			test.log(LogStatus.INFO, "Clicked on CSR Field");	
		/*	
			CertificateValidationPageElements.LoadSsl247_TestCsR();
		    driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
			test.log(LogStatus.INFO, "Filled In CSR");	
		*/	
			CertificateValidationPageElements.CsrFieldFill(prop.getProperty(Line1));
			CertificateValidationPageElements.HitEnterKey();
			CertificateValidationPageElements.CsrFieldFill(prop.getProperty(Line2));
			CertificateValidationPageElements.HitEnterKey();
			CertificateValidationPageElements.CsrFieldFill(prop.getProperty(Line3));
			CertificateValidationPageElements.HitEnterKey();;
			CertificateValidationPageElements.CsrFieldFill(prop.getProperty(Line4));
			CertificateValidationPageElements.HitEnterKey();
			CertificateValidationPageElements.CsrFieldFill(prop.getProperty(Line5));
			CertificateValidationPageElements.HitEnterKey();
			CertificateValidationPageElements.CsrFieldFill(prop.getProperty(Line6));
			CertificateValidationPageElements.HitEnterKey();
			CertificateValidationPageElements.CsrFieldFill(prop.getProperty(Line7));
			CertificateValidationPageElements.HitEnterKey();
			CertificateValidationPageElements.CsrFieldFill(prop.getProperty(Line8));
			CertificateValidationPageElements.HitEnterKey();
			CertificateValidationPageElements.CsrFieldFill(prop.getProperty(Line9));
			CertificateValidationPageElements.HitEnterKey();
			CertificateValidationPageElements.CsrFieldFill(prop.getProperty(Line10));
			CertificateValidationPageElements.HitEnterKey();
			CertificateValidationPageElements.CsrFieldFill(prop.getProperty(Line11));
			CertificateValidationPageElements.HitEnterKey();
			CertificateValidationPageElements.CsrFieldFill(prop.getProperty(Line12));
			CertificateValidationPageElements.HitEnterKey();
			CertificateValidationPageElements.CsrFieldFill(prop.getProperty(Line13));
			CertificateValidationPageElements.HitEnterKey();
			CertificateValidationPageElements.CsrFieldFill(prop.getProperty(Line14));
			CertificateValidationPageElements.HitEnterKey();
			CertificateValidationPageElements.CsrFieldFill(prop.getProperty(Line15));
			CertificateValidationPageElements.HitEnterKey();
			CertificateValidationPageElements.CsrFieldFill(prop.getProperty(Line16));
			CertificateValidationPageElements.HitEnterKey();
			CertificateValidationPageElements.CsrFieldFill(prop.getProperty(Line17));
			CertificateValidationPageElements.HitEnterKey();
			
			test.log(LogStatus.PASS, "Certificate Details Tab Filled");
			String path2 = ScreenShot.Image(driver, "Proposal");
			String imagePath2 = test.addScreenCapture(path2);
			test.log(LogStatus.INFO, imagePath2);
			
	  }catch (Exception e) {
			
			test.log(LogStatus.FAIL, "Error iN Certails Tab");
			System.out.println("Element Not Found");
			String path2 = ScreenShot.Image(driver, "Element");
			String imagePath2 = test.addScreenCapture(path2);
			test.log(LogStatus.INFO, imagePath2);
			report.endTest(test);
			report.flush();
			Assert.fail("Exception " + e);
		}	
			
			Thread.sleep(1000);
		  	jse.executeScript("window.scrollBy(0,-500)", "");
		  	
		 //Admin Tab----------------------------------------------------------
		 try {  	
			 
		  	CertificateValidationPageElements.AdminTabClick();
		    driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
			test.log(LogStatus.INFO, "Clicked Admin Tab");	
			
			CertificateValidationPageElements.AdminNameFieldSelect("Gideon Ogunleye");
		    driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
			test.log(LogStatus.INFO, "Selected Admin contact name");	
			
			CertificateValidationPageElements.AdminOrganisationFieldFill("SSL247  SARL");
		    driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
			test.log(LogStatus.INFO, "Filled Admin Organisation Name");
			
			Thread.sleep(1000);
		  	jse.executeScript("window.scrollBy(0,500)", "");
		  	
		  	CertificateValidationPageElements.AdminFavouriteColourQuestionFieldFill("Blue");
		    driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
			test.log(LogStatus.INFO, "Filled Admin Questtion 1");
			
			CertificateValidationPageElements.AdminFavouriteBookQuestionFieldFill("Oliver Twist");
		    driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
			test.log(LogStatus.INFO, "Filled Admin Question 2");
			
			CertificateValidationPageElements.AdminFavouriteVegetableQuestionFieldFill("Carrot");
		    driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
			test.log(LogStatus.INFO, "Filled Admin Question 3");
			
			CertificateValidationPageElements.AdminFavouriteSportQuestionFieldFill("Football");
		    driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
			test.log(LogStatus.INFO, "Filled Admin Question 4");
			
			CertificateValidationPageElements.AdminStreetNameQuestionFieldFill("London");
		    driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
			test.log(LogStatus.INFO, "Filled Admin Question 5");
			
			test.log(LogStatus.PASS, "Admin Tab Filled");
			String path2 = ScreenShot.Image(driver, "Proposal");
			String imagePath2 = test.addScreenCapture(path2);
			test.log(LogStatus.INFO, imagePath2);
			
		  }catch (Exception e) {
				
				test.log(LogStatus.FAIL, "Error In Admin Tab");
				System.out.println("Element Not Found");
				String path2 = ScreenShot.Image(driver, "Element");
				String imagePath2 = test.addScreenCapture(path2);
				test.log(LogStatus.INFO, imagePath2);
				report.endTest(test);
				report.flush();
				Assert.fail("Exception " + e);
			}	
			
			
			Thread.sleep(1000);
		  	jse.executeScript("window.scrollBy(0,-900)", "");
		  	
		  //Technical Tab--------------------------------------------------------------------------------	
		  try {
			  
			  CertificateValidationPageElements.TechnicalTabClick();
			  driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
			  test.log(LogStatus.INFO, "Click on Technical Tab");
			  
			  CertificateValidationPageElements.TechnicalNameFieldSelect("Gideon Ogunleye");
			  driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
			  test.log(LogStatus.INFO, "Selected Technical Contact");
			  
			  CertificateValidationPageElements.TechnicalOrganisationFieldFill("SSL247 SARL");
			  driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
			  test.log(LogStatus.INFO, "Filled Tech Organisation Field");
			  
			  Thread.sleep(1000);
			  jse.executeScript("window.scrollBy(0,500)", "");
			  	
			  CertificateValidationPageElements.TechFavouriteColourQuestionFieldFill("Blue");
			  driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
			  test.log(LogStatus.INFO, "Filled Tech Questtion 1");
				
			  CertificateValidationPageElements.TechFavouriteBookQuestionFieldFill("Oliver Twist");
			  driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
			  test.log(LogStatus.INFO, "Filled Tech Question 2");
				
		      CertificateValidationPageElements.TechFavouriteVegetableQuestionFieldFill("Carrot");
			  driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
			  test.log(LogStatus.INFO, "Filled Tech Question 3");
				
			  CertificateValidationPageElements.TechFavouriteSportQuestionFieldFill("Football");
			  driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
			  test.log(LogStatus.INFO, "Filled Tech Question 4");
				
			  CertificateValidationPageElements.TechStreetNameQuestionFieldFill("London");
			  driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
			  test.log(LogStatus.INFO, "Filled Tech Question 5");
			  
			  test.log(LogStatus.PASS, "Tech Tab Filled");
			  String path2 = ScreenShot.Image(driver, "Proposal");
			  String imagePath2 = test.addScreenCapture(path2);
			  test.log(LogStatus.INFO, imagePath2);
			  
		  }catch (Exception e) {
				
				test.log(LogStatus.FAIL, "Error In Technical Tab");
				System.out.println("Element Not Found");
				String path2 = ScreenShot.Image(driver, "Element");
				String imagePath2 = test.addScreenCapture(path2);
				test.log(LogStatus.INFO, imagePath2);
				report.endTest(test);
				report.flush();
				Assert.fail("Exception " + e);
			}
		  
		Thread.sleep(1000);
		jse.executeScript("window.scrollBy(0,-900)", "");
		

		//Organisation Tab-------------------------------------------------------------------------------------------
		try {
			
			CertificateValidationPageElements.OrganisationTabClick();	
			driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
			test.log(LogStatus.INFO, "Clicked Organisation Tab");
			
			CertificateValidationPageElements.OrganisationLegalNameFieldFill("SSL247 SARL");	
			driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
			test.log(LogStatus.INFO, "Filled Organisation Legal Name Field");
			
			CertificateValidationPageElements.OrganisationCategoryFieldSelect("Registered company or corporation");
			driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
			test.log(LogStatus.INFO, "Selected Organisation Category");
			
			CertificateValidationPageElements.OrganisationRegistrationNumberFieldFill("05802692");
			driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
			test.log(LogStatus.INFO, "Filled Organisation Rgistration Number");
			
			test.log(LogStatus.PASS, "Organisation Tab Filled");
			String path2 = ScreenShot.Image(driver, "Proposal");
			String imagePath2 = test.addScreenCapture(path2);
			test.log(LogStatus.INFO, imagePath2);
			
			
		}catch (Exception e) {
			
			test.log(LogStatus.FAIL, "Error In Organisation Tab");
			System.out.println("Element Not Found");
			String path2 = ScreenShot.Image(driver, "Element");
			String imagePath2 = test.addScreenCapture(path2);
			test.log(LogStatus.INFO, imagePath2);
			report.endTest(test);
			report.flush();
			Assert.fail("Exception " + e);
		}
		
		Thread.sleep(1000);
	  	jse.executeScript("window.scrollBy(0,-500)", "");
	  	
	  	
	  	//Director Tab-------------------------------------------------------------------------------------------------
	  	try {
	  		
	  		CertificateValidationPageElements.DirectorTabClick();
			driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
			test.log(LogStatus.INFO, "Clicked Director Tab");
	  		
	  		
	  		CertificateValidationPageElements.DirectorContactFieldSelect("Gideon Ogunleye");
			driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
			test.log(LogStatus.INFO, "Selected Director Contact Name");
	  		
	  		CertificateValidationPageElements.DirectorOrganisationFieldFill("SSL247 SARL");
			driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
			test.log(LogStatus.INFO, "Filled Director Organisation Name Field");
	  		
	  		
			Thread.sleep(1000);
			jse.executeScript("window.scrollBy(0,500)", "");
	  		
	  		
	  		CertificateValidationPageElements.DirectorFavouriteColourQuestionFieldFill("Blue");
			driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
			test.log(LogStatus.INFO, "Filled Director Tab Questtion 1");
	  		
	  		CertificateValidationPageElements.DirectorFavouriteVegetableQuestionFieldFill("Oliver Twist");
			driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
			test.log(LogStatus.INFO, "Filled Director Tab Questtion 2");
	  		
	  		CertificateValidationPageElements.DirectorFavouriteBookQuestionFieldFill("Carrot");
			driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
			test.log(LogStatus.INFO, "Filled Director Tab Questtion 3");
	  		
	  		CertificateValidationPageElements.DirectorFavouriteSportQuestionFieldFill("Football");
			driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
			test.log(LogStatus.INFO, "Filled Director Tab Questtion 4");
	  		
	  		CertificateValidationPageElements.DirectorStreetNameQuestionFieldFill("London");
			driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
			test.log(LogStatus.INFO, "Filled Director Tab Questtion 1");
			
			test.log(LogStatus.PASS, "Director Tab Filled");
			String path2 = ScreenShot.Image(driver, "Proposal");
			String imagePath2 = test.addScreenCapture(path2);
			test.log(LogStatus.INFO, imagePath2);
	  		
	  		
	  	}catch (Exception e) {
			
			test.log(LogStatus.FAIL, "Error In Director Tab");
			System.out.println("Element Not Found");
			String path2 = ScreenShot.Image(driver, "Element");
			String imagePath2 = test.addScreenCapture(path2);
			test.log(LogStatus.INFO, imagePath2);
			report.endTest(test);
			report.flush();
			Assert.fail("Exception " + e);
		}
	  	
		Thread.sleep(1000);
	  	jse.executeScript("window.scrollBy(0,-900)", "");
	  	
	  	CertificateValidationPageElements.SubmitCertForIssuanceButtonClick();
	  	driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
		test.log(LogStatus.INFO, "Clicked Submit Certificate For Issuance Button");

		//Validate Alert-----------------------------------------------------------------------------
		try {
			
			String Alertnote = "The certificate has been saved and is pending submission with the CA";
			AlertBoxElements.AlertWait();
			    	
			if (AlertBoxElements.VerifyAlert(Alertnote)) {
						
			    	test.log(LogStatus.PASS, "Validation Complete");
			    	Assert.assertTrue(AlertBoxElements.VerifyAlert(Alertnote));
			    	System.out.println("Order Cert Completed!");
			    	
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

  
}
