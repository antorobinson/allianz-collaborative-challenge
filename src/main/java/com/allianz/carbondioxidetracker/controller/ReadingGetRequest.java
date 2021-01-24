package com.allianz.carbondioxidetracker.controller;

import java.util.Optional;

public class ReadingGetRequest {
	private Optional<String> city;
	private Optional<String> district;

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

}
