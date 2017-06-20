package BaseUtilities;

import org.testng.annotations.Test;
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

public class CsR extends DriverLoad {
	
	DriverLoad LoadDriver;
	
	
	@FindBy (id="CertificateDetailCsr")
	public static WebElement CsR;
	
	@FindBy (xpath=".//*[@id='mainCertDetails']/a")
	WebElement Decoder;
	
	@FindBy (id="useCsrInfo")
	WebElement DecoderPopup;

	//@FindBy (name="data[User][password]")
	//WebElement Password;
	
	
	public CsR(WebDriver driver){
		
		this.driver = driver;
		PageFactory.initElements(new AjaxElementLocatorFactory(driver, 100), this);
		//PageFactory.initElements(driver, this);
		
	}
	
	
	public void LoadCsR () throws Exception {
		
		Properties prop = new Properties();
		FileInputStream fis = new FileInputStream("C://Users//Gideon Okunleye//workspace//AutomationTestScripts//DataDriving.properties");
				 
		prop.load(fis);
		
		EnterCsR(prop.getProperty("Para1"));
		HitEnterKey();
		EnterCsR(prop.getProperty("Para2"));
		HitEnterKey();
		EnterCsR(prop.getProperty("Para3"));
		HitEnterKey();;
		EnterCsR(prop.getProperty("Para4"));
		HitEnterKey();
		EnterCsR(prop.getProperty("Para5"));
		HitEnterKey();
		EnterCsR(prop.getProperty("Para6"));
		HitEnterKey();
		EnterCsR(prop.getProperty("Para7"));
		HitEnterKey();
		EnterCsR(prop.getProperty("Para8"));
		HitEnterKey();
		EnterCsR(prop.getProperty("Para9"));
		HitEnterKey();
		EnterCsR(prop.getProperty("Para10"));
		HitEnterKey();
		EnterCsR(prop.getProperty("Para11"));
		HitEnterKey();
		EnterCsR(prop.getProperty("Para12"));
		HitEnterKey();
		EnterCsR(prop.getProperty("Para13"));
		HitEnterKey();
		EnterCsR(prop.getProperty("Para14"));
		HitEnterKey();
		EnterCsR(prop.getProperty("Para15"));
		HitEnterKey();
		EnterCsR(prop.getProperty("Para16"));
		HitEnterKey();
		EnterCsR(prop.getProperty("Para17"));
		HitEnterKey();
	
	}
	
	
	public void EnterCsR(String name){
			
		CsR.sendKeys(name);
	}
	
	public void HitEnterKey(){
		
		CsR.sendKeys(Keys.ENTER);
	}
	
	public void ClickDecoder() throws Exception {
		
		Decoder.click();
		
	}
	
	public void ClickDecoderPopUp () throws Exception{
		
		DecoderPopup.click();
		
	}
	
}
