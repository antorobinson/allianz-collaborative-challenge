package com.allianz.carbondioxidetracker.controller;

import org.assertj.core.api.Assertions;
import org.junit.Test;

import java.util.Date;

public class ReadingInputRequestTest {

    @Test
    public void testGettersAndSetters() {

        final ReadingInputRequest request = new ReadingInputRequest() ;

        final Date date = new Date() ;

        request.setSensorId(1L);
        request.setDate(new Date());
        request.setCarbonValue(200F);

        Assertions.assertThat(request.getSensorId()).isEqualTo(1L) ;
        Assertions.assertThat(request.getDate()).isEqualTo(date) ;
        Assertions.assertThat(request.getCarbonValue()).isEqualTo(200) ;
    }
}