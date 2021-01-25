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
package com.allianz.carbondioxidetracker.common;

public enum ErrorMessage {

    NULL_REQUEST("Null Request") ,
    NULL_COMMAND("Null Command") ,
    SENSOR_NOT_FOUND("Sensor not found") ,
    ;


    public static final String SENSOR_ID_CANNOT_BE_EMPTY = "sensorId cannot be empty" ;
    public static final String INVALID_SENSOR_ID_LENGTH = "sensorId must between 3 and 32" ;
    public static final String INVALID_INVALID_PATTERN = "sensorId must be alphanumeric" ;
    public static final String CARBON_VALUE_CANNOT_BE_EMPTY = "carbonValue cannot be empty" ;
    public static final String CARBON_MUST_NEED_GREATER_VALUE = "carbonValue must be greater than 300" ;
    public static final String CARBON_MUST_NEED_LESSER_VALUE = "carbonValue must be lesser than 400" ;


    private final String value;

    ErrorMessage(String value) {
        this.value = value ;
    }

    public String getValue() {
        return value;
    }

}
