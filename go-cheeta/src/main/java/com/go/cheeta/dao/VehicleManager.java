package com.go.cheeta.dao;
import java.sql.*;
import java.util.*;

import com.go.cheeta.model.Booking;
import com.go.cheeta.model.Vehicle;
public class VehicleManager {

	
	public static boolean addVehicle(Vehicle vehicle) throws ClassNotFoundException, SQLException {
		DbConnector connector = new DbConnectorSQL();
		Connection connection = connector.getConnection();
		String query="INSERT INTO vehicle (registernumber,model,seat,type,kmcost,branch) Values (?,?,?,?,?,?)";
		PreparedStatement ps = connection.prepareStatement(query);
		//ps.setString(1, product.getProductName());
		ps.setString(1, vehicle.getVehicle_Registernumber());
		ps.setString(2, vehicle.getVehicle_Model());
		ps.setInt(3,vehicle.getNumberof_Seat() );
		ps.setString(4, vehicle.getVehicle_Type());
		ps.setDouble(5, vehicle.getCostper_Km());
		ps.setString(6, vehicle.getBranch());
		boolean result = ps.executeUpdate() > 0 ;
		ps.close();
		connection.close();
		return result;
	}
	
	 public static List<Vehicle> getAllVehicle() throws ClassNotFoundException, SQLException{
		 
		 DbConnector connector = new DbConnectorSQL();
		 Connection connection = connector.getConnection();
		 String query = "SELECT * FROM vehicle";
		 Statement st=connection.createStatement();
		 ResultSet rs=st.executeQuery(query);
		 
		 List<Vehicle>vehicles=new ArrayList();
		 while(rs.next()) {
			 
			 Vehicle vehicle=new Vehicle(rs.getInt("vehicleid"),rs.getString("registernumber"),rs.getString("model"),rs.getInt("seat"),rs.getString("type"),rs.getDouble("kmcost"),rs.getString("branch"));
			 vehicles.add(vehicle);
		 }
		 
		    st.close();
			connection.close();
			return vehicles;
	 }
	 
	 public static boolean deleteProduct(int vehicleid) throws ClassNotFoundException, SQLException {
		 	DbConnector connector =new DbConnectorSQL();
			Connection connection = connector.getConnection();
			
			String query = "DELETE FROM vehicle WHERE vehicleid=?";
			PreparedStatement ps = connection.prepareStatement(query);
			ps.setInt(1, vehicleid);
			
			boolean result = ps.executeUpdate() > 0 ;
			ps.close();
			connection.close();
			return result;
		 
	 }
	 
	 
	 public static Vehicle getTheVehicleByVehicleID(int vehicleCode) throws ClassNotFoundException, SQLException {
		    DbConnector connector =new DbConnectorSQL();
			Connection connection = connector.getConnection();
			String query = "SELECT * FROM vehicle WHERE vehicleid=? ";
			PreparedStatement ps=connection.prepareStatement(query);
			ps.setInt(1, vehicleCode);
			ResultSet rs=ps.executeQuery();
			Vehicle vehicle=new Vehicle();
			if(rs.next()) {
				
				vehicle.setVehicleID(rs.getInt("vehicleid"));
				vehicle.setVehicle_Registernumber(rs.getString("registernumber"));
				vehicle.setVehicle_Model( rs.getString("model"));
				vehicle.setNumberof_Seat(rs.getInt("seat"));
				vehicle.setVehicle_Type(rs.getString("type"));
				vehicle.setCostper_Km(rs.getDouble("kmcost"));
				vehicle.setBranch(rs.getString("branch"));
			}
			ps.close();
			connection.close();
			return vehicle;
		    
	 }
	 
	 public static boolean updateVehicle(Vehicle vehicle) throws ClassNotFoundException, SQLException {
		 	DbConnector connector =new DbConnectorSQL();
			Connection connection = connector.getConnection();
			String query = "UPDATE vehicle SET registernumber=? , model=? , seat=? , type=?,kmcost=?, branch=? WHERE vehicleid=?";
			PreparedStatement ps = connection.prepareStatement(query);
			ps.setString(1, vehicle.getVehicle_Registernumber());
			ps.setString(2, vehicle.getVehicle_Model());
			ps.setInt(3,vehicle.getNumberof_Seat() );
			ps.setString(4, vehicle.getVehicle_Type());
			ps.setDouble(5, vehicle.getCostper_Km());
			ps.setString(6, vehicle.getBranch());
			ps.setInt(7, vehicle.getVehicleID());
			boolean result = ps.executeUpdate() > 0 ;
			ps.close();
			connection.close();
			return result;
		 
		 
	 }
	 
	 
	 
		public static List<Vehicle> searchBookingVehicle(Booking booking,Vehicle vehicle) throws ClassNotFoundException, SQLException {
			DbConnector connector =new DbConnectorSQL();
			Connection connection = connector.getConnection();
			String query = "SELECT DISTINCT vehicleid,model,seat,type,kmcost  FROM vehicle LEFT JOIN booking ON vehicleid = vid WHERE NOT (startdate>=? AND enddate<=?  OR enddate>=? AND  startdate<=?) and type=?";
			PreparedStatement ps=connection.prepareStatement(query);
			   ps.setString(1, booking.getStart_Date().toString());
				ps.setString(2, booking.getEnd_Date().toString());
				ps.setString(3, booking.getEnd_Date().toString());
				ps.setString(4,booking.getStart_Date().toString() );
				ps.setString(5,vehicle.getVehicle_Type());
			    ResultSet rs=ps.executeQuery();
			
			//ResultSet rs=ps.executeQuery(query);
			List<Vehicle>availablevehicles=new ArrayList();
			
			while(rs.next()) {
				vehicle=new Vehicle(rs.getInt("vehicleid"),rs.getString("model"),rs.getInt("seat"),rs.getString("type"),rs.getDouble("kmcost"));
				
				
				availablevehicles.add(vehicle);
				
			}
			ps.close();
			connection.close();
			return availablevehicles;
			
			
		}
	 
		public static List<Vehicle> getVehilcesWithoutDriver(Vehicle vehicle) throws ClassNotFoundException, SQLException {
			DbConnector connector =new DbConnectorSQL();
			Connection connection = connector.getConnection();
			String query = "SELECT model,vid,vehicleid FROM vehicle LEFT JOIN driver on vehicleid=vid where vid is  null";
			PreparedStatement ps=connection.prepareStatement(query);
			 ResultSet rs=ps.executeQuery();
			List<Vehicle>vehiclesdata=new ArrayList();
			while(rs.next()) {
				vehicle=new Vehicle();
				vehicle.setVehicle_Model(rs.getString("model"));
				vehicle.setVehicleID(rs.getInt("vehicleid"));
				
				vehiclesdata.add(vehicle);
			};
			ps.close();
			connection.close();
			return vehiclesdata;
			
			
		}
		
		
		
	 
}
