package Sanity_Test;

import org.testng.annotations.DataProvider;
//import utilities.Constants;
//import utilities.ExcelUtility;
import org.testng.annotations.Test;

import BaseUtilities.ExcelUtility;

public class Test_DataSanity {
	
	static ExcelUtility ExcelUtility = new ExcelUtility();
	
	@DataProvider (name ="LoginUser")
	public static Object[][] LoginUser(){
		Object[][] obj = new Object[2][3];
		
		/*---------1st Parameter-------------*/	
		//Username
		obj[0][0]="qa@ssl247.co.uk";
		//Password
		obj[0][1]="Test1235";
		//Url
		obj[0][2]="InValid Credentials";
		
		
		/*---------2st Parameter-------------*/
		//Username
		obj[1][0]="qa@ssl247.co.uk";
		//Password
		obj[1][1]="Test1234";
		//Url
		obj[1][2]="Valid Credentilas";
			
		
		/*---------2st Parameter-------------	
		//Username
		obj[2][0]="qa@ssl247.co.uk";
		//Password
		obj[2][1]="Test1234";
		//Url
		obj[2][2]="https://automation-live.ssl247.co.uk/";
		//Account Name
		obj[2][3]="UKTE001";
		//Column Product
		obj[2][4]="RapidSSL Pro";
		*/
		return obj;
		
	}
	
	@DataProvider (name ="AdminLogin")
	public static Object[][] AdminLogin(){
		Object[][] obj = new Object[2][5];
		
		/*---------1st Parameter-------------*/	
		//Websitename
		obj[0][0]="Uk Website";
		//Domain
		obj[0][1]="Url";
		//Username
		obj[0][2]="AdUserName";
		//Password
		obj[0][3]="AdValidPassword";
		//Url
		obj[0][4]="Valid Credentials";
		
		
		/*---------2nd Parameter-------------*/
		//Websitename
		obj[1][0]="Uk Website";
		//Domain
		obj[1][1]="Url";
		//Username
		obj[1][2]="AdUserName";
		//Password
		obj[1][3]="AdInvalidPassword";
		//Url
		obj[1][4]="InValid Credentials";
		
		return obj;
		
	}
	
