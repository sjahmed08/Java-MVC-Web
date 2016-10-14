package com.tcs.ilp.infinity.model;

public class Customer {
	private int customerID;
	
	private String firstName, lastName, emailID, phoneNumber, address1, address2,
	landMark, pinCode, city, state, operatorName, retailerName, password;
	
	public Customer(){};
	
	public Customer(int customerID, String firstName, String lastName, String emailID, String phoneNumber, String address1, String address2, String landMark, String pinCode, String city, String state){
		this.customerID = customerID;
		this.firstName = firstName;
		this.lastName = lastName;
		this.emailID = emailID;
		this.phoneNumber = phoneNumber;
		this.address1 = address1;
		this.address2 = address2;
		this.landMark = landMark;
		this.pinCode = pinCode;
		this.city = city;
		this.state = state;
	}
	
	public Customer(String firstName, String lastName, String emailID, String phoneNumber, String address1, String address2, String landMark, String pinCode, String city, String state){
		this.firstName = firstName;
		this.lastName = lastName;
		this.emailID = emailID;
		this.phoneNumber = phoneNumber;
		this.address1 = address1;
		this.address2 = address2;
		this.landMark = landMark;
		this.pinCode = pinCode;
		this.city = city;
		this.state = state;
	}
	
	public int getCustomerID() {
		return customerID;
	}

	public void setCustomerID(int customerID) {
		this.customerID = customerID;
	}
	
	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmailID() {
		return emailID;
	}

	public void setEmailID(String emailID) {
		this.emailID = emailID;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
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
	
	public String getLandMark() {
		return landMark;
	}

	public void setLandMark(String landMark) {
		this.landMark = landMark;
	}

	public String getPinCode() {
		return pinCode;
	}

	public void setPinCode(String pinCode) {
		this.pinCode = pinCode;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}
	
	public String getOperatorName() {
		return operatorName;
	}
	
	public void setOperatorName(String operatorName) {
		this.operatorName = operatorName;
	}
	
	public String getRetailerName() {
		return retailerName;
	}
	
	public void setRetailerName(String retailerName) {
		this.retailerName = retailerName;
	}
	
	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
}
