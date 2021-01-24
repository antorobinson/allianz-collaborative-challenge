package com.allianz.carbondioxidetracker.service.impls;

import com.allianz.carbondioxidetracker.common.ErrorCode;
import com.allianz.carbondioxidetracker.common.ErrorMessage;
import com.allianz.carbondioxidetracker.common.IEmptyValidation;
import com.allianz.carbondioxidetracker.common.IValidationException;
import com.allianz.carbondioxidetracker.controller.ReadingGetRequest;
import com.allianz.carbondioxidetracker.entity.Reading;
import com.allianz.carbondioxidetracker.entity.Sensor;
import com.allianz.carbondioxidetracker.repository.SensorRepository;
import com.allianz.carbondioxidetracker.service.ReadingInputCommand;
import com.allianz.carbondioxidetracker.service.ReadingInputResult;
import com.allianz.carbondioxidetracker.service.SensorGetResponse;
import com.allianz.carbondioxidetracker.service.SensorService;
import com.allianz.carbondioxidetracker.service.adaptors.ReadingInputCommandAdaptor;
import com.allianz.carbondioxidetracker.service.adaptors.SensorGetResponseAdaptor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
class SensorServiceImpl implements SensorService {
	
	private SensorRepository sensorRepository;
	
	private ReadingInputCommandAdaptor readingInputCommandAdaptor;
	
	private SensorGetResponseAdaptor sensorGetResponseAdaptor;
	
	@Override
	public ReadingInputResult addReading(ReadingInputCommand command) {

		final Reading reading = readingInputCommandAdaptor.adopt(command) ;

		if (IEmptyValidation.isEmpty(reading))
			throw IValidationException.of(ErrorCode.NULL_COMMAND, ErrorMessage.NULL_COMMAND.getValue()) ;

		final Optional<Sensor> sensorWrapper = sensorRepository.findById(command.getSensorId()) ;

		if (!sensorWrapper.isPresent())
			throw IValidationException.of(ErrorCode.SENSOR_NOT_FOUND, ErrorMessage.SENSOR_NOT_FOUND.getValue()) ;

		Sensor sensor = sensorWrapper.get() ;
		sensor.getSensorReadings().add(reading);
		sensor = sensorRepository.save(sensor) ;

		return ReadingInputResult.builder()
				.setReadingId(sensor.getSensorReadings().get(sensor.getSensorReadings().size() - 1).getId())
				.setSensorId(command.getSensorId())
				.setDate(reading.getTime())
				.setReadingValue(reading.getReadingValue())
				.build() ;
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


	public List<Sensor> getSensorReadingsByCity(String city) {
		List<Sensor> sensorReadings = sensorRepository.findSensorByCity(city);
		return sensorReadings;
		
	}


	public List<Sensor> getSensorReadingsByDistrict(String district) {
		List<Sensor> sensorReadings = sensorRepository.findSensorByDistrict(district);
		return sensorReadings;
	}


	public List<SensorGetResponse> search(ReadingGetRequest readingGetRequest){
		
		List<Sensor> readingList = null;
		
		String city=null;
		String district=null;
		
		if(readingGetRequest.getCity() !=null ){
			city=readingGetRequest.getCity().get();
		}
		if(readingGetRequest.getDistrict() !=null){
			district=readingGetRequest.getDistrict().get();
		}
		if(district != null){
				readingList=sensorRepository.findSensorByDistrict(district);
		}
		else if(city!=null){
				readingList=sensorRepository.findSensorByCity(city);
		}
		else
			readingList=retrieveSensors();
		
		List<SensorGetResponse> sensorReadingList = sensorGetResponseAdaptor.adopt(readingList);
		
		return sensorReadingList;
	}
	
	@Autowired
	void setSensorRepository(SensorRepository sensorRepository) {
		this.sensorRepository = sensorRepository;
	}

	@Autowired
	void setReadingInputCommandAdaptor(ReadingInputCommandAdaptor adaptor) {
		this.readingInputCommandAdaptor = adaptor;
	}
	
	@Autowired
	public void setSensorGetResponseAdaptor(SensorGetResponseAdaptor sensorGetResponseAdaptor) {
		this.sensorGetResponseAdaptor = sensorGetResponseAdaptor;
	}




}
