package com.go.cheeta.controller;

import java.io.IOException;
import java.sql.SQLException;
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
import com.go.cheeta.service.VehicleService;

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
			   //getTotal(request,response);
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
		
		else if(action.equals("sendto")) {
			//send(request, response);
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
		
		//Booking bookin=new Booking();
		
		try {
			List<Sales>sale=service.searchByBranch();
			
		
			if(sale.isEmpty()) {
				
				message="Sorry No sales";
			}
			request.setAttribute("saleData",sale);
			getTotal(request, response);
			
			
		} catch (ClassNotFoundException | SQLException e) {
			
			message=e.getMessage();
		}
		request.setAttribute("message",message);
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

		
	
}


