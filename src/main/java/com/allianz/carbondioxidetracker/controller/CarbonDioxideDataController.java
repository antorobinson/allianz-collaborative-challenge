package com.allianz.carbondioxidetracker.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/v1/carbonDioxideData")
public class CarbonDioxideDataController {

	@PostMapping("/SensorReadings")
	public ResponseEntity<String> addReading(){
		
		return ResponseEntity.status(201).body("Success");
	}
	
	@GetMapping("/SensorReadings/reading")
	public ResponseEntity<String> getReadingPerCity(){
		
		return ResponseEntity.ok().body("Success");
	}
	
	

}
