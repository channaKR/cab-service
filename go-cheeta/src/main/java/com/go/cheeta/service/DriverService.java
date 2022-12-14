package com.go.cheeta.service;

import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.List;

import com.go.cheeta.dao.AccountManager;
import com.go.cheeta.dao.BookingManager;
import com.go.cheeta.dao.DriversManager;
import com.go.cheeta.model.Account;
import com.go.cheeta.model.Booking;
import com.go.cheeta.model.Customer;
import com.go.cheeta.model.DriverClass;
import com.go.cheeta.model.Vehicle;

public class DriverService implements User {

	@Override
	public boolean login() {
		// TODO Auto-generated method stub
		return false;
	}

	
	public boolean addDriver(Vehicle vehicle,DriverClass driver,Account account) throws ClassNotFoundException, SQLException {
		
		return AccountManager.addDriver(vehicle, driver, account);
		
	}
	
	public List<Booking> viewOrdersDriver(Booking booking,DriverClass driver) throws ClassNotFoundException, SQLException{
		return BookingManager.viewOrdersDriver(booking, driver);
		
		
	}
	
	 public  DriverClass login(Account login,DriverClass driver) throws ClassNotFoundException, SQLException {
			return AccountManager.DriverLogin(login, driver);
		}
	 
	 public boolean confirmBooking(Booking booking) throws ClassNotFoundException, SQLException {
		 return BookingManager.updateBooking(booking);
		 
	 }
	 
	public List<DriverClass>getAllDriversData() throws ClassNotFoundException, SQLException{
		return DriversManager.driverData();
	}
	
	
	public DriverClass getDriverInformation(Vehicle vehicle) throws ClassNotFoundException, SQLException {
		
		return DriversManager.getDriverbyVehicle(vehicle);
	}
	
	public boolean UpdateDriver(DriverClass driver) throws ClassNotFoundException, SQLException {
		return DriversManager.updateDriver(driver);
	}
	
public boolean deleteDriver(String id) throws ClassNotFoundException, SQLException {
		
	return DriversManager.deleteDriver(id);
	
	}
}
