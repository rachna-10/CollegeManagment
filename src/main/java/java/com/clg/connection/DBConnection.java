package com.clg.connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DBConnection {
    private static final String driver = "com.mysql.cj.jdbc.Driver";
    private static final String url = "jdbc:mysql://localhost:3306/college_db";
    private static final String userName = "root";
    private static final String password = "rachna@10";

    public static Connection getConnection() {
                 Connection conn = null;

                 try {
                               Class.forName(driver);
                               conn = DriverManager.getConnection(url, userName, password);
                               System.out.println("Connection success..");

                 } catch (Exception e) {
                               e.printStackTrace();

                 }
                 return conn;
    }
    public static void main(String[] args) {
    
    	Connection conn = null;
		try {
			conn = DriverManager.getConnection(url, userName, password);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {

			if (conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {
					
					e.printStackTrace();
				}
			}

		}
 System.out.println("All connection closed");
	}

    	
		
	}

