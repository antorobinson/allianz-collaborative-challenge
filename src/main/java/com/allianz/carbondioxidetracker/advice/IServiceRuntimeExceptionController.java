package com.allianz.carbondioxidetracker.advice;


import com.allianz.carbondioxidetracker.common.IServiceRuntimeException;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
class IServiceRuntimeExceptionController {

    private static final String KEY = "error-message" ;
    private static final String ERROR_DETAIL = "error-detail" ;

    @ExceptionHandler(value = IServiceRuntimeException.class)
    public ResponseEntity<Object> exception(IServiceRuntimeException exception) {

        final HttpHeaders headers = new HttpHeaders();
        headers.add(KEY, exception.getMessage());

        return new ResponseEntity<>(exception.getMessage(), headers, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler(NullPointerException.class)
    public final ResponseEntity<Object> exception(NullPointerException exception) {

        final HttpHeaders headers = new HttpHeaders();
        headers.add(ERROR_DETAIL, exception.getMessage() != null ? exception.getMessage()
                : exception.getStackTrace()[0].toString());

        return new ResponseEntity<>(exception.getMessage(), headers, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler(value = HttpMessageNotReadableException.class)
    public ResponseEntity<Object> exception(HttpMessageNotReadableException exception) {

        final HttpHeaders headers = new HttpHeaders();
        headers.add(ERROR_DETAIL, exception.getMessage() != null ? exception.getMessage()
                : exception.getStackTrace()[0].toString());

        return new ResponseEntity<>(exception.getMessage(), headers, HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
