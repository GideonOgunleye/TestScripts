package Sanity_Test;

import org.testng.annotations.Test;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import BaseUtilities.AlertBox;
import BaseUtilities.BrowserStack;
import BaseUtilities.Chrome;
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
import Regression_Test.Test_Data;

import org.testng.annotations.BeforeTest;
//import org.json.simple.parser.JSONParser;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
//import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
//import org.testng.annotations.BeforeMethod;

public class Registered_User extends BrowserStack  {
	
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
	
	@BeforeMethod (groups = {"Sanity","Smoke","BS_Smoke","BS_Sanity","BS_Sanity","BS_DailySanity","Smoke_Firefox","Smoke_Chrome","Sanity_Chrome"})
	public void Login () throws Exception {
		
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

	
	@AfterMethod (groups = {"Sanity","Smoke","BS_Smoke","BS_Sanity","BS_DailySanity", "BS_Sanity","Smoke_Firefox","Smoke_Chrome","Sanity_Chrome"}, alwaysRun = true)
	public void Logout (ITestResult result) throws Exception {

	    //Take Screen Shots
				
	  	String path =  ScreenShot.Image(driver, "TestSecreenShot-" + result.getMethod().getMethodName());
		String imagePath = test.addScreenCapture(path);
		test.log(LogStatus.INFO, "Test Complete", imagePath);
		
		driver.navigate().refresh();
		
		Thread.sleep(5000);
		
		try{
			
			LoginPageElements.ClickLogoutButton();
			driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
			test.log(LogStatus.INFO, "User Logged Out");
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
		
		//return destination;
		
	}
	

	
	@Test (priority = 0, groups = {"Smoke","BS_Smoke","BS_Sanity","Smoke_Firefox","Smoke_Chrome"},dataProviderClass =Test_DataSanity.class, dataProvider="LoginUser")
	  public void LogIn_Validation (String Username, String Password, String Credentials) throws Exception{
		 
		  report = ExtentFactory.getInstance3();
		
		 // test = report.startTest("<---------------------------Test Suite Start----------------------------------->");
		  test = report.startTest("Registered User Test --> User Login- " + Credentials);
		  
		  try{
				
				LoginPageElements.ClickLogoutButton();
				driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
				test.log(LogStatus.INFO, "User Logged Out");
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
		  
		  LoginPageElements.LoadLoginPage();
		  Thread.sleep(1000);
		  test.log(LogStatus.INFO, "Browser Opened and Url Entered");
		  test.log(LogStatus.INFO, "Login Page Loaded");
		  
		  LoginPageElements.ClickLoginLink();
		  driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
		  test.log(LogStatus.INFO, "Clicked Login Link");
		  
		  LoginPageElements.EnterUserName(Username);
		  driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
		  test.log(LogStatus.INFO, "Entereed UserName");
		  
		  LoginPageElements.EnterPassword(Password);
		  driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
		  test.log(LogStatus.INFO, "Entered Password");
		  
		  
		  LoginPageElements.ClickLoginButton();
		  driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
		  test.log(LogStatus.INFO, "Clicked Login Link");
		  
		  
		  try {
				
			 
			 if(driver.getTitle().contains("Slicket Backlog")){
				 
				 System.out.println("Admin User Logged In");
			 	 test.log(LogStatus.PASS, "Admin User Logged In");
			 
			 }else {
				 
				 System.out.println("Dashboard Page NOT Opened");
			 	 test.log(LogStatus.FAIL, "Dashboard Page NOT Opened");
			 	 
			 }
			  
			}catch(Exception e) {
				System.out.println("Exception:- "+ e);
				test.log(LogStatus.FAIL, "Validation Failed");
				//Assert.fail("Exception " + e);
			
				}	
			
		  
	  }

	@Test (priority = 1, groups = {"Sanity","BS_Sanity","Sanity_Chrome"})
	  public void Order_RapidSSL() throws Exception {
		 

		System.out.println("Order Cert Started!");
		
		test = report.startTest("Registered User Test --> Order_RapidSSL");
	    test.log(LogStatus.INFO, "User Logged in");
	    
	    Thread.sleep(1000);
		
	    //Navigate to product page//
	
	    //Click to Order RapidSSL Product
		sslDashBoardElements.ClickMyProductsLink();
		Thread.sleep(15000);
		driver.findElement(By.xpath(".//*[@id='SSLCertificate']/table/tbody/tr[16]/td[3]/a")).click();
		test.log(LogStatus.INFO, "Product Page Opened");
		
		//Check Domain Name
		driver.findElement(By.name("data[Basket][common_name]")).sendKeys("ssl247.co.uk");
		driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
		driver.findElement(By.id("check-cn-btn")).click();
		Thread.sleep(10000);
		driver.findElement(By.xpath(".//*[@id='BasketAddCertificateForm']/div[12]/input[1]")).click();
				
		//Choose 3year Duration Option
		driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
		driver.findElement(By.id("BasketYears3")).click();
				
		//Select Apache 2 Server and Add to basket
		driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
		WebElement Servertype = driver.findElement(By.xpath(".//*[@id='BasketServerType']"));
		Select Type = new Select(Servertype);
		Type.selectByVisibleText("Apache 2");
		driver.findElement(By.id("addCertificateToBasket")).click();
		Thread.sleep(10000);
		test.log(LogStatus.INFO, "Rapid SSL Pro Added To Basket");
				
		//Confirm Order Details
		driver.findElement(By.id("checkoutLink")).click();
		driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
		test.log(LogStatus.INFO, "Clicked Checkout Link");
		
		//Fill In Billing Retails
		System.out.println("Start Billing Page");
		
		BillingPageElements.FillFirstname("Quality");
		driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
		test.log(LogStatus.INFO, "Filled First Name");
		
		BillingPageElements.FillLastname("Assurance Tester");
		driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
		test.log(LogStatus.INFO, "Filled Last Name");
		
		BillingPageElements.FillPhoneNumber("0203MMM7610541");
		driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
		test.log(LogStatus.INFO, "Filled Phone Number");
		
		BillingPageElements.FillEmail("qa@ssl247.co.uk");
		driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
		test.log(LogStatus.INFO, "Filled Email");
		
		BillingPageElements.FillAddress1("63 Lisson St, Marylebone");
		driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
		test.log(LogStatus.INFO, "Filled Address 1");
		
		BillingPageElements.FillCity("London");
		driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
		test.log(LogStatus.INFO, "Filled City");
		
		BillingPageElements.SelectCountry("United Kingdom");
		driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
		test.log(LogStatus.INFO, "Selected Country");
		
		BillingPageElements.FillPostcode("NW1 5DD");
		driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
		test.log(LogStatus.INFO, "Filled Postcode");
		
		//Confirm input
		BillingPageElements.ClickConfirmButton();
		driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
		test.log(LogStatus.INFO, "Clicked Confirm Button");
		
		try {	
			/*----Complete Order----*/
			WebDriverWait wait = new WebDriverWait(driver, 50);	
			WebElement Button;
			Button = wait.until(ExpectedConditions.visibilityOfElementLocated (By.xpath(".//*[@class='btn btn-success btn-small']")));
			Button.click();
			driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
			test.log(LogStatus.INFO, "Clicked Click Complete Button");
	
			
			CsrElements.LoadCsR();
			driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
			test.log(LogStatus.INFO, "Entered CSR");
			
			CsrElements.ClickDecoder();
			driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
			test.log(LogStatus.INFO, "Clicked Decoder Button");
			
			Thread.sleep(10000);
			
			CsrElements.ClickDecoderPopUp();
			driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
			test.log(LogStatus.INFO, "Clicked Decoder Pop Up");
			
			Thread.sleep(10000);
				
			System.out.println("Sleep Over");
			
			JavascriptExecutor jse = (JavascriptExecutor)driver;
			jse.executeScript("window.scrollBy(0,-500)", "");
			
			Thread.sleep(5000);
			
			
			/*-----Fillm in Admin Tab-----------------------*/
			WebElement Admintab = driver.findElement (By.xpath(".//*[@class='tabbable v-margin5']/ul/li[2]/a"));
			Admintab.click();
			driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
			test.log(LogStatus.INFO, "Clicked Admin Tab");
		
		    System.out.println("Admin Tab Clicked");
		   	
			WebElement Organization = driver.findElement(By.id("CertificateAdminOrganisation"));
			Organization.clear();
			Organization.sendKeys("SSL247 Ltd");
			driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
			test.log(LogStatus.INFO, "Filled Organisation Field");
			
			WebElement Title = driver.findElement(By.id("CertificateAdminTitle"));
			Select Initials = new Select(Title);
			Initials.selectByVisibleText("Dr");
			driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
			test.log(LogStatus.INFO, "Seleted Title Field");
			
			WebElement Firstname = driver.findElement(By.id("CertificateAdminFirstname"));
			Firstname.sendKeys("Gideon");
			driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
			test.log(LogStatus.INFO, "Filled Admin First Name");
			
			WebElement Lastname = driver.findElement(By.id("CertificateAdminLastname"));
			Lastname.sendKeys("Ogunleye");
			driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
			test.log(LogStatus.INFO, "Filled Admin Last Name");
			
			WebElement Email = driver.findElement(By.id("CertificateAdminEmail"));
			Email.sendKeys("qa@ssl247.co.uk");
			driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
			test.log(LogStatus.INFO, "Filled Admin Email");
			
			WebElement Phone = driver.findElement(By.id("CertificateAdminPhone"));
			Phone.sendKeys("02037610541");
			driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
			test.log(LogStatus.INFO, "Fill Admin Phone Number");
			
			driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
			
			/*-----Fill in Tech Tab-----------------------------*/
			WebElement Techtab = driver.findElement (By.xpath(".//*[@class='tabbable v-margin5']/ul/li[3]/a"));
			Techtab.click();
			driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
			test.log(LogStatus.INFO, "Clicked Tech Tab");
			
			WebElement TechOrganization = driver.findElement(By.id("CertificateTechOrganisation"));
			TechOrganization.clear();
			TechOrganization.sendKeys("SSL247 Ltd");
			driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
			test.log(LogStatus.INFO, "Filled Tech Organization");
			
			WebElement TechTitle = driver.findElement(By.id("CertificateTechTitle"));
			Select TechInitials = new Select(TechTitle);
			TechInitials.selectByVisibleText("Dr");
			driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
			test.log(LogStatus.INFO, "Selected Tech Title Field");
			
			WebElement TechFirstname = driver.findElement(By.id("CertificateTechFirstname"));
			TechFirstname.clear();
			TechFirstname.sendKeys("Gideon");
			driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
			test.log(LogStatus.INFO, "Filled Tech First Name");
			
			WebElement TechLastname = driver.findElement(By.id("CertificateTechLastname"));
			TechLastname.clear();
			TechLastname.sendKeys("Ogunleye");
			driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
			test.log(LogStatus.INFO, "Filled Tech Last Name");
			
			WebElement TechEmail = driver.findElement(By.id("CertificateTechEmail"));
			TechEmail.clear();
			TechEmail.sendKeys("qa@ssl247.co.uk");
			driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
			test.log(LogStatus.INFO, "Filled Tech Email");
			
			WebElement TechPhone = driver.findElement(By.id("CertificateTechPhone"));
			TechPhone.clear();
			TechPhone.sendKeys("02037610541");
			driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
			test.log(LogStatus.INFO, "Filled Tech Phone Number");
			
			driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
			
			/*-----Click on Submit Button--------*/
			WebElement Submit = driver.findElement(By.xpath(".//*[@class='form-actions v-margin5 text-right']/button"));
			Submit.click();
			driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
			test.log(LogStatus.INFO, "Clicked Submit button");
		
		}catch (Exception e) {
			
			test.log(LogStatus.FAIL, "Validation Failed");
			String path = ScreenShot.Image(driver, "TestScreenshot");
			String imagePath = test.addScreenCapture(path);;
			test.log(LogStatus.INFO, imagePath);
			
			Assert.fail("Exception " + e);

		}

		//Validate Alert
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
	
	@Test (priority = 2, groups = {"Sanity","BS_Sanity","Sanity_Chrome"},dataProviderClass =Test_DataSanity.class, dataProvider="CreateUser")
	  public void Create_User(String Firstname, String Lastname, String Email, String PhoneNumber, String Address, String State, String Postcode, String CountryNm) throws Exception {
		 

		System.out.println("Create User Started!");
		test = report.startTest("Registered User Test --> Create User" + Email);
	    test.log(LogStatus.INFO, "User Logged in");
		
		//1-Navigate and click on My Users
		sslDashBoardElements.ClickMyUsersLink();
		test.log(LogStatus.INFO, "My End Users Page Opened");
				
		//2-Navigate and Click on New Users
		Thread.sleep(5000);
		driver.findElement(By.linkText("New user")).click();
		test.log(LogStatus.INFO, "New User Form Opened");
		
		//3-Fill In Form With Required Information
		Thread.sleep(5000);
		WebElement UserRole = driver.findElement(By.xpath(".//*[@id='UserRole']"));
		Select Role = new Select(UserRole);
		Role.selectByValue("1");
		WebElement AccessLevel = driver.findElement(By.xpath(".//*[@id='UserAccessLevel']"));
		Select Level = new Select(AccessLevel);
		Level.selectByVisibleText("Standard User");
		driver.findElement(By.name("data[User][firstname]")).sendKeys(Firstname);
		driver.findElement(By.name("data[User][lastname]")).sendKeys(Lastname);
		driver.findElement(By.name("data[User][email]")).sendKeys(Email);
		driver.findElement(By.name("data[User][phone]")).sendKeys(PhoneNumber);
		driver.findElement(By.name("data[User][address_1]")).clear();
		driver.findElement(By.name("data[User][address_1]")).sendKeys(Address);
		driver.findElement(By.name("data[User][city]")).clear();
		driver.findElement(By.name("data[User][city]")).sendKeys(State);
		driver.findElement(By.name("data[User][postcode]")).clear();
		driver.findElement(By.name("data[User][postcode]")).sendKeys(Postcode);
		WebElement Country = driver.findElement(By.xpath(".//*[@id='UserCountry']"));
		Select CountryName = new Select(Country);
		CountryName.selectByVisibleText(CountryNm);
		
		
		JavascriptExecutor jse = (JavascriptExecutor)driver;
		jse.executeScript("window.scrollBy(0,-500)", "");
		
		Thread.sleep(1000);
		
		driver.findElement(By.xpath(".//*[@id='UserMysslAddForm']/h2/button")).click();
		
		test.log(LogStatus.PASS, "New User Form Filled and Saved");
		
		System.out.println("Create User Completed!");
		
	}   
	
	@Test (priority = 3, groups = {"Sanity","BS_Sanity","Sanity_Chrome"}) 
	  public void Edit_User () throws Exception {
		

		System.out.println("Edit User Started!");
		
		test = report.startTest("Registered User Test --> Edit Users");
	    test.log(LogStatus.INFO, "User Logged in");
	    
		//Navigate to User Profiles
		sslDashBoardElements.ClickMyUsersLink();
		driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
	    test.log(LogStatus.INFO, "Clicked My Users Link");
		
		//Thread.sleep(15000);
		//driver.findElement(By.xpath(".//*[@id='mainContainer']/div[4]/div[1]/ul[1]/li[21]/a")).click();
		//driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
		//test.log(LogStatus.INFO, "User Profiles Page Opened");
		
		//Edit User Profile
		Thread.sleep(15000);
		
		driver.findElement(By.xpath(".//*[@id='mainContainer']/div[4]/div[2]/div[2]/div[3]/div/address/div/a[1]")).click();
		driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
	    test.log(LogStatus.INFO, "Clicked Edit Button for Tester");
		Thread.sleep(10000);
		
		WebElement address = driver.findElement(By.xpath(".//*[@id='UserRole']"));
		Select Role = new Select(address);
		Role.selectByIndex(0);
		
		driver.findElement(By.name("data[User][firstname]")).clear();
		driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
	    test.log(LogStatus.INFO, "Cleared First Name Field");
	    
		driver.findElement(By.name("data[User][firstname]")).sendKeys("Gideon");
		driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
	    test.log(LogStatus.INFO, "Entered First Name");
	    
		driver.findElement(By.name("data[User][lastname]")).clear();
		driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
	    test.log(LogStatus.INFO, "Cleared Last Name Field");
		
		driver.findElement(By.name("data[User][lastname]")).sendKeys("Ogunleye");
		driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
	    test.log(LogStatus.INFO, "Entered Last Name");
		
		driver.findElement(By.name("data[User][phone]")).clear();
		driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
	    test.log(LogStatus.INFO, "Cleared Phone Number Field");
		
		driver.findElement(By.name("data[User][phone]")).sendKeys("02037610541");
		driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
	    test.log(LogStatus.INFO, "Entered Phone Number");
		
		driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
		JavascriptExecutor jse = (JavascriptExecutor)driver;
		jse.executeScript("window.scrollBy(0,-500)", "");
		Thread.sleep(100);
		
			
			driver.findElement(By.xpath(".//*[@id='UserMysslEditForm']/div[3]/ul/li[2]/a")).click();
			driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
		    test.log(LogStatus.INFO, "Clicked Additional Details Tab");
			Thread.sleep(100);
			
			driver.findElement(By.xpath(".//*[@id='UserState']")).clear();
			driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
		    test.log(LogStatus.INFO, "Cleared State Field");
		    
			driver.findElement(By.xpath(".//*[@id='UserState']")).sendKeys("London");
			driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
		    test.log(LogStatus.INFO, "Entered State");
			
			driver.findElement(By.xpath(".//*[@id='UserMysslEditForm']/div[2]/button")).click();
			driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
		    test.log(LogStatus.INFO, "Clicked Submit Changes Button");
		    
		    //Take Screenshot
		    String path = ScreenShot.Image(driver, "Edit User");
		    String imagePath = test.addScreenCapture(path);
		    test.log(LogStatus.PASS, "Form Submitted");
		    test.log(LogStatus.INFO, imagePath);

			
			//String Alertnote = "Contact has been updated";
			//AlertBoxElements.AlertWait();
			    	
			try {
				
				String Alertnote = "Contact has been updated";  
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
									
				test.log(LogStatus.FAIL, "Alert not displayed");
				

			}
		
	}	

	
	@Test (priority = 5, groups = {"Sanity","BS_Sanity","Sanity_Chrome"})
	public void Domain_Name_Ordering () throws Exception {
		

		System.out.println("Domain Name Order Started!");
		
		test = report.startTest("Registered User Test --> Domain Name Ordering");
	    test.log(LogStatus.INFO, "User Logged in");
		
		//Navigate Domain Names Link on side bar
	    sslDashBoardElements.ClickMyDomainNamesLink();
	    driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
	    test.log(LogStatus.INFO, "Clicked on Domain Name Link"); 
	    
	    sslDashBoardElements.ClickRegisterDomainLink();
	    driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
	    test.log(LogStatus.INFO, "Clicked on register domain link");
			
		//Enter Domain Name to check availability
		driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
		
		driver.findElement(By.id("check-domain-name")).sendKeys("ssl247test.net");
		driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
	    test.log(LogStatus.INFO, "Entered Domain Name in Search Field");
		
		driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
		driver.findElement(By.xpath(".//*[@class='btn btn-ssl search-domain-box-button']")).click();
		driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
	    test.log(LogStatus.INFO, "Clicked on search button");
		
		Thread.sleep(10000);
		
		WebDriverWait wait = new WebDriverWait(driver, 20);	
		WebElement Result;
		Result = wait.until(ExpectedConditions.visibilityOfElementLocated (By.xpath(".//*[@id='domain-name-results']/tbody/tr[2]/td[1]")));
		WebElement 	Avalability = driver.findElement(By.xpath(".//*[@id='domain-name-results']/tbody/tr[2]/td[2]/span"));
				
		String oneVal = "ssl247test.net";
		String twoVal = "Available";
		//WebElement 	Result = driver.findElement(By.xpath(".//*[@id='domain-name-results']/tbody/tr[2]/td[1]"));
		//WebElement 	Avalability = driver.findElement(By.xpath(".//*[@id='domain-name-results']/tbody/tr[2]/td[2]/span"));
		//Thread.sleep(5000);
				
		if(Result.getText().equals(oneVal)){
					
			System.out.println("Search Keyword is present");
			test.log(LogStatus.INFO, "Domain Name is Available");
			Thread.sleep(5000);
			
				}else {
					
					System.out.println("Search Keyword Not Present");
					test.log(LogStatus.FAIL, "Domain is Not Available");
					 }
				
				if (Avalability.getText().equals(twoVal)){
					
					System.out.println("Domain Name is Avalable");
					test.log(LogStatus.PASS, "Domain Name is Available");
					
					driver.findElement(By.xpath(".//*[@id='domain-name-results']/tbody/tr[2]/td[4]/input")).click();
					driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
				    test.log(LogStatus.INFO, "Clicked on Input");
					
					driver.findElement(By.xpath(".//*[@id='domain-search-results']/div/button")).click();
					driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
				    test.log(LogStatus.INFO, "Clicked on Button");
					
				}else {
					
					System.out.println("Domain Name is Not Available");
					test.log(LogStatus.FAIL, "Domain is Not Available");
					Thread.sleep(1000);
					//driver.quit();
				}
				
				
		//Confirm Basket
		Thread.sleep(15000);
		driver.findElement(By.id("checkoutLink")).click();
		driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
	    test.log(LogStatus.INFO, "Clicked Order Button");
		
				
		//Fill In Billing Retails
		driver.findElement(By.name("data[BasketContact][firstname]")).clear();
		driver.findElement(By.name("data[BasketContact][firstname]")).sendKeys("Gideon");
		driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
	    test.log(LogStatus.INFO, "Filled First Name Field");
		
		driver.findElement(By.name("data[BasketContact][lastname]")).clear();
		driver.findElement(By.name("data[BasketContact][lastname]")).sendKeys("Ogunleye");
		driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
	    test.log(LogStatus.INFO, "Filled Last Name Field");
		
		driver.findElement(By.name("data[BasketContact][phone]")).clear();
		driver.findElement(By.name("data[BasketContact][phone]")).sendKeys("02037610541");
		driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
	    test.log(LogStatus.INFO, "Filled Phone Number Field");
		
		driver.findElement(By.name("data[BasketContact][email]")).clear();
		driver.findElement(By.name("data[BasketContact][email]")).sendKeys("qa@ssl247.co.uk");
		driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
	    test.log(LogStatus.INFO, "Filled Email Field");
		
		driver.findElement(By.name("data[BasketContact][address_1]")).clear();
		driver.findElement(By.name("data[BasketContact][address_1]")).sendKeys("63 Lisson St, Marylebone");
		driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
	    test.log(LogStatus.INFO, "Filled Address Field");
		
		driver.findElement(By.name("data[BasketContact][city]")).clear();
		driver.findElement(By.name("data[BasketContact][city]")).sendKeys("London");
		driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
	    test.log(LogStatus.INFO, "Filled City Field");
		
		WebElement Country = driver.findElement(By.name("data[BasketContact][country]"));
		Select CountryName = new Select(Country);
		CountryName.selectByVisibleText("United Kingdom");
		driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
	    test.log(LogStatus.INFO, "Selected Country");
		
		driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
		driver.findElement(By.id("notUsaStateInput")).clear();
		driver.findElement(By.id("notUsaStateInput")).sendKeys("London");
		driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
	    test.log(LogStatus.INFO, "Filled State Field");
		
		driver.findElement(By.id("BasketContactPostcode")).clear();
		driver.findElement(By.id("BasketContactPostcode")).sendKeys("NW1 5DD");
		driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
	    test.log(LogStatus.INFO, "Filled Postcode Field");
		
				
		//Confirm input
		Thread.sleep(5000);
		driver.findElement(By.xpath(".//*[@id='BasketContactForm']/div[8]/button")).click();
		driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
	    test.log(LogStatus.INFO, "Clicked Confirm Button");
	
		try {
				//Click Complete Button
				Thread.sleep(5000);
				//driver.findElement(By.xpath(".//*[@id='mainContainer']/div[4]/div[2]/div[1]/div/div[1]/table/tbody/tr[5]/td/a")).click();
				driver.findElement(By.xpath(".//*[@class='actions']/a")).click();
				driver.manage().timeouts().implicitlyWait(100, TimeUnit.SECONDS);
				
				//Click on Admin Tab
				
				Thread.sleep(5000);
				driver.findElement(By.cssSelector("a[href*='#admin-domainName-edit-admin-contact-tab']")).click();
				
				//Fill in the Required Information
				WebElement AdContact = driver.findElement(By.xpath(".//*[@id='AdminContactUser']"));
				Select Name = new Select(AdContact);
				Name.selectByVisibleText("Mr Gideon Ogunleye");
				driver.manage().timeouts().implicitlyWait(100, TimeUnit.SECONDS);
				driver.findElement(By.id("AdminContactDialingCode")).sendKeys("475");
				//driver.findElement(By.id("AdminContactDialingCode")).sendKeys(Keys.ENTER);
				
				System.out.println("Filled Admin Tab");
				
				//Click on Technical Tab
				JavascriptExecutor jse = (JavascriptExecutor)driver;
				jse.executeScript("window.scrollBy(0,-500)", "");
				Thread.sleep(5000);
				driver.findElement(By.cssSelector("a[href*='#admin-domainName-edit-technical-contact-tab']")).click();
				
				//Fill in Required Information
				WebElement TechContact = driver.findElement(By.xpath(".//*[@id='TechnicalContactUser']"));
				Select TechName = new Select(TechContact);
				TechName.selectByVisibleText("Mr Gideon Ogunleye");
				
				driver.findElement(By.id("TechnicalContactDialingCode")).sendKeys("475");
				
				//Click on Owner Tab
				//JavascriptExecutor jse = (JavascriptExecutor)driver;
				jse.executeScript("window.scrollBy(0,-500)", "");
				Thread.sleep(5000);
				driver.findElement(By.cssSelector("a[href*='#admin-domainName-edit-owner-contact-tab")).click();
				
				//Fill in Required Information
				WebElement Owner = driver.findElement(By.xpath(".//*[@id='OwnerContactUser']"));
				Select OwnerName = new Select(Owner);
				OwnerName.selectByVisibleText("Mr Gideon Ogunleye");
						
				driver.findElement(By.id("OwnerContactDialingCode")).sendKeys("475");
				test.log(LogStatus.PASS, "Order Completed");
						
				//Click on Save Changes
				jse.executeScript("window.scrollBy(0,-500)", "");
				
				Thread.sleep(5000);
				
				driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
				driver.findElement(By.xpath(".//*[@id='DomainNameMysslEditForm']/div[2]/div[1]/button")).click();
				
				driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
				
		}catch (Exception e) {
			
			test.log(LogStatus.FAIL, "Validation of Domain Name Not Completed");
			String path = ScreenShot.Image(driver, "TestScreenshot");
			String imagePath = test.addScreenCapture(path);;
			test.log(LogStatus.INFO, imagePath);

			LoginPageElements.ClickLogoutButton();
			Assert.fail("Exception " + e);
		}	
		
		
		try {
			
				String Alertnote = "Validation complete, order will be processed shortly, thank you";
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
				
					test.log(LogStatus.FAIL, "Alert Not Displayed");
					//Assert.fail("Exception " + e);
				}

		
	}
		
	@Test (priority = 3, groups = {"Sanity","BS_DailySanity"},dataProviderClass =Test_DataSanity.class, dataProvider="ReissueCertificate", enabled = false) 
	public void  Reissue_Certificate(String AdUsername, String Adpassword, String URL, String Account, String Product) throws Exception {
		
		System.out.println("Reissue Certificate Test Started!");
		
		test = report.startTest("Registered User Test --> Reissue Certificate: " + Product );
	    test.log(LogStatus.INFO, "User Logged in");
		
		//Navigate Domain Names Link on side bar
	    sslDashBoardElements.MysslCertificatessLinkClick();
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
			//Assert.fail("Exception " + e);
			System.out.println("Reissuaince Test Exception:-  " + e);
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
	    	//Assert.fail("Exception " + e);
	    }
	    
	}   

/*	
	  @BeforeTest (groups = {"Sanity"})
	  public void beforeTest() throws IOException, Exception {
		
		 /*----Firefox Driver-----
		 //System.setProperty("webdriver.gecko.driver","C:\\geckodriver.exe");
		// driver = new FirefoxDriver(); 

		 System.setProperty("webdriver.chrome.driver", "C:\\chromedriver.exe");
		 driver = new ChromeDriver();  
		 
		 System.out.println("Registered User Module Test is Running.....");
		 
		 
		/*-------- //Log in As Administrator
		 Properties prop = new Properties();
		 FileInputStream fis = new FileInputStream("C://Users//Gideon Okunleye//workspace//SSL247_Test//DataDrivingAdmin.properties");
					 
		 prop.load(fis);

		 driver.get(prop.getProperty("Url")); 
		 driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
		 driver.manage().window().maximize();
		 String title = driver.getTitle();				 
		 Assert.assertTrue(title.contains("SSL Certificates: Buy Symantec, Thawte, Apache SSL Cert, GlobalSign, GeoTrust, RapidSSL- SSL247.co.uk")); 
						
		 driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
		 driver.findElement(By.linkText("Login")).click();
		 driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
		 driver.findElement(By.name("data[User][email]")).sendKeys(prop.getProperty("Username"));
		 driver.findElement(By.name("data[User][password]")).sendKeys(prop.getProperty("Password"));
		 driver.findElement(By.xpath(".//*[@id='UserMysslLoginForm']/button")).click();
		 
		//Search For UK Test User
		 driver.findElement(By.xpath(".//*[@id='mainNavigation']/li[2]/a")).click();
		 driver.findElement(By.name("data[Account][query]")).sendKeys("Uk Test");
		 driver.findElement(By.xpath(".//*[@id='AccountAdminIndexForm']/div[2]/div[1]/button")).click();
		 Thread.sleep(5000);
		 driver.findElement(By.xpath(".//*[@id='DataTables_Table_0']/tbody/tr[1]/td[8]/a/i")).click();
		 driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
		 driver.findElement(By.linkText("Account end users")).click();
		 
		//Navigate to Edit User
		 driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
		 Actions  actions=new Actions(driver);
	     WebElement menuHoverLink=driver.findElement(By.xpath(".//*[@id='mainContainer']/div[7]/div[2]/div[2]/div[1]/div/address/div[2]/div/button"));
	     actions.click(menuHoverLink);
	     driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
	     WebElement subLink=driver.findElement(By.xpath(".//*[@id='mainContainer']/div[7]/div[2]/div[2]/div[1]/div/address/div[2]/div/ul/li[1]/a"));
	     actions.moveToElement(subLink);
	     actions.click();
	     actions.perform();
	     
	     //Edit User
	     WebElement AccessLevel = driver.findElement(By.xpath(".//*[@id='UserAccessLevel']"));
		 Select Level = new Select(AccessLevel);
		 Level.selectByVisibleText("Super User");
		 
		 //Click Save User
		 driver.findElement(By.xpath(".//*[@id='UserAdminEditForm']/div[2]/button")).click();
		 
		 //User Log Out
		 Thread.sleep(15000);
		 driver.findElement(By.linkText("Logout")).click();----
		 
	  }
*/
	  
/*	  
	  @AfterTest (groups = {"Sanity"})
	  public void afterTest() throws Exception {
		  
		 Thread.sleep(1000);
		 
		 //report.endTest(test);
		
		 driver.quit();
		 System.out.println("Registered User Module Test is Compete!");
		
  }
*/	  
	
}
