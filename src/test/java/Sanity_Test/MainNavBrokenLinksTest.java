package Sanity_Test;

import org.testng.annotations.Test;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import BaseUtilities.AlertBox;
import BaseUtilities.BrowserStack;
import BaseUtilities.Chrome;
import BaseUtilities.Constants;
import BaseUtilities.DriverLoad;
import BaseUtilities.ExtentFactory;
import BaseUtilities.FindLinks;
import BaseUtilities.TakeScreenShot;
import PageFactory.LoginPage;
//import PageFactory.Navigation;
import PageFactory.NavigationLinks;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;

public class MainNavBrokenLinksTest extends Chrome {
  
	ExtentReports report;
	ExtentTest test;
	NavigationLinks NavigationElements;
	LoginPage 	LoginPageElements;
	AlertBox AlertBoxElements;
	TakeScreenShot ScreenShot;
	FindLinks Links;

  @BeforeMethod (groups = {"Smoke","BS_Smoke","BS_Sanity","Smoke_Firefox","Smoke_Chrome"})
  public void beforeMethod() throws Exception {
	  
	  NavigationElements = new NavigationLinks(driver);
	  LoginPageElements = new LoginPage(driver);
	  AlertBoxElements = new AlertBox(driver);
	  ScreenShot = new TakeScreenShot();
	  Links = new  FindLinks(driver);
	  
	  //LoginPageElements.LoadLoginPage();
	  //report = ExtentFactory.getInstance5();
	  //test.log(LogStatus.INFO, "Browser Opened and Url Entered");
	  
  }

