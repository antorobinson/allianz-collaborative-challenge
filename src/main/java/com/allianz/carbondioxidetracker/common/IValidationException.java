package com.allianz.carbondioxidetracker.common;

public final class IValidationException extends RuntimeException {

    public IValidationException(String message) {
        super(message);
    }

    public static IValidationException withMessage(String message) {
        return new IValidationException(message) ;
    }
}
