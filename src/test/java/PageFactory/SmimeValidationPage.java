package PageFactory;

import java.io.FileInputStream;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
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


public class SmimeValidationPage extends DriverLoad {
	ExtentReports report;
	ExtentTest test;
	
	
	/********SMIME Validation Page**********/
	
	@FindBy(css = "a[href*='#myssl-certificate-edit-security-tab']")
	WebElement DetailsTab;
	
	@FindBy(css = "a[href*='#myssl-certificate-tncs']")
	WebElement MiscTab;
	
	@FindBy(xpath = ".//*[@id='PersonalSigningAcceptTerms']")
	WebElement TermsCheckBox;
	
	@FindBy(xpath = ".//*[@id='PersonalSigningPassphrase']")
	WebElement PassPhraseField;
	
	//@FindBy(xpath = ".//*[@id='CertificateDetailCsr']")
	//WebElement CsrField;
	
	//@FindBy(xpath = ".//*[@id='mainCertDetails']/a")
	//WebElement DecodeCsrButton;
	
	
	
	/*******************Admin Tad*****************/
	//@FindBy(xpath = ".//*[@id='CertificateMysslEditForm']/div[2]/div[2]/ul/li[2]/a")
	//WebElement AdminTab;
	
	@FindBy(xpath = ".//*[@id='PersonalSigningAdminContact']")
	WebElement AdminNameField;
	
	@FindBy(xpath = ".//*[@id='PersonalSigningAdminOrganisation']")
	WebElement AdminOrganisationField;
	
	@FindBy(xpath = ".//*[@id='PersonalSigningAdminDivision']")
	WebElement AdminDivisionField;
	
	
	
	/**********Technical Tab*****************/
	//@FindBy(xpath = ".//*[@id='CertificateMysslEditForm']/div[2]/div[2]/ul/li[3]/a")
	//WebElement TechnicalTab;
	
	@FindBy(xpath = ".//*[@id='PersonalSigningTechContact']")
	WebElement TechnicalNameField;
	
	@FindBy(xpath = ".//*[@id='PersonalSigningTechOrganisation']")
	WebElement TechnicalOrganisationField;
	
	@FindBy(xpath = ".//*[@id='PersonalSigningTechDivision']")
	WebElement TechDivisionField;
	
	
	/**********Director Tab*****************/
	//@FindBy(xpath = ".//*[@id='CertificateMysslEditForm']/div[2]/div[2]/ul/li[5]/a")
	//WebElement DirectorTab;
	
	@FindBy(xpath = ".//*[@id='PersonalSigningDirectorContact']")
	WebElement DirectorContactField;
	
	@FindBy(xpath = ".//*[@id='PersonalSigningDirectorOrganisation']")
	WebElement DirectorOrganisationField;
	
	@FindBy(xpath = ".//*[@id='PersonalSigningDirectorDivision']")
	WebElement DirectorDivisionField;
	
	
	/***************Admin Security Questions******/
	@FindBy(xpath = ".//*[@id='PersonalSigningAdminQuestion1']")
	WebElement AdminFavouriteColourQuestionField;
	
	@FindBy(xpath = ".//*[@id='PersonalSigningAdminQuestion2']")
	WebElement AdminFavouriteVegetableQuestionField;
	
	@FindBy(xpath = ".//*[@id='PersonalSigningAdminQuestion3']")
	WebElement AdminFavouriteBookQuestionField;
	
	@FindBy(xpath = ".//*[@id='PersonalSigningAdminQuestion4']")
	WebElement AdminFavouriteSportQuestionField;
	
	@FindBy(xpath = ".//*[@id='PersonalSigningAdminQuestion5']")
	WebElement AdminStreetNameQuestionField;
	
	
	/***************Tech Security Questions******/
	@FindBy(xpath = ".//*[@id='PersonalSigningTechQuestion1']")
	WebElement TechFavouriteColourQuestionField;
	
	@FindBy(xpath = ".//*[@id='PersonalSigningTechQuestion2']")
	WebElement TechFavouriteVegetableQuestionField;
	
	@FindBy(xpath = ".//*[@id='PersonalSigningTechQuestion3']")
	WebElement TechFavouriteBookQuestionField;
	
	@FindBy(xpath = ".//*[@id='PersonalSigningTechQuestion4']")
	WebElement TechFavouriteSportQuestionField;
	
	@FindBy(xpath = ".//*[@id='PersonalSigningTechQuestion5']")
	WebElement TechStreetNameQuestionField;
	
	
	/***************Director Security Questions******/
	@FindBy(xpath = ".//*[@id='PersonalSigningDirectorQuestion1']")
	WebElement DirectorFavouriteColourQuestionField;
	
	@FindBy(xpath = ".//*[@id='PersonalSigningDirectorQuestion2']")
	WebElement DirectorFavouriteVegetableQuestionField;
	
	@FindBy(xpath = ".//*[@id='PersonalSigningDirectorQuestion3']")
	WebElement DirectorFavouriteBookQuestionField;
	
	@FindBy(xpath = ".//*[@id='PersonalSigningDirectorQuestion4']")
	WebElement DirectorFavouriteSportQuestionField;
	
	@FindBy(xpath = ".//*[@id='PersonalSigningDirectorQuestion5']")
	WebElement DirectorStreetNameQuestionField;
	
	@FindBy(xpath = ".//*[@id='PersonalSigningOrganisationLegalName']")
	WebElement OrganisationLegalNameField;
	
	@FindBy(xpath = ".//*[@id='PersonalSigningOrganisationRegistrationNumber']")
	WebElement OrganisationRegistrationNumberField;
	
	
	@FindBy(xpath = ".//*[@id='PersonalSigningMysslEditForm']/h2/div/button")
	WebElement SaveChangesButton;
	