  @AfterMethod (groups = {"Smoke","BS_Smoke","BS_Sanity","Smoke_Firefox","Smoke_Chrome"})
  public void afterMethod(ITestResult result) throws IOException, Exception {
	  
	 /* 	String path =  ScreenShot.Image(driver, "TestSecreenShot" + result.getMethod().getMethodName());
		String imagePath = test.addScreenCapture(path);
		test.log(LogStatus.INFO, "Test Complete", imagePath);
	*/	
		//Thread.sleep(5000);
		//driver.navigate().refresh();
		
	
		//test.log(LogStatus.INFO, "Browser Refreshed");
		//report.endTest(test);
		//report.flush();
	
		//return destination;
	  
  }
  
  
  @Test (priority = 0, groups = {"Smoke","BS_Smoke","BS_Sanity","Smoke_Firefox","Smoke_Chrome"},dataProviderClass =Test_DataSanity.class, dataProvider="IndexLinksAllSites")
  public void SSL_Certlink_Test(String Websitename, String WebsiteUrl, String Path) {
	  
	  //String Path = "C:\\ExtentReport\\UK-Website.csv";
	  //driver.get("https://www.ssl247.co.uk");
	  driver.get(WebsiteUrl);
	  driver.manage().window().maximize();
	  driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
	  
	  try {
		  
		  //NavigationElements.ClickSslCertificatesLink();
		  driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);

	     // TODO - Find All Links Method
	        
		  Links.DemoTestlinks("Uk Website", Path, driver.getCurrentUrl());

	  	
	  }catch (Exception e) {
	  						
	  		Assert.fail("Exception " + e);
	  }

  }
  
  @Test (priority = 1, groups = {"Smoke","BS_Smoke","BS_Sanity","Smoke_Firefox","Smoke_Chrome"},dataProviderClass =Test_DataSanity.class, dataProvider="IndexLinksAllSites")
  public void FreeSsl_Link_Test(String Websitename, String WebsiteUrl, String Path) {
	  
	  test = report.startTest("Nav Links Test --> FreeSsl Link Test" + Websitename);
	  
	  driver.get(WebsiteUrl);
	  driver.manage().window().maximize();
	  driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
		
	  try {
		  
		  
		  NavigationElements.ClickFreeSslLink();
		  driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
		  test.log(LogStatus.INFO, "Page Opened");
	  			    	
		     // TODO - Find All Links Method
	        
		  Links.Submenupagelinks(Websitename, Path, driver.getCurrentUrl());
	  	
	  }catch (Exception e) {
	  						
	  		test.log(LogStatus.FAIL, "Validation Failed");
	  		Assert.fail("Exception " + e);
	  }
	    
  }
  
  @Test (priority = 2, groups = {"Smoke","BS_Smoke","BS_Sanity","Smoke_Firefox","Smoke_Chrome"})
  public void ProtectAndSecure_Link_Test() {
	  
	  test = report.startTest("Nav Links Test --> Protect And Secure Link Test");
	 
	  try {
		  


	  	
	  }catch (Exception e) {
	  						
	  		test.log(LogStatus.FAIL, "Validation Failed");
	  		Assert.fail("Exception " + e);
	  }
	    
  }
  
  @Test (priority = 4, groups = {"Smoke","BS_Smoke","BS_Sanity","Smoke_Firefox","Smoke_Chrome"})
  public void Identify_Link_Test() {
	  
	  test = report.startTest("Nav Links Test --> Identify Link Test");
	 
	  try {
		  
		  if (NavigationElements.IdentifyLinkContains("Identify & Manage")) { 
			  
			  driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
			  test.log(LogStatus.INFO, "Link Text Is Validated");
			  
		  }else {
			  	
			  test.log(LogStatus.FAIL, "Text Not Validated");
			  NavigationElements.IdentifyLinkTextPrint();
			  Assert.fail("Text Not Validated"); 	
		  }		  		
	  	
	  }catch (Exception e) {
	  						
	  		test.log(LogStatus.FAIL, "Validation Failed");
	  		Assert.fail("Exception " + e);
	  }
	    
  }
  
  @Test (priority = 5, groups = {"Smoke","BS_Smoke","BS_Sanity","Smoke_Firefox","Smoke_Chrome"},dataProviderClass =Test_DataSanity.class, dataProvider="IndexLinksAllSites")
  public void Register_Link_Test(String Websitename, String WebsiteUrl, String Path) {
	  
	  test = report.startTest("Nav Links Test --> Register Link Test" + Websitename);
	  
	  driver.get(WebsiteUrl);
	  driver.manage().window().maximize();
	  driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
		
	  try {
		    
		  
		  NavigationElements.ClickRegisterLink();
		  driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
		  test.log(LogStatus.INFO, "Page Opened");
		 
		  // TODO - Find All Links Method
		  
		  Links.Submenupagelinks(Websitename, Path, driver.getCurrentUrl());  	
	  		
	  	
	  }catch (Exception e) {
	  						
	  		test.log(LogStatus.FAIL, "Validation Failed");
	  		Assert.fail("Exception " + e);
	  }
	    
  }
 
  /*
  @Test (priority = 6, groups = {"Smoke","BS_Smoke","BS_Sanity","Smoke_Firefox","Smoke_Chrome"})
  public void Manage_Link_Test() {
	  
	  test = report.startTest("Nav Links Test --> Manage Link Test");
	  
	  NavigationElements.ClickManageLink();
	  
	  test.log(LogStatus.INFO, "Page Opened");
	  
	  String PageTitle = "Managed Public Key Infrastructure (MPKI) Service by SSL247®";
		
	  try {
	  			    	
	  		if (NavigationElements.ValidatePage(PageTitle)) {
	  						
	  				test.log(LogStatus.PASS, "Validation Complete");
	  			    Assert.assertTrue(NavigationElements.ValidatePage(PageTitle));
	  			    System.out.println("Validation Complete!");
	  		}else{
	  				NavigationElements.PrintPageTitle();	
	  				test.log(LogStatus.FAIL, "Validation Failed");
	  				Assert.fail("Validation Failed ");
	  			    	
	  		}
	  	
	  }catch (Exception e) {
	  						
	  		test.log(LogStatus.FAIL, "Validation Failed");
	  		Assert.fail("Exception " + e);
	  }
	    
  }
 */ 
  
  @Test (priority = 7, groups = {"Smoke","BS_Smoke","BS_Sanity","Smoke_Firefox","Smoke_Chrome"},dataProviderClass =Test_DataSanity.class, dataProvider="IndexLinksAllSites")
  public void BecomePartner_Link_Test(String Websitename, String WebsiteUrl, String Path) {
	  
	  test = report.startTest("Nav Links Test --> Become Partner Link Test" + Websitename);
	  
	  driver.get(WebsiteUrl);
	  driver.manage().window().maximize();
	  driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
			
	  try {
		  
		  NavigationElements.ClickBecomePartnerLink();
		  driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
		  test.log(LogStatus.INFO, "Page Opened");
		  
		  // TODO - Find All Links Method
		  
		  Links.Submenupagelinks(Websitename, Path, driver.getCurrentUrl());
	  		
	  	
	  }catch (Exception e) {
	  						
	  		test.log(LogStatus.FAIL, "Validation Failed");
	  		Assert.fail("Exception " + e);
	  }
	    
  }
  
  @Test (priority = 8, groups = {"Smoke","BS_Smoke","BS_Sanity","Smoke_Firefox","Smoke_Chrome"},dataProviderClass =Test_DataSanity.class, dataProvider="IndexLinksAllSites")
  public void MySsl_Link_Test(String Websitename, String WebsiteUrl, String Path) {
	  
	  test = report.startTest("Nav Links Test --> MySsl Link Test" + Websitename);
	  
	  driver.get(WebsiteUrl);
	  driver.manage().window().maximize();
	  driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
	  
	  try {
			  
		  NavigationElements.ClickMySslLink();
		  driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
		  test.log(LogStatus.INFO, "Page Opened");
		  
		  // TODO - Find All Links Method
		  
		  Links.Submenupagelinks(Websitename, Path, driver.getCurrentUrl());
	  	
	  }catch (Exception e) {
	  						
	  		test.log(LogStatus.FAIL, "Validation Failed");
	  		Assert.fail("Exception " + e);
	  }
	    
  }
  
  @Test (priority = 9, groups = {"Smoke","BS_Smoke","BS_Sanity","Smoke_Firefox","Smoke_Chrome"},dataProviderClass =Test_DataSanity.class, dataProvider="IndexLinksAllSites")
  public void FreeTrials_Link_Test(String Websitename, String WebsiteUrl, String Path) {
	  
	  test = report.startTest("Nav Links Test --> Free Trials Link Test" + Websitename);
	  
	  driver.get(WebsiteUrl);
	  driver.manage().window().maximize();
	  driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
		
	  try {
		  
		  NavigationElements.ClickFreeTrialsLink();
		  driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
		  test.log(LogStatus.INFO, "Page Opened");
		  
		  // TODO - Find All Links Method
		  
		  Links.Submenupagelinks(Websitename, Path, driver.getCurrentUrl());
	  	
	  }catch (Exception e) {
	  						
	  		test.log(LogStatus.FAIL, "Validation Failed");
	  		Assert.fail("Exception " + e);
	  }
	    
  }
  
  @Test (priority = 10, groups = {"Smoke","BS_Smoke","BS_Sanity","Smoke_Firefox","Smoke_Chrome"},dataProviderClass =Test_DataSanity.class, dataProvider="IndexLinksAllSites")
  public void Wizard_Link_Test(String Websitename, String WebsiteUrl, String Path) {
	  
	  test = report.startTest("Nav Links Test --> Wizard Link Test" + Websitename);
	 
	  driver.get(WebsiteUrl);
	  driver.manage().window().maximize();
	  driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
		
	  try {
		  
		  NavigationElements.ClickWizardLink();
		  driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
		  test.log(LogStatus.INFO, "Page Opened");
		  
		  // TODO - Find All Links Method
		  
		  Links.Submenupagelinks(Websitename, Path, driver.getCurrentUrl());
	  	
	  }catch (Exception e) {
	  						
	  		test.log(LogStatus.FAIL, "Validation Failed");
	  		Assert.fail("Exception " + e);
	  }
	    
  }
  
  @Test (priority = 11, groups = {"Smoke","BS_Smoke","BS_Sanity","Smoke_Firefox","Smoke_Chrome"},dataProviderClass =Test_DataSanity.class, dataProvider="IndexLinksAllSites")
  public void About_Link_Test(String Websitename, String WebsiteUrl, String Path) {
	  
	  test = report.startTest("Nav Links Test --> About Link Test" + Websitename);
	  
	  driver.get(WebsiteUrl);
	  driver.manage().window().maximize();
	  driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
	  
	  try {
		  
		  NavigationElements.ClickAboutLink();
		  driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
		  test.log(LogStatus.INFO, "Page Opened");
		  
		  // TODO - Find All Links Method
		  
		  Links.Submenupagelinks(Websitename, Path, driver.getCurrentUrl());
	  	
	  }catch (Exception e) {
	  						
	  		test.log(LogStatus.FAIL, "Page Title Not Accurate");
	  		//Assert.fail("Exception " + e);
	  }
	    
  }
  
  @Test (priority = 12, groups = {"Smoke","BS_Smoke","BS_Sanity","Smoke_Firefox","Smoke_Chrome"},dataProviderClass =Test_DataSanity.class, dataProvider="IndexLinksAllSites")
  public void Support_Link_Test(String Websitename, String WebsiteUrl, String Path) {
	  
	  test = report.startTest("Nav Links Test --> Support Link Test" + Websitename);
	  
	  driver.get(WebsiteUrl);
	  driver.manage().window().maximize();
	  driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
	  
	  try {
		   
		  
		  NavigationElements.ClickSupportLink();
		  driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
		  test.log(LogStatus.INFO, "Page Opened");
		  
		  // TODO - Find All Links Method
		  
		  Links.Submenupagelinks(Websitename, Path, driver.getCurrentUrl());
	  	
	  }catch (Exception e) {
	  						
	  		test.log(LogStatus.FAIL, "Validation Failed");
	  		Assert.fail("Exception " + e);
	  }
	    
  }
  
  @Test (priority = 13, groups = {"Smoke","BS_Smoke","BS_Sanity","Smoke_Firefox","Smoke_Chrome"},dataProviderClass =Test_DataSanity.class, dataProvider="IndexLinksAllSites" )
  public void Blog_Link_Test(String Websitename, String WebsiteUrl, String Path) {
	  
	  test = report.startTest("Nav Links Test --> Blog Link Test" + Websitename);
	  
	  driver.get(WebsiteUrl);
	  driver.manage().window().maximize();
	  driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
		
	  try {
		  
		  NavigationElements.ClickBlogLink();
		  driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
		  test.log(LogStatus.INFO, "Page Opened");
		  
		  // TODO - Find All Links Method
		  
		  Links.Submenupagelinks(Websitename, Path, driver.getCurrentUrl());
	  	
	  }catch (Exception e) {
	  						
	  		test.log(LogStatus.FAIL, "Validation Failed");
	  		Assert.fail("Exception " + e);
	  }
	    
  }

}
