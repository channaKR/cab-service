package com.go.cheeta.service;

public class Sales {

	private int orderid;
	private int customerid;
	private double paymentcoast;
	private String vehicleRegisterNumber;
	public Sales() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Sales(int orderid, int customerid, double paymentcoast, String vehicleRegisterNumber) {
		super();
		this.orderid = orderid;
		this.customerid = customerid;
		this.paymentcoast = paymentcoast;
		this.vehicleRegisterNumber = vehicleRegisterNumber;
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
	public String getVehicleid() {
		return vehicleRegisterNumber;
	}
	public void setVehicleid(String vehicleRegisterNumber) {
		this.vehicleRegisterNumber = vehicleRegisterNumber;
	}
	
	
	
}