package Sanity_Test;

import org.testng.annotations.Test;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import BaseUtilities.BrowserStack;
import BaseUtilities.Chrome;
import BaseUtilities.DriverLoad;
import BaseUtilities.ExtentFactory;
import BaseUtilities.Firefox;
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

public class SubNavigation_Test extends Chrome {
  
	ExtentReports report;
	ExtentTest test;
	NavigationLinks NavigationElements;
	LoginPage 	LoginPageElements;

  @BeforeMethod (groups = {"Sanity","BS_Sanity","Sanity_Chrome"})
  public void beforeMethod() throws Exception {
	  
	  NavigationElements = new NavigationLinks(driver);
	  LoginPageElements = new LoginPage(driver);
	  
	  //LoginPageElements.LoadLoginPage();
	  driver.get("https://www.ssl247.co.uk");
	  driver.manage().window().maximize();
	  driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
	  
	  Thread.sleep(3000);
	  
	  report = ExtentFactory.getInstance();
	  //test.log(LogStatus.INFO, "Browser Opened and Url Entered");
	  
  }

  @AfterMethod (groups = {"Sanity","BS_Sanity","Sanity_Chrome"})
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
  
  @Test (priority = 0, groups = {"Sanity","BS_Sanity","Sanity_Chrome"})
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
  
  
  @Test (priority = 1, groups = {"Sanity","BS_Sanity","Sanity_Chrome"})
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
  
