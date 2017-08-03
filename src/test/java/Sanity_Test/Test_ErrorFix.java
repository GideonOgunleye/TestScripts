package Sanity_Test;

import org.testng.annotations.Test;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import BaseUtilities.AlertBox;
import BaseUtilities.BrowserStack;
import BaseUtilities.Chrome;
import BaseUtilities.CsR;
import BaseUtilities.DriverLoad;
import BaseUtilities.ExtentFactory;
import BaseUtilities.TakeScreenShot;
import PageFactory.BillingPage;
import PageFactory.LoginPage;
import PageFactory.sslDashBoard;
import Regression_Test.Test_Data;
import Sanity_Test.Test_DataSanity;

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

public class Test_ErrorFix extends Chrome {
	//WebDriver driver;
	ExtentReports report;
	ExtentTest test;
	LoginPage 	LoginPageElements;
	BillingPage BillingPageElements;
	sslDashBoard sslDashBoardElements;
	AlertBox AlertBoxElements;
	TakeScreenShot ScreenShot;
	CsR CsrElements;

	
	@BeforeMethod (groups = {"Regression","BS_Regression","Regression_Chrome"})
	public void User_Login () throws Exception {
		 
		LoginPageElements = new LoginPage(driver);
		BillingPageElements = new BillingPage(driver);
		sslDashBoardElements = new sslDashBoard(driver);
		AlertBoxElements = new AlertBox(driver);
		ScreenShot = new TakeScreenShot();
		CsrElements = new CsR(driver);

		
		LoginPageElements.ClientLogin();
		
		Thread.sleep(5000);
		
	}

	
	@AfterMethod (groups = {"Regression","BS_Regression","Regression_Chrome"}, alwaysRun = true)
	public void User_Logout (ITestResult result) throws Exception {
		
	
	    //Take Screen Shots	
				
		String path =  ScreenShot.Image(driver, "TestSecreenShot-" + result.getMethod().getMethodName());
		String imagePath = test.addScreenCapture(path);
		test.log(LogStatus.INFO, "Test Complete", imagePath);
		
		driver.navigate().refresh();
		
		Thread.sleep(1000);
		
		//User Log Out
		
		 try{ 
			 
			 if(LoginPageElements.LogoutButtonIsVisible()) {
	  			   
	  			 LoginPageElements.ClickLogoutButton();
		  		 test.log(LogStatus.INFO, "After Method-Client User Logged Out");
		  		 String path2 = ScreenShot.Image(driver, "Logout");
		  		 String imagePath2 = test.addScreenCapture(path2);
		  		 test.log(LogStatus.INFO, imagePath2);
		  		 report.endTest(test);
		  		 report.flush();
				 
			 }else {
				 
				 test.log(LogStatus.FAIL, "After Method-Logout not visible");
				 String path2 = ScreenShot.Image(driver, "Logout");
				 String imagePath2 = test.addScreenCapture(path2);
				 test.log(LogStatus.INFO, imagePath2);
				 report.endTest(test);
				 report.flush();
				 Assert.fail("Log Out not visible");
				 //driver.quit();
			 }
	
		 }catch (Exception e) {
				
				test.log(LogStatus.FAIL, "After Method-Logout Failed");
				String path2 = ScreenShot.Image(driver, "Logout");
				String imagePath2 = test.addScreenCapture(path2);
				test.log(LogStatus.INFO, imagePath2);
				report.endTest(test);
				report.flush();
				Assert.fail("Log Out Failed- "+"Exception: " + e);
				driver.quit();
				
		} 

	}
	
	
	@Test (priority = 1, groups = {"Regression","BS_Regression","Regression_Chrome"},dataProviderClass = Test_Data.class, dataProvider="OrderProduct_Data")
	  public void Order_Certificates(String Product, String ProductLink) throws Exception {
		
		report = ExtentFactory.getInstance2();
		
		System.out.println(ProductLink + " Order Has Started.............");
		test = report.startTest(Product);
	    test.log(LogStatus.INFO, "User Logged in");
		
		//Navigate to product page//
	    sslDashBoardElements.ClickMyProductsLink();
	    driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
	    test.log(LogStatus.INFO, "Clicked on Product Link");
	    
  try {		
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

		if (Link1.getText().contains(ProductLink)) {
				
				System.out.println(ProductLink + " Found");
				driver.findElement(By.xpath(".//*[@id='SSLCertificate']/table/tbody/tr[1]/td[2]/a")).click();
				test.log(LogStatus.INFO, ProductLink + "Link Clicked");
			
			}else if (Link2.getText().contains(ProductLink)) {
				
				System.out.println(ProductLink + " Found");
				driver.findElement(By.xpath(".//*[@id='SSLCertificate']/table/tbody/tr[2]/td[2]/a")).click();
				test.log(LogStatus.INFO, ProductLink + "Link Clicked");
		
			}else if (Link3.getText().contains(ProductLink)) {
				
				System.out.println(ProductLink + " Found");
				driver.findElement(By.xpath(".//*[@id='SSLCertificate']/table/tbody/tr[3]/td[2]/a")).click();
			    driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
				test.log(LogStatus.INFO, ProductLink + "Link Clicked");
				
			}else if (Link4.getText().contains(ProductLink)) {
				
				System.out.println(ProductLink + " Found");
				driver.findElement(By.xpath(".//*[@id='SSLCertificate']/table/tbody/tr[4]/td[2]/a")).click();
			    driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
				test.log(LogStatus.INFO, ProductLink + "Link Clicked");
			
			}else if (Link5.getText().contains(ProductLink)) {
				
				System.out.println(ProductLink + " Found");
				driver.findElement(By.xpath(".//*[@id='SSLCertificate']/table/tbody/tr[5]/td[2]/a")).click();
			    driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
				test.log(LogStatus.INFO, ProductLink + "Link Clicked");
			
			}else if (Link6.getText().contains(ProductLink)) {
				
				System.out.println(ProductLink + " Found");
				driver.findElement(By.xpath(".//*[@id='SSLCertificate']/table/tbody/tr[6]/td[2]/a")).click();
			    driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
			    test.log(LogStatus.INFO, ProductLink + "Link Clicked");
				
			
			}else if (Link7.getText().contains(ProductLink)) {
				
				System.out.println(ProductLink + " Found");
				driver.findElement(By.xpath(".//*[@id='SSLCertificate']/table/tbody/tr[7]/td[2]/a")).click();
			    driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
			    test.log(LogStatus.INFO, ProductLink + "Link Clicked");
		
			}else if (Link8.getText().contains(ProductLink)) {
				
				System.out.println(ProductLink + " Found");
				driver.findElement(By.xpath(".//*[@id='SSLCertificate']/table/tbody/tr[8]/td[2]/a")).click();
			    driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
			    test.log(LogStatus.INFO, ProductLink + "Link Clicked");
				
			
			}else if (Link9.getText().contains(ProductLink)) {
				
				System.out.println(ProductLink + " Found");
				driver.findElement(By.xpath(".//*[@id='SSLCertificate']/table/tbody/tr[9]/td[2]/a")).click();
			    driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
			    test.log(LogStatus.INFO, ProductLink + "Link Clicked");
			
			}else if (Link10.getText().contains(ProductLink)) {
				
				System.out.println(ProductLink + " Found");
				driver.findElement(By.xpath(".//*[@id='SSLCertificate']/table/tbody/tr[10]/td[2]/a")).click();
			    driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
			    test.log(LogStatus.INFO, ProductLink + "Link Clicked");
				
			}else if (Link11.getText().contains(ProductLink)) {
				
				System.out.println(ProductLink + " Found");
				driver.findElement(By.xpath(".//*[@id='SSLCertificate']/table/tbody/tr[11]/td[2]/a")).click();
			    driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
			    test.log(LogStatus.INFO, ProductLink + "Link Clicked");
			
			}else if (Link12.getText().contains(ProductLink)) {
				
				System.out.println(ProductLink + " Found");
				driver.findElement(By.xpath(".//*[@id='SSLCertificate']/table/tbody/tr[12]/td[2]/a")).click();
			    driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
			    test.log(LogStatus.INFO, ProductLink + "Link Clicked");
			
			}else if (Link13.getText().contains(ProductLink)) {
				
				System.out.println(ProductLink + " Found");
				driver.findElement(By.xpath(".//*[@id='SSLCertificate']/table/tbody/tr[13]/td[2]/a")).click();
			    driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
			    test.log(LogStatus.INFO, ProductLink + "Link Clicked");
			
			
			}else if (Link14.getText().contains(ProductLink)) {
				
				System.out.println(ProductLink + " Found");
				driver.findElement(By.xpath(".//*[@id='SSLCertificate']/table/tbody/tr[14]/td[2]/a")).click();
			    driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
			    test.log(LogStatus.INFO, ProductLink + "Link Clicked");
				
			}else if (Link15.getText().contains(ProductLink)) {
				
				System.out.println(ProductLink + " Found");
				driver.findElement(By.xpath(".//*[@id='SSLCertificate']/table/tbody/tr[15]/td[2]/a")).click();
			    driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
			    test.log(LogStatus.INFO, ProductLink + "Link Clicked");
			
			}else if (Link16.getText().contains(ProductLink)) {
				
				System.out.println(ProductLink + " Found");
				driver.findElement(By.xpath(".//*[@id='SSLCertificate']/table/tbody/tr[16]/td[2]/a")).click();
			    driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
			    test.log(LogStatus.INFO, ProductLink + "Link Clicked");
			
			}else if (Link17.getText().contains(ProductLink)) {
				
				System.out.println(ProductLink + " Found");
				driver.findElement(By.xpath(".//*[@id='SSLCertificate']/table/tbody/tr[17]/td[2]/a")).click();
				test.log(LogStatus.INFO, ProductLink + "Link Clicked");
			
			}else if (Link18.getText().contains(ProductLink)) {
				
				System.out.println(ProductLink + " Found");
				driver.findElement(By.xpath(".//*[@id='SSLCertificate']/table/tbody/tr[18]/td[2]/a")).click();
			    driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
			    test.log(LogStatus.INFO, ProductLink + "Link Clicked");
			
			}else if (Link19.getText().contains(ProductLink)) {
				
				System.out.println(ProductLink + " Found");
				driver.findElement(By.xpath(".//*[@id='SSLCertificate']/table/tbody/tr[19]/td[2]/a")).click();
			    driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
			    test.log(LogStatus.INFO, ProductLink + "Link Clicked");
			
			}else if (Link20.getText().contains(ProductLink)) {
				
				System.out.println(ProductLink + " Found");
				driver.findElement(By.xpath(".//*[@id='SSLCertificate']/table/tbody/tr[20]/td[2]/a")).click();
				driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
				test.log(LogStatus.INFO, ProductLink + "Link Clicked");
			
			}else if (Link21.getText().contains(ProductLink)) {
				
				System.out.println(ProductLink + " Found");
				driver.findElement(By.xpath(".//*[@id='SSLCertificate']/table/tbody/tr[21]/td[2]/a")).click();
				driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
				test.log(LogStatus.INFO, ProductLink + "Link Clicked");
			
			}else if (Link22.getText().contains(ProductLink)) {
				
				System.out.println(ProductLink + " Found");
				driver.findElement(By.xpath(".//*[@id='SSLCertificate']/table/tbody/tr[22]/td[2]/a")).click();
				driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
				test.log(LogStatus.INFO, ProductLink + "Link Clicked");
			
			}else if (Link23.getText().contains(ProductLink)) {
				
				System.out.println(ProductLink + " Found");
				driver.findElement(By.xpath(".//*[@id='SSLCertificate']/table/tbody/tr[23]/td[2]/a")).click();
				driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
				test.log(LogStatus.INFO, ProductLink + "Link Clicked");
			
			}else if (Link24.getText().contains(ProductLink)) {
				
				System.out.println(ProductLink + " Found");
				driver.findElement(By.xpath(".//*[@id='SSLCertificate']/table/tbody/tr[24]/td[2]/a")).click();
				driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
				test.log(LogStatus.INFO, ProductLink + "Link Clicked");
			
			}else if (Link25.getText().contains(ProductLink)) {
				
				System.out.println(ProductLink + " Found");
				driver.findElement(By.xpath(".//*[@id='SSLCertificate']/table/tbody/tr[25]/td[2]/a")).click();
				driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
				test.log(LogStatus.INFO, ProductLink + "Link Clicked");
				
		}else {
			
			System.out.println("Product Not Found");
			test.log(LogStatus.FAIL, "Product Not Found");
			
		}
		
   }catch (Exception e) {
		
	   	String path = ScreenShot.Image(driver, "Product");
		String imagePath = test.addScreenCapture(path);
		test.log(LogStatus.INFO, imagePath);
		test.log(LogStatus.FAIL, "Validation Failed");
		Assert.fail("Exception " + e);
		
	}
		
		//Check Domain Name
		driver.findElement(By.name("data[Basket][common_name]")).clear();
		driver.findElement(By.name("data[Basket][common_name]")).sendKeys("ssl247.net");
		driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
		test.log(LogStatus.INFO, "Filled in Common Name");
		
		
		driver.findElement(By.id("check-cn-btn")).click();
		driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
		test.log(LogStatus.INFO, "Clicked on Check Button");
		
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
		test.log(LogStatus.INFO, ProductLink + " Added To Basket");
				
		//Confirm Order Details
		driver.findElement(By.id("checkoutLink")).click();
		driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
		test.log(LogStatus.INFO, "Clicked Checkout Button");
				
		//Fill In Billing Retails
		BillingPageElements.FillFirstname("Quality");
		driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
		test.log(LogStatus.INFO, "Filled in First Name");
		
		BillingPageElements.FillLastname("Assurance Tester");
		driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
		test.log(LogStatus.INFO, "Filled In Last Name");
		
		BillingPageElements.FillPhoneNumber("0203MMM7610541");
		driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
		test.log(LogStatus.INFO, "Filled In Phone Number");
		
		BillingPageElements.FillEmail("qa@ssl247.co.uk");
		driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
		test.log(LogStatus.INFO, "Filled In Email");
		
		BillingPageElements.FillAddress1("63 Lisson St, Marylebone");
		driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
		test.log(LogStatus.INFO, "Filled In Address");
		
		BillingPageElements.FillCity("London");
		driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
		test.log(LogStatus.INFO, "Filled In City");
		
		BillingPageElements.SelectCountry("United Kingdom");
		driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
		test.log(LogStatus.INFO, "Selected Country");
		
		BillingPageElements.FillPostcode("NW1 5DD");
		driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
		test.log(LogStatus.INFO, "Filled in PostCode");
	  			
		//Confirm input
		BillingPageElements.ClickConfirmButton();
		driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
		test.log(LogStatus.INFO, "Clicked Confirm Button");
		
		WebDriverWait wait = new WebDriverWait(driver, 100);
		
		driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
	  	
	  	try {
			
			if (driver.findElement(By.xpath("html/body/div[4]/p[1]")).isDisplayed()) {
			
				String OrderStatus = driver.findElement(By.xpath("html/body/div[4]/p[1]")).getText();
			  	Assert.assertTrue(OrderStatus.contains("Thank You. Your order has been placed."));
			  	test.log(LogStatus.PASS, " Order Placed");
		  		System.out.println(ProductLink + " Order Placed");
		  		
		  		
			}else {
				
				System.out.println(ProductLink + " Order Not Placed");
				test.log(LogStatus.INFO, " Order Not Placed");
			}
		
		}catch(Exception e) {
			
			System.out.println(ProductLink + " Exception" + e);
			test.log(LogStatus.INFO, "Alart Not displayed");
		}
	  	
	  	
		try {
			
			if (driver.findElement(By.xpath(".//*[@class='btn btn-success btn-small']")).isDisplayed()) {
			
				System.out.println("Account Has Enough Funds");
				test.log(LogStatus.PASS, " Account Has Enough Funds");
				driver.findElement(By.xpath(".//*[@class='btn btn-success btn-small']")).click();
				
			}
		
		}catch(Exception e) {
			System.out.println("Account Does Not Have Enough Funds");
			test.log(LogStatus.FAIL, "Account Does Not Have Enough Funds");
			String path = ScreenShot.Image(driver, "ScreenShot");
			String imagePath = test.addScreenCapture(path);
			test.log(LogStatus.INFO, imagePath);
			Assert.fail("Exception " + e);
			
			}
		
		try { 
			
			
			CsrElements.LoadCsR();
			
			WebElement Decoder = driver.findElement(By.xpath(".//*[@id='mainCertDetails']/a"));
			Decoder.click();
			driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
			test.log(LogStatus.INFO, "Clicked on CsR Decoder");
			
			Thread.sleep(10000);
			
			WebElement DecoderStatus;
			DecoderStatus = wait.until(ExpectedConditions.visibilityOfElementLocated (By.xpath(".//*[@class='modal-footer']/a[1]")));
			DecoderStatus.click();
			driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
			test.log(LogStatus.INFO, "Clicked on CsR Decoder Button");
			
			Thread.sleep(10000);
			
			System.out.println("Sleep Over");
			
			JavascriptExecutor jse = (JavascriptExecutor)driver;
			jse.executeScript("window.scrollBy(0,-250)", "");
			
			Thread.sleep(2000);
			
			
			/*-----Fillm in Admin Tab-----------------------*/
			WebElement Admintab = driver.findElement (By.xpath(".//*[@class='tabbable v-margin5']/ul/li[2]/a"));
			Admintab.click();
		
		    System.out.println("Admin Tab Clicked");
		    
		    WebElement ContactSelect = driver.findElement(By.xpath(".//*[@id='CertificateAdminContact']"));
			Select Initials = new Select(ContactSelect);
			Initials.selectByVisibleText("Gideon Ogunleye");
		   	
			WebElement Organization = driver.findElement(By.id("CertificateAdminOrganisation"));
			Organization.clear();
			Organization.sendKeys("SSL247 Ltd");
			
		}catch (Exception e) {
			
			test.log(LogStatus.FAIL, "Validation Failed");
			Assert.fail("Exception " + e);
			String path = ScreenShot.Image(driver, "SearchResult");
			String imagePath = test.addScreenCapture(path);
			test.log(LogStatus.INFO, imagePath);

		}
	
		
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
			String path = ScreenShot.Image(driver, "SearchResult");
			String imagePath = test.addScreenCapture(path);
			test.log(LogStatus.INFO, "Tech Tab is not Present");
			test.log(LogStatus.INFO, imagePath);
		
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
				String path = ScreenShot.Image(driver, "SearchResult");
				String imagePath = test.addScreenCapture(path);
				test.log(LogStatus.INFO, "Organisation Tab is not Present");
				test.log(LogStatus.INFO, imagePath);
			
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
			String path = ScreenShot.Image(driver, "SearchResult");
			String imagePath = test.addScreenCapture(path);
			test.log(LogStatus.INFO, "Organisation Category is not Present");
			test.log(LogStatus.INFO, imagePath);

		
			}
		
		
		/*-----Click on Submit Button--------*/
		WebElement Submit = driver.findElement(By.xpath(".//*[@class='form-actions v-margin5 text-right']/button"));
		Submit.click();
		
		try {
			String Alertnote = "The certificate has been saved and is pending submission with the CA";  
			AlertBoxElements.AlertWait();
					    	
		  if (AlertBoxElements.VerifyAlert(Alertnote)) {
								
			test.log(LogStatus.PASS, "Validation Complete");
			Assert.assertTrue(AlertBoxElements.VerifyAlert(Alertnote));
			System.out.println("Validation Complete!");
			
		  }else{
					    	
			test.log(LogStatus.FAIL, "Validation Failed");
			AlertBoxElements.AlertPrint();
			String path = ScreenShot.Image(driver, "SearchResult");
			String imagePath = test.addScreenCapture(path);
			test.log(LogStatus.INFO, imagePath);
			Assert.fail("Validation Failed ");
					    	
			}
			
		}catch (Exception e) {
								
			test.log(LogStatus.FAIL, "Validation Failed");
			String path = ScreenShot.Image(driver, "SearchResult");
			String imagePath = test.addScreenCapture(path);
			test.log(LogStatus.INFO, imagePath);

			Assert.fail("Exception " + e);

		}

	}
		
	
}
