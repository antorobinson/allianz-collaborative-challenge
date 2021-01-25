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
import com.allianz.carbondioxidetracker.entity.Reading;
import com.allianz.carbondioxidetracker.service.ReadingGetResponse;
import com.allianz.carbondioxidetracker.service.adaptors.ReadingGetResponseAdaptor;
import org.springframework.stereotype.Component;
/**
 * This class is a Adaptor class implements from ReadingGetResponseAdaptor to adopt Reading to ReadingGetResponse
 * <p>
 * See {@link Reading}
 * See {@link ReadingGetResponse}
 * See {@link IAdaptor}
 * </p>
 */
@Component
class ReadingGetResponseAdaptorImpl implements ReadingGetResponseAdaptor {

	/**
	 * This methode takes Reading as an argument and give ReadingGetResponse as a return type
	 * @param reading is an instance of Reading class
	 * @return is an converted instance of ReadingGetResponse
	 */
	@Override
	public ReadingGetResponse adopt(Reading reading) {
		ReadingGetResponse readingResponse = new ReadingGetResponse();
		readingResponse.setId(reading.getId());
		readingResponse.setReadingValue(reading.getReadingValue());
		readingResponse.setTime(reading.getTime());
		
		return readingResponse;
	}
}
