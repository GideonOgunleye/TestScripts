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

  @BeforeMethod (groups = {"Smoke","BS_Smoke","BS_Sanity","Smoke_Firefox","Smoke_Chrome"})
  public void beforeMethod() throws Exception {
	  
	  NavigationElements = new NavigationLinks(driver);
	  LoginPageElements = new LoginPage(driver);
	  AlertBoxElements = new AlertBox(driver);
	  ScreenShot = new TakeScreenShot();
	  
	  //LoginPageElements.LoadLoginPage();
	  report = ExtentFactory.getInstance5();
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
		report.endTest(test);
		report.flush();
	
		//return destination;
	  
  }
  
  
  @Test (priority = 0, groups = {"Smoke","BS_Smoke","BS_Sanity","Smoke_Firefox","Smoke_Chrome"},dataProviderClass =Test_DataSanity.class, dataProvider="IndexLinksAllSites" )
  public void SSL_Certlink_Test(String Websitename, String WebsiteUrl) {
	  
	  
	  test = report.startTest("Nav Links Test --> SSL Cert link Test" + Websitename);
	  
	  driver.get(WebsiteUrl);
	  driver.manage().window().maximize();
	  driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
	  
	  try {
		  
		  NavigationElements.ClickSslCertificatesLink();
		  driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
		  test.log(LogStatus.INFO, "Page Opened");
		  
	     // TODO - Find All Links Method
	        
	     String url = "";
      
	     List<WebElement> demovar = driver.findElement(By.xpath(".//*[@class='contentWrapper']")).findElements(By.tagName("a"));
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
		        Thread.sleep(3000); // To check if the navigation is happening properly.
		        
		        try {
		        	
		        	 System.out.println("Page Title Is:-" + driver.getTitle());
		        	 
		        }catch (Exception e) {
		        	
		        	System.out.println("Page Has no Title");
		        	System.out.println(e);
		        }
		        
		      
		        try {
		        	
		        	if (driver.getTitle().contains("404")) {
		        		
		        		System.out.println("ERROR 404 FOUND ON PAGE!!!!!");
		        		test.log(LogStatus.FAIL, "ERROR 404 FOUND ON PAGE!!!!!: - " + href);
		        		String path = ScreenShot.Image(driver, "Link Error");
			  			String imagePath = test.addScreenCapture(path);
			  			test.log(LogStatus.INFO, imagePath);
			  			
		        		
		        	}else if (driver.getPageSource().contains("not found")){
		        		
		        		System.out.println("Page Not Found Error..!!");
		        		test.log(LogStatus.FAIL, "Page Not Found Error..!!: - " + href);
		        		String path = ScreenShot.Image(driver, "Link Error");
			  			String imagePath = test.addScreenCapture(path);
			  			test.log(LogStatus.INFO, imagePath);	
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
		        
		        //TODO
		        try {
		           	
		        	
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
					      
					      System.out.println("-----------------------------------------------------");
					   
					  }
		       	
		       }catch (Exception e) {

		       	System.out.println("Image Array Method not Validated");
		       	System.out.println("e");
		       	
		       }    
		        
		        driver.navigate().back();
		        Thread.sleep(3000); // To check if the navigation is happening properly.
		        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		        System.out.println("Navigate Back");
		        System.out.println("+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++");
		    }

	  	
	  }catch (Exception e) {
	  						
	  		test.log(LogStatus.FAIL, "Validation Failed");
	  		Assert.fail("Exception " + e);
	  }

  }
  
  @Test (priority = 1, groups = {"Smoke","BS_Smoke","BS_Sanity","Smoke_Firefox","Smoke_Chrome"},dataProviderClass =Test_DataSanity.class, dataProvider="IndexLinksAllSites")
  public void FreeSsl_Link_Test(String Websitename, String WebsiteUrl) {
	  
	  test = report.startTest("Nav Links Test --> FreeSsl Link Test" + Websitename);
	  
	  driver.get(WebsiteUrl);
	  driver.manage().window().maximize();
	  driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
		
	  try {
		  
		  
		  NavigationElements.ClickFreeSslLink();
		  driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
		  test.log(LogStatus.INFO, "Page Opened");
	  			    	
		     // TODO - Find All Links Method
	        
		     String url = "";
	      
		     List<WebElement> demovar = driver.findElement(By.xpath(".//*[@class='contentWrapper']")).findElements(By.tagName("a"));
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
			        Thread.sleep(3000); // To check if the navigation is happening properly.
			        
			        try {
			        	
			        	 System.out.println("Page Title Is:-" + driver.getTitle());
			        	 
			        }catch (Exception e) {
			        	
			        	System.out.println("Page Has no Title");
			        	System.out.println(e);
			        }
			        
			      
			        try {
			        	
			        	if (driver.getTitle().contains("404")) {
			        		
			        		System.out.println("ERROR 404 FOUND ON PAGE!!!!!");
			        		test.log(LogStatus.FAIL, "ERROR 404 FOUND ON PAGE!!!!!: - " + href);
			        		String path = ScreenShot.Image(driver, "Link Error");
				  			String imagePath = test.addScreenCapture(path);
				  			test.log(LogStatus.INFO, imagePath);
				  			
			        		
			        	}else if (driver.getPageSource().contains("not found")){
			        		
			        		System.out.println("Page Not Found Error..!!");
			        		test.log(LogStatus.FAIL, "Page Not Found Error..!!: - " + href);
			        		String path = ScreenShot.Image(driver, "Link Error");
				  			String imagePath = test.addScreenCapture(path);
				  			test.log(LogStatus.INFO, imagePath);	
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
			        
			        //TODO
			        try {
			           	
			        	
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
						      
						      System.out.println("-----------------------------------------------------");
						   
						  }
			       	
			       }catch (Exception e) {

			       	System.out.println("Image Array Method not Validated");
			       	System.out.println("e");
			       	
			       }   
			        
			        driver.navigate().back();
			        Thread.sleep(3000); // To check if the navigation is happening properly.
			        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			        System.out.println("Navigate Back");
			        System.out.println("+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++");
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
  public void Register_Link_Test(String Websitename, String WebsiteUrl) {
	  
	  test = report.startTest("Nav Links Test --> Register Link Test" + Websitename);
	  
	  driver.get(WebsiteUrl);
	  driver.manage().window().maximize();
	  driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
		
	  try {
		    
		  
		  NavigationElements.ClickRegisterLink();
		  driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
		  test.log(LogStatus.INFO, "Page Opened");
		 
		  // TODO - Find All Links Method
		  
		  System.out.println(driver.getTitle());
		  driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
		  test.log(LogStatus.INFO, "Page Title is:" + driver.getTitle());
	        
		     String url = "";
	      
		     List<WebElement> demovar = driver.findElement(By.xpath(".//*[@class='contentWrapper']")).findElements(By.tagName("a"));
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
			        Thread.sleep(3000); // To check if the navigation is happening properly.
			        
			        try {
			        	
			        	 System.out.println("Page Title Is:-" + driver.getTitle());
			        	 
			        }catch (Exception e) {
			        	
			        	System.out.println("Page Has no Title");
			        	System.out.println(e);
			        }
			        
			      
			        try {
			        	
			        	if (driver.getTitle().contains("404")) {
			        		
			        		System.out.println("ERROR 404 FOUND ON PAGE!!!!!");
			        		test.log(LogStatus.FAIL, "ERROR 404 FOUND ON PAGE!!!!!: - " + href);
			        		String path = ScreenShot.Image(driver, "Link Error");
				  			String imagePath = test.addScreenCapture(path);
				  			test.log(LogStatus.INFO, imagePath);
				  			
			        		
			        	}else if (driver.getPageSource().contains("not found")){
			        		
			        		System.out.println("Page Not Found Error..!!");
			        		test.log(LogStatus.FAIL, "Page Not Found Error..!!: - " + href);
			        		String path = ScreenShot.Image(driver, "Link Error");
				  			String imagePath = test.addScreenCapture(path);
				  			test.log(LogStatus.INFO, imagePath);	
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
			        
			        //TODO
			        try {
			           	
			        	
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
						      
						      System.out.println("-----------------------------------------------------");
						   
						  }
			       	
			       }catch (Exception e) {

			       	System.out.println("Image Array Method not Validated");
			       	System.out.println("e");
			       	
			       }    
			        
			        driver.navigate().back();
			        Thread.sleep(3000); // To check if the navigation is happening properly.
			        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			        System.out.println("Navigate Back");
			        System.out.println("+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++");
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
  
  @Test (priority = 7, groups = {"Smoke","BS_Smoke","BS_Sanity","Smoke_Firefox","Smoke_Chrome"},dataProviderClass =Test_DataSanity.class, dataProvider="IndexLinksAllSites")
  public void BecomePartner_Link_Test(String Websitename, String WebsiteUrl) {
	  
	  test = report.startTest("Nav Links Test --> Become Partner Link Test" + Websitename);
	  
	  driver.get(WebsiteUrl);
	  driver.manage().window().maximize();
	  driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
			
	  try {
		  
		  
		  NavigationElements.ClickBecomePartnerLink();
		  driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
		  test.log(LogStatus.INFO, "Page Opened");
		  
		  // TODO - Find All Links Method
		  
		  System.out.println(driver.getTitle());
		  driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
		  test.log(LogStatus.INFO, "Page Title is:" + driver.getTitle());
	        
		     String url = "";
	      
		     List<WebElement> demovar = driver.findElement(By.xpath(".//*[@class='contentWrapper']")).findElements(By.tagName("a"));
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
			        Thread.sleep(3000); // To check if the navigation is happening properly.
			        
			        try {
			        	
			        	 System.out.println("Page Title Is:-" + driver.getTitle());
			        	 
			        }catch (Exception e) {
			        	
			        	System.out.println("Page Has no Title");
			        	System.out.println(e);
			        }
			        
			      
			        try {
			        	
			        	if (driver.getTitle().contains("404")) {
			        		
			        		System.out.println("ERROR 404 FOUND ON PAGE!!!!!");
			        		test.log(LogStatus.FAIL, "ERROR 404 FOUND ON PAGE!!!!!: - " + href);
			        		String path = ScreenShot.Image(driver, "Link Error");
				  			String imagePath = test.addScreenCapture(path);
				  			test.log(LogStatus.INFO, imagePath);
				  			
			        		
			        	}else if (driver.getPageSource().contains("not found")){
			        		
			        		System.out.println("Page Not Found Error..!!");
			        		test.log(LogStatus.FAIL, "Page Not Found Error..!!: - " + href);
			        		String path = ScreenShot.Image(driver, "Link Error");
				  			String imagePath = test.addScreenCapture(path);
				  			test.log(LogStatus.INFO, imagePath);	
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
			        
			        //TODO
			        try {
			           	
			        	
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
						      
						      System.out.println("-----------------------------------------------------");
						   
						  }
			       	
			       }catch (Exception e) {

			       	System.out.println("Image Array Method not Validated");
			       	System.out.println("e");
			       	
			       }    
			        
			        driver.navigate().back();
			        Thread.sleep(3000); // To check if the navigation is happening properly.
			        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			        System.out.println("Navigate Back");
			        System.out.println("+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++");
	  			    	
	  		}
	  	
	  }catch (Exception e) {
	  						
	  		test.log(LogStatus.FAIL, "Validation Failed");
	  		Assert.fail("Exception " + e);
	  }
	    
  }
  
  @Test (priority = 8, groups = {"Smoke","BS_Smoke","BS_Sanity","Smoke_Firefox","Smoke_Chrome"},dataProviderClass =Test_DataSanity.class, dataProvider="IndexLinksAllSites")
  public void MySsl_Link_Test(String Websitename, String WebsiteUrl) {
	  
	  test = report.startTest("Nav Links Test --> MySsl Link Test" + Websitename);
	  
	  driver.get(WebsiteUrl);
	  driver.manage().window().maximize();
	  driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
	  
	  try {
			  
		  NavigationElements.ClickMySslLink();
		  driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
		  test.log(LogStatus.INFO, "Page Opened");
		  
		  // TODO - Find All Links Method
		  
		  System.out.println(driver.getTitle());
		  driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
		  test.log(LogStatus.INFO, "Page Title is:" + driver.getTitle());
	        
		     String url = "";
	      
		     List<WebElement> demovar = driver.findElement(By.xpath(".//*[@class='contentWrapper']")).findElements(By.tagName("a"));
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
			        Thread.sleep(3000); // To check if the navigation is happening properly.
			        
			        try {
			        	
			        	 System.out.println("Page Title Is:-" + driver.getTitle());
			        	 
			        }catch (Exception e) {
			        	
			        	System.out.println("Page Has no Title");
			        	System.out.println(e);
			        }
			        
			      
			        try {
			        	
			        	if (driver.getTitle().contains("404")) {
			        		
			        		System.out.println("ERROR 404 FOUND ON PAGE!!!!!");
			        		test.log(LogStatus.FAIL, "ERROR 404 FOUND ON PAGE!!!!!: - " + href);
			        		String path = ScreenShot.Image(driver, "Link Error");
				  			String imagePath = test.addScreenCapture(path);
				  			test.log(LogStatus.INFO, imagePath);
				  			
			        		
			        	}else if (driver.getPageSource().contains("not found")){
			        		
			        		System.out.println("Page Not Found Error..!!");
			        		test.log(LogStatus.FAIL, "Page Not Found Error..!!: - " + href);
			        		String path = ScreenShot.Image(driver, "Link Error");
				  			String imagePath = test.addScreenCapture(path);
				  			test.log(LogStatus.INFO, imagePath);	
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
			        
			        //TODO
			        try {
			           	
			        	
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
						      
						      System.out.println("-----------------------------------------------------");
						   
						  }
			       	
			       }catch (Exception e) {

			       	System.out.println("Image Array Method not Validated");
			       	System.out.println("e");
			       	
			       }    
			        
			        driver.navigate().back();
			        Thread.sleep(3000); // To check if the navigation is happening properly.
			        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			        System.out.println("Navigate Back");
			        System.out.println("+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++");
	  			    	
	  		}
	  	
	  }catch (Exception e) {
	  						
	  		test.log(LogStatus.FAIL, "Validation Failed");
	  		Assert.fail("Exception " + e);
	  }
	    
  }
  
  @Test (priority = 9, groups = {"Smoke","BS_Smoke","BS_Sanity","Smoke_Firefox","Smoke_Chrome"},dataProviderClass =Test_DataSanity.class, dataProvider="IndexLinksAllSites")
  public void FreeTrials_Link_Test(String Websitename, String WebsiteUrl) {
	  
	  test = report.startTest("Nav Links Test --> Free Trials Link Test" + Websitename);
	  
	  driver.get(WebsiteUrl);
	  driver.manage().window().maximize();
	  driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
		
	  try {
		  
		  NavigationElements.ClickFreeTrialsLink();
		  driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
		  test.log(LogStatus.INFO, "Page Opened");
		  
		  // TODO - Find All Links Method
		  
		  System.out.println(driver.getTitle());
		  driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
		  test.log(LogStatus.INFO, "Page Title is:" + driver.getTitle());
	        
		     String url = "";
	      
		     List<WebElement> demovar = driver.findElement(By.xpath(".//*[@class='contentWrapper']")).findElements(By.tagName("a"));
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
			        Thread.sleep(3000); // To check if the navigation is happening properly.
			        
			        try {
			        	
			        	 System.out.println("Page Title Is:-" + driver.getTitle());
			        	 
			        }catch (Exception e) {
			        	
			        	System.out.println("Page Has no Title");
			        	System.out.println(e);
			        }
			        
			      
			        try {
			        	
			        	if (driver.getTitle().contains("404")) {
			        		
			        		System.out.println("ERROR 404 FOUND ON PAGE!!!!!");
			        		test.log(LogStatus.FAIL, "ERROR 404 FOUND ON PAGE!!!!!: - " + href);
			        		String path = ScreenShot.Image(driver, "Link Error");
				  			String imagePath = test.addScreenCapture(path);
				  			test.log(LogStatus.INFO, imagePath);
				  			
			        		
			        	}else if (driver.getPageSource().contains("not found")){
			        		
			        		System.out.println("Page Not Found Error..!!");
			        		test.log(LogStatus.FAIL, "Page Not Found Error..!!: - " + href);
			        		String path = ScreenShot.Image(driver, "Link Error");
				  			String imagePath = test.addScreenCapture(path);
				  			test.log(LogStatus.INFO, imagePath);	
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
			        
			        //TODO
			        try {
			           	
			        	
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
						      
						      System.out.println("-----------------------------------------------------");
						   
						  }
			       	
			       }catch (Exception e) {

			       	System.out.println("Image Array Method not Validated");
			       	System.out.println("e");
			       	
			       }    
			        
			        driver.navigate().back();
			        Thread.sleep(3000); // To check if the navigation is happening properly.
			        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			        System.out.println("Navigate Back");
			        System.out.println("+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++");
	  			    	
	  		}
	  	
	  }catch (Exception e) {
	  						
	  		test.log(LogStatus.FAIL, "Validation Failed");
	  		Assert.fail("Exception " + e);
	  }
	    
  }
  
  @Test (priority = 10, groups = {"Smoke","BS_Smoke","BS_Sanity","Smoke_Firefox","Smoke_Chrome"},dataProviderClass =Test_DataSanity.class, dataProvider="IndexLinksAllSites")
  public void Wizard_Link_Test(String Websitename, String WebsiteUrl) {
	  
	  test = report.startTest("Nav Links Test --> Wizard Link Test" + Websitename);
	 
	  driver.get(WebsiteUrl);
	  driver.manage().window().maximize();
	  driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
		
	  try {
		  
		  NavigationElements.ClickWizardLink();
		  driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
		  test.log(LogStatus.INFO, "Page Opened");
		  
		  // TODO - Find All Links Method
		  
		  System.out.println(driver.getTitle());
		  driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
		  test.log(LogStatus.INFO, "Page Title is:" + driver.getTitle());
	        
		     String url = "";
	      
		     List<WebElement> demovar = driver.findElement(By.xpath(".//*[@class='contentWrapper']")).findElements(By.tagName("a"));
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
			        Thread.sleep(3000); // To check if the navigation is happening properly.
			        
			        try {
			        	
			        	 System.out.println("Page Title Is:-" + driver.getTitle());
			        	 
			        }catch (Exception e) {
			        	
			        	System.out.println("Page Has no Title");
			        	System.out.println(e);
			        }
			        
			      
			        try {
			        	
			        	if (driver.getTitle().contains("404")) {
			        		
			        		System.out.println("ERROR 404 FOUND ON PAGE!!!!!");
			        		test.log(LogStatus.FAIL, "ERROR 404 FOUND ON PAGE!!!!!: - " + href);
			        		String path = ScreenShot.Image(driver, "Link Error");
				  			String imagePath = test.addScreenCapture(path);
				  			test.log(LogStatus.INFO, imagePath);
				  			
			        		
			        	}else if (driver.getPageSource().contains("not found")){
			        		
			        		System.out.println("Page Not Found Error..!!");
			        		test.log(LogStatus.FAIL, "Page Not Found Error..!!: - " + href);
			        		String path = ScreenShot.Image(driver, "Link Error");
				  			String imagePath = test.addScreenCapture(path);
				  			test.log(LogStatus.INFO, imagePath);	
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
	  	
	  }catch (Exception e) {
	  						
	  		test.log(LogStatus.FAIL, "Validation Failed");
	  		Assert.fail("Exception " + e);
	  }
	    
  }
  
  @Test (priority = 11, groups = {"Smoke","BS_Smoke","BS_Sanity","Smoke_Firefox","Smoke_Chrome"},dataProviderClass =Test_DataSanity.class, dataProvider="IndexLinksAllSites")
  public void About_Link_Test(String Websitename, String WebsiteUrl) {
	  
	  test = report.startTest("Nav Links Test --> About Link Test" + Websitename);
	  
	  driver.get(WebsiteUrl);
	  driver.manage().window().maximize();
	  driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
	  
	  try {
		  
		  NavigationElements.ClickAboutLink();
		  driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
		  test.log(LogStatus.INFO, "Page Opened");
		  
		  // TODO - Find All Links Method
		  
		  System.out.println(driver.getTitle());
		  driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
		  test.log(LogStatus.INFO, "Page Title is:" + driver.getTitle());
	        
		     String url = "";
	      
		     List<WebElement> demovar = driver.findElement(By.xpath(".//*[@class='contentWrapper']")).findElements(By.tagName("a"));
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
			        Thread.sleep(3000); // To check if the navigation is happening properly.
			        
			        try {
			        	
			        	 System.out.println("Page Title Is:-" + driver.getTitle());
			        	 
			        }catch (Exception e) {
			        	
			        	System.out.println("Page Has no Title");
			        	System.out.println(e);
			        }
			        
			      
			        try {
			        	
			        	if (driver.getTitle().contains("404")) {
			        		
			        		System.out.println("ERROR 404 FOUND ON PAGE!!!!!");
			        		test.log(LogStatus.FAIL, "ERROR 404 FOUND ON PAGE!!!!!: - " + href);
			        		String path = ScreenShot.Image(driver, "Link Error");
				  			String imagePath = test.addScreenCapture(path);
				  			test.log(LogStatus.INFO, imagePath);
				  			
			        		
			        	}else if (driver.getPageSource().contains("not found")){
			        		
			        		System.out.println("Page Not Found Error..!!");
			        		test.log(LogStatus.FAIL, "Page Not Found Error..!!: - " + href);
			        		String path = ScreenShot.Image(driver, "Link Error");
				  			String imagePath = test.addScreenCapture(path);
				  			test.log(LogStatus.INFO, imagePath);	
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
			        
			        //TODO
			        try {
			           	
			        	
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
						      
						      System.out.println("-----------------------------------------------------");
						   
						  }
			       	
			       }catch (Exception e) {

			       	System.out.println("Image Array Method not Validated");
			       	System.out.println("e");
			       	
			       }    
			        
			        driver.navigate().back();
			        Thread.sleep(3000); // To check if the navigation is happening properly.
			        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			        System.out.println("Navigate Back");
			        System.out.println("+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++");
	  			    	
	  		}
	  	
	  }catch (Exception e) {
	  						
	  		test.log(LogStatus.FAIL, "Page Title Not Accurate");
	  		//Assert.fail("Exception " + e);
	  }
	    
  }
  
  @Test (priority = 12, groups = {"Smoke","BS_Smoke","BS_Sanity","Smoke_Firefox","Smoke_Chrome"},dataProviderClass =Test_DataSanity.class, dataProvider="IndexLinksAllSites")
  public void Support_Link_Test(String Websitename, String WebsiteUrl) {
	  
	  test = report.startTest("Nav Links Test --> Support Link Test" + Websitename);
	  
	  driver.get(WebsiteUrl);
	  driver.manage().window().maximize();
	  driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
	  
	  try {
		   
		  
		  NavigationElements.ClickSupportLink();
		  driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
		  test.log(LogStatus.INFO, "Page Opened");
		  
		  // TODO - Find All Links Method
		  
		  System.out.println(driver.getTitle());
		  driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
		  test.log(LogStatus.INFO, "Page Title is:" + driver.getTitle());
	        
		     String url = "";
	      
		     List<WebElement> demovar = driver.findElement(By.xpath(".//*[@class='contentWrapper']")).findElements(By.tagName("a"));
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
			        Thread.sleep(3000); // To check if the navigation is happening properly.
			        
			        try {
			        	
			        	 System.out.println("Page Title Is:-" + driver.getTitle());
			        	 
			        }catch (Exception e) {
			        	
			        	System.out.println("Page Has no Title");
			        	System.out.println(e);
			        }
			        
			      
			        try {
			        	
			        	if (driver.getTitle().contains("404")) {
			        		
			        		System.out.println("ERROR 404 FOUND ON PAGE!!!!!");
			        		test.log(LogStatus.FAIL, "ERROR 404 FOUND ON PAGE!!!!!: - " + href);
			        		String path = ScreenShot.Image(driver, "Link Error");
				  			String imagePath = test.addScreenCapture(path);
				  			test.log(LogStatus.INFO, imagePath);
				  			
			        		
			        	}else if (driver.getPageSource().contains("not found")){
			        		
			        		System.out.println("Page Not Found Error..!!");
			        		test.log(LogStatus.FAIL, "Page Not Found Error..!!: - " + href);
			        		String path = ScreenShot.Image(driver, "Link Error");
				  			String imagePath = test.addScreenCapture(path);
				  			test.log(LogStatus.INFO, imagePath);	
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
			        
			        //TODO
			        try {
			           	
			        	
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
						      
						      System.out.println("-----------------------------------------------------");
						   
						  }
			       	
			       }catch (Exception e) {

			       	System.out.println("Image Array Method not Validated");
			       	System.out.println("e");
			       	
			       }    
			        
			        driver.navigate().back();
			        Thread.sleep(3000); // To check if the navigation is happening properly.
			        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			        System.out.println("Navigate Back");
			        System.out.println("+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++");
	  			    	
	  		}
	  	
	  }catch (Exception e) {
	  						
	  		test.log(LogStatus.FAIL, "Validation Failed");
	  		Assert.fail("Exception " + e);
	  }
	    
  }
  
  @Test (priority = 13, groups = {"Smoke","BS_Smoke","BS_Sanity","Smoke_Firefox","Smoke_Chrome"},dataProviderClass =Test_DataSanity.class, dataProvider="IndexLinksAllSites" )
  public void Blog_Link_Test(String Websitename, String WebsiteUrl) {
	  
	  test = report.startTest("Nav Links Test --> Blog Link Test" + Websitename);
	  
	  driver.get(WebsiteUrl);
	  driver.manage().window().maximize();
	  driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
		
	  try {
		  
		  NavigationElements.ClickBlogLink();
		  driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
		  test.log(LogStatus.INFO, "Page Opened");
		  
		  // TODO - Find All Links Method
		  
		  System.out.println(driver.getTitle());
		  driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
		  test.log(LogStatus.INFO, "Page Title is:" + driver.getTitle());
	        
		     String url = "";
	      
		     List<WebElement> demovar = driver.findElement(By.xpath(".//*[@class='contentWrapper']")).findElements(By.tagName("a"));
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
			        Thread.sleep(3000); // To check if the navigation is happening properly.
			        
			        try {
			        	
			        	 System.out.println("Page Title Is:-" + driver.getTitle());
			        	 
			        }catch (Exception e) {
			        	
			        	System.out.println("Page Has no Title");
			        	System.out.println(e);
			        }
			        
			      
			        try {
			        	
			        	if (driver.getTitle().contains("404")) {
			        		
			        		System.out.println("ERROR 404 FOUND ON PAGE!!!!!");
			        		test.log(LogStatus.FAIL, "ERROR 404 FOUND ON PAGE!!!!!: - " + href);
			        		String path = ScreenShot.Image(driver, "Link Error");
				  			String imagePath = test.addScreenCapture(path);
				  			test.log(LogStatus.INFO, imagePath);
				  			
			        		
			        	}else if (driver.getPageSource().contains("not found")){
			        		
			        		System.out.println("Page Not Found Error..!!");
			        		test.log(LogStatus.FAIL, "Page Not Found Error..!!: - " + href);
			        		String path = ScreenShot.Image(driver, "Link Error");
				  			String imagePath = test.addScreenCapture(path);
				  			test.log(LogStatus.INFO, imagePath);	
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
			        
			        //TODO
			        try {
			           	
			        	
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
						      
						      System.out.println("-----------------------------------------------------");
						   
						  }
			       	
			       }catch (Exception e) {

			       	System.out.println("Image Array Method not Validated");
			       	System.out.println("e");
			       	
			       }    
			        
			        driver.navigate().back();
			        Thread.sleep(3000); // To check if the navigation is happening properly.
			        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			        System.out.println("Navigate Back");
			        System.out.println("+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++");
	  			    	
	  		}
	  	
	  }catch (Exception e) {
	  						
	  		test.log(LogStatus.FAIL, "Validation Failed");
	  		Assert.fail("Exception " + e);
	  }
	    
  }

}
