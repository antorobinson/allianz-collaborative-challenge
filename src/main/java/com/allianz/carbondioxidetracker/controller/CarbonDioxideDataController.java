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

package com.allianz.carbondioxidetracker.controller;

import com.allianz.carbondioxidetracker.common.ErrorCode;
import com.allianz.carbondioxidetracker.common.ErrorMessage;
import com.allianz.carbondioxidetracker.common.IEmptyValidation;
import com.allianz.carbondioxidetracker.common.IResponse;
import com.allianz.carbondioxidetracker.common.IResponseBuilder;
import com.allianz.carbondioxidetracker.common.IResponseBuilder.ResponseBody;
import com.allianz.carbondioxidetracker.common.IValidationException;
import com.allianz.carbondioxidetracker.controller.adaptors.ReadingInputRequestAdaptor;
import com.allianz.carbondioxidetracker.service.ReadingInputCommand;
import com.allianz.carbondioxidetracker.service.ReadingInputResult;
import com.allianz.carbondioxidetracker.service.ReadingService;
import com.allianz.carbondioxidetracker.service.SensorGetResponse;
import com.allianz.carbondioxidetracker.service.SensorService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.text.ParseException;
import java.util.List;

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
@Slf4j
@RestController
@RequestMapping("/v1/co2")
public class CarbonDioxideDataController {
	/**
	 * sensorService interface is used to interact with UseCase in Service layer .
	 * To sse the available UseCases see {@link SensorService}
	 */
	private SensorService sensorService;
	/**
	 * This Adaptor interface is used to convert the ReadingInputRequest to ReadingInputCommand.
	 * To sse the available UseCases see {@link ReadingInputRequestAdaptor}
	 */
	private ReadingInputRequestAdaptor readingInputRequestAdaptor;
	/**
	 * This methode expose the api end point methode to post a Reading value .
	 * <p>
	 * <b> Execution steps </b>
	 * 1. receives the request
	 * 2. Convert request to command using readingInputRequestAdaptor
	 * 3. Validate the request, command using IEmptyValidation & request.validateSelf()
	 * 4. If Validate fails  throws IValidationException
	 * 5. Submits the command to sensorService.addReading and get the result
	 * 6. Submits the command to sensorService.addReading and get the result
	 * 7. Build IResponse<ResponseBody<ReadingInputResult>> from result using IResponseBuilder
	 * </p>
	 * @param request ReadingInputRequest the input RequestBody of carbon values received from HTTP Post request.
	 * To know the values of request
	 * @see ReadingInputRequest
	 * @return IResponse<ReadingInputResult> to know more about IResponse
	 * @see IResponse and to know more about ReadingInputResult
	 * @see IResponseBuilder and to know more about IResponseBuilder
	 * @see IResponseBuilder.Message and to know more about Message
	 * @see IResponseBuilder.ResponseBody and to know more about ResponseBody
	 * @see IResponseBuilder.Error and to know more about Error
	 * @see IEmptyValidation#isEmpty(Object) and to know more about IEmptyValidation
	 * @see ReadingInputRequest#validateSelf() and to know more about self validation
	 */
	@PostMapping
	public IResponse<ResponseBody<ReadingInputResult>> addReading(
			@RequestBody ReadingInputRequest request) {

		log.info("request received in CarbonDioxideDataController.addReading{}", request);
		final ReadingInputCommand command = readingInputRequestAdaptor.adopt(request) ;

		if (IEmptyValidation.isEmpty(command))
			throw IValidationException.of(ErrorCode.NULL_REQUEST, ErrorMessage.NULL_REQUEST.getValue()) ;

		request.validateSelf() ;

		final ReadingInputResult result = sensorService.addReading(command) ;

		log.info("result sent in CarbonDioxideDataController.addReading{}", result);

		return IResponseBuilder.builder(result)
				.setStatus(HttpStatus.OK)
				.build() ;
	}
	/**
	 * This methode expose the api end point methode to get Reading values .
	 * <p>
	 * <b> Execution steps </b>
	 * 1. receives the request
	 * 2. Submits the command to sensorService.addReading and get the result
	 * 3. Build IResponse<ResponseBody<ReadingInputResult>> from result using IResponseBuilder
	 * </p>
	 * @param readingGetRequest ReadingGetRequest the input of query values received from HTTP Get request.
	 * To know the values of request
	 * @see ReadingGetRequest
	 * @return IResponse<ResponseBody<List<SensorGetResponse>>> to know more about IResponse
	 * @see IResponse and to know more about ReadingInputResult
	 * @see IResponseBuilder and to know more about IResponseBuilder
	 * @see IResponseBuilder.Message and to know more about Message
	 * @see IResponseBuilder.ResponseBody and to know more about ResponseBody
	 * @see IResponseBuilder.Error and to know more about Error
	 */
	@GetMapping("/readings")
	public IResponse<ResponseBody<List<SensorGetResponse>>> getReadingPerCity(ReadingGetRequest readingGetRequest)
			throws ParseException{
		
		List<SensorGetResponse> result = sensorService.search(readingGetRequest);
		
		return IResponseBuilder.builder(result)
				.setStatus(HttpStatus.OK)
				.build();
	}
	/**
	 * @param adaptor
	 * Setter based auto wiring is used
	 */
	@Autowired
	void setReadingInputRequestAdaptor(ReadingInputRequestAdaptor adaptor) {
		this.readingInputRequestAdaptor = adaptor;
	}
	/**
	 * @param service
	 * Setter based auto wiring is used
	 */
	@Autowired
	public void setSensorService(SensorService service) {
		this.sensorService = service;
	}
	
}
