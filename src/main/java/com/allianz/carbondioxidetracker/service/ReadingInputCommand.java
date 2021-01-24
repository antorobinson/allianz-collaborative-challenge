package com.allianz.carbondioxidetracker.service;

public class ReadingInputCommand {

    private String sensorId;
    private Float carbonValue;

    public String getSensorId() {
        return sensorId;
    }

    public void setSensorId(String sensorId) {
        this.sensorId = sensorId;
    }

    public Float getCarbonValue() {
        return carbonValue;
    }

    public void setCarbonValue(Float carbonValue) {
        this.carbonValue = carbonValue;
    }
}
