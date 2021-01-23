package com.allianz.carbondioxidetracker.controller;

import com.allianz.carbondioxidetracker.boundary.adaptors.AddReadingRequestAdaptor;
import com.allianz.carbondioxidetracker.common.*;
import com.allianz.carbondioxidetracker.entity.Reading;
import com.allianz.carbondioxidetracker.entity.Sensor;
import com.allianz.carbondioxidetracker.service.ReadingService;
import com.allianz.carbondioxidetracker.service.impls.SensorServiceImpl;
import com.allianz.carbondioxidetracker.util.CurrentTimeCalendar;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/v1/co2")
public class CarbonDioxideDataController {
	

	private SensorServiceImpl sensorService;

	private AddReadingRequestAdaptor addReadingRequestAdaptor;

	private ReadingService readingService;


	@PostMapping
	public IResponse<Reading> addReading(@RequestBody CarbonReadingInputRequest request) {

		if (IEmptyValidation.isEmpty(request))
			throw IValidationException.of(ErrorCode.NULL_REQUEST, ErrorMessage.NULL_REQUEST.getValue()) ;

		request.validateSelf() ;

		final Reading reading = addReadingRequestAdaptor.adopt(request) ;

		final Reading savedReading = readingService.addReading(reading) ;

		return IResponseBuilder.builder(savedReading)
				.setStatus(HttpStatus.OK)
				.build() ;
	}

	@GetMapping
	public ResponseEntity<Sensor> getReadingPerCity(){
		
		Date currentTime = CurrentTimeCalendar.getCurrentTimeUsingCalendar();
		Reading reading = new Reading(Float.valueOf(420),currentTime);
		
		Sensor sensor = sensorService.getSensorById("TK01");
		
		sensor.getSensorReadings().add(reading);
		
		sensorService.saveSensor(sensor);
		
//		sensor.getSensorReadings().add(reading);
//		
//		sensorService.saveSensor(sensor);
		
		return ResponseEntity.ok().body(sensor);

	}

	@Autowired
	void setAddCarbonReadingRequestAdaptor(AddReadingRequestAdaptor adaptor) {
		this.addReadingRequestAdaptor = adaptor;
	}

	@Autowired
	void setReadingService(ReadingService service) {
		this.readingService = service;
	}
	
	@Autowired
	public void setSensorService(SensorServiceImpl sensorService) {
		this.sensorService = sensorService;
	}
}
