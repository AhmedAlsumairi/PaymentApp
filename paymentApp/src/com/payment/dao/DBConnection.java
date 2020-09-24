package com.payment.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {
	private static Connection  connect = null;
 public static Connection getConnection() {
			try {
				Class.forName("com.mysql.jdbc.Driver");
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			}
			try {
				connect = DriverManager
				     .getConnection("jdbc:mysql://localhost:3306/test","root","");
			} catch (SQLException e) {
				e.printStackTrace();
			}	
			return connect;
    }
}
