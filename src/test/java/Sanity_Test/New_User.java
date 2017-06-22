package Sanity_Test;

import org.testng.annotations.Test;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import BaseUtilities.AlertBox;
import BaseUtilities.BrowserStack;
import BaseUtilities.Cookies;
import BaseUtilities.CsR;
import BaseUtilities.DriverLoad;
import BaseUtilities.ExtentFactory;
import PageFactory.BillingPage;
import PageFactory.LoginPage;
import PageFactory.NavigationLinks;
import PageFactory.sslDashBoard;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;

public class New_User extends BrowserStack  {
	//public WebDriver driver;
	ExtentReports report;
	ExtentTest test;
	LoginPage 	LoginPageElements;
	BillingPage BillingPageElements;
	sslDashBoard sslDashBoardElements;
	CsR CsrElements;
	Cookies CookiesElements;
	NavigationLinks NavigationElements;
	AlertBox AlertBoxElements;
	
	@BeforeMethod (groups = {"Sanity","Smoke","BS_Sanity","BS_Smoke"})
	public void Load_Homepage () throws Exception {
		
		report = ExtentFactory.getInstance(); 
		LoginPageElements = new LoginPage(driver);
		BillingPageElements = new BillingPage(driver);
		sslDashBoardElements = new sslDashBoard(driver);
		CsrElements = new CsR(driver);
		CookiesElements = new Cookies(driver);
		NavigationElements = new NavigationLinks(driver);
		AlertBoxElements = new AlertBox(driver);
		
		LoginPageElements.LoadLoginPage();
		
		report = ExtentFactory.getInstance();
		
		Thread.sleep(5000);		
	}
	
	@AfterMethod (groups = {"Sanity","Smoke","BS_Sanity","BS_Smoke"},alwaysRun = true)
	public String Aftermethod (ITestResult result) throws IOException, Exception {
		
		String filename = result.getMethod().getMethodName() +".png";
	    String Directory = "C:\\Screenshots\\Sanity ScreenShots\\";
		  
	    File sourceFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(sourceFile, new File(Directory + filename));
		  
		String destination = Directory + filename;
		
		String path = destination;
		String imagePath = test.addScreenCapture(path);
		test.log(LogStatus.INFO, "Test Complete", imagePath);
		
		driver.navigate().refresh();
		Thread.sleep(1000);
		System.out.println("Page Refreshed");
		
	
	test.log(LogStatus.INFO, "Browser Refreshed");
	report.endTest(test);
	report.flush();
	
	return destination;
		
	}                                                                                     
	                                                                                      
