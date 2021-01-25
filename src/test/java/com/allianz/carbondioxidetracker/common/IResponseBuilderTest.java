package com.allianz.carbondioxidetracker.common;

import org.assertj.core.api.Assertions;
import org.junit.Test;
import org.springframework.http.HttpStatus;

public class IResponseBuilderTest {

    @Test
    public void testBuilder() {

        Object obj = new Object()  ;
        final IResponse<IResponseBuilder.ResponseBody<Object>> response = IResponseBuilder.builder()
                .setBody(obj)
                .addHeader("KEY", "VALUE")
                .setStatus(HttpStatus.OK)
                .build()
                ;

        Assertions.assertThat(response).isNotNull() ;
        Assertions.assertThat(response.getBody().getError()).isNull() ;
        Assertions.assertThat(response.getBody().getData()).isEqualTo(obj) ;
        Assertions.assertThat(response.getBody().getMessage())
                .isEqualTo(IResponseBuilder.Message.SUCCESS) ;
        Assertions.assertThat(response.getHeaders().containsKey("KEY")).isTrue() ;
        Assertions.assertThat(response.getHeaders().size()).isOne() ;
        Assertions.assertThat(response.getStatusCode()).isEqualTo(HttpStatus.OK) ;
    }

    @Test
    public void testError() {

        final IResponseBuilder.Error error = IResponseBuilder
                .error(ErrorCode.BAD_REQUEST, ErrorMessage.SENSOR_NOT_FOUND.getValue())  ;
        final IResponse<IResponseBuilder.ResponseBody<Object>> response = IResponseBuilder.builder()
                .setError(error)
                .addHeader("KEY", "VALUE")
                .setStatus(HttpStatus.BAD_REQUEST)
                .build()
                ;

        Assertions.assertThat(response).isNotNull() ;
        Assertions.assertThat(response.getBody().getData()).isNull() ;
        Assertions.assertThat(response.getBody().getError()).isNotNull() ;
        Assertions.assertThat(response.getBody().getMessage()).isEqualTo(IResponseBuilder.Message.NOT_SUCCESS) ;
        Assertions.assertThat(response.getBody().getError().getErrorCode()).isEqualTo(ErrorCode.BAD_REQUEST) ;
        Assertions.assertThat(response.getBody().getError().getErrorMessage())
                .isEqualTo(ErrorMessage.SENSOR_NOT_FOUND.getValue()) ;
        Assertions.assertThat(response.getStatusCode()).isEqualTo(HttpStatus.BAD_REQUEST) ;
    }

}
