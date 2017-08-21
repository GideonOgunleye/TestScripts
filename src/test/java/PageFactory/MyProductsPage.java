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


public class MyProductsPage extends DriverLoad {
	ExtentReports report;
	ExtentTest test;
	
	
	/********My Products Page*******/
	@FindBy(xpath = ".//*[@id='SSLCertificate']/table/tbody/tr[1]/td[1]")
	WebElement Link1;
	
	@FindBy(xpath = ".//*[@id='SSLCertificate']/table/tbody/tr[1]/td[2]/a")
	WebElement Link1_Button1;
	
	@FindBy(xpath = ".//*[@id='SSLCertificate']/table/tbody/tr[2]/td[1]")
	WebElement Link2;
	
	@FindBy(xpath = ".//*[@id='SSLCertificate']/table/tbody/tr[2]/td[2]/a")
	WebElement Link2_Button1;
	
	@FindBy(xpath = ".//*[@id='SSLCertificate']/table/tbody/tr[3]/td[1]")
	WebElement Link3;
	
	@FindBy(xpath = ".//*[@id='SSLCertificate']/table/tbody/tr[3]/td[2]/a")
	WebElement Link3_Button1;
	
	@FindBy(xpath = ".//*[@id='SSLCertificate']/table/tbody/tr[4]/td[1]")
	WebElement Link4;
	
	@FindBy(xpath = ".//*[@id='SSLCertificate']/table/tbody/tr[4]/td[2]/a")
	WebElement Link4_Button1;
	
	@FindBy(xpath = ".//*[@id='SSLCertificate']/table/tbody/tr[5]/td[1]")
	WebElement Link5;
	
	@FindBy(xpath = ".//*[@id='SSLCertificate']/table/tbody/tr[5]/td[2]/a")
	WebElement Link5_Button1;
	
	@FindBy(xpath = ".//*[@id='SSLCertificate']/table/tbody/tr[6]/td[1]")
	WebElement Link6;
	
	@FindBy(xpath = ".//*[@id='SSLCertificate']/table/tbody/tr[6]/td[2]/a")
	WebElement Link6_Button1;
	
	@FindBy(xpath = ".//*[@id='SSLCertificate']/table/tbody/tr[7]/td[1]")
	WebElement Link7;
	
	@FindBy(xpath = ".//*[@id='SSLCertificate']/table/tbody/tr[7]/td[2]/a")
	WebElement Link7_Button1;
	
	@FindBy(xpath = ".//*[@id='SSLCertificate']/table/tbody/tr[8]/td[1]")
	WebElement Link8;
	
	@FindBy(xpath = ".//*[@id='SSLCertificate']/table/tbody/tr[8]/td[2]/a")
	WebElement Link8_Button1;
	
	@FindBy(xpath = ".//*[@id='SSLCertificate']/table/tbody/tr[9]/td[1]")
	WebElement Link9;
	
	@FindBy(xpath = ".//*[@id='SSLCertificate']/table/tbody/tr[9]/td[2]/a")
	WebElement Link9_Button1;
	
	@FindBy(xpath = ".//*[@id='SSLCertificate']/table/tbody/tr[10]/td[1]")
	WebElement Link10;
	
	@FindBy(xpath = ".//*[@id='SSLCertificate']/table/tbody/tr[10]/td[2]/a")
	WebElement Link10_Button1;
	
	@FindBy(xpath = ".//*[@id='SSLCertificate']/table/tbody/tr[11]/td[1]")
	WebElement Link11;
	
	@FindBy(xpath = ".//*[@id='SSLCertificate']/table/tbody/tr[11]/td[2]/a")
	WebElement Link11_Button1;
	
	@FindBy(xpath = ".//*[@id='SSLCertificate']/table/tbody/tr[12]/td[1]")
	WebElement Link12;
	
	@FindBy(xpath = ".//*[@id='SSLCertificate']/table/tbody/tr[12]/td[2]/a")
	WebElement Link12_Button1;
	
	@FindBy(xpath = ".//*[@id='SSLCertificate']/table/tbody/tr[13]/td[1]")
	WebElement Link13;
	
	@FindBy(xpath = ".//*[@id='SSLCertificate']/table/tbody/tr[13]/td[2]/a")
	WebElement Link13_Button1;
	
	@FindBy(xpath = ".//*[@id='SSLCertificate']/table/tbody/tr[14]/td[1]")
	WebElement Link14;
	
