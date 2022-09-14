package com.go.cheeta.service;

import java.sql.SQLException;
import java.util.List;

import com.go.cheeta.dao.AccountManager;
import com.go.cheeta.dao.BookingManager;
import com.go.cheeta.dao.VehicleManager;
import com.go.cheeta.model.Account;
import com.go.cheeta.model.Booking;
import com.go.cheeta.model.Customer;
import com.go.cheeta.model.DriverClass;
import com.go.cheeta.model.Vehicle;

public class CustomerService implements User {

	@Override
	public boolean login() {
		
		return false;
	}
	public  boolean addAccountData(Customer customer,Account customeraccount) throws ClassNotFoundException, SQLException {
		return AccountManager.addAccountData(customer,customeraccount);
	}
	
	 public List<Vehicle>availableVehicle(Booking booking,Vehicle vehicle) throws ClassNotFoundException, SQLException{
			return VehicleManager.searchBookingVehicle(booking, vehicle);
			 
		 }
	 public boolean bookVehicle(Booking booking,Vehicle vehicle,Customer customer,DriverClass driverClass) throws ClassNotFoundException, SQLException {
		 
		 return BookingManager.bookVehicle(booking, vehicle, customer, driverClass);
	 } 
	 
	 public  Customer login(Account login,Customer customer) throws ClassNotFoundException, SQLException {
		return AccountManager.Login(login, customer);
	}
}
