package com.payment.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.payment.models.User;

public class LoginDAO {
	
	public User logAuth(String userName, String password) {
		User user = null;
		
			try {
			Connection connect = DBConnection.getConnection();
			PreparedStatement stmt = connect.prepareStatement("SELECT * FROM users WHERE userName = ? and password=? ");
			stmt.setString(1,userName);
			stmt.setString(2,password);
			ResultSet set = stmt.executeQuery();
			while(set.next()) {
				 user = new User();
				 user.setUserID(set.getInt("userID"));
				 user.setUsername(set.getString("userName"));
				 user.setPassword(set.getString("password"));
				 user.setRole(set.getString("role"));  
		      }
			}catch (SQLException e) {
				e.printStackTrace();
			}
		return user;
     }
}
	
