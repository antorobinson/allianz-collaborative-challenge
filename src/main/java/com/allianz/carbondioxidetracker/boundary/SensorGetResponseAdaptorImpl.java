package com.allianz.carbondioxidetracker.boundary;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.allianz.carbondioxidetracker.entity.Reading;
import com.allianz.carbondioxidetracker.entity.Sensor;
import com.allianz.carbondioxidetracker.service.ReadingGetResponse;
import com.allianz.carbondioxidetracker.service.SensorGetResponse;
import com.allianz.carbondioxidetracker.service.adaptors.ReadingGetResponseAdaptor;
import com.allianz.carbondioxidetracker.service.adaptors.SensorGetResponseAdaptor;

@Component
public class SensorGetResponseAdaptorImpl implements SensorGetResponseAdaptor {
	
	private ReadingGetResponseAdaptor readingGetResponseAdaptor;

	@Override
	public SensorGetResponse adopt(Sensor sensor) {
		SensorGetResponse sensorGetResponse = new SensorGetResponse();
		sensorGetResponse.setCity(sensor.getCity());
		sensorGetResponse.setDistrict(sensor.getDistrict());
		sensorGetResponse.setSensorId(sensor.getSensorId());
		List<ReadingGetResponse> readingGetResponseList = new ArrayList<>();
		List<Reading> readingList = sensor.getSensorReadings();
		for (Reading reading : readingList) {
			readingGetResponseList.add(readingGetResponseAdaptor.adopt(reading));
		}
		sensorGetResponse.setSensorReadings(readingGetResponseList);
		return sensorGetResponse;
	}
	
	@Autowired
	public void setReadingGetResponseAdaptor(ReadingGetResponseAdaptor readingGetResponseAdaptor) {
		this.readingGetResponseAdaptor = readingGetResponseAdaptor;
	}

	
}
