package Slickets_Test;
 
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
 
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
 
public class FindAllLinks {
 
	public static WebDriver driver;
	
	public static void main(String[] args) throws Exception {
 
		//WebDriver driver = new FirefoxDriver();
		
		System.setProperty("webdriver.chrome.driver", "C:\\chromedriver.exe");
		driver = new ChromeDriver();  
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
 
		driver.get("https://www.ssl247.co.uk/thalesPartnerURL");
		driver.manage().window().maximize();
		
		WebElement MainNavigation = driver.findElement(By.xpath(".//*[@id='mainNavigation']"));
		
		//String Css = MainNavigation.getCssValue("z-index");getLocation()
		
		Point Css = MainNavigation.getLocation();
		System.out.println("Menu Z index is "+ Css);
		
        try {
        	
        	if (driver.getPageSource().contains("404 Page not found")) {
        		
        		System.out.println("ERROR 404 FOUND ON PAGE!!!!!");
        		
        	}else if (driver.getPageSource().contains("not found")){
        		
        		System.out.println("Page Not Found Error..!!");
        		
        	}
        	
        }catch (Exception k){
        	
        	System.out.println(k);
        }
		
		
		
		
		//int ImageWidth = MainNavigation.getSize().getWidth();
        //System.out.println("Navigation width Is "+ImageWidth+" pixels");
        
        //int ImageHeight = MainNavigation.getSize().getHeight();        
        //System.out.println("Navigation height Is "+ImageHeight+" pixels");
		
		//String bodyText = driver.findElement(By.tagName("body")).getText();
		//Assert.assertTrue("Text not found!", bodyText.contains(text));
		
		
		//WebElement element = driver.findElement(By.id(Value));
 
/*		java.util.List<WebElement> links = driver.findElements(By.tagName("a"));
		
		int sizeOfAllLinks = links.size();
		System.out.println(sizeOfAllLinks);
		
		
		for(int i=0; i<sizeOfAllLinks ;i++)
		{
			System.out.println(links.get(i).getAttribute("href"));
			//links.get(i).getAttribute("href").
			Thread.sleep(3000);
			driver.navigate().back();
		} 
*/		
		/*for (int index=0; index<sizeOfAllLinks; index++ ) {
			
			//getElementWithIndex(By.tagName("a"), index).click();
			
			driver.navigate().back();
		}*/
		
/*		public WebElement getElementWithIndex(By by, int index) {
			WebElement element = driver.findElement(By.id(Value));
			List<WebElement> elements = element.findElements(By.tagName("a")); 
			return elements.get(index);
		}*/
		
		//System.out.println(links.size());
		
		//Thread.sleep(1000);
 
		/*for (int i = 1; i<=links.size(); i=i+1)
 
		{
			System.out.println("----------------------------------------------------------------");
			System.out.println("Link name is:"+links.get(i).getText());
			
			Thread.sleep(1000);
			//driver.getTitle();
			System.out.println("Navigation Page Title is"+driver.getTitle());
			driver.navigate().back();
			Thread.sleep(1000);
			System.out.println("----------------------------------------------------------------");
		}*/
 
	}
 
}