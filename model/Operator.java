package com.tcs.ilp.infinity.model;

public class Operator {
	private int operatorID;
	
	private String firstName, lastName, emailID, phoneNumber, shiftTimeStart,
	shiftTimeEnd, maxNoCustomers, creationDate, password;

	public Operator(){};
	
	public Operator(int operatorID, String firstName, String lastName, String emailID, String phoneNumber, String shiftTimeStart, String shiftTimeEnd, String maxNoCustomers){
		this.operatorID = operatorID ;
		this.firstName = firstName;
		this.lastName = lastName;
		this.emailID = emailID;
		this.phoneNumber = phoneNumber;
		this.shiftTimeStart = shiftTimeStart;
		this.shiftTimeEnd = shiftTimeEnd;
		this.maxNoCustomers = maxNoCustomers;
	}

	public Operator(String firstName, String lastName, String emailID, String phoneNumber, String shiftTimeStart, String shiftTimeEnd, String maxNoCustomers){
		this.firstName = firstName;
		this.lastName = lastName;
		this.emailID = emailID;
		this.phoneNumber = phoneNumber;
		this.shiftTimeStart = shiftTimeStart;
		this.shiftTimeEnd = shiftTimeEnd;
		this.maxNoCustomers = maxNoCustomers;
	}
	
	public int getOperatorID() {
		return operatorID;
	}

	public void setOperatorID(int operatorID) {
		this.operatorID = operatorID;
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

	public String getShiftTimeStart() {
		return shiftTimeStart;
	}

	public void setShiftTimeStart(String shiftTimeStart) {
		this.shiftTimeStart = shiftTimeStart;
	}

	public String getShiftTimeEnd() {
		return shiftTimeEnd;
	}

	public void setShiftTimeEnd(String shiftTimeEnd) {
		this.shiftTimeEnd = shiftTimeEnd;
	}

	public String getMaxNoCustomers() {
		return maxNoCustomers;
	}

	public void setMaxNoCustomers(String maxNoCustomers) {
		this.maxNoCustomers = maxNoCustomers;
	}
	
	public String getCreationDate() {
		return creationDate;
	}

	public void setCreationDate(String creationDate) {
		this.creationDate = creationDate;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
}
