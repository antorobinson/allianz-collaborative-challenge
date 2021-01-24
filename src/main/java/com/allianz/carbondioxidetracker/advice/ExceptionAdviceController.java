package com.allianz.carbondioxidetracker.advice;


import com.allianz.carbondioxidetracker.common.ErrorCode;
import com.allianz.carbondioxidetracker.common.IResponse;
import com.allianz.carbondioxidetracker.common.IResponseBuilder;
import com.allianz.carbondioxidetracker.common.IServiceRuntimeException;
import com.allianz.carbondioxidetracker.common.IValidationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
class ExceptionAdviceController extends ExceptionController {

    @ExceptionHandler(value = IValidationException.class)
    public ResponseEntity<Object> exception(IValidationException exception) {

        return IResponseBuilder.builder()
                .addHeader(ERROR_MESSAGE_KEY, getExceptionMessage(exception))
                .addHeader(ERROR_DETAIL_KEY, getExceptionMessage(exception))
                .setStatus(HttpStatus.BAD_REQUEST)
                .setBody(IResponseBuilder.error(exception.getErrorCode()))
                .build() ;
    }

    @ExceptionHandler(value = IServiceRuntimeException.class)
    public IResponse<Object> exception(IServiceRuntimeException exception) {

        return IResponseBuilder.builder()
                .addHeader(ERROR_MESSAGE_KEY, getExceptionMessage(exception))
                .addHeader(ERROR_DETAIL_KEY, getExceptionMessage(exception))
                .setStatus(HttpStatus.INTERNAL_SERVER_ERROR)
                .setBody(IResponseBuilder.error(exception.getErrorCode()))
                .build() ;
    }

    @ExceptionHandler(NullPointerException.class)
    public final IResponse<Object> exception(NullPointerException exception) {

        return IResponseBuilder.builder()
                .addHeader(ERROR_MESSAGE_KEY, getExceptionMessage(exception))
                .addHeader(ERROR_DETAIL_KEY, getExceptionMessage(exception))
                .setStatus(HttpStatus.INTERNAL_SERVER_ERROR)
                .setBody(IResponseBuilder.error(ErrorCode.INTERNAL_SERVER_ERROR))
                .build() ;
    }

    @ExceptionHandler(value = HttpMessageNotReadableException.class)
    public IResponse<Object> exception(HttpMessageNotReadableException exception) {

        return IResponseBuilder.builder()
                .addHeader(ERROR_MESSAGE_KEY, getExceptionMessage(exception))
                .addHeader(ERROR_DETAIL_KEY, getExceptionMessage(exception))
                .setStatus(HttpStatus.INTERNAL_SERVER_ERROR)
                .setBody(IResponseBuilder.error(ErrorCode.INTERNAL_SERVER_ERROR))
                .build() ;
    }
}