	@Test (priority = 0, groups = {"Smoke","BS_Smoke"}, alwaysRun = true)
	  public void User_Registration() throws Exception {
	
/*		
		LoginPageElements = new LoginPage(driver);
		sslDashBoardElements = new sslDashBoard(driver);
*/
		report = ExtentFactory.getInstance3();
		Properties prop = new Properties();
		FileInputStream fis = new FileInputStream("C://Users//Gideon Okunleye//workspace//AutomationTestScripts//DataDriving.properties");
				 
		prop.load(fis);

		test = report.startTest("New User Test --> User Registration");
	    test.log(LogStatus.INFO, "Browser Opened and Url Entered");
	
		//Click on User Registration Link
		LoginPageElements.ClickRegisterLink();
		Thread.sleep(10000);
		
		//Your Details Section
		driver.findElement(By.name("data[User][firstname]")).sendKeys(prop.getProperty("Firstname"));
		driver.findElement(By.name("data[User][lastname]")).sendKeys(prop.getProperty("Lastname"));
		driver.findElement(By.name("data[User][email]")).sendKeys(prop.getProperty("EmailAdd"));
		driver.findElement(By.name("data[User][pre_password]")).sendKeys(prop.getProperty("Password"));
		driver.findElement(By.name("data[User][confirm_password]")).sendKeys(prop.getProperty("Password"));
		
		//Address Section
		JavascriptExecutor jse = (JavascriptExecutor)driver;
		jse.executeScript("window.scrollBy(0,500)", "");
		driver.findElement(By.name("data[User][address_1]")).sendKeys(prop.getProperty("Address"));
		driver.findElement(By.name("data[User][city]")).sendKeys(prop.getProperty("City"));
		
		Thread.sleep(5000);
		jse.executeScript("window.scrollBy(500,1000)", "");
		driver.findElement(By.id("notUsaStateInput")).sendKeys(prop.getProperty("State"));
		driver.findElement(By.name("data[User][postcode]")).sendKeys(prop.getProperty("PostCode"));
		driver.findElement(By.name("data[User][phone]")).sendKeys(prop.getProperty("Phone"));
		
		Thread.sleep(5000);
		CookiesElements.CheckCookies();
		driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
		//WebElement Submit = driver.findElement(By.xpath(".//*[@id='UserMysslRegisterForm']/div[8]/div[2]/inputzzz"));
		//driver.findElement(By.xpath(".//*[@id='UserMysslRegisterForm']/div[8]/div[2]/input")).click();
		//driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
		try {
			
			if (driver.findElement(By.xpath(".//*[@id='UserMysslRegisterForm']/div[8]/div[2]/input")).isDisplayed()) {
			
				driver.findElement(By.xpath(".//*[@id='UserMysslRegisterForm']/div[8]/div[2]/input")).click();
				driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
		  		System.out.println(" Submit Button Clicked");
			}
		
		}catch(Exception e) {
			
			System.out.println("Submit Button Not Visible");
			test.log(LogStatus.FAIL, "Submit Button Not Visible");
	  	
		}
		
		/*Verify Registration*/
		
		//WebDriverWait wait = new WebDriverWait(driver, 20);	
		String LoginMsg = "Thank you for registering, you are now logged into your MySSL account";
		String LogOutMsg = "You are now logged out of your MySSL® account";
	    ///Thread.sleep(100);
	    
	    try {
	    	  
	    	if (AlertBoxElements.AlertIsVisible()) {
	    		
	    		test.log(LogStatus.PASS, "Submit Message Displayed");
	    	}
	    		
	    		}catch (Exception e) {
	    			
	    			test.log(LogStatus.FAIL, "Cant Find Submit Message");
	    			Assert.assertTrue(AlertBoxElements.VerifyAlert(LoginMsg));
	    		}
	    
	 
	    try {
		  
	    	
	    	if (AlertBoxElements.VerifyAlert(LoginMsg)) {
				
				test.log(LogStatus.PASS, "Form Submitted");
				Assert.assertTrue(AlertBoxElements.VerifyAlert(LoginMsg));
	    	}
			
				}catch (Exception e) {
				
					test.log(LogStatus.FAIL, "Form Not Submitted");
					Assert.assertTrue(AlertBoxElements.VerifyAlert(LoginMsg));
				}
	
				
	
	driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
	
	
		/*Verify Logout*/
		if (LoginPageElements.LogoutButtonIsVisible()) {
		
			LoginPageElements.ClickLogoutButton();
			driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
			AlertBoxElements.AlertPrint();
			
			
			if (AlertBoxElements.VerifyAlert(LogOutMsg)){
				
				test.log(LogStatus.PASS, "Log Out Message Does Not Match");
				Assert.assertTrue(AlertBoxElements.VerifyAlert(LogOutMsg));
				
			}else {
				
				test.log(LogStatus.FAIL, "Client Log Out Not Sucessfull");
				Assert.assertTrue(AlertBoxElements.VerifyAlert(LogOutMsg));
			}
	
		}else {
			System.out.println("LogOut Button Not Visible");
			test.log(LogStatus.FAIL, "Client Log Out Not Sucessfull");
			Assert.assertTrue(AlertBoxElements.VerifyAlert(LogOutMsg));
	
		}

	}
	
  
 
 
  @Test (priority = 2, groups = {"Sanity","BS_Sanity"})
  public void Get_in_Touch () throws Exception {
	  
	  	test = report.startTest("New User Test --> Get in Touch Form");
	    test.log(LogStatus.INFO, "Browser Opened and Url Entered");
	//Navigate to support Link
		//driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
		driver.findElement(By.xpath(".//*[@id='mainNavigation']/li[13]/a")).click();
		driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
				
		//Navigate to get in touch form
		driver.findElement(By.xpath(".//*[@id='contactRightFields']/div[6]/div/textarea")).click();
		driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
				
		//Fill in form fields
		Thread.sleep(1000);
		
		WebElement GetInTouchForm = driver.findElement(By.xpath(".//*[@id='title']"));
		
		if (GetInTouchForm.isDisplayed()) {
			
			test.log(LogStatus.PASS, "Form Opened");
			
		}else {
			
			test.log(LogStatus.FAIL, "Form Not Opened");
		}
		
		WebElement Title = driver.findElement(By.xpath(".//*[@id='title']"));
		Select Tl = new Select(Title);
		Tl.selectByVisibleText("Mr");
		driver.findElement(By.xpath(".//*[@id='contactRightFields']/div[2]/div/input")).sendKeys("QA");
		driver.findElement(By.xpath(".//*[@id='contactRightFields']/div[3]/div/input")).sendKeys("Tester");
		driver.findElement(By.xpath(".//*[@id='contactRightFields']/div[4]/div/input")).sendKeys("qa@ssl247.co.uk");
		driver.findElement(By.xpath(".//*[@id='contactRightFields']/div[6]/div/textarea")).sendKeys("Testing!!!");
	    Thread.sleep(5000);
		driver.findElement(By.xpath(".//*[@id='contactformright']/div[3]/button[1]")).click();
		
		
		String StatusMsg = "Your query is being processed - we will be in touch with a response shortly";
/*		
		try {
	    	  
	    	if (AlertBoxElements.AlertIsVisible()) {
	    		
	    			
	    			test.log(LogStatus.PASS, "Submit Message Displayed");
	    	}
	    		
	    		}catch (Exception e) {
	    			
	    			test.log(LogStatus.FAIL, "Cant Find Submit Message");
	    			Assert.assertTrue(AlertBoxElements.VerifyAlert(StatusMsg));
	    		}

	 
	    try {
		  
	    	
	    	if (AlertBoxElements.VerifyAlert(StatusMsg)) {
				
				test.log(LogStatus.PASS, "Form Submitted");
				Assert.assertTrue(AlertBoxElements.VerifyAlert(StatusMsg));
	    	}
			
				}catch (Exception e) {
				
					test.log(LogStatus.FAIL, "Form Not Submitted");
					Assert.assertTrue(AlertBoxElements.VerifyAlert(StatusMsg));
				}
*/	
		
		try {
			  
	    	
	    	AlertBoxElements.AlertWait();
	    	
	    	if (AlertBoxElements.VerifyAlert(StatusMsg)) {
				
				test.log(LogStatus.PASS, "Form Submitted");
				Assert.assertTrue(AlertBoxElements.VerifyAlert(StatusMsg));
	    	}else{
	    		
	    		AlertBoxElements.AlertPrint();	
	    	  	test.log(LogStatus.FAIL, "Validation Failed");
	    	  	Assert.fail("Validation Failed ");
	    	  			    	
	    	  }
			
		}catch (Exception e) {
				
				test.log(LogStatus.FAIL, "Form Not Submitted");
				Assert.fail("Exception " + e);
				
			}

		
		
		
		
	  }
	  
