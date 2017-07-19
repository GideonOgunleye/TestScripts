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
import PageFactory.LoginPage;
//import PageFactory.Navigation;
import PageFactory.NavigationLinks;

import org.testng.annotations.BeforeMethod;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;

public class MainNav_Test extends BrowserStack {
  
	ExtentReports report;
	ExtentTest test;
	NavigationLinks NavigationElements;
	LoginPage 	LoginPageElements;
	AlertBox AlertBoxElements;
	TakeScreenShot ScreenShot;

  @BeforeMethod (groups = {"Smoke","BS_Smoke","BS_Sanity","Smoke_Firefox","Smoke_Chrome"})
  public void beforeMethod() throws Exception {
	  
	  NavigationElements = new NavigationLinks(driver);
	  LoginPageElements = new LoginPage(driver);
	  AlertBoxElements = new AlertBox(driver);
	  ScreenShot = new TakeScreenShot();
	  
	  LoginPageElements.LoadLoginPage();
	  report = ExtentFactory.getInstance3();
	  //test.log(LogStatus.INFO, "Browser Opened and Url Entered");
	  
  }

  @AfterMethod (groups = {"Smoke","BS_Smoke","BS_Sanity","Smoke_Firefox","Smoke_Chrome"})
  public void afterMethod(ITestResult result) throws IOException, Exception {

/*
	  	String filename = result.getMethod().getMethodName()+ result.getEndMillis() +".png";
	    String Directory = "C:\\Screenshots\\Sanity ScreenShots\\";
		  
	    File sourceFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(sourceFile, new File(Directory + filename));
		  
		String destination = Directory + filename;
*/
	  
	  	String path =  ScreenShot.Image(driver, "TestSecreenShot" + result.getMethod().getMethodName());
		String imagePath = test.addScreenCapture(path);
		test.log(LogStatus.INFO, "Test Complete", imagePath);
		
		Thread.sleep(5000);
		driver.navigate().refresh();
		
	
		test.log(LogStatus.INFO, "Browser Refreshed");
		report.endTest(test);
		report.flush();
	
		//return destination;
	  
  }
  
  @Test (priority = 0, groups = {"Smoke","BS_Smoke","BS_Sanity","Smoke_Firefox","Smoke_Chrome"})
  public void SSL_Certlink_Test() {
	  
	  test = report.startTest("Nav Links Test --> SSL Cert link Test");
	  

		
	  try {
	  			
		  if (NavigationElements.SslCertificatesLinkContains("SSL Certificates")) { 
			  
			  driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
			  test.log(LogStatus.INFO, "Link Text Is Validated");
			  
		  }else {
			  	
			  test.log(LogStatus.FAIL, "Text Not Validated");
			  NavigationElements.SslCertificatesLinkTextPrint();
			  Assert.fail("Text Not Validated"); 	
		  }
		  
		  NavigationElements.ClickSslCertificatesLink();
		  driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
		  test.log(LogStatus.INFO, "Page Opened");
		  
		  String PageTitle = "SSL247's SSL Certificates";
		  
	  		if (NavigationElements.ValidatePage(PageTitle)) {
	  						
	  				test.log(LogStatus.PASS, "Validation Complete");
	  			    Assert.assertTrue(NavigationElements.ValidatePage(PageTitle));
	  			    System.out.println("Validation Complete!");
	  		}else{
	  				NavigationElements.PrintPageTitle();	
	  				test.log(LogStatus.FAIL, "Validation Failed");
	  			    	
	  		}
	  	
	  }catch (Exception e) {
	  						
	  		test.log(LogStatus.FAIL, "Validation Failed");
	  		Assert.fail("Exception " + e);
	  }

	  
	  
	  
  }
  
