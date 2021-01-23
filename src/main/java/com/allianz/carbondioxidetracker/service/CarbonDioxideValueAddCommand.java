package com.allianz.carbondioxidetracker.service;

import java.util.Date;

public class CarbonDioxideValueAddCommand {

    private String sensorId;
    private Date date;
    private Float carbonValue;

    public String getSensorId() {
        return sensorId;
    }

    public void setSensorId(String sensorId) {
        this.sensorId = sensorId;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Float getCarbonValue() {
        return carbonValue;
    }

    public void setCarbonValue(Float carbonValue) {
        this.carbonValue = carbonValue;
    }
}
