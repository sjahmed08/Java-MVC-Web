package com.tcs.ilp.infinity.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.tcs.ilp.infinity.model.SetTopBox;
import com.tcs.ilp.infinity.util.DBUtil;

public class SetTopBoxDAO {

	public int createSetTopBox(SetTopBox stb) {
		Connection conn = DBUtil.getDBConnection();
		PreparedStatement createSetTopBoxTPS = null;
		PreparedStatement seqPS = null;
		ResultSet rs = null;
		int setTopBoxID = 0;
		
		//Creating DB query to create a STB record
		String createSetTopBoxQuery = "INSERT INTO A_A_A_SET_TOP_BOX(SET_TOP_BOX_SERIAL_NO, SET_TOP_BOX_TYPE, SET_TOP_BOX_MAC_ID, REMOTE_CONTROL_ASSET_ID, DISH_ASSET_ID, SET_TOP_BOX_STATUS) " +
									"values(A_A_A_SET_TOP_BOX_SEQ.nextval,?,?,?,?, 'Unassigned')";
		try {
			//Tying the "?" from above to an actual value
			createSetTopBoxTPS = conn.prepareStatement(createSetTopBoxQuery);
		
			createSetTopBoxTPS.setString(1, stb.getType());
			createSetTopBoxTPS.setDouble(2, Double.valueOf(stb.getMacID()));
			createSetTopBoxTPS.setDouble(3, Double.valueOf(stb.getRemoteID()));
			createSetTopBoxTPS.setDouble(4, Double.valueOf(stb.getDishId()));
			
			createSetTopBoxTPS.execute(); //run the query //we assume the query doecreateSetTopBoxPS.setDouble(8, Double.valueOf(stb.getDiscount()));sn't fail
			
			//retrieving the primary key of the record we just created.
			seqPS = conn.prepareStatement("SELECT A_A_A_SET_TOP_BOX_SEQ.CurrVal as ID from DUAL");
			rs =seqPS.executeQuery();
			if(rs.next()){
				setTopBoxID = rs.getInt("ID");
			}
		} catch (SQLException e){
			System.out.println("Exeception occured while performing create SetTopBox operation.");
			e.printStackTrace();
		} finally {
			DBUtil.closeResultSet(rs);
			DBUtil.closeStatement(createSetTopBoxTPS);
			DBUtil.closeStatement(seqPS);
			DBUtil.closeConnection(conn);
		}
		return setTopBoxID;
	}//ends function

	public SetTopBox searchSetTopBox(String setTopBoxID){
		Connection conn = DBUtil.getDBConnection();
		PreparedStatement searchSetTopBoxPS = null;
		ResultSet rs = null;
		SetTopBox stb = new SetTopBox();
		
		String searchSetTopBoxQuery = "SELECT * FROM A_A_A_SET_TOP_BOX WHERE SET_TOP_BOX_SERIAL_NO = " + setTopBoxID;
		System.out.println(setTopBoxID + "This is the ID we want");
		try {
			
			searchSetTopBoxPS = conn.prepareStatement(searchSetTopBoxQuery);
			rs = searchSetTopBoxPS.executeQuery();
			
			if(rs.next()){
				stb.setSerial(rs.getInt("SET_TOP_BOX_SERIAL_NO"));
				stb.setType(rs.getString("SET_TOP_BOX_TYPE"));
				stb.setMacID(rs.getDouble("SET_TOP_BOX_MAC_ID"));
				stb.setRemoteID(rs.getDouble("REMOTE_CONTROL_ASSET_ID"));
				stb.setDishId(rs.getDouble("DISH_ASSET_ID"));
				stb.setStatus(rs.getString("DISH_ASSET_ID"));
			}//ends if
			} catch (SQLException e){
				System.out.println("Exeception occured while performing create STB operation.");
				e.printStackTrace();
			} finally {
				DBUtil.closeResultSet(rs);
				DBUtil.closeStatement(searchSetTopBoxPS);
				DBUtil.closeConnection(conn);
			}//ends finally
					System.out.println(stb.getType() + "This is from object");
			return stb;
}

	public int updateSetTopBox(SetTopBox stb) {
		Connection conn = DBUtil.getDBConnection();
		PreparedStatement ps = null;
		PreparedStatement seqPS = null;
		ResultSet rs = null;
		
		//Creating DB query to create a STB record
		String updateSetTopBoxQuery = "UPDATE A_A_A_SET_TOP_BOX SET " +
				"SET_TOP_BOX_TYPE=?, SET_TOP_BOX_MAC_ID=?, REMOTE_CONTROL_ASSET_ID=?, DISH_ASSET_ID=?" +
				 "WHERE SET_TOP_BOX_SERIAL_NO =?";
		try {
			//Tying the "?" from above to an actual value
			ps = conn.prepareStatement(updateSetTopBoxQuery);
		
			ps.setString(1, stb.getType());
			ps.setDouble(2, Double.valueOf(stb.getMacID()));
			ps.setDouble(3, Double.valueOf(stb.getRemoteID()));
			ps.setDouble(4, Double.valueOf(stb.getDishId()));
			ps.setDouble(5, Double.valueOf(stb.getSerial()));
			ps.execute(); //run the query //we assume the query doecreateSetTopBoxPS.setDouble(8, Double.valueOf(stb.getDiscount()));sn't fail
			
		} catch (SQLException e){
			System.out.println("Exeception occured while performing create SetTopBox operation.");
			e.printStackTrace();
			return -1;
		} finally {
			DBUtil.closeResultSet(rs);
			DBUtil.closeStatement(ps);
			DBUtil.closeStatement(seqPS);
			DBUtil.closeConnection(conn);
		}
		return 1;
	}

	public int deleteSetTopBox(int ID) {
		Connection conn = DBUtil.getDBConnection();
		PreparedStatement ps = null;
		
		//Creating DB query to create a STB record
		String deleteSetTopBoxQuery = "DELETE FROM A_A_A_SET_TOP_BOX WHERE SET_TOP_BOX_SERIAL_NO=?"; 

		try {
			//Tying the "?" from above to an actual value
			ps = conn.prepareStatement(deleteSetTopBoxQuery);
		
			ps.setInt(1, ID);

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

	
	}