	@FindBy(xpath = ".//*[@id='SSLCertificate']/table/tbody/tr[14]/td[2]/a")
	WebElement Link14_Button1;
	
	@FindBy(xpath = ".//*[@id='SSLCertificate']/table/tbody/tr[15]/td[1]")
	WebElement Link15;
	
	@FindBy(xpath = ".//*[@id='SSLCertificate']/table/tbody/tr[15]/td[2]/a")
	WebElement Link15_Button1;
	
	@FindBy(xpath = ".//*[@id='SSLCertificate']/table/tbody/tr[16]/td[1]")
	WebElement Link16;
	
	@FindBy(xpath = ".//*[@id='SSLCertificate']/table/tbody/tr[16]/td[2]/a")
	WebElement Link16_Button1;
	
	@FindBy(xpath = ".//*[@id='SSLCertificate']/table/tbody/tr[17]/td[1]")
	WebElement Link17;
	
	@FindBy(xpath = ".//*[@id='SSLCertificate']/table/tbody/tr[17]/td[2]/a")
	WebElement Link17_Button1;
	
	@FindBy(xpath = ".//*[@id='SSLCertificate']/table/tbody/tr[18]/td[1]")
	WebElement Link18;
	
	@FindBy(xpath = ".//*[@id='SSLCertificate']/table/tbody/tr[18]/td[2]/a")
	WebElement Link18_Button1;
	
	@FindBy(xpath = ".//*[@id='SSLCertificate']/table/tbody/tr[19]/td[1]")
	WebElement Link19;
	
	@FindBy(xpath = ".//*[@id='SSLCertificate']/table/tbody/tr[19]/td[2]/a")
	WebElement Link19_Button1;
	
	@FindBy(xpath = ".//*[@id='SSLCertificate']/table/tbody/tr[20]/td[1]")
	WebElement Link20;
	
	@FindBy(xpath = ".//*[@id='SSLCertificate']/table/tbody/tr[20]/td[2]/a")
	WebElement Link20_Button1;
	
	@FindBy(xpath = ".//*[@id='SSLCertificate']/table/tbody/tr[21]/td[1]")
	WebElement Link21;
	
	@FindBy(xpath = ".//*[@id='SSLCertificate']/table/tbody/tr[21]/td[2]/a")
	WebElement Link21_Button1;
	
	@FindBy(xpath = ".//*[@id='SSLCertificate']/table/tbody/tr[22]/td[1]")
	WebElement Link22;
	
	@FindBy(xpath = ".//*[@id='SSLCertificate']/table/tbody/tr[22]/td[2]/a")
	WebElement Link22_Button1;
	
	@FindBy(xpath = ".//*[@id='SSLCertificate']/table/tbody/tr[23]/td[1]")
	WebElement Link23;
	
	@FindBy(xpath = ".//*[@id='SSLCertificate']/table/tbody/tr[23]/td[2]/a")
	WebElement Link23_Button1;
	
	@FindBy(xpath = ".//*[@id='SSLCertificate']/table/tbody/tr[24]/td[1]")
	WebElement Link24;
	
	@FindBy(xpath = ".//*[@id='SSLCertificate']/table/tbody/tr[24]/td[2]/a")
	WebElement Link24_Button1;
	
	@FindBy(xpath = ".//*[@id='SSLCertificate']/table/tbody/tr[25]/td[1]")
	WebElement Link25;
	
	@FindBy(xpath = ".//*[@id='SSLCertificate']/table/tbody/tr[25]/td[2]/a")
	WebElement Link25_Button1;
	
	
	public MyProductsPage(WebDriver driver){
		
		this.driver = driver;
		PageFactory.initElements(new AjaxElementLocatorFactory(driver, 20), this);
		//PageFactory.initElements(driver, this);
		
	}
	
	public void ValidatePage() {
		
		String Status = driver.getTitle();
		System.out.println("Page Title is:"  + Status);
		Assert.assertTrue(Status.contains("Proposals"));
		
	}
	
	
	public boolean Link1Contains (String Product){
		
		return Link1.getText().contains(Product);
	}
	
	public boolean Link2Contains (String Product){
		
		return Link2.getText().contains(Product);
	}
	
	public boolean Link3Contains (String Product){
		
		return Link3.getText().contains(Product);
	}
	
	public boolean Link4Contains (String Product){
		
		return Link4.getText().contains(Product);
	}
	
