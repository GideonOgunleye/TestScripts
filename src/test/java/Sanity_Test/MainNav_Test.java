package Sanity_Test;

import org.testng.annotations.Test;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import PageFactory.AlertBox;
import PageFactory.BrowserStack;
import PageFactory.DriverLoad;
import PageFactory.ExtentFactory;
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

  @BeforeMethod (groups = {"Smoke","BS_Smoke"})
  public void beforeMethod() throws Exception {
	  
	  NavigationElements = new NavigationLinks(driver);
	  LoginPageElements = new LoginPage(driver);
	  AlertBoxElements = new AlertBox(driver);
	  
	  LoginPageElements.LoadLoginPage();
	  report = ExtentFactory.getInstance3();
	  //test.log(LogStatus.INFO, "Browser Opened and Url Entered");
	  
  }

  @AfterMethod (groups = {"Smoke","BS_Smoke"})
  public String afterMethod(ITestResult result) throws IOException, Exception {
	  
	  String filename = result.getMethod().getMethodName() +".png";
	    String Directory = "C:\\Screenshots\\Sanity ScreenShots\\";
		  
	    File sourceFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(sourceFile, new File(Directory + filename));
		  
		String destination = Directory + filename;
		
		String path = destination;
		String imagePath = test.addScreenCapture(path);
		test.log(LogStatus.INFO, "Test Complete", imagePath);
		
		Thread.sleep(5000);
		driver.navigate().refresh();
		
	
		test.log(LogStatus.INFO, "Browser Refreshed");
		report.endTest(test);
		report.flush();
	
		return destination;
	  
  }
  
  @Test (priority = 0, groups = {"Smoke","BS_Smoke"})
  public void SSL_Certlink_Test() {
	  
	  test = report.startTest("Nav Links Test --> SSL Cert link Test");
	  
	  NavigationElements.ClickSslCertificatesLink();
	  test.log(LogStatus.INFO, "Page Opened");
	  
	  String PageTitle = "SSL247's SSL Certificates";
		
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
  
  @Test (priority = 1, groups = {"Smoke","BS_Smoke"})
  public void FreeSsl_Link_Test() {
	  
	  test = report.startTest("Nav Links Test --> FreeSsl Link Test");
	  
	  NavigationElements.ClickFreeSslLink();
	  
	  test.log(LogStatus.INFO, "Page Opened");
	  
	  String PageTitle = "GeoTrust Free Trial";
		
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
  
  @Test (priority = 2, groups = {"Smoke","BS_Smoke"})
  public void ProtectAndSecure_Link_Test() {
	  
	  test = report.startTest("Nav Links Test --> Protect And Secure Link Test");
	  
	  NavigationElements.ClickProtectAndSecureLink();
	  
	  test.log(LogStatus.INFO, "Page Opened");
	  
	  String PageTitle = "Penetration Testing: Advanced professional testing by accredited experts";
		
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
  
  @Test (priority = 4, groups = {"Smoke","BS_Smoke"})
  public void Identify_Link_Test() {
	  
	  test = report.startTest("Nav Links Test --> Identify Link Test");
	  
	  NavigationElements.ClickIdentifyLink();
	  
	  test.log(LogStatus.INFO, "Page Opened");
	  
	  String PageTitle = "Digital IDs from SSL247";
		
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
  
  @Test (priority = 5, groups = {"Smoke","BS_Smoke"})
  public void Register_Link_Test() {
	  
	  test = report.startTest("Nav Links Test --> Register Link Test");
	  
	  NavigationElements.ClickRegisterLink();
	  
	  test.log(LogStatus.INFO, "Page Opened");
	  
	  String PageTitle = "Get your Domain Name Now";
		
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
  
  @Test (priority = 6, groups = {"Smoke","BS_Smoke"})
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
  
  @Test (priority = 7, groups = {"Smoke","BS_Smoke"})
  public void BecomePartner_Link_Test() {
	  
	  test = report.startTest("Nav Links Test --> Become Partner Link Test");
	  
	  NavigationElements.ClickBecomePartnerLink();
	  
	  test.log(LogStatus.INFO, "Page Opened");
	  
	  String PageTitle = "Grow your business by joining our partners programs!";
		
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
  
  @Test (priority = 8, groups = {"Smoke","BS_Smoke"})
  public void MySsl_Link_Test() {
	  
	  test = report.startTest("Nav Links Test --> MySsl Link Test");
	  
	  NavigationElements.ClickMySslLink();
	  
	  test.log(LogStatus.INFO, "Page Opened");
	  
	  String PageTitle = "MySSL® Account Login";
		
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
  
  @Test (priority = 9, groups = {"Smoke","BS_Smoke"})
  public void FreeTrials_Link_Test() {
	  
	  test = report.startTest("Nav Links Test --> Free Trials Link Test");
	  
	  NavigationElements.ClickFreeTrialsLink();
	  
	  test.log(LogStatus.INFO, "Page Opened");
	  
	  String PageTitle = "Free trials";
		
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
  
  @Test (priority = 10, groups = {"Smoke","BS_Smoke"})
  public void Wizard_Link_Test() {
	  
	  test = report.startTest("Nav Links Test --> Wizard Link Test");
	  
	  NavigationElements.ClickWizardLink();
	  
	  test.log(LogStatus.INFO, "Page Opened");
	  
	  String PageTitle = "SSL Certificates: Buy Symantec, Thawte, Apache SSL Cert, GlobalSign, GeoTrust, RapidSSL- SSL247.co.uk";
		
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
  
  @Test (priority = 11, groups = {"Smoke","BS_Smoke"})
  public void About_Link_Test() {
	  
	  test = report.startTest("Nav Links Test --> About Link Test");
	  
	  NavigationElements.ClickAboutLink();
	  
	  test.log(LogStatus.INFO, "Page Opened");
	  
	  String PageTitle = "About SSL247® – The Web Security Consultants";
		
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
  
  @Test (priority = 12, groups = {"Smoke","BS_Smoke"})
  public void Support_Link_Test() {
	  
	  test = report.startTest("Nav Links Test --> Support Link Test");
	  
	  NavigationElements.ClickSupportLink();
	  
	  test.log(LogStatus.INFO, "Page Opened");
	  
	  String PageTitle = "Help and Support - Install your SSL Certificate";
		
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
  
  @Test (priority = 13, groups = {"Smoke","BS_Smoke"})
  public void Blog_Link_Test() {
	  
	  test = report.startTest("Nav Links Test --> Blog Link Test");
	  
	  NavigationElements.ClickBlogLink();
	  
	  test.log(LogStatus.INFO, "Page Opened");
	  
	  String PageTitle = "SSL247 Blog";
		
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

}
