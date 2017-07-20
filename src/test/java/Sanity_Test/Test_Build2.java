package Sanity_Test;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
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
import BaseUtilities.TakeScreenShot;
import PageFactory.AdminCertificateDetailsPage;
import PageFactory.AdminCertificatesPage;
import PageFactory.AdminIssuedCertificatesPage;
import PageFactory.AdminNavigationLinks;
import PageFactory.AdminSslDashBoard;
import PageFactory.BillingPage;
import PageFactory.ClientAccountsPage;
import PageFactory.LoginPage;
import PageFactory.NavigationLinks;
import PageFactory.ProposalsPage;
import PageFactory.sslDashBoard;
import Regression_Test.Test_Data;

public class Test_Build2 extends BrowserStack {
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
	TakeScreenShot ScreenShot;
	
	@BeforeMethod (groups = {"Sanity","Smoke","BS_Smoke","BS_Sanity","Sanity_Chrome"})
	public void Load_Homepage () throws Exception {
		
		report = ExtentFactory.getInstance(); 
		LoginPageElements = new LoginPage(driver);
		BillingPageElements = new BillingPage(driver);
		sslDashBoardElements = new sslDashBoard(driver);
		CsrElements = new CsR(driver);
		CookiesElements = new Cookies(driver);
		NavigationElements = new NavigationLinks(driver);
		AlertBoxElements = new AlertBox(driver);
		ScreenShot = new TakeScreenShot();
		
		LoginPageElements.LoadLoginPage();
		
		report = ExtentFactory.getInstance();
		
		Thread.sleep(5000);		
	}
	
	@AfterMethod (groups = {"Sanity","Smoke","BS_Smoke","BS_Sanity","Sanity_Chrome"},alwaysRun = true)
	public void Aftermethod (ITestResult result) throws IOException, Exception {

/*		
		String filename = result.getMethod().getMethodName()+ result.getEndMillis() +".png";
	    String Directory = "C:\\Screenshots\\Sanity ScreenShots\\";
		  
	    File sourceFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(sourceFile, new File(Directory + filename));
		  
		String destination = Directory + filename;
*/
		
	  	String path =  ScreenShot.Image(driver, "TestSecreenShot-" + result.getMethod().getMethodName());
		String imagePath = test.addScreenCapture(path);
		test.log(LogStatus.INFO, "Test Complete", imagePath);
		
		driver.navigate().refresh();
		Thread.sleep(1000);
		System.out.println("Page Refreshed");
		
	
		test.log(LogStatus.INFO, "Browser Refreshed");
		report.endTest(test);
		report.flush();
	
	//return destination;
		
	}
	
	  @Test (priority = 5, groups = {"Sanity", "BS_Sanity","Sanity_Chrome"})
	  public void Request_a_PenTest_Proposal() throws Exception{
		  
		test = report.startTest("New User Test --> Request a PenTest Form");
		test.log(LogStatus.INFO, "Browser Opened and Url Entered");
		
		Thread.sleep(1000);
		
		WebDriverWait wait = new WebDriverWait(driver, 50);
		Actions  Mouse=new Actions(driver);
		
		WebElement Dropdown=wait.until(ExpectedConditions.visibilityOfElementLocated (By.xpath(".//*[@id='mainNavigation']/li[4]/a")));
	    Mouse.moveToElement(Dropdown);
	    Mouse.perform();
	    
	    String path2 = ScreenShot.Image(driver, "Screenshot");
		String imagePath2 = test.addScreenCapture(path2);
		test.log(LogStatus.INFO, "Take Screenshot", imagePath2);
	    
		WebElement EyeIcon=wait.until(ExpectedConditions.visibilityOfElementLocated (By.xpath(".//*[@id='mainNavigation']/li[4]/ul/li[1]/a")));
	    Mouse.moveToElement(EyeIcon);
	    Mouse.click();
	    Mouse.perform();	
		
		
		Thread.sleep(1000);
		
		driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
		JavascriptExecutor jse = (JavascriptExecutor)driver;
		jse.executeScript("window.scrollBy(0,500)", "");
		
		Thread.sleep(1000);
		
		try {
			
			String Msg = "Request a free proposal";
			WebElement ProposalForm = driver.findElement(By.xpath(".//*[@id='mainContainer']/div[4]/div[5]/div[1]/a"));
			
			if (ProposalForm.getText().contains(Msg)) {
				
				test.log(LogStatus.PASS, "Form Opened");
				
				ProposalForm.click();
				driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
				test.log(LogStatus.INFO, "Clicked On Proposal Form");
				
				
			}else {
				
				System.out.println("Message is:" + ProposalForm.getText());
				//ScreenShot.Image(null);
				String path = ScreenShot.Image(driver, "SearchResult");
				String imagePath = test.addScreenCapture(path);
				test.log(LogStatus.FAIL, "Form Not Opened", imagePath);
				
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
			CookiesElements.CheckCookies();
			driver.findElement(By.xpath(".//*[@id='penTestForm']/div[3]/button[1]")).click();
		
		}catch (Exception e) {
			
			String path = ScreenShot.Image(driver, "FormDispaly" + driver.hashCode());
			String imagePath = test.addScreenCapture(path);
			test.log(LogStatus.FAIL, "Form Not Opened", imagePath);
			Assert.fail("Exception " + e);
			driver.quit();
			
		}
		
	    
	 
	    try {
		  
	    	String StatusMsg = "Your query is being processed";
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
				
				test.log(LogStatus.FAIL, "Alert Not Displayed");
				
			}

	  }	
	
 
  
  
  
}
