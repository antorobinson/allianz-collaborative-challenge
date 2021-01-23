package com.allianz.carbondioxidetracker.common;

import org.assertj.core.api.Assertions;
import org.junit.Test;

public class IValidationExceptionTest {

    @Test
    public void testWithMessage() {
        Assertions.assertThat(
                IValidationException.of(
                        ErrorCode.NULL_REQUEST,  "message"
                ).getMessage()
        ).isEqualTo("message") ;
    }
}
