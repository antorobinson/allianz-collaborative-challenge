package com.allianz.carbondioxidetracker.boundary;

import com.allianz.carbondioxidetracker.controller.ReadingInputRequest;
import com.allianz.carbondioxidetracker.service.ReadingInputCommand;
import org.assertj.core.api.Assertions;
import org.junit.Before;
import org.junit.Test;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

public class ReadingInputRequestAdaptorImplTest {

    private ReadingInputRequestAdaptorImpl readingInputRequestAdaptorImplUnderTest;

    @Before
    public void setUp() {
        readingInputRequestAdaptorImplUnderTest = new ReadingInputRequestAdaptorImpl();
    }

    @Test
    public void testAdopt() {

        final ReadingInputRequest request = new ReadingInputRequest();

        final Date date = new GregorianCalendar(2019, Calendar.JANUARY, 1).getTime() ;
        request.setSensorId(1L);
        request.setDate(date);
        request.setCarbonValue(340F);

        final ReadingInputCommand result = readingInputRequestAdaptorImplUnderTest.adopt(request);
        Assertions.assertThat(result).isNotNull() ;
        Assertions.assertThat(result.getDate()).isEqualTo(date) ;
        Assertions.assertThat(result.getCarbonValue()).isEqualTo(request.getCarbonValue()) ;
    }

    @Test
    public void testAdoptNullRequest() {

        final ReadingInputRequest request = null;
        final ReadingInputCommand result = readingInputRequestAdaptorImplUnderTest.adopt(request);

        Assertions.assertThat(result).isNull();
    }
}
