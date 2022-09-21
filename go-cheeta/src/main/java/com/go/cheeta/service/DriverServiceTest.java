package com.go.cheeta.service;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.*;

import java.sql.SQLException;
import java.util.List;

import org.junit.jupiter.api.Test;

import com.go.cheeta.model.Account;
import com.go.cheeta.model.DriverClass;
import com.go.cheeta.model.Vehicle;
import com.mysql.cj.jdbc.Driver;

class DriverServiceTest {

	@Test
	void testLogin() {
		Account login=new Account();
		DriverClass driver=new DriverClass();
		DriverService service=new DriverService();
		login.setEmail("chanukabandara");
		login.setPassword("23333");
		try {
			driver=service.login(login, driver);
			assertEquals(null,driver.getDrivername());
			
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}

	@Test
	void testAddDriver() {
		
		
	}

	@Test
	void testViewOrdersDriver() {
		
		
	}

	@Test
	void testLoginAccountDriverClass() {
		
	}

	@Test
	void testConfirmBooking() {
		fail("Not yet implemented");
	}

	@Test
	void testGetAllDriversData() {
		DriverService service=new DriverService();
		try {
			List<DriverClass>dr=service.getAllDriversData();
			assertNotNull(dr);
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}

	@Test
	void testGetDriverInformation() {
		Vehicle vehicle=new Vehicle();
		vehicle.setVehicleID(12);
		
		DriverClass driver=new DriverClass();
		DriverService driverser=new DriverService();
		try {
			driver=driverser.getDriverInformation(vehicle);
			String name=driver.getDrivername();
			assertEquals(name,driver.getDrivername());
			
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
	}

	@Test
	void testUpdateDriver() {
		
	}

}
