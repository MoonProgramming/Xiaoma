package com.MoonLikeCats.conn;

import java.sql.Connection;

public class DBConnectionUtils {
	
	public static Connection getDBConnection() {
		try {
			return MySQLConn.getMySqlConnection();
		} catch (ClassNotFoundException e) {
			
			e.printStackTrace();
		}
		return null;
	}
	
	public static void closeQuietly(Connection conn) {
        try {
            conn.close();
            System.out.println("mysql connection closed");
        } catch (Exception e) {
        	System.out.println("close mysql connection failed");
        }
    }
 
    public static void rollbackQuietly(Connection conn) {
        try {
            conn.rollback();
            System.out.println("mysql connection rollbacked");
        } catch (Exception e) {
        	System.out.println("rollback mysql connection failed");
        }
    }
}
