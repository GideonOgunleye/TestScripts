package PageFactory;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
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


public class AdminIssuedCertificatesPage extends DriverLoad {
	ExtentReports report;
	ExtentTest test;
	
	
	/********Issue Certificates Page****/
	
	@FindBy(xpath = ".//*[@id='mainContainer']/div[7]/div[2]/div/table/tbody/tr[10]/td[4]")
	WebElement Column10;
	
	@FindBy(xpath = ".//*[@id='mainContainer']/div[7]/div[2]/div/table/tbody/tr[2]/td[4]")
	WebElement Column2;
	
	@FindBy(xpath = ".//*[@id='mainContainer']/div[7]/div[2]/div/table/tbody/tr[3]/td[4]")
	WebElement Column3;
	
	@FindBy(xpath = ".//*[@id='mainContainer']/div[7]/div[2]/div/table/tbody/tr[4]/td[4]")
	WebElement Column4;
	
	@FindBy(xpath = ".//*[@id='mainContainer']/div[7]/div[2]/div/table/tbody/tr[5]/td[4]")
	WebElement Column5;
	
	@FindBy(xpath = ".//*[@id='mainContainer']/div[7]/div[2]/div/table/tbody/tr[15]/td[4]")
	WebElement Column15;
	
	@FindBy(xpath = ".//*[@class='stdContentWrapper']/div/table/tbody/tr[10]/td[11]/a")
	WebElement Product10;
	
	@FindBy(xpath = ".//*[@class='stdContentWrapper']/div/table/tbody/tr[2]/td[11]/a")
	WebElement Product2;
	
	@FindBy(xpath = ".//*[@class='stdContentWrapper']/div/table/tbody/tr[3]/td[11]/a")
	WebElement Product3;
	
	@FindBy(xpath = ".//*[@class='stdContentWrapper']/div/table/tbody/tr[4]/td[11]/a")
	WebElement Product4;
	
	@FindBy(xpath = ".//*[@class='stdContentWrapper']/div/table/tbody/tr[5]/td[11]/a")
	WebElement Product5;
	
	@FindBy(xpath = ".//*[@id='mainContainer']/div[7]/div[2]/div/table/tbody/tr[15]/td[11]/a")
	WebElement Product15;
	
	
	
	public AdminIssuedCertificatesPage(WebDriver driver){
		
		this.driver = driver;
		PageFactory.initElements(new AjaxElementLocatorFactory(driver, 20), this);
		//PageFactory.initElements(driver, this);
		
	}
	
	public boolean Column10Contains(String Certificate){
		
		return Column10.getText().contains(Certificate);

	}
	
	public void Column10TextPrint(){
		
		 System.out.println("Cloumn Product is:" + Column10.getText());

	}
	
	public boolean Column2Contains(String Certificate){
		
		return Column2.getText().contains(Certificate);

	}
	
	public void Column2TextPrint(){
		
		System.out.println("Cloumn Product is:" + Column2.getText());

	}
	
	public boolean Column3Contains(String Certificate){
		
		return Column3.getText().contains(Certificate);

	}
	
	public void Column3TextPrint(){
		
		System.out.println("Cloumn Product is:" + Column3.getText());

	}
	
	public boolean Column4Contains(String Certificate){
		
		return Column4.getText().contains(Certificate);

	}
	
	public boolean Column5Contains(String Certificate){
		
		return Column5.getText().contains(Certificate);

	}

	public boolean Column15Contains(String Certificate){
		
		return Column15.getText().contains(Certificate);

	}
	
	public void Column15TextPrint(){
		
		System.out.println("Cloumn Product is:" + Column15.getText());

	}
	
	public void Product10View(){
		
		Product10.click();
		
	}
	
	public void Product2View(){
		
		Product2.click();
		
	}
	
	public void Product3View(){
		
		Product3.click();
		
	}
	
	public void Product4View(){
		
		Product4.click();
		
	}
	
	public void Product5View(){
		
		Product5.click();
		
	}
	
	public void Product15View(){
		
		Product15.click();
		
	}

}
