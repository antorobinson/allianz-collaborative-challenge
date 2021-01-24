package com.allianz.carbondioxidetracker.service.impls;

import com.allianz.carbondioxidetracker.common.ErrorCode;
import com.allianz.carbondioxidetracker.common.ErrorMessage;
import com.allianz.carbondioxidetracker.common.IEmptyValidation;
import com.allianz.carbondioxidetracker.common.IValidationException;
import com.allianz.carbondioxidetracker.entity.Reading;
import com.allianz.carbondioxidetracker.entity.Sensor;
import com.allianz.carbondioxidetracker.repository.SensorRepository;
import com.allianz.carbondioxidetracker.service.ReadingInputCommand;
import com.allianz.carbondioxidetracker.service.ReadingInputResult;
import com.allianz.carbondioxidetracker.service.SensorService;
import com.allianz.carbondioxidetracker.service.adaptors.ReadingInputCommandAdaptor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
class SensorServiceImpl implements SensorService {
	
	private SensorRepository sensorRepository;
	
	private ReadingInputCommandAdaptor readingInputCommandAdaptor;
	
	private SensorService sensorService;
	
	@Autowired
	public void setSensorService(SensorService sensorService) {
		this.sensorService = sensorService;
	}

	@Autowired
	public void setSensorRepository(SensorRepository sensorRepository) {
		this.sensorRepository = sensorRepository;
	}
		
	@Autowired
	public void setReadingInputCommandAdaptor(ReadingInputCommandAdaptor readingInputCommandAdaptor) {
		this.readingInputCommandAdaptor = readingInputCommandAdaptor;
	}

	@Override
	public Sensor addReading(ReadingInputCommand command) {
		Reading readingInput = readingInputCommandAdaptor.adopt(command) ;

		if (IEmptyValidation.isEmpty(readingInput)) {
			throw IValidationException.of(ErrorCode.NULL_COMMAND, ErrorMessage.NULL_COMMAND.getValue()) ;
		}
		
		Date currentTime = new Date();
		Reading reading = new Reading(readingInput.getReadingValue(),currentTime);
		
		//change to readingInput.getId() to String
		Sensor sensor = sensorService.getSensorById("TK01");
		sensor.getSensorReadings().add(reading);		
		sensorService.saveSensor(sensor);

		//create new response builder for sensor
		return sensor;
	}

	@Override
	public List<Sensor> retrieveSensors() {
		List<Sensor> sensorList = sensorRepository.findAll();
		return sensorList;
	}

	@Override
	public Sensor getSensorById(String sensorId) {
		Optional<Sensor> optSensor = sensorRepository.findById(sensorId);
		return optSensor.get();
	}

	@Override
	public void saveSensor(Sensor sensor) {
		sensorRepository.save(sensor);
		
	}

	@Override
	public List<Sensor> getSensorReadingsByCity(String city) {
		List<Sensor> sensorReadings = sensorRepository.findSensorByCity(city);
		return sensorReadings;
		
	}

	@Override
	public List<Sensor> getSensorReadingsByDistrict(String district) {
		List<Sensor> sensorReadings = sensorRepository.findSensorByDistrict(district);
		return sensorReadings;
	}


	

}
