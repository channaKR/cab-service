package com.go.cheeta.controller;

import java.io.IOException;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.go.cheeta.model.Account;
import com.go.cheeta.model.Booking;
import com.go.cheeta.model.Customer;
import com.go.cheeta.model.DriverClass;
import com.go.cheeta.model.Vehicle;
import com.go.cheeta.service.CustomerService;
import com.go.cheeta.service.DriverService;
import com.go.cheeta.service.VehicleService;

public class DriverController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String action=request.getParameter("action");
		   if(action.equals("bookingorder")) {
			   viewOrders(request,response);
			   
		   }
		   else if(action.equals("drivelogin")) {
			   log(request,response);
		   }
		   
		   else if(action.equals("cofirm")) {
			   confirmBooking(request,response);
		   }
	}

	
	
	private void viewOrders(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		String message= "";
		DriverService service=new DriverService();
		DriverClass driver=new DriverClass();
		Booking booking=new Booking();
		
		try {
			
			driver.setNicnumber(request.getParameter("drivernic"));
			List<Booking>bookingorders=service.viewOrdersDriver(booking, driver);
			
			if(bookingorders.isEmpty()) {
				

			}
			request.setAttribute("orders",bookingorders);
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			message=e.getMessage();
		}
		request.setAttribute("message", message);
		RequestDispatcher rd=request.getRequestDispatcher("view-order.jsp");
		rd.forward(request, response);
	}
	
	
	private void log(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String message= "";
		Account account=new Account();
		DriverClass driverdata=new DriverClass();
		account.setEmail(request.getParameter("email"));
		account.setPassword(request.getParameter("password"));

		DriverService service=new DriverService();
		try {
			DriverClass result=service.login(account, driverdata);
			if(result.getDrivername()==null) {
				message="Invalid Login.Please Cheack Your Data";
				request.setAttribute("message", message);
				RequestDispatcher rd=request.getRequestDispatcher("driver-login.jsp");
				rd.forward(request, response);
			}
			else if(result.getDrivername()!=null) {
				HttpSession session=request.getSession();
				
				session.setAttribute("user", result.getDrivername());
				session.setAttribute("drivernic", result.getNicnumber());
			}
			
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			message=e.toString();
		}
		request.setAttribute("message", message);
		RequestDispatcher rd=request.getRequestDispatcher("driver-dashboard.jsp");
		rd.forward(request, response);
		
	}
	
	private void confirmBooking(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String message= "";
		DriverService service=new DriverService();
		Booking booking = new Booking();
		booking.setBooking_ID(Integer.parseInt(request.getParameter("bookingid")));
		booking.setConfirm(1);
		try {
			service.confirmBooking(booking);
			message="Order confirm";
			
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			message=e.getMessage();
		}
		request.setAttribute("message", message);
		RequestDispatcher rd=request.getRequestDispatcher("driver-dashboard.jsp");
		rd.forward(request, response);
		
	}
	
}