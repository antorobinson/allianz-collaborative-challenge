package com.allianz.carbondioxidetracker.boundary;

import com.allianz.carbondioxidetracker.entity.Reading;
import com.allianz.carbondioxidetracker.service.ReadingInputCommand;
import org.assertj.core.api.Assertions;
import org.junit.Before;
import org.junit.Test;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

public class ReadingInputCommandAdaptorImplTest {

    private ReadingInputCommandAdaptorImpl readingInputCommandAdaptorUnderTest;

    @Before
    public void setUp() {
        readingInputCommandAdaptorUnderTest = new ReadingInputCommandAdaptorImpl();
    }

    @Test
    public void testAdopt() {

        final ReadingInputCommand command = new ReadingInputCommand();

        final Date date = new GregorianCalendar(2019, Calendar.JANUARY, 1).getTime() ;
        command.setSensorId(1L);
        command.setDate(date);
        command.setCarbonValue(340F);

        final Reading result = readingInputCommandAdaptorUnderTest.adopt(command);
        Assertions.assertThat(result).isNotNull() ;
        Assertions.assertThat(result.getTime()).isEqualTo(date) ;
        Assertions.assertThat(result.getReadingValue()).isEqualTo(command.getCarbonValue()) ;
    }


    @Test
    public void testAdoptNullRequest() {

        final ReadingInputCommand request = null;

        final Reading result = readingInputCommandAdaptorUnderTest.adopt(request);
        Assertions.assertThat(result).isNull();
    }
}
