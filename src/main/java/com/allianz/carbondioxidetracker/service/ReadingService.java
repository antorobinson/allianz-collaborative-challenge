package com.allianz.carbondioxidetracker.service;

import com.allianz.carbondioxidetracker.entity.Reading;

import java.util.List;

public interface ReadingService {

	ReadingInputResult addReading(ReadingInputCommand command) ;

	List<Reading> retrieveReadings();
	  
	Reading getReading(Long readingId);
}
