package Regression_Test;

import org.testng.annotations.Test;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import PageFactory.BillingPage;
import PageFactory.DriverLoad;
//import net.sf.cglib.core.Local;
import PageFactory.ExtentFactory;
import PageFactory.LoginPage;
import PageFactory.sslDashBoard;

import org.testng.annotations.BeforeTest;
//import org.json.simple.parser.JSONParser;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
//import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
//import org.testng.annotations.BeforeMethod;

public class Order_Products extends DriverLoad {
	//WebDriver driver;
	ExtentReports report;
	ExtentTest test;
	LoginPage 	LoginPageElements;
	BillingPage BillingPageElements;
	sslDashBoard sslDashBoardElements;
	
	@BeforeMethod (groups = {"Regression"})
	public void User_Login () throws Exception {
		 
		LoginPageElements = new LoginPage(driver);
		BillingPageElements = new BillingPage(driver);
		sslDashBoardElements = new sslDashBoard(driver);
		
		Properties prop = new Properties();
		FileInputStream fis = new FileInputStream("C://Users//Gideon Okunleye//workspace//AutomationTestScripts//DataDriving.properties");
				 
		prop.load(fis);
		
		
		driver.get(prop.getProperty("Url")); 
		driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		String title = driver.getTitle();				 
		Assert.assertTrue(title.contains("SSL Certificates: Buy Symantec, Thawte, Apache SSL Cert, GlobalSign, GeoTrust, RapidSSL- SSL247.co.uk"));
		
		LoginPageElements.clickLoginLink();
		LoginPageElements.EnterUserName(prop.getProperty("Username"));
		LoginPageElements.EnterPassword(prop.getProperty("Password"));
		LoginPageElements.ClickLoginButton();
		
	}

	
	@AfterMethod (groups = {"Regression"}, alwaysRun = true)
	public String User_Logout (ITestResult result) throws Exception {
		
	
	    //Take Screen Shots
	    //String filename = result.getMethod().getMethodName() +".png";
		String filename = result.getEndMillis() + ".png";
	    String Directory = "C:\\Users\\Gideon Okunleye\\Documents\\Testing Documents\\ScreenShots\\Regression ScreenShots\\";
		  
	    File sourceFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(sourceFile, new File(Directory + filename));
		  
		String destination = Directory + filename;
		String path = destination;
		String imagePath = test.addScreenCapture(path);
		test.log(LogStatus.INFO, "Test Complete", imagePath);
		
		driver.navigate().refresh();
		Thread.sleep(1000);
		
		LoginPageElements.ClickLogoutButton();
		test.log(LogStatus.INFO, "User Logged Out");
		
		report.endTest(test);
		report.flush();
		
		return destination;
		 
		
	}
	
	
	@Test (priority = 1, groups = {"Regression"},dataProviderClass = Order_Products_Data.class, dataProvider="OrderProduct_Data")
	  public void Order_Certificates(String Product, String ProductLink) throws Exception {
		
		Properties prop = new Properties();
		FileInputStream fis = new FileInputStream("C://Users//Gideon Okunleye//workspace//SSL247_Test//DataDriving.properties");
				 
		prop.load(fis);
		
		report = ExtentFactory.getInstance2();
		
		System.out.println(ProductLink + " Order Has Started.............");
		test = report.startTest(Product);
	    test.log(LogStatus.INFO, "User Logged in");
		
		//Navigate to product page//
	    sslDashBoardElements.ClickMyProductsLink();
		
		//Click to Order RapidSSL Product
		WebElement Link1 = driver.findElement(By.xpath(".//*[@id='SSLCertificate']/table/tbody/tr[1]/td[1]"));
		WebElement Link2 = driver.findElement(By.xpath(".//*[@id='SSLCertificate']/table/tbody/tr[2]/td[1]"));
		WebElement Link3 = driver.findElement(By.xpath(".//*[@id='SSLCertificate']/table/tbody/tr[3]/td[1]"));
		WebElement Link4 = driver.findElement(By.xpath(".//*[@id='SSLCertificate']/table/tbody/tr[4]/td[1]"));
		WebElement Link5 = driver.findElement(By.xpath(".//*[@id='SSLCertificate']/table/tbody/tr[5]/td[1]"));
		WebElement Link6 = driver.findElement(By.xpath(".//*[@id='SSLCertificate']/table/tbody/tr[6]/td[1]"));
		WebElement Link7 = driver.findElement(By.xpath(".//*[@id='SSLCertificate']/table/tbody/tr[7]/td[1]"));
		WebElement Link8 = driver.findElement(By.xpath(".//*[@id='SSLCertificate']/table/tbody/tr[8]/td[1]"));
		WebElement Link9 = driver.findElement(By.xpath(".//*[@id='SSLCertificate']/table/tbody/tr[9]/td[1]"));
		
		JavascriptExecutor jse = (JavascriptExecutor)driver;
		jse.executeScript("window.scrollBy(0,250)", "");
		
		WebElement Link10 = driver.findElement(By.xpath(".//*[@id='SSLCertificate']/table/tbody/tr[10]/td[1]"));
		WebElement Link11 = driver.findElement(By.xpath(".//*[@id='SSLCertificate']/table/tbody/tr[11]/td[1]"));
		WebElement Link12 = driver.findElement(By.xpath(".//*[@id='SSLCertificate']/table/tbody/tr[12]/td[1]"));
		WebElement Link13 = driver.findElement(By.xpath(".//*[@id='SSLCertificate']/table/tbody/tr[13]/td[1]"));
		WebElement Link14 = driver.findElement(By.xpath(".//*[@id='SSLCertificate']/table/tbody/tr[14]/td[1]"));
		WebElement Link15 = driver.findElement(By.xpath(".//*[@id='SSLCertificate']/table/tbody/tr[15]/td[1]"));
		WebElement Link16 = driver.findElement(By.xpath(".//*[@id='SSLCertificate']/table/tbody/tr[16]/td[1]"));
		WebElement Link17 = driver.findElement(By.xpath(".//*[@id='SSLCertificate']/table/tbody/tr[17]/td[1]"));
		WebElement Link18 = driver.findElement(By.xpath(".//*[@id='SSLCertificate']/table/tbody/tr[18]/td[1]"));
		WebElement Link19 = driver.findElement(By.xpath(".//*[@id='SSLCertificate']/table/tbody/tr[19]/td[1]"));
		WebElement Link20 = driver.findElement(By.xpath(".//*[@id='SSLCertificate']/table/tbody/tr[20]/td[1]"));
		WebElement Link21 = driver.findElement(By.xpath(".//*[@id='SSLCertificate']/table/tbody/tr[21]/td[1]"));
		WebElement Link22 = driver.findElement(By.xpath(".//*[@id='SSLCertificate']/table/tbody/tr[22]/td[1]"));
		WebElement Link23 = driver.findElement(By.xpath(".//*[@id='SSLCertificate']/table/tbody/tr[23]/td[1]"));
		WebElement Link24 = driver.findElement(By.xpath(".//*[@id='SSLCertificate']/table/tbody/tr[24]/td[1]"));
		WebElement Link25 = driver.findElement(By.xpath(".//*[@id='SSLCertificate']/table/tbody/tr[25]/td[1]"));
		//WebElement Link26 = driver.findElement(By.xpath(".//*[@id='SSLCertificate']/table/tbody/tr[13]/td[1]"));
		//WebElement Link16 = driver.findElement(By.xpath(".//*[@id='SSLCertificate']/table/tbody/tr[16]/td[1]"));
		
		if (Link1.getText().contains(ProductLink)) {
				
				System.out.println(ProductLink + " Found");
				driver.findElement(By.xpath(".//*[@id='SSLCertificate']/table/tbody/tr[1]/td[2]/a")).click();
				test.log(LogStatus.INFO, "Product Page Opened");
			
			}else if (Link2.getText().contains(ProductLink)) {
				
				System.out.println(ProductLink + " Found");
				driver.findElement(By.xpath(".//*[@id='SSLCertificate']/table/tbody/tr[2]/td[2]/a")).click();
				test.log(LogStatus.INFO, "Product Page Opened");
		
			}else if (Link3.getText().contains(ProductLink)) {
				
				System.out.println(ProductLink + " Found");
				driver.findElement(By.xpath(".//*[@id='SSLCertificate']/table/tbody/tr[3]/td[2]/a")).click();
				test.log(LogStatus.INFO, "Product Page Opened");
				
			}else if (Link4.getText().contains(ProductLink)) {
				
				System.out.println(ProductLink + " Found");
				driver.findElement(By.xpath(".//*[@id='SSLCertificate']/table/tbody/tr[4]/td[2]/a")).click();
				test.log(LogStatus.INFO, "Product Page Opened");
			
			}else if (Link5.getText().contains(ProductLink)) {
				
				System.out.println(ProductLink + " Found");
				driver.findElement(By.xpath(".//*[@id='SSLCertificate']/table/tbody/tr[5]/td[2]/a")).click();
				test.log(LogStatus.INFO, "Product Page Opened");
			
			}else if (Link6.getText().contains(ProductLink)) {
				
				System.out.println(ProductLink + " Found");
				driver.findElement(By.xpath(".//*[@id='SSLCertificate']/table/tbody/tr[6]/td[2]/a")).click();
				test.log(LogStatus.INFO, "Product Page Opened");
				
			
			}else if (Link7.getText().contains(ProductLink)) {
				
				System.out.println(ProductLink + " Found");
				driver.findElement(By.xpath(".//*[@id='SSLCertificate']/table/tbody/tr[7]/td[2]/a")).click();
				test.log(LogStatus.INFO, "Product Page Opened");
		
			}else if (Link8.getText().contains(ProductLink)) {
				
				System.out.println(ProductLink + " Found");
				driver.findElement(By.xpath(".//*[@id='SSLCertificate']/table/tbody/tr[8]/td[2]/a")).click();
				test.log(LogStatus.INFO, "Product Page Opened");
				
			
			}else if (Link9.getText().contains(ProductLink)) {
				
				System.out.println(ProductLink + " Found");
				driver.findElement(By.xpath(".//*[@id='SSLCertificate']/table/tbody/tr[9]/td[2]/a")).click();
				test.log(LogStatus.INFO, "Product Page Opened");
			
			}else if (Link10.getText().contains(ProductLink)) {
				
				System.out.println(ProductLink + " Found");
				driver.findElement(By.xpath(".//*[@id='SSLCertificate']/table/tbody/tr[10]/td[2]/a")).click();
				test.log(LogStatus.INFO, "Product Page Opened");
				
			}else if (Link11.getText().contains(ProductLink)) {
				
				System.out.println(ProductLink + " Found");
				driver.findElement(By.xpath(".//*[@id='SSLCertificate']/table/tbody/tr[11]/td[2]/a")).click();
				test.log(LogStatus.INFO, "Product Page Opened");
			
			}else if (Link12.getText().contains(ProductLink)) {
				
				System.out.println(ProductLink + " Found");
				driver.findElement(By.xpath(".//*[@id='SSLCertificate']/table/tbody/tr[12]/td[2]/a")).click();
				test.log(LogStatus.INFO, "Product Page Opened");
			
			}else if (Link13.getText().contains(ProductLink)) {
				
				System.out.println(ProductLink + " Found");
				driver.findElement(By.xpath(".//*[@id='SSLCertificate']/table/tbody/tr[13]/td[2]/a")).click();
				test.log(LogStatus.INFO, "Product Page Opened");
			
			
			}else if (Link14.getText().contains(ProductLink)) {
				
				System.out.println(ProductLink + " Found");
				driver.findElement(By.xpath(".//*[@id='SSLCertificate']/table/tbody/tr[14]/td[2]/a")).click();
				test.log(LogStatus.INFO, "Product Page Opened");
				
			}else if (Link15.getText().contains(ProductLink)) {
				
				System.out.println(ProductLink + " Found");
				driver.findElement(By.xpath(".//*[@id='SSLCertificate']/table/tbody/tr[15]/td[2]/a")).click();
				test.log(LogStatus.INFO, "Product Page Opened");
			
			}else if (Link16.getText().contains(ProductLink)) {
				
				System.out.println(ProductLink + " Found");
				driver.findElement(By.xpath(".//*[@id='SSLCertificate']/table/tbody/tr[16]/td[2]/a")).click();
				test.log(LogStatus.INFO, "Product Page Opened");
			
			}else if (Link17.getText().contains(ProductLink)) {
				
				System.out.println(ProductLink + " Found");
				driver.findElement(By.xpath(".//*[@id='SSLCertificate']/table/tbody/tr[17]/td[2]/a")).click();
				test.log(LogStatus.INFO, "Product Page Opened");
			
			}else if (Link18.getText().contains(ProductLink)) {
				
				System.out.println(ProductLink + " Found");
				driver.findElement(By.xpath(".//*[@id='SSLCertificate']/table/tbody/tr[18]/td[2]/a")).click();
				test.log(LogStatus.INFO, "Product Page Opened");
			
			}else if (Link19.getText().contains(ProductLink)) {
				
				System.out.println(ProductLink + " Found");
				driver.findElement(By.xpath(".//*[@id='SSLCertificate']/table/tbody/tr[19]/td[2]/a")).click();
				test.log(LogStatus.INFO, "Product Page Opened");
			
			}else if (Link20.getText().contains(ProductLink)) {
				
				System.out.println(ProductLink + " Found");
				driver.findElement(By.xpath(".//*[@id='SSLCertificate']/table/tbody/tr[20]/td[2]/a")).click();
				test.log(LogStatus.INFO, "Product Page Opened");
			
			}else if (Link21.getText().contains(ProductLink)) {
				
				System.out.println(ProductLink + " Found");
				driver.findElement(By.xpath(".//*[@id='SSLCertificate']/table/tbody/tr[21]/td[2]/a")).click();
				test.log(LogStatus.INFO, "Product Page Opened");
			
			}else if (Link22.getText().contains(ProductLink)) {
				
				System.out.println(ProductLink + " Found");
				driver.findElement(By.xpath(".//*[@id='SSLCertificate']/table/tbody/tr[22]/td[2]/a")).click();
				test.log(LogStatus.INFO, "Product Page Opened");
			
			}else if (Link23.getText().contains(ProductLink)) {
				
				System.out.println(ProductLink + " Found");
				driver.findElement(By.xpath(".//*[@id='SSLCertificate']/table/tbody/tr[23]/td[2]/a")).click();
				test.log(LogStatus.INFO, "Product Page Opened");
			
			}else if (Link24.getText().contains(ProductLink)) {
				
				System.out.println(ProductLink + " Found");
				driver.findElement(By.xpath(".//*[@id='SSLCertificate']/table/tbody/tr[24]/td[2]/a")).click();
				test.log(LogStatus.INFO, "Product Page Opened");
			
			}else if (Link25.getText().contains(ProductLink)) {
				
				System.out.println(ProductLink + " Found");
				driver.findElement(By.xpath(".//*[@id='SSLCertificate']/table/tbody/tr[25]/td[2]/a")).click();
				test.log(LogStatus.INFO, "Product Page Opened");
		}else {
			
			System.out.println("Product Not Found");
			test.log(LogStatus.FAIL, "Product Not Found");
			
		}

	/*	
		Thread.sleep(15000);
		WebElement Link = driver.findElement(By.xpath(".//*[@id='SSLCertificate']/table/tbody/tr[16]/td[3]/a"));
		Link.click();
		test.log(LogStatus.INFO, "Product Page Opened");
	*/	
		//Check Domain Name
		driver.findElement(By.name("data[Basket][common_name]")).clear();
		driver.findElement(By.name("data[Basket][common_name]")).sendKeys("ssl247.net");
		driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
		driver.findElement(By.id("check-cn-btn")).click();
		Thread.sleep(10000);
		
		try {
			
			if (driver.findElement(By.xpath(".//*[@id='BasketAddCertificateForm']/div[12]/input[1]")).isDisplayed()) {
			
				driver.findElement(By.xpath(".//*[@id='BasketAddCertificateForm']/div[12]/input[1]")).click();
				driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
			  	System.out.println("SAN Option Present");
		  		
			}
		
		}catch(Exception e) {
			System.out.println("SAN Option Not Present");
		
			}
		
		//driver.findElement(By.xpath(".//*[@id='BasketAddCertificateForm']/div[12]/input[1]")).click();
		//driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);

/*		
		//Choose 3year Duration Option
		driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
		driver.findElement(By.id("BasketYears3")).click();
*/
		
		//Select Apache 2 Server and Add to basket
		try {
			
			if (driver.findElement(By.xpath(".//*[@id='BasketServerType']")).isDisplayed()) {
			
				WebElement Servertype = driver.findElement(By.xpath(".//*[@id='BasketServerType']"));
				Select Type = new Select(Servertype);
				Type.selectByVisibleText("Apache 2");
				
			}
		
		}catch(Exception e) {
			System.out.println("Years and Apache Selection Options Not Available");
			
			}
		
		driver.findElement(By.id("addCertificateToBasket")).click();
		Thread.sleep(10000);
		test.log(LogStatus.INFO, "Rapid SSL Pro Added To Basket");
				
		//Confirm Order Details
		driver.findElement(By.id("checkoutLink")).click();
				
		//Fill In Billing Retails
		BillingPageElements.FillFirstname("Quality");
		BillingPageElements.FillLastname("Assurance Tester");
		BillingPageElements.FillPhoneNumber("0203MMM7610541");
		BillingPageElements.FillEmail("qa@ssl247.co.uk");
		BillingPageElements.FillAddress1("63 Lisson St, Marylebone");
		BillingPageElements.FillCity("London");
		BillingPageElements.SelectCountry("United Kingdom");
		driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
		BillingPageElements.FillPostcode("NW1 5DD");
		
	  	//Assert.assertTrue(SendStatus.contains("The certificate has been saved and is pending submission with the CA"));
	  			
		//Confirm input
		BillingPageElements.ClickConfirmButton();
		WebDriverWait wait = new WebDriverWait(driver, 100);
		
		driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
	  	//WebElement OrderStatus = driver.findElement(By.xpath("html/body/div[4]/p[1]"));
	  	//WebElement OrderStatus = wait.until(ExpectedConditions.visibilityOfElementLocated (By.xpath("html/body/div[4]/p[1]")));
	  	//String CheckStatus = "Thank You. Your order has been placed.";
	  	
	  	try {
			
			if (driver.findElement(By.xpath("html/body/div[4]/p[1]")).isDisplayed()) {
			
				String OrderStatus = driver.findElement(By.xpath("html/body/div[4]/p[1]")).getText();
			  	Assert.assertTrue(OrderStatus.contains("Thank You. Your order has been placed."));
			  	test.log(LogStatus.PASS, " Order Placed");
		  		System.out.println(ProductLink + " Order Placed");
			}
		
		}catch(Exception e) {
			
			System.out.println(ProductLink + " Order NOT Placed or Status Alert not Displayed");
	  	
		}
	  	
/*	  	
	  	
	  	if (OrderStatus.getText().contains(CheckStatus)) {
	  		
	  		test.log(LogStatus.PASS, " Order Placed");
	  		System.out.println(ProductLink + " Order Placed");
	  		
	  	}else {
	  		
	  		test.log(LogStatus.FAIL, "Order NOT Placed");
	  		System.out.println(ProductLink + " Order NOT Placed");
	  		System.out.println("Test area Shows:" + OrderStatus.getText());
	  		
	  	}
	  	
*/	  	
	  	
	  
		/*----Complete Order----*/
	
		
/*		WebElement Button;
		Button = wait.until(ExpectedConditions.visibilityOfElementLocated (By.xpath(".//*[@class='btn btn-success btn-small']")));
		Button.click();
*/
	  	
		try {
			
			if (driver.findElement(By.xpath(".//*[@class='btn btn-success btn-small']")).isDisplayed()) {
			
				System.out.println("Account Has Enough Funds");
				test.log(LogStatus.PASS, " Account Has Enough Funds");
				driver.findElement(By.xpath(".//*[@class='btn btn-success btn-small']")).click();
				
			}
		
		}catch(Exception e) {
			System.out.println("Account Does Not Have Enough Funds");
			test.log(LogStatus.FAIL, "Account Does Not Have Enough Funds");
		
			}
		
		WebDriverWait wait2 = new WebDriverWait(driver, 50);	
		WebElement Csr;
		Csr = wait2.until(ExpectedConditions.visibilityOfElementLocated (By.id("CertificateDetailCsr")));
		Csr.sendKeys(prop.getProperty("Para1"));
		Csr.sendKeys(Keys.ENTER);
		Csr.sendKeys(prop.getProperty("Para2"));
		Csr.sendKeys(Keys.ENTER);
		Csr.sendKeys(prop.getProperty("Para3"));
		Csr.sendKeys(Keys.ENTER);
		Csr.sendKeys(prop.getProperty("Para4"));
		Csr.sendKeys(Keys.ENTER);
		Csr.sendKeys(prop.getProperty("Para5"));
		Csr.sendKeys(Keys.ENTER);
		Csr.sendKeys(prop.getProperty("Para6"));
		Csr.sendKeys(Keys.ENTER);
		Csr.sendKeys(prop.getProperty("Para7"));
		Csr.sendKeys(Keys.ENTER);
		Csr.sendKeys(prop.getProperty("Para8"));
		Csr.sendKeys(Keys.ENTER);
		Csr.sendKeys(prop.getProperty("Para9"));
		Csr.sendKeys(Keys.ENTER);
		Csr.sendKeys(prop.getProperty("Para10"));
		Csr.sendKeys(Keys.ENTER);
		Csr.sendKeys(prop.getProperty("Para11"));
		Csr.sendKeys(Keys.ENTER);
		Csr.sendKeys(prop.getProperty("Para12"));
		Csr.sendKeys(Keys.ENTER);
		Csr.sendKeys(prop.getProperty("Para13"));
		Csr.sendKeys(Keys.ENTER);
		Csr.sendKeys(prop.getProperty("Para14"));
		Csr.sendKeys(Keys.ENTER);
		Csr.sendKeys(prop.getProperty("Para15"));
		Csr.sendKeys(Keys.ENTER);
		Csr.sendKeys(prop.getProperty("Para16"));
		Csr.sendKeys(Keys.ENTER);
		Csr.sendKeys(prop.getProperty("Para17"));
		Csr.sendKeys(Keys.ENTER);
		
		WebElement Decoder = driver.findElement(By.xpath(".//*[@id='mainCertDetails']/a"));
		Decoder.click();
		
		WebElement DecoderStatus;
		DecoderStatus = wait.until(ExpectedConditions.visibilityOfElementLocated (By.xpath(".//*[@class='modal-footer']/a[1]")));
		DecoderStatus.click();
		Thread.sleep(10000);
		
		System.out.println("Sleep Over");
		
		//JavascriptExecutor jse = (JavascriptExecutor)driver;
		jse.executeScript("window.scrollBy(0,-250)", "");
		
		Thread.sleep(2000);
		
		
		/*-----Fillm in Admin Tab-----------------------*/
		WebElement Admintab = driver.findElement (By.xpath(".//*[@class='tabbable v-margin5']/ul/li[2]/a"));
		Admintab.click();
	
	    System.out.println("Admin Tab Clicked");
	    
	    WebElement ContactSelect = driver.findElement(By.xpath(".//*[@id='CertificateAdminContact']"));
		Select Initials = new Select(ContactSelect);
		Initials.selectByVisibleText("Quality Assurance Tester");
	   	
		WebElement Organization = driver.findElement(By.id("CertificateAdminOrganisation"));
		Organization.clear();
		Organization.sendKeys("SSL247 Ltd");

/*		
		WebElement Title = driver.findElement(By.id("CertificateAdminTitle"));
		Select Initials = new Select(Title);
		Initials.selectByVisibleText("Dr");
		
		WebElement Firstname = driver.findElement(By.id("CertificateAdminFirstname"));
		Firstname.sendKeys("Gideon");
		
		WebElement Lastname = driver.findElement(By.id("CertificateAdminLastname"));
		Lastname.sendKeys("Ogunleye");
		
		WebElement Email = driver.findElement(By.id("CertificateAdminEmail"));
		Email.sendKeys("qa@ssl247.co.uk");
		
		WebElement Phone = driver.findElement(By.id("CertificateAdminPhone"));
		Phone.sendKeys("02037610541");
*/		
		driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
		
		/*-----Fill in Tech Tab-----------------------------*/
		
		try {
			
			if (driver.findElement(By.xpath(".//*[@class='tabbable v-margin5']/ul/li[3]/a")).isDisplayed()) {
			
				System.out.println("Tech Tab is Present");
				WebElement Techtab = driver.findElement (By.xpath(".//*[@class='tabbable v-margin5']/ul/li[3]/a"));
				Techtab.click();
				
				WebElement TechOrganization = driver.findElement(By.id("CertificateTechOrganisation"));
				TechOrganization.clear();
				TechOrganization.sendKeys("SSL247 Ltd");
				
				WebElement TechTitle = driver.findElement(By.id("CertificateTechTitle"));
				Select TechInitials = new Select(TechTitle);
				TechInitials.selectByVisibleText("Dr");
				
				WebElement TechFirstname = driver.findElement(By.id("CertificateTechFirstname"));
				TechFirstname.clear();
				TechFirstname.sendKeys("Gideon");
				
				WebElement TechLastname = driver.findElement(By.id("CertificateTechLastname"));
				TechLastname.clear();
				TechLastname.sendKeys("Ogunleye");
				
				WebElement TechEmail = driver.findElement(By.id("CertificateTechEmail"));
				TechEmail.clear();
				TechEmail.sendKeys("qa@ssl247.co.uk");
				
				WebElement TechPhone = driver.findElement(By.id("CertificateTechPhone"));
				TechPhone.clear();
				TechPhone.sendKeys("02037610541");
			}
		
		}catch(Exception e) {
			System.out.println("Tech Tab is not Present");
		
			}
		
		
		
		
		driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
		
		/*-----Fill in Organisation Tab-----------------------------*/
		
		try {
				if (driver.findElement(By.xpath(".//*[@id='CertificateMysslEditForm']/div[2]/div[2]/ul/li[4]/a")).isDisplayed()) {
				
					System.out.println("Organisation Tab is Present");
					driver.findElement(By.xpath(".//*[@id='CertificateMysslEditForm']/div[2]/div[2]/ul/li[4]/a")).click();
					driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
					driver.findElement(By.xpath(".//*[@id='CertificateOrganisationLegalName']")).clear();
					driver.findElement(By.xpath(".//*[@id='CertificateOrganisationLegalName']")).sendKeys("SSL247 Ltd");
					System.out.println("Organisation Legal Name Field Filled");
				}
			
			}catch(Exception e) {
				System.out.println("Organisation Tab is not Present");
			
				}

		
		try {
			if (driver.findElement(By.xpath(".//*[@id='CertificateOrganisationCategory']")).isDisplayed()) {
			
				System.out.println("Organisation Category is Present");
				WebElement Category = driver.findElement(By.xpath(".//*[@id='CertificateOrganisationCategory']"));
				Select Level = new Select(Category);
				Level.selectByVisibleText("Other registered business");
				
				driver.findElement(By.xpath(".//*[@id='CertificateOrganisationRegistrationNumber']")).clear();
				driver.findElement(By.xpath(".//*[@id='CertificateOrganisationRegistrationNumber']")).sendKeys("01234567");
			}
		
		}catch(Exception e) {
			System.out.println("Organisation Category is not Present");
		
			}
		
		
		/*-----Click on Submit Button--------*/
		WebElement Submit = driver.findElement(By.xpath(".//*[@class='form-actions v-margin5 text-right']/button"));
		Submit.click();
		driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
	  	
	  	try {
			
			if (driver.findElement(By.xpath("html/body/div[4]/p[1]")).isDisplayed()) {
			
				String OrderStatus = driver.findElement(By.xpath("html/body/div[4]/p[1]")).getText();
			  	Assert.assertTrue(OrderStatus.contains("Product Successfully Ordered with CA"));
			  	test.log(LogStatus.PASS, " Order Placed");
		  		System.out.println(ProductLink + " Order Placed");
			}
		
		}catch(Exception e) {
			
			System.out.println(ProductLink + " Product Not Successfully Ordered with CA or Status Alert not Displayed");
	  	
		}
	  	
		// Log Out
		//Thread.sleep(15000);
		//driver.findElement(By.linkText("Logout")).click();
		//Thread.sleep(15000);	
	}
	
/*	
	  @BeforeTest (groups = {"Regression"})
	  public void beforeTest() throws IOException, Exception {
		
		 /*----Firefox Driver------
		 //System.setProperty("webdriver.gecko.driver","C:\\geckodriver.exe");
		// driver = new FirefoxDriver(); 
		 
		 System.setProperty("webdriver.chrome.driver", "C:\\chromedriver.exe");
		 driver = new ChromeDriver();  
		 
		 System.out.println("Order Products Regression Test is Running.....");
		 
		 
		 
	  }
	  
	  @AfterTest (groups = {"Regression"})
	  public void afterTest() throws Exception {
		  
		 Thread.sleep(1000);
		 
		 //report.endTest(test);
		 driver.quit();
		 System.out.println("Order Products Regression Test is Compete!");
  	}
*/	
	
}
