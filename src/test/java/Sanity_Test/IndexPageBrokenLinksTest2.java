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
import Slickets_Test.FindAllLinks5B;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.HttpURLConnection;
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
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;

public class IndexPageBrokenLinksTest2 extends Chrome {
	
	ExtentReports report;
	ExtentTest test;
	NavigationLinks NavigationElements;
	LoginPage 	LoginPageElements;
	AlertBox AlertBoxElements;
	TakeScreenShot ScreenShot;
	IndexPageBrokenLinksTest2 NewTest;
	
	 static ArrayList<String> hrefs = new ArrayList<String>(); //List for storing all href values for 'a' tag
	 static ArrayList<String> Externalhrefs = new ArrayList<String>(); //List for storing all External href values for 'a' tag
	  
	  
  public IndexPageBrokenLinksTest2(){
	    	
	  //this.driver = driver;
	  //NewTest = new IndexPageBrokenLinksTest2();
  }

  public void linkTest() {
	  
	  try {
		  
	     // TODO - Find All Links Method
	        
	     String url = "";
      
	     List<WebElement> demovar = driver.findElements(By.tagName("a"));
		 System.out.println(demovar.size());
		
		 
		    for (WebElement var : demovar) {
		    	
		    	url = var.getAttribute("href");
		    	
	            if(url == null || url.isEmpty()){
	            	System.out.println("URL is either not configured for anchor tag or it is empty");
	            	                continue;
	             }

	              if(url.contains("tel:")){
	            	  
	            	  System.out.println("Telephone number link Skipped");
	                  continue;
	                  
	              	}
	              
	              if(url.contains("ssl247.")){
	            	  
	            	  System.out.println("Irrelevant Domain.");
	                  continue;
	                  
	              	}
	              
	              if(url.contains("/#")){
	            	  
	                  System.out.println("Irrelevant Url");
	            	  //System.out.println("Skppied Ssl Links");
	                  continue;
	                  
	              	}
	              
	              if(!url.contains("ssl247.")){
	            	  
	            	  Externalhrefs.add(var.getAttribute("href"));
	                  //continue;
	                  
	              	}else {
	              		
	    		        System.out.println(var.getText()); // used to get text present between the anchor tags
	    		        System.out.println(var.getAttribute("href"));
	    		        hrefs.add(var.getAttribute("href")); 
	    		        System.out.println("*************************************");
	              	}
	            
		    }
		    
		    //Navigating to each External Link.
		    int j=0;
		    for (String href : Externalhrefs) {
		    	   	
		        driver.navigate().to(href);
		        System.out.println((++j)+": navigated to ExternalURL with href: "+href);
		        Thread.sleep(3000); // To check if the navigation is happening properly.
		        System.out.println("Page Title Is:-" + driver.getTitle());
		        //test.log(LogStatus.INFO, "External Link is" + href);
		        //test.log(LogStatus.INFO, "Page Title Is:-" + driver.getTitle());
		        
		        if (driver.getTitle().contains("404")) {
		        		
	        		System.out.println("ERROR 404 FOUND ON PAGE!!!!!");
	        		//test.log(LogStatus.FAIL, "ERROR 404 FOUND ON PAGE!!!!!: - " + href);
	        		//String path = ScreenShot.Image(driver, "Link Error");
		  			//String imagePath = test.addScreenCapture(path);
		  			//test.log(LogStatus.INFO, imagePath);
		  			
	        		
	        	}else if (driver.getPageSource().contains("not found")){
	        		
	        		System.out.println("Page Not Found Error..!!");
	        		//test.log(LogStatus.FAIL, "Page Not Found Error..!!: - " + href);
	        		//String path = ScreenShot.Image(driver, "Link Error");
		  			//String imagePath = test.addScreenCapture(path);
		  			//test.log(LogStatus.INFO, imagePath);	
	        	}
		        
		        driver.navigate().back();
		        Thread.sleep(3000); // To check if the navigation is happening properly.
		        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		        System.out.println("Navigate Back");
		        System.out.println("+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++");
		    }
		    
		    
		    
		    
		    
		    

		    //Navigating to each link containing SSl247.
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
		        		/*test.log(LogStatus.FAIL, "ERROR 404 FOUND ON PAGE!!!!!: - " + href);
		        		String path = ScreenShot.Image(driver, "Link Error");
			  			String imagePath = test.addScreenCapture(path);
			  			test.log(LogStatus.INFO, imagePath);
			  			*/
		        		
		        	}else if (driver.getPageSource().contains("not found")){
		        		
		        		System.out.println("Page Not Found Error..!!");
		        		/*test.log(LogStatus.FAIL, "Page Not Found Error..!!: - " + href);
		        		String path = ScreenShot.Image(driver, "Link Error");
			  			String imagePath = test.addScreenCapture(path);
			  			test.log(LogStatus.INFO, imagePath);
			  			*/	
		        	}
		        	
		        try {
		        	
		    		WebElement ContentDiv = driver.findElement(By.xpath(".//*[@class='page-content']"));
		    		
			         if(ContentDiv.getText().isEmpty()) {
			        		
			        	System.out.println("Content Div is empty");
			        	//test.log(LogStatus.FAIL, "Content Link Is Empty----:" + href);
			        		
			         }else {
			        		
			        		System.out.println("Page Has Content");
			        		//test.log(LogStatus.INFO, "Page Has Content:----" + href);
			        	}
		        	
		        }catch (Exception e){

		        	System.out.println("Page Content Dive Not Found");

	        		}
		        
		        //Try Page Content # Div
		        
		        try {
		        	
			    		WebElement ContentDiv = driver.findElement(By.xpath(".//*[@class='page-content ha']"));
			    		
				         if(ContentDiv.getText().isEmpty()) {
				        		
				        	System.out.println("Content Div is empty");
				        	//test.log(LogStatus.FAIL, "Content Link Is Empty----:" + href);
				        		
				         }else {
				        		
				        		System.out.println("Page Has Content");
				        		//test.log(LogStatus.INFO, "Page Has Content:----" + href);
				        	}
			        	
			      }catch (Exception e){

			    	  System.out.println("Page Content # Dive Not Found");

		        	}
		        
		        //Try Page Content Fullwidth_Page	
		        
		        try {
		        	
			    		WebElement ContentDiv = driver.findElement(By.xpath(".//*[@class='page-content fullwidth_page']"));
			    		
				         if(ContentDiv.getText().isEmpty()) {
				        		
				        	System.out.println("Content Div is empty");
				        	//test.log(LogStatus.FAIL, "Content Link Is Empty----:" + href);
				        		
				         }else {
				        		
				        		System.out.println("Page Has Content");
				        		//test.log(LogStatus.INFO, "Page Has Content:----" + href);
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
				    	//  test.log(LogStatus.INFO, "Image Src Is:"+ webElement.getAttribute("src"));
					      System.out.println("Image Size is: " + size+"Bytes");
				    	//  test.log(LogStatus.INFO, "Image Size is: " + size+"Bytes");
					      
					      if (size > 250000 ) {
					    	  
					    	  System.out.println("Image Size is greater than 150kb!!!");
					    	//  test.log(LogStatus.FAIL, "Image Size is greater than 150kb" );
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
	  						
	  	//	test.log(LogStatus.FAIL, "Validation Failed");
	  		Assert.fail("Exception " + e);
	  }

	                     
  }	 
	 
  @BeforeMethod (groups = {"Smoke","BS_Smoke","BS_Sanity","Smoke_Firefox","Smoke_Chrome"})
  public void beforeMethod() throws Exception {
	  
	  NavigationElements = new NavigationLinks(driver);
	  LoginPageElements = new LoginPage(driver);
	  AlertBoxElements = new AlertBox(driver);
	  ScreenShot = new TakeScreenShot();
	  NewTest = new IndexPageBrokenLinksTest2();
	  report = ExtentFactory.getInstance4();

	  
  }

  @AfterMethod (groups = {"Smoke","BS_Smoke","BS_Sanity","Smoke_Firefox","Smoke_Chrome"})
  public void afterMethod(ITestResult result) throws IOException, Exception {
	  

		report.endTest(test);
		report.flush();
	  
  }
  
  
  @Test (priority = 0, groups = {"Smoke","BS_Smoke","BS_Sanity","Smoke_Firefox","Smoke_Chrome"})
  public void HomePage_Test() {
	  
	  
	  test = report.startTest("Nav Links Test --> HomePage Test-  ");
	  
	  driver.get("https://www.ssl247.co.uk");
	  driver.manage().window().maximize();
	  driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
	  
	  NewTest.linkTest();
	  
	  
	  test.log(LogStatus.INFO, "Page Opened");

  }
  
}
