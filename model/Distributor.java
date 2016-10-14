package com.tcs.ilp.infinity.model;

public class Distributor {
	private int distributorID;
	private String distributorName, contact1, contact2, address1, address2, city,
	pinCode, zone, setTopBoxLimit, creditLimit;
	
	public Distributor(){};
	
	
	public int getDistributorID() {
		return distributorID;
	}
	public void setDistributorID(int distributorID) {
		this.distributorID = distributorID;
	}
	public String getDistributorName() {
		return distributorName;
	}
	public void setDistributorName(String distributorName) {
		this.distributorName = distributorName;
	}
	public String getContact1() {
		return contact1;
	}
	public void setContact1(String contact1) {
		this.contact1 = contact1;
	}
	public String getContact2() {
		return contact2;
	}
	public void setContact2(String contact2) {
		this.contact2 = contact2;
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
	public String getPinCode() {
		return pinCode;
	}
	public void setPinCode(String pinCode) {
		this.pinCode = pinCode;
	}
	public String getZone() {
		return zone;
	}
	public void setZone(String zone) {
		this.zone = zone;
	}
	public String getSetTopBoxLimit() {
		return setTopBoxLimit;
	}
	public void setSetTopBoxLimit(String setTopBoxLimit) {
		this.setTopBoxLimit = setTopBoxLimit;
	}
	public String getCreditLimit() {
		return creditLimit;
	}
	public void setCreditLimit(String creditLimit) {
		this.creditLimit = creditLimit;
	}
}
