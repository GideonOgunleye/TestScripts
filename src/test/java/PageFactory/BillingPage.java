package PageFactory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

import BaseUtilities.DriverLoad;

public class BillingPage extends DriverLoad {
	
	@FindBy(name = "data[BasketContact][firstname]")
	WebElement Firstname;
	
	@FindBy (name="data[BasketContact][lastname]")
	public static WebElement Lastname;

	@FindBy (name="data[BasketContact][phone]")
	WebElement PhoneNumber;
	
	@FindBy (name="data[BasketContact][email]")
	WebElement Email;
	
	@FindBy (name = "data[BasketContact][address_1]")
	WebElement Address1;
	
	@FindBy (name = "data[BasketContact][city]")
	WebElement City;
	
	@FindBy (name = "data[BasketContact][country]")
	WebElement Country;
	
	@FindBy (id = "notUsaStateInput")
	WebElement State;
	
	@FindBy (id = "BasketContactPostcode")
	WebElement Postcode;
	
	@FindBy (xpath = ".//*[@id='BasketContactForm']/div[8]/button")
	WebElement ConfirmButton;
	
	
	
	
	public BillingPage(WebDriver driver){
		
		this.driver = driver;
		PageFactory.initElements(new AjaxElementLocatorFactory(driver, 100), this);
		//PageFactory.initElements(driver, this);
		
	}
	
	public void FillFirstname(String Fname){
		
		Firstname.clear();
		Firstname.sendKeys(Fname);
	}
	
	public void FillLastname(String Lname){
		
		Lastname.clear();
		Lastname.sendKeys(Lname);
	}
	
	public void FillPhoneNumber(String Number) {
		
		PhoneNumber.clear();
		PhoneNumber.sendKeys(Number);
	}
	
	public void FillEmail(String EmailAdd) {
		
		Email.clear();
		Email.sendKeys(EmailAdd);
	}
	
	public void FillAddress1(String Address) {
		
		Address1.clear();
		Address1.sendKeys(Address);
	}
	
	public void FillCity(String CityName) {
		
		City.clear();
		City.sendKeys(CityName);
	}
	
	public void SelectCountry(String CountryyName) {
		
		Select CountryName = new Select(Country);
		CountryName.selectByVisibleText(CountryyName);
	}
	
	public void FillState(String StateName) {
		
		State.clear();
		State.sendKeys(StateName);
	}
	
	public void FillPostcode(String PostcodeN) {
		
		Postcode.clear();
		Postcode.sendKeys(PostcodeN);
	}
	
	public void ClickConfirmButton() {
		
		ConfirmButton.click();
	}
	
}
