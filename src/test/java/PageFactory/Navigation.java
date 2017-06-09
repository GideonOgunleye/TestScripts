package PageFactory;

import static org.testng.Assert.assertTrue;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;
import org.testng.annotations.Test;

public class Navigation extends DriverLoad {
	
	
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
	
	
	
	/********SSL Certificates SubMenu Navigation**********/
	@FindBy(xpath = ".//*[@id='mainContainer']/div[4]/div[2]/h2")
	WebElement PageHeader;
	
	
	/********Protect and Secure SubMenu Navigation**********/
	
	
	/********Identify SubMenu Navigation**********/
	
	
	/********Register SubMenu Navigation**********/
	
	
	/********Manage SubMenu Navigation**********/
	
	
	/********Become a Partner SubMenu Navigation**********/
	
	
	/********My SSL SubMenu Navigation**********/
	
	
	/********Free Trials SubMenu Navigation**********/
	
	
	/********About SubMenu Navigation**********/
	
	
	/********Support SubMenu Navigation**********/
	
	
	
	
	
	public Navigation(WebDriver driver){
		
		this.driver = driver;
		PageFactory.initElements(new AjaxElementLocatorFactory(driver, 100), this);
		//PageFactory.initElements(driver, this);
		
	}
	
	public void ClickSslCertificatesLink(){
		
		SslCertificatesLink.click();
		//driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
		//assertTrue(driver.getTitle().contains("SSL247's  SSL Certificates"));
	
	}
	
	public void ClickFreeSslLink(){
		
		FreeSslLink.click();
	}
	
	public void ClickProtectAndSecureLink() {
		
		ProtectAndSecureLink.click();
	}
	
	public void ClickIdentifyLink() {
		
		IdentifyLink.click();
	}
	
	public void ClickRegisterLink() {
		
		RegisterLink.click();
	}
	
	public void ClickManageLink() {
		
		ManageLink.click();
	}
	
	public void ClickBecomePartnerLink() {
		
		BecomePartnerLink.click();
	}
	
	public void ClickMySslLink() {
		
		MySslLink.click();
	}
	
	public void ClickFreeTrialsLink() {
		
		FreeTrialsLink.click();
	}
	
	public void ClickWizardLink() {
		
		WizardLink.click();
	}
	
	public void ClickAboutLink() {
		
		AboutLink.click();
	}
	
	public void ClickSupportLink() {
		
		SupportLink.click();
	}
	
	public void ClickBlogLink() {
		
		BlogLink.click();
	}
}
