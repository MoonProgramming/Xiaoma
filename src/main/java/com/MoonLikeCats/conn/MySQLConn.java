package com.MoonLikeCats.conn;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class MySQLConn {

	public static Connection getMySqlConnection() throws ClassNotFoundException {
		String hostName = "localhost";
	    String dbName = "testschema";
	    String userName = "root";
	    String password = "tangerine";
	    return getMySQLConnection(hostName, dbName, userName, password);
	}

	private static Connection getMySQLConnection(String hostName, String dbName, String userName, String password) throws ClassNotFoundException {

		Class.forName("com.mysql.jdbc.Driver");
		
		// URL Connection for MySQL:
	    // Example: jdbc:mysql://localhost:3306/simplehr
	    String connectionURL = "jdbc:mysql://" + hostName + ":3306/" + dbName;

	    try {
			Connection conn = DriverManager.getConnection(connectionURL, userName, password);
			if (conn != null) {
				System.out.println("mysql connection established");
			}
			else {
				System.out.println("mysql connection failed");
			}
			return conn;
		} catch (SQLException e) {
			System.out.println("mysql connection exception");
			e.printStackTrace();
			return null;
		}
	}
}
