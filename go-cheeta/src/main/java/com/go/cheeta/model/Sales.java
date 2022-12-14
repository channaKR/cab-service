package com.go.cheeta.model;

import java.time.LocalDate;

public class Sales {

	private int orderid;
	private int customerid;
	private double paymentcoast;
	private int vehicleRegisterNumber;
	private String branch;
	private LocalDate date;
	
	public Sales() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Sales(int orderid, int customerid, double paymentcoast, int vehicleRegisterNumber, String branch,
			LocalDate date) {
		super();
		this.orderid = orderid;
		this.customerid = customerid;
		this.paymentcoast = paymentcoast;
		this.vehicleRegisterNumber = vehicleRegisterNumber;
		this.branch = branch;
		this.date = date;
	}

	public int getOrderid() {
		return orderid;
	}

	public void setOrderid(int orderid) {
		this.orderid = orderid;
	}

	public int getCustomerid() {
		return customerid;
	}

	public void setCustomerid(int customerid) {
		this.customerid = customerid;
	}

	public double getPaymentcoast() {
		return paymentcoast;
	}

	public void setPaymentcoast(double paymentcoast) {
		this.paymentcoast = paymentcoast;
	}

	public int getVehicleRegisterNumber() {
		return vehicleRegisterNumber;
	}

	public void setVehicleRegisterNumber(int vehicleRegisterNumber) {
		this.vehicleRegisterNumber = vehicleRegisterNumber;
	}

	public String getBranch() {
		return branch;
	}

	public void setBranch(String branch) {
		this.branch = branch;
	}

	public LocalDate getDate() {
		return date;
	}

	public void setDate(LocalDate date) {
		this.date = date;
	}
	
	
}
