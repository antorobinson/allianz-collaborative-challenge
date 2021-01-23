package com.allianz.carbondioxidetracker;


import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

import com.allianz.carbondioxidetracker.entity.Reading;
import com.allianz.carbondioxidetracker.entity.Sensor;
import com.allianz.carbondioxidetracker.repository.SensorRepository;
import com.allianz.carbondioxidetracker.service.impls.SensorServiceImpl;
import com.allianz.carbondioxidetracker.util.CurrentTimeCalendar;

@ComponentScan(basePackages={"com.allianz.carbondioxidetracker.*"})
@SpringBootApplication
public class CarbonDioxideTrackerApplication{

	public static void main(String[] args) {
		SpringApplication.run(CarbonDioxideTrackerApplication.class, args);
	}
	

}
