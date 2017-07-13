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


public class sslDashBoard extends DriverLoad {
	ExtentReports report;
	ExtentTest test;
	
	
	/*****Side Nave*******/
	@FindBy(xpath = ".//*[@class='leftMenuWrapper']/ul[1]/li[3]/a")
	WebElement MyBasketsLink;
	
	@FindBy(xpath = ".//*[@class='leftMenuWrapper']/ul[1]/li[4]/a")
	WebElement MyProductsLink;
	
	@FindBy(xpath = ".//*[@class='leftMenuWrapper']/ul[1]/li[6]/a")
	WebElement MysslCertificatessLink;
	
	@FindBy(xpath = ".//*[@class='leftMenuWrapper']/ul[1]/li[8]/a")
	WebElement MyDomainNamesLink;
	
	@FindBy(xpath = ".//*[@class='leftMenuWrapper']/ul[1]/li[8]/ul/li[1]/a/span")
	WebElement RegisterDomainLink;
	
	@FindBy(xpath = ".//*[@class='leftMenuWrapper']/ul[1]/li[16]/a")
	WebElement MyProposalsLink;
	
	@FindBy(xpath = ".//*[@class='leftMenuWrapper']/ul[1]/li[17]/a")
	WebElement MyOrderHistoryLink;
	
	@FindBy(xpath = ".//*[@class='leftMenuWrapper']/ul[1]/li[18]/a")
	WebElement MyLedgerLink;
	
	@FindBy(xpath = ".//*[@class='leftMenuWrapper']/ul[1]/li[19]/a")
	WebElement MyAccountLink;
	
	@FindBy(xpath = ".//*[@class='leftMenuWrapper']/ul[1]/li[20]/a")
	WebElement MyUsersLink;
	
	@FindBy(xpath = ".//*[@class='leftMenuWrapper']/ul[1]/li[22]/a")
	WebElement AccountEndUsersLink;
	
	
	/********Page Elements**********/
	@FindBy(xpath = ".//*[@id='mainContainer']/div[4]/div[2]/h2")
	WebElement PageHeader;
	
	
	/*******SSL Certificates Sublink***/
	@FindBy(xpath = ".//*[@id='mainContainer']/div[7]/div[1]/ul/li[5]/ul/li[9]/a")
	WebElement ExternalLink;
	
	@FindBy(xpath = ".//*[@id='mainContainer']/div[4]/div[1]/ul[1]/li[6]/ul/li[2]/a")
	WebElement SearchLink;
	
	@FindBy(xpath = ".//*[@id='mainContainer']/div[4]/div[1]/ul[1]/li[6]/ul/li[5]/a")
	WebElement IssuedLink;
	
	/********Issue Certificates Page****/
	
	@FindBy(xpath = ".//*[@id='mainContainer']/div[4]/div[1]/ul[1]/li[6]/ul/li[5]/a")
	WebElement Column1;
	
	@FindBy(xpath = ".//*[@id='mainContainer']/div[4]/div[1]/ul[1]/li[6]/ul/li[5]/a")
	WebElement Column2;
	
	@FindBy(xpath = ".//*[@id='mainContainer']/div[4]/div[1]/ul[1]/li[6]/ul/li[5]/a")
	WebElement Column3;
	
	
	
	
	public sslDashBoard(WebDriver driver){
		
		this.driver = driver;
		PageFactory.initElements(new AjaxElementLocatorFactory(driver, 20), this);
		//PageFactory.initElements(driver, this);
		
	}
	
	
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
	
	public void SearchLinkClick() {
		
		SearchLink.click();
	}
	
	public void IssuedLinkClick() {
		
		IssuedLink.click();
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
	
	public void ClientDashboardValidation() {
		
		String Status = "MySSL® » Dashboard";
		Assert.assertTrue(driver.getTitle().contains(Status));
		System.out.println("Page Title is:"  + Status);
		
	}
	
	public void AdminDashboardValidation() {
		
		String Status = "Account Overview";
		System.out.println("Page Title is:"  + driver.getTitle());
		Assert.assertTrue(driver.getTitle().contains(Status));
		System.out.println("Page Title is:"  + Status);
		
	}
	
	public void ExternalLinkClick() {
		
		driver.findElement(By.xpath(".//*[@id='UserMysslLoginForm']/button")).click();
		
		ExternalLink.click();
	}

}
