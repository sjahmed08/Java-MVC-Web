package com.tcs.ilp.infinity.service;

import com.tcs.ilp.infinity.dao.ChannelPackageDAO;
import com.tcs.ilp.infinity.model.ChannelPackage;

public class ChannelPackageService {
	public int createChannelPackage(ChannelPackage channelPackage){
		ChannelPackageDAO channelPackageDAO = new ChannelPackageDAO();
		return channelPackageDAO.createChannelPackage(channelPackage);
	}
	
	public int updateChannelPackage(ChannelPackage channelPackage){
		ChannelPackageDAO channelPackageDAO = new ChannelPackageDAO();
		return channelPackageDAO.updateChannelPackage(channelPackage);
	}
	
	public int deleteChannelPackage(String channelPackageID){
		ChannelPackageDAO channelPackageDAO = new ChannelPackageDAO();
		return channelPackageDAO.deleteChannelPackage(channelPackageID);
	}

	public ChannelPackage searchChannelPackage(int channelPackageId) {
		ChannelPackageDAO channelPackageDAO = new ChannelPackageDAO();
		return channelPackageDAO.searchChannelPackage(channelPackageId);
	}
}
