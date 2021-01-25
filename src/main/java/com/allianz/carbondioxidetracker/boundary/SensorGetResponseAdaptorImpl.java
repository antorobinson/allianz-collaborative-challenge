package com.allianz.carbondioxidetracker.boundary;

import com.allianz.carbondioxidetracker.entity.Sensor;
import com.allianz.carbondioxidetracker.service.SensorGetResponse;
import com.allianz.carbondioxidetracker.service.adaptors.ReadingGetResponseAdaptor;
import com.allianz.carbondioxidetracker.service.adaptors.SensorGetResponseAdaptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
class SensorGetResponseAdaptorImpl implements SensorGetResponseAdaptor {
	
	private ReadingGetResponseAdaptor readingGetResponseAdaptor;

	@Override
	public SensorGetResponse adopt(Sensor sensor) {

		final SensorGetResponse response = new SensorGetResponse();
		response.setCity(sensor.getCity());
		response.setDistrict(sensor.getDistrict());
		response.setSensorId(sensor.getSensorId());

		response.setSensorReadings(readingGetResponseAdaptor.adopt(sensor.getSensorReadings()));

		return response;
	}
	
	@Autowired
	public void setReadingGetResponseAdaptor(ReadingGetResponseAdaptor adaptor) {
		this.readingGetResponseAdaptor = adaptor;
	}

	
}
