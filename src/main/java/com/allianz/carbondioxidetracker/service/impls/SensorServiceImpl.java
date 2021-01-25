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

/**
 * This class contains various methods that are used to perform CRUD operation on Service entity such as addReading, retriveSensors,
 * getSensorById, saveSensor and search method
 * <p>This class contains repository, adaptors and builders.
 * The adaptors are used to convert the controller inputs to the entity classes. @see ReadingInputCommandAdaptor
 * This class uses repository classes to interact with H2 file-based database. @see SensorRepository
 * Builder pattern is used to generate custom response for Sensor insertion operation. @see ReadingInputResult
 * @version v1
 * @since 1.0
 */
@Service
class SensorServiceImpl implements SensorService {
	/**
	 * This Repository class is used to interact with Sensor entity. @see Sensor
	 */
	private SensorRepository sensorRepository;
	/**
	 * This Adaptor class is used to convert the controller input object to Reading entity object.
	 */
	private ReadingInputCommandAdaptor readingInputCommandAdaptor;
	/**
	 * This Adaptor class is used to convert the Sensor entity collection to sensorResponse collection.
	 */
	private SensorGetResponseAdaptor sensorGetResponseAdaptor;
	/**
	 * This method takes command object as an input
	 * and converts it to Reading entity object for further empty validation.
	 * First it check the given sensorId whether it exists in database, it would
	 * @throws IValidationException if it does not present in database.
	 * then it adds the reading to the sensor object to persist in the database.
	 * Builder pattern is used to build the response.
	 */
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

	/**
	 * This method is used to retrieve all sensor information
	 */
	@Override
	public List<Sensor> retrieveSensors() {
		return sensorRepository.findAll();
	}

	/**
	 * This method is used to retrieve sensor object which matches the passed sensorId
	 */
	@Override
	public Sensor getSensorById(String sensorId) {

		Optional<Sensor> optSensor = sensorRepository.findById(sensorId);
		return optSensor.orElse(null);
	}

	/**
	 * This method is used to persist Sensor object in the database
	 */
	@Override
	public void saveSensor(Sensor sensor) {
		sensorRepository.save(sensor);
		
	}

	public List<Sensor> getSensorReadingsByCity(String city) {
		return sensorRepository.findSensorByCity(city);
		
	}

	public List<Sensor> getSensorReadingsByDistrict(String district) {
		return sensorRepository.findSensorByDistrict(district);
	}

	/**
	 * This method handles multiple query operations based on the optional query parameters.
	 * It checks for district value and then executes findByDistrict method, if city is passed then it executes findByCity method.
	 * if both city and district values are not provided, it fetches all sensor values to user.
	 */
	@Override
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
	
	/**
	 * @param sensorRepository
	 * Setter based auto wiring is used
	 */
	@Autowired
	void setSensorRepository(SensorRepository sensorRepository) {
		this.sensorRepository = sensorRepository;
	}

	/**
	 * @param adaptor
	 * Setter based auto wiring is used
	 */
	@Autowired
	void setReadingInputCommandAdaptor(ReadingInputCommandAdaptor adaptor) {
		this.readingInputCommandAdaptor = adaptor;
	}
	
	/**
	 * @param sensorGetResponseAdaptor
	 * Setter based auto wiring is used
	 */
	@Autowired
	public void setSensorGetResponseAdaptor(SensorGetResponseAdaptor sensorGetResponseAdaptor) {
		this.sensorGetResponseAdaptor = sensorGetResponseAdaptor;
	}
}
