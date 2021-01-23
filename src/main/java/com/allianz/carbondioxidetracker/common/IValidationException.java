package com.allianz.carbondioxidetracker.common;

public final class IValidationException extends IServiceRuntimeException {


    public IValidationException(ErrorCode errorCode, String errorMessage) {
        super(errorCode, errorMessage);
    }

    public static IValidationException of(ErrorCode errorCode, String errorMessage) {
        return new IValidationException(errorCode, errorMessage) ;
    }
}
