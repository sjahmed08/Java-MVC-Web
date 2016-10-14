package com.tcs.ilp.infinity.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.tcs.ilp.infinity.model.Operator;
import com.tcs.ilp.infinity.model.User;
import com.tcs.ilp.infinity.util.DBUtil;
import com.tcs.ilp.infinity.util.OperatorUtil;

public class OperatorDAO {
	public int createOperator(Operator operator) {
		Connection conn = DBUtil.getDBConnection();
		PreparedStatement createOperatorPS = null;
		int opId = 0;
		
		//Creating DB query to create an Operator record
		String createOperatorQuery = "INSERT INTO A_A_A_OPERATOR (OPERATOR_ID, FIRST_NAME, LAST_NAME, EMAIL_ID, PHONE_NUMBER, MAX_NO_CUSTOMERS, CREATION_DATE, SHIFT_TIME_START, SHIFT_TIME_END) " +
									"values(?,?,?,?,?,?, CURRENT_TIMESTAMP,?,?)";
		try {
			User user = new User();
			user.setUserName(operator.getEmailID());
			user.setPassword(operator.getPassword());
			user.setRole("Operator");
			opId = com.tcs.ilp.infinity.dao.LoginDAO.createUser(user);
			
			//Tying the "?" from above to an actual value
			createOperatorPS = conn.prepareStatement(createOperatorQuery);
			createOperatorPS.setInt(1, opId);
			createOperatorPS.setString(2, operator.getFirstName());
			createOperatorPS.setString(3, operator.getLastName());
			createOperatorPS.setString(4, operator.getEmailID());
			createOperatorPS.setString(5, operator.getPhoneNumber());
			createOperatorPS.setInt(6, Integer.valueOf(operator.getMaxNoCustomers())); 
			createOperatorPS.setString(7, operator.getShiftTimeStart()); 
			createOperatorPS.setString(8, OperatorUtil.addEightHours(operator.getShiftTimeStart())); 
			createOperatorPS.execute(); //run the query //we assume the query doesn't fail
			
		} catch (SQLException e){
			System.out.println("Exeception occured while performing create customer operation.");
			e.printStackTrace();
		} finally {
			DBUtil.closeStatement(createOperatorPS);
			DBUtil.closeConnection(conn);
		}
		return opId;
	}
	
	public Operator searchOperator(String emailID){
		Connection conn = DBUtil.getDBConnection();
		PreparedStatement searchOperatorPS = null;
		ResultSet rs = null;
		Operator operator = new Operator();
	
		String searchOperatorQuery = "SELECT * FROM A_A_A_OPERATOR WHERE EMAIL_ID = ?";
		try {
	
			searchOperatorPS = conn.prepareStatement(searchOperatorQuery);
			searchOperatorPS.setString(1, emailID);
			rs = searchOperatorPS.executeQuery();
			
			if(rs.next()){
				operator.setOperatorID(rs.getInt("OPERATOR_ID"));
				operator.setFirstName(rs.getString("FIRST_NAME"));
				operator.setLastName(rs.getString("LAST_NAME"));
				operator.setEmailID(rs.getString("EMAIL_ID"));
				operator.setPhoneNumber(rs.getString("PHONE_NUMBER"));
				operator.setMaxNoCustomers(String.valueOf(rs.getInt("MAX_NO_CUSTOMERS")));
				operator.setCreationDate(rs.getString("CREATION_DATE"));
				operator.setShiftTimeStart(rs.getString("SHIFT_TIME_START"));
				operator.setShiftTimeEnd(rs.getString("SHIFT_TIME_END"));
				System.out.println("RETURNING OPERATOR");
			}
		} catch (SQLException e){
			System.out.println("Exeception occured while performing search customer operation.");
			e.printStackTrace();
			return null;
		} finally {
			DBUtil.closeResultSet(rs);
			DBUtil.closeStatement(searchOperatorPS);
			DBUtil.closeConnection(conn);
		}
		return operator;
	}
	
	public int updateOperator(Operator o){
		Connection conn = DBUtil.getDBConnection();
		PreparedStatement ps = null;
		ResultSet rs = null;
		String updateOperatorQuery = "UPDATE A_A_A_OPERATOR SET " +
				"first_Name=?, last_Name=?, email_ID=?, phone_Number=?, MAX_NO_CUSTOMERS=?," +
				"SHIFT_TIME_START=?, SHIFT_TIME_END=?  WHERE operator_ID = ?";
		try {

			System.out.println("PHONE NUMBER IS:" + o.getPhoneNumber());
			ps = conn.prepareStatement(updateOperatorQuery);
			ps.setString(1, o.getFirstName());
			ps.setString(2, o.getLastName());
			ps.setString(3, o.getEmailID());
			System.out.println("PHONE NUMBER IS:" + o.getPhoneNumber());
			ps.setString(4, o.getPhoneNumber());
			ps.setString(5, o.getMaxNoCustomers());
			//ps.setString(6, o.getCreationDate());
			ps.setString(6, o.getShiftTimeStart());
			ps.setString(7, o.getShiftTimeEnd());
			ps.setInt(8, o.getOperatorID());
			System.out.println("Command Executed: " + ps.toString());
			rs = ps.executeQuery();
			return 1;
		}

		catch (SQLException e){
			System.out.println("Exeception occured while performing update Operator operation.");
			e.printStackTrace();
		} finally {
			DBUtil.closeResultSet(rs);
			DBUtil.closeStatement(ps);
			DBUtil.closeConnection(conn);
		}
		return -1;
	}
	
	public int deleteOperator(int operatorID){
		Connection dbConnection = DBUtil.getDBConnection();
		PreparedStatement preparedStatement = null;

		String deleteSQL = "DELETE A_A_A_OPERATOR WHERE OPERATOR_ID = ?";
		try {
			preparedStatement = dbConnection.prepareStatement(deleteSQL);
			preparedStatement.setInt(1, operatorID);
			System.out.println("Command Executed: " + preparedStatement.toString());
			preparedStatement.execute();
			
		} catch (SQLException e) {
			System.out.println("Exeception occured while performing delete Operator operation.");
			e.printStackTrace();
			return -1;
		} finally {
			DBUtil.closeStatement(preparedStatement);
			DBUtil.closeConnection(dbConnection);
		}
		return 1;
	}
}
