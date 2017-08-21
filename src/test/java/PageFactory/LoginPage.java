package PageFactory;

import org.testng.annotations.Test;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import BaseUtilities.Constants;
import BaseUtilities.DriverLoad;
import BaseUtilities.HandleEvents;

import org.testng.annotations.BeforeTest;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterTest;

public class LoginPage extends DriverLoad {
	
	//DriverLoad LoadDriver;
	
	@FindBy(xpath = ".//*[@id='top-panel']/div[1]/span[1]/a[1]")
	WebElement LoginLink;
	
	@FindBy(xpath = ".//*[@id='top-panel']/div[1]/span[1]/a[2]")
	WebElement RegisterLink;
	
	@FindBy (name="data[User][email]")
	public static WebElement Username;

	@FindBy (name="data[User][password]")
	WebElement Password;
	
	@FindBy (xpath=".//*[@id='UserMysslLoginForm']/button")
	WebElement LoginButton;
	
	@FindBy (xpath = ".//*[@id='top-panel']/div[1]/span[1]/a[2]")
	WebElement LogoutButton;
	
	@FindBy (xpath = ".//*[@id='top-panel']/div[1]/span[1]/a[3]")
	WebElement AdminLogoutButton;
	
	@FindBy (xpath = ".//*[@id='top-panel']/div[1]/span[1]/a[1]")
	WebElement AdminStatus;
	
	public LoginPage(WebDriver driver){
		
		this.driver = driver;
		PageFactory.initElements(new AjaxElementLocatorFactory(driver, 100), this);
		//PageFactory.initElements(driver, this);
		
	}
	

	
	public boolean AdminPageValidation () {
		
		return AdminStatus.isDisplayed();
		
	}
	
	
	public void ClickLoginLink(){
		
		LoginLink.click();
	}
	
	public void ClickRegisterLink(){
		
		RegisterLink.click();
	}
	
	public void EnterUserName(String name){
			
		Username.sendKeys(name);
	}
	
	public void EnterPassword(String Pword) {
		
		Password.sendKeys(Pword);
	}
	
	public boolean LoginLinkIsVisible () {
		
		return LoginLink.getText().contains("Login");
		
	}
	
	public boolean LoginLinkContains (String Label) {
		
		return LoginLink.getText().contains(Label);
		
	}
	
	public void LoginLinkTestPrint() {
		
		 System.out.println("LinkText = " +  LoginLink.getText());
		
	}
	
	public void ClickLoginButton() {
		
		LoginButton.click();
		driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
		
	}
	
	public void LogoutAssert () {
		
		Assert.assertTrue(LogoutButton.getText().contains("Logout"));
	}
	
	public boolean LogoutButtonIsVisible () {
		
		return LogoutButton.getText().contains("Logout");
		
	}
	
	
	public void ClickLogoutButton() {
		
		
		LogoutButton.click();
			
	}
	
	public void ClickAdminLogoutButton() {
		
		AdminLogoutButton.click();
		driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
		//Assert.assertTrue(driver.getTitle().contains("MySSL® Account Login"));
	}
	
	public boolean AdminLogoutButtonIsVisible () {
		
		return AdminLogoutButton.isDisplayed();
		
	}
	
	//UK Login-----------------------------------------------------------------------------------------------------------------------------------	
		public void LoadLoginPage () throws Exception {
			
		  	Properties prop = new Properties();
			FileInputStream fis = new FileInputStream(Constants.File_Path + Constants.DataFile_Name);
					 
			prop.load(fis);

			driver.get(prop.getProperty("Url")); 
			driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
			driver.manage().window().maximize();
			//String title = driver.getTitle();				 
			//Assert.assertTrue(title.contains("SSL Certificates: Buy Symantec, Thawte, Apache SSL Cert, GlobalSign, GeoTrust, RapidSSL- SSL247.co.uk")); 
			//Thread.sleep(5000);
			
		}
		
