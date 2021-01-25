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
package com.allianz.carbondioxidetracker.controller;

import com.allianz.carbondioxidetracker.common.ErrorMessage;
import com.allianz.carbondioxidetracker.common.ISelfValidation;
import com.allianz.carbondioxidetracker.common.Regex;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

@Getter
@Setter
public class ReadingInputRequest extends ISelfValidation {

    @NotNull(message = ErrorMessage.SENSOR_ID_CANNOT_BE_EMPTY)
    @Size(min=2, max=30 , message = ErrorMessage.INVALID_SENSOR_ID_LENGTH)
    @Pattern(regexp = Regex.ALPHA_NUMERIC, message=ErrorMessage.INVALID_INVALID_PATTERN)
    private String sensorId;

    @NotNull(message = ErrorMessage.CARBON_VALUE_CANNOT_BE_EMPTY)
    @Min(value = 301, message = ErrorMessage.CARBON_MUST_NEED_GREATER_VALUE)
    @Max(value = 400, message = ErrorMessage.CARBON_MUST_NEED_LESSER_VALUE)
    private Float carbonValue;
}
