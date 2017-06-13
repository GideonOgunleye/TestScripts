package Sanity_Test;

import org.testng.annotations.Test;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import PageFactory.BillingPage;
import PageFactory.BrowserStack;
import PageFactory.Cookies;
import PageFactory.CsR;
import PageFactory.DriverLoad;
import PageFactory.ExtentFactory;
import PageFactory.LoginPage;
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
	Cookies CookiesElement;
	
	@BeforeMethod (groups = {"Sanity","Smoke"})
	public void Load_Homepage () throws Exception {
		
		report = ExtentFactory.getInstance(); 
		LoginPageElements = new LoginPage(driver);
		BillingPageElements = new BillingPage(driver);
		sslDashBoardElements = new sslDashBoard(driver);
		CsrElements = new CsR(driver);
		CookiesElement = new Cookies(driver);
		
		LoginPageElements.LoadLoginPage();
		
		report = ExtentFactory.getInstance();
		
		Thread.sleep(5000);		
	}
*/	
	@AfterMethod (groups = {"Sanity","BS_Sanity"},alwaysRun = true)
	public String Aftermethod (ITestResult result) throws IOException, Exception {
		
		String filename = result.getMethod().getMethodName() +".png";
	    String Directory = "C:\\Screenshots\\Sanity ScreenShots\\";
		  
	    File sourceFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(sourceFile, new File(Directory + filename));
		  
		String destination = Directory + filename;
		
		String path = destination;
		String imagePath = test.addScreenCapture(path);
		test.log(LogStatus.INFO, "Test Complete", imagePath);
		
		Thread.sleep(5000);
		driver.navigate().refresh();
		
	
	test.log(LogStatus.INFO, "Browser Refreshed");
	report.endTest(test);
	report.flush();
	
	return destination;
		
	}                                                                                     
	                                                                                      
	@Test (priority = 0, groups = {"Sanity","BS_Sanity"}, alwaysRun = true)
	  public void User_Registration() throws Exception {
	
/*		
		LoginPageElements = new LoginPage(driver);
		sslDashBoardElements = new sslDashBoard(driver);
*/
		report = ExtentFactory.getInstance3();
		Properties prop = new Properties();
		FileInputStream fis = new FileInputStream("C://Users//Gideon Okunleye//workspace//AutomationTestScripts//DataDriving.properties");
				 
		prop.load(fis);

/*
		driver.get(prop.getProperty("Url")); 
		driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		String title = driver.getTitle();				 
		Assert.assertTrue(title.contains("SSL Certificates: Buy Symantec, Thawte, Apache SSL Cert, GlobalSign, GeoTrust, RapidSSL- SSL247.co.uk")); 
		Thread.sleep(5000);
		//driver.findElement(By.id("cookiesStatus")).click();
		driver.findElement(By.xpath(".//*[@id='ackCookies']")).click();
		Thread.sleep(5000);
*/		
		//report = ExtentFactory.getInstance(); 
		
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
		//driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
		//jse.executeScript("window.scrollBy(500,1000)", "");
		
		Thread.sleep(5000);
		jse.executeScript("window.scrollBy(500,1000)", "");
		driver.findElement(By.id("notUsaStateInput")).sendKeys(prop.getProperty("State"));
		driver.findElement(By.name("data[User][postcode]")).sendKeys(prop.getProperty("PostCode"));
		driver.findElement(By.name("data[User][phone]")).sendKeys(prop.getProperty("Phone"));
		
		Thread.sleep(5000);
		//WebElement Cookies = driver.findElement(By.id("cookiesStatus"));
		
		CookiesElement.CheckCookies();
		driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
		driver.findElement(By.xpath(".//*[@id='UserMysslRegisterForm']/div[8]/div[2]/input")).click();
		driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
	
		//String StatusMsg = "MySSL� � Dashboard";	
		//driver.findElement(By.xpath(".//*[@id='mainContainer']/div[4]/div[2]/h2")).getText();
		//WebElement Status = driver.findElement(By.xpath(".//*[@id='mainContainer']/div[4]/div[2]/h2"));
		
		try {
			
			if (sslDashBoardElements.PageValidation()) {
			
				Assert.assertTrue(sslDashBoardElements.PageHeaderAssert().contains("MySSL� � Dashboard"));
				driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
				test.log(LogStatus.PASS, "User Successfully Registered");
				System.out.println("Dashboard Page Opened");
				
			}
		
		}catch(Exception e) {
			System.out.println("Dashboard Page Not Opened");
			test.log(LogStatus.FAIL, "Dashboard Page Not Opened");
		
			}
		
		Assert.assertTrue(sslDashBoardElements.PageHeaderAssert().contains("MySSL� � Dashboard"));
		driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
		LoginPageElements.ClickLogoutButton();
/*		
try		{	
	
			if (sslDashBoardElements.PageValidation()) {
			
				test.log(LogStatus.PASS, "Dashboard Page Opened");
				
				try {
				
					if (sslDashBoardElements.PageHeaderAssert().contains(StatusMsg)) {
					
					test.log(LogStatus.PASS, "User Sucessfully Registered");
					Assert.assertTrue(sslDashBoardElements.PageHeaderAssert().contains("MySSL� � Dashboard"));
					driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
					LoginPageElements.ClickLogoutButton();
					test.log(LogStatus.INFO, "User Logged Out");
					
				}
					
				}catch (Exception e) {
					
					test.log(LogStatus.FAIL, "User not Sucessfully Registered");
				}
			}
				
		}catch (Exception e){
			
			test.log(LogStatus.FAIL, "Dashboard Page Not Opened");
			
			}
		
*/		
		
	}
	
  @Test (priority = 1, groups = {"Sanity","BS_Sanity"})
  public void Log_Out_New_User (){
	  
	  LoginPageElements = new LoginPage(driver);
	  sslDashBoardElements = new sslDashBoard(driver);
	  
	  //driver.findElement(By.xpath(".//*[@id='top-panel']/div[1]/span[1]/a[2]")).click();
	   * 
	   */
	 
	 // report = ExtentFactory.getInstance(); 
	  report = ExtentFactory.getInstance3();
	  LoginPageElements.ClientLogin();
		
	  test = report.startTest("New User Test --> User Login");
	  test.log(LogStatus.INFO, "Browser Opened and Url Entered");
	  
	  Thread.sleep(5000);
	  
	  String StatusMsg = "MySSL� � Dashboard";	
	  if (sslDashBoardElements.PageHeaderAssert().contains(StatusMsg)) {
			
			test.log(LogStatus.PASS, "User Sucessfully Signed");
			
		}else {
			
			test.log(LogStatus.FAIL, "User not Sucessfully Signed");
		}
	  
	  LoginPageElements.ClickLogoutButton();
	  test.log(LogStatus.INFO, "User Logged Out");
  }

 
 		//Create Connection to DB		
  	Connection con = DriverManager.getConnection(dbUrl,username,password);
  	Statement stmt = con.createStatement();	
  	stmt.execute(query2);
  	System.out.println("Account Has Been Deleted");
  	
