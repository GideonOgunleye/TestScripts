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

import BaseUtilities.BrowserStack;

public class NavigationLinks extends BrowserStack {
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
	
	//@FindBy(xpath = ".//*[@id='mainNavigation']/li[7]/a")
	//WebElement ManageLink;
	
	@FindBy(xpath = ".//*[@id='mainNavigation']/li[7]/a")
	WebElement BecomePartnerLink;
	
	@FindBy(xpath = ".//*[@id='mainNavigation']/li[8]/a")
	WebElement MySslLink;
	
	@FindBy(xpath = ".//*[@id='mainNavigation']/li[9]/a")
	WebElement FreeTrialsLink;
	
	@FindBy(xpath = ".//*[@id='mainNavigation']/li[10]/a")
	WebElement WizardLink;
	
	@FindBy(xpath = ".//*[@id='mainNavigation']/li[11]/a")
	WebElement AboutLink;
	
	@FindBy(xpath = ".//*[@id='mainNavigation']/li[12]/a")
	WebElement SupportLink;
	
	@FindBy(xpath = ".//*[@id='mainNavigation']/li[13]/a")
	WebElement BlogLink;
	
	@FindBy(xpath = ".//*[@id='mainContainer']/div[4]/div[2]/h2")
	WebElement PageHeader;
	
	
	/********SSL Certificates SubMenu Navigation**********/
	@FindBy(xpath = ".//*[@id='special-ul']/li[1]/ul/li[1]/a/span[1]")
	WebElement SymantecLink;
	
	@FindBy(xpath = ".//*[@id='special-ul']/li[1]/ul/li[2]/a/span[1]")
	WebElement VeriSignLink;
	
	@FindBy(xpath = ".//*[@id='special-ul']/li[1]/ul/li[3]/a/span[1]")
	WebElement GeoTrustLink;
	
	@FindBy(xpath = ".//*[@id='special-ul']/li[1]/ul/li[4]/a/span[1]")
	WebElement ThawteLink;
	
	@FindBy(xpath = ".//*[@id='special-ul']/li[1]/ul/li[5]/a/span[1]")
	WebElement GlobalSignLink;
	
	@FindBy(xpath = ".//*[@id='special-ul']/li[1]/ul/li[6]/a/span[1]")
	WebElement ComodoLink;
	
	@FindBy(xpath = ".//*[@id='special-ul']/li[1]/ul/li[7]/a/span[1]")
	WebElement RapidSslLink;
	
	@FindBy(xpath = ".//*[@id='special-ul']/li[1]/ul/li[8]/a/span[1]")
	WebElement EntrustLink;
	
	@FindBy(xpath = ".//*[@id='special-ul']/li[2]/ul/li[1]/a/span[1]")
	WebElement SanSslLink;
	
	@FindBy(xpath = ".//*[@id='special-ul']/li[2]/ul/li[2]/a/span[1]")
	WebElement WildcardSslLink;
	
	@FindBy(xpath = ".//*[@id='special-ul']/li[2]/ul/li[3]/a/span[1]")
	WebElement SanWildcardSslLink;
	
	@FindBy(xpath = ".//*[@id='special-ul']/li[2]/ul/li[4]/a/span[1]")
	WebElement ECCSslLink;
	
	@FindBy(xpath = ".//*[@id='special-ul']/li[2]/ul/li[5]/a/span[1]")
	WebElement IPaddressSslLink;
	
	@FindBy(xpath = ".//*[@id='special-ul']/li[3]/ul/li[1]/a/span[1]")
	WebElement ExtendedValidationLink;
	
	@FindBy(xpath = ".//*[@id='special-ul']/li[3]/ul/li[2]/a/span[1]")
	WebElement OrganisationValidationLink;
	
	@FindBy(xpath = ".//*[@id='special-ul']/li[3]/ul/li[3]/a/span[1]")
	WebElement SymantecReadyIssuanceLink;
	
	@FindBy(xpath = ".//*[@id='special-ul']/li[3]/ul/li[4]/a/span[1]")
	WebElement DomainValidationLink;
	
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
	
	public boolean ValidatePage(String Msg){
		
		return driver.getTitle().contains(Msg);

	
	}
	
