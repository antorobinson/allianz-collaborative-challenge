package com.allianz.carbondioxidetracker.common;

public enum ErrorMessage {

    NULL_REQUEST("Null Request") ,
    NULL_COMMAND("Null Command")
    ;

    private final String value;

    ErrorMessage(String value) {
        this.value = value ;
    }

    public String getValue() {
        return value;
    }

}
