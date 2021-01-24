package com.allianz.carbondioxidetracker.controller;

import org.assertj.core.api.Assertions;
import org.junit.Test;

public class ReadingInputRequestTest {

    @Test
    public void testGettersAndSetters() {

        final ReadingInputRequest request = new ReadingInputRequest() ;
        request.setSensorId("TPK1");
        request.setCarbonValue(200F);

        Assertions.assertThat(request.getSensorId()).isEqualTo("TPK1") ;
        Assertions.assertThat(request.getCarbonValue()).isEqualTo(200) ;
    }
}