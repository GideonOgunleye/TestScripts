package PageFactory;

import PageFactory.DriverLoad;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterTest;

public class LoginPage extends DriverLoad {
	public static WebElement element = null;
	
	
	/*Returns Login Link*/
	public static WebElement LoginLink() {
		element = driver.findElement(By.linkText("Login"));
		return element;
	} 
	
	/*Returns Username Textfield*/
	public static WebElement UsernameField() {
		element = driver.findElement(By.name("data[User][email]"));
		return element;
	} 
	
	/*Returns Password Textfield*/
	public static WebElement PasswordField() {
		element = driver.findElement(By.name("data[User][password]"));
		return element;
	} 
	
	/*Returns Password Textfield*/
	public static WebElement LoginButton(WebDriver driver) {
		driver.findElement(By.xpath(".//*[@id='UserMysslLoginForm']/button"));
		return element;
	} 
	
	
	
}
