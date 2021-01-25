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
package com.allianz.carbondioxidetracker.advice;

import com.allianz.carbondioxidetracker.common.ErrorCode;
import com.allianz.carbondioxidetracker.common.IResponse;
import com.allianz.carbondioxidetracker.common.IResponseBuilder;
import com.allianz.carbondioxidetracker.common.IResponseBuilder.ResponseBody;
import com.allianz.carbondioxidetracker.common.IServiceRuntimeException;
import com.allianz.carbondioxidetracker.common.IValidationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

/**
 * This ControllerAdvice class will catch and create the error response of all the Exceptions
 * <p>
 * See {@link IValidationException}
 * See {@link IServiceRuntimeException}
 * See {@link NullPointerException}
 * See {@link HttpMessageNotReadableException}
 * See {@link IResponse}
 * See {@link ResponseBody}
 * See {@link IResponseBuilder}
 * See {@link IResponseBuilder.ResponseBody}
 * See {@link IResponseBuilder.Message}
 * See {@link IResponseBuilder.Error}
 * See {@link HttpStatus}
 * See {@link ExceptionController#getExceptionMessage}
 * </p>
 * @version v1
 * @since 1.0
 */
@ControllerAdvice
class ExceptionAdviceController extends ExceptionController {

    /**
     * This ExceptionHandler catch and create the error response of IValidationException
     * <p>
     * See {@link IValidationException}
     * </p>
     * @param exception IValidationException exception thrown from any where from the application
     * @return ResponseEntity<ResponseBody<Object>> error response with error code and error body
     */
    @ExceptionHandler(value = IValidationException.class)
    public ResponseEntity<ResponseBody<Object>> exception(IValidationException exception) {
        return getResponseBodyIResponse(
                getExceptionMessage(exception), HttpStatus.BAD_REQUEST, exception.getErrorCode()
        );
    }
    /**
     * This ExceptionHandler catch and create the error response of IServiceRuntimeException
     * <p>
     * See {@link IServiceRuntimeException}
     * </p>
     * @param exception IServiceRuntimeException exception thrown from any where from the application
     * @return ResponseEntity<ResponseBody<Object>> error response with error code and error body
     */
    @ExceptionHandler(value = IServiceRuntimeException.class)
    public IResponse<ResponseBody<Object>> exception(IServiceRuntimeException exception) {
        return getResponseBodyIResponse(
                getExceptionMessage(exception), HttpStatus.INTERNAL_SERVER_ERROR, exception.getErrorCode()
        );
    }
    /**
     * This ExceptionHandler catch and create the error response of NullPointerException
     * <p>
     * See {@link NullPointerException}
     * </p>
     * @param exception NullPointerException exception thrown from any where from the application
     * @return ResponseEntity<ResponseBody<Object>> error response with error code and error body
     */
    @ExceptionHandler(NullPointerException.class)
    public final IResponse<ResponseBody<Object>> exception(NullPointerException exception) {
        return getResponseBodyIResponse(
                getExceptionMessage(exception), HttpStatus.INTERNAL_SERVER_ERROR, ErrorCode.INTERNAL_SERVER_ERROR
        );
    }
    /**
     * This ExceptionHandler catch and create the error response of HttpMessageNotReadableException
     * <p>
     * See {@link HttpMessageNotReadableException}
     * </p>
     * @param exception HttpMessageNotReadableException exception thrown from any where from the application
     * @return ResponseEntity<ResponseBody<Object>> error response with error code and error body
     */
    @ExceptionHandler(value = HttpMessageNotReadableException.class)
    public IResponse<ResponseBody<Object>> exception(HttpMessageNotReadableException exception) {
        return getResponseBodyIResponse(
                getExceptionMessage(exception), HttpStatus.INTERNAL_SERVER_ERROR, ErrorCode.INTERNAL_SERVER_ERROR
        );
    }

    private IResponse<ResponseBody<Object>> getResponseBodyIResponse(
            String message,
            HttpStatus httpStatus,
            ErrorCode errorCode) {

        return IResponseBuilder.builder()
                .addHeader(ERROR_MESSAGE_KEY, errorCode.getValue())
                .addHeader(ERROR_DETAIL_KEY, message)
                .setStatus(httpStatus)
                .setError(IResponseBuilder.error(errorCode, message))
                .build();
    }
}
