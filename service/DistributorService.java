package com.tcs.ilp.infinity.service;

import com.tcs.ilp.infinity.dao.DistributorDAO;
import com.tcs.ilp.infinity.model.Distributor;

public class DistributorService {
	public int createDistributor (Distributor distributor)
	{
		DistributorDAO distributorDAO = new DistributorDAO();
		return distributorDAO.createDistributor(distributor);
	}
	
	public Distributor searchDistributor(String DistributorID)
	{
		DistributorDAO DistDao = new DistributorDAO();
		return DistDao.searchDistributor(DistributorID);
	}
	
	public int updateDistributor(Distributor dst)
	{
		DistributorDAO dstDAO = new DistributorDAO();
		return dstDAO.updateDistributor(dst);		
	}
	
	public int deleteDistributor(int ID)
	{
		DistributorDAO dst = new DistributorDAO();
		return dst.deleteDistributor(ID);
	}

}
