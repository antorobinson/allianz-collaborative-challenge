package com.allianz.carbondioxidetracker.service;

import com.allianz.carbondioxidetracker.entity.Reading;

import java.util.List;

public interface ReadingService {

	Reading addReading(Reading command) ;

	List<Reading> retrieveReadings();
	  
	Reading getReading(Long readingId);
}
