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
import com.go.cheeta.model.Sales;
import com.go.cheeta.service.BookingService;
import com.go.cheeta.service.SaleService;

public class SaleController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String action=request.getParameter("action");
		if(action.equals("getorder")) {
			getOrdersbyId(request,response);
		}
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String action=request.getParameter("action");
		if(action.equals("orderhistory")) {
			getOrdersbyId(request,response);
		}
		
	}
	
	private void getOrdersbyId(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String message= "";
		SaleService service=new SaleService();  
		Sales sale= new Sales();
		sale.setCustomerid(Integer.parseInt(request.getParameter("customer")));
		try {
			List<Sales>salesdata=service.getSalesbyID(sale);
			if(salesdata.isEmpty()) {
				message="Empty List";
			}
			request.setAttribute("saledata", salesdata);
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			message=e.getMessage();
		} 
		
		request.setAttribute("message", message);
		RequestDispatcher rd=request.getRequestDispatcher("ConfirmOrders.jsp");
		rd.forward(request, response);
	}
	
}
