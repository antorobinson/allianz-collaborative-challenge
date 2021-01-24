package com.allianz.carbondioxidetracker.service;

import java.util.Date;

public class ReadingGetResponse {

    private Long id;

    private Float readingValue;

    private Date time;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Float getReadingValue() {
		return readingValue;
	}

	public void setReadingValue(Float readingValue) {
		this.readingValue = readingValue;
	}

	public Date getTime() {
		return time;
	}

	public void setTime(Date time) {
		this.time = time;
	}
    
}
