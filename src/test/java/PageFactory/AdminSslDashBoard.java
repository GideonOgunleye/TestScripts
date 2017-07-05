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


public class AdminSslDashBoard extends DriverLoad {
	ExtentReports report;
	ExtentTest test;
	
	
	/*****Side Nave*******/
	
	@FindBy(xpath = ".//*[@class='leftMenuWrapper']/ul[1]/li[4]")
	WebElement MyProductsLink;
	
	@FindBy(xpath = ".//*[@class='leftMenuWrapper']/ul[1]/li[5]/a")
	WebElement MysslCertificatessLink;
	
	@FindBy(xpath = ".//*[@class='leftMenuWrapper']/ul[1]/li[6]/a")
	WebElement MyDomainNamesLink;
	
	@FindBy(xpath = ".//*[@class='leftMenuWrapper']/ul[1]/li[17]/a")
	WebElement ProposalsLink;
	
	@FindBy(xpath = ".//*[@class='leftMenuWrapper']/ul[1]/li[18]/a")
	WebElement LedgerLink;
	
	@FindBy(xpath = ".//*[@class='leftMenuWrapper']/ul[1]/li[22]/a")
	WebElement AccountEndUsersLink;
	
	
	/********Page Elements**********/
	@FindBy(xpath = ".//*[@id='mainContainer']/div[4]/div[2]/h2")
	WebElement PageHeader;
	
	
	/*******SSL Certificates Sublink***/
	@FindBy(xpath = ".//*[@class='leftMenuWrapper']/ul/li[5]/ul/li[9]/a")
	WebElement ExternalLink;
	
	@FindBy(xpath = ".//*[@class='leftMenuWrapper']/ul/li[5]/ul/li[1]/a")
	WebElement SearchLink;
	
	@FindBy(xpath = ".//*[@class='leftMenuWrapper']/ul/li[5]/ul/li[2]/a")
	WebElement IncompleteLink;
	
	/********Certificates Page**********/
	@FindBy(xpath = ".//*[@id='CertificateAdminAccountIndexForm']/div[2]/div/div[2]/div/a[7]")
	WebElement BulkEditContactsButton;
	
	@FindBy(xpath = ".//*[@id='CertificateAdminEditForm']/div[2]/div[2]/ul/li[2]/a")
	WebElement AdminTab;
	
	
	/**********Bulk Edit Certificates Page**************/
	@FindBy(xpath = ".//*[@id='CertificateAdminAccountEditContactsForm']/table/thead/tr/th[5]/label")
	WebElement AdminContactCheckbox;
	
	@FindBy(xpath = ".//*[@id='CertificateTechContact']")
	WebElement ContactField;
	
	@FindBy(xpath = ".//*[@id='CertificateAdminAccountEditContactsForm']/div[3]/button")
	WebElement UpdateCertificateButton;
	
	@FindBy(xpath = ".//*[@id='CertificateAdminContact']")
	WebElement AccountAdminContactField;
	
	@FindBy(xpath = ".//*[@id='CertificateAdminTitle']/option[5]")
	WebElement OptionMiss;
	
	@FindBy(xpath = ".//*[@id='CertificateTechRegion']")
	WebElement RegionField;
	
	
	/*****Users Page Elements******/
	@FindBy(xpath = ".//*[@id='mainContainer']/div[7]/div[2]/div[2]/div[1]/div/address/strong[1]")
	WebElement User1_Link;
	
	@FindBy(xpath = ".//*[@id='mainContainer']/div[7]/div[2]/div[2]/div[1]/div/address/div[2]/div/button")
	WebElement User1_ActionButton;
	
	@FindBy(xpath = ".//*[@id='mainContainer']/div[7]/div[2]/div[2]/div[1]/div/address/div[2]/div/ul/li[1]/a")
	WebElement User1_EditLink;
	
	@FindBy(xpath = ".//*[@id='mainContainer']/div[7]/div[2]/div[2]/div[2]/div/address/strong[1]")
	WebElement User2_Link;
	
	@FindBy(xpath = ".//*[@id='mainContainer']/div[7]/div[2]/div[2]/div[2]/div/address/div[2]/div/button")
	WebElement User2_ActionButton;
	
	@FindBy(xpath = ".//*[@id='mainContainer']/div[7]/div[2]/div[2]/div[2]/div/address/div[2]/div/ul/li[1]/a")
	WebElement User2_EditLink;
	
	@FindBy(xpath = ".//*[@id='mainContainer']/div[7]/div[2]/div[2]/div[3]/div/address/strong[1]")
	WebElement User3_Link;
	
	@FindBy(xpath = ".//*[@id='mainContainer']/div[7]/div[2]/div[2]/div[3]/div/address/div[2]/div/button")
	WebElement User3_ActionButton;
	
