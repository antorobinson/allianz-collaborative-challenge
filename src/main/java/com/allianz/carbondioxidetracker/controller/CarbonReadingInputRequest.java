package com.allianz.carbondioxidetracker.controller;

import com.allianz.carbondioxidetracker.common.ISelfValidation;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import java.util.Date;

public class CarbonReadingInputRequest extends ISelfValidation {

    @NotNull(message = "sensorId cannot be empty")
    @Min(value = 0, message = "sensorId must be greater than 0")
    private Long sensorId;

//    @NotNull(message = "date cannot be empty")
//    @DateTimeFormat(pattern = "dd-MM-yyyy HH:mm")
    private Date date;

    @NotNull(message = "carbonValue cannot be empty")
    @Min(value = 300, message = "carbonValue must be greater than 300")
    @Max(value = 400, message = "carbonValue must be lesser than 400")
    private Float carbonValue;

    public Long getSensorId() {
        return sensorId;
    }

    public void setSensorId(Long sensorId) {
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