  @Test (priority = 3, groups = {"Sanity","BS_Sanity"})
  public void Ask_a_question () throws Exception {
	  
	 test = report.startTest("New User Test --> Ask a Question Form");
	 test.log(LogStatus.INFO, "Browser Opened and Url Entered");
	//Navigate to MySSL Link
	driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
	driver.findElement(By.xpath(".//*[@id='mainNavigation']/li[9]/a")).click();
			
	//Navigate to get in touch form
	//CookiesElement.CheckCookies();
	WebDriverWait wait = new WebDriverWait(driver, 40);	
	WebElement FormLink;
	FormLink = wait.until(ExpectedConditions.visibilityOfElementLocated (By.xpath(".//*[@id='call-us-box']/div/ul/li[1]/a")));
	FormLink.click();

	//Fill in form fields
	Thread.sleep(1000);	
	WebElement QuestionForm;
	QuestionForm = driver.findElement(By.xpath(".//*[@id='contactform']/div[2]/div[1]/div/select"));
	//TitleField = wait2.until(ExpectedConditions.visibilityOfElementLocated (By.xpath(".//*[@id='contactform']/div[2]/div[1]/div/select")));
	//TitleField.click();
	
    if (QuestionForm.isDisplayed()) {
			
		System.out.println("Form Opened");
		test.log(LogStatus.PASS, " Form Opened");
		Select Tl = new Select(QuestionForm);
		Tl.selectByVisibleText("Mrs");
		driver.findElement(By.name("first_name")).sendKeys("Gideon");
		driver.findElement(By.name("last_name")).sendKeys("Ogunleye");
		driver.findElement(By.name("email")).sendKeys("qa@ssl247.co.uk");
		driver.findElement(By.name("description")).sendKeys("This is is a Message");
		CookiesElements.CheckCookies();
		Thread.sleep(5000);
		driver.findElement(By.xpath(".//*[@class='btn btn-ssl']")).click();
		
	}else {
		
		System.out.println("Form Not Opened");
		test.log(LogStatus.FAIL, " Form Not Opened");
		
	}
   	
    String StatusMsg = "Your query is being processed - we will be in touch with a response shortly";
    //Thread.sleep(100);
    
 try {
	  
    	
    	AlertBoxElements.AlertWait();
    	
    	if (AlertBoxElements.VerifyAlert(StatusMsg)) {
			
			test.log(LogStatus.PASS, "Form Submitted");
			Assert.assertTrue(AlertBoxElements.VerifyAlert(StatusMsg));
    	}else{
    		
    		AlertBoxElements.AlertPrint();	
    	  	test.log(LogStatus.FAIL, "Validation Failed");
    	  	Assert.fail("Validation Failed ");
    	  			    	
    	  }
		
	}catch (Exception e) {
			
			test.log(LogStatus.FAIL, "Form Not Submitted");
			Assert.fail("Exception " + e);
			
		}

    
  }
  
