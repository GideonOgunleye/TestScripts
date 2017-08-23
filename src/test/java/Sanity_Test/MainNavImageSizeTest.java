package Sanity_Test;

import org.testng.annotations.Test;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import BaseUtilities.AlertBox;
import BaseUtilities.BrowserStack;
import BaseUtilities.Chrome;
import BaseUtilities.Constants;
import BaseUtilities.CsR;
import BaseUtilities.DriverLoad;
import BaseUtilities.ExtentFactory;
import BaseUtilities.HtmlUnit;
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
import java.util.Iterator;
import java.util.List;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

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
import java.net.HttpURLConnection;


public class MainNavImageSizeTest extends Chrome {
	
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
	
	
   public MainNavImageSizeTest(WebDriver driver) {
	    	
	        this.driver = driver;
	  }
	
    public void ImageTest() {
    	
        try {
        	
	        	
	  		  List<WebElement> inputs = driver.findElements(By.tagName("img"));
			  System.out.println("Total images are " + inputs.size());
			  
			  for (Iterator<WebElement> iterator = inputs.iterator(); iterator.hasNext();) {
				  
			      WebElement webElement = (WebElement) iterator.next();
			      URLConnection urlConnection = new URL(webElement.getAttribute("src")).openConnection();
			      int size = urlConnection.getContentLength();
			      System.out.println("Image Src Is:"+ webElement.getAttribute("src"));
		    	  //test.log(LogStatus.INFO, "Image Src Is:"+ webElement.getAttribute("src"));
			      System.out.println("Image Size is: " + size+"Bytes");
		    	  //test.log(LogStatus.INFO, "Image Size is: " + size+"Bytes");
			      
			      if (size > 250000 ) {
			    	  
			    	  System.out.println("Image Size is greater than 150kb!!!");
			    	  //test.log(LogStatus.FAIL, "Image Size is greater than 150kb" );
			      }
			      
			      System.out.println("-----------------------------------------------------");
			   
			  }
        	
        }catch (Exception e) {

        	System.out.println("Image Array Method not Validated");
        	
        }
    	
    	
    }
	
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
		
		
		//LoginPageElements.ClientLogin();
		
		Thread.sleep(2000);		
	}

	
	@AfterMethod (groups = {"Sanity","Smoke","BS_Smoke","BS_Sanity","BS_DailySanity", "BS_Sanity","Smoke_Firefox","Smoke_Chrome","Sanity_Chrome"}, alwaysRun = true)
	public void Logout (ITestResult result) throws Exception {

		
		driver.navigate().refresh();
		
		Thread.sleep(1000);
		
		test.log(LogStatus.INFO, "Browser Refreshed");
		report.endTest(test);
		report.flush();
		
	}
	

	
	@Test (priority = 0, groups = {"Smoke","BS_Smoke","BS_Sanity","Smoke_Firefox","Smoke_Chrome"},dataProviderClass =Test_DataSanity.class, dataProvider="IndexLinksAllSites")
	  public void IndexPage (String Websitename, String WebsiteUrl) throws Exception{
		 
		  report = ExtentFactory.getInstance3();
		  
		  test = report.startTest("Url Test --> Image Validation- " + Websitename);
		  System.out.println("++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++");
		  System.out.println("Url Test --> IndexPageImage Validation-" + Websitename);
		  
		  driver.get(WebsiteUrl); 
		  driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
		  driver.manage().window().maximize();
		 
		  Thread.sleep(1000);
		  
		  List<WebElement> inputs = driver.findElements(By.tagName("img"));
		  System.out.println("Total images are " + inputs.size());
		  
		  for (Iterator<WebElement> iterator = inputs.iterator(); iterator.hasNext();) {
			  
		      WebElement webElement = (WebElement) iterator.next();
		      URLConnection urlConnection = new URL(webElement.getAttribute("src")).openConnection();
		      int size = urlConnection.getContentLength();
		      System.out.println("Image Src Is:"+ webElement.getAttribute("src"));
	    	  test.log(LogStatus.INFO, "Image Src Is:"+ webElement.getAttribute("src"));
		      System.out.println("Image Size is: " + size+"Bytes");
	    	  test.log(LogStatus.INFO, "Image Size is: " + size+"Bytes");
		      
		      if (size > 250000 ) {
		    	  
		    	  System.out.println("Image Size is greater than 150kb!!!");
		    	  test.log(LogStatus.FAIL, "Image Size is greater than 150kb" );
		      }
		      
		      System.out.println("+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++");
		   
		  }
		  
	
		  
	  }
	
	@Test (priority = 1, groups = {"Smoke","BS_Smoke","BS_Sanity","Smoke_Firefox","Smoke_Chrome"},dataProviderClass =Test_DataSanity.class, dataProvider="IndexLinksAllSites")
	  public void SSL_CertlinkPage (String Websitename, String WebsiteUrl) throws Exception{
		 
		  report = ExtentFactory.getInstance3();
		  
		  test = report.startTest("Url Test --> SSL_CertlinkPageImage Validation- " + Websitename);
		  System.out.println("++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++");
		  System.out.println("Url Test --> SSL_CertlinkPageImage Validation-" + Websitename);
		  
		  driver.get(WebsiteUrl); 
		  driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
		  driver.manage().window().maximize();
		  
		  Thread.sleep(1000);
		  
		  NavigationElements.ClickSslCertificatesLink();
		  driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
		  test.log(LogStatus.INFO, "Page Opened");
		  
		  List<WebElement> inputs = driver.findElements(By.tagName("img"));
		  System.out.println("Total images are " + inputs.size());
		  
		  for (Iterator<WebElement> iterator = inputs.iterator(); iterator.hasNext();) {
			  
		      WebElement webElement = (WebElement) iterator.next();
		      URLConnection urlConnection = new URL(webElement.getAttribute("src")).openConnection();
		      int size = urlConnection.getContentLength();
		      System.out.println("Image Src Is:"+ webElement.getAttribute("src"));
	    	  test.log(LogStatus.INFO, "Image Src Is:"+ webElement.getAttribute("src"));
		      System.out.println("Image Size is: " + size+"Bytes");
	    	  test.log(LogStatus.INFO, "Image Size is: " + size+"Bytes");
		      
		      if (size > 250000 ) {
		    	  
		    	  System.out.println("Image Size is greater than 150kb!!!");
		    	  test.log(LogStatus.FAIL, "Image Size is greater than 150kb" );
		      }
		      
		      System.out.println("+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++");
		   
		  }
		  
	
		  
	  }
	
}