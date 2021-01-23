package com.allianz.carbondioxidetracker.common;

import org.assertj.core.api.Assertions;
import org.junit.Test;

public class IValidationExceptionTest {

    @Test
    public void testWithMessage() {
        Assertions.assertThat(IValidationException.withMessage("message").getMessage()).isEqualTo("message") ;
    }
}
