package com.allianz.carbondioxidetracker.common;

import org.assertj.core.api.Assertions;
import org.junit.Test;

public class IEmptyValidationTest {

    @Test
    public void testIsEmpty() {
        Assertions.assertThat(IEmptyValidation.isEmpty(null)).isTrue();

        String string = null ;
        Assertions.assertThat(IEmptyValidation.isEmpty(string)).isTrue();

        string = "" ;
        Assertions.assertThat(IEmptyValidation.isEmpty(string)).isTrue();

        string = " " ;
        Assertions.assertThat(IEmptyValidation.isEmpty(string)).isTrue();

        string = "testData" ;
        Assertions.assertThat(IEmptyValidation.isEmpty(string)).isFalse();
    }
}
