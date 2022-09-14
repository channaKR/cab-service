package com.go.cheeta.service;

import java.sql.SQLException;
import java.util.*;

import com.go.cheeta.dao.VehicleManager;
import com.go.cheeta.model.Booking;
import com.go.cheeta.model.Vehicle;

public class VehicleService {

	public boolean addVehicle(Vehicle vehicle) throws ClassNotFoundException, SQLException {
		
		return VehicleManager.addVehicle(vehicle);
		
	}
	
	public List<Vehicle> viewAllVehicle() throws ClassNotFoundException, SQLException{
		return VehicleManager.getAllVehicle();
	}
	
	
	public  boolean deleteProduct(int vehicleid) throws ClassNotFoundException, SQLException {
		return VehicleManager.deleteProduct(vehicleid);
	}
	
	public  Vehicle getTheVehicleByVehicleID(int vehicleCode) throws ClassNotFoundException, SQLException {
		return VehicleManager.getTheVehicleByVehicleID(vehicleCode);
	}
	
	 public boolean updateVehicle(Vehicle vehicle) throws ClassNotFoundException, SQLException {
		 
		 return VehicleManager.updateVehicle(vehicle);
	 }
	
	 public List<Vehicle>availableVehicle(Booking booking,Vehicle vehicle) throws ClassNotFoundException, SQLException{
		return VehicleManager.searchBookingVehicle(booking, vehicle);
		 
	 }
	 public List<Vehicle>getVehilcesWithoutDriver(Vehicle vehicle) throws ClassNotFoundException, SQLException{
		return VehicleManager.getVehilcesWithoutDriver(vehicle);
		
	 
	 }
	 
}
