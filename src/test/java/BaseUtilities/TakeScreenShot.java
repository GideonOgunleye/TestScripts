package BaseUtilities;

import org.testng.annotations.Test;

import com.relevantcodes.extentreports.LogStatus;

import org.testng.annotations.BeforeTest;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;

public class TakeScreenShot extends DriverLoad {
	
	
	//public WebDriver driver;
	//ITestResult result;
	
   public static String getRandomString(int length) {
	   
		StringBuilder sb = new StringBuilder();
		String characters = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890";
		for (int i = 0; i < length; i++) {
			
			int index = (int) (Math.random() * characters.length());
			sb.append(characters.charAt(index));
			
		}
		
		return sb.toString();
	}
	
		
	public String Image (WebDriver driver, String result) throws Exception {
	
		
		String filename = result + getRandomString(10) + ".png";
	    String Directory = "C:\\Users\\Gideon Okunleye\\Documents\\Testing Documents\\ScreenShots\\Regression ScreenShots\\";
		  
	    File sourceFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(sourceFile, new File(Directory + filename));
		
		String destination = Directory + filename;
		return destination;
		 
	}

  
}
