package com.allianz.carbondioxidetracker.controller;

import com.allianz.carbondioxidetracker.boundary.adaptors.AddReadingRequestAdaptor;
import com.allianz.carbondioxidetracker.common.ErrorMessages;
import com.allianz.carbondioxidetracker.common.IEmptyValidation;
import com.allianz.carbondioxidetracker.common.IValidationException;
import com.allianz.carbondioxidetracker.entity.Reading;
import com.allianz.carbondioxidetracker.service.ReadingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/v1/co2")
public class CarbonDioxideDataController {


	private AddReadingRequestAdaptor addReadingRequestAdaptor;

//	private CarbonDioxideDataService carbonDioxideDataService;

	private ReadingService readingService;

	@PostMapping
	public ResponseEntity<Reading> addReading(@RequestBody AddCarbonReadingRequest request) {

		if (IEmptyValidation.isEmpty(request)) throw IValidationException.withMessage(ErrorMessages.NULL_REQUEST) ;

		request.validateSelf() ;

		final Reading reading = addReadingRequestAdaptor.adopt(request) ;

		return new ResponseEntity<>(readingService.addReading(reading), HttpStatus.OK) ;
	}
	
	@GetMapping
	public ResponseEntity<String> getReadingPerCity(){
		
		return ResponseEntity.ok().body("Success");
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