		public void ClientLogin () throws Exception {
			
		  	Properties prop = new Properties();
			FileInputStream fis = new FileInputStream(Constants.File_Path + Constants.DataFile_Name);
					 
			prop.load(fis);

			driver.get(prop.getProperty("Url")); 
			driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
			driver.manage().window().maximize();
			String title = driver.getTitle();				 
			Assert.assertTrue(title.contains("SSL Certificates: Buy Symantec, Thawte, Apache SSL Cert, GlobalSign, GeoTrust, RapidSSL- SSL247.co.uk")); 
			Thread.sleep(5000);
			
			ClickLoginLink();
			driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
			EnterUserName(prop.getProperty("Username"));
			EnterPassword(prop.getProperty("Password"));
			driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
			ClickLoginButton();
			driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
			String Status = driver.getTitle();
			Assert.assertTrue(Status.contains("MySSL® » Dashboard"));

		}
		
		public void AdminLogin() throws Exception {
			
		  	Properties prop = new Properties();
			FileInputStream fis = new FileInputStream(Constants.File_Path + Constants.DataFile_Name);
					 
			prop.load(fis);

			driver.get(prop.getProperty("Url")); 
			driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
			driver.manage().window().maximize();
			//String title = driver.getTitle();				 
			//Assert.assertTrue(title.contains("SSL Certificates: Buy Symantec, Thawte, Apache SSL Cert, GlobalSign, GeoTrust, RapidSSL- SSL247.co.uk")); 
			//Thread.sleep(5000);
			
			ClickLoginLink();
			driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
			EnterUserName(prop.getProperty("AdUserName"));
			EnterPassword(prop.getProperty("AdPassword"));
			driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
			ClickLoginButton();
			
			
		}
		
		//French Login-----------------------------------------------------------------------------------------------------------------------------------	
		public void FrLoadLoginPage () throws Exception {
			
		  	Properties prop = new Properties();
			FileInputStream fis = new FileInputStream(Constants.File_Path + Constants.DataFile_Name);
					 
			prop.load(fis);

			driver.get(prop.getProperty("FrenchUrl")); 
			driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
			driver.manage().window().maximize();
			String title = driver.getTitle();				 
			Assert.assertTrue(title.contains("SSL Certificates: Buy Symantec, Thawte, Apache SSL Cert, GlobalSign, GeoTrust, RapidSSL- SSL247.co.uk")); 
			Thread.sleep(5000);
			
		}
		
		public void FrClientLogin () throws Exception {
			
		  	Properties prop = new Properties();
			FileInputStream fis = new FileInputStream(Constants.File_Path + Constants.DataFile_Name);
					 
			prop.load(fis);

			driver.get(prop.getProperty("FrenchUrl")); 
			driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
			driver.manage().window().maximize();
			String title = driver.getTitle();				 
			Assert.assertTrue(title.contains("SSL Certificates: Buy Symantec, Thawte, Apache SSL Cert, GlobalSign, GeoTrust, RapidSSL- SSL247.co.uk")); 
			Thread.sleep(5000);
			
			ClickLoginLink();
			driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
			EnterUserName(prop.getProperty("Username"));
			EnterPassword(prop.getProperty("Password"));
			driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
			ClickLoginButton();
			driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
			String Status = driver.getTitle();
			Assert.assertTrue(Status.contains("MySSL® » Dashboard"));

		}
		
		public void FrAdminLogin() throws Exception {
			
		  	Properties prop = new Properties();
			FileInputStream fis = new FileInputStream(Constants.File_Path + Constants.DataFile_Name);
					 
			prop.load(fis);

			driver.get(prop.getProperty("FrenchUrl")); 
			driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
			driver.manage().window().maximize();
			//String title = driver.getTitle();				 
			//Assert.assertTrue(title.contains("SSL Certificates: Buy Symantec, Thawte, Apache SSL Cert, GlobalSign, GeoTrust, RapidSSL- SSL247.co.uk")); 
			//Thread.sleep(5000);
			
			ClickLoginLink();
			driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
			EnterUserName(prop.getProperty("AdUserName"));
			EnterPassword(prop.getProperty("AdPassword"));
			driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
			ClickLoginButton();
			
			
		}
}
