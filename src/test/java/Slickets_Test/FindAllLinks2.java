package Slickets_Test;
 
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
 
import org.openqa.selenium.WebDriver;
 
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
 
public class FindAllLinks2 {
	
	//private static String[] links = null;
	//private static int linksCount = 0;
	 
	
 
	public static void main(String[] args) throws Exception {
 
		WebDriver driver = new ChromeDriver();
		
		System.setProperty("webdriver.chrome.driver", "C:\\chromedriver.exe");
		    
		driver.get("https://www.ssl247.co.uk/ssl-certificates/brands/symantec");
		driver.manage().window().maximize();
		
		//WebElement element = driver.findElement(By.id(Value));
		
		
		 driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		 //driver.get("http://bing.com");

		 //List<WebElement> demovar=driver.findElements(By.tagName("a"));
		 List<WebElement> demovar = driver.findElement(By.xpath(".//*[@class='page-content ha']")).findElements(By.tagName("a"));
		 System.out.println(demovar.size());
		 String url = "";

		 ArrayList<String> hrefs = new ArrayList<String>(); //List for storing all href values for 'a' tag
		 

		    for (WebElement var : demovar) {
		    	
		    	url = var.getAttribute("href");
		    	
	            if(url == null || url.isEmpty()){
	            	System.out.println("URL is either not configured for anchor tag or it is empty");
	            	  continue;
	             }
	       
	              if(!url.contains("ssl247.co.uk")){
	            	  
	                  System.out.println("URL belongs to another domain, skipping it.");
	                  continue;
	                  
	              	}
	              if(url.contains("ssl247.co.uk/#")){
	            	  
	                  System.out.println("Irrelevant Url");
	                  continue;
	                  
	              	}
	              
		           /* if(var.isDisplayed() && !hrefs.contains(var.getText())){
		            	//System.out.println("URL is either not configured for anchor tag or it is empty");
		            	//continue;
		             }*/
	            
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
		        	 
		    	/*	 List<WebElement> demovar2=driver.findElements(By.tagName("a"));
		    		 System.out.println(demovar2.size());
		    		 String url2 = "";
		        	
		    		 //*************************
		 		    for (WebElement var2 : demovar2) {
				    	
				    	url2 = var2.getAttribute("href");
				    	
			            if(url2 == null || url.isEmpty()){
			            	
			            	System.out.println("URL is either not configured for anchor tag or it is empty");
			            	                continue;
			             }
			            
			              if(url2.contains("ssl247.co.uk/#")){
			            	  
			                  System.out.println("Irrelevant Url");
			                  continue;
			                  
			              	}
			              if(url2.contentEquals("www.ssl247.co.uk")){
			            	  
			                  System.out.println("Irrelevant Url-2");
			                  continue;
			              	}
			              
			              if(!url2.contains("ssl247.co.uk")){
			            	  
			                  System.out.println("URL belongs to another domain, skipping it.");
			                  continue;
			                  
			              	}
			           
				        System.out.println(var2.getText()); // used to get text present between the anchor tags
				        System.out.println(var2.getAttribute("href"));
				        hrefs.add(var2.getAttribute("href")); 
				        System.out.println("****************");
			         
				    }*/
		 		    
		        	//*****************************
		 		    
		        }catch (Exception e) {
		        	
		        	System.out.println("Page Has no Title");
		        	System.out.println(e);
		        }
		        
		        try {
		        	
		        	if (driver.getPageSource().contains("404")) {
		        		
		        		System.out.println("ERROR 404 FOUNF ON PAGE!!!!!");
		        		
		        	}else if (driver.getPageSource().contains("not found")){
		        		
		        		System.out.println("Page Not Foun Error..!!");
		        		
		        	}
		        	
		        }catch (Exception k){
		        	
		        	
		        }
		        
		        driver.navigate().back();
		        Thread.sleep(3000); // To check if the navigation is happening properly.
		        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		        System.out.println("Navigate Back");
		        System.out.println("+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++");
		    }
		
	}
}