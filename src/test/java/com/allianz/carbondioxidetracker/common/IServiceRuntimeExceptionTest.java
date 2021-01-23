package com.allianz.carbondioxidetracker.common;

import org.assertj.core.api.Assertions;
import org.junit.Test;

public class IServiceRuntimeExceptionTest {

    @Test
    public void testWithMessage() {
        Assertions.assertThat(IServiceRuntimeException.withMessage("message").getMessage()).isEqualTo("message") ;
    }
}