	public void PrintPageTitle() {
		
		System.out.println("Title is:" + driver.getTitle());
		

	}
	
	public void ClickSslCertificatesLink(){
		
		SslCertificatesLink.click();
		driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
		//assertTrue(driver.getTitle().contains("SSL247's SSL Certificates"));

	
	}

/*	
	public void SslCertificatesLinkTextValidation(){
		
		assertTrue(SslCertificatesLink.getText().contains("SSL Certificates"));
		
	}
*/	
	public boolean SslCertificatesLinkContains(String Text){
		
		return SslCertificatesLink.getText().contains(Text);
		
	}
	
	public void SslCertificatesLinkTextPrint(){
		
		System.out.println("Link Text is:" + SslCertificatesLink.getText());
		
	}
	
	public void ClickFreeSslLink(){
		
		FreeSslLink.click();
		driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
		//assertTrue(driver.getTitle().contains("GeoTrust Free Trial"));
	}
	
	public boolean FreeSslLinkContains(String Text){
		
		return FreeSslLink.getText().contains(Text);
		
	}
	
	public void FreeSslLinkTextPrint(){
		
		System.out.println("Link Text is:" + FreeSslLink.getText());
		
	}
	
	public void ClickProtectAndSecureLink() {
		
		ProtectAndSecureLink.click();
		driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
	}
	
	public boolean ProtectAndSecureLinkContains(String Text){
		
		return ProtectAndSecureLink.getText().contains(Text);
		
	}
	
	public void ProtectAndSecurePrintText(){
		
		System.out.println("Link Text is:" + ProtectAndSecureLink.getText());
		
	}
	
	public void ClickIdentifyLink() {
		
		IdentifyLink.click();
		driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
		//assertTrue(driver.getTitle().contains("Digital IDs from SSL247"));
	}
/*	
	public void IdentifyLinkTextValidation(){
		
		assertTrue(IdentifyLink.getText().contains("Identify & Manage"));
		
	}
*/	
	public boolean IdentifyLinkContains(String Text){
		
		return IdentifyLink.getText().contains(Text);
		
	}
	
	public void IdentifyLinkTextPrint(){
		
		System.out.println("Link Text is:" + IdentifyLink.getText());
		
	}
	
	public void ClickRegisterLink() {
		
		RegisterLink.click();
		driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
		//assertTrue(driver.getTitle().contains("Get your Domain Name Now"));
	}
/*	
	public void RegisterLinkTextValidation(){
		
		assertTrue(RegisterLink.getText().contains("Register"));
		
	}
*/	
	public boolean RegisterLinkContains(String Text){
		
		return RegisterLink.getText().contains(Text);
		
	}
	
	public void RegisterLinkTextPrint(){
		
		System.out.println("Link Text is:" + RegisterLink.getText());
		
	}
/*	
	public void ClickManageLink() {
		
		ManageLink.click();
		driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
		//assertTrue(driver.getTitle().contains("Managed Public Key Infrastructure (MPKI) Service by SSL247®"));
	}
*/	
	public void ClickBecomePartnerLink() {
		
		BecomePartnerLink.click();
		driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
		//assertTrue(driver.getTitle().contains("Grow your business by joining our partners programs!"));
	}
/*	
	public void BecomePartnerLinkTextValidation(){
		
		assertTrue(BecomePartnerLink.getText().contains("Become a Partner"));
		
	}
*/	
	public boolean BecomePartnerLinkContains(String Text){
		
		return BecomePartnerLink.getText().contains(Text);
		
	}
	
	public void BecomePartnerLinkTextPrint(){
		
		System.out.println("Link Text is:" + BecomePartnerLink.getText());
		
	}
	
	public void ClickMySslLink() {
		
		MySslLink.click();
		driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
		//assertTrue(driver.getTitle().contains("MySSL® Account Login"));
	}
/*	
	public void MySslLinkTextValidation(){
		
		assertTrue(MySslLink.getText().contains("MySSL"));
		
	}
*/	
	public boolean MySslLinkContains(String Text){
		
		return MySslLink.getText().contains(Text);
		
	}
	
	public void MySslLinkTextPrint(){
		
		System.out.println("Link Text is:" + MySslLink.getText());
		
	}
	
