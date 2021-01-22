package com.allianz.carbondioxidetracker.service;

import java.util.List;

import com.allianz.carbondioxidetracker.entity.Sensor;

public interface SensorService {

	 public List<Sensor> retrieveSensors();
	  
	 public Sensor getSensor(String sensorId);
	  
	 public void saveSensor(Sensor sensor);
}
