package com.tcs.ilp.infinity.model;

public class Video {
	private int videoID;
	private String videoName, videoCategory, videoDuration, videoFrequency,
	videoStartTime, videoEndTime, videoCost, preview;
	
	public Video(){};
	
	
	public int getVideoID() {
		return videoID;
	}
	public void setVideoID(int videoID) {
		this.videoID = videoID;
	}
	public String getVideoName() {
		return videoName;
	}
	public void setVideoName(String videoName) {
		this.videoName = videoName;
	}
	public String getVideoCategory() {
		return videoCategory;
	}
	public void setVideoCategory(String videoCategory) {
		this.videoCategory = videoCategory;
	}
	public String getVideoDuration() {
		return videoDuration;
	}
	public void setVideoDuration(String videoDuration) {
		this.videoDuration = videoDuration;
	}
	public String getVideoFrequency() {
		return videoFrequency;
	}
	public void setVideoFrequency(String videoFrequency) {
		this.videoFrequency = videoFrequency;
	}
	public String getVideoStartTime() {
		return videoStartTime;
	}
	public void setVideoStartTime(String videoStartTime) {
		this.videoStartTime = videoStartTime;
	}
	public String getVideoEndTime() {
		return videoEndTime;
	}
	public void setVideoEndTime(String videoEndTime) {
		this.videoEndTime = videoEndTime;
	}
	public String getVideoCost() {
		return videoCost;
	}
	public void setVideoCost(String videoCost) {
		this.videoCost = videoCost;
	}
	public String getPreview() {
		return preview;
	}
	public void setPreview(String preview) {
		this.preview = preview;
	}
}
