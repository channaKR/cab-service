package com.go.cheeta.model;

public class Vehicle {
  private int vehicleID;
  private String vehicle_Registernumber;
  private String vehicle_Model;
  private int numberof_Seat;
  private String vehicle_Type;
  private double costper_Km;
  private String branch;
	
	
public Vehicle() {
	super();
	// TODO Auto-generated constructor stub
}

public Vehicle(int vehicleID, String vehicle_Registernumber, String vehicle_Model, int numberof_Seat,
		String vehicle_Type, double costper_Km, String branch) {
	super();
	this.vehicleID = vehicleID;
	this.vehicle_Registernumber = vehicle_Registernumber;
	this.vehicle_Model = vehicle_Model;
	this.numberof_Seat = numberof_Seat;
	this.vehicle_Type = vehicle_Type;
	this.costper_Km = costper_Km;
	this.branch = branch;
}





public Vehicle(int vehicleID, String vehicle_Model,int numberof_Seat,String vehicle_Type,double costper_Km) {
	super();
	this.vehicleID = vehicleID;
	this.vehicle_Model = vehicle_Model;
	this.numberof_Seat=numberof_Seat;
	this.vehicle_Type=vehicle_Type;
	this.costper_Km=costper_Km;
}

public int getVehicleID() {
	return vehicleID;
}


public void setVehicleID(int vehicleID) {
	this.vehicleID = vehicleID;
}


public String getVehicle_Registernumber() {
	return vehicle_Registernumber;
}


public void setVehicle_Registernumber(String vehicle_Registernumber) {
	this.vehicle_Registernumber = vehicle_Registernumber;
}


public String getVehicle_Model() {
	return vehicle_Model;
}


public void setVehicle_Model(String vehicle_Model) {
	this.vehicle_Model = vehicle_Model;
}


public int getNumberof_Seat() {
	return numberof_Seat;
}


public void setNumberof_Seat(int numberof_Seat) {
	this.numberof_Seat = numberof_Seat;
}


public String getVehicle_Type() {
	return vehicle_Type;
}


public void setVehicle_Type(String vehicle_Type) {
	this.vehicle_Type = vehicle_Type;
}


public double getCostper_Km() {
	return costper_Km;
}


public void setCostper_Km(double costper_Km) {
	this.costper_Km = costper_Km;
}


public String getBranch() {
	return branch;
}


public void setBranch(String branch) {
	this.branch = branch;
}

  
  
  
}
