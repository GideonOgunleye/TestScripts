package Sanity_Test;

import org.testng.annotations.Test;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import BaseUtilities.AlertBox;
import BaseUtilities.BrowserStack;
import BaseUtilities.Chrome;
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

public class Admin_User2 extends BrowserStack {
  //WebDriver driver;
	
	
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
  TakeScreenShot ScreenShot;
  
	
  @BeforeMethod (groups = {"Sanity","Smoke","Smoke_Firefox","Smoke_Chrome","BS_Sanity","Sanity_Chrome"})
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
	  ScreenShot = new TakeScreenShot();
  
	  LoginPageElements.AdminLogin();
 
	  report = ExtentFactory.getInstance(); 	 
		 
  }
  
  @AfterMethod (alwaysRun = true, groups = {"Sanity","Smoke","Smoke_Firefox","Smoke_Chrome","BS_Sanity","Sanity_Chrome"})
  public void Log_Out (ITestResult result) throws Exception {
	  
	  //Take Screen Shots
/*	  
	  String filename = result.getMethod().getMethodName()+ result.getEndMillis() +".png";
	  String Directory = "C:\\Users\\Gideon Okunleye\\Documents\\Testing Documents\\ScreenShots\\Sanity ScreenShots\\";
	  
	  File sourceFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
	  FileUtils.copyFile(sourceFile, new File(Directory + filename));
	  
	  String destination = Directory + filename;
*/	  
	  
	  String path =  ScreenShot.Image(driver, "TestSecreenShot-" + result.getMethod().getMethodName());
	  String imagePath = test.addScreenCapture(path);
	  test.log(LogStatus.INFO, "Test Complete", imagePath);
	  
	  
	  /*User Log Out*/
	  driver.navigate().refresh();
	  Thread.sleep(5000);
	  
	  LoginPageElements.ClickAdminLogoutButton();
	  test.log(LogStatus.INFO, "Admin User Logged Out");
	  
	  report.endTest(test);
	  report.flush();
	  
	 // return destination;
  }
  
  @Test (priority = 0, groups = {"Smoke","Smoke_Firefox","Smoke_Chrome"})
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

 
 
  @Test (priority = 4,groups = {"Sanity","BS_Sanity","Sanity_Chrome"})
  public void Send_Fulfillment_Email() throws Exception {
	  
	  test = report.startTest("Admin Test -->  Send Fullfillement Email");
	    test.log(LogStatus.INFO, "Admin User Logged in");
	  
	  //Navigate to products link
	  	driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
	  	Actions  actions=new Actions(driver);
	  	WebElement ProductsLink=driver.findElement(By.xpath(".//*[@id='mainNavigation']/li[3]/a"));
	  	actions.moveToElement(ProductsLink);
	  	driver.manage().timeouts().implicitlyWait(50,TimeUnit.SECONDS);
	  	
	  	Thread.sleep(1000);
	  	
	  	WebElement CertificatesLink=driver.findElement(By.xpath(".//*[@id='mainNavigation']/li[3]/ul/li[1]/a"));
	    actions.moveToElement(CertificatesLink);
	  	actions.click();
	  	actions.perform();
	  	driver.manage().timeouts().implicitlyWait(50,TimeUnit.SECONDS);
	  	test.log(LogStatus.INFO, "Opened Search Products Page");
	  	
	  	Thread.sleep(1000);
		
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

}
