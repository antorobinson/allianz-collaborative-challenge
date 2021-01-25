package com.allianz.carbondioxidetracker.boundary;

import com.allianz.carbondioxidetracker.entity.Reading;
import com.allianz.carbondioxidetracker.service.ReadingGetResponse;
import org.assertj.core.api.Assertions;
import org.junit.Before;
import org.junit.Test;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

public class ReadingGetResponseAdaptorImplTest {

    private ReadingGetResponseAdaptorImpl readingGetResponseAdaptorImplUnderTest;

    @Before
    public void setUp() {
        readingGetResponseAdaptorImplUnderTest = new ReadingGetResponseAdaptorImpl();
    }

    @Test(expected = NullPointerException.class)
    public void testAdoptNullReading() {

        final Reading reading = null;
        readingGetResponseAdaptorImplUnderTest.adopt(reading);
    }

    @Test
    public void testAdopt() {

        final Date date = new GregorianCalendar(2019, Calendar.JANUARY, 1).getTime() ;
        final Reading reading = new Reading(250F, date);
        reading.setId(2L);

        final ReadingGetResponse result = readingGetResponseAdaptorImplUnderTest.adopt(reading);

        Assertions.assertThat(result).isNotNull() ;
        Assertions.assertThat(result.getId()).isEqualTo(2L) ;
        Assertions.assertThat(result.getTime()).isEqualTo(date) ;
        Assertions.assertThat(result.getReadingValue()).isEqualTo(250F) ;
    }
}
