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

import com.payment.models.Payment;

/**
 * Servlet implementation class ShowUpdatePage
 */
@WebServlet("/ShowUpdatePage")
public class ShowUpdatePage extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ShowUpdatePage() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		Payment payment = null;
		int id = Integer.parseInt(request.getParameter("userIDN"));
		ArrayList<Payment> li =  (ArrayList<Payment>) request.getSession(false).getAttribute("paymentList");
		for (Payment pamt : li) {
			if (pamt.getPaymenyID() == id) {
				payment = new Payment();
				payment.setPaymenyID(pamt.getPaymenyID());
				payment.setPaymentType(pamt.getPaymentType());
				payment.setCardExpiryDate(pamt.getCardExpiryDate());
				payment.setPaymentStatus(pamt.getPaymentStatus());
				payment.setPaymentDate(pamt.getPaymentDate());
				payment.setCardNo(pamt.getCardNo());
				payment.setCvv(pamt.getCvv());
				payment.setOrderId(pamt.getOrderId());
				request.getSession(false).setAttribute("paymentUpdate", payment);
			}
		}
		
		
		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/WEB-INF/pages/PaymentUpdate.jsp");
		dispatcher.forward(request,response);
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
