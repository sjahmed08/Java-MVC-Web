package com.tcs.ilp.infinity.model;

public class Retailer {
	private int retailerID;

	String name, contactNo1, contactNo2, address1, address2, city, state, pinCode,
	setTopBoxLimit, creditLimit, commissionPercentage, serviceCharge, inventoryList;

	public Retailer(){};
	
	public Retailer(int retailerID, String name, String contactNo1, String contactNo2, String address1, String address2, String city, String state, String pinCode, String setTopBoxLimit, String creditLimit, String commissionPercentage, String serviceCharge, String inventoryList){
		this.retailerID = retailerID;
		this.name = name;
		this.contactNo1 = contactNo1;
		this.contactNo2 = contactNo2;
		this.address1 = address1;
		this.address2 = address2;
		this.city = city;
		this.state = state;
		this.pinCode = pinCode;
		this.setTopBoxLimit = setTopBoxLimit;
		this.creditLimit = creditLimit;
		this.commissionPercentage = commissionPercentage;
		this.serviceCharge = serviceCharge;
		this.inventoryList = inventoryList;
	}
	
	public Retailer(String name, String contactNo1, String contactNo2, String address1, String address2, String city, String state, String pinCode, String setTopBoxLimit, String creditLimit, String commissionPercentage, String serviceCharge, String inventoryList){
		this.name = name;
		this.contactNo1 = contactNo1;
		this.contactNo2 = contactNo2;
		this.address1 = address1;
		this.address2 = address2;
		this.city = city;
		this.state = state;
		this.pinCode = pinCode;
		this.setTopBoxLimit = setTopBoxLimit;
		this.creditLimit = creditLimit;
		this.commissionPercentage = commissionPercentage;
		this.serviceCharge = serviceCharge;
		this.inventoryList = inventoryList;
	}
	
	public int getRetailerID() {
		return retailerID;
	}

	public void setRetailerID(int retailerID) {
		this.retailerID = retailerID;
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getContactNo1() {
		return contactNo1;
	}

	public void setContactNo1(String contactNo1) {
		this.contactNo1 = contactNo1;
	}

	public String getContactNo2() {
		return contactNo2;
	}

	public void setContactNo2(String contactNo2) {
		this.contactNo2 = contactNo2;
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

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getPinCode() {
		return pinCode;
	}

	public void setPinCode(String pinCode) {
		this.pinCode = pinCode;
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

	public String getCommissionPercentage() {
		return commissionPercentage;
	}

	public void setCommissionPercentage(String commissionPercentage) {
		this.commissionPercentage = commissionPercentage;
	}

	public String getServiceCharge() {
		return serviceCharge;
	}

	public void setServiceCharge(String serviceCharge) {
		this.serviceCharge = serviceCharge;
	}

	public String getInventoryList() {
		return inventoryList;
	}

	public void setInventoryList(String inventoryList) {
		this.inventoryList = inventoryList;
	}

	public void setCreationDate(String string) {
		// TODO Auto-generated method stub
		
	}
}
