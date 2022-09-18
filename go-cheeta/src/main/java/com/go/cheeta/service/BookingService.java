package com.go.cheeta.service;

import java.sql.SQLException;
import java.util.List;

import com.go.cheeta.dao.BookingManager;
import com.go.cheeta.model.Booking;

public class BookingService {
	
	public  List<Booking> getAllBooking() throws ClassNotFoundException, SQLException{
		return BookingManager.getAllBooking();
		
		
	}
	
	public static List<Booking> byCustomer(Booking booking) throws ClassNotFoundException, SQLException{
		
		return BookingManager.byCustomer(booking);
	}
}
