package com.go.cheeta.service;

import static org.junit.Assert.*;
import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import com.go.cheeta.model.Booking;

public class BookingServiceTest {

	@Test
	public void testGetAllBooking() {
		
		try {
			BookingService serv=new BookingService();
			List<Booking>book=serv.getAllBooking();
			assertNotNull(book);
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
		
	}

	@Test
	public void testByCustomer() {
		
		try {Booking booking=new Booking();
			BookingService bservice=new BookingService();
			booking.setCustomerid(2);
		
			List<Booking>dta=bservice.byCustomer(booking);
			
			assertNotNull(dta);
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
