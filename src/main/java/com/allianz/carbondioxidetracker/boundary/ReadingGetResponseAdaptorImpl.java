package com.allianz.carbondioxidetracker.boundary;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.allianz.carbondioxidetracker.entity.Reading;
import com.allianz.carbondioxidetracker.service.SensorGetResponse;
import com.allianz.carbondioxidetracker.service.adaptors.ReadingGetResponseAdaptor;

@Component
public class ReadingGetResponseAdaptorImpl implements ReadingGetResponseAdaptor {

	@Override
	public SensorGetResponse adopt(Reading object) {
		// TODO Auto-generated method stub
		return null;
	}


}
