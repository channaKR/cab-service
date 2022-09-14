package com.go.cheeta.model;

public class Account {
  private String email;
  private String password;
  private String roll;

  public Account() {
	super();
	// TODO Auto-generated constructor stub
}
public Account(String email, String password, String roll ) {
	super();
	this.email = email;
	this.password = password;
	this.roll = roll;
	
}
public String getEmail() {
	return email;
}
public void setEmail(String email) {
	this.email = email;
}
public String getPassword() {
	return password;
}
public void setPassword(String password) {
	this.password = password;
}
public String getRoll() {
	return roll;
}
public void setRoll(String roll) {
	this.roll = roll;
}
 

  
}
