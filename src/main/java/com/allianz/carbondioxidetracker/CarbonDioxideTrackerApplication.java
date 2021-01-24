package com.allianz.carbondioxidetracker;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@ComponentScan(basePackages={"com.allianz.carbondioxidetracker.*"})
@SpringBootApplication
public class CarbonDioxideTrackerApplication {

	public static void main(String[] args) {
		SpringApplication.run(CarbonDioxideTrackerApplication.class, args);
	}
}
