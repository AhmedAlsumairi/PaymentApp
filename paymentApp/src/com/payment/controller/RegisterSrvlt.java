package com.payment.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.payment.dao.UserDAO;
import com.payment.models.User;

/**
 * Servlet implementation class RegisterSrvlt
 */
@WebServlet("/RegisterSrvlt")
public class RegisterSrvlt extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RegisterSrvlt() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/index.jsp");
		dispatcher.forward(request,response);
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 
		 String username = request.getParameter("username");
		 String password = request.getParameter("password");
		 String role = request.getParameter("role");
		 System.out.println(role+password+username);
		  User user = new User();
		  user.setUsername(username);
		  user.setPassword(password); 
		  user.setRole(role); 
		  UserDAO userdao = new UserDAO(); 
		  userdao.addUser(user);
		 
		 
		doGet(request, response);
	}

}
