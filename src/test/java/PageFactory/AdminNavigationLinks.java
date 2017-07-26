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
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import BaseUtilities.BrowserStack;
import BaseUtilities.DriverLoad;

public class AdminNavigationLinks extends DriverLoad {
	
	
	/*****Main Menu*******/
	@FindBy(xpath = ".//*[@id='mainNavigation']/li[2]/a")
	WebElement ClientsAccountsLink;
	
	@FindBy(xpath = ".//*[@id='mainNavigation']/li[3]/a")
	WebElement ProductsLink;
	
	/********Clients Accounts SubMenu Navigation**********/
	@FindBy(xpath = ".//*[@id='mainNavigation']/li[2]/ul/li[1]/a")
	WebElement NewAccountLink;
	
	
	

	
	/********Products SubMenu Navigation**********/
	@FindBy(xpath = ".//*[@id='mainNavigation']/li[3]/ul/li[1]/a")
	WebElement CertificatesLink;
	
	
	/********Identify SubMenu Navigation**********/
	
	
	/********Register SubMenu Navigation**********/
	
	
	/********Manage SubMenu Navigation**********/
	
	
	/********Become a Partner SubMenu Navigation**********/
	
	
	/********My SSL SubMenu Navigation**********/
	
	
	/********Free Trials SubMenu Navigation**********/
	
	
	/********About SubMenu Navigation**********/
	
	
	/********Support SubMenu Navigation**********/
	
	
	
	
	
	public AdminNavigationLinks(WebDriver driver){
		
		this.driver = driver;
		PageFactory.initElements(new AjaxElementLocatorFactory(driver, 100), this);
		//PageFactory.initElements(driver, this);
		
	}

	
	public void ClientsAccountsLinkClick(){
		
		ClientsAccountsLink.click();
		driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
		assertTrue(driver.getTitle().contains("SSL247 Accounts"));

	
	}
	
	
	
	public void  ProductsLinkMouse(){
		
		Actions  actions=new Actions(driver);
		actions.moveToElement(ProductsLink).build().perform();
	  	//actions.perform();
	  	//actions.moveToElement(ProductsLink);
		//assertTrue(driver.getTitle().contains("Products for United Kingdom"));
		
	
	}
	
	public void CertificatesLinkClick(){
		
		Actions  actions=new Actions(driver);
		actions.moveToElement(CertificatesLink);
	  	actions.click();
	  	actions.perform();
		driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
		//assertTrue(driver.getTitle().contains("Products for United Kingdom"));
	}
	
	public void  ClientsAccountsLinkMouse(){
		
		Actions  actions=new Actions(driver);
		actions.moveToElement(ClientsAccountsLink).build().perform();
	  	//actions.perform();
	  	//actions.moveToElement(ProductsLink);
		//assertTrue(driver.getTitle().contains("Products for United Kingdom"));
		
	
	}
	
