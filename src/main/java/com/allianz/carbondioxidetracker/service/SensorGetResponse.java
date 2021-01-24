package com.allianz.carbondioxidetracker.service;

import java.util.ArrayList;
import java.util.List;


public class SensorGetResponse {

	private String sensorId;

	private String city;

	private String district;
	
	private List<ReadingGetResponse> sensorReadings = new ArrayList<>();

	public String getSensorId() {
		return sensorId;
	}

	public void setSensorId(String sensorId) {
		this.sensorId = sensorId;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getDistrict() {
		return district;
	}

	public void setDistrict(String district) {
		this.district = district;
	}

	public List<ReadingGetResponse> getSensorReadings() {
		return sensorReadings;
	}

	public void setSensorReadings(List<ReadingGetResponse> sensorReadings) {
		this.sensorReadings = sensorReadings;
	}
	
	
}
