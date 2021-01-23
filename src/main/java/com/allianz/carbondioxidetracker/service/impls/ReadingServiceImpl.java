package com.allianz.carbondioxidetracker.service.impls;

import com.allianz.carbondioxidetracker.common.ErrorCode;
import com.allianz.carbondioxidetracker.common.ErrorMessage;
import com.allianz.carbondioxidetracker.common.IEmptyValidation;
import com.allianz.carbondioxidetracker.common.IValidationException;
import com.allianz.carbondioxidetracker.entity.Reading;
import com.allianz.carbondioxidetracker.repository.ReadingRepository;
import com.allianz.carbondioxidetracker.service.ReadingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ReadingServiceImpl implements ReadingService {
	
	private ReadingRepository readingRepository;

	@Override
	public Reading addReading(Reading reading) {

		if (IEmptyValidation.isEmpty(reading)) {
			throw IValidationException.of(ErrorCode.NULL_REQUEST, ErrorMessage.NULL_REQUEST.getValue()) ;
		}



		return readingRepository.save(reading) ;
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


	@Autowired
	void setReadingRepository(ReadingRepository repository) {
		this.readingRepository = repository;
	}


}
