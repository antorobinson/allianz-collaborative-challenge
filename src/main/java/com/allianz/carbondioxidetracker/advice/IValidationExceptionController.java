package com.allianz.carbondioxidetracker.advice;

import com.allianz.carbondioxidetracker.common.IValidationException;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
class IValidationExceptionController {

    private static final String KEY = "error-message" ;

    @ExceptionHandler(value = IValidationException.class)
    public ResponseEntity<Object> exception(IValidationException exception) {

        final HttpHeaders headers = new HttpHeaders();
        headers.add(KEY, exception.getMessage());

        return new ResponseEntity<>(exception.getMessage(), headers, HttpStatus.BAD_REQUEST);
    }
}
