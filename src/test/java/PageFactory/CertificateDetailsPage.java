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
	
	@FindBy(xpath = ".//*[@id='CertificateMysslViewForm']/div[2]/div/button")
	WebElement ValidateCsrButton;

	
	public CertificateDetailsPage(WebDriver driver){
		
		this.driver = driver;
		PageFactory.initElements(new AjaxElementLocatorFactory(driver, 20), this);
		//PageFactory.initElements(driver, this);
		
	}
	


	public void ReIssueTabClick(){
		
		ReIssueTab.click();
		
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
	
	public void LoadCsR () throws Exception {
		
		Properties prop = new Properties();
		FileInputStream fis = new FileInputStream("C://Users//Gideon Okunleye//workspace//AutomationTestScripts//DataDriving.properties");
				 
		prop.load(fis);
		
		CsrFieldFill(prop.getProperty("Para1"));
		HitEnterKey();
		CsrFieldFill(prop.getProperty("Para2"));
		HitEnterKey();
		CsrFieldFill(prop.getProperty("Para3"));
		HitEnterKey();;
		CsrFieldFill(prop.getProperty("Para4"));
		HitEnterKey();
		CsrFieldFill(prop.getProperty("Para5"));
		HitEnterKey();
		CsrFieldFill(prop.getProperty("Para6"));
		HitEnterKey();
		CsrFieldFill(prop.getProperty("Para7"));
		HitEnterKey();
		CsrFieldFill(prop.getProperty("Para8"));
		HitEnterKey();
		CsrFieldFill(prop.getProperty("Para9"));
		HitEnterKey();
		CsrFieldFill(prop.getProperty("Para10"));
		HitEnterKey();
		CsrFieldFill(prop.getProperty("Para11"));
		HitEnterKey();
		CsrFieldFill(prop.getProperty("Para12"));
		HitEnterKey();
		CsrFieldFill(prop.getProperty("Para13"));
		HitEnterKey();
		CsrFieldFill(prop.getProperty("Para14"));
		HitEnterKey();
		CsrFieldFill(prop.getProperty("Para15"));
		HitEnterKey();
		CsrFieldFill(prop.getProperty("Para16"));
		HitEnterKey();
		CsrFieldFill(prop.getProperty("Para17"));
		HitEnterKey();
	
	}
	
}
