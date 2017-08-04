package Sanity_Test;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class Test_DataSanity {
	
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
}
