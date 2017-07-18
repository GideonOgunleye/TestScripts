package PageFactory;

import java.io.FileInputStream;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import BaseUtilities.DriverLoad;

import org.testng.Assert;


public class CertificateDetailsPage extends DriverLoad {
	ExtentReports report;
	ExtentTest test;
	
	
	/********Issue Certificates Page****/
	
	@FindBy(xpath = ".//*[@id='certificateAdditionalInfo']/li[1]/a")
	WebElement ReIssueTab;
	
	@FindBy(xpath = ".//*[@id='CertificateNewCsr']")
	WebElement CsrField;
	
	@FindBy(xpath = ".//*[@id='CertificateMysslViewForm']/div[2]/div[1]/div/button")
	WebElement ValidateCsrButton;
	
	@FindBy(xpath = ".//*[@class='stdContentWrapper']/div[1]/div[1]/div/div/div[2]/div/div[2]/a")
	WebElement ReIssueButton;
	
	@FindBy(xpath = ".//*[@id='CertificateMysslReissueForm']/fieldset/button")
	WebElement ReIssueCertificateButton;
	

	
	public CertificateDetailsPage(WebDriver driver){
		
		this.driver = driver;
		PageFactory.initElements(new AjaxElementLocatorFactory(driver, 20), this);
		//PageFactory.initElements(driver, this);
		
	}
	
	public void ReIssueTabClick(){
		
		ReIssueTab.click();
		
	}
	
	public void ReIssueButtonClick(){
		
		ReIssueButton.click();
		
	}
	
	public void ReIssueCertificateButtonClick(){
		
		ReIssueCertificateButton.click();
		
	}
	
	public void CsrFieldClick(){
		
		CsrField.click();
		
	}
	
	public void ValidateCsrButton(){
		
		ValidateCsrButton.click();
		
	}
	
	public void CsrFieldFill(String name){
		
		CsrField.sendKeys(name);
	}
	
	public void HitEnterKey(){
		
		CsrField.sendKeys(Keys.ENTER);
	}
	
	
	public void LoadSsl247_TestCsR () throws Exception {
		
		Properties prop = new Properties();
		FileInputStream fis = new FileInputStream("C://Users//Gideon Okunleye//workspace//AutomationTestScripts//DataDriving.properties");
				 
		prop.load(fis);
		
		CsrFieldFill(prop.getProperty("Ssl-test1"));
		HitEnterKey();
		CsrFieldFill(prop.getProperty("Ssl-test2"));
		HitEnterKey();
		CsrFieldFill(prop.getProperty("Ssl-test3"));
		HitEnterKey();;
		CsrFieldFill(prop.getProperty("Ssl-test4"));
		HitEnterKey();
		CsrFieldFill(prop.getProperty("Ssl-test5"));
		HitEnterKey();
		CsrFieldFill(prop.getProperty("Ssl-test6"));
		HitEnterKey();
		CsrFieldFill(prop.getProperty("Ssl-test7"));
		HitEnterKey();
		CsrFieldFill(prop.getProperty("Ssl-test8"));
		HitEnterKey();
		CsrFieldFill(prop.getProperty("Ssl-test9"));
		HitEnterKey();
		CsrFieldFill(prop.getProperty("Ssl-test10"));
		HitEnterKey();
		CsrFieldFill(prop.getProperty("Ssl-test11"));
		HitEnterKey();
		CsrFieldFill(prop.getProperty("Ssl-test12"));
		HitEnterKey();
		CsrFieldFill(prop.getProperty("Ssl-test13"));
		HitEnterKey();
		CsrFieldFill(prop.getProperty("Ssl-test14"));
		HitEnterKey();
		CsrFieldFill(prop.getProperty("Ssl-test15"));
		HitEnterKey();
		CsrFieldFill(prop.getProperty("Ssl-test16"));
		HitEnterKey();
		CsrFieldFill(prop.getProperty("Ssl-test17"));
		HitEnterKey();
	
	}
	
}
