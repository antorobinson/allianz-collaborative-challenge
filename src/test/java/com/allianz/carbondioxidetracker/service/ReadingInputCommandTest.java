package com.allianz.carbondioxidetracker.service;

import org.assertj.core.api.Assertions;
import org.junit.Test;

import java.util.Date;

public class ReadingInputCommandTest {


    @Test
    public void testSettersAndGetters() {

        final ReadingInputCommand command = new ReadingInputCommand() ;
        final Date date = new Date() ;

        command.setSensorId("TPK1");
        command.setCarbonValue(8F);

        Assertions.assertThat(command.getSensorId()).isEqualTo("TPK1") ;
        Assertions.assertThat(command.getCarbonValue()).isEqualTo(8F) ;

    }
}
