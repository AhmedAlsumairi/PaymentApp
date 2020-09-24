package com.payment.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.payment.models.Payment;
import com.payment.models.User;

public class PaymentDAO {	
	private List<Payment> listP;


	public void addPayment(Payment payment, int userID) {
		try {
			Connection connect = DBConnection.getConnection();
			PreparedStatement stmt = connect.prepareStatement("insert into payments (paymentType,paymentDate,cardNo,cardExpiryDate,orderId,ccv,paymentStatus,user_id) values(?,?,?,?,?,?,?,?,?)");
			stmt.setString(1,payment.getPaymentType());
			stmt.setString(2,payment.getPaymentDate());
			stmt.setInt(3,payment.getCardNo());
			stmt.setString(4,payment.getCardExpiryDate());
			stmt.setInt(5,payment.getOrderId());
			stmt.setInt(6,payment.getCvv());
			stmt.setString(7,payment.getPaymentStatus());
			stmt.setInt(8,userID);
		    stmt.execute();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
	
	
	public Payment displayPayment(int userID) {
		Payment payment = null;
		try {
			Connection connect = DBConnection.getConnection();
			PreparedStatement stmt = connect.prepareStatement("select * from payments WHERE user_id = ?");
			
			stmt.setInt(1,userID);
			ResultSet rst = stmt.executeQuery();
			while(rst.next()) {
				payment = new Payment();
				payment.setPaymentType(rst.getString("paymentType"));
				payment.setPaymentDate(rst.getString("paymentDate"));
				payment.setCardExpiryDate(rst.getString("cardExpiryDate"));
				payment.setPaymentStatus(rst.getString("paymentStatus"));
				payment.setCardNo(rst.getInt("cardNo"));
				payment.setCvv(rst.getInt("ccv"));
				payment.setOrderId(rst.getInt("orderId"));
		      }
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return payment;
	}
	
	
	public List<Payment> displayPayments(int userID) {
		Payment payment = null;
		listP = new ArrayList<Payment>();
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection connect = DriverManager
                    .getConnection("jdbc:mysql://localhost:3306/test","root","");
			PreparedStatement stmt = connect.prepareStatement("select * from payments WHERE user_id = ?");
			
			stmt.setInt(1,userID);
			ResultSet rst = stmt.executeQuery();
			while(rst.next()) {
				payment = new Payment();
				payment.setPaymenyID(rst.getInt("payment_Id"));
				payment.setPaymentType(rst.getString("paymentType"));
				payment.setPaymentDate(rst.getString("paymentDate"));
				payment.setCardExpiryDate(rst.getString("cardExpiryDate"));
				payment.setPaymentStatus(rst.getString("paymentStatus"));
				payment.setCardNo(rst.getInt("cardNo"));
				payment.setCvv(rst.getInt("ccv"));
				payment.setOrderId(rst.getInt("orderId"));
		         listP.add(payment);
		      }
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return listP;
	}
	
	
	
	public int updatePayment(Payment payment) {
		
		try {
			Connection connect = DBConnection.getConnection();
			PreparedStatement update = connect.prepareStatement(
                    "UPDATE payments SET paymentType = ?, paymentDate = ?, cardNo = ?, cardExpiryDate = ? , orderId = ?, ccv = ? , paymentStatus	 = ? WHERE payment_Id  = ? ");
            update.setString(1, payment.getPaymentType());
            update.setString(2, payment.getPaymentDate());
            update.setInt(3, payment.getCardNo());
            update.setString(4, payment.getCardExpiryDate());
            update.setInt(5, payment.getOrderId());
            update.setInt(6, payment.getCvv());
            update.setString(7, payment.getPaymentStatus());
            update.setInt(8, payment.getPaymenyID());
            update.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return 55;
	}

	
	
	
	public int cancelPayment(int paymentId) {
		
		try {
			Connection connect = DBConnection.getConnection();
			PreparedStatement update = connect.prepareStatement(
					 "DELETE FROM payments WHERE payment_Id  = ?");     
            update.setInt(1, paymentId);
            update.execute();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return 0;
	}
}
