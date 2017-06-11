package Sanity_Test;

import org.testng.annotations.Test;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import PageFactory.DriverLoad;
import PageFactory.ExtentFactory;
import PageFactory.LoginPage;
import PageFactory.Navigation;

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

public class Navigation_Links extends DriverLoad {
  
	ExtentReports report;
	ExtentTest test;
	Navigation NavigationElements;
	LoginPage 	LoginPageElements;

  @BeforeMethod (groups = {"Smoke"})
  public void beforeMethod() throws Exception {
	  
	  NavigationElements = new Navigation(driver);
	  LoginPageElements = new LoginPage(driver);
	  
	/*  
	  Properties prop = new Properties();
		FileInputStream fis = new FileInputStream("C://Users//Gideon Okunleye//workspace//AutomationTestScripts//DataDriving.properties");
				 
		prop.load(fis);

		driver.get(prop.getProperty("Url")); 
		driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		String title = driver.getTitle();				 
		Assert.assertTrue(title.contains("SSL Certificates: Buy Symantec, Thawte, Apache SSL Cert, GlobalSign, GeoTrust, RapidSSL- SSL247.co.uk")); 
		Thread.sleep(5000);
	*/  
	  LoginPageElements.LoadLoginPage();
	  report = ExtentFactory.getInstance();
	  
	  
  }

  @AfterMethod (groups = {"Smoke"})
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
  
  @Test (groups = {"Smoke"})
  public void SSL_Certlink_Test() {
	  
	  test = report.startTest("Nav Links Test --> SSL_Certlink");
	  test.log(LogStatus.INFO, "Browser Opened and Url Entered");
	  
	  NavigationElements.ClickSslCertificatesLink();
	  test.log(LogStatus.INFO, "Page Opened");
	  
	  
  }

}
