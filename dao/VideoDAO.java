
package com.tcs.ilp.infinity.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


import com.tcs.ilp.infinity.model.Video;
import com.tcs.ilp.infinity.model.Video;
import com.tcs.ilp.infinity.util.DBUtil;


public class VideoDAO {

	public int createVideo(Video video) {
		
			Connection conn = DBUtil.getDBConnection();
			PreparedStatement createVideoPS = null;
			PreparedStatement seqPS = null;
			ResultSet rs = null;
			int videoID = 0;
			
			//Creating DB query to create an Operator record
			String createVideoQuery = "INSERT INTO A_A_A_VIDEOS (VIDEO_ID, VIDEO_NAME, VIDEO_CATEGORY, VIDEO_DURATION, VIDEO_FREQUENCY, VIDEO_START_TIME, VIDEO_END_TIME, VIDEO_COST, VIDEO_PREVIEW) " +
										"values(A_A_A_VIDEOS_ON_DEMAND_SEQ.nextval,?,?,?,?,?,?,?,?)";
			try {
				//Tying the "?" from above to an actual value
				createVideoPS = conn.prepareStatement(createVideoQuery);
				createVideoPS.setString(1, video.getVideoName());
				createVideoPS.setString(2, video.getVideoCategory());
				createVideoPS.setInt(3, Integer.valueOf(video.getVideoDuration()));
				createVideoPS.setString(4, video.getVideoFrequency());
				createVideoPS.setString(5, video.getVideoStartTime()); 
				createVideoPS.setString(6, video.getVideoEndTime()); 
				createVideoPS.setInt(7, Integer.valueOf(video.getVideoCost())); 
				createVideoPS.setString(8, video.getPreview()); 
				createVideoPS.execute(); //run the query //we assume the query doesn't fail
		
				//retrieving the primary key of the record we just created.
				seqPS = conn.prepareStatement("SELECT A_A_A_VIDEOS_ON_DEMAND_SEQ.CurrVal as ID from DUAL");
				rs =seqPS.executeQuery();
				if(rs.next()){
					videoID = rs.getInt("ID");
				}
			} catch (SQLException e){
				System.out.println("Exeception occured while performing create Video operation.");
				e.printStackTrace();
			} finally {
				DBUtil.closeResultSet(rs);
				DBUtil.closeStatement(createVideoPS);
				DBUtil.closeStatement(seqPS);
				DBUtil.closeConnection(conn);
			}
			return videoID;
	}
	
	public Video searchVideo(String VideoID) {
		Connection conn = DBUtil.getDBConnection();
		PreparedStatement searchVideoPS = null;
		ResultSet rs = null;
		Video vid = new Video();
		String searchVideoQuery = "SELECT * FROM A_A_A_VIDEOS WHERE VIDEO_ID = " + VideoID;
		
			
		try {
			
			searchVideoPS = conn.prepareStatement(searchVideoQuery);
			rs = searchVideoPS.executeQuery();
			
			if(rs.next()){
				vid.setVideoID(rs.getInt("VIDEO_ID"));
				vid.setVideoName(rs.getString("VIDEO_NAME"));
				vid.setVideoCategory(rs.getString("VIDEO_CATEGORY"));
				vid.setVideoDuration(rs.getString("VIDEO_DURATION"));
				vid.setVideoFrequency(rs.getString("VIDEO_FREQUENCY"));
				vid.setVideoStartTime(rs.getString("VIDEO_START_TIME"));
				vid.setVideoEndTime(rs.getString("VIDEO_END_TIME"));
				vid.setVideoCost(rs.getString("VIDEO_COST"));
				vid.setPreview(rs.getString("VIDEO_PREVIEW"));		
			}
			
		}catch (SQLException e){
				System.out.println("Exeception occured while performing create Video operation.");
				e.printStackTrace();
			}finally {
				DBUtil.closeResultSet(rs);
				DBUtil.closeStatement(searchVideoPS);
				DBUtil.closeConnection(conn);
		
		}
		return vid;
	}
	
	public int updateVideo(Video v){
		Connection conn = DBUtil.getDBConnection();
		PreparedStatement ps = null;
		ResultSet rs = null;
		System.out.println("Video ID IS:" + v.getVideoID());
		String updateVideoQuery = "UPDATE A_A_A_Videos SET " +
				"VIDEO_NAME=?, VIDEO_CATEGORY=?, VIDEO_DURATION=?, VIDEO_FREQUENCY=?, VIDEO_START_TIME=?, VIDEO_END_TIME=?," +
				"VIDEO_COST=?, VIDEO_PREVIEW=?" + "WHERE VIDEO_ID ="  + v.getVideoID() ;
		try {


			ps = conn.prepareStatement(updateVideoQuery);
			//ps.setInt(1, v.getVideoID());
			ps.setString(1, v.getVideoName());			
			ps.setString(2, v.getVideoCategory());
			ps.setString(3, v.getVideoDuration());		
			ps.setString(4, v.getVideoFrequency());			
			ps.setString(5, v.getVideoStartTime());		
			ps.setString(6, v.getVideoEndTime());
			ps.setString(7, v.getVideoCost());
			ps.setString(8, v.getPreview());
			System.out.println("Command Executed: " + ps.toString());
			rs = ps.executeQuery();
			return 1;
		}

		catch (SQLException e){
			System.out.println("Exception occured while performing update Video operation.");
			e.printStackTrace();
		} finally {
			DBUtil.closeResultSet(rs);
			DBUtil.closeStatement(ps);
			DBUtil.closeConnection(conn);
		}
		return -1;

	}

	public int deleteVideo(int videoID) {
		
		Connection conn = DBUtil.getDBConnection();
		PreparedStatement ps = null;
		ResultSet rs = null;
		String deleteVideoQuery = "DELETE FROM A_A_A_VIDEOS WHERE VIDEO_ID=?";
		try {


			ps = conn.prepareStatement(deleteVideoQuery);
			ps.setInt(1,videoID);
			ps.execute();
			
		}
			/*//ps.setInt(1, v.getVideoID());
			ps.setString(1, v.getVideoName());			
			ps.setString(2, v.getVideoCategory());	
			ps.setString(3, v.getVideoDuration());
			ps.setString(4, v.getVideoFrequency());
			ps.setString(5, v.getVideoStartTime());
			ps.setString(6, v.getVideoEndTime());
			ps.setString(7, v.getVideoCost());
			ps.setString(8, v.getPreview());
			System.out.println("Command Executed: " + ps.toString());
			rs = ps.executeQuery();
			return 1;
		}
*/
		catch (SQLException e){
			System.out.println("Exception occured while performing delete Video operation.");
			e.printStackTrace();
			return -1;
			
		} finally {
			//DBUtil.closeResultSet(rs);
			DBUtil.closeStatement(ps);
			DBUtil.closeConnection(conn);
		}
		return 1;
	
		
	}

}

