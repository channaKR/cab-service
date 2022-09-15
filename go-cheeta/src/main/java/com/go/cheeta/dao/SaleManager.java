package com.go.cheeta.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.go.cheeta.service.Sales;

public class SaleManager {

	public static boolean addSale() throws ClassNotFoundException, SQLException {
		DbConnector connector = new DbConnectorSQL();
		Connection connection = connector.getConnection();
		Sales sales=new Sales();
		String query="Insert into confirmorder (customerid,coast,vehicleregnumber) values"+
		"(?,?,?)";
		PreparedStatement ps = connection.prepareStatement(query);
		ps.setInt(1,sales.getCustomerid());
		ps.setDouble(2, sales.getPaymentcoast());
		ps.setString(3, sales.getVehicleid());
		boolean result = ps.executeUpdate() > 0 ;
		ps.close();
		connection.close();
		return result;
	}
}