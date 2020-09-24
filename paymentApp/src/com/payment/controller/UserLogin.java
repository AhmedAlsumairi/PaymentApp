package com.payment.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.payment.dao.LoginDAO;
import com.payment.dao.PaymentDAO;
import com.payment.models.Payment;
import com.payment.models.User;

/**
 * Servlet implementation class UserLogin
 */
@WebServlet("/UserLogin")
public class UserLogin extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UserLogin() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PaymentDAO paymentDAO = new PaymentDAO();
		List<Payment> paymentList = new ArrayList<Payment>();
		LoginDAO login = new LoginDAO();
		User user = login.logAuth(request.getParameter("username"),request.getParameter("password"));
		if(user != null) {
			request.getSession().setAttribute("userRole", user.getRole());
			request.getSession(false).setAttribute("userId", user.getUserID());
			request.getSession(false).setAttribute("userName", user.getUsername());
			List<Payment> lisP = paymentDAO.displayPayments(user.getUserID());
			request.getSession(false).setAttribute("paymentList", lisP);	
		}
		
		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/index.jsp");
		dispatcher.forward(request,response);
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
