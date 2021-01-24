package com.allianz.carbondioxidetracker.boundary;


import com.allianz.carbondioxidetracker.entity.Reading;
import com.allianz.carbondioxidetracker.service.ReadingGetResponse;
import com.allianz.carbondioxidetracker.service.adaptors.ReadingGetResponseAdaptor;
import org.springframework.stereotype.Component;

@Component
public class ReadingGetResponseAdaptorImpl implements ReadingGetResponseAdaptor {

	@Override
	public ReadingGetResponse adopt(Reading reading) {
		ReadingGetResponse readingResponse = new ReadingGetResponse();
		readingResponse.setId(reading.getId());
		readingResponse.setReadingValue(reading.getReadingValue());
		readingResponse.setTime(reading.getTime());
		
		return readingResponse;
	}


}
