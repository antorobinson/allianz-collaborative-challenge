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

        return IResponseBuilder.builder()
                .addHeader(ERROR_MESSAGE_KEY, getExceptionMessage(exception))
                .addHeader(ERROR_DETAIL_KEY, getExceptionMessage(exception))
                .setStatus(HttpStatus.BAD_REQUEST)
                .setError(IResponseBuilder.error(exception.getErrorCode(), getExceptionMessage(exception)))
                .build() ;
    }

    @ExceptionHandler(value = IServiceRuntimeException.class)
    public IResponse<ResponseBody<Object>> exception(IServiceRuntimeException exception) {

        return IResponseBuilder.builder()
                .addHeader(ERROR_MESSAGE_KEY, getExceptionMessage(exception))
                .addHeader(ERROR_DETAIL_KEY, getExceptionMessage(exception))
                .setStatus(HttpStatus.INTERNAL_SERVER_ERROR)
                .setError(IResponseBuilder.error(exception.getErrorCode(), getExceptionMessage(exception)))
                .build() ;
    }

    @ExceptionHandler(NullPointerException.class)
    public final IResponse<ResponseBody<Object>> exception(NullPointerException exception) {

        return IResponseBuilder.builder()
                .addHeader(ERROR_MESSAGE_KEY, getExceptionMessage(exception))
                .addHeader(ERROR_DETAIL_KEY, getExceptionMessage(exception))
                .setStatus(HttpStatus.INTERNAL_SERVER_ERROR)
                .setError(IResponseBuilder.error(ErrorCode.INTERNAL_SERVER_ERROR, getExceptionMessage(exception)))
                .build() ;
    }

    @ExceptionHandler(value = HttpMessageNotReadableException.class)
    public IResponse<ResponseBody<Object>> exception(HttpMessageNotReadableException exception) {

        return IResponseBuilder.builder()
                .addHeader(ERROR_MESSAGE_KEY, getExceptionMessage(exception))
                .addHeader(ERROR_DETAIL_KEY, getExceptionMessage(exception))
                .setStatus(HttpStatus.INTERNAL_SERVER_ERROR)
                .setError(IResponseBuilder.error(ErrorCode.INTERNAL_SERVER_ERROR, getExceptionMessage(exception)))
                .build() ;
    }
    
    @ExceptionHandler(value = ParseException.class)
    public IResponse<ResponseBody<Object>> exception(ParseException exception) {

        return IResponseBuilder.builder()
                .addHeader(ERROR_MESSAGE_KEY, getExceptionMessage(exception))
                .addHeader(ERROR_DETAIL_KEY, getExceptionMessage(exception))
                .setStatus(HttpStatus.INTERNAL_SERVER_ERROR)
                .setError(IResponseBuilder.error(ErrorCode.INTERNAL_SERVER_ERROR, getExceptionMessage(exception)))
                .build() ;
    }

}
