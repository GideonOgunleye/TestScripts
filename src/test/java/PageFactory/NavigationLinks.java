package PageFactory;

import static org.testng.Assert.assertTrue;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class NavigationLinks extends DriverLoad {
	ExtentReports report;
	ExtentTest test;
	
	/*****Main Menu*******/
	@FindBy(xpath = ".//*[@id='mainNavigation']/li[2]/a")
	WebElement SslCertificatesLink;
	
	@FindBy(xpath = ".//*[@id='mainNavigation']/li[3]/a")
	WebElement FreeSslLink;
	
	@FindBy(xpath = ".//*[@id='mainNavigation']/li[4]/a")
	WebElement ProtectAndSecureLink;
	
	@FindBy(xpath = ".//*[@id='mainNavigation']/li[5]/a")
	WebElement IdentifyLink;
	
	@FindBy(xpath = ".//*[@id='mainNavigation']/li[6]/a")
	WebElement RegisterLink;
	
	@FindBy(xpath = ".//*[@id='mainNavigation']/li[7]/a")
	WebElement ManageLink;
	
	@FindBy(xpath = ".//*[@id='mainNavigation']/li[8]/a")
	WebElement BecomePartnerLink;
	
	@FindBy(xpath = ".//*[@id='mainNavigation']/li[9]/a")
	WebElement MySslLink;
	
	@FindBy(xpath = ".//*[@id='mainNavigation']/li[10]/a")
	WebElement FreeTrialsLink;
	
	@FindBy(xpath = ".//*[@id='mainNavigation']/li[11]/a")
	WebElement WizardLink;
	
	@FindBy(xpath = ".//*[@id='mainNavigation']/li[12]/a")
	WebElement AboutLink;
	
	@FindBy(xpath = ".//*[@id='mainNavigation']/li[13]/a")
	WebElement SupportLink;
	
	@FindBy(xpath = ".//*[@id='mainNavigation']/li[14]/a")
	WebElement BlogLink;
	
	@FindBy(xpath = ".//*[@id='mainContainer']/div[4]/div[2]/h2")
	WebElement PageHeader;
	
	
	/********SSL Certificates SubMenu Navigation**********/
	@FindBy(xpath = ".//*[@id='special-ul']/li[1]/ul/li[1]/a/span[1]")
	WebElement SymantecLink;
	
	@FindBy(xpath = ".//*[@id='special-ul']/li[1]/ul/li[2]/a/span[1]")
	WebElement VeriSignLink;
	
	
	/********Protect and Secure SubMenu Navigation**********/
	
	
	/********Identify SubMenu Navigation**********/
	
	
	/********Register SubMenu Navigation**********/
	
	
	/********Manage SubMenu Navigation**********/
	
	
	/********Become a Partner SubMenu Navigation**********/
	
	
	/********My SSL SubMenu Navigation**********/
	
	
	/********Free Trials SubMenu Navigation**********/
	
	
	/********About SubMenu Navigation**********/
	
	
	/********Support SubMenu Navigation**********/
	
	
	
	
	
	public NavigationLinks(WebDriver driver){
		
		this.driver = driver;
		PageFactory.initElements(new AjaxElementLocatorFactory(driver, 100), this);
		//PageFactory.initElements(driver, this);
		
	}
	
	public void ClickSslCertificatesLink(){
		
		SslCertificatesLink.click();
		driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
		assertTrue(driver.getTitle().contains("SSL247's SSL Certificates"));

	
	}
	
	public void ClickFreeSslLink(){
		
		FreeSslLink.click();
		driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
		assertTrue(driver.getTitle().contains("GeoTrust Free Trial"));
	}
	
	public void ClickProtectAndSecureLink() {
		
		ProtectAndSecureLink.click();
		driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
		assertTrue(driver.getTitle().contains("Penetration Testing: Advanced professional testing by accredited experts"));
	}
	
	public void ClickIdentifyLink() {
		
		IdentifyLink.click();
		driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
		assertTrue(driver.getTitle().contains("Digital IDs from SSL247"));
	}
	
	public void ClickRegisterLink() {
		
		RegisterLink.click();
		driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
		assertTrue(driver.getTitle().contains("Get your Domain Name Now"));
	}
	
	public void ClickManageLink() {
		
		ManageLink.click();
		driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
		assertTrue(driver.getTitle().contains("Managed Public Key Infrastructure (MPKI) Service by SSL247®"));
	}
	
	public void ClickBecomePartnerLink() {
		
		BecomePartnerLink.click();
		driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
		assertTrue(driver.getTitle().contains("Grow your business by joining our partners programs!"));
	}
	
	public void ClickMySslLink() {
		
		MySslLink.click();
		driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
		assertTrue(driver.getTitle().contains("MySSL® Account Login"));
	}
	
	public void ClickFreeTrialsLink() {
		
		FreeTrialsLink.click();
		driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
		assertTrue(driver.getTitle().contains("Free trials"));
	}
	
	public void ClickWizardLink() {
		
		WizardLink.click();
		driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
		assertTrue(driver.getTitle().contains("SSL Certificates: Buy Symantec, Thawte, Apache SSL Cert, GlobalSign, GeoTrust, RapidSSL- SSL247.co.uk "));
	}
	
	public void ClickAboutLink() {
		
		AboutLink.click();
		driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
		assertTrue(driver.getTitle().contains("About SSL247® – The Web Security Consultants"));
	}
	
	public void ClickSupportLink() {
		
		SupportLink.click();
		driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
		assertTrue(driver.getTitle().contains("Help and Support - Install your SSL Certificate"));
	}
	
	public void ClickBlogLink() {
		
		BlogLink.click();
		driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
		assertTrue(driver.getTitle().contains("SSL247 Blog"));
	}
	
	public void ClickSynmantecLink() {
		
		driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
		Actions  actions=new Actions(driver);
	  	actions.moveToElement(SslCertificatesLink);
	  	driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
	    actions.moveToElement(SymantecLink);
	  	actions.click();
	  	actions.perform();
	  	driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
	  	assertTrue(driver.getTitle().contains("Symantec SSL Certificates"));

	}
	
	public void ClickVeriSignLink() {
		
		driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
		Actions  actions=new Actions(driver);
	  	actions.moveToElement(SslCertificatesLink);
	  	driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
	    actions.moveToElement(VeriSignLink);
	  	actions.click();
	  	actions.perform();
	  	driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
	  	assertTrue(driver.getTitle().contains("VeriSign SSL Certificates"));

	}
}
