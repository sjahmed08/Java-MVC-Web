package com.tcs.ilp.infinity.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.tcs.ilp.infinity.model.Customer;
import com.tcs.ilp.infinity.model.User;
import com.tcs.ilp.infinity.util.DBUtil;

public class CustomerDAO {
	public int createCustomer(Customer customer, String operatorName) {
		Connection conn = DBUtil.getDBConnection();
		PreparedStatement createCustomerPS = null;
		int custId = 0;
		
		String createCustomerQuery = "INSERT INTO A_A_A_CUSTOMER (CUSTOMER_ID, FIRST_NAME, LAST_NAME, EMAIL_ID, PHONE_NUMBER, ADDRESS1, ADDRESS2, LAND_MARK, PIN_CODE, CITY, STATE, CREATION_DATE, OPERATOR_NAME, RETAILER_NAME)" 
		+ "values(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, CURRENT_TIMESTAMP, ?, ?)"; 
		
		try {
			User user = new User();
			user.setUserName(customer.getEmailID());
			user.setPassword(customer.getPassword());
			user.setRole("Customer");
			custId = com.tcs.ilp.infinity.dao.LoginDAO.createUser(user);
			
			createCustomerPS = conn.prepareStatement(createCustomerQuery);
			createCustomerPS.setInt(1, custId);
			createCustomerPS.setString(2, customer.getFirstName());
			createCustomerPS.setString(3, customer.getLastName());
			createCustomerPS.setString(4, customer.getEmailID());
			createCustomerPS.setString(5, customer.getPhoneNumber());
			createCustomerPS.setString(6, customer.getAddress1());
			createCustomerPS.setString(7, customer.getAddress2());
			createCustomerPS.setString(8, customer.getLandMark());
			createCustomerPS.setString(9, customer.getPinCode());
			createCustomerPS.setString(10, customer.getCity());
			createCustomerPS.setString(11, customer.getState());
			createCustomerPS.setString(12, operatorName);
			createCustomerPS.setString(13, customer.getRetailerName());
			createCustomerPS.execute();
		
		}
		catch(SQLException e) {
			System.out.println("Exception occured while performing create customer operation.");
			e.printStackTrace();
		}
		finally {
			DBUtil.closeConnection(conn);
			DBUtil.closeStatement(createCustomerPS);
		}				
		
		return custId;		
	}
	
	public Customer searchCustomer(String emailID){
		Connection conn = DBUtil.getDBConnection();
		PreparedStatement ps = null;
		ResultSet rs = null;
		String searchCustomerQuery = "SELECT * FROM A_A_A_CUSTOMER WHERE EMAIL_ID = ?";
		
				
		try {
			ps = conn.prepareStatement(searchCustomerQuery);
			ps.setString(1, emailID);
			
			rs = ps.executeQuery();
			System.out.println("Command Executed: " + ps.toString());
			Customer c = new Customer();

			if(rs.next()){

				c.setCustomerID(Integer.parseInt(rs.getString("CUSTOMER_ID")));
				c.setFirstName((rs.getString("FIRST_NAME")));
				c.setLastName(rs.getString("LAST_NAME"));
				c.setEmailID(rs.getString("EMAIL_ID"));
				c.setPhoneNumber(rs.getString("PHONE_NUMBER"));
				c.setAddress1(rs.getString("ADDRESS1"));
				c.setAddress2(rs.getString("ADDRESS2"));
				c.setLandMark(rs.getString("LAND_MARK"));
				c.setPinCode(rs.getString("PIN_CODE"));
				c.setCity(rs.getString("CITY"));
				c.setState(rs.getString("State"));
				c.setOperatorName(rs.getString("OPERATOR_NAME"));
				return c;
			}

		} catch (SQLException e){
			System.out.println("Exeception occured while performing search customer operation.");
			e.printStackTrace();
		} finally {
			DBUtil.closeResultSet(rs);
			DBUtil.closeStatement(ps);
			DBUtil.closeConnection(conn);
		}
		return null;
	}

	public int updateCustomer(Customer c){
		Connection conn = DBUtil.getDBConnection();
		PreparedStatement ps = null;
		ResultSet rs = null;
		System.out.println("Customer ID IS:" + c.getCustomerID());
		String updateCustomerQuery = "UPDATE A_A_A_CUSTOMER SET " +
				"first_Name=?, last_Name=?, email_ID=?, phone_Number=?, address1=?, address2=?," +
				"land_Mark=?, Pin_Code=?, city=?, state=?" + "WHERE Customer_ID ="  + "'" + c.getCustomerID() + "'";
		try {


			ps = conn.prepareStatement(updateCustomerQuery);
			ps.setString(1, c.getFirstName());
			ps.setString(2, c.getLastName());
			ps.setString(3, c.getEmailID());
			ps.setString(4, c.getPhoneNumber());
			ps.setString(5, c.getAddress1());
			ps.setString(6, c.getAddress2());
			ps.setString(7, c.getLandMark());
			ps.setString(8, c.getPinCode());
			ps.setString(9, c.getCity());
			ps.setString(10, c.getState());
			System.out.println("Command Executed: " + ps.toString());
			rs = ps.executeQuery();
			return 1;
		}

		catch (SQLException e){
			System.out.println("Exeception occured while performing search customer operation.");
			e.printStackTrace();
		} finally {
			DBUtil.closeResultSet(rs);
			DBUtil.closeStatement(ps);
			DBUtil.closeConnection(conn);
		}
		return -1;

	}

	public int deleteCustomer(String emailID){
		Connection dbConnection = DBUtil.getDBConnection();
		PreparedStatement preparedStatement = null;

		String deleteSQL = "DELETE A_A_A_Customer WHERE EMAIL_ID = ?";
		try {
			preparedStatement = dbConnection.prepareStatement(deleteSQL);
			preparedStatement.setString(1, emailID);
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
