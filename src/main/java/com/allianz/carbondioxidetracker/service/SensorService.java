package com.allianz.carbondioxidetracker.service;

import com.allianz.carbondioxidetracker.controller.ReadingGetRequest;
import com.allianz.carbondioxidetracker.entity.Sensor;

import java.text.ParseException;
import java.util.List;

public interface SensorService {
	
	  ReadingInputResult addReading(ReadingInputCommand command);

	  List<Sensor> retrieveSensors();
	  
	  Sensor getSensorById(String sensorId);
	  
	  void saveSensor(Sensor sensor);
	 
	  List<SensorGetResponse> search(ReadingGetRequest readingGetRequest) throws ParseException;
	 
}