/*
		//Create Statement Object		
	   Statement stmt = con.createStatement();	
	   	   
			// Execute the SQL Query. Store results in ResultSet		
		ResultSet rs= stmt.executeQuery(query2);							

		// While Loop to iterate through all data and print results		
		while (rs.next()){
	        	  String AccCode = rs.getString("account_code");								        
                  String name = rs.getString("name");					                               
                  System. out.println(AccCode+"  "+name);		
          }		
		
		 // closing DB Connection		
		con.close();		  
  }
  
  
  
  @Test (priority = 2, groups = {"SQL"})
  public void SQL_DeleteUser () throws SQLException, ClassNotFoundException {
	  
		//Connection URL Syntax: "jdbc:mysql://ipaddress:portnumber/db_name"		
      String dbUrl = "jdbc:mysql://notcraft-prod.covetytyjb4n.eu-west-1.rds.amazonaws.com";					

		//Database Username		
		String username = "gogunleye";	
      
		//Database Password		
		String password = "n8hY5HqCkd7suLSM";				

		//Query to Execute		
		//String query = "select *  from bakewell_staging_go.accounts Where account_code ='QUAL017';";	
		String query2 = "delete from bakewell_staging_go.users Where email ='QATester2@ssl247-test.com';";
      
	    //Load mysql jdbc driver		
 	    Class.forName("com.mysql.jdbc.Driver");			
 
 		//Create Connection to DB		
  	Connection con = DriverManager.getConnection(dbUrl,username,password);
  	Statement stmt = con.createStatement();	
  	stmt.execute(query2);
  	System.out.println("User Has Been Deleted");
  	
/*
		//Create Statement Object		
	   Statement stmt = con.createStatement();	
	   	   
			// Execute the SQL Query. Store results in ResultSet		
		ResultSet rs= stmt.executeQuery(query2);							

		// While Loop to iterate through all data and print results		
		while (rs.next()){
	        	  String AccCode = rs.getString("account_code");								        
                  String name = rs.getString("name");					                               
                  System. out.println(AccCode+"  "+name);		
          }		
		
		 // closing DB Connection		
		con.close();		
	  
  }
	
 */
 
 
  @Test (priority = 2, groups = {"Sanity","BS_Sanity"})
  public void Get_in_Touch () throws Exception {
	  
	  
	   report = ExtentFactory.getInstance3(); 
	    
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
		WebElement Title = driver.findElement(By.xpath(".//*[@id='title']"));
		Select Tl = new Select(Title);
		Tl.selectByVisibleText("Mr");
		driver.findElement(By.xpath(".//*[@id='contactRightFields']/div[2]/div/input")).sendKeys("QA");
		driver.findElement(By.xpath(".//*[@id='contactRightFields']/div[3]/div/input")).sendKeys("Tester");
		driver.findElement(By.xpath(".//*[@id='contactRightFields']/div[4]/div/input")).sendKeys("qa@ssl247.co.uk");
		driver.findElement(By.xpath(".//*[@id='contactRightFields']/div[6]/div/textarea")).sendKeys("Testing!!!");
	    Thread.sleep(5000);
		driver.findElement(By.xpath(".//*[@id='contactformright']/div[3]/button[1]")).click();
		test.log(LogStatus.PASS, "Form Sent Sucessfully");
		driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
	  }
	  
  @Test (priority = 3, groups = {"Sanity","BS_Sanity"})
  public void Ask_a_question () throws Exception {
	  
	 report = ExtentFactory.getInstance3();
	  
	 test = report.startTest("New User Test --> Ask a Question Form");
	 test.log(LogStatus.INFO, "Browser Opened and Url Entered");
	//Navigate to MySSL Link
	driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
	driver.findElement(By.xpath(".//*[@id='mainNavigation']/li[9]/a")).click();
			
	//Navigate to get in touch form
	WebDriverWait wait = new WebDriverWait(driver, 40);	
	WebElement FormLink;
	FormLink = wait.until(ExpectedConditions.visibilityOfElementLocated (By.xpath(".//*[@id='call-us-box']/div/ul/li[1]/a")));
	FormLink.click();

	//Fill in form fields
	Thread.sleep(1000);	
	WebElement TitleField;
	
	TitleField = driver.findElement(By.xpath(".//*[@id='contactform']/div[2]/div[1]/div/select"));
	//TitleField = wait2.until(ExpectedConditions.visibilityOfElementLocated (By.xpath(".//*[@id='contactform']/div[2]/div[1]/div/select")));
	//TitleField.click();
	
    if (TitleField.isDisplayed()) {
		
		System.out.println("Driver Found Title Element");
		test.log(LogStatus.PASS, " Title Element Found");
		Select Tl = new Select(TitleField);
		Tl.selectByVisibleText("Mrs");
		driver.findElement(By.name("first_name")).sendKeys("Qatester");
		driver.findElement(By.name("last_name")).sendKeys("Qatester");
		driver.findElement(By.name("email")).sendKeys("Qatester");
		driver.findElement(By.name("description")).sendKeys("Qatester");
		driver.findElement(By.xpath(".//*[@class='btn btn-ssl']")).click();
		test.log(LogStatus.PASS, "Form Sent Successfully");
		
		
	}else {
		
		System.out.println("Title Element Not Found");
		test.log(LogStatus.FAIL, " Title Element Not Found");
		
	}
	
	//Thread.sleep(1000);
	//WebElement Title = driver.findElement(By.xpath(".//*[@id='title']"));
/*	Select Tl = new Select(TitleField);
	Tl.selectByVisibleText("Mrs");
	driver.findElement(By.name("first_name")).sendKeys("Qatester");
	driver.findElement(By.name("last_name")).sendKeys("Qatester");
	driver.findElement(By.name("email")).sendKeys("Qatester");
	driver.findElement(By.name("description")).sendKeys("Qatester");
	driver.findElement(By.xpath(".//*[@class='btn btn-ssl']")).click();
	test.log(LogStatus.PASS, "Form Sent Successfully");
	//driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
*/
    
    
  }
  
  @Test (priority = 4, groups = {"Sanity","BS_Sanity"})
  public void Request_a_Bronchure () throws Exception {
	   
	report = ExtentFactory.getInstance3();
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
	WebElement Title = driver.findElement(By.xpath(".//*[@id='request_brochure_title']"));
	Select Tl = new Select(Title);
	Tl.selectByVisibleText("Mrs");
	driver.findElement(By.name("request_brochure_firstname")).sendKeys("Qatester");
	driver.findElement(By.name("request_brochure_lastname")).sendKeys("Qatester");
	driver.findElement(By.name("request_brochure_email")).sendKeys("Qatester");
	driver.findElement(By.name("request_brochure_address_1")).sendKeys("Qatester");
	driver.findElement(By.name("request_brochure_city")).sendKeys("Qatester");
	driver.findElement(By.name("request_brochure_postcode")).sendKeys("Qatester");
	Thread.sleep(1000);
	driver.findElement(By.xpath(".//*[@id='requestBrochureForm']/div[3]/button[2]")).click();
	driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
	driver.findElement(By.xpath(".//*[@id='requestBrochureForm']/div[3]/button[1]")).click();
	test.log(LogStatus.PASS, "Form Sent Successfully");
	//driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
	  
  }
  
  @Test (priority = 5, groups = {"Sanity","BS_Sanity"})
  public void Request_a_PenTest_Proposal() throws Exception{
	  
	report = ExtentFactory.getInstance3();
	test = report.startTest("New User Test --> Request a PenTest Form");
	test.log(LogStatus.INFO, "Browser Opened and Url Entered");
	//Navigate to Support Link
	//driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
	driver.findElement(By.cssSelector("a[href*='penetrationtesting']")).click();
			
	//Navigate to Request a Brochure Link
	driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
	driver.findElement(By.xpath(".//*[@id='mainContainer']/div[4]/div[5]/div[1]/a")).click();
			
	//Fill in the form
	Thread.sleep(1000);
	WebElement Title = driver.findElement(By.xpath(".//*[@id='penTestForm']/div[2]/div[1]/div/select"));
	Select Tl = new Select(Title);
	Tl.selectByVisibleText("Mrs");
	driver.findElement(By.xpath(".//*[@id='penTestForm']/div[2]/div[2]/div/input")).sendKeys("Firstname");
	driver.findElement(By.xpath(".//*[@id='penTestForm']/div[2]/div[3]/div/input")).sendKeys("Lastname");
	driver.findElement(By.xpath(".//*[@id='penTestForm']/div[2]/div[5]/div/input")).sendKeys("Email");
	driver.findElement(By.xpath(".//*[@id='penTestForm']/div[2]/div[6]/div/input")).sendKeys("Phone Number");
	WebElement RequiredBx = driver.findElement(By.xpath(".//*[@id='penTestForm']/div[2]/div[7]/div/label[3]/input"));
	RequiredBx.click();
	driver.findElement(By.xpath(".//*[@id='penTestForm']/div[2]/div[8]/div/textarea")).sendKeys("This message is for testing purposes and only. thanks");
	driver.findElement(By.xpath(".//*[@id='penTestForm']/div[3]/button[1]")).click();
	driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
	driver.findElement(By.xpath(".//*[@id='penTestForm']/div[3]/button[2]")).click();
	test.log(LogStatus.PASS, "Form Sent Successfully");
	//driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
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
