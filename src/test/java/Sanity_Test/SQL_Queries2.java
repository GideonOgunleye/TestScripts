package Sanity_Test;

import org.testng.annotations.Test;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;

import BaseUtilities.BrowserStack;
import BaseUtilities.DriverLoad;

import org.testng.annotations.BeforeSuite;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterSuite;

public class SQL_Queries2 {
	
	
	@Test (priority = 1, groups = {"SQL","BS_Sanity","Smoke_Firefox"})
	  public void SQL_DeleteAccount () throws SQLException, ClassNotFoundException {
		  
			//Connection URL Syntax: "jdbc:mysql://ipaddress:portnumber/db_name"		
	      String dbUrl = "jdbc:mysql://notcraft3.covetytyjb4n.eu-west-1.rds.amazonaws.com";					

			//Database Username		
			String username = "gogunleye";	
	      
			//Database Password		
			String password = "n8hY5HqCkd7suLSM";				

			//Query to Execute		
			//String query = "select *  from bakewell_staging_go.accounts Where account_code ='QUAL017';";	
			String query2 = "delete from bakewell_automation.accounts Where account_code ='QUAL017';";
	      
		    //Load mysql jdbc driver		
	 	    Class.forName("com.mysql.jdbc.Driver");			
	 
	 		//Create Connection to DB		
	  	Connection con = DriverManager.getConnection(dbUrl,username,password);
	  	Statement stmt = con.createStatement();	
	  	stmt.execute(query2);
	  	System.out.println("Account Has Been Deleted");
	  	con.close();
	  	
	/*
			//Create Statement Object		
		   Statement stmt = con.createStatement();	
		   	   
				// Execute the SQL Query. Store results in ResultSet		
			ResultSet rs= stmt.executeQuery(query2);							

			// While Loop to iterate through all data and print results		
			while (rs.next()){
		        	  String AccCode = rs.getString("account_code");								        
	                  String name = rs.getString("name");					                               
	                  System. out.println(AccCode+"  "+name);		
	          }		
	*/		
			 // closing DB Connection				
		  
	  }
	  
	  @Test (priority = 2, groups = {"SQL","BS_Sanity","BS_Smoke","Smoke_Firefox"})
	  public void SQL_DeleteUser () throws SQLException, ClassNotFoundException {
		  
			//Connection URL Syntax: "jdbc:mysql://ipaddress:portnumber/db_name"		
	      String dbUrl = "jdbc:mysql://notcraft3.covetytyjb4n.eu-west-1.rds.amazonaws.com";					

			//Database Username		
			String username = "gogunleye";	
	      
			//Database Password		
			String password = "n8hY5HqCkd7suLSM";				

			//Query to Execute		
			//String query = "select *  from bakewell_staging_go.accounts Where account_code ='QUAL017';";	
			String query2 = "delete from bakewell_automation.users Where email ='QATester2@ssl247-test.com';";
	      
		    //Load mysql jdbc driver		
	 	    Class.forName("com.mysql.jdbc.Driver");			
	 
	 		//Create Connection to DB		
	  	Connection con = DriverManager.getConnection(dbUrl,username,password);
	  	Statement stmt = con.createStatement();	
	  	stmt.execute(query2);
	  	System.out.println("User Has Been Deleted");
	  	
	  	
	/*
			//Create Statement Object		
		   Statement stmt = con.createStatement();	
		   	   
				// Execute the SQL Query. Store results in ResultSet		
			ResultSet rs= stmt.executeQuery(query2);							

			// While Loop to iterate through all data and print results		
			while (rs.next()){
		        	  String AccCode = rs.getString("account_code");								        
	                  String name = rs.getString("name");					                               
	                  System. out.println(AccCode+"  "+name);		
	          }		
	*/		
			 // closing DB Connection		
			con.close();		
		  
	  }
/*	  
	  @Test (priority = 3, groups = {"SQL"})
	  public void SQL_DeleteDomain_Order () throws SQLException, ClassNotFoundException {
		  
			//Connection URL Syntax: "jdbc:mysql://ipaddress:portnumber/db_name"		
	      String dbUrl = "jdbc:mysql://notcraft-prod.covetytyjb4n.eu-west-1.rds.amazonaws.com";					

			//Database Username		
			String username = "gogunleye";	
	      
			//Database Password		
			String password = "n8hY5HqCkd7suLSM";				

			//Query to Execute		
			//String query = "select *  from bakewell_staging_go.accounts Where account_code ='QUAL017';";	
			String query2 = "delete from bakewell_staging_go.domain_names Where domain_name ='ssl247.net';";
	      
		    //Load mysql jdbc driver		
	 	    Class.forName("com.mysql.jdbc.Driver");			
	 
	 		//Create Connection to DB		
	  	Connection con = DriverManager.getConnection(dbUrl,username,password);
	  	Statement stmt = con.createStatement();	
	  	stmt.execute(query2);
	  	System.out.println("User Has Been Deleted");		
		con.close();			  
	  }	
*/
	  
