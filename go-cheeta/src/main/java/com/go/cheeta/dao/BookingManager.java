package com.go.cheeta.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.*;

import com.go.cheeta.model.*;

public class BookingManager {

	public static boolean bookVehicle(Booking booking,Vehicle vehicle,Customer customer,DriverClass driver) throws ClassNotFoundException, SQLException {
		DbConnector connector = new DbConnectorSQL();
		Connection connection = connector.getConnection();
		String query="INSERT INTO booking (startdate,enddate,branch,location,km,vid,customerid,fullcost) VALUES "+
		"(?,?,?,?,?,?,?,?) ";
		PreparedStatement ps = connection.prepareStatement(query);
		ps.setString(1,booking.getStart_Date().toString() );
		ps.setString(2,booking.getEnd_Date().toString() );
		ps.setString(3, booking.getBaranch());
		ps.setString(4, booking.getLocation());
		ps.setDouble(5, booking.getKillometers());
		ps.setInt(6, vehicle.getVehicleID());
		ps.setInt(7, customer.getCustomer_ID());
		ps.setDouble(8, booking.getCostfor_vehicle());
		boolean result = ps.executeUpdate() > 0 ;
		ps.close();
		connection.close();
		return result;
		
		
	}
	
	
	public static List<Booking> viewOrdersDriver(Booking booking,DriverClass driver) throws ClassNotFoundException, SQLException {
		
		DbConnector connector =new DbConnectorSQL();
		Connection connection = connector.getConnection();
		
		String query="SELECT booking.bookingid,booking.startdate,booking.enddate,booking.location,"+
		"branch,km,fullcost FROM booking LEFT JOIN driver ON"+
				" booking.vid=driver.vid where drivernic=?";
		PreparedStatement ps=connection.prepareStatement(query);
		ps.setString(1, driver.getNicnumber());
	    ResultSet rs=ps.executeQuery();
	    List<Booking> vehiclebook=new ArrayList();
	    while(rs.next()) {
	    	Booking bookingData=new Booking();
	    	String startDate=rs.getString("startdate");
			String endDate=rs.getString("enddate");
			LocalDate start_DateLocalDate = LocalDate.parse (startDate);
			LocalDate endt_DateLocalDate = LocalDate.parse (endDate);
	    	bookingData.setBooking_ID(rs.getInt("bookingid"));
	    	bookingData.setStart_Date(start_DateLocalDate);
	    	bookingData.setEnd_Date(endt_DateLocalDate);
	    	bookingData.setLocation(rs.getString("location"));
	    	bookingData.setBaranch(rs.getString("branch"));
	    	bookingData.setKillometers(rs.getDouble("km"));
	    	bookingData.setCostfor_vehicle(rs.getDouble("fullcost"));
	    	
	    	vehiclebook.add(bookingData);
	    }
	   
	    
		return vehiclebook;
		
	}
	
	
	
}
