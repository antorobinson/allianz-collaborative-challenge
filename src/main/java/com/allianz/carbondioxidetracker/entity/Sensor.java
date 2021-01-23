package com.allianz.carbondioxidetracker.entity;


import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="SENSOR")
public class Sensor {
	
	@Id
	@Column(name="SENSOR_ID")
	private String sensorId;
	
	@Column(name="CITY")
	private String city;
	
	@Column(name="DISTRICT")
	private String district;
	
	@OneToMany(cascade=CascadeType.ALL)
	private List<Reading> sensorReadings;
	

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

	public List<Reading> getSensorReadings() {
		return sensorReadings;
	}

	public void setSensorReadings(List<Reading> sensorReadings) {
		this.sensorReadings = sensorReadings;
	}
	
	

}