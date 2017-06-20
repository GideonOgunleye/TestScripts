package PageFactory;

import org.testng.annotations.Test;

import BaseUtilities.DriverLoad;

import org.testng.annotations.BeforeTest;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterTest;

public class AlertBox extends DriverLoad {
	
	DriverLoad LoadDriver;
	
	
	@FindBy (xpath="html/body/div[4]/p[1]")
	WebElement Alert;
	
	
	public AlertBox(WebDriver driver){
		
		this.driver = driver;
		PageFactory.initElements(new AjaxElementLocatorFactory(driver, 100), this);
		//PageFactory.initElements(driver, this);
		
	}
	
	public boolean VerifyAlert(String Msg) {
		
		return Alert.getText().contains(Msg);

		
	}
	
	public boolean AlertIsVisible() {
		
		return Alert.isDisplayed();

		
	}
	
	public boolean AlertWait() {
		
		WebDriverWait wait = new WebDriverWait(driver, 60);
		WebElement Status = wait.until(ExpectedConditions.visibilityOfElementLocated (By.xpath("html/body/div[4]/p[1]")));
		
		return Status.isDisplayed();
		
	}
	
	public void AlertPrint() {
		
		System.out.println("Message is:" + Alert.getText());
		

	}
	
	
	
}
