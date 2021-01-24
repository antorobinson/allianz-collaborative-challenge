package com.allianz.carbondioxidetracker.boundary;

import com.allianz.carbondioxidetracker.entity.Reading;
import com.allianz.carbondioxidetracker.service.SensorGetResponse;
import com.allianz.carbondioxidetracker.service.adaptors.ReadingGetResponseAdaptor;
import org.springframework.stereotype.Component;

@Component
public class ReadingGetResponseAdaptorImpl implements ReadingGetResponseAdaptor {

	@Override
	public SensorGetResponse adopt(Reading object) {
		// TODO Auto-generated method stub
		return null;
	}


}
