package com.allianz.carbondioxidetracker.controller;

import org.assertj.core.api.Assertions;
import org.junit.Test;

import java.util.Date;

public class CarbonReadingInputRequestTest {

    @Test
    public void testGettersAndSetters() {

        final CarbonReadingInputRequest request = new CarbonReadingInputRequest() ;

        final Date date = new Date() ;

        request.setSensorId(1L);
        request.setDate(new Date());
        request.setCarbonValue(200F);

        Assertions.assertThat(request.getSensorId()).isEqualTo(1L) ;
        Assertions.assertThat(request.getDate()).isEqualTo(date) ;
        Assertions.assertThat(request.getCarbonValue()).isEqualTo(200) ;
    }
}