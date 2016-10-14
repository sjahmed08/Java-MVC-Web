package com.tcs.ilp.infinity.model;

public class SetTopBoxType {
	String type, features; 

	int setTopBoxTypeID;
	double length; double breadth; double width; 
	double price; double installCharges; double upgradationCharges;
	double discount; double billingType; double refund;
	
	
	public SetTopBoxType(){};
	
	public SetTopBoxType(String type, int setTopBoxTypeID, double length, double breadth, double width,
			double price, double installCharges, double upgradationCharges,
			double discount, double billingType, double refund) {
		super();
		this.type = type;
		this.setTopBoxTypeID=setTopBoxTypeID;
		this.length = length;
		this.breadth = breadth;
		this.width = width;
		this.price = price;
		this.installCharges = installCharges;
		this.upgradationCharges = upgradationCharges;
		this.discount = discount;
		this.billingType = billingType;
		this.refund = refund;
		
	}


	public int getSetTopBoxTypeID() {
		return setTopBoxTypeID;
	}

	public void setSetTopBoxTypeID(int setTopBoxTypeID) {
		this.setTopBoxTypeID = setTopBoxTypeID;
	}
	
	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}
	
	public String getFeatures() {
		return features;
	}

	public void setFeatures(String features) {
		this.features = features;
	}


	public double getLength() {
		return length;
	}

	public void setLength(double length) {
		this.length = length;
	}

	public double getBreadth() {
		return breadth;
	}

	public void setBreadth(double breadth) {
		this.breadth = breadth;
	}

	public double getWidth() {
		return width;
	}

	public void setWidth(double width) {
		this.width = width;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public double getInstallCharges() {
		return installCharges;
	}

	public void setInstallCharges(double installCharges) {
		this.installCharges = installCharges;
	}

	public double getUpgradationCharges() {
		return upgradationCharges;
	}

	public void setUpgradationCharges(double upgradationCharges) {
		if(type!="Standard");
		this.upgradationCharges = upgradationCharges;
	}

	public double getDiscount() {
		return discount;
	}

	public void setDiscount(double discount) {
		this.discount = discount;
	}

	public double getBillingType() {
		return billingType;
	}

	public void setBillingType(double billingType) {
		this.billingType = billingType;
	}

	public double getRefund() {
		return refund;
	}

	public void setRefund(double refund) {
		this.refund = refund;
	}

	
}
