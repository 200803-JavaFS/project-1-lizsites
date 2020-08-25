package com.revature.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionUtil {
	private static final String CONNECTION_USERNAME = "postgres";
	private static final String CONNECTION_PASSWORD = "password";
	private static final String CONNECTION_URL = "jdbc:postgresql://javafs200803.cg0rpxexvjxn.us-east-2.rds.amazonaws.com/project1";
	private static Connection connection;
	
	public static synchronized Connection getConnection() throws SQLException {
		if (connection == null) {
			
			try {
			Class.forName("org.postgresql.Driver");
			} catch (ClassNotFoundException e) {
				System.out.println("Could not register driver!!!!!!!!!!");
				e.printStackTrace();
			}
			connection = DriverManager.getConnection(CONNECTION_URL , CONNECTION_USERNAME , CONNECTION_PASSWORD );
		}
		
		if (connection.isClosed()) {
			System.out.println("Opening a new connection!!!!!!!");
			connection = DriverManager.getConnection(CONNECTION_URL, CONNECTION_USERNAME, CONNECTION_PASSWORD );
		}
		
		if (connection == null) {
			System.out.println("connection is closed....");
		} 
		
		return connection;
	}
	
}
