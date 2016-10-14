package com.tcs.ilp.infinity.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.tcs.ilp.infinity.model.SetTopBoxType;
import com.tcs.ilp.infinity.util.DBUtil;

public class SetTopBoxTypeDAO {
	public int createSetTopBoxType(SetTopBoxType stbType) {
		Connection conn = DBUtil.getDBConnection();
		PreparedStatement createSetTopBoxTypePS = null;
		PreparedStatement seqPS = null;
		ResultSet rs = null;
		int setTopBoxTypeID = 0;
		
		//Creating DB query to create an Channel record
		String createChannelQuery = "INSERT INTO A_A_A_SET_TOP_BOX_TYPE(SET_TOP_BOX_ID, SET_TOP_BOX_TYPE,  FEATURES, DIMENSIONS_LENGTH, DIMENSIONS_BREADTH, DIMENSIONS_WIDTH, PRICE, INSTALLATION_CHARGE, UPGRADE_CHARGE, DISCOUNT, BILLING_TYPE, REFUNDABLE_DEPOSIT_AMOUNT) " +
									"values(A_A_A_SET_TOP_BOX_TYPE_SEQ.nextval,?,?,?,?,?,?,?,?,?,?,?)";
		try {
			System.out.println("query kinda donez0");
			//Tying the "?" from above to an actual value
			createSetTopBoxTypePS = conn.prepareStatement(createChannelQuery);
			createSetTopBoxTypePS.setString(1, stbType.getType());
			createSetTopBoxTypePS.setString(2, stbType.getFeatures());
			createSetTopBoxTypePS.setDouble(3, Double.valueOf(stbType.getLength()));
			createSetTopBoxTypePS.setDouble(4, Double.valueOf(stbType.getBreadth()));
			createSetTopBoxTypePS.setDouble(5, Double.valueOf(stbType.getWidth()));
			System.out.println("query sorta kinda donez0");
			createSetTopBoxTypePS.setDouble(6, Double.valueOf(stbType.getPrice()));
			createSetTopBoxTypePS.setDouble(7, Double.valueOf(stbType.getInstallCharges()));
			createSetTopBoxTypePS.setDouble(8, Double.valueOf(stbType.getUpgradationCharges()));
			createSetTopBoxTypePS.setDouble(9, Double.valueOf(stbType.getDiscount()));
			createSetTopBoxTypePS.setDouble(10, Double.valueOf(stbType.getBillingType()));
			createSetTopBoxTypePS.setDouble(11, Double.valueOf(stbType.getRefund()));
			createSetTopBoxTypePS.execute(); //run the query //we assume the query doecreateSetTopBoxTypePS.setDouble(8, Double.valueOf(stbType.getDiscount()));sn't fail
			System.out.println("query donez0");
			//retrieving the primary key of the record we just created.
			seqPS = conn.prepareStatement("SELECT A_A_A_SET_TOP_BOX_TYPE_SEQ.CurrVal as ID from DUAL");
			rs =seqPS.executeQuery();
			if(rs.next()){
				setTopBoxTypeID = rs.getInt("ID");
			}
		} catch (SQLException e){
			System.out.println("Exeception occured while performing create channel operation.");
			e.printStackTrace();
		} finally {
			DBUtil.closeResultSet(rs);
			DBUtil.closeStatement(createSetTopBoxTypePS);
			DBUtil.closeStatement(seqPS);
			DBUtil.closeConnection(conn);
		}
		return setTopBoxTypeID;
	}

	public SetTopBoxType searchSetTopBoxType(int iD) {
		// TODO Auto-generated method stub
		return null;
	}

}
