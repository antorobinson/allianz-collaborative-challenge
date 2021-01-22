package com.allianz.carbondioxidetracker.service;

import java.util.List;

import com.allianz.carbondioxidetracker.entity.Reading;

public interface ReadingService {

	 public List<Reading> retrieveReadings();
	  
	 public Reading getReading(Long readingId);
	  
	 public void saveReading(Reading reading);
}
