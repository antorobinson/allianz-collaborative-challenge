package com.allianz.carbondioxidetracker.common;

public class IServiceRuntimeException extends RuntimeException {

    public IServiceRuntimeException(String message) {
        super(message);
    }

    public static IServiceRuntimeException withMessage(String message) {
        return new IServiceRuntimeException(message) ;
    }
}
