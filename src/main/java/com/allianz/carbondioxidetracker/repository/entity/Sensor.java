/*
 * This is only for an interview purpose in Allianz Technology,
 * This code is developed by 4 interview candidates.
 * This is written in free version Java 8 .
 * This is written in spring boot version 2.4.2 .
 * This is an open source .
 * This code meets most of the SOLID principles.
 * No Copyrights or no rights reserved .
 * Any one can use this code for their organization, personal or learning purposes.
 * ANY ONE CAN ALTER THIS CODE OR THIS FILE.
 * @author Team Player-1
 * @author Team Player-2
 * @author Team Player-3
 * @author Team Player-4
 */
package com.allianz.carbondioxidetracker.repository.entity;


import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.ArrayList;
import java.util.List;

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
	@JoinColumn(name = "FK_SENSOR_READING", referencedColumnName="SENSOR_ID")
	private List<Reading> sensorReadings = new ArrayList<>();
	
	public Sensor(){
		
	}

	/**
	 * @param sensorId
	 * @param city
	 * @param district
	 */
	public Sensor(String sensorId, String city, String district) {
		super();
		this.sensorId = sensorId;
		this.city = city;
		this.district = district;
	}

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
