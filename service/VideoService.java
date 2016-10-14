package com.tcs.ilp.infinity.service;

import com.tcs.ilp.infinity.dao.VideoDAO;
import com.tcs.ilp.infinity.model.Video;

public class VideoService {

	public int createVideo(Video video) {
		
		VideoDAO videoDAO = new VideoDAO();
		return videoDAO.createVideo(video);
	}

	public Video searchVideo (String videoID){
		VideoDAO videoDAO = new VideoDAO();
		return videoDAO.searchVideo(videoID);	
	}
		public int updateVideo(Video video){
			VideoDAO videoDAO = new VideoDAO();
			return videoDAO.updateVideo(video);
	}

		public int deleteVideo(int videoID) {
			VideoDAO videoDAO = new VideoDAO();
			return videoDAO.deleteVideo(videoID);
			
		}
}