	public boolean Link5Contains (String Product){
		
		return Link5.getText().contains(Product);
	}
	
	public boolean Link6Contains (String Product){
		
		return Link6.getText().contains(Product);
	}
	
	public boolean Link7Contains (String Product){
		
		return Link7.getText().contains(Product);
	}
	
	public boolean Link8Contains (String Product){
		
		return Link8.getText().contains(Product);
	}
	
	public boolean Link9Contains (String Product){
		
		return Link9.getText().contains(Product);
	}
	
	public boolean Link10Contains (String Product){
		
		return Link10.getText().contains(Product);
	}
	
	public boolean Link11Contains (String Product){
		
		return Link11.getText().contains(Product);
	}
	
	public boolean Link12Contains (String Product){
		
		return Link12.getText().contains(Product);
	}
	
	public boolean Link13Contains (String Product){
		
		return Link13.getText().contains(Product);
	}
	
	public boolean Link14Contains (String Product){
		
		return Link14.getText().contains(Product);
	}
	
	public boolean Link15Contains (String Product){
		
		return Link15.getText().contains(Product);
	}
	
	public boolean Link16Contains (String Product){
		
		return Link16.getText().contains(Product);
	}
	
	public boolean Link17Contains (String Product){
		
		return Link17.getText().contains(Product);
	}
	
	public boolean Link18Contains (String Product){
		
		return Link18.getText().contains(Product);
	}
	
	public boolean Link19Contains (String Product){
		
		return Link19.getText().contains(Product);
	}
	
	public boolean Link20Contains (String Product){
		
		return Link20.getText().contains(Product);
	}
	
	public boolean Link21Contains (String Product){
		
		return Link21.getText().contains(Product);
	}
	
	public boolean Link22Contains (String Product){
		
		return Link22.getText().contains(Product);
	}
	
	public boolean Link23Contains (String Product){
		
		return Link23.getText().contains(Product);
	}
	
	public boolean Link24Contains (String Product){
		
		return Link24.getText().contains(Product);
	}
	
	public boolean Link25Contains (String Product){
		
		return Link25.getText().contains(Product);
	}
	
	//------------Link Button Click Methods---------------------------------------------------------
	
	public void Link1_Button1Clink(){
		
		Link1_Button1.click();
	}
	
	public void Link2_Button1Clink(){
		
		Link2_Button1.click();
	}
	
	public void Link3_Button1Clink(){
		
		Link3_Button1.click();
	}
	
	public void Link4_Button1Clink(){
		
		Link4_Button1.click();
	}
	
	public void Link5_Button1Clink(){
		
		Link5_Button1.click();
	}
	
	public void Link6_Button1Clink(){
		
		Link6_Button1.click();
	}
	
	public void Link7_Button1Clink(){
		
		Link7_Button1.click();
	}
	
	public void Link8_Button1Clink(){
		
		Link8_Button1.click();
	}
	
	public void Link9_Button1Clink(){
		
		Link9_Button1.click();
	}
	
	public void Link10_Button1Clink(){
		
		Link10_Button1.click();
	}
	
	public void Link11_Button1Clink(){
		
		Link11_Button1.click();
	}
	
	public void Link12_Button1Clink(){
		
		Link12_Button1.click();
	}
	
	public void Link13_Button1Clink(){
		
		Link13_Button1.click();
	}
	
	public void Link14_Button1Clink(){
		
		Link14_Button1.click();
	}
	
	public void Link15_Button1Clink(){
		
		Link15_Button1.click();
	}
	
	public void Link16_Button1Clink(){
		
		Link16_Button1.click();
	}
	
	public void Link17_Button1Clink(){
		
		Link17_Button1.click();
	}
	
	public void Link18_Button1Clink(){
		
		Link18_Button1.click();
	}
	
	public void Link19_Button1Clink(){
		
		Link19_Button1.click();
	}
	
	public void Link20_Button1Clink(){
		
		Link20_Button1.click();
	}
	
	public void Link21_Button1Clink(){
		
		Link21_Button1.click();
	}
	
	public void Link22_Button1Clink(){
		
		Link22_Button1.click();
	}
	
	public void Link23_Button1Clink(){
		
		Link23_Button1.click();
	}
	
	public void Link24_Button1Clink(){
		
		Link24_Button1.click();
	}
	
	public void Link25_Button1Clink(){
		
		Link25_Button1.click();
	}
	
}
