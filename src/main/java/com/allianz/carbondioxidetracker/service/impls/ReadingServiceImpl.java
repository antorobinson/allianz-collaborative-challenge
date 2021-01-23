package com.allianz.carbondioxidetracker.service.impls;

import com.allianz.carbondioxidetracker.common.ErrorCode;
import com.allianz.carbondioxidetracker.common.ErrorMessage;
import com.allianz.carbondioxidetracker.common.IEmptyValidation;
import com.allianz.carbondioxidetracker.common.IValidationException;
import com.allianz.carbondioxidetracker.entity.Reading;
import com.allianz.carbondioxidetracker.repository.ReadingRepository;
import com.allianz.carbondioxidetracker.service.ReadingInputCommand;
import com.allianz.carbondioxidetracker.service.ReadingInputResult;
import com.allianz.carbondioxidetracker.service.ReadingService;
import com.allianz.carbondioxidetracker.service.adaptors.ReadingInputCommandAdaptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
class ReadingServiceImpl implements ReadingService {
	
	private ReadingRepository readingRepository;

	private ReadingInputCommandAdaptor readingInputCommandAdaptor;


	@Override
	public ReadingInputResult addReading(ReadingInputCommand command) {

		Reading reading = readingInputCommandAdaptor.adopt(command) ;

		if (IEmptyValidation.isEmpty(reading)) {
			throw IValidationException.of(ErrorCode.NULL_COMMAND, ErrorMessage.NULL_COMMAND.getValue()) ;
		}

		reading = readingRepository.save(reading) ;

		return ReadingInputResult.builder()
				.setId(reading.getId())
				.setDate(reading.getTime())
				.setReadingValue(reading.getReadingValue())
				.build() ;
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

	@Autowired
	void setReadingInputCommandAdaptor(ReadingInputCommandAdaptor adaptor) {
		this.readingInputCommandAdaptor = adaptor;
	}
}