  @Test (priority = 2, groups = {"Sanity","BS_Sanity","Sanity_Chrome"})
  public void GeoTrustLink_Test() {
	  
	 test = report.startTest("Nav Links Test --> GeoTrustLink Test");
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
  
  @Test (priority = 3, groups = {"Sanity","BS_Sanity","Sanity_Chrome"})
  public void ThawteLink_Test() {
	  
	 test = report.startTest("Nav Links Test --> ThawteLink Test");
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
  
  @Test (priority = 4, groups = {"Sanity","BS_Sanity","Sanity_Chrome"})
  public void GlobalSignLink_Test() {
	  
	 test = report.startTest("Nav Links Test --> GlobalSignLink Test");
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
  
  @Test (priority = 5, groups = {"Sanity","BS_Sanity","Sanity_Chrome"})
  public void ComodoLink_Test() {
	  
	 test = report.startTest("Nav Links Test --> ComodoLink Test");
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
  
  @Test (priority = 6, groups = {"Sanity","BS_Sanity","Sanity_Chrome"})
  public void RapidSslLink_Test() {
	  
	 test = report.startTest("Nav Links Test --> RapidSslLink Test");
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
  
  @Test (priority = 7, groups = {"Sanity","BS_Sanity","Sanity_Chrome"})
  public void EntrustLink_Test() {
	  
	 test = report.startTest("Nav Links Test --> EntrustLink Test");
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
  
  @Test (priority = 8, groups = {"Sanity","BS_Sanity","Sanity_Chrome"})
  public void SanSslLink_Test() {
	  
	 test = report.startTest("Nav Links Test --> SanSslLink Test");
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
  
  @Test (priority = 9, groups = {"Sanity","BS_Sanity","Sanity_Chrome"})
  public void WildcardSslLink_Test() {
	  
	 test = report.startTest("Nav Links Test --> WildcardSslLink Test");
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
  
  @Test (priority = 10, groups = {"Sanity","BS_Sanity","Sanity_Chrome"})
  public void SanWildcardSslLink_Test() {
	  
	 test = report.startTest("Nav Links Test --> SanWildcardSslLink Test");
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
  
  @Test (priority = 11, groups = {"Sanity","BS_Sanity","Sanity_Chrome"})
  public void ECCSslLink_Test() {
	  
	 test = report.startTest("Nav Links Test --> ECCSslLink Test");
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
  
  @Test (priority = 12, groups = {"Sanity","BS_Sanity","Sanity_Chrome"})
  public void IPaddressSslLink_Test() {
	  
	 test = report.startTest("Nav Links Test --> IPaddressSslLink Test");
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
  
  @Test (priority = 13, groups = {"Sanity","BS_Sanity","Sanity_Chrome"})
  public void ExtendedValidationLink_Test() {
	  
	 test = report.startTest("Nav Links Test --> ExtendedValidationLink Test");
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
  
  @Test (priority = 14, groups = {"Sanity","BS_Sanity","Sanity_Chrome"})
  public void OrganisationValidationLink_Test() {
	  
	 test = report.startTest("Nav Links Test --> OrganisationValidationLink Test");
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
  
  @Test (priority = 15, groups = {"Sanity","BS_Sanity","Sanity_Chrome"})
  public void SymantecReadyIssuanceLink_Test() {
	  
	 test = report.startTest("Nav Links Test --> Symantec Ready Issuance Link Test");
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
  
  @Test (priority = 16, groups = {"Sanity","BS_Sanity","Sanity_Chrome"})
  public void DomainValidationLink_Test() {
	  
	 test = report.startTest("Nav Links Test --> Domain Validation Link Test");
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
  
  @Test (priority = 17, groups = {"Sanity","BS_Sanity","Sanity_Chrome"})
  public void PenentrationTestingLink_Test() {
	  
	 test = report.startTest("Nav Links Test --> PenentrationTestingLink Test");


		
	  try {
			 NavigationElements.PenentrationTestingLinkClick();	    	
			 Thread.sleep(1000);				
	 	  	 test.log(LogStatus.PASS, "Validation Complete");
	 	  	 System.out.println("Validation Complete!");		    	
	 
	 	  	
	  }catch (Exception e) {
	 	  						
	 	  		test.log(LogStatus.FAIL, "Validation Failed");
	 	  		Assert.fail("Exception " + e);
	  }
	   
  }
  
  @Test (priority = 18, groups = {"Sanity","BS_Sanity","Sanity_Chrome"})
  public void QualysConsultancyKitLink_Test() {
	  
	 test = report.startTest("Nav Links Test --> QualysConsultancyKitLink Test");


		
	  try {
			 NavigationElements.QualysConsultancyKitLinkClick();	    	
			 Thread.sleep(1000);				
	 	  	 test.log(LogStatus.PASS, "Validation Complete");
	 	  	 System.out.println("Validation Complete!");		    	
	 
	 	  	
	  }catch (Exception e) {
	 	  						
	 	  		test.log(LogStatus.FAIL, "Validation Failed");
	 	  		Assert.fail("Exception " + e);
	  }
	   
  }
  
  @Test (priority = 19, groups = {"Sanity","BS_Sanity","Sanity_Chrome"})
  public void Gdpr_HealthCheckLink_Test() {
	  
	 test = report.startTest("Nav Links Test --> Gdpr_HealthCheckLink Test");


		
	  try {
			 NavigationElements.Gdpr_HealthCheckLinkClick();	    	
			 Thread.sleep(1000);				
	 	  	 test.log(LogStatus.PASS, "Validation Complete");
	 	  	 System.out.println("Validation Complete!");		    	
	 
	 	  	
	  }catch (Exception e) {
	 	  						
	 	  		test.log(LogStatus.FAIL, "Validation Failed");
	 	  		Assert.fail("Exception " + e);
	  }
	   
  }
  
  @Test (priority = 20, groups = {"Sanity","BS_Sanity","Sanity_Chrome"})
  public void ThalesVolumetricDataLink_Test() {
	  
	 test = report.startTest("Nav Links Test --> ThalesVolumetricDataLink Test");


		
	  try {
			 NavigationElements.ThalesVolumetricDataLinkClick();	    	
			 Thread.sleep(1000);				
	 	  	 test.log(LogStatus.PASS, "Validation Complete");
	 	  	 System.out.println("Validation Complete!");		    	
	 
	 	  	
	  }catch (Exception e) {
	 	  						
	 	  		test.log(LogStatus.FAIL, "Validation Failed");
	 	  		Assert.fail("Exception " + e);
	  }
	   
  }
  
  @Test (priority = 21, groups = {"Sanity","BS_Sanity","Sanity_Chrome"})
  public void ThalesHsmLink_Test() {
	  
	 test = report.startTest("Nav Links Test --> ThalesHsmLink Test");


		
	  try {
			 NavigationElements.ThalesHsmLinkClick();	    	
			 Thread.sleep(1000);				
	 	  	 test.log(LogStatus.PASS, "Validation Complete");
	 	  	 System.out.println("Validation Complete!");		    	
	 
	 	  	
	  }catch (Exception e) {
	 	  						
	 	  		test.log(LogStatus.FAIL, "Validation Failed");
	 	  		Assert.fail("Exception " + e);
	  }
	   
  }
  
  @Test (priority = 22, groups = {"Sanity","BS_Sanity","Sanity_Chrome"})
  public void SynmantecCloudSecurityLink_Test() {
	  
	 test = report.startTest("Nav Links Test --> SynmantecCloudSecurityLink Test");


		
	  try {
			 NavigationElements.SynmantecCloudSecurityLinkClick();	    	
			 Thread.sleep(1000);				
	 	  	 test.log(LogStatus.PASS, "Validation Complete");
	 	  	 System.out.println("Validation Complete!");		    	
	 
	 	  	
	  }catch (Exception e) {
	 	  						
	 	  		test.log(LogStatus.FAIL, "Validation Failed");
	 	  		Assert.fail("Exception " + e);
	  }
	   
  }
  
  @Test (priority = 23, groups = {"Sanity","BS_Sanity","Sanity_Chrome"})
  public void WebSecurityLink_Test() {
	  
	 test = report.startTest("Nav Links Test --> WebSecurityLink Test");


		
	  try {
			 NavigationElements.WebSecurityLinkClick();	    	
			 Thread.sleep(1000);				
	 	  	 test.log(LogStatus.PASS, "Validation Complete");
	 	  	 System.out.println("Validation Complete!");		    	
	 
	 	  	
	  }catch (Exception e) {
	 	  						
	 	  		test.log(LogStatus.FAIL, "Validation Failed");
	 	  		Assert.fail("Exception " + e);
	  }
	   
  }
  
  @Test (priority = 24, groups = {"Sanity","BS_Sanity","Sanity_Chrome"})
  public void EndPointProtectionLink_Test() {
	  
	 test = report.startTest("Nav Links Test --> EndPointProtectionLink Test");


		
	  try {
			 NavigationElements.EndPointProtectionLinkClick();	    	
			 Thread.sleep(1000);				
	 	  	 test.log(LogStatus.PASS, "Validation Complete");
	 	  	 System.out.println("Validation Complete!");		    	
	 
	 	  	
	  }catch (Exception e) {
	 	  						
	 	  		test.log(LogStatus.FAIL, "Validation Failed");
	 	  		Assert.fail("Exception " + e);
	  }
	   
  }
  
  @Test (priority = 25, groups = {"Sanity","BS_Sanity","Sanity_Chrome"})
  public void EmailSecurityLink_Test() {
	  
	 test = report.startTest("Nav Links Test --> EmailSecurityLink Test");


		
	  try {
			 NavigationElements.EmailSecurityLinkClick();	    	
			 Thread.sleep(1000);				
	 	  	 test.log(LogStatus.PASS, "Validation Complete");
	 	  	 System.out.println("Validation Complete!");		    	
	 
	 	  	
	  }catch (Exception e) {
	 	  						
	 	  		test.log(LogStatus.FAIL, "Validation Failed");
	 	  		Assert.fail("Exception " + e);
	  }
	   
  }
  
  @Test (priority = 26, groups = {"Sanity","BS_Sanity","Sanity_Chrome"})
  public void PersonalIdsLink_Test() {
	  
	 test = report.startTest("Nav Links Test --> PersonalIdsLink Test");


		
	  try {
			 NavigationElements.PersonalIdsLinkClick();	    	
			 Thread.sleep(1000);				
	 	  	 test.log(LogStatus.PASS, "Validation Complete");
	 	  	 System.out.println("Validation Complete!");		    	
	 
	 	  	
	  }catch (Exception e) {
	 	  						
	 	  		test.log(LogStatus.FAIL, "Validation Failed");
	 	  		Assert.fail("Exception " + e);
	  }
	   
  } 
  
  @Test (priority = 27, groups = {"Sanity","BS_Sanity","Sanity_Chrome"})
  public void CodeSigningLink_Test() {
	  
	 test = report.startTest("Nav Links Test --> CodeSigningLink Test");


		
	  try {
			 NavigationElements.CodeSigningLinkClick();	    	
			 Thread.sleep(1000);				
	 	  	 test.log(LogStatus.PASS, "Validation Complete");
	 	  	 System.out.println("Validation Complete!");		    	
	 
	 	  	
	  }catch (Exception e) {
	 	  						
	 	  		test.log(LogStatus.FAIL, "Validation Failed");
	 	  		Assert.fail("Exception " + e);
	  }
	   
  } 
  
  @Test (priority = 28, groups = {"Sanity","BS_Sanity","Sanity_Chrome"})
  public void PdfSigningLink_Test() {
	  
	 test = report.startTest("Nav Links Test --> PdfSigningLink Test");


		
	  try {
			 NavigationElements.PdfSigningLinkClick();	    	
			 Thread.sleep(1000);				
	 	  	 test.log(LogStatus.PASS, "Validation Complete");
	 	  	 System.out.println("Validation Complete!");		    	
	 
	 	  	
	  }catch (Exception e) {
	 	  						
	 	  		test.log(LogStatus.FAIL, "Validation Failed");
	 	  		Assert.fail("Exception " + e);
	  }
	   
  } 
  
  @Test (priority = 29, groups = {"Sanity","BS_Sanity","Sanity_Chrome"})
  public void MpkiLink_Test() {
	  
	 test = report.startTest("Nav Links Test --> MpkiLink Test");


		
	  try {
			 NavigationElements.MpkiLinkClick();	    	
			 Thread.sleep(1000);				
	 	  	 test.log(LogStatus.PASS, "Validation Complete");
	 	  	 System.out.println("Validation Complete!");		    	
	 
	 	  	
	  }catch (Exception e) {
	 	  						
	 	  		test.log(LogStatus.FAIL, "Validation Failed");
	 	  		Assert.fail("Exception " + e);
	  }
	   
  } 
  
  @Test (priority = 30, groups = {"Sanity","BS_Sanity","Sanity_Chrome"})
  public void DomainNamesLink_Test() {
	  
	 test = report.startTest("Nav Links Test --> DomainNamesLink Test");


		
	  try {
			 NavigationElements.DomainNamesLinkClick();	    	
			 Thread.sleep(1000);				
	 	  	 test.log(LogStatus.PASS, "Validation Complete");
	 	  	 System.out.println("Validation Complete!");		    	
	 
	 	  	
	  }catch (Exception e) {
	 	  						
	 	  		test.log(LogStatus.FAIL, "Validation Failed");
	 	  		Assert.fail("Exception " + e);
	  }
	   
  } 
  
  @Test (priority = 31, groups = {"Sanity","BS_Sanity","Sanity_Chrome"})
  public void BrandProtectionLink_Test() {
	  
	 test = report.startTest("Nav Links Test --> BrandProtectionLink Test");

	  try {
			 NavigationElements.BrandProtectionLinkClick();	    	
			 Thread.sleep(1000);				
	 	  	 test.log(LogStatus.PASS, "Validation Complete");
	 	  	 System.out.println("Validation Complete!");		    	
	 
	 	  	
	  }catch (Exception e) {
	 	  						
	 	  		test.log(LogStatus.FAIL, "Validation Failed");
	 	  		Assert.fail("Exception " + e);
	  }
	   
  } 

  
  @Test (priority = 32, groups = {"Sanity","BS_Sanity","Sanity_Chrome"})
  public void CoperateProgramsLink_Test() {
	  
	 test = report.startTest("Nav Links Test --> CoperateProgramsLink Test");

	  try {
			 NavigationElements.CoperateProgramsLinkClick();	    	
			 Thread.sleep(1000);				
	 	  	 test.log(LogStatus.PASS, "Validation Complete");
	 	  	 System.out.println("Validation Complete!");		    	
	 
	 	  	
	  }catch (Exception e) {
	 	  						
	 	  		test.log(LogStatus.FAIL, "Validation Failed");
	 	  		Assert.fail("Exception " + e);
	  }
	   
  } 
  
  @Test (priority = 33, groups = {"Sanity","BS_Sanity","Sanity_Chrome"})
  public void ResellerProgramsLink_Test() {
	  
	 test = report.startTest("Nav Links Test --> ResellerProgramsLink Test");

	  try {
			 NavigationElements.ResellerProgramsLinkClick();	    	
			 Thread.sleep(1000);				
	 	  	 test.log(LogStatus.PASS, "Validation Complete");
	 	  	 System.out.println("Validation Complete!");		    	
	 
	 	  	
	  }catch (Exception e) {
	 	  						
	 	  		test.log(LogStatus.FAIL, "Validation Failed");
	 	  		Assert.fail("Exception " + e);
	  }
	   
  } 
  
  @Test (priority = 34, groups = {"Sanity","BS_Sanity","Sanity_Chrome"})
  public void WhatIsMySslLink_Test() {
	  
	 test = report.startTest("Nav Links Test --> WhatIsMySslLink Test");

	  try {
			 NavigationElements.WhatIsMySslLinkClick();	    	
			 Thread.sleep(1000);				
	 	  	 test.log(LogStatus.PASS, "Validation Complete");
	 	  	 System.out.println("Validation Complete!");		    	
	 
	 	  	
	  }catch (Exception e) {
	 	  						
	 	  		test.log(LogStatus.FAIL, "Validation Failed");
	 	  		Assert.fail("Exception " + e);
	  }
	   
  } 
  
  @Test (priority = 35, groups = {"Sanity","BS_Sanity","Sanity_Chrome"})
  public void LogIntoMySslLink_Test() {
	  
	 test = report.startTest("Nav Links Test --> LogIntoMySslLink Test");

	  try {
			 NavigationElements.LogIntoMySslLinkClick();	    	
			 Thread.sleep(1000);				
	 	  	 test.log(LogStatus.PASS, "Validation Complete");
	 	  	 System.out.println("Validation Complete!");		    	
	 
	 	  	
	  }catch (Exception e) {
	 	  						
	 	  		test.log(LogStatus.FAIL, "Validation Failed");
	 	  		Assert.fail("Exception " + e);
	  }
	   
  } 
  
  @Test (priority = 36, groups = {"Sanity","BS_Sanity","Sanity_Chrome"})
  public void RenewalsWithSsl247Link_Test() {
	  
	 test = report.startTest("Nav Links Test --> RenewalsWithSsl247Link Test");

	  try {
			 NavigationElements.RenewalsWithSsl247LinkClick();	    	
			 Thread.sleep(1000);				
	 	  	 test.log(LogStatus.PASS, "Validation Complete");
	 	  	 System.out.println("Validation Complete!");		    	
	 
	 	  	
	  }catch (Exception e) {
	 	  						
	 	  		test.log(LogStatus.FAIL, "Validation Failed");
	 	  		Assert.fail("Exception " + e);
	  }
	   
  } 
  
  @Test (priority = 37, groups = {"Sanity","BS_Sanity","Sanity_Chrome"})
  public void RenewYourSslCertificateLink_Test() {
	  
	 test = report.startTest("Nav Links Test --> RenewYourSslCertificateLink Test");

	  try {
			 NavigationElements.RenewalsWithSsl247LinkClick();	    	
			 Thread.sleep(1000);				
	 	  	 test.log(LogStatus.PASS, "Validation Complete");
	 	  	 System.out.println("Validation Complete!");		    	
	 
	 	  	
	  }catch (Exception e) {
	 	  						
	 	  		test.log(LogStatus.FAIL, "Validation Failed");
	 	  		Assert.fail("Exception " + e);
	  }
	   
  } 
  
  @Test (priority = 38, groups = {"Sanity","BS_Sanity","Sanity_Chrome"})
  public void OurFreeTrialsLink_Test() {
	  
	 test = report.startTest("Nav Links Test --> OurFreeTrialsLink Test");

	  try {
			 NavigationElements.OurFreeTrialsLinkClick();	    	
			 Thread.sleep(1000);				
	 	  	 test.log(LogStatus.PASS, "Validation Complete");
	 	  	 System.out.println("Validation Complete!");		    	
	 
	 	  	
	  }catch (Exception e) {
	 	  						
	 	  		test.log(LogStatus.FAIL, "Validation Failed");
	 	  		Assert.fail("Exception " + e);
	  }
	   
  } 
  
  @Test (priority = 39, groups = {"Sanity","BS_Sanity","Sanity_Chrome"})
  public void FreeTrialSslLink_Test() {
	  
	 test = report.startTest("Nav Links Test --> FreeTrialSslLink Test");

	  try {
			 NavigationElements.FreeTrialSslLinkClick();	    	
			 Thread.sleep(1000);				
	 	  	 test.log(LogStatus.PASS, "Validation Complete");
	 	  	 System.out.println("Validation Complete!");		    	
	 
	 	  	
	  }catch (Exception e) {
	 	  						
	 	  		test.log(LogStatus.FAIL, "Validation Failed");
	 	  		Assert.fail("Exception " + e);
	  }
	   
  } 
  
  @Test (priority = 40, groups = {"Sanity","BS_Sanity","Sanity_Chrome"})
  public void FreeVulnerabilityScanLink_Test() {
	  
	 test = report.startTest("Nav Links Test --> FreeVulnerabilityScanLink Test");

	  try {
			 NavigationElements.FreeVulnerabilityScanLinkClick();	    	
			 Thread.sleep(1000);				
	 	  	 test.log(LogStatus.PASS, "Validation Complete");
	 	  	 System.out.println("Validation Complete!");		    	
	 
	 	  	
	  }catch (Exception e) {
	 	  						
	 	  		test.log(LogStatus.FAIL, "Validation Failed");
	 	  		Assert.fail("Exception " + e);
	  }
	   
  } 
  
  @Test (priority = 41, groups = {"Sanity","BS_Sanity","Sanity_Chrome"})
  public void WhoWeAreLink_Test() {
	  
	 test = report.startTest("Nav Links Test --> WhoWeAreLink Test");

	  try {
			 NavigationElements.WhoWeAreLinkClick();	    	
			 Thread.sleep(1000);				
	 	  	 test.log(LogStatus.PASS, "Validation Complete");
	 	  	 System.out.println("Validation Complete!");		    	
	 
	 	  	
	  }catch (Exception e) {
	 	  						
	 	  		test.log(LogStatus.FAIL, "Validation Failed");
	 	  		Assert.fail("Exception " + e);
	  }
	   
  }
  
  @Test (priority = 42, groups = {"Sanity","BS_Sanity","Sanity_Chrome"})
  public void OnlineBusinessContinuityLink_Test() {
	  
	 test = report.startTest("Nav Links Test --> OnlineBusinessContinuityLink Test");

	  try {
			 NavigationElements.OnlineBusinessContinuityLinkClick();	    	
			 Thread.sleep(1000);				
	 	  	 test.log(LogStatus.PASS, "Validation Complete");
	 	  	 System.out.println("Validation Complete!");		    	
	 
	 	  	
	  }catch (Exception e) {
	 	  						
	 	  		test.log(LogStatus.FAIL, "Validation Failed");
	 	  		Assert.fail("Exception " + e);
	  }
	   
  }
  
  @Test (priority = 43, groups = {"Sanity","BS_Sanity","Sanity_Chrome"})
  public void ContactLink_Test() {
	  
	 test = report.startTest("Nav Links Test --> ContactLink Test");

	  try {
			 NavigationElements.ContactLinkClick();	    	
			 Thread.sleep(1000);				
	 	  	 test.log(LogStatus.PASS, "Validation Complete");
	 	  	 System.out.println("Validation Complete!");		    	
	 
	 	  	
	  }catch (Exception e) {
	 	  						
	 	  		test.log(LogStatus.FAIL, "Validation Failed");
	 	  		Assert.fail("Exception " + e);
	  }
	   
  }
  
  @Test (priority = 44, groups = {"Sanity","BS_Sanity","Sanity_Chrome"})
  public void TestimonialsLink_Test() {
	  
	 test = report.startTest("Nav Links Test --> TestimonialsLink Test");

	  try {
			 NavigationElements.TestimonialsLinkClick();	    	
			 Thread.sleep(1000);				
	 	  	 test.log(LogStatus.PASS, "Validation Complete");
	 	  	 System.out.println("Validation Complete!");		    	
	 
	 	  	
	  }catch (Exception e) {
	 	  						
	 	  		test.log(LogStatus.FAIL, "Validation Failed");
	 	  		Assert.fail("Exception " + e);
	  }
	   
  }
  
  @Test (priority = 45, groups = {"Sanity","BS_Sanity","Sanity_Chrome"})
  public void AccreditationsLink_Test() {
	  
	 test = report.startTest("Nav Links Test --> AccreditationsLink Test");

	  try {
			 NavigationElements.AccreditationsLinkClick();	    	
			 Thread.sleep(1000);				
	 	  	 test.log(LogStatus.PASS, "Validation Complete");
	 	  	 System.out.println("Validation Complete!");		    	
	 
	 	  	
	  }catch (Exception e) {
	 	  						
	 	  		test.log(LogStatus.FAIL, "Validation Failed");
	 	  		Assert.fail("Exception " + e);
	  }
	   
  }
  
  @Test (priority = 46, groups = {"Sanity","BS_Sanity","Sanity_Chrome"})
  public void CareersLink_Test() {
	  
	 test = report.startTest("Nav Links Test --> CareersLink Test");

	  try {
			 NavigationElements.CareersLinkClick();	    	
			 Thread.sleep(1000);				
	 	  	 test.log(LogStatus.PASS, "Validation Complete");
	 	  	 System.out.println("Validation Complete!");		    	
	 
	 	  	
	  }catch (Exception e) {
	 	  						
	 	  		test.log(LogStatus.FAIL, "Validation Failed");
	 	  		Assert.fail("Exception " + e);
	  }
	   
  }
  
  @Test (priority = 47, groups = {"Sanity","BS_Sanity","Sanity_Chrome"})
  public void HelpAndSuppotLink_Test() {
	  
	 test = report.startTest("Nav Links Test --> HelpAndSuppotLink Test");

	  try {
			 NavigationElements.HelpAndSuppotLinkClick();	    	
			 Thread.sleep(1000);				
	 	  	 test.log(LogStatus.PASS, "Validation Complete");
	 	  	 System.out.println("Validation Complete!");		    	
	 
	 	  	
	  }catch (Exception e) {
	 	  						
	 	  		test.log(LogStatus.FAIL, "Validation Failed");
	 	  		Assert.fail("Exception " + e);
	  }
	   
  }
  
  @Test (priority = 48, groups = {"Sanity","BS_Sanity","Sanity_Chrome"})
  public void KnowledgeBaseLink_Test() {
	  
	 test = report.startTest("Nav Links Test --> KnowledgeBaseLink Test");

	  try {
			 NavigationElements.KnowledgeBaseLinkClick();	    	
			 Thread.sleep(1000);				
	 	  	 test.log(LogStatus.PASS, "Validation Complete");
	 	  	 System.out.println("Validation Complete!");		    	
	 
	 	  	
	  }catch (Exception e) {
	 	  						
	 	  		test.log(LogStatus.FAIL, "Validation Failed");
	 	  		Assert.fail("Exception " + e);
	  }
	   
  }
  
  @Test (priority = 49, groups = {"Sanity","BS_Sanity","Sanity_Chrome"})
  public void SslToolsLink_Test() {
	  
	 test = report.startTest("Nav Links Test --> SslToolsLink Test");

	  try {
			 NavigationElements.SslToolsLinkClick();	    	
			 Thread.sleep(1000);				
	 	  	 test.log(LogStatus.PASS, "Validation Complete");
	 	  	 System.out.println("Validation Complete!");		    	
	 
	 	  	
	  }catch (Exception e) {
	 	  						
	 	  		test.log(LogStatus.FAIL, "Validation Failed");
	 	  		Assert.fail("Exception " + e);
	  }
	   
  }
  
  @Test (priority = 50, groups = {"Sanity","BS_Sanity","Sanity_Chrome"})
  public void Sha1CheckerLink_Test() {
	  
	 test = report.startTest("Nav Links Test --> Sha1CheckerLink Test");

	  try {
			 NavigationElements.Sha1CheckerLinkClick();	    	
			 Thread.sleep(1000);				
	 	  	 test.log(LogStatus.PASS, "Validation Complete");
	 	  	 System.out.println("Validation Complete!");		    	
	 
	 	  	
	  }catch (Exception e) {
	 	  						
	 	  		test.log(LogStatus.FAIL, "Validation Failed");
	 	  		Assert.fail("Exception " + e);
	  }
	   
  }
  
  @Test (priority = 51, groups = {"Sanity","BS_Sanity","Sanity_Chrome"})
  public void CsrGeneratorLink_Test() {
	  
	 test = report.startTest("Nav Links Test --> CsrGeneratorLink Test");

	  try {
			 NavigationElements.CsrGeneratorLinkClick();	    	
			 Thread.sleep(1000);				
	 	  	 test.log(LogStatus.PASS, "Validation Complete");
	 	  	 System.out.println("Validation Complete!");		    	
	 
	 	  	
	  }catch (Exception e) {
	 	  						
	 	  		test.log(LogStatus.FAIL, "Validation Failed");
	 	  		Assert.fail("Exception " + e);
	  }
	   
  }
  
  @Test (priority = 52, groups = {"Sanity","BS_Sanity","Sanity_Chrome"})
  public void CreateCsrLink_Test() {
	  
	 test = report.startTest("Nav Links Test --> CreateCsrLink Test");

	  try {
			 NavigationElements.CreateCsrLinkClick();	    	
			 Thread.sleep(1000);				
	 	  	 test.log(LogStatus.PASS, "Validation Complete");
	 	  	 System.out.println("Validation Complete!");		    	
	 
	 	  	
	  }catch (Exception e) {
	 	  						
	 	  		test.log(LogStatus.FAIL, "Validation Failed");
	 	  		Assert.fail("Exception " + e);
	  }
	   
  }
  
  @Test (priority = 53, groups = {"Sanity","BS_Sanity","Sanity_Chrome"})
  public void InstallCertificateLink_Test() {
	  
	 test = report.startTest("Nav Links Test --> InstallCertificateLink Test");

	  try {
			 NavigationElements.InstallCertificateLinkClick();	    	
			 Thread.sleep(1000);				
	 	  	 test.log(LogStatus.PASS, "Validation Complete");
	 	  	 System.out.println("Validation Complete!");		    	
	 
	 	  	
	  }catch (Exception e) {
	 	  						
	 	  		test.log(LogStatus.FAIL, "Validation Failed");
	 	  		Assert.fail("Exception " + e);
	  }
	   
  }
  
  @Test (priority = 54, groups = {"Sanity","BS_Sanity","Sanity_Chrome"})
  public void InstallSiteSealLink_Test() {
	  
	 test = report.startTest("Nav Links Test --> InstallSiteSealLink Test");

	  try {
			 NavigationElements.InstallSiteSealLinkClick();	    	
			 Thread.sleep(1000);				
	 	  	 test.log(LogStatus.PASS, "Validation Complete");
	 	  	 System.out.println("Validation Complete!");		    	
	 
	 	  	
	  }catch (Exception e) {
	 	  						
	 	  		test.log(LogStatus.FAIL, "Validation Failed");
	 	  		Assert.fail("Exception " + e);
	  }
	   
  }
  
  @Test (priority = 55, groups = {"Sanity","BS_Sanity","Sanity_Chrome"})
  public void ImportExportTipsLink_Test() {
	  
	 test = report.startTest("Nav Links Test --> ImportExportTipsLink Test");

	  try {
			 NavigationElements.ImportExportTipsLinkClick();	    	
			 Thread.sleep(1000);				
	 	  	 test.log(LogStatus.PASS, "Validation Complete");
	 	  	 System.out.println("Validation Complete!");		    	
	 
	 	  	
	  }catch (Exception e) {
	 	  						
	 	  		test.log(LogStatus.FAIL, "Validation Failed");
	 	  		Assert.fail("Exception " + e);
	  }
	   
  }
  
  
  @Test (priority = 56, groups = {"Sanity","BS_Sanity","Sanity_Chrome"})
  public void DownloadRootsCertificatesLink_Test() {
	  
	 test = report.startTest("Nav Links Test --> DownloadRootsCertificatesLink Test");

	  try {
			 NavigationElements.DownloadRootsCertificatesLinkClick();	    	
			 Thread.sleep(1000);				
	 	  	 test.log(LogStatus.PASS, "Validation Complete");
	 	  	 System.out.println("Validation Complete!");		    	
	 
	 	  	
	  }catch (Exception e) {
	 	  						
	 	  		test.log(LogStatus.FAIL, "Validation Failed");
	 	  		Assert.fail("Exception " + e);
	  }
	   
  }
  
  @Test (priority = 57, groups = {"Sanity","BS_Sanity","Sanity_Chrome"})
  public void RenewalsWithSsl247_SupportLink_Test() {
	  
	 test = report.startTest("Nav Links Test --> RenewalsWithSsl247_SupportLink Test");

	  try {
			 NavigationElements.RenewalsWithSsl247_SupportLinkClick();	    	
			 Thread.sleep(1000);				
	 	  	 test.log(LogStatus.PASS, "Validation Complete");
	 	  	 System.out.println("Validation Complete!");		    	
	 
	 	  	
	  }catch (Exception e) {
	 	  						
	 	  		test.log(LogStatus.FAIL, "Validation Failed");
	 	  		Assert.fail("Exception " + e);
	  }
	   
  }
  
  @Test (priority = 58, groups = {"Sanity","BS_Sanity","Sanity_Chrome"})
  public void RenewYourSslCertificate_SupportLink_Test() {
	  
	 test = report.startTest("Nav Links Test --> RenewYourSslCertificate_SupportLink Test");

	  try {
			 NavigationElements.RenewYourSslCertificate_SupportLinkClick();	    	
			 Thread.sleep(1000);				
	 	  	 test.log(LogStatus.PASS, "Validation Complete");
	 	  	 System.out.println("Validation Complete!");		    	
	 
	 	  	
	  }catch (Exception e) {
	 	  						
	 	  		test.log(LogStatus.FAIL, "Validation Failed");
	 	  		Assert.fail("Exception " + e);
	  }
	   
  }
  
  
}
