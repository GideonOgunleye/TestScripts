package Slickets_Test;

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
import Sanity_Test.Test_DataSanity;

import org.testng.annotations.BeforeTest;
//import org.json.simple.parser.JSONParser;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
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
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import java.net.HttpURLConnection;


public class Test_Build5C extends Chrome  {
	
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
	protected java.util.HashSet<String> alreadyListed;
	protected java.util.Queue<String> queue;

	
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
		
		alreadyListed = new java.util.HashSet<String>();
		queue = new java.util.LinkedList<String>();
		
		
		//LoginPageElements.ClientLogin();
		
		Thread.sleep(2000);		
	}

	
	@AfterMethod (groups = {"Sanity","Smoke","BS_Smoke","BS_Sanity","BS_DailySanity", "BS_Sanity","Smoke_Firefox","Smoke_Chrome","Sanity_Chrome"}, alwaysRun = true)
	public void Logout (ITestResult result) throws Exception {

	    //Take Screen Shots
	/*			
	  	String path =  ScreenShot.Image(driver, "TestSecreenShot-" + result.getMethod().getMethodName());
		String imagePath = test.addScreenCapture(path);
		test.log(LogStatus.INFO, "Test Complete", imagePath);
	*/	
		driver.navigate().refresh();
		
		Thread.sleep(1000);
	/*	
		String path2 = ScreenShot.Image(driver, "Logout");
		String imagePath2 = test.addScreenCapture(path2);
		test.log(LogStatus.INFO, imagePath2);
	*/
		report.endTest(test);
		report.flush();
	
		
	}
	
	

	
	@Test (priority = 0, groups = {"Smoke","BS_Smoke","BS_Sanity","Smoke_Firefox","Smoke_Chrome"})
	  public void Get_Attribute () throws Exception{
		 

		
		  Properties prop = new Properties();
		  FileInputStream fis = new FileInputStream(Constants.File_Path + Constants.DataFile_Name);
		  prop.load(fis);
			  
		  report = ExtentFactory.getInstance3();
				
		  //test = report.startTest("<---------------------------Test Suite Start----------------------------------->");
		  test = report.startTest("Url Test --> Validate Links on- "+ "UK Website"); 
		  
	     // TODO 
		  
		  
		  
		  
	        
	     //String homePage = "https://www.ssl247.co.uk";
	     String url = "";

	        
	     //driver = new ChromeDriver();
	        
	     driver.manage().window().maximize();
	        
	     driver.get(prop.getProperty("UkUrl2"));
	        
	   	 List<WebElement> demovar=driver.findElements(By.tagName("a"));
		 System.out.println(demovar.size());
		
		 ArrayList<String> hrefs = new ArrayList<String>(); //List for storing all href values for 'a' tag
		 

		    for (WebElement var : demovar) {
		    	
		    	url = var.getAttribute("href");
		    	
	            if(url == null || url.isEmpty()){  
	            	
	            	  System.out.println("URL is either not configured for anchor tag or it is empty");
	            	  continue;
	             }
	            
	              if(!url.contains("ssl247.")){
	            	  
	                  System.out.println("URL belongs to another domain, skipping it.");
	                  continue;
	                  
	              	}
	              
	              if(url.contains("/#")){
	            	  
	                  System.out.println("Irrelevant Url");
	                  continue;
	                  
	              	}
	            
		        System.out.println(var.getText()); // used to get text present between the anchor tags
		        System.out.println(var.getAttribute("href"));
		        hrefs.add(var.getAttribute("href")); 
		        System.out.println("*************************************");
		
		          
		    }

		    //Navigating to each link
		    int i=0;
		    for (String href : hrefs) {
		    	
		        driver.navigate().to(href);
		        System.out.println((++i)+": navigated to URL with href: "+href);
		        Thread.sleep(3000);
		        
		        try {
		        	
		        	 System.out.println("Page Title Is:-" + driver.getTitle());
		        	 
		        }catch (Exception e) {
		        	
		        	System.out.println("Page Has no Title");
		        	System.out.println(e);
		        }
		        
		        
		        try {
		        	
		        	if (driver.getTitle().contains("404")) {
		        		
		        		System.out.println("ERROR 404 FOUND ON PAGE!!!!!");
		        		String path = ScreenShot.Image(driver, "Link Error");
			  			String imagePath = test.addScreenCapture(path);
			  			test.log(LogStatus.INFO, imagePath);
			  			test.log(LogStatus.FAIL, "ERROR 404 FOUND ON PAGE!!!!!");
			  			test.log(LogStatus.FAIL, "Failed Link is:" + href);
			  			
		        		
		        	}else if (driver.getPageSource().contains("not found")){
		        		
		        		System.out.println("Page Not Found Error..!!");
		        		String path = ScreenShot.Image(driver, "Link Error");
			  			String imagePath = test.addScreenCapture(path);
			  			test.log(LogStatus.INFO, imagePath);
			  			test.log(LogStatus.FAIL, "Page Not Found Error..!!");
			  			test.log(LogStatus.FAIL, "Failed Link is:" + href);
		        		
		        	}
		        	
		        try {
		        	
		    		WebElement ContentDiv = driver.findElement(By.xpath(".//*[@class='page-content']"));
		    		
			         if(ContentDiv.getText().isEmpty()) {
			        		
			        	System.out.println("Content Div is empty");
			        	test.log(LogStatus.FAIL, "Content Link Is Empty----:" + href);
			        		
			         }else {
			        		
			        		System.out.println("Page Has Content");
			        		test.log(LogStatus.INFO, "Page Has Content:----" + href);
			        	}
		        	
		        }catch (Exception e){
		        	
		        	System.out.println("Page Content Dive Not Found");

	        		}
		        
		        //Try Page Content # Div
		        
		        try {
		        	
			    		WebElement ContentDiv = driver.findElement(By.xpath(".//*[@class='page-content ha']"));
			    		
				         if(ContentDiv.getText().isEmpty()) {
				        		
				        	System.out.println("Content Div is empty");
				        	test.log(LogStatus.FAIL, "Content Link Is Empty----:" + href);
				        		
				         }else {
				        		
				        		System.out.println("Page Has Content");
				        		test.log(LogStatus.INFO, "Page Has Content:----" + href);
				        	}
			        	
			      }catch (Exception e){
			        	
			    	  System.out.println("Page Content # Dive Not Found");

		        	}
		        
		        //Try Page Content Fullwidth_Page	
		        
		        try {
		        	
			    		WebElement ContentDiv = driver.findElement(By.xpath(".//*[@class='page-content fullwidth_page']"));
			    		
				         if(ContentDiv.getText().isEmpty()) {
				        		
				        	System.out.println("Content Div is empty");
				        	test.log(LogStatus.FAIL, "Content Link Is Empty----:" + href);
				        		
				         }else {
				        		
				        		System.out.println("Page Has Content");
				        		test.log(LogStatus.INFO, "Page Has Content:----" + href);
				        	}
			        	
			      }catch (Exception e){
			        	
			    	  System.out.println("page-content fullwidth_page Dive Not Found");

		        	}
		        
		        
		        	
		     }catch (Exception k){
		        	
		        System.out.println(k);
		    }
		        
		        
		        
		        driver.navigate().back();
		        Thread.sleep(3000); // To check if the navigation is happening properly.
		        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		        System.out.println("Navigate Back");
		        System.out.println("+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++");
		    }

	    }
		  
	 @AfterTest (groups = {"Sanity","SQL","Regression","Smoke"})
	  public void afterTest() throws Exception {
		  
		  Thread.sleep(10000);
			 //report.endTest(test);
			 
		driver.quit();

		  
	  }

	
}