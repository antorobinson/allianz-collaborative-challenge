package com.allianz.carbondioxidetracker.controller.advice;

import org.assertj.core.api.Assertions;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

public class ExceptionControllerTest {

    private ExceptionController exceptionControllerUnderTest;

    @Before
    public void setUp() {
        exceptionControllerUnderTest = new ExceptionController();
    }

    @Test
    public void testGetExceptionMessage() {

        final Exception exception = Mockito.mock(Exception.class);

        Mockito.when(exception.getMessage()).thenReturn("message") ;
        final String result = exceptionControllerUnderTest.getExceptionMessage(exception);

        Assertions.assertThat(result).isEqualTo("message") ;
    }

    @Test
    public void testGetExceptionStackTrace() {

        final Exception exception = new ExceptionImpl(
                "ExceptionControllerTest" ,
                "getStackTrace" ,
                "ExceptionControllerTest" ,
                48
        );

        final String result = exceptionControllerUnderTest.getExceptionMessage(exception);

        Assertions.assertThat(result).isEqualTo("ExceptionControllerTest.getStackTrace(ExceptionControllerTest:48)") ;
    }

    private static class ExceptionImpl extends Exception {

        String declaringClass;
        String methodName ;
        String fileName;
        int lineNumber ;

        ExceptionImpl(String declaringClass, String methodName,
                      String fileName, int lineNumber) {

            this.declaringClass = declaringClass ;
            this.methodName = methodName ;
            this.fileName = fileName ;
            this.lineNumber = lineNumber ;
        }

        @Override
        public String getMessage() {
            return null;
        }

        @Override
        public StackTraceElement[] getStackTrace() {
            final StackTraceElement[] stackTraceElements = new StackTraceElement[1] ;
            final StackTraceElement stackTrace = new StackTraceElement(declaringClass, methodName,
                    fileName, lineNumber) ;

            stackTraceElements[0] = stackTrace ;

            return stackTraceElements ;
        }
    }
}
