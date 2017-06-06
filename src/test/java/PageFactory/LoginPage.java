package PageFactory;

import PageFactory.DriverLoad;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeTest;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;

public class LoginPage extends DriverLoad {
	
	@FindBy(linkText = "Login")
	WebElement LoginLink;
	
	@FindBy (name="data[User][email]")
	public static WebElement Username;

	@FindBy (name="data[User][password]")
	WebElement Password;
	
	@FindBy (xpath=".//*[@id='UserMysslLoginForm']/button")
	WebElement LoginButton;
	
	@FindBy (linkText = "Logout")
	WebElement LogoutButton;
	
	public LoginPage(WebDriver driver){
		
		this.driver = driver;
		PageFactory.initElements(new AjaxElementLocatorFactory(driver, 100), this);
		//PageFactory.initElements(driver, this);
		
	}
	
	public void clickLoginLink(){
		
		LoginLink.click();
	}
	
	public void EnterUserName(String name){
			
		Username.sendKeys(name);
	}
	
	public void EnterPassword(String Pword) {
		
		Password.sendKeys(Pword);
	}
	
	public void ClickLoginButton() {
		
		LoginButton.click();
	}
	
	public void ClickLogoutButton() {
		
		LogoutButton.click();
	}
}
