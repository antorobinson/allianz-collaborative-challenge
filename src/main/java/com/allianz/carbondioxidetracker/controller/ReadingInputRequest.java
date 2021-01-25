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

import com.allianz.carbondioxidetracker.common.ISelfValidation;
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

    @NotNull(message = "sensorId cannot be empty")
    @Size(min=2, max=30 , message = "sensorId must between 3 and 32")
    @Pattern(regexp = "^[a-zA-Z0-9]*$" ,message="sensorId must be alphanumeric")
    private String sensorId;

    @NotNull(message = "carbonValue cannot be empty")
    @Min(value = 300, message = "carbonValue must be greater than 300")
    @Max(value = 400, message = "carbonValue must be lesser than 400")
    private Float carbonValue;
}
