package com.go.cheeta.model;

public class DriverClass {
	private String nicnumber;
	private String drivername;
	private String address;
	private String contactnumber;
	private String email;
	private int vehicleID;
	
	public DriverClass() {
		super();
		// TODO Auto-generated constructor stub
	}

	public DriverClass(String nicnumber, String drivername, String address, String contactnumber, String email,
			int vehicleID) {
		super();
		this.nicnumber = nicnumber;
		this.drivername = drivername;
		this.address = address;
		this.contactnumber = contactnumber;
		this.email = email;
		this.vehicleID = vehicleID;
	}

	public int getDriverid() {
		return vehicleID;
	}
	
	public int getVehicleID() {
		return vehicleID;
	}

	public void setVehicleID(int vehicleID) {
		this.vehicleID = vehicleID;
	}

	public String getDrivername() {
		return drivername;
	}

	public void setDrivername(String drivername) {
		this.drivername = drivername;
	}
	public String getContactnumber() {
		return contactnumber;
	}
	public void setContactnumber(String contactnumber) {
		this.contactnumber = contactnumber;
	}
	public String getNicnumber() {
		return nicnumber;
	}
	public void setNicnumber(String nicnumber) {
		this.nicnumber = nicnumber;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
	
	
	
}
