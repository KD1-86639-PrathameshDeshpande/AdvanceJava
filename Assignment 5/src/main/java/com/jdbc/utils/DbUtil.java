package com.jdbc.utils;

import java.sql.Connection;
import java.sql.DriverManager;

public class DbUtil
{
	public static final String DB_DRIVER = "com.mysql.cj.jdbc.Driver";
	public static final String DB_URL = "jdbc:mysql://localhost:3306/jdbc_demo_kdac";
	public static final String DB_USER = "KD1_Abhijeet_86738";
	public static final String DB_PASSWD = "Abhi12";

	static {
		// load and register driver
		try {
			Class.forName(DB_DRIVER);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
			System.exit(1);
		}
	}

	public static Connection getConnection() throws Exception {
		Connection con = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWD);
		return con;
	}
}
