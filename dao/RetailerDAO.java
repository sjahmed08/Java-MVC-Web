package com.tcs.ilp.infinity.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.tcs.ilp.infinity.model.Retailer;
import com.tcs.ilp.infinity.util.DBUtil;

public class RetailerDAO {
	
	public int createRetailer(Retailer retailer) {
		Connection conn = DBUtil.getDBConnection();
		PreparedStatement createRetailerPS = null;
		PreparedStatement seqPS = null;
		ResultSet rs = null;
		int retailId = 0;
		
		String createRetailerQuery = "INSERT INTO A_A_A_RETAILER (RETAIL_ID, RETAILER_NAME, CONTACT_NUMBER1, CONTACT_NUMBER2, ADDRESS1, ADDRESS2, CITY, STATE, PIN_CODE," +
		"SET_TOP_BOX_LIMIT, CREDIT_LIMIT, COMMISSION_PERCENTAGE, SERVICE_CHARGE) " +
				"values(A_A_A_RETAILER_SEQ.nextval,?,?,?,?,?,?,?,?,?,?,?,?)";
		try {
			createRetailerPS = conn.prepareStatement(createRetailerQuery);
			createRetailerPS.setString(1, retailer.getName());
			createRetailerPS.setString(2, retailer.getContactNo1());
			createRetailerPS.setString(3, retailer.getContactNo2());
			createRetailerPS.setString(4, retailer.getAddress1());
			createRetailerPS.setString(5, retailer.getAddress2());
			createRetailerPS.setString(6, retailer.getCity());
			createRetailerPS.setString(7, retailer.getState());
			createRetailerPS.setString(8, retailer.getPinCode());
			createRetailerPS.setInt(9, Integer.valueOf(retailer.getSetTopBoxLimit()));
			createRetailerPS.setInt(10, Integer.valueOf(retailer.getCreditLimit()));
			createRetailerPS.setInt(11, Integer.valueOf(retailer.getCommissionPercentage()));
			createRetailerPS.setInt(12, Integer.valueOf(retailer.getServiceCharge()));
			createRetailerPS.execute();
			
			seqPS = conn.prepareStatement("SELECT A_A_A_RETAILER_SEQ.CurrVal as ID from DUAL");
			rs = seqPS.executeQuery();
			if (rs.next())
			{
				retailId = rs.getInt("ID");
			}
		}
		catch(SQLException e){
			System.out.println("Exception occured while performing retailer operation");
			e.printStackTrace();
		}
		finally
		{
			DBUtil.closeResultSet(rs);
			DBUtil.closeStatement(createRetailerPS);
			DBUtil.closeStatement(seqPS);
			DBUtil.closeConnection(conn);
		}	
		return retailId;		
	}
	
	public Retailer searchRetailer(int ID){
		Connection conn = DBUtil.getDBConnection();
		PreparedStatement searchRetailerPS = null;
		ResultSet rs = null;
		Retailer retailer = new Retailer();
		
		String searchRetailerQuery = "SELECT * FROM A_A_A_RETAILER WHERE RETAIL_ID = ?";
		try {
	
			searchRetailerPS = conn.prepareStatement(searchRetailerQuery);
			searchRetailerPS.setInt(1, ID);
			rs = searchRetailerPS.executeQuery();
			
			if(rs.next()){
				retailer.setRetailerID(rs.getInt("RETAIL_ID"));
				retailer.setName(rs.getString("RETAILER_NAME"));
				retailer.setContactNo1(rs.getString("CONTACT_NUMBER1"));
				retailer.setContactNo2(rs.getString("CONTACT_NUMBER2"));
				retailer.setAddress1(rs.getString("ADDRESS1"));
				retailer.setAddress2(rs.getString("ADDRESS2"));
				retailer.setCity(rs.getString("CITY"));
				retailer.setState(rs.getString("STATE"));
				retailer.setPinCode(rs.getString("PIN_CODE"));
				retailer.setSetTopBoxLimit(String.valueOf(rs.getInt("SET_TOP_BOX_LIMIT")));
				retailer.setCreditLimit(String.valueOf(rs.getInt("CREDIT_LIMIT")));
				retailer.setCommissionPercentage(String.valueOf(rs.getInt("COMMISSION_PERCENTAGE")));
				retailer.setServiceCharge(String.valueOf(rs.getInt("SERVICE_CHARGE")));
				return retailer;
			}
		} catch (SQLException e){
			System.out.println("Exeception occured while performing create retailer operation.");
			e.printStackTrace();
		} finally {
			DBUtil.closeResultSet(rs);
			DBUtil.closeStatement(searchRetailerPS);
			DBUtil.closeConnection(conn);
		}
		return null;
	}
	
	public int updateRetailer(Retailer retailer){
		Connection conn = DBUtil.getDBConnection();
		PreparedStatement ps = null;
		ResultSet rs = null;
		System.out.println("Retailer ID IS:" + retailer.getRetailerID());
		String updateRetailerQuery = "UPDATE A_A_A_RETAILER SET " +
				"RETAILER_NAME=?, CONTACT_NUMBER1=?, CONTACT_NUMBER2=?, ADDRESS1=?, ADDRESS2=?," +
				"CITY=?, STATE=?, PIN_CODE=?, SET_TOP_BOX_LIMIT=?, CREDIT_LIMIT=?, COMMISSION_PERCENTAGE=?, SERVICE_CHARGE=? "  + "WHERE RETAIL_ID =?";
		try {

			ps = conn.prepareStatement(updateRetailerQuery);
			ps.setString(1, retailer.getName());
			ps.setString(2, retailer.getContactNo1());
			ps.setString(3, retailer.getContactNo2());
			ps.setString(4, retailer.getAddress1());
			ps.setString(5, retailer.getAddress2());
			ps.setString(6, retailer.getCity());
			ps.setString(7, retailer.getState());
			ps.setString(8, retailer.getPinCode());
			ps.setString(9, retailer.getSetTopBoxLimit());
			ps.setString(10, retailer.getCreditLimit());
			ps.setString(11, retailer.getCommissionPercentage());
			ps.setString(12, retailer.getServiceCharge());
			ps.setInt(13, retailer.getRetailerID());
			
			System.out.println("Command Executed: " + ps.toString());
			rs = ps.executeQuery();
			return 1;
		}

		catch (SQLException e){
			System.out.println("Exeception occured while performing search retailer operation.");
			e.printStackTrace();
		} finally {
			DBUtil.closeResultSet(rs);
			DBUtil.closeStatement(ps);
			DBUtil.closeConnection(conn);
		}
		return -1;
	}
	
	public int deleteRetailer(int retailerID){
		Connection dbConnection = DBUtil.getDBConnection();
		PreparedStatement preparedStatement = null;

		String deleteSQL = "DELETE A_A_A_RETAILER WHERE RETAIL_ID = ?";
		try {
			preparedStatement = dbConnection.prepareStatement(deleteSQL);
			preparedStatement.setInt(1, retailerID);
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