	@FindBy(xpath = ".//*[@id='myssl-certificate-tncs']/div[2]/div/div/div[2]")
	WebElement PopUp;
	
	
	public SmimeValidationPage(WebDriver driver){
		
		this.driver = driver;
		PageFactory.initElements(new AjaxElementLocatorFactory(driver, 20), this);
		//PageFactory.initElements(driver, this);
		
	}
	
	public void DetailsTabClick(){
		
		DetailsTab.click();
		
	}
	
	public void MiscTabClick(){
		
		MiscTab.click();
		
	}
	
	public void TermsCheckBoxTick(){
		
		TermsCheckBox.click();
		
	}
	
	public void SaveChangesButtonClick(){
		
		SaveChangesButton.click();
		
	}
	
	public void PopUpClick(){
		
		PopUp.click();
		
	}
	
	
	public void PassPhraseFieldFill(String Phrase){
		
		PassPhraseField.clear();
		PassPhraseField.sendKeys(Phrase);
		
	}
	
	
	public void OrganisationLegalNameFieldFill(String Phrase){
		
		OrganisationLegalNameField.clear();
		OrganisationLegalNameField.sendKeys(Phrase);
		
	}
	
	
	
	public void OrganisationRegistrationNumberFieldFill(String Phrase){
		
		OrganisationRegistrationNumberField.clear();
		OrganisationRegistrationNumberField.sendKeys(Phrase);
		
	}
	
	public void AdminNameFieldSelect(String Name){
		
		Select AdminName = new Select(AdminNameField);
		AdminName.selectByVisibleText(Name);
		
	}
	
	public void AdminDivisionFieldFill(String Name){
		
		AdminDivisionField.clear();
		AdminDivisionField.sendKeys(Name);
		
	}
	
	public void AdminFavouriteColourQuestionFieldFill(String Question){
		
		AdminFavouriteColourQuestionField.clear();
		AdminFavouriteColourQuestionField.sendKeys(Question);
	}
	
	public void AdminFavouriteVegetableQuestionFieldFill(String Question){
		
		AdminFavouriteVegetableQuestionField.clear();
		AdminFavouriteVegetableQuestionField.sendKeys(Question);
	}
	
	public void AdminFavouriteBookQuestionFieldFill(String Question){
		
		AdminFavouriteBookQuestionField.clear();
		AdminFavouriteBookQuestionField.sendKeys(Question);
	}
	
	public void AdminFavouriteSportQuestionFieldFill(String Question){
		
		AdminFavouriteSportQuestionField.clear();
		AdminFavouriteSportQuestionField.sendKeys(Question);
	}
	
	public void AdminStreetNameQuestionFieldFill(String Question){
		
		AdminStreetNameQuestionField.clear();
		AdminStreetNameQuestionField.sendKeys(Question);
	}
	
	public void TechnicalNameFieldSelect(String Name){
		
		Select TechName = new Select(TechnicalNameField);
		TechName.selectByVisibleText(Name);
		
	}
	
	public void TechDivisionFieldFill(String Name){
		
		TechDivisionField.clear();
		TechDivisionField.sendKeys(Name);
		
	}
	
	public void TechFavouriteColourQuestionFieldFill(String Question){
		
		TechFavouriteColourQuestionField.clear();
		TechFavouriteColourQuestionField.sendKeys(Question);
	}
	
	public void TechFavouriteVegetableQuestionFieldFill(String Question){
		
		TechFavouriteVegetableQuestionField.clear();
		TechFavouriteVegetableQuestionField.sendKeys(Question);
	}
	
	public void TechFavouriteBookQuestionFieldFill(String Question){
		
		TechFavouriteBookQuestionField.clear();
		TechFavouriteBookQuestionField.sendKeys(Question);
	}
	
	public void TechFavouriteSportQuestionFieldFill(String Question){
		
		TechFavouriteSportQuestionField.clear();
		TechFavouriteSportQuestionField.sendKeys(Question);
	}
	
	public void TechStreetNameQuestionFieldFill(String Question){
		
		TechStreetNameQuestionField.clear();
		TechStreetNameQuestionField.sendKeys(Question);
	}
	
	public void DirectorContactFieldSelect(String Name){
		
		Select DirectorName = new Select(DirectorContactField);
		DirectorName.selectByVisibleText(Name);
		
	}
	
	public void DirectorDivisionFieldFill(String Name){
		
		DirectorDivisionField.clear();
		DirectorDivisionField.sendKeys(Name);
		
	}
	
	public void DirectorFavouriteColourQuestionFieldFill(String Question){
		
		DirectorFavouriteColourQuestionField.clear();
		DirectorFavouriteColourQuestionField.sendKeys(Question);
	}
	
	public void DirectorFavouriteVegetableQuestionFieldFill(String Question){
		
		DirectorFavouriteVegetableQuestionField.clear();
		DirectorFavouriteVegetableQuestionField.sendKeys(Question);
	}
	
	public void DirectorFavouriteBookQuestionFieldFill(String Question){
		
		DirectorFavouriteBookQuestionField.clear();
		DirectorFavouriteBookQuestionField.sendKeys(Question);
	}
	
	public void DirectorFavouriteSportQuestionFieldFill(String Question){
		
		DirectorFavouriteSportQuestionField.clear();
		DirectorFavouriteSportQuestionField.sendKeys(Question);
	}
	
	public void DirectorStreetNameQuestionFieldFill(String Question){
		
		DirectorStreetNameQuestionField.clear();
		DirectorStreetNameQuestionField.sendKeys(Question);
	}
	
}
