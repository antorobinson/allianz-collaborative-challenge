package com.allianz.carbondioxidetracker.controller;

import java.util.Optional;

public class ReadingGetRequest {
	private Optional<String> city;
	private Optional<String> district;
	private Optional<String> fromDate;
	private Optional<String> toDate;
	public Optional<String> getCity() {
		return city;
	}
	public void setCity(Optional<String> city) {
		this.city = city;
	}
	public Optional<String> getDistrict() {
		return district;
	}
	public void setDistrict(Optional<String> district) {
		this.district = district;
	}
	public Optional<String> getFromDate() {
		return fromDate;
	}
	public void setFromDate(Optional<String> fromDate) {
		this.fromDate = fromDate;
	}
	public Optional<String> getToDate() {
		return toDate;
	}
	public void setToDate(Optional<String> toDate) {
		this.toDate = toDate;
	}

	

	
	

}
