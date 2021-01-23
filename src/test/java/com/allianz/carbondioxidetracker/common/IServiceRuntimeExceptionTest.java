package com.allianz.carbondioxidetracker.common;

import org.assertj.core.api.Assertions;
import org.junit.Test;

public class IServiceRuntimeExceptionTest {

    @Test
    public void testWithMessage() {
        Assertions.assertThat(
                IServiceRuntimeException.of(
                        ErrorCode.BAD_REQUEST, "message"
                ).getMessage()
        ).isEqualTo("message") ;
    }
}
