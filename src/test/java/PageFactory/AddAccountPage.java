package PageFactory;

import static org.testng.Assert.assertTrue;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import BaseUtilities.BrowserStack;
import BaseUtilities.DriverLoad;

public class AddAccountPage extends DriverLoad {
	
	
	/*****Main Menu*******/
	@FindBy(xpath = ".//*[@id='AccountName']")
	WebElement CompanyNameField;
	
	//@FindBy(xpath = ".//*[@id='AccountDaysToPay']")
	//WebElement DaysToPayField;
	
	@FindBy(xpath = ".//*[@id='AccountAccountManagerId']")
	WebElement AccountManagerField;
	
	@FindBy(xpath = ".//*[@id='AccountSalesAssistantId']")
	WebElement SalesAssistantField;
	
	@FindBy(xpath = ".//*[@id='AccountWebsiteId']")
	WebElement TerritoryField;
	
	@FindBy(xpath = ".//*[@id='AccountVatPrefix']")
	WebElement VatPrefixField;
	
	@FindBy(xpath = ".//*[@id='AccountVatNumber']")
	WebElement VatNumberField;
	
	@FindBy(xpath = ".//*[@id='AccountCompanyRegistrationNumber']")
	WebElement CompanyRegNumberField;
	
	@FindBy(xpath = ".//*[@id='AccountAccountActivitySector']")
	WebElement AccountActivitySectorField;
	
	@FindBy(xpath = ".//*[@id='AccountAccountCompanySizeId']")
	WebElement AccountCompanySizeField;
	
	@FindBy(xpath = ".//*[@id='AccountPaymentTerms']")
	WebElement RequestPaymentTermsCheckBox;
	
	@FindBy(xpath = ".//*[@id='AccountDaysToPay']")
	WebElement DaysToPayField;
	
	@FindBy(xpath = ".//*[@id='AccountDaysToPayEom']")
	WebElement DaysToEomCheckBox;
	
	@FindBy(xpath = ".//*[@id='AccountMinimumPaymentLimit']")
	WebElement MinimumPaymentLimitField;
	
	@FindBy(xpath = ".//*[@id='AccountAdminAddForm']/div[2]/div[2]/div/div[1]/button[1]")
	WebElement ActiveButton;
	
	@FindBy(xpath = ".//*[@id='AccountAdminAddForm']/div[2]/div[2]/div/button")
	WebElement CreateAccountButton;
	
	public AddAccountPage(WebDriver driver){
		
		this.driver = driver;
		PageFactory.initElements(new AjaxElementLocatorFactory(driver, 100), this);
		//PageFactory.initElements(driver, this);
		
	}

	
	public void CompanyNameFieldFill(String CName){
		
		CompanyNameField.sendKeys(CName);
	
	}
	
	public void AccountManagerFieldSelect(String Name){
		
		Select Options = new Select(AccountManagerField);
		Options.selectByVisibleText(Name);
	
	}
	
	public void SalesAssistantFieldSelect(String Name){
		
		Select Options = new Select(SalesAssistantField);
		Options.selectByVisibleText(Name);
	
	}
	
	public void TerritoryFieldSelect(String TName){
		
		Select Options = new Select(TerritoryField);
		Options.selectByVisibleText(TName);
	
	}
	
	public void VatPrefixFieldSelect(String Prefix){
		
		Select Options = new Select(VatPrefixField);
		Options.selectByVisibleText(Prefix);
	
	}
	
	public void VatNumberFieldFill(String VNumber){
		
		VatNumberField.sendKeys(VNumber);
	
	}
	
	public void AccountActivitySectorFieldSelect(String Sector){
		
		Select Options = new Select(AccountActivitySectorField);
		Options.selectByVisibleText(Sector);
	
	}
	
	public void CompanyRegNumberFieldFill(String RNumber){
		
		CompanyRegNumberField.sendKeys(RNumber);
	
	}
	
	public void AccountCompanySizeFieldSelect(String Range){
		
		Select Options = new Select(AccountCompanySizeField);
		Options.selectByVisibleText(Range);
	}
	
	public void RequestPaymentTermsCheckBoxClick(){
		
		RequestPaymentTermsCheckBox.click();
	
	}
	
	public void DaysToPayFieldSelect(String Days){
		
		Select Options = new Select(DaysToPayField);
		Options.selectByVisibleText(Days);
	
	}
	
	public void DaysToEomCheckBoxClick(){
		
		DaysToEomCheckBox.click();
	
	}
	
	public void MinimumPaymentLimitFieldSelect(String Number){
		
		Select Options = new Select(MinimumPaymentLimitField);
		Options.selectByVisibleText(Number);
	
	}
	
	public void ActiveButtonClick(){
		
		ActiveButton.click();
	
	}
	
	public void CreateAccountButtonClick(){
		
		CreateAccountButton.click();
	
	}
	
	

}
