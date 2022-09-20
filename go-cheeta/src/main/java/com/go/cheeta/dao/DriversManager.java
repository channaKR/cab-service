package com.go.cheeta.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import com.go.cheeta.model.Account;
import com.go.cheeta.model.Booking;
import com.go.cheeta.model.DriverClass;
import com.go.cheeta.model.Sales;
import com.go.cheeta.model.Vehicle;

public class DriversManager {
	public static boolean addDriver(Vehicle vehicle,DriverClass driver ,Account account) throws ClassNotFoundException, SQLException {
		DbConnector connector = new DbConnectorSQL();
		Connection connection = connector.getConnection();
		String query="insert into driver (drivernic,drivername,driveraddress,contact,email,vid) values(?,?,?,?,?,?) ";
		PreparedStatement ps = connection.prepareStatement(query);
		//ps.setString(1, product.getProductName());
		ps.setString(1, driver.getNicnumber());
		ps.setString(2, driver.getDrivername());
		ps.setString(3,driver.getAddress() );
		ps.setString(4, driver.getContactnumber());
		ps.setString(5, account.getEmail());
		ps.setInt(6, vehicle.getVehicleID());
		
		boolean result = ps.executeUpdate() > 0 ;
		ps.close();
		connection.close();
		return result;
	}
	
	//
	
	public static List<DriverClass> driverData() throws ClassNotFoundException, SQLException{
		
		DbConnector connector = new DbConnectorSQL();
		 Connection connection = connector.getConnection();
		 String query = "SELECT drivernic,drivername,driveraddress,contact,email,vid FROM driver";
		 Statement st=connection.createStatement();
		 ResultSet rs=st.executeQuery(query);
		 
		 List<DriverClass>drivers=new ArrayList();
		 while(rs.next()) {
			 
			 DriverClass driver=new DriverClass();
			 driver.setNicnumber(rs.getString("drivernic"));
			 driver.setDrivername(rs.getString("drivername"));
			 driver.setContactnumber(rs.getString("contact"));
			 driver.setEmail(rs.getString("email"));
			 driver.setVehicleID(rs.getInt("vid"));
			 driver.setAddress(rs.getString("driveraddress"));
			 drivers.add(driver);
		 }
		 
		    st.close();
			connection.close();
			return drivers;
	}
	
	public static DriverClass getDriverbyVehicle(Vehicle vehicle) throws ClassNotFoundException, SQLException {
		
		DbConnector connector =new DbConnectorSQL();
		Connection connection = connector.getConnection();
		
		String query="SELECT * FROM gocheeta.driver where vid=?";
		PreparedStatement ps=connection.prepareStatement(query);
		ps.setInt(1, vehicle.getVehicleID());
	    ResultSet rs=ps.executeQuery();
	    DriverClass rd=new DriverClass();
	    
	    while(rs.next()) {
	    	DriverClass driverdata=new DriverClass(rs.getString("drivernic"),rs.getString("drivername"),rs.getString("driveraddress"),rs.getString("contact"),rs.getString("email"),rs.getInt("vid"));
	    
	      rd=driverdata;
	    }
	   
	    ps.close();
		connection.close();
		return rd;
		
	}

	public static List<DriverClass>getAllDrivers() throws ClassNotFoundException, SQLException{
	  DbConnector connector = new DbConnectorSQL();
		 Connection connection = connector.getConnection();
		 String query = "SELECT * FROM gocheeta.driver";
		 Statement st=connection.createStatement();
		 ResultSet rs=st.executeQuery(query);
		 
		 List<DriverClass>drivers=new ArrayList();
		 while(rs.next()) {
			 
			 DriverClass driver=new DriverClass();
			 drivers.add(driver);
		 }
		 
		    st.close();
			connection.close();
			return drivers;
	  
	  
	  
  }

	public static boolean updateDriver(DriverClass driver) throws ClassNotFoundException, SQLException {
	 	DbConnector connector =new DbConnectorSQL();
		Connection connection = connector.getConnection();
		String query = "UPDATE driver SET drivernic=?,drivername=?,driveraddress=?,contact=?,email=?,vid=?  where drivernic=?";
		PreparedStatement ps = connection.prepareStatement(query);
		ps.setString(1, driver.getNicnumber());
		ps.setString(2, driver.getDrivername());
		ps.setString(3, driver.getAddress());
		ps.setString(4, driver.getContactnumber());
		ps.setString(5, driver.getEmail());
		ps.setInt(6, driver.getVehicleID());
		ps.setString(7, driver.getNicnumber());
		boolean result = ps.executeUpdate() > 0 ;
		ps.close();
		connection.close();
		return result;
	 
	 
 }
}
