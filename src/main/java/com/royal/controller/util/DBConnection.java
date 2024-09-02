package com.royal.controller.util;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBConnection {

	private static final String URLNAME = "jdbc:mysql://localhost:3306/test";
	private static final String DRIVERCLASS = "com.mysql.cj.jdbc.Driver";
	private static final String USERNAME = "root";
	private static final String PASSWORD = "root";
	
//2) create getconnection method
	public static Connection getConnection()
	{
		Connection conn = null;
		try {
			Class.forName(DRIVERCLASS);
			//4) pass credentials into Drivermanager's get connection
			conn = DriverManager.getConnection(URLNAME, USERNAME, PASSWORD);
			// 5) validate connection object
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return conn;
	}
	
	public static void main(String[] args) {
		Connection conn = DBConnection.getConnection();
		System.out.println(conn);
	}

}
