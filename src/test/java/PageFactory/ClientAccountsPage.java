package PageFactory;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
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


public class ClientAccountsPage extends DriverLoad {
	ExtentReports report;
	ExtentTest test;
	
	
	/********Proposal Page*******/
	@FindBy(xpath = ".//*[@id='AccountQuery']")
	WebElement SearchQueryField;
	
	@FindBy(xpath = ".//*[@id='AccountAdminIndexForm']/div[2]/div[1]/button")
	WebElement UpdateButton;
	
	@FindBy(xpath = ".//*[@id='DataTables_Table_0']/tbody/tr[1]/td[1]")
	WebElement ColumnOneResult;
	
	@FindBy(xpath = ".//*[@id='FormAdminIssue']/div[3]/div[1]/div/div/button")
	WebElement ConfirmCheckBoxOne;
	
	@FindBy(xpath = ".//*[@id='FormAdminIssue']/div[3]/div[2]/div/div[2]/button")
	WebElement ConfirmCheckBoxTwo;
	
	@FindBy(xpath = ".//*[@id='adminIssueInvoiceValidation']")
	WebElement IssueProposalButton;
	
	
	public ClientAccountsPage(WebDriver driver){
		
		this.driver = driver;
		PageFactory.initElements(new AjaxElementLocatorFactory(driver, 20), this);
		//PageFactory.initElements(driver, this);
		
	}
	
	public void ValidatePage() {
		
		String Status = driver.getTitle();
		System.out.println("Page Title is:"  + Status);
		Assert.assertTrue(Status.contains("SSL247 Accounts"));
		
	}
	
	public void SearchQueryFieldFill(String search){
		
		SearchQueryField.sendKeys(search);
	}
	
	public void UpdateButtonClink(){
		
		UpdateButton.click();
	}
	
	public void ValidateResults(String Account) {
		
		Assert.assertTrue(ColumnOneResult.getText().contains(Account));
		
	}
	
	public void ViewAccount(){
		
		Actions  Mouse=new Actions(driver);
	    WebElement Dropdown=driver.findElement(By.xpath(".//*[@id='DataTables_Table_0']/tbody/tr[1]/td[9]/div/button"));
	    Mouse.click(Dropdown);
	    driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
	    WebElement EyeIcon=driver.findElement(By.xpath(".//*[@id='DataTables_Table_0']/tbody/tr[1]/td[9]/div/ul/li[1]/a"));
	    Mouse.moveToElement(EyeIcon);
	    Mouse.click();
	    Mouse.perform();
	}
	
	
	
	
/*	
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
*/	

}
