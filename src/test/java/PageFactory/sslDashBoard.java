package PageFactory;

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

import org.testng.Assert;


public class sslDashBoard extends DriverLoad {
	ExtentReports report;
	ExtentTest test;
	
	
	/*****Side Nave*******/
	@FindBy(xpath = ".//*[@class='leftMenuWrapper']/ul[1]/li[4]/a")
	WebElement MyBasketsLink;
	
	@FindBy(xpath = ".//*[@class='leftMenuWrapper']/ul[1]/li[5]/a")
	WebElement MyProductsLink;
	
	@FindBy(xpath = ".//*[@class='leftMenuWrapper']/ul[1]/li[7]/a")
	WebElement MysslCertificatessLink;
	
	@FindBy(xpath = ".//*[@class='leftMenuWrapper']/ul[1]/li[9]/a")
	WebElement MyDomainNamesLink;
	
	@FindBy(xpath = ".//*[@class='leftMenuWrapper']/ul[1]/li[9]/ul/li[1]/a/span")
	WebElement RegisterDomainLink;
	
	@FindBy(xpath = ".//*[@class='leftMenuWrapper']/ul[1]/li[17]/a")
	WebElement MyProposalsLink;
	
	@FindBy(xpath = ".//*[@class='leftMenuWrapper']/ul[1]/li[18]/a")
	WebElement MyOrderHistoryLink;
	
	@FindBy(xpath = ".//*[@class='leftMenuWrapper']/ul[1]/li[19]/a")
	WebElement MyLedgerLink;
	
	@FindBy(xpath = ".//*[@class='leftMenuWrapper']/ul[1]/li[20]/a")
	WebElement MyAccountLink;
	
	@FindBy(xpath = ".//*[@class='leftMenuWrapper']/ul[1]/li[21]/a")
	WebElement MyUsersLink;
	
	@FindBy(xpath = ".//*[@class='leftMenuWrapper']/ul[1]/li[22]/a")
	WebElement AccountEndUsersLink;
	
	
	/********Page Elements**********/
	@FindBy(xpath = ".//*[@id='mainContainer']/div[4]/div[2]/h2")
	WebElement PageHeader;
	
	
	public sslDashBoard(WebDriver driver){
		
		this.driver = driver;
		PageFactory.initElements(new AjaxElementLocatorFactory(driver, 100), this);
		//PageFactory.initElements(driver, this);
		
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
		
		MyUsersLink.click();
	}
	
	public void ClickAccountEndUsersLink() {
		
		AccountEndUsersLink.click();
	}
	
	public String PageHeaderAssert() {
		
		return PageHeader.getText();
	
	}

}
