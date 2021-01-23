package com.allianz.carbondioxidetracker.controller;

import com.allianz.carbondioxidetracker.boundary.adaptors.AddReadingRequestAdaptor;
import com.allianz.carbondioxidetracker.common.*;
import com.allianz.carbondioxidetracker.entity.Reading;
import com.allianz.carbondioxidetracker.service.ReadingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/v1/co2")
public class CarbonDioxideDataController {
	
	


	private AddReadingRequestAdaptor addReadingRequestAdaptor;

//	private CarbonDioxideDataService carbonDioxideDataService;

	private ReadingService readingService;

	@PostMapping
	public IResponse<Reading> addReading(@RequestBody AddCarbonReadingRequest request) {

		if (IEmptyValidation.isEmpty(request))
			throw IValidationException.of(ErrorCode.NULL_REQUEST, ErrorMessage.NULL_REQUEST.getValue()) ;

		request.validateSelf() ;

		final Reading reading = addReadingRequestAdaptor.adopt(request) ;

		return IResponseBuilder.builder(reading)
				.setStatus(HttpStatus.OK)
				.build() ;
	}
	
	@GetMapping
	public IResponse<String> getReadingPerCity() {

		return IResponseBuilder.builder("Success")
				.setStatus(HttpStatus.OK)
				.build() ;
	}

	@Autowired
	void setAddCarbonReadingRequestAdaptor(AddReadingRequestAdaptor adaptor) {
		this.addReadingRequestAdaptor = adaptor;
	}

	@Autowired
	void setReadingService(ReadingService service) {
		this.readingService = service;
	}

	//	public void setCarbonDioxideDataService(CarbonDioxideDataService service) {
//		this.carbonDioxideDataService = service;
//	}
}
