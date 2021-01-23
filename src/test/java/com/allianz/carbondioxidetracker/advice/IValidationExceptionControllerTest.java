package com.allianz.carbondioxidetracker.advice;

import com.allianz.carbondioxidetracker.common.IValidationException;
import org.assertj.core.api.Assertions;
import org.junit.Before;
import org.junit.Test;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

public class IValidationExceptionControllerTest {

    private IValidationExceptionController iValidationExceptionControllerUnderTest;

    @Before
    public void setUp() {
        iValidationExceptionControllerUnderTest = new IValidationExceptionController();
    }

    @Test
    public void testException() {

        final IValidationException exception = new IValidationException("message");

        final ResponseEntity<Object> result = iValidationExceptionControllerUnderTest.exception(exception);

        Assertions.assertThat(result).isNotNull() ;
        Assertions.assertThat(result.getStatusCode()).isEqualTo(HttpStatus.BAD_REQUEST) ;
        Assertions.assertThat(result.getHeaders().containsKey("error-message")).isTrue() ;
//        Assertions.assertThat(result.getHeaders().containsValue("message")).isTrue() ;
    }
}
