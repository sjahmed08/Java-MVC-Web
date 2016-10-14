package com.tcs.ilp.infinity.service;

import com.tcs.ilp.infinity.dao.ChannelDAO;
import com.tcs.ilp.infinity.model.Channel;

public class ChannelService {
	public int createChannel(Channel channel){
		ChannelDAO channelDAO = new ChannelDAO();
		return channelDAO.createChannel(channel);
	}
	
	public Channel searchChannel(String name){
		ChannelDAO channelDAO = new ChannelDAO();
		return channelDAO.searchChannel(name);
	}
	
	public int updateChannel(Channel channel){
		ChannelDAO channelDAO = new ChannelDAO();
		return channelDAO.updateChannel(channel);
	}
	
	public int deleteChannel(int channelID){
		ChannelDAO channelDAO = new ChannelDAO();
		return channelDAO.deleteChannel(channelID);
	}
}
