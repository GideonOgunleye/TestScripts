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

public class AdminCertificatesPage extends DriverLoad {
	
	
	
	/*****Page Elements*******/
	@FindBy(xpath = ".//*[@id='CertificateQuery']")
	WebElement SearchField;
	
	@FindBy(xpath = ".//*[@id='CertificateField']")
	WebElement ForField;
	
	@FindBy(xpath = ".//*[@id='CertificateBrandId']")
	WebElement BrandField;
	
	@FindBy(xpath = ".//*[@id='CertificateProductId']")
	WebElement ProductField;
	
	@FindBy(xpath = ".//*[@id='CertificateStatusId']")
	WebElement StatusField;
	
	@FindBy(xpath = ".//*[@id='CertificateDisplayFree']")
	WebElement ShowFreeSSLField;
	
	@FindBy(xpath = ".//*[@id='CertificateAccountManagerId']")
	WebElement ManagerField;
	
	@FindBy(xpath = ".//*[@id='CertificateIsUninvoiced']")
	WebElement InvoicedField;
	
	@FindBy(xpath = ".//*[@id='CertificateDateRange']")
	WebElement DateSearchField;
	
	@FindBy(xpath = ".//*[@id='CertificateFrom']")
	WebElement From_Field;
	
	@FindBy(xpath = ".//*[@id='CertificateTo']")
	WebElement To_Field;
	
	@FindBy(xpath = ".//*[@id='CertificateAdminIndexForm']/div[2]/div[2]/div[5]/button[1]")
	WebElement SearchButton;
	
	@FindBy(xpath = ".//*[@id='CertificateAdminIndexForm']/div[2]/div[2]/div[5]/a")
	WebElement ClearButton;
	
	@FindBy(xpath = ".//*[@id='certificatesExport']")
	WebElement ExportButton;
	
	@FindBy(xpath = ".//*[@id='DataTables_Table_0_wrapper']/div[1]/div[1]")
	WebElement SearchResult;
	
	public AdminCertificatesPage(WebDriver driver){
		
		this.driver = driver;
		PageFactory.initElements(new AjaxElementLocatorFactory(driver, 100), this);
		//PageFactory.initElements(driver, this);
		
	}

	
	
	
	public void SearchFieldSendKeys(String Query){
		
		SearchField.sendKeys(Query);
		driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);

	}
	
	public void ForFieldSelect(String List){
		
		Select Options = new Select(ForField);
		Options.selectByVisibleText(List);

	}
	
	public void StatusFieldSelect(String List){
		
		Select StatusOptions = new Select(StatusField);
		StatusOptions.selectByVisibleText(List);

	}
	
	public void SearchButtonClick(){
		
		SearchButton.click();
		driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);

	
	}
	
	public String SearchResultValidate(){
		
		return SearchResult.getText();
		
		
		/*	
			String Message = "records per page";
			
			if (SearchResult.getText().contains(Message)) {
				
				
			}else {
				
				System.out.println("Search Result Not Present");
			}
		*/	
	
	}
	

/*
	public void ProductsLinkMouse(){
		
		Actions  actions=new Actions(driver);
	  	actions.moveToElement(ProductsLink);
		driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
		assertTrue(driver.getTitle().contains("Products for United Kingdom"));

	
	}
	
	public void CertificatesLinkClick(){
		
		Actions  actions=new Actions(driver);
		actions.moveToElement(CertificatesLink);
	  	actions.click();
	  	actions.perform();
		driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
		assertTrue(driver.getTitle().contains("Products for United Kingdom"));

	
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
