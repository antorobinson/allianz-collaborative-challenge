package com.allianz.carbondioxidetracker.common;

public enum ErrorCode {

    NULL_REQUEST("NULL_REQUEST") ,
    BAD_REQUEST("BAD_REQUEST") ,
    NULL_COMMAND("NULL_COMMAND") ,
    SENSOR_NOT_FOUND("SENSOR_NOT_FOUND") ,
    INTERNAL_SERVER_ERROR("INTERNAL_SERVER_ERROR") ;

    private final String value;

    ErrorCode(String value) {
        this.value = value ;
    }

    public String getValue() {
        return value;
    }
}