  @Test (priority = 4, groups = {"Sanity","BS_Sanity"})
  public void Request_a_Bronchure () throws Exception {
	   
	test = report.startTest("New User Test --> Request a Bronchure Form");
	test.log(LogStatus.INFO, "Browser Opened and Url Entered");
	  
	//Navigate to Support Link
	//driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
	driver.findElement(By.cssSelector("a[href*='support']")).click();
			
	//Navigate to Request a Brochure Link
	driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
	driver.findElement(By.xpath(".//*[@class='ssl-brochure']")).click();
			
	//Fill in the form
	Thread.sleep(1000);
	WebDriverWait wait = new WebDriverWait(driver, 20);	
	String Msg = "Request a Brochure";
	WebElement BronchureForm = wait.until(ExpectedConditions.visibilityOfElementLocated (By.xpath(".//*[@id='requestBrochureForm']/div[1]/h3")));
	System.out.println("Status Message is:" + BronchureForm.getText());
	
	if (BronchureForm.getText().contains(Msg)) {
		
		test.log(LogStatus.PASS, "Form Opened");
		
	}else {
		
		test.log(LogStatus.FAIL, "Form Not Opened");
	}
	
	WebElement Title = driver.findElement(By.xpath(".//*[@id='request_brochure_title']"));
	Select Tl = new Select(Title);
	Tl.selectByVisibleText("Mrs");
	driver.findElement(By.name("request_brochure_firstname")).sendKeys("Gideon");
	driver.findElement(By.name("request_brochure_lastname")).sendKeys("Ogunleye");
	driver.findElement(By.name("request_brochure_email")).sendKeys("qa@ssl247.co.uk");
	driver.findElement(By.name("request_brochure_address_1")).sendKeys("63 Lisson St, Marylebone");
	driver.findElement(By.name("request_brochure_city")).sendKeys("London");
	driver.findElement(By.name("request_brochure_postcode")).sendKeys("NW1 5DD");
	Thread.sleep(5000);
	driver.findElement(By.xpath(".//*[@id='requestBrochureForm']/div[3]/button[2]")).click();
	String StatusMsg = "Thank you, your brochure has been requested";
	
    try {
	  
    	
    	AlertBoxElements.AlertWait();
    	
    	if (AlertBoxElements.VerifyAlert(StatusMsg)) {
			
			test.log(LogStatus.PASS, "Form Submitted");
			Assert.assertTrue(AlertBoxElements.VerifyAlert(StatusMsg));
    	}else{
    		
    		AlertBoxElements.AlertPrint();	
    	  	test.log(LogStatus.FAIL, "Validation Failed");
    	  	Assert.fail("Validation Failed ");
    	  			    	
    	  }
		
	}catch (Exception e) {
			
			test.log(LogStatus.FAIL, "Form Not Submitted");
			Assert.fail("Exception " + e);
			
		}

    
	  
  }
  