	@DataProvider (name ="AdminLoginAllSites")
	public static Object[][] AdminLoginAllSites(){
		Object[][] obj = new Object[38][5];
		
		/*---------1st Parameter-------------*/	
		//Websitename
		obj[0][0]="Uk Website";
		//Domain
		obj[0][1]="Url";
		//Username
		obj[0][2]="AdUserName";
		//Password
		obj[0][3]="AdValidPassword";
		//Url
		obj[0][4]="Valid Credentials";
		
		
		/*---------2nd Parameter-------------*/
		//Websitename
		obj[1][0]="Uk Website";
		//Domain
		obj[1][1]="Url";
		//Username
		obj[1][2]="AdUserName";
		//Password
		obj[1][3]="AdInvalidPassword";
		//Url
		obj[1][4]="InValid Credentials";
		
		
		/*---------3rd Parameter-------------*/	
		//Websitename
		obj[2][0]="French Website";
		//Domain
		obj[2][1]="FrenchUrl";
		//Username
		obj[2][2]="AdUserName";
		//Password
		obj[2][3]="AdValidPassword";
		//Url
		obj[2][4]="Valid Credentials";
		
		
		/*---------4th Parameter-------------*/
		//Websitename
		obj[3][0]="French Website";
		//Domain
		obj[3][1]="FrenchUrl";
		//Username
		obj[3][2]="AdUserName";
		//Password
		obj[3][3]="AdInvalidPassword";
		//Url
		obj[3][4]="InValid Credentials";
		
		/*---------5th Parameter-------------*/	
		//Websitename
		obj[4][0]="AE Website";
		//Domain
		obj[4][1]="AeUrl";
		//Username
		obj[4][2]="AdUserName";
		//Password
		obj[4][3]="AdValidPassword";
		//Url
		obj[4][4]="Valid Credentials";
		
		/*---------6th Parameter-------------*/
		//Websitename
		obj[5][0]="AE Website";
		//Domain
		obj[5][1]="AeUrl";
		//Username
		obj[5][2]="AdUserName";
		//Password
		obj[5][3]="AdInvalidPassword";
		//Url
		obj[5][4]="InValid Credentials";
		
		/*---------7th Parameter-------------*/
		//Websitename
		obj[6][0]="AE Website";
		//Domain
		obj[6][1]="AeUrl";
		//Username
		obj[6][2]="AdUserName";
		//Password
		obj[6][3]="AdValidPassword";
		//Url
		obj[6][4]="InValid Credentials";
		
		/*---------8th Parameter-------------*/
		//Websitename
		obj[7][0]="AE Website";
		//Domain
		obj[7][1]="AeUrl";
		//Username
		obj[7][2]="AdUserName";
		//Password
		obj[7][3]="AdInvalidPassword";
		//Url
		obj[7][4]="InValid Credentials";
		
		/*---------9th Parameter-------------*/
		//Websitename
		obj[8][0]="BE Website";
		//Domain
		obj[8][1]="BeUrl";
		//Username
		obj[8][2]="AdUserName";
		//Password
		obj[8][3]="AdValidPassword";
		//Url
		obj[8][4]="InValid Credentials";
		
		/*---------10th Parameter-------------*/
		//Websitename
		obj[9][0]="BE Website";
		//Domain
		obj[9][1]="BeUrl";
		//Username
		obj[9][2]="AdUserName";
		//Password
		obj[9][3]="AdInvalidPassword";
		//Url
		obj[9][4]="InValid Credentials";
		
		/*---------11th Parameter-------------*/
		//Websitename
		obj[10][0]="CL Website";
		//Domain
		obj[10][1]="ClUrl";
		//Username
		obj[10][2]="AdUserName";
		//Password
		obj[10][3]="AdValidPassword";
		//Url
		obj[10][4]="InValid Credentials";
		
		/*---------12th Parameter-------------*/
		//Websitename
		obj[11][0]="CL Website";
		//Domain
		obj[11][1]="ClUrl";
		//Username
		obj[11][2]="AdUserName";
		//Password
		obj[11][3]="AdInvalidPassword";
		//Url
		obj[11][4]="InValid Credentials";
		
		/*---------13th Parameter-------------*/
		//Websitename
		obj[12][0]="COM Website";
		//Domain
		obj[12][1]="ComUrl";
		//Username
		obj[12][2]="AdUserName";
		//Password
		obj[12][3]="AdValidPassword";
		//Url
		obj[12][4]="InValid Credentials";
		
		/*---------14th Parameter-------------*/
		//Websitename
		obj[13][0]="COM Website";
		//Domain
		obj[13][1]="ComUrl";
		//Username
		obj[13][2]="AdUserName";
		//Password
		obj[13][3]="AdInvalidPassword";
		//Url
		obj[13][4]="InValid Credentials";
		
		/*---------15th Parameter-------------*/
		//Websitename
		obj[14][0]="COM.BR Website";
		//Domain
		obj[14][1]="Com.brUrl";
		//Username
		obj[14][2]="AdUserName";
		//Password
		obj[14][3]="AdValidPassword";
		//Url
		obj[14][4]="InValid Credentials";
		
		/*---------16th Parameter-------------*/
		//Websitename
		obj[15][0]="COM.BR Website";
		//Domain
		obj[15][1]="Com.brUrl";
		//Username
		obj[15][2]="AdUserName";
		//Password
		obj[15][3]="AdInvalidPassword";
		//Url
		obj[15][4]="InValid Credentials";
		
		/*---------17th Parameter-------------*/
		//Websitename
		obj[16][0]="COM.CO Website";
		//Domain
		obj[16][1]="Com.coUrl";
		//Username
		obj[16][2]="AdUserName";
		//Password
		obj[16][3]="AdValidPassword";
		//Url
		obj[16][4]="InValid Credentials";
		
		/*---------18th Parameter-------------*/
		//Websitename
		obj[17][0]="COM.CO Website";
		//Domain
		obj[17][1]="Com.coUrl";
		//Username
		obj[17][2]="AdUserName";
		//Password
		obj[17][3]="AdInvalidPassword";
		//Url
		obj[17][4]="InValid Credentials";
		
		/*---------19th Parameter-------------*/
		//Websitename
		obj[18][0]="COM.MX Website";
		//Domain
		obj[18][1]="Com.mxUrl";
		//Username
		obj[18][2]="AdUserName";
		//Password
		obj[18][3]="AdValidPassword";
		//Url
		obj[18][4]="InValid Credentials";
		
		/*---------20th Parameter-------------*/
		//Websitename
		obj[19][0]="COM.MX Website";
		//Domain
		obj[19][1]="Com.mxUrl";
		//Username
		obj[19][2]="AdUserName";
		//Password
		obj[19][3]="AdInvalidPassword";
		//Url
		obj[19][4]="InValid Credentials";
		
		/*---------21th Parameter-------------*/
		//Websitename
		obj[20][0]="COM.PE Website";
		//Domain
		obj[20][1]="Com.peUrl";
		//Username
		obj[20][2]="AdUserName";
		//Password
		obj[20][3]="AdValidPassword";
		//Url
		obj[20][4]="InValid Credentials";
		
		/*---------22th Parameter-------------*/
		//Websitename
		obj[21][0]="COM.PE Website";
		//Domain
		obj[21][1]="Com.peUrl";
		//Username
		obj[21][2]="AdUserName";
		//Password
		obj[21][3]="AdInvalidPassword";
		//Url
		obj[21][4]="InValid Credentials";
		
		/*---------23th Parameter-------------*/
		//Websitename
		obj[22][0]="DE Website";
		//Domain
		obj[22][1]="DeUrl";
		//Username
		obj[22][2]="AdUserName";
		//Password
		obj[22][3]="AdValidPassword";
		//Url
		obj[22][4]="InValid Credentials";
		
		/*---------24th Parameter-------------*/
		//Websitename
		obj[23][0]="DE Website";
		//Domain
		obj[23][1]="DeUrl";
		//Username
		obj[23][2]="AdUserName";
		//Password
		obj[23][3]="AdInvalidPassword";
		//Url
		obj[23][4]="InValid Credentials";
		
		/*---------25th Parameter-------------*/
		//Websitename
		obj[24][0]="DK Website";
		//Domain
		obj[24][1]="DkUrl";
		//Username
		obj[24][2]="AdUserName";
		//Password
		obj[24][3]="AdValidPassword";
		//Url
		obj[24][4]="InValid Credentials";
		
		/*---------26th Parameter-------------*/
		//Websitename
		obj[25][0]="DK Website";
		//Domain
		obj[25][1]="DkUrl";
		//Username
		obj[25][2]="AdUserName";
		//Password
		obj[25][3]="AdInvalidPassword";
		//Url
		obj[25][4]="InValid Credentials";
		
		/*---------27th Parameter-------------*/
		//Websitename
		obj[26][0]="ES Website";
		//Domain
		obj[26][1]="EsUrl";
		//Username
		obj[26][2]="AdUserName";
		//Password
		obj[26][3]="AdValidPassword";
		//Url
		obj[26][4]="InValid Credentials";
		
		/*---------28th Parameter-------------*/
		//Websitename
		obj[27][0]="ES Website";
		//Domain
		obj[27][1]="EsUrl";
		//Username
		obj[27][2]="AdUserName";
		//Password
		obj[27][3]="AdInvalidPassword";
		//Url
		obj[27][4]="InValid Credentials";
		
		
		/*---------29th Parameter-------------*/
		//Websitename
		obj[28][0]="IE Website";
		//Domain
		obj[28][1]="IeUrl";
		//Username
		obj[28][2]="AdUserName";
		//Password
		obj[28][3]="AdValidPassword";
		//Url
		obj[28][4]="InValid Credentials";
		
		/*---------30th Parameter-------------*/
		//Websitename
		obj[29][0]="IE Website";
		//Domain
		obj[29][1]="IeUrl";
		//Username
		obj[29][2]="AdUserName";
		//Password
		obj[29][3]="AdInvalidPassword";
		//Url
		obj[29][4]="InValid Credentials";
		
		/*---------31st Parameter-------------*/
		//Websitename
		obj[30][0]="IT Website";
		//Domain
		obj[30][1]="ItUrl";
		//Username
		obj[30][2]="AdUserName";
		//Password
		obj[30][3]="AdValidPassword";
		//Url
		obj[30][4]="InValid Credentials";
		
		/*---------32nd Parameter-------------*/
		//Websitename
		obj[31][0]="IT Website";
		//Domain
		obj[31][1]="ItUrl";
		//Username
		obj[31][2]="AdUserName";
		//Password
		obj[31][3]="AdInvalidPassword";
		//Url
		obj[31][4]="InValid Credentials";
		
		/*---------33rd Parameter-------------*/
		//Websitename
		obj[32][0]="NI Website";
		//Domain
		obj[32][1]="NlUrl";
		//Username
		obj[32][2]="AdUserName";
		//Password
		obj[32][3]="AdValidPassword";
		//Url
		obj[32][4]="InValid Credentials";
		
		/*---------34th Parameter-------------*/
		//Websitename
		obj[33][0]="NI Website";
		//Domain
		obj[33][1]="NlUrl";
		//Username
		obj[33][2]="AdUserName";
		//Password
		obj[33][3]="AdInvalidPassword";
		//Url
		obj[33][4]="InValid Credentials";
		
		/*---------35th Parameter-------------*/
		//Websitename
		obj[34][0]="PT Website";
		//Domain
		obj[34][1]="PtUrl";
		//Username
		obj[34][2]="AdUserName";
		//Password
		obj[34][3]="AdValidPassword";
		//Url
		obj[34][4]="InValid Credentials";
		
		/*---------36th Parameter-------------*/
		//Websitename
		obj[35][0]="PT Website";
		//Domain
		obj[35][1]="PtUrl";
		//Username
		obj[35][2]="AdUserName";
		//Password
		obj[35][3]="AdInvalidPassword";
		//Url
		obj[35][4]="InValid Credentials";
		
		/*---------37th Parameter-------------*/
		//Websitename
		obj[36][0]="SE Website";
		//Domain
		obj[36][1]="SeUrl";
		//Username
		obj[36][2]="AdUserName";
		//Password
		obj[36][3]="AdValidPassword";
		//Url
		obj[36][4]="InValid Credentials";
		
		/*---------38th Parameter-------------*/
		//Websitename
		obj[37][0]="SE Website";
		//Domain
		obj[37][1]="SeUrl";
		//Username
		obj[37][2]="AdUserName";
		//Password
		obj[37][3]="AdInvalidPassword";
		//Url
		obj[37][4]="InValid Credentials";
		
		return obj;
		
	}
	
