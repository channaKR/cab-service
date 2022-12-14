package com.go.cheeta.controller;

import java.io.IOException;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.*;

import javax.mail.MessagingException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.go.cheeta.model.*;
import com.go.cheeta.service.*;

public class WebController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 String action=request.getParameter("action");
		   if(action.equals("all")) {
			   viewVehicle(request,response);
			   
		   }
		   else if(action.equals("withoutDriver")) {
			   
			   getVehiclesWithoutDrivers(request,response);
		   }
		   
		   else if(action.equals("viewallsale")) {
			   
			   getSales(request,response);
			   
		   }
		   else if(action.equals("branchtot")) {
				
			   searchTotal(request,response);
			   
			}
		   else if(action.equals("viewOrders")) {
			   
			   viewOrders(request, response);
		   }
		   else if(action.equals("alldrivers")) {
			   
			   getAllDriver(request, response);
		   }
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String action=request.getParameter("action");
		if(action.equals("addVehicle")) {
			addVehicle(request, response);
		}
		
		else if(action.equals("deleteVehicle")) {
			deleteVehicle(request, response);
		}
		
		else if(action.equals("editVehicle")) {
			viewVehicleByID(request, response);
		}
		else if(action.equals("updateVehicle")) {
			
			UpdateVehicle(request, response);
	 }
		
		else if(action.equals("addDriver")) {
			
			addDriver(request, response);
			
		}
		else if(action.equals("getdriver")) {
			viewOrders(request, response);
		}
		else if(action.equals("adminlogin")) {
			addminlogin(request, response);
		}
		
		if(action.equals("logout")) {
			adminlogout(request, response);
			
		}
		
	}
	
	
	private void addVehicle(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException  {
		String message= "";
		VehicleService service= new VehicleService();
		Vehicle vehicle=new Vehicle();
		vehicle.setVehicle_Registernumber(request.getParameter("register_Number"));
		vehicle.setVehicle_Model(request.getParameter("vehicle_Model"));
		vehicle.setNumberof_Seat(Integer.parseInt(request.getParameter("vehicle_Seat")));
		vehicle.setVehicle_Type(request.getParameter("vehicle_type"));
		vehicle.setCostper_Km(Double.parseDouble(request.getParameter("costPer_Km")));
		vehicle.setBranch(request.getParameter("branch"));
		boolean result;
		try {
			result = service.addVehicle(vehicle);
			if(result) {
				message=vehicle.getVehicle_Model()+" "+"Add To The System";
			}
		} catch (ClassNotFoundException | SQLException e) {
			
			message=e.getMessage();
		}
		
		
		request.setAttribute("message", message);
		RequestDispatcher rd=request.getRequestDispatcher("add-vehicle.jsp");
		rd.forward(request, response);
	}
	
	private void viewVehicle(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String message= "";
		VehicleService service=new VehicleService();
		DriverClass driverdata=new DriverClass();
		DriverService driverservice=new DriverService();
		
		try {
			List<Vehicle>vehicles=service.viewAllVehicle();
			
			
			if(vehicles.isEmpty()) {
				 message="There's no any vehicles";

			}
			request.setAttribute("vehicleData",vehicles);
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			message=e.getMessage();
		}
		request.setAttribute("message",message);
		RequestDispatcher rd=request.getRequestDispatcher("admin-view-vehicles.jsp"); 
		rd.forward(request, response);
		
		
	}

	
	private void deleteVehicle(HttpServletRequest request, HttpServletResponse response) throws IOException   {
		String message= "";
		VehicleService service= new VehicleService();
		int vehicleID= Integer.parseInt(request.getParameter("vehicleID"));
		try {
			boolean result=service.deleteProduct(vehicleID);
			if(result) {
				
				message="The product Deleted";
				
			}
			
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			message=e.getMessage();

		}
		
		request.setAttribute("message", message);
		HttpSession session=request.getSession();
		session.setAttribute("deleteMessage", message);
		response.sendRedirect("/go-cheeta/viewVehicle?action=all");
		
	}
	
	
	private void viewVehicleByID(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException  {
		String message= "";
		VehicleService service=new VehicleService();
		int vehicleID= Integer.parseInt(request.getParameter("vehicleID"));
		Vehicle vehicle= new Vehicle();
		
		try {
			vehicle=service.getTheVehicleByVehicleID(vehicleID);
			
		} catch (ClassNotFoundException | SQLException e) {
			
			message=e.getMessage();
		}
		
		   request.setAttribute("message", message);
		   request.setAttribute("vehicle",vehicle);
		   RequestDispatcher rd=request.getRequestDispatcher("admin-update-vehicle.jsp");
		   rd.forward(request, response);
	}
	
	private void UpdateVehicle(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{   String message= "";
	VehicleService service= new VehicleService();
	Vehicle vehicle=new Vehicle();
	int vehicleID= Integer.parseInt(request.getParameter("vehicleID"));
	vehicle.setVehicleID(vehicleID);
	vehicle.setVehicle_Registernumber(request.getParameter("register_Number"));
	vehicle.setVehicle_Model(request.getParameter("vehicle_Model"));
	vehicle.setNumberof_Seat(Integer.parseInt(request.getParameter("vehicle_Seat")));
	vehicle.setVehicle_Type(request.getParameter("vehicle_type"));
	vehicle.setCostper_Km(Double.parseDouble(request.getParameter("costPer_Km")));
	vehicle.setBranch(request.getParameter("branch"));
	boolean result;
	try {
		result = service.updateVehicle(vehicle);
		if(result) {
			message="Update Successfully";
		}
	} catch (ClassNotFoundException | SQLException e) {
		
		message=e.getMessage();
	}
	
	
	request.setAttribute("message", message);
	response.sendRedirect("/go-cheeta/viewVehicle?action=all");
	
	}
	
	private void getVehiclesWithoutDrivers(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String message= "";
		VehicleService service=new VehicleService();
		Vehicle vehicle=new Vehicle();
		try {
			List<Vehicle>vehicles=service.getVehilcesWithoutDriver(vehicle);
			if(vehicles.isEmpty()) {
				 message="There's no any vehicles";
				 
				 
				 

			}
			request.setAttribute("vehicleData",vehicles);
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			message=e.getMessage();
		}
		request.setAttribute("message",message);
		RequestDispatcher rd=request.getRequestDispatcher("add-driver.jsp"); 
		rd.forward(request, response);
		
		
		
	}
	
	
	private void addDriver(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException  {
		String message= "";
		DriverService service=new DriverService();
		Vehicle vehicle=new Vehicle();
		DriverClass driver=new DriverClass();
		Account account=new Account();
		
		vehicle.setVehicleID(Integer.parseInt(request.getParameter("model")));
		driver.setDrivername(request.getParameter("dname"));
		driver.setNicnumber(request.getParameter("nic"));
		driver.setAddress(request.getParameter("address"));
		driver.setContactnumber(request.getParameter("contact"));
		account.setEmail(request.getParameter("email"));
		account.setPassword(request.getParameter("password"));
		account.setRoll("driver");
		boolean result;
		try {
			result = service.addDriver(vehicle, driver, account);
			if(result) {
				message="Add To The System";
			}
		} catch (ClassNotFoundException | SQLException e) {
			
			message=e.getMessage();
		}
		
		
		request.setAttribute("message",message);
		
		response.sendRedirect("/go-cheeta/viewVehicle?action=withoutDriver");
		
	}
	
	private void getSales(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String message= "";
		SaleService service=new SaleService();
		
		
		
		try {
			List<Sales>sale=service.searchByBranch();
			
		
			if(sale.isEmpty()) {
				
				message="Sorry No sales";
			}
			request.setAttribute("saleData",sale);
			
			
			
		} catch (ClassNotFoundException | SQLException e) {
			
			message=e.getMessage();
		}
		request.setAttribute("message",message);
		getTotal(request, response);
		RequestDispatcher rd=request.getRequestDispatcher("admin-dashboard.jsp"); 
		
		rd.forward(request, response);
		
	}
	
	private void getTotal(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String message= "";
		SaleService service=new SaleService();
		
		try {
			Sales sale=service.allCoast();
			request.setAttribute("tot",sale);
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			message=e.getMessage();
		}
		
		request.setAttribute("message",message);
		RequestDispatcher rd=request.getRequestDispatcher("admin-dashboard.jsp"); 
		
		rd.forward(request, response);
		
	}

	private void searchTotal(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		SaleService service=new SaleService();
		String message= "";
		String searchbydate=request.getParameter("date");
		LocalDate date = LocalDate.parse (searchbydate);
		Sales searchdata=new Sales();
		searchdata.setDate(date);
		searchdata.setBranch(request.getParameter("branch"));
		
		try {
			List<Sales>saletotal=service.searchBranchSales(searchdata);
			if(saletotal.isEmpty()) {
				
				message="Sales Not available";
				
			}
			
			HttpSession session=request.getSession();
			
			session.setAttribute("branchsearch", saletotal);
			
			
			//getSales(request,response);
			
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			message=e.getMessage();
		}
		request.setAttribute("message",message);
		RequestDispatcher rd=request.getRequestDispatcher("admin-dashboard.jsp"); 
		rd.forward(request, response);
		
		request.setAttribute("message",message);
	    
	}
	
	private void viewOrders(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		String message= "";
		BookingService service=new BookingService();
		Booking booking=new Booking();
		
		
		try {
			
			if(request.getParameter("vehicleids")!=null) {
				Vehicle vehicle=new Vehicle();
				VehicleService vehicleservice=new VehicleService();
				Customer customer=new Customer();
				customer.setCustomer_ID(Integer.parseInt(request.getParameter("customerid")));
				CustomerService customerservice=new CustomerService();
				vehicle.setVehicleID(Integer.parseInt(request.getParameter("vehicleids")));
				
				DriverService driverservice=new DriverService();
				DriverClass driverinfor=new DriverClass();
				vehicle=vehicleservice.getTheVehicleByVehicleID(Integer.parseInt(request.getParameter("vehicleids")));
				driverinfor=driverservice.getDriverInformation(vehicle);
				Customer cs=customerservice.getCustomerbyID(customer);
				HttpSession session=request.getSession();
				session.setAttribute("vmodel", vehicle.getVehicle_Model());
				session.setAttribute("dname",driverinfor.getDrivername() );
				session.setAttribute("dcontact",driverinfor.getContactnumber() );
				session.setAttribute("customer", cs.getCustomername1()+" "+ cs.getCustomername2());
				
			}
			List<Booking>orders=service.getAllBooking();
			if(orders.isEmpty()) {
				message="No orders found";
				
			}
			request.setAttribute("viewAllBooking", orders);
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			message=e.getMessage();
		}
		request.setAttribute("message", message);
		RequestDispatcher rd=request.getRequestDispatcher("view-booking-orders.jsp");
		rd.forward(request, response);
	}
	
	private void getAllDriver(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String message= "";
		DriverClass driver=new DriverClass();
		DriverService service=new DriverService();
		try {
			List<DriverClass>drivers=service.getAllDriversData();
			if(drivers.isEmpty()) {
				
				message="No Driver Data";
			}
			request.setAttribute("driversdata", drivers);
			
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			message=e.getMessage();
	}
		request.setAttribute("message", message);
		RequestDispatcher rd=request.getRequestDispatcher("view-alldrivers.jsp");
		rd.forward(request, response);
	}
	
	private void addminlogin(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String message= "";
		Account account=new Account();
		
		account.setEmail(request.getParameter("user_email"));
		account.setPassword(request.getParameter("user_password"));
		
		AccountService service=new AccountService();
		try {
			Account result=service.adminLogin(account);
			if(result.getEmail()==null) {
				message="Invalid Login.Please Cheack Your Data";
				request.setAttribute("message", message);
				RequestDispatcher rd=request.getRequestDispatcher("admin-login.jsp");
				rd.forward(request, response);
			}
			else if(result.getEmail()!=null) {
				HttpSession session=request.getSession();
				
				session.setAttribute("useremail", result.getEmail());
			
			}
			
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			message=e.toString();
		}
		request.setAttribute("message", message);
		response.sendRedirect("/go-cheeta/salesData?action=viewallsale");
		
		
		}
	
	private void adminlogout(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session=request.getSession();
		session.invalidate();
		RequestDispatcher rd=request.getRequestDispatcher("admin-login.jsp");
		rd.forward(request, response);
		
	}
	
	
	
}