	@FindBy(xpath = ".//*[@id='mainContainer']/div[7]/div[2]/div[2]/div[3]/div/address/div[2]/div/ul/li[1]/a")
	WebElement User3_EditLink;
	
	@FindBy(xpath = ".//*[@id='mainContainer']/div[7]/div[2]/div[2]/div[4]/div/address/strong[1]")
	WebElement User4_Link;
	
	@FindBy(xpath = ".//*[@id='mainContainer']/div[7]/div[2]/div[2]/div[]/div/address/div[2]/div/button")
	WebElement User4_ActionButton;
	
	@FindBy(xpath = ".//*[@id='mainContainer']/div[7]/div[2]/div[2]/div[1]/div/address/div[2]/div/ul/li[1]/a")
	WebElement User4_EditLink;
	
	
	/********Edit User Page**********/
	@FindBy(xpath = ".//*[@id='UserAccessLevel']")
	WebElement AccessLevelField;
	
	@FindBy(xpath = ".//*[@id='UserAdminEditForm']/div[3]/ul/li[2]/a")
	WebElement OptionalDetailsTab;
	
	@FindBy(xpath = ".//*[@id='UserState']")
	WebElement StateField;
	
	@FindBy(xpath = ".//*[@id='UserAdminEditForm']/div[2]/button")
	WebElement SubmitChangesButton;
	
	/********Incomplete Certificates Page***************/
	@FindBy(xpath = ".//*[@id='mainContainer']/div[7]/div[2]/div/table/tbody/tr[1]/td[8]/a/i")
	WebElement FirstCertEditIcon;
	
	
	
	public AdminSslDashBoard(WebDriver driver){
		
		this.driver = driver;
		PageFactory.initElements(new AjaxElementLocatorFactory(driver, 20), this);
		//PageFactory.initElements(driver, this);
		
	}
	
	
	public boolean PageIsVisible() {
		
		return PageHeader.isDisplayed();
		
	}

	
	public void ClickMyProductsLink(){
		
		MyProductsLink.click();
	}
	
	public void ClickMysslCertificatessLink() {
		
		MysslCertificatessLink.click();
	}
	
	public void ExternalLinkClick() {
		
		ExternalLink.click();
	}
	
	public void SearchLinkClick() {
		
		SearchLink.click();
	}
	
	public void IncompleteLinkClick() {
		
		IncompleteLink.click();
	}
	
	public void FirstCertEditIconClick() {
		
		FirstCertEditIcon.click();
	}
	
	public void AdminTabClick() {
		
		AdminTab.click();
	}
	
	
	public void BulkEditContactsButtonClick() {
		
		BulkEditContactsButton.click();
	}
	
	public void AdminContactCheckboxClick() {
		
		AdminContactCheckbox.click();
	}
	
	public void ContactFieldSelect(String Name){
		
		 Select Level = new Select(ContactField);
		 Level.selectByVisibleText(Name);
	}
	
	public void AccountAdminContactFieldSelect(String Name){
		
		 Select Level = new Select(AccountAdminContactField);
		 Level.selectByVisibleText(Name);
	}
	
	public void UpdateCertificateButtonClick() {
		
		UpdateCertificateButton.click();
	}
	
	public void DomainNamesLinkClick() {
		
		MyDomainNamesLink.click();
	}
	
	public void ProposalsLinkClick() {
		
		ProposalsLink.click();
	}
	
	public void LedgerLinkClick() {
		
		LedgerLink.click();
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
		//Assert.assertTrue(driver.getTitle().contains(Status));
		System.out.println("Page Title is:"  + Status);
		
	}

	public void ThirdCertDropDown(){
		
		Actions  Mouse=new Actions(driver);
	    WebElement Dropdown=driver.findElement(By.xpath(".//*[@id='mainContainer']/div[7]/div[2]/div/table/tbody/tr[3]/td[9]/div/button"));
	    Mouse.click(Dropdown);
	    driver.manage().timeouts().implicitlyWait(50,TimeUnit.SECONDS);
	    WebElement EyeIcon=driver.findElement(By.xpath(".//*[@id='mainContainer']/div[7]/div[2]/div/table/tbody/tr[3]/td[9]/div/ul/li[3]/a"));
	    Mouse.moveToElement(EyeIcon);
	    Mouse.perform();
	    
	}
	