	@DataProvider (name ="ReissueCertificate")
	public static Object[][] ReissueCertificate(){
		Object[][] obj = new Object[1][5];
		
		/*---------1st Parameter-------------*/	
		//Username
		obj[0][0]="qa@ssl247.co.uk";
		//Password
		obj[0][1]="Test1234";
		//Url
		obj[0][2]="https://automation-live.ssl247.co.uk/";
		//Account Name
		obj[0][3]="UKTE001";
		//Column Product
		obj[0][4]="Symantec Secure Site Pro EV";
		
		
		/*---------2st Parameter-------------
		//Username
		obj[1][0]="qa@ssl247.co.uk";
		//Password
		obj[1][1]="Test1234";
		//Url
		obj[1][2]="https://automation-live.ssl247.co.uk/";
		//Account Name
		obj[1][3]="UKTE001";
		//Column Product
		obj[1][4]="Symantec Secure Site EV";
		*/	
		
		/*---------2st Parameter-------------	
		//Username
		obj[2][0]="qa@ssl247.co.uk";
		//Password
		obj[2][1]="Test1234";
		//Url
		obj[2][2]="https://automation-live.ssl247.co.uk/";
		//Account Name
		obj[2][3]="UKTE001";
		//Column Product
		obj[2][4]="RapidSSL Pro";
		*/
		return obj;
		
	}
	
