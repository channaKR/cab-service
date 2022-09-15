package com.go.cheeta.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.go.cheeta.model.*;

public class SaleManager {

	public static boolean addSale() throws ClassNotFoundException, SQLException {
		DbConnector connector = new DbConnectorSQL();
		Connection connection = connector.getConnection();
		Sales sales=new Sales();
		String query="Insert into confirmorder (customerid,coast,vehicleregnumber,branch,paymentdate) values"+
		"(?,?,?)";
		PreparedStatement ps = connection.prepareStatement(query);
		ps.setInt(1,sales.getCustomerid());
		ps.setDouble(2, sales.getPaymentcoast());
		ps.setString(3, sales.getVehicleRegisterNumber());
		ps.setString(4, sales.getBranch());
		ps.setString(5, sales.getDate().toString());
		boolean result = ps.executeUpdate() > 0 ;
		ps.close();
		connection.close();
		return result;
	}
}
