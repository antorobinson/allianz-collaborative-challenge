package com.allianz.carbondioxidetracker.advice;

import org.assertj.core.api.Assertions;
import org.junit.Before;
import org.junit.Test;

public class ExceptionControllerTest {

    private ExceptionController exceptionControllerUnderTest;

    @Before
    public void setUp() {
        exceptionControllerUnderTest = new ExceptionController();
    }

    @Test
    public void testGetExceptionMessage() {

        final Exception exception = new Exception("message");

        final String result = exceptionControllerUnderTest.getExceptionMessage(exception);

        Assertions.assertThat(result).isNotNull() ;
        Assertions.assertThat(result).isEqualTo("message") ;
    }
}
