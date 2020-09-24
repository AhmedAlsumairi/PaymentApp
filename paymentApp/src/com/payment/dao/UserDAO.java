package com.payment.dao;

import java.sql.DriverManager;
import java.sql.SQLException;

import java.sql.Connection;
import java.sql.PreparedStatement;
import com.payment.models.User;

public class UserDAO {
	
	public void addUser(User user) {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection connect = DriverManager
                    .getConnection("jdbc:mysql://localhost:3306/test","root","");
			PreparedStatement stmt = connect.prepareStatement("insert into users (userName,password,role)  values(?,?,?)");
			stmt.setString(1,user.getUsername());
			stmt.setString(2,user.getPassword());
			stmt.setString(3,user.getRole());
			boolean sataus = stmt.execute();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
