package PageFactory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;
import org.testng.annotations.Test;

public class BillingPage extends DriverLoad {
	
	@FindBy(xpath = ".//*[@id='top-panel']/div[1]/span[1]/a[1]")
	WebElement LoginLink;
	
	@FindBy (name="data[User][email]")
	public static WebElement Username;

	@FindBy (name="data[User][password]")
	WebElement Password;
	
	@FindBy (xpath=".//*[@id='UserMysslLoginForm']/button")
	WebElement LoginButton;
	
	@FindBy (xpath = ".//*[@id='top-panel']/div[1]/span[1]/a[2]")
	WebElement LogoutButton;
	
	public BillingPage(WebDriver driver){
		
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
	
	
	
	
  @Test
  public void f() {
  }
}
