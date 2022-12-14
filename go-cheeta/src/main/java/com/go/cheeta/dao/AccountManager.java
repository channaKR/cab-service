package com.go.cheeta.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.javatuples.Pair;

import com.go.cheeta.model.Account;
import com.go.cheeta.model.Customer;
import com.go.cheeta.model.DriverClass;
import com.go.cheeta.model.Vehicle;

public class AccountManager {

	public static boolean addAccountData(Customer customer,Account customeraccount) throws ClassNotFoundException, SQLException {
		DbConnector connector = new DbConnectorSQL();
		Connection connection = connector.getConnection();
		String query="INSERT INTO customer (firstname,secondname,address1,address2,city,email) Values (?,?,?,?,?,?)";
		PreparedStatement ps = connection.prepareStatement(query);
		ps.setString(1,customer.getCustomername1());
		ps.setString(2,customer.getCustomername2());
		ps.setString(3,customer.getAddress1());
		ps.setString(4,customer.getAddress2());
		ps.setString(5,customer.getCity());
		ps.setString(6,customeraccount.getEmail());
		boolean result = ps.executeUpdate() > 0 ;
		addLogin(customeraccount);
		ps.close();
		connection.close();
		return result;
		
	}
	
	
	public static boolean addLogin(Account customer) throws ClassNotFoundException, SQLException {
		DbConnector connector = new DbConnectorSQL();
		Connection connection = connector.getConnection();
		String query="INSERT INTO login (email,password,roll) Values (?,?,?)";
		PreparedStatement ps = connection.prepareStatement(query);
		ps.setString(1,customer.getEmail());
		ps.setString(2,customer.getPassword());
		ps.setString(3,customer.getRoll());
		
	
		boolean result = ps.executeUpdate() > 0 ;
		ps.close();
		connection.close();
		return result;
		
	}
	
	public static Customer Login(Account login,Customer customer) throws ClassNotFoundException, SQLException {
		DbConnector connector = new DbConnectorSQL();
		Connection connection = connector.getConnection();
		String query="SELECT customer.firstname,customer.secondname,login.email,customer.customerid FROM login LEFT JOIN customer ON login.email=customer.email where login.email=? AND password=?";
		PreparedStatement ps=connection.prepareStatement(query);
		ps.setString(1, login.getEmail());
		ps.setString(2, login.getPassword());
		ResultSet rs=ps.executeQuery();
		Account ac=new Account();
		Customer cs=new Customer();
		if(rs.next()) {
			customer.setCustomername1(rs.getString("firstname"));
			customer.setCustomername2(rs.getString("secondname"));
			customer.setEmail(rs.getString("email"));
			customer.setCustomer_ID(rs.getInt("customerid"));
		}
		ps.close();
		connection.close();
		return customer;
		
}
	
public static Account adminLogin(Account login) throws ClassNotFoundException, SQLException {
	DbConnector connector=new DbConnectorSQL();
	Connection connection = connector.getConnection();
	String query="SELECT email FROM gocheeta.login where email=? and password=? and roll='admin'";
	PreparedStatement ps=connection.prepareStatement(query);
	ps.setString(1, login.getEmail());
	ps.setString(2, login.getPassword());
	ResultSet rs=ps.executeQuery();
	Account lg=new Account();
	if(rs.next()) {
		
		lg.setEmail(rs.getString("email"));
		
	}
	ps.close();
	connection.close();
	return lg;
	
}
	
	
	public static DriverClass DriverLogin(Account login,DriverClass driver) throws ClassNotFoundException, SQLException {
		DbConnector connector = new DbConnectorSQL();
		Connection connection = connector.getConnection();
		String query="SELECT driver.drivername,driver.drivernic,driver.email FROM driver LEFT join login on driver.email=login.email where login.email=? AND login.password=? AND roll='driver'";
		PreparedStatement ps=connection.prepareStatement(query);
		ps.setString(1, login.getEmail());
		ps.setString(2, login.getPassword());
		ResultSet rs=ps.executeQuery();
		Account ac=new Account();
		Customer cs=new Customer();
		if(rs.next()) {
			driver.setDrivername(rs.getString("drivername"));
			driver.setNicnumber(rs.getString("drivernic"));
			driver.setEmail(rs.getString("email"));
		}
		ps.close();
		connection.close();
		return driver;
		
}
	
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
		
		
		boolean result = ps.executeUpdate() > 0 ;
		addLogin(account);
		ps.close();
		connection.close();
		return result;
	}
	
	
	public static Customer getCustomerbyID(Customer customer) throws ClassNotFoundException, SQLException {
		DbConnector connector = new DbConnectorSQL();
		Connection connection = connector.getConnection();
		String query="SELECT firstname,secondname FROM gocheeta.customer where customerid=?";
		PreparedStatement ps = connection.prepareStatement(query);
		ps.setInt(1, customer.getCustomer_ID());
		ResultSet rs=ps.executeQuery();
		
		if(rs.next()) {
			customer.setCustomername1(rs.getString("firstname"));
			customer.setCustomername2(rs.getString("secondname"));
			
		}
		ps.close();
		connection.close();
		return customer;
		
	
	}
	
	
}
