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

import java.text.ParseException;

@ControllerAdvice
class ExceptionAdviceController extends ExceptionController {

    @ExceptionHandler(value = IValidationException.class)
    public ResponseEntity<ResponseBody<Object>> exception(IValidationException exception) {
        return getResponseBodyIResponse(
                getExceptionMessage(exception), HttpStatus.BAD_REQUEST, exception.getErrorCode()
        );
    }

    @ExceptionHandler(value = IServiceRuntimeException.class)
    public IResponse<ResponseBody<Object>> exception(IServiceRuntimeException exception) {
        return getResponseBodyIResponse(
                getExceptionMessage(exception), HttpStatus.INTERNAL_SERVER_ERROR, exception.getErrorCode()
        );
    }

    @ExceptionHandler(NullPointerException.class)
    public final IResponse<ResponseBody<Object>> exception(NullPointerException exception) {
        return getResponseBodyIResponse(
                getExceptionMessage(exception), HttpStatus.INTERNAL_SERVER_ERROR, ErrorCode.INTERNAL_SERVER_ERROR
        );
    }

    @ExceptionHandler(value = HttpMessageNotReadableException.class)
    public IResponse<ResponseBody<Object>> exception(HttpMessageNotReadableException exception) {
        return getResponseBodyIResponse(
                getExceptionMessage(exception), HttpStatus.INTERNAL_SERVER_ERROR, ErrorCode.INTERNAL_SERVER_ERROR
        );
    }
    
    @ExceptionHandler(value = ParseException.class)
    public IResponse<ResponseBody<Object>> exception(ParseException exception) {
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
