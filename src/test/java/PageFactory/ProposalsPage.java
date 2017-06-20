package PageFactory;

import java.util.concurrent.TimeUnit;

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
	
	/*
	public boolean PageIsVisible() {
		
		return PageHeader.isDisplayed();
		
	}

	
	
	public void ClickMyBasketsLink(){
		
		MyBasketsLink.click();
	}
	
	public void ClickMyProductsLink(){
		
		MyProductsLink.click();
	}
	
	public void ClickMysslCertificatessLink() {
		
		MysslCertificatessLink.click();
	}
	
	public void ClickMyDomainNamesLink() {
		
		MyDomainNamesLink.click();
	}
	
	public void ClickRegisterDomainLink() {
		
		RegisterDomainLink.click();
	}
	
	public void ClickMyProposalsLink() {
		
		MyProposalsLink.click();
	}
	
	public void ClickMyOrderHistoryLink() {
		
		MyOrderHistoryLink.click();
	}
	
	public void ClickMyLedgerLink() {
		
		MyLedgerLink.click();
	}
	
	public void ClickMyAccountLink() {
		
		MyAccountLink.click();
	}
	
	public void ClickMyUsersLink() {
		
		JavascriptExecutor jse = (JavascriptExecutor)driver;
		jse.executeScript("window.scrollBy(0,250)", "");
		MyUsersLink.click();
	}
	
	public void ClickAccountEndUsersLink() {
		
		AccountEndUsersLink.click();
	}
	
	public void PageHeaderAssert() {
		
		String Status = driver.getTitle();
		//Assert.assertTrue(Status.contains("MySSL® » Dashboard"));
		System.out.println("Page Title is:"  + Status);
		
	}
	
	*/

}
