package com.tcs.ilp.infinity.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.tcs.ilp.infinity.model.Channel;
import com.tcs.ilp.infinity.util.DBUtil;

public class ChannelDAO {
	public int createChannel(Channel channel) {
		Connection conn = DBUtil.getDBConnection();
		PreparedStatement createChannelPS = null;
		PreparedStatement seqPS = null;
		
		ResultSet rs = null;
		int channelId = 0;
		
		//Creating DB query to create an Channel record
		String createChannelQuery = "INSERT INTO A_A_A_CHANNEL (CHANNEL_ID, CHANNEL_NAME, CHANNEL_BAND, VIDEO_CARRIER_FREQ, AUDIO_CARRIER_FREQ, CHANNEL_CHARGE_TYPE, CHANNEL_TRANSMISSION_TYPE, CHANNEL_CHARGE) " +
									"values(A_A_A_CHANNEL_SEQ.nextval,?,?,?,?,?,?,?)";
		
		try {
			//Tying the "?" from above to an actual value
			createChannelPS = conn.prepareStatement(createChannelQuery);
			createChannelPS.setString(1, channel.getChannelName());
			createChannelPS.setString(2, channel.getChannelBand());
			createChannelPS.setInt(3, Integer.valueOf(channel.getVideoCarrierFreq()));
			createChannelPS.setInt(4, Integer.valueOf(channel.getAudioCarrierFreq()));
			createChannelPS.setString(5, channel.getChannelChargeType()); 
			createChannelPS.setString(6, channel.getChannelTransmissionType()); 
			createChannelPS.setInt(7, Integer.valueOf(channel.getChannelCharge())); 
			createChannelPS.execute(); //run the query //we assume the query doesn't fail
			
			//retrieving the primary key of the record we just created.
			seqPS = conn.prepareStatement("SELECT A_A_A_CHANNEL_SEQ.CurrVal as ID from DUAL");
			rs =seqPS.executeQuery();
			if(rs.next()){
				channelId = rs.getInt("ID");
			}
		} catch (SQLException e){
			System.out.println("Exeception occured while performing create channel operation.");
			e.printStackTrace();
		} finally {
			DBUtil.closeResultSet(rs);
			DBUtil.closeStatement(createChannelPS);
			DBUtil.closeStatement(seqPS);
			DBUtil.closeConnection(conn);
		}
		return channelId;
	}
	
	
	
	public int updateChannel(Channel c){
		Connection conn = DBUtil.getDBConnection();
		PreparedStatement ps = null;
		ResultSet rs = null;
		System.out.println("Channel ID IS:" + c.getChannelID());
		String updateChannelQuery = "UPDATE A_A_A_CHANNEL SET " +
				"CHANNEL_NAME=?, CHANNEL_BAND=?, VIDEO_CARRIER_FREQ=?, AUDIO_CARRIER_FREQ=?, CHANNEL_CHARGE_TYPE=?," +
				"CHANNEL_TRANSMISSION_TYPE=?, CHANNEL_CHARGE=? " + "WHERE CHANNEL_ID =?";
		try {


			ps = conn.prepareStatement(updateChannelQuery);
			
			ps.setString(1, c.getChannelName());
			ps.setString(2, c.getChannelBand());
			ps.setInt(3, Integer.parseInt(c.getVideoCarrierFreq()));
			ps.setInt(4, Integer.parseInt(c.getAudioCarrierFreq()));
			ps.setString(5, c.getChannelChargeType());
			ps.setString(6, c.getChannelTransmissionType());
			ps.setInt(7, Integer.parseInt(c.getChannelCharge()));
			ps.setInt(8, c.getChannelID());
			System.out.println("Command Executed: " + ps.toString());
			rs = ps.executeQuery();
			return 1;
		}

		catch (SQLException e){
			System.out.println("Exeception occured while performing search Channel operation.");
			e.printStackTrace();
		} finally {
			DBUtil.closeResultSet(rs);
			DBUtil.closeStatement(ps);
			DBUtil.closeConnection(conn);
		}
		return -1;
	}
	
	public int deleteChannel(int channelID){
		Connection conn = DBUtil.getDBConnection();
		PreparedStatement ps = null;
		
		//Creating DB query to create a STB record
		String deleteChannelQuery = "DELETE FROM A_A_A_CHANNEL WHERE CHANNEL_ID=?"; 

		try {
			//Tying the "?" from above to an actual value
			ps = conn.prepareStatement(deleteChannelQuery);
		
			ps.setInt(1, channelID);

			ps.execute(); //run the query //we assume the query doecreateSetTopBoxPS.setDouble(8, Double.valueOf(stb.getDiscount()));sn't fail
			
		} catch (SQLException e){
			System.out.println("Exeception occured while performing delete SetTopBox operation.");
			e.printStackTrace();
			return -1;
		} finally {
			DBUtil.closeStatement(ps);
			DBUtil.closeConnection(conn);
		}
		return 1;
	}
	public Channel searchChannel(String channelName){
		Connection conn = DBUtil.getDBConnection();
		PreparedStatement ps = null;
		ResultSet rs = null;
		String searchChannelQuery = "SELECT * FROM A_A_A_CHANNEL WHERE CHANNEL_ID = ?";
		
				
		try {
			ps = conn.prepareStatement(searchChannelQuery);
			ps.setString(1, channelName);
			
			rs = ps.executeQuery();
			System.out.println("Command Executed: " + ps.toString());
			Channel c = new Channel();

			if(rs.next()){

				c.setChannelID(Integer.parseInt(rs.getString("CHANNEL_ID")));
				c.setChannelName((rs.getString("CHANNEL_NAME")));
				c.setChannelBand(rs.getString("CHANNEL_BAND"));
				c.setVideoCarrierFreq(rs.getString("VIDEO_CARRIER_FREQ"));
				c.setAudioCarrierFreq(rs.getString("AUDIO_CARRIER_FREQ"));
				c.setChannelChargeType(rs.getString("CHANNEL_CHARGE_TYPE"));
				c.setChannelTransmissionType(rs.getString("CHANNEL_TRANSMISSION_TYPE"));
				c.setChannelCharge(rs.getString("CHANNEL_CHARGE"));
				
				return c;
			}

		} catch (SQLException e){
			System.out.println("Exeception occured while performing search Channel operation.");
			e.printStackTrace();
			return null;
		} finally {
			DBUtil.closeResultSet(rs);
			DBUtil.closeStatement(ps);
			DBUtil.closeConnection(conn);
		}
		return null;
	}

}
