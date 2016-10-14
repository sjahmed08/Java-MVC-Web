package com.tcs.ilp.infinity.service;


import com.tcs.ilp.infinity.dao.SetTopBoxTypeDAO;
import com.tcs.ilp.infinity.model.SetTopBoxType;

public class SetTopBoxTypeService {
	

	public int createSetTopBoxType(SetTopBoxType setTopBoxType) 
	{
		SetTopBoxTypeDAO setTopBoxTypeDAO = new SetTopBoxTypeDAO();
		return setTopBoxTypeDAO.createSetTopBoxType(setTopBoxType);
	}
	
	public SetTopBoxType searchSetTopBoxType(int ID) 
	{
		SetTopBoxTypeDAO setTopBoxTypeDAO = new SetTopBoxTypeDAO();
		return setTopBoxTypeDAO.searchSetTopBoxType(ID);
	}
	
}


