package com.tcs.ilp.infinity.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.tcs.ilp.infinity.model.Distributor;
import com.tcs.ilp.infinity.model.SetTopBox;
import com.tcs.ilp.infinity.util.DBUtil;

public class DistributorDAO {
	public int createDistributor(Distributor distributor)
	{
		Connection conn = DBUtil.getDBConnection();
		PreparedStatement createDistributorPS = null;
		PreparedStatement seqPS = null;
		ResultSet rs = null;
		int distributorId = 0;
		
		String createDistributorQuery = "INSERT INTO A_A_A_DISTRIBUTOR (DISTRIBUTOR_ID, DISTRIBUTOR_NAME, CONTACT_NUMBER1, CONTACT_NUMBER2, ADDRESS1, ADDRESS2, CITY, PIN_CODE, ZONE, SET_TOP_BOX_LIMIT, CREDIT_LIMIT) " +
				"values(A_A_A_DISTRIBUTOR_SEQ.nextval,?,?,?,?,?,?,?,?,?,?)";
		try {
			createDistributorPS = conn.prepareStatement(createDistributorQuery);
			createDistributorPS.setString(1, distributor.getDistributorName());
			createDistributorPS.setString(2, distributor.getContact1());
			createDistributorPS.setString(3, distributor.getContact2());
			createDistributorPS.setString(4, distributor.getAddress1());
			createDistributorPS.setString(5, distributor.getAddress2());
			createDistributorPS.setString(6, distributor.getCity());
			createDistributorPS.setString(7, distributor.getPinCode());
			createDistributorPS.setString(8, distributor.getZone());
			createDistributorPS.setString(9, distributor.getSetTopBoxLimit());
			createDistributorPS.setString(10, distributor.getCreditLimit());
			createDistributorPS.execute();
			seqPS = conn.prepareStatement("SELECT A_A_A_DISTRIBUTOR_SEQ.CurrVal as ID from DUAL");
			rs = seqPS.executeQuery();
			if (rs.next()){
				distributorId = rs.getInt("ID");
			}
		}
		catch(SQLException e)
		{
			System.out.println("Exception occured while performing create distributor");
			e.printStackTrace();
		}
		finally {
			DBUtil.closeResultSet(rs);
			DBUtil.closeStatement(createDistributorPS);
			DBUtil.closeStatement(seqPS);
			DBUtil.closeConnection(conn);
		}		
		return distributorId;		
	}
	
	public Distributor searchDistributor(String DistributorID){
		Connection conn = DBUtil.getDBConnection();
		PreparedStatement searchDistributorPS = null;
		ResultSet rs = null;
		
		Distributor dst = new Distributor();
		
		String searchDistributorQuery = "SELECT * FROM A_A_A_DISTRIBUTOR WHERE DISTRIBUTOR_ID = " + DistributorID;
		System.out.println(DistributorID + "This is the ID we want");
		
		try {
			
			searchDistributorPS = conn.prepareStatement(searchDistributorQuery);
			rs = searchDistributorPS.executeQuery();
			
			if(rs.next()){
				dst.setDistributorID(rs.getInt("DISTRIBUTOR_ID"));
				dst.setDistributorName(rs.getString("DISTRIBUTOR_NAME"));
				dst.setContact1(rs.getString("CONTACT_NUMBER1"));
				dst.setContact2(rs.getString("CONTACT_NUMBER2"));
				dst.setAddress1(rs.getString("ADDRESS1"));
				dst.setAddress2(rs.getString("ADDRESS2"));
				dst.setCity(rs.getString("CITY"));
				dst.setPinCode(rs.getString("PIN_CODE"));
				dst.setZone(rs.getString("ZONE"));
				dst.setSetTopBoxLimit(rs.getString("SET_TOP_BOX_LIMIT"));
				dst.setCreditLimit(rs.getString("CREDIT_LIMIT"));
			}
			//ends if
			} catch (SQLException e){
				System.out.println("Exeception occured while performing create STB operation.");
				e.printStackTrace();
			} finally {
				DBUtil.closeResultSet(rs);
				DBUtil.closeStatement(searchDistributorPS);
				DBUtil.closeConnection(conn);
			}//ends finally
				
			return dst;
	}
	
	
	public int updateDistributor(Distributor distributor) {
		Connection conn = DBUtil.getDBConnection();
		PreparedStatement createDistributorPS = null;
		PreparedStatement seqPS = null;
		ResultSet rs = null;
		
		String updateDistributorQuery = "UPDATE A_A_A_DISTRIBUTOR SET " +
				"DISTRIBUTOR_NAME=?, CONTACT_NUMBER1=?, CONTACT_NUMBER2=?," +
				 "ADDRESS1=?, ADDRESS2=?, CITY=?, PIN_CODE=?, ZONE=?, SET_TOP_BOX_LIMIT=?, CREDIT_LIMIT=? WHERE DISTRIBUTOR_ID = ?";
		
		try {
			//Tying the "?" from above to an actual value
			
			createDistributorPS = conn.prepareStatement(updateDistributorQuery);			
			createDistributorPS.setString(1, distributor.getDistributorName());
			createDistributorPS.setString(2, distributor.getContact1());
			createDistributorPS.setString(3, distributor.getContact2());
			createDistributorPS.setString(4, distributor.getAddress1());
			createDistributorPS.setString(5, distributor.getAddress2());
			createDistributorPS.setString(6, distributor.getCity());
			createDistributorPS.setString(7, distributor.getPinCode());
			createDistributorPS.setString(8, distributor.getZone());
			createDistributorPS.setInt(9, Integer.parseInt(distributor.getSetTopBoxLimit()));	
			createDistributorPS.setInt(10, Integer.parseInt(distributor.getCreditLimit()));	
			createDistributorPS.setInt(11, distributor.getDistributorID());	
			System.out.println(distributor.getDistributorID());
			createDistributorPS.execute(); //run the query //we assume the query doecreateSetTopBoxPS.setDouble(8, Double.valueOf(stb.getDiscount()));sn't fail
			
		} catch (SQLException e){
			System.out.println("Exeception occured while performing update Distributor.");
			e.printStackTrace();
			return -1;
		} finally {
			DBUtil.closeResultSet(rs);
			DBUtil.closeStatement(createDistributorPS);
			DBUtil.closeStatement(seqPS);
			DBUtil.closeConnection(conn);
		}
		return 1;
	}
		
	public int deleteDistributor(int ID) {
		Connection conn = DBUtil.getDBConnection();
		PreparedStatement ps = null;
		
		String deleteSetDistributor = "DELETE FROM A_A_A_DISTRIBUTOR WHERE DISTRIBUTOR_ID=?"; 
		
		try 
		{
			ps = conn.prepareStatement(deleteSetDistributor);
			
			ps.setInt(1, ID);

			ps.execute(); 
		}
		catch(SQLException e)
		{
			System.out.println("Exeception occured while performing delete Distributor operation.");
			e.printStackTrace();
			return -1;			
		}
		finally
		{
			DBUtil.closeStatement(ps);
			DBUtil.closeConnection(conn);
		}		
		return 1;
	}
	
	
	
	
		
		
		
		
		
	}
