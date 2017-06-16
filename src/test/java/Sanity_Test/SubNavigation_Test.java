package Sanity_Test;

import org.testng.annotations.Test;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import PageFactory.BrowserStack;
import PageFactory.DriverLoad;
import PageFactory.ExtentFactory;
import PageFactory.LoginPage;
//import PageFactory.Navigation;
import PageFactory.NavigationLinks;

import org.testng.annotations.BeforeMethod;

import static org.testng.Assert.assertTrue;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
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

public class SubNavigation_Test extends BrowserStack {
  
	ExtentReports report;
	ExtentTest test;
	NavigationLinks NavigationElements;
	LoginPage 	LoginPageElements;

  @BeforeMethod (groups = {"Sanity","BS_Sanity"})
  public void beforeMethod() throws Exception {
	  
	  NavigationElements = new NavigationLinks(driver);
	  LoginPageElements = new LoginPage(driver);
	  
	  LoginPageElements.LoadLoginPage();
	  report = ExtentFactory.getInstance();
	  //test.log(LogStatus.INFO, "Browser Opened and Url Entered");
	  
  }

  @AfterMethod (groups = {"Sanity","BS_Sanity"})
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
  
  @Test (priority = 0, groups = {"Sanity","BS_Sanity"})
  public void SymantecLink_Test() {
	  
	  test = report.startTest("Nav Links Test --> Symantec Link Test");
	  NavigationElements.SynmantecLinkClick();
	  
	  String PageTitle = "Symantec SSL Certificates";
		
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
  
  
  @Test (priority = 1, groups = {"Sanity","BS_Sanity"})
  public void VerSignLink_Test() {
	  
	 test = report.startTest("Nav Links Test --> VeriSign Link Test");
	  NavigationElements.VeriSignLinkClick();
	  
	  String PageTitle = "VeriSign SSL Certificates";
		
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
  
  @Test (priority = 2, groups = {"Sanity","BS_Sanity"})
  public void GeoTrustLink_Test() {
	  
	 test = report.startTest("Nav Links Test --> VeriSign Link Test");
	  NavigationElements.GeoTrustLinkClick();
	  
	  String PageTitle = "GeoTrust SSL Certificates";
		
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
  
  @Test (priority = 3, groups = {"Sanity","BS_Sanity"})
  public void ThawteLink_Test() {
	  
	 test = report.startTest("Nav Links Test --> VeriSign Link Test");
	  NavigationElements.ThawteLinkClick();
	  
	  String PageTitle = "Thawte SSL Certificates";
		
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
  
  @Test (priority = 4, groups = {"Sanity","BS_Sanity"})
  public void GlobalSignLink_Test() {
	  
	 test = report.startTest("Nav Links Test --> VeriSign Link Test");
	  NavigationElements.GlobalSignLinkClick();
	  
	  String PageTitle = "GlobalSign SSL Certificates";
		
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
  
  @Test (priority = 5, groups = {"Sanity","BS_Sanity"})
  public void ComodoLink_Test() {
	  
	 test = report.startTest("Nav Links Test --> VeriSign Link Test");
	  NavigationElements.ComodoLinkClick();
	  
	  String PageTitle = "Comodo SSL Certificates";
		
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
  
  @Test (priority = 6, groups = {"Sanity","BS_Sanity"})
  public void RapidSslLink_Test() {
	  
	 test = report.startTest("Nav Links Test --> VeriSign Link Test");
	  NavigationElements.RapidSslLinkClick();
	  
	  String PageTitle = "RapidSSL Certificates";
		
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
  
  @Test (priority = 7, groups = {"Sanity","BS_Sanity"})
  public void EntrustLink_Test() {
	  
	 test = report.startTest("Nav Links Test --> VeriSign Link Test");
	  NavigationElements.EntrustLinkClick();
	  
	  String PageTitle = "Entrust SSL Certificates";
		
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
  
  @Test (priority = 8, groups = {"Sanity","BS_Sanity"})
  public void SanSslLink_Test() {
	  
	 test = report.startTest("Nav Links Test --> VeriSign Link Test");
	  NavigationElements.SanSslLinkClick();
	  
	  String PageTitle = "SSL: UC & SAN Certificates for Microsoft Exchange and OCS";
		
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
  
  @Test (priority = 9, groups = {"Sanity","BS_Sanity"})
  public void WildcardSslLink_Test() {
	  
	 test = report.startTest("Nav Links Test --> VeriSign Link Test");
	 NavigationElements.WildcardSslLinkClick();
	  
	  String PageTitle = "Wildcard SSL - Secure unlimited sub-domains";
		
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
  
  @Test (priority = 10, groups = {"Sanity","BS_Sanity"})
  public void SanWildcardSslLink_Test() {
	  
	 test = report.startTest("Nav Links Test --> VeriSign Link Test");
	 NavigationElements.SanWildcardSslLinkClick();
	  
	  String PageTitle = "SAN Wildcard SSL - The truly flexible and cost effective multi-use certificate";
		
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
  
  @Test (priority = 11, groups = {"Sanity","BS_Sanity"})
  public void ECCSslLink_Test() {
	  
	 test = report.startTest("Nav Links Test --> VeriSign Link Test");
	 NavigationElements.ECCSslLinkClick();
	  
	  String PageTitle = "ECC Encryption - Stronger and Faster";
		
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
  
  @Test (priority = 12, groups = {"Sanity","BS_Sanity"})
  public void IPaddressSslLink_Test() {
	  
	 test = report.startTest("Nav Links Test --> VeriSign Link Test");
	 NavigationElements.IPaddressSslLinkClick();
	  
	  String PageTitle = "Secure your IP address rather than your domain name with IP SSL";
		
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
  
  @Test (priority = 13, groups = {"Sanity","BS_Sanity"})
  public void ExtendedValidationLink_Test() {
	  
	 test = report.startTest("Nav Links Test --> VeriSign Link Test");
	 NavigationElements.ExtendedValidationLinkClick();
	  
	  String PageTitle = "EV SSL - Displaying the ‘green bar of trust’";
		
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
  
  @Test (priority = 14, groups = {"Sanity","BS_Sanity"})
  public void OrganisationValidationLink_Test() {
	  
	 test = report.startTest("Nav Links Test --> VeriSign Link Test");
	 NavigationElements.OrganisationValidationLinkClick();
	  
	  String PageTitle = "Organisationally Validated SSL Certificates";
		
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
  
  @Test (priority = 15, groups = {"Sanity","BS_Sanity"})
  public void SymantecReadyIssuanceLink_Test() {
	  
	 test = report.startTest("Nav Links Test --> VeriSign Link Test");
	 NavigationElements.SymantecReadyIssuanceLinkClick();
	  
	  String PageTitle = "Symantec Ready Issuance with SSL247®";
		
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
  
  @Test (priority = 16, groups = {"Sanity","BS_Sanity"})
  public void DomainValidationLink_Test() {
	  
	 test = report.startTest("Nav Links Test --> VeriSign Link Test");
	 NavigationElements.DomainValidationLinkClick();
	  
	  String PageTitle = "Domain Validated certificates";
		
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
  
  /*
   *  
  @Test (priority = 2, groups = {"Smoke"})
  public void ProtectAndSecure_Link_Test() {
	  
	  test = report.startTest("Nav Links Test --> Protect And Secure Link Test");
	  
	  NavigationElements.ClickProtectAndSecureLink();
	  
	  test.log(LogStatus.INFO, "Page Opened");
	    
  }
  
  @Test (priority = 4, groups = {"Smoke"})
  public void Identify_Link_Test() {
	  
	  test = report.startTest("Nav Links Test --> Identify Link Test");
	  
	  NavigationElements.ClickIdentifyLink();
	  
	  test.log(LogStatus.INFO, "Page Opened");
	    
  }
  
  @Test (priority = 5, groups = {"Smoke"})
  public void Register_Link_Test() {
	  
	  test = report.startTest("Nav Links Test --> Register Link Test");
	  
	  NavigationElements.ClickRegisterLink();
	  
	  test.log(LogStatus.INFO, "Page Opened");
	    
  }
  
  @Test (priority = 6, groups = {"Smoke"})
  public void Manage_Link_Test() {
	  
	  test = report.startTest("Nav Links Test --> Manage Link Test");
	  
	  NavigationElements.ClickManageLink();
	  
	  test.log(LogStatus.INFO, "Page Opened");
	    
  }
  
  @Test (priority = 7, groups = {"Smoke"})
  public void BecomePartner_Link_Test() {
	  
	  test = report.startTest("Nav Links Test --> Become Partner Link Test");
	  
	  NavigationElements.ClickBecomePartnerLink();
	  
	  test.log(LogStatus.INFO, "Page Opened");
	    
  }
  
  @Test (priority = 8, groups = {"Smoke"})
  public void MySsl_Link_Test() {
	  
	  test = report.startTest("Nav Links Test --> Become Partner Link Test");
	  
	  NavigationElements.ClickMySslLink();
	  
	  test.log(LogStatus.INFO, "Page Opened");
	    
  }
  
  @Test (priority = 9, groups = {"Smoke"})
  public void FreeTrials_Link_Test() {
	  
	  test = report.startTest("Nav Links Test --> Free Trials Link Test");
	  
	  NavigationElements.ClickFreeTrialsLink();
	  
	  test.log(LogStatus.INFO, "Page Opened");
	    
  }
  
  @Test (priority = 10, groups = {"Smoke"})
  public void Wizard_Link_Test() {
	  
	  test = report.startTest("Nav Links Test --> Wizard Link Test");
	  
	  NavigationElements.ClickWizardLink();
	  
	  test.log(LogStatus.INFO, "Page Opened");
	    
  }
  
  @Test (priority = 11, groups = {"Smoke"})
  public void About_Link_Test() {
	  
	  test = report.startTest("Nav Links Test --> About Link Test");
	  
	  NavigationElements.ClickAboutLink();
	  
	  test.log(LogStatus.INFO, "Page Opened");
	    
  }
  
  @Test (priority = 12, groups = {"Smoke"})
  public void Support_Link_Test() {
	  
	  test = report.startTest("Nav Links Test --> Support Link Test");
	  
	  NavigationElements.ClickSupportLink();
	  
	  test.log(LogStatus.INFO, "Page Opened");
	    
  }
  
  @Test (priority = 13, groups = {"Smoke"})
  public void Blog_Link_Test() {
	  
	  test = report.startTest("Nav Links Test --> Blog Link Test");
	  
	  NavigationElements.ClickBlogLink();
	  
	  test.log(LogStatus.INFO, "Page Opened");
	    
  }
	*/
}
