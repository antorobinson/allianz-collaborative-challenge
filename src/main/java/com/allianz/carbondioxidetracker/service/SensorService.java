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
package com.allianz.carbondioxidetracker.service;

import com.allianz.carbondioxidetracker.controller.ReadingGetRequest;
import com.allianz.carbondioxidetracker.entity.Sensor;

import java.text.ParseException;
import java.util.List;

/**
 * This service class is used to expose relevant CRUD operation on Sensor entity. @see SensorServiceImpl
 *
 */
public interface SensorService {
	
	  ReadingInputResult addReading(ReadingInputCommand command);

	  List<Sensor> retrieveSensors();
	  
	  Sensor getSensorById(String sensorId);
	  
	  void saveSensor(Sensor sensor);
	 
	  List<SensorGetResponse> search(ReadingGetRequest readingGetRequest) throws ParseException;
	 
}
