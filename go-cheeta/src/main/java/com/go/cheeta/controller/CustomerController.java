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

import com.go.cheeta.model.*;
import com.go.cheeta.service.BookingService;
import com.go.cheeta.service.CustomerService;
import com.go.cheeta.service.User;
import com.go.cheeta.service.VehicleService;

public class CustomerController extends HttpServlet {
	private static final long serialVersionUID = 1L;
 
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		 String action=request.getParameter("action");
    
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		 String action=request.getParameter("action");
		 if(action.equals("addCustomer")) {
			 
			 createCustomer(request,response);
		 }
		 
		 else  if(action.equals("availableVehicles")) {
			 
			 viewVehicleAvailability(request,response);
		 }	
		 else if(action.equals("bookingvehicle")) {
			 
			 bookingVehicle(request,response);
			 
		 }
		 else if(action.equals("customerlogin")){
			 
			 log(request,response);
			 
		 }
		 
		 else if(action.equals("bookingData")) {
			 
			 getAvailablevehiclegData(request,response);
		 }
		 else if(action.equals("myorders")) {
				
				getCustomerBookings(request, response);
			}
		
	}

	
	private void createCustomer(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String message= "";
		CustomerService service=new CustomerService();
		Customer customer=new Customer();
		Account account =new Account();
		customer.setCustomername1(request.getParameter("customername1"));
		customer.setCustomername2(request.getParameter("customername2"));
		customer.setAddress1(request.getParameter("addres1"));
		customer.setAddress2(request.getParameter("addres2"));
		customer.setCity(request.getParameter("city"));
		account.setEmail(request.getParameter("email"));
		account.setPassword(request.getParameter("password"));
		account.setRoll("customer");
		
		boolean result;
		try {
			result=service.addAccountData(customer,account);
			if(result) {
				message=customer.getCustomername1()+" "+"Add To The System";
			}
		} catch (ClassNotFoundException | SQLException e) {
			message=e.getMessage();
			
		}
		
		 	request.setAttribute("message", message);
			RequestDispatcher rd=request.getRequestDispatcher("create-account.jsp");
			rd.forward(request, response);
		
	}
	
	
	private void viewVehicleAvailability(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		String message= "";
		VehicleService service=new VehicleService();
		Vehicle vehicle=new Vehicle();
		Booking booking=new Booking();
		String startDate=request.getParameter("startdate");
		String endDate=request.getParameter("enddate");
		LocalDate start_DateLocalDate = LocalDate.parse (startDate);
		LocalDate endt_DateLocalDate = LocalDate.parse (endDate);
		try {
			
			booking.setStart_Date(start_DateLocalDate );
			booking.setEnd_Date(endt_DateLocalDate);
			vehicle.setVehicle_Type(request.getParameter("vehicle_type"));
			List<Vehicle>vehicleList=service.availableVehicle(booking, vehicle);
			
			if(vehicleList.isEmpty()) {
				

			}
			request.setAttribute("availablevehicle",vehicleList);
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			message=e.getMessage();
		}
		request.setAttribute("message", message);
		RequestDispatcher rd=request.getRequestDispatcher("available-vehicle.jsp");
		rd.forward(request, response);
	   }
	
	
	private void bookingVehicle(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String message= "";
		Vehicle vehicle=new Vehicle();
		Booking booking=new Booking();
		DriverClass driverClass=new DriverClass();
		Customer customer=new Customer();
		CustomerService service=new CustomerService();
		String startDate=request.getParameter("startdate");
		String endDate=request.getParameter("enddate");
		LocalDate start_DateLocalDate = LocalDate.parse (startDate);
		LocalDate endt_DateLocalDate = LocalDate.parse (endDate);
		booking.setStart_Date(start_DateLocalDate);
		booking.setEnd_Date(endt_DateLocalDate);
		vehicle.setVehicleID(Integer.parseInt(request.getParameter("ID")));
		customer.setCustomer_ID(Integer.parseInt(request.getParameter("customid")));
		booking.setKillometers(Double.parseDouble(request.getParameter("km")));
		double costperkm=Double.parseDouble(request.getParameter("costkm"));
		double km=Double.parseDouble(request.getParameter("km"));
		booking.setCostfor_vehicle(costperkm*km);
		booking.setLocation(request.getParameter("location"));
		booking.setBaranch(request.getParameter("branch"));
		
		try {
		boolean result=	service.bookVehicle(booking, vehicle, customer, driverClass);
		if(result) {
			
			message="Booking Complete";
			
		}
			
		} catch (ClassNotFoundException | SQLException e) {
			message=e.getMessage();
		}
		request.setAttribute("message", message);
		RequestDispatcher rd=request.getRequestDispatcher("booking-vehicle.jsp");
		rd.forward(request, response);
	}
	
	
	private void log(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String message= "";
		Account account=new Account();
		Customer customer=new Customer();
		account.setEmail(request.getParameter("email"));
		account.setPassword(request.getParameter("password"));

		CustomerService service=new CustomerService();
		try {
			Customer result=service.login(account, customer);
			if(result.getCustomername1()==null) {
				message="Invalid Login.Please Cheack Your Data";
				request.setAttribute("message", message);
				RequestDispatcher rd=request.getRequestDispatcher("customer-login.jsp");
				rd.forward(request, response);
			}
			else if(result.getCustomername1()!=null) {
				HttpSession session=request.getSession();
				
				session.setAttribute("user", result.getCustomername1());
				session.setAttribute("customerid", result.getCustomer_ID());
			}
			
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			message=e.toString();
		}
		request.setAttribute("message", message);
		RequestDispatcher rd=request.getRequestDispatcher("customer-index.jsp");
		rd.forward(request, response);
		
	}	
	
	private void getAvailablevehiclegData(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		String message= "";
		HttpSession session=request.getSession();
		int vehicleid=Integer.parseInt(request.getParameter("vehicleid")) ;
		double cost=Double.parseDouble(request.getParameter("kmcost"));
		session.setAttribute("ID", vehicleid);
		session.setAttribute("cost",cost);
		RequestDispatcher rd=request.getRequestDispatcher("booking-vehicle.jsp");
		rd.forward(request, response);
	}
	
	private void getCustomerBookings(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
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