	@DataProvider (name ="CreateUser")
	public static Object[][] CreateUser(){
		Object[][] obj = new Object[2][8];
		
		/*---------1st Parameter-------------*/	
		//Firstname
		obj[0][0]="Gideon";
		//Lastname
		obj[0][1]="Ogunleye1";
		//Email
		obj[0][2]="Gid1@ssl247-test.com";
		//Phone Number
		obj[0][3]="02037610541";
		//Address 1
		obj[0][4]="63 Lisson St, Marylebone";
		//State
		obj[0][5]="London";
		//Post code
		obj[0][6]="NW1 5DD";
		//Country
		obj[0][7]="United Kingdom";
		
		/*---------2nd Parameter-------------*/	
		//Firstname
		obj[1][0]="Gideon";
		//Lastname
		obj[1][1]="Ogunleye2";
		//Email
		obj[1][2]="Gid2@ssl247-test.com";
		//Phone Number
		obj[1][3]="02037610541";
		//Address 1
		obj[1][4]="63 Lisson St, Marylebone";
		//State
		obj[1][5]="London";
		//Post code
		obj[1][6]="NW1 5DD";
		//Country
		obj[1][7]="United Kingdom";

		
		return obj;
		
	}
	
	@DataProvider (name ="EditUserAllSites")
	public static Object[][] EditUserAllSites(){
		Object[][] obj = new Object[21][5];
		
		
		/*---------1st Parameter-------------*/	
		//Websitename
		obj[0][0]="Uk Website-01";
		//Domain
		obj[0][1]="Url";
		//Username
		obj[0][2]="AdUserName";
		//Password
		obj[0][3]="AdValidPassword";
		//Url
		obj[0][4]="Valid Credentials";
		
		
		/*---------2nd Parameter-------------*/
		//Websitename
		obj[1][0]="French Website-02";
		//Domain
		obj[1][1]="FrenchUrl";
		//Username
		obj[1][2]="AdUserName";
		//Password
		obj[1][3]="AdValidPassword";
		//Url
		obj[1][4]="Valid Credentials";
		
		
		/*---------3rd Parameter-------------*/	
		//Websitename
		obj[2][0]="AE Website-03";
		//Domain
		obj[2][1]="AeUrl";
		//Username
		obj[2][2]="AdUserName";
		//Password
		obj[2][3]="AdValidPassword";
		//Url
		obj[2][4]="Valid Credentials";
		
		
		/*---------4th Parameter-------------*/
		//Websitename
		obj[3][0]="BE Website-04";
		//Domain
		obj[3][1]="BeUrl";
		//Username
		obj[3][2]="AdUserName";
		//Password
		obj[3][3]="AdValidPassword";
		//Url
		obj[3][4]="Valid Credentials";
		
		/*---------5th Parameter-------------*/	
		//Websitename
		obj[4][0]="CL Website-05";
		//Domain
		obj[4][1]="ClUrl";
		//Username
		obj[4][2]="AdUserName";
		//Password
		obj[4][3]="AdValidPassword";
		//Url
		obj[4][4]="Valid Credentials";
		
		/*---------6th Parameter-------------*/
		//Websitename
		obj[5][0]="Com Website-06";
		//Domain
		obj[5][1]="ComUrl";
		//Username
		obj[5][2]="AdUserName";
		//Password
		obj[5][3]="AdValidPassword";
		//Url
		obj[5][4]="Valid Credentials";
		
		/*---------7th Parameter-------------*/
		//Websitename
		obj[6][0]="Com.Br Website-07";
		//Domain
		obj[6][1]="Com.brUrl";
		//Username
		obj[6][2]="AdUserName";
		//Password
		obj[6][3]="AdValidPassword";
		//Url
		obj[6][4]="Valid Credentials";
		
		/*---------8th Parameter-------------*/
		//Websitename
		obj[7][0]="Com.co Website-08";
		//Domain
		obj[7][1]="Com.coUrl";
		//Username
		obj[7][2]="AdUserName";
		//Password
		obj[7][3]="AdValidPassword";
		//Url
		obj[7][4]="Valid Credentials";
		
		/*---------9th Parameter-------------*/
		//Websitename
		obj[8][0]="Com.mx Website-09";
		//Domain
		obj[8][1]="Com.mxUrl";
		//Username
		obj[8][2]="AdUserName";
		//Password
		obj[8][3]="AdValidPassword";
		//Url
		obj[8][4]="Valid Credentials";
		
		/*---------10th Parameter-------------*/
		//Websitename
		obj[9][0]="Com.pe Website-10";
		//Domain
		obj[9][1]="Com.peUrl";
		//Username
		obj[9][2]="AdUserName";
		//Password
		obj[9][3]="AdValidPassword";
		//Url
		obj[9][4]="Valid Credentials";
		
		/*---------11th Parameter-------------*/
		//Websitename
		obj[10][0]="DE Website-11";
		//Domain
		obj[10][1]="DeUrl";
		//Username
		obj[10][2]="AdUserName";
		//Password
		obj[10][3]="AdValidPassword";
		//Url
		obj[10][4]="Valid Credentials";
		
		/*---------12th Parameter-------------*/
		//Websitename
		obj[11][0]="DK Website-12";
		//Domain
		obj[11][1]="DkUrl";
		//Username
		obj[11][2]="AdUserName";
		//Password
		obj[11][3]="AdValidPassword";
		//Url
		obj[11][4]="Valid Credentials";
		
		/*---------13th Parameter-------------*/
		//Websitename
		obj[12][0]="ES Website-13";
		//Domain
		obj[12][1]="EsUrl";
		//Username
		obj[12][2]="AdUserName";
		//Password
		obj[12][3]="AdValidPassword";
		//Url
		obj[12][4]="Valid Credentials";
		
		/*---------14th Parameter-------------*/
		//Websitename
		obj[13][0]="IE Website-14";
		//Domain
		obj[13][1]="IeUrl";
		//Username
		obj[13][2]="AdUserName";
		//Password
		obj[13][3]="AdValidPassword";
		//Url
		obj[13][4]="Valid Credentials";
		
		/*---------15th Parameter-------------*/
		//Websitename
		obj[14][0]="IT Website-15";
		//Domain
		obj[14][1]="ItUrl";
		//Username
		obj[14][2]="AdUserName";
		//Password
		obj[14][3]="AdValidPassword";
		//Url
		obj[14][4]="Valid Credentials";
		
		/*---------16th Parameter-------------*/
		//Websitename
		obj[15][0]="NI Website-16";
		//Domain
		obj[15][1]="NlUrl";
		//Username
		obj[15][2]="AdUserName";
		//Password
		obj[15][3]="AdValidPassword";
		//Url
		obj[15][4]="Valid Credentials";
		
		/*---------17th Parameter-------------*/
		//Websitename
		obj[16][0]="PT Website-17";
		//Domain
		obj[16][1]="PtUrl";
		//Username
		obj[16][2]="AdUserName";
		//Password
		obj[16][3]="AdValidPassword";
		//Url
		obj[16][4]="Valid Credentials";
		
		/*---------18th Parameter-------------*/
		//Websitename
		obj[17][0]="SE Website-18";
		//Domain
		obj[17][1]="SeUrl";
		//Username
		obj[17][2]="AdUserName";
		//Password
		obj[17][3]="AdValidPassword";
		//Url
		obj[17][4]="Valid Credentials";
		
		
		return obj;
		
	}
	
