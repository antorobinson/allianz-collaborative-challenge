package com.allianz.carbondioxidetracker.common;

public class IServiceRuntimeException extends RuntimeException {

    private final ErrorCode errorCode ;

    public IServiceRuntimeException(ErrorCode errorCode, String errorMessage) {

        super(errorMessage);
        this.errorCode = errorCode;
    }

    public static IServiceRuntimeException of(ErrorCode errorCode, String errorMessage) {
        return new IServiceRuntimeException(errorCode, errorMessage) ;
    }

    public ErrorCode getErrorCode() {
        return errorCode;
    }

    public String getErrorMessage() {
        return getMessage();
    }

}
