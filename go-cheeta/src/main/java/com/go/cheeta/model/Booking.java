package com.go.cheeta.model;

import java.time.LocalDate;
import java.util.Date;

public class Booking {

	private int booking_ID;
	private LocalDate start_Date;
	private LocalDate end_Date;
	private String baranch;
	private String location;
	private double killometers;
	private int vehicle_ID;
	private int driver_ID;
	private String booking_Result;
	private String vehiclemodel;
	private double costfor_vehicle;
	
	public Booking() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Booking(int booking_ID, LocalDate start_Date, LocalDate end_Date, String baranch, String location,
			double killometers, int vehicle_ID, int driver_ID, String booking_Result) {
		super();
		this.booking_ID = booking_ID;
		this.start_Date = start_Date;
		this.end_Date = end_Date;
		this.baranch = baranch;
		this.location = location;
		this.killometers = killometers;
		this.vehicle_ID = vehicle_ID;
		this.driver_ID = driver_ID;
		this.booking_Result = booking_Result;
	}
	public int getBooking_ID() {
		return booking_ID;
	}
	public void setBooking_ID(int booking_ID) {
		this.booking_ID = booking_ID;
	}
	public LocalDate getStart_Date() {
		return start_Date;
	}
	public void setStart_Date(LocalDate start_Date) {
		this.start_Date = start_Date;
	}
	public LocalDate getEnd_Date() {
		return end_Date;
	}
	public void setEnd_Date(LocalDate end_Date) {
		this.end_Date = end_Date;
	}
	public String getBaranch() {
		return baranch;
	}
	public void setBaranch(String baranch) {
		this.baranch = baranch;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	public double getKillometers() {
		return killometers;
	}
	public void setKillometers(double killometers) {
		this.killometers = killometers;
	}
	public int getVehicle_ID() {
		return vehicle_ID;
	}
	public void setVehicle_ID(int vehicle_ID) {
		this.vehicle_ID = vehicle_ID;
	}
	public int getDriver_ID() {
		return driver_ID;
	}
	public void setDriver_ID(int driver_ID) {
		this.driver_ID = driver_ID;
	}
	public String getBooking_Result() {
		return booking_Result;
	}
	public void setBooking_Result(String booking_Result) {
		this.booking_Result = booking_Result;
	}
	public String getVehiclemodel() {
		return vehiclemodel;
	}
	public void setVehiclemodel(String vehiclemodel) {
		this.vehiclemodel = vehiclemodel;
	}
	public double getCostfor_vehicle() {
		return costfor_vehicle;
	}
	public void setCostfor_vehicle(double costfor_vehicle) {
		this.costfor_vehicle = costfor_vehicle;
	}
	
	
	
}
