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
	private int customerid;
	private double costfor_vehicle;
	private int confirm;
	public Booking() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Booking(int booking_ID, LocalDate start_Date, LocalDate end_Date, String baranch, String location,
			double killometers, int vehicle_ID, int customerid, double costfor_vehicle, int confirm) {
		super();
		this.booking_ID = booking_ID;
		this.start_Date = start_Date;
		this.end_Date = end_Date;
		this.baranch = baranch;
		this.location = location;
		this.killometers = killometers;
		this.vehicle_ID = vehicle_ID;
		this.customerid = customerid;
		this.costfor_vehicle = costfor_vehicle;
		this.confirm = confirm;
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
	public int getCustomerid() {
		return customerid;
	}
	public void setCustomerid(int customerid) {
		this.customerid = customerid;
	}
	public double getCostfor_vehicle() {
		return costfor_vehicle;
	}
	public void setCostfor_vehicle(double costfor_vehicle) {
		this.costfor_vehicle = costfor_vehicle;
	}
	public int getConfirm() {
		return confirm;
	}
	public void setConfirm(int confirm) {
		this.confirm = confirm;
	}

	
}
