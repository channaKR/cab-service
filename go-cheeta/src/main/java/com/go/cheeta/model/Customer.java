package com.go.cheeta.model;

public class Customer {
	private int customer_ID;
	private String customername1;
	private String customername2;
	private String address1;
	private String address2;
	private String city;
	private String email;
	public Customer() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Customer(int customer_ID, String customername1, String customername2,String email, String address1, String address2,
			String city) {
		super();
		this.customer_ID = customer_ID;
		this.customername1 = customername1;
		this.customername2 = customername2;
		this.email=email;
		this.address1 = address1;
		this.address2 = address2;
		this.city = city;
	}
	public int getCustomer_ID() {
		return customer_ID;
	}
	public void setCustomer_ID(int customer_ID) {
		this.customer_ID = customer_ID;
	}
	public String getCustomername1() {
		return customername1;
	}
	public void setCustomername1(String customername1) {
		this.customername1 = customername1;
	}
	public String getCustomername2() {
		return customername2;
	}
	public void setCustomername2(String customername2) {
		this.customername2 = customername2;
	}
	public String getAddress1() {
		return address1;
	}
	public void setAddress1(String address1) {
		this.address1 = address1;
	}
	public String getAddress2() {
		return address2;
	}
	public void setAddress2(String address2) {
		this.address2 = address2;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
  
	
	
}
