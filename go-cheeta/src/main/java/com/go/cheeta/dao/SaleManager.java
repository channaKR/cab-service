package com.go.cheeta.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.List.*;

import com.go.cheeta.model.*;

public class SaleManager {

	public static boolean addSale(Sales sales) throws ClassNotFoundException, SQLException {
		DbConnector connector = new DbConnectorSQL();
		Connection connection = connector.getConnection();
		
		String query="Insert into confirmorder (customerid,coast,vehicleregnumber,branch,paymentdate) values"+
		"(?,?,?,?,?)";
		PreparedStatement ps = connection.prepareStatement(query);
		ps.setInt(1,sales.getCustomerid());
		ps.setDouble(2, sales.getPaymentcoast());
		ps.setInt(3, sales.getVehicleRegisterNumber());
		ps.setString(4, sales.getBranch());
		ps.setString(5, sales.getDate().toString());
		boolean result = ps.executeUpdate() > 0 ;
		ps.close();
		connection.close();
		return result;
	}
	
	public static List<Sales> searchByBranch() throws ClassNotFoundException, SQLException {
		
		 DbConnector connector = new DbConnectorSQL();
		 Connection connection = connector.getConnection();
		 String query = "SELECT  SUM(coast) ,branch FROM confirmorder group by branch ";
		 Statement st=connection.createStatement();
		 ResultSet rs=st.executeQuery(query);
		 
		 List<Sales>sales=new ArrayList();
		 while(rs.next()) {
			 Sales sale=new Sales();
			 sale.setPaymentcoast(rs.getFloat("SUM(coast)"));
			 sale.setBranch(rs.getString("branch"));
			 sales.add(sale);
		 }
		 
		    st.close();
			connection.close();
			
		return sales;
		
		
		
	}
	
	
	public  static Sales allCoast() throws ClassNotFoundException, SQLException {
		
		 DbConnector connector = new DbConnectorSQL();
		 Connection connection = connector.getConnection();
		 String query = "SELECT SUM(coast) FROM confirmorder";
		 Statement st=connection.createStatement();
		 ResultSet rs=st.executeQuery(query);
		 Sales saledata=new Sales();
		 if(rs.next()) {
			 Sales sale=new Sales();
			 sale.setPaymentcoast(rs.getFloat("SUM(coast)"));
			 saledata=sale;
		 }
		 
		 return saledata;
	}
	
	public static List<Sales> searchBranchSales(Sales sale) throws ClassNotFoundException, SQLException {
		
		 DbConnector connector = new DbConnectorSQL();
		 Connection connection = connector.getConnection();
		 String query = "SELECT SUM(coast),branch FROM gocheeta.confirmorder where paymentdate=? && branch=?";
		 PreparedStatement ps=connection.prepareStatement(query);
		 ps.setString(1, sale.getDate().toString());
		 ps.setString(2, sale.getBranch());
		 ResultSet rs=ps.executeQuery();
		 List<Sales>sales=new ArrayList<Sales>();
		 
		
		 while(rs.next()) {
			 sale=new Sales();
			 sale.setPaymentcoast(rs.getFloat("SUM(coast)"));
			 sale.setBranch(rs.getString("branch"));
			 sales.add(sale);
		 }
		 connection.close();
		 return sales;
}
	

	public static List<Sales> getConfirmOrders(Sales sale) throws ClassNotFoundException, SQLException {
		
		 DbConnector connector = new DbConnectorSQL();
		 Connection connection = connector.getConnection();
		 String query = "SELECT * FROM gocheeta.confirmorder where customerid=? or vehicleregnumber=?";
		 PreparedStatement ps=connection.prepareStatement(query);
		 ps.setInt(1, sale.getCustomerid());
		 ps.setInt(2, sale.getVehicleRegisterNumber());
		 ResultSet rs=ps.executeQuery();
		 List<Sales>sales=new ArrayList<Sales>();
		 
		
		 while(rs.next()) {
			 	String dateorder=rs.getString("paymentdate");
	    		
	    		LocalDate orderdate = LocalDate.parse (dateorder);
	    		sale=new Sales(rs.getInt("orderid"),rs.getInt("customerid"),rs.getDouble("coast"),rs.getInt("vehicleregnumber"),rs.getString("branch"),orderdate);
			 
			 sales.add(sale);
		 }
		 connection.close();
		 return sales;
}
	

}
