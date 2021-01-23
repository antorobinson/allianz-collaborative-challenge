package com.allianz.carbondioxidetracker.advice;

class ExceptionController {

    public static final String ERROR_MESSAGE_KEY = "error-message" ;
    public static final String ERROR_DETAIL_KEY = "error-detail" ;

    public final String getExceptionMessage(Exception exception) {

        return exception.getMessage() != null
                ? exception.getMessage()
                : exception.getStackTrace()[0].toString()
                ;
    }
}