	@DataProvider (name ="DataAllSites")
	public static Object[][] DataAllSites(){
		Object[][] obj = new Object[18][5];
		
		
		/*---------1st Parameter-------------*/	
		//Websitename
		obj[0][0]="Uk Website-01";
		//Domain
		obj[0][1]="Url";
		//Username
		obj[0][2]="AdUserName";
		//Password
		obj[0][3]="AdValidPassword";
		//Url
		obj[0][4]="Valid Credentials";
		
		
		/*---------2nd Parameter-------------*/
		//Websitename
		obj[1][0]="French Website-02";
		//Domain
		obj[1][1]="FrenchUrl";
		//Username
		obj[1][2]="AdUserName";
		//Password
		obj[1][3]="AdValidPassword";
		//Url
		obj[1][4]="Valid Credentials";
		
		
		/*---------3rd Parameter-------------*/	
		//Websitename
		obj[2][0]="AE Website-03";
		//Domain
		obj[2][1]="AeUrl";
		//Username
		obj[2][2]="AdUserName";
		//Password
		obj[2][3]="AdValidPassword";
		//Url
		obj[2][4]="Valid Credentials";
		
		
		/*---------4th Parameter-------------*/
		//Websitename
		obj[3][0]="BE Website-04";
		//Domain
		obj[3][1]="BeUrl";
		//Username
		obj[3][2]="AdUserName";
		//Password
		obj[3][3]="AdValidPassword";
		//Url
		obj[3][4]="Valid Credentials";
		
		/*---------5th Parameter-------------*/	
		//Websitename
		obj[4][0]="CL Website-05";
		//Domain
		obj[4][1]="ClUrl";
		//Username
		obj[4][2]="AdUserName";
		//Password
		obj[4][3]="AdValidPassword";
		//Url
		obj[4][4]="Valid Credentials";
		
		/*---------6th Parameter-------------*/
		//Websitename
		obj[5][0]="Com Website-06";
		//Domain
		obj[5][1]="ComUrl";
		//Username
		obj[5][2]="AdUserName";
		//Password
		obj[5][3]="AdValidPassword";
		//Url
		obj[5][4]="Valid Credentials";
		
		/*---------7th Parameter-------------*/
		//Websitename
		obj[6][0]="Com.Br Website-07";
		//Domain
		obj[6][1]="Com.brUrl";
		//Username
		obj[6][2]="AdUserName";
		//Password
		obj[6][3]="AdValidPassword";
		//Url
		obj[6][4]="Valid Credentials";
		
		/*---------8th Parameter-------------*/
		//Websitename
		obj[7][0]="Com.co Website-08";
		//Domain
		obj[7][1]="Com.coUrl";
		//Username
		obj[7][2]="AdUserName";
		//Password
		obj[7][3]="AdValidPassword";
		//Url
		obj[7][4]="Valid Credentials";
		
		/*---------9th Parameter-------------*/
		//Websitename
		obj[8][0]="Com.mx Website-09";
		//Domain
		obj[8][1]="Com.mxUrl";
		//Username
		obj[8][2]="AdUserName";
		//Password
		obj[8][3]="AdValidPassword";
		//Url
		obj[8][4]="Valid Credentials";
		
		/*---------10th Parameter-------------*/
		//Websitename
		obj[9][0]="Com.pe Website-10";
		//Domain
		obj[9][1]="Com.peUrl";
		//Username
		obj[9][2]="AdUserName";
		//Password
		obj[9][3]="AdValidPassword";
		//Url
		obj[9][4]="Valid Credentials";
		
		/*---------11th Parameter-------------*/
		//Websitename
		obj[10][0]="DE Website-11";
		//Domain
		obj[10][1]="DeUrl";
		//Username
		obj[10][2]="AdUserName";
		//Password
		obj[10][3]="AdValidPassword";
		//Url
		obj[10][4]="Valid Credentials";
		
		/*---------12th Parameter-------------*/
		//Websitename
		obj[11][0]="DK Website-12";
		//Domain
		obj[11][1]="DkUrl";
		//Username
		obj[11][2]="AdUserName";
		//Password
		obj[11][3]="AdValidPassword";
		//Url
		obj[11][4]="Valid Credentials";
		
		/*---------13th Parameter-------------*/
		//Websitename
		obj[12][0]="ES Website-13";
		//Domain
		obj[12][1]="EsUrl";
		//Username
		obj[12][2]="AdUserName";
		//Password
		obj[12][3]="AdValidPassword";
		//Url
		obj[12][4]="Valid Credentials";
		
		/*---------14th Parameter-------------*/
		//Websitename
		obj[13][0]="IE Website-14";
		//Domain
		obj[13][1]="IeUrl";
		//Username
		obj[13][2]="AdUserName";
		//Password
		obj[13][3]="AdValidPassword";
		//Url
		obj[13][4]="Valid Credentials";
		
		/*---------15th Parameter-------------*/
		//Websitename
		obj[14][0]="IT Website-15";
		//Domain
		obj[14][1]="ItUrl";
		//Username
		obj[14][2]="AdUserName";
		//Password
		obj[14][3]="AdValidPassword";
		//Url
		obj[14][4]="Valid Credentials";
		
		/*---------16th Parameter-------------*/
		//Websitename
		obj[15][0]="NI Website-16";
		//Domain
		obj[15][1]="NlUrl";
		//Username
		obj[15][2]="AdUserName";
		//Password
		obj[15][3]="AdValidPassword";
		//Url
		obj[15][4]="Valid Credentials";
		
		/*---------17th Parameter-------------*/
		//Websitename
		obj[16][0]="PT Website-17";
		//Domain
		obj[16][1]="PtUrl";
		//Username
		obj[16][2]="AdUserName";
		//Password
		obj[16][3]="AdValidPassword";
		//Url
		obj[16][4]="Valid Credentials";
		
		/*---------18th Parameter-------------*/
		//Websitename
		obj[17][0]="SE Website-18";
		//Domain
		obj[17][1]="SeUrl";
		//Username
		obj[17][2]="AdUserName";
		//Password
		obj[17][3]="AdValidPassword";
		//Url
		obj[17][4]="Valid Credentials";

		return obj;
		
	}
	/*
	@DataProvider (name ="ExcelTest")
	public static Object[][] ExcelTest(){
		Object[][] testData =  ExcelUtility.getTestData("Invalid_Login");
	
		return testData;
		
	}
	*/
	
