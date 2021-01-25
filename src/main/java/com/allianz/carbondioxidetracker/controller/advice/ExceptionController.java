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
 */
package com.allianz.carbondioxidetracker.controller.advice;

class ExceptionController {

    public static final String ERROR_MESSAGE_KEY = "error-code" ;
    public static final String ERROR_DETAIL_KEY = "error-message" ;

    public final String getExceptionMessage(Exception exception) {

        return exception.getMessage() != null
                ? exception.getMessage()
                : exception.getStackTrace()[0].toString()
                ;
    }
}
