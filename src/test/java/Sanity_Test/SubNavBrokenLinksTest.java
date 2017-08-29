package Sanity_Test;

import org.testng.annotations.Test;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import BaseUtilities.BrowserStack;
import BaseUtilities.Chrome;
import BaseUtilities.DriverLoad;
import BaseUtilities.ExtentFactory;
import BaseUtilities.FindLinks;
import BaseUtilities.TakeScreenShot;
import PageFactory.LoginPage;
//import PageFactory.Navigation;
import PageFactory.NavigationLinks;

import org.testng.annotations.BeforeMethod;

import static org.testng.Assert.assertTrue;

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
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;

public class SubNavBrokenLinksTest extends Chrome {
  
	ExtentReports report;
	ExtentTest test;
	NavigationLinks NavigationElements;
	LoginPage 	LoginPageElements;
	TakeScreenShot ScreenShot;
	FindLinks Links;

  @BeforeMethod (groups = {"Sanity","BS_Sanity","Sanity_Chrome"})
  public void beforeMethod() throws Exception {
	  
	  NavigationElements = new NavigationLinks(driver);
	  LoginPageElements = new LoginPage(driver);
	  ScreenShot = new TakeScreenShot();
	  Links = new  FindLinks(driver);
	  
	  //LoginPageElements.LoadLoginPage();
	  report = ExtentFactory.getInstance6();
	  
  }

  @AfterMethod (groups = {"Sanity","BS_Sanity","Sanity_Chrome"})
  public void afterMethod(ITestResult result) throws IOException, Exception {
	  
		
		//Thread.sleep(5000);
		//driver.navigate().refresh();
		
		//test.log(LogStatus.INFO, "Browser Refreshed");
		report.endTest(test);
		report.flush();
	
  }
  
  @Test (priority = 0, groups = {"Sanity","BS_Sanity","Sanity_Chrome"},dataProviderClass =Test_DataSanity.class, dataProvider="IndexLinksAllSites")
  public void SymantecLink_Test(String Websitename, String WebsiteUrl, String Path) {
	  
	  test = report.startTest("Nav Links Test --> Symantec Link Test" + Websitename);
	  
	  driver.get(WebsiteUrl);
	  driver.manage().window().maximize();
	  driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
		
	  try {
	 	 
		  NavigationElements.SynmantecLinkClick();
		  driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
		  test.log(LogStatus.INFO, "Page Opened");
		  
		     // TODO - Find All Links Method
	        
		  Links.Submenupagelinks(Websitename, Path, WebsiteUrl);

	 	  	
	  }catch (Exception e) {
	 	  						
	 	  		test.log(LogStatus.FAIL, "Validation Failed");
	 	  		Assert.fail("Exception " + e);
	  }

	  
  }
  
  
  @Test (priority = 1, groups = {"Sanity","BS_Sanity","Sanity_Chrome"},dataProviderClass =Test_DataSanity.class, dataProvider="IndexLinksAllSites")
  public void VerSignLink_Test(String Websitename, String WebsiteUrl, String Path) {
	  
	 test = report.startTest("Nav Links Test --> VeriSign Link Test" + Websitename);
	 
	  driver.get(WebsiteUrl);
	  driver.manage().window().maximize();
	  driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);	 
	  
