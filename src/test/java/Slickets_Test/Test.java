//package Slickets_Test;

package Slickets_Test;


import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
 
public class Test {

//public static String URL = "http://www.nbc.com/Heroes/novels/downloads/";
	private static String[] links = null;
	private static int linksCount = 0;

public static void main(String[] args) throws InterruptedException, IOException {
	
	//Instantiating FirefoxDriver
	System.setProperty("webdriver.chrome.driver", "C:\\chromedriver.exe");
	//WebDriver driver = new FirefoxDriver();
	WebDriver driver = new ChromeDriver();
	
	//driver.get("www.xyz.com");  
	//WebElement element = driver.findElement(By.id(Value));
	
	driver.get("google.com");
	List<WebElement> linksize = driver.findElements(By.tagName("a")); 
	linksCount = linksize.size();
	System.out.println("Total no of links Available: "+linksCount);
	links= new String[linksCount];
	System.out.println("List of links Available: ");  
	// print all the links from webpage 
	for(int i=0;i<linksCount;i++)
	{
	links[i] = linksize.get(i).getAttribute("href");
	System.out.println(links[i]);
	} 
	// navigate to each Link on the webpage
	for(int i=0;i<linksCount;i++)
	{
	driver.navigate().to(links[i]);
	Thread.sleep(3000);
	}
	
	
	/*
	List<WebElement> elements = driver.findElements(By.tagName("a"));
	int sizeOfAllLinks = elements.size();
	System.out.println(sizeOfAllLinks);
	for(int i=0; i<sizeOfAllLinks ;i++)
	{
	System.out.println(elements.get(i).getAttribute("href"));
	}   
	for (int index=0; index<sizeOfAllLinks; index++ ) {
	getElementWithIndex(By.tagName("a"), index).click();
	driver.navigate().back();
	}

	public WebElement getElementWithIndex(By by, int index) {
	WebElement element = driver.findElement(By.id(Value));
	List<WebElement> elements = element.findElements(By.tagName("a")); 
	return elements.get(index);
	}*/


	
	}

}