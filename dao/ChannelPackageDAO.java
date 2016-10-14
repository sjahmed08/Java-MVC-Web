package com.tcs.ilp.infinity.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.tcs.ilp.infinity.model.ChannelPackage;
import com.tcs.ilp.infinity.model.Customer;
import com.tcs.ilp.infinity.util.DBUtil;

public class ChannelPackageDAO {
	public int createChannelPackage(ChannelPackage channelPackage) {
		Connection conn = DBUtil.getDBConnection();
		PreparedStatement createChannelPackagePS = null;
		PreparedStatement seqPS = null;
		ResultSet rs = null;
		int packageId = 0;
		
		//Creating DB query to create an Operator record
		String createChannelPackageQuery = "INSERT INTO A_A_A_CHANNEL_PACKAGE (PACKAGE_ID, PACKAGE_NAME, PACKAGE_CATEGORY, PACKAGE_CHARGING_TYPE, PACKAGE_TRANSMISSION_TYPE, PACKAGE_COST, PACKAGE_AVAILABLE_FROM, ADDED_BY_DEFAULT, PACKAGE_AVAILABLE_TO) " +
									"values(A_A_A_CHANNEL_PACKAGE_SEQ.nextval,?,?,?,?,?,?,?,?)";
		try {
			//Tying the "?" from above to an actual value
			createChannelPackagePS = conn.prepareStatement(createChannelPackageQuery);
			createChannelPackagePS.setString(1, channelPackage.getPackageName());
			createChannelPackagePS.setString(2, channelPackage.getPackageCategory());
			createChannelPackagePS.setString(3, channelPackage.getPackageChargingType());
			createChannelPackagePS.setString(4, channelPackage.getPackageTransmissionType());
			createChannelPackagePS.setInt(5, Integer.parseInt(channelPackage.getPackageCost()));
			createChannelPackagePS.setDate(6, java.sql.Date.valueOf(channelPackage.getPackageAvailStart())); 
			createChannelPackagePS.setString(7, channelPackage.getAddedByDefault());
			createChannelPackagePS.setDate(8, java.sql.Date.valueOf(channelPackage.getPackageAvailEnd())); 
			
			createChannelPackagePS.execute(); //run the query //we assume the query doesn't fail

			//retrieving the primary key of the record we just created.
			seqPS = conn.prepareStatement("SELECT A_A_A_CHANNEL_PACKAGE_SEQ.CurrVal as ID from DUAL");
			rs =seqPS.executeQuery();
			
			if(rs.next()){
				packageId = rs.getInt("ID");
			}
		} catch (SQLException e){
			System.out.println("Exeception occured while performing create channel package operation.");
			e.printStackTrace();
		} finally {
			DBUtil.closeResultSet(rs);
			DBUtil.closeStatement(createChannelPackagePS);
			DBUtil.closeStatement(seqPS);
			DBUtil.closeConnection(conn);
		}
		return packageId;
	}
	
	
	public ChannelPackage searchChannelPackage(int channelPackageId){
		Connection conn = DBUtil.getDBConnection();
		PreparedStatement ps = null;
		ResultSet rs = null;
		String searchChannelPackageQuery = "SELECT * FROM A_A_A_CHANNEL_PACKAGE WHERE PACKAGE_ID = ?";
		
		try {
			ps = conn.prepareStatement(searchChannelPackageQuery);
			ps.setInt(1, channelPackageId);
			
			rs = ps.executeQuery();
			System.out.println("Command Executed: " + ps.toString());
			ChannelPackage c = new ChannelPackage();

			if(rs.next()){
				
				c.setChannelPackageID((rs.getString("PACKAGE_ID")));
				c.setPackageName((rs.getString("PACKAGE_NAME")));
				c.setPackageCategory(rs.getString("PACKAGE_CATEGORY"));
				c.setPackageChargingType(rs.getString("PACKAGE_CHARGING_TYPE"));
				c.setPackageTransmissionType(rs.getString("PACKAGE_TRANSMISSION_TYPE"));
				c.setPackageCost(rs.getString("PACKAGE_COST"));
				c.setPackageAvailStart(rs.getString("PACKAGE_AVAILABLE_FROM"));
				c.setPackageAvailEnd(rs.getString("PACKAGE_AVAILABLE_TO"));
				c.setAddedByDefault(rs.getString("ADDED_BY_DEFAULT"));
				return c;
			}

		} catch (SQLException e){
			System.out.println("Exeception occured while performing search channel package operation.");
			e.printStackTrace();
		} finally {
			DBUtil.closeResultSet(rs);
			DBUtil.closeStatement(ps);
			DBUtil.closeConnection(conn);
		}
		return null;
	}
	
	public int updateChannelPackage(ChannelPackage c){
		Connection conn = DBUtil.getDBConnection();
		PreparedStatement ps = null;
		ResultSet rs = null;
		System.out.println("ChannelPackage ID IS:" + c.getChannelPackageID());
		String updateChannelPackageQuery = "UPDATE A_A_A_CHANNEL_PACKAGE SET " +
				"PACKAGE_NAME=?, " +
				"PACKAGE_CATEGORY=?, " +
				"PACKAGE_CHARGING_TYPE=?, " +
				"PACKAGE_TRANSMISSION_TYPE=?, " +
				"PACKAGE_COST=?," +
				"PACKAGE_AVAILABLE_FROM=?, " +
				"PACKAGE_AVAILABLE_TO=?, " +
				"ADDED_BY_DEFAULT=? " +
				"WHERE PACKAGE_ID = ?";
		try {

			ps = conn.prepareStatement(updateChannelPackageQuery);
			
			ps.setString(1, c.getPackageName());
			ps.setString(2, c.getPackageCategory());
			ps.setString(3, c.getPackageChargingType());
			ps.setString(4, c.getPackageTransmissionType());
			ps.setString(5, c.getPackageCost());
			ps.setDate(6, java.sql.Date.valueOf(c.getPackageAvailStart()));
			ps.setDate(7, java.sql.Date.valueOf(c.getPackageAvailEnd()));
			ps.setString(8, c.getAddedByDefault());
			ps.setInt(9, Integer.parseInt(c.getChannelPackageID()));
			System.out.println("Command Executed: " + ps.toString());
			rs = ps.executeQuery();
		}

		catch (SQLException e){
			System.out.println("Exeception occured while performing search customer operation.");
			e.printStackTrace();
			return -1;
		} finally {
			DBUtil.closeResultSet(rs);
			DBUtil.closeStatement(ps);
			DBUtil.closeConnection(conn);
		}
		return 1;

	}
	
	public int deleteChannelPackage(String channelPackageId){
		Connection dbConnection = DBUtil.getDBConnection();
		PreparedStatement preparedStatement = null;

		String deleteSQL = "DELETE A_A_A_CHANNEL_PACKAGE WHERE PACKAGE_ID = ?";
		try {
			preparedStatement = dbConnection.prepareStatement(deleteSQL);
			preparedStatement.setInt(1, Integer.parseInt(channelPackageId));
			System.out.println("Command Executed: " + preparedStatement.toString());
			preparedStatement.execute();

		} catch (SQLException e) {

			System.out.println(e);
			return -1;

		} finally {

			DBUtil.closeStatement(preparedStatement);
			DBUtil.closeConnection(dbConnection);

		}

		return 1;
	}
}
