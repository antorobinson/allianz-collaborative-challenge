package com.allianz.carbondioxidetracker.service;

import com.allianz.carbondioxidetracker.entity.Sensor;

import java.util.List;

public interface SensorService {

	 public List<Sensor> retrieveSensors();
	  
	 public Sensor getSensorById(String sensorId);
	  
	 public void saveSensor(Sensor sensor);
	 
	 public void getSensorReadingsByCity(String city);
	 
	 public void getSensorReadingsByDistrict(String district);
}