	  @Test (priority = 4, groups = {"SQL","BS_Sanity","Smoke_Firefox"})
	  public void SQL_Certificate_Order () throws SQLException, ClassNotFoundException {
		  
			//Connection URL Syntax: "jdbc:mysql://ipaddress:portnumber/db_name"		
	      String dbUrl = "jdbc:mysql://notcraft3.covetytyjb4n.eu-west-1.rds.amazonaws.com";					

			//Database Username		
			String username = "gogunleye";	
	      
			//Database Password		
			String password = "n8hY5HqCkd7suLSM";				

			//Query to Execute		
			//String query = "select *  from bakewell_staging_go.accounts Where account_code ='QUAL017';";	
			String query2 = "delete from bakewell_automation.certificates Where common_name ='ssl247.co.uk';";
			String query3 = "delete from bakewell_automation.certificates Where common_name ='ssl247-test.co.uk';";
	      
		    //Load mysql jdbc driver		
	 	    Class.forName("com.mysql.jdbc.Driver");			
	 
	 		//Create Connection to DB		
	  	Connection con = DriverManager.getConnection(dbUrl,username,password);
	  	Statement stmt = con.createStatement();	
	  	stmt.execute(query2);
	  	
	  	stmt.execute(query3);
	  	
	  	System.out.println("Certificates Have Been Deleted");		
		con.close();		
		  
	  }	
	  
	  @Test (priority = 5, groups = {"SQL","BS_Sanity","Smoke_Firefox"})
	  public void SQL_DomainName_Order () throws SQLException, ClassNotFoundException {
		  
			//Connection URL Syntax: "jdbc:mysql://ipaddress:portnumber/db_name"		
	      String dbUrl = "jdbc:mysql://notcraft3.covetytyjb4n.eu-west-1.rds.amazonaws.com";					

			//Database Username		
			String username = "gogunleye";	
	      
			//Database Password		
			String password = "n8hY5HqCkd7suLSM";				

			//Query to Execute		
			//String query = "select *  from bakewell_staging_go.accounts Where account_code ='QUAL017';";	
			String query2 = "delete from bakewell_automation.domain_names where domain_name = 'ssl247test.net';";
	      
		    //Load mysql jdbc driver		
	 	    Class.forName("com.mysql.jdbc.Driver");			
	 
	 		//Create Connection to DB		
	  	Connection con = DriverManager.getConnection(dbUrl,username,password);
	  	Statement stmt = con.createStatement();	
	  	stmt.execute(query2);
	  	System.out.println("Ordered Domain Names Have Been Deleted");		
		con.close();		
		  
	  }	
	  
	  @Test (priority = 6, groups = {"SQL","BS_Sanity","Smoke_Firefox"})
	  public void Delete_User() throws SQLException, ClassNotFoundException {
		  
			//Connection URL Syntax: "jdbc:mysql://ipaddress:portnumber/db_name"		
	      String dbUrl = "jdbc:mysql://notcraft3.covetytyjb4n.eu-west-1.rds.amazonaws.com";					

			//Database Username		
			String username = "gogunleye";	
	      
			//Database Password		
			String password = "n8hY5HqCkd7suLSM";				

			//Query to Execute		
			//String query = "select *  from bakewell_staging_go.accounts Where account_code ='QUAL017';";	
			String query1 = "delete from bakewell_automation.users where lastname = 'Ogunleye1';";
			String query2 = "delete from bakewell_automation.users where lastname = 'Ogunleye2';";
	      
		    //Load mysql jdbc driver		
	 	    Class.forName("com.mysql.jdbc.Driver");			
	 
	 		//Create Connection to DB		
	  	Connection con = DriverManager.getConnection(dbUrl,username,password);
	  	Statement stmt = con.createStatement();	
	  	stmt.execute(query1);
	  	System.out.println("User Ogunleye 1 Deleted");	
	  	
	
	  	Statement stmt2 = con.createStatement();	
	  	stmt2.execute(query2);
	  	System.out.println("User Ogunleye 2 Deleted");	
	  	
	  	
		con.close();		
		  
	  }	
	/* 
	  @Test (priority = 6, groups = {"SQL","BS_Sanity","Smoke_Firefox"})
	  public void Update_StatusID() throws SQLException, ClassNotFoundException {
		  
			//Connection URL Syntax: "jdbc:mysql://ipaddress:portnumber/db_name"		
	      String dbUrl = "jdbc:mysql://notcraft3.covetytyjb4n.eu-west-1.rds.amazonaws.com";					

			//Database Username		
			String username = "gogunleye";	
	      
			//Database Password		
			String password = "n8hY5HqCkd7suLSM";				

			//Query to Execute		
			//String query = "select *  from bakewell_staging_go.accounts Where account_code ='QUAL017';";	
			String query1 = "update bakewell_automation.certificates set status_minor_id = 1 where common_name='ssl247-test.com';";
	      
		    //Load mysql jdbc driver		
	 	    Class.forName("com.mysql.jdbc.Driver");			
	 
	 		//Create Connection to DB		
	  	Connection con = DriverManager.getConnection(dbUrl,username,password);
	  	Statement stmt = con.createStatement();	
	  	stmt.execute(query1);
	  	System.out.println("Certificate Updated");	
	  		
		con.close();		
		  
	  }	
	  */
}