	  try {
		  
		  NavigationElements.VeriSignLinkClick();
		  Thread.sleep(1000);
	 	  			    	
		     // TODO - Find All Links Method
	        
		  Links.Submenupagelinks(Websitename, Path, WebsiteUrl);
	 	  	
	  }catch (Exception e) {
	 	  						
	 	  		test.log(LogStatus.FAIL, "Validation Failed");
	 	  		Assert.fail("Exception " + e);
	  }
	   
  }
  
  @Test (priority = 2, groups = {"Sanity","BS_Sanity","Sanity_Chrome"},dataProviderClass =Test_DataSanity.class, dataProvider="IndexLinksAllSites")
  public void GeoTrustLink_Test(String Websitename, String WebsiteUrl, String Path) {
	  
	 test = report.startTest("Nav Links Test --> GeoTrustLink Test" + Websitename);
	  
	  driver.get(WebsiteUrl);
	  driver.manage().window().maximize();
	  driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
	  
	  try {
		  
			 NavigationElements.GeoTrustLinkClick();
			 Thread.sleep(1000);
	 	  			    	
		     // TODO - Find All Links Method
	        
			 Links.Submenupagelinks(Websitename, Path, WebsiteUrl);
	 	  	
	  }catch (Exception e) {
	 	  						
	 	  		test.log(LogStatus.FAIL, "Validation Failed");
	 	  		Assert.fail("Exception " + e);
	  }
	   
  }
  
  @Test (priority = 3, groups = {"Sanity","BS_Sanity","Sanity_Chrome"},dataProviderClass =Test_DataSanity.class, dataProvider="IndexLinksAllSites")
  public void ThawteLink_Test(String Websitename, String WebsiteUrl, String Path) {
	  
	 test = report.startTest("Nav Links Test --> ThawteLink Test" + Websitename);
	 
	  driver.get(WebsiteUrl);
	  driver.manage().window().maximize();
	  driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
	  
	  try {
		  
			 NavigationElements.ThawteLinkClick();
			 Thread.sleep(1000);
	 	  			    	
		     // TODO - Find All Links Method
	        
			 Links.Submenupagelinks(Websitename, Path, WebsiteUrl);
	 	  	
	  }catch (Exception e) {
	 	  						
	 	  		test.log(LogStatus.FAIL, "Validation Failed");
	 	  		Assert.fail("Exception " + e);
	  }
	   
  }
  
  @Test (priority = 4, groups = {"Sanity","BS_Sanity","Sanity_Chrome"},dataProviderClass =Test_DataSanity.class, dataProvider="IndexLinksAllSites")
  public void GlobalSignLink_Test(String Websitename, String WebsiteUrl, String Path) {
	  
	 test = report.startTest("Nav Links Test --> GlobalSignLink Test" + Websitename);
	 
	  driver.get(WebsiteUrl);
	  driver.manage().window().maximize();
	  driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
	  
	  try {
		  
		  NavigationElements.GlobalSignLinkClick();
		  Thread.sleep(1000);
	 	  			    	
		  Links.Submenupagelinks(Websitename, Path, WebsiteUrl);
	 	  	
	  }catch (Exception e) {
	 	  						
	 	  		test.log(LogStatus.FAIL, "Validation Failed");
	 	  		Assert.fail("Exception " + e);
	  }
	   
  }
  
  @Test (priority = 5, groups = {"Sanity","BS_Sanity","Sanity_Chrome"},dataProviderClass =Test_DataSanity.class, dataProvider="IndexLinksAllSites")
  public void ComodoLink_Test(String Websitename, String WebsiteUrl, String Path) {
	  
	 test = report.startTest("Nav Links Test --> ComodoLink Test" + Websitename);
	 
	  driver.get(WebsiteUrl);
	  driver.manage().window().maximize();
	  driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
	 
	  try {
		  
		  NavigationElements.ComodoLinkClick();
		  Thread.sleep(1000);
	 	  			    	
		     // TODO - Find All Links Method
	        
		  Links.Submenupagelinks(Websitename, Path, WebsiteUrl);
	 	  	
	  }catch (Exception e) {
	 	  						
	 	  		test.log(LogStatus.FAIL, "Validation Failed");
	 	  		Assert.fail("Exception " + e);
	  }
	   
  }
  
  @Test (priority = 6, groups = {"Sanity","BS_Sanity","Sanity_Chrome"},dataProviderClass =Test_DataSanity.class, dataProvider="IndexLinksAllSites")
  public void RapidSslLink_Test(String Websitename, String WebsiteUrl, String Path) {
	  
	 test = report.startTest("Nav Links Test --> RapidSslLink Test" + Websitename);
	 
	  driver.get(WebsiteUrl);
	  driver.manage().window().maximize();
	  driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
		
	  try {
		  
		  NavigationElements.RapidSslLinkClick();
		  Thread.sleep(1000);
	 	  			    	
		  Links.Submenupagelinks(Websitename, Path, WebsiteUrl);
	 	  	
	  }catch (Exception e) {
	 	  						
	 	  		test.log(LogStatus.FAIL, "Validation Failed");
	 	  		Assert.fail("Exception " + e);
	  }
	   
  }
  
  @Test (priority = 7, groups = {"Sanity","BS_Sanity","Sanity_Chrome"},dataProviderClass =Test_DataSanity.class, dataProvider="IndexLinksAllSites")
  public void EntrustLink_Test(String Websitename, String WebsiteUrl, String Path) {
	  
	 test = report.startTest("Nav Links Test --> EntrustLink Test" + Websitename);
	 
	  driver.get(WebsiteUrl);
	  driver.manage().window().maximize();
	  driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
	  
	  try {
		  
		  NavigationElements.EntrustLinkClick();
		  Thread.sleep(1000);
	 	  			    	
		  Links.Submenupagelinks(Websitename, Path, WebsiteUrl);
	 	  	
	  }catch (Exception e) {
	 	  						
	 	  		test.log(LogStatus.FAIL, "Validation Failed");
	 	  		Assert.fail("Exception " + e);
	  }
	   
  }
  
  @Test (priority = 8, groups = {"Sanity","BS_Sanity","Sanity_Chrome"},dataProviderClass =Test_DataSanity.class, dataProvider="IndexLinksAllSites")
  public void SanSslLink_Test(String Websitename, String WebsiteUrl, String Path) {
	  
	 test = report.startTest("Nav Links Test --> SanSslLink Test" + Websitename);
	 
	  driver.get(WebsiteUrl);
	  driver.manage().window().maximize();
	  driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
		
	  try {
		  
		  NavigationElements.SanSslLinkClick();
		  Thread.sleep(1000);
	 	  			    	
		     // TODO - Find All Links Method
	        
		  Links.Submenupagelinks(Websitename, Path, WebsiteUrl);
	 	  	
	  }catch (Exception e) {
	 	  						
	 	  		test.log(LogStatus.FAIL, "Validation Failed");
	 	  		Assert.fail("Exception " + e);
	  }
	   
  }
  
  @Test (priority = 9, groups = {"Sanity","BS_Sanity","Sanity_Chrome"},dataProviderClass =Test_DataSanity.class, dataProvider="IndexLinksAllSites")
  public void WildcardSslLink_Test(String Websitename, String WebsiteUrl, String Path) {
	  
	 test = report.startTest("Nav Links Test --> WildcardSslLink Test" + Websitename);
	 
	  driver.get(WebsiteUrl);
	  driver.manage().window().maximize();
	  driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
	  	
	  try {
		  
			 NavigationElements.WildcardSslLinkClick();
			 Thread.sleep(1000);
	 	  			    	
		     // TODO - Find All Links Method
	        
			 Links.Submenupagelinks(Websitename, Path, WebsiteUrl);
	 	  	
	  }catch (Exception e) {
	 	  						
	 	  		test.log(LogStatus.FAIL, "Validation Failed");
	 	  		Assert.fail("Exception " + e);
	  }
	   
  }
  
  @Test (priority = 10, groups = {"Sanity","BS_Sanity","Sanity_Chrome"},dataProviderClass =Test_DataSanity.class, dataProvider="IndexLinksAllSites")
  public void SanWildcardSslLink_Test(String Websitename, String WebsiteUrl, String Path) {
	  
	 test = report.startTest("Nav Links Test --> SanWildcardSslLink Test" + Websitename);
	 
	  driver.get(WebsiteUrl);
	  driver.manage().window().maximize();
	  driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
	  
	  try {
		  
		  NavigationElements.SanWildcardSslLinkClick();
		  Thread.sleep(1000);
	 	  			    	
		     // TODO - Find All Links Method
	        
		  Links.Submenupagelinks(Websitename, Path, WebsiteUrl);
	 	  	
	  }catch (Exception e) {
	 	  						
	 	  		test.log(LogStatus.FAIL, "Validation Failed");
	 	  		Assert.fail("Exception " + e);
	  }
	   
  }
  
  @Test (priority = 11, groups = {"Sanity","BS_Sanity","Sanity_Chrome"},dataProviderClass =Test_DataSanity.class, dataProvider="IndexLinksAllSites")
  public void ECCSslLink_Test(String Websitename, String WebsiteUrl, String Path) {
	  
	 test = report.startTest("Nav Links Test --> ECCSslLink Test" + Websitename);
	 
	  driver.get(WebsiteUrl);
	  driver.manage().window().maximize();
	  driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
	  
		
	  try {
		  
			 NavigationElements.ECCSslLinkClick();
			 Thread.sleep(1000);
	 	  			    	
		     // TODO - Find All Links Method
	        
			 Links.Submenupagelinks(Websitename, Path, WebsiteUrl);
	 	  	
	  }catch (Exception e) {
	 	  						
	 	  		test.log(LogStatus.FAIL, "Validation Failed");
	 	  		Assert.fail("Exception " + e);
	  }
	   
  }
  
  @Test (priority = 12, groups = {"Sanity","BS_Sanity","Sanity_Chrome"},dataProviderClass =Test_DataSanity.class, dataProvider="IndexLinksAllSites")
  public void IPaddressSslLink_Test(String Websitename, String WebsiteUrl, String Path) {
	  
	 test = report.startTest("Nav Links Test --> IPaddressSslLink Test" + Websitename);
	 
	  driver.get(WebsiteUrl);
	  driver.manage().window().maximize();
	  driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
	  
	  try {
		  
		  NavigationElements.IPaddressSslLinkClick();
		  Thread.sleep(1000);
	 	  			    	
		     // TODO - Find All Links Method
	        
		  Links.Submenupagelinks(Websitename, Path, WebsiteUrl);
	 	  	
	  }catch (Exception e) {
	 	  						
	 	  		test.log(LogStatus.FAIL, "Validation Failed");
	 	  		Assert.fail("Exception " + e);
	  }
	   
  }
  
  @Test (priority = 13, groups = {"Sanity","BS_Sanity","Sanity_Chrome"},dataProviderClass =Test_DataSanity.class, dataProvider="IndexLinksAllSites")
  public void ExtendedValidationLink_Test(String Websitename, String WebsiteUrl, String Path) {
	  
	 test = report.startTest("Nav Links Test --> ExtendedValidationLink Test" + Websitename);
	 
	  driver.get(WebsiteUrl);
	  driver.manage().window().maximize();
	  driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
		
	  try {
		  
		  NavigationElements.ExtendedValidationLinkClick();
		  Thread.sleep(1000);
	 	  			    	
		     // TODO - Find All Links Method
	        
		  Links.Submenupagelinks(Websitename, Path, WebsiteUrl);
	 	  	
	  }catch (Exception e) {
	 	  						
	 	  		test.log(LogStatus.FAIL, "Validation Failed");
	 	  		Assert.fail("Exception " + e);
	  }
	   
  }
  
  @Test (priority = 14, groups = {"Sanity","BS_Sanity","Sanity_Chrome"},dataProviderClass =Test_DataSanity.class, dataProvider="IndexLinksAllSites")
  public void OrganisationValidationLink_Test(String Websitename, String WebsiteUrl, String Path) {
	  
	 test = report.startTest("Nav Links Test --> OrganisationValidationLink Test" + Websitename);
	 
	  driver.get(WebsiteUrl);
	  driver.manage().window().maximize();
	  driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
		
	  try {
		  
		  NavigationElements.OrganisationValidationLinkClick();
		  Thread.sleep(1000);
	 	  			    	
		     // TODO - Find All Links Method
	        
		  Links.Submenupagelinks(Websitename, Path, WebsiteUrl);
	 	  	
	  }catch (Exception e) {
	 	  						
	 	  		test.log(LogStatus.FAIL, "Validation Failed");
	 	  		Assert.fail("Exception " + e);
	  }
	   
  }
  
  @Test (priority = 15, groups = {"Sanity","BS_Sanity","Sanity_Chrome"},dataProviderClass =Test_DataSanity.class, dataProvider="IndexLinksAllSites")
  public void SymantecReadyIssuanceLink_Test(String Websitename, String WebsiteUrl, String Path) {
	  
	 test = report.startTest("Nav Links Test --> Symantec Ready Issuance Link Test" + Websitename);
	 
	  driver.get(WebsiteUrl);
	  driver.manage().window().maximize();
	  driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
		
	  try {
		  
		  NavigationElements.SymantecReadyIssuanceLinkClick();
		  Thread.sleep(1000);
	 	  			    	
		     // TODO - Find All Links Method
	        
		  Links.Submenupagelinks(Websitename, Path, WebsiteUrl);
	 	  	
	  }catch (Exception e) {
	 	  						
	 	  		test.log(LogStatus.FAIL, "Validation Failed");
	 	  		Assert.fail("Exception " + e);
	  }
	   
  }
  
  @Test (priority = 16, groups = {"Sanity","BS_Sanity","Sanity_Chrome"},dataProviderClass =Test_DataSanity.class, dataProvider="IndexLinksAllSites")
  public void DomainValidationLink_Test(String Websitename, String WebsiteUrl, String Path) {
	  
	 test = report.startTest("Nav Links Test --> Domain Validation Link Test" + Websitename);
	 
	  driver.get(WebsiteUrl);
	  driver.manage().window().maximize();
	  driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
		
	  try {
		  
			 NavigationElements.DomainValidationLinkClick();
			 Thread.sleep(1000);
			 
			  driver.get("https://www.ssl247.co.uk");
			  driver.manage().window().maximize();
			  driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
			  
	 	  			    	
		     // TODO - Find All Links Method
	        
			  Links.Submenupagelinks(Websitename, Path, WebsiteUrl);
	 	  	
	  }catch (Exception e) {
	 	  						
	 	  		test.log(LogStatus.FAIL, "Validation Failed");
	 	  		Assert.fail("Exception " + e);
	  }
	   
  }
  
  @Test (priority = 17, groups = {"Sanity","BS_Sanity","Sanity_Chrome"},dataProviderClass =Test_DataSanity.class, dataProvider="IndexLinksAllSites")
  public void PenentrationTestingLink_Test(String Websitename, String WebsiteUrl, String Path) {
	  
	 test = report.startTest("Nav Links Test --> PenentrationTestingLink Test" + Websitename);

	  driver.get(WebsiteUrl);
	  driver.manage().window().maximize();
	  driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
		
	  try {
			 NavigationElements.PenentrationTestingLinkClick();	
			 Thread.sleep(1000);
			 
			 // TODO - Find All Links Method
		        
			 Links.Submenupagelinks(Websitename, Path, WebsiteUrl);    	
	 
	 	  	
	  }catch (Exception e) {
	 	  						
	 	  		test.log(LogStatus.FAIL, "Validation Failed");
	 	  		Assert.fail("Exception " + e);
	  }
	   
  }
  
  @Test (priority = 18, groups = {"Sanity","BS_Sanity","Sanity_Chrome"},dataProviderClass =Test_DataSanity.class, dataProvider="IndexLinksAllSites")
  public void QualysConsultancyKitLink_Test(String Websitename, String WebsiteUrl, String Path) {
	  
	 test = report.startTest("Nav Links Test --> QualysConsultancyKitLink Test" + Websitename);

	  driver.get(WebsiteUrl);
	  driver.manage().window().maximize();
	  driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
		
	  try {
			 NavigationElements.QualysConsultancyKitLinkClick();
			 Thread.sleep(1000);
			 
			 
			 // TODO - Find All Links Method
		        
			 Links.Submenupagelinks(Websitename, Path, WebsiteUrl);		    	
	 
	 	  	
	  }catch (Exception e) {
	 	  						
	 	  		test.log(LogStatus.FAIL, "Validation Failed");
	 	  		Assert.fail("Exception " + e);
	  }
	   
  }
  
  @Test (priority = 19, groups = {"Sanity","BS_Sanity","Sanity_Chrome"},dataProviderClass =Test_DataSanity.class, dataProvider="IndexLinksAllSites")
  public void Gdpr_HealthCheckLink_Test(String Websitename, String WebsiteUrl, String Path) {
	  
	 test = report.startTest("Nav Links Test --> Gdpr_HealthCheckLink Test" + Websitename);

	  driver.get(WebsiteUrl);
	  driver.manage().window().maximize();
	  driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
		
	  try {
			 NavigationElements.Gdpr_HealthCheckLinkClick();
			 Thread.sleep(1000);
			 
			 // TODO - Find All Links Method
		        
			 Links.Submenupagelinks(Websitename, Path, WebsiteUrl);		    	
	 
	 	  	
	  }catch (Exception e) {
	 	  						
	 	  		test.log(LogStatus.FAIL, "Validation Failed");
	 	  		Assert.fail("Exception " + e);
	  }
	   
  }
  
  @Test (priority = 20, groups = {"Sanity","BS_Sanity","Sanity_Chrome"},dataProviderClass =Test_DataSanity.class, dataProvider="IndexLinksAllSites")
  public void ThalesVolumetricDataLink_Test(String Websitename, String WebsiteUrl, String Path) {
	  
	 test = report.startTest("Nav Links Test --> ThalesVolumetricDataLink Test" + Websitename);

	  driver.get(WebsiteUrl);
	  driver.manage().window().maximize();
	  driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
		
	  try {
			 NavigationElements.ThalesVolumetricDataLinkClick();
			 Thread.sleep(1000);
			 
			 // TODO - Find All Links Method
		        
			 Links.Submenupagelinks(Websitename, Path, WebsiteUrl);		    	
	 
	 	  	
	  }catch (Exception e) {
	 	  						
	 	  		test.log(LogStatus.FAIL, "Validation Failed");
	 	  		Assert.fail("Exception " + e);
	  }
	   
  }
  
  @Test (priority = 21, groups = {"Sanity","BS_Sanity","Sanity_Chrome"},dataProviderClass =Test_DataSanity.class, dataProvider="IndexLinksAllSites")
  public void ThalesHsmLink_Test(String Websitename, String WebsiteUrl, String Path) {
	  
	 test = report.startTest("Nav Links Test --> ThalesHsmLink Test" + Websitename);
	 
	  driver.get(WebsiteUrl);
	  driver.manage().window().maximize();
	  driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);

	  try {
			 NavigationElements.ThalesHsmLinkClick();
			 Thread.sleep(1000);
			 
			 // TODO - Find All Links Method
		        
			 Links.Submenupagelinks(Websitename, Path, WebsiteUrl);		    	
	 
	 	  	
	  }catch (Exception e) {
	 	  						
	 	  		test.log(LogStatus.FAIL, "Validation Failed");
	 	  		Assert.fail("Exception " + e);
	  }
	   
  }
  
  @Test (priority = 22, groups = {"Sanity","BS_Sanity","Sanity_Chrome"},dataProviderClass =Test_DataSanity.class, dataProvider="IndexLinksAllSites")
  public void SynmantecCloudSecurityLink_Test(String Websitename, String WebsiteUrl, String Path) {
	  
	 test = report.startTest("Nav Links Test --> SynmantecCloudSecurityLink Test" + Websitename);

	  driver.get(WebsiteUrl);
	  driver.manage().window().maximize();
	  driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
		
	  try {
			 NavigationElements.SynmantecCloudSecurityLinkClick();
			 Thread.sleep(1000);
			 
			 // TODO - Find All Links Method
		        
			 Links.Submenupagelinks(Websitename, Path, WebsiteUrl);		    	
	 
	 	  	
	  }catch (Exception e) {
	 	  						
	 	  		test.log(LogStatus.FAIL, "Validation Failed");
	 	  		Assert.fail("Exception " + e);
	  }
	   
  }
  
  @Test (priority = 23, groups = {"Sanity","BS_Sanity","Sanity_Chrome"},dataProviderClass =Test_DataSanity.class, dataProvider="IndexLinksAllSites")
  public void WebSecurityLink_Test(String Websitename, String WebsiteUrl, String Path) {
	  
	 test = report.startTest("Nav Links Test --> WebSecurityLink Test" + Websitename);

	  driver.get(WebsiteUrl);
	  driver.manage().window().maximize();
	  driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
		
	  try {
			 NavigationElements.WebSecurityLinkClick();	
			 Thread.sleep(1000);
			 
			 // TODO - Find All Links Method
		        
			 Links.Submenupagelinks(Websitename, Path, WebsiteUrl);		    	
	 
	 	  	
	  }catch (Exception e) {
	 	  						
	 	  		test.log(LogStatus.FAIL, "Validation Failed");
	 	  		Assert.fail("Exception " + e);
	  }
	   
  }
  
  @Test (priority = 24, groups = {"Sanity","BS_Sanity","Sanity_Chrome"},dataProviderClass =Test_DataSanity.class, dataProvider="IndexLinksAllSites")
  public void EndPointProtectionLink_Test(String Websitename, String WebsiteUrl, String Path) {
	  
	 test = report.startTest("Nav Links Test --> EndPointProtectionLink Test" + Websitename);

	  driver.get(WebsiteUrl);
	  driver.manage().window().maximize();
	  driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
		
	  try {
			 NavigationElements.EndPointProtectionLinkClick();
			 Thread.sleep(1000);
			 
			 // TODO - Find All Links Method
		        
			 Links.Submenupagelinks(Websitename, Path, WebsiteUrl);		    	
	 
	 	  	
	  }catch (Exception e) {
	 	  						
	 	  		test.log(LogStatus.FAIL, "Validation Failed");
	 	  		Assert.fail("Exception " + e);
	  }
	   
  }
  
  @Test (priority = 25, groups = {"Sanity","BS_Sanity","Sanity_Chrome"},dataProviderClass =Test_DataSanity.class, dataProvider="IndexLinksAllSites")
  public void EmailSecurityLink_Test(String Websitename, String WebsiteUrl, String Path) {
	  
	 test = report.startTest("Nav Links Test --> EmailSecurityLink Test" + Websitename);

	  driver.get(WebsiteUrl);
	  driver.manage().window().maximize();
	  driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);	 
		
	  try {
			 NavigationElements.EmailSecurityLinkClick();
			 Thread.sleep(1000);
			 
			 // TODO - Find All Links Method
		        
			 Links.Submenupagelinks(Websitename, Path, WebsiteUrl);		    	
	 
	 	  	
	  }catch (Exception e) {
	 	  						
	 	  		test.log(LogStatus.FAIL, "Validation Failed");
	 	  		Assert.fail("Exception " + e);
	  }
	   
  }
  
  @Test (priority = 26, groups = {"Sanity","BS_Sanity","Sanity_Chrome"},dataProviderClass =Test_DataSanity.class, dataProvider="IndexLinksAllSites")
  public void PersonalIdsLink_Test(String Websitename, String WebsiteUrl, String Path) {
	  
	 test = report.startTest("Nav Links Test --> PersonalIdsLink Test" + Websitename);

	  driver.get(WebsiteUrl);
	  driver.manage().window().maximize();
	  driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
		
	  try {
			 NavigationElements.PersonalIdsLinkClick();	 
			 Thread.sleep(1000);
			 
			 // TODO - Find All Links Method
		        
			 Links.Submenupagelinks(Websitename, Path, WebsiteUrl);		    	
	 
	 	  	
	  }catch (Exception e) {
	 	  						
	 	  		test.log(LogStatus.FAIL, "Validation Failed");
	 	  		Assert.fail("Exception " + e);
	  }
	   
  } 
  
  @Test (priority = 27, groups = {"Sanity","BS_Sanity","Sanity_Chrome"},dataProviderClass =Test_DataSanity.class, dataProvider="IndexLinksAllSites")
  public void CodeSigningLink_Test(String Websitename, String WebsiteUrl, String Path) {
	  
	 test = report.startTest("Nav Links Test --> CodeSigningLink Test" + Websitename);

	  driver.get(WebsiteUrl);
	  driver.manage().window().maximize();
	  driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);

		
	  try {
			 NavigationElements.CodeSigningLinkClick();
			 Thread.sleep(1000);
			 
			 // TODO - Find All Links Method
		        
			 Links.Submenupagelinks(Websitename, Path, WebsiteUrl);		    	
	 
	 	  	
	  }catch (Exception e) {
	 	  						
	 	  		test.log(LogStatus.FAIL, "Validation Failed");
	 	  		Assert.fail("Exception " + e);
	  }
	   
  } 
  
  @Test (priority = 28, groups = {"Sanity","BS_Sanity","Sanity_Chrome"},dataProviderClass =Test_DataSanity.class, dataProvider="IndexLinksAllSites")
  public void PdfSigningLink_Test(String Websitename, String WebsiteUrl, String Path) {
	  
	 test = report.startTest("Nav Links Test --> PdfSigningLink Test" + Websitename);

	  driver.get(WebsiteUrl);
	  driver.manage().window().maximize();
	  driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
		
	  try {
			 NavigationElements.PdfSigningLinkClick();
			 Thread.sleep(1000);
			 
			 // TODO - Find All Links Method
		        
			 Links.Submenupagelinks(Websitename, Path, WebsiteUrl);		    	
	 
	 	  	
	  }catch (Exception e) {
	 	  						
	 	  		test.log(LogStatus.FAIL, "Validation Failed");
	 	  		Assert.fail("Exception " + e);
	  }
	   
  } 
  
  @Test (priority = 29, groups = {"Sanity","BS_Sanity","Sanity_Chrome"},dataProviderClass =Test_DataSanity.class, dataProvider="IndexLinksAllSites")
  public void MpkiLink_Test(String Websitename, String WebsiteUrl, String Path) {
	  
	 test = report.startTest("Nav Links Test --> MpkiLink Test" + Websitename);

	  driver.get(WebsiteUrl);
	  driver.manage().window().maximize();
	  driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
		
	  try {
			 NavigationElements.MpkiLinkClick();
			 Thread.sleep(1000);
			 
			 // TODO - Find All Links Method
		        
			 Links.Submenupagelinks(Websitename, Path, WebsiteUrl);	    	
	 
	 	  	
	  }catch (Exception e) {
	 	  						
	 	  		test.log(LogStatus.FAIL, "Validation Failed");
	 	  		Assert.fail("Exception " + e);
	  }
	   
  } 
  
  @Test (priority = 30, groups = {"Sanity","BS_Sanity","Sanity_Chrome"},dataProviderClass =Test_DataSanity.class, dataProvider="IndexLinksAllSites")
  public void DomainNamesLink_Test(String Websitename, String WebsiteUrl, String Path) {
	  
	 test = report.startTest("Nav Links Test --> DomainNamesLink Test" + Websitename);

	  driver.get(WebsiteUrl);
	  driver.manage().window().maximize();
	  driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
		
	  try {
			 NavigationElements.DomainNamesLinkClick();
			 Thread.sleep(1000);
			 
			 // TODO - Find All Links Method
		        
			 Links.Submenupagelinks(Websitename, Path, WebsiteUrl);		    	
	 
	 	  	
	  }catch (Exception e) {
	 	  						
	 	  		test.log(LogStatus.FAIL, "Validation Failed");
	 	  		Assert.fail("Exception " + e);
	  }
	   
  } 
  
  @Test (priority = 31, groups = {"Sanity","BS_Sanity","Sanity_Chrome"},dataProviderClass =Test_DataSanity.class, dataProvider="IndexLinksAllSites")
  public void BrandProtectionLink_Test(String Websitename, String WebsiteUrl, String Path) {
	  
	 test = report.startTest("Nav Links Test --> BrandProtectionLink Test"+ Websitename);
	 
	  driver.get(WebsiteUrl);
	  driver.manage().window().maximize();
	  driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);

	  try {
			 NavigationElements.BrandProtectionLinkClick();
			 Thread.sleep(1000);
    	
			 // TODO - Find All Links Method
		        
			 Links.Submenupagelinks(Websitename, Path, WebsiteUrl);		    	
	 
	 	  	
	  }catch (Exception e) {
	 	  						
	 	  		test.log(LogStatus.FAIL, "Validation Failed");
	 	  		Assert.fail("Exception " + e);
	  }
	   
  } 

  
  @Test (priority = 32, groups = {"Sanity","BS_Sanity","Sanity_Chrome"},dataProviderClass =Test_DataSanity.class, dataProvider="IndexLinksAllSites")
  public void CoperateProgramsLink_Test(String Websitename, String WebsiteUrl, String Path) {
	  
	 test = report.startTest("Nav Links Test --> CoperateProgramsLink Test" + Websitename);
	 
	  driver.get(WebsiteUrl);
	  driver.manage().window().maximize();
	  driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);

	  try {
			 NavigationElements.CoperateProgramsLinkClick();
			 Thread.sleep(1000);
			 
			 // TODO - Find All Links Method
		        
			 Links.Submenupagelinks(Websitename, Path, WebsiteUrl);		    	
	 
	 	  	
	  }catch (Exception e) {
	 	  						
	 	  		test.log(LogStatus.FAIL, "Validation Failed");
	 	  		Assert.fail("Exception " + e);
	  }
	   
  } 
  
  @Test (priority = 33, groups = {"Sanity","BS_Sanity","Sanity_Chrome"},dataProviderClass =Test_DataSanity.class, dataProvider="IndexLinksAllSites")
  public void ResellerProgramsLink_Test(String Websitename, String WebsiteUrl, String Path) {
	  
	 test = report.startTest("Nav Links Test --> ResellerProgramsLink Test" + Websitename);
	 
	  driver.get(WebsiteUrl);
	  driver.manage().window().maximize();
	  driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);

	  try {
			 NavigationElements.ResellerProgramsLinkClick();
			 Thread.sleep(1000);
			 
			 // TODO - Find All Links Method
		        
			 Links.Submenupagelinks(Websitename, Path, WebsiteUrl);		    	
	 
	 	  	
	  }catch (Exception e) {
	 	  						
	 	  		test.log(LogStatus.FAIL, "Validation Failed");
	 	  		Assert.fail("Exception " + e);
	  }
	   
  } 
  
  @Test (priority = 34, groups = {"Sanity","BS_Sanity","Sanity_Chrome"},dataProviderClass =Test_DataSanity.class, dataProvider="IndexLinksAllSites")
  public void WhatIsMySslLink_Test(String Websitename, String WebsiteUrl, String Path) {
	  
	 test = report.startTest("Nav Links Test --> WhatIsMySslLink Test" + Websitename);
	 
	  driver.get(WebsiteUrl);
	  driver.manage().window().maximize();
	  driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);

	  try {
			 NavigationElements.WhatIsMySslLinkClick();	
			 Thread.sleep(1000);
			 
			 // TODO - Find All Links Method
		        
			 Links.Submenupagelinks(Websitename, Path, WebsiteUrl);		    	
	 
	 	  	
	  }catch (Exception e) {
	 	  						
	 	  		test.log(LogStatus.FAIL, "Validation Failed");
	 	  		Assert.fail("Exception " + e);
	  }
	   
  } 
  
  @Test (priority = 35, groups = {"Sanity","BS_Sanity","Sanity_Chrome"},dataProviderClass =Test_DataSanity.class, dataProvider="IndexLinksAllSites")
  public void LogIntoMySslLink_Test(String Websitename, String WebsiteUrl, String Path) {
	  
	 test = report.startTest("Nav Links Test --> LogIntoMySslLink Test" + Websitename);
	 
	  driver.get(WebsiteUrl);
	  driver.manage().window().maximize();
	  driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);

	  try {
			 NavigationElements.LogIntoMySslLinkClick();	    	
			 Thread.sleep(1000);
			 
			 // TODO - Find All Links Method
		        
			 Links.Submenupagelinks(Websitename, Path, WebsiteUrl);		    	
	 
	 	  	
	  }catch (Exception e) {
	 	  						
	 	  		test.log(LogStatus.FAIL, "Validation Failed");
	 	  		Assert.fail("Exception " + e);
	  }
	   
  } 
  
  @Test (priority = 36, groups = {"Sanity","BS_Sanity","Sanity_Chrome"},dataProviderClass =Test_DataSanity.class, dataProvider="IndexLinksAllSites")
  public void RenewalsWithSsl247Link_Test(String Websitename, String WebsiteUrl, String Path) {
	  
	 test = report.startTest("Nav Links Test --> RenewalsWithSsl247Link Test" + Websitename);
	 
	  driver.get(WebsiteUrl);
	  driver.manage().window().maximize();
	  driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);

	  try {
			 NavigationElements.RenewalsWithSsl247LinkClick();	    	
			 Thread.sleep(1000);
			 
			 // TODO - Find All Links Method
		        
			 Links.Submenupagelinks(Websitename, Path, WebsiteUrl);		    	
	 
	 	  	
	  }catch (Exception e) {
	 	  						
	 	  		test.log(LogStatus.FAIL, "Validation Failed");
	 	  		Assert.fail("Exception " + e);
	  }
	   
  } 
  
  @Test (priority = 37, groups = {"Sanity","BS_Sanity","Sanity_Chrome"},dataProviderClass =Test_DataSanity.class, dataProvider="IndexLinksAllSites")
  public void RenewYourSslCertificateLink_Test(String Websitename, String WebsiteUrl, String Path) {
	  
	 test = report.startTest("Nav Links Test --> RenewYourSslCertificateLink Test" + Websitename);
	 
	  driver.get(WebsiteUrl);
	  driver.manage().window().maximize();
	  driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);

	  try {
			 NavigationElements.RenewalsWithSsl247LinkClick();	
			 Thread.sleep(1000);	
			 
			 // TODO - Find All Links Method
		        
			 Links.Submenupagelinks(Websitename, Path, WebsiteUrl);		    	
	 
	 	  	
	  }catch (Exception e) {
	 	  						
	 	  		test.log(LogStatus.FAIL, "Validation Failed");
	 	  		Assert.fail("Exception " + e);
	  }
	   
  } 
  
  @Test (priority = 38, groups = {"Sanity","BS_Sanity","Sanity_Chrome"},dataProviderClass =Test_DataSanity.class, dataProvider="IndexLinksAllSites")
  public void OurFreeTrialsLink_Test(String Websitename, String WebsiteUrl, String Path) {
	  
	 test = report.startTest("Nav Links Test --> OurFreeTrialsLink Test" + Websitename);
	 
	  driver.get(WebsiteUrl);
	  driver.manage().window().maximize();
	  driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);

	  try {
			 NavigationElements.OurFreeTrialsLinkClick();	    	
			 Thread.sleep(1000);		
			 
			 // TODO - Find All Links Method
		        
			 Links.Submenupagelinks(Websitename, Path, WebsiteUrl);		    	
	 
	 	  	
	  }catch (Exception e) {
	 	  						
	 	  		test.log(LogStatus.FAIL, "Validation Failed");
	 	  		Assert.fail("Exception " + e);
	  }
	   
  } 
  
  @Test (priority = 39, groups = {"Sanity","BS_Sanity","Sanity_Chrome"},dataProviderClass =Test_DataSanity.class, dataProvider="IndexLinksAllSites")
  public void FreeTrialSslLink_Test(String Websitename, String WebsiteUrl, String Path) {
	  
	 test = report.startTest("Nav Links Test --> FreeTrialSslLink Test" + Websitename);
	 
	  driver.get(WebsiteUrl);
	  driver.manage().window().maximize();
	  driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);	 

	  try {
			 NavigationElements.FreeTrialSslLinkClick();	    	
			 Thread.sleep(1000);		
			 
			 // TODO - Find All Links Method
		        
			 Links.Submenupagelinks(Websitename, Path, WebsiteUrl);		    	
	 
	 	  	
	  }catch (Exception e) {
	 	  						
	 	  		test.log(LogStatus.FAIL, "Validation Failed");
	 	  		Assert.fail("Exception " + e);
	  }
	   
  } 
  
  @Test (priority = 40, groups = {"Sanity","BS_Sanity","Sanity_Chrome"},dataProviderClass =Test_DataSanity.class, dataProvider="IndexLinksAllSites")
  public void FreeVulnerabilityScanLink_Test(String Websitename, String WebsiteUrl, String Path) {
	  
	 test = report.startTest("Nav Links Test --> FreeVulnerabilityScanLink Test" + Websitename);
	 
	  driver.get(WebsiteUrl);
	  driver.manage().window().maximize();
	  driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);

	  try {
			 NavigationElements.FreeVulnerabilityScanLinkClick();	    	
			 Thread.sleep(1000);
			 
			 // TODO - Find All Links Method
		        
			 Links.Submenupagelinks(Websitename, Path, WebsiteUrl);		    	
	 
	 	  	
	  }catch (Exception e) {
	 	  						
	 	  		test.log(LogStatus.FAIL, "Validation Failed");
	 	  		Assert.fail("Exception " + e);
	  }
	   
  } 
  
  @Test (priority = 41, groups = {"Sanity","BS_Sanity","Sanity_Chrome"},dataProviderClass =Test_DataSanity.class, dataProvider="IndexLinksAllSites")
  public void WhoWeAreLink_Test(String Websitename, String WebsiteUrl, String Path) {
	  
	 test = report.startTest("Nav Links Test --> WhoWeAreLink Test" + Websitename);
	 
	  driver.get(WebsiteUrl);
	  driver.manage().window().maximize();
	  driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);

	  try {
			 NavigationElements.WhoWeAreLinkClick();	    	
			 Thread.sleep(1000);	
			 
			 // TODO - Find All Links Method
		        
			 Links.Submenupagelinks(Websitename, Path, WebsiteUrl);		    	
	 
	 	  	
	  }catch (Exception e) {
	 	  						
	 	  		test.log(LogStatus.FAIL, "Validation Failed");
	 	  		Assert.fail("Exception " + e);
	  }
	   
  }
  
  @Test (priority = 42, groups = {"Sanity","BS_Sanity","Sanity_Chrome"},dataProviderClass =Test_DataSanity.class, dataProvider="IndexLinksAllSites")
  public void OnlineBusinessContinuityLink_Test(String Websitename, String WebsiteUrl, String Path) {
	  
	 test = report.startTest("Nav Links Test --> OnlineBusinessContinuityLink Test" + Websitename);
	 
	  driver.get(WebsiteUrl);
	  driver.manage().window().maximize();
	  driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);

	  try {
			 NavigationElements.OnlineBusinessContinuityLinkClick();	    	
			 Thread.sleep(1000);
			 
			 // TODO - Find All Links Method
		        
			 Links.Submenupagelinks(Websitename, Path, WebsiteUrl);		    	
	 
	 	  	
	  }catch (Exception e) {
	 	  						
	 	  		test.log(LogStatus.FAIL, "Validation Failed");
	 	  		Assert.fail("Exception " + e);
	  }
	   
  }
  
  @Test (priority = 43, groups = {"Sanity","BS_Sanity","Sanity_Chrome"},dataProviderClass =Test_DataSanity.class, dataProvider="IndexLinksAllSites")
  public void ContactLink_Test(String Websitename, String WebsiteUrl, String Path) {
	  
	 test = report.startTest("Nav Links Test --> ContactLink Test" + Websitename);
	 
	  driver.get(WebsiteUrl);
	  driver.manage().window().maximize();
	  driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);

	  try {
			 NavigationElements.ContactLinkClick();	    	
			 Thread.sleep(1000);
			 
			 // TODO - Find All Links Method
		        
			 Links.Submenupagelinks(Websitename, Path, WebsiteUrl);		    	
	 
	 	  	
	  }catch (Exception e) {
	 	  						
	 	  		test.log(LogStatus.FAIL, "Validation Failed");
	 	  		Assert.fail("Exception " + e);
	  }
	   
  }
  
  @Test (priority = 44, groups = {"Sanity","BS_Sanity","Sanity_Chrome"},dataProviderClass =Test_DataSanity.class, dataProvider="IndexLinksAllSites")
  public void TestimonialsLink_Test(String Websitename, String WebsiteUrl, String Path) {
	  
	 test = report.startTest("Nav Links Test --> TestimonialsLink Test" + Websitename);
	 
	  driver.get(WebsiteUrl);
	  driver.manage().window().maximize();
	  driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);

	  try {
			 NavigationElements.TestimonialsLinkClick();	    	
			 Thread.sleep(1000);
			 
			 // TODO - Find All Links Method
		        
			 Links.Submenupagelinks(Websitename, Path, WebsiteUrl);		    	
	 
	 	  	
	  }catch (Exception e) {
	 	  						
	 	  		test.log(LogStatus.FAIL, "Validation Failed");
	 	  		Assert.fail("Exception " + e);
	  }
	   
  }
  
  @Test (priority = 45, groups = {"Sanity","BS_Sanity","Sanity_Chrome"},dataProviderClass =Test_DataSanity.class, dataProvider="IndexLinksAllSites")
  public void AccreditationsLink_Test(String Websitename, String WebsiteUrl, String Path) {
	  
	 test = report.startTest("Nav Links Test --> AccreditationsLink Test" + Websitename);
	  
	  driver.get(WebsiteUrl);
	  driver.manage().window().maximize();
	  driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);

	  try {
			 NavigationElements.AccreditationsLinkClick();	    	
			 Thread.sleep(1000);
			 
			 // TODO - Find All Links Method
		        
			 Links.Submenupagelinks(Websitename, Path, WebsiteUrl);		    	
	 
	 	  	
	  }catch (Exception e) {
	 	  						
	 	  		test.log(LogStatus.FAIL, "Validation Failed");
	 	  		Assert.fail("Exception " + e);
	  }
	   
  }
  
  @Test (priority = 46, groups = {"Sanity","BS_Sanity","Sanity_Chrome"},dataProviderClass =Test_DataSanity.class, dataProvider="IndexLinksAllSites")
  public void CareersLink_Test(String Websitename, String WebsiteUrl, String Path) {
	  
	 test = report.startTest("Nav Links Test --> CareersLink Test" + Websitename);
	 
	  driver.get(WebsiteUrl);
	  driver.manage().window().maximize();
	  driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);

	  try {
			 NavigationElements.CareersLinkClick();	    	
			 Thread.sleep(1000);
			  
			 // TODO - Find All Links Method
		        
			 Links.Submenupagelinks(Websitename, Path, WebsiteUrl);		    	
	 
	 	  	
	  }catch (Exception e) {
	 	  						
	 	  		test.log(LogStatus.FAIL, "Validation Failed");
	 	  		Assert.fail("Exception " + e);
	  }
	   
  }
  
  @Test (priority = 47, groups = {"Sanity","BS_Sanity","Sanity_Chrome"},dataProviderClass =Test_DataSanity.class, dataProvider="IndexLinksAllSites")
  public void HelpAndSuppotLink_Test(String Websitename, String WebsiteUrl, String Path) {
	  
	 test = report.startTest("Nav Links Test --> HelpAndSuppotLink Test" + Websitename);
	 
	  driver.get(WebsiteUrl);
	  driver.manage().window().maximize();
	  driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);

	  try {
			 NavigationElements.HelpAndSuppotLinkClick();	    	
			 Thread.sleep(1000);
			 
			 // TODO - Find All Links Method
		        
			 Links.Submenupagelinks(Websitename, Path, WebsiteUrl);		    	
	 
	 	  	
	  }catch (Exception e) {
	 	  						
	 	  		test.log(LogStatus.FAIL, "Validation Failed");
	 	  		Assert.fail("Exception " + e);
	  }
	   
  }
  
  @Test (priority = 48, groups = {"Sanity","BS_Sanity","Sanity_Chrome"},dataProviderClass =Test_DataSanity.class, dataProvider="IndexLinksAllSites")
  public void KnowledgeBaseLink_Test(String Websitename, String WebsiteUrl, String Path) {
	  
	 test = report.startTest("Nav Links Test --> KnowledgeBaseLink Test" + Websitename);
	 
	  driver.get(WebsiteUrl);
	  driver.manage().window().maximize();
	  driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);

	  try {
			 NavigationElements.KnowledgeBaseLinkClick();	    	
			 Thread.sleep(1000);
			 
			 // TODO - Find All Links Method
		        
			 Links.Submenupagelinks(Websitename, Path, WebsiteUrl);		    	
	 
	 	  	
	  }catch (Exception e) {
	 	  						
	 	  		test.log(LogStatus.FAIL, "Validation Failed");
	 	  		Assert.fail("Exception " + e);
	  }
	   
  }
  
  @Test (priority = 49, groups = {"Sanity","BS_Sanity","Sanity_Chrome"},dataProviderClass =Test_DataSanity.class, dataProvider="IndexLinksAllSites")
  public void SslToolsLink_Test(String Websitename, String WebsiteUrl, String Path) {
	  
	 test = report.startTest("Nav Links Test --> SslToolsLink Test" + Websitename);
	 
	  driver.get(Websitename);
	  driver.manage().window().maximize();
	  driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);

	  try {
			 NavigationElements.SslToolsLinkClick();	    	
			 Thread.sleep(1000);
			 
			 // TODO - Find All Links Method
		        
			 Links.Submenupagelinks(Websitename, Path, WebsiteUrl);		    	
	 
	 	  	
	  }catch (Exception e) {
	 	  						
	 	  		test.log(LogStatus.FAIL, "Validation Failed");
	 	  		Assert.fail("Exception " + e);
	  }
	   
  }
  
  @Test (priority = 50, groups = {"Sanity","BS_Sanity","Sanity_Chrome"},dataProviderClass =Test_DataSanity.class, dataProvider="IndexLinksAllSites")
  public void Sha1CheckerLink_Test(String Websitename, String WebsiteUrl, String Path) {
	  
	 test = report.startTest("Nav Links Test --> Sha1CheckerLink Test" + Websitename);
	 
	  driver.get(WebsiteUrl);
	  driver.manage().window().maximize();
	  driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);

	  try {
			 NavigationElements.Sha1CheckerLinkClick();	    	
			 Thread.sleep(1000);
			 
			 // TODO - Find All Links Method
		        
			 Links.Submenupagelinks(Websitename, Path, WebsiteUrl);		    	
	 
	 	  	
	  }catch (Exception e) {
	 	  						
	 	  		test.log(LogStatus.FAIL, "Validation Failed");
	 	  		Assert.fail("Exception " + e);
	  }
	   
  }
  
  @Test (priority = 51, groups = {"Sanity","BS_Sanity","Sanity_Chrome"},dataProviderClass =Test_DataSanity.class, dataProvider="IndexLinksAllSites")
  public void CsrGeneratorLink_Test(String Websitename, String WebsiteUrl, String Path) {
	  
	 test = report.startTest("Nav Links Test --> CsrGeneratorLink Test" + Websitename);
	 
	  driver.get(WebsiteUrl);
	  driver.manage().window().maximize();
	  driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);

	  try {
			 NavigationElements.CsrGeneratorLinkClick();	    	
			 Thread.sleep(1000);
			 
			 
			 // TODO - Find All Links Method
		        
			 Links.Submenupagelinks(Websitename, Path, WebsiteUrl);		    	
	 
	 	  	
	  }catch (Exception e) {
	 	  						
	 	  		test.log(LogStatus.FAIL, "Validation Failed");
	 	  		Assert.fail("Exception " + e);
	  }
	   
  }
  
  @Test (priority = 52, groups = {"Sanity","BS_Sanity","Sanity_Chrome"},dataProviderClass =Test_DataSanity.class, dataProvider="IndexLinksAllSites")
  public void CreateCsrLink_Test(String Websitename, String WebsiteUrl, String Path) {
	  
	 test = report.startTest("Nav Links Test --> CreateCsrLink Test" + Websitename);
	 
	  driver.get(WebsiteUrl);
	  driver.manage().window().maximize();
	  driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);

	  try {
			 NavigationElements.CreateCsrLinkClick();	    	
			 Thread.sleep(1000);
			 
			 // TODO - Find All Links Method
		        
			 Links.Submenupagelinks(Websitename, Path, WebsiteUrl);		    	
	 
	 	  	
	  }catch (Exception e) {
	 	  						
	 	  		test.log(LogStatus.FAIL, "Validation Failed");
	 	  		Assert.fail("Exception " + e);
	  }
	   
  }
  
  @Test (priority = 53, groups = {"Sanity","BS_Sanity","Sanity_Chrome"},dataProviderClass =Test_DataSanity.class, dataProvider="IndexLinksAllSites")
  public void InstallCertificateLink_Test(String Websitename, String WebsiteUrl, String Path) {
	  
	 test = report.startTest("Nav Links Test --> InstallCertificateLink Test" + Websitename);
	 
	  driver.get(WebsiteUrl);
	  driver.manage().window().maximize();
	  driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);

	  try {
			 NavigationElements.InstallCertificateLinkClick();	    	
			 Thread.sleep(1000);
			 
			 // TODO - Find All Links Method
		        
			 Links.Submenupagelinks(Websitename, Path, WebsiteUrl);		    	
	 
	 	  	
	  }catch (Exception e) {
	 	  						
	 	  		test.log(LogStatus.FAIL, "Validation Failed");
	 	  		Assert.fail("Exception " + e);
	  }
	   
  }
  
  @Test (priority = 54, groups = {"Sanity","BS_Sanity","Sanity_Chrome"},dataProviderClass =Test_DataSanity.class, dataProvider="IndexLinksAllSites")
  public void InstallSiteSealLink_Test(String Websitename, String WebsiteUrl, String Path) {
	  
	 test = report.startTest("Nav Links Test --> InstallSiteSealLink Test" + Websitename);
	 
	  driver.get(WebsiteUrl);
	  driver.manage().window().maximize();
	  driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);

	  try {
			 NavigationElements.InstallSiteSealLinkClick();	    	
			 Thread.sleep(1000);
			 
			 // TODO - Find All Links Method
		        
			 Links.Submenupagelinks(Websitename, Path, WebsiteUrl);		    	
	 
	 	  	
	  }catch (Exception e) {
	 	  						
	 	  		test.log(LogStatus.FAIL, "Validation Failed");
	 	  		Assert.fail("Exception " + e);
	  }
	   
  }
  
  @Test (priority = 55, groups = {"Sanity","BS_Sanity","Sanity_Chrome"},dataProviderClass =Test_DataSanity.class, dataProvider="IndexLinksAllSites")
  public void ImportExportTipsLink_Test(String Websitename, String WebsiteUrl, String Path) {
	  
	 test = report.startTest("Nav Links Test --> ImportExportTipsLink Test" + Websitename);
	 
	  driver.get(WebsiteUrl);
	  driver.manage().window().maximize();
	  driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);

	  try {
			 NavigationElements.ImportExportTipsLinkClick();	    	
			 Thread.sleep(1000);
			 
			 // TODO - Find All Links Method
		        
			 Links.Submenupagelinks(Websitename, Path, WebsiteUrl);		    	
	 
	 	  	
	  }catch (Exception e) {
	 	  						
	 	  		test.log(LogStatus.FAIL, "Validation Failed");
	 	  		Assert.fail("Exception " + e);
	  }
	   
  }
  
  
  @Test (priority = 56, groups = {"Sanity","BS_Sanity","Sanity_Chrome"},dataProviderClass =Test_DataSanity.class, dataProvider="IndexLinksAllSites")
  public void DownloadRootsCertificatesLink_Test(String Websitename, String WebsiteUrl, String Path) {
	  
	 test = report.startTest("Nav Links Test --> DownloadRootsCertificatesLink Test" + Websitename);
	 
	  driver.get(WebsiteUrl);
	  driver.manage().window().maximize();
	  driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);

	  try {
			 NavigationElements.DownloadRootsCertificatesLinkClick();	    	
			 Thread.sleep(1000);
			 
			 // TODO - Find All Links Method
		        
			 Links.Submenupagelinks(Websitename, Path, WebsiteUrl);		    	
	 
	 	  	
	  }catch (Exception e) {
	 	  						
	 	  		test.log(LogStatus.FAIL, "Validation Failed");
	 	  		Assert.fail("Exception " + e);
	  }
	   
  }
  
  @Test (priority = 57, groups = {"Sanity","BS_Sanity","Sanity_Chrome"},dataProviderClass =Test_DataSanity.class, dataProvider="IndexLinksAllSites")
  public void RenewalsWithSsl247_SupportLink_Test(String Websitename, String WebsiteUrl, String Path) {
	  
	 test = report.startTest("Nav Links Test --> RenewalsWithSsl247_SupportLink Test" + Websitename);
	 
	  driver.get(WebsiteUrl);
	  driver.manage().window().maximize();
	  driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);

	  try {
			 NavigationElements.RenewalsWithSsl247_SupportLinkClick();	    	
			 Thread.sleep(1000);
			 
			 // TODO - Find All Links Method
		        
			 Links.Submenupagelinks(Websitename, Path, WebsiteUrl);		    	
	 
	 	  	
	  }catch (Exception e) {
	 	  						
	 	  		test.log(LogStatus.FAIL, "Validation Failed");
	 	  		Assert.fail("Exception " + e);
	  }
	   
  }
  
  @Test (priority = 58, groups = {"Sanity","BS_Sanity","Sanity_Chrome"},dataProviderClass =Test_DataSanity.class, dataProvider="IndexLinksAllSites")
  public void RenewYourSslCertificate_SupportLink_Test(String Websitename, String WebsiteUrl, String Path) {
	  
	 test = report.startTest("Nav Links Test --> RenewYourSslCertificate_SupportLink Test" + Websitename);
	 
	  driver.get(WebsiteUrl);
	  driver.manage().window().maximize();
	  driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);

	  try {
			 NavigationElements.RenewYourSslCertificate_SupportLinkClick();	    	
			 Thread.sleep(1000);
			 
			 // TODO - Find All Links Method
		        
			 Links.Submenupagelinks(Websitename, Path, WebsiteUrl);		    	
	 
	 	  	
	  }catch (Exception e) {
	 	  						
	 	  		test.log(LogStatus.FAIL, "Validation Failed");
	 	  		Assert.fail("Exception " + e);
	  }
	   
  }
  
}
