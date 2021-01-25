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
package com.allianz.carbondioxidetracker.boundary;

import com.allianz.carbondioxidetracker.common.IAdaptor;
import com.allianz.carbondioxidetracker.repository.entity.Sensor;
import com.allianz.carbondioxidetracker.service.SensorGetResponse;
import com.allianz.carbondioxidetracker.service.adaptors.ReadingGetResponseAdaptor;
import com.allianz.carbondioxidetracker.service.adaptors.SensorGetResponseAdaptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
/**
 * This class is a Adaptor class implements from SensorGetResponseAdaptor to adopt Sensor to SensorGetResponse
 * <p>
 * See {@link Sensor}
 * See {@link SensorGetResponse}
 * See {@link IAdaptor}
 * </p>
 * @version v1
 * @since 1.0
 */
@Component
class SensorGetResponseAdaptorImpl implements SensorGetResponseAdaptor {
	/**
	 * This Adaptor interface is used to convert the Reading to ReadingGetResponse.
	 * To sse the available methode see {@link ReadingGetResponseAdaptor}
	 */
	private ReadingGetResponseAdaptor readingGetResponseAdaptor;
	/**
	 * This methode takes Sensor as an argument and give SensorGetResponse as a return type
	 * @param sensor is an instance of Sensor class
	 * @return is an converted instance of SensorGetResponse
	 */
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
