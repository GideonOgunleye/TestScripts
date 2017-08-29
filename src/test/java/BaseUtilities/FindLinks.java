package BaseUtilities;

import org.testng.annotations.Test;

import com.csvreader.CsvWriter;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import org.testng.annotations.BeforeTest;

import java.io.BufferedOutputStream;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.io.Writer;
import java.net.URL;
import java.net.URLConnection;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;

public class FindLinks extends Chrome {
	
	ExtentReports report;
	ExtentTest test;
	
	DriverLoad LoadDriver;
	
	
	//@FindBy (name="data[User][password]")
	//WebElement Password;
	
	
	public FindLinks(WebDriver driver){
		
		this.driver = driver;
		PageFactory.initElements(new AjaxElementLocatorFactory(driver, 100), this);
		//PageFactory.initElements(driver, this);
		
	}
	
	
 public void DemoTestlinks (String Websitename, String Path, String CurrentUrl) throws Exception {
		
		//report = ExtentFactory.getInstance4();
		

	  try {
		  
			String csv = Path;
			boolean isFileExist = new File(csv).exists();
			CsvWriter testcases = new CsvWriter(new FileWriter(csv, true), ',');
			
			if (!isFileExist) {
				
				testcases.write("Websitename");
		    	testcases.write("Page");
		    	testcases.write("Url");
		    	testcases.write("Page Error");
		    	testcases.write("Status");
				testcases.write("Content Error");
				testcases.write("Image Src");
				testcases.write("Image Error");
				testcases.endRecord();
				testcases.flush();
				
			}
		  
		     // TODO - Find All Links Method
		        
		     String url = "";
	      
		     List<WebElement> demovar = driver.findElements(By.tagName("a"));
		     //List<WebElement> demovar = driver.findElement(By.xpath(".//*[@class='contentWrapper']")).findElements(By.tagName("a"));
			 System.out.println(demovar.size());
			 
			 
			 
			 ArrayList<String> hrefs = new ArrayList<String>(); //List for storing all href values for 'a' tag
			 ArrayList<String> Externalhrefs = new ArrayList<String>(); //List for storing all External href values for 'a' tag
			 ArrayList<String> pdfs = new ArrayList<String>(); //List for storing all values for 'a' tag containing pdfs
			 
			    for (WebElement var : demovar) {
			    	
			    	url = var.getAttribute("href");
			    	
			    	
			    	
			    	if(url == null || url.isEmpty()){
		            	System.out.println("URL is either not configured for anchor tag or it is empty");
		            	                continue;
		             }
		            if(var.getAttribute("class").contains("top-flag sprite-flags-24px") || var.getAttribute("class").contains("home nav-a--")
		            	|| var.getAttribute("id").contains("home-top-ssl_logo-2")){
		            	System.out.println("div skipped");
		            	System.out.println(url);
		            	continue;
		             }

		              if(url.contains("tel:")){
		            	  
		            	  System.out.println("Telephone number link Skipped");
		                  continue;
		                  
		              	}
		              
		              if(url.contains("mailto:")){
		            	  
		            	  System.out.println("Telephone number link Skipped");
		                  continue;
		                  
		              	}
		              
		              if(url.contains("#")){
		            	  
		                  System.out.println("Irrelevant Url");
		            	  //System.out.println("Skppied Ssl Links");
		                  continue;
		                  
		              	}
		              
		              	if(url.contains(".pdf")){
		            	  
		              		pdfs.add(var.getAttribute("href"));
		                  //System.out.println("Irrelevant Url");
		            	  //System.out.println("Skppied Ssl Links");
		                  //continue;
		                  
		              	}
		              	
		           /*  if(!url.contains("kb/ssl-certificates")){
	            	  
	            	  System.out.println("Irrelevant Domain.");
	                  continue;
	                  
	              		}*/
		             if(hrefs.contains(url)){
		            	  
		            	  System.out.println("Already visited Domain.");
		            	  System.out.println(url);
		                  continue;
		                  
		              		}
		              
		              if(!url.contains("ssl247.")){
		            	  
		            	  Externalhrefs.add(var.getAttribute("href"));
		                  //continue;
		                  
		              	}else {
		              		
		    		        System.out.println(var.getText()); // used to get text present between the anchor tags
		    		        System.out.println(var.getAttribute("href"));
		    		        hrefs.add(var.getAttribute("href")); 
		    		       
		    		      /* try {
		    		        	
		    		        //driver.navigate().to(var.getAttribute("href"));  
		    		        Thread.sleep(1000);
		    		        new FindLinks(driver).Submenupagelinks(Websitename, Path, CurrentUrl);
		    		        driver.navigate().back();
		    		        Thread.sleep(1000);
		    		        continue;
		    		        
		    		        }catch (Exception e) {
		    		        	
		    		        	System.out.println("Stale");
		    		        	
		    		        }*/
		    		        
		    		        
		    		        
		    		        System.out.println("*************************************");
		    		        
		    		        
		              	}
		            
			    }

//if (isFileExist){
			    
			    
			    //Navigating to each External Link.
			    int j=0;
			    for (String href : Externalhrefs) {
			    	
			    	//List<String> PageUrl = new ArrayList<> (Arrays.asList ( driver.getCurrentUrl()));
			    	//List<String> arrayList = new ArrayList<> ( Arrays.asList ( "a" , "b" , "c" ) );
			    	
			        driver.navigate().to(href);
			        System.out.println((++j)+": navigated to ExternalURL with href: "+href);
			        Thread.sleep(5000); // To check if the navigation is happening properly.
			        System.out.println("Page Title Is:-" + driver.getTitle());
	        
			        if (driver.getTitle().contains("404")) {
			        	System.out.println("ERROR 404 FOUND ON PAGE!!!!!");
			        	testcases.write(Websitename);
			        	testcases.write(CurrentUrl);
			        	testcases.write(href);	
		        		testcases.write("Error 404");
		        		testcases.write("Fail");
						testcases.write("");
						testcases.write("");
						testcases.write("");
						testcases.endRecord();
						testcases.flush();
						
						
		        	}else if (driver.getPageSource().contains("This site can’t be reached") 
		        			|| driver.getPageSource().contains("This publication has not been activated")){
		        		
		        		System.out.println("Page Not Found Error..!!");
		        		testcases.write(Websitename);
		        		testcases.write(CurrentUrl);
		        		testcases.write(href);
		        		testcases.write("Page Not Found");
		        		testcases.write("Fail");
						testcases.write("");
						testcases.write("");
						testcases.write("");
						testcases.endRecord();
						testcases.flush();
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
			        
			       /* try {
			        	
			        	 System.out.println("Page Title Is:-" + driver.getTitle());
			        	 
			        }catch (Exception e) {
			        	
			        	System.out.println("Page Has no Title");
			        	System.out.println(e);
			        }*/
			        
			      
			        try {
			        	
			        	if (driver.getTitle().contains("404")) {

			        		System.out.println("ERROR 404 FOUND ON PAGE!!!!!");
			        		testcases.write(Websitename);
			        		testcases.write(CurrentUrl);
			        		testcases.write(href);
			        		testcases.write("Error 404");
			        		testcases.write("Fail");
							testcases.write("");
							testcases.write("");
							testcases.write("");
							testcases.endRecord();
							testcases.flush();
			        		
			        	}else if (driver.getPageSource().contains("Page not found")){
			        		
			        		System.out.println("Page Not Found Error..!!");
			        		testcases.write(Websitename);
			        		testcases.write(CurrentUrl);
			        		testcases.write(href);
			        		testcases.write("Page not Found");
			        		testcases.write("Fail");
			        		testcases.write("");
							testcases.write("");
							testcases.write("");
							testcases.endRecord();
							testcases.flush();

			        	}else {
			        		

			        		
			        	}
			        	
			        try {
			        	
			    		WebElement ContentDiv = driver.findElement(By.xpath(".//*[@class='page-content']"));
			    		
				         if(ContentDiv.getText().isEmpty()) {
				        		
				        	System.out.println("Content Div is empty");
				        	testcases.write(Websitename);
				        	testcases.write(CurrentUrl);
				    		testcases.write(href);
				    		testcases.write("");
				    		testcases.write("Fail");
				    		testcases.write("Content Div is empty");
				    		testcases.write("");
				    		testcases.write("");
				    		testcases.endRecord();
				    		testcases.flush();
				        		
				         }else {
				        		
				        		System.out.println("Page Has Content");
				        	}
			        	
			        }catch (Exception e){

			        	System.out.println("Page Content Dive Not Found");

		        		}
			        
			        //Try Page Content # Div
			        
			        try {
			        	
				    		WebElement ContentDiv = driver.findElement(By.xpath(".//*[@class='page-content ha']"));
				    		
					         if(ContentDiv.getText().isEmpty()) {
					        		
					        	System.out.println("Content Div is empty");
					        	testcases.write(Websitename);
					        	testcases.write(CurrentUrl);
					        	testcases.write(href);
					    		testcases.write("");
					    		testcases.write("Fail");
					    		testcases.write("Content Div is empty");
					    		testcases.write("");
					    		testcases.write("");
					    		testcases.endRecord();
					    		testcases.flush();
					        		
					         }else {
					        	 
					        		System.out.println("Page Has Content");
					        	}
				        	
				      }catch (Exception e){

				    	  System.out.println("Page Content # Dive Not Found");

			        	}
			        
			        //Try Page Content Fullwidth_Page	
			        
			        try {
			        	
				    		WebElement ContentDiv = driver.findElement(By.xpath(".//*[@class='page-content fullwidth_page']"));
				    		
					         if(ContentDiv.getText().isEmpty()) {
					        		
					        	System.out.println("Content Div is empty");
					        	testcases.write(Websitename);
					        	testcases.write(CurrentUrl);
					        	testcases.write(href);
					    		testcases.write("");
					    		testcases.write("Fail");
					    		testcases.write("Content Div is empty");
					    		testcases.write("");
					    		testcases.write("");
					    		testcases.endRecord();
					    		testcases.flush();
					    		
					         }else {
					        		
					        		System.out.println("Page Has Content");
					        		
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
						      System.out.println("Image Size is: " + size+"Bytes");
						    
						      if (size > 250000 ) {
						    	  
						    	System.out.println("Image Size is greater than 250kb!!!");
						    	testcases.write(Websitename);
						  		testcases.write(href);
						  		testcases.write("");
								testcases.write("");
								testcases.write("Fail");
								testcases.write("");
								testcases.write(webElement.getAttribute("src"));
								testcases.write("greater than 250kb!!!");
								testcases.endRecord();
								testcases.flush();
						    	  
						      }else {
						    	  
						    	  System.out.println("Image Size is less than 250kb"); 
						    	  
						      }

						      System.out.println("-----------------------------------------------------");
						   
						  }
			       	
			       }catch (Exception e) {

			       	System.out.println("Image Array Method not Validated");
			       	System.out.println("e");
			       	
			       } 
			        
			        /* //Download PDFs
				    //int i=0;
				   // for (String href : hrefs) {
			        try {
			           	
			        	
				  		  //List<WebElement> inputs = driver.findElements(By.tagName("img"));
						  //System.out.println("Total images are " + inputs.size());
			        	  int p=0;
						  for (String hrefp : pdfs) {
							  
						      //WebElement webElement = (WebElement) iterator.next();
						      URLConnection urlConnection = new URL(hrefp).openConnection();
						      int size = urlConnection.getContentLength();
						      System.out.println("pdf Src Is:"+ hrefp);
						      System.out.println("pdf Size is: " + size+"Bytes");
						    
						      if (size > 250000 ) {
						    	  
						    	System.out.println("pdf Size is greater than 250kb!!!");
						    	testcases.write(Websitename);
						  		testcases.write(CurrentUrl);
						  		testcases.write("");
								testcases.write("");
								testcases.write("Fail");
								testcases.write("");
								testcases.write(hrefp);
								testcases.write("greater than 250kb!!!");
								testcases.endRecord();
								testcases.flush();
						    	  
						      }else {
						    	  
						    	  System.out.println("Image Size is less than 250kb"); 
						    	  
						      }

						      System.out.println("-----------------------------------------------------");
						   
						  }
			       	
			       }catch (Exception e) {

			       	System.out.println("PDF Array Method not Validated");
			       	System.out.println("e");
			       	
			       } */
			        
			        //new FindLinks(driver).Submenupagelinks(Websitename, Path, driver.getCurrentUrl());
			        
			        driver.navigate().back();
			        Thread.sleep(5000); // To check if the navigation is happening properly.
			        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			        System.out.println("Navigate Back");
			        System.out.println("+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++");
			           	
			    }
			//}

			testcases.close();

		  }catch (Exception e) {
			  
		  		Assert.fail("Exception " + e);
		  }
		  
	}
	
	
	public void Indexpagelinks (String Websitename, String Path, String CurrentUrl) throws Exception {
		
		//report = ExtentFactory.getInstance4();
		

		  try {
			  
				String csv = Path;
				boolean isFileExist = new File(csv).exists();
				CsvWriter testcases = new CsvWriter(new FileWriter(csv, true), ',');
				
				if (!isFileExist) {
					
					testcases.write("Websitename");
			    	testcases.write("Page");
			    	testcases.write("Url");
			    	testcases.write("Page Error");
			    	testcases.write("Status");
					testcases.write("Content Error");
					testcases.write("Image Src");
					testcases.write("Image Error");
					testcases.endRecord();
					testcases.flush();
					
				}
			  
			     // TODO - Find All Links Method
			        
			     String url = "";
		      
			     List<WebElement> demovar = driver.findElements(By.tagName("a"));
			     //List<WebElement> demovar = driver.findElement(By.xpath(".//*[@class='contentWrapper']")).findElements(By.tagName("a"));
				 System.out.println(demovar.size());
				 
				 
				 
				 ArrayList<String> hrefs = new ArrayList<String>(); //List for storing all href values for 'a' tag
				 ArrayList<String> Externalhrefs = new ArrayList<String>(); //List for storing all External href values for 'a' tag
				
				 
				    for (WebElement var : demovar) {
				    	
				    	url = var.getAttribute("href");
				    	
				    	
				    	
				    	if(url == null || url.isEmpty()){
			            	System.out.println("URL is either not configured for anchor tag or it is empty");
			            	                continue;
			             }
			            if(var.getAttribute("class").contains("top-flag sprite-flags-24px") || var.getAttribute("class").contains("home nav-a--")
			            	|| var.getAttribute("id").contains("home-top-ssl_logo-2")){
			            	System.out.println("div skipped");
			            	System.out.println(url);
			            	continue;
			             }

			              if(url.contains("tel:")){
			            	  
			            	  System.out.println("Telephone number link Skipped");
			                  continue;
			                  
			              	}
			              
			              if(url.contains("mailto:")){
			            	  
			            	  System.out.println("Telephone number link Skipped");
			                  continue;
			                  
			              	}
			              
			              if(url.contains("#")){
			            	  
			                  System.out.println("Irrelevant Url");
			            	  //System.out.println("Skppied Ssl Links");
			                  continue;
			                  
			              	}
			              
			              	if(url.contains(".pdf")){
			            	  
			                  System.out.println("Irrelevant Url");
			            	  //System.out.println("Skppied Ssl Links");
			                  continue;
			                  
			              	}
			              	
			           /*  if(!url.contains("kb/ssl-certificates")){
		            	  
		            	  System.out.println("Irrelevant Domain.");
		                  continue;
		                  
		              		}*/
			             if(hrefs.contains(url)){
			            	  
			            	  System.out.println("Already visited Domain.");
			            	  System.out.println(url);
			                  continue;
			                  
			              		}
			              
			              if(!url.contains("ssl247.")){
			            	  
			            	  Externalhrefs.add(var.getAttribute("href"));
			                  //continue;
			                  
			              	}else {
			              		
			    		        System.out.println(var.getText()); // used to get text present between the anchor tags
			    		        System.out.println(var.getAttribute("href"));
			    		        hrefs.add(var.getAttribute("href")); 
			    		       
			    		      /* try {
			    		        	
			    		        //driver.navigate().to(var.getAttribute("href"));  
			    		        Thread.sleep(1000);
			    		        new FindLinks(driver).Submenupagelinks(Websitename, Path, CurrentUrl);
			    		        driver.navigate().back();
			    		        Thread.sleep(1000);
			    		        continue;
			    		        
			    		        }catch (Exception e) {
			    		        	
			    		        	System.out.println("Stale");
			    		        	
			    		        }*/
			    		        
			    		        
			    		        
			    		        System.out.println("*************************************");
			    		        
			    		        
			              	}
			            
				    }

	//if (isFileExist){
				    
				    
				    //Navigating to each External Link.
				    int j=0;
				    for (String href : Externalhrefs) {
				    	
				    	//List<String> PageUrl = new ArrayList<> (Arrays.asList ( driver.getCurrentUrl()));
				    	//List<String> arrayList = new ArrayList<> ( Arrays.asList ( "a" , "b" , "c" ) );
				    	
				        driver.navigate().to(href);
				        System.out.println((++j)+": navigated to ExternalURL with href: "+href);
				        Thread.sleep(5000); // To check if the navigation is happening properly.
				        System.out.println("Page Title Is:-" + driver.getTitle());
		        
				        if (driver.getTitle().contains("404")) {
				        	System.out.println("ERROR 404 FOUND ON PAGE!!!!!");
				        	testcases.write(Websitename);
				        	testcases.write(CurrentUrl);
				        	testcases.write(href);	
			        		testcases.write("Error 404");
			        		testcases.write("Fail");
							testcases.write("");
							testcases.write("");
							testcases.write("");
							testcases.endRecord();
							testcases.flush();
							
							
			        	}else if (driver.getPageSource().contains("This site can’t be reached") 
			        			|| driver.getPageSource().contains("This publication has not been activated")){
			        		
			        		System.out.println("Page Not Found Error..!!");
			        		testcases.write(Websitename);
			        		testcases.write(CurrentUrl);
			        		testcases.write(href);
			        		testcases.write("Page Not Found");
			        		testcases.write("Fail");
							testcases.write("");
							testcases.write("");
							testcases.write("");
							testcases.endRecord();
							testcases.flush();
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
				        
				       /* try {
				        	
				        	 System.out.println("Page Title Is:-" + driver.getTitle());
				        	 
				        }catch (Exception e) {
				        	
				        	System.out.println("Page Has no Title");
				        	System.out.println(e);
				        }*/
				        
				      
				        try {
				        	
				        	if (driver.getTitle().contains("404")) {

				        		System.out.println("ERROR 404 FOUND ON PAGE!!!!!");
				        		testcases.write(Websitename);
				        		testcases.write(CurrentUrl);
				        		testcases.write(href);
				        		testcases.write("Error 404");
				        		testcases.write("Fail");
								testcases.write("");
								testcases.write("");
								testcases.write("");
								testcases.endRecord();
								testcases.flush();
				        		
				        	}else if (driver.getPageSource().contains("Page not found")){
				        		
				        		System.out.println("Page Not Found Error..!!");
				        		testcases.write(Websitename);
				        		testcases.write(CurrentUrl);
				        		testcases.write(href);
				        		testcases.write("Page not Found");
				        		testcases.write("Fail");
				        		testcases.write("");
								testcases.write("");
								testcases.write("");
								testcases.endRecord();
								testcases.flush();

				        	}else {
				        		

				        		
				        	}
				        	
				        try {
				        	
				    		WebElement ContentDiv = driver.findElement(By.xpath(".//*[@class='page-content']"));
				    		
					         if(ContentDiv.getText().isEmpty()) {
					        		
					        	System.out.println("Content Div is empty");
					        	testcases.write(Websitename);
					        	testcases.write(CurrentUrl);
					    		testcases.write(href);
					    		testcases.write("");
					    		testcases.write("Fail");
					    		testcases.write("Content Div is empty");
					    		testcases.write("");
					    		testcases.write("");
					    		testcases.endRecord();
					    		testcases.flush();
					        		
					         }else {
					        		
					        		System.out.println("Page Has Content");
					        	}
				        	
				        }catch (Exception e){

				        	System.out.println("Page Content Dive Not Found");

			        		}
				        
				        //Try Page Content # Div
				        
				        try {
				        	
					    		WebElement ContentDiv = driver.findElement(By.xpath(".//*[@class='page-content ha']"));
					    		
						         if(ContentDiv.getText().isEmpty()) {
						        		
						        	System.out.println("Content Div is empty");
						        	testcases.write(Websitename);
						        	testcases.write(CurrentUrl);
						        	testcases.write(href);
						    		testcases.write("");
						    		testcases.write("Fail");
						    		testcases.write("Content Div is empty");
						    		testcases.write("");
						    		testcases.write("");
						    		testcases.endRecord();
						    		testcases.flush();
						        		
						         }else {
						        	 
						        		System.out.println("Page Has Content");
						        	}
					        	
					      }catch (Exception e){

					    	  System.out.println("Page Content # Dive Not Found");

				        	}
				        
				        //Try Page Content Fullwidth_Page	
				        
				        try {
				        	
					    		WebElement ContentDiv = driver.findElement(By.xpath(".//*[@class='page-content fullwidth_page']"));
					    		
						         if(ContentDiv.getText().isEmpty()) {
						        		
						        	System.out.println("Content Div is empty");
						        	testcases.write(Websitename);
						        	testcases.write(CurrentUrl);
						        	testcases.write(href);
						    		testcases.write("");
						    		testcases.write("Fail");
						    		testcases.write("Content Div is empty");
						    		testcases.write("");
						    		testcases.write("");
						    		testcases.endRecord();
						    		testcases.flush();
						    		
						         }else {
						        		
						        		System.out.println("Page Has Content");
						        		
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
							      System.out.println("Image Size is: " + size+"Bytes");
							    
							      if (size > 250000 ) {
							    	  
							    	System.out.println("Image Size is greater than 250kb!!!");
							    	testcases.write(Websitename);
							  		testcases.write(href);
							  		testcases.write("");
									testcases.write("");
									testcases.write("Fail");
									testcases.write("");
									testcases.write(webElement.getAttribute("src"));
									testcases.write("greater than 250kb!!!");
									testcases.endRecord();
									testcases.flush();
							    	  
							      }else {
							    	  
							    	  System.out.println("Image Size is less than 250kb"); 
							    	  
							      }

							      System.out.println("-----------------------------------------------------");
							   
							  }
				       	
				       }catch (Exception e) {

				       	System.out.println("Image Array Method not Validated");
				       	System.out.println("e");
				       	
				       } 
				        
				        //new FindLinks(driver).Submenupagelinks(Websitename, Path, driver.getCurrentUrl());
				        
				        driver.navigate().back();
				        Thread.sleep(5000); // To check if the navigation is happening properly.
				        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
				        System.out.println("Navigate Back");
				        System.out.println("+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++");
				           	
				    }
				//}

				testcases.close();

			  }catch (Exception e) {
				  
			  		Assert.fail("Exception " + e);
		}
		  
}
	
	
	public void Submenupagelinks (String Websitename, String Path, String CurrentUrl) throws Exception {
		
		  try {
			  
			  	//driver.findElement(By.cssSelector("body")).sendKeys(Keys.CONTROL +"t");
			  	//driver.switchTo().window(CurrentUrl);
			  	
			   /* Actions builder = new Actions(driver);
			  	Action openLinkInNewTab = builder
			  	         //.moveToElement(CurrentUrl)
			  	         .sendKeys(CurrentUrl, Keys.CONTROL)
			  	         .sendKeys(Keys.ENTER)
			  	         //.keyUp(Keys.CONTROL)
			  	         .build();

			  	openLinkInNewTab.perform();*/
			  	
			  	
				String csv = Path;
				boolean isFileExist = new File(csv).exists();
				CsvWriter testcases = new CsvWriter(new FileWriter(csv, true), ',');
				
			/*	if (!isFileExist) {
					
					testcases.write("Websitename");
			    	testcases.write("Page");
	        		testcases.write("Url");
	        		testcases.write("Page Error");
	        		testcases.write("Status");
					testcases.write("Content Error");
					testcases.write("Image Src");
					testcases.write("Image Error");
					testcases.endRecord();
					
				}*/
			  
			     // TODO - Find All Links Method
			        
			     String url = "";
		      
			     //List<WebElement> demovar = driver.findElements(By.tagName("a"));
			     List<WebElement> demovar = driver.findElement(By.xpath(".//*[@class='contentWrapper']")).findElements(By.tagName("a"));
				 System.out.println(demovar.size());
				 
				 ArrayList<String> hrefs = new ArrayList<String>(); //List for storing all href values for 'a' tag
				 ArrayList<String> Externalhrefs = new ArrayList<String>(); //List for storing all External href values for 'a' tag
				
				 
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
			              
			              if(url.contains("mailto:")){
			            	  
			            	  System.out.println("Telephone number link Skipped");
			                  continue;
			                  
			              	}
			              
			              if(url.contains(".pdf")){
			            	  
			                  System.out.println("Irrelevant Url");
			            	  //System.out.println("Skppied Ssl Links");
			                  continue;
			                  
			              	}
			              
			              if(url.contains("#")){
			            	  
			                  System.out.println("Irrelevant Url");
			            	  //System.out.println("Skppied Ssl Links");
			                  continue;
			                  
			              	}
			            /*  if(!url.contains("manage/")){
			            	  
			                  System.out.println("Irrelevant Domain");
			            	  //System.out.println("Skppied Ssl Links");
			                  continue;
			                  
			              	}*/
			              
			              if(hrefs.contains(url)){
			            	  
			                  System.out.println("Already Visited Url");
			                  System.out.println(url);
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
	
//if (isFileExist){
				    
				    
				    //Navigating to each External Link.
				    int j=0;
				    for (String href : Externalhrefs) {

				        driver.navigate().to(href);
				        System.out.println("Sub 1- "+(++j)+": navigated to ExternalURL with href: "+href);
				        Thread.sleep(5000); // To check if the navigation is happening properly.
				        System.out.println("Page Title Is:-" + driver.getTitle());
		        
				        if (driver.getTitle().contains("404")) {
				        	System.out.println("ERROR 404 FOUND ON PAGE!!!!!");
					    	testcases.write(Websitename);
					    	testcases.write(CurrentUrl);
				        	testcases.write(href);	
			        		testcases.write("Error 404");
			        		testcases.write("Fail");
							testcases.write("");
							testcases.write("");
							testcases.write("");
							testcases.endRecord();
							testcases.flush();
							
			        	}else if (driver.getPageSource().contains("This site can’t be reached")
			        			|| driver.getPageSource().contains("This publication has not been activated")){
			        		
			        		System.out.println("Page Not Found Error..!!");
					    	testcases.write(Websitename);
					    	testcases.write(CurrentUrl);
			        		testcases.write(href);
			        		testcases.write("Page Not Found");
			        		testcases.write("Fail");
							testcases.write("");
							testcases.write("");
							testcases.write("");
							testcases.endRecord();	
							testcases.flush();
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
				        System.out.println("Sub 1- "+(++i)+": navigated to URL with href: "+href);
				   
				        Thread.sleep(3000); // To check if the navigation is happening properly.
				        
				       /* try {
				        	
				        	 System.out.println("Page Title Is:-" + driver.getTitle());
				        	 
				        }catch (Exception e) {
				        	
				        	System.out.println("Page Has no Title");
				        	System.out.println(e);
				        }*/
				        
				      
				        try {
				        	
				        	if (driver.getTitle().contains("404")) {

				        		System.out.println("ERROR 404 FOUND ON PAGE!!!!!");
				        		testcases.write(Websitename);
				        		testcases.write(CurrentUrl);
				        		testcases.write(href);
				        		testcases.write("Error 404");
				        		testcases.write("Fail");
								testcases.write("");
								testcases.write("");
								testcases.write("");
								testcases.endRecord();
								testcases.flush();
				        		
				        	}else if (driver.getPageSource().contains("Page not found")){
				        		
				        		System.out.println("Page Not Found Error..!!");
				        		testcases.write(Websitename);
				        		testcases.write(CurrentUrl);
				        		testcases.write(href);
				        		testcases.write("Page not Found");
				        		testcases.write("Fail");
				        		testcases.write("");
								testcases.write("");
								testcases.write("");
								testcases.endRecord();
								testcases.flush();
	
				        	}else {
				        		

				        		
				        	}
				        	
				        try {
				        	
				    		WebElement ContentDiv = driver.findElement(By.xpath(".//*[@class='page-content']"));
				    		
					         if(ContentDiv.getText().isEmpty()) {
					        		
					        	System.out.println("Content Div is empty");
					        	testcases.write(Websitename);
					        	testcases.write(CurrentUrl);
					    		testcases.write(href);
					    		testcases.write("");
					    		testcases.write("Fail");
					    		testcases.write("Content Div is empty");
					    		testcases.write("");
					    		testcases.write("");
					    		testcases.endRecord();
					    		testcases.flush();
					        		
					         }else {
					        		
					        		System.out.println("Page Has Content");
					        	}
				        	
				        }catch (Exception e){

				        	System.out.println("Page Content Dive Not Found");

			        		}
				        
				        //Try Page Content # Div
				        
				        try {
				        	
					    		WebElement ContentDiv = driver.findElement(By.xpath(".//*[@class='page-content ha']"));
					    		
						         if(ContentDiv.getText().isEmpty()) {
						        		
						        	System.out.println("Content Div is empty");
						        	testcases.write(Websitename);
						        	testcases.write(CurrentUrl);
						        	testcases.write(href);
						    		testcases.write("");
						    		testcases.write("Fail");
						    		testcases.write("Content Div is empty");
						    		testcases.write("");
						    		testcases.write("");
						    		testcases.endRecord();
						    		testcases.flush();
						        		
						         }else {
						        	 
						        		System.out.println("Page Has Content");
						        	}
					        	
					      }catch (Exception e){

					    	  System.out.println("Page Content # Dive Not Found");

				        	}
				        
				        //Try Page Content Fullwidth_Page	
				        
				        try {
				        	
					    		WebElement ContentDiv = driver.findElement(By.xpath(".//*[@class='page-content fullwidth_page']"));
					    		
						         if(ContentDiv.getText().isEmpty()) {
						        		
						        	System.out.println("Content Div is empty");
						        	testcases.write(Websitename);
						        	driver.navigate().back();
						        	testcases.write(CurrentUrl);
						        	testcases.write(href);
						    		testcases.write("");
						    		testcases.write("Fail");
						    		testcases.write("Content Div is empty");
						    		testcases.write("");
						    		testcases.write("");
						    		testcases.endRecord();
						    		testcases.flush();
						    		
						         }else {
						        		
						        		System.out.println("Page Has Content");
						        		
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
							      System.out.println("Image Size is: " + size+"Bytes");
							    
							      if (size > 250000 ) {
							    	  
							    	System.out.println("Image Size is greater than 250kb!!!");
							    	testcases.write(Websitename);
							  		testcases.write(href);
							  		testcases.write("");
									testcases.write("");
									testcases.write("Fail");
									testcases.write("");
									testcases.write(webElement.getAttribute("src"));
									testcases.write("greater than 250kb!!!");
									testcases.endRecord();
									testcases.flush();
							    	  
							      }else {
							    	  
							    	  System.out.println("Image Size is less than 250kb"); 
							    	  
							      }

							      System.out.println("-----------------------------------------------------");
							   
							  }
				       	
				       }catch (Exception e) {

				       	System.out.println("Image Array Method not Validated");
				       	System.out.println("e");
				       	
				       } 
				        
				        new FindLinks(driver).Submenupagelinks2(Websitename, Path, driver.getCurrentUrl());
				        
				        driver.navigate().back();
				        Thread.sleep(3000); // To check if the navigation is happening properly.
				        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
				        System.out.println("Navigate Back");
				        System.out.println("+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++");
				           	
				    }
				//}

				//testcases.close();

			  }catch (Exception e) {
				  
			  		//Assert.fail("Exception " + e);
				  System.out.println("E");
			  }
	  
	}

	public void Submenupagelinks2 (String Websitename, String Path, String CurrentUrl) throws Exception {
		
		  try {
			  
				String csv = Path;
				boolean isFileExist = new File(csv).exists();
				CsvWriter testcases = new CsvWriter(new FileWriter(csv, true), ',');
				
			/*	if (!isFileExist) {
					
					testcases.write("Websitename");
			    	testcases.write("Page");
	        		testcases.write("Url");
	        		testcases.write("Page Error");
	        		testcases.write("Status");
					testcases.write("Content Error");
					testcases.write("Image Src");
					testcases.write("Image Error");
					testcases.endRecord();
					
				}*/
			  
			     // TODO - Find All Links Method
			        
			     String url = "";
		      
			     //List<WebElement> demovar = driver.findElements(By.tagName("a"));
			     List<WebElement> demovar = driver.findElement(By.xpath(".//*[@class='contentWrapper']")).findElements(By.tagName("a"));
				 System.out.println(demovar.size());
				 
				 ArrayList<String> hrefs = new ArrayList<String>(); //List for storing all href values for 'a' tag
				 ArrayList<String> Externalhrefs = new ArrayList<String>(); //List for storing all External href values for 'a' tag
				
				 
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
			              
			              if(url.contains("mailto:")){
			            	  
			            	  System.out.println("Telephone number link Skipped");
			                  continue;
			                  
			              	}
			              
			              if(url.contains(".pdf")){
			            	  
			                  System.out.println("Irrelevant Url");
			            	  //System.out.println("Skppied Ssl Links");
			                  continue;
			                  
			              	}
			              
			              if(url.contains("#")){
			            	  
			                  System.out.println("Irrelevant Url");
			            	  //System.out.println("Skppied Ssl Links");
			                  continue;
			                  
			              	}
			            /*  if(!url.contains("manage/")){
			            	  
			                  System.out.println("Irrelevant Domain");
			            	  //System.out.println("Skppied Ssl Links");
			                  continue;
			                  
			              	}*/
			              
			              if(hrefs.contains(url)){
			            	  
			                  System.out.println("Already Visited Url");
			                  System.out.println(url);
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
	
//if (isFileExist){
				    
				    
				    //Navigating to each External Link.
				    int j=0;
				    for (String href : Externalhrefs) {

				        driver.navigate().to(href);
				        System.out.println("Sub 2- "+(++j)+": navigated to ExternalURL with href: "+href);
				        Thread.sleep(5000); // To check if the navigation is happening properly.
				        System.out.println("Page Title Is:-" + driver.getTitle());
		        
				        if (driver.getTitle().contains("404")) {
				        	System.out.println("ERROR 404 FOUND ON PAGE!!!!!");
					    	testcases.write(Websitename);
					    	testcases.write(CurrentUrl);
				        	testcases.write(href);	
			        		testcases.write("Error 404");
			        		testcases.write("Fail");
							testcases.write("");
							testcases.write("");
							testcases.write("");
							testcases.endRecord();
							testcases.flush();
							
			        	}else if (driver.getPageSource().contains("This site can’t be reached")
			        			|| driver.getPageSource().contains("This publication has not been activated")){
			        		
			        		System.out.println("Page Not Found Error..!!");
					    	testcases.write(Websitename);
					    	testcases.write(CurrentUrl);
			        		testcases.write(href);
			        		testcases.write("Page Not Found");
			        		testcases.write("Fail");
							testcases.write("");
							testcases.write("");
							testcases.write("");
							testcases.endRecord();	
							testcases.flush();
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
				        System.out.println("Sub 2- "+(++i)+": navigated to URL with href: "+href);
				   
				        Thread.sleep(3000); // To check if the navigation is happening properly.
				        
				       /* try {
				        	
				        	 System.out.println("Page Title Is:-" + driver.getTitle());
				        	 
				        }catch (Exception e) {
				        	
				        	System.out.println("Page Has no Title");
				        	System.out.println(e);
				        }*/
				        
				      
				        try {
				        	
				        	if (driver.getTitle().contains("404")) {

				        		System.out.println("ERROR 404 FOUND ON PAGE!!!!!");
				        		testcases.write(Websitename);
				        		testcases.write(CurrentUrl);
				        		testcases.write(href);
				        		testcases.write("Error 404");
				        		testcases.write("Fail");
								testcases.write("");
								testcases.write("");
								testcases.write("");
								testcases.endRecord();
								testcases.flush();
				        		
				        	}else if (driver.getPageSource().contains("Page not found")){
				        		
				        		System.out.println("Page Not Found Error..!!");
				        		testcases.write(Websitename);
				        		testcases.write(CurrentUrl);
				        		testcases.write(href);
				        		testcases.write("Page not Found");
				        		testcases.write("Fail");
				        		testcases.write("");
								testcases.write("");
								testcases.write("");
								testcases.endRecord();
								testcases.flush();
	
				        	}else {
				        		

				        		
				        	}
				        	
				        try {
				        	
				    		WebElement ContentDiv = driver.findElement(By.xpath(".//*[@class='page-content']"));
				    		
					         if(ContentDiv.getText().isEmpty()) {
					        		
					        	System.out.println("Content Div is empty");
					        	testcases.write(Websitename);
					        	testcases.write(CurrentUrl);
					    		testcases.write(href);
					    		testcases.write("");
					    		testcases.write("Fail");
					    		testcases.write("Content Div is empty");
					    		testcases.write("");
					    		testcases.write("");
					    		testcases.endRecord();
					    		testcases.flush();
					        		
					         }else {
					        		
					        		System.out.println("Page Has Content");
					        	}
				        	
				        }catch (Exception e){

				        	System.out.println("Page Content Dive Not Found");

			        		}
				        
				        //Try Page Content # Div
				        
				        try {
				        	
					    		WebElement ContentDiv = driver.findElement(By.xpath(".//*[@class='page-content ha']"));
					    		
						         if(ContentDiv.getText().isEmpty()) {
						        		
						        	System.out.println("Content Div is empty");
						        	testcases.write(Websitename);
						        	testcases.write(CurrentUrl);
						        	testcases.write(href);
						    		testcases.write("");
						    		testcases.write("Fail");
						    		testcases.write("Content Div is empty");
						    		testcases.write("");
						    		testcases.write("");
						    		testcases.endRecord();
						    		testcases.flush();
						        		
						         }else {
						        	 
						        		System.out.println("Page Has Content");
						        	}
					        	
					      }catch (Exception e){

					    	  System.out.println("Page Content # Dive Not Found");

				        	}
				        
				        //Try Page Content Fullwidth_Page	
				        
				        try {
				        	
					    		WebElement ContentDiv = driver.findElement(By.xpath(".//*[@class='page-content fullwidth_page']"));
					    		
						         if(ContentDiv.getText().isEmpty()) {
						        		
						        	System.out.println("Content Div is empty");
						        	testcases.write(Websitename);
						        	driver.navigate().back();
						        	testcases.write(CurrentUrl);
						        	testcases.write(href);
						    		testcases.write("");
						    		testcases.write("Fail");
						    		testcases.write("Content Div is empty");
						    		testcases.write("");
						    		testcases.write("");
						    		testcases.endRecord();
						    		testcases.flush();
						    		
						         }else {
						        		
						        		System.out.println("Page Has Content");
						        		
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
							      System.out.println("Image Size is: " + size+"Bytes");
							    
							      if (size > 250000 ) {
							    	  
							    	System.out.println("Image Size is greater than 250kb!!!");
							    	testcases.write(Websitename);
							  		testcases.write(href);
							  		testcases.write("");
									testcases.write("");
									testcases.write("Fail");
									testcases.write("");
									testcases.write(webElement.getAttribute("src"));
									testcases.write("greater than 250kb!!!");
									testcases.endRecord();
									testcases.flush();
							    	  
							      }else {
							    	  
							    	  System.out.println("Image Size is less than 250kb"); 
							    	  
							      }

							      System.out.println("-----------------------------------------------------");
							   
							  }
				       	
				       }catch (Exception e) {

				       	System.out.println("Image Array Method not Validated");
				       	System.out.println("e");
				       	
				       } 
				        
				        new FindLinks(driver).Submenupagelinks3(Websitename, Path, driver.getCurrentUrl());
				        
				        driver.navigate().back();
				        Thread.sleep(3000); // To check if the navigation is happening properly.
				        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
				        System.out.println("Navigate Back");
				        System.out.println("+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++");
				           	
				    }
				//}

				//testcases.close();

			  }catch (Exception e) {
				  
			  		//Assert.fail("Exception " + e);
				  System.out.println("E");
			  }
	  
	}
	
	public void Submenupagelinks3 (String Websitename, String Path, String CurrentUrl) throws Exception {
		
		  try {
			  
				String csv = Path;
				boolean isFileExist = new File(csv).exists();
				CsvWriter testcases = new CsvWriter(new FileWriter(csv, true), ',');
				
			/*	if (!isFileExist) {
					
					testcases.write("Websitename");
			    	testcases.write("Page");
	        		testcases.write("Url");
	        		testcases.write("Page Error");
	        		testcases.write("Status");
					testcases.write("Content Error");
					testcases.write("Image Src");
					testcases.write("Image Error");
					testcases.endRecord();
					
				}*/
			  
			     // TODO - Find All Links Method
			        
			     String url = "";
		      
			     //List<WebElement> demovar = driver.findElements(By.tagName("a"));
			     List<WebElement> demovar = driver.findElement(By.xpath(".//*[@class='contentWrapper']")).findElements(By.tagName("a"));
				 System.out.println(demovar.size());
				 
				 ArrayList<String> hrefs = new ArrayList<String>(); //List for storing all href values for 'a' tag
				 ArrayList<String> Externalhrefs = new ArrayList<String>(); //List for storing all External href values for 'a' tag
				
				 
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
			              
			              if(url.contains("mailto:")){
			            	  
			            	  System.out.println("Telephone number link Skipped");
			                  continue;
			                  
			              	}
			              
			              if(url.contains(".pdf")){
			            	  
			                  System.out.println("Irrelevant Url");
			            	  //System.out.println("Skppied Ssl Links");
			                  continue;
			                  
			              	}
			              
			              if(url.contains("#")){
			            	  
			                  System.out.println("Irrelevant Url");
			            	  //System.out.println("Skppied Ssl Links");
			                  continue;
			                  
			              	}
			            /*  if(!url.contains("manage/")){
			            	  
			                  System.out.println("Irrelevant Domain");
			            	  //System.out.println("Skppied Ssl Links");
			                  continue;
			                  
			              	}*/
			              
			              if(hrefs.contains(url)){
			            	  
			                  System.out.println("Already Visited Url");
			                  System.out.println(url);
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
	
//if (isFileExist){
				    
				    
				    //Navigating to each External Link.
				    int j=0;
				    for (String href : Externalhrefs) {

				        driver.navigate().to(href);
				        System.out.println("Sub 3- "+(++j)+": navigated to ExternalURL with href: "+href);
				        Thread.sleep(5000); // To check if the navigation is happening properly.
				        System.out.println("Page Title Is:-" + driver.getTitle());
		        
				        if (driver.getTitle().contains("404")) {
				        	System.out.println("ERROR 404 FOUND ON PAGE!!!!!");
					    	testcases.write(Websitename);
					    	testcases.write(CurrentUrl);
				        	testcases.write(href);	
			        		testcases.write("Error 404");
			        		testcases.write("Fail");
							testcases.write("");
							testcases.write("");
							testcases.write("");
							testcases.endRecord();
							testcases.flush();
							
			        	}else if (driver.getPageSource().contains("This site can’t be reached")
			        			|| driver.getPageSource().contains("This publication has not been activated")){
			        		
			        		System.out.println("Page Not Found Error..!!");
					    	testcases.write(Websitename);
					    	testcases.write(CurrentUrl);
			        		testcases.write(href);
			        		testcases.write("Page Not Found");
			        		testcases.write("Fail");
							testcases.write("");
							testcases.write("");
							testcases.write("");
							testcases.endRecord();	
							testcases.flush();
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
				        System.out.println("Sub 3- "+(++i)+": navigated to URL with href: "+href);
				   
				        Thread.sleep(3000); // To check if the navigation is happening properly.
				        
				       /* try {
				        	
				        	 System.out.println("Page Title Is:-" + driver.getTitle());
				        	 
				        }catch (Exception e) {
				        	
				        	System.out.println("Page Has no Title");
				        	System.out.println(e);
				        }*/
				        
				      
				        try {
				        	
				        	if (driver.getTitle().contains("404")) {

				        		System.out.println("ERROR 404 FOUND ON PAGE!!!!!");
				        		testcases.write(Websitename);
				        		testcases.write(CurrentUrl);
				        		testcases.write(href);
				        		testcases.write("Error 404");
				        		testcases.write("Fail");
								testcases.write("");
								testcases.write("");
								testcases.write("");
								testcases.endRecord();
								testcases.flush();
				        		
				        	}else if (driver.getPageSource().contains("Page not found")){
				        		
				        		System.out.println("Page Not Found Error..!!");
				        		testcases.write(Websitename);
				        		testcases.write(CurrentUrl);
				        		testcases.write(href);
				        		testcases.write("Page not Found");
				        		testcases.write("Fail");
				        		testcases.write("");
								testcases.write("");
								testcases.write("");
								testcases.endRecord();
								testcases.flush();
	
				        	}else {
				        		

				        		
				        	}
				        	
				        try {
				        	
				    		WebElement ContentDiv = driver.findElement(By.xpath(".//*[@class='page-content']"));
				    		
					         if(ContentDiv.getText().isEmpty()) {
					        		
					        	System.out.println("Content Div is empty");
					        	testcases.write(Websitename);
					        	testcases.write(CurrentUrl);
					    		testcases.write(href);
					    		testcases.write("");
					    		testcases.write("Fail");
					    		testcases.write("Content Div is empty");
					    		testcases.write("");
					    		testcases.write("");
					    		testcases.endRecord();
					    		testcases.flush();
					        		
					         }else {
					        		
					        		System.out.println("Page Has Content");
					        	}
				        	
				        }catch (Exception e){

				        	System.out.println("Page Content Dive Not Found");

			        		}
				        
				        //Try Page Content # Div
				        
				        try {
				        	
					    		WebElement ContentDiv = driver.findElement(By.xpath(".//*[@class='page-content ha']"));
					    		
						         if(ContentDiv.getText().isEmpty()) {
						        		
						        	System.out.println("Content Div is empty");
						        	testcases.write(Websitename);
						        	testcases.write(CurrentUrl);
						        	testcases.write(href);
						    		testcases.write("");
						    		testcases.write("Fail");
						    		testcases.write("Content Div is empty");
						    		testcases.write("");
						    		testcases.write("");
						    		testcases.endRecord();
						    		testcases.flush();
						        		
						         }else {
						        	 
						        		System.out.println("Page Has Content");
						        	}
					        	
					      }catch (Exception e){

					    	  System.out.println("Page Content # Dive Not Found");

				        	}
				        
				        //Try Page Content Fullwidth_Page	
				        
				        try {
				        	
					    		WebElement ContentDiv = driver.findElement(By.xpath(".//*[@class='page-content fullwidth_page']"));
					    		
						         if(ContentDiv.getText().isEmpty()) {
						        		
						        	System.out.println("Content Div is empty");
						        	testcases.write(Websitename);
						        	driver.navigate().back();
						        	testcases.write(CurrentUrl);
						        	testcases.write(href);
						    		testcases.write("");
						    		testcases.write("Fail");
						    		testcases.write("Content Div is empty");
						    		testcases.write("");
						    		testcases.write("");
						    		testcases.endRecord();
						    		testcases.flush();
						    		
						         }else {
						        		
						        		System.out.println("Page Has Content");
						        		
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
							      System.out.println("Image Size is: " + size+"Bytes");
							    
							      if (size > 250000 ) {
							    	  
							    	System.out.println("Image Size is greater than 250kb!!!");
							    	testcases.write(Websitename);
							  		testcases.write(href);
							  		testcases.write("");
									testcases.write("");
									testcases.write("Fail");
									testcases.write("");
									testcases.write(webElement.getAttribute("src"));
									testcases.write("greater than 250kb!!!");
									testcases.endRecord();
									testcases.flush();
							    	  
							      }else {
							    	  
							    	  System.out.println("Image Size is less than 250kb"); 
							    	  
							      }

							      System.out.println("-----------------------------------------------------");
							   
							  }
				       	
				       }catch (Exception e) {

				       	System.out.println("Image Array Method not Validated");
				       	System.out.println("e");
				       	
				       } 
				        
				        new FindLinks(driver).Submenupagelinks4(Websitename, Path, driver.getCurrentUrl());
				        
				        driver.navigate().back();
				        Thread.sleep(3000); // To check if the navigation is happening properly.
				        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
				        System.out.println("Navigate Back");
				        System.out.println("+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++");
				           	
				    }
				//}

				//testcases.close();

			  }catch (Exception e) {
				  
			  		//Assert.fail("Exception " + e);
				  System.out.println("E");
			  }
	  
	}
	
	public void Submenupagelinks4 (String Websitename, String Path, String CurrentUrl) throws Exception {
		
		  try {
			  
				String csv = Path;
				boolean isFileExist = new File(csv).exists();
				CsvWriter testcases = new CsvWriter(new FileWriter(csv, true), ',');
				
			/*	if (!isFileExist) {
					
					testcases.write("Websitename");
			    	testcases.write("Page");
	        		testcases.write("Url");
	        		testcases.write("Page Error");
	        		testcases.write("Status");
					testcases.write("Content Error");
					testcases.write("Image Src");
					testcases.write("Image Error");
					testcases.endRecord();
					
				}*/
			  
			     // TODO - Find All Links Method
			        
			     String url = "";
		      
			     //List<WebElement> demovar = driver.findElements(By.tagName("a"));
			     List<WebElement> demovar = driver.findElement(By.xpath(".//*[@class='contentWrapper']")).findElements(By.tagName("a"));
				 System.out.println(demovar.size());
				 
				 ArrayList<String> hrefs = new ArrayList<String>(); //List for storing all href values for 'a' tag
				 ArrayList<String> Externalhrefs = new ArrayList<String>(); //List for storing all External href values for 'a' tag
				
				 
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
			              
			              if(url.contains("mailto:")){
			            	  
			            	  System.out.println("Telephone number link Skipped");
			                  continue;
			                  
			              	}
			              
			              if(url.contains(".pdf")){
			            	  
			                  System.out.println("Irrelevant Url");
			            	  //System.out.println("Skppied Ssl Links");
			                  continue;
			                  
			              	}
			              
			              if(url.contains("#")){
			            	  
			                  System.out.println("Irrelevant Url");
			            	  //System.out.println("Skppied Ssl Links");
			                  continue;
			                  
			              	}
			            /*  if(!url.contains("manage/")){
			            	  
			                  System.out.println("Irrelevant Domain");
			            	  //System.out.println("Skppied Ssl Links");
			                  continue;
			                  
			              	}*/
			              
			              if(hrefs.contains(url)){
			            	  
			                  System.out.println("Already Visited Url");
			                  System.out.println(url);
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
	
//if (isFileExist){
				    
				    
				    //Navigating to each External Link.
				    int j=0;
				    for (String href : Externalhrefs) {

				        driver.navigate().to(href);
				        System.out.println("Sub 4- "+(++j)+": navigated to ExternalURL with href: "+href);
				        Thread.sleep(5000); // To check if the navigation is happening properly.
				        System.out.println("Page Title Is:-" + driver.getTitle());
		        
				        if (driver.getTitle().contains("404")) {
				        	System.out.println("ERROR 404 FOUND ON PAGE!!!!!");
					    	testcases.write(Websitename);
					    	testcases.write(CurrentUrl);
				        	testcases.write(href);	
			        		testcases.write("Error 404");
			        		testcases.write("Fail");
							testcases.write("");
							testcases.write("");
							testcases.write("");
							testcases.endRecord();
							testcases.flush();
							
			        	}else if (driver.getPageSource().contains("This site can’t be reached")
			        			|| driver.getPageSource().contains("This publication has not been activated")){
			        		
			        		System.out.println("Page Not Found Error..!!");
					    	testcases.write(Websitename);
					    	testcases.write(CurrentUrl);
			        		testcases.write(href);
			        		testcases.write("Page Not Found");
			        		testcases.write("Fail");
							testcases.write("");
							testcases.write("");
							testcases.write("");
							testcases.endRecord();	
							testcases.flush();
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
				        System.out.println("Sub 4- "+(++i)+": navigated to URL with href: "+href);
				   
				        Thread.sleep(3000); // To check if the navigation is happening properly.
				        
				       /* try {
				        	
				        	 System.out.println("Page Title Is:-" + driver.getTitle());
				        	 
				        }catch (Exception e) {
				        	
				        	System.out.println("Page Has no Title");
				        	System.out.println(e);
				        }*/
				        
				      
				        try {
				        	
				        	if (driver.getTitle().contains("404")) {

				        		System.out.println("ERROR 404 FOUND ON PAGE!!!!!");
				        		testcases.write(Websitename);
				        		testcases.write(CurrentUrl);
				        		testcases.write(href);
				        		testcases.write("Error 404");
				        		testcases.write("Fail");
								testcases.write("");
								testcases.write("");
								testcases.write("");
								testcases.endRecord();
								testcases.flush();
				        		
				        	}else if (driver.getPageSource().contains("Page not found")){
				        		
				        		System.out.println("Page Not Found Error..!!");
				        		testcases.write(Websitename);
				        		testcases.write(CurrentUrl);
				        		testcases.write(href);
				        		testcases.write("Page not Found");
				        		testcases.write("Fail");
				        		testcases.write("");
								testcases.write("");
								testcases.write("");
								testcases.endRecord();
								testcases.flush();
	
				        	}else {
				        		

				        		
				        	}
				        	
				        try {
				        	
				    		WebElement ContentDiv = driver.findElement(By.xpath(".//*[@class='page-content']"));
				    		
					         if(ContentDiv.getText().isEmpty()) {
					        		
					        	System.out.println("Content Div is empty");
					        	testcases.write(Websitename);
					        	testcases.write(CurrentUrl);
					    		testcases.write(href);
					    		testcases.write("");
					    		testcases.write("Fail");
					    		testcases.write("Content Div is empty");
					    		testcases.write("");
					    		testcases.write("");
					    		testcases.endRecord();
					    		testcases.flush();
					        		
					         }else {
					        		
					        		System.out.println("Page Has Content");
					        	}
				        	
				        }catch (Exception e){

				        	System.out.println("Page Content Dive Not Found");

			        		}
				        
				        //Try Page Content # Div
				        
				        try {
				        	
					    		WebElement ContentDiv = driver.findElement(By.xpath(".//*[@class='page-content ha']"));
					    		
						         if(ContentDiv.getText().isEmpty()) {
						        		
						        	System.out.println("Content Div is empty");
						        	testcases.write(Websitename);
						        	testcases.write(CurrentUrl);
						        	testcases.write(href);
						    		testcases.write("");
						    		testcases.write("Fail");
						    		testcases.write("Content Div is empty");
						    		testcases.write("");
						    		testcases.write("");
						    		testcases.endRecord();
						    		testcases.flush();
						        		
						         }else {
						        	 
						        		System.out.println("Page Has Content");
						        	}
					        	
					      }catch (Exception e){

					    	  System.out.println("Page Content # Dive Not Found");

				        	}
				        
				        //Try Page Content Fullwidth_Page	
				        
				        try {
				        	
					    		WebElement ContentDiv = driver.findElement(By.xpath(".//*[@class='page-content fullwidth_page']"));
					    		
						         if(ContentDiv.getText().isEmpty()) {
						        		
						        	System.out.println("Content Div is empty");
						        	testcases.write(Websitename);
						        	driver.navigate().back();
						        	testcases.write(CurrentUrl);
						        	testcases.write(href);
						    		testcases.write("");
						    		testcases.write("Fail");
						    		testcases.write("Content Div is empty");
						    		testcases.write("");
						    		testcases.write("");
						    		testcases.endRecord();
						    		testcases.flush();
						    		
						         }else {
						        		
						        		System.out.println("Page Has Content");
						        		
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
							      System.out.println("Image Size is: " + size+"Bytes");
							    
							      if (size > 250000 ) {
							    	  
							    	System.out.println("Image Size is greater than 250kb!!!");
							    	testcases.write(Websitename);
							  		testcases.write(href);
							  		testcases.write("");
									testcases.write("");
									testcases.write("Fail");
									testcases.write("");
									testcases.write(webElement.getAttribute("src"));
									testcases.write("greater than 250kb!!!");
									testcases.endRecord();
									testcases.flush();
							    	  
							      }else {
							    	  
							    	  System.out.println("Image Size is less than 250kb"); 
							    	  
							      }

							      System.out.println("-----------------------------------------------------");
							   
							  }
				       	
				       }catch (Exception e) {

				       	System.out.println("Image Array Method not Validated");
				       	System.out.println("e");
				       	
				       } 
				        
				        //new FindLinks(driver).Submenupagelinks5(Websitename, Path, driver.getCurrentUrl());
				        
				        driver.navigate().back();
				        Thread.sleep(3000); // To check if the navigation is happening properly.
				        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
				        System.out.println("Navigate Back");
				        System.out.println("+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++");
				           	
				    }
				//}

				//testcases.close();

			  }catch (Exception e) {
				  
			  		//Assert.fail("Exception " + e);
				  System.out.println("E");
			  }
	  
	}
	
	public void Submenupagelinks5 (String Websitename, String Path, String CurrentUrl) throws Exception {
		
		  try {
			  
				String csv = Path;
				boolean isFileExist = new File(csv).exists();
				CsvWriter testcases = new CsvWriter(new FileWriter(csv, true), ',');
				
			/*	if (!isFileExist) {
					
					testcases.write("Websitename");
			    	testcases.write("Page");
	        		testcases.write("Url");
	        		testcases.write("Page Error");
	        		testcases.write("Status");
					testcases.write("Content Error");
					testcases.write("Image Src");
					testcases.write("Image Error");
					testcases.endRecord();
					
				}*/
			  
			     // TODO - Find All Links Method
			        
			     String url = "";
		      
			     //List<WebElement> demovar = driver.findElements(By.tagName("a"));
			     List<WebElement> demovar = driver.findElement(By.xpath(".//*[@class='contentWrapper']")).findElements(By.tagName("a"));
				 System.out.println(demovar.size());
				 
				 ArrayList<String> hrefs = new ArrayList<String>(); //List for storing all href values for 'a' tag
				 ArrayList<String> Externalhrefs = new ArrayList<String>(); //List for storing all External href values for 'a' tag
				
				 
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
			              
			              if(url.contains("mailto:")){
			            	  
			            	  System.out.println("Telephone number link Skipped");
			                  continue;
			                  
			              	}
			              
			              if(url.contains(".pdf")){
			            	  
			                  System.out.println("Irrelevant Url");
			            	  //System.out.println("Skppied Ssl Links");
			                  continue;
			                  
			              	}
			              
			              if(url.contains("#")){
			            	  
			                  System.out.println("Irrelevant Url");
			            	  //System.out.println("Skppied Ssl Links");
			                  continue;
			                  
			              	}
			            /*  if(!url.contains("manage/")){
			            	  
			                  System.out.println("Irrelevant Domain");
			            	  //System.out.println("Skppied Ssl Links");
			                  continue;
			                  
			              	}*/
			              
			              if(hrefs.contains(url)){
			            	  
			                  System.out.println("Already Visited Url");
			                  System.out.println(url);
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
	
//if (isFileExist){
				    
				    
				    //Navigating to each External Link.
				    int j=0;
				    for (String href : Externalhrefs) {

				        driver.navigate().to(href);
				        System.out.println("Sub 5- "+(++j)+": navigated to ExternalURL with href: "+href);
				        Thread.sleep(5000); // To check if the navigation is happening properly.
				        System.out.println("Page Title Is:-" + driver.getTitle());
		        
				        if (driver.getTitle().contains("404")) {
				        	System.out.println("ERROR 404 FOUND ON PAGE!!!!!");
					    	testcases.write(Websitename);
					    	testcases.write(CurrentUrl);
				        	testcases.write(href);	
			        		testcases.write("Error 404");
			        		testcases.write("Fail");
							testcases.write("");
							testcases.write("");
							testcases.write("");
							testcases.endRecord();
							testcases.flush();
							
			        	}else if (driver.getPageSource().contains("This site can’t be reached")
			        			|| driver.getPageSource().contains("This publication has not been activated")){
			        		
			        		System.out.println("Page Not Found Error..!!");
					    	testcases.write(Websitename);
					    	testcases.write(CurrentUrl);
			        		testcases.write(href);
			        		testcases.write("Page Not Found");
			        		testcases.write("Fail");
							testcases.write("");
							testcases.write("");
							testcases.write("");
							testcases.endRecord();	
							testcases.flush();
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
				        System.out.println("Sub 5- "+(++i)+": navigated to URL with href: "+href);
				   
				        Thread.sleep(3000); // To check if the navigation is happening properly.
				        
				       /* try {
				        	
				        	 System.out.println("Page Title Is:-" + driver.getTitle());
				        	 
				        }catch (Exception e) {
				        	
				        	System.out.println("Page Has no Title");
				        	System.out.println(e);
				        }*/
				        
				      
				        try {
				        	
				        	if (driver.getTitle().contains("404")) {

				        		System.out.println("ERROR 404 FOUND ON PAGE!!!!!");
				        		testcases.write(Websitename);
				        		testcases.write(CurrentUrl);
				        		testcases.write(href);
				        		testcases.write("Error 404");
				        		testcases.write("Fail");
								testcases.write("");
								testcases.write("");
								testcases.write("");
								testcases.endRecord();
								testcases.flush();
				        		
				        	}else if (driver.getPageSource().contains("Page not found")){
				        		
				        		System.out.println("Page Not Found Error..!!");
				        		testcases.write(Websitename);
				        		testcases.write(CurrentUrl);
				        		testcases.write(href);
				        		testcases.write("Page not Found");
				        		testcases.write("Fail");
				        		testcases.write("");
								testcases.write("");
								testcases.write("");
								testcases.endRecord();
								testcases.flush();
	
				        	}else {
				        		

				        		
				        	}
				        	
				        try {
				        	
				    		WebElement ContentDiv = driver.findElement(By.xpath(".//*[@class='page-content']"));
				    		
					         if(ContentDiv.getText().isEmpty()) {
					        		
					        	System.out.println("Content Div is empty");
					        	testcases.write(Websitename);
					        	testcases.write(CurrentUrl);
					    		testcases.write(href);
					    		testcases.write("");
					    		testcases.write("Fail");
					    		testcases.write("Content Div is empty");
					    		testcases.write("");
					    		testcases.write("");
					    		testcases.endRecord();
					    		testcases.flush();
					        		
					         }else {
					        		
					        		System.out.println("Page Has Content");
					        	}
				        	
				        }catch (Exception e){

				        	System.out.println("Page Content Dive Not Found");

			        		}
				        
				        //Try Page Content # Div
				        
				        try {
				        	
					    		WebElement ContentDiv = driver.findElement(By.xpath(".//*[@class='page-content ha']"));
					    		
						         if(ContentDiv.getText().isEmpty()) {
						        		
						        	System.out.println("Content Div is empty");
						        	testcases.write(Websitename);
						        	testcases.write(CurrentUrl);
						        	testcases.write(href);
						    		testcases.write("");
						    		testcases.write("Fail");
						    		testcases.write("Content Div is empty");
						    		testcases.write("");
						    		testcases.write("");
						    		testcases.endRecord();
						    		testcases.flush();
						        		
						         }else {
						        	 
						        		System.out.println("Page Has Content");
						        	}
					        	
					      }catch (Exception e){

					    	  System.out.println("Page Content # Dive Not Found");

				        	}
				        
				        //Try Page Content Fullwidth_Page	
				        
				        try {
				        	
					    		WebElement ContentDiv = driver.findElement(By.xpath(".//*[@class='page-content fullwidth_page']"));
					    		
						         if(ContentDiv.getText().isEmpty()) {
						        		
						        	System.out.println("Content Div is empty");
						        	testcases.write(Websitename);
						        	driver.navigate().back();
						        	testcases.write(CurrentUrl);
						        	testcases.write(href);
						    		testcases.write("");
						    		testcases.write("Fail");
						    		testcases.write("Content Div is empty");
						    		testcases.write("");
						    		testcases.write("");
						    		testcases.endRecord();
						    		testcases.flush();
						    		
						         }else {
						        		
						        		System.out.println("Page Has Content");
						        		
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
							      System.out.println("Image Size is: " + size+"Bytes");
							    
							      if (size > 250000 ) {
							    	  
							    	System.out.println("Image Size is greater than 250kb!!!");
							    	testcases.write(Websitename);
							  		testcases.write(href);
							  		testcases.write("");
									testcases.write("");
									testcases.write("Fail");
									testcases.write("");
									testcases.write(webElement.getAttribute("src"));
									testcases.write("greater than 250kb!!!");
									testcases.endRecord();
									testcases.flush();
							    	  
							      }else {
							    	  
							    	  System.out.println("Image Size is less than 250kb"); 
							    	  
							      }

							      System.out.println("-----------------------------------------------------");
							   
							  }
				       	
				       }catch (Exception e) {

				       	System.out.println("Image Array Method not Validated");
				       	System.out.println("e");
				       	
				       } 
				        
				        //new FindLinks(driver).Submenupagelinks2(Websitename, Path, driver.getCurrentUrl());
				        
				        driver.navigate().back();
				        Thread.sleep(3000); // To check if the navigation is happening properly.
				        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
				        System.out.println("Navigate Back");
				        System.out.println("+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++");
				           	
				    }
				//}

				//testcases.close();

			  }catch (Exception e) {
				  
			  		//Assert.fail("Exception " + e);
				  System.out.println("E");
			  }
	  
	}
	
  
}
