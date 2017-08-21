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
import org.openqa.selenium.htmlunit.HtmlUnitDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;

public class HtmlUnit {
	
	
	public WebDriver driver;
	


  @BeforeClass (groups = {"Sanity","SQL","Regression","Smoke"} )
  public void beforeTest() throws IOException  {
	
 	 
	  //System.setProperty("webdriver.chrome.driver", "C:\\chromedriver.exe");
	  //driver = new ChromeDriver();
	  driver = new HtmlUnitDriver();
	  driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
	  
   
  }

  @AfterClass (groups = {"Sanity","SQL","Regression","Smoke"})
  public void afterTest() throws Exception {
	  
	  Thread.sleep(10000);
		 //report.endTest(test);
		 
	driver.quit();

	  
  }

 
  
}
