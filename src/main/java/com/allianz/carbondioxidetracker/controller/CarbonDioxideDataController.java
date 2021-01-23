package com.allianz.carbondioxidetracker.controller;

import com.allianz.carbondioxidetracker.common.*;
import com.allianz.carbondioxidetracker.controller.adaptors.ReadingInputRequestAdaptor;
import com.allianz.carbondioxidetracker.entity.Reading;
import com.allianz.carbondioxidetracker.entity.Sensor;
import com.allianz.carbondioxidetracker.service.ReadingInputCommand;
import com.allianz.carbondioxidetracker.service.ReadingInputResult;
import com.allianz.carbondioxidetracker.service.ReadingService;
import com.allianz.carbondioxidetracker.service.SensorService;
import com.allianz.carbondioxidetracker.util.CurrentTimeCalendar;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Date;

@RestController
@RequestMapping("/v1/co2")
public class CarbonDioxideDataController {

	private ReadingService readingService;

	private SensorService sensorService;

	private ReadingInputRequestAdaptor readingInputRequestAdaptor;



	@PostMapping
	public IResponse<ReadingInputResult> addReading(@RequestBody ReadingInputRequest request) {

		if (IEmptyValidation.isEmpty(request))
			throw IValidationException.of(ErrorCode.NULL_REQUEST, ErrorMessage.NULL_REQUEST.getValue()) ;

		request.validateSelf() ;

		final ReadingInputCommand command = readingInputRequestAdaptor.adopt(request) ;
		final ReadingInputResult result = readingService.addReading(command) ;

		return IResponseBuilder.builder(result)
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
	void setReadingInputRequestAdaptor(ReadingInputRequestAdaptor adaptor) {
		this.readingInputRequestAdaptor = adaptor;
	}

	@Autowired
	void setReadingService(ReadingService service) {
		this.readingService = service;
	}
	
	@Autowired
	public void setSensorService(SensorService sensorService) {
		this.sensorService = sensorService;
	}
}
