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
	
	@DataProvider (name ="Certificate_ProposalsOrder_Data")
	public static Object[][] Certificate_ProposalsOrder_Data(){
		Object[][] obj = new Object[29][6];
		
		/*---------1st Parameter-------------*/	
		//ProductType
		obj[0][0]="SSL Certificate";
		//Product
		//obj[0][1]="Symantec Secure Site Pro EV";
		obj[0][1]="GeoTrust QuickSSL Premium";
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
		//obj[1][1]="Symantec Secure Site Pro";
		obj[1][1]="GlobalSign DomainSSL";
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
		
		/*--------16th Parameter-------------*/	
		//ProductType
		obj[15][0]="SSL Certificate";
		//Product
		obj[15][1]="GlobalSign DomainSSL";
		//Quantity
		obj[15][2]="1";
		//Duration
		obj[15][3]="1 year";
		//Duration
		obj[15][4]="1";
		//Common Name
		obj[15][5]="ssl247-test.co.uk";
		
		/*--------17th Parameter-------------*/	
		//ProductType
		obj[16][0]="SSL Certificate";
		//Product
		obj[16][1]="RapidSSL Pro";
		//Quantity
		obj[16][2]="1";
		//Duration
		obj[16][3]="1 year";
		//Duration
		obj[16][4]="1";
		//Common Name
		obj[16][5]="ssl247-test.co.uk";
		
		/*--------18th Parameter-------------*/	
		//ProductType
		obj[17][0]="SSL Certificate";
		//Product
		obj[17][1]="RapidSSL";
		//Quantity
		obj[17][2]="1";
		//Duration
		obj[17][3]="1 year";
		//Duration
		obj[17][4]="1";
		//Common Name
		obj[17][5]="ssl247-test.co.uk";
		
		/*--------19th Parameter-------------*/	
		//ProductType
		obj[18][0]="SSL Certificate";
		//Product
		obj[18][1]="Comodo Wildcard SSL Premium";
		//Quantity
		obj[18][2]="1";
		//Duration
		obj[18][3]="1 year";
		//Duration
		obj[18][4]="1";
		//Common Name
		obj[18][5]="ssl247-test.co.uk";
		
		/*--------20th Parameter-------------*/	
		//ProductType
		obj[19][0]="SSL Certificate";
		//Product
		obj[19][1]="Comodo PositiveSSL Multi-domain";
		//Quantity
		obj[19][2]="1";
		//Duration
		obj[19][3]="1 year";
		//Duration
		obj[19][4]="1";
		//Common Name
		obj[19][5]="ssl247-test.co.uk";
		
		/*--------21th Parameter-------------*/	
		//ProductType
		obj[20][0]="SSL Certificate";
		//Product
		obj[20][1]="Comodo EV SSL";
		//Quantity
		obj[20][2]="1";
		//Duration
		obj[20][3]="1 year";
		//Duration
		obj[20][4]="1";
		//Common Name
		obj[20][5]="ssl247-test.co.uk";
		
		/*--------22th Parameter-------------*/	
		//ProductType
		obj[21][0]="SSL Certificate";
		//Product
		obj[21][1]="Comodo EV SSL with SGC";
		//Quantity
		obj[21][2]="1";
		//Duration
		obj[21][3]="1 year";
		//Duration
		obj[21][4]="1";
		//Common Name
		obj[21][5]="ssl247-test.co.uk";
		
		/*--------23th Parameter-------------*/	
		//ProductType
		obj[22][0]="SSL Certificate";
		//Product
		obj[22][1]="Comodo EV Multi-Domain SSL";
		//Quantity
		obj[22][2]="1";
		//Duration
		obj[22][3]="1 year";
		//Duration
		obj[22][4]="1";
		//Common Name
		obj[22][5]="ssl247-test.co.uk";
		
		/*--------24th Parameter-------------*/	
		//ProductType
		obj[23][0]="SSL Certificate";
		//Product
		obj[23][1]="Comodo OV SSL";
		//Quantity
		obj[23][2]="1";
		//Duration
		obj[23][3]="1 year";
		//Duration
		obj[23][4]="1";
		//Common Name
		obj[23][5]="ssl247-test.co.uk";
		
		/*--------25th Parameter-------------*/	
		//ProductType
		obj[24][0]="SSL Certificate";
		//Product
		obj[24][1]="Comodo OV SSL with SGC";
		//Quantity
		obj[24][2]="1";
		//Duration
		obj[24][3]="1 year";
		//Duration
		obj[24][4]="1";
		//Common Name
		obj[24][5]="ssl247-test.co.uk";
		
		/*--------26th Parameter-------------**/	
		//ProductType
		obj[25][0]="SSL Certificate";
		//Product
		obj[25][1]="Comodo OV Multi-Domain SSL";
		//Quantity
		obj[25][2]="1";
		//Duration
		obj[25][3]="1 year";
		//Duration
		obj[25][4]="1";
		//Common Name
		obj[25][5]="ssl247-test.co.uk";
		
		/*--------27th Parameter-------------**/	
		//ProductType
		obj[26][0]="SSL Certificate";
		//Product
		obj[26][1]="Comodo Wildcard SSL with SGC";
		//Quantity
		obj[26][2]="1";
		//Duration
		obj[26][3]="1 year";
		//Duration
		obj[26][4]="1";
		//Common Name
		obj[26][5]="ssl247-test.co.uk";
		
		
		/*--------28th Parameter-------------**/	
		//ProductType
		obj[27][0]="SSL Certificate";
		//Product
		obj[27][1]="Comodo PositiveSSL Wildcard";
		//Quantity
		obj[27][2]="1";
		//Duration
		obj[27][3]="1 year";
		//Duration
		obj[27][4]="1";
		//Common Name
		obj[27][5]="ssl247-test.co.uk";
		
		/*--------29th Parameter-------------**/	
		//ProductType
		obj[28][0]="SSL Certificate";
		//Product
		obj[28][1]="Comodo PositiveSSL";
		//Quantity
		obj[28][2]="1";
		//Duration
		obj[28][3]="1 year";
		//Duration
		obj[28][4]="1";
		//Common Name
		obj[28][5]="ssl247-test.co.uk";
		
		/*--------30th Parameter-------------	
		//ProductType
		obj[29][0]="SSL Certificate";
		//Product
		obj[29][1]="Extra SANs for EV Certificates";
		//Quantity
		obj[29][2]="1";
		//Duration
		obj[29][3]="1 year";
		//Duration
		obj[29][4]="1";
		//Common Name
		obj[29][5]="ssl247-test.co.uk";
		**/
		
		/*--------31st Parameter-------------	
		//ProductType
		obj[30][0]="SSL Certificate";
		//Product
		obj[30][1]="Entrust Standard SSL";
		//Quantity
		obj[30][2]="1";
		//Duration
		obj[30][3]="1 year";
		//Duration
		obj[30][4]="1";
		//Common Name
		obj[30][5]="ssl247-test.co.uk";
		**/
		
		/*--------32nd Parameter-------------	
		//ProductType
		obj[31][0]="SSL Certificate";
		//Product
		obj[31][1]="Extra SANs for SSL Certificates (all except EV)";
		//Quantity
		obj[31][2]="1";
		//Duration
		obj[31][3]="1 year";
		//Duration
		obj[31][4]="1";
		//Common Name
		obj[31][5]="ssl247-test.co.uk";
		**/
		
		/*--------33rd Parameter-------------	
		//ProductType
		obj[32][0]="SSL Certificate";
		//Product
		obj[32][1]="Entrust Advantage SSL Certificates";
		//Quantity
		obj[32][2]="1";
		//Duration
		obj[32][3]="1 year";
		//Duration
		obj[32][4]="1";
		//Common Name
		obj[32][5]="ssl247-test.co.uk";
		**/
		
		/*--------34th Parameter-------------/	
		//ProductType
		obj[33][0]="SSL Certificate";
		//Product
		obj[33][1]="Entrust UC Multi-Domain SSL Certificates";
		//Quantity
		obj[33][2]="1";
		//Duration
		obj[33][3]="1 year";
		//Duration
		obj[33][4]="1";
		//Common Name
		obj[33][5]="ssl247-test.co.uk";
		**
		
		/*--------35th Parameter-------------	
		//ProductType
		obj[34][0]="SSL Certificate";
		//Product
		obj[34][1]="Entrust Wildcard SSL Certificates";
		//Quantity
		obj[34][2]="1";
		//Duration
		obj[34][3]="1 year";
		//Duration
		obj[34][4]="1";
		//Common Name
		obj[34][5]="ssl247-test.co.uk";
		**/
		
		/*--------36th Parameter-------------	
		//ProductType
		obj[35][0]="SSL Certificate";
		//Product
		obj[35][1]="Entrust EV Multi-Domain SSL Certificates";
		//Quantity
		obj[35][2]="1";
		//Duration
		obj[35][3]="1 year";
		//Duration
		obj[35][4]="1";
		//Common Name
		obj[35][5]="ssl247-test.co.uk";
		**/
		
		/*--------37th Parameter-------------	
		//ProductType
		obj[36][0]="SSL Certificate";
		//Product
		obj[36][1]="Entrust Private SSL";
		//Quantity
		obj[36][2]="1";
		//Duration
		obj[36][3]="1 year";
		//Duration
		obj[36][4]="1";
		//Common Name
		obj[36][5]="ssl247-test.co.uk";
		**/
		
		/*--------38th Parameter-------------	
		//ProductType
		obj[37][0]="SSL Certificate";
		//Product
		obj[37][1]="Certificat SSL de norme RGS";
		//Quantity
		obj[37][2]="1";
		//Duration
		obj[37][3]="1 year";
		//Duration
		obj[37][4]="1";
		//Common Name
		obj[37][5]="ssl247-test.co.uk";
		**/
		return obj;
		
	}
	
	@DataProvider (name ="Personal_ID_ProposalsOrder_Data")
	public static Object[][] Personal_ID_ProposalsOrder_Data(){
		Object[][] obj = new Object[4][6];
		
		/*---------1st Parameter-------------*/	
		//ProductType
		obj[0][0]="Personal ID";
		//Product
		obj[0][1]="GlobalSign PersonalSign 2 Department";
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
		obj[1][0]="Personal ID";
		//Product
		obj[1][1]="GlobalSign PersonalSign 2 Pro";
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
		obj[2][0]="Personal ID";
		//Product
		obj[2][1]="PersonalSign 1";
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
		obj[3][0]="Personal ID";
		//Product
		obj[3][1]="Entrust S/MIME Enterprise Certificate";
		//Quantity
		obj[3][2]="1";
		//Duration
		obj[3][3]="1 year";
		//Duration
		obj[3][4]="1";
		//Common Name
		obj[3][5]="ssl247-test.co.uk";
		
		
		/*--------5th Parameter-------------	
		//ProductType
		obj[4][0]="Personal ID";
		//Product
		obj[4][1]="Signature Électronique RGS* (une étoile)";
		//Quantity
		obj[4][2]="1";
		//Duration
		obj[4][3]="1 year";
		//Duration
		obj[4][4]="1";
		//Common Name
		obj[4][5]="ssl247-test.co.uk";
		*/
		
		/*--------6th Parameter-------------	
		//ProductType
		obj[5][0]="Personal ID";
		//Product
		obj[5][1]="Signature Électronique RGS** (deux étoiles)";
		//Quantity
		obj[5][2]="1";
		//Duration
		obj[5][3]="1 year";
		//Duration
		obj[5][4]="1";
		//Common Name
		obj[5][5]="ssl247-test.co.uk";
		*/
		
		/*--------7th Parameter-------------	
		//ProductType
		obj[6][0]="Personal ID";
		//Product
		obj[6][1]="Signature Électronique RGS*** (trois étoiles)";
		//Quantity
		obj[6][2]="1";
		//Duration
		obj[6][3]="1 year";
		//Duration
		obj[6][4]="1";
		//Common Name
		obj[6][5]="ssl247-test.co.uk";
		*/
		
		/*--------8th Parameter-------------	
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
		*/
		
		return obj;
		
	}
	
	@DataProvider (name ="CodeSigning_ProposalsOrder_Data")
	public static Object[][] CodeSigning_ProposalsOrder_Data(){
		Object[][] obj = new Object[6][6];
		
		/*---------1st Parameter-------------*/	
		//ProductType
		obj[0][0]="Code Signing";
		//Product
		obj[0][1]="Symantec Code Signing";
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
		obj[1][0]="Code Signing";
		//Product
		obj[1][1]="Symantec Code Signing for Individuals";
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
		obj[2][0]="Code Signing";
		//Product
		obj[2][1]="Thawte Code Signing";
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
		obj[3][0]="Code Signing";
		//Product
		obj[3][1]="Thawte Code Signing for Individuals";
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
		obj[4][0]="Code Signing";
		//Product
		obj[4][1]="GlobalSign Code Signing";
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
		obj[5][0]="Code Signing";
		//Product
		obj[5][1]="GlobalSign EV Code Signing Certificate";
		//Quantity
		obj[5][2]="1";
		//Duration
		obj[5][3]="1 year";
		//Duration
		obj[5][4]="1";
		//Common Name
		obj[5][5]="ssl247-test.co.uk";
		
		
		/*--------7th Parameter-------------	
		//ProductType
		obj[6][0]="Code Signing";
		//Product
		obj[6][1]="Entrust Code Signing Certificate";
		//Quantity
		obj[6][2]="1";
		//Duration
		obj[6][3]="1 year";
		//Duration
		obj[6][4]="1";
		//Common Name
		obj[6][5]="ssl247-test.co.uk";
		*/
		
		/*--------8th Parameter-------------	
		//ProductType
		obj[7][0]="Code Signing";
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
		*/
		
		return obj;
		
	}
	
	@DataProvider (name ="PdfSigning_ProposalsOrder_Data")
	public static Object[][] PdfSigning_ProposalsOrder_Data(){
		Object[][] obj = new Object[5][6];
		
		/*---------1st Parameter-------------*/	
		//ProductType
		obj[0][0]="PDF Signing";
		//Product
		obj[0][1]="GlobalSign PDF Signing AATL";
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
		obj[1][0]="PDF Signing";
		//Product
		obj[1][1]="Entrust Document Signing Certificate (Individual)";
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
		obj[2][0]="PDF Signing";
		//Product
		obj[2][1]="Entrust Document Signing Certificate (Department)";
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
		obj[3][0]="PDF Signing";
		//Product
		obj[3][1]="Entrust Document Signing Certificate Enterprise (10k signatures)";
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
		obj[4][0]="PDF Signing";
		//Product
		obj[4][1]="Entrust Document Signing Certificate Enterprise (unlimited signatures)";
		//Quantity
		obj[4][2]="1";
		//Duration
		obj[4][3]="1 year";
		//Duration
		obj[4][4]="1";
		//Common Name
		obj[4][5]="ssl247-test.co.uk";
		
		return obj;
		
	}
	
	@DataProvider (name ="BrandProtection_ProposalsOrder_Data")
	public static Object[][] BrandProtection_ProposalsOrder_Data(){
		Object[][] obj = new Object[5][6];
		
		/*---------1st Parameter-------------*/	
		//ProductType
		obj[0][0]="Brand Protection";
		//Product
		obj[0][1]="Trademark Clearinghouse";
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
		obj[1][0]="Brand Protection";
		//Product
		obj[1][1]="Domain Name Recovery";
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
		obj[2][0]="Brand Protection";
		//Product
		obj[2][1]="Uniform Domain Name Dispute Resolution Policy";
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
		obj[3][0]="Brand Protection";
		//Product
		obj[3][1]="URS Procedure";
		//Quantity
		obj[3][2]="1";
		//Duration
		obj[3][3]="1 year";
		//Duration
		obj[3][4]="1";
		//Common Name
		obj[3][5]="ssl247-test.co.uk";
		
		return obj;
		
	}

	@DataProvider (name ="ReadyIssuance_ProposalsOrder_Data")
	public static Object[][] ReadyIssuance_ProposalsOrder_Data(){
		Object[][] obj = new Object[4][6];
		
		/*---------1st Parameter-------------*/	
		//ProductType
		obj[0][0]="Ready Issuance";
		//Product
		obj[0][1]="Symantec Ready Issuance";
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
		obj[1][0]="Ready Issuance";
		//Product
		obj[1][1]="Entrust 3 Domains";
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
		obj[2][0]="Ready Issuance";
		//Product
		obj[2][1]="Entrust Organizations";
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
		obj[3][0]="Ready Issuance";
		//Product
		obj[3][1]="Entrust Client Company Names";
		//Quantity
		obj[3][2]="1";
		//Duration
		obj[3][3]="1 year";
		//Duration
		obj[3][4]="1";
		//Common Name
		obj[3][5]="ssl247-test.co.uk";
		
		/*--------5th Parameter-------------	
		//ProductType
		obj[4][0]="Ready Issuance";
		//Product
		obj[4][1]="Entrust Account Admin User";
		//Quantity
		obj[4][2]="1";
		//Duration
		obj[4][3]="1 year";
		//Duration
		obj[4][4]="1";
		//Common Name
		obj[4][5]="ssl247-test.co.uk";
		*/
		
		return obj;
		
	}
	
	@DataProvider (name ="PenTest_ProposalsOrder_Data")
	public static Object[][] PenTest_ProposalsOrder_Data(){
		Object[][] obj = new Object[3][6];
		
		/*---------1st Parameter-------------*/	
		//ProductType
		obj[0][0]="Penetration Testing";
		//Product
		obj[0][1]="External Test";
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
		obj[1][0]="Penetration Testing";
		//Product
		obj[1][1]="Internal Penetration Test";
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
		obj[2][0]="Penetration Testing";
		//Product
		obj[2][1]="Social Engineering Penetration Test";
		//Quantity
		obj[2][2]="1";
		//Duration
		obj[2][3]="1 year";
		//Duration
		obj[2][4]="1";
		//Common Name
		obj[2][5]="ssl247-test.co.uk";
		
		
		return obj;
		
	}
	
	@DataProvider (name ="EntrustEnterpriseAccount_ProposalsOrder_Data")
	public static Object[][] EntrustEnterpriseAccount_ProposalsOrder_Data(){
		Object[][] obj = new Object[2][6];
		
		/*---------1st Parameter-------------*/	
		//ProductType
		obj[0][0]="Entrust Enterprise Account";
		//Product
		obj[0][1]="Entrust Pooling Account";
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
		obj[1][0]="Entrust Enterprise Account";
		//Product
		obj[1][1]="Entrust Non-Pooling Account";
		//Quantity
		obj[1][2]="1";
		//Duration
		obj[1][3]="1 year";
		//Duration
		obj[1][4]="1";
		//Common Name
		obj[1][5]="ssl247-test.co.uk";
		
		return obj;
		
	}
	
	@DataProvider (name ="CertignaCertificate_ProposalsOrder_Data")
	public static Object[][] CertignaCertificate_ProposalsOrder_Data(){
		Object[][] obj = new Object[4][24];
		
		/*---------1st Parameter-------------*/	
		//ProductType
		obj[0][0]="SSL Certificate";
		//Product
		//obj[0][1]="Symantec Secure Site Pro EV";
		obj[0][1]="RGS Client SSL (Software) 1004";
		//Quantity
		obj[0][2]="1";
		//Duration
		obj[0][3]="1 year";
		//Duration
		obj[0][4]="1";
		//Common Name
		obj[0][5]="ssl247-test.co.uk";
		//Staff Name
		obj[0][6]="Daniel Genadiev";
		//Csr Line 1
		obj[0][7]="Ssl-test1";
		//Csr Line 2
		obj[0][8]="Ssl-test2";
		//Csr Line 3
		obj[0][9]="Ssl-test3";
		//Csr Line 4
		obj[0][10]="Ssl-test4";
		//Csr Line 5
		obj[0][11]="Ssl-test5";
		//Csr Line 6
		obj[0][12]="Ssl-test6";
		//Csr Line 7
		obj[0][13]="Ssl-test7";
		//Csr Line 8
		obj[0][14]="Ssl-test8";
		//Csr Line 9
		obj[0][15]="Ssl-test9";
		//Csr Line 10
		obj[0][16]="Ssl-test10";
		//Csr Line 11
		obj[0][17]="Ssl-test11";
		//Csr Line 12
		obj[0][18]="Ssl-test12";
		//Csr Line 13
		obj[0][19]="Ssl-test13";
		//Csr Line 14
		obj[0][20]="Ssl-test14";
		//Csr Line 15
		obj[0][21]="Ssl-test15";
		//Csr Line 16
		obj[0][22]="Ssl-test16";
		//Csr Line 17
		obj[0][23]="Ssl-test17";
		
		/*---------2nd Parameter-------------*/	
		//ProductType
		obj[1][0]="SSL Certificate";
		//Product
		//obj[0][1]="Symantec Secure Site Pro EV";
		obj[1][1]="RGS Server SSL (EN319411-1) 1002";
		//Quantity
		obj[1][2]="1";
		//Duration
		obj[1][3]="1 year";
		//Duration
		obj[1][4]="1";
		//Common Name
		obj[1][5]="ssl247-test.co.uk";
		//Staff Name
		obj[1][6]="Daniel Genadiev";
		//Csr Line 1
		obj[1][7]="Ssl-test1";
		//Csr Line 1
		obj[1][8]="Ssl-test2";
		//Csr Line 3
		obj[1][9]="Ssl-test3";
		//Csr Line 4
		obj[1][10]="Ssl-test4";
		//Csr Line 5
		obj[1][11]="Ssl-test5";
		//Csr Line 6
		obj[1][12]="Ssl-test6";
		//Csr Line 7
		obj[1][13]="Ssl-test7";
		//Csr Line 8
		obj[1][14]="Ssl-test8";
		//Csr Line 9
		obj[1][15]="Ssl-test9";
		//Csr Line 10
		obj[1][16]="Ssl-test10";
		//Csr Line 11
		obj[1][17]="Ssl-test11";
		//Csr Line 12
		obj[1][18]="Ssl-test12";
		//Csr Line 13
		obj[1][19]="Ssl-test13";
		//Csr Line 14
		obj[1][20]="Ssl-test14";
		//Csr Line 15
		obj[1][21]="Ssl-test15";
		//Csr Line 16
		obj[1][22]="Ssl-test16";
		//Csr Line 17
		obj[1][23]="Ssl-test17";		
		
		/*---------3rd Parameter-------------*/	
		//ProductType
		obj[2][0]="SSL Certificate";
		//Product
		//obj[0][1]="Symantec Secure Site Pro EV";
		obj[2][1]="RGS Wildcard SSL (Software) 1003";
		//Quantity
		obj[2][2]="1";
		//Duration
		obj[2][3]="1 year";
		//Duration
		obj[2][4]="1";
		//Common Name
		obj[2][5]="ssl247-test.co.uk";
		//Staff Name
		obj[2][6]="Daniel Genadiev";
		//Csr Line 1
		obj[2][7]="Ssl-test1";
		//Csr Line 2
		obj[2][8]="Ssl-test2";
		//Csr Line 3
		obj[2][9]="Ssl-test3";
		//Csr Line 4
		obj[2][10]="Ssl-test4";
		//Csr Line 5
		obj[2][11]="Ssl-test5";
		//Csr Line 6
		obj[2][12]="Ssl-test6";
		//Csr Line 7
		obj[2][13]="Ssl-test7";
		//Csr Line 8
		obj[2][14]="Ssl-test8";
		//Csr Line 9
		obj[2][15]="Ssl-test9";
		//Csr Line 10
		obj[2][16]="Ssl-test10";
		//Csr Line 11
		obj[2][17]="Ssl-test11";
		//Csr Line 12
		obj[2][18]="Ssl-test12";
		//Csr Line 13
		obj[2][19]="Ssl-test13";
		//Csr Line 14
		obj[2][20]="Ssl-test14";
		//Csr Line 15
		obj[2][21]="Ssl-test15";
		//Csr Line 16
		obj[2][22]="Ssl-test16";
		//Csr Line 17
		obj[2][23]="Ssl-test17";
		
		/*---------4th Parameter-------------*/	
		//ProductType
		obj[3][0]="SSL Certificate";
		//Product
		//obj[0][1]="Symantec Secure Site Pro EV";
		obj[3][1]="RGS Server SSL (RGS*) 1001";
		//Quantity
		obj[3][2]="1";
		//Duration
		obj[3][3]="1 year";
		//Duration
		obj[3][4]="1";
		//Common Name
		obj[3][5]="ssl247-test.co.uk";
		//Staff Name
		obj[3][6]="Daniel Genadiev";
		//Csr Line 1
		obj[3][7]="Ssl-test1";
		//Csr Line 3
		obj[3][8]="Ssl-test2";
		//Csr Line 3
		obj[3][9]="Ssl-test3";
		//Csr Line 4
		obj[3][10]="Ssl-test4";
		//Csr Line 5
		obj[3][11]="Ssl-test5";
		//Csr Line 6
		obj[3][12]="Ssl-test6";
		//Csr Line 7
		obj[3][13]="Ssl-test7";
		//Csr Line 8
		obj[3][14]="Ssl-test8";
		//Csr Line 9
		obj[3][15]="Ssl-test9";
		//Csr Line 10
		obj[3][16]="Ssl-test10";
		//Csr Line 11
		obj[3][17]="Ssl-test11";
		//Csr Line 12
		obj[3][18]="Ssl-test12";
		//Csr Line 13
		obj[3][19]="Ssl-test13";
		//Csr Line 14
		obj[3][20]="Ssl-test14";
		//Csr Line 15
		obj[3][21]="Ssl-test15";
		//Csr Line 16
		obj[3][22]="Ssl-test16";
		//Csr Line 17
		obj[3][23]="Ssl-test17";

	
		return obj;
		
	}
	
	@DataProvider (name ="CertignaPersonalID_ProposalsOrder_Data")
	public static Object[][] CertignaPersonalID_ProposalsOrder_Data(){
		Object[][] obj = new Object[6][24];
		
		/*---------1st Parameter-------------*/	
		//ProductType
		obj[0][0]="Personal ID";
		//Product
		obj[0][1]="RGS ID RGS** (Smartcard) 2002";
		//obj[0][1]="RGS Encryption Certificate 2011";
		//Quantity
		obj[0][2]="1";
		//Duration
		obj[0][3]="1 year";
		//Duration
		obj[0][4]="1";
		//Common Name
		obj[0][5]="ssl247-test.co.uk";
		//Staff Name
		obj[0][6]="Daniel Genadiev";
		//Csr Line 1
		obj[0][7]="Ssl-test1";
		//Csr Line 2
		obj[0][8]="Ssl-test2";
		//Csr Line 3
		obj[0][9]="Ssl-test3";
		//Csr Line 4
		obj[0][10]="Ssl-test4";
		//Csr Line 5
		obj[0][11]="Ssl-test5";
		//Csr Line 6
		obj[0][12]="Ssl-test6";
		//Csr Line 7
		obj[0][13]="Ssl-test7";
		//Csr Line 8
		obj[0][14]="Ssl-test8";
		//Csr Line 9
		obj[0][15]="Ssl-test9";
		//Csr Line 10
		obj[0][16]="Ssl-test10";
		//Csr Line 11
		obj[0][17]="Ssl-test11";
		//Csr Line 12
		obj[0][18]="Ssl-test12";
		//Csr Line 13
		obj[0][19]="Ssl-test13";
		//Csr Line 14
		obj[0][20]="Ssl-test14";
		//Csr Line 15
		obj[0][21]="Ssl-test15";
		//Csr Line 16
		obj[0][22]="Ssl-test16";
		//Csr Line 17
		obj[0][23]="Ssl-test17";
		
		/*---------2nd Parameter-------------*/	
		//ProductType
		obj[1][0]="Personal ID";
		//Product
		//obj[0][1]="Symantec Secure Site Pro EV";
		obj[1][1]="RGS ID RGS*** (Qualified Smartcard) 2003";
		//Quantity
		obj[1][2]="1";
		//Duration
		obj[1][3]="1 year";
		//Duration
		obj[1][4]="1";
		//Common Name
		obj[1][5]="ssl247-test.co.uk";
		//Staff Name
		obj[1][6]="Daniel Genadiev";
		//Csr Line 1
		obj[1][7]="Ssl-test1";
		//Csr Line 1
		obj[1][8]="Ssl-test2";
		//Csr Line 3
		obj[1][9]="Ssl-test3";
		//Csr Line 4
		obj[1][10]="Ssl-test4";
		//Csr Line 5
		obj[1][11]="Ssl-test5";
		//Csr Line 6
		obj[1][12]="Ssl-test6";
		//Csr Line 7
		obj[1][13]="Ssl-test7";
		//Csr Line 8
		obj[1][14]="Ssl-test8";
		//Csr Line 9
		obj[1][15]="Ssl-test9";
		//Csr Line 10
		obj[1][16]="Ssl-test10";
		//Csr Line 11
		obj[1][17]="Ssl-test11";
		//Csr Line 12
		obj[1][18]="Ssl-test12";
		//Csr Line 13
		obj[1][19]="Ssl-test13";
		//Csr Line 14
		obj[1][20]="Ssl-test14";
		//Csr Line 15
		obj[1][21]="Ssl-test15";
		//Csr Line 16
		obj[1][22]="Ssl-test16";
		//Csr Line 17
		obj[1][23]="Ssl-test17";		
		
		/*---------3rd Parameter-------------*/	
		//ProductType
		obj[2][0]="Personal ID";
		//Product
		//obj[0][1]="Symantec Secure Site Pro EV";
		obj[2][1]="RGS Auth RGS*** (Qualified Smartcard) 2004";
		//Quantity
		obj[2][2]="1";
		//Duration
		obj[2][3]="1 year";
		//Duration
		obj[2][4]="1";
		//Common Name
		obj[2][5]="ssl247-test.co.uk";
		//Staff Name
		obj[2][6]="Daniel Genadiev";
		//Csr Line 1
		obj[2][7]="Ssl-test1";
		//Csr Line 2
		obj[2][8]="Ssl-test2";
		//Csr Line 3
		obj[2][9]="Ssl-test3";
		//Csr Line 4
		obj[2][10]="Ssl-test4";
		//Csr Line 5
		obj[2][11]="Ssl-test5";
		//Csr Line 6
		obj[2][12]="Ssl-test6";
		//Csr Line 7
		obj[2][13]="Ssl-test7";
		//Csr Line 8
		obj[2][14]="Ssl-test8";
		//Csr Line 9
		obj[2][15]="Ssl-test9";
		//Csr Line 10
		obj[2][16]="Ssl-test10";
		//Csr Line 11
		obj[2][17]="Ssl-test11";
		//Csr Line 12
		obj[2][18]="Ssl-test12";
		//Csr Line 13
		obj[2][19]="Ssl-test13";
		//Csr Line 14
		obj[2][20]="Ssl-test14";
		//Csr Line 15
		obj[2][21]="Ssl-test15";
		//Csr Line 16
		obj[2][22]="Ssl-test16";
		//Csr Line 17
		obj[2][23]="Ssl-test17";
		
		/*---------4th Parameter-------------*/	
		//ProductType
		obj[3][0]="Personal ID";
		//Product
		//obj[0][1]="Symantec Secure Site Pro EV";
		obj[3][1]="RGS ID RGS Token (Smartcard) 2005";
		//Quantity
		obj[3][2]="1";
		//Duration
		obj[3][3]="1 year";
		//Duration
		obj[3][4]="1";
		//Common Name
		obj[3][5]="ssl247-test.co.uk";
		//Staff Name
		obj[3][6]="Daniel Genadiev";
		//Csr Line 1
		obj[3][7]="Ssl-test1";
		//Csr Line 3
		obj[3][8]="Ssl-test2";
		//Csr Line 3
		obj[3][9]="Ssl-test3";
		//Csr Line 4
		obj[3][10]="Ssl-test4";
		//Csr Line 5
		obj[3][11]="Ssl-test5";
		//Csr Line 6
		obj[3][12]="Ssl-test6";
		//Csr Line 7
		obj[3][13]="Ssl-test7";
		//Csr Line 8
		obj[3][14]="Ssl-test8";
		//Csr Line 9
		obj[3][15]="Ssl-test9";
		//Csr Line 10
		obj[3][16]="Ssl-test10";
		//Csr Line 11
		obj[3][17]="Ssl-test11";
		//Csr Line 12
		obj[3][18]="Ssl-test12";
		//Csr Line 13
		obj[3][19]="Ssl-test13";
		//Csr Line 14
		obj[3][20]="Ssl-test14";
		//Csr Line 15
		obj[3][21]="Ssl-test15";
		//Csr Line 16
		obj[3][22]="Ssl-test16";
		//Csr Line 17
		obj[3][23]="Ssl-test17";

		/*---------5th Parameter-------------*/	
		//ProductType
		obj[4][0]="Personal ID";
		//Product
		//obj[0][1]="Symantec Secure Site Pro EV";
		obj[4][1]="RGS ID RGS (Software) 2001";
		//Quantity
		obj[4][2]="1";
		//Duration
		obj[4][3]="1 year";
		//Duration
		obj[4][4]="1";
		//Common Name
		obj[4][5]="ssl247-test.co.uk";
		//Staff Name
		obj[4][6]="Daniel Genadiev";
		//Csr Line 1
		obj[4][7]="Ssl-test1";
		//Csr Line 2
		obj[4][8]="Ssl-test2";
		//Csr Line 3
		obj[4][9]="Ssl-test3";
		//Csr Line 4
		obj[4][10]="Ssl-test4";
		//Csr Line 5
		obj[4][11]="Ssl-test5";
		//Csr Line 6
		obj[4][12]="Ssl-test6";
		//Csr Line 7
		obj[4][13]="Ssl-test7";
		//Csr Line 8
		obj[4][14]="Ssl-test8";
		//Csr Line 9
		obj[4][15]="Ssl-test9";
		//Csr Line 10
		obj[4][16]="Ssl-test10";
		//Csr Line 11
		obj[4][17]="Ssl-test11";
		//Csr Line 12
		obj[4][18]="Ssl-test12";
		//Csr Line 13
		obj[4][19]="Ssl-test13";
		//Csr Line 14
		obj[4][20]="Ssl-test14";
		//Csr Line 15
		obj[4][21]="Ssl-test15";
		//Csr Line 16
		obj[4][22]="Ssl-test16";
		//Csr Line 17
		obj[4][23]="Ssl-test17";
		
		/*---------6th Parameter-------------*/	
		//ProductType
		obj[5][0]="Personal ID";
		//Product
		//obj[0][1]="Symantec Secure Site Pro EV";
		obj[5][1]="RGS Encryption Certificate 2011";
		//Quantity
		obj[5][2]="1";
		//Duration
		obj[5][3]="1 year";
		//Duration
		obj[5][4]="1";
		//Common Name
		obj[5][5]="ssl247-test.co.uk";
		//Staff Name
		obj[5][6]="Daniel Genadiev";
		//Csr Line 1
		obj[5][7]="Ssl-test1";
		//Csr Line 2
		obj[5][8]="Ssl-test2";
		//Csr Line 3
		obj[5][9]="Ssl-test3";
		//Csr Line 4
		obj[5][10]="Ssl-test4";
		//Csr Line 5
		obj[5][11]="Ssl-test5";
		//Csr Line 6
		obj[5][12]="Ssl-test6";
		//Csr Line 7
		obj[5][13]="Ssl-test7";
		//Csr Line 8
		obj[5][14]="Ssl-test8";
		//Csr Line 9
		obj[5][15]="Ssl-test9";
		//Csr Line 10
		obj[5][16]="Ssl-test10";
		//Csr Line 11
		obj[5][17]="Ssl-test11";
		//Csr Line 12
		obj[5][18]="Ssl-test12";
		//Csr Line 13
		obj[5][19]="Ssl-test13";
		//Csr Line 14
		obj[5][20]="Ssl-test14";
		//Csr Line 15
		obj[5][21]="Ssl-test15";
		//Csr Line 16
		obj[5][22]="Ssl-test16";
		//Csr Line 17
		obj[5][23]="Ssl-test17";

	
		return obj;
		
	}
	
	@DataProvider (name ="CodeSigningCerts_ProposalsOrder_Data")
	public static Object[][] CodeSigningCerts_ProposalsOrder_Data(){
		Object[][] obj = new Object[6][24];
		
		/*---------1st Parameter-------------*/	
		//ProductType
		obj[0][0]="Code Signing";
		//Product
		obj[0][1]="RGS Timestamping Certificate (Software) 1006";
		//Quantity
		obj[0][2]="1";
		//Duration
		obj[0][3]="1 year";
		//Duration
		obj[0][4]="1";
		//Common Name
		obj[0][5]="ssl247-test.co.uk";
		//Staff Name
		obj[0][6]="Daniel Genadiev";
		//Csr Line 1
		obj[0][7]="Ssl-test1";
		//Csr Line 2
		obj[0][8]="Ssl-test2";
		//Csr Line 3
		obj[0][9]="Ssl-test3";
		//Csr Line 4
		obj[0][10]="Ssl-test4";
		//Csr Line 5
		obj[0][11]="Ssl-test5";
		//Csr Line 6
		obj[0][12]="Ssl-test6";
		//Csr Line 7
		obj[0][13]="Ssl-test7";
		//Csr Line 8
		obj[0][14]="Ssl-test8";
		//Csr Line 9
		obj[0][15]="Ssl-test9";
		//Csr Line 10
		obj[0][16]="Ssl-test10";
		//Csr Line 11
		obj[0][17]="Ssl-test11";
		//Csr Line 12
		obj[0][18]="Ssl-test12";
		//Csr Line 13
		obj[0][19]="Ssl-test13";
		//Csr Line 14
		obj[0][20]="Ssl-test14";
		//Csr Line 15
		obj[0][21]="Ssl-test15";
		//Csr Line 16
		obj[0][22]="Ssl-test16";
		//Csr Line 17
		obj[0][23]="Ssl-test17";
		
		/*---------2nd Parameter-------------*/	
		//ProductType
		obj[1][0]="Code Signing";
		//Product
		obj[1][1]="RGS Signature Server Certificate (Software) 1005";
		//Quantity
		obj[1][2]="1";
		//Duration
		obj[1][3]="1 year";
		//Duration
		obj[1][4]="1";
		//Common Name
		obj[1][5]="ssl247-test.co.uk";
		//Staff Name
		obj[1][6]="Daniel Genadiev";
		//Csr Line 1
		obj[1][7]="Ssl-test1";
		//Csr Line 1
		obj[1][8]="Ssl-test2";
		//Csr Line 3
		obj[1][9]="Ssl-test3";
		//Csr Line 4
		obj[1][10]="Ssl-test4";
		//Csr Line 5
		obj[1][11]="Ssl-test5";
		//Csr Line 6
		obj[1][12]="Ssl-test6";
		//Csr Line 7
		obj[1][13]="Ssl-test7";
		//Csr Line 8
		obj[1][14]="Ssl-test8";
		//Csr Line 9
		obj[1][15]="Ssl-test9";
		//Csr Line 10
		obj[1][16]="Ssl-test10";
		//Csr Line 11
		obj[1][17]="Ssl-test11";
		//Csr Line 12
		obj[1][18]="Ssl-test12";
		//Csr Line 13
		obj[1][19]="Ssl-test13";
		//Csr Line 14
		obj[1][20]="Ssl-test14";
		//Csr Line 15
		obj[1][21]="Ssl-test15";
		//Csr Line 16
		obj[1][22]="Ssl-test16";
		//Csr Line 17
		obj[1][23]="Ssl-test17";		
		
		/*---------3rd Parameter-------------*/	
		//ProductType
		obj[2][0]="Code Signing";
		//Product
		obj[2][1]="RGS Timestamping Certificate (HSM) 1009";
		//Quantity
		obj[2][2]="1";
		//Duration
		obj[2][3]="1 year";
		//Duration
		obj[2][4]="1";
		//Common Name
		obj[2][5]="ssl247-test.co.uk";
		//Staff Name
		obj[2][6]="Daniel Genadiev";
		//Csr Line 1
		obj[2][7]="Ssl-test1";
		//Csr Line 2
		obj[2][8]="Ssl-test2";
		//Csr Line 3
		obj[2][9]="Ssl-test3";
		//Csr Line 4
		obj[2][10]="Ssl-test4";
		//Csr Line 5
		obj[2][11]="Ssl-test5";
		//Csr Line 6
		obj[2][12]="Ssl-test6";
		//Csr Line 7
		obj[2][13]="Ssl-test7";
		//Csr Line 8
		obj[2][14]="Ssl-test8";
		//Csr Line 9
		obj[2][15]="Ssl-test9";
		//Csr Line 10
		obj[2][16]="Ssl-test10";
		//Csr Line 11
		obj[2][17]="Ssl-test11";
		//Csr Line 12
		obj[2][18]="Ssl-test12";
		//Csr Line 13
		obj[2][19]="Ssl-test13";
		//Csr Line 14
		obj[2][20]="Ssl-test14";
		//Csr Line 15
		obj[2][21]="Ssl-test15";
		//Csr Line 16
		obj[2][22]="Ssl-test16";
		//Csr Line 17
		obj[2][23]="Ssl-test17";
		
		/*---------4th Parameter-------------*/	
		//ProductType
		obj[3][0]="Code Signing";
		//Product
		obj[3][1]="RGS Signature Server Certificate (HSM) 1008";
		//Quantity
		obj[3][2]="1";
		//Duration
		obj[3][3]="1 year";
		//Duration
		obj[3][4]="1";
		//Common Name
		obj[3][5]="ssl247-test.co.uk";
		//Staff Name
		obj[3][6]="Daniel Genadiev";
		//Csr Line 1
		obj[3][7]="Ssl-test1";
		//Csr Line 3
		obj[3][8]="Ssl-test2";
		//Csr Line 3
		obj[3][9]="Ssl-test3";
		//Csr Line 4
		obj[3][10]="Ssl-test4";
		//Csr Line 5
		obj[3][11]="Ssl-test5";
		//Csr Line 6
		obj[3][12]="Ssl-test6";
		//Csr Line 7
		obj[3][13]="Ssl-test7";
		//Csr Line 8
		obj[3][14]="Ssl-test8";
		//Csr Line 9
		obj[3][15]="Ssl-test9";
		//Csr Line 10
		obj[3][16]="Ssl-test10";
		//Csr Line 11
		obj[3][17]="Ssl-test11";
		//Csr Line 12
		obj[3][18]="Ssl-test12";
		//Csr Line 13
		obj[3][19]="Ssl-test13";
		//Csr Line 14
		obj[3][20]="Ssl-test14";
		//Csr Line 15
		obj[3][21]="Ssl-test15";
		//Csr Line 16
		obj[3][22]="Ssl-test16";
		//Csr Line 17
		obj[3][23]="Ssl-test17";

		/*---------5th Parameter-------------*/	
		//ProductType
		obj[4][0]="Code Signing";
		//Product
		obj[4][1]="RGS Codesigning Certificate (HSM) 1010";
		//Quantity
		obj[4][2]="1";
		//Duration
		obj[4][3]="1 year";
		//Duration
		obj[4][4]="1";
		//Common Name
		obj[4][5]="ssl247-test.co.uk";
		//Staff Name
		obj[4][6]="Daniel Genadiev";
		//Csr Line 1
		obj[4][7]="Ssl-test1";
		//Csr Line 2
		obj[4][8]="Ssl-test2";
		//Csr Line 3
		obj[4][9]="Ssl-test3";
		//Csr Line 4
		obj[4][10]="Ssl-test4";
		//Csr Line 5
		obj[4][11]="Ssl-test5";
		//Csr Line 6
		obj[4][12]="Ssl-test6";
		//Csr Line 7
		obj[4][13]="Ssl-test7";
		//Csr Line 8
		obj[4][14]="Ssl-test8";
		//Csr Line 9
		obj[4][15]="Ssl-test9";
		//Csr Line 10
		obj[4][16]="Ssl-test10";
		//Csr Line 11
		obj[4][17]="Ssl-test11";
		//Csr Line 12
		obj[4][18]="Ssl-test12";
		//Csr Line 13
		obj[4][19]="Ssl-test13";
		//Csr Line 14
		obj[4][20]="Ssl-test14";
		//Csr Line 15
		obj[4][21]="Ssl-test15";
		//Csr Line 16
		obj[4][22]="Ssl-test16";
		//Csr Line 17
		obj[4][23]="Ssl-test17";
		
		/*---------6th Parameter-------------*/	
		//ProductType
		obj[5][0]="Code Signing";
		//Product
		obj[5][1]="RGS Codesigning Certificate (Software) 1007";
		//Quantity
		obj[5][2]="1";
		//Duration
		obj[5][3]="1 year";
		//Duration
		obj[5][4]="1";
		//Common Name
		obj[5][5]="ssl247-test.co.uk";
		//Staff Name
		obj[5][6]="Daniel Genadiev";
		//Csr Line 1
		obj[5][7]="Ssl-test1";
		//Csr Line 2
		obj[5][8]="Ssl-test2";
		//Csr Line 3
		obj[5][9]="Ssl-test3";
		//Csr Line 4
		obj[5][10]="Ssl-test4";
		//Csr Line 5
		obj[5][11]="Ssl-test5";
		//Csr Line 6
		obj[5][12]="Ssl-test6";
		//Csr Line 7
		obj[5][13]="Ssl-test7";
		//Csr Line 8
		obj[5][14]="Ssl-test8";
		//Csr Line 9
		obj[5][15]="Ssl-test9";
		//Csr Line 10
		obj[5][16]="Ssl-test10";
		//Csr Line 11
		obj[5][17]="Ssl-test11";
		//Csr Line 12
		obj[5][18]="Ssl-test12";
		//Csr Line 13
		obj[5][19]="Ssl-test13";
		//Csr Line 14
		obj[5][20]="Ssl-test14";
		//Csr Line 15
		obj[5][21]="Ssl-test15";
		//Csr Line 16
		obj[5][22]="Ssl-test16";
		//Csr Line 17
		obj[5][23]="Ssl-test17";

	
		return obj;
		
	}

	
	
}