	@DataProvider(name = "loginData")
	public static Object[][] dataProvider(){
		
			
		Object[][] testData = ExcelUtility.getTestData("Invalid_Login");
		
		for(Object o:testData){
			
			System.out.println(o.toString());
		}
		
		return testData;
	}
	
	@DataProvider (name ="IndexLinksAllSites")
	public static Object[][] IndexLinksAllSites(){
		Object[][] obj = new Object[18][5];
		
		
		/*---------1st Parameter-------------*/	
		//MainLink
		obj[0][0]="Uk Website-01";
		//Sublink
		obj[0][1]="about/SSEaccredited";
		//Username
		obj[0][2]="AdUserName";
		//Password
		obj[0][3]="AdValidPassword";
		//Url
		obj[0][4]="Valid Credentials";
		
		
		/*---------2nd Parameter-------------*/
		//Websitename
		obj[1][0]="French Website-02";
		//Domain
		obj[1][1]="FrenchUrl";
		//Username
		obj[1][2]="AdUserName";
		//Password
		obj[1][3]="AdValidPassword";
		//Url
		obj[1][4]="Valid Credentials";
		
		
		/*---------3rd Parameter-------------*/	
		//Websitename
		obj[2][0]="AE Website-03";
		//Domain
		obj[2][1]="AeUrl";
		//Username
		obj[2][2]="AdUserName";
		//Password
		obj[2][3]="AdValidPassword";
		//Url
		obj[2][4]="Valid Credentials";
		
		
		/*---------4th Parameter-------------*/
		//Websitename
		obj[3][0]="BE Website-04";
		//Domain
		obj[3][1]="BeUrl";
		//Username
		obj[3][2]="AdUserName";
		//Password
		obj[3][3]="AdValidPassword";
		//Url
		obj[3][4]="Valid Credentials";
		
		/*---------5th Parameter-------------*/	
		//Websitename
		obj[4][0]="CL Website-05";
		//Domain
		obj[4][1]="ClUrl";
		//Username
		obj[4][2]="AdUserName";
		//Password
		obj[4][3]="AdValidPassword";
		//Url
		obj[4][4]="Valid Credentials";
		
		/*---------6th Parameter-------------*/
		//Websitename
		obj[5][0]="Com Website-06";
		//Domain
		obj[5][1]="ComUrl";
		//Username
		obj[5][2]="AdUserName";
		//Password
		obj[5][3]="AdValidPassword";
		//Url
		obj[5][4]="Valid Credentials";
		
		/*---------7th Parameter-------------*/
		//Websitename
		obj[6][0]="Com.Br Website-07";
		//Domain
		obj[6][1]="Com.brUrl";
		//Username
		obj[6][2]="AdUserName";
		//Password
		obj[6][3]="AdValidPassword";
		//Url
		obj[6][4]="Valid Credentials";
		
		/*---------8th Parameter-------------*/
		//Websitename
		obj[7][0]="Com.co Website-08";
		//Domain
		obj[7][1]="Com.coUrl";
		//Username
		obj[7][2]="AdUserName";
		//Password
		obj[7][3]="AdValidPassword";
		//Url
		obj[7][4]="Valid Credentials";
		
		/*---------9th Parameter-------------*/
		//Websitename
		obj[8][0]="Com.mx Website-09";
		//Domain
		obj[8][1]="Com.mxUrl";
		//Username
		obj[8][2]="AdUserName";
		//Password
		obj[8][3]="AdValidPassword";
		//Url
		obj[8][4]="Valid Credentials";
		
		/*---------10th Parameter-------------*/
		//Websitename
		obj[9][0]="Com.pe Website-10";
		//Domain
		obj[9][1]="Com.peUrl";
		//Username
		obj[9][2]="AdUserName";
		//Password
		obj[9][3]="AdValidPassword";
		//Url
		obj[9][4]="Valid Credentials";
		
		/*---------11th Parameter-------------*/
		//Websitename
		obj[10][0]="DE Website-11";
		//Domain
		obj[10][1]="DeUrl";
		//Username
		obj[10][2]="AdUserName";
		//Password
		obj[10][3]="AdValidPassword";
		//Url
		obj[10][4]="Valid Credentials";
		
		/*---------12th Parameter-------------*/
		//Websitename
		obj[11][0]="DK Website-12";
		//Domain
		obj[11][1]="DkUrl";
		//Username
		obj[11][2]="AdUserName";
		//Password
		obj[11][3]="AdValidPassword";
		//Url
		obj[11][4]="Valid Credentials";
		
		/*---------13th Parameter-------------*/
		//Websitename
		obj[12][0]="ES Website-13";
		//Domain
		obj[12][1]="EsUrl";
		//Username
		obj[12][2]="AdUserName";
		//Password
		obj[12][3]="AdValidPassword";
		//Url
		obj[12][4]="Valid Credentials";
		
		/*---------14th Parameter-------------*/
		//Websitename
		obj[13][0]="IE Website-14";
		//Domain
		obj[13][1]="IeUrl";
		//Username
		obj[13][2]="AdUserName";
		//Password
		obj[13][3]="AdValidPassword";
		//Url
		obj[13][4]="Valid Credentials";
		
		/*---------15th Parameter-------------*/
		//Websitename
		obj[14][0]="IT Website-15";
		//Domain
		obj[14][1]="ItUrl";
		//Username
		obj[14][2]="AdUserName";
		//Password
		obj[14][3]="AdValidPassword";
		//Url
		obj[14][4]="Valid Credentials";
		
		/*---------16th Parameter-------------*/
		//Websitename
		obj[15][0]="NI Website-16";
		//Domain
		obj[15][1]="NlUrl";
		//Username
		obj[15][2]="AdUserName";
		//Password
		obj[15][3]="AdValidPassword";
		//Url
		obj[15][4]="Valid Credentials";
		
		/*---------17th Parameter-------------*/
		//Websitename
		obj[16][0]="PT Website-17";
		//Domain
		obj[16][1]="PtUrl";
		//Username
		obj[16][2]="AdUserName";
		//Password
		obj[16][3]="AdValidPassword";
		//Url
		obj[16][4]="Valid Credentials";
		
		/*---------18th Parameter-------------*/
		//Websitename
		obj[17][0]="SE Website-18";
		//Domain
		obj[17][1]="SeUrl";
		//Username
		obj[17][2]="AdUserName";
		//Password
		obj[17][3]="AdValidPassword";
		//Url
		obj[17][4]="Valid Credentials";

		return obj;
	}
	
}
