package com.allianz.carbondioxidetracker.entity;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="READING")
public class Reading {
	
	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	private Long id;
	
	@Column(name="READING")
	private Float reading;
		
	@Column(name="TIME")
	private Date time;
	
	@ManyToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="SENSOR_ID")
	private Sensor sensor;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Float getReading() {
		return reading;
	}

	public void setReading(Float reading) {
		this.reading = reading;
	}


	public Date getTime() {
		return time;
	}

	public void setTime(Date time) {
		this.time = time;
	}
	
}
