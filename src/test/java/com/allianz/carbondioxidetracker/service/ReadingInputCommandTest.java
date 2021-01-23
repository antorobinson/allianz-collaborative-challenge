package com.allianz.carbondioxidetracker.service;

import org.assertj.core.api.Assertions;
import org.junit.Test;

import java.util.Date;

public class ReadingInputCommandTest {


    @Test
    public void testSettersAndGetters() {

        final ReadingInputCommand command = new ReadingInputCommand() ;
        final Date date = new Date() ;

        command.setSensorId(2L);
        command.setDate(date);
        command.setCarbonValue(8F);

        Assertions.assertThat(command.getSensorId()).isEqualTo(2L) ;
        Assertions.assertThat(command.getDate()).isEqualTo(date) ;
        Assertions.assertThat(command.getCarbonValue()).isEqualTo(8F) ;

    }
}
