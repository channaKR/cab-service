package com.go.cheeta.controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.go.cheeta.model.Booking;
import com.go.cheeta.service.BookingService;

public class SaleController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
	}
	
	private void getOrdersbyId(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String message= "";
		BookingService service=new BookingService();  
		Booking book=new Booking();
		book.setCustomerid(Integer.parseInt(request.getParameter("customer")));
		try {
			List<Booking>customerbooking=service.byCustomer(book);
			if(customerbooking.isEmpty()) {
				message="Empty List";
			}
			request.setAttribute("customerbooking", customerbooking);
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			message=e.getMessage();
		} 
		
		request.setAttribute("message", message);
		RequestDispatcher rd=request.getRequestDispatcher("all-booking-data.jsp");
		rd.forward(request, response);
	}
	
}
