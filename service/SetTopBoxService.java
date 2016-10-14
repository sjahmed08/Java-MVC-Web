package com.tcs.ilp.infinity.service;

import com.tcs.ilp.infinity.model.SetTopBox;
import com.tcs.ilp.infinity.dao.SetTopBoxDAO;

public class SetTopBoxService {
	public int createSetTopBox(SetTopBox setTopBox){
		SetTopBoxDAO setTopBoxDAO = new SetTopBoxDAO();
		return setTopBoxDAO.createSetTopBox(setTopBox);
	}
	
	public SetTopBox searchSetTopBox(String setTopBoxID){
		SetTopBoxDAO stbDAO = new SetTopBoxDAO();
		return stbDAO.searchSetTopBox(setTopBoxID);
	
	}

	public int updateSetTopBox(SetTopBox stb) {
		SetTopBoxDAO setTopBoxDAO = new SetTopBoxDAO();
		return setTopBoxDAO.updateSetTopBox(stb);
	}

	public int deleteSetTopBox(int ID) {
		SetTopBoxDAO setTopBoxDAO = new SetTopBoxDAO();
		return setTopBoxDAO.deleteSetTopBox(ID);
	}
}
