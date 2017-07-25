package Regression_Test;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class Test_Data {
	
	@DataProvider (name ="OrderProduct_Data")
	public static Object[][] OrderProductData(){
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
	
	
	@DataProvider (name ="Login_Data")
	public static Object[][] LoginData(){
		Object[][] obj = new Object[4][8];
		
		/*---------1st Parameter-------------*/	
		//Username
		obj[0][0]="qa@ssl247.co.uk";
		//Password
		obj[0][1]="Test1234";
		//Url
		obj[0][2]="https://staging-hc.ssl247.co.uk/";
		
		//AdminUser
		obj[0][3]="gogunleye@ssl247.co.uk";
		//Admin Password
		obj[0][4]="GrEu4Uy6";
		
		//Test Validation
	    obj[0][5]="UK Test Complete";
	    
	    //Test Account
	    obj[0][6]="UKTE001";
	    obj[0][7]="Quality Assurance Tester";
		
		
	/*---------2nd Parameter-------------*/		
		//Username
		obj[1][0]="qa@ssl247.fr";
		//Password
		obj[1][1]="Test1234";
		//Url
		obj[1][2]="https://staging-hc.ssl247.fr/";
		
		//AdminUser
		obj[1][3]="gogunleye@ssl247.co.uk";
		//Admin Password
		obj[1][4]="GrEu4Uy6";
		
		//Test Validation
		obj[1][5]="France Test Complete";
		
		//Test Account
	    obj[1][6]="FRTE001";
	    obj[1][7]="Quality French Testing";
		
	/*---------3rd Parameter-------------*/	
		//Username
		obj[2][0]="qa@ssl247.dk";
		//Password
		obj[2][1]="Test1234";
		//Url
		obj[2][2]="https://staging-hc.ssl247.dk/";
		
		//AdminUser
		obj[2][3]="gogunleye@ssl247.co.uk";
		//Admin Password
		obj[2][4]="GrEu4Uy6";
		
		//Test Validation
		obj[2][5]="Denmark Test Complete";
	
		//Test Account
	    obj[2][6]="DENM001";
	    obj[2][7]="Denmark Quality tester";
	    
	/*---------4th Parameter-------------*/	
		//Username
		obj[3][0]="qa@ssl247.ae";
		//Password
		obj[3][1]="Test1234";
		//Url
		obj[3][2]="https://staging-hc.ssl247.be/";
		
		//AdminUser
		obj[3][3]="gogunleye@ssl247.co.uk";
		//Admin Password
		obj[3][4]="GrEu4Uy6";
		
		//Test Validation
		obj[3][5]="Belgium Test Complete";
	
		//Test Account
	    obj[3][6]="BELG003";
	    obj[3][7]="Belgian Quality Testing";
	    
	    
		return obj;
		
		
	}
	
	
	@DataProvider (name ="Bulk Transfer Test")
	public static Object[][] BulkTransferTestData(){
		Object[][] obj = new Object[2][5];
		
		/*---------1st Parameter-------------*/	
		//Username
		obj[0][0]="gogunleye@ssl247.co.uk";
		//Password
		obj[0][1]="GrEu4Uy6";
		//Url
		obj[0][2]="https://ssl247:wpmsBv9P@automation-live.ssl247.co.uk";
		//Account Name
		obj[0][3]="UKTE001";
		//Account Name
		obj[0][4]="UKTE004";
		
		/*---------2st Parameter-------------*/	
		//Username
		obj[1][0]="gogunleye@ssl247.co.uk";
		//Password
		obj[1][1]="GrEu4Uy6";
		//Url
		obj[1][2]="https://ssl247:wpmsBv9P@automation-live.ssl247.co.uk";
		//Account Name
		obj[1][3]="UKTE004";
		//Account Name
		obj[1][4]="UKTE001";
		
		
		return obj;
		
	}
	
	@DataProvider (name ="ProposalsOrder_Data")
	public static Object[][] ProposalsOrder_Data(){
		Object[][] obj = new Object[15][6];
		
		/*---------1st Parameter-------------*/	
		//ProductType
		obj[0][0]="SSL Certificate";
		//Product
		obj[0][1]="Symantec Secure Site Pro EV";
		//Quantity
		obj[0][2]="1";
		//Duration
		obj[0][3]="1 year";
		//Duration
		obj[0][4]="1";
		//Common Name
		obj[0][5]="ssl247-test.co.uk";
		
		/*---------2nd Parameter-------------*/	
		//ProductType
		obj[1][0]="SSL Certificate";
		//Product
		obj[1][1]="Symantec Secure Site Pro";
		//Quantity
		obj[1][2]="1";
		//Duration
		obj[1][3]="1 year";
		//Duration
		obj[1][4]="1";
		//Common Name
		obj[1][5]="ssl247-test.co.uk";
		
		
		/*--------3rd Parameter-------------*/	
		//ProductType
		obj[2][0]="SSL Certificate";
		//Product
		obj[2][1]="Symantec Secure Site EV";
		//Quantity
		obj[2][2]="1";
		//Duration
		obj[2][3]="1 year";
		//Duration
		obj[2][4]="1";
		//Common Name
		obj[2][5]="ssl247-test.co.uk";
		
		
		/*--------4th Parameter-------------*/	
		//ProductType
		obj[3][0]="SSL Certificate";
		//Product
		obj[3][1]="Symantec Secure Site";
		//Quantity
		obj[3][2]="1";
		//Duration
		obj[3][3]="1 year";
		//Duration
		obj[3][4]="1";
		//Common Name
		obj[3][5]="ssl247-test.co.uk";
		
		
		/*--------5th Parameter-------------*/	
		//ProductType
		obj[4][0]="SSL Certificate";
		//Product
		obj[4][1]="Thawte SSL Web Server EV";
		//Quantity
		obj[4][2]="1";
		//Duration
		obj[4][3]="1 year";
		//Duration
		obj[4][4]="1";
		//Common Name
		obj[4][5]="ssl247-test.co.uk";
		
		/*--------6th Parameter-------------*/	
		//ProductType
		obj[5][0]="SSL Certificate";
		//Product
		obj[5][1]="Thawte SSL Web Server";
		//Quantity
		obj[5][2]="1";
		//Duration
		obj[5][3]="1 year";
		//Duration
		obj[5][4]="1";
		//Common Name
		obj[5][5]="ssl247-test.co.uk";
		
		/*--------7th Parameter-------------*/	
		//ProductType
		obj[6][0]="SSL Certificate";
		//Product
		obj[6][1]="Thawte SSL123";
		//Quantity
		obj[6][2]="1";
		//Duration
		obj[6][3]="1 year";
		//Duration
		obj[6][4]="1";
		//Common Name
		obj[6][5]="ssl247-test.co.uk";
		
		/*--------8th Parameter-------------*/	
		//ProductType
		obj[7][0]="SSL Certificate";
		//Product
		obj[7][1]="GeoTrust True BusinessID EV";
		//Quantity
		obj[7][2]="1";
		//Duration
		obj[7][3]="1 year";
		//Duration
		obj[7][4]="1";
		//Common Name
		obj[7][5]="ssl247-test.co.uk";
		
		/*--------9th Parameter-------------*/	
		//ProductType
		obj[8][0]="SSL Certificate";
		//Product
		obj[8][1]="GeoTrust True BusinessID Multi-Domain EV";
		//Quantity
		obj[8][2]="1";
		//Duration
		obj[8][3]="1 year";
		//Duration
		obj[8][4]="1";
		//Common Name
		obj[8][5]="ssl247-test.co.uk";
		
		/*--------10th Parameter-------------*/	
		//ProductType
		obj[9][0]="SSL Certificate";
		//Product
		obj[9][1]="GeoTrust True BusinessID";
		//Quantity
		obj[9][2]="1";
		//Duration
		obj[9][3]="1 year";
		//Duration
		obj[9][4]="1";
		//Common Name
		obj[9][5]="ssl247-test.co.uk";
		
		/*--------11th Parameter-------------*/	
		//ProductType
		obj[10][0]="SSL Certificate";
		//Product
		obj[10][1]="GeoTrust True BusinessID Multi-Domain";
		//Quantity
		obj[10][2]="1";
		//Duration
		obj[10][3]="1 year";
		//Duration
		obj[10][4]="1";
		//Common Name
		obj[10][5]="ssl247-test.co.uk";
		
		/*--------12th Parameter-------------*/	
		//ProductType
		obj[11][0]="SSL Certificate";
		//Product
		obj[11][1]="GeoTrust QuickSSL Premium";
		//Quantity
		obj[11][2]="1";
		//Duration
		obj[11][3]="1 year";
		//Duration
		obj[11][4]="1";
		//Common Name
		obj[11][5]="ssl247-test.co.uk";
		
		/*--------13th Parameter-------------*/	
		//ProductType
		obj[12][0]="SSL Certificate";
		//Product
		obj[12][1]="GeoTrust Free Trial";
		//Quantity
		obj[12][2]="1";
		//Duration
		obj[12][3]="1 year";
		//Duration
		obj[12][4]="1";
		//Common Name
		obj[12][5]="ssl247-test.co.uk";
		
		/*--------14th Parameter-------------*/	
		//ProductType
		obj[13][0]="SSL Certificate";
		//Product
		obj[13][1]="GlobalSign ExtendedSSL";
		//Quantity
		obj[13][2]="1";
		//Duration
		obj[13][3]="1 year";
		//Duration
		obj[13][4]="1";
		//Common Name
		obj[13][5]="ssl247-test.co.uk";
		
		/*--------15th Parameter-------------*/	
		//ProductType
		obj[14][0]="SSL Certificate";
		//Product
		obj[14][1]="GlobalSign OrganizationSSL";
		//Quantity
		obj[14][2]="1";
		//Duration
		obj[14][3]="1 year";
		//Duration
		obj[14][4]="1";
		//Common Name
		obj[14][5]="ssl247-test.co.uk";
		
		return obj;
		
	}
}
