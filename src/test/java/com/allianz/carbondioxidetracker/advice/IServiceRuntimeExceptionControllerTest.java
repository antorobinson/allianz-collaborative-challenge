package com.allianz.carbondioxidetracker.advice;

import com.allianz.carbondioxidetracker.common.IServiceRuntimeException;
import com.allianz.carbondioxidetracker.common.IValidationException;
import org.assertj.core.api.Assertions;
import org.junit.Before;
import org.junit.Test;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;

public class IServiceRuntimeExceptionControllerTest {

    private IServiceRuntimeExceptionController exceptionControllerUnderTest;

    @Before
    public void setUp() {
        exceptionControllerUnderTest = new IServiceRuntimeExceptionController();
    }

    @Test
    public void testExceptionIServiceRuntimeException() {

        final IServiceRuntimeException exception = new IServiceRuntimeException("message");

        final ResponseEntity<Object> result = exceptionControllerUnderTest.exception(exception);

        Assertions.assertThat(result).isNotNull() ;
        Assertions.assertThat(result.getStatusCode()).isEqualTo(HttpStatus.INTERNAL_SERVER_ERROR) ;
        Assertions.assertThat(result.getHeaders().containsKey("error-message")).isTrue() ;
    }

    @Test
    public void testExceptionNullPointerException() {

        final NullPointerException exception = new NullPointerException("message");

        final ResponseEntity<Object> result = exceptionControllerUnderTest.exception(exception);

        Assertions.assertThat(result).isNotNull() ;
        Assertions.assertThat(result.getStatusCode()).isEqualTo(HttpStatus.INTERNAL_SERVER_ERROR) ;
        Assertions.assertThat(result.getHeaders().containsKey("error-detail")).isTrue() ;
    }

    @Test
    public void testExceptionHttpMessageNotReadableException() {

        final HttpMessageNotReadableException exception = new HttpMessageNotReadableException("message");

        final ResponseEntity<Object> result = exceptionControllerUnderTest.exception(exception);

        Assertions.assertThat(result).isNotNull() ;
        Assertions.assertThat(result.getStatusCode()).isEqualTo(HttpStatus.INTERNAL_SERVER_ERROR) ;
        Assertions.assertThat(result.getHeaders().containsKey("error-detail")).isTrue() ;
    }
}
