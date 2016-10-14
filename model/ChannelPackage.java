package com.tcs.ilp.infinity.model;

public class ChannelPackage {
	private String channelPackageID;

	private String packageName, packageCategory, packageChargingType, packageTransmissionType,
	packageCost = "0", addedByDefault, packageAvailStart, packageAvailEnd;
	
//private Date packageAvailStart, packageAvailEnd;

	public ChannelPackage(){};

	public String getChannelPackageID() {
		return channelPackageID;
	}

	public void setChannelPackageID(String channelPackageID) {
		this.channelPackageID = channelPackageID;
	}

	public String getPackageName() {
		return packageName;
	}

	public void setPackageName(String packageName) {
		this.packageName = packageName;
	}

	public String getPackageCategory() {
		return packageCategory;
	}

	public void setPackageCategory(String packageCategory) {
		this.packageCategory = packageCategory;
	}

	public String getPackageChargingType() {
		return packageChargingType;
	}

	public void setPackageChargingType(String packageChargingType) {
		this.packageChargingType = packageChargingType;
	}

	public String getPackageTransmissionType() {
		return packageTransmissionType;
	}

	public void setPackageTransmissionType(String packageTransmissionType) {
		this.packageTransmissionType = packageTransmissionType;
	}

	public String getPackageCost() {
		return packageCost;
	}

	public void setPackageCost(String packageCost) {
		this.packageCost = packageCost;
	}

	public String getPackageAvailStart() {
		return packageAvailStart;
	}

	public void setPackageAvailStart(String packageAvailStart) {
		this.packageAvailStart = packageAvailStart;
	}

	public String getPackageAvailEnd() {
		return packageAvailEnd;
	}

	public void setPackageAvailEnd(String packageAvailEnd) {
		this.packageAvailEnd = packageAvailEnd;
	}

	public String getAddedByDefault() {
		return addedByDefault;
	}

	public void setAddedByDefault(String addedByDefault) {
		this.addedByDefault = addedByDefault;
	}	
}
