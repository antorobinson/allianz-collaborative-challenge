package com.allianz.carbondioxidetracker.common;

import org.assertj.core.api.Assertions;
import org.junit.Test;

public class ErrorMessagesTest {

    @Test
    public void testErrorMessages() {

        Assertions.assertThat(ErrorMessages.NULL_REQUEST).isNotNull() ;
        Assertions.assertThat(ErrorMessages.NULL_COMMAND).isNotNull() ;
    }
}
