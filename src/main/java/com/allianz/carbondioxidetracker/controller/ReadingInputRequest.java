package com.allianz.carbondioxidetracker.controller;

import com.allianz.carbondioxidetracker.common.ISelfValidation;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

public class ReadingInputRequest extends ISelfValidation {

    @NotNull(message = "sensorId cannot be empty")
    @Size(min=2, max=30 , message = "sensorId must between 3 and 32")
    @Pattern(regexp = "^[a-zA-Z0-9]*$" ,message="sensorId must be alphanumeric")
    private String sensorId;

    @NotNull(message = "carbonValue cannot be empty")
    @Min(value = 300, message = "carbonValue must be greater than 300")
    @Max(value = 400, message = "carbonValue must be lesser than 400")
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
