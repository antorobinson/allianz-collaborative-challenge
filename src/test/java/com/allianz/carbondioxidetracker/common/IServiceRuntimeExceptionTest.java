package com.allianz.carbondioxidetracker.common;

import org.assertj.core.api.Assertions;
import org.junit.Test;

public class IServiceRuntimeExceptionTest {

    @Test
    public void testWithMessage() {

        IServiceRuntimeException exception = IServiceRuntimeException.of(
                ErrorCode.BAD_REQUEST, "message"
        ) ;

        Assertions.assertThat(exception.getErrorCode()).isEqualTo(ErrorCode.BAD_REQUEST) ;
        Assertions.assertThat(exception.getMessage()).isEqualTo("message") ;
    }
}