  @Test (priority = 5, groups = {"Sanity", "BS_Sanity"})
  public void Request_a_PenTest_Proposal() throws Exception{
	  
	test = report.startTest("New User Test --> Request a PenTest Form");
	test.log(LogStatus.INFO, "Browser Opened and Url Entered");
	NavigationElements.ClickProtectAndSecureLink();
			
	//Navigate to Request a Brochure Link
	driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
	JavascriptExecutor jse = (JavascriptExecutor)driver;
	jse.executeScript("window.scrollBy(0,500)", "");
	driver.findElement(By.xpath(".//*[@id='mainContainer']/div[4]/div[5]/div[1]/a")).click();
	
			
	//Fill in the form
	Thread.sleep(1000);
	CookiesElements.CheckCookies();
	//CookiesElements.CheckCookies2();
	String Msg = "Request a Free proposal";
	WebElement ProposalForm = driver.findElement(By.xpath(".//*[@id='penTestForm']/div[1]/h3"));
	
	if (ProposalForm.getText().contains(Msg)) {
		
		test.log(LogStatus.PASS, "Form Opened");
		
	}else {
		
		test.log(LogStatus.FAIL, "Form Not Opened");
	}
	
	
	WebElement Title = driver.findElement(By.xpath(".//*[@id='penTestForm']/div[2]/div[1]/div/select"));
	Select Tl = new Select(Title);
	Tl.selectByVisibleText("Mrs");
	driver.findElement(By.xpath(".//*[@id='penTestForm']/div[2]/div[2]/div/input")).sendKeys("Gideon");
	driver.findElement(By.xpath(".//*[@id='penTestForm']/div[2]/div[3]/div/input")).sendKeys("Ogunleye");
	driver.findElement(By.xpath(".//*[@id='penTestForm']/div[2]/div[5]/div/input")).sendKeys("qa@ssl247.co.uk");
	driver.findElement(By.xpath(".//*[@id='penTestForm']/div[2]/div[6]/div/input")).sendKeys("0123456789");
	WebElement RequiredBx = driver.findElement(By.xpath(".//*[@id='penTestForm']/div[2]/div[7]/div/label[3]/input"));
	RequiredBx.click();
	driver.findElement(By.xpath(".//*[@id='penTestForm']/div[2]/div[8]/div/textarea")).sendKeys("This message is for testing purposes and only. thanks");
	Thread.sleep(5000);
	driver.findElement(By.xpath(".//*[@id='penTestForm']/div[3]/button[1]")).click();
	
	String StatusMsg = "Your query is being processed";
    //Thread.sleep(100);
 
    try {
	  
    	AlertBoxElements.AlertWait();
    	
    	if (AlertBoxElements.VerifyAlert(StatusMsg)) {
			
			test.log(LogStatus.PASS, "Form Submitted");
			Assert.assertTrue(AlertBoxElements.VerifyAlert(StatusMsg));
			
    	}else{
    		
    		AlertBoxElements.AlertPrint();	
    	  	test.log(LogStatus.FAIL, "Validation Failed");
    	  	Assert.fail("Validation Failed ");
    	  	
    	  }
		
	}catch (Exception e) {
			
			test.log(LogStatus.FAIL, "Form Not Submitted");
			Assert.assertTrue(AlertBoxElements.VerifyAlert(StatusMsg));
		}


	
  }
/*  
  @BeforeTest (groups = {"Sanity"})
  public void BeforeTest() throws IOException, Exception {
	
	 /*----Firefox Driver------
	 //System.setProperty("webdriver.gecko.driver","C:\\geckodriver.exe");
	// driver = new FirefoxDriver(); 
	 
	 System.setProperty("webdriver.chrome.driver", "C:\\chromedriver.exe");
	 driver = new ChromeDriver();  
	 
	
	 System.out.println("New User Module Test is Running.....");
*/	 
	 
/*	 
	 Properties prop = new Properties();
		FileInputStream fis = new FileInputStream("C://Users//Gideon Okunleye//workspace//SSL247_Test//DataDriving.properties");
				 
		prop.load(fis);

		driver.get(prop.getProperty("Url")); 
		driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		String title = driver.getTitle();				 
		Assert.assertTrue(title.contains("SSL Certificates: Buy Symantec, Thawte, Apache SSL Cert, GlobalSign, GeoTrust, RapidSSL- SSL247.co.uk")); 
		Thread.sleep(5000);
		//driver.findElement(By.id("cookiesStatus")).click();
		driver.findElement(By.xpath(".//*[@id='ackCookies']")).click();
		Thread.sleep(5000);
	
	 
  }
*/
 
/*  
  @AfterTest (groups = {"Sanity"})
  public void AfterTest() throws Exception {
	  
	 Thread.sleep(10000);
	 //report.endTest(test);
	 
	 driver.quit();
	 System.out.println("New User Module Test is Complete!");
	 
	
  }
*/  
  
}