	public void FourthCertDropDown(){
		
		Actions  Mouse=new Actions(driver);
	    WebElement Dropdown=driver.findElement(By.xpath(".//*[@id='mainContainer']/div[7]/div[2]/div/table/tbody/tr[4]/td[9]/div/button"));
	    Mouse.click(Dropdown);
	    driver.manage().timeouts().implicitlyWait(50,TimeUnit.SECONDS);
	    WebElement EyeIcon=driver.findElement(By.xpath(".//*[@id='mainContainer']/div[7]/div[2]/div/table/tbody/tr[4]/td[9]/div/ul/li[4]/a"));
	    Mouse.moveToElement(EyeIcon);
	    Mouse.perform();
	    
	}
	
	
	public void FifthCertDropDown(){
		
		Actions  Mouse=new Actions(driver);
	    WebElement Dropdown=driver.findElement(By.xpath(".//*[@id='mainContainer']/div[7]/div[2]/div/table/tbody/tr[5]/td[9]/div/button"));
	    Mouse.click(Dropdown);
	    driver.manage().timeouts().implicitlyWait(50,TimeUnit.SECONDS);
	    WebElement EyeIcon=driver.findElement(By.xpath(".//*[@id='mainContainer']/div[7]/div[2]/div/table/tbody/tr[5]/td[9]/div/ul/li[3]/a"));
	    Mouse.moveToElement(EyeIcon);
	    Mouse.perform();
	    
	}
	
	public boolean User1_LinkContains(String val){
		
		return User1_Link.getText().contains(val);

	}
	
	public boolean User2_LinkContains(String val){
		
		return User2_Link.getText().contains(val);
	
	}
	
	public boolean User3_LinkContains(String val){
		
		return User3_Link.getText().contains(val);

	}
	
	public boolean User4_LinkContains(String val){
		
		return User4_Link.getText().contains(val);

	}
	
	public boolean MissTitleIsDisplayed(){
		
		String Val = "Miss";
		return OptionMiss.getText().equals(Val);

	}
	
	public void AdminTitleTextPrint() {
		
		System.out.println("Title Present is" + OptionMiss.getText());
	}
	
	public void User1_EditButton(){
		
		 Actions  actions=new Actions(driver);
		 WebElement User1_ActionButton =driver.findElement(By.xpath(".//*[@id='mainContainer']/div[7]/div[2]/div[2]/div[1]/div/address/div[2]/div/button"));
		 actions.click(User1_ActionButton);
		 driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
		 WebElement User1_EditLink =driver.findElement(By.xpath(".//*[@id='mainContainer']/div[7]/div[2]/div[2]/div[1]/div/address/div[2]/div/ul/li[1]/a"));
		 actions.moveToElement(User1_EditLink);
		 actions.click();
		 actions.perform();		

	}
	
	public void User2_EditButton(){
		
		 Actions  actions=new Actions(driver);
		 WebElement User2_ActionButton =driver.findElement(By.xpath(".//*[@id='mainContainer']/div[7]/div[2]/div[2]/div[2]/div/address/div[2]/div/button"));
		 actions.click(User2_ActionButton);
		 driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
		 WebElement User2_EditLink =driver.findElement(By.xpath(".//*[@id='mainContainer']/div[7]/div[2]/div[2]/div[2]/div/address/div[2]/div/ul/li[1]/a"));
		 actions.moveToElement(User2_EditLink);
		 actions.click();
		 actions.perform();		

	}
	
	public void User3_EditButton(){
		
		 Actions  actions=new Actions(driver);
		 WebElement User3_ActionButton =driver.findElement(By.xpath(".//*[@id='mainContainer']/div[7]/div[2]/div[2]/div[3]/div/address/div[2]/div/button"));
		 actions.click(User3_ActionButton);
		 driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
		 WebElement User3_EditLink =driver.findElement(By.xpath(".//*[@id='mainContainer']/div[7]/div[2]/div[2]/div[3]/div/address/div[2]/div/ul/li[1]/a"));
		 actions.moveToElement(User3_EditLink);
		 actions.click();
		 actions.perform();		

	}
	
	public void User4_EditButton(){
		
		 Actions  actions=new Actions(driver);
		 WebElement User4_ActionButton =driver.findElement(By.xpath(".//*[@id='mainContainer']/div[7]/div[2]/div[2]/div[]/div/address/div[2]/div/button"));
		 actions.click(User4_ActionButton);
		 driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
		 WebElement User4_EditLink =driver.findElement(By.xpath(".//*[@id='mainContainer']/div[7]/div[2]/div[2]/div[1]/div/address/div[2]/div/ul/li[1]/a"));
		 actions.moveToElement(User4_EditLink);
		 actions.click();
		 actions.perform();		

	}
	
	public void AccessLevelSelect(String Access){
		
		 Select Level = new Select(AccessLevelField);
		 Level.selectByVisibleText(Access);
	}
	
	public void OptionalDetailsTabClick() {
		
		OptionalDetailsTab.click();
	}
	
	public void StateFieldFill(String State) {
		
		StateField.clear();
		StateField.sendKeys(State);
	}
	
	public void RegionFieldFill(String Region) {
		
		RegionField.clear();
		RegionField.sendKeys(Region);
	}
	
	public void SubmitChangesButtonClick() {
		
		SubmitChangesButton.click();
	}

}
