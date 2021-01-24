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
 */

package com.allianz.carbondioxidetracker.controller;

import com.allianz.carbondioxidetracker.common.ErrorCode;
import com.allianz.carbondioxidetracker.common.ErrorMessage;
import com.allianz.carbondioxidetracker.common.IEmptyValidation;
import com.allianz.carbondioxidetracker.common.IResponse;
import com.allianz.carbondioxidetracker.common.IResponseBuilder;
import com.allianz.carbondioxidetracker.common.IValidationException;
import com.allianz.carbondioxidetracker.controller.adaptors.ReadingInputRequestAdaptor;
import com.allianz.carbondioxidetracker.entity.Reading;
import com.allianz.carbondioxidetracker.entity.Sensor;
import com.allianz.carbondioxidetracker.repository.SensorRepository;
import com.allianz.carbondioxidetracker.service.ReadingInputCommand;
import com.allianz.carbondioxidetracker.service.ReadingInputResult;
import com.allianz.carbondioxidetracker.service.ReadingService;
import com.allianz.carbondioxidetracker.service.SensorService;
import com.allianz.carbondioxidetracker.util.CurrentTimeCalendar;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Optional;

/**
 * This class contains various methods for serving HTTP requests (such as
 * addReading, getReadingPerCity).
 * This class is responsible for receiving all the requests comes from the end point of <b>"/v1/co2"</b>.
 *<p>
 * This class contains adaptors, Services and Builders.
 * The Adaptors are converts the HTTP requests to acceptable Command or Query for the Service inputs.
 * The Services are the access point interfaces of business layer. Through Service interfaces this class
 * interact with business layer .
 * The methods in this class will throw a {@code IValidationException}, {@code IServiceRuntimeException} or
 * {@code NullPointerException} .
 * This class is annotated with @RestController. To know more about RestController
 * see the {@link RestController} and {@link Autowired} {@link PostMapping} {@link GetMapping}
 * {@link RequestBody} {@link RequestMapping} {@link RestController}
 * To see the Adaptor interfaces in this class are
 * @see ReadingInputRequestAdaptor
 * @see ReadingInputRequestAdaptor#adopt(Object)
 * To see the Service interfaces in this class are
 * @see ReadingService
 * @see SensorService
 * @see ReadingService#addReading
 * @see SensorService
 *<p>
 * @author Team Player-1
 * @author Team Player-2
 * @author Team Player-3
 * @author Team Player-4
 * @version v1
 * @since 1.0
 */

@RestController
@RequestMapping("/v1/co2")
public class CarbonDioxideDataController {

	/**
	 *
	 */
	private ReadingService readingService;

	/**
	 *
	 */
	private SensorService sensorService;

	/**
	 *
	 *
	 */
	private ReadingInputRequestAdaptor readingInputRequestAdaptor;

	/**
	 * api end end point methode to post values
	 * <p>
	 *     receives ReadingInputRequest as a request and return IResponse<ReadingInputResult> as response
	 *     To know more about ReadingInputRequest, see the {@link ReadingInputRequest)} class.
	 *     To know more about IResponse, see the {@link IResponse)} class.
	 *
	 * </p>
	 *
	 * @param request the input RequestBody of carbon values received from HTTP Post request.
	 *
	 *    If you want to see the
	 * values of request
	 * @see ReadingInputRequest
	 *
	 * @return IResponse<ReadingInputResult> to know more about IResponse
	 * @see IResponse and to know more about ReadingInputResult
	 * @see ReadingInputResult .
	 */

	@PostMapping
	public IResponse<ReadingInputResult> addReading(@RequestBody ReadingInputRequest request) {

		if (IEmptyValidation.isEmpty(request))
			throw IValidationException.of(ErrorCode.NULL_REQUEST, ErrorMessage.NULL_REQUEST.getValue()) ;

		request.validateSelf() ;

		final ReadingInputCommand command = readingInputRequestAdaptor.adopt(request) ;
		//Use Sensor service, already created draft in Sensor Service
		final ReadingInputResult result = readingService.addReading(command) ;

		return IResponseBuilder.builder(result)
				.setStatus(HttpStatus.OK)
				.build() ;
	}


	@GetMapping("/readings/")
	public ResponseEntity<List<Sensor>> getReadingPerCity(
			@PathVariable (value = "city") String city,
			@RequestParam ("fromDate") Optional<String> fromDate,
			@RequestParam ("toDate") Optional<String> toDate
			) throws ParseException{
		
		Date fromD=null;
		Date toD=null;

		if(fromDate.isPresent()){
			fromD = new SimpleDateFormat("dd-MM-yyyy").parse(fromDate.get());
		}
		if(toDate.isPresent()){
			toD = new SimpleDateFormat("dd-MM-yyyy").parse(toDate.get());
		}
		if(fromD!=null&&toD!=null)
			System.out.println(fromD+"  "+toD);
		
		List<Sensor> result = sensorService.getSensorReadingsByCity(city);
		
		return IResponseBuilder.builder(result)
				.setStatus(HttpStatus.OK)
				.build();
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
