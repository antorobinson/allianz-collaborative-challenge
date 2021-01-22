package com.allianz.carbondioxidetracker.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.allianz.carbondioxidetracker.entity.Reading;
import com.allianz.carbondioxidetracker.repository.ReadingRepository;
import com.allianz.carbondioxidetracker.service.ReadingService;

@Service
public class ReadingServiceImpl implements ReadingService{
	
	private ReadingRepository readingRepository;
	
	@Autowired
	public void setReadingRepository(ReadingRepository readingRepository) {
		this.readingRepository = readingRepository;
	}

	@Override
	public List<Reading> retrieveReadings() {
		List<Reading> readingsList = readingRepository.findAll();
		return readingsList;
	}

	@Override
	public Reading getReading(Long readingId) {
		Optional<Reading> optReading = readingRepository.findById(readingId);
		return optReading.get();
	}

	@Override
	public void saveReading(Reading reading) {
		readingRepository.save(reading);
		
	}
	

}
