package com.allianz.carbondioxidetracker.controller.advice;

import com.allianz.carbondioxidetracker.common.ErrorCode;
import com.allianz.carbondioxidetracker.common.IResponseBuilder.ResponseBody;
import com.allianz.carbondioxidetracker.common.IServiceRuntimeException;
import com.allianz.carbondioxidetracker.common.IValidationException;
import org.assertj.core.api.Assertions;
import org.junit.Before;
import org.junit.Test;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;

public class ExceptionAdviceControllerTest {

    private ExceptionAdviceController exceptionControllerUnderTest;

    @Before
    public void setUp() {
        exceptionControllerUnderTest = new ExceptionAdviceController();
    }

    @Test
    public void testIValidationException() {

        final IValidationException exception = IValidationException
                .of(ErrorCode.NULL_REQUEST, "message");

        final ResponseEntity<ResponseBody<Object>> result = exceptionControllerUnderTest.exception(exception);

        Assertions.assertThat(result).isNotNull() ;
        Assertions.assertThat(result.getStatusCode()).isEqualTo(HttpStatus.BAD_REQUEST) ;
        Assertions.assertThat(result.getHeaders().containsKey(ExceptionAdviceController.ERROR_MESSAGE_KEY)).isTrue() ;
    }

    @Test
    public void testExceptionIServiceRuntimeException() {

        final IServiceRuntimeException exception = IServiceRuntimeException
                .of(ErrorCode.NULL_REQUEST, "message");

        final ResponseEntity<ResponseBody<Object>> result = exceptionControllerUnderTest.exception(exception);

        Assertions.assertThat(result).isNotNull() ;
        Assertions.assertThat(result.getStatusCode()).isEqualTo(HttpStatus.INTERNAL_SERVER_ERROR) ;
        Assertions.assertThat(result.getHeaders().containsKey(ExceptionAdviceController.ERROR_MESSAGE_KEY)).isTrue() ;
    }

    @Test
    public void testExceptionNullPointerException() {

        final NullPointerException exception = new NullPointerException("message");

        final ResponseEntity<ResponseBody<Object>> result = exceptionControllerUnderTest.exception(exception);

        Assertions.assertThat(result).isNotNull() ;
        Assertions.assertThat(result.getStatusCode()).isEqualTo(HttpStatus.INTERNAL_SERVER_ERROR) ;
        Assertions.assertThat(result.getHeaders().containsKey(ExceptionAdviceController.ERROR_DETAIL_KEY)).isTrue() ;
    }

    @Test
    public void testExceptionHttpMessageNotReadableException() {

        final HttpMessageNotReadableException exception = new HttpMessageNotReadableException("message");

        final ResponseEntity<ResponseBody<Object>> result = exceptionControllerUnderTest.exception(exception);

        Assertions.assertThat(result).isNotNull() ;
        Assertions.assertThat(result.getStatusCode()).isEqualTo(HttpStatus.INTERNAL_SERVER_ERROR) ;
        Assertions.assertThat(result.getHeaders().containsKey(ExceptionAdviceController.ERROR_DETAIL_KEY)).isTrue() ;
    }
}
