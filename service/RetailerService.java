package com.tcs.ilp.infinity.service;

import com.tcs.ilp.infinity.dao.RetailerDAO;
import com.tcs.ilp.infinity.model.Retailer;

public class RetailerService {
	public int createRetailer(Retailer retailer){
		RetailerDAO retailerDAO = new RetailerDAO();
		return retailerDAO.createRetailer(retailer);
	}
	
	public Retailer searchRetailer(int ID){
		RetailerDAO retailerDAO = new RetailerDAO();
		return retailerDAO.searchRetailer(ID);
	}
	
	public int updateRetailer(Retailer retailer){
		RetailerDAO retailerDAO = new RetailerDAO();
		return retailerDAO.updateRetailer(retailer);
	}
	
	public int deleteRetailer(int retailerID){
		RetailerDAO retailerDAO = new RetailerDAO();
		return retailerDAO.deleteRetailer(retailerID);
	}

}
