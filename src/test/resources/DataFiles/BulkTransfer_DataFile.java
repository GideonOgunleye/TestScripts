package Regression_Test;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class Order_Products_Data {
	
	@DataProvider (name ="OrderProduct_Data")
	public static Object[][] testData(){
		Object[][] obj = new Object[25][2];
		
		/*---------1st Parameter-------------*/	
		//Product Name
		obj[0][0]="Order Products Test --> Order_Symantec Secure Site";
		//Product Link
		obj[0][1]= "Symantec Secure Site";
		
		/*---------2rd Parameter-------------*/	
		//Product Name
		obj[1][0]="Order Products Test --> Order_Symantec Secure Site EV";
		//Product Link
		obj[1][1]= "Symantec Secure Site EV";
		
		/*---------3rd Parameter-------------*/	
		//Product Name
		obj[2][0]="Order Products Test --> Order_Symantec Secure Site Pro";
		//Product Link
		obj[2][1]= "Symantec Secure Site Pro";
		
		/*---------4th Parameter-------------*/	
		//Product Name
		obj[3][0]="Order Products Test --> Order_Symantec Secure Site Pro EV";
		//Product Link
		obj[3][1]= "Symantec Secure Site Pro EV";
		
		/*---------5th Parameter-------------*/	
		//Product Name
		obj[4][0]="Order Products Test --> Order_Thawte SSL Web Server";
		//Product Link
		obj[4][1]= "Thawte SSL Web Server";
		
		/*---------6th Parameter-------------*/	
		//Product Name
		obj[5][0]="Order Products Test --> Order_Thawte SSL Web Server EV";
		//Product Link
		obj[5][1]= "Thawte SSL Web Server EV";
		
		/*---------7th Parameter-------------*/	
		//Product Name
		obj[6][0]="Order Products Test --> Order_Thawte SSL123";
		//Product Link
		obj[6][1]= "Thawte SSL123";
		
		/*---------8th Parameter-------------*/
		//Product Name
		obj[7][0]="Order Products Test --> GeoTrust QuickSSL Premium";
		//Product Link
		obj[7][1]= "GeoTrust QuickSSL Premium";
		
		/*---------9th Parameter-------------*/
		//Product Name
		obj[8][0]="Order Products Test --> GeoTrust True BusinessID";
		//Product Link
		obj[8][1]= "GeoTrust True BusinessID";
		
		/*---------10th Parameter-------------*/	
		//Product Name
		obj[9][0]="Order Products Test --> GeoTrust True BusinessID EV";
		//Product Link
		obj[9][1]= "GeoTrust True BusinessID EV";
		
		/*---------11th Parameter-------------*/	
		//Product Name
		obj[10][0]="Order Products Test --> GeoTrust True BusinessID Multi-Domain";
		//Product Link
		obj[10][1]= "GeoTrust True BusinessID Multi-Domain";
		
		/*---------12th Parameter-------------*/	
		//Product Name
		obj[11][0]="Order Products Test --> GeoTrust True BusinessID Multi-Domain EV";
		//Product Link
		obj[11][1]= "GeoTrust True BusinessID Multi-Domain EV";
		
		/*---------13th Parameter-------------*/	
		//Product Name
		obj[12][0]="Order Products Test --> GlobalSign DomainSSL";
		//Product Link
		obj[12][1]= "GlobalSign DomainSSL";
		
		/*---------14th Parameter-------------*/	
		//Product Name
		obj[13][0]="Order Products Test --> GlobalSign ExtendedSSL";
		//Product Link
		obj[13][1]= "GlobalSign ExtendedSSL";
		
		/*---------15th Parameter-------------*/	
		//Product Name
		obj[14][0]="Order Products Test --> GlobalSign OrganizationSSL";
		//Product Link
		obj[14][1]= "GlobalSign OrganizationSSL";
		
		/*---------16th Parameter-------------*/	
		//Product Name
		obj[15][0]="Order Products Test --> RapidSSL";
		//Product Link
		obj[15][1]= "RapidSSL";
		
		/*---------17th Parameter-------------*/	
		//Product Name
		obj[16][0]="Order Products Test --> RapidSSL Pro";
		//Product Link
		obj[16][1]= "RapidSSL Pro";
		
		/*---------18th Parameter-------------*/	
		//Product Name
		obj[17][0]="Order Products Test --> Comodo EV Multi-Domain SSL";
		//Product Link
		obj[17][1]= "Comodo EV Multi-Domain SSL";
		
		/*---------19th Parameter-------------*/	
		//Product Name
		obj[18][0]="Order Products Test --> Comodo EV SSL";
		//Product Link
		obj[18][1]= "Comodo EV SSL";
		
		/*---------20th Parameter-------------*/	
		//Product Name
		obj[19][0]="Order Products Test --> Comodo OV Multi-Domain SSL";
		//Product Link
		obj[19][1]= "Comodo OV Multi-Domain SSL";
		
		/*---------21th Parameter-------------*/	
		//Product Name
		obj[20][0]="Order Products Test --> Comodo OV SSL";
		//Product Link
		obj[20][1]= "Comodo OV SSL";
		
		/*---------22th Parameter-------------*/	
		//Product Name
		obj[21][0]="Order Products Test --> Comodo PositiveSSL";
		//Product Link
		obj[21][1]= "Comodo PositiveSSL";
		
		/*---------23th Parameter-------------*/	
		//Product Name
		obj[22][0]="Order Products Test --> Comodo PositiveSSL Multi-domain";
		//Product Link
		obj[22][1]= "Comodo PositiveSSL Multi-domain";
		
		/*---------24th Parameter-------------*/	
		//Product Name
		obj[23][0]="Order Products Test --> Comodo PositiveSSL Wildcard";
		//Product Link
		obj[23][1]= "Comodo PositiveSSL Wildcard";
		
		/*---------25th Parameter-------------*/	
		//Product Name
		obj[24][0]="Order Products Test --> Comodo Wildcard SSL Premium";
		//Product Link
		obj[24][1]= "Comodo Wildcard SSL Premium";
	    
		return obj;
		
		
	}
}
