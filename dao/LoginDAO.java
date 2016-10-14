package com.tcs.ilp.infinity.dao;

import java.sql.*;

import com.tcs.ilp.infinity.model.User;
import com.tcs.ilp.infinity.util.DBUtil;

public class LoginDAO {
	    public User validateUserLogin (String username, String password){
			Connection conn = DBUtil.getDBConnection();
			PreparedStatement login = null;
			ResultSet rs = null;
			User user = null;

	        String QUERY = "SELECT * FROM A_A_A_USERS WHERE USERNAME = ? AND PASSWORD = ? ";
	        try {
	        	login = conn.prepareStatement(QUERY);
	        	login.setString(1, username);
	        	login.setString(2, password);
	        	
	        	rs = login.executeQuery();
	        	if(rs.next()){
					user = new User(rs.getInt("USER_ID"), rs.getString("USERNAME"), rs.getString("PASSWORD"), rs.getString("ROLE"));
				}

	        }   catch (SQLException e){
	            e.printStackTrace();
	        }   finally {
				DBUtil.closeResultSet(rs);
				DBUtil.closeStatement(login);
				DBUtil.closeConnection(conn);
	        }
	        return user;
	    }

		public static int createUser(User user) throws SQLException{
			Connection conn = DBUtil.getDBConnection();
			PreparedStatement ps = null;
			PreparedStatement seqPS = null;
			ResultSet rs = null;
			int ID = 0;
			
			//Creating DB query to create an Operator record
			String createUserQuery = "INSERT INTO A_A_A_USERS (USER_ID, USERNAME, PASSWORD, ROLE) " +
										"values(A_A_A_USER_SEQ.nextval,?,?,?)";
			try {
				//Tying the "?" from above to an actual value
				ps = conn.prepareStatement(createUserQuery);
				ps.setString(1, user.getUserName());
				ps.setString(2, user.getPassword());
				ps.setString(3, user.getRole());
				ps.execute(); //run the query //we assume the query doesn't fail
				
				seqPS = conn.prepareStatement("SELECT A_A_A_USER_SEQ.CurrVal as ID from DUAL");
				rs = seqPS.executeQuery();

				if(rs.next()){
					ID = rs.getInt("ID");
				}
				
			} catch (SQLException e){
				throw new SQLException();
			} finally {
				
				DBUtil.closeConnection(conn);
				DBUtil.closeStatement(ps);
				DBUtil.closeStatement(seqPS);
				DBUtil.closeResultSet(rs);
			}
			return ID;
		}
	}

