package com.tcs.ilp.infinity.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DBUtil {

	public static Connection getDBConnection() {
		Connection con = null;
		try {
			String driver = "oracle.jdbc.driver.OracleDriver";
			String dbURL = "jdbc:oracle:thin:@192.168.1.158:1521:xe";
			String dbUserName = "System";
			String dbPassword = "password@1234";
			
			Class.forName(driver);
			con = DriverManager.getConnection(dbURL, dbUserName, dbPassword);
			
		} catch(ClassNotFoundException e) {
			// TODO Error Log
			e.printStackTrace();
		} catch(SQLException e) {
			// TODO Error Log
			e.printStackTrace();
		}
		return con;
	}
	
	public static void closeResultSet(ResultSet rs) {
		if( rs != null ){
			try {
				rs.close();
			} catch (SQLException e) {
				// TODO Error Log
				e.printStackTrace();
			}
		}		
	}

	public static void closeStatement(PreparedStatement ps) {
		if(ps != null){
			try {
				ps.close();
			} catch (SQLException e) {
				// TODO Error Log
				e.printStackTrace();
			}
		}		
	}

	public static void closeConnection(Connection conn) {
		if(conn != null){
			try {
				conn.close();
			} catch (SQLException e) {
				// TODO Error Log
				e.printStackTrace();
			}
		}		
	}
}
