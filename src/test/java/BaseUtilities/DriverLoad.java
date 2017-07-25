package BaseUtilities;

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
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;

public class DriverLoad {
	
	
	public WebDriver driver;
	


  @BeforeClass (groups = {"Sanity","SQL","Regression","Smoke","Smoke_Chrome","Sanity_Chrome","Regression_Chrome","BS_Smoke","BS_Sanity"} )
  public void Chrome_BeforeTest() throws IOException  {
	
 	 
	  System.setProperty("webdriver.chrome.driver", "C:\\chromedriver.exe");
	  driver = new ChromeDriver();  
	  //driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
	  
   
  }

  @AfterClass (groups = {"Sanity","SQL","Regression","Smoke","Smoke_Chrome","Sanity_Chrome","Regression_Chrome","BS_Smoke","BS_Sanity"})
  public void Chrome_AfterTest() throws Exception {
	  
	  Thread.sleep(10000);
		 //report.endTest(test);
		 
	driver.quit();

	  
  }
  
  /*
  
  @BeforeClass (groups = {"Smoke_Firefox","Sanity_Firefox","Regression_Firefox"})
  public void Firefox_beforeTest() throws IOException  {
	
 	 
	  System.setProperty("webdriver.gecko.driver", "C:\\geckodriver.exe");
	  driver = new FirefoxDriver();
	  driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
	  
   
  }

  @AfterClass (groups = {"Smoke_Firefox","Sanity_Firefox","Regression_Firefox"})
  public void Firefox_afterTest() throws Exception {
	  
	  Thread.sleep(10000);
		 //report.endTest(test);
		 
	driver.quit();
	  
  }

 */
  
}
