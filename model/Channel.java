package com.tcs.ilp.infinity.model;

public class Channel {
	private int channelID;


	private String channelName, channelBand, videoCarrierFreq, audioCarrierFreq, 
	channelChargeType, channelTransmissionType, channelCharge;

	public Channel(){};
			
	public Channel(String channelName, String channelBand, String videoCarrierFreq, String audioCarrierFreq, String channelChargeType, String channelTransmissionType, String channelCharge){
		this.channelName = channelName;
		this.channelBand = channelBand;
		this.videoCarrierFreq = videoCarrierFreq;
		this.audioCarrierFreq = audioCarrierFreq;
		this.channelChargeType = channelChargeType;
		this.channelTransmissionType = channelTransmissionType;
		this.channelCharge = channelCharge;
	}
	
	
	public int getChannelID() {
		return channelID;
	}

	public void setChannelID(int channelID) {
		this.channelID = channelID;
	}
	
	public String getChannelName() {
		return channelName;
	}

	public void setChannelName(String channelName) {
		this.channelName = channelName;
	}

	public String getChannelBand() {
		return channelBand;
	}

	public void setChannelBand(String channelBand) {
		this.channelBand = channelBand;
	}

	public String getVideoCarrierFreq() {
		return videoCarrierFreq;
	}

	public void setVideoCarrierFreq(String videoCarrierFreq) {
		this.videoCarrierFreq = videoCarrierFreq;
	}

	public String getAudioCarrierFreq() {
		return audioCarrierFreq;
	}

	public void setAudioCarrierFreq(String audioCarrierFreq) {
		this.audioCarrierFreq = audioCarrierFreq;
	}

	public String getChannelChargeType() {
		return channelChargeType;
	}

	public void setChannelChargeType(String channelChargeType) {
		this.channelChargeType = channelChargeType;
	}

	public String getChannelTransmissionType() {
		return channelTransmissionType;
	}

	public void setChannelTransmissionType(String channelTransmissionType) {
		this.channelTransmissionType = channelTransmissionType;
	}

	public String getChannelCharge() {
		return channelCharge;
	}

	public void setChannelCharge(String channelCharge) {
		this.channelCharge = channelCharge;
	}	
}
