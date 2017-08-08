package PageFactory;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
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


public class AdminOrdersPage extends DriverLoad {
	ExtentReports report;
	ExtentTest test;
	
	
	/********Proposal Page*******/
	@FindBy(xpath = ".//*[@id='mainContainer']/div[7]/div[2]/div[2]/ul/li[2]/a")
	WebElement SavedTab;
	
	@FindBy(xpath = ".//*[@id='mainContainer']/div[6]/div[2]/div[2]/ul/li[2]/a")
	WebElement SavedTabFR;
	
	@FindBy(xpath = ".//*[@id='mainContainer']/div[7]/div[2]/div[2]/ul/li[3]/a")
	WebElement Pending;
	
	@FindBy(xpath = ".//*[@id='DataTables_Table_1']/tbody/tr[1]/td[7]/a")
	WebElement FirstCertViewButton;
	
	@FindBy(xpath = ".//*[@id='mainContainer']/div[7]/div[2]/div/table/tbody/tr/td[8]/a")
	WebElement CertEditButton;
	
	@FindBy(xpath = ".//*[@id='mainContainer']/div[6]/div[2]/div/table/tbody/tr/td[8]/a")
	WebElement CertEditButtonFR;

	public AdminOrdersPage(WebDriver driver){
		
		this.driver = driver;
		PageFactory.initElements(new AjaxElementLocatorFactory(driver, 20), this);
		//PageFactory.initElements(driver, this);
		
	}
	
	public void SavedTabClick(){
		
		SavedTab.click();
	}
	
	public void SavedTabFRClick(){
		
		SavedTabFR.click();
	}
	
	public void FirstCertViewButtonClick(){
		
		FirstCertViewButton.click();
	}
	
	public void CertEditButtonClick(){
		
		CertEditButton.click();
	}
	
	public void CertEditButtonFRClick(){
		
		CertEditButtonFR.click();
	}

}
