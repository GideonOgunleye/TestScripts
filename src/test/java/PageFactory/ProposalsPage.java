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


public class ProposalsPage extends DriverLoad {
	ExtentReports report;
	ExtentTest test;
	
	
	/********Proposal Page*******/
	@FindBy(xpath = ".//*[@class='tabbable outer']/ul[1]/li[1]/a")
	WebElement UnIssuedTab;
	
	@FindBy(xpath = ".//*[@class='tabbable outer']/ul[1]/li[2]/a")
	WebElement IssuedTab;
	
	@FindBy(xpath = ".//*[@id='InvoiceAdminAccountIndexForm']/table/tbody/tr[1]/td[6]/a/i")
	WebElement ViewTopResult;
	
	@FindBy(xpath = ".//*[@id='mainContainer']/div[7]/div[2]/div[2]/a[5]")
	WebElement IssueProposalTab;
	
	@FindBy(xpath = ".//*[@id='FormAdminIssue']/div[3]/div[1]/div/div/button")
	WebElement ConfirmCheckBoxOne;
	
	@FindBy(xpath = ".//*[@id='FormAdminIssue']/div[3]/div[2]/div/div[2]/button")
	WebElement ConfirmCheckBoxTwo;
	
	@FindBy(xpath = ".//*[@id='adminIssueInvoiceValidation']")
	WebElement IssueProposalButton;
	
	@FindBy(xpath = ".//*[@id='mainContainer']/div[7]/div[2]/div[1]/div[2]/div/div/a")
	WebElement NewProposalButton;
	
	@FindBy(xpath = ".//*[@id='BasketItem1ProductTypeId']")
	WebElement ProductTypeField;
	
	@FindBy(xpath = ".//*[@id='productSelect1']")
	WebElement ProductField;
	
	@FindBy(xpath = ".//*[@id='BasketItem1Quantity']")
	WebElement QuantityField;
	
	@FindBy(xpath = ".//*[@id='Product1Years']/select")
	WebElement DurationField;
	
	@FindBy(xpath = ".//*[@id='BasketItem1CommonName']")
	WebElement CommonNameField;
	
	@FindBy(xpath = ".//*[@id='ProposalCalculatePrices']")
	WebElement CalculatePricesButton;
	
	@FindBy(xpath = ".//*[@id='ProposalSave']")
	WebElement SaveProposalButton;
	
	
	public ProposalsPage(WebDriver driver){
		
		this.driver = driver;
		PageFactory.initElements(new AjaxElementLocatorFactory(driver, 20), this);
		//PageFactory.initElements(driver, this);
		
	}
	
	public void ValidatePage() {
		
		String Status = driver.getTitle();
		System.out.println("Page Title is:"  + Status);
		Assert.assertTrue(Status.contains("Proposals"));
		
	}
	
	public void UnIssuedTabClink(){
		
		UnIssuedTab.click();
	}
	
	public void IssueProposalTabClink(){
		
		IssueProposalTab.click();
	}
	
	public void ViewTopResult(){
		
		ViewTopResult.click();
	}
	
	public void ConfirmCheckBoxOneClink(){
		
		ConfirmCheckBoxOne.click();
	}
	
	public void ConfirmCheckBoxTwoClink(){
		
		ConfirmCheckBoxTwo.click();
	}
	
	public void IssueProposalButtonClink(){
		
		IssueProposalButton.click();
	}
	

	public void NewProposalButtonClink(){
		
		NewProposalButton.click();
	}
	
	public void ProductTypeFieldSelect(String Product){
		
		Select ProductName = new Select(ProductTypeField);
		ProductName.selectByVisibleText(Product);
	}
	
	public void ProductFieldSelect(String ProductType){
	
		Select Type = new Select(ProductField);
		Type.selectByVisibleText(ProductType);
	}
	
	public void QuantityFieldClear(){
		
		QuantityField.clear();
	}
	
	public void QuantityFieldSenkeys(String Quantity){
		
		QuantityField.sendKeys(Quantity);
	}
	
	public void DurationFieldSelect(String Duration){
		
		Select DurationNo = new Select(DurationField);
		DurationNo.selectByVisibleText(Duration);
	}
	
	public void CommonNameFieldClear(){
		
		CommonNameField.clear();
	}
	
	public void CommonNameFieldSendKeys(String CommonName){
		
		CommonNameField.sendKeys(CommonName);
	}
	
	public void CalculatePricesButtonClink(){
		
		CalculatePricesButton.click();
	}
	
	public void SaveProposalButtonButtonClink(){
		
		SaveProposalButton.click();
	}
}
