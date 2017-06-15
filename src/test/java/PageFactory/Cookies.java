package PageFactory;

import PageFactory.DriverLoad;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeTest;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterTest;

public class Cookies extends DriverLoad {
	
	DriverLoad LoadDriver;
	
	
	@FindBy (id="cookiesStatus")
	public static WebElement CookiesButton;
	
	@FindBy (xpath="html/body/div[4]/p[1]")
	public static WebElement CookiesMsg;
	
	@FindBy (xpath=".//*[@id='ackCookies']")
	public static WebElement CookiesButton2;
	
	
	
	public Cookies(WebDriver driver){
		
		this.driver = driver;
		PageFactory.initElements(new AjaxElementLocatorFactory(driver, 100), this);
		//PageFactory.initElements(driver, this);
		
	}
	
	public void CheckCookies() {
		
		driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
			
		try {
			
			if (CookiesButton.isDisplayed()) {
			
				CookiesButton.click();
				System.out.println("Cookies Button Has Been Clicked");
			}
		
		}catch(Exception e) {
			System.out.println("Cookies Button Not Displayed");
			
			}
		

		
	}
	
	public void CheckCookies2() {
		
		driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
		//String Message = "Cookies";
		
		try {
			
			if (CookiesButton2.isDisplayed()) {
			
				CookiesButton2.click();
				driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
				System.out.println("Cookies Displayed");
			}
		
		}catch(Exception e) {
			System.out.println("Cookies Not Displayed");
			
			}
	
	}
	
	
	public void ClickCookiesButton(){
			
		CookiesButton.click();
	}
	
	public void ClickCookiesButton2(){
		
		CookiesButton2.click();
	}
	

	
}
