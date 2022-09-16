package com.go.cheeta.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.go.cheeta.model.Account;
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
	
}
