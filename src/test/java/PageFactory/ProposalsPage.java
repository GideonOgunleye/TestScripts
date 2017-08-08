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
	
	@FindBy(xpath = ".//*[@id='mainContainer']/div[6]/div[2]/div[2]/a[5]")
	WebElement IssueProposalTabFR;
	
	@FindBy(xpath = ".//*[@id='FormAdminIssue']/div[3]/div[1]/div/div/button")
	WebElement ConfirmCheckBoxOne;
	
	@FindBy(xpath = ".//*[@id='FormAdminIssue']/div[3]/div[2]/div/div[2]/button")
	WebElement ConfirmCheckBoxTwo;
	
	@FindBy(xpath = ".//*[@id='adminIssueInvoiceValidation']")
	WebElement IssueProposalButton;
	
	@FindBy(xpath = ".//*[@id='mainContainer']/div[7]/div[2]/div[1]/div[2]/div/div/a")
	WebElement NewProposalButton;
	
	@FindBy(xpath = ".//*[@id='mainContainer']/div[6]/div[2]/div[1]/div[2]/div/div/a")
	WebElement NewProposalButton2;
	
	@FindBy(xpath = ".//*[@id='BasketItem1ProductTypeId']")
	WebElement ProductTypeField;
	
	@FindBy(xpath = ".//*[@id='productSelect1']")
	WebElement ProductField;
	
	@FindBy(xpath = ".//*[@id='productSelect2']")
	WebElement ProductField2;
	
	@FindBy(xpath = ".//*[@id='BasketItem1Quantity']")
	WebElement QuantityField;
	
	@FindBy(xpath = ".//*[@id='BasketItem2Quantity']")
	WebElement QuantityField2;
	
	@FindBy(xpath = ".//*[@id='Product1Years']/select")
	WebElement DurationField;
	
	@FindBy(xpath = ".//*[@id='Product2Years']/select")
	WebElement DurationField2;
	
	@FindBy(xpath = ".//*[@id='Product1Licenses']/select")
	WebElement LicenseField;
	
	@FindBy(xpath = ".//*[@id='BasketItem1CommonName']")
	WebElement CommonNameField;
	
	@FindBy(xpath = ".//*[@id='BasketItem2CommonName']")
	WebElement CommonNameField2;
	
	@FindBy(xpath = ".//*[@id='ProposalCalculatePrices']")
	WebElement CalculatePricesButton;
	
	@FindBy(xpath = ".//*[@id='ProposalSave']")
	WebElement SaveProposalButton;
	
	@FindBy(xpath = ".//*[@class='stdContentWrapper']/div[2]/a[4]")
	WebElement ConvertToInvoiceButton;
	
	@FindBy(xpath = ".//*[@id='adminIssueInvoiceValidation']")
	WebElement IssueInvoiceButton;
	
	@FindBy(xpath = ".//*[@id='BasketAdminAddForm']/div[4]/a")
	WebElement AddAnotherProductButton;
	
	@FindBy(xpath = ".//*[@id='AdminInvoiceIssueUserId']")
	WebElement MemberOfStaffField;
	
	@FindBy(xpath = ".//*[@id='FormAdminIssue']/div[3]/div[2]/div/div/button")
	WebElement IssuInvoiceCheckbox1;
	
	@FindBy(xpath =".//*[@id='FormAdminIssue']/div[3]/div[4]/div/div[2]/button" )
	WebElement IssueInvoiceCheckbox2;
	
	@FindBy(xpath = ".//*[@id='mainContainer']/div[7]/div[2]/div[2]/a[5]")
	WebElement IssueInvoiceTab;
	
	@FindBy(xpath = ".//*[@id='InvoicePoDoc']")
	WebElement PoDocumentsField;
	
	@FindBy(xpath = ".//*[@id='issueInvoiceModal']/form[1]/div[3]/div[7]/button")
	WebElement PoDocumentCheckbox;
	
	
	
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
	
	public void IssueProposalTabFRClink(){
		
		IssueProposalTabFR.click();
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
	
	public void NewProposalButton2Clink(){
		
		NewProposalButton2.click();
	}
	
	public void ProductTypeFieldSelect(String Product){
		
		Select ProductName = new Select(ProductTypeField);
		ProductName.selectByVisibleText(Product);
	}
	
	public void ProductFieldSelect(String ProductType){
	
		Select Type = new Select(ProductField);
		Type.selectByVisibleText(ProductType);
	}
	
	public void ProductFieldSelect2(String ProductType){
		
		Select Type = new Select(ProductField);
		Type.selectByVisibleText(ProductType);
	}
	
	public void QuantityFieldClear(){
		
		QuantityField.clear();
	}
	
	public void QuantityFieldSenkeys(String Quantity){
		
		QuantityField.sendKeys(Quantity);
	}
	
	public void QuantityField2Clear(){
		
		QuantityField2.clear();
	}
	
	public void QuantityField2Senkeys(String Quantity){
		
		QuantityField2.sendKeys(Quantity);
	}
	
	
	
	public void DurationFieldSelect(String Duration){
		
		Select DurationNo = new Select(DurationField);
		DurationNo.selectByVisibleText(Duration);
	}
	
	public void DurationField2Select(String Duration){
		
		Select DurationNo = new Select(DurationField);
		DurationNo.selectByVisibleText(Duration);
	}
	
	public void LicenseFieldSelect(String Number){
		
		Select DurationNo = new Select(LicenseField);
		DurationNo.selectByVisibleText(Number);
	}
	
	public void CommonNameFieldClear(){
		
		CommonNameField.clear();
	}
	
	public void CommonNameFieldSendKeys(String CommonName){
		
		CommonNameField.sendKeys(CommonName);
	}
	
	public void CommonNameField2Clear(){
		
		CommonNameField.clear();
	}
	
	public void CommonNameField2SendKeys(String CommonName){
		
		CommonNameField.sendKeys(CommonName);
	}
	
	public void CalculatePricesButtonClink(){
		
		CalculatePricesButton.click();
	}
	
	public void SaveProposalButtonClink(){
		
		SaveProposalButton.click();
	}
	
	public void ConvertToInvoiceButtonClink(){
		
		ConvertToInvoiceButton.click();
	}
	
	public void AddAnotherProductButtonClink(){
		
		AddAnotherProductButton.click();
	}
	
	public void IssueTabClink(){
		
		IssueInvoiceTab.click();
	}
	
	public void IssueInvoiceButtonClink(){
		
		IssueInvoiceButton.click();
	}
	
	
	public void MemberOfStaffFieldSelect(String Name){
		
		Select DurationNo = new Select(MemberOfStaffField);
		DurationNo.selectByVisibleText(Name);
	}
	
	public void PoDocumentFieldSelect(){
		
		Select DurationNo = new Select(PoDocumentsField);
		//DurationNo.selectByVisibleText(DocName);
		DurationNo.selectByIndex(3);
	}
	
	public void IssueInvoiceCheckbox1Clink(){
		
		IssuInvoiceCheckbox1.click();
	}
	
	public void IssueInvoiceCheckbox2Clink(){
		
		IssueInvoiceCheckbox2.click();
	}
	
	public void PoDocumentCheckboxClink(){
		
		PoDocumentCheckbox.click();
	}
	
}
