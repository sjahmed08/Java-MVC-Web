package com.tcs.ilp.infinity.model;

public class SetTopBox {
	double serial; double  macID; 
	double remoteID; double dishId;
	String status, type;

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public SetTopBox(){};
	
	public SetTopBox(double serial, double macID, double remoteID, double dishId) {
		super();
		this.serial = serial;
		this.macID = macID;
		this.remoteID = remoteID;
		this.dishId = dishId;
	}
	public double getSerial() {
		return serial;
	}
	public void setSerial(double serial) {
		this.serial = serial;
	}
	public double getMacID() {
		return macID;
	}
	public void setMacID(double macID) {
		this.macID = macID;
	}
	public double getRemoteID() {
		return remoteID;
	}
	public void setRemoteID(double remoteID) {
		this.remoteID = remoteID;
	}
	public double getDishId() {
		return dishId;
	}
	public void setDishId(double dishId) {
		this.dishId = dishId;
	}
	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}
}
