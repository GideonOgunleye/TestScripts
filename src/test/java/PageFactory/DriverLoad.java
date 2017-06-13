package PageFactory;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeTest;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterTest;

public class DriverLoad {
	
	
	public WebDriver driver;
	


  @BeforeTest (groups = {"Sanity","SQL","Regression"} )
  public void beforeTest() throws IOException  {
	
 	  
	  System.setProperty("webdriver.chrome.driver", "C:\\chromedriver.exe");
	  driver = new ChromeDriver();  
	  
   
  }

  @AfterTest (groups = {"Sanity","SQL","Regression"})
  public void afterTest() throws Exception {
	  
	  Thread.sleep(10000);
		 //report.endTest(test);
		 
	driver.quit();

	  
  }

 
  
}
