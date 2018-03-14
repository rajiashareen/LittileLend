package com.littlelend.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnection {
	
	public static Connection getConnection() throws ClassNotFoundException, SQLException {
		   Class.forName("com.mysql.jdbc.Driver");    
		   String dbName = "littlelend";        
	          String userName = "Shareen";        
	          String password = "Shareen_1994";      
	          String hostname = "jdbc:mysql://littilelendmyinstance.cmryltifugcn.us-east-2.rds.amazonaws.com:3306/littlelend";       
	          return DriverManager.getConnection(hostname,userName,password);
	          
	          
	    }

}
