package com.allianz.carbondioxidetracker.service;

import com.allianz.carbondioxidetracker.entity.Sensor;

import java.util.List;

public interface SensorService {

	 public List<Sensor> retrieveSensors();
	  
	 public Sensor getSensor(String sensorId);
	  
	 public void saveSensor(Sensor sensor);
}
