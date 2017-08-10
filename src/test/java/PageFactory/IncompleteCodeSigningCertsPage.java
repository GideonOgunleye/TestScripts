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


public class IncompleteCodeSigningCertsPage extends DriverLoad {
	ExtentReports report;
	ExtentTest test;
	
	
	/********Incomplete Certificates Page****/
	
	@FindBy(xpath = ".//*[@id='DataTables_Table_0']/tbody/tr/td[6]/a")
	WebElement Column1EditButton;
	
	

	
	public IncompleteCodeSigningCertsPage(WebDriver driver){
		
		this.driver = driver;
		PageFactory.initElements(new AjaxElementLocatorFactory(driver, 20), this);
		//PageFactory.initElements(driver, this);
		
	}
	
	public void Column1EditButtonClick() {
		
		Column1EditButton.click();
	}
		
}
