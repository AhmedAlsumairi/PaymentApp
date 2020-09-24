package com.payment.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.payment.dao.PaymentDAO;
import com.payment.models.Payment;

/**
 * Servlet implementation class AddPaymentSrvlt
 */
@WebServlet("/AddPaymentSrvlt")
public class AddPaymentSrvlt extends HttpServlet {
	private static final long serialVersionUID = 1L;
    public AddPaymentSrvlt() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		  Payment payment = new Payment();
		  payment.setPaymentType(request.getParameter("paymentType"));
		  payment.setPaymentDate(request.getParameter("paymentDate")); 
		  payment.setCardExpiryDate(request.getParameter("cardExpiryDate"));
		  payment.setPaymentStatus(request.getParameter("paymentStatus"));
		  payment.setCardNo(Integer.parseInt(request.getParameter("cardNo")));
		  payment.setCvv(Integer.parseInt(request.getParameter("cvv")));
		  payment.setOrderId(Integer.parseInt(request.getParameter("orderId"))); 
		  int userID = (int) request.getSession(false).getAttribute("userId");
		  PaymentDAO paymentdao = new PaymentDAO();
		  paymentdao.addPayment(payment, userID);
		  RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/index.jsp");
			dispatcher.forward(request,response);
		response.getWriter().append("Served at: ").append(request.getContextPath());
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