	public void ClickFreeTrialsLink() {
		
		FreeTrialsLink.click();
		driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
		//assertTrue(driver.getTitle().contains("Free trials"));
	}
/*	
	public void FreeTrialsLinkTextValidation(){
		
		assertTrue(FreeTrialsLink.getText().contains("Free Trials"));
		
	}
*/	
	public boolean FreeTrialsLinkContains(String Text){
		
		return FreeTrialsLink.getText().contains(Text);
		
	}
	
	public void FreeTrialsLinkTextPrint(){
		
		System.out.println("Link Text is:" + FreeTrialsLink.getText());
		
	}
	
	public void ClickWizardLink() {
		
		WizardLink.click();
		driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
		//assertTrue(driver.getTitle().contains("SSL Certificates: Buy Symantec, Thawte, Apache SSL Cert, GlobalSign, GeoTrust, RapidSSL- SSL247.co.uk "));
	}
/*	
	public void WizardLinkTextValidation(){
		
		assertTrue(WizardLink.getText().contains("Wizard"));
		
	}
*/	
	public boolean WizardLinkContains(String Text){
		
		return WizardLink.getText().contains(Text);
		
	}
	
	public void WizardLinkTextPrint(){
		
		System.out.println("Link Text is:" + WizardLink.getText());
		
	}
	
	public void ClickAboutLink() {
		
		AboutLink.click();
		driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
	}
/*	
	public void AboutLinkTextValidation(){
		
		assertTrue(AboutLink.getText().contains("About"));
		
	}
*/	
	public boolean AboutLinkContains(String Text){
		
		return AboutLink.getText().contains(Text);
		
	}
	
	public void AboutLinkTextPrint(){
		
		System.out.println("Link Text is:" + AboutLink.getText());
		
	}
	
	public void ClickSupportLink() {
		
		SupportLink.click();
		driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
		//assertTrue(driver.getTitle().contains("Help and Support - Install your SSL Certificate"));
	}
/*	
	public void SupportLinkTextValidation(){
		
		assertTrue(SupportLink.getText().contains("Support"));
		
	}
*/	
	public boolean SupportLinkContains(String Text){
		
		return SupportLink.getText().contains(Text);
		
	}
	
	public void SupportLinkTextPrint(){
		
		System.out.println("Link Text is:" + SupportLink.getText());
		
	}
	
	public void ClickBlogLink() {
		
		BlogLink.click();
		driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
		//assertTrue(driver.getTitle().contains("SSL247 Blog"));
	}
/*	
	public void BlogLinkTextValidation(){
		
		assertTrue(BlogLink.getText().contains("Blog"));
		
	}
*/	
	public boolean BlogLinkContains(String Text){
		
		return BlogLink.getText().contains(Text);
		
	}
	
	public void BlogLinkTextPrint(){
		
		System.out.println("Link Text is:" + BlogLink.getText());
		
	}
	
	
	/*
	 *-------------------- SSL Certificates Sublinks--------------------------
	 */
	
	public void SynmantecLinkClick() {
		
		driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
		Actions  actions=new Actions(driver);
	  	actions.moveToElement(SslCertificatesLink);
	  	driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
	    actions.moveToElement(SymantecLink);
	  	actions.click();
	  	actions.perform();
	  	driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
	  	//assertTrue(driver.getTitle().contains("Symantec SSL Certificates"));

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
	  	//assertTrue(driver.getTitle().contains("VeriSign SSL Certificates"));

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
	  	//PrintPageTitle();

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
	  	//PrintPageTitle();

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
	  	//PrintPageTitle();

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
	  //	PrintPageTitle();

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
	  	//PrintPageTitle();

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
	  	//PrintPageTitle();

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
	  	//PrintPageTitle();

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
	  	//PrintPageTitle();

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
	  	//PrintPageTitle();

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
	  	//PrintPageTitle();

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
	  	//PrintPageTitle();

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
	  	//PrintPageTitle();

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
	  	//PrintPageTitle();

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
	  	//PrintPageTitle();

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
	  	//PrintPageTitle();

	}
	
	public void FindAllLinks() {
		
		

	}
	
	
}
