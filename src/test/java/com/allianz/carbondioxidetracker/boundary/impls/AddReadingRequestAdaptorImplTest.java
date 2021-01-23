package com.allianz.carbondioxidetracker.boundary.impls;

import com.allianz.carbondioxidetracker.common.DateToStringUtil;
import com.allianz.carbondioxidetracker.controller.AddCarbonReadingRequest;
import com.allianz.carbondioxidetracker.entity.Reading;
import com.allianz.carbondioxidetracker.service.CarbonDioxideValueAddCommand;
import org.assertj.core.api.Assertions;
import org.junit.Before;
import org.junit.Test;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

public class AddReadingRequestAdaptorImplTest {

    private AddReadingRequestAdaptorImpl addCarbonReadingRequestAdaptorImplUnderTest;

    @Before
    public void setUp() {
        addCarbonReadingRequestAdaptorImplUnderTest = new AddReadingRequestAdaptorImpl();
    }

    @Test
    public void testAdopt() {

        final AddCarbonReadingRequest request = new AddCarbonReadingRequest();

        final Date date = new GregorianCalendar(2019, Calendar.JANUARY, 1).getTime() ;
        request.setSensorId(1L);
        request.setDate(date);
        request.setCarbonValue(340F);

        final Reading result = addCarbonReadingRequestAdaptorImplUnderTest.adopt(request);

        Assertions.assertThat(result).isNotNull() ;
        Assertions.assertThat(result.getId()).isEqualTo(request.getSensorId()) ;
        Assertions.assertThat(result.getTime()).isEqualTo(date) ;
        Assertions.assertThat(result.getReadingValue()).isEqualTo(request.getCarbonValue()) ;
    }

    @Test
    public void testAdoptNullRequest() {

        final AddCarbonReadingRequest request = null;

        final Reading result = addCarbonReadingRequestAdaptorImplUnderTest.adopt(request);
        Assertions.assertThat(result).isNull();
    }
}