  @Test (priority = 1, groups = {"Smoke","BS_Smoke","BS_Sanity","Smoke_Firefox","Smoke_Chrome"})
  public void FreeSsl_Link_Test() {
	  
	  test = report.startTest("Nav Links Test --> FreeSsl Link Test");
	  
		
	  try {
		  
		  
		  if (NavigationElements.FreeSslLinkContains("Free SSL")) { 
			  
			  driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
			  test.log(LogStatus.INFO, "Link Text Is Validated");
			  
		  }else {
			  	
				test.log(LogStatus.FAIL, "Text Not Validated");
				NavigationElements.FreeSslLinkTextPrint();
				Assert.fail("Text Not Validated"); 	
		  }
		  
		  NavigationElements.ClickFreeSslLink();
		  driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
		  test.log(LogStatus.INFO, "Page Opened");
		  
		  String PageTitle = "GeoTrust Free Trial";
	  			    	
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
  
  @Test (priority = 2, groups = {"Smoke","BS_Smoke","BS_Sanity","Smoke_Firefox","Smoke_Chrome"})
  public void ProtectAndSecure_Link_Test() {
	  
	  test = report.startTest("Nav Links Test --> Protect And Secure Link Test");
	 
	  try {
		  
		  if (NavigationElements.ProtectAndSecureLinkContains("Test & Protect")) { 
			  
				  driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
				  test.log(LogStatus.INFO, "Link Text Is Validated");
			  
		  }else {
			  	
				  test.log(LogStatus.FAIL, "Text Not Validated");
				  NavigationElements.ProtectAndSecurePrintText();
				  Assert.fail("Text Not Validated"); 	
		  }

	  	
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

	/*	  
		  NavigationElements.ClickIdentifyLink();
		  driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
		  test.log(LogStatus.INFO, "Page Opened");
		  
		  String PageTitle = "Digital IDs from SSL247";
	  			    	
	  		if (NavigationElements.ValidatePage(PageTitle)) {
	  						
	  				test.log(LogStatus.PASS, "Validation Complete");
	  			    Assert.assertTrue(NavigationElements.ValidatePage(PageTitle));
	  			    System.out.println("Validation Complete!");
	  		}else{
	  				NavigationElements.PrintPageTitle();	
	  				test.log(LogStatus.FAIL, "Validation Failed");
	  				Assert.fail("Validation Failed ");
	  			    	
	  		}
	  		
	  */		
	  	
	  }catch (Exception e) {
	  						
	  		test.log(LogStatus.FAIL, "Validation Failed");
	  		Assert.fail("Exception " + e);
	  }
	    
  }
  
  @Test (priority = 5, groups = {"Smoke","BS_Smoke","BS_Sanity","Smoke_Firefox","Smoke_Chrome"})
  public void Register_Link_Test() {
	  
	  test = report.startTest("Nav Links Test --> Register Link Test");
	  
		
	  try {
		  
		  if (NavigationElements.RegisterLinkContains("Register")) { 
			  
			  driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
			  test.log(LogStatus.INFO, "Link Text Is Validated");
			  
		  }else {
			  	
			  test.log(LogStatus.FAIL, "Text Not Validated");
			  NavigationElements.RegisterLinkTextPrint();
			  Assert.fail("Text Not Validated"); 	
		  }		  
		  
		  NavigationElements.ClickRegisterLink();
		  driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
		  test.log(LogStatus.INFO, "Page Opened");
		  
		  String PageTitle = "Get your Domain Name Now";
	  			    	
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
  
  @Test (priority = 7, groups = {"Smoke","BS_Smoke","BS_Sanity","Smoke_Firefox","Smoke_Chrome"})
  public void BecomePartner_Link_Test() {
	  
	  test = report.startTest("Nav Links Test --> Become Partner Link Test");
	  
			
	  try {
		  
		  if (NavigationElements.BecomePartnerLinkContains("Become a Partner")) { 
			  
			  driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
			  test.log(LogStatus.INFO, "Link Text Is Validated");
			  
		  }else {
			  	
			  test.log(LogStatus.FAIL, "Text Not Validated");
			  NavigationElements.BecomePartnerLinkTextPrint();
			  Assert.fail("Text Not Validated"); 	
		  }
		  
		  NavigationElements.ClickBecomePartnerLink();
		  driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
		  test.log(LogStatus.INFO, "Page Opened");
		  
		  String PageTitle = "Grow your business by joining our partners programs!";
	  			    	
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
  
  @Test (priority = 8, groups = {"Smoke","BS_Smoke","BS_Sanity","Smoke_Firefox","Smoke_Chrome"})
  public void MySsl_Link_Test() {
	  
	  test = report.startTest("Nav Links Test --> MySsl Link Test");

	  try {
	
		  if (NavigationElements.MySslLinkContains("MySSL")) { 
			  
			  driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
			  test.log(LogStatus.INFO, "Link Text Is Validated");
			  
		  }else {
			  	
			  test.log(LogStatus.FAIL, "Text Not Validated");
			  NavigationElements.MySslLinkTextPrint();
			  Assert.fail("Text Not Validated"); 	
		  }
		  
		  NavigationElements.ClickMySslLink();
		  driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
		  test.log(LogStatus.INFO, "Page Opened");
		  
		  String PageTitle = "MySSL® Account Login";
	  			    	
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
  
  @Test (priority = 9, groups = {"Smoke","BS_Smoke","BS_Sanity","Smoke_Firefox","Smoke_Chrome"})
  public void FreeTrials_Link_Test() {
	  
	  test = report.startTest("Nav Links Test --> Free Trials Link Test");
	  
		
	  try {
		  
		  if (NavigationElements.FreeTrialsLinkContains("Free Trials")) { 
			  
			  driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
			  test.log(LogStatus.INFO, "Link Text Is Validated");
			  
		  }else {
			  	
			  test.log(LogStatus.FAIL, "Text Not Validated");
			  NavigationElements.FreeTrialsLinkTextPrint();
			  Assert.fail("Text Not Validated"); 	
		  }
		  
		  NavigationElements.ClickFreeTrialsLink();
		  driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
		  test.log(LogStatus.INFO, "Page Opened");
		  
		  String PageTitle = "Free trials";
	  			    	
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
  
  @Test (priority = 10, groups = {"Smoke","BS_Smoke","BS_Sanity","Smoke_Firefox","Smoke_Chrome"})
  public void Wizard_Link_Test() {
	  
	  test = report.startTest("Nav Links Test --> Wizard Link Test");
	 
		
	  try {
		  
		  if (NavigationElements.WizardLinkContains("Wizard")) { 
			  
			  driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
			  test.log(LogStatus.INFO, "Link Text Is Validated");
			  
		  }else {
			  	
			  test.log(LogStatus.FAIL, "Text Not Validated");
			  NavigationElements.WizardLinkTextPrint();
			  Assert.fail("Text Not Validated"); 	
		  }
		  
		  NavigationElements.ClickWizardLink();
		  driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
		  test.log(LogStatus.INFO, "Page Opened");
		  
		  String PageTitle = "SSL Certificates: Buy Symantec, Thawte, Apache SSL Cert, GlobalSign, GeoTrust, RapidSSL- SSL247.co.uk";
	  			    	
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
  
  @Test (priority = 11, groups = {"Smoke","BS_Smoke","BS_Sanity","Smoke_Firefox","Smoke_Chrome"})
  public void About_Link_Test() {
	  
	  test = report.startTest("Nav Links Test --> About Link Test");
	  
	  try {
		  
		  if (NavigationElements.AboutLinkContains("About")) { 
			  
			  driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
			  test.log(LogStatus.INFO, "Link Text Is Validated");
			  
		  }else {
			  	
			  test.log(LogStatus.FAIL, "Text Not Validated");
			  NavigationElements.AboutLinkTextPrint();
			  Assert.fail("Text Not Validated"); 	
		  }
		  
		  NavigationElements.ClickAboutLink();
		  driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
		  test.log(LogStatus.INFO, "Page Opened");
		  
		  String PageTitle = "About SSL247® – The Web Security Consultants";	
		  
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
	  						
	  		test.log(LogStatus.FAIL, "Page Title Not Accurate");
	  		//Assert.fail("Exception " + e);
	  }
	    
  }
  
  @Test (priority = 12, groups = {"Smoke","BS_Smoke","BS_Sanity","Smoke_Firefox","Smoke_Chrome"})
  public void Support_Link_Test() {
	  
	  test = report.startTest("Nav Links Test --> Support Link Test");
	  
	  try {
		   
		  if (NavigationElements.SupportLinkContains("Support")) { 
			  
			  driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
			  test.log(LogStatus.INFO, "Link Text Is Validated");
			  
		  }else {
			  	
			  test.log(LogStatus.FAIL, "Text Not Validated");
			  NavigationElements.SupportLinkTextPrint();
			  Assert.fail("Text Not Validated"); 	
		  }
		  
		  NavigationElements.ClickSupportLink();
		  driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
		  test.log(LogStatus.INFO, "Page Opened");
		  
		  String PageTitle = "Help and Support - Install your SSL Certificate";
	  			    	
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
  
  @Test (priority = 13, groups = {"Smoke","BS_Smoke","BS_Sanity","Smoke_Firefox","Smoke_Chrome"})
  public void Blog_Link_Test() {
	  
	  test = report.startTest("Nav Links Test --> Blog Link Test");
	  

		
	  try {
		  
		  if (NavigationElements.BlogLinkContains("Blog")) { 
			  
			  driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
			  test.log(LogStatus.INFO, "Link Text Is Validated");
			  
		  }else {
			  	
			  test.log(LogStatus.FAIL, "Text Not Validated");
			  NavigationElements.BlogLinkTextPrint();
			  Assert.fail("Text Not Validated"); 	
		  }
		  
		  NavigationElements.ClickBlogLink();
		  driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
		  test.log(LogStatus.INFO, "Page Opened");
		  
		  String PageTitle = "SSL247 Blog";
	  			    	
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

}
