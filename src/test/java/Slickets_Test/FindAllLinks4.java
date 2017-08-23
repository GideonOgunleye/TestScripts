package Slickets_Test;
 
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
 
import org.openqa.selenium.WebDriver;
 
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
 
public class FindAllLinks4 {
	
	//private static String[] links = null;
	//private static int linksCount = 0;
	static List<String> hrefs = new ArrayList<String>(); //List for storing all href values for 'a' tag
	WebDriver driver;
	
    public FindAllLinks4(WebDriver driver) {
    	
        this.driver = driver;
    }
    
    public void linkTest() {
        // loop over all the a elements in the page
    	
            try{
            	
       		 List<WebElement> demovar=driver.findElements(By.tagName("a"));
    		 System.out.println(demovar.size());
    		 String url = "";

    		 //ArrayList<String> hrefs = new ArrayList<String>(); //List for storing all href values for 'a' tag
    		 

    		    for (WebElement var : demovar) {
    		    	
    		    	url = var.getAttribute("href");
    		    	
    	            if(url == null || url.isEmpty()){
    	            	System.out.println("URL is either not configured for anchor tag or it is empty");
    	            	                continue;
    	             }
    	       
    	              if(!url.contains("ssl247.co.uk")){
    	            	  
    	                  System.out.println("URL belongs to another domain, skipping it.");
    	                  System.out.println(var.getText());
    	                  continue;
    	                  
    	              	}
    	              if(url.contains("/#")){
    	            	  
    	                  System.out.println("Irrelevant Url");
    	                  continue;
    	                  
    	              	}
    	              if(url.contains("@ssl247.co.uk")){
    	            	  
    	                  System.out.println("Irrelevant Url");
    	                  continue;
    	                  
    	              	}
    	              
    		            if(var.isDisplayed() && !hrefs.contains(url)){
    		            	
    		            	//System.out.println("URL is either not configured for anchor tag or it is empty");
    		            	//continue;
    		            	//hrefs.add(url);
    		            	//System.out.println(url);
    		            	
    				        System.out.println(var.getText()); // used to get text present between the anchor tags
    				        System.out.println(var.getAttribute("href"));
    				        hrefs.add(var.getAttribute("href")); 
    				        var.click();
    				        System.out.println("Clicked On Link");
    				        new FindAllLinks4(driver).linkTest();
    				       
    				        System.out.println("*************************************");
    		            	
    		             }
    		            
   				        //System.out.println(var.getText()); // used to get text present between the anchor tags
				        //System.out.println(var.getAttribute("href"));
				       // hrefs.add(var.getAttribute("href")); 
    		          
    		    }

    		    driver.navigate().back();
                
    		    
    		   //Navigating to each link
    		/*    int i=0;
    		    
    		    for (String href : hrefs) {
    		    	
    		    	/*if (hrefs.contains(url)) {
    		    		
    		    		 driver.navigate().to(href);
    	    		     System.out.println((++i)+": navigated to URL with href: "+href);
    	    		        
    	    		     //hrefs.add(var.getAttribute("href")); 

    	    		     new FindAllLinks4(driver).linkTest();
    		    		
    		    	}
    		    	
		    		 driver.navigate().to(href);
	    		     System.out.println((++i)+": navigated to URL with href: "+href);
	    		     
	    		     new FindAllLinks4(driver).linkTest();
    		       
    		        
    		        Thread.sleep(3000); // To check if the navigation is happening properly.
    		        
    		        try {
    		        	
    		        	 System.out.println("Page Title Is:-" + driver.getTitle());
    		      
    		 		    
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
    		        
    		        
    		        
    		    }*/
            
        }catch(Exception e) {
            e.printStackTrace();
        }
                     
    }

	
 
	public static void main(String[] args) throws Exception {
 
		WebDriver driver = new ChromeDriver();
		
		System.setProperty("webdriver.chrome.driver", "C:\\chromedriver.exe");
		    
		driver.get("https://www.ssl247.co.uk/");
		driver.manage().window().maximize();
	
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		 new FindAllLinks4(driver).linkTest();

		 //driver.get("http://bing.com");

		
	}
}