	public void NewAccountLinkClick(){
		
		Actions  actions=new Actions(driver);
		actions.moveToElement(NewAccountLink);
	  	actions.click();
	  	actions.perform();
		driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
		//assertTrue(driver.getTitle().contains("Products for United Kingdom"));
	}
	
/*	
	public boolean ValidatePage(String Msg){
		
		return driver.getTitle().contains(Msg);

	
	}
	
	public void PrintPageTitle() {
		
		System.out.println("Title is:" + driver.getTitle());
		

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
	
	
	
	
	public void SynmantecLinkClick() {
		
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
	
	public void VeriSignLinkClick() {
		
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
	
	public void GeoTrustLinkClick() {
		
		driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
		Actions  actions=new Actions(driver);
	  	actions.moveToElement(SslCertificatesLink);
	  	driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
	    actions.moveToElement(GeoTrustLink);
	  	actions.click();
	  	actions.perform();
	  	driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
	  	PrintPageTitle();

	}
	
	public void ThawteLinkClick() {
		
		driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
		Actions  actions=new Actions(driver);
	  	actions.moveToElement(SslCertificatesLink);
	  	driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
	    actions.moveToElement(ThawteLink);
	  	actions.click();
	  	actions.perform();
	  	driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
	  	PrintPageTitle();

	}
	
	public void GlobalSignLinkClick() {
		
		driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
		Actions  actions=new Actions(driver);
	  	actions.moveToElement(SslCertificatesLink);
	  	driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
	    actions.moveToElement(GlobalSignLink);
	  	actions.click();
	  	actions.perform();
	  	driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
	  	PrintPageTitle();

	}
	
	public void ComodoLinkClick() {
		
		driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
		Actions  actions=new Actions(driver);
	  	actions.moveToElement(SslCertificatesLink);
	  	driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
	    actions.moveToElement(ComodoLink);
	  	actions.click();
	  	actions.perform();
	  	driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
	  	PrintPageTitle();

	}
	
	public void RapidSslLinkClick() {
		
		driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
		Actions  actions=new Actions(driver);
	  	actions.moveToElement(SslCertificatesLink);
	  	driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
	    actions.moveToElement(RapidSslLink);
	  	actions.click();
	  	actions.perform();
	  	driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
	  	PrintPageTitle();

	}
	
	public void EntrustLinkClick() {
		
		driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
		Actions  actions=new Actions(driver);
	  	actions.moveToElement(SslCertificatesLink);
	  	driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
	    actions.moveToElement(EntrustLink);
	  	actions.click();
	  	actions.perform();
	  	driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
	  	PrintPageTitle();

	}
	
	public void SanSslLinkClick() {
		
		driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
		Actions  actions=new Actions(driver);
	  	actions.moveToElement(SslCertificatesLink);
	  	driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
	    actions.moveToElement(SanSslLink);
	  	actions.click();
	  	actions.perform();
	  	driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
	  	PrintPageTitle();

	}
	
	public void WildcardSslLinkClick() {
		
		driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
		Actions  actions=new Actions(driver);
	  	actions.moveToElement(SslCertificatesLink);
	  	driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
	    actions.moveToElement(WildcardSslLink);
	  	actions.click();
	  	actions.perform();
	  	driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
	  	PrintPageTitle();

	}
	
	public void SanWildcardSslLinkClick() {
		
		driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
		Actions  actions=new Actions(driver);
	  	actions.moveToElement(SslCertificatesLink);
	  	driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
	    actions.moveToElement(SanWildcardSslLink);
	  	actions.click();
	  	actions.perform();
	  	driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
	  	PrintPageTitle();

	}
	
	public void ECCSslLinkClick() {
		
		driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
		Actions  actions=new Actions(driver);
	  	actions.moveToElement(SslCertificatesLink);
	  	driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
	    actions.moveToElement(ECCSslLink);
	  	actions.click();
	  	actions.perform();
	  	driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
	  	PrintPageTitle();

	}
	
	public void IPaddressSslLinkClick() {
		
		driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
		Actions  actions=new Actions(driver);
	  	actions.moveToElement(SslCertificatesLink);
	  	driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
	    actions.moveToElement(IPaddressSslLink);
	  	actions.click();
	  	actions.perform();
	  	driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
	  	PrintPageTitle();

	}
	
	public void ExtendedValidationLinkClick() {
		
		driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
		Actions  actions=new Actions(driver);
	  	actions.moveToElement(SslCertificatesLink);
	  	driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
	    actions.moveToElement(ExtendedValidationLink);
	  	actions.click();
	  	actions.perform();
	  	driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
	  	PrintPageTitle();

	}
	
	public void OrganisationValidationLinkClick() {
		
		driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
		Actions  actions=new Actions(driver);
	  	actions.moveToElement(SslCertificatesLink);
	  	driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
	    actions.moveToElement(OrganisationValidationLink);
	  	actions.click();
	  	actions.perform();
	  	driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
	  	PrintPageTitle();

	}
	
	public void SymantecReadyIssuanceLinkClick() {
		
		driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
		Actions  actions=new Actions(driver);
	  	actions.moveToElement(SslCertificatesLink);
	  	driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
	    actions.moveToElement(SymantecReadyIssuanceLink);
	  	actions.click();
	  	actions.perform();
	  	driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
	  	PrintPageTitle();

	}
	
	public void DomainValidationLinkClick() {
		
		driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
		Actions  actions=new Actions(driver);
	  	actions.moveToElement(SslCertificatesLink);
	  	driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
	    actions.moveToElement(DomainValidationLink);
	  	actions.click();
	  	actions.perform();
	  	driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
	  	PrintPageTitle();

	}
*/	
	
}
