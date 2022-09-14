package com.go.cheeta.dao;

import java.sql.*;

public class DbConnectorSQL implements DbConnector {

	@Override
	public Connection getConnection() throws ClassNotFoundException, SQLException {
         
Class.forName("com.mysql.cj.jdbc.Driver");
		
		String url="jdbc:mysql://localhost:3306/gocheeta";
	    String userName="root";
		String password="123456";
		return DriverManager.getConnection(url,userName,password);
	}

}
