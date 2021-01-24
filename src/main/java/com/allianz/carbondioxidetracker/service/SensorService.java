package com.allianz.carbondioxidetracker.service;

import com.allianz.carbondioxidetracker.entity.Sensor;

import java.util.List;

public interface SensorService {
	
	 public ReadingInputResult addReading(ReadingInputCommand command);

	 public List<Sensor> retrieveSensors();
	  
	 public Sensor getSensorById(String sensorId);
	  
	 public void saveSensor(Sensor sensor);
	 
	 public List<Sensor> getSensorReadingsByCity(String city);
	 
	 public List<Sensor> getSensorReadingsByDistrict(String district);
}
