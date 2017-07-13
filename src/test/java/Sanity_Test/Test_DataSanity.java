package Sanity_Test;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class Test_DataSanity {
	

	@DataProvider (name ="ReissueCertificate")
	public static Object[][] ReissueCertificate(){
		Object[][] obj = new Object[2][5];
		
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
		obj[0][4]="RapidSSL Pro";
		
		/*---------2st Parameter-------------*/	
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
		
		return obj;
		
	}
}
