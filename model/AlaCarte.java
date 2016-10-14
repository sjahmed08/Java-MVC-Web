package com.tcs.ilp.infinity.model;

public class AlaCarte {

	String custName;
	//String that will pull details from channel object? -- everything listed under details is located in the actual channel object. 
	String channelDetails;
	double totalCost;
	double selectionCharges;
	double discount;
	double tax;
	double totalAmountPayable;
	
	public AlaCarte(){};
	
	public AlaCarte(String custName, String channelDetails, double totalCost,
			double selectionCharges, double discount, double tax,
			double totalAmountPayable) {
		super();
		this.custName = custName;
		this.channelDetails = channelDetails;
		this.totalCost = totalCost;
		this.selectionCharges = selectionCharges;
		this.discount = discount;
		this.tax = tax;
		this.totalAmountPayable = totalAmountPayable;
	}
	public String getCustName() {
		return custName;
	}
	public void setCustName(String custName) {
		this.custName = custName;
	}
	public String getChannelDetails() {
		return channelDetails;
	}
	public void setChannelDetails(String channelDetails) {
		this.channelDetails = channelDetails;
	}
	public double getTotalCost() {
		return totalCost;
	}
	public void setTotalCost(double totalCost) {
		this.totalCost = totalCost;
	}
	public double getSelectionCharges() {
		return selectionCharges;
	}
	public void setSelectionCharges(double selectionCharges) {
		this.selectionCharges = selectionCharges;
	}
	public double getDiscount() {
		return discount;
	}
	public void setDiscount(double discount) {
		this.discount = discount;
	}
	public double getTax() {
		return tax;
	}
	public void setTax(double tax) {
		this.tax = tax;
	}
	public double getTotalAmountPayable() {
		return totalAmountPayable;
	}
	public void setTotalAmountPayable(double totalAmountPayable) {
		this.totalAmountPayable = totalAmountPayable;
	}
	
	
	
	
